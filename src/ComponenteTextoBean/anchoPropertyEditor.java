package ComponenteTextoBean;

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
    /*
    obtiene el valor del editor de propiedades para establecer 
    el valor del componente en línea de código 
    (Código generado por java en el diseño de la interfaz). 
    El valor lo establece setValue()
    */
    @Override
        public Object getValue() {
            if(super.getValue()==null){
                setValue(null);
            }
            int ret;
            ret = (int) editor.jsAncho.getValue();
        return ret;
    }

    /*
     * Asigna un valor (obtenido del panel) a la propiedad
     */
    @Override
    public void setValue(Object ancho) {
        if(ancho==null){
            ancho = 1;
        }
        
        super.setValue((int) ancho);

    }
    
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }
    //devuelve en la hoja de propiedades el valor establecido en el editor
    @Override
    public String getAsText(){
        return editor.jsAncho.getValue().toString();
    }
    //establece el valor seleccionado en el editor de propiedades
    @Override
    public void setAsText(String text){
        editor.jsAncho.setValue(Integer.parseInt(text));
    }
    /*
    devuelve una cadena que será el valor 
    configurado en el componente personalizado. Este valor es el que obtenido desde getValue 
    se formatea para que se coloque en el código java. Si se quiere representar un número, 
    como es este caso, debe devolverse una cadena simple, sin agregar las comillas dobles. 
    Ver el ejemplo de tipo para notar la diferencia.
    */
    @Override
    public String getJavaInitializationString() {
        return editor.jsAncho.getValue().toString();
    }
}