import ac.light.map.Grid;
import ac.light.map.KeyboardLogic;
import ac.light.map.Painter;
import ac.light.map.Screens.StartScreen;

public class Main {

    public static void main(String[] args) {

        Grid newBackground = new Grid(4,4);
        newBackground.drawMain();
        newBackground.color();
        newBackground.drawGrid();
        newBackground.drawFrontGrid();
        Painter painter = new Painter(newBackground);
        painter.score();


        StartScreen startScreen = new StartScreen();
        startScreen.show();

        KeyboardLogic keyboardLogic = new KeyboardLogic(newBackground, startScreen);
        keyboardLogic.setPlayer(painter);
        keyboardLogic.init();



        System.out.println("Hello world!");
    }
}