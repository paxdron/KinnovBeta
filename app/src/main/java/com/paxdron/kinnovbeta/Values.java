package com.paxdron.kinnovbeta;

import android.graphics.Typeface;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by antonio on 12/05/16.
 */
public class Values implements ICollapse{
    public static int itemSelected=0;
    public CollapseClass collapseClass;
    private ComponenteStimMode stim_mode;
    private ComponenteBiseleccion carrier;
    private ComponenteBiseleccion duracion_burst;
    private ComponenteVariable frecuencia_burst;
    private ComponenteVariable tiempo_aplicacion;
    private ComponenteVariable rise;
    private ComponenteVariable on;
    private ComponenteVariable decay;
    private ComponenteVariable off;
    private ArrayList<Object> Elementos;

    public Values(ComponenteStimMode stim_mode,
            ComponenteBiseleccion carrier,
            ComponenteBiseleccion duracion_burst,
            ComponenteVariable frecuencia_burst,
            ComponenteVariable tiempo_aplicacion,
            ComponenteVariable rise,
            ComponenteVariable on,
            ComponenteVariable decay,
            ComponenteVariable off) {
        this.stim_mode=stim_mode;
        this.carrier=carrier;
        this.duracion_burst=duracion_burst;
        this.frecuencia_burst=frecuencia_burst;
        this.tiempo_aplicacion=tiempo_aplicacion;
        this.rise=rise;
        this.on=on;
        this.decay=decay;
        this.off=off;
        Elementos= new ArrayList<>();
        Elementos.add(stim_mode);
        Elementos.add(carrier);
        Elementos.add(duracion_burst);
        Elementos.add(frecuencia_burst);
        Elementos.add(rise);
        Elementos.add(on);
        Elementos.add(decay);
        Elementos.add(off);
        Elementos.add(tiempo_aplicacion);
        collapseClass=CollapseClass.getInstance();
        collapseClass.registerCallback(this);
    }

    public void setValues(String texto,int modo){
        modo=stim_mode.getModSelected();
        carrier.setValue(Integer.valueOf(texto.substring(7,8)));
        duracion_burst.setValue(Integer.valueOf(texto.substring(10,11)));
        frecuencia_burst.setValue(Integer.valueOf(texto.substring(13,16).replaceAll("\\s+","")));
        if(modo!=0){
            rise.setValue(Integer.valueOf(texto.substring(16,18).replaceAll("\\s+","")));
            on.setValue(Integer.valueOf(texto.substring(19,21).replaceAll("\\s+","")));
            decay.setValue(Integer.valueOf(texto.substring(22,24).replaceAll("\\s+","")));
            off.setValue(Integer.valueOf(texto.substring(25,27).replaceAll("\\s+","")));
        }
        tiempo_aplicacion.setValue(Integer.valueOf(texto.substring(30,32).replaceAll("\\s+","")));
    }
    public void setTypefce(Typeface font){
        stim_mode.setTypeface(font);
        carrier.setTypeface(font);
        duracion_burst.setTypeface(font);
        frecuencia_burst.setTypeface(font);
        tiempo_aplicacion.setTypeface(font);
        rise.setTypeface(font);
        on.setTypeface(font);
        decay.setTypeface(font);
        off.setTypeface(font);
    }
    public void setIds(){
        stim_mode.setIdentificador(1);
        carrier.setIdentificador(2);
        duracion_burst.setIdentificador(3);
        frecuencia_burst.setIdentificador(4);
        rise.setIdentificador(5);
        on.setIdentificador(6);
        decay.setIdentificador(7);
        off.setIdentificador(8);
        tiempo_aplicacion.setIdentificador(9);
    }



    @Override
    public void callbackCollapse() {
                stim_mode.Collapse();
                carrier.Collapse();
                duracion_burst.Collapse();
                ComponenteVariable selected;
                for (int i=3; i<Elementos.size();i++) {
                    selected=(ComponenteVariable) Elementos.get(i);
                    if (!(selected.getIdentificador() == i + 1)){
                        selected.Collapse();
                    }
                }

    }
}
