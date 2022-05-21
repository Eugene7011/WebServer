package com.podzirei.webserver.resource;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceReaderITest {
    private static final String ACTUAL_RESOURCE_DATA = "After the Second World War, jeans became popular all over the world. " +
            "Today, blue jeans are made throughout the world – most of them in Asia. " +
            "Very few jeans are now made in the USA, because of the cost: but it is still possible to buy blue jeans that are made in San Francisco. " +
            "if you have a lot of money to spend.";
    private final ResourceReader resourceReader = new ResourceReader("src/main/resources/webapp");

    @BeforeEach
    void init() throws Exception {
        File path = new File("src/main/resources/webapp/Test");
        path.mkdir();

        File path1 = new File("src/main/resources/webapp/Test/file1.txt");
        path1.createNewFile();
        OutputStream outputStream = new FileOutputStream(path1);

        byte[] contentArray = ACTUAL_RESOURCE_DATA.getBytes();
        outputStream.write(contentArray);
        outputStream.close();
    }

    @AfterEach
    void delete() {
        File path1 = new File("src/main/resources/webapp/Test/file1.txt");
        path1.delete();

        File path = new File("src/main/resources/webapp/Test");
        path.delete();
    }

    @DisplayName("test readResource returns correct data read from resource file")
    @Test
    void test_ReadResource_Return_Correct_Data_Read_From_Resource_File() throws IOException {
        String uri = "/Test/file1.txt";
        String resourceData = new String(resourceReader.readResource(uri));

        assertEquals(ACTUAL_RESOURCE_DATA, resourceData);
    }

    @DisplayName("test readResource throws FileNotFoundException on incorrect filepath")
    @Test
    void test_ReadResource_Throws_FileNotFoundException_On_Incorrect_Filepath() {
        String uri = "/Test/file232.txt";

        Assertions.assertThrows(FileNotFoundException.class,
                () -> resourceReader.readResource(uri));
    }

    @DisplayName("test readResource throws RuntimeException on blank resource file data")
    @Test
    void test_ReadResource_Throws_RuntimeException_On_Blank_Resource_File_Data() throws IOException {
        File path1 = new File("src/main/resources/webapp/file1.txt");
        path1.createNewFile();
        OutputStream outputStream = new FileOutputStream(path1);

        byte[] contentArray = (" ").getBytes();
        outputStream.write(contentArray);
        outputStream.close();

        String uri = "/file1.txt";

        Assertions.assertThrows(RuntimeException.class,
                () -> resourceReader.readResource(uri));

        path1.delete();
    }
}
