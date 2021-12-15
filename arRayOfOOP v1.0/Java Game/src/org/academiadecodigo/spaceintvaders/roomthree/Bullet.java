package org.academiadecodigo.spaceintvaders.roomthree;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.Enemy;
import org.academiadecodigo.spaceintvaders.hero.Hero;

import java.util.ConcurrentModificationException;

public class Bullet {
    private Picture bullet;
    private int row;
    private int col;
    private Enemy boss;
    private BulletNumber bulletNumber;
    private Hero hero;
    private boolean hasDoneDamage;


    public Bullet(Enemy boss, BulletNumber order, Hero hero) {
        this.boss = boss;
        this.bulletNumber = order;
        setBulletCoordinates(order);
        this.bullet = new Picture(col, row, "imgs/boss/bossBullets.PNG");
        //bullet.setColor(Color.YELLOW);
        this.hero = hero;
        hasDoneDamage = false;
    }


    public void collide(){

        if((hero.getHero().getX() >= (bullet.getX() - 30))){ // esquerda da bullet
            if((hero.getHero().getX() <= (bullet.getX() + 5))){ // direita da bullet
                if(hero.getHero().getY() > (bullet.getY() - 15 )){
                    if(hero.getHero().getY() < (bullet.getY()) + 1){
                        if(!hasDoneDamage) {
                            hero.beHit();
                            //System.out.println("hit by a bullet!");
                            hasDoneDamage = true;
                        }
                    }
                }

            }

        }
    }




    public void setBulletCoordinates(BulletNumber order) {
        switch (order) {
            case FIRST:
                this.col = boss.getCol() + 20;
                this.row = boss.getRow() + 50;
                break;

            case SECOND:
                this.col = boss.getCol() + 20;
                this.row = boss.getRow() + 50;
                break;

            case THIRD:
                this.col = boss.getCol() + 20;
                this.row = boss.getRow() + 50;
                break;

            case FOURTH:
                this.col = boss.getCol() + 20;
                this.row = boss.getRow() + 50;
                break;

        }
    }

    public void delete(){
        bullet.delete();
    }


    public void move(){
        try{
            //bullet.fill();
            bullet.draw();
            bullet.translate(0,10);
            row = bullet.getY();
            col = bullet.getX();
            collide();
        } catch(ConcurrentModificationException e){
            System.out.println("e");
        }
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

}
