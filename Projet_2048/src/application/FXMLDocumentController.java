/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import bdd.BaseDeDonnees;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Partie;

/**
 *
 * @author Lucille
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    private Pane container; // panneau recouvrant toute la fenêtre
    @FXML
    private GridPane grid1; //Grille à gauche dans le jeu
    @FXML
    private GridPane grid2; //Grille au milieu
    @FXML
    private GridPane grid3; //Grille à droite
    
    @FXML
    private Label score_label; // value will be injected by the FXMLLoader
    @FXML
    private Pane score_pane; //Conteneur du label score et du score actuel
    @FXML
    private Label nb_score; //Valeur du score à l'écran
    
    @FXML
    private Label move_label; //le mot "Move" dans le jeu
    @FXML
    private Pane move_pane; //Le conteneur de move_label + nb_move
    @FXML
    private Label nb_move; //Nombre de mouvements effectués
    
    @FXML
    private Button start_button; //Bouton "START"
    
    @FXML
    private Menu option_button;
    @FXML
    private Menu game_button;
    
    @FXML
    private MenuBar menu_bar;
    @FXML
    private MenuItem pt_restart; //bouton "recommencer"
    @FXML
    private MenuItem pt_giveup; //bouton "abandonner"
    @FXML
    private MenuItem pt_save; //bouton "sauvegarder"
    
    @FXML
    private MenuItem logout_button; //bouton déconnexion
    
    @FXML
    private MenuItem op_theme;
    @FXML
    private MenuItem op_son;
    
    // variables globales non définies dans la vue (fichier .fxml)
    private BaseDeDonnees bdd;
    private Partie partie;
    //Cases du jeu
    private final Pane case_pane = new Pane(); // panneau utilisé pour dessiner une tuile "2"
    private final Label case_label_2 = new Label("2");
    private final Label case_label_4 = new Label("4");
    private final Label case_label_8 = new Label("8");
    private final Label case_label_16 = new Label("16");
    private final Label case_label_32 = new Label("32");
    private final Label case_label_64 = new Label("64");
    private final Label case_label_128 = new Label("128");
    private final Label case_label_256 = new Label("256");
    private final Label case_label_512 = new Label("512");
    private final Label case_label_1024 = new Label("1024");
    private final Label case_label_2048 = new Label("2048");
    private final int wh_case=77; //largeur et hauteur de la case (en px)
    private int x_1 = 38, x_2 = 282, x_3 = 525, y = 272;
    private int objectifx_1 = 38, objectifx_2 = 282, objectifx_3 = 525, objectify = 272;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bdd = BaseDeDonnees.getInstance();
        System.out.println("le contrôleur initialise la vue");
        // utilisation de styles pour la grille et la tuile (voir style_2048.css)
        case_pane.getStyleClass().add("case_pane");
        case_pane.getStyleClass().add("case_pane");
        case_label_2.getStyleClass().add("case_label_2");
        case_label_4.getStyleClass().add("case_label_4");
        case_label_8.getStyleClass().add("case_label_8");
        case_label_16.getStyleClass().add("case_label_16");
        case_label_32.getStyleClass().add("case_label_32");
        case_label_64.getStyleClass().add("case_label_64");
        case_label_128.getStyleClass().add("case_label_128");
        case_label_256.getStyleClass().add("case_label_256");
        case_label_512.getStyleClass().add("case_label_512");
        case_label_1024.getStyleClass().add("case_label_1024");
        case_label_2048.getStyleClass().add("case_label_2048");        //Définition de la taille d'une case
        grid1.getStyleClass().add("grid");
        grid2.getStyleClass().add("grid");
        grid3.getStyleClass().add("grid");
        
        score_pane.getStyleClass().add("score_pane");
        score_label.getStyleClass().add("score_label");
        nb_score.getStyleClass().add("nb_score");
        
        move_pane.getStyleClass().add("move_pane");
        move_label.getStyleClass().add("move_label");
        nb_move.getStyleClass().add("nb_move");
        //bouton start et les boutons du menu
        start_button.getStyleClass().add("bouton_start");
        //MENU
        menu_bar.getStyleClass().add("menu_bar");
        option_button.getStyleClass().add("bouton_menu");
        game_button.getStyleClass().add("bouton_menu");
        //boutons sous-menu MENU>>PARTIE>>
        pt_restart.getStyleClass().add("bouton_sous_menu");
        pt_giveup.getStyleClass().add("bouton_sous_menu");
        pt_save.getStyleClass().add("bouton_sous_menu");
        logout_button.getStyleClass().add("bouton_sous_menu");
        //bouton SON et THEME (switch)
        //op_son.getStyleClass().add("bouton");
        //op_theme.getStyleClass().add("bouton");
        
        GridPane.setHalignment(case_pane, HPos.CENTER);
        GridPane.setHalignment(case_label_2, HPos.CENTER);
        grid1.getChildren().add(case_pane); //ajout de la case à son conteneur: la grille 1
        case_pane.getChildren().add(case_label_2);
        // on place la tuile en précisant les coordonnées (x,y) du coin supérieur gauche d'une des trois grilles
        //Case 0,0 grille 1: layout X=38, layout Y=271
        //Case 0,0 grille 2: layout X=282
        //Case 0,0 grille 3: layout X=525
        case_pane.setLayoutX(x_1);  //a gauche
        case_pane.setLayoutY(y);    //en haut
        case_pane.setPrefSize(wh_case, wh_case);
        case_pane.setVisible(false);
        case_label_2.setVisible(false);
    }
    
    @FXML
    private void clickStart(ActionEvent event) {
        System.out.println("touche START appuyée");
        Partie partie = new Partie();
        partie.start();
    }

    @FXML
    public void keyPressed(KeyEvent ke) {
        System.out.println("touche appuyée");
        String touche = ke.getText();
        
        if (touche.compareTo("q") == 0) { // utilisateur appuie sur "q" pour envoyer la tuile vers la gauche
            if (objectifx_1 > 38) { // possible uniquement si on est pas dans la colonne la plus à gauche
                objectifx_2 -= (int) 240 / 3; // on définit la position que devra atteindre la tuile en abscisse (modèle). Le thread se chargera de mettre la vue à jour
                move_label.setText(Integer.toString(Integer.parseInt(move_label.getText()) + 1)); // mise à jour du compteur de mouvement
            }
        }else if (touche.compareTo("d") == 0) { // utilisateur appuie sur "d" pour envoyer la tuile vers la droite

        }
    }    
    
}
