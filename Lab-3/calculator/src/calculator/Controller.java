package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    @FXML
    private Text outputNumber;
    @FXML
    private Text historyOperations;
    @FXML
    private GridPane grid;

    private boolean isStart = true;
    private String mInput = "0";
    private String operator = "";
    private boolean isInput = true;
    private boolean isError = false;
    private boolean isReset = false;
    private boolean isAdditionalOperator = false;
    private String lastInHistory = "";
    private String history = "";

    private Button currentButton;

    private Model model = new Model();

    @FXML
    public void number(ActionEvent ae) {

        if (isError)
            return;
        if (isStart) {
            outputNumber.prefWidth(0);
            mInput = "";
            isStart = false;
            isInput = true;
            outputNumber.setStyle("-fx-font-size: " + 35 + "px;");
            lastInHistory = "";

            if (isReset) {
                operator = "";
                model.setX(null);
                isReset = false;
                historyOperations.setText("");
            }
        }

        if (isInput) {
            String inputNumber = ((Button)ae.getSource()).getText();
            inputSymbol(inputNumber);
        }

        showNumber(processingInputNumber(mInput));
    }

    @FXML
    public void operatorProc(ActionEvent ae) {

        if (isError)
            return;

        String op = ((Button)ae.getSource()).getId();

        if (operator.equals(""))
            operator = op;

        if (isStart && isReset && model.getX() != null) {
            mInput = model.getX().toString();
            outputHistory(formatNumberInHistory("" + model.getX().doubleValue()), op);
        }

        if (model.getX() == null) {
            model.setX(new BigDecimal(mInput));
            outputHistory(mInput, op);
        }
        else {
            if (!isStart || (isAdditionalOperator && !isReset)) {
                try {
                    outputHistory(formatNumberInHistory("" +
                            (new BigDecimal(mInput)).doubleValue()), op);
                    model.setX(model.calculations(mInput, operator));
                    mInput = model.getX().toString();
                } catch (ArithmeticException e) {
                    outputNumber.setText(e.getMessage());
                    isError = true;
                    return;
                }
            }
        }

        if (model.getX().doubleValue() == Double.POSITIVE_INFINITY ||
                model.getX().doubleValue() == Double.NEGATIVE_INFINITY) {
            isError = true;
            outputNumber.setText("Overflow");
            return;
        }
        else
            showNumber(processingInputNumber("" + model.getX().doubleValue()));

        operator = op;

        if (isStart && !isReset && !isAdditionalOperator)
            changeOperatorInHistory(operator);

        isStart = true;
        isReset = false;
        isAdditionalOperator = false;
    }

    @FXML
    public void additionalOperator(ActionEvent ae) {
        if (isError)
            return;

        try {
            if (isStart && isReset) {
                outputHistory(formatNumberInHistory("" + model.getX().doubleValue()),
                        ((Button) ae.getSource()).getId());

                model.setX(model.additionalCalculations(model.getX().toString(),
                        ((Button) ae.getSource()).getId()));

                showNumber(processingInputNumber("" + model.getX().doubleValue()));
            }
            else {
                if (!(((Button) ae.getSource()).getId().equals("percentage")))
                    outputHistory(formatNumberInHistory("" + new BigDecimal(mInput).doubleValue()),
                            ((Button) ae.getSource()).getId());

                mInput = model.additionalCalculations(mInput,
                        ((Button) ae.getSource()).getId()).toString();

                if ((((Button) ae.getSource()).getId().equals("percentage")))
                    outputHistory(formatNumberInHistory("" + new BigDecimal(mInput).doubleValue()),
                            ((Button) ae.getSource()).getId());

                showNumber(processingInputNumber("" + new BigDecimal(mInput).doubleValue()));
            }
        }
        catch (ArithmeticException | NumberFormatException e) {
            outputNumber.setText(e.getMessage());
            isError = true;
            return;
        }

        if (!(((Button) ae.getSource()).getId().equals("negate")))
            isStart = true;
        isAdditionalOperator = true;
    }

    @FXML
    public void control(ActionEvent ae) {
        switch (((Button)ae.getSource()).getId()) {
            case "delete":
                if (isError)
                    return;

                if (!isStart) {
                    if (mInput.length() > 0)
                        mInput = mInput.substring(0, mInput.length() - 1);

                    if (mInput.length() != 0)
                        showNumber(processingInputNumber(mInput));
                    else
                        showNumber(processingInputNumber("0"));

                    isInput = true;
                }
                break;

            case "clearEntered":
                isStart = true;
                mInput = "0";
                outputNumber.setText("0");

                if (isError)
                    resetAll();

                if (isStart && isReset) {
                    model.setX(null);
                    operator = "";
                }

                break;

            case "clear":
                resetAll();
                break;

            case "equal":
                if (isError)
                    return;

                if (!operator.equals("")) {
                    try {
                        model.setX(model.calculations(mInput, operator));
                    }
                    catch (ArithmeticException e) {
                        outputNumber.setText(e.getMessage());
                        isError = true;
                        return;
                    }

                    double res = model.getX().doubleValue();
                    if (res == Double.POSITIVE_INFINITY || res == Double.NEGATIVE_INFINITY) {
                        isError = true;
                        outputNumber.setText("Overflow");
                        return;
                    }
                    else
                        showNumber(processingInputNumber("" + res));

                    isReset = true;
                }
                isStart = true;

                historyOperations.setText("");
                history = "";
                break;
        }
    }

    private void changeOperatorInHistory(String op) {
        if (!history.equals("")) {
            history = history.substring(0, history.length() - 2);
            switch (op) {
                case "multiply":
                    history += "* ";
                    break;
                case "divide":
                    history += "/ ";
                    break;
                case "plus":
                    history += "+ ";
                    break;
                case "minus":
                    history += "- ";
                    break;
            }
            historyOperations.setText(history);
        }
    }

    private void outputHistory(String number, String operator) {
        if (lastInHistory.equals(""))
            lastInHistory = number;

        switch (operator) {
            case "plus":
                history += lastInHistory + " + ";
                historyOperations.setText(history);

                lastInHistory = "";
                break;

            case "minus":
                history += lastInHistory + " - ";
                historyOperations.setText(history);

                lastInHistory = "";
                break;

            case "multiply":
                history += lastInHistory + " * ";
                historyOperations.setText(history);

                lastInHistory = "";
                break;

            case "divide":
                history += lastInHistory + " / ";
                historyOperations.setText(history);

                lastInHistory = "";
                break;

            case "sqrt":
                lastInHistory = "sqrt(" + lastInHistory + ")";
                historyOperations.setText(history + lastInHistory + " ");
                break;

            case "percentage":
                lastInHistory = number;
                historyOperations.setText(history + lastInHistory + " ");
                break;

            case "sqr":
                lastInHistory = "sqr(" + lastInHistory + ")";
                historyOperations.setText(history + lastInHistory + " ");
                break;

            case "reciprocal":
                lastInHistory = "reciprocal(" + lastInHistory + ")";
                historyOperations.setText(history + lastInHistory + " ");
                break;

            case "negate":
                lastInHistory = "-" + number;
                historyOperations.setText(history + lastInHistory + " ");
                break;
        }

        if (historyOperations.getBoundsInLocal().getWidth() > 320)
            historyOperations.setText("«  " + historyOperations.getText().substring(
                    historyOperations.getText().length() - 44
            ));
    }

    private void showNumber(String output) {
        double fontSize = outputNumber.getFont().getSize();
        while (isInput) {
            if (((fontSize / 2) + 2.1) * output.length() > 370) {
                fontSize -= 2;
                if (fontSize > 21)
                    outputNumber.setStyle("-fx-font-size: " + fontSize + "px;");
                else
                    isInput = false;
            } else
                break;
        }
        outputNumber.setText(output);
    }

    private void inputSymbol(String symbol) {
        if (!(mInput.indexOf('.') != -1 && symbol.equals("."))) {
            if (symbol.equals(".") && mInput.length() == 0)
                mInput += "0";
            mInput += symbol;
        }
    }

    private String processingInputNumber(String inputNumber) {
        StringBuffer temp;
        int indexPoint = inputNumber.indexOf('.');
        int startIndex = 0;

        if (inputNumber.charAt(0) == '-')
            startIndex = 1;

        if (indexPoint == -1)
            temp = new StringBuffer(inputNumber.substring(startIndex, inputNumber.length()));
        else
            temp = new StringBuffer(inputNumber.substring(startIndex, indexPoint));

        if (temp.length() > 3) {
            int i = temp.length() / 3;
            int index = temp.length() - 3;
            while (i > 0 && index != 0) {
                temp.insert(index, ",", 0, 1);
                index -= 3;
                i--;
            }
        }

        if (startIndex == 1)
            temp.insert(0, '-');

        if (indexPoint != -1)
            if (!(indexPoint == inputNumber.length() - 2 &&
                    inputNumber.charAt(inputNumber.length() - 1) == '0'))
                temp.append(inputNumber.substring(indexPoint));

        return temp.toString();
    }

    private void resetAll() {
        model.setX(null);
        operator = "";
        mInput = "0";
        isError = false;
        isReset = false;
        isInput = true;
        isStart = true;
        historyOperations.setText("");
        outputNumber.setText("0");
        history = "";
        lastInHistory = "";
    }

    private String formatNumberInHistory(String number) {
        int index = number.indexOf(".");
        if (index == number.length() - 2 && number.charAt(index + 1) == '0')
            return number.substring(0, index);
        else
            return number;
    }

    private List<Button> keysPressed = new ArrayList<>();

    public void keyPressed(KeyEvent event) {
        int index = -1;

        switch (event.getCode().getName()) {
            case "Delete":
                index = 0;
                break;

            case "End":
                index = 1;
                break;

            case "Backspace":
                index = 2;
                break;
        }

        switch (event.getCode().getName()) {
            case "Divide":
            case "Slash":
                index = 3;
                break;
            case "7":
            case "Numpad 7":
                index = 4;
                break;
            case "8":
            case "Numpad 8":
                index = 5;
                break;
            case "9":
            case "Numpad 9":
                index = 6;
                break;
            case "Multiply":
                index = 7;
                break;
            case "4":
            case "Numpad 4":
                index = 8;
                break;
            case "5":
            case "Numpad 5":
                index = 9;
                break;
            case "6":
            case "Numpad 6":
                index = 10;
                break;
            case "Minus":
            case "Subtract":
                index = 11;
                break;
            case "1":
            case "Numpad 1":
                index = 12;
                break;
            case "2":
            case "Numpad 2":
                index = 13;
                break;
            case "3":
            case "Numpad 3":
                index = 14;
                break;
            case "Add":
            case "Plus":
                index = 15;
                break;
            case "0":
            case "Numpad 0":
                index = 18;
                break;
            case "Decimal":
            case "Period":
                index = 16;
                break;
            case "Enter":
                index = 17;
                break;
        }

        if (event.isShiftDown()) {
            switch (event.getCode()) {
                case DIGIT8:
                    System.out.println("a");
                    index = 7;
                    break;
                case EQUALS:
                    index = 15;
                    break;
            }
        }

        if (index == -1)
            return;

        currentButton = ((Button)grid.getChildren().get(index));

        currentButton.getStyleClass().add("click");
        keysPressed.add(currentButton);
        currentButton.fire();

    }
    public void keyReleased(KeyEvent event) {
        while (keysPressed.size() != 0) {
            keysPressed.get(0).getStyleClass().remove("click");
            keysPressed.remove(0);
        }
    }
}


