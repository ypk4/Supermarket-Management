import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.layout.StackPane;

import javafx.scene.control.Separator;

import javafx.scene.control.SelectionMode;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableCell;
import javafx.util.Callback;

import javafx.scene.control.cell.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.lang.*;

import java.util.regex.Pattern;


import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.Separator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.*;
import javax.sql.rowset.BaseRowSet;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.InvocationTargetException;

import java.text.SimpleDateFormat;

import java.sql.Timestamp;


public class project extends Application {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   	static final String DB_URL = "jdbc:mysql://localhost/supermarket";
   	static final String USER = "Yogiraj";
   	static final String PASS = "123456";

	Scene scene2a, scene2b, scene1, scene3, scene4, scene5;
    	TextField priceInput2, nameInput2;
	Label cust_name2, cust_mob_no2, codeLabel, ackLabel;
	ComboBox<String> plist, plist1;
   	ResultSet rs_dist;
   	TextField mob_no_input;
    	
	Connection conn = null;
   	Statement stmt = null;

	TableView<Product> table;
    	TextField codeornameInput, quantityInput;
    	Label totalAmountLabel;
    	TableColumn<Product, Double> amountColumn;
	TableColumn<Product, String> codeColumn;
	TableColumn<Product, Integer> quantityColumn;
	TableColumn<Product, String> nameColumn;
	TableColumn<Product, Double> priceColumn;
	TextField custmobinput3, custnameinput3;

    	Double totalAmount = 0.0;

	String finallabel = "Code";
	String currentTime = "";

	TableView<Product2> table2;
    	TextField codeInput2, quantityInput2;
   	Label totalAmountLabel2;
    	TableColumn<Product2, Double> amountColumn2;
	Label dateLabel2;
	Label nameLabel2;
	Label mobNoLabel2;
	
	String custname5 = "";
	Double tot_amt = 0.0;
	String mob_no3;
	
	TextField mob_input2, mob_input3;


	TableView<Product3> table61;
    	public static TableView<Product4> table62;
    	//TextField codeInput, avail_quantityInput;
    	TableColumn col_action;
    	ResultSet rs_prod;
    
    	
	Scene scene6, scene7;
    
    
	ComboBox<String> comboBox7;
	TableView<Product5> table7;

    	//TextField codeInput3, quantityInput3;
    
    	Label totalAmountLabel3;

    	Label nameLabel3, dLabel3, ordLabel3, idLabel3;
    	TableColumn<Product5, Double> amountColumn3;

  	Stage window;
	ObservableList<Product4> allProducts;
	ObservableList<String> distNames;
	LinkedHashSet<String> distNamesDistinct;



    	String prev;
    	TextField nameInput8, emailInput8, mobInput8;
    	Label idInput8, ackLabel8;
    	Scene scene8;

	TextField stockInput9;
    	ComboBox<String> comboBox29;
    	Label ackLabel29;
	Scene scene9;


    	public static void main(String[] args) {
       		launch(args);
   	}


