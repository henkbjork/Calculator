package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label display;
    @FXML
    private Button ac;
    @FXML
    private Button conversion;
    @FXML
    private Boolean[] operator = new Boolean[4];

    private double[] temporary = {0, 0};

    @FXML
    public void buttonPressed(Event event) {
        Button btn = (Button)event.getSource();
        if(display.getText().equals("0")) {
            ac.setText("C");
            display.setText("");
        }
        switch(btn.getId()) {
            case "one":
                display.setText(display.getText()+"1");
                break;
            case "two":
                display.setText(display.getText()+"2");
                break;
            case "three":
                display.setText(display.getText()+"3");
                break;
            case "four":
                display.setText(display.getText()+"4");
                break;
            case "five":
                display.setText(display.getText()+"5");
                break;
            case "six":
                display.setText(display.getText()+"6");
                break;
            case "seven":
                display.setText(display.getText()+"7");
                break;
            case "eight":
                display.setText(display.getText()+"8");
                break;
            case "nine":
                display.setText(display.getText()+"9");
                break;
            case "zero":
                display.setText(display.getText()+"0");
                break;
            case "comma":
                display.setText(display.getText()+".");
                break;
        }
    }

    @FXML
    public void operatorPressed(Event event) {
        Button btn = (Button)event.getSource();
        temporary[0] = Double.parseDouble(display.getText());
        switch(btn.getId()) {
            case "plus":
                operator[0] = true;
                break;
            case "minus":
                operator[1] = true;
                break;
            case "times":
                operator[2] = true;
                break;
            case "divided":
                operator[3] = true;
                break;
        }
        display.setText("");
    }

    public void delete() {
        ac.setText("AC");
        display.setText("0");

        for(int i=0; i<operator.length; i++) {
            operator[i] = false;
        }

        for(int i=0; i<temporary.length; i++) {
            temporary[i] = 0;
        }
    }

    public void result() {
        double result = 0;
        temporary[1] = Double.parseDouble(display.getText());
        if(operator[0]) {
            result = temporary[0] + temporary[1];
        } else if(operator[1]) {
            result = temporary[0] - temporary[1];
        } else if(operator[2]) {
            result = temporary[0] * temporary[1];
        } else if(operator[3]) {
            result = temporary[0] / temporary[1];
        }
        display.setText(Double.toString(result));
    }

    public void conversion() {
        if(!display.getText().equals("0")) {
            Double value = Double.parseDouble(display.getText());
            value *= -1;
            display.setText(value.toString());
        }
    }

    public void percentage() {
        Double value = Double.parseDouble(display.getText());
        value *= 0.01;
        display.setText(value.toString());
    }




}
