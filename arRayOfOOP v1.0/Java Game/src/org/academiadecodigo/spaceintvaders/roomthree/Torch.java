package org.academiadecodigo.spaceintvaders.roomthree;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.hero.Hero;


public class Torch {
    private Picture leftStatue;
    private Picture rightStatue;
    private Picture leftProjectile;
    private Picture rightProjectile;
    private int leftRow;
    private int leftCol;
    private int rightRow;
    private int rightCol;
    private boolean leftHasDoneDamage;
    private boolean rightHasDoneDamage;
    private Hero hero;
    private int statueCol;
    private int statueRow;
    private int rightStatueHP;
    private int leftStatueHP;


    public Torch(int col, int row, Hero hero) {
        this.rightStatueHP = 1;
        this.leftStatueHP = 1;
        this.hero = hero;
        this.statueCol = col;
        this.statueRow = row;
        leftStatue = new Picture(col, row, "/imgs/skeleton/skeleton_down.PNG");
        //facingRight.draw();
        rightStatue = new Picture(col + 360, row, "/imgs/skeleton/skeleton_down_flip.png");
        //facingLeft.draw();
        createLeftProjectiles();
        createRightProjectiles();
        leftHasDoneDamage = false;
        rightHasDoneDamage = false;


    }

    public void drawStatues() {
        leftStatue.draw();
        rightStatue.draw();
    }

    public void rightGotHit() {
        rightStatueHP--;
        rightStatue.delete();
        //System.out.println("You the right thingy!");
    }

    public void leftGotHit() {
        leftStatueHP--;
        leftStatue.delete();
        //System.out.println("You the left thingy!");
    }

    public void arrowLeftStatueCollision() {
        if (hero.getArrow1() != null) {
            if ((hero.getArrow1().getCol() > (leftStatue.getX() - 30))) {
                if ((hero.getArrow1().getCol() < (leftStatue.getX() + 5))) {
                    if (hero.getArrow1().getRow() > (leftStatue.getY() - 15)) {
                        if (hero.getArrow1().getRow() < (leftStatue.getY()) + 30) {


                            leftGotHit();
                            hero.deleteArrow1();
                            //System.out.println("You hit the facing left thingy!");

                        }
                    }
                }
            }
        }

        if (hero.getArrow2() != null) {
            if ((hero.getArrow2().getCol() > (leftStatue.getX() - 30))) {
                if ((hero.getArrow2().getCol() < (leftStatue.getX() + 5))) {
                    if (hero.getArrow2().getRow() > (leftStatue.getY() - 15)) {
                        if (hero.getArrow2().getRow() < (leftStatue.getY()) + 30) {


                            leftGotHit();
                            hero.deleteArrow2();
                            //System.out.println("You hit the facing left thingy!");

                        }
                    }
                }
            }
        }

        if (hero.getArrow3() != null) {
            if ((hero.getArrow3().getCol() > (leftStatue.getX() - 50))) {
                if ((hero.getArrow3().getCol() < (leftStatue.getX() + 50))) {
                    if (hero.getArrow3().getRow() > (leftStatue.getY() - 15)) {
                        if (hero.getArrow3().getRow() < (leftStatue.getY()) + 30) {


                            leftGotHit();
                            hero.deleteArrow3();
                            //System.out.println("You hit the facing left thingy!");

                        }
                    }
                }
            }
        }

    }

    public void arrowRightStatueCollision() {
        if (hero.getArrow1() != null) {
            if ((hero.getArrow1().getCol() > (rightStatue.getX() - 30))) {
                if ((hero.getArrow1().getCol() < (rightStatue.getX() + 5))) {
                    if (hero.getArrow1().getRow() > (rightStatue.getY() - 15)) {
                        if (hero.getArrow1().getRow() < (rightStatue.getY()) + 30) {


                            rightGotHit();
                            hero.deleteArrow1();
                            //System.out.println("You hit the facing right thingy!");


                        }
                    }
                }
            }
        }

        if (hero.getArrow2() != null) {
            if ((hero.getArrow2().getCol() > (rightStatue.getX() - 30))) {
                if ((hero.getArrow2().getCol() < (rightStatue.getX() + 5))) {
                    if (hero.getArrow2().getRow() > (rightStatue.getY() - 15)) {
                        if (hero.getArrow2().getRow() < (rightStatue.getY()) + 30) {


                            rightGotHit();
                            hero.deleteArrow2();
                            //System.out.println("You hit the facing right thingy!");


                        }
                    }
                }
            }
        }

        if (hero.getArrow3() != null) {
            if ((hero.getArrow3().getCol() > (rightStatue.getX() - 30))) {
                if ((hero.getArrow3().getCol() < (rightStatue.getX() + 5))) {
                    if (hero.getArrow3().getRow() > (rightStatue.getY() - 15)) {
                        if (hero.getArrow3().getRow() < (rightStatue.getY()) + 30) {


                            rightGotHit();
                            hero.deleteArrow3();
                            //System.out.println("You hit the facing right thingy!");


                        }
                    }
                }
            }
        }


    }


