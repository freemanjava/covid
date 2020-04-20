package com.freeman.covid.services;

import com.freeman.covid.configurations.MongoConfig;

import com.freeman.covid.models.dto.CoronaStateDTO;
import com.freeman.covid.models.entities.CoronaState;
import com.freeman.covid.repositories.CoronaStateRepo;
import com.opencsv.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class DataLoader {

    @Autowired
    private MongoConfig mongoConfig;

    @Autowired
    private CoronaStateRepo coronaStateRepo;

    private static final String PATH = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/";

    public DataLoader() {
    }


    @PostConstruct
    @Scheduled(cron = "* 1 * * * *")
    public void fetchingData() throws IOException, CsvValidationException {

        List<String> fileNames = new ArrayList<>();
        String fileName1 = "03-21-2020.csv";
        fileNames.add(fileName1);
        String fileName2 = "03-22-2020.csv";
        fileNames.add(fileName2);
        GitHub gitHub = new GitHubBuilder().withPassword("freemanjava", "Dragon75491_").build();
        GHRepository ghRepository = gitHub.getRepository("CSSEGISandData/COVID-19");
        List<GHContent> directoryContent = ghRepository.getDirectoryContent("csse_covid_19_data/csse_covid_19_daily_reports");
//        if (!directoryContent.isEmpty()) {
//            for (GHContent content : directoryContent) {
//                if (content.getName().contains(".csv")) {
//                    fileNames.add(content.getName());
//                }
//            }
//        }
        RestTemplate restTemplate = new RestTemplate();
        String url;
        for (String fileName : fileNames) {
            log.info("Started to handle the file: " + fileName);
            url = PATH + fileName;
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            String body = response.getBody();

//            StringReader reader = new StringReader(Objects.requireNonNull(newBody));
            StringReader reader = new StringReader(Objects.requireNonNull(body));

            CsvToBean<CoronaStateDTO> bean = new CsvToBeanBuilder<CoronaStateDTO>(reader).withType(CoronaStateDTO.class).build();

//            CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
//            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
//            List<String[]> records = csvReader.readAll();
            List<String[]> records = new LinkedList<>();
            List<String[]> headers = new LinkedList<>();
            CSVReader headerReader = new CSVReader(reader);
            headers.add(headerReader.readNext());

//            CSVReaderHeaderAware headerReader = new CSVReaderHeaderAware(reader);
//            Map<String, String> readMap = headerReader.readMap();
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            String [] line;
            while ((line = csvReader.readNext()) != null){
//                if (StringUtils.substringBetween(line, "\"", "\""))
                records.add(line);
            }

            List<String> stringsNames = new LinkedList<>();
//            Map<String, String> modelMapForDB = new LinkedHashMap<>();
//            stringsNames.add("provinceStateCSV");
//            stringsNames.add("countryRegionCSV");
//            stringsNames.add("lastUpdateCSV");
//            stringsNames.add("confirmedQuantityCSV");
//            stringsNames.add("deathsQuantityCSV");
//            stringsNames.add("recoveredQuantityCSV");
//            stringsNames.add("latitudeCSV");
//            stringsNames.add("longitudeCSV");
//            for (String[] strings : records) {
//                List<String> stringsValues = new LinkedList<>(Arrays.asList(strings));
//                if (stringsNames.size() == stringsValues.size()) {
//                    for (int i = 0; i < stringsNames.size(); i++) {
//                        modelMapForDB.put(stringsNames.get(i), stringsValues.get(i));
//                    }
//                } else {
//                    for (int i = 0; i < stringsValues.size(); i++) {
//                        modelMapForDB.put(stringsNames.get(i), stringsValues.get(i));
//                    }
//                }


//                StatisticBySick statistic = new StatisticBySick(
//                        Integer.parseInt(!modelMapForDB.get("confirmedQuantityCSV").isEmpty() ?
//                                modelMapForDB.get("confirmedQuantityCSV") : "0"),
//                        Integer.parseInt(!modelMapForDB.get("deathsQuantityCSV").isEmpty() ?
//                                modelMapForDB.get("deathsQuantityCSV") : "0"),
//                        Integer.parseInt(!modelMapForDB.get("recoveredQuantityCSV").isEmpty() ?
//                                modelMapForDB.get("recoveredQuantityCSV") : "0"));
//                GeoPoint geoPoint = new GeoPoint(modelMapForDB.get("latitudeCSV"), modelMapForDB.get("longitudeCSV"));
//                List<ProvinceState> provinceStateList = new ArrayList<>();
//                ProvinceState provinceState = new ProvinceState(
//                        modelMapForDB.get("provinceStateCSV"), modelMapForDB.get("lastUpdateCSV"), geoPoint, statistic);
//                provinceStateList.add(provinceState);
//                CountryRegion countryRegion = new CountryRegion(modelMapForDB.get("countryRegionCSV"), provinceStateList);

                LocalDateTime time = LocalDateTime.now();
//            LocaleDa updateDate = new LocaleData();//"2020-03-15T18:20:18"
//            long time = updateDate.getTime();
                StringBuilder combinedKey = new StringBuilder();
//                CoronaState coronaState = new CoronaState(String.valueOf(time), combinedKey.toString(), countryRegion);
//                if (coronaStateRepo.existsCoronaStateByCountryRegion_Name(countryRegion.getCountryRegion())) {
//                    CoronaState foundCoronaState = coronaStateRepo.findCoronaStateByCountryRegion_Name(countryRegion.getCountryRegion());
//                    List<ProvinceState> foundProvinceStateList = foundCoronaState.getCountryRegion().getProvinceState();
//                    foundProvinceStateList.add(provinceState);
//                    foundCoronaState.getCountryRegion().setProvinceState(foundProvinceStateList);
//                    mongoConfig.mongoTemplate().save(foundCoronaState, countryRegion.getCountryRegion());
//                    //                coronaStateRepo.save(foundCoronaState);
//                } else {
//                    mongoConfig.mongoTemplate().insert(coronaState, countryRegion.getCountryRegion());
////                coronaStateRepo.insert(coronaState);
//                }
//            }
        }
    }
}
