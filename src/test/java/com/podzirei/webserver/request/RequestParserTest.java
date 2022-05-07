package com.podzirei.webserver.request;

import com.podzirei.webserver.entity.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.podzirei.webserver.request.RequestParser.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RequestParserTest {

    private Request request;

    @BeforeEach
    void setUp() {
        request = new Request();
    }

    @DisplayName("test injectHttpMethodAndUri injects GET HTTP method into request object")
    @Test
    void testInjectMethodIntoRequestObject() throws IOException {
        injectUriAndMethod(new BufferedReader(
                new CharArrayReader(("GET /index.html HTTP/1.1").toCharArray())), request);
        String actualHttpMethod = request.getHttpMethod().getDescription();
        assertEquals("GET", actualHttpMethod);
    }

    @DisplayName("test injectHttpMethodAndUri injects uri into request object")
    @Test
    void testInjectUriIntoRequestObject() throws IOException {
        injectUriAndMethod(new BufferedReader(
                new CharArrayReader(("GET /index.html HTTP/1.1").toCharArray())), request);
        String actualUri = request.getUri();
        assertEquals("/index.html", actualUri);
    }

    @DisplayName("test injectHttpMethodAndUri throws RuntimeException on null start line")
    @Test
    void testInjectUriAndMethodThrowsRuntimeExceptionOnNullStartLine() throws IOException {
        BufferedReader mockedBufferedReader = mock(BufferedReader.class);
        when(mockedBufferedReader.readLine()).thenReturn(null);

        Assertions.assertThrows(RuntimeException.class,
                () -> injectUriAndMethod(mockedBufferedReader, request));
    }

    @DisplayName("test injectHttpMethodAndUri throws RuntimeException on blank start line")
    @Test
    void testInjectUriAndMethodThrowsRuntimeExceptionOnBlankStartLine(){
        Assertions.assertThrows(RuntimeException.class,
                () -> injectUriAndMethod(new BufferedReader(
                        new CharArrayReader((" ").toCharArray())), request));
    }
}
