//Define the button cell

import javafx.scene.control.TableCell;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class ButtonCell extends TableCell<Product3, Boolean> {
        private Button cellButton;
        String dist;
     //   private Main5 main5 = new Main5();

        ButtonCell(String text) {
              cellButton = new Button("Action");
             cellButton.setText(text);
            cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                // do something when button is clicked :-
                    
                    System.out.println("Button clicked");
                    
                    Product3 product = (Product3)getTableRow().getItem();

                    if(product.getOrder_quantity() != 0)
	            {   System.out.println(product.getName() + " " + product.getCode() + " " + product.getDistributor() + " " + product.getOrder_quantity());
	            	dist = product.getDistributor();
	            	System.out.println(dist);
	            	
                   	Product4 product4 = new Product4(product.getCode(), product.getName(), product.getCategory(), product.getDistributor(), product.getOrder_quantity());	            	
	
	            	project.table62.getItems().add(product4);        
	            }
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
 }
