package com.t1908e.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.displayTextView = (TextView) findViewById(R.id.result);
    }

    public void handleNumberPress(View view) {
        TextView pressedTextView = (TextView) view;
        String pressedText = pressedTextView.getText().toString();
        displayTextView.setText(displayTextView.getText().toString().concat(pressedText));

    }

    public void handleClear(View view) {
        this.displayTextView.setText("");
    }

    public void handleEqualPress(View view) {
        String currentRes = displayTextView.getText().toString();
        String normalizeRes = currentRes.replace('x', '*');
        Expression exp = new Expression(normalizeRes);
        String res = String.valueOf(exp.calculate());
        displayTextView.setText(res);
    }

    public void handleBackSpace(View view) {
        if(displayTextView.getText().length() == 0) {
            return;
        }
        displayTextView.setText(displayTextView.getText().subSequence(0, displayTextView.getText().length() - 1));
    }
}