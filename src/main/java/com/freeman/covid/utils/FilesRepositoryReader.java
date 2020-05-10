package com.freeman.covid.utils;

import org.kohsuke.github.GHContent;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilesRepositoryReader {

    private static final String USER_NAME = "freemanjava";
    private static final String USER_PASSWORD = "Dragon75491_";
    private static final String REPOSITORY_NAME = "CSSEGISandData/COVID-19";
    private static final String DIRECTORY_PATH = "csse_covid_19_data/csse_covid_19_daily_reports";
    private final List<String> fileNames = new ArrayList<>();

    public FilesRepositoryReader() {
    }

    private GitHub getConnection() throws IOException {
        return new GitHubBuilder().withPassword(USER_NAME, USER_PASSWORD).build();
    }

    private GHRepository getRepository() throws IOException {
        GitHub gitHub = getConnection();
        return gitHub.getRepository(REPOSITORY_NAME);
    }

    public List<GHContent> getContentList(){
        List<GHContent> directoryContent = null;
        try {
            directoryContent = getRepository().getDirectoryContent(DIRECTORY_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return directoryContent;
    }

    public List<String> getFileNames(){
        List<GHContent> directoryContent = getContentList();
        String fileName1 = "03-21-2020.csv";
        String fileName2 = "03-22-2020.csv";
        fileNames.add(fileName1);
        fileNames.add(fileName2);

//        if (!directoryContent.isEmpty()) {
//            for (GHContent content : directoryContent) {
//                if (content.getName().contains(".csv")) {
//                    fileNames.add(content.getName());
//                }
//            }
//        }
        return fileNames;
    }

}
