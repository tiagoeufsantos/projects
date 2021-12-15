package org.academiadecodigo.spaceintvaders.roomthree;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.Enemy;
import org.academiadecodigo.spaceintvaders.hero.Hero;

public class RoomThree {
    private Enemy boss;
    private Bullet bullet1;
    private Bullet bullet2;
    private Bullet bullet3;
    private Bullet bullet4;
    private boolean bullet2CanGo;
    private boolean bullet3CanGo;
    private boolean bullet4CanGo;
    private Hero hero;
    private Torch torchSet1;
    private Torch torchSet2;
    private boolean bossSpawn;
    private boolean statuesNotSpawned;
    private Picture penta1;
    private Picture penta2;
    private Picture penta3;
    private Picture penta4;
    private boolean bossSpawned;
    private boolean canMove;
    private Picture fogNoTransp;

    private boolean labyrinthHasntBeenExplained = true;
    private Picture labyrinthExplanation;

    private Picture bossTalkBox;
    private boolean hasBossSpoken = false;

    public RoomThree(Hero hero) {
        boss = new Boss(hero);
        bullet2CanGo = false;
        bullet3CanGo = false;
        bullet4CanGo = false;
        bossSpawn = false;
        this.hero = hero;
        bullet1 = new Bullet(boss, BulletNumber.FIRST, hero);
        torchSet1 = new Torch(880, 140, hero);
        torchSet2 = new Torch(880, 260, hero);
        bossSpawn = false;
        statuesNotSpawned = true;
        penta1 = new Picture(880,150,"/imgs/skeleton/penta.png");
        penta2 = new Picture(880, 270, "/imgs/skeleton/penta.png");
        penta3 = new Picture(880 + 360, 150, "/imgs/skeleton/penta.png");
        penta4 = new Picture(880 + 360, 270, "/imgs/skeleton/penta.png");

        fogNoTransp = new Picture(870,10,"/imgs/fog/fog5noTransp.jpg");

    }

    public int getBossHp(){
        return boss.getHp();
    }


    public void moveAll() {
        teleport();

        if(hero.getHero().getX() < 840 && bossSpawn){
            canMove = false;
            fogNoTransp.draw();
        }

        if((hero.getHero().getX() > 840 && hero.getHero().getY() < 340) /*&& !(bossSpawn)*/ ){
            canMove = true;
            //System.out.println("setting true 1");
            fogNoTransp.delete();
        }

        if(canMove){
        if (bossSpawn){
            if(!bossSpawned) {
                boss.drawBoss();
                bossSpawned = true;
                //System.out.println("setting true 2");
            }

            if(boss.getHp() <= 3 && statuesNotSpawned){
                torchSet1.drawStatues();
                torchSet2.drawStatues();
                statuesNotSpawned = false;
            }

        }

        firstPhase();
        secondPhase1();
        secondPhase2();
        }

    }

    public void setCanMoveFalse(){
        canMove = false;
    }


    public void teleport(){
        int resultX = 1080 - hero.getHero().getX();
        int resultY = 300 - hero.getHero().getY();

        if(hero.getHero().getX() > 550 && hero.getHero().getX() < 670){
            if(hero.getHero().getY() > 50 && hero.getHero().getY() < 70){
                hero.getHero().translate(resultX,resultY);
                try{
                    hero.getHero().delete();
                    Thread.sleep(50);
                    hero.getHero().draw();
                    hero.getHero().delete();
                    Thread.sleep(50);
                    hero.getHero().draw();
                } catch(InterruptedException e){
                    System.out.println("Thread thing");
                }

            }
        }

        if(hero.getHero().getY() < 250){
            if (hero.getHero().getX() > 900 && hero.getHero().getX() < 1230){
                bossSpawn = true;
            }
        }

    }

    public void setLabyrinthExplanation(){
        labyrinthExplanation.delete();
    };

    public void teleportToBinaryLand(){
        if(hero.getHero().getX() == 880){
            if(hero.getHero().getY() == 60){
                hero.getHero().translate(210,320);

                if(labyrinthHasntBeenExplained) {

                    labyrinthExplanation = new Picture(950, 540, "imgs/scrolls/Untitled 2 2 2 2.png");
                    labyrinthExplanation.draw();

                    labyrinthHasntBeenExplained = false;
                }


                //hero.getHero().delete();
                //hero.setRow(1200);
                //hero.setCol(720);
                //hero.getHero().draw();
                //hero.setCol(600);
                //hero.setRow(1200);

            }
        }

    }





