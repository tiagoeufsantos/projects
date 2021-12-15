package org.academiadecodigo.spaceintvaders;

import org.academiadecodigo.simplegraphics.graphics.Color;
//import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.hero.Direction;
import org.academiadecodigo.spaceintvaders.hero.Hero;
import org.academiadecodigo.spaceintvaders.hero.OldLady;
import org.academiadecodigo.spaceintvaders.hero.Prince;
//import org.academiadecodigo.spaceintvaders.roomFive.RoomFive;
import org.academiadecodigo.spaceintvaders.roomFive.RoomFive;
import org.academiadecodigo.spaceintvaders.roomFive.ShootingFireball;
import org.academiadecodigo.spaceintvaders.roomFour.RoomFour;
import org.academiadecodigo.spaceintvaders.roomOne.RoomOne;
import org.academiadecodigo.spaceintvaders.roomthree.RoomThree;
import org.academiadecodigo.spaceintvaders.roomtwo.RoomTwo;
import org.academiadecodigo.spaceintvaders.uielements.UiElements;
//import java.awt.Rectangle;

public class JavaGame implements KeyboardHandler {

    public static final int NUMBER_OF_WALLS = 35;
    public static final int MOVEMENT = 10;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle canvas;
    //private org.academiadecodigo.simplegraphics.graphics.Rectangle background;
    private Picture bg;
    private boolean prince02HasMoved;
    private boolean princeIsGone;

    private boolean spaceStartsTheGame;

    private int counterSound = 0;

    private org.academiadecodigo.simplegraphics.graphics.Rectangle topWall;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle bottomWall;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle leftWall;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle rightWall;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle wall01A;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle wall01B;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle wall01Left;
    //private org.academiadecodigo.simplegraphics.graphics.Rectangle wall01Right;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle wall02;
    //private org.academiadecodigo.simplegraphics.graphics.Rectangle wall02Top;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle wall02Bottom;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle wall03;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle wall03Top;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle wall03Bottom;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle labyrinthWall01;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle labyrinthWall02;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle labyrinthWall03;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle labyrinthWall04;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle labyrinthWall05;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle labyrinthWall06;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle labyrinthWall07;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle labyrinthWall08;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle labyrinthWall09;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle labyrinthWall10;
    private org.academiadecodigo.simplegraphics.graphics.Rectangle labyrinthWall11;

    private Rectangle labyrinthWall12;
    private Rectangle labyrinthWall13;
    private Rectangle labyrinthWall14;
    private Rectangle labyrinthWall15;
    private Rectangle labyrinthWall16;
    private Rectangle labyrinthWall17;
    private Rectangle labyrinthWall18;

    private java.awt.Rectangle futureHero; /** this is new*/
    private java.awt.Rectangle futurePrince; /** this too*/

    private Rectangle roomFiveLeftBlock;
    private Rectangle roomFiveRightBlock;

    //private Rectangle endScreen = new Rectangle(10, 10, 1280, 720);
    private Picture endScreen = new Picture (10,10, "/imgs/winningScreen/won.png");

    private Picture hero;
    private java.awt.Rectangle heroBounds;
    private Hero hero2;

    private Picture prince;
    private Prince prince01;
    private Prince prince02;
    private Prince prince03;
    private java.awt.Rectangle princeBounds;

    private ShootingFireball shootingFireball;



    private Picture prince01Picture;
    private OldLady oldLady;

    //private Picture oldLadyPicture;




    private org.academiadecodigo.simplegraphics.graphics.Rectangle walls[];


    private RoomOne roomOne;
    private RoomTwo roomTwo;
    private RoomThree roomThree;
    private RoomFour roomFour;
    private RoomFive roomFive;
    private boolean shooting;

    private UiElements fog;
    //private UiElements rock;

    private UiElements princessTeleport;
    private UiElements princeTeleport;

    private UiElements tiredKnight;
    private UiElements rainbowHeart;