    	@Override
	@SuppressWarnings({"unchecked"})
	public void start(Stage primaryStage) throws Exception {
        	window = primaryStage;
        	window.setTitle("Supermarket");


	// Header
	HBox header = new HBox();
	header.setPadding(new Insets(0, 0,0,0));
       	header.setSpacing(0);

	Button CustBill = new Button("Customer Billing");
	CustBill.setMinHeight(40);
	CustBill.setMinWidth(110);
	CustBill.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	CustBill.setOnAction( e -> { window.setScene(scene1); clear_fields(); } );
 
	header.getChildren().add(CustBill);

	Separator s1 = new Separator();
	s1.setOrientation(Orientation.VERTICAL);

	header.getChildren().add(s1);

	Button orderStock = new Button("Order Stock");
	orderStock.setMinHeight(40);
	orderStock.setMinWidth(110);
	orderStock.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	orderStock.setOnAction( e -> { window.setScene(scene6); clear_fields();} );

 
	header.getChildren().add(orderStock);

	
       	Separator s2 = new Separator();
	s2.setOrientation(Orientation.VERTICAL);
	
	header.getChildren().add(s2);

	Button addNewProd = new Button("Add New Product");
	addNewProd.setMinHeight(40);
	addNewProd.setMinWidth(110);
	addNewProd.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewProd.setOnAction( e -> { changeScene5(); clear_fields();} ); //System.out.println("Hi") );//window.setScene(scene5));
 
	header.getChildren().add(addNewProd);

	Separator s3 = new Separator();
	s3.setOrientation(Orientation.VERTICAL);
	
	header.getChildren().add(s3);

	Button addNewDist = new Button("Add New Distributor");
	addNewDist.setMinHeight(40);
	addNewDist.setMinWidth(110);
	addNewDist.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");	addNewDist.setOnAction( e -> { window.setScene(scene8); clear_fields();});

 
	header.getChildren().add(addNewDist);


	Separator s4 = new Separator();
	s4.setOrientation(Orientation.VERTICAL);
	
	header.getChildren().add(s4);


	Button stockRec = new Button("Stock Received");
	stockRec.setMinHeight(40);
	stockRec.setMinWidth(110);
	stockRec.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	stockRec.setOnAction(e -> { window.setScene(scene9); clear_fields(); } );
  
	header.getChildren().add(stockRec);

	Separator base = new Separator();

	VBox vsep = new VBox();
	//vsep.setSpacing(0);

	vsep.getChildren().addAll(header, base); 


	
	//scene 1
	
        HBox h11 = new HBox();
        HBox h12 = new HBox();
       	h11.setSpacing(10.0);
       	h12.setSpacing(10.0);
		
       	GridPane grid1 = new GridPane();
        grid1.setPadding(new Insets(10, 10, 10, 10));

        grid1.setAlignment(Pos.TOP_CENTER);
        grid1.setVgap(38);

        grid1.setHgap(10);

        Label Enter_mob_no1 = new Label("Enter Mobile Number");
	Enter_mob_no1.setFont(Font.font("Arial", 30));
	
	h12.getChildren().add(Enter_mob_no1);

	h12.setAlignment(Pos.BOTTOM_CENTER);
 	GridPane.setConstraints(h12, 0, 0);

        mob_no_input = new TextField();

	mob_no_input.setMinHeight(40);
        GridPane.setConstraints(mob_no_input, 0, 1);
        
	String mob_no;
	
        Button search_1 = new Button("Search");
	search_1.setMinHeight(40);
	search_1.setMinWidth(80);
	search_1.setStyle("-fx-font: 22 arial");
	h11.getChildren().add(search_1);

	h11.setAlignment(Pos.BOTTOM_CENTER);
        GridPane.setConstraints(h11, 0, 2);

	search_1.setOnAction( e -> search(mob_no_input, mob_no_input.getText()) );
	    
      	grid1.getChildren().addAll(h12, mob_no_input, h11);

	VBox vbox_1 = new VBox();
	vbox_1.getChildren().addAll(vsep, grid1);
	vbox_1.setAlignment(Pos.TOP_CENTER);
     	scene1 = new Scene(vbox_1, 1300, 725);

        window.setScene(scene1);



// Header - 2a
	HBox header2a = new HBox();
	header2a.setPadding(new Insets(0, 0,0,0));
       	header2a.setSpacing(0);

	Button CustBill2a = new Button("Customer Billing");
	CustBill2a.setMinHeight(40);
	CustBill2a.setMinWidth(110);
	CustBill2a.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	CustBill2a.setOnAction( e -> { window.setScene(scene1); clear_fields(); });
 
	header2a.getChildren().add(CustBill2a);



	Separator s2a1 = new Separator();

	s2a1.setOrientation(Orientation.VERTICAL);


	header2a.getChildren().add(s2a1);


	Button orderStock2a = new Button("Order Stock");

	orderStock2a.setMinHeight(40);
	orderStock2a.setMinWidth(110);

	orderStock2a.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	orderStock2a.setOnAction( e -> { window.setScene(scene6); clear_fields(); } );



	header2a.getChildren().add(orderStock2a);
	

       	Separator s2a2 = new Separator();
	s2a2.setOrientation(Orientation.VERTICAL);
	
	header2a.getChildren().add(s2a2);

	Button addNewProd2a = new Button("Add New Product");

	addNewProd2a.setMinHeight(40);
	addNewProd2a.setMinWidth(110);
	addNewProd2a.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");

	addNewProd2a.setOnAction( e -> { changeScene5(); clear_fields(); } ); //System.out.println("Hi") );//window.setScene(scene5));

 
	header2a.getChildren().add(addNewProd2a);


	Separator s2a3 = new Separator();
	s2a3.setOrientation(Orientation.VERTICAL);

	header2a.getChildren().add(s2a3);

	Button addNewDist2a = new Button("Add New Distributor");
	addNewDist2a.setMinHeight(40);
	addNewDist2a.setMinWidth(110);
	addNewDist2a.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewDist2a.setOnAction( e -> { window.setScene(scene8); clear_fields(); } );


	header2a.getChildren().add(addNewDist2a);


	Separator s2a4 = new Separator();
	s2a4.setOrientation(Orientation.VERTICAL);
	
	header2a.getChildren().add(s2a4);

	Button stockRec2a = new Button("Stock Received");
	stockRec2a.setMinHeight(40);
	stockRec2a.setMinWidth(110);

	stockRec2a.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	stockRec2a.setOnAction( e -> { window.setScene(scene9); clear_fields(); } );

	header2a.getChildren().add(stockRec2a);

	Separator base2a = new Separator();

	VBox vsep2a = new VBox();
	//vsep.setSpacing(0);

	vsep2a.getChildren().addAll(header2a, base2a); 
	

//scene 2a

	HBox h21 = new HBox();
        HBox h22 = new HBox();
	HBox h23 = new HBox();
	HBox h24 = new HBox();
	HBox h25 = new HBox();
	
       	h21.setSpacing(10.0);
       	h22.setSpacing(10.0);
	h23.setSpacing(10.0);
	h24.setSpacing(20.0);
	h25.setSpacing(20.0);

	VBox v21 = new VBox();
	v21.setSpacing(20.0);
	
	VBox v22 = new VBox();
	v22.setSpacing(15.0);
	
	VBox v23 = new VBox();
	v23.setSpacing(15.0);
		
        GridPane grid2 = new GridPane();

        grid2.setPadding(new Insets(10, 10, 10, 10));

       	grid2.setAlignment(Pos.TOP_CENTER);
       	grid2.setVgap(38);

       	grid2.setHgap(10);


       	Label Enter_mob_no2 = new Label("Enter Mobile Number");
	Enter_mob_no2.setFont(Font.font("Arial", 30));
	
	h22.getChildren().add(Enter_mob_no2);

	h22.setAlignment(Pos.BOTTOM_CENTER);
 	GridPane.setConstraints(h22, 0, 0);
        
        mob_input2 = new TextField();

	mob_input2.setMinHeight(40);
        GridPane.setConstraints(mob_input2, 0, 1);       
	
        Button search_2 = new Button("Search");
	search_2.setMinHeight(40);
	search_2.setMinWidth(80);
	search_2.setStyle("-fx-font: 22 arial");
	h21.getChildren().add(search_2);

	h21.setAlignment(Pos.BOTTOM_CENTER);
        GridPane.setConstraints(h21, 0, 2);
	search_2.setOnAction( e -> search(mob_input2, mob_input2.getText()) );

    	Label cust_details = new Label("Customer Details:-");
	cust_details.setFont(Font.font("Arial", 30));
	
	h23.getChildren().add(cust_details);

	h23.setAlignment(Pos.BOTTOM_CENTER);
 	GridPane.setConstraints(h23, 0, 3);

	Label cust_name = new Label("Name:-");
	cust_name.setFont(Font.font("Arial", 30));
	
	v22.getChildren().add(cust_name);

	
 	Label cust_mob_no = new Label("Mobile Number:-");
	cust_mob_no.setFont(Font.font("Arial", 30));
	
	v22.getChildren().add(cust_mob_no);

	cust_name2 = new Label();
	cust_name2.setFont(Font.font("Arial", 30));
	
	v23.getChildren().add(cust_name2);

	cust_mob_no2 = new Label();
	cust_mob_no2.setFont(Font.font("Arial", 30));
	
	v23.getChildren().add(cust_mob_no2);
	
	h24.getChildren().addAll(v22, v23);
 	
	GridPane.setConstraints(h24, 0, 4);

	Label blanklabel = new Label("");
	blanklabel.setFont(Font.font("Arial", 30));
	
	v21.getChildren().add(blanklabel);

	v21.setAlignment(Pos.BOTTOM_CENTER);
 
	Button Proc_bill2 = new Button("Proceed to Billing");
	Proc_bill2.setMinHeight(40);
	Proc_bill2.setMinWidth(80);
	Proc_bill2.setStyle("-fx-font: 22 arial");
	v21.getChildren().add(Proc_bill2);

	v21.setAlignment(Pos.BOTTOM_CENTER);
	Proc_bill2.setOnAction( e -> { window.setScene(scene3);
				table.getItems().clear();
				totalAmount = calculateTotalAmount();	});	

	Button Go_back2 = new Button("Go Back");
	Go_back2.setMinHeight(40);
	Go_back2.setMinWidth(80);
	Go_back2.setStyle("-fx-font: 22 arial");
	v21.getChildren().add(Go_back2);

	v21.setAlignment(Pos.BOTTOM_CENTER);
       	GridPane.setConstraints(v21, 0, 5);
	Go_back2.setOnAction( e -> window.setScene(scene1));

      	grid2.getChildren().addAll(h22, mob_input2, h21, h23, h24, h25, v21);

	VBox vbox_2a = new VBox();
	vbox_2a.getChildren().addAll(vsep2a, grid2);
     	scene2a = new Scene(vbox_2a, 1300, 725);

        	//window.setScene(scene2a);


// Header - 2b
	HBox header2b = new HBox();
	header2b.setPadding(new Insets(0, 0,0,0));
       	header2b.setSpacing(0);

	Button CustBill2b = new Button("Customer Billing");
	CustBill2b.setMinHeight(40);
	CustBill2b.setMinWidth(110);
	CustBill2b.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	CustBill2b.setOnAction( e -> { window.setScene(scene1); clear_fields(); } );
 
	header2b.getChildren().add(CustBill2b);



	Separator s2b1 = new Separator();

	s2b1.setOrientation(Orientation.VERTICAL);


	header2b.getChildren().add(s2b1);


	Button orderStock2b = new Button("Order Stock");

	orderStock2b.setMinHeight(40);
	orderStock2b.setMinWidth(110);

	orderStock2b.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	orderStock2b.setOnAction( e -> { window.setScene(scene6); clear_fields(); });


	header2b.getChildren().add(orderStock2b);
	

       	Separator s2b2 = new Separator();
	s2b2.setOrientation(Orientation.VERTICAL);
	
	header2b.getChildren().add(s2b2);

	Button addNewProd2b = new Button("Add New Product");
	addNewProd2b.setMinHeight(40);
	addNewProd2b.setMinWidth(110);
	addNewProd2b.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");

	addNewProd2b.setOnAction( e -> { changeScene5(); clear_fields(); } ); //System.out.println("Hi") );//window.setScene(scene5));
 
	header2b.getChildren().add(addNewProd2b);

	Separator s2b3 = new Separator();
	s2b3.setOrientation(Orientation.VERTICAL);

	header2b.getChildren().add(s2b3);

	Button addNewDist2b = new Button("Add New Distributor");
	addNewDist2b.setMinHeight(40);
	addNewDist2b.setMinWidth(110);
	addNewDist2b.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewDist2b.setOnAction( e -> { window.setScene(scene8); clear_fields(); } );

	header2b.getChildren().add(addNewDist2b);

	Separator s2b4 = new Separator();
	s2b4.setOrientation(Orientation.VERTICAL);
	
	header2b.getChildren().add(s2b4);

	Button stockRec2b = new Button("Stock Received");
	stockRec2b.setMinHeight(40);
	stockRec2b.setMinWidth(110);
	stockRec2b.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	stockRec2b.setOnAction( e -> { window.setScene(scene9); clear_fields(); });
	header2b.getChildren().add(stockRec2b);

	Separator base2b = new Separator();
	VBox vsep2b = new VBox();
	vsep2b.setSpacing(0);

	vsep2b.getChildren().addAll(header2b, base2b); 



//scene 2b

	HBox h31 = new HBox();
        HBox h32 = new HBox();
	HBox h33 = new HBox();
	HBox h34 = new HBox();
	HBox h35 = new HBox();
       	h31.setSpacing(10.0);
       	h32.setSpacing(10.0);
	h33.setSpacing(10.0);
	h34.setSpacing(20.0);
	h35.setSpacing(20.0);

	VBox v31 = new VBox();
	v31.setSpacing(20.0);
	
	VBox v32 = new VBox();
	v32.setSpacing(15.0);
	
	VBox v33 = new VBox();
	v33.setSpacing(15.0);
		
        GridPane grid3 = new GridPane();

        grid3.setPadding(new Insets(10, 10, 10, 10));

       	grid3.setAlignment(Pos.TOP_CENTER);
       	grid3.setVgap(38);

       	grid3.setHgap(10);  

       	Label Enter_mob_no3 = new Label("Enter Mobile Number");
	Enter_mob_no3.setFont(Font.font("Arial", 30));
	
	h32.getChildren().add(Enter_mob_no3);

	h32.setAlignment(Pos.BOTTOM_CENTER);
 	GridPane.setConstraints(h32, 0, 0);

       	mob_input3 = new TextField();

	mob_input3.setMinHeight(40);
       	GridPane.setConstraints(mob_input3, 0, 1);

       	Button search_3 = new Button("Search");
	search_3.setMinHeight(40);
	search_3.setMinWidth(80);
	search_3.setStyle("-fx-font: 22 arial");
	h31.getChildren().add(search_3);

	h31.setAlignment(Pos.BOTTOM_CENTER);
       	GridPane.setConstraints(h31, 0, 2);
	search_3.setOnAction( e -> search(mob_input3, mob_input3.getText()) );

    	Label mobno_not_found = new Label("Mobile Number not found");
	mobno_not_found.setFont(Font.font("Arial", 30));
	
	h33.getChildren().add(mobno_not_found);

	h33.setAlignment(Pos.BOTTOM_CENTER);
 	GridPane.setConstraints(h33, 0, 3);
	
	Label create_acc = new Label("Create new account:");
	create_acc.setFont(Font.font("Arial", 30));
	
	h34.getChildren().add(create_acc);

	h34.setAlignment(Pos.BOTTOM_CENTER);
 	GridPane.setConstraints(h34, 0, 4);

	Label cust_name3 = new Label("Name:-");
	cust_name3.setFont(Font.font("Arial", 30));
	
	v32.getChildren().add(cust_name3);

	
 	Label cust_mob_no3 = new Label("Mobile Number:-");
	cust_mob_no3.setFont(Font.font("Arial", 30));
	
	v32.getChildren().add(cust_mob_no3);
	
	custnameinput3 = new TextField();

	custnameinput3.setMinHeight(40);
	custnameinput3.setMinWidth(250);
        v33.getChildren().add(custnameinput3);
	
	custmobinput3 = new TextField();

	custmobinput3.setMinHeight(40);
	custmobinput3.setMinWidth(250);
	//custmobinput3.setText(mob_no_input.getText());
        v33.getChildren().add(custmobinput3);

	h35.getChildren().addAll(v32, v33);
	 	
	GridPane.setConstraints(h35, 0, 5);	
	
	Label blanklabel3 = new Label("");
	blanklabel3.setFont(Font.font("Arial", 30));
	
	//v31.getChildren().add(blanklabel3);

	v31.setAlignment(Pos.BOTTOM_CENTER);

	Button Proc_bill3 = new Button("Create account and Proceed to Billing");
	Proc_bill3.setMinHeight(40);
	Proc_bill3.setMinWidth(80);
	Proc_bill3.setStyle("-fx-font: 22 arial");
	v31.getChildren().add(Proc_bill3);

	v31.setAlignment(Pos.BOTTOM_CENTER);
	Proc_bill3.setOnAction( e ->   {
		newaccount(custnameinput3.getText(), custmobinput3.getText());
		window.setScene(scene3);		

	});

	Button Go_back3 = new Button("Go Back");
	Go_back3.setMinHeight(40);
	Go_back3.setMinWidth(80);
	Go_back3.setStyle("-fx-font: 22 arial");
	v31.getChildren().add(Go_back3);

	v31.setAlignment(Pos.BOTTOM_CENTER);
        GridPane.setConstraints(v31, 0, 6);
	Go_back3.setOnAction( e -> window.setScene(scene1));

      	grid3.getChildren().addAll(h32, mob_input3, h31, h33, h34, h35, v31);

	VBox vbox_2b = new VBox();
	//vbox_2b.setAlignment(Pos.CENTER); 
	vbox_2b.getChildren().addAll(vsep2b, grid3);
     	scene2b = new Scene(vbox_2b, 1300, 725);



// Header - 3
	HBox header3 = new HBox();
	header3.setPadding(new Insets(0, 0,0,0));
       	header3.setSpacing(0);

	Button CustBill3 = new Button("Customer Billing");
	CustBill3.setMinHeight(40);
	CustBill3.setMinWidth(110);
	CustBill3.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	CustBill3.setOnAction( e -> { window.setScene(scene1); clear_fields(); });
 
	header3.getChildren().add(CustBill3);

	Separator s31 = new Separator();
	s31.setOrientation(Orientation.VERTICAL);

	header3.getChildren().add(s31);

	Button orderStock3 = new Button("Order Stock");
	orderStock3.setMinHeight(40);
	orderStock3.setMinWidth(110);
	orderStock3.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	orderStock3.setOnAction( e -> { window.setScene(scene6); clear_fields(); });

	header3.getChildren().add(orderStock3);
	
       	Separator s32 = new Separator();
	s32.setOrientation(Orientation.VERTICAL);
	
	header3.getChildren().add(s32);

	Button addNewProd3 = new Button("Add New Product");
	addNewProd3.setMinHeight(40);
	addNewProd3.setMinWidth(110);
	addNewProd3.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewProd3.setOnAction( e -> { changeScene5(); clear_fields();} ); //System.out.println("Hi") );//window.setScene(scene5));
 
	header3.getChildren().add(addNewProd3);

	Separator s33 = new Separator();
	s33.setOrientation(Orientation.VERTICAL);
	header3.getChildren().add(s33);

	Button addNewDist3 = new Button("Add New Distributor");
	addNewDist3.setMinHeight(40);
	addNewDist3.setMinWidth(110);
	addNewDist3.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewDist3.setOnAction( e -> { window.setScene(scene8); clear_fields(); } );

	header3.getChildren().add(addNewDist3);

	Separator s34 = new Separator();
	s34.setOrientation(Orientation.VERTICAL);
	
	header3.getChildren().add(s34);

	Button stockRec3 = new Button("Stock Received");
	stockRec3.setMinHeight(40);
	stockRec3.setMinWidth(110);
	stockRec3.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	stockRec3.setOnAction( e -> { window.setScene(scene9); clear_fields(); } );
	header3.getChildren().add(stockRec3);

	Separator base3 = new Separator();
	VBox vsep3 = new VBox();
	//vsep.setSpacing(0);

	vsep3.getChildren().addAll(header3, base3); 



//scene 3
	
        GridPane grid = new GridPane();
  				
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
       
        Label searchLabel = new Label("Search by :");

        GridPane.setConstraints(searchLabel, 0, 0);

       searchLabel.setFont(Font.font("Arial", 15));

 	Label codeornameLabel = new Label(finallabel + ":");

        	GridPane.setConstraints(codeornameLabel, 0, 1);

       	codeornameLabel.setFont(Font.font("Arial", 15));

        ComboBox<String> comboBox = new ComboBox<>();

        comboBox.getItems().addAll("Code", "Name");
        comboBox.setValue("Code");

	comboBox.setOnAction( e -> {
		codeornameLabel.setText(comboBox.getValue());
		finallabel = comboBox.getValue();		
	}
	 );


        GridPane.setConstraints(comboBox, 1, 0);

        codeornameInput = new TextField();

        //codeornameInput.setPromptText("password");

        GridPane.setConstraints(codeornameInput, 1, 1);        
        
        Label quantityLabel = new Label("Quantity :");

        GridPane.setConstraints(quantityLabel, 0, 2);

       quantityLabel.setFont(Font.font("Arial", 15));

        quantityInput = new TextField();

  	GridPane.setConstraints(quantityInput, 1, 2);

	Button addButton = new Button("Add to order list");

	addButton.setStyle("-fx-font: 15 arial");
	addButton.setOnAction(e -> addButtonClicked());

        GridPane.setConstraints(addButton, 1, 3);

        grid.getChildren().addAll(searchLabel, comboBox, codeornameLabel, codeornameInput, quantityLabel, quantityInput, addButton);

       Separator separator = new Separator();
 
       StackPane stackPane = new StackPane();

        Label orderListLabel = new Label("Order List");
   	orderListLabel.setFont(Font.font("Arial", 20));

        stackPane.getChildren().add(orderListLabel);

        codeColumn = new TableColumn<>("Code");
 
       codeColumn.setMinWidth(150);

        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));


        nameColumn = new TableColumn<>("Name");
       nameColumn.setMinWidth(350);
      nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
 
       priceColumn = new TableColumn<>("Price"); 
      priceColumn.setMinWidth(150);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

       quantityColumn = new TableColumn<>("Quantity");
       quantityColumn.setMinWidth(150);
      quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
	 
       amountColumn = new TableColumn<>("Amount");
       amountColumn.setMinWidth(150);
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

	
	table = new TableView<>();						
       	table.setItems(getProduct());
	table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	table.getColumns().addAll(codeColumn, nameColumn, priceColumn, quantityColumn, amountColumn);
       
        totalAmountLabel = new Label();
	totalAmount = calculateTotalAmount();

       	totalAmountLabel.setFont(Font.font("Arial", 20));	
        
	Button removeSelecButton = new Button("Remove selected order(s)");

	//System.out.println("before");

       	removeSelecButton.setOnAction(e -> removeSelecButtonClicked());

	//System.out.println("before");

	removeSelecButton.setStyle("-fx-font: 15 arial");
		        
        Button removeAllButton = new Button("Remove all");
       	removeAllButton.setOnAction(e -> removeAllButtonClicked());
	removeAllButton.setStyle("-fx-font: 15 arial");
	
	Button cancelBillButton = new Button("Cancel bill and Go back");
       	cancelBillButton.setOnAction(e -> cancelBillButtonClicked());
	cancelBillButton.setStyle("-fx-font: 15 arial");		
                				
	Button makeBillButton = new Button("Make bill");	
	makeBillButton.setOnAction(e -> makeBillButtonClicked());	

	makeBillButton.setStyle("-fx-font: 15 arial");
	
	 
	HBox hBox = new HBox();		
	hBox.setPadding(new Insets(20, 25, 20, 25));

        hBox.setSpacing(100);
  
    	hBox.setMargin(removeSelecButton, new Insets(0, 0, 0, 80)); 
                       
	hBox.getChildren().addAll(removeSelecButton, removeAllButton, cancelBillButton, makeBillButton);

      
        VBox vBoxMain = new VBox();			
	vBoxMain.getChildren().addAll(vsep3, grid, separator, stackPane, table, totalAmountLabel, hBox);

      	scene3 = new Scene(vBoxMain, 1300, 725);


