package Caso1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

public class Caso1 extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		//Creo el Layout en el que colocaré las tres láminas de elementos
		
		BorderPane layout = new BorderPane();
		
		//************************************************************************** Líneas ************************************************************************
		
		//Establezo el layout para los elementos de panel1
		
		GridPane gridPane = new GridPane();
		
		//Estabkezco el ancho de cada celda del gridPane y la alineación de los elementos en su interior
		
		ColumnConstraints columna1 = new ColumnConstraints();
		
		columna1.setPercentWidth(25);
		
		columna1.setHalignment(HPos.CENTER);
		
		ColumnConstraints columna2 = new ColumnConstraints();
		
		columna2.setPercentWidth(25);
		
		columna2.setHalignment(HPos.CENTER);
		
		ColumnConstraints columna3 = new ColumnConstraints();
		
		columna3.setPercentWidth(25);
		
		columna3.setHalignment(HPos.CENTER);
		
		ColumnConstraints columna4 = new ColumnConstraints();
		
		columna4.setPercentWidth(25);
		
		columna4.setHalignment(HPos.CENTER);
		
		gridPane.getColumnConstraints().addAll(columna1,columna2,columna3,columna4);
		
		//Hago visible las lineas del gridPane
		
		gridPane.setGridLinesVisible(true);
		
		//Centro los elementos 
		
		gridPane.setAlignment(Pos.CENTER);
		
		/*Creo los elementos que irán dentro de este primer panel, cada uno con propiedades,
		 * posición y forma diferentes */
		
		//Linea horizontal
		
		Line linea1 = new Line(50.0f,100.0f,140.0f,100.0f);
		linea1.setStrokeWidth(20.0f);
		linea1.setStroke(Color.BLUE);
		linea1.setStrokeLineCap(StrokeLineCap.ROUND);
		
		System.out.println(linea1.getLayoutBounds());
		
		//Linea vertical
		Line linea2 = new Line(250.0f,50.0f,250.0f,150.0f);
		linea2.setStrokeWidth(10.0f);
		linea2.setStroke(Color.RED);
		linea2.setStrokeLineCap(StrokeLineCap.SQUARE);
		
		//Linea diagonal hacia la derecha
		Line linea3 = new Line(340.0f,150.0f, 440.0f, 50.0f);
		linea3.setStrokeWidth(5.0f);
		linea3.setStroke(Color.DARKMAGENTA);
		linea3.setStrokeLineCap(StrokeLineCap.BUTT);
		
		//Linea diagonal hacia la izquierda
		Line linea4 = new Line(460.0f, 50.0f, 560.0f, 150.0f);
		linea4.setStrokeWidth(15.0f);
		linea4.setStroke(Color.YELLOWGREEN);
		linea4.setStrokeLineCap(StrokeLineCap.ROUND);
		
		//Coloco cada elemento en su posición dentro del GridPane
		
		GridPane.setConstraints(linea1, 0, 0);
		GridPane.setConstraints(linea2, 1, 0);
		GridPane.setConstraints(linea3, 2, 0);
		GridPane.setConstraints(linea4, 3, 0);
		
		//Añado los elementos creados al gridPane y establezco su layout
		
		gridPane.getChildren().addAll(linea1,linea2,linea3,linea4);
		
		layout.setTop(gridPane);
		
		//*************************************************************** Formas Geométricas ************************************************************************
		
		//Creo la lámina que contendrá los elementos y establezo su disposición
		
		Pane panel2 = new Pane();
		
		//Establezco un color de fondo para diferenciar esta zona de la anterior
		
		panel2.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE,CornerRadii.EMPTY,Insets.EMPTY)));
		
		//Creo las formas geométricas
		
		//Circulo
		
		Circle circulo = new Circle(75,75,50);
		
		circulo.setFill(Color.DARKBLUE);
				
		//Cuadrado
		
		Rectangle cuadrado = new Rectangle(220, 150, 100, 100);
		
		//Pentagono
		
		Polygon pentagono = new Polygon();
		
		pentagono.getPoints().addAll(new Double[]{
			
			400.0, 350.0,
			
			450.0, 300.0,
			
			500.0, 350.0,
			
			475.0, 400.0,
			
			425.0, 400.0
				
		});
		
		pentagono.setFill(Color.RED);
		
		//Añado los elementos al panel2 y establezco el layout del panel2
		
		panel2.getChildren().addAll(circulo, cuadrado, pentagono);
		
		layout.setCenter(panel2);
		

		//*************************************************************** Botones ********************************************************************************
		
		//Creo una tercera zona donde ubico los botones
		
		GridPane panelBotones = new GridPane();
		
		panelBotones.setAlignment(Pos.CENTER);
		
		//Establlezco las características de cada celda donde inserto los botones
		
		ColumnConstraints boton1 = new ColumnConstraints();
		
		boton1.setPrefWidth(350);
		
		boton1.setHalignment(HPos.CENTER);
		
		ColumnConstraints boton2 = new ColumnConstraints();
		
		boton2.setPrefWidth(350);
		
		boton2.setHalignment(HPos.CENTER);
		
		ColumnConstraints boton3 = new ColumnConstraints();
		
		boton3.setPrefWidth(350);
		
		boton3.setHalignment(HPos.CENTER);
		
		ColumnConstraints boton4 = new ColumnConstraints();
		
		boton4.setHalignment(HPos.CENTER);
		
		ColumnConstraints boton5 = new ColumnConstraints();
		
		boton5.setHalignment(HPos.CENTER);
		
		ColumnConstraints boton6 = new ColumnConstraints();
		
		boton6.setHalignment(HPos.CENTER);
		
		panelBotones.getColumnConstraints().addAll(boton1, boton2, boton3, boton4, boton5, boton6);
		
		//Creo dos botones para cada forma: uno ejecuta la transformación el otro vuelve al estado inicial
		
		Button botonCirculo = new Button("Trasladar Círculo");
		
		Button botonCuadrado = new Button("Escalar Cuadrado");
		
		Button botonPentagono = new Button("Rotar Pentágono");
		
		Button botonRestableceCuad = new Button("Restablecer Cuadrado");
		
		Button botonRestableceCirc = new Button("Restablecer Círculo");
		
		Button botonRestablecePent = new Button("Restablecer Pentágono");
		
		//Añado cada botón a su celda
		
		GridPane.setConstraints(botonCirculo, 0, 0);
		
		GridPane.setConstraints(botonCuadrado, 1, 0);
		
		GridPane.setConstraints(botonPentagono, 2, 0);
		
		GridPane.setConstraints(botonRestableceCirc, 0, 1);
		
		GridPane.setConstraints(botonRestableceCuad, 1, 1);
		
		GridPane.setConstraints(botonRestablecePent, 2, 1);
		
		//Establezco la Funcionalidad de los botones
		
		//Funcionalidad de los botones que modifican el círculo 
		
		botonCirculo.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				circulo.setTranslateX(25);
				
				circulo.setTranslateY(150);
	
			}
			
		});
		
		botonRestableceCirc.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				circulo.setTranslateX(0);
				
				circulo.setTranslateY(0);
				
			}

		});
		
		//Funcionalidad de los botones que modifican el cuadrado
		
		botonCuadrado.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				cuadrado.setScaleX(2.0);
				
				cuadrado.setScaleY(2.0);
				
			}
			
		});
		
		botonRestableceCuad.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				cuadrado.setScaleX(1.0);
				
				cuadrado.setScaleY(1.0);
				
			}
			
		});
		
		//Funcionalidad de los botones que controlan la figura pentágono
		
		botonPentagono.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				pentagono.setRotate(180);
				
			}
			
		});
		
		botonRestablecePent.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				pentagono.setRotate(0);
				
			}
			
			
		});
		
		//Añado los botones a su panel
		
		panelBotones.getChildren().addAll(botonCirculo, botonCuadrado, botonPentagono, botonRestableceCirc, botonRestablecePent, botonRestableceCuad);
		
		layout.setBottom(panelBotones);
		
		//Creo la escena
		
		Scene escena = new Scene(layout, 600, 600);
		
		//Añado la escena creada al stage
		
		stage.setScene(escena);
		
		stage.setTitle("Diseño de Interfaces - Unidad 1 - Caso1");
		
		//Hago visible el stage
		
		stage.show();
		
	}
	
	//Lanzo la aplicación
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}

}