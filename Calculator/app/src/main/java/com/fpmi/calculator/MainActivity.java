package com.fpmi.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


     TextView input;
     TextView output;
     Button mc;
     Button ms;
     Button mr;
     Button m_plus;
     Button m_minus;
     Button backspace;
     Button plus_minus;
     Button c;
     Button n_0;
     Button n_1;
     Button n_2;
     Button n_3;
     Button n_4;
     Button n_5;
     Button n_6;
     Button n_7;
     Button n_8;
     Button n_9;
     Button sqrt;
     Button x;
     Button plus;
     Button mul;
     Button minus;
     Button equal;
     Button slash;
     Button point;
     Button right_bracket;
    Button left_bracket;
    String help = "";
    String expression = "";
    private double memory = 0;
    int warning = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews(){
        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);

        mc = (Button) findViewById(R.id.buttonMC);
        mr = (Button) findViewById(R.id.buttonMR);
        ms = (Button) findViewById(R.id.buttonMS);
        m_plus = (Button) findViewById(R.id.buttonMPLUS);
        m_minus = (Button) findViewById(R.id.buttonMMINUS);
        backspace = (Button) findViewById(R.id.button_back);
        plus_minus = (Button) findViewById(R.id.button_plus_minus);
        c = (Button) findViewById(R.id.button_C);
        n_0 = (Button) findViewById(R.id.button0);
        n_1 = (Button) findViewById(R.id.button1);
        n_2 = (Button) findViewById(R.id.button2);
        n_3 = (Button) findViewById(R.id.button3);
        n_4 = (Button) findViewById(R.id.button4);
        n_5 = (Button) findViewById(R.id.button5);
        n_6 = (Button) findViewById(R.id.button6);
        n_7 = (Button) findViewById(R.id.button7);
        n_8 = (Button) findViewById(R.id.button8);
        n_9 = (Button) findViewById(R.id.button9);
        sqrt = (Button) findViewById(R.id.button_sqrt);
        x = (Button) findViewById(R.id.button_X);
        plus = (Button) findViewById(R.id.button_plus);
        mul = (Button) findViewById(R.id.button_mul);
        minus = (Button) findViewById(R.id.button_minus);
        equal = (Button) findViewById(R.id.button_equal);
        slash = (Button) findViewById(R.id.button_slash);
        point = (Button) findViewById(R.id.button_point);
        left_bracket = (Button) findViewById(R.id.left_bracket);
        right_bracket = (Button) findViewById(R.id.right_bracket);

        mc.setOnClickListener(this);
        mr.setOnClickListener(this);
        ms.setOnClickListener(this);
        m_minus.setOnClickListener(this);
        m_plus.setOnClickListener(this);
        backspace.setOnClickListener(this);
        plus.setOnClickListener(this);
        plus_minus.setOnClickListener(this);
        c.setOnClickListener(this);
        n_0.setOnClickListener(this);
        n_1.setOnClickListener(this);
        n_2.setOnClickListener(this);
        n_3.setOnClickListener(this);
        n_4.setOnClickListener(this);
        n_5.setOnClickListener(this);
        n_6.setOnClickListener(this);
        n_7.setOnClickListener(this);
        n_8.setOnClickListener(this);
        n_9.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        x.setOnClickListener(this);
        point.setOnClickListener(this);
        mul.setOnClickListener(this);
        minus.setOnClickListener(this);
        equal.setOnClickListener(this);
        slash.setOnClickListener(this);
        left_bracket.setOnClickListener(this);
        right_bracket.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch
        (v.getId()) {
            case R.id.buttonMC:
                memory = 0;
                break;

            case R.id.buttonMS:
                memory = solveExpression(expression);
                break;

            case R.id.buttonMR:
                input.setText(Double.toString(memory));
                break;

            case R.id.buttonMPLUS:
                memory += solveExpression(expression);
                break;

            case R.id.buttonMMINUS:
                memory -= solveExpression(expression);
                break;

            case R.id.button_back:
                if(expression.length() != 0) {
                    if(Character.isDigit(expression.charAt(expression.length() - 1))) {
                        expression = expression.substring(0, expression.length() - 1);
                        input.setText(expression);
                    }
                    else{
                        if(expression.charAt(expression.length() - 1) == ' '){
                            if(expression.charAt(expression.length() - 2) == '(' ||
                                    expression.charAt(expression.length() - 2) == '√'){
                                expression = expression.substring(0, expression.length() - 2);
                                input.setText(expression);
                            }
                            else{
                                expression = expression.substring(0, expression.length() - 3);
                                input.setText(expression);
                            }
                        }
                        else{
                            expression = expression.substring(0, expression.length() - 2);
                            input.setText(expression);
                        }
                    }
                }
                break;
            case R.id.button_plus_minus:
                if(expression.length() != 0) {
                    if (expression.charAt(expression.length() - 1) != ' ' &&
                            expression.charAt(expression.length() - 1) != '.') {
                        expression = expression.concat(" * -1");
                        input.setText(expression);
                        warning = 0;
                    }
                }
                break;
            case R.id.button_C:
                expression = expression = "";
                input.setText("");
                output.setText("");
                warning = 0;
                break;
            case R.id.button0:
                if(expression.length() != 0) {
                    if (expression.charAt(expression.length() - 1) != '0') {
                        if(warning <= 16) {
                            expression = expression.concat("0");
                            input.setText(expression);
                            warning++;
                        }
                    }
                }
                else{
                    expression = expression.concat("0.");
                    input.setText(expression);
                }
                break;
            case R.id.button1:
                    if (warning <= 16) {
                        expression = expression.concat("1");
                        input.setText(expression);
                        warning++;
                    }
                break;
            case R.id.button2:
                if(warning <= 16) {
                expression = expression.concat("2");
                input.setText(expression);
                    warning++;
                }
                break;
            case R.id.button3:
                if(warning <= 16) {
                expression = expression.concat("3");
                input.setText(expression);
                warning++;
                }
                break;
            case R.id.button4:
                if(warning <= 16) {
                expression = expression.concat("4");
                input.setText(expression);
                    warning++;
                }
                break;
            case R.id.button5:
                if(warning <= 16) {
                expression = expression.concat("5");
                input.setText(expression);
                    warning++;
                }
                break;
            case R.id.button6:
                if(warning <= 16) {
                expression = expression.concat("6");
                input.setText(expression);
                    warning++;
                }
                break;
            case R.id.button7:
                if(warning <= 16) {
                expression = expression.concat("7");
                input.setText(expression);
                    warning++;
                }
                break;
            case R.id.button8:
                if(warning <= 16) {
                expression = expression.concat("8");
                input.setText(expression);
                    warning++;
                }
                break;
            case R.id.button9:
                if(warning <= 16) {
                expression = expression.concat("9");
                input.setText(expression);
                    warning++;
                }
                break;
            case R.id.button_plus:
                if(expression.length() != 0){
                    if(expression.charAt(expression.length() - 1) != ' ' &&
                            expression.charAt(expression.length() - 1) != '.') {
                        expression = expression.concat(" + ");
                        input.setText(expression);
                        warning = 0;
                    }
                }

                break;
            case R.id.button_minus:
                if(expression.length() != 0){
                    if(expression.charAt(expression.length() - 1) != ' ' &&
                            expression.charAt(expression.length() - 1) != '.') {
                        expression = expression.concat(" - ");
                        input.setText(expression);
                        warning = 0;
                    }
                }
                break;
            case R.id.button_slash:
                if(expression.length() != 0){
                    if(expression.charAt(expression.length() - 1) != ' ' &&
                            expression.charAt(expression.length() - 1) != '.') {
                        expression = expression.concat(" / ");
                        input.setText(expression);
                        warning = 0;
                    }
                }
                break;
            case R.id.button_mul:
                if(expression.length() != 0){
                    if(expression.charAt(expression.length() - 1) != ' ' &&
                            expression.charAt(expression.length() - 1) != '.') {
                        expression = expression.concat(" * ");
                        input.setText(expression);
                        warning = 0;
                    }
                }
                break;
            case R.id.button_equal:
                if(expression.length() != 0 && expression.charAt(expression.length() - 1) != ' ' &&
                        expression.charAt(expression.length() - 1) != '.') {
                    double answer = solveExpression(expression);
                    if(answer == Double.POSITIVE_INFINITY || answer == Double.NEGATIVE_INFINITY){
                        output.setText("Somewhere in the calculations there is a division by 0");
                    }
                    else{
                        output.setText(String.valueOf(answer));
                    }

                }
                break;
            case R.id.button_point:
                if(expression.length() != 0){
                    if(expression.charAt(expression.length() - 1) != ' ' &&
                            expression.charAt(expression.length() - 1) != '.') {
                        expression = expression.concat(".");
                        input.setText(expression);
                        warning = 0;
                    }
                }
                else{
                    expression = expression.concat("0.");
                    input.setText(expression);
                }
                break;
            case R.id.button_sqrt:
                if(expression.length() != 0 && expression.charAt(expression.length() - 1) != ' ' &&
                        expression.charAt(expression.length() - 1) != '.') {
                        help = "√ ( ";
                        help = help.concat(expression);
                        help = help.concat(" )");
                        expression = help;
                        input.setText(expression);
                        warning = 0;
                }
                break;
            case R.id.button_X:
                if(expression.length() != 0 && expression.charAt(expression.length() - 1) != ' ' &&
                        expression.charAt(expression.length() - 1) != '.') {
                        help = "1 / ( ";
                        help = help.concat(expression);
                        help = help.concat(" )");
                        expression = help;
                        input.setText(expression);
                        warning = 0;
                }
                break;
            case R.id.left_bracket:
                expression = expression.concat("( ");
                input.setText(expression);
                break;
            case R.id.right_bracket:
                expression = expression.concat(" )");
                input.setText(expression);
                break;
        }
    }

    private int priority(String x) {
        if (x.equals("(")) return 1;
        if (x.equals("+") || x.equals("-")) return 2;
        if (x.equals("√")) return 4;
        if (x.equals("*") || x.equals("/")) return 3;
        return 4;
    }

    public double solveExpression(String expression){
        return calc(polskaRecord(expression));
    }

    public String polskaRecord(String expression){
        Stack<String> charArr = new Stack<>();
        String output = "";
        String[] arr = expression.split(" ");
        for(String r: arr){
            if(r.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")){
                output = output.concat(r + " ");
            }
            else{
                if(r.length() != 0) {
                    if (r.equals(")")) {
                        while (!charArr.peek().equals("(")) {
                            output = output.concat(charArr.pop() + " ");
                        }
                        charArr.pop();
                    } else {
                        if (!charArr.empty()) {
                            if (!r.equals("(")) {
                                while (priority(r) < priority(charArr.peek())) {
                                    output = output.concat(charArr.pop() + " ");
                                    if(charArr.empty()){
                                        break;
                                    }
                                }
                            }
                        }
                        charArr.push(r);
                    }
                }
                }
            }
        while(!charArr.empty()){
            output = output.concat(charArr.pop() + " ");
        }
        return output;
    }

    public double calc(String expression){
        Stack<Double> stack = new Stack<>();
        String[] arr = expression.split(" ");
        double a;
        double b;
        for(String r: arr){
            if(r.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")){
                stack.push(Double.parseDouble(r));
            }
            else{
                switch (r){
                    case "+":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b + a);
                        break;
                    case "-":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b - a);
                        break;
                    case "*":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b * a);
                        break;
                    case "/":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b / a);
                        break;
                    case "√":
                        a = stack.pop();
                        stack.push(Math.sqrt(a));
                        break;

                }
            }
        }
        return stack.pop();
    }

}