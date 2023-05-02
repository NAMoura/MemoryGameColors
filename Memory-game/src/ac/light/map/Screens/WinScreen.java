package ac.light.map.Screens;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class WinScreen {

    private Picture gameWinner = new Picture(10,10, "resources/GameWinner.jpg");



    public void show(){
        gameWinner.draw();
    }
}