// Header - 4
	HBox header4 = new HBox();
	header4.setPadding(new Insets(0, 0,0,0));
       	header4.setSpacing(0);

	Button CustBill4 = new Button("Customer Billing");
	CustBill4.setMinHeight(40);
	CustBill4.setMinWidth(110);
	CustBill4.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	CustBill4.setOnAction( e -> { window.setScene(scene1); clear_fields(); } );
 
	header4.getChildren().add(CustBill4);

	Separator s41 = new Separator();
	s41.setOrientation(Orientation.VERTICAL);

	header4.getChildren().add(s41);

	Button orderStock4 = new Button("Order Stock");
	orderStock4.setMinHeight(40);
	orderStock4.setMinWidth(110);
	orderStock4.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	orderStock4.setOnAction( e -> { window.setScene(scene6); clear_fields();});

	header4.getChildren().add(orderStock4);
	
       	Separator s42 = new Separator();
	s42.setOrientation(Orientation.VERTICAL);
	
	header4.getChildren().add(s42);

	Button addNewProd4 = new Button("Add New Product");
	addNewProd4.setMinHeight(40);
	addNewProd4.setMinWidth(110);
	addNewProd4.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewProd4.setOnAction( e -> { changeScene5(); clear_fields();} ); //System.out.println("Hi") );//window.setScene(scene5));
 
	header4.getChildren().add(addNewProd4);

	Separator s43 = new Separator();
	s43.setOrientation(Orientation.VERTICAL);
	header4.getChildren().add(s43);

	Button addNewDist4 = new Button("Add New Distributor");
	addNewDist4.setMinHeight(40);
	addNewDist4.setMinWidth(110);
	addNewDist4.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");	
	//addNewDist.setOnAction( e -> window.setScene(scene8));
	addNewDist4.setOnAction( e -> { window.setScene(scene8); clear_fields();});
	header4.getChildren().add(addNewDist4);

	Separator s44 = new Separator();
	s44.setOrientation(Orientation.VERTICAL);
	
	header4.getChildren().add(s44);

	Button stockRec4 = new Button("Stock Received");
	stockRec4.setMinHeight(40);
	stockRec4.setMinWidth(110);
	stockRec4.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	stockRec4.setOnAction( e -> { window.setScene(scene9); clear_fields();});
	header4.getChildren().add(stockRec4);

	Separator base4 = new Separator();
	VBox vsep4 = new VBox();
	//vsep.setSpacing(0);

	vsep4.getChildren().addAll(header4, base4); 



// scene 4

	 //  HBox hBox = new HBox();
        	java.util.Date curDate2 = new java.util.Date();
        	SimpleDateFormat myFormat2 = new SimpleDateFormat(" E  dd-MM-yyyy  hh:mm:ss a");
        
        	dateLabel2 = new Label();
       	dateLabel2.setFont(Font.font("Arial", 15));
       	        
        	nameLabel2 = new Label();
       	nameLabel2.setFont(Font.font("Arial", 15));        
        
        	mobNoLabel2 = new Label();
       	mobNoLabel2.setFont(Font.font("Arial", 15));
        
        	VBox vBox2 = new VBox();
       	vBox2.setMargin(dateLabel2, new Insets(10, 10, 10, 40));        
       	vBox2.setMargin(nameLabel2, new Insets(10, 10, 10, 40)); 
       	vBox2.setMargin(mobNoLabel2, new Insets(10, 10, 10, 40));        
       	vBox2.getChildren().addAll(dateLabel2, nameLabel2, mobNoLabel2);			
        
              
        	// Horizontal separator line
        	Separator separator2 = new Separator();						
        

        	// Table heading
        	StackPane stackPane2 = new StackPane();
        	Label orderListLabel2 = new Label("Bill Details");				
       	orderListLabel2.setFont(Font.font("Arial", 18));      
        	stackPane2.getChildren().add(orderListLabel2);
        
	// Table :-
        	//Name column
        	TableColumn<Product2, String> nameColumn2 = new TableColumn<>("Name");
        	nameColumn2.setMinWidth(400);
        	nameColumn2.setCellValueFactory(new PropertyValueFactory<>("name2"));

        	//Price column
        	TableColumn<Product2, Double> priceColumn2 = new TableColumn<>("Price");
        	priceColumn2.setMinWidth(160);
        	priceColumn2.setCellValueFactory(new PropertyValueFactory<>("price2"));

        	//Quantity column
        	TableColumn<Product2, Integer> quantityColumn2 = new TableColumn<>("Quantity");
        	quantityColumn2.setMinWidth(160);
        	quantityColumn2.setCellValueFactory(new PropertyValueFactory<>("quantity2"));

	//Amount column
        	amountColumn2 = new TableColumn<>("Amount");
        	amountColumn2.setMinWidth(160);
        	amountColumn2.setCellValueFactory(new PropertyValueFactory<>("amount2"));

	table2 = new TableView<>();							
        	table2.setItems(getProducts());
	table2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	table2.getColumns().addAll(nameColumn2, priceColumn2, quantityColumn2, amountColumn2);
      
        	VBox amountBox2 = new VBox(10);
        	amountBox2.setPadding(new Insets(20, 25, 20, 25));
        	totalAmountLabel2 = new Label(); 
       	totalAmountLabel2.setFont(Font.font("Arial", 15));        
       	amountBox2.getChildren().add(totalAmountLabel2);


        	//Buttons
        	Button printBillButton2 = new Button("Confirm and Print Bill");
        	printBillButton2.setOnAction(e -> printBillButtonClicked(mob_no_input.getText()));
	printBillButton2.setStyle("-fx-font: 15 arial");		                        
        
        	Button goBackButton2 = new Button("Go Back");
        	goBackButton2.setOnAction(e -> goBackButtonClicked());
	goBackButton2.setStyle("-fx-font: 15 arial");		                        
        
        	Button startNewBillButton2 = new Button("Start New Bill");
        	startNewBillButton2.setOnAction(e -> startNewBillButtonClicked());			
	startNewBillButton2.setStyle("-fx-font: 15 arial");		                   
   
        	HBox hBox2 = new HBox();								
        	hBox2.setPadding(new Insets(20, 25,20,25));
        	hBox2.setSpacing(140);
      	hBox2.setMargin(printBillButton2, new Insets(0,0,0,100));        
       	hBox2.getChildren().addAll(printBillButton2, goBackButton2, startNewBillButton2);

	
	VBox vBoxMain2 = new VBox();								
       	vBoxMain2.getChildren().addAll(vsep4, vBox2, separator2, stackPane2, table2, amountBox2, hBox2);

       	scene4 = new Scene(vBoxMain2, 1300, 725);
       	
       	
       	
// Header - 5
	HBox header5 = new HBox();
	header5.setPadding(new Insets(0, 0,0,0));
       	header5.setSpacing(0);

	Button CustBill5 = new Button("Customer Billing");
	CustBill5.setMinHeight(40);
	CustBill5.setMinWidth(110);
	CustBill5.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	CustBill5.setOnAction( e -> { window.setScene(scene1); clear_fields();});
 
	header5.getChildren().add(CustBill5);

	Separator s51 = new Separator();
	s51.setOrientation(Orientation.VERTICAL);

	header5.getChildren().add(s51);

	Button orderStock5 = new Button("Order Stock");
	orderStock5.setMinHeight(40);
	orderStock5.setMinWidth(110);
	orderStock5.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	orderStock5.setOnAction( e -> {window.setScene(scene6); clear_fields();});

	header5.getChildren().add(orderStock5);
	
       	Separator s52 = new Separator();
	s52.setOrientation(Orientation.VERTICAL);
	
	header5.getChildren().add(s52);

	Button addNewProd5 = new Button("Add New Product");
	addNewProd5.setMinHeight(40);
	addNewProd5.setMinWidth(110);
	addNewProd5.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewProd5.setOnAction( e -> { changeScene5(); clear_fields();} ); //System.out.println("Hi") );//window.setScene(scene5));
 
	header5.getChildren().add(addNewProd5);

	Separator s53 = new Separator();
	s53.setOrientation(Orientation.VERTICAL);
	header5.getChildren().add(s53);

	Button addNewDist5 = new Button("Add New Distributor");
	addNewDist5.setMinHeight(40);
	addNewDist5.setMinWidth(110);
	addNewDist5.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewDist5.setOnAction( e -> { window.setScene(scene8); clear_fields(); } );

	header5.getChildren().add(addNewDist5);

	Separator s54 = new Separator();
	s54.setOrientation(Orientation.VERTICAL);
	
	header5.getChildren().add(s54);

	Button stockRec5 = new Button("Stock Received");
	stockRec5.setMinHeight(40);
	stockRec5.setMinWidth(110);
	stockRec5.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	stockRec5.setOnAction( e -> { window.setScene(scene9); clear_fields();});
	header5.getChildren().add(stockRec5);

	Separator base5 = new Separator();
	VBox vsep5 = new VBox();
	//vsep.setSpacing(0);

	vsep5.getChildren().addAll(header5, base5); 


       	
