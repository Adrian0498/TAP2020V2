package sample.ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.events.EventosMemorama;

import java.util.Random;

public class Memorama extends Stage implements EventHandler {

    private String[] arImagenes = {"Avestruz.jpg", "Buho.jpg", "Cebra.jpg", "Gorila.jpg", "Leon.jpg", "loro.jpg", "Mariposa.jpg", "Pav_Real.jpg", "Serpiente.jpg", "Tigre.jpg", "Tucan.jpg"};

    private Label lblTarjetas;
    private TextField txtNoTarjetas;
    private Button btnAceptar;
    private HBox hBox;
    private VBox vBox;
    private GridPane gdpMesa;
    private Button[][] arTarjetas;
    private String[][] arAsignacion; //para la logica
    int posx, posy, contAv, contPavo, contBuh, contCeb, contGo, contLe, contLo, contMa, contSe, contTi, contTu, posImg;
    private int noCartas;
    private Scene escena;


    public Memorama() {

        CrearUI();
        this.setTitle("Memorama :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        lblTarjetas = new Label("Número de Pares:"); //num de tarjetas
        txtNoTarjetas = new TextField();
        btnAceptar = new Button("Jugar!");
        btnAceptar.addEventHandler(MouseEvent.MOUSE_CLICKED, this);


        hBox = new HBox();
        hBox.getChildren().addAll(lblTarjetas, txtNoTarjetas, btnAceptar);
        hBox.setSpacing(10);

        gdpMesa = new GridPane();
        vBox = new VBox();
        vBox.getChildren().addAll(hBox, gdpMesa);

        escena = new Scene(vBox, 500, 500);
    }

    @Override
    public void handle(Event event) {

        noCartas = Integer.parseInt(txtNoTarjetas.getText()); //obtenemos numero de tarjetas

        vBox.getChildren().remove(gdpMesa);

        gdpMesa = new GridPane();
        arAsignacion = new String[2][noCartas];
        revolver();
        arTarjetas = new Button[2][noCartas];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < noCartas; j++) {

                Image img = new Image("sample/assets/carta_base.jpg");
                ImageView imv = new ImageView(img);
                imv.setFitHeight(120);
                imv.setPreserveRatio(true);

                arTarjetas[i][j] = new Button();
                int finalI = i;
                int finalJ = j;
                arTarjetas[i][j].setOnAction(event1 -> verTarjeta(finalI, finalJ));
                arTarjetas[i][j].setGraphic(imv);
                arTarjetas[i][j].setPrefSize(80, 120);

                gdpMesa.add(arTarjetas[i][j], j, i);

            }
        }

        vBox.getChildren().add(gdpMesa);
    }

    private void verTarjeta(int finalI, int finalJ) {

        Image img = new Image("sample/assets/" + arAsignacion[finalI][finalJ]);
        ImageView imv = new ImageView(img);
        imv.setFitHeight(120);
        imv.setPreserveRatio(true);

        arTarjetas[finalI][finalJ].setGraphic(imv);
    }


    private void revolver() {

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < noCartas; j++) {
                arAsignacion[i][j] = new String();
            }

        posImg = (int) (Math.random()*arImagenes.length);
        for(int i=0; i< noCartas;){
            if( arAsignacion[posx][posy].equals("") ){
                posx = (int) (Math.random()*2);
                posy = (int) (Math.random()*noCartas);
                switch (arImagenes[posImg]){
                    case "Avestruz.jpg":
                        contAv++;
                        arAsignacion[posx][posy] = arImagenes[posImg];
                        if (contAv==2){
                            i++;
                            posImg = (int) (Math.random()*arImagenes.length);
                        }
                        break;
                    case "Buho.jpg":
                        contBuh++;
                        arAsignacion[posx][posy] = arImagenes[posImg];
                        if (contBuh==2){
                            i++;
                            posImg = (int) (Math.random()*arImagenes.length);
                        }
                        break;
                    case "Cebra.jpg":
                        contCeb++;
                        arAsignacion[posx][posy] = arImagenes[posImg];
                        if (contCeb==2){
                            i++;
                            posImg = (int) (Math.random()*arImagenes.length);
                        }
                        break;
                    case "Gorila.jpg":
                        contGo++;
                        arAsignacion[posx][posy] = arImagenes[posImg];
                        if (contGo==2){
                            i++;
                            posImg = (int) (Math.random()*arImagenes.length);
                        }
                        break;
                    case "Leon.jpg":
                        contLe++;
                        arAsignacion[posx][posy] = arImagenes[posImg];
                        if (contLe==2){
                            i++;
                            posImg = (int) (Math.random()*arImagenes.length);
                        }
                        break;
                    case "loro.jpg":
                        contLo++;
                        arAsignacion[posx][posy] = arImagenes[posImg];
                        if (contLo==2){
                            i++;
                            posImg = (int) (Math.random()*arImagenes.length);
                        }
                        break;
                    case "Mariposa.jpg":
                        contMa++;
                        arAsignacion[posx][posy] = arImagenes[posImg];
                        if (contMa==2){
                            i++;
                            posImg = (int) (Math.random()*arImagenes.length);
                        }
                        break;
                    case "Serpiente.jpg":
                        contSe++;
                        arAsignacion[posx][posy] = arImagenes[posImg];
                        if (contSe==2){
                            i++;
                            posImg = (int) (Math.random()*arImagenes.length);
                        }
                        break;
                    case "Tigre.jpg":
                        contTi++;
                        arAsignacion[posx][posy] = arImagenes[posImg];
                        if (contTi==2){
                            i++;
                            posImg = (int) (Math.random()*arImagenes.length);
                        }
                        break;
                    case "Tucan.jpg":
                        contTu++;
                        arAsignacion[posx][posy] = arImagenes[posImg];
                        if (contTu==2){
                            i++;
                            posImg = (int) (Math.random()*arImagenes.length);
                        }
                        break;
                    case "Pav_Real.jpg":
                        contPavo++;
                        arAsignacion[posx][posy] = arImagenes[posImg];
                        if (contPavo==2){
                            i++;
                            posImg = (int) (Math.random()*arImagenes.length);
                        }
                        break;
                }
            }else{
                posx = (int) (Math.random()*2);
                posy = (int) (Math.random()*noCartas);
            }

        }
    }
}




