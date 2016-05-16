package com.paxdron.kinnovbeta;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by Antonio on 13/05/2016.
 */
public class ComponenteBiseleccion extends LinearLayout {
    public FancyButton btnPrimero, btnUltimo;
    CollapseClass collapseClass=CollapseClass.getInstance();
    public TextView tvTitulo;
    private boolean isExpanded,isFirstSelected;
    private String unidad,titulo;
    private int valorFirst,valorLast,currentValue,id;
    public ComponenteBiseleccion(Context context) {
        super(context);
        initializeViews(context);
    }

    public ComponenteBiseleccion(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray;
        typedArray= context.obtainStyledAttributes(attrs,R.styleable.ComponenteBiseleccion);
        titulo = typedArray
                .getString(R.styleable.ComponenteBiseleccion_nombre_campo_bs);
        setUnidad(typedArray
                .getString(R.styleable.ComponenteBiseleccion_unidad_bs));
        valorFirst=typedArray.getInteger(R.styleable.ComponenteBiseleccion_valor_first, 1);
        valorLast=typedArray.getInteger(R.styleable.ComponenteBiseleccion_valor_last,4);
        typedArray.recycle();
        initializeViews(context);
    }

    public ComponenteBiseleccion(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }



    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        isExpanded=false;
        btnPrimero=(FancyButton)this.findViewById(R.id.btn_first);
        btnUltimo=(FancyButton)this.findViewById(R.id.btn_last);
        tvTitulo=(TextView)this.findViewById(R.id.tvTitulo);
        isFirstSelected=true;
        btnUltimo.setVisibility(GONE);
        tvTitulo.setText(titulo);
        btnPrimero.setText(valorFirst + unidad);
        btnUltimo.setText(valorLast + unidad);
        setClickListeners();
    }
    public void setTypeface(Typeface font) {
        //Typeface font=Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Light.ttf");
        tvTitulo.setTypeface(font);
    }

    public void setClickListeners(){
        btnPrimero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isExpanded)
                    expand();
                    //Posicionar el cursor
                else{
                    //Collapsar y enviar mensaje
                    btnUltimo.setVisibility(GONE);
                    currentValue=valorFirst;
                    isExpanded=false;
                    //Si esta seleccionado solo colapse, de lo contrartio tambien enviar el mensaje
                }

            }
        });
        btnUltimo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isExpanded)
                    expand();
                else {
                    //Collapsar y enviar mensaje
                    btnPrimero.setVisibility(GONE);
                    currentValue = valorLast;
                    isExpanded = false;
                }
            }
        });
    }

    public void setValue(int value){
        if(value==valorFirst)
            currentValue=valorFirst;
        else
            currentValue=valorLast;
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.componente_biseleccion, this);
    }

    public void setUnidad(String unidad){
        this.unidad=(unidad==null)?"":" "+unidad;
    }
    public void Collapse(){
        if(isExpanded) {
            if (isFirstSelected) {
                btnUltimo.setVisibility(GONE);
            } else
                btnPrimero.setVisibility(GONE);
            isExpanded=false;
        }
    }

    public void expand(){
        Values.itemSelected=id;
        collapseClass.notifica();
        btnPrimero.setVisibility(VISIBLE);
        btnUltimo.setVisibility(VISIBLE);
        isExpanded=true;
    }


    public void setIdentificador(int id){
        this.id=id;
    }

    public int getIdentificador(){
        return id;
    }
}