// scene5
        
        HBox h1 = new HBox();
        HBox h2 = new HBox();
	HBox h6 = new HBox();
	HBox h9 = new HBox();

       	h1.setSpacing(10.0);
       	h2.setSpacing(10.0);
	h6.setSpacing(20.0);
	h9.setSpacing(20.0);

	VBox v1 = new VBox();
	v1.setSpacing(20.0);
	
	VBox v2 = new VBox();
	v2.setSpacing(20.0);
	
	VBox v3 = new VBox();
	v3.setSpacing(20.0);
	
	VBox v4 = new VBox();
	v4.setSpacing(0);
	
	VBox v5 = new VBox();
	v5.setSpacing(0);

	HBox h5 = new HBox();
	h5.setSpacing(125.0);
		
        	GridPane grid4 = new GridPane();
	grid4.setPadding(new Insets(10, 10, 10, 10));

       	grid4.setAlignment(Pos.TOP_CENTER);
       	grid4.setVgap(38);

       	grid4.setHgap(10);
   
	Label l = new Label("Add new Product");
	l.setFont(Font.font("Arial", 30));
	
	h2.getChildren().add(l);
	h2.setAlignment(Pos.BOTTOM_CENTER);
 	
	Label lm = new Label("Name:");
	lm.setFont(Font.font("Arial", 28));

	plist1 = new ComboBox<>();
        	
	plist1.setPromptText("Select distributor name");
	//plist1.setValue("");

	plist1.setStyle("-fx-font: 22 arial");
	plist1.setMinWidth(250);
	//plist1.setEditable(true);
	plist1.getItems().addAll(all_dist_names());
	
	GridPane.setConstraints(plist1, 1, 4);
	
	GridPane.setConstraints(lm, 0, 0);
	
    	Label lm1 = new Label("Category:");
	lm1.setFont(Font.font("Arial", 28));
	GridPane.setConstraints(lm1, 0, 1);

	Label lm2 = new Label("Product code:");
	lm2.setFont(Font.font("Arial", 28));
	GridPane.setConstraints(lm2, 0, 2);
	
	Label lm3 = new Label("Price:");
	lm3.setFont(Font.font("Arial", 28));
	GridPane.setConstraints(lm3, 0, 3);

	Label lm4 = new Label("Distributor name:");
	lm4.setFont(Font.font("Arial", 28));
	GridPane.setConstraints(lm4, 0, 4);

	ackLabel = new Label();
	ackLabel.setFont(Font.font("Arial", 21));
	//GridPane.setConstraints(ackLabel, 0, 5);

	codeLabel = new Label();

	codeLabel.setMinHeight(40);
	codeLabel.setMinWidth(250);
	GridPane.setConstraints(codeLabel, 1, 2);
       
	plist = new ComboBox<>();

       	plist.setPromptText("Select category");

	plist.setStyle("-fx-font: 22 arial");
	plist.setMinWidth(250);
	//plist.setEditable(true);
	plist.getItems().addAll("Kitchenware & Crockery", "Electronic Appliances", "Clothing & Textiles", "Food Items", "Stationary", "Gift Items", "Other");
	
	// IMPORTANT : ADD CATEGORIES HERE
	
	GridPane.setConstraints(plist, 1, 1);
	
	priceInput2 = new TextField();
	priceInput2.setMinHeight(40);
	priceInput2.setMinWidth(250);
	GridPane.setConstraints(priceInput2, 1, 3);

	nameInput2 = new TextField();
	nameInput2.setMinHeight(40);
	nameInput2.setMinWidth(250);
	GridPane.setConstraints(nameInput2, 1, 0);
	
	Button b1 = new Button("Generate code and Add product");
	b1.setOnAction(e -> addprodcode());
	b1.setMinHeight(40);
	b1.setMinWidth(80);
	b1.setStyle("-fx-font: 22 arial");
	v1.getChildren().add(b1);

	v1.setAlignment(Pos.BOTTOM_CENTER);

	Button b2 = new Button("Clear fields");
	b2.setOnAction(e -> clearFields());
	b2.setMinHeight(40);
	b2.setMinWidth(80);
	b2.setStyle("-fx-font: 22 arial");
	v1.getChildren().add(b2);

	//v1.setAlignment(Pos.BOTTOM_CENTER);

      	grid4.getChildren().addAll(lm1, lm2, lm3, lm4, lm, plist1, plist, codeLabel, priceInput2, nameInput2);
	v2.getChildren().addAll(vsep5, h2, grid4, ackLabel, v1);


	
     	scene5 = new Scene(v2, 1320, 730);



// Header - 6
	HBox header6 = new HBox();
	header6.setPadding(new Insets(0, 0,0,0));
       	header6.setSpacing(0);

	Button CustBill6 = new Button("Customer Billing");
	CustBill6.setMinHeight(40);
	CustBill6.setMinWidth(110);
	CustBill6.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	CustBill6.setOnAction( e -> { window.setScene(scene1); clear_fields();});
 
	header6.getChildren().add(CustBill6);

	Separator s61 = new Separator();
	s61.setOrientation(Orientation.VERTICAL);

	header6.getChildren().add(s61);

	Button orderStock6 = new Button("Order Stock");
	orderStock6.setMinHeight(40);
	orderStock6.setMinWidth(110);
	orderStock6.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	orderStock6.setOnAction( e -> {window.setScene(scene6); clear_fields();});

	header6.getChildren().add(orderStock6);
	
       	Separator s62 = new Separator();
	s62.setOrientation(Orientation.VERTICAL);
	
	header6.getChildren().add(s62);

	Button addNewProd6 = new Button("Add New Product");
	addNewProd6.setMinHeight(40);
	addNewProd6.setMinWidth(110);
	addNewProd6.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewProd6.setOnAction( e -> { changeScene5(); clear_fields();} ); //System.out.println("Hi") );//window.setScene(scene5));
 
	header6.getChildren().add(addNewProd6);

	Separator s63 = new Separator();
	s63.setOrientation(Orientation.VERTICAL);
	header6.getChildren().add(s63);

	Button addNewDist6 = new Button("Add New Distributor");
	addNewDist6.setMinHeight(40);
	addNewDist6.setMinWidth(110);
	addNewDist6.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewDist6.setOnAction( e -> { window.setScene(scene8); clear_fields();});

	header6.getChildren().add(addNewDist6);

	Separator s64 = new Separator();
	s64.setOrientation(Orientation.VERTICAL);
	
	header6.getChildren().add(s64);

	Button stockRec6 = new Button("Stock Received");
	stockRec6.setMinHeight(40);
	stockRec6.setMinWidth(110);
	stockRec6.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	stockRec6.setOnAction( e -> { window.setScene(scene9); clear_fields();});
	header6.getChildren().add(stockRec6);

	Separator base6 = new Separator();
	VBox vsep6 = new VBox();
	//vsep.setSpacing(0);

	vsep6.getChildren().addAll(header6, base6); 



//scene 6

	StackPane stackPane6 = new StackPane();					// 1)
        	Label heading = new Label("Order new stock");				
       	heading.setFont(Font.font("Arial", 18));      
        	stackPane6.getChildren().add(heading);
        	stackPane6.setPadding(new Insets(10, 0, 20, 0));        
        
        // Label - constrains use (child, column, row)
        	Label searchLabel6 = new Label("Select product category :");
        	GridPane.setConstraints(searchLabel6, 0, 0);
       	searchLabel6.setFont(Font.font("Arial", 15));

      
	// Table :-
        //Code column
        	TableColumn<Product3, String> codeColumn61 = new TableColumn<>("Code");
        	codeColumn61.setMinWidth(80);
        	codeColumn61.setCellValueFactory(new PropertyValueFactory<>("code"));

        //Product Name column
        	TableColumn<Product3, String> nameColumn61 = new TableColumn<>("Name");
        	nameColumn61.setMinWidth(300);
        	nameColumn61.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        //Product Category column
        	TableColumn<Product3, String> categoryColumn61 = new TableColumn<>("Category");
        	categoryColumn61.setMinWidth(200);
        	categoryColumn61.setCellValueFactory(new PropertyValueFactory<>("category"));

        //Distributor Name column
        	TableColumn<Product3, String> distributorColumn61 = new TableColumn<>("Distributor");
        	distributorColumn61.setMinWidth(225);
        	distributorColumn61.setCellValueFactory(new PropertyValueFactory<>("distributor"));

	//Price column
        	TableColumn<Product3, Double> priceColumn61 = new TableColumn<>("Price");
        	priceColumn61.setMinWidth(125);
        	priceColumn61.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Avail_Quantity column
        	TableColumn<Product3, Integer> avail_quantityColumn61 = new TableColumn<>("Avail. Quantity");
        	avail_quantityColumn61.setMinWidth(110);
        	avail_quantityColumn61.setCellValueFactory(new PropertyValueFactory<>("avail_quantity"));

	//Order_Quantity column (TextField)
        	TableColumn<Product3, Number> order_quantityColumn61 = new TableColumn<>("Order Quantity");
        	order_quantityColumn61.setMinWidth(110);
        	order_quantityColumn61.setCellValueFactory(new PropertyValueFactory<>("order_quantity"));
        
        	order_quantityColumn61.setCellFactory(col -> new IntegerEditingCell());
        
        
        //Order button
        	Button btnNew = new Button();
    //    btnNew.setOnAction(e ->  System.out.println("Button clicked\n"));
        
        	col_action = new TableColumn<>("Click to order");
        	col_action.setSortable(false);

        	col_action.setCellValueFactory(
                	new Callback<TableColumn.CellDataFeatures<Product3, Boolean>, 
                	ObservableValue<Boolean>>() {

            		@Override
            		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Product3, Boolean> p) {
                			return new SimpleBooleanProperty(p.getValue() != null);
            		}
        	});


        	col_action.setCellFactory(
                	new Callback<TableColumn<Product3, Boolean>, TableCell<Product3, Boolean>>() {

            		@Override
            		public TableCell<Product3, Boolean> call(TableColumn<Product3, Boolean> p) {
                			return new ButtonCell("Add Order");
            		}

        	});


	table61 = new TableView<>();							//3)
	table61.setEditable(true);
        table61.setItems(getProduct3());
	table61.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	table61.getColumns().addAll(codeColumn61, nameColumn61, categoryColumn61, distributorColumn61, priceColumn61, avail_quantityColumn61, order_quantityColumn61, col_action);
              
         
         // Horizontal separator line
        	Separator separator6 = new Separator();						// 2)
        
	/* Heading */
	StackPane stackPane62 = new StackPane();					// 1)
        	Label heading2 = new Label("Stock Order List");				
       	heading2.setFont(Font.font("Arial", 18));      
        	stackPane62.getChildren().add(heading2);
        	stackPane62.setPadding(new Insets(20, 0, 10, 0));           
         
         
        //Code column
        	TableColumn<Product4, String> codeColumn62 = new TableColumn<>("Code");
        	codeColumn62.setMinWidth(80);
        	codeColumn62.setCellValueFactory(new PropertyValueFactory<>("code"));      
              
        //Product Name column
        	TableColumn<Product4, String> nameColumn62 = new TableColumn<>("Name");
        	nameColumn62.setMinWidth(300);
       	nameColumn62.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        //Product Category column
        	TableColumn<Product4, String> categoryColumn62 = new TableColumn<>("Category");
        	categoryColumn62.setMinWidth(200);
        	categoryColumn62.setCellValueFactory(new PropertyValueFactory<>("category"));

        //Distributor Name column
        	TableColumn<Product4, String> distributorColumn62 = new TableColumn<>("Distributor");
        	distributorColumn62.setMinWidth(225);
        	distributorColumn62.setCellValueFactory(new PropertyValueFactory<>("distributor"));
      
        //Order_Quantity column
        	TableColumn<Product4, Number> order_quantityColumn62 = new TableColumn<>("Order Quantity");
        	order_quantityColumn62.setMinWidth(180);
        	order_quantityColumn62.setCellValueFactory(new PropertyValueFactory<>("order_quantity"));
              

	table62 = new TableView<>();							//3)
//        	table.setItems(getProduct3());
	table62.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	table62.getColumns().addAll(codeColumn62, nameColumn62, categoryColumn62, distributorColumn62, order_quantityColumn62);
        

        //Buttons
        	Button removeSelecButton6 = new Button("Remove selected order(s)");
       	removeSelecButton6.setOnAction(e -> removeSelecButtonClicked6());
	removeSelecButton6.setStyle("-fx-font: 15 arial");		        
        
        	Button removeAllButton6 = new Button("Remove all");
        	removeAllButton6.setOnAction(e -> removeAllButtonClicked6());
	removeAllButton6.setStyle("-fx-font: 15 arial");		                
        
        	Button cancelBillButton6 = new Button("Cancel ordering and Go back");
        	cancelBillButton6.setOnAction(e -> cancelBillButtonClicked6());
	cancelBillButton6.setStyle("-fx-font: 15 arial");		                			
   
	Button makeBillButton6 = new Button("Confirm bill and Continue");				
        	makeBillButton6.setOnAction(e -> makeBillButtonClicked6());	
	makeBillButton6.setStyle("-fx-font: 15 arial");		                
   
        	HBox hBox6 = new HBox();								// 4)
        	hBox6.setPadding(new Insets(20, 25, 20, 25));
        	hBox6.setSpacing(100);
      	hBox6.setMargin(removeSelecButton6, new Insets(0, 0, 0, 80));                
        	hBox6.getChildren().addAll(removeSelecButton6, removeAllButton6, cancelBillButton6, makeBillButton6);
                
        	VBox vBoxMain6 = new VBox();								
        	vBoxMain6.getChildren().addAll(vsep6, stackPane6, table61, separator6, stackPane62, table62, hBox6);
       

        	scene6 = new Scene(vBoxMain6, 1360, 745);
        	scene6.getStylesheets().add("columnheader.css");
        	//window.setScene(scene6);


