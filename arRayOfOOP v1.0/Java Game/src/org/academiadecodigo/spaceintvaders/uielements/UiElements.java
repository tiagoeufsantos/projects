package org.academiadecodigo.spaceintvaders.uielements;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.hero.Hero;

public class UiElements {

    private boolean hasTeleported;

    private Picture gameStart;
    private Picture gameOver;

    private Picture fogR1;
    private Picture fogR2;
    private Picture fogR3;
    private Picture fogR4;
    private Picture fogR5;
    private Picture fogR6;

    private Hero hero;
    private boolean hasGameStart;
    private boolean gameEnded;
    private Picture heart1Full;
    private Picture heart2Full;
    private Picture heart3Full;

    private Picture heart1Half;
    private Picture heart2Half;
    private Picture heart3Half;

    private Picture heart1Empty;
    private Picture heart2Empty;
    private Picture heart3Empty;


    private int resultX;
    private int resultY;
    private int counterDead;

    private int heroHealth;
    private int bossHp;

    private Picture rock;
    private Rectangle rockBounds;

    private Picture princessTeleportSwirl;
    private Picture princeTeleportSwirl;

    private Picture tiredKnight;
    private Rectangle tiredKnightBounds;

    private Picture rainbowHeart;
    private Rectangle rainbowHeartBounds;
    private int drawCounter;

    public UiElements(Hero hero){
        this.hero = hero;
        gameStart = new Picture(10,10,"/imgs/openingScreen/opening.JPEG");
        gameOver = new Picture(10,10,"/imgs/gameOver/gameover.jpeg");

        fogR1 = new Picture(10,10,"/imgs/fog/fogR1.png");
        fogR2 = new Picture(10,370,"/imgs/fog/fogR2.png");
        fogR3 = new Picture(430,10,"/imgs/fog/fogR3.png");
        fogR4 = new Picture(430,370,"/imgs/fog/fogR4.png");
        fogR5 = new Picture(870,10,"/imgs/fog/fogR5.png");
        fogR6 = new Picture(870,370,"/imgs/fog/fogR6.png");
       // rock = new Picture(390,60,"src/imgs/rock/rock.png");
        princessTeleportSwirl = new Picture(640, 60, "/imgs/teleport/princessTeleport.PNG");
        princeTeleportSwirl = new Picture(880, 60, "/imgs/teleport/princeTeleport.PNG");
        tiredKnight = new Picture(800, 650, "imgs/tiredKnight/tiredKnightFront.PNG");
        rainbowHeart = new Picture(1060, 690, "imgs/heartRainbow.PNG");
        rainbowHeart.draw();
        drawCounter = 0;

        this.gameEnded = false;
        this.hasGameStart = false;
        heart1Full = new Picture(20, 20,"/imgs/hearts/heartFull.PNG");
        heart2Full = new Picture(60, 20,"/imgs/hearts/heartFull.PNG");
        heart3Full = new Picture(100, 20,"/imgs/hearts/heartFull.PNG");

        heart1Half = new Picture(20, 20,"/imgs/hearts/heartHalf.PNG");
        heart2Half = new Picture(60, 20,"/imgs/hearts/heartHalf.PNG");
        heart3Half = new Picture(100, 20,"/imgs/hearts/heartHalf.PNG");

        heart1Empty = new Picture(20, 20,"/imgs/hearts/heartEmpty.PNG");
        heart2Empty = new Picture(60, 20,"/imgs/hearts/heartEmpty.PNG");
        heart3Empty = new Picture(100, 20,"/imgs/hearts/heartEmpty.PNG");
        heroHealth = hero.getHp();
        hasTeleported = false;

        counterDead = 40;

    }


    public void drawfog(){

        if(heroHealth != hero.getHp()){
            heroHealth = hero.getHp();
            drawHearts();
            //System.out.println(heroHealth);
        }
        if(drawCounter <= 0) {
            fogR1.draw();
            fogR2.draw();
            fogR3.draw();
            fogR4.draw();
            fogR5.draw();
            fogR6.draw();
            drawCounter = 10;
        }
        drawCounter--;
        if(gameEnded){
            gameOver.draw();
            gameOver.delete();
            gameOver.draw();
            resultX =  60 - hero.getHero().getX();
            resultY =  210 - hero.getHero().getY();
            hero.getHero().translate(resultX,resultY);
            if(counterDead >= 0) {
                counterDead--;
            } else {
                gameEnded = false;
                gameOver.delete();
                counterDead = 50;
            }
        }

        if(!hasGameStart) {
            gameStart.draw();
        } else {
            gameStart.delete();
        }
        deleteFog();
        if(((hero.getHero().getY() > 350 && hero.getHero().getY() < 410) && hero.getHero().getX() < 390) && (hero.getHp() <= 6 && hero.getHp() >= 1)){
            drawHearts();
        }
    }

