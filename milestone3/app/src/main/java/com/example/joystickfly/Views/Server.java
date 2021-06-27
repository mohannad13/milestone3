package com.example.joystickfly.Views;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Server {
   private Socket clientSocket;
    PrintWriter out;


   public void connect(String ip,int port) {

       try {
           clientSocket = new Socket(ip,port);
       } catch (IOException e) {
           e.printStackTrace();
       }
       try {
           out = new PrintWriter(clientSocket.getOutputStream(),true);
       } catch (IOException e) {
           e.printStackTrace();
       }

   }
   public void sendCommand(String command, double v){
       out.print(command + v + "\r\n");
       out.flush();
   }
}