// Header - 7
	HBox header7 = new HBox();
	header7.setPadding(new Insets(0, 0,0,0));
       	header7.setSpacing(0);

	Button CustBill7 = new Button("Customer Billing");
	CustBill7.setMinHeight(40);
	CustBill7.setMinWidth(110);
	CustBill7.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	CustBill7.setOnAction( e -> { window.setScene(scene1); clear_fields();});
 
	header7.getChildren().add(CustBill7);

	Separator s71 = new Separator();
	s71.setOrientation(Orientation.VERTICAL);

	header7.getChildren().add(s71);

	Button orderStock7 = new Button("Order Stock");
	orderStock7.setMinHeight(40);
	orderStock7.setMinWidth(110);
	orderStock7.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	orderStock7.setOnAction( e -> {window.setScene(scene6); clear_fields();});

	header7.getChildren().add(orderStock7);
	
       	Separator s72 = new Separator();
	s72.setOrientation(Orientation.VERTICAL);
	
	header7.getChildren().add(s72);

	Button addNewProd7 = new Button("Add New Product");
	addNewProd7.setMinHeight(40);
	addNewProd7.setMinWidth(110);
	addNewProd7.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewProd7.setOnAction( e -> { changeScene5(); clear_fields();} ); //System.out.println("Hi") );//window.setScene(scene5));
 
	header7.getChildren().add(addNewProd7);

	Separator s73 = new Separator();
	s73.setOrientation(Orientation.VERTICAL);
	header7.getChildren().add(s73);

	Button addNewDist7 = new Button("Add New Distributor");
	addNewDist7.setMinHeight(40);
	addNewDist7.setMinWidth(110);
	addNewDist7.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewDist7.setOnAction( e -> { window.setScene(scene8); clear_fields();});

	header7.getChildren().add(addNewDist7);

	Separator s74 = new Separator();
	s74.setOrientation(Orientation.VERTICAL);
	
	header7.getChildren().add(s74);

	Button stockRec7 = new Button("Stock Received");
	stockRec7.setMinHeight(40);
	stockRec7.setMinWidth(110);
	stockRec7.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	stockRec7.setOnAction( e -> { window.setScene(scene9); clear_fields();});
	header7.getChildren().add(stockRec7);

	Separator base7 = new Separator();
	VBox vsep7 = new VBox();
	//vsep.setSpacing(0);

	vsep7.getChildren().addAll(header7, base7); 


/* scene7 */
        
         GridPane grid7 = new GridPane();  				// 1)

        grid7.setPadding(new Insets(10, 10, 10, 10));
        grid7.setVgap(18);
        grid7.setHgap(10);

 
       // Search by Label - constrains use (child, column, row)

        Label searchLabel3 = new Label("Select distributor :");

        GridPane.setConstraints(searchLabel3, 0, 0);

       searchLabel3.setFont(Font.font("Arial", 15));

        comboBox7 = new ComboBox<String>();

        GridPane.setConstraints(comboBox7, 1, 0);
        
         Label codeLabel3 = new Label("Distributor name :");
	 nameLabel3 = new Label("");


	 GridPane.setConstraints(codeLabel3, 0, 1);

     	 codeLabel3.setFont(Font.font("Arial", 15));

	nameLabel3.setFont(Font.font("Arial", 15));

        GridPane.setConstraints(nameLabel3, 1, 1);


	Label idLabel3 = new Label("Order Id :");

       	 GridPane.setConstraints(idLabel3, 0, 2);

       	idLabel3.setFont(Font.font("Arial", 15));

	ordLabel3 = new Label("");

	ordLabel3.setFont(Font.font("Arial", 15));
       	
	GridPane.setConstraints(ordLabel3, 1, 2);

        
        
       	 Label dateLabel3 = new Label("Date :");

       	 GridPane.setConstraints(dateLabel3, 0, 3);

       	dateLabel3.setFont(Font.font("Arial", 15));

	 dLabel3 = new Label("");

	dLabel3.setFont(Font.font("Arial", 15));
       	
	GridPane.setConstraints(dLabel3, 1, 3);


	Label blank7 = new Label("");

	GridPane.setConstraints(blank7, 1, 4);

                
 	grid7.getChildren().addAll(searchLabel3, comboBox7, codeLabel3, nameLabel3, idLabel3, ordLabel3, dateLabel3, dLabel3, blank7);    
              
        
       	Separator separator3 = new Separator();
				
       	StackPane stackPane3 = new StackPane();

       	 Label orderListLabel3 = new Label("Order List");
			
   	orderListLabel3.setFont(Font.font("Arial", 20));

        stackPane3.getChildren().add(orderListLabel3);


        
	// Table :-
        
        //Name column

        TableColumn<Product5, String> nameColumn3 = new TableColumn<>("Name");
 
      	 nameColumn3.setMinWidth(450);
  
      	nameColumn3.setCellValueFactory(new PropertyValueFactory<>("name"));

        
      	TableColumn<Product5, String> serialNo3 = new TableColumn<>("Sr. No.");
  
      	serialNo3.setMinWidth(150);

       	serialNo3.setCellValueFactory(new PropertyValueFactory<>("srno"));


        //Quantity column
 
       	TableColumn<Product5, String> quantityColumn3 = new TableColumn<>("Quantity");
       	quantityColumn3.setMinWidth(425);
      	quantityColumn3.setCellValueFactory(new PropertyValueFactory<>("quantity"));


	table7 = new TableView<>();						// 5)

	table7.getColumns().addAll(serialNo3, nameColumn3, quantityColumn3);
 
     
       	Button GoBack = new Button("Print / Save as PDF");

	GoBack.setStyle("-fx-font: 15 arial");
	
	HBox hBox37 = new HBox();						// 7)
      
  	hBox37.setPadding(new Insets(20, 25, 20, 450));

       	hBox37.setSpacing(100);
               
 	 hBox37.getChildren().addAll(GoBack);
     
         	VBox vBoxMain37 = new VBox();			
	 vBoxMain37.getChildren().addAll(vsep7, grid7, separator3, stackPane3, table7, hBox37);
       
      	scene7 = new Scene(vBoxMain37, 1300, 725);


// Header - 8
	HBox header8 = new HBox();
	header8.setPadding(new Insets(0, 0,0,0));
       	header8.setSpacing(0);

	Button CustBill8 = new Button("Customer Billing");
	CustBill8.setMinHeight(40);
	CustBill8.setMinWidth(110);
	CustBill8.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	CustBill8.setOnAction( e -> { window.setScene(scene1); clear_fields();});
 
	header8.getChildren().add(CustBill8);

	Separator s81 = new Separator();
	s81.setOrientation(Orientation.VERTICAL);

	header8.getChildren().add(s81);

	Button orderStock8 = new Button("Order Stock");
	orderStock8.setMinHeight(40);
	orderStock8.setMinWidth(110);
	orderStock8.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	orderStock8.setOnAction( e -> { window.setScene(scene6); clear_fields();});

	header8.getChildren().add(orderStock8);
	
       	Separator s82 = new Separator();
	s82.setOrientation(Orientation.VERTICAL);
	
	header8.getChildren().add(s82);

	Button addNewProd8 = new Button("Add New Product");
	addNewProd8.setMinHeight(40);
	addNewProd8.setMinWidth(110);
	addNewProd8.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewProd8.setOnAction( e -> { changeScene5(); clear_fields();} ); //System.out.println("Hi") );//window.setScene(scene5));
 
	header8.getChildren().add(addNewProd8);

	Separator s83 = new Separator();
	s83.setOrientation(Orientation.VERTICAL);
	header8.getChildren().add(s83);

	Button addNewDist8 = new Button("Add New Distributor");
	addNewDist8.setMinHeight(40);
	addNewDist8.setMinWidth(110);
	addNewDist8.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewDist8.setOnAction( e -> { window.setScene(scene8); clear_fields();});

	header8.getChildren().add(addNewDist8);

	Separator s84 = new Separator();
	s84.setOrientation(Orientation.VERTICAL);
	
	header8.getChildren().add(s84);

	Button stockRec8 = new Button("Stock Received");
	stockRec8.setMinHeight(40);
	stockRec8.setMinWidth(110);
	stockRec8.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	stockRec8.setOnAction( e -> { window.setScene(scene9); clear_fields();});
	header8.getChildren().add(stockRec8);

	Separator base8 = new Separator();
	VBox vsep8 = new VBox();
	//vsep.setSpacing(0);

	vsep8.getChildren().addAll(header8, base8); 



//	scene 8

	HBox h18 = new HBox();
       	HBox h28 = new HBox();
	HBox h68 = new HBox();
	HBox h98 = new HBox();

       	h18.setSpacing(10.0);
       	h28.setSpacing(10.0);
	h68.setSpacing(20.0);
	h98.setSpacing(20.0);

	h28.setPadding(new Insets(30, 10, 30, 10));

	VBox v18 = new VBox();
	v18.setSpacing(30.0);
	
	VBox v28 = new VBox();
	v28.setSpacing(20.0);
	v18.setPadding(new Insets(30, 10, 30, 10));

//	
	VBox v38 = new VBox();
	v38.setSpacing(20.0);
//	
	VBox v48 = new VBox();
	v48.setSpacing(0);
//	
	VBox v58 = new VBox();
	v58.setSpacing(0);

	HBox h58 = new HBox();
	h58.setSpacing(125.0);
		
        GridPane grid8 = new GridPane();
       	grid8.setPadding(new Insets(10, 10, 10, 10));

       	grid8.setAlignment(Pos.TOP_CENTER);
       	grid8.setVgap(38);

       	grid8.setHgap(10);

        
	Label l81 = new Label("Add new Distributor");
	l81.setFont(Font.font("Arial", 40));
	
	h28.getChildren().add(l81);

	h28.setAlignment(Pos.CENTER);
 	
	Label lm82 = new Label("Name:");
	lm82.setFont(Font.font("Arial", 28));
        
	GridPane.setConstraints(lm82, 0, 0);
	
    	Label lm83 = new Label("Mobile number:");
	lm83.setFont(Font.font("Arial", 28));
	GridPane.setConstraints(lm83, 0, 2);

	Label lm84 = new Label("Distributor Id:");
	lm84.setFont(Font.font("Arial", 28));
	GridPane.setConstraints(lm84, 0, 1);
	
	Label lm85 = new Label("Email ID:");
	lm85.setFont(Font.font("Arial", 28));
	GridPane.setConstraints(lm85, 0, 3);

	mobInput8 = new TextField();

	mobInput8.setMinHeight(40);
	mobInput8.setMinWidth(250);
	GridPane.setConstraints(mobInput8, 1, 2);

	idInput8 = new Label();

	idInput8.setMinHeight(40);
	idInput8.setMinWidth(250);
	GridPane.setConstraints(idInput8, 1, 1);
       	
	emailInput8 = new TextField();

	emailInput8.setMinHeight(40);
	emailInput8.setMinWidth(250);
	GridPane.setConstraints(emailInput8, 1, 3);

	nameInput8 = new TextField();

	nameInput8.setMinHeight(40);
	nameInput8.setMinWidth(250);
	GridPane.setConstraints(nameInput8, 1, 0);
	
	ackLabel8 = new Label();
	GridPane.setConstraints(ackLabel8, 1, 4);	
  	
