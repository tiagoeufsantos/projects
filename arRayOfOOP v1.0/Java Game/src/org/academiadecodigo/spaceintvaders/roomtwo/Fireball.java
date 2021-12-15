package org.academiadecodigo.spaceintvaders.roomtwo;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.hero.Direction;
import org.academiadecodigo.spaceintvaders.hero.Hero;
import org.academiadecodigo.spaceintvaders.roomthree.BulletNumber;

public class Fireball {
    Picture fireball;
    Hero hero;
    FireballNumber order;
    private boolean goRight;
    private int col;
    private int row;
    private long invencibility;

    public Fireball(Hero hero, FireballNumber order) {
        //1: x left 410, y 100 \\\\\\ x790, y100

        this.hero = hero;
        this.order = order;
        create(order);
        //fireball.draw();
        goRight = false;
        invencibility = 20;
    }

    public void create(FireballNumber order) {
        switch (order) {
            case FIRST:
                fireball = new Picture(655, 130, "imgs/eyeballs/eyeballGoingRight.png");
                break;

            case SECOND:
                fireball = new Picture(655, 180, "imgs/eyeballs/eyeballGoingLeft.png");
                break;

            case THIRD:
                fireball = new Picture(655, 230, "imgs/eyeballs/eyeballGoingRight.png");
                break;

            case FOURTH:
                fireball = new Picture(655, 280, "imgs/eyeballs/eyeballGoingLeft.png");
                break;


        }
    }

    public void fireballShow(){
        fireball.draw();
    }

    public void fireballDel(){
        fireball.delete();
    }

    private void setCol() {
        col = fireball.getX();
    }

    private void setRow() {
        row = fireball.getY();
    }

    private int getCol() {
        return col;
    }

    public void move() {
        invencibility--;
        if(invencibility == -9999999){
            invencibility = 0;
        }

        switch (order) {

            case FIRST:
                if (goRight) {
                    fireball.translate(20, 00);
                    setCol();
                    collide();
                    if (getCol() >= 830) {
                        goRight = false;
                    }
                } else {
                    fireball.translate(-20, 00);
                    setCol();
                    collide();
                    if (getCol() < 440) {
                        goRight = true;
                    }
                }
                break;

            case SECOND:

                if (!goRight) {
                    fireball.translate(20, 00);
                    setCol();
                    collide();
                    if (getCol() >= 830) {
                        goRight = true;
                    }
                } else {
                    fireball.translate(-20, 00);
                    setCol();
                    collide();
                    if (getCol() < 440) {
                        goRight = false;
                    }
                }
                break;

            case THIRD:

                if (goRight) {
                    fireball.translate(20, 00);
                    setCol();
                    collide();
                    if (getCol() >= 830) {
                        goRight = false;
                    }
                } else {
                    fireball.translate(-20, 00);
                    setCol();
                    collide();
                    if (getCol() < 440) {
                        goRight = true;
                    }
                }
                break;

            case FOURTH:

                if (!goRight) {
                    fireball.translate(20, 00);
                    setCol();
                    collide();
                    if (getCol() >= 830) {
                        goRight = true;
                    }
                } else {
                    fireball.translate(-20, 00);
                    setCol();
                    collide();
                    if (getCol() < 440) {
                        goRight = false;
                    }
                }
                break;

        }



    }


    public void collide() {
        if (invencibility < 0) {

            if ((hero.getHero().getX() > (fireball.getX() - 30))) {
                if ((hero.getHero().getX() < (fireball.getX() + 30))) {
                    if (hero.getHero().getY() > (fireball.getY() - 30)) {
                        if (hero.getHero().getY() < (fireball.getY()) + 30) {
                            hero.beHit();
                            invencibility = 20;
                            //System.out.println("hit by a fire thing");
                        }
                    }
                }

            }

        }
    }


}