    public int getLeftRow() {
        return leftRow;
    }

    public int getRightRow() {
        return rightRow;
    }

    public int getLeftCol() {
        return leftCol;
    }

    public int getRightCol() {
        return rightCol;
    }


    public void leftCollide() {
        if ((hero.getHero().getX() >= (leftProjectile.getX() - 30))) {
            if ((hero.getHero().getX() < (leftProjectile.getX() + 5))) {
                if (hero.getHero().getY() >= (leftProjectile.getY() - 30)) {
                    if (hero.getHero().getY() < (leftProjectile.getY()) + 10) {
                        if (!leftHasDoneDamage) {
                            hero.beHit();
                            //System.out.println("hit by a torch bullet!");
                            leftHasDoneDamage = true;
                        }
                    }
                }

            }

        }
    }


    public void rightCollide() {
        if ((hero.getHero().getX() > (rightProjectile.getX() - 30))) {
            if ((hero.getHero().getX() < (rightProjectile.getX() + 5))) {
                if (hero.getHero().getY() > (rightProjectile.getY() - 30)) {
                    if (hero.getHero().getY() < (rightProjectile.getY()) + 10) {
                        if (!rightHasDoneDamage) {
                            hero.beHit();
                            //System.out.println("hit by a left torch bullet!");
                            rightHasDoneDamage = true;
                        }
                    }
                }

            }

        }

    }

    public int getRightStatueHP() {
        return rightStatueHP;
    }

    public int getLeftStatueHP() {
        return leftStatueHP;
    }

    public void leftDelete() {
        try {
            leftProjectile.delete();
            leftHasDoneDamage = false;
        } catch (java.util.ConcurrentModificationException es) {
            leftDelete();
        }
    }

    public void rightDelete() {
        try {
            rightProjectile.delete();
            rightHasDoneDamage = false;
        } catch (java.util.ConcurrentModificationException es) {
            rightDelete();
        }
    }

    public void leftMove() {
        try {
            if (leftStatueHP > 0) {
                //leftProjectile.fill();
                leftProjectile.draw();
                leftProjectile.translate(10, 0);
                leftRow = leftProjectile.getY();
                leftCol = leftProjectile.getX();
                leftCollide();
                arrowLeftStatueCollision();
                arrowRightStatueCollision();
            } else {
                leftProjectile.delete();
            }
        } catch (java.util.ConcurrentModificationException es) {
            leftMove();
        }

    }

    public void rightMove() {
        try {
            if (rightStatueHP > 0) {
                //rightProjectile.fill();
                rightProjectile.draw();
                rightProjectile.translate(-10, 0);
                rightRow = rightProjectile.getY();
                rightCol = rightProjectile.getX();
                rightCollide();
                arrowRightStatueCollision();
                arrowRightStatueCollision();
            } else {
                rightProjectile.delete();
            }
        } catch (java.util.ConcurrentModificationException es) {
            rightMove();
        }

    }


    public void createLeftProjectiles() {
        try {
            leftProjectile = new Picture(statueCol, statueRow + 15, "imgs/arrows/arrowRight.png");
            //leftProjectile.setColor(Color.YELLOW);
        } catch (java.util.ConcurrentModificationException es) {
            createLeftProjectiles();
        }
    }

    public void createRightProjectiles() {
        try {
            rightProjectile = new Picture(statueCol + 365, statueRow + 15, "imgs/arrows/arrowLeft.png");
            //rightProjectile.setColor(Color.YELLOW);
        } catch (java.util.ConcurrentModificationException es) {
            createRightProjectiles();
        }

    }
}
