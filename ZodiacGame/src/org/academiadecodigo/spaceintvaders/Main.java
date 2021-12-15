package org.academiadecodigo.spaceintvaders;

import org.academiadecodigo.bootcamp.Prompt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        //SERVER CONNECTION WITH PROMPT AND DATAOUTPUTSTREAM
        ServerSocket serverSocket = new ServerSocket(2021);

        System.out.println("connect server");
        Socket clientSocket = serverSocket.accept();
        System.out.println("accept");

        Prompt prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());


        //INSTANTIATE QUIZ AND ZODIAC CLASS
        Quiz quiz = new Quiz();
        Zodiac zodiac = new Zodiac();

        //SET PROMPTS AND DATAOUTPUTSTREAMS
        zodiac.setPrompt(prompt);
        quiz.setPrompt(prompt);
        zodiac.setOut(out);
        quiz.setOut(out);

        //RUN METHODS
        zodiac.zodiac();
        quiz.quiz();

    }
}




