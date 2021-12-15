package org.academiadecodigo.spaceintvaders.hero;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;



public class OldLady {

    private Picture oldLady;
    private Rectangle oldLadyBounds;
    private Picture oldLadyTalkBox;



    public OldLady() {
        oldLady = new Picture(260,210,"imgs/oldlady/oldlady.PNG");
        //oldLady.draw();
    }

    public Rectangle oldLadyGetBounds() {
        oldLadyBounds = new Rectangle(oldLady.getX(), oldLady.getY(), 40,40);
        //oldLadyBounds.draw();
        return oldLadyBounds;
    }

    public Picture oldLadyChatBox(){
        oldLadyTalkBox = new Picture(50, 250, "/imgs/scrolls/Untitled 2.png");
        //oldLadyTalkBox.setColor(Color.ORANGE);
        oldLadyTalkBox.draw();
        return oldLadyTalkBox;
    }

    public void oldLadySpeaks() throws InterruptedException {
        oldLadyChatBox();
        Thread.sleep(7000);

        oldLadyTalkBox.delete();
    }

    public Rectangle getOldLadyBounds(){
        return oldLadyBounds;
    }

    public Picture getOldLady(){
        return oldLady;
    }



}
