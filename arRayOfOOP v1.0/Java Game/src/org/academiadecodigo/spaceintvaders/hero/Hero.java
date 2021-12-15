package org.academiadecodigo.spaceintvaders.hero;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Hero { // col x, row y
    private Picture hero;
    private Arrow arrow1;
    private Arrow arrow2;
    private Arrow arrow3;
    private int col;
    private int row;
    private int hp;
    private Direction lastDir;
    private int arrowCounter;
    Arrow lastArrow;

    //X:1170
    //Y:650

    public Hero(){
        this.col = 60;
        this.row = 210;
        hero = new Picture(col,row,"imgs/princess_down.png");
        hero.draw();
        hp = 6;
        arrowCounter = -1;
        arrow1 = new Arrow(hero, Direction.UP);
        arrow1.arrowDelete();
        arrow2 = new Arrow(hero, Direction.UP);
        arrow2.arrowDelete();
        arrow3 = new Arrow(hero, Direction.UP);
        arrow3.arrowDelete();
        lastArrow = arrow3;

    }

    public void setHealth(){
        this.hp = 6;
    }


    public Picture getHero(){
        return hero;
    }

    public Arrow getArrow1(){
       return arrow1;
    }

    public Arrow getArrow2(){
        return arrow2;
    }

    public Arrow getArrow3(){
        return arrow3;
    }

    public void setArrow1Null(){
        arrow1 = null;
    }

    public void setArrow2Null(){
        arrow2 = null;
    }

    public void setArrow3Null(){
        arrow3 = null;
    }





    public void beHit(){
        hp--;
        //System.out.println("I've been hit and have " + hp);
        try {
            hero.delete();
            Thread.sleep(50);
            hero.draw();
            hero.delete();
            Thread.sleep(50);
            hero.draw();
        } catch(java.lang.InterruptedException e){
            System.out.println("Interrupted thread exception catch");
        }
    }

    public void arrowMove(){
        if(arrow1 != null){
        arrow1.move();
        }
        if(arrow2 != null) {
            arrow2.move();
        }
        if(arrow3 != null) {
            arrow3.move();
        }
    }

    public void translateArrow1(){
        arrow1.translateLeft();
    }

    public void translateArrow2(){
        arrow2.translateLeft();
    }

    public void translateArrow3(){
        arrow3.translateLeft();
    }


    public void deleteArrow1(){
        arrow1.arrowDelete();
    }

    public void deleteArrow2(){
        arrow2.arrowDelete();

    }

    public void deleteArrow3(){
        arrow3.arrowDelete();
    }

    public void createArrow1(){
        arrow1 = new Arrow(hero, lastDir);
    }

    public void createArrow2(){
        arrow2 = new Arrow(hero, lastDir);
    }

    public void createArrow3(){
        arrow3 = new Arrow(hero, lastDir);
    }

    public void setLastDir(Direction dir) {
        this.lastDir = dir;
    }


    public boolean arrowInputLogic(){

        if(arrowCounter == -1){
            createArrow1();
            createArrow2();
            createArrow3();
            lastArrow = arrow3;
            arrowCounter++;
            return true;

        }

        if(lastArrow != null) {
            if(lastArrow.getCounter() < 4) {
                return true;
            }
        }

            arrowCounter++;

            if (arrowCounter == 1) {
                deleteArrow1();
                createArrow1();
                lastArrow = arrow1;
                //System.out.println("Arrow 1");
            }
            if (arrowCounter == 2) {
                deleteArrow2();
                createArrow2();
                lastArrow = arrow2;
                //System.out.println("Arrow 2");
            }

            if (arrowCounter == 3) {
                deleteArrow3();
                createArrow3();
                lastArrow = arrow3;
                //System.out.println("Arrow 3");
                arrowCounter = 0;
            }


        return true;
    }


    public int getHp(){
        return hp;
    }

    public void loseHp(){
        hp = hp - 1;
    }

    public int getCol(){
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public void setRow(int row){
        this.row = row;
    }

    public void translateUp(){
        hero.translate(0,-10);
        row = hero.getY();
        col = hero.getX();
        lastDir = Direction.UP;
    }

    public void translateDown(){
        hero.translate(0,10);
        row = hero.getY();
        col = hero.getX();
        lastDir = Direction.DOWN;
    }

    public void translateLeft(){
        hero.translate(-10,0);
        row = hero.getY();
        col = hero.getX();
        lastDir = Direction.LEFT;
    }

    public void translateRight(){
        hero.translate(10,0);
        row = hero.getY();
        col = hero.getX();
        lastDir = Direction.RIGHT;
    }



}
