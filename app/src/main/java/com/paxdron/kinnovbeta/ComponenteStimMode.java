package com.paxdron.kinnovbeta;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by Antonio on 14/05/2016.
 */
public class ComponenteStimMode extends LinearLayout{
    CollapseClass collapseClass=CollapseClass.getInstance();
    private boolean isExpanded;
    private FancyButton modo1,modo2,modo3;
    private TextView tvTitulo;
    private FancyButton[] modosBtns;

    private int modSelected=0,id;

    private String[] modosLabels;
    public ComponenteStimMode(Context context) {
        super(context);
        initializeViews(context);
    }

    public ComponenteStimMode(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public ComponenteStimMode(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.componente_stim_mode, this);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        isExpanded=false;
        modo1=(FancyButton)findViewById(R.id.modo1);
        modo2=(FancyButton)findViewById(R.id.modo2);
        modo3=(FancyButton)findViewById(R.id.modo3);
        tvTitulo=(TextView)this.findViewById(R.id.tvTitulo);
        modosBtns = new FancyButton[]{modo1, modo2, modo3};
        modosLabels=getResources().getStringArray(R.array.stimm_mode);
        modo1.setVisibility(GONE);
        modo3.setVisibility(GONE);
        setClickListeners();
    }

    private void setClickListeners() {
        modo1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectMode(0);
            }
        });
        modo2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isExpanded) {
                    Values.itemSelected=id;
                    collapseClass.notifica();
                    setTexts();
                    modo1.setVisibility(VISIBLE);
                    modo3.setVisibility(VISIBLE);
                    isExpanded = true;
                } else {
                    selectMode(1);
                }
            }
        });
        modo3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectMode(2);
            }
        });
    }

    public void setTexts(){
        for (int i=0;i<3;i++) {
            modosBtns[i].setText(modosLabels[i]);
        }
    }

    private void selectMode(int indice){
        modSelected=indice;
        //TODO
        //
        Collapse();
    }

    public int getModSelected() {
        return modSelected;
    }

    public void setTypeface(Typeface font) {
        //Typeface font=Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Light.ttf");
        tvTitulo.setTypeface(font);
    }
    public void setIdentificador(int id){
        this.id=id;
    }

    public int getIdentificador(){
        return id;
    }

    public void Collapse(){
        if(isExpanded) {
            modo2.setText(modosLabels[modSelected]);
            AlphaAnimation fade_out = new AlphaAnimation(1.0f, 0.0f);
            fade_out.setDuration(200);
            fade_out.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationStart(Animation arg0) {
                }

                public void onAnimationRepeat(Animation arg0) {
                }

                public void onAnimationEnd(Animation arg0) {
                    modo1.setVisibility(View.GONE);
                    modo3.setVisibility(View.GONE);
                    modo2.setText(modosLabels[modSelected]);
                }
            });
            modo3.startAnimation(fade_out);
            modo1.startAnimation(fade_out);
            isExpanded = false;
        }
    }

}
