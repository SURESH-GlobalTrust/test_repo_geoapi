package com.globaltrust.geodata.controllers;

/*import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;*/
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import com.globaltrust.geodata.service.CSVDataService;

/**
 * This is the controller class or API entry point for CSV related API. The default path for each api is api/csv and the specific method name
 */
@RestController

@CrossOrigin(origins = "*")
@RequestMapping("/api/csv")
public class CSVDataController {

    /**
     * This is a private variable type
     */
    @Autowired
    ResourceLoader resourceLoader;


    /**
     *
     */
    private CSVDataService csvDataService;

    /**
     * This is the default constructor
     */
    public CSVDataController() {
        this.csvDataService = new CSVDataService(resourceLoader);
    }

    /**
     * This is a constructor with csvdataservice parameter where it will initialize the service paraerter
     * @param csvDataService injecting the service parameter
     */
    public CSVDataController(CSVDataService csvDataService) {
        this.csvDataService = csvDataService; // Initialize the csvDataServie private variable with parameter value
    }

    /**
     * This is the method or api end point named getFacilitiesCsv
     * we call csvDataService.getFacilitiesCsv() to get CSV data from csv file stored in resource folder
     * @return It will prepare ResponseEntity object using the csv data with file name facilities.csv
     * and content type will be application/octet-stream and return the http.ResponseEntity
     * @throws IOException if the csv not available or face any problem to access the file it will throw IOException
     */

    @GetMapping("/getfacilities")
    @ApiOperation(value = "Get facilities in CSV format", produces = "application/octet-stream")
    @Operation(summary = "This is a test api which will return a CSV file with geo information",
            description = "We have a static CSV file which will return in this API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "A csv file will be downloaded with name facilities.csv",
                    content = {@Content(mediaType = "application/octet-stream")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    })


    public ResponseEntity<?> getFacilitiesCsv() throws IOException {
        this.csvDataService = new CSVDataService(resourceLoader);
        Resource file = csvDataService.getFacilitiesCsv();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=facilities.csv")
                .body(file.getInputStream().readAllBytes());
    }

}