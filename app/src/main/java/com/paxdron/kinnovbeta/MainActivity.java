package com.paxdron.kinnovbeta;

import android.content.Intent;
import android.graphics.Typeface;
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
    private ComponenteStimMode  stim_mode;
    private ComponenteBiseleccion carrier;
    private ComponenteBiseleccion duracion_burst;
    private ComponenteVariable frecuencia_burst;
    private ComponenteVariable tiempo_aplicacion;
    private ComponenteVariable rise;
    private ComponenteVariable on;
    private ComponenteVariable decay;
    private ComponenteVariable off;
    private Values valores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stim_mode=(ComponenteStimMode)findViewById(R.id.stim_mode);
        carrier=(ComponenteBiseleccion)findViewById(R.id.carrier);
        duracion_burst=(ComponenteBiseleccion)findViewById(R.id.duracion_burst);
        frecuencia_burst=(ComponenteVariable)findViewById(R.id.frecuencia_burst);
        tiempo_aplicacion=(ComponenteVariable)findViewById(R.id.tiempo_aplicacion);
        rise=(ComponenteVariable)findViewById(R.id.rise);
        on=(ComponenteVariable)findViewById(R.id.on);
        decay=(ComponenteVariable)findViewById(R.id.decay);
        off=(ComponenteVariable)findViewById(R.id.off);
        Typeface font= Typeface.createFromAsset(this.getAssets(), "fonts/OpenSans-Light.ttf");
        valores= new Values(stim_mode,carrier,duracion_burst,frecuencia_burst,tiempo_aplicacion,rise,on,decay,off);
        valores.setTypefce(font);
        valores.setValues("Sinc.  4  4  12012 60 20 60   60",1);
    }




}
