/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miComponenteTexto;

import java.awt.Component;
import java.beans.*;

/**
 *
 * @author Luis
 */
public class anchoPropertyEditor extends PropertyEditorSupport {
    
    private editorAncho editor = null;
    
    public anchoPropertyEditor() {
        this.editor = new editorAncho();
    }
    
    @Override
    public Component getCustomEditor() {
        return editor;
    }
    
        @Override
    public String[] getTags() {
        String[] tags = {"1", "2", "3", "4","5", "6", "7", "8", "9", "10","11" 
                ,"12", "13", "14","15"};
        return tags;
    }
    
    @Override
        public Object getValue() {
            if(super.getValue()==null){
                setValue(null);
            }
            String ret = (String)super.getValue().toString();
            ret = editor.jsAncho.getValue().toString();
        return ret;
    }

    /*
     * Asigna un valor (obtenido del panel) a la propiedad
     */
    @Override
    public void setValue(Object ancho) {
        if(ancho==null){
            ancho = new String();
        }
        super.setValue((String)ancho);

    }
    
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }
    
    @Override
    public String getAsText(){
        return super.getAsText();
    }
    
    @Override
    public void setAsText(String text){
        editor.jsAncho.setValue(Integer.parseInt(text));
        super.setAsText(text);
    }
    
    @Override
    public String getJavaInitializationString() {
        return "\"" + editor.jsAncho.getValue().toString() + "\"" ;
    }
}