/*	Button b3 = new Button("Generate code");
	b3.setOnAction(e -> generateCode());
	b3.setMinHeight(40);
	b3.setMinWidth(80);
	b3.setStyle("-fx-font: 22 arial");
	GridPane.setConstraints(b3, 2, 0);*/

	
	Button b81 = new Button("Generate Id and Add");
	b81.setOnAction(e -> add_dist());
	b81.setMinHeight(40);
	b81.setMinWidth(80);
	b81.setStyle("-fx-font: 22 arial");
	v18.getChildren().add(b81);

	v18.setAlignment(Pos.BOTTOM_CENTER);

	Button b82 = new Button("Clear fields");
	b82.setOnAction(e -> goBack8());
	b82.setMinHeight(40);
	b82.setMinWidth(80);
	b82.setStyle("-fx-font: 22 arial");
	v18.getChildren().add(b82);


      	grid8.getChildren().addAll(lm82, lm83, lm84, lm85, nameInput8, idInput8, mobInput8, emailInput8, ackLabel8);
	v28.getChildren().addAll(vsep8, h28, grid8, v18);

	v28.setAlignment(Pos.TOP_CENTER);
	
     	scene8 = new Scene(v28, 1300, 725);


// Header - 9
	HBox header9 = new HBox();
	header9.setPadding(new Insets(0, 0,0,0));
       	header9.setSpacing(0);

	Button CustBill9 = new Button("Customer Billing");
	CustBill9.setMinHeight(40);
	CustBill9.setMinWidth(110);
	CustBill9.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	CustBill9.setOnAction( e -> { window.setScene(scene1); clear_fields();});
 
	header9.getChildren().add(CustBill9);

	Separator s91 = new Separator();
	s91.setOrientation(Orientation.VERTICAL);

	header9.getChildren().add(s91);

	Button orderStock9 = new Button("Order Stock");
	orderStock9.setMinHeight(40);
	orderStock9.setMinWidth(110);
	orderStock9.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	orderStock9.setOnAction( e -> { window.setScene(scene6); clear_fields();});

	header9.getChildren().add(orderStock9);
	
       	Separator s92 = new Separator();
	s92.setOrientation(Orientation.VERTICAL);
	
	header9.getChildren().add(s92);

	Button addNewProd9 = new Button("Add New Product");
	addNewProd9.setMinHeight(40);
	addNewProd9.setMinWidth(110);
	addNewProd9.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewProd9.setOnAction( e -> { changeScene5(); clear_fields();} );
	header9.getChildren().add(addNewProd9);

	Separator s93 = new Separator();
	s93.setOrientation(Orientation.VERTICAL);
	header9.getChildren().add(s93);

	Button addNewDist9 = new Button("Add New Distributor");
	addNewDist9.setMinHeight(40);
	addNewDist9.setMinWidth(110);
	addNewDist9.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	addNewDist9.setOnAction( e -> { window.setScene(scene8); clear_fields();});

	header9.getChildren().add(addNewDist9);

	Separator s94 = new Separator();
	s94.setOrientation(Orientation.VERTICAL);
	
	header9.getChildren().add(s94);

	Button stockRec9 = new Button("Stock Received");
	stockRec9.setMinHeight(40);
	stockRec9.setMinWidth(110);
	stockRec9.setStyle("-fx-font: 20 arial;"+" -fx-background-color: transparent;" + "-fx-padding: 1 25 1 25;");
	stockRec9.setOnAction( e -> { window.setScene(scene9); clear_fields();});
	header9.getChildren().add(stockRec9);

	Separator base9 = new Separator();
	VBox vsep9 = new VBox();
	//vsep.setSpacing(0);

	vsep9.getChildren().addAll(header9, base9); 



