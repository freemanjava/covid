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

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
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

            CountryRegion countryRegion = new CountryRegion(countryRegionCSV);
            ProvinceState provinceState = new ProvinceState(provinceStateCSV);
            GeoPoint geoPoint = new GeoPoint(latitudeCSV, longitudeCSV);
            DetectionPlace detectionPlace = new DetectionPlace(countryRegion, provinceState, geoPoint);
            CoronaState coronaState = new CoronaState(lastUpdateCSV, Integer.parseInt(confirmedQuantityCSV),
                    Integer.parseInt(deathsQuantityCSV), Integer.parseInt(recoveredQuantityCSV),detectionPlace);
            coronaStateRepo.insert(coronaState);
//            CountryRegion country = countryRegionRepo.findCountryRegionByName(countryRegion);
//            if (country == null){
////            if (countryRegionRepo.findByNameExists(countryRegion)){
//                country = new CountryRegion(countryRegion);
//            }
//            else {
//                country = countryRegionRepo.findCountryRegionByName(countryRegion);
//            }
//            ProvinceState province = provinceStateRepo.
//            ProvinceState province = new ProvinceState(provinceState);
//            DetectionPlace detectionPlace = new DetectionPlace();
//            CoronaState coronaState = CoronaState.builder()
//                    .detectionPlace(detectionPlace)
//                    .lastUpdate(lastUpdate)
//                    .confirmedQuantity(Integer.parseInt(confirmedQuantity))
//                    .deathsQuantity(Integer.parseInt(deathsQuantity))
//                    .recoveredQuantity(Integer.parseInt(recoveredQuantity))
//                    .build();
//            coronaStateRepo.save(coronaState);
        }
//        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
//        strategy.setType(CoronaState.class);
//        String[] memberFieldsToBindTo = {"name", "email", "phoneNo", "country"};
//        strategy.setColumnMapping(memberFieldsToBindTo);
//        List forObject = restTemplate.getForObject("https://api.github.com/repos/CSSEGISandData/repo/releases", List.class);
//        List<LinkedHashMap<String,String>> repos = restTemplate.getForObject("https://api.github.com/repos/CSSEGISandData/repo/releases", List.class);
//        List<LinkedHashMap<String,String>> repos = restTemplate.getForObject("https://api.github.com/users/CSSEGISandData/repos", List.class);

//        for(LinkedHashMap<String,String>  repo : repos)
//        {
//            System.out.println(repo.get("name"));
//        }
//        GitHubClient client = this.gitHubClient.setCredentials("freemanjava", "Dragon75491_");
//        RepositoryService service = new RepositoryService();
//
//        try {
//            service.getRepository("CSSEGISandData","COVID-19");
////            gitHubClient.getRepository("CSSEGISandData/COVID-19/csse_covid_19_daily_reports");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
