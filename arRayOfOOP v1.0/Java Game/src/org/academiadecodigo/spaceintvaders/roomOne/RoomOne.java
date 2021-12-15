package org.academiadecodigo.spaceintvaders.roomOne;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceintvaders.JavaGame;
import org.academiadecodigo.spaceintvaders.hero.Hero;

public class RoomOne {

    private Hero hero;
    private Picture rock;
    private Rectangle rockBounds;
    private boolean hasRocked;
    private boolean princeHasBeenRocked;
    private boolean bossKidnappedPrince;

    private Picture boss;


    public RoomOne(Hero hero) {
        this.hero = hero;
        rock = new Picture(390, 60, "/imgs/rock/rock.png");
        hasRocked = false;
        boss = new Picture(30, 30, "/imgs/boss/bossLightsOn.PNG");
        bossKidnappedPrince = false;
    }


    public void triggerRockAction() throws InterruptedException {
        if (((hero.getHero().getX() >= 70 && hero.getHero().getX() <= 300) && (hero.getHero().getY() >= 200 && hero.getHero().getY() < 300)) ||
                (hero.getHero().getX() >= 80 && hero.getHero().getY() >= 330)) {


            if (!bossKidnappedPrince) {
                while (boss.getX() <= 390) {
                    //System.out.println("WHAT");
                    boss.draw();
                    Thread.sleep(20);
                    boss.translate(10, 0);
                    bossKidnappedPrince = true;
                }
            }
            //Thread.sleep(1000);

            boss.delete();

            if (!hasRocked) {
                rock.draw();
                princeHasBeenRocked = true;
                //rock.delete();
                //Thread.sleep(200);
                //rock.draw();
                //rock.delete();
                //Thread.sleep(200);
                //rock.draw();
                hasRocked = true;

            }
        }
    }

    public Rectangle rockBounds() {
        rockBounds = new Rectangle(rock.getX(), rock.getY(), 40, 40);
        //oldLadyBounds.draw();

        return rockBounds;
    }

    public Rectangle getRockBounds() {
        return rockBounds();
    }

    public boolean hasPrinceBeenRocked() {
        return princeHasBeenRocked;
    }
}
