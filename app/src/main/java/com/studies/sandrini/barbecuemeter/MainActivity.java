package com.studies.sandrini.barbecuemeter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar menBar, womenBar, childrenBar;
    TextView menOutput, womenOutput, childrenOutput, sausageOutput, meatOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menBar = (SeekBar) findViewById(R.id.men_bar);
        womenBar = (SeekBar) findViewById(R.id.women_bar);
        childrenBar = (SeekBar) findViewById(R.id.children_bar);
        menOutput = (TextView) findViewById(R.id.men_output);
        womenOutput = (TextView) findViewById(R.id.women_output);
        childrenOutput = (TextView) findViewById(R.id.children_output);
        sausageOutput = (TextView) findViewById(R.id.sausage_output);
        meatOutput = (TextView) findViewById(R.id.meat_output);

        menBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                menOutput.setText(String.valueOf(progress));
                calculate(progress, womenBar.getProgress(), childrenBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        womenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                womenOutput.setText(String.valueOf(progress));
                calculate(menBar.getProgress(), progress, childrenBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        childrenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                childrenOutput.setText(String.valueOf(progress));
                calculate(menBar.getProgress(), womenBar.getProgress(), progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void calculate(int men, int women, int kids) {
        //int sausage, meat;
        float resultSausage, resultMeat;

        resultSausage = (men * 500 + women * 250 + kids * 200) / 1000;
        resultMeat = (men * 500 + women * 300 + kids * 200) / 1000;
        sausageOutput.setText(String.valueOf(resultSausage));
        meatOutput.setText(String.valueOf(resultMeat));
    }
}
