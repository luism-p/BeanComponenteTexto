
package miComponenteTexto;

import java.awt.Component;
import java.beans.*;

/**
 *
 * @author Luis
 */
public class tipoPropertyEditor extends PropertyEditorSupport {
    //variable del editor
    private editorTipo editor = null;
    
    public tipoPropertyEditor() {
        //establece el valor preseleccionado en el editor.
        this.editor = new editorTipo();
    }
    //permite obtener el editor.
    @Override
    public Component getCustomEditor() {
        return editor;
    }
    
        @Override
    public String[] getTags() {
        String[] tags = {"Entero", "Real", "Texto", "SN", "Alfanumérico"};
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
        String ret = (String) super.getValue();
        ret = editor.jcbTipo.getSelectedItem().toString();
        return ret;
    }

    /*
     * Asigna un valor (obtenido del panel) a la propiedad
     */
    @Override
    public void setValue(Object tipo) {
        if(tipo==null){
            tipo = new String();
        }
        super.setValue(tipo);
    }
    
    //Indica que el bean tiene un editor personalizado.
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }
    
    //devuelve en la hoja de propiedades el valor establecido en el editor
    @Override
    public String getAsText(){
        return super.getAsText();
    }
    
    //establece el valor seleccionado en el editor de propiedades
    @Override
    public void setAsText(String text){
        editor.jcbTipo.setSelectedItem(text);
        super.setAsText(text);
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
        return "\"" + editor.jcbTipo.getSelectedItem().toString() + "\"";
    }
}
