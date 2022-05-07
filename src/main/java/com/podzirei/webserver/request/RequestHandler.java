package com.podzirei.webserver.request;

import com.podzirei.webserver.entity.Request;
import com.podzirei.webserver.entity.Response;
import com.podzirei.webserver.entity.ServerException;
import com.podzirei.webserver.entity.StatusCode;
import com.podzirei.webserver.resource.ResourceReader;
import com.podzirei.webserver.response.ResponseBuilder;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;

public class RequestHandler {
    private final BufferedReader reader;
    private final BufferedOutputStream outputStream;
    private final ResourceReader resourceReader;

    public RequestHandler(BufferedReader reader, BufferedOutputStream outputStream, ResourceReader resourceReader) {
        this.reader = reader;
        this.outputStream = outputStream;
        this.resourceReader = resourceReader;
    }

    public void handle() throws IOException {

        RequestParser requestParser = new RequestParser(reader);
        ResponseBuilder responseBuilder = new ResponseBuilder();
        Response response = new Response();

        try {
            Request request = requestParser.parseRequest();

            byte[] byteContentFromResourceFile = resourceReader.readResource(request.getUri());

            response.setStatusCode(StatusCode.OK);
            response.setContent(byteContentFromResourceFile);
            responseBuilder.responseWriter(outputStream, response);

        } catch (ServerException e){
            response.setStatusCode(e.getStatusCode());
        }
    }
}
