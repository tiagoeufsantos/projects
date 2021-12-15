package org.academiadecodigo.spaceintvaders.roomFour;

import org.academiadecodigo.spaceintvaders.hero.Hero;

public class RoomFour {
    Hero hero;
    MovingEnemy movingEnemyOne;
    MovingEnemy movingEnemyTwo;
    MovingEnemy movingEnemyThree;
    MovingEnemy movingEnemyFour;
    MovingEnemy movingEnemyFive;
    MovingEnemy movingEnemySix;

    public RoomFour(Hero hero) {
        this.hero = hero;
        movingEnemyOne = new MovingEnemy(hero, MovingEnemyNumber.ONE);
        movingEnemyTwo = new MovingEnemy(hero, MovingEnemyNumber.TWO);
        movingEnemyThree = new MovingEnemy(hero, MovingEnemyNumber.THREE);
        movingEnemyFour = new MovingEnemy(hero, MovingEnemyNumber.FOUR);
        movingEnemyFive = new MovingEnemy(hero, MovingEnemyNumber.FIVE);
        movingEnemySix = new MovingEnemy(hero, MovingEnemyNumber.SIX);
    }

    public void moveAll() {
        movingEnemyOne.move();
        movingEnemyTwo.move();
        movingEnemyThree.move();
        movingEnemyFour.move();
        movingEnemyFive.move();
        movingEnemySix.move();
    }
}