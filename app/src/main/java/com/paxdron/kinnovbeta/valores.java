package com.paxdron.kinnovbeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

public class valores extends AppCompatActivity {

    NiftyDialogBuilder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valores);
        dialogBuilder=NiftyDialogBuilder.getInstance(this);
        dialogBuilder
                .withTitle("Modal Dialog")
                .withMessage("This is a modal Dialog.")
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
    }

    public void selectStMode(View v){
        dialogBuilder.show();
    }
}
