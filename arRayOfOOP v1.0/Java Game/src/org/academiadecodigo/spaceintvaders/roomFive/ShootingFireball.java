package org.academiadecodigo.spaceintvaders.roomFive;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.hero.Hero;

public class ShootingFireball {
    //Picture shootingFireball;
    Picture fireball;
    Hero hero;
    ShootingFireballNumber number;

    private boolean right;
    private int col;
    private long invincible;

    Rectangle fireballOneBounds;
    Rectangle fireballTwoBounds;
    Rectangle fireballThreeBounds;

    Rectangle miniFireball1Bounds;
    Rectangle miniFireball2Bounds;

    private Rectangle fireBalls[];

    public ShootingFireball(Hero hero, ShootingFireballNumber number) {

        this.hero = hero;
        this.number = number;
        createEnemy(number);
        fireball.draw();



        right = false;
        invincible = 20;
    }


    //ENEMY CREATE
    public void createEnemy(ShootingFireballNumber number) {
        switch (number) {
            case ONE:
                fireball = new Picture(620, 390, "/imgs/ghost/ghost40right.PNG");
                fireballOneBounds = new Rectangle(fireball.getX(), fireball.getY(), fireball.getWidth(), fireball.getHeight());

                break;

            case TWO:
                fireball = new Picture(500, 490, "/imgs/ghost/ghost40left.PNG");
                fireballTwoBounds = new Rectangle(fireball.getX(), fireball.getY(), fireball.getWidth(), fireball.getHeight());

                break;

            case THREE:
                fireball = new Picture(730, 590, "/imgs/ghost/ghost40right.PNG");
                fireballThreeBounds = new Rectangle(fireball.getX(), fireball.getY(), fireball.getWidth(), fireball.getHeight());
                break;


        }
    }

    public Rectangle[] bigFireBallArray() {
        return fireBalls = new Rectangle[3];
    };

    public Rectangle[] getArray() {
        return fireBalls;
    }


    //GETTER && SETTER
    private void setCol() {
        col = fireball.getX();
    }

    private int getCol() {
        return col;
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
                    fireball.translate(12, 0);
                    setCol();
                    collide();
                    if (getCol() >= 800) {
                        right = true;
                    }
                } else {
                    fireball.translate(-15, 0);
                    setCol();
                    collide();
                    if (getCol() < 460) {
                        right = false;
                    }
                }
                break;

            case TWO:
                if (!right) {
                    fireball.translate(10, 0);
                    setCol();
                    collide();
                    if (getCol() >= 800) {
                        right = true;
                    }
                } else {
                    fireball.translate(-10, 0);
                    setCol();
                    collide();
                    if (getCol() < 460) {
                        right = false;
                    }
                }
                break;

            case THREE:
                if (!right) {
                    fireball.translate(15, 0);
                    setCol();
                    collide();
                    if (getCol() >= 800) {
                        right = true;
                    }
                } else {
                    fireball.translate(-12, 0);
                    setCol();
                    collide();
                    if (getCol() < 460) {
                        right = false;
                    }
                }
                break;
        }
    }


    //COLLISION
    public void collide() {
        if (invincible < 0) {

            if ((hero.getHero().getX() > (fireball.getX() - 30))) {
                if ((hero.getHero().getX() < (fireball.getX() + 30))) {
                    if (hero.getHero().getY() > (fireball.getY() - 30)) {
                        if (hero.getHero().getY() < (fireball.getY()) + 30) {
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
