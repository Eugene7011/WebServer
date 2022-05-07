package com.podzirei.webserver.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    Server server = new Server();

    @DisplayName("test getPort returns 3000 when created server by default")
    @Test
    void test_GetPort_Returns_3000_When_Created_Server_By_Default() {
        //prepare
        Server mockServer = mock(Server.class);

        //when
        when(mockServer.getPort()).thenReturn(3000);
        int port = server.getPort();

        //then
        assertEquals(mockServer.getPort(), port);
    }

    @DisplayName("test setPort throws IllegalArgumentException on port our of bounds")
    @Test
    void test_SetPort_Throws_IllegalArgumentException_On_Port_Our_Of_Bounds() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> server.setPort(-1));
    }
}
