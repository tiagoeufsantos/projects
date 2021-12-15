package org.academiadecodigo.spaceintvaders;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;


import java.io.DataOutputStream;
import java.io.IOException;

public class Quiz implements Signs{

    //PROPERTIES
    private static int incorrect;
    private static int correct;

    private Prompt prompt;
    private DataOutputStream out;


    //SETTERS OF PROMPT AND DATAOUTPUTSTREAM BECAUSE IT WILL BE INSTANTIATED IN MAIN CLASS
    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }
    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    //METHOD QUIZ WITH ALL 12 QUESTIONS
    public void quiz() throws IOException {

        //QUIZ START | QUESTION 1
        String[] options = {"Begin", "Nevermind"};

        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("The game will have a few questions about zodiac signs.\n" + "Are you ready?"); //change question
        int answerIndex = prompt.getUserInput(scanner);
        if (answerIndex == 1) {
            out.writeBytes("Great, felling pumped? Let's test your knowledge of the \"ancient science\" of astrology.\n");
        } else if (answerIndex == 2) {
            out.writeBytes("You suck! But you're one of us. Let's PLAY!!!!\n");
        }

        //QUESTION 2 \ CAPRICORN
        String[] options2 = {"Are very good leaders", "Have a magnetic personality", "Are natural peacemakers"};

        MenuInputScanner scanner2 = new MenuInputScanner(options2);
        scanner2.setMessage("Select the feature of the Zodiac Sign " + signs[0] + "!"); //change question
        int answerIndex2 = prompt.getUserInput(scanner2);
        if (answerIndex2 == 1) {
            correct++;
        } else if (answerIndex2 == 2) {
            incorrect++;
        } else if (answerIndex2 == 3) {
            incorrect++;
        }

        //QUESTION 3 \ AQUARIUS
        String[] options3 = {"They are intelligent", "They are really kind", "Very optimistic"};

        MenuInputScanner scanner3 = new MenuInputScanner(options3);
        scanner3.setMessage("Select the feature of the Zodiac Sign " + signs[1] + "!"); //change question
        int answerIndex3 = prompt.getUserInput(scanner3);
        if (answerIndex3 == 1) {
            incorrect++;
        } else if (answerIndex3 == 2) {
            incorrect++;
        } else if (answerIndex3 == 3) {
            correct++;
        }

        //QUESTION 4 \ PISCES
        String[] options4 = {"They are creative", "They are very unique", "Very pratical people"};

        MenuInputScanner scanner4 = new MenuInputScanner(options4);
        scanner4.setMessage("Select the feature of the Zodiac Sign " + signs[2] + "!"); //change question
        int answerIndex4 = prompt.getUserInput(scanner4);
        if (answerIndex4 == 1) {
            correct++;
        } else if (answerIndex4 == 2) {
            incorrect++;
        } else if (answerIndex4 == 3) {
            incorrect++;
        }

        //QUESTION 5 \ ARIES
        String[] options5 = {"Very ambitious", "Very logical", "Enthusiastic people"};

        MenuInputScanner scanner5 = new MenuInputScanner(options5);
        scanner5.setMessage("Select the feature of the Zodiac Sign " + signs[3] + "!"); //change question
        int answerIndex5 = prompt.getUserInput(scanner5);
        if (answerIndex5 == 1) {
            correct++;
        } else if (answerIndex5 == 2) {
            incorrect++;
        } else if (answerIndex5 == 3) {
            incorrect++;
        }

        //QUESTION 6 \ TAURUS
        String[] options6 = {"Very loyal", "Desire to share the wealth", "Determined persons"};

        MenuInputScanner scanner6 = new MenuInputScanner(options6);
        scanner6.setMessage("Select the feature of the Zodiac Sign " + signs[4] + "!"); //change question
        int answerIndex6 = prompt.getUserInput(scanner6);
        if (answerIndex6 == 1) {
            incorrect++;
        } else if (answerIndex6 == 2) {
            incorrect++;
        } else if (answerIndex6 == 3) {
            correct++;
        }


        //QUESTION 7 \ GEMINI
        String[] options7 = {"Really protective", "Easy-going & Adjustable people", "Hard working people"};

        MenuInputScanner scanner7 = new MenuInputScanner(options7);
        scanner7.setMessage("Select the feature of the Zodiac Sign " + signs[5] + "!"); //change question
        int answerIndex7 = prompt.getUserInput(scanner7);
        if (answerIndex7 == 1) {
            incorrect++;
        } else if (answerIndex7 == 2) {
            correct++;
        } else if (answerIndex7 == 3) {
            incorrect++;
        }

        //QUESTION 8 \ CANCER
        String[] options8 = {"Very intuitive", "Really brave", "Very optimistic"};

        MenuInputScanner scanner8 = new MenuInputScanner(options8);
        scanner8.setMessage("Select the feature of the Zodiac Sign " + signs[6] + "!"); //change question
        int answerIndex8 = prompt.getUserInput(scanner8);
        if (answerIndex8 == 1) {
            correct++;
        } else if (answerIndex8 == 2) {
            incorrect++;
        } else if (answerIndex8 == 3) {
            incorrect++;
        }

        //QUESTION 9 \ LEO
        String[] options9 = {"Really protective", "Innate creative", "Really brave"};

        MenuInputScanner scanner9 = new MenuInputScanner(options9);
        scanner9.setMessage("Select the feature of the Zodiac Sign " + signs[7] + "!"); //change question
        int answerIndex9 = prompt.getUserInput(scanner9);
        if (answerIndex9 == 1) {
            incorrect++;
        } else if (answerIndex9 == 2) {
            correct++;
        } else if (answerIndex9 == 3) {
            incorrect++;
        }

        //QUESTION 10 \ VIRGO
        String[] options10 = {"Empathetic people", "Freedom lovers", "Kindness people"};

        MenuInputScanner scanner10 = new MenuInputScanner(options10);
        scanner10.setMessage("Select the feature of the Zodiac Sign " + signs[8] + "!"); //change question
        int answerIndex10 = prompt.getUserInput(scanner10);
        if (answerIndex10 == 1) {
            incorrect++;
        } else if (answerIndex10 == 2) {
            incorrect++;
        } else if (answerIndex10 == 3) {
            correct++;
        }

        //QUESTION 11 \ LIBRA
        String[] options11 = {"Really honest", "Very clever people", "Strong sense of justice"};

        MenuInputScanner scanner11 = new MenuInputScanner(options11);
        scanner11.setMessage("Select the feature of the Zodiac Sign " + signs[9] + "!"); //change question
        int answerIndex11 = prompt.getUserInput(scanner11);
        if (answerIndex11 == 1) {
            incorrect++;
        } else if (answerIndex11 == 2) {
            incorrect++;
        } else if (answerIndex11 == 3) {
            correct++;
        }

        //QUESTION 12 \ Scorpios
        String[] options12 = {"Very creative and productive", "Very loyal", "Honestly strong"};

        MenuInputScanner scanner12 = new MenuInputScanner(options12);
        scanner12.setMessage("Select the feature of the Zodiac Sign " + signs[10] + "!"); //change question
        int answerIndex12 = prompt.getUserInput(scanner12);
        if (answerIndex12 == 1) {
            incorrect++;
        } else if (answerIndex12 == 2) {
            correct++;
        } else if (answerIndex12 == 3) {
            incorrect++;
        }


        //QUESTION 12 \ Scorpios
        String[] options13 = {"Fair-minded people", "Extroverted and social people", "Very disciplined"};

        MenuInputScanner scanner13 = new MenuInputScanner(options13);
        scanner13.setMessage("Select the feature of the Zodiac Sign " + signs[11] + "!"); //change question
        int answerIndex13 = prompt.getUserInput(scanner13);
        if (answerIndex13 == 1) {
            correct++;
        } else if (answerIndex13 == 2) {
            incorrect++;
        } else if (answerIndex13 == 3) {
            incorrect++;
        }

        out.writeBytes("Correct answers: " + correct + "\n");
        out.writeBytes("Incorrect answers: " + incorrect + "\n");
        if (correct > 6) {
            out.writeBytes("hehehehehe dumb!\n");
        } else if (correct <= 6) {
            out.writeBytes("After all this we found that you still suck!\n");
        }
        out.writeBytes("Thanks for all Losers!\n");
    }



}
