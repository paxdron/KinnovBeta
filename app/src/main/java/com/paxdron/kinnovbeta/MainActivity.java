package com.paxdron.kinnovbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.karumi.expandableselector.ExpandableItem;
import com.karumi.expandableselector.ExpandableSelector;
import com.karumi.expandableselector.ExpandableSelectorListener;
import com.karumi.expandableselector.OnExpandableItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableSelector colorsExpandableSelector;
    private View colorsHeaderButton;
    private ExpandableSelector sizesExpandableSelector;
    private ExpandableSelector freqExpandableSelector;
    private int value=0;
    private List<ExpandableSelector> eSelectors;
    ComponenteVariable CVgroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CVgroup=(ComponenteVariable)findViewById(R.id.cv1);
        CVgroup.btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, ":V", Toast.LENGTH_SHORT).show();
            }
        });
        CVgroup.btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "V:", Toast.LENGTH_SHORT).show();
            }
        });
    }




}
