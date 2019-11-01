/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetpackeges;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author user
 */
public class InternetPackeges extends Application {
    
    @Override
    public void start(Stage primaryStage)  throws Exception {
        URL fxmlUrl = getClass().getClassLoader().getResource("view/SellingView.fxml");
	HBox root = FXMLLoader.<HBox>load(fxmlUrl);

	Scene scene = new Scene(root);     
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Registration of Internet package sales");  
        primaryStage.centerOnScreen();  
        primaryStage.setResizable(false);  
        primaryStage.show();
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
