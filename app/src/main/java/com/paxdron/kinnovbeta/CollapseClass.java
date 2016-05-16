package com.paxdron.kinnovbeta;

/**
 * Created by Antonio on 14/05/2016.
 */
public class CollapseClass {
    public static CollapseClass instancia;
    public static boolean isCreated=false;
    ICollapse CallbackCollapseClass;

    public static CollapseClass getInstance(){
        if(!isCreated){
            instancia=new CollapseClass();
            isCreated=true;
        }
        return instancia;
    }

    void registerCallback(ICollapse callbackClass){
        CallbackCollapseClass = callbackClass;
    }

    void notifica(){
        CallbackCollapseClass.callbackCollapse();
    }

}