    private boolean canMoveRight;
    private boolean canMoveleft;
    private boolean canMoveUp;
    private boolean canMoveDown;



    private Direction lastDir;

    public Direction setLastDir(){
        return lastDir;
    };

    // HERO STUFF
/*    public void drawHero() {
        hero = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1260, 700, 20, 20);
        hero.setColor(Color.PINK);
        hero.fill();
    }  */

    public void drawHero() {
        hero = hero2.getHero();


        //hero.setColor(Color.PINK);
        hero.draw();
    }

    public void drawPrince() {
        prince = prince02.getHero();
        prince.draw();
    }

    public void drawPrince01() {
        prince01Picture = prince01.getHero();
        prince01Picture.draw();

    }


    private void drawPrince03() {
        prince03.getHero().draw();

    }

    public void showOldLady() {
        oldLady.getOldLady().draw();
        oldLady.oldLadyGetBounds();
    }

    public void wheresHero() {
        //System.out.println("X: " + hero.getX());
        //System.out.println("Y: " + hero.getY());
    }

    public int wheresHeroX() {
        return hero.getX();
    }

    public int wheresHeroY() {
        return hero.getY();
    }

    public java.awt.Rectangle getHeroBounds() {
        return new java.awt.Rectangle(hero.getX(), hero.getY(), hero.getWidth(), hero.getHeight());
    }

    public java.awt.Rectangle getPrinceBounds() {
        return new java.awt.Rectangle(prince01Picture.getX(), prince01Picture.getY(), prince01Picture.getWidth(), prince01Picture.getHeight());
    }

// NEW STUFF

