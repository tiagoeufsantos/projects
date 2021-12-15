package org.academiadecodigo.spaceintvaders.roomtwo;

import org.academiadecodigo.spaceintvaders.hero.Hero;

public class RoomTwo {
    Hero hero;
    Fireball fireball1;
    Fireball fireball2;
    Fireball fireball3;
    Fireball fireball4;
    private int showCounter;
    private int delCounter;



    public RoomTwo(Hero hero){
        this.hero = hero;
        fireball1 = new Fireball(hero, FireballNumber.FIRST);
        fireball2 = new Fireball(hero, FireballNumber.SECOND);
        fireball3 = new Fireball(hero, FireballNumber.THIRD);
        fireball4 = new Fireball(hero, FireballNumber.FOURTH);
        showCounter = 0;
        delCounter = 0;

    }

    public void moveAll(){



        if ((hero.getHero().getX() < 390) || (hero.getHero().getX() > 830) || (hero.getHero().getY() > 340) ) {
            if(showCounter == 0) {
                //System.out.println("show3");
                fireball1.fireballDel();
                fireball2.fireballDel();
                fireball3.fireballDel();
                fireball4.fireballDel();
                showCounter = 10;
            }
            showCounter--;
        } else {
            if(delCounter == 0) {
                //System.out.println("del");
                fireball1.fireballShow();
                fireball2.fireballShow();
                fireball3.fireballShow();
                fireball4.fireballShow();

                delCounter = 10;
            }
            delCounter--;

        }





        fireball1.move();
        fireball2.move();
        fireball3.move();
        fireball4.move();
    }

}
