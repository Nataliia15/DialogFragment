package com.example.rateapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.zip.Inflater;

public class FDialog extends DialogFragment {
    public interface OnInputListener{
        void setInput(String input);
    }
    public OnInputListener myInputListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myInputListener=(OnInputListener)getActivity();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LinearLayout linearLayout=new LinearLayout(getActivity());
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setPadding(40,10,40,10);
        linearLayout.setLayoutParams(lp);
        EditText editText=new EditText(getActivity());


       editText.setHint("Type here");
       editText.setWidth(800);
       linearLayout.addView(editText);
        AlertDialog.Builder dialog=new AlertDialog.Builder(getActivity());
        dialog.setTitle("Type your review");
        dialog.setView(linearLayout);
       dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               if(editText.getText()!=null){
                   String review= editText.getText().toString();
               myInputListener.setInput(review);}
               else{
                   Toast.makeText(getActivity(),"Please enter your review!",Toast.LENGTH_SHORT).show();
               }

           }
       });
       dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();

           }
       });
        return dialog.create();
    }
}
