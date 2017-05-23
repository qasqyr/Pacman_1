import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Yera on 09.05.2017.
 */
public class Map extends Pane {
    private int unit;
    private int size;
    private int[][] map;
    private Circle ball;
    private Position start;
    private ImagePattern img;


    public Map (String fileName) {
        this.unit=50;

        try {

            Scanner s = new Scanner(new File(fileName));
            size = s.nextInt();  // to identify first symbol (size of map)
            map = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                    map[i][j] = s.nextInt();
                }

            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if(map[i][j] == 2) {
                        start = new Position((25+50*j), (25+50*i));
                    }
                }
            }

            s.close();

        } catch (IOException i) {
            System.out.println("Problem is identified");

        }

        Image Kappa = new Image("Kappa.gif"); // to give my pacman the animation
        setBall(new Circle(24,new ImagePattern(Kappa,0, 0, 1, 1, true)));

        getBall().setCenterX(start.getX());
        getBall().setCenterY(start.getY());


        getChildren().add(getBall());
    }

    public int getUnit() {
        return unit;
    }

    public int getSize() {
        return size;
    }

    public int[][] getMap() {
        return map;
    }

    public Position getStart() {
        return start;
    }

    public Circle getBall() {
        return ball;
    }

    public void setBall(Circle ball) {
        this.ball = ball;
    }
}