// scene 9

	 StackPane stackPane9 = new StackPane();
       	Label orderListLabel9 = new Label("Stock order received");			// 1)
      	orderListLabel9.setFont(Font.font("Arial", 22));
       	stackPane9.getChildren().add(orderListLabel9);
       	stackPane9.setPadding(new Insets(30, 15, 15, 0));
        
 	
 	// Horizontal separator line
        Separator separator91 = new Separator();						// 2)
      
       	GridPane grid9 = new GridPane();  						// 3)
       	grid9.setPadding(new Insets(45, 15, 15, 400));
       	grid9.setVgap(15);
       	grid9.setHgap(15);

      
        //Stock id Label
        Label stockLabel9 = new Label("Enter Order Id :");
        GridPane.setConstraints(stockLabel9, 0, 0);
       	stockLabel9.setFont(Font.font("Arial", 20));
       	
        //Stock id Input
        stockInput9 = new TextField();
    //    	codeInput.setPromptText("password");
        GridPane.setConstraints(stockInput9, 1, 0);
        
        //Quantity Label
        Label quantityLabel9 = new Label("Select Distributor :");
        GridPane.setConstraints(quantityLabel9, 0, 1);
       	quantityLabel9.setFont(Font.font("Arial", 20));
       	
        // Dropdown
        comboBox29 = new ComboBox<>();
        	/*try
		{ 
		String url = "jdbc:mysql://localhost/supermarket";			// jdbc:mysql://localhost/database_name
    		String user = "Yogiraj";
    		String password = "123456";

 	 	Connection con = DriverManager.getConnection(url, user, password);
	    	System.out.println("Connected successfully to Supermarket database");
			
	    	Statement stmt = con.createStatement();
	//    ResultSet rs_distrib = stmt.executeQuery("select name from distributor where id in (select id from dist_stockOrder where stock_id = " + Integer.valueOf(stockInput.getText()) + ")");
	// Add listener to stockInput, so that whenever it changes, comboBox2 items change accordingly
	    
	    	ResultSet rs_distrib = stmt.executeQuery("select name from distributor");
	    	ObservableList<String> dist_list9 = FXCollections.observableArrayList();
	    
	    	while(rs_distrib.next())
	    		dist_list9.add(rs_distrib.getString(1));
	    	
	    	comboBox29.setItems(dist_list9);
	
		}
		catch(Exception e)
		{	e.printStackTrace();
		}*/
	// --> combobox setItems()
	comboBox29.setItems(getDistributors());
        comboBox29.setPromptText("Select Distributor");
        GridPane.setConstraints(comboBox29, 1, 1);
        
        // Button
	Button addButton9 = new Button("Add Received Stock Details");
	addButton9.setStyle("-fx-font: 15 arial");		
        addButton9.setOnAction(e -> addButtonClicked9());
        GridPane.setConstraints(addButton9, 1, 2);
        
        ackLabel29 = new Label();
        StackPane spane29 = new StackPane();
        spane29.getChildren().add(ackLabel29);
        
        StackPane spane9 = new StackPane();
        spane9.getChildren().add(addButton9);
        spane9.setPadding(new Insets(90, 15, 15, 0));
        
        grid9.getChildren().addAll(stockLabel9, stockInput9, quantityLabel9, comboBox29);// addButton);      
        

        VBox vBoxMain9 = new VBox();								
        vBoxMain9.getChildren().addAll(vsep9, stackPane9, separator91, grid9, spane29, spane9);

        scene9 = new Scene(vBoxMain9, 1300, 725);

	window.show();
   }


    private boolean search(TextField input, String mob_no)
    {		
    		table.getItems().clear();
    		
    		try{
      		
      		//	Class.forName("com.mysql.jdbc.Driver");

      			if((mob_no_input.getText()).length() == 10)
      			{
      			conn = DriverManager.getConnection(DB_URL,USER,PASS);
      			stmt = conn.createStatement();
      			String sql;
   			
      			sql = "SELECT name, mob_no FROM customer WHERE mob_no = " + mob_no;
      			ResultSet rs = stmt.executeQuery(sql);
			
			String name = "none";
			String mobnumber = "none";
			while(rs.next()) {
				name = rs.getString("name");
				mobnumber = rs.getString("mob_no");
			}
			mob_no3 = mobnumber;
			custname5 = name;
			
			if(!(name.equals("none"))) {		//mob-no found

				
				window.setScene(scene2a);
				mob_input2.clear();
				cust_name2.setText(name);
				cust_mob_no2.setText(mobnumber);
				
				
			}
			else {			//mob-no not found
				
				window.setScene(scene2b);
				mob_input3.clear();
	   			custmobinput3.setText(mob_no_input.getText());
	   			//custmobinput3.setText(
   			}

      			rs.close();
      			stmt.close();
      			conn.close();
      		    }
   		}catch(SQLException se){
      				
      				se.printStackTrace();
   		}catch(Exception e){
      				e.printStackTrace();
   		}finally{
     
      				try{
         					if(stmt!=null)
            						stmt.close();
      				}catch(SQLException se2){

      				}

      				try{
         					if(conn!=null)
           						conn.close();
      				}catch(SQLException se){
         					se.printStackTrace();
      				}
  			 }

		return true;
	   }

	 private boolean newaccount(String name, String  mob_no){
   		mob_no3 = mob_no;
		custname5 = name;
		
		try{
      		
      		//	Class.forName("com.mysql.jdbc.Driver");

      			conn = DriverManager.getConnection(DB_URL,USER,PASS);
      			stmt = conn.createStatement();
      			String sql;
   			
      			sql = "INSERT INTO customer(mob_no, name) VALUES('" + mob_no + "','" + name + "')";
      			stmt.executeUpdate(sql);
		
      			stmt.close();
      			conn.close();
			
   			}catch(SQLException se){
      
      				se.printStackTrace();
   			}catch(Exception e){
      				e.printStackTrace();
   			}finally{
     
      				try{
         					if(stmt!=null)
            						stmt.close();
      				}catch(SQLException se2){

      				}

      				try{
         					if(conn!=null)
           						conn.close();
      				}catch(SQLException se){
         					se.printStackTrace();
      				}
  			 }
		return true;
	   }


   	public void addButtonClicked()
    	{	String codeorname = codeornameInput.getText();
		try{
      		
      		//	Class.forName("com.mysql.jdbc.Driver");

      			conn = DriverManager.getConnection(DB_URL,USER,PASS);
      			stmt = conn.createStatement();
      			String sql;
   			if(finallabel.equals("Code")) {
      				sql = "SELECT code, name, price, category, avail_quant FROM product WHERE code = '" + codeorname + "'";
			}
			else  {
				sql = "SELECT code, name, price, category, avail_quant FROM product WHERE name = '" + codeorname + "'";
			}
      			ResultSet rs = stmt.executeQuery(sql);
			
			
			String code = "none";
			String name = "none";
			Double price  = 0.0;
			String category = "none";
			int availq = 0;
			while(rs.next()) {
				code = rs.getString("code");
				name = rs.getString("name");
				price = rs.getDouble("price");
				category = rs.getString("category");
				availq = rs.getInt("avail_quant");
			}
			
			if((name.equals("none"))) {		//not found

				
				//window.setScene(scene2);
				//cust_name2.setText(name);
				//cust_mob_no2.setText(mobnumber);
				
			}
			else {		//found
					Product product = new Product(code, name, price, Integer.parseInt(quantityInput.getText()));
        				table.getItems().add(product);
       					codeornameInput.clear();
        				quantityInput.clear();	
					totalAmount = calculateTotalAmount();
			}

      
      			rs.close();
      			stmt.close();
      			conn.close();
   			}
   			catch(SQLException se){
      
      				se.printStackTrace();
   			}
   			catch(Exception e){
      				e.printStackTrace();
   			}
   			finally{
     
      				try{
         					if(stmt != null)
            						stmt.close();
      				}catch(SQLException se2){

      				}

      				try{
         					if(conn != null)
           						conn.close();
      				}catch(SQLException se){
         					se.printStackTrace();
      				}
  			 }

 		    	}

   
  	public void removeSelecButtonClicked()
    	{	         	System.out.println("before");
    	
	 	ObservableList<Product> productSelected, allProducts3;
		allProducts3 = table.getItems();
       		productSelected = table.getSelectionModel().getSelectedItems();
         	//productSelected.forEach(allProducts3::remove);
         	
         	System.out.println("Selected11");
         		
         	for(Product prod : productSelected)
			System.out.println(prod.getName()); 
		
		System.out.println("All11");
		
		for(Product prod2 : allProducts3)
			System.out.println(prod2.getName()); 
         	
         	//allProducts3.removeAll(productSelected);
       		productSelected.forEach(allProducts3::remove);         	
         	totalAmount = calculateTotalAmount();	

    	}

   
  
 	public void removeAllButtonClicked()
  	{	
 		table.getItems().clear();
         		totalAmount = calculateTotalAmount();	
  
 	}
   
    
  	public void cancelBillButtonClicked()
   	{
		totalAmount = calculateTotalAmount();
		table.getItems().clear();
  
		window.setScene(scene1);
		
 	}
   
   
	public void printBillButtonClicked(String mob_no)
  	{	
		String code = "none";			
		int quant = 0;
		int newquant = 0;
		int oldquant = 0;
		Double sum;
		
		try{
      		
      		//	Class.forName("com.mysql.jdbc.Driver");

      			conn = DriverManager.getConnection(DB_URL,USER,PASS);
      			stmt = conn.createStatement();
      			String sql1;
		
			sql1 = "INSERT into placedOrder(date_time, mob_no, total_amt) VALUES('" + currentTime + "','" + mob_no + "'," + tot_amt + ")";
			stmt.executeUpdate(sql1); 
			sql1 = "SELECT name from customer where mob_no = '" + mob_no + "'"; 
			ResultSet rs = stmt.executeQuery(sql1);
			
				
			/*while(rs.next()) {
				custname5 = rs.getString("name");
			}*/
      			stmt.close();
      			conn.close();
			
   			}catch(SQLException se){
      
      				se.printStackTrace();
   			}catch(Exception e){
      				e.printStackTrace();
   			}finally{
     
      				try{
         					if(stmt!=null)
            						stmt.close();
      				}catch(SQLException se2){

      				}

      				try{
         					if(conn!=null)
           						conn.close();
      				}catch(SQLException se){
         					se.printStackTrace();
      				}
  			 }

		int id = 0;
		int k = 0;
		for (int i = 0;  i < table.getItems().size(); i++)
    		{
			
			code  = (codeColumn.getCellData(i));
			
     			quant = (quantityColumn.getCellData(i));

			try{
      		
      		//	Class.forName("com.mysql.jdbc.Driver");

      			conn = DriverManager.getConnection(DB_URL,USER,PASS);
      			stmt = conn.createStatement();
      			String sql2;
			if(k != 1) {
				sql2 = "SELECT order_id FROM placedOrder ORDER BY order_id DESC LIMIT 1";
				ResultSet rs = stmt.executeQuery(sql2);
				while(rs.next()) {
					id = rs.getInt("order_id"); 

				}
				k++;
			}
   			 
      			sql2 =  "INSERT into order_product(order_id, code, ordered_quant) VALUES(" + id + ",'" + code + "'," + quant + ")";
      			stmt.executeUpdate(sql2);
		
      			stmt.close();
      			conn.close();
			
   			}catch(SQLException se){
      
      				se.printStackTrace();
   			}catch(Exception e){
      				e.printStackTrace();
   			}finally{
     
      				try{
         					if(stmt!=null)
            						stmt.close();
      				}catch(SQLException se2){

      				}

      				try{
         					if(conn!=null)
           						conn.close();
      				}catch(SQLException se){
         					se.printStackTrace();
      				}
  			 }
		}
		code = "none";			
		quant = 0;
		newquant = 0;
		oldquant = 0;
		

		for (int i = 0;  i < table.getItems().size(); i++)
    	{		//from here
			
			code  = (codeColumn.getCellData(i));
			
     			quant = (quantityColumn.getCellData(i));

			
			try{
      		
      		//	Class.forName("com.mysql.jdbc.Driver");

      			conn = DriverManager.getConnection(DB_URL,USER,PASS);
      			stmt = conn.createStatement();
      			String sql;
			sql = "SELECT avail_quant from product where code = '" + code + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				oldquant = rs.getInt("avail_quant");
				newquant = oldquant - quant; 

			}
   			 
      			sql = "UPDATE product SET avail_quant = '" + newquant + "' where code = '" + code + "'";
      			stmt.executeUpdate(sql);
		
      			stmt.close();
      			conn.close();
			
   			}catch(SQLException se){
      
      				se.printStackTrace();
   			}catch(Exception e){
      				e.printStackTrace();
   			}finally{
     
      				try{
         					if(stmt!=null)
            						stmt.close();
      				}catch(SQLException se2){

      				}

      				try{
         					if(conn!=null)
           						conn.close();
      				}catch(SQLException se){
         					se.printStackTrace();
      				}
  			 }


		}
			
		//window.setScene(scene5);
	
   	}

 
    	public ObservableList<Product> getProduct()
    	{	ObservableList<Product> products = FXCollections.observableArrayList();
      		return products;
    	}
  
  
   	public Double calculateTotalAmount()
    	{	
		Double sum = 0.0;
   
 		for (int i = 0;  i < table.getItems().size(); i++)
    		{
			//System.out.println(amountColumn.getCellData(i));
			sum = sum + (amountColumn.getCellData(i));
		}

		totalAmountLabel.setText("Total Amount : Rs " + sum);
	 	return sum;
    	}
 
  
	public ObservableList<Product2> getProducts() {
		String name = "none";
		Double price = 0.0;
		int quantity = 0;
		Double amount = 0.0;
		
	  	ObservableList<Product2> products2 = FXCollections.observableArrayList();
        
        	for (int i = 0;  i < table.getItems().size(); i++)
 	 	{
			name  = (nameColumn.getCellData(i));
			quantity = (quantityColumn.getCellData(i));

			price  = (priceColumn.getCellData(i));
			amount  = (amountColumn.getCellData(i));
			Product2 product = new Product2(name, price, quantity, amount);

        			table2.getItems().add(product);
 		}
		
        		return products2;
    	} 
    	
    	
	 public void makeBillButtonClicked() {
		window.setScene(scene4);
		tot_amt = 0.0;
		tot_amt  = calculateTotalAmount();	

		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		currentTime = sdf.format(dt);
		dateLabel2.setText("Date and Time:  " + currentTime);
		nameLabel2.setText("Customer Name: " + custname5);
		mobNoLabel2.setText("Registered Mobile Number: " + mob_no3);
		totalAmountLabel2.setText("Total amount : Rs " + tot_amt);
		String name = "none";
		Double price = 0.0;
		int quantity = 0;
		Double amount = 0.0;
		table2.getItems().clear();
	  	ObservableList<Product2> products2 = FXCollections.observableArrayList();
        	
        	for (int i = 0;  i < table.getItems().size(); i++)
    		{
			name  = (nameColumn.getCellData(i));
			quantity = (quantityColumn.getCellData(i));

			price  = (priceColumn.getCellData(i));
			amount  = (amountColumn.getCellData(i));
			Product2 product = new Product2(name, price, quantity, amount);

        			table2.getItems().add(product);
 	
		}
		//System.out.println("Print bill and insert record into db");
   	}


   //goBackButton Clicked
   	public void goBackButtonClicked() {
		window.setScene(scene3);
		 
   	}
   
   
   //startNewBill Clicked
   	public void startNewBillButtonClicked() {
		window.setScene(scene3);
		table.getItems().clear();
		
   	}
   	
   	
      public void addprodcode() {
	String url = "jdbc:mysql://localhost/supermarket";			// jdbc:mysql://localhost/database_name
 	String user = "Yogiraj";
	String password = "123456";
	String[] s = new String[2];
	String code;
 
	try
	{   Connection con = DriverManager.getConnection(url, user, password);
	    System.out.println("Connected successfully to Supermarket database");
			
	    Statement stmt = con.createStatement();
	    
	    int last_id;
	    
	    ResultSet rs = stmt.executeQuery("select max(code) from product where category = '" + plist.getValue() + "'");
	    
	    if(rs.first())
	    {	//s = (rs.getString(1)).split("-");
	    	//last_id = Integer.parseInt(s[1]);
	    	if(rs.getString(1) == null)
	    	{	System.out.println("here " + rs.getString(1));
   	     		last_id = 1;
   	        	code = (plist.getValue()).substring(0, 5);
   	        	code = code + "-" + last_id;
   	        }
		else
	    	{	System.out.println("Here " + rs.getString(1));
	    		s = (rs.getString(1)).split("-");
	    		last_id = Integer.parseInt(s[1]) + 1;

	        	code = (plist.getValue()).substring(0, 5);
	        	code = code + "-" + last_id;
	    	}
	    }
	    
	    else
	    	code = "new";
	    
				
  	    if(validateForm2() == 1)
  	    {	 	    
  	    	ackLabel.setText(" ");
  	    	
  	    	int j = 1;
  	    	
  	    	rs_dist = stmt.executeQuery("select * from distributor");
  	    	System.out.println(plist1.getValue());
  	    	
  	    	for( rs_dist.first(); rs_dist.next(); j++)
  	    	{	if(rs_dist.getString(2) == plist1.getValue())
  	    			break;
  	    	}
  	    	
  	    	rs_dist.absolute(j);
  	    	int id = rs_dist.getInt(1);
  	    	
  	    	int i = stmt.executeUpdate("insert into product(code, name, price, category, avail_quant, id) values('" + code + "', '" + nameInput2.getText() + "','" + priceInput2.getText() + "','" + plist.getValue() + "', '0', '" + id + "')");
  	    	Thread.sleep(500);
  	    	ackLabel.setText("Product record inserted for " + nameInput2.getText());
  	    	
  	    	codeLabel.setText(code);
  	    	
  	    	table61.getItems().clear();
  	    	table61.setItems(getProduct3());
  	    	
  	    }
  	    else
  	    {	ackLabel.setText("Either some field is empty or is in wrong format" + validateForm2());
  	    }
	    /*try
	    {	ResultSet rs = stmt.executeQuery("select distinct course_id from takes where ID = '" + args[0] + "'");
		System.out.println("Courses the student has enrolled for :");
		*/		
	}
	catch(Exception e)
	{	e.printStackTrace();
	}
    }
    
    
    public ObservableList<String> all_dist_names()
    {	//ObservableList<String> dist_names;
        ObservableList<String> dist_names = FXCollections.observableArrayList();
    	String url = "jdbc:mysql://localhost/supermarket";			// jdbc:mysql://localhost/database_name
 	String user = "Yogiraj";
	String password = "123456";
	
    	try
	{   Connection con = DriverManager.getConnection(url, user, password);
	    System.out.println("Connected successfully to Supermarket database");
	    
    	    Statement stmt = con.createStatement();
    	    rs_dist = stmt.executeQuery("select id, name from distributor");
    	    
    	    while(rs_dist.next())
    	    	dist_names.add(rs_dist.getString(2));
	}
	
	catch(Exception e)
	{   e.printStackTrace();
	}
	
	return dist_names;
    }
    
    
    public void clearFields()
    {	priceInput2.clear();
    	nameInput2.clear();
    	codeLabel.setText("");
    }
    
    
    public int validateForm2()
    {	if(priceInput2.getText() == "" || nameInput2.getText() == "" || plist1.getValue() == null)
    		return -1;
    	
    	return 1;
    }
    
    public void changeScene5()
    {	window.setScene(scene5);
    }



	//Remove selected button clicked
   public void removeSelecButtonClicked6()
    {	 ObservableList<Product4> productSelected, allProducts;
         allProducts = table62.getItems();
         productSelected = table62.getSelectionModel().getSelectedItems();

	System.out.println("Selected");
	for(Product4 prod : productSelected)
		System.out.println(prod.getName()); 
		
	System.out.println("All");
		
	for(Product4 prod2 : allProducts)
		System.out.println(prod2.getName()); 

         allProducts.removeAll(productSelected);
    }

   //removeAllButton clicked
   public void removeAllButtonClicked6()
   {	 table62.getItems().clear();
   }
   
   //cancelBillButton Clicked
   public void cancelBillButtonClicked6()
   {	System.out.println("Cancel ordering and Go back");
   }
   
   //makeBillButton Clicked
  public void makeBillButtonClicked6()
   {	System.out.println("Confirm bill and Continue");
   	// insert record into stockOrder, product_stockOrder, dist_stockOrder
   	
   	String url = "jdbc:mysql://localhost/supermarket";			// jdbc:mysql://localhost/database_name
 	String user = "Yogiraj";
	String password = "123456";
 
	try
	{   Connection con = DriverManager.getConnection(url, user, password);
	//	Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("Connected successfully to Supermarket database");
			
	    Statement stmt = con.createStatement();
	    
	    int last_stock_id;
	    
	    ResultSet rs = stmt.executeQuery("select max(stock_id) from stockOrder");
	    if(rs.first())
	    	last_stock_id = rs.getInt(1);
	    else
	    	last_stock_id = 0;
	    
	    last_stock_id++;
	    rs.close();
	
	    if(validateForm3() == 1)
  	    {	// 1. insert into stockOrder 	
  	    	int i = stmt.executeUpdate("insert into stockOrder(stock_id, date_time) values(" +  last_stock_id + ", now())");
  	    	
  	    	if(i > 1)	
  	    		System.out.println("Inserted in stockOrder");
  	    
  	    	// 2. insert into product_stockOrder        
	    	allProducts = FXCollections.observableArrayList();;
  	    	allProducts = table62.getItems();
            
    		for(Product4 prod : allProducts)
            	{	int j = stmt.executeUpdate("insert into product_stockOrder(stock_id, code, given_quant) values(" +  last_stock_id + ", '" + prod.getCode() + "', " + prod.getOrder_quantity() + ")");
            		if(j > 1)	
  	    			System.out.println("Inserted in product_stockOrder");
  	      	}
            	
            	// 3. insert into dist_stockOrder
            	distNames = FXCollections.observableArrayList();;
  	    	for(Product4 prod : allProducts)
  	    		distNames.add(prod.getDistributor());
  	    		
  	    	for(String s : distNames)
			System.out.println(s + "dist");
		
		LinkedHashSet<String> distNames_distinct = new LinkedHashSet();
		for(String s : distNames)
		{	if (!s.equals(String.valueOf(distNames_distinct)) && !(comboBox7.getItems().contains(s)))
    				distNames_distinct.add(s);
    		}
    		
		for(String s : distNames_distinct) {
			comboBox7.getItems().add(s);
		}
		ordLabel3.setText(String.valueOf(last_stock_id));
		
			
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dformat = new java.text.SimpleDateFormat("E dd.MM.yyyy hh:mm a");
		dLabel3.setText(dformat.format(date));


		comboBox7.setOnAction(e -> 
		{	nameLabel3.setText(comboBox7.getValue());
			table7.setItems(getProduct5());
		});
  	    	
  	    	String query = "select distinct id from distributor where name in (";
  	    	
  	    	i = 0;
  	    	for(String n : distNames)
  	    	{	if(i == 0)
  	    			query += "'" + n + "'";
  	    		else
  	    			query += ", '" + n + "'";
  	    		i++;
  	    	}
  	    	query += ")";
  	    		
  	    	System.out.println(query);
  	    	
  	   	ResultSet rs_dist_order = stmt.executeQuery(query);
  	   		    	
	    	CachedRowSet rowset = new CachedRowSetImpl();
		rowset.populate(rs_dist_order);
	    	
            	while(rowset.next())
            	{	//String query2 = 
            		int j = stmt.executeUpdate("insert into dist_stockOrder(id, stock_id, status) values(" +  rowset.getInt(1) + ", " + last_stock_id + ", 'ordered')");
            		if(j > 1)	
  	    			System.out.println("Inserted in dist_stockOrder");
  	    
               	}
               	rs_dist_order.close();
            	
         
//  	    	ackLabel.setText("Distributor record inserted");
  	    }
  	    else
  	    {	//ackLabel.setText("Either some field is empty or is in wrong format" + validateForm());
  	    }
  	    
  	   window.setScene(scene7);
            window.show();  	    		
	}
	catch(Exception e)
	{	e.printStackTrace();
	}
   }
   
   //Get all of the products :-
    public ObservableList<Product3> getProduct3()
    {   ObservableList<Product3> products = FXCollections.observableArrayList();
        
        String url = "jdbc:mysql://localhost/supermarket";			// jdbc:mysql://localhost/database_name
 	String user = "Yogiraj";
	String password = "123456";
	
    	try
	{   Connection con = DriverManager.getConnection(url, user, password);
		//Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("Connected successfully to Supermarket database");
	    
    	// ---->>>

	
     	    Statement stmt = con.createStatement();
		//uncomment the following 3 lines.
    	    rs_prod = stmt.executeQuery("select code, product.name, category, distributor.name, price, avail_quant from product join distributor on product.id = distributor.id");
    
    	    while(rs_prod.next())
		products.add(new Product3(rs_prod.getString(1), rs_prod.getString(2), rs_prod.getString(3), rs_prod.getString(4), Double.valueOf(rs_prod.getString(5)), Integer.valueOf(rs_prod.getString(6)), 0));
    	}
        
        catch(Exception e)
	{   e.printStackTrace();
	}
	
        
        return products;
    }
    

    public int validateForm3()
    {	
    	return 1;
    }


     public ObservableList<Product5> getProduct5()
    {
  	ObservableList<Product5> products = FXCollections.observableArrayList();
   	String dist = comboBox7.getValue();


        System.out.println(dist);
	table7.getItems().clear();
	
	int cnt = 1;
	
	for(Product4 prod : allProducts)
	{	if(dist.equals(prod.getDistributor()))
		{	products.add(new Product5(cnt, prod.getName(),  prod.getOrder_quantity()));
			cnt++;
		}
		System.out.println("product "+ prod.getName());
	}	
        return products;

    }


	public void add_dist() {
	String url = "jdbc:mysql://localhost/supermarket";			// jdbc:mysql://localhost/database_name
 	String user = "Yogiraj";
	String password = "123456";
	
 
	try
	{   Connection con = DriverManager.getConnection(url, user, password);
	    System.out.println("Connected successfully to Supermarket database");
			
	    Statement stmt = con.createStatement();
	    
	    int last_id;
	    
	    ResultSet rs = stmt.executeQuery("select max(id) from distributor");
	    
	    if(rs.first())
	    {	last_id = rs.getInt(1);
	    	System.out.println("Here ahs" + last_id);;
	    }
	    else
	    {	last_id = 0;
	    	System.out.println("Hi here" + last_id);
	    }
	    
	    last_id++;
	    
	    //idInput8.setText(String.valueOf(last_id));
				
  	    if(validateForm8() == 1)
  	    {	int i = stmt.executeUpdate("insert into distributor(id, name, mob_no, email) values('" + last_id + "', '" +  nameInput8.getText() + "','" + mobInput8.getText() + "','" + emailInput8.getText() + "')");
  	    	ackLabel8.setText("Distributor record inserted");
  	    	
  	    	idInput8.setText(String.valueOf(last_id));
  	    	  	    	
  	    	plist1.getItems().clear();
		plist1.getItems().addAll(all_dist_names());
		
		comboBox29.setItems(getDistributors());
	
  	    }
  	    else
  	    {	ackLabel8.setText("Either some field is empty or is in wrong format or Duplicate entry" + validateForm8());
  	    }
	    /*try
	    {	ResultSet rs = stmt.executeQuery("select distinct course_id from takes where ID = '" + args[0] + "'");
		System.out.println("Courses the student has enrolled for :");
		*/		
	}
	catch(Exception e)
	{	e.printStackTrace();
	}
     }
     
     public int validateForm8()
     {	String email_pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		//"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
     // "^(.+)@(.+)$"; //
        Pattern pattern = Pattern.compile(email_pattern);
     	Matcher matcher = pattern.matcher(emailInput8.getText());
     	
     	if(nameInput8.getText() == "" || mobInput8.getText() == "" || emailInput8.getText() == "" || (mobInput8.getText()).length() != 10 || matcher.matches() == false)
     		return -2;
     	try
     	{	//System.out.println(mobInput8.getText());
     		Long.valueOf(mobInput8.getText());
     	     	return 1;
     	}
     	catch(Exception e)
     	{	e.printStackTrace();
     		return -1;
     	}
//     	return true;
     }
     
     public void goBack8()
     {	nameInput8.clear();
     	mobInput8.clear();
     	emailInput8.clear();
     	ackLabel8.setText("");
     	idInput8.setText("");
//	window.setScene(scene1);
     }


    public ObservableList<String> getDistributors()
    {	ObservableList<String> dist_list9;
    	try
	{ 
		String url = "jdbc:mysql://localhost/supermarket";			// jdbc:mysql://localhost/database_name
    		String user = "Yogiraj";
    		String password = "123456";

 	 	Connection con = DriverManager.getConnection(url, user, password);
	    	System.out.println("Connected successfully to Supermarket database");
			
	    	Statement stmt = con.createStatement();
	//    ResultSet rs_distrib = stmt.executeQuery("select name from distributor where id in (select id from dist_stockOrder where stock_id = " + Integer.valueOf(stockInput.getText()) + ")");
	// Add listener to stockInput, so that whenever it changes, comboBox2 items change accordingly
	    
	    	ResultSet rs_distrib = stmt.executeQuery("select name from distributor");
	    	dist_list9 = FXCollections.observableArrayList();
	    
	    	while(rs_distrib.next())
	    		dist_list9.add(rs_distrib.getString(1));
	    	
	    	return dist_list9;
	    	//comboBox29.setItems(dist_list9);
	
	}
	catch(Exception e)
	{	e.printStackTrace();
		return null;
	}

    }
    

    public void addButtonClicked9()
    {	System.out.println("Stock received");
    	ackLabel29.setText("");
    	String url = "jdbc:mysql://localhost/supermarket";			// jdbc:mysql://localhost/database_name
    	String user = "Yogiraj";
    	String password = "123456";
    	try
	{   Connection con = DriverManager.getConnection(url, user, password);
	    System.out.println("Connected successfully to Supermarket database");
			
	    Statement stmt = con.createStatement();
	    ackLabel29.setText("");
	    
	    try
	    {	
	    	int stock_id = Integer.parseInt(stockInput9.getText());
	    	String dist = comboBox29.getValue();
	    
	//    	ResultSet rs_dist_id = stmt.executeQuery("select * from distributor where name = '" + dist + "'");
	    	
	    	int i = 0;
	    	
	    	//for(rs_dist_id.first(); rs_dist_id.next(); i++);
	    	
	    	///System.out.println(dist + i);
	    	
	    	
	//    	int dist_id = rs_dist_id.getInt(1);
	  ///  	System.out.println(dist_id);
	    		    	
	//    	int in = stmt.executeUpdate("update dist_stockOrder set status = 'delivered' where stock_id = '" + stock_id + "' and id = (select id from distributor where name = '" +  dist + "')");
	    	
//	    	ResultSet rs_status = stmt.executeQuery("select status from dist_stockOrder where id = '" + dist_id + "' and stock_id = '" + stock_id + "'");
	    	
//	    	ResultSet rs_status = stmt.executeQuery("select status from dist_stockOrder where id = (select id from distributor where name = '" + dist + "') and stock_id = '" + stock_id + "'");

///	    	String status = rs_status.getString(1);
	    	
//	    	if(status == "ordered")
//	    	{	
	    		int in = stmt.executeUpdate("update dist_stockOrder set status = 'delivered' where stock_id = '" + stock_id + "' and id = (select id from distributor where name = '" +  dist + "') and status = 'ordered'");
	  
	  		int in2;
	  		
	  		if(in != 0)
	  			in2 = stmt.executeUpdate("update product set avail_quant = avail_quant + (select given_quant from product_stockOrder where product.code = product_stockOrder.code and stock_id = " + stock_id + ") where code in (select code from product_stockOrder where stock_id = " + stock_id + ") and id = (select id from distributor where name = '" +  dist + "')");
	  		
	  		if(in == 0)
	    	 	ackLabel29.setText("Error in entering received stock details. Check stock_id input and distributor selected.");	
	    	else
	    		ackLabel29.setText("Received stock entries done successfully ");
	    		
	    	table61.getItems().clear();
	    	table61.setItems(getProduct3());
	    	
	    	//}
	    	
	  //  	else
	    //	 	ackLabel29.setText("Stock order from the distributor is already delivered");		    		
	    	
	    	con.close();
	    }
	    catch(Exception e)
	    {	//ackLabel2.setText();

	    	e.printStackTrace();
	    }
	}
	
	catch(Exception e)
	{	e.printStackTrace();
	}
    }
    
    
    public void clear_fields()
    {
    	mob_no_input.clear();
    	
    	plist1.valueProperty().set(null);
    	plist1.setPromptText("Select Distributor");
    	
    	plist.valueProperty().set(null);    	
    	plist.setPromptText("Select category");

    	totalAmountLabel.setText("");
    	
    	priceInput2.clear();
    	nameInput2.clear();    	
    	codeLabel.setText("");
    	ackLabel.setText("");
    	
    	table62.getItems().clear();
    	
    	mobInput8.clear();
    	emailInput8.clear();
    	nameInput8.clear();
    	idInput8.setText("");
    	ackLabel8.setText("");
    	
    	stockInput9.clear();
    	comboBox29.valueProperty().set(null);
       	comboBox29.setPromptText("Select Distributor");
       	ackLabel29.setText("");
       	
       	custmobinput3.clear();
       	custnameinput3.clear();
    
    }
}
