package org.academiadecodigo.spaceintvaders.hero;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.Enemy;

import java.util.ConcurrentModificationException;

public class Arrow {
    private Picture arrow;
    private Picture arrowPicture;
    private int col;
    private int row;
    private Direction lastDir;
    private Picture hero;
    private int counter;
    private Enemy enemy;
    private Picture arrowNeutral;
    private boolean hasDoneDamage;
    private int resultX;
    private int resultY;


    public Arrow(Picture hero, Direction lastDir){
        this.hero = hero;
        this.lastDir = lastDir;
        setArrowCordinates();
        arrow = new Picture(col, row,"imgs/arrows/arrowUp.png");
        arrowNeutral = new Picture(10, 10,"imgs/arrows/arrowUp.png");
        //arrow.setColor(Color.RED);
        //arrow.fill();
        arrow.draw();
        hasDoneDamage = false;


    }

    public int getCounter(){
        return counter;
    }

    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
    }


    public void setArrowCordinates(){
        if(lastDir == null){
            lastDir = Direction.LEFT;
        }
        switch (lastDir){
            case UP:
                this.col = hero.getX() + 10;
                this.row = hero.getY() - 10;
                break;

            case DOWN:
                this.col = hero.getX() + 10;
                this.row = hero.getY() + 40;
                break;

            case LEFT:
                this.col = hero.getX();
                this.row = hero.getY();
                break;

            case RIGHT:
                this.col = hero.getX() + 20;
                this.row = hero.getY();
                break;
        }
    }

    public void move(){
        if(arrow.getX() >= 1235 || (arrow.getX() < 430 && arrow.getX() > 1)){
            arrow.delete();
            resultX =  0 - arrow.getX();
            resultY =  0 - arrow.getY();
            arrow.translate(resultX,resultY);
            arrow = arrowNeutral;
            //arrow = arrowPicture;
        }

        if(arrow.getX() <= 25){

            arrow.delete();
            arrow = arrowNeutral;
            //arrow = arrowPicture;
        }

        if((arrow.getY() >= 675) || (arrow.getY() > 390 && arrow.getX() < 870) ){
            arrow.delete();
            resultX =  0 - arrow.getX();
            resultY =  0 - arrow.getY();
            arrow.translate(resultX,resultY);
            arrow = arrowNeutral;
            //arrow = arrowPicture;
        }

        if(arrow.getY() <= 30){
            arrow.translate(-100,0);
            arrow.delete();
            arrow = arrowNeutral;
            //arrow = arrowPicture;
        }

        counter++;
        if(counter > 10){
            arrow.delete();
            arrow = new Picture(10, 10,"imgs/arrows/arrowLeft.png");

        }

        switch (lastDir){
            case UP:
                arrow.load("imgs/arrows/arrowUp.png");
                arrow.translate(0,-20);

                row = arrow.getY();
                break;

            case DOWN:
                arrow.load("imgs/arrows/arrowDown.png");
                arrow.translate(0,20);

                row = arrow.getY();
                break;

            case LEFT:
                arrow.load("imgs/arrows/arrowLeft.png");
                arrow.translate(-20,0);
                col = arrow.getX();
                break;

            case RIGHT:
                arrow.load("imgs/arrows/arrowRight.png");
                arrow.translate(20,0);
                col = arrow.getX();
                break;

        }
    }

    public void setDoneDamageTrue(){
        hasDoneDamage = true;
    }
    public boolean hasdoneDamage(){
        return hasDoneDamage;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public void setCol(int col){
        this.col = col;
    }

    public void setRow(int row){
        this.row = row;
    }


    public void arrowDelete(){
        try{
            arrow.delete();
            arrow = new Picture(10, 10, "imgs/arrows/arrowUp.png");
        } catch (ConcurrentModificationException e){
            System.out.println("delete arrow fast fetcher exception");
        }
    }

    public void hit(){
    }

    public void translateLeft(){
        arrow.translate(-50,0);
    }


}
