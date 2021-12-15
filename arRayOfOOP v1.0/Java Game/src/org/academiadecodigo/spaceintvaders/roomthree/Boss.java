package org.academiadecodigo.spaceintvaders.roomthree;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.Enemy;
import org.academiadecodigo.spaceintvaders.hero.Hero;

public class Boss implements Enemy {
    private Picture boss;
    private int col;
    private int row;
    private boolean goRight;
    private Hero hero;
    private int hp;
    private boolean arrow1HasDoneDamage;
    private boolean arrow2HasDoneDamage;
    private boolean arrow3HasDoneDamage;
    private long invencibility;


    public Boss(Hero hero) {
        //X:1090
        //Y:00
        this.col = 1090;
        this.row = 20;
        boss = new Picture(col, row, "/imgs/boss/bossLightsOn.PNG");

        goRight = true;
        hp = 7;
        this.hero = hero;
        arrow1HasDoneDamage = false;
        arrow2HasDoneDamage = false;
        arrow3HasDoneDamage = false;
        invencibility = 20L;
    }


    public void drawBoss(){
        boss.draw();
    }

    public int getHp(){
        return hp;
    }

    public void delete(){
        boss.delete();
    }


    public void collide() {

        if ((hero.getHero().getX() > (boss.getX() - 50))) {
            if ((hero.getHero().getX() < (boss.getX() + 150))) {
                if (hero.getHero().getY() > (boss.getY() - 150)) {
                    if (hero.getHero().getY() < (boss.getY()) + 50) {
                        hero.beHit();
                        //System.out.println("ran into boss!");


                    }
                }

            }

        }
    }

    public void arrowCollision() {


        if(!hero.getArrow1().hasdoneDamage()){
            if (hero.getArrow1() != null) {
                if ((hero.getArrow1().getCol() > (boss.getX() - 50))) {
                    if ((hero.getArrow1().getCol() < (boss.getX() + 50))) {
                        if (hero.getArrow1().getRow() > (boss.getY() - 150)) {
                            if (hero.getArrow1().getRow() < (boss.getY()) + 50) {

                                hero.getArrow1().setDoneDamageTrue();
                                beHit();
                                hero.deleteArrow1();
                                //System.out.println("You hit the boss!");


                            }
                        }
                    }
                }
            }
        }

        if(!hero.getArrow2().hasdoneDamage()) {
            if (hero.getArrow2() != null) {
                if ((hero.getArrow2().getCol() > (boss.getX() - 50))) {
                    if ((hero.getArrow2().getCol() < (boss.getX() + 50))) {
                        if (hero.getArrow2().getRow() > (boss.getY() - 150)) {
                            if (hero.getArrow2().getRow() < (boss.getY()) + 50) {

                                beHit();
                                hero.getArrow2().setDoneDamageTrue();
                                hero.deleteArrow2();
                                //System.out.println("You hit the boss!");


                            }
                        }
                    }
                }
            }
        }

        if(!hero.getArrow3().hasdoneDamage()) {
            if (hero.getArrow3() != null) {
                if ((hero.getArrow3().getCol() > (boss.getX() - 50))) {
                    if ((hero.getArrow3().getCol() < (boss.getX() + 100))) {
                        if (hero.getArrow3().getRow() > (boss.getY() - 150)) {
                            if (hero.getArrow3().getRow() < (boss.getY()) + 50) {

                                beHit();
                                hero.getArrow3().setDoneDamageTrue();
                                hero.deleteArrow3();
                                //System.out.println("You hit the boss!");


                            }
                        }
                    }
                }
            }
        }
    }





    public void Arrow1HasNotDoneDamage(){
        arrow1HasDoneDamage = false;
    }

    public void Arrow2HasNotDoneDamage(){
        arrow1HasDoneDamage = false;
    }

    public void Arrow3HasNotDoneDamage(){
        arrow1HasDoneDamage = false;
    }





    public void beHit(){
        try{
            boss.delete();
            Thread.sleep(50);
            boss.draw();
            boss.delete();
            Thread.sleep(50);
            boss.draw();
            hp--;
            //System.out.println(hp);
        } catch (java.lang.InterruptedException e){
            System.out.println("interrupted Exception");
        } catch (java.util.ConcurrentModificationException es){
            beHit();
            //System.out.println("current");
        }
    }


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    /*public void setRow(){
        this.row = boss.getY();
    } */

    public void setCol() {
        this.col = boss.getX();
    }


    public void move() {
        try {
            if (goRight) {
                boss.translate(15, 00);
                setCol();
                collide();
                arrowCollision();
                if (getCol() > 1130) {
                    goRight = false;
                }
            } else {
                boss.translate(-10, 00);
                setCol();
                collide();
                arrowCollision();
                if (getCol() < 900) {
                    goRight = true;
                }
            }
        } catch (java.util.ConcurrentModificationException edd) {
            move();
        }
    }
}
