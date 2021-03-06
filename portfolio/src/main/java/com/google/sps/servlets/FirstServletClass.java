package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/** Handles requests sent to the /intro URL */
@WebServlet("/intro")
public class FirstServletClass extends HttpServlet {
    
    private String[] greetings = {"Hi!","Hola!","Salut!"};
    private List<String> greetingsList = Arrays.asList(greetings);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Random rand = new Random();
        int randomIndex = rand.nextInt(3);

        response.setContentType("text/html;");
        response.getWriter().println("Welcome to my portfolio page!");
        response.getWriter().println(greetingsList.get(randomIndex));

        // Convert the server stats to JSON
        String json = convertToJsonUsingGson(greetingsList);

        // Send the JSON as the response
        response.setContentType("application/json;");
        //response.getWriter().println(json);
    }


/**
   * Converts a ServerStats instance into a JSON string using the Gson library. Note: We first added
   * the Gson library dependency to pom.xml.
   */
  private String convertToJsonUsingGson(List<String> l) {
    Gson gson = new Gson();
    String json = gson.toJson(l);
    return json;
  }
}