    public void moveS(){

        wheresHero();
        futureHero = getHeroBounds();
        futurePrince = getPrinceBounds();
        try {
            hero.load("/imgs/princess_down.PNG");

        } catch(java.util.ConcurrentModificationException e) {
            hero.load("/imgs/princess_down.PNG");
        }
        //System.out.println(prince01Picture.getX());
        //System.out.println(prince01Picture.getY());
        hero.load("/imgs/princess_down.PNG");
        //  hero.draw();

        if (hero.getY() >= 10 && hero.getY() <= 700) {

            futureHero.translate(0, MOVEMENT);
            for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                if (futureHero.intersects(getWallBounds(walls[i]))) {
                    return;
                }
            }
            hero.translate(0, MOVEMENT);
            hero2.setLastDir(Direction.DOWN);
            if ((hero.getX() >= 1080) && (wheresHeroY() >= 380)) {
                //System.out.println("ORKINGW");
                futurePrince.translate(0, MOVEMENT);
                for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                    if (futurePrince.intersects(getWallBounds(walls[i]))) {
                        return;
                    }
                }
                prince01Picture.translate(0, MOVEMENT);
            }
        }
    }


    public void moveD(){
        wheresHero();
        futureHero = getHeroBounds();
        futurePrince = getPrinceBounds();
        try {
            hero.load("/imgs/princess_right.PNG");

        } catch(java.util.ConcurrentModificationException e) {
            hero.load("/imgs/princess_right.PNG");
        }
        //System.out.println(prince01Picture.getX());
        //System.out.println(prince01Picture.getY());
        //hero.load("/imgs/princess_right.PNG");
        //hero.draw();*/

        if (hero.getX() >= 10 && hero.getX() <= 1260) {
            futureHero.translate(MOVEMENT, 0);
            for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                if (futureHero.intersects(getWallBounds(walls[i]))) {
                    return;
                }
            }
            hero.translate(MOVEMENT, 0);
            hero2.setLastDir(Direction.RIGHT);
            if ((hero.getX() >= 1080) && (wheresHeroY() >= 380)) {
                //System.out.println("ORKINGW");
                futurePrince.translate(-MOVEMENT, 0);
                for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                    if (futurePrince.intersects(getWallBounds(walls[i]))) {
                        return;
                    }
                }
                prince01Picture.translate(-MOVEMENT, 0);
            }
        }
    }

    public void moveW(){

        wheresHero();
        futureHero = getHeroBounds();
        futurePrince = getPrinceBounds();
        try {
            hero.load("/imgs/princess_up.PNG");

        } catch(java.util.ConcurrentModificationException e) {
            hero.load("/imgs/princess_up.PNG");
        }
        //System.out.println(prince01Picture.getX());
        //System.out.println(prince01Picture.getY());
        //hero.load("/imgs/princess_up.PNG");
        //hero.draw();

        if (hero.getY() >= 20 && hero.getY() <= 710) {
            futureHero.translate(0,-(MOVEMENT));
            for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                if (futureHero.intersects(getWallBounds(walls[i]))) {
                    return;
                }
            }
            hero.translate(0, -(MOVEMENT));
            hero2.setLastDir(Direction.UP);
            if ((hero.getX() >= 1080) && (wheresHeroY() >= 380)) {
                //System.out.println("ORKINGW");
                futurePrince.translate(0, -MOVEMENT);
                for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                    if (futurePrince.intersects(getWallBounds(walls[i]))) {
                        return;
                    }
                }
                prince01Picture.translate(0, -MOVEMENT);
            }

        }

    }

    public void moveA(){
        wheresHero();
        futureHero = getHeroBounds();
        futurePrince = getPrinceBounds();
        try {
            hero.load("/imgs/princess_left.PNG");

        } catch(java.util.ConcurrentModificationException e) {
            hero.load("/imgs/princess_left.PNG");
        }
        //System.out.println(prince01Picture.getX());
        //System.out.println(prince01Picture.getY());
        //hero.load("/imgs/princess_left.PNG");
        //hero.draw();*/

        if (hero.getX() >= 20 && hero.getX() <= 1290) {
            futureHero.translate(-(MOVEMENT), 0);
            for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                if (futureHero.intersects(getWallBounds(walls[i]))) {
                    return;
                }
            }
            hero.translate(-(MOVEMENT), 0);
            hero2.setLastDir(Direction.LEFT);
            if ((hero.getX() >= 1080) && (wheresHeroY() >= 380)) {
                //System.out.println("ORKINGW");
                futurePrince.translate(MOVEMENT, 0);
                for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                    if (futurePrince.intersects(getWallBounds(walls[i]))) {
                        return;
                    }
                }
                prince01Picture.translate(MOVEMENT, 0);
            }
        }
    }

    // NEW STUFF END
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {



        /**
         * Key S
         */
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {

            canMoveDown = true;
            /*
            wheresHero();
            try {
                hero.load("/imgs/princess_down.PNG");

            } catch(java.util.ConcurrentModificationException e) {
                hero.load("/imgs/princess_down.PNG");
            }
            System.out.println(prince01Picture.getX());
            System.out.println(prince01Picture.getY());
            hero.load("/imgs/princess_down.PNG");
            //  hero.draw();

            if (hero.getY() >= 10 && hero.getY() <= 700) {

                futureHero.translate(0, MOVEMENT);
                for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                    if (futureHero.intersects(getWallBounds(walls[i]))) {
                        return;
                    }
                }
                hero.translate(0, MOVEMENT);
                hero2.setLastDir(Direction.DOWN);
                if ((hero.getX() >= 1080) && (wheresHeroY() >= 380)) {
                    System.out.println("ORKINGW");
                    futurePrince.translate(0, MOVEMENT);
                    for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                        if (futurePrince.intersects(getWallBounds(walls[i]))) {
                            return;
                        }
                    }
                    prince01Picture.translate(0, MOVEMENT);
                }
            } */
        }

        /**
         * Key W
         */
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {

            canMoveUp = true;
            /*wheresHero();
            try {
                hero.load("/imgs/princess_up.PNG");

            } catch(java.util.ConcurrentModificationException e) {
                hero.load("/imgs/princess_up.PNG");
            }
            System.out.println(prince01Picture.getX());
            System.out.println(prince01Picture.getY());
            //hero.load("/imgs/princess_up.PNG");
            //hero.draw();

            if (hero.getY() >= 20 && hero.getY() <= 710) {
                futureHero.translate(0,-(MOVEMENT));
                for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                    if (futureHero.intersects(getWallBounds(walls[i]))) {
                        return;
                    }
                }
                hero.translate(0, -(MOVEMENT));
                hero2.setLastDir(Direction.UP);
                if ((hero.getX() >= 1080) && (wheresHeroY() >= 380)) {
                    System.out.println("ORKINGW");
                    futurePrince.translate(0, -MOVEMENT);
                    for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                        if (futurePrince.intersects(getWallBounds(walls[i]))) {
                            return;
                        }
                    }
                    prince01Picture.translate(0, -MOVEMENT);
                }

            } */
        }

        /**
         * Key A
         */
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {

            canMoveleft = true;
            /* wheresHero();
            try {
                hero.load("/imgs/princess_left.PNG");

            } catch(java.util.ConcurrentModificationException e) {
                hero.load("/imgs/princess_left.PNG");
            }
            System.out.println(prince01Picture.getX());
            System.out.println(prince01Picture.getY());
            //hero.load("/imgs/princess_left.PNG");
            //hero.draw();

            if (hero.getX() >= 20 && hero.getX() <= 1290) {
                futureHero.translate(-(MOVEMENT), 0);
                for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                    if (futureHero.intersects(getWallBounds(walls[i]))) {
                        return;
                    }
                }
                hero.translate(-(MOVEMENT), 0);
                hero2.setLastDir(Direction.LEFT);
                if ((hero.getX() >= 1080) && (wheresHeroY() >= 380)) {
                    System.out.println("ORKINGW");
                    futurePrince.translate(MOVEMENT, 0);
                    for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                        if (futurePrince.intersects(getWallBounds(walls[i]))) {
                            return;
                        }
                    }
                    prince01Picture.translate(MOVEMENT, 0);
                }
            } */
        }

        /**
         * Key D
         */

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            canMoveRight = true;
            /*
            wheresHero();
            try {
                hero.load("/imgs/princess_right.PNG");

            } catch(java.util.ConcurrentModificationException e) {
                hero.load("/imgs/princess_right.PNG");
            }
            System.out.println(prince01Picture.getX());
            System.out.println(prince01Picture.getY());
            //hero.load("/imgs/princess_right.PNG");
            //hero.draw();

            if (hero.getX() >= 10 && hero.getX() <= 1260) {
                futureHero.translate(MOVEMENT, 0);
                for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                    if (futureHero.intersects(getWallBounds(walls[i]))) {
                        return;
                    }
                }
                hero.translate(MOVEMENT, 0);
                hero2.setLastDir(Direction.RIGHT);
                if ((hero.getX() >= 1080) && (wheresHeroY() >= 380)) {
                    System.out.println("ORKINGW");
                    futurePrince.translate(-MOVEMENT, 0);
                    for (int i = 0; i < NUMBER_OF_WALLS; i++) {
                        if (futurePrince.intersects(getWallBounds(walls[i]))) {
                            return;
                        }
                    }
                    prince01Picture.translate(-MOVEMENT, 0);
                }
            }
            */
        }



        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {

            spaceStartsTheGame = true;

            fog.setGameStartTrue();

            if(!(hero.getY() > 390 && hero.getX() < 870)){
                if(!(hero.getX() < 430 && hero.getX() > 1)){
                    arrowInputLogic();
                }}


        }


    }

    public void arrowInputLogic(){
        shooting = hero2.arrowInputLogic();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            canMoveUp = false;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            canMoveDown = false;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            canMoveleft = false;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            canMoveRight = false;
        }

    }


    // WALL STUFF



    public java.awt.Rectangle getWallBounds(org.academiadecodigo.simplegraphics.graphics.Rectangle wall) {
        return new java.awt.Rectangle(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
    }

    public void topWallDraw() {
        topWall = new org.academiadecodigo.simplegraphics.graphics.Rectangle(10, 10, 1280, 10);
        topWall.setColor(Color.GRAY);
        //topWall.fill();
    }

    public void bottomWallDraw() {
        bottomWall = new org.academiadecodigo.simplegraphics.graphics.Rectangle(10, 720, 1280, 10);
        bottomWall.setColor(Color.GRAY);
        //bottomWall.fill();
    }

    public void leftWallDraw() {
        leftWall = new org.academiadecodigo.simplegraphics.graphics.Rectangle(10, 10, 10, 720);
        leftWall.setColor(Color.GRAY);
        //leftWall.fill();
    }

    public void rightWallDraw() {
        rightWall = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1280, 10, 10, 720);
        rightWall.setColor(Color.GRAY);
        //rightWall.fill();
    }

    public void drawWall01A() {
        wall01A = new org.academiadecodigo.simplegraphics.graphics.Rectangle(150, 370, 430, 10);
        wall01A.setColor(Color.GRAY);
        //wall01A.fill();
    }

    // Other borders

    public void drawWall01B() {
        wall01B = new org.academiadecodigo.simplegraphics.graphics.Rectangle(720, 370, 580, 10);
        wall01B.setColor(Color.GRAY);
        //wall01B.fill();
    }

    public void drawWall01Left() {
        wall01Left = new org.academiadecodigo.simplegraphics.graphics.Rectangle(10, 370, 30, 10);
        wall01Left.setColor(Color.GRAY);
        //wall01Left.fill();
    }

