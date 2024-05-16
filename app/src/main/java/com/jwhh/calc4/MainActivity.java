package com.jwhh.calc4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Screen;
    private Button AC,Seven,Eight,Nine,Four,Five,Six,Minus,Equal;
    private String input,Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen =findViewById(R.id.screen);
        AC=findViewById(R.id.ac);
        Seven=findViewById(R.id.seven);
        Eight=findViewById(R.id.eight);
        Nine=findViewById(R.id.nine);
        Four=findViewById(R.id.four);
        Five=findViewById(R.id.five);
        Six=findViewById(R.id.six);
        Minus=findViewById(R.id.minus);
        Equal=findViewById(R.id.equal);
    }
    public void ButtonClick (View view){
        Button button =(Button) view;
        String data = button.getText().toString();

        switch (data){
            case "AC":
                input="";
                break;
            case "-":
                Solve();
                input+=data;
                break;
            case "=":
                Solve();
                Answer=input;
                break;
            default:
                if(input==null){
                    input="";
                }
                input+=data;

        }
        Screen.setText(input);
    }

    private void Solve(){
        if(input.split("-").length==2) {
            String number[] = input.split("-");
            if (number[0].equals("")) {
                number[0] = "0";
            }
            try {
                double sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input = sub + "";
            } catch (Exception ex) {
            }
        }

                else if(input.split("-").length==3){
                    String number[] = input.split("-");
                    try{

                    double sub=Double.parseDouble(number[1])-Double.parseDouble(number[2]);
                    input=sub+" ";
                }


            catch (Exception ex){

            }
        }
        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
            Screen.setText(input);
        }
    }
}