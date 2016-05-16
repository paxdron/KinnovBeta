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
 * Created by antonio on 12/05/16.
 */
public class ComponenteVariable extends LinearLayout {
    FancyButton btnIncrease,btnValue,btnDecrease;
    CollapseClass collapseClass=CollapseClass.getInstance();
    private String titulo;
    private int valor,id;
    private TextView tvTitulo,tvValue;
    private boolean isExpanded;
    private String unidad;
    public ComponenteVariable(Context context) {
        super(context);
        initializeViews(context);
    }

    public ComponenteVariable(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray;
        typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.ComponenteVariable);
        titulo = typedArray
                .getString(R.styleable.ComponenteVariable_nombre_campo);
        setUnidad(typedArray
                .getString(R.styleable.ComponenteVariable_unidad));
        valor = typedArray
                .getInteger(R.styleable.ComponenteVariable_valor, 0);

        typedArray.recycle();
        initializeViews(context);
    }

    public ComponenteVariable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }


    /**
     * Inflates the views in the layout.
     *
     * @param context
     *           the current context for the view.
     */
    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.componente_variable, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        isExpanded=false;
        btnIncrease = (FancyButton) this
                .findViewById(R.id.btnIncreaseValue);
        btnValue = (FancyButton) this
                .findViewById(R.id.btnValue);
        btnDecrease = (FancyButton) this
                        .findViewById(R.id.btnDecreaseValue);
        tvTitulo=(TextView)this.findViewById(R.id.tvTitulo);
        tvTitulo.setText(titulo);
        tvValue=(TextView)this.findViewById(R.id.tvValue);
        setValue(valor);
        btnIncrease.setVisibility(GONE);
        btnDecrease.setVisibility(GONE);
        btnValue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isExpanded) {
                    Values.itemSelected=id;
                    collapseClass.notifica();
                    btnIncrease.setVisibility(VISIBLE);
                    btnDecrease.setVisibility(VISIBLE);
                    isExpanded = true;
                } else {
                    Collapse();
                    isExpanded = false;
                }
            }
        });

    }
    public void setTypeface(Typeface font) {
        //Typeface font=Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Light.ttf");
        tvTitulo.setTypeface(font);
    }
    public void setValue(int valor){
        this.valor=valor;
        tvValue.setText(valor + unidad);
    }


    public void setUnidad(String unidad){
        this.unidad=(unidad==null)?"":" "+unidad;
    }

    public int getIdentificador(){
        return id;
    }

    public void Collapse(){
        if(isExpanded) {
            btnIncrease.setVisibility(GONE);
            btnDecrease.setVisibility(GONE);
            isExpanded=false;
        }
    }

    public void setIdentificador(int id){
        this.id=id;
    }

}