/*    public void drawWall01Right() {
        wall01Right = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1240, 370, 40, 10);
        wall01Right.setColor(Color.GRAY);
        wall01Right.fill();
    }*/

    public void drawWall02() {
        wall02 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(430, 10, 10, 610);
        wall02.setColor(Color.GRAY);
        //wall02.fill();
    }

/*    public void drawWall02Top() {
        wall02Top = new org.academiadecodigo.simplegraphics.graphics.Rectangle(430, 10, 10, 50);
        wall02Top.setColor(Color.GRAY);
        wall02Top.fill();
    }*/

    public void drawWall02Bottom() {
        wall02Bottom = new org.academiadecodigo.simplegraphics.graphics.Rectangle(430, 690, 10, 30);
        wall02Bottom.setColor(Color.GRAY);
        //wall02Bottom.fill();
    }


    public void drawWall03() {
        wall03 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(870, 100, 10, 630);
        wall03.setColor(Color.GRAY);
        //wall03.fill();
    }

    public void drawWall03Top() {
        wall03Top = new org.academiadecodigo.simplegraphics.graphics.Rectangle(870, 10, 10, 100);
        wall03Top.setColor(Color.GRAY);
        //wall03Top.fill();
    }

    public void drawWall03Bottom() {
        wall03Bottom = new org.academiadecodigo.simplegraphics.graphics.Rectangle(879, 370, 10, 360);
        wall03Bottom.setColor(Color.GRAY);
        //wall03Bottom.fill();
    }

    // Labyrinth Walls

    public void labyrinthWall01() {
        labyrinthWall01 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1080, 380, 9, 300);
        //labyrinthWall01.setColor(Color.GRAY);
        //labyrinthWall01.fill();
    }

    public void labyrinthWall02() {
        labyrinthWall02 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(930, 420, 310, 10);
        //labyrinthWall02.setColor(Color.GRAY);
        //labyrinthWall02.fill();
    }

    public void labyrinthWall03() {
        labyrinthWall03 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(880, 470, 90, 10);
        //labyrinthWall03.setColor(Color.GRAY);
        //labyrinthWall03.fill();
    }

    public void labyrinthWall04() {
        labyrinthWall04 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1010, 470, 20, 10);
        //labyrinthWall04.setColor(Color.GRAY);
        //labyrinthWall04.fill();
    }

    public void labyrinthWall05() {
        labyrinthWall05 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(930, 520, 100, 10);
        //labyrinthWall05.setColor(Color.GRAY);
        //labyrinthWall05.fill();
    }

    public void labyrinthWall06() {
        labyrinthWall06 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(880, 570, 60, 10);
        //labyrinthWall06.setColor(Color.GRAY);
        //labyrinthWall06.fill();
    }

    public void labyrinthWall07() {
        labyrinthWall07 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(940, 620, 60, 10);
        //labyrinthWall07.setColor(Color.GRAY);
        //labyrinthWall07.fill();
    }

    public void labyrinthWall08() {
        labyrinthWall08 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1000, 570, 30, 10);
        //labyrinthWall08.setColor(Color.GRAY);
        //labyrinthWall08.fill();
    }

    public void labyrinthWall09() {
        labyrinthWall09 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(940, 670, 200, 10);
        //labyrinthWall09.setColor(Color.GRAY);
        //labyrinthWall09.fill();
    }

    public void labyrinthWall10() {
        labyrinthWall10 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(940, 570, 10, 60);
        //labyrinthWall10.setColor(Color.GRAY);
        //labyrinthWall10.fill();
    }

    public void labyrinthWall11() {
        labyrinthWall11 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(990, 570, 10, 60);
        //labyrinthWall11.setColor(Color.GRAY);
        //labyrinthWall11.fill();
    }

    // PRINCESS SIDE
    public void labyrinthWall12() {
        labyrinthWall12 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1200, 470, 80, 10);
        //labyrinthWall12.setColor(Color.GREEN);
        //labyrinthWall12.fill();
    }

    public void labyrinthWall13() {
        labyrinthWall13 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1130, 470, 30, 10);
        //labyrinthWall13.setColor(Color.GREEN);
        //labyrinthWall13.fill();
    }

    public void labyrinthWall14() {
        labyrinthWall14 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1130, 520, 110, 10);
        //labyrinthWall14.setColor(Color.GREEN);
        //labyrinthWall14.fill();
    }

    public void labyrinthWall15() {
        labyrinthWall15 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1220, 570, 20, 10);
        //labyrinthWall15.setColor(Color.PINK);
        //labyrinthWall15.fill();
    }

    public void labyrinthWall16() {
        labyrinthWall16 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1089, 570, 90, 10);
        //labyrinthWall16.setColor(Color.PINK);
        //labyrinthWall16.fill();
    }

    public void labyrinthWall17() {
        labyrinthWall17 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1140, 620, 140, 10);
        //labyrinthWall17.setColor(Color.PINK);
        //labyrinthWall17.fill();
    }

    public void labyrinthWall18() {
        labyrinthWall18 = new org.academiadecodigo.simplegraphics.graphics.Rectangle(1180, 670, 60, 10);
        //labyrinthWall18.setColor(Color.BLUE);
        //labyrinthWall18.fill();
    }

    // ROOM FIVE BLOCKS

    public void roomFiveLeftBlock() {
        roomFiveLeftBlock = new Rectangle(440,380, 150,250);
        //roomFiveLeftBlock.setColor(Color.GREEN);
        //roomFiveLeftBlock.fill();
    }

    public void roomFiveRightBlock() {
        roomFiveRightBlock = new Rectangle(720,380, 150,250);
        //roomFiveRightBlock.setColor(Color.GREEN);
        //roomFiveRightBlock.fill();
    }


    // CANVAS STUFF
    public void drawCanvas() {
        canvas = new org.academiadecodigo.simplegraphics.graphics.Rectangle(0, 0, 1300, 740);
        canvas.setColor(Color.GRAY);
        canvas.fill();
    }

    // BACKGROUND STUFF
