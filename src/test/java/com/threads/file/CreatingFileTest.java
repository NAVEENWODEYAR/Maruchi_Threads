package com.threads.file;
/**
 * @author NaveenWodeyar
 * @date 08-Oct-2024
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CreatingFileTest {
    
    private CreatingFile creatingFile;
    private static final String TEST_FILE_NAME = "ThreadTest.txt";

    @BeforeEach
    void setUp() {
        creatingFile = new CreatingFile(TEST_FILE_NAME);
    }

    @AfterEach
    void tearDown() {
        File file = new File(TEST_FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testCreateFile() {
        creatingFile.createFile();
        File file = new File(TEST_FILE_NAME);
        assertTrue(file.exists(), "File should be created.");
    }

    @Test
    void testWriteToFile() throws IOException {
        creatingFile.createFile();
        creatingFile.writeToFile();
        
        String content = creatingFile.readFile();
        assertTrue(content.contains("Welcome to file operations in Java,"), "File should contain the written text.");
    }

    @Test
    void testReadFile() throws IOException {
        creatingFile.createFile();
        creatingFile.writeToFile();
        
        String content = creatingFile.readFile();
        assertFalse(content.isEmpty(), "File should not be empty after writing.");
    }
}

