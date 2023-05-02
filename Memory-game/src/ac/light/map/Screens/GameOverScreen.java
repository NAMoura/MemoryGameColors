package ac.light.map.Screens;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOverScreen {
    private Picture gameOver = new Picture(10,10, "resources/GameOver.jpg");



    public void show(){
        gameOver.draw();
    }


}
