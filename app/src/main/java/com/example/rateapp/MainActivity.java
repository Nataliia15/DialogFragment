package com.example.rateapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FDialog.OnInputListener {
    TextView reviewTV,rateTV;
    RatingBar ratingBar;
    Button rateBut,reviewBut;
    DialogFragment reviewDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reviewTV=findViewById(R.id.review);
        ratingBar=findViewById(R.id.ratingBar);
        rateBut=findViewById(R.id.rateBut);
        reviewBut=findViewById(R.id.reviewBut);
        rateTV=findViewById(R.id.rateTV);
        reviewDialog=new FDialog();

        rateBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRateDialog();
            }
        });
        reviewBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               reviewDialog.show(getSupportFragmentManager(),"fdialog" );
            }
        });

    }
    public void showRateDialog(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        LinearLayout linearLayout=new LinearLayout(this);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
         RatingBar dialogRatingBar=new RatingBar(this);
        dialogRatingBar.setLayoutParams(lp);
        dialogRatingBar.setNumStars(5);
         linearLayout.addView(dialogRatingBar);
        dialog.setTitle("Rate");
        dialog.setView(linearLayout);
        dialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ratingBar.setRating(dialogRatingBar.getRating());
                rateTV.setText( String.valueOf(dialogRatingBar.getRating()));

            }
        });
        dialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.create();
        dialog.show();


    }

    @Override
    public void setInput(String input) {
        reviewTV.setText(input);
    }
}