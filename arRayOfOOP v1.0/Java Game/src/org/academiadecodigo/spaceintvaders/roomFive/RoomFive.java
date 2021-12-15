package org.academiadecodigo.spaceintvaders.roomFive;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.hero.Hero;

public class RoomFive {

    Hero hero;
    Picture knightTalkBox;
    ShootingFireball fireballOne;
    ShootingFireball fireballTwo;
    ShootingFireball fireballThree;

    MiniFireball miniFireball1;
    MiniFireball miniFireball2;

    private Picture arrow;
    private boolean drawsArrow;
    private boolean arrowPresent = false;










    public RoomFive(Hero hero) {
        this.hero = hero;
        fireballOne = new ShootingFireball(hero, ShootingFireballNumber.ONE);
        fireballTwo = new ShootingFireball(hero, ShootingFireballNumber.TWO);
        fireballThree = new ShootingFireball(hero, ShootingFireballNumber.THREE);

        miniFireball1 = new MiniFireball(hero, MiniFireballNumber.ONE);
        miniFireball2 = new MiniFireball(hero, MiniFireballNumber.TWO);
        drawsArrow = false;

        arrow = new Picture(640,540,"/imgs/arrows/arrowUp.png");

    }

    public void drawArrow() {

        if(!drawsArrow) {
            arrow.draw();
            arrowPresent = true;
            drawsArrow = true;
        }
        //System.out.println("Arrow is now present");
    }

    public void deleteArrow() {
        this.arrow.delete();
    }

    public boolean isArrowPresent(){
        return arrowPresent;
    }

    public Picture getArrow(){
        return this.arrow;
    }





    public void moveAll(){

        fireballOne.move();
        fireballTwo.move();
        fireballThree.move();
        miniFireball1.move();
        miniFireball2.move();
    }





        public Picture tiredKnightChatBox(){
            knightTalkBox = new Picture(470, 600, "/imgs/scrolls/Untitled 2 2.png");
            //knightTalkBox.setColor(Color.ORANGE);
            knightTalkBox.draw();
            drawArrow();
            return knightTalkBox;
        }

        public void tiredKnightSpeaks() throws InterruptedException {
            tiredKnightChatBox();
            Thread.sleep(7000);
            knightTalkBox.delete();
        }

    }

