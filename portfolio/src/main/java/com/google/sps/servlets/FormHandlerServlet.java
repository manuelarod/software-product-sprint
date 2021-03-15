package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String textValue = request.getParameter("text-input");
    String messageValue = request.getParameter("message-input");
    long timestamp = System.currentTimeMillis();

    String text1 = "You submitted the email address: " + textValue;
    String text2 = "You sumbitted the message: " + messageValue;

    writeToResponse(response,text1);
    writeToResponse(response,text2);
    
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("ContactInfo");
    FullEntity contactEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("emailAddress", textValue)
            .set("message", messageValue)
            .set("timestamp", timestamp)
            .build();
    datastore.put(contactEntity);

    response.sendRedirect("/index.html");
  }

  private void writeToResponse(HttpServletResponse response, String text) throws IOException {
    System.out.println(text);
    response.getWriter().println(text);
  }
}