    public void secondPhase2(){
        if (boss.getHp() <= 2) {
            torchSet2.leftMove();
            torchSet2.rightMove();


            if (torchSet2.getLeftCol() >= 1052 || torchSet1.getRightCol() <= 1052) {
                torchSet2.leftDelete();
                torchSet2.rightDelete();
                torchSet2.createLeftProjectiles();
                torchSet2.createRightProjectiles();
            }

        }

    }





    public void secondPhase1(){
        if (boss.getHp() <= 2) {
            torchSet1.leftMove();
            torchSet1.rightMove();


            if (torchSet1.getLeftCol() >= 1052 || torchSet1.getRightCol() <= 1052) {
                torchSet1.leftDelete();
                torchSet1.rightDelete();
                torchSet1.createLeftProjectiles();
                torchSet1.createRightProjectiles();
            }

        }

    }

    public void firstPhase() {
        if (boss.getHp() >= 0 && bossSpawn) {
            boss.move();
            bullet1.move();
            bullet1Reappear();
            if(boss.getHp() <= 4){
                penta1.draw();
                penta2.draw();
                penta3.draw();
                penta4.draw();

            }

            if (bullet1.getRow() > 120) {
                bullet2CanGo = true;
            }
            bullet2Reappear();


            if (bullet2.getRow() > 120) {
                bullet3CanGo = true;
            }
            bullet3Reappear();

            if (bullet3.getRow() > 120) {
                bullet4CanGo = true;
            }
            bullet4Reappear();
        } else {
            deleteAll();

        }
    }


    public void deleteAll() {
        boss.delete();
        if (bullet1 != null) {
            bullet1.delete();
        }
        if (bullet2 != null) {
            bullet2.delete();
        }
        if (bullet3 != null) {
            bullet3.delete();
        }
        if (bullet4 != null) {
            bullet4.delete();
        }
    }

    public void bullet1Reappear() {
        if (bullet1.getRow() > 360) {
            bullet1.delete();
            bullet1 = new Bullet(boss, BulletNumber.FIRST, hero);
        }
    }

    public void bullet2Reappear() {
        if (bullet2CanGo) {
            bullet2.move();
            if (bullet2.getRow() > 360) {
                bullet2.delete();
                bullet2 = new Bullet(boss, BulletNumber.SECOND, hero);
            }
        } else {
            bullet2 = new Bullet(boss, BulletNumber.SECOND, hero);
        }
    }

    public void bullet3Reappear() {
        if (bullet3CanGo) {
            bullet3.move();
            if (bullet3.getRow() > 360) {
                bullet3.delete();
                bullet3 = new Bullet(boss, BulletNumber.THIRD, hero);

            }
        } else {
            bullet3 = new Bullet(boss, BulletNumber.THIRD, hero);
        }

    }

    public void bullet4Reappear() {
        if (bullet4CanGo) {
            bullet4.move();
            if (bullet4.getRow() > 360) {
                bullet4.delete();
                bullet4 = new Bullet(boss, BulletNumber.FOURTH, hero);
            }
        } else {
            bullet4 = new Bullet(boss, BulletNumber.THIRD, hero);
        }
    }

    public Picture bossChatBox(){
        bossTalkBox = new Picture(940, 180, "/imgs/scrolls/Untitled 2 2 2.png");
        //knightTalkBox.setColor(Color.ORANGE);
        bossTalkBox.draw();
        //drawArrow();
        return bossTalkBox;
    }

    public void bossSpeaks() throws InterruptedException {
        if(!hasBossSpoken){
            bossChatBox();
            //System.out.println("HEYEYEYEYEYYEYEYEYEYEYEYEYEYEYEYEYEYEYEYEYEYEYEYEY");
            Thread.sleep(3000);
            bossTalkBox.delete();
        }


    }

    public boolean hasBossSpoken() {
        return hasBossSpoken;
    }

    public void setHasBossSpoken() {
        this.hasBossSpoken = true;
    }

}


