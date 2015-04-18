package com.cocome.action;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.cocome.DAO.Login;
import com.opensymphony.xwork2.ActionSupport;

public class EmailSendService{

   /*private String from;
   private String password;
   private String to;
   private String subject;
   private String body;*/

   static Properties properties = new Properties();
   static
   {
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.socketFactory.port", "465");
      properties.put("mail.smtp.socketFactory.class",
                     "javax.net.ssl.SSLSocketFactory");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.port", "465");
   }

   public boolean SendMail(Login login) 
   {
      boolean ret = true;
      try
      {
         Session session = Session.getDefaultInstance(properties,  
            new javax.mail.Authenticator() {
            protected PasswordAuthentication 
            getPasswordAuthentication() {
            return new 
            PasswordAuthentication("cocome2015nbsm@gmail.com", "12345cocome");
            }});

         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("cocome2015nbsm@gmail.com"));
         message.setRecipients(Message.RecipientType.TO, 
            InternetAddress.parse("satvikshetty05@gmail.com"));
         message.setSubject("Password reset");
         message.setText("Your new password is "+login.getPassword());
         Transport.send(message);
      }
      catch(Exception e)
      {
         ret = false;
         e.printStackTrace();
      }
      return ret;
   }

  /* public String getFrom() {
      return from;
   }

   public void setFrom(String from) {
      this.from = from;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getTo() {
      return to;
   }

   public void setTo(String to) {
      this.to = to;
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getBody() {
      return body;
   }

   public void setBody(String body) {
      this.body = body;
   }*/

   public static Properties getProperties() {
      return properties;
   }

   public static void setProperties(Properties properties) {
	   EmailSendService.properties = properties;
   }
}
