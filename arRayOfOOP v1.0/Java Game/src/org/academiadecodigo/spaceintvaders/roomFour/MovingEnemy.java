package org.academiadecodigo.spaceintvaders.roomFour;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.hero.Hero;


public class MovingEnemy {
    Picture movingEnemy;
    Hero hero;
    MovingEnemyNumber number;
    private boolean right;
    private boolean down;
    private int col;
    private int row;
    private long invincible;

    public MovingEnemy(Hero hero, MovingEnemyNumber number) {

        this.hero = hero;
        this.number = number;
        createEnemy(number);
        movingEnemy.draw();
        right = false;
        down = false;
        invincible = 10;
    }

    public void createEnemy(MovingEnemyNumber number) {
        switch (number) {
            case ONE:
                movingEnemy = new Picture(300, 420, "/imgs/bat/bat.PNG");
                break;

            case TWO:
                movingEnemy = new Picture(100, 550, "/imgs/bat/bat.PNG");
                break;

            case THREE:
                movingEnemy = new Picture(200, 650, "/imgs/bat/bat.PNG");
                break;

            case FOUR:
                movingEnemy = new Picture(20, 550, "/imgs/bat/bat.PNG");
                break;

            case FIVE:
                movingEnemy = new Picture(250, 530, "/imgs/bat/bat.PNG");
                break;

            case SIX:
                movingEnemy = new Picture(290, 500, "/imgs/bat/bat.PNG");
                break;
        }
    }

    private void setCol() {
        col = movingEnemy.getX();
    }

    private void setRow() {
        row = movingEnemy.getY();
    }

    private int getCol() {
        return col;
    }

    private int getRow() {
        return row;
    }

    public void move() {
        invincible--;
        if (invincible == -9999) {
            invincible = 0;
        }

        switch (number) {
            case ONE:
                if (right) {
                    movingEnemy.translate(15, 0);
                    setCol();
                    collide();
                    if (getCol() >= 250) {
                        right = false;
                    }
                } else {
                    movingEnemy.translate(-20, 0);
                    setCol();
                    collide();
                    if (getCol() < 20) {
                        right = true;
                    }
                }
                break;

            case TWO:
                if (!right) {
                    movingEnemy.translate(20, 0);
                    setCol();
                    collide();
                    if (getCol() >= 355) {
                        right = true;
                    }
                } else {
                    movingEnemy.translate(-20, 0);
                    setCol();
                    collide();
                    if (getCol() < 70) {
                        right = false;
                    }
                }
                break;

            case THREE:
                if (!right) {
                    movingEnemy.translate(15, 0);
                    setCol();
                    collide();
                    if (getCol() >= 360) {
                        right = true;
                    }
                } else {
                    movingEnemy.translate(-20, 0);
                    setCol();
                    collide();
                    if (getCol() < 200) {
                        right = false;
                    }
                }
                break;

            case FOUR:
                if (!down) {
                    movingEnemy.translate(0, 15);
                    setRow();
                    collide();
                    if (getRow() >= 670) {
                        down = true;
                    }
                } else {
                    movingEnemy.translate(0, -20);
                    setRow();
                    collide();
                    if (getRow() < 450) {
                        down = false;
                    }
                }
                break;

            case FIVE:
                if (!down) {
                    movingEnemy.translate(8, 8);
                    setRow();
                    collide();
                    if (getRow() >= 520) {
                        down = true;
                    }
                } else {
                    movingEnemy.translate(-11, -11);
                    setRow();
                    collide();
                    if (getRow() < 400) {
                        down = false;
                    }
                }
                break;

            case SIX:
                if (!down) {
                    movingEnemy.translate(0, 10);
                    setRow();
                    collide();
                    if (getRow() >= 500) {
                        down = true;
                    }
                } else {
                    movingEnemy.translate(0, -10);
                    setRow();
                    collide();
                    if (getRow() < 385) {
                        down = false;
                    }
                }
                break;

        }
    }


    public void collide() {
        if (invincible < 0) {
            if ((hero.getHero().getX() > (movingEnemy.getX() - 30))) {
                if ((hero.getHero().getX() < (movingEnemy.getX() + 30))) {
                    if (hero.getHero().getY() > (movingEnemy.getY() - 30)) {
                        if (hero.getHero().getY() < (movingEnemy.getY()) + 30) {
                            hero.beHit();
                            invincible = 20;
                            //System.out.println("hit by a bat thing");
                        }
                    }
                }

            }

        }
    }

}

