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
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eSelectors= new ArrayList<>();
        initializeColorsExpandableSelector();
        initializeSizesExpandableSelector();
        eSelectors.add(sizesExpandableSelector);
        eSelectors.add(freqExpandableSelector);
        eSelectors.add(colorsExpandableSelector);
    }

    public void iniciar(View view) {
        startActivity(new Intent(this, valores.class));
    }

    private void initializeColorsExpandableSelector() {
        colorsExpandableSelector = (ExpandableSelector) findViewById(R.id.es_colors);
        List<ExpandableItem> expandableItems = new ArrayList<>();
        expandableItems.add(new ExpandableItem(R.drawable.item_brown));
        expandableItems.add(new ExpandableItem(R.drawable.item_green));
        expandableItems.add(new ExpandableItem(R.drawable.item_orange));
        expandableItems.add(new ExpandableItem(R.drawable.item_pink));
        colorsExpandableSelector.showExpandableItems(expandableItems);
        colorsHeaderButton = findViewById(R.id.bt_colors);
        colorsHeaderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //colorsHeaderButton.setVisibility(View.INVISIBLE);
                colorsExpandableSelector.expand();
            }
        });
        colorsExpandableSelector.setOnExpandableItemClickListener(new OnExpandableItemClickListener() {
            @Override
            public void onExpandableItemClickListener(int index, View view) {
                switch (index) {
                    case 0:
                        colorsHeaderButton.setBackgroundResource(R.drawable.item_brown);
                        break;
                    case 1:
                        colorsHeaderButton.setBackgroundResource(R.drawable.item_green);
                        break;
                    case 2:
                        colorsHeaderButton.setBackgroundResource(R.drawable.item_orange);
                        break;
                    default:
                        colorsHeaderButton.setBackgroundResource(R.drawable.item_pink);
                }
                colorsExpandableSelector.collapse();
            }
        });
    }

    private void initializeSizesExpandableSelector() {
        sizesExpandableSelector = (ExpandableSelector) findViewById(R.id.es_sizes);
        freqExpandableSelector = (ExpandableSelector) findViewById(R.id.es_freq);

        final List<ExpandableItem> expandableItems = new ArrayList<ExpandableItem>();
        expandableItems.add(new ExpandableItem(Integer.toString(value)));
        expandableItems.add(new ExpandableItem("-"));
        expandableItems.add(new ExpandableItem("+"));
        sizesExpandableSelector.showExpandableItems(expandableItems);
        freqExpandableSelector.showExpandableItems(expandableItems);
        sizesExpandableSelector.setExpandableSelectorListener(new ExpandableSelectorListener() {
            @Override
            public void onCollapse() {
                //Do something here
                ExpandableItem segundo = sizesExpandableSelector.getExpandableItem(1);
                sizesExpandableSelector.updateExpandableItem(1, sizesExpandableSelector.getExpandableItem(0));
                sizesExpandableSelector.updateExpandableItem(0, segundo);
            }

            @Override
            public void onExpand() {
                //Do something here
                ExpandableItem segundo = sizesExpandableSelector.getExpandableItem(1);
                sizesExpandableSelector.updateExpandableItem(1, sizesExpandableSelector.getExpandableItem(0));
                sizesExpandableSelector.updateExpandableItem(0, segundo);
                collapseOthers(sizesExpandableSelector);
            }

            @Override
            public void onCollapsed() {
                //Do something here
            }

            @Override
            public void onExpanded() {
                //Do something here
            }

        });
        sizesExpandableSelector.setOnExpandableItemClickListener(new OnExpandableItemClickListener() {
            @Override public void onExpandableItemClickListener(int index, View view) {
                switch (index) {
                    case 0:
                        value--;
                        sizesExpandableSelector.updateExpandableItem(1, new ExpandableItem(Integer.toString(value)));
                        break;
                    case 1:
                        sizesExpandableSelector.collapse();
                        break;
                    case 2:
                        value++;
                        sizesExpandableSelector.updateExpandableItem(1, new ExpandableItem(Integer.toString(value)));
                        break;
                    default:
                }

                System.out.println(Integer.toString(value));
            }
        });
    }

    public void collapseOthers(ExpandableSelector eSeleccionado){
        for (ExpandableSelector eS:eSelectors
             ) {
            if(eS!=eSeleccionado)
                eS.collapse();
        }
    }

}
