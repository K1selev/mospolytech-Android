package com.example.simpletexteditor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private float mTextSize = 20;
    private EditText mEdit;
    private TextView tSize;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdit = (EditText) findViewById(R.id.edit_text);
        tSize = (TextView) findViewById(R.id.size);
        ToggleButton buttonB = (ToggleButton) findViewById(R.id.button_b);
        ToggleButton buttonI = (ToggleButton) findViewById(R.id.button_i);
        Button buttonSans = (Button) findViewById(R.id.button_sans);
        Button buttonSer = (Button) findViewById(R.id.button_serif);
        Button buttonMono = (Button) findViewById(R.id.button_monospace);
        Button buttonPlus = (Button) findViewById(R.id.button_plus);
        Button buttonMinus = (Button) findViewById(R.id.button_minus);
        ImageButton bRed = (ImageButton) findViewById(R.id.red);
        ImageButton bBlue = (ImageButton) findViewById(R.id.blue);
        ImageButton bGreen = (ImageButton) findViewById(R.id.green);
        ImageButton bBlueLight = (ImageButton) findViewById(R.id.blueLight);
        ImageButton bPink = (ImageButton) findViewById(R.id.pink);
        ImageButton bYellow = (ImageButton) findViewById(R.id.yellow);
        ImageButton bBlack = (ImageButton) findViewById(R.id.black);

        buttonB.setOnClickListener(this);
        buttonI.setOnClickListener(this);
        buttonSans.setOnClickListener(this);
        buttonSer.setOnClickListener(this);
        buttonMono.setOnClickListener(this);

        bRed.setOnClickListener(this);
        bBlue.setOnClickListener(this);
        bGreen.setOnClickListener(this);
        bBlueLight.setOnClickListener(this);
        bPink.setOnClickListener(this);
        bYellow.setOnClickListener(this);
        bBlack.setOnClickListener(this);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int but = v.getId();
        if (but == R.id.button_plus) {
            if (mTextSize < 72) {
                mTextSize += 2;
                mEdit.setTextSize(mTextSize);
                tSize.setText("Text size: " + String.format("%.0f", mTextSize));
            }
        }
        if (but == R.id.button_minus) {
            if (mTextSize > 18) {
                mTextSize -= 2;
                mEdit.setTextSize(mTextSize);
                tSize.setText("Text size: " + String.format("%.0f", mTextSize));
            }
        }
        if (but == R.id.button_b) {
            if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                mEdit.setTypeface(mEdit.getTypeface(),
                        Typeface.BOLD_ITALIC);
            else if (mEdit.getTypeface().getStyle() ==
                    Typeface.BOLD_ITALIC)
                mEdit.setTypeface(mEdit.getTypeface(),
                        Typeface.ITALIC);
            else if (mEdit.getTypeface().getStyle() == Typeface.BOLD)

                mEdit.setTypeface(Typeface.create(mEdit.getTypeface(),
                        Typeface.NORMAL));
            else mEdit.setTypeface(mEdit.getTypeface(),
                        Typeface.BOLD);
        }
        if (but == R.id.button_i) {
            if (mEdit.getTypeface().getStyle() == Typeface.BOLD)
                mEdit.setTypeface(mEdit.getTypeface(),
                        Typeface.BOLD_ITALIC);
            else if (mEdit.getTypeface().getStyle() ==
                    Typeface.BOLD_ITALIC)
                mEdit.setTypeface(mEdit.getTypeface(),
                        Typeface.BOLD);
            else if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)

                mEdit.setTypeface(Typeface.create(mEdit.getTypeface(),
                        Typeface.NORMAL));
            else mEdit.setTypeface(mEdit.getTypeface(),
                        Typeface.ITALIC);
        }
        if (but == R.id.button_sans) {
            if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                mEdit.setTypeface(Typeface.SANS_SERIF,
                        Typeface.ITALIC);
            else if (mEdit.getTypeface().getStyle() ==
                    Typeface.BOLD_ITALIC)
                mEdit.setTypeface(Typeface.SANS_SERIF,
                        Typeface.BOLD_ITALIC);
            else if (mEdit.getTypeface().getStyle() ==
                    Typeface.BOLD)
                mEdit.setTypeface(Typeface.SANS_SERIF,
                        Typeface.BOLD);
            else mEdit.setTypeface(Typeface.SANS_SERIF,
                        Typeface.NORMAL);
        }
        if (but == R.id.button_serif) {
            if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                mEdit.setTypeface(Typeface.SERIF, Typeface.ITALIC);
            else if (mEdit.getTypeface().getStyle() ==
                    Typeface.BOLD_ITALIC)
                mEdit.setTypeface(Typeface.SERIF,
                        Typeface.BOLD_ITALIC);
            else if (mEdit.getTypeface().getStyle() == Typeface.BOLD)
                mEdit.setTypeface(Typeface.SERIF, Typeface.BOLD);
            else mEdit.setTypeface(Typeface.SERIF, Typeface.NORMAL);
        }
        if (but == R.id.button_monospace) {
            if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                mEdit.setTypeface(Typeface.MONOSPACE,
                        Typeface.ITALIC);
            else if (mEdit.getTypeface().getStyle() ==
                    Typeface.BOLD_ITALIC)
                mEdit.setTypeface(Typeface.MONOSPACE,
                        Typeface.BOLD_ITALIC);
            else if (mEdit.getTypeface().getStyle() ==
                    Typeface.BOLD)
                mEdit.setTypeface(Typeface.MONOSPACE,
                        Typeface.BOLD);
            else mEdit.setTypeface(Typeface.MONOSPACE,
                        Typeface.NORMAL);
        }
        if (but == R.id.red)
            mEdit.setTextColor(Color.parseColor("#F44336"));

        if (but == R.id.blue)
            mEdit.setTextColor(Color.parseColor("#3F51B5"));

        if (but == R.id.green)
            mEdit.setTextColor(Color.parseColor("#4CAF50"));

        if (but == R.id.blueLight)
            mEdit.setTextColor(Color.parseColor("#00BCD4"));

        if (but == R.id.pink)
            mEdit.setTextColor(Color.parseColor("#E91E63"));

        if (but == R.id.yellow)
            mEdit.setTextColor(Color.parseColor("#FFEB3B"));

        if (but == R.id.black)
            mEdit.setTextColor(Color.parseColor("#000000"));
    }
}
