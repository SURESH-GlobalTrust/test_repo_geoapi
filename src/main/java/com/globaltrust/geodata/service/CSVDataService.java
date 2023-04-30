package com.globaltrust.geodata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * This is CSVDataService service where will implement all logic to load CSV data from different sources like Resouce, External Service ie API, Open datacube etc
 */
@Service
public class CSVDataService {


    private final ResourceLoader resourceLoader; // This is a private variable type ResourceLoader which will be injected by caller
    private static final String CSV_FILE_PATH = "static/CSVFiles/facilities.csv"; //This is static variable for our test data file path

    /**
     * This is constructor where will assign the member variale resourceLoader
     * @param resourceLoader this value will use to load csv file from Resource folder
     */
    public CSVDataService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * This the service method reponsible to read facilities csv file and return the Resource
     * @return after loading the csv from specified path it will return Resource file
     * @throws IOException If face any problem to access the file it will throw IOException
     */
    public Resource getFacilitiesCsv() throws IOException {
        try {

            Resource file = resourceLoader.getResource("classpath:/static/CSVFiles/facilities.csv"); //Loading CSV file from specified path

            if (!file.exists()) {
                //throw new IllegalStateException("CSV file not found");
                throw new IOException("CSV file not found");
            }

            return file;
        } catch (Exception ex) {
            throw new IOException("CSV file not found");
        }

    }

}
