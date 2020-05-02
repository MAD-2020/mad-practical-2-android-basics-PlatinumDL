package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Whack-A-Mole";
    private TextView Score;
    private List<Button> ButtonList = new ArrayList<>();
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ButtonLeft = (Button) findViewById(R.id.ButtonLeft);
        Button ButtonRight = (Button) findViewById(R.id.ButtonRight);
        Button ButtonMiddle = (Button) findViewById(R.id.ButtonMiddle);
        ButtonList.add(ButtonMiddle);
        ButtonList.add(ButtonLeft);
        ButtonList.add(ButtonRight);
        Score = (TextView) findViewById(R.id.Score);

        ButtonLeft.setOnClickListener(this);
        ButtonMiddle.setOnClickListener(this);
        ButtonRight.setOnClickListener(this);
    }
    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }

    public void setNewMole()
    {
        for (Button i: ButtonList){
            i.setText("O");
        }
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        Button random = ButtonList.get(randomLocation);
        random.setText("*");
    }

    @Override
    public void onClick(View v) {
        Button temp = (Button) v;
        switch (v.getId()){
            case R.id.ButtonLeft:
                Log.v(TAG,"Button Left Clicked!");
                break;
            case R.id.ButtonMiddle:
                Log.v(TAG,"Button Middle Clicked!");
                break;
            case R.id.ButtonRight:
                Log.v(TAG,"Button Right Clicked!");
                break;
        }
        if (temp.getText() == "*"){
            count = count + 1;
            temp.setText("O");
            String numberAsString = String.valueOf(count);
            Score.setText(numberAsString);
            Log.v(TAG,"Hit, score added!");
            setNewMole();
        }
        else {
            count = count - 1;
            String numberAsString = String.valueOf(count);
            Score.setText(numberAsString);
            Log.v(TAG,"Missed, score deducted!");
            setNewMole();
        }
    }
}
