package org.academiadecodigo.spaceintvaders;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.DataOutputStream;
import java.io.IOException;

public class Zodiac implements Signs{

    //PROPERTIES
    private int numDays;

    private Prompt prompt;
    private DataOutputStream out;


    //SETTERS OF PROMPT AND DATAOUTPUTSTREAM BECAUSE IT WILL BE INSTANTIATED IN MAIN CLASS
    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }
    public void setOut(DataOutputStream out) {
        this.out = out;
    }


    //METHOD WITH THE QUESTIONS: NAME, DAY, MONTH AND THE RESULT
    public void zodiac() throws IOException {

        //QUESTION NAME
        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("Hello Player! Welcome to Zodiac Quiz!" + "\n" + "What is your name?");
        String name = prompt.getUserInput(question1);

        //QUESTION MONTH OF BIRTH
        IntegerInputScanner question2 = new IntegerRangeInputScanner(1, 12);
        question2.setMessage("The month you were born?");

        int month = prompt.getUserInput(question2);
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                numDays = 28;
                break;
        }

        //QUESTION DAY OF BIRTH
        IntegerInputScanner question3 = new IntegerRangeInputScanner(1, numDays);
        question3.setMessage("The day you were born?");
        int day = prompt.getUserInput(question3);


        out.writeBytes("\n" + "Welcome " + name + "! \n");

        //RESULT OF DATA PICKED
        if (month == 12 && (day >= 22 && day <= numDays) || month == 1 && (day <= 19 && day >= 1)) { //Capricorn
            out.writeBytes("Nice! You are a " + signs[0] + "! " + "You are a tough nut to crack. Ironically, you try to be funny with your super dry sense of humor.\n" +
                    "Try to loosen up a little and stop taking yourself too seriously. Learn to take risks.\n" +
                    "Your seriousness makes you look spineless. Given your unique personality, your ideal place of work is a monastery.");
        } else if (month == 1 && (day >= 20 && day <= numDays) || month == 2 && (day <= 18 && day >= 1)) { //Aquarius
            out.writeBytes("Nice! You are a " + signs[1] + "! " + "It’s like you are allergic to fun. In fact, you HATE laughing.\n" +
                    "But whenever someone needs someone to feel miserable, guilty, or angry, you always come through. You simply don’t give a s**t about anyone.\n" +
                    "An Aquarius probably invented the condescending eye-roll.\n" +
                    "You are also a great liar and amazingly self-sufficient. But you make lots of stupid mistakes. Fortunately, just like your mistakes, your accomplishments can be mind-blowing.");
        } else if (month == 2 && (day >= 19 && day <= numDays) || month == 3 && (day <= 20 && day >= 1)) { //pisces
            out.writeBytes("Nice! You are a " + signs[2] + "!\n" + "According to your Zodiac sign, you're an asshole! Furthermore you are funny, but not on purpose.\n" +
                    "For starters, your friends, when you were young, were all imaginary, and you have still held on to a few of them even as an adult.\n" +
                    "If anyone needs a reality check, it’s you. You don’t drink to forget your problems, but as a way to zip line to your ridiculous make-believe world.");
        } else if (month == 3 && (day >= 21 && day <= numDays) || month == 4 && (day <= 19 && day >= 1)) { //aries
            out.writeBytes("Nice! You are a " + signs[3] + "!\n" + "Apparently, there is a good reason your sign is the ram. Your eyebrows are ram-like. The fact that you have smug expressions doesn’t help either.\n" +
                    "You will reach for your gun just to explain your philosophical points.\n" +
                    "Aries folks think dumb mistakes are funny. A kid tripping will make you fall down in laughter, and a 35-year-old sucking their thumb will keep you laughing for days.\n" +
                    "Ironically, you can’t take it when someone points out you have done the wrong thing.\n" + "You are also famous for making life-changing decisions at a young age, often with hilarious and saddening results.");
        } else if (month == 4 && (day >= 20 && day <= numDays) || month == 5 && (day <= 20 && day >= 1)) { //taurus
            out.writeBytes("Nice! You are a " + signs[4] + "! " + "You know too many dirty jokes, it’s almost embarrassing. But you make up for it by being materialistic and lazy.\n" +
                    "Maybe not lazy, per se, you are mostly a relaxed worker.\n" +
                    "Like your bull star-sign, you are often voracious and stubborn. A few people consider you a total a-hole.\n" + "It’s a good thing you have a sense of humor.");
        } else if (month == 5 && (day >= 21 && day <= numDays) || month == 6 && (day <= 21 && day >= 1)) { //gemini
            out.writeBytes("Nice! You are a " + signs[5] + "! " + "People love Geminis. Why wouldn’t they? After all, everyone loves unstable people with mental issues.\n" +
                    "Their cars are funny, and they make them funnier by driving them into stuff.\n" +
                    "They will argue with kids, and mooning people is a go-to joke for them. You will even argue with yourself and lash out.\n" +
                    "Geminis like to explain philosophical concepts they hardly understand with theories that make no sense.\n" +
                    "Their medicine cabinets are always fully loaded, and they make themselves heard by speaking loudly.");
        } else if (month == 6 && (day >= 22 && day <= numDays) || month == 7 && (day <= 22 && day >= 1)) { //cancer
            out.writeBytes("Nice! You are a " + signs[6] + "! " + "Nobody thinks you are funny until you try to be funny.\n" + "That’s when you prove you are a lot less funny than you look." +
                    "But your clumsiness is your saving grace.\n" + "It’s always hilarious seeing you spill your coffee. You are far too sensitive, moody, and whiny.\n" +
                    "Also, you are a sucker, but that’s a good thing because it means you believe in people's goodness.\n" + "That’s ironic considering that so many Cancers are in prison.");
        } else if (month == 7 && (day >= 23 && day <= numDays) || month == 8 && (day <= 22 && day >= 1)) { //leo
            out.writeBytes("Nice! You are a " + signs[7] + "! " + "You kiss yourself in mirrors, and you will even interrupt yourself while talking in a bid to outdo your insatiable desire for attention.\n" +
                    "Unless the entire town is crazy about your birthday party, it’s not good enough.\n" +
                    "But your ability to irritate is incredible, which is why necrophilia is probably an appealing proposition for you.");
        } else if (month == 8 && (day >= 23 && day <= numDays) || month == 9 && (day <= 22 && day >= 1)) { //virgo
            out.writeBytes("Nice! You are a " + signs[8] + "! " + "You like to color-coordinate everything, including your food! No wonder you are such a pain in the ass.\n" +
                    "Your favorite cleaning appliance is a toothbrush, and you think if you look closely enough, you can see the germs.\n" +
                    "People have to walk on eggshells around you because you are so easy to piss off.");
        } else if (month == 9 && (day >= 23 && day <= numDays) || month == 10 && (day <= 23 && day >= 1)) { //libra
            out.writeBytes("Nice! You are a " + signs[9] + "! " + "Nobody likes perfection like you do, although nobody feels as incomplete as you do.\n" + "Your desire for perfection can inspire an unhealthy dose of nausea.\n" +
                    "Mix that with your indecisiveness, love for ethnic foods, and use of quotes, you become more than a little intolerable.\n" + "You are better at explaining your ideas when drunk, and reality is a bit hard for you to understand.\n" +
                    "You probably have messy finances because, in your mind, you already think you are living the perfect dream.");
        } else if (month == 10 && (day >= 24 && day <= numDays) || month == 11 && (day <= 21 && day >= 1)) { //scorpio
            out.writeBytes("Nice! You are a " + signs[10] + "! " + "Are you a hacker? If you are a Scorpio, then there is a good chance you are one. You also treat Star Trek like a documentary.\n" +
                    "Most people like their coffee black, and so do you. but while everyone prefers it in a cup, while you eat it off a spoon.\n" +
                    "You take life very, very seriously, and you like to smoke in the shower. But you also like sex, and that gives you another opportunity to smoke.");
        } else if (month == 11 && (day >= 22 && day <= numDays) || month == 12 && (day <= 21 && day >= 1)) { //sagitario
            out.writeBytes("Nice! You are a " + signs[11] + "! " + "You don’t know when to stop. You make funny jokes until they are no longer funny.\n" + "And even then, you go on until your audience boos you off.\n" +
                    "Making yourself look like an idiot is your idea of being fun. Others know you for your fear of commitment.");
        }

        out.writeBytes("\n" + "\n" +
                "What do you think?\n" +
                "Are you happy with your zodiac sign description? Probably not.\n" +
                "But there’s nothing wrong with laughing at yourself once in a while. Unless, of course, you are Capricorn.\n");

    }




}
