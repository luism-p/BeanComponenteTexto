
package miComponenteTexto;

import java.awt.Component;
import java.beans.*;

/**
 *
 * @author Luis
 */
public class tipoPropertyEditor extends PropertyEditorSupport {
    
    private editorTipo editor = null;
            
    public tipoPropertyEditor() {
        this.editor = new editorTipo();
    }
    
    @Override
    public Component getCustomEditor() {
        return editor;
    }
    
        @Override
    public String[] getTags() {
        String[] tags = {"Entero", "Real", "Texto", "SN"};
        return tags;
    }
    
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
        editor.jcbTipo.setSelectedItem(text);
        super.setAsText(text);
    }
    
    @Override
    public String getJavaInitializationString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append((String) editor.jcbTipo.getSelectedItem());
        sb.append("\"");
        String retorno = new String(sb);
        return retorno;
    }
}
