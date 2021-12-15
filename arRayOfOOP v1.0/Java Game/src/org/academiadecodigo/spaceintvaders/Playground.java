package org.academiadecodigo.spaceintvaders;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Playground {

    public static void main(String[] args) throws InterruptedException{

        JavaGame javaGame = new JavaGame();
        Keyboard keyboard = new Keyboard(javaGame);

        // Keyboard Bindings + Strokes

        // Key W - UP
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_W);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent up2 = new KeyboardEvent();
        up2.setKey(KeyboardEvent.KEY_W);
        up2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(up2);

        // Key S - DOWN
        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_S);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent down2 = new KeyboardEvent();
        down2.setKey(KeyboardEvent.KEY_S);
        down2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(down2);

        // Key A - LEFT
        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_A);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent left2 = new KeyboardEvent();
        left2.setKey(KeyboardEvent.KEY_A);
        left2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(left2);

        // Key D - RIGHT
        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_D);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent right2 = new KeyboardEvent();
        right2.setKey(KeyboardEvent.KEY_D);
        right2.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(right2);

        // Key SPACE - SHOOT ARROW
        KeyboardEvent spaceKey = new KeyboardEvent();
        spaceKey.setKey(KeyboardEvent.KEY_SPACE);
        spaceKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceKey);

        javaGame.start();
    }
}
