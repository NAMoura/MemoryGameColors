package ac.light.map;

import ac.light.map.Screens.GameOverScreen;
import ac.light.map.Screens.WinScreen;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Painter {


    Picture painter;
    Grid tile;
    Color second_color;
    Color first_colour;
    private int first_tile_x;
    private int first_tile_y;
    private int second_tile_x;
    private int second_tile_y;
    private int firstArrPos, secondArrPos, getArray;
    private int number_of_trys = 10;
    private Text text;
    private Boolean[] isFilled = new Boolean[400];
    private int correctGuesses = 0;


    public Painter (Grid tile){
        this.tile = tile;
        this.painter = new Picture(10,10,"resources/mover.png");

        painter.draw();
    }



    public void  moveRight() {
        painter.translate(Grid.CELLSIZE,0);
    }
    public void  moveLeft() {
        painter.translate(-Grid.CELLSIZE, 0);
    }
    public void  moveUp() {
        painter.translate(0,-Grid.CELLSIZE);
    }
    public void  moveDown() {
        painter.translate(0, Grid.CELLSIZE);
    }

    public void score(){

        this.text = new Text(515,850, "" + number_of_trys);
        this.text.setColor(Color.WHITE);
        this.text.grow(10,15);
        this.text.draw();

    }

    public int getX(){
        return painter.getX();
    }

    public int getY(){
        return painter.getY();
    }

    public int getArray(){
        return getArray;
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }




    public Color compare_second_colour() {
        for(int i = 0; i < 16; i++) {
            if ((tile.getX(i) == painter.getX() && (tile.getY(i) == painter.getY()))) {
                tile.hide(i);
                second_color = tile.getColor(i);
                second_tile_x = tile.getX(i);
                second_tile_y = tile.getY(i);
                secondArrPos = i;
                getArray = i;

            }
        }
        return second_color;
    }

    public Color compare_first_colour()  {
        for(int i = 0; i < 16; i++) {
            if ((tile.getX(i) == painter.getX() && (tile.getY(i) == painter.getY()))) {
                tile.hide(i);
                first_colour = tile.getColor(i);
                first_tile_x = tile.getX(i);
                first_tile_y = tile.getY(i);
                firstArrPos = i;
                getArray = i;

            }
        }
        return first_colour;
    }

    public void compare_both()  {

        if (first_colour == second_color){
            // lock the squares, set corresponding boolean array position to true
            System.out.println("colors are equal");
            tile.setDiscoreved(firstArrPos);
            tile.setDiscoreved(secondArrPos);
            getArray = 16;
            correctGuesses++;
            if (correctGuesses == 8) {
                WinScreen winScreen = new WinScreen();
                winScreen.show();

            }

        }else {

            //redraw the top squares

            tile.recreate_tile(first_tile_x, first_tile_y, firstArrPos);
            tile.recreate_tile(second_tile_x, second_tile_y, secondArrPos);

            painter.delete();

            this.painter = new Picture(second_tile_x,second_tile_y,"resources/mover.png");
            painter.draw();
            number_of_trys--;
            text.delete();
            score();

            if (number_of_trys == 0){
                GameOverScreen gameOverScreen = new GameOverScreen();
                gameOverScreen.show();
            }

            System.out.println("colors are not equal");

        }
    }
}
