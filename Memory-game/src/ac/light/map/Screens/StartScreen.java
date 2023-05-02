package ac.light.map.Screens;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartScreen {

    private Picture gameStart = new Picture(10,10, "resources/GameStart.jpg");



    public void show(){
        gameStart.draw();
    }

    public void delete(){
        gameStart.delete();
    }
}
