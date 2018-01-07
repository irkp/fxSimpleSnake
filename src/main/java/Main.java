import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Snake Game");
        SnakeController controller = new SnakeController();
        Group root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);
        Canvas canvas = new Canvas(500, 500);
        root.getChildren().add(canvas);

        final ArrayList<String> input = new ArrayList<>();
        final SnakePosition snakePosition = new SnakePosition();

        keyPressedEvent(theScene, input);
        keyReleaseEvent(theScene, input);

        final GraphicsContext gc = canvas.getGraphicsContext2D();
        final Image snakeHead = new Image("head.png", 10, 10, false, false);

        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                gc.clearRect(0, 0, 500, 500);
                Direction direction = inputKeyToDirection(input);
                Main.this.newSnakePosition(direction, controller, snakePosition);
                gc.drawImage(snakeHead, snakePosition.getHeadX(), snakePosition.getHeadY());
            }
        }.start();
        primaryStage.show();
    }

    private void newSnakePosition(Direction direction, SnakeController controller, SnakePosition snakePosition) {
        if (null == direction) {
            direction = snakePosition.getActualDirection();
        }
        if (Direction.LEFT.equals(direction)) {
            controller.goLeft(snakePosition);
        } else if (Direction.RIGHT.equals(direction)) {
            controller.goRigth(snakePosition);
        } else if (Direction.UP.equals(direction)) {
            controller.goUp(snakePosition);
        } else if (Direction.DOWN.equals(direction)) {
            controller.goDown(snakePosition);
        }
        snakePosition.setActualDirection(direction);
    }


    private void keyPressedEvent(Scene theScene, ArrayList<String> input) {
        theScene.setOnKeyPressed(
                e -> {
                    String code = e.getCode().toString();
                    if (!input.contains(code))
                        input.add(code);
                });
    }

    private void keyReleaseEvent(Scene theScene, ArrayList<String> input) {
        theScene.setOnKeyReleased(
                e -> {
                    String code = e.getCode().toString();
                    input.remove(code);
                });
    }

    private Direction inputKeyToDirection(ArrayList<String> input) {
        if (input.contains("UP")) {
            return Direction.UP;
        } else if (input.contains("DOWN")) {
            return Direction.DOWN;
        } else if (input.contains("LEFT")) {
            return Direction.LEFT;
        } else if (input.contains("RIGHT")) {
            return Direction.RIGHT;
        }
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
