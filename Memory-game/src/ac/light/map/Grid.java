package ac.light.map;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.Collections;

public class Grid {

    public static final int CELLSIZE = 200;
    private int rows;
    private int cols;
    private ArrayList<Color> myColors;
    private Rectangle[] tiles = new Rectangle[16];
    private Picture[] front = new Picture[16];
    private Boolean[] isDiscovered = new Boolean[17];
    private Rectangle main;
    private Picture bottom;


    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.isDiscovered[16] = false;

    }

    public void drawMain() {
        main = new Rectangle(10, 10, cols * CELLSIZE, rows * CELLSIZE);
        main.setColor(Color.BLACK);
        main.fill();
        bottom = new Picture(16,815,"resources/Bottom.jpg");
        bottom.draw();
    }




    public void drawGrid() {
        int positionX = 10;
        int positionY = 10;
        int a = 0;


        while (positionY < main.getHeight()) {
            for (int i = 0; i < rows; i++) {

                while (positionX < main.getWidth()) {
                    for (int j = 0; j < cols; j++) {
                        tiles[a] = new Rectangle(positionX, positionY, CELLSIZE, CELLSIZE);
                        tiles[a].setColor(myColors.get(a));
                        tiles[a].fill();
                        isDiscovered[a] = false;
                        a++;
                        j++;
                        positionX = positionX + CELLSIZE;
                    }
                }

                positionX = 10;
                positionY = positionY + CELLSIZE;

            }

        }

    }


    public void drawFrontGrid() {
        int positionX = 10;
        int positionY = 10;
        int a = 0;


        while (positionY < main.getHeight()) {
            for (int i = 0; i < rows; i++) {

                while (positionX < main.getWidth()) {
                    for (int j = 0; j < cols; j++) {
                        front[a] = new Picture(positionX, positionY, "resources/teste.jpg");
                        front[a].draw();
                        a++;
                        j++;
                        positionX = positionX + CELLSIZE;
                    }
                }

                positionX = 10;
                positionY = positionY + CELLSIZE;

            }
        }

    }


    //RANDOMIZE COLORS;
    public void color() {
        myColors = new ArrayList<>();
        myColors.add(Color.BLUE);
        myColors.add(Color.GREEN);
        myColors.add(Color.CYAN);
        myColors.add(Color.ORANGE);
        myColors.add(Color.RED);
        myColors.add(Color.PINK);
        myColors.add(Color.YELLOW);
        myColors.add(Color.LIGHT_GRAY);
        myColors.add(Color.BLUE);
        myColors.add(Color.GREEN);
        myColors.add(Color.CYAN);
        myColors.add(Color.ORANGE);
        myColors.add(Color.RED);
        myColors.add(Color.PINK);
        myColors.add(Color.YELLOW);
        myColors.add(Color.LIGHT_GRAY);



        // Here we use Random() to shuffle given list.
        Collections.shuffle(myColors);
        System.out.println("\nShuffled List with Random() : \n"
                + myColors);

    }

    public void recreate_tile(int x, int y, int arrayPos) {


        front[arrayPos] = new Picture(x,y,"resources/teste.jpg");
        front[arrayPos].draw();

    }



    //SETTER E GETTER
    public int getX(int x){
       return tiles[x].getX();
    }

    public int getY(int y){
        return tiles[y].getY();
    }

    public Color getColor(int c){
       return tiles[c].getColor();
    }


    // setter e getter do front

    public int getXPic(int x){
        return front[x].getX();
    }

    public int getYPic(int y){
        return front[y].getY();
    }

    public void hide(int c){
        front[c].delete();

    }


    public void setDiscoreved(int pos){
       isDiscovered[pos] = true;
    }

    public boolean isDiscovered(int pos){
        return isDiscovered[pos];
    }

    public int getMaxY(){
        return main.getHeight();
    }

    public int getMaxX(){
        return main.getWidth();
    }

    public int getMinX(){
        return main.getX();
    }

    public int getMinY(){
        return main.getY();
    }
}