/*    public void drawBackground() {
        background = new org.academiadecodigo.simplegraphics.graphics.Rectangle(10, 10, 1280, 720);
        background.setColor(Color.WHITE);
        background.fill();
    }*/

        public void drawBackground() {
        bg = new Picture(10, 10, "imgs/backgrounds/bg.JPEG");
        //background.setColor(Color.WHITE);
        //background.fill();
            bg.draw();
    }

/*    public java.awt.Rectangle getBackgroundBounds() {
        return new java.awt.Rectangle(background.getX(), background.getY(), background.getWidth(), background.getHeight());
    }*/

    public java.awt.Rectangle getBackgroundBounds() {
        return new java.awt.Rectangle(bg.getX(), bg.getY(), bg.getWidth(), bg.getHeight());
    }




public void endScreen() {
        endScreen.draw();

    //endScreen.setColor(Color.PINK);
    //endScreen.fill();
}


    public void playSong(){
        if(counterSound <= 0) {
            new SoundClipTest("imgs/_sounds/VintageBack.wav");
            counterSound = 1010;
        }
        counterSound--;
    }

    public JavaGame() {
        spaceStartsTheGame = false;
        canMoveRight = false;
        canMoveleft = false;
        canMoveUp = false;
        canMoveDown = false;
        shooting = false;
        shooting = false;



        //drawCanvas();
        drawBackground();
        //drawCanvas();
        topWallDraw();
        bottomWallDraw();
        leftWallDraw();
        rightWallDraw();
        drawWall01A();
        drawWall01B();
        drawWall01Left();
        //drawWall01Right();
        drawWall02();
        //drawWall02Top();
        drawWall02Bottom();
        drawWall03();
        drawWall03Top();
        drawWall03Bottom();
        labyrinthWall01();
        labyrinthWall02();
        labyrinthWall03();
        labyrinthWall04();
        labyrinthWall05();
        labyrinthWall06();
        labyrinthWall07();
        labyrinthWall08();
        labyrinthWall09();
        labyrinthWall10();
        labyrinthWall11();
        labyrinthWall12();
        labyrinthWall13();
        labyrinthWall14();
        labyrinthWall15();
        labyrinthWall16();
        labyrinthWall17();
        labyrinthWall18();

        roomFiveLeftBlock();
        roomFiveRightBlock();


        walls = new Rectangle[NUMBER_OF_WALLS];
        walls[0] = topWall;
        walls[1] = bottomWall;
        walls[2] = leftWall;
        walls[3] = rightWall;
        walls[4] = wall01A;
        walls[5] = wall01B;
        walls[6] = wall01Left;
        //walls[7] = wall01Right;
        walls[7] = wall02;
        //walls[9] = wall02Top;
        walls[8] = wall02Bottom;
        walls[9] = wall03;
        walls[10] = wall03Top;
        walls[11] = labyrinthWall01;
        walls[12] = labyrinthWall02;
        walls[13] = labyrinthWall03;
        walls[14] = labyrinthWall04;
        walls[15] = labyrinthWall05;
        walls[16] = labyrinthWall06;
        walls[17] = labyrinthWall07;
        walls[18] = labyrinthWall07;
        walls[19] = labyrinthWall08;
        walls[20] = labyrinthWall09;
        walls[21] = labyrinthWall10;
        walls[22] = labyrinthWall11;
        walls[23] = labyrinthWall12;
        walls[24] = labyrinthWall13;
        walls[25] = labyrinthWall14;
        walls[26] = labyrinthWall15;
        walls[27] = labyrinthWall16;
        walls[28] = labyrinthWall17;
        walls[29] = labyrinthWall18;
        walls[30] = roomFiveLeftBlock;
        walls[31] = roomFiveRightBlock;

        //shootingFireball.bigFireBallArray();
        //shootingFireball.getArray();




        //walls[12] = wall03Bottom;

        hero2 = new Hero();

        roomOne = new RoomOne(hero2);
        roomTwo = new RoomTwo(hero2);
        roomThree = new RoomThree(hero2);
        roomFour = new RoomFour(hero2);
        roomFive = new RoomFive(hero2);

        fog = new UiElements(hero2);
/*        rock = new UiElements(hero2);
        princessTeleport = new UiElements(hero2);
        princeTeleport = new UiElements(hero2);
        tiredKnight = new UiElements(hero2);
        rainbowHeart = new UiElements(hero2);*/


        //walls[3] = wall01;
        drawHero();
        prince01 = new Prince(1040,380);
        drawPrince01();
        prince01.getHero().delete();
        prince02 = new Prince(-2080,-2060);
        drawPrince();
        prince03 = new Prince(390, 60);

        drawPrince03();
        getHeroBounds();
        getPrinceBounds();

        oldLady = new OldLady();
        showOldLady();

        walls[32] = oldLady.getOldLadyBounds();
        walls[33] = roomOne.getRockBounds();
        walls[34] = fog.tiredKnightBounds();
        //walls[35] = rainbowHeart.rainbowHeartBounds();





        //
        //fog.drawRock();

        fog.drawPrincessTeleport();
        fog.drawtiredKnight();
        prince02HasMoved = false;





        //getWall01Bounds();


    }

    public void start() throws InterruptedException {
        while(true) {



            if(spaceStartsTheGame) {
                if (canMoveRight) {
                    moveD();
                }
                if (canMoveleft) {
                    moveA();
                    //System.out.println("move A");
                }
                if (canMoveDown) {
                    moveS();
                }
                if (canMoveUp) {
                    moveW();
                }
            }

            Thread.sleep(50);
            playSong();
            roomTwo.moveAll();
            roomThree.moveAll();
            fog.getBossHp(roomThree.getBossHp());
            fog.drawPrinceTeleport();
            roomFour.moveAll();
            roomFive.moveAll();
            roomOne.triggerRockAction();

            while((hero.getX() == 220 && hero.getY() == 210)) {
                oldLady.oldLadySpeaks();
                hero.translate(-10,0);
            }

            while((hero.getX() >= 760 && hero.getX() <= 800) && hero.getY() >= 620) {
                roomFive.tiredKnightSpeaks();

                hero.translate(-10,0);
            };

            if((hero.getX() >= 1040 && hero.getX() <= 1100) && (hero.getY() >= 230 && hero.getY() >= 270)) {
                roomThree.bossSpeaks();
                if(!prince02HasMoved) {
                    prince02.getHero().translate(2960, 2120);
                    prince02.getHero().delete();
                    prince02.getHero().draw();

                    prince02HasMoved = true;
                }


                if (roomThree.hasBossSpoken() == false) {
                    hero.translate(0, -40);
                    roomThree.setHasBossSpoken();
                }
            };

            if(((hero.getX() >= 620) && (hero.getX() <= 650)) && ((hero.getY() >= 510) && (hero.getY() <= 540))) {
                if (roomFive.isArrowPresent() == true) {
                    //System.out.println("IM HERE ARROW TAKE ME AWAY");
                    roomFive.deleteArrow();
                }
            }

            if(roomThree.getBossHp() <= -1) {
                roomThree.teleportToBinaryLand();

                if(fog.deletePrince()){
                    prince02.getHero().delete();
                }
            }

            fog.drawfog();



            if (shooting) {
                hero2.arrowMove();
            }

            if((hero.getX() == 1090 && hero.getY() == 380)) {

                roomThree.setCanMoveFalse();
                prince01.getHero().draw();

            }

            if(roomOne.hasPrinceBeenRocked()) {
                while(!princeIsGone) {
                    prince03.getHero().translate(10, 0);
                    Thread.sleep(30);
                    prince03.getHero().translate(10, 0);
                    Thread.sleep(30);
                    prince03.getHero().translate(10, 0);
                    Thread.sleep(30);

                    princeIsGone = true;
                }
                prince03.getHero().delete();
            }


            if(((hero.getX() >= 1210 && hero.getX() <= 1260) && (hero.getY() == 380))) {

                roomThree.setLabyrinthExplanation();
                roomThree.setCanMoveFalse();
            }


            if((hero.getX() <= 1100 && hero.getY() == 680) && ((prince01Picture.getX() >= 1020) && (prince01Picture.getY() == 680))) {
                endScreen();


            }




        }
    }





}
