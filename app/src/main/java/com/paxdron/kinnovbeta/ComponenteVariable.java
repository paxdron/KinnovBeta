package com.paxdron.kinnovbeta;

import android.content.Context;
import android.content.res.TypedArray;
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
    String titulo;
    int btn_size;
    TextView tvTitulo;
    private boolean selected;
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

        // Sets the images for the previous and next buttons. Uses
        // built-in images so you don't need to add images, but in
        // a real application your images should be in the
        // application package so they are always available.
        selected=false;
        btnIncrease = (FancyButton) this
                .findViewById(R.id.btnIncreaseValue);
        btnValue = (FancyButton) this
                .findViewById(R.id.btnValue);
        btnDecrease = (FancyButton) this
                        .findViewById(R.id.btnDecreaseValue);
        tvTitulo=(TextView)this.findViewById(R.id.tvTitulo);
        tvTitulo.setText(titulo);
        btnIncrease.setVisibility(GONE);
        btnDecrease.setVisibility(GONE);
        btnValue.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!selected){
                    btnIncrease.setVisibility(VISIBLE);
                    btnDecrease.setVisibility(VISIBLE);
                    selected=true;
                }
                else{
                    collapse();
                    selected=false;
                }
            }
        });

    }

    public void collapse(){
        btnIncrease.setVisibility(GONE);
        btnDecrease.setVisibility(GONE);
    }
}
