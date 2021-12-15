package org.academiadecodigo.spaceintvaders;

public interface Enemy {

    public void beHit();

    public int getCol();

    public int getRow();
    public void move();

    public int getHp();
    public void delete();

    public void drawBoss();

}
