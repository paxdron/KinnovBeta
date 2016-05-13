package com.paxdron.kinnovbeta;

/**
 * Created by antonio on 12/05/16.
 */
public class Values {
    private ComponenteVariable stim_mode;
    private ComponenteVariable carrier;
    private ComponenteVariable duracion_burst;
    private ComponenteVariable frecuencia_burst;
    private ComponenteVariable tiempo_aplicacion;
    private ComponenteVariable rise;
    private ComponenteVariable on;
    private ComponenteVariable decay;
    private ComponenteVariable off;

    public Values(ComponenteVariable stim_mode,
            ComponenteVariable carrier,
            ComponenteVariable duracion_burst,
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
    }

    public void setValues(String Cadena){

    }

}
