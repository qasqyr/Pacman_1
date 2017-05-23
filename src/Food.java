/*
 * Decompiled with CFR 0_118.
 *
 * Could not load the following classes:
 *  Map
 *  Player
 *  Position
 *  javafx.application.Platform
 *  javafx.collections.ObservableList
 *  javafx.scene.Node
 *  javafx.scene.control.Label
 *  javafx.scene.layout.Pane
 *  javafx.scene.paint.Color
 *  javafx.scene.paint.Paint
 *  javafx.scene.shape.Circle
 */

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Food {
    private Map map;
    private Pane foodPane;
    private Player player;
    private Circle circle;
    private Position foodPosition;
    private Label seconds;
    private final int timer = 5;
    private int numOfCircles = 10;
    private int time;
    private int points;
    private int size;
    private int[][] cells;
    private ImagePattern img;

    public Food(Map map, Player player) {
        this.map = map;
        this.foodPane = new Pane();
        this.map.getChildren().add((Node) this.foodPane);
        this.player = player;
        this.size = this.map.getSize();
        this.cells = this.map.getMap();
        Thread thread = new Thread(() -> {
            while (this.numOfCircles > 0) {
                this.createFood();
                Platform.runLater(() -> {
                            this.foodPane.getChildren().addAll((Node[]) new Node[]{this.circle, this.seconds});
                        }
                );
                this.time = 5;
                while (this.time > 0) {
                    Platform.runLater(() -> {
                                this.seconds.setText("" + this.time);
                            }
                    );
                    if (this.player.getPosition().equals(this.foodPosition)) {
                        this.points += this.time;
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException var1_2) {
                        // empty catch block
                    }
                    --this.time;
                }
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException var1_3) {
                    // empty catch block
                }
                Platform.runLater(() -> {
                            this.foodPane.getChildren().clear();
                        }
                );
                --this.numOfCircles;
            }
            System.out.println(this.getPoints());
        }
        );
        thread.start();
    }

    public int getPoints() {
        return this.points;
    }

    private void createFood() {
        int n;
        int n2;
        Random random = new Random();
        double d = this.map.getUnit();
        do {
            n = random.nextInt(this.size);
            n2 = random.nextInt(this.size);
        } while (this.map.getMap()[n2][n] == 1 || this.player.getPosition().equals(new Position(25+50*n, 25+50*n2)));

        this.circle = new Circle((double)n * d + d / 2.0, (double)n2 * d + d / 2.0, d / 2.0);
        Image PogChamp = new Image("PogChamp.gif");

        this.circle.setFill(new ImagePattern(PogChamp,0, 0, 1, 1, true));
        this.foodPosition = new Position(25+50*n, 25+50*n2);
        this.seconds = new Label("5");
        this.seconds.setTranslateX((double)n * d);
        this.seconds.setTranslateY((double)n2 * d);
    }
}