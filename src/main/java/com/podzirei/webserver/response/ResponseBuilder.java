package com.podzirei.webserver.response;

import com.podzirei.webserver.entity.Response;
import com.podzirei.webserver.entity.StatusCode;

import java.io.BufferedOutputStream;
import java.io.IOException;

import static com.podzirei.webserver.response.ResponseWriter.writeErrorResponse;
import static com.podzirei.webserver.response.ResponseWriter.writeResponse;

public class ResponseBuilder {

    public void responseWriter(BufferedOutputStream outputStream, Response response) throws IOException {
        try (outputStream) {
            StatusCode status = response.getStatusCode();
            if (status == StatusCode.OK) {
                writeResponse(outputStream, response);
            } else {
                writeErrorResponse(outputStream, response);
            }
        }
    }
}
