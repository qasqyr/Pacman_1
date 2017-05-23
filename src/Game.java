/**
 * Created by Yera-PC on 5/23/2017.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import java.util.Scanner;

/*Game class

- JavaFX application;

- Creates the map;

- Creates the player;

- Creates food instance;

- Controls key events;

- The whole game starts as follows:
*/
public class Game extends Application {

    static Scanner scanner = new Scanner(System.in);
    //write here location of input file
    static String input  = "C:\\Users\\Yera-PC\\IdeaProjects\\Pacman_1\\map0.txt";
    static Map map = new Map(input);
    static Player player;
    static Circle ball;
    static Rectangle r;
    static Line lineX;
    static Line lineY;
    //static Food food;
    //static Grid grid;

    @Override
    public void start(Stage primaryStage) {
        try {
            map = new Map(input);

            map.setStyle("-fx-background-color: white");
            map.setPrefSize(400, 400);



            int[][] matrix = map.getMap();
            int size = map.getSize();



            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    lineX = new Line(0, j*50, size*50, j*50); // lines on X axis
                    lineY = new Line(i*50, 0, i*50, size*50); // lines on Y axis
                    map.getChildren().addAll(lineX,lineY); // adding both lines on MAP pane

                    if(matrix[i][j] == 1) {
                        r = new Rectangle(50*(j),50*(i), 50, 50 );
                        map.getChildren().addAll(r); // adding rectangle on my map pane
                    }

                }
            }

            player = new MyPlayer(map);
            Food food = new Food(map, player);
            Scene scene = new Scene(map,400,400);

            //CONTROLLER
            scene.setOnKeyPressed(e ->{
                if (e.getCode().isLetterKey()){
                    switch(e.getCode()){
                        case W:
                            player.moveUp();
                            break;
                        case S:
                            player.moveDown();
                            break;

                        case D:
                            player.moveRight();
                            break;
                        case A:
                            player.moveLeft();
                            break;

                    }
                }
            });


            primaryStage.setScene(scene);
            primaryStage.setTitle("Pacman_1");
            primaryStage.show();
            map.getBall().requestFocus();
            System.out.println("Use WASD to move, don't forget to click on window :D");
            System.out.println("Your score:");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
