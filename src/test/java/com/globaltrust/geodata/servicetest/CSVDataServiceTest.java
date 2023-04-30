package com.globaltrust.geodata.servicetest;
import com.globaltrust.geodata.service.CSVDataService;
/*import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CSVDataServiceTest {

    @Mock
    private ResourceLoader resourceLoader;

    @InjectMocks
    private CSVDataService csvDataService;

    public CSVDataServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFacilitiesCsv_WhenFileExists_ReturnsInputStream() throws IOException {
        // Arrange
        Resource file = mock(Resource.class);
        //InputStream expected = mock(InputStream.class);
        Resource expected = mock(Resource.class);
        when(resourceLoader.getResource("classpath:/static/CSVFiles/facilities.csv")).thenReturn(file);
        when(file.exists()).thenReturn(true);
        when(file).thenReturn(expected);

        // Act
        //Resource result = csvDataService.getFacilitiesCsv();

        // Assert
        //assertNotNull(result);
        //assertEquals(expected, result);
    }

    @Test
    public void testGetFacilitiesCsv_WhenFileDoesNotExist_ThrowsIOException() throws IOException {
        // Arrange
        Resource file = mock(Resource.class);
        when(resourceLoader.getResource("classpath:/static/CSVFiles/nonexistent.csv")).thenReturn(file);
        when(file.exists()).thenReturn(false);

        // Act & Assert
        assertThrows(IOException.class, () -> csvDataService.getFacilitiesCsv());
    }
}*/


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * This is service test class. Here used MockitoJUnitRunner for unit testing
 */
@RunWith(MockitoJUnitRunner.class)
public class CSVDataServiceTest {
    @Mock
    private ResourceLoader resourceLoader;

    @InjectMocks
    private CSVDataService csvDataService;

    /**
     * This method will test csvDataService.getFacilitiesCsv when the file is existed
     * @throws IOException
     */
    @Test
    public void testGetFacilitiesCsv_WhenFileExists_ReturnsResource() throws IOException {
        // Arrange
        Resource file = new ClassPathResource("static/CSVFiles/facilities.csv");
        when(resourceLoader.getResource("classpath:/static/CSVFiles/facilities.csv")).thenReturn(file);

        // Act
        Resource result = csvDataService.getFacilitiesCsv();

        // Assert
        assertNotNull(result);
        assertEquals(file, result);
    }

    /**
     * This method will test csvDataService.getFacilitiesCsv when the file is not exist
     * @throws IOException
     */
    @Test
    public void testGetFacilitiesCsv_WhenFileDoesNotExist_ThrowsIOException() throws IOException {
        // Arrange
        Resource file = new ClassPathResource("static/CSVFiles/nonexistent.csv");
        when(resourceLoader.getResource("classpath:/static/CSVFiles/nonexistent.csv")).thenReturn(file);

        // Act & Assert
        assertThrows(IOException.class, () -> csvDataService.getFacilitiesCsv());
    }

}
