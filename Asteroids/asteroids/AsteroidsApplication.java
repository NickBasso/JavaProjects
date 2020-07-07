package asteroids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {
    
    public static int WIDTH = 300;
    public static int HEIGHT = 200;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        
        Pane pane = new Pane();
        pane.setPrefSize(WIDTH, HEIGHT);
        Text text = new Text(10, 20, "Points: 0");
        //pane.getChildren().add(text);
        bp.setPrefSize(WIDTH + 50, HEIGHT + 50);
        bp.setTop(text);
        bp.setCenter(pane);
        //pane.getChildren().add(new Circle(30, 50, 10));
        //Polygon parallelogram = new Polygon(0, 0, 100, 0, 100, 50, 0, 50);
        //pane.getChildren().add(parallelogram);
        
        //parallelogram.setTranslateX(100);
        //parallelogram.setTranslateY(20);
        
        AtomicInteger points = new AtomicInteger();
        
        Ship ship = new Ship(WIDTH / 2, HEIGHT / 2);
        List<Asteroid> asteroids = new ArrayList<>();
        List<Projectile> projectiles = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            Asteroid asteroid = new Asteroid(rnd.nextInt(WIDTH / 3), rnd.nextInt(HEIGHT));
            asteroids.add(asteroid);
        }

        pane.getChildren().add(ship.getCharacter());
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));
        
        

        Scene scene = new Scene(bp);
        //
            Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

            scene.setOnKeyPressed(event -> {
                pressedKeys.put(event.getCode(), Boolean.TRUE);
            });

            scene.setOnKeyReleased(event -> {
                pressedKeys.put(event.getCode(), Boolean.FALSE);
            });
            
            // update the game state 60 times per minute
            new AnimationTimer() {

                @Override
                public void handle(long now) {
                    text.setText("Points: " + points.incrementAndGet());
                    
                    if(pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                        ship.turnLeft();
                    }

                    if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                        ship.turnRight();
                    }
                    
                    if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                        ship.accelerate();
                    }
                    
                    if (pressedKeys.getOrDefault(KeyCode.SPACE, false) && projectiles.size() < 3) {
                        // we shoot
                        Projectile projectile = new Projectile((int) ship.getCharacter().getTranslateX(), (int) ship.getCharacter().getTranslateY());
                        projectile.getCharacter().setRotate(ship.getCharacter().getRotate());
                        projectiles.add(projectile);

                        projectile.accelerate();
                        projectile.setMovement(projectile.getMovement().normalize().multiply(3));

                        pane.getChildren().add(projectile.getCharacter());
                    }
                    
                    ship.move();
                    asteroids.forEach(asteroid -> asteroid.move());
                    projectiles.forEach(projectile -> projectile.move());
                    
                    /*// projectiles to remove
                    List<Projectile> projectilesToRemove = projectiles.stream().filter(projectile -> {
                        List<Asteroid> collisions = asteroids.stream()
                                                                    .filter(asteroid -> asteroid.collide(projectile))
                                                                    .collect(Collectors.toList());

                        if(collisions.isEmpty()) {
                            return false;
                        }

                        collisions.stream().forEach(collided -> {
                            asteroids.remove(collided);
                            pane.getChildren().remove(collided.getCharacter());
                        });

                        return true;
                    }).collect(Collectors.toList());

                    projectilesToRemove.forEach(projectile -> {
                        pane.getChildren().remove(projectile.getCharacter());
                        projectiles.remove(projectile);
                    });
                    
                    // remove astroids when hit by a projectile
                    projectiles.forEach(projectile -> {
                        List<Asteroid> collisions = asteroids.stream()
                                                                    .filter(asteroid -> asteroid.collide(projectile))
                                                                    .collect(Collectors.toList());

                        collisions.stream().forEach(collided -> {
                            asteroids.remove(collided);
                            pane.getChildren().remove(collided.getCharacter());
                        });
                    });*/
                    
                    
                    
                    ////// check for projectiles and asteroids to be removed
                    projectiles.forEach(projectile -> {
                        asteroids.forEach(asteroid -> {
                            if(projectile.collide(asteroid)) {
                                projectile.setAlive(false);
                                asteroid.setAlive(false);
                            }
                        });
                        
                        
                        if(!projectile.isAlive()) {
                            text.setText("Points: " + points.addAndGet(1000));
                        }
                    });

                    projectiles.stream()
                        .filter(projectile -> !projectile.isAlive())
                        .forEach(projectile -> pane.getChildren().remove(projectile.getCharacter()));
                    
                    projectiles.removeAll(projectiles.stream()
                                            .filter(projectile -> !projectile.isAlive())
                                            .collect(Collectors.toList()));

                    asteroids.stream()
                            .filter(asteroid -> !asteroid.isAlive())
                            .forEach(asteroid -> pane.getChildren().remove(asteroid.getCharacter()));
                    asteroids.removeAll(asteroids.stream()
                                                .filter(asteroid -> !asteroid.isAlive())
                                                .collect(Collectors.toList()));
                    
                    // check for ship collission with any asteroid
                    asteroids.forEach(asteroid -> {
                        if (ship.collide(asteroid)) {
                            stop();
                        }
                    });
                    
                    // add 5% chance to add an asteroid to the game
                    if(Math.random() < 0.005) {
                        Asteroid asteroid = new Asteroid(WIDTH, HEIGHT);
                        if(!asteroid.collide(ship)) {
                            asteroids.add(asteroid);
                            pane.getChildren().add(asteroid.getCharacter());
                        }
                    }
                } 
            }.start();
        
        //
        
        stage.setTitle("Asteroids");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int partsCompleted() {
        // State how many parts you have completed using the return value of this method
        return 4;
    }

}
