/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author dell pc
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private RadioButton auto_rb;
    @FXML
    private RadioButton manual_rb;
    @FXML
    private TextField t1;
    @FXML
    private Label l1;
    @FXML
    private Label l2;

    @FXML
    private TextField t2;
    @FXML
    private TextField t3;

    @FXML
    private Button submit_button;
    @FXML
    private Label label_output;
    @FXML
    private Label l3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleRadio(ActionEvent event) {
        manual_rb.setSelected(false);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        t1.setVisible(false);
        t2.setVisible(false);
        t3.setVisible(false);
        label_output.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");

        label_output.setText("Generating Dataset with" + "\n" + "Number of Items=75" + "\n" + "Zipf Factor=0.5" + "\n" + "Number of Transactions=1000");
    }

    @FXML
    private void handlemanual(ActionEvent event) {
        auto_rb.setSelected(false);
        t1.setText("");
        t2.setText("");
        t3.setText("");
        label_output.setText("");
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        t1.setVisible(true);
        t2.setVisible(true);
        t3.setVisible(true);

    }

    @FXML
    private void handleSubmitButton(ActionEvent event) throws IOException {

        if (manual_rb.isSelected() == true) {
            //int size,double skew,int numOfTransactions,int support,int setsize,boolean flag
            if (((t1.getText()).equals("") == true) || ((t1.getText()).equals("") == true) || ((t1.getText()).equals("") == true)) {
                label_output.setText("Enter Manual Values");

            } else {
                DatasetGenerator dg = new DatasetGenerator(Integer.parseInt(t1.getText()), Double.parseDouble(t2.getText()), Integer.parseInt(t3.getText()), false);
                dg.generate();
                label_output.setText(label_output.getText() + "\n" + "Generated dataset.txt");
            }
        } else if (auto_rb.isSelected() == true) {

            DatasetGenerator dg = new DatasetGenerator(true);
            dg.generate();
            label_output.setText(label_output.getText() + "\n" + "Generated dataset.txt");
        } else {
            label_output.setText("Select an option");
        }
    }
}