    public void drawRock() {
        rock.draw();
    }

    public void drawHearts(){
        switch(heroHealth){
            case 6:
                heart1Full.delete();
                heart1Full.draw();
                heart2Full.delete();
                heart2Full.draw();
                heart3Full.delete();
                heart3Full.draw();
                break;
            case 5:
                heart1Full.delete();
                heart1Full.draw();
                heart2Full.delete();
                heart2Full.draw();
                heart3Full.delete();
                heart3Half.delete();
                heart3Half.draw();
                break;

            case 4:
                heart1Full.delete();
                heart1Full.draw();
                heart2Full.delete();
                heart2Full.draw();
                heart3Half.delete();
                heart3Empty.delete();
                heart3Empty.draw();
                break;
            case 3:
                heart2Full.delete();
                heart2Half.draw();
                break;
            case 2:
                heart2Half.delete();
                heart2Empty.draw();
                break;
            case 1:
                heart1Full.delete();
                heart1Half.draw();
                break;

            default:
                heart1Half.delete();
                heart2Empty.delete();
                heart3Empty.delete();
                heart1Full.draw();
                heart2Full.draw();
                heart3Full.draw();
                gameEnded = true;
                hero.setHealth();
                break;
        }


    }

    public void setGameStartTrue(){
        hasGameStart = true;
    }

    public void deleteFog(){
        if((hero.getHero().getX() < 430) && (hero.getHero().getY() > 340)){
            fogR2.delete();
        }

        if((hero.getHero().getX() > 410 && hero.getHero().getX() < 830) && (hero.getHero().getY() > 320)){
            fogR4.delete();
        }

        if((hero.getHero().getX() > 430) && (hero.getHero().getX() < 840)) {
            if (hero.getHero().getY() < 350) {
                fogR3.delete();
            }
        }

        if((hero.getHero().getX() > 840) && (hero.getHero().getX() < 1270)){
            if(hero.getHero().getY() < 330){
                fogR5.delete();
            }
        }

        if((hero.getHero().getX() < 390) && (hero.getHero().getY() < 360)){
            if(hasGameStart) {
                fogR1.delete();
            }
        }

        if((hero.getHero().getX() > 860) && (hero.getHero().getX() < 1260)){
            if(hero.getHero().getY() > 370){
                fogR6.delete();
            }
        }

    }
    public void getBossHp(int hp){
        this.bossHp = hp;
    }

    public void drawPrincessTeleport() {
        princessTeleportSwirl.draw();
    }

    public void drawPrinceTeleport() {

        if(bossHp <= -1) {
            princeTeleportSwirl.draw();

            if(!hasTeleported) {
                hero.getHero().delete();
                hero.getHero().draw();
                hasTeleported = true;
            }

            //System.out.println("HEYEYEYEYEY");

        }



    }

    public boolean deletePrince(){
        if(bossHp <= -1){
            return true;
        } else {
            return false;
        }
    }

    public void drawtiredKnight() {
        tiredKnight.draw();
    }

    public Rectangle tiredKnightBounds() {
        tiredKnightBounds = new Rectangle(tiredKnight.getX(), tiredKnight.getY(), 40, 40);
        return tiredKnightBounds;
    }

/*    public Rectangle rockBounds() {
        rockBounds = new Rectangle(rock.getX(), rock.getY(), 40,40);
        //oldLadyBounds.draw();

        return rockBounds;
    }*/



    public Rectangle rainbowHeartBounds() {
        rainbowHeartBounds = new Rectangle(rainbowHeart.getX(), rainbowHeart.getY(), 40,40);
        //oldLadyBounds.draw();

        return rainbowHeartBounds;
    }

    public Rectangle getRainbowHeartBounds() {
        return rainbowHeartBounds;
    }

}
