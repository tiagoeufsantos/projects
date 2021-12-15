package org.academiadecodigo.spaceintvaders.hero;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Prince { // col x, row y
    private Picture prince;
    private int col;
    private int row;
    private int hp;
    private Direction lastDir;


    //X:1170
    //Y:650

    public Prince(int col, int row){
        //this.col = 100;
        //this.row = 650;
        this.col = col;
        this.row = row;
        prince = new Picture(col,row,"imgs/prince/prince_down.PNG");
        prince.draw();
        hp = 3;


    }


    public Picture getHero(){
        return prince;
    }











    public void setLastDir(Direction dir) {
        this.lastDir = dir;
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
        prince.translate(0,-10);
        row = prince.getY();
        col = prince.getX();
        lastDir = Direction.UP;
    }

    public void translateDown(){
        prince.translate(0,10);
        row = prince.getY();
        col = prince.getX();
        lastDir = Direction.DOWN;
    }

    public void translateLeft(){
        prince.translate(-10,0);
        row = prince.getY();
        col = prince.getX();
        lastDir = Direction.LEFT;
    }

    public void translateRight(){
        prince.translate(10,0);
        row = prince.getY();
        col = prince.getX();
        lastDir = Direction.RIGHT;
    }



}
