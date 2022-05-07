package com.podzirei.webserver.response;

import com.podzirei.webserver.entity.Request;
import com.podzirei.webserver.request.RequestHandler;
import com.podzirei.webserver.resource.ResourceReader;
import com.podzirei.webserver.server.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ResponseHandlerITest {

//    BufferedReader socketReader;
//    BufferedReader mockedSocketReader;
//    ResourceReader mockedCResourceReader;
//    RequestHandler requestHandler;
//    Request mockedRequest;
//    MockedStatic<RequestReader> requestReaderMockedStatic;
//
//    @BeforeEach
//    void setUp() {
//        mockedSocketReader = mock(BufferedReader.class);
//        mockedContentReader = mock(ContentReader.class);
//        mockedRequest = mock(Request.class);
//    }
//
//    @AfterEach
//    void close() {
//        if (requestReaderMockedStatic != null) {
//            requestReaderMockedStatic.close();
//        }
//    }

}
