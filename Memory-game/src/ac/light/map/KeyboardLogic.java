package ac.light.map;

import ac.light.map.Screens.StartScreen;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import java.util.concurrent.TimeUnit;

public class KeyboardLogic implements KeyboardHandler {

    private Keyboard keyboard;
    private Painter painter;
    private StartScreen startScreen;
    int click_number;
    private Grid grid;


    public KeyboardLogic(Grid grid, StartScreen startScreen) {
        this.click_number = 0;
        this.grid = grid;
        this.startScreen = startScreen;
    }


    public void init() {
        keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent enter = new KeyboardEvent();
        enter.setKey(KeyboardEvent.KEY_S);
        enter.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent quit = new KeyboardEvent();
        quit.setKey(KeyboardEvent.KEY_Q);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(space);
        keyboard.addEventListener(enter);
        keyboard.addEventListener(quit);


    }

    public void setPlayer(Painter painter) {
        this.painter = painter;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (painter.getX() + Grid.CELLSIZE < grid.getMaxX()) {
                    painter.moveRight();

                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if (painter.getX() > grid.getMinX()) {
                    painter.moveLeft();
                }
                break;

            case KeyboardEvent.KEY_UP:
                if (painter.getY() > grid.getMinX()) {
                    painter.moveUp();

                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (painter.getY() + Grid.CELLSIZE < grid.getMaxX()) {
                    painter.moveDown();


                }
                break;
            case KeyboardEvent.KEY_SPACE:
               if(grid.isDiscovered(painter.getArray())==false) {
                   click_number++;
                   if (click_number == 1) {
                           painter.compare_first_colour();

                   }
                   if (click_number == 2) {
                       painter.compare_second_colour();

                       Timer timer = new Timer(500, new ActionListener() {
                           public void actionPerformed(ActionEvent e) {
                       painter.compare_both();
                           }
                       });
                       timer.setRepeats(false);
                       timer.start();
                       click_number=0;
                   }

                   break;
               }
            case KeyboardEvent.KEY_S:
                startScreen.delete();
                break;

            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + keyboardEvent.getKey());
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


    }


}
