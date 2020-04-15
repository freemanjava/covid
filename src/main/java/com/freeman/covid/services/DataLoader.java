package com.freeman.covid.services;

import com.freeman.covid.models.*;

import com.freeman.covid.repositories.CoronaStateRepo;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.util.resources.LocaleData;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class DataLoader {

    @Autowired
    private CoronaStateRepo coronaStateRepo;

    private static final String URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/03-16-2020.csv";

    public DataLoader(){
    }


    @PostConstruct
    @Scheduled(cron = "* 1 * * * *")
    public void fetchingData() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        String body = response.getBody();
        String result = null;
        String substring = StringUtils.substringBetween(body, "\"", "\"");
        if (substring !=null && substring.contains(",")){
            result = substring.replace(",", "");
        }
        String newBody = body.replace(substring, result);
        StringReader reader = new StringReader(Objects.requireNonNull(newBody));
        CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
        List<String[]> records = csvReader.readAll();
        for (String[] strings : records){
            String provinceStateCSV = strings[0];
            String countryRegionCSV = strings[1];
            String lastUpdateCSV = strings[2];
            String confirmedQuantityCSV = strings[3];
            String deathsQuantityCSV = strings[4];
            String recoveredQuantityCSV = strings[5];
            String latitudeCSV = strings[6];
            String longitudeCSV = strings[7];

            StatisticBySick statistic = new StatisticBySick(Integer.parseInt(confirmedQuantityCSV),
                    Integer.parseInt(deathsQuantityCSV), Integer.parseInt(recoveredQuantityCSV));
            GeoPoint geoPoint = new GeoPoint(latitudeCSV, longitudeCSV);
            List<ProvinceState> provinceStateList = new ArrayList<>();
            ProvinceState provinceState = new ProvinceState(provinceStateCSV, lastUpdateCSV, geoPoint, statistic);
            provinceStateList.add(provinceState);
            CountryRegion countryRegion = new CountryRegion(countryRegionCSV, provinceStateList);

            LocalDateTime time = LocalDateTime.now();
//            LocaleDa updateDate = new LocaleData();//"2020-03-15T18:20:18"
//            long time = updateDate.getTime();
            CoronaState coronaState = new CoronaState(String.valueOf(time), countryRegion);
            if (coronaStateRepo.existsCoronaStateByCountryRegion_Name(countryRegion.getName())){
                CoronaState foundCoronaState = coronaStateRepo.findCoronaStateByCountryRegion_Name(countryRegion.getName());
                List<ProvinceState> foundProvinceStateList = foundCoronaState.getCountryRegion().getProvinceState();
                foundProvinceStateList.add(provinceState);
                foundCoronaState.getCountryRegion().setProvinceState(foundProvinceStateList);
                coronaStateRepo.save(foundCoronaState);
            } else {
                coronaStateRepo.insert(coronaState);
            }
        }
    }
}
