package org.academiadecodigo.spaceintvaders.roomFive;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.hero.Hero;

public class MiniFireball {

    Picture miniFireball;
    private Hero hero;

    private int col;
    private boolean right;

    MiniFireballNumber number;
    private long invincible;


    //CONSTRUCTOR
    public MiniFireball(Hero hero, MiniFireballNumber number) {
        this.hero = hero;
        this.number = number;
        setMiniFireballCoords(number);
        miniFireball.draw();
        right = false;
        invincible = 10;

    }


    //GETTER && SETTER
    public int getCol() {
        return col;
    }

    public void setCol() {
        col = miniFireball.getX();
    }

    public void setMiniFireballCoords(MiniFireballNumber number) {
        switch (number) {
            case ONE:
                miniFireball = new Picture(460, 455, "/imgs/ghost/ghost20right.PNG");
                //miniFireball.grow(-20, -10);
                break;
            case TWO:
                miniFireball = new Picture(830, 545, "/imgs/ghost/ghost20left.PNG");
                //miniFireball.grow(-20, -10);
                break;
        }
    }


    //ENEMY MOVE
    public void move() {
        invincible--;
        if (invincible == -9999) {
            invincible = 0;
        }

        switch (number) {
            case ONE:
                if (!right) {
                    miniFireball.translate(3, 0);
                    setCol();
                    collide();
                    if (getCol() >= 810) {
                        miniFireball.translate(-390,0);
                    }
                }
                break;

            case TWO:
                if (!right) {
                    miniFireball.translate(-4, 0);
                    setCol();
                    collide();
                    if (getCol() <= 460) {
                        miniFireball.translate(390,0);
                    }
                }
                break;
        }
    }


    public void collide() {
        if (invincible < 0) {

            if ((hero.getHero().getX() > (miniFireball.getX() - 30))) {
                if ((hero.getHero().getX() < (miniFireball.getX() + 30))) {
                    if (hero.getHero().getY() > (miniFireball.getY() - 30)) {
                        if (hero.getHero().getY() < (miniFireball.getY()) + 30) {
                            hero.beHit();
                            invincible = 20;
                            //System.out.println("hit by a fire thing");
                        }
                    }
                }

            }

        }
    }


}
