package miComponenteTexto;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author Luis
 */
public class ComponenteTexto extends JTextField implements Serializable {
    
    
    private String tipo;
    private String ancho;
    
    public ComponenteTexto() {
        this.ancho="5";
        this.tipo="Texto";
        this.setText("");
        this.gestionaEntrada();
    }


    /**
     * Get the value of tipo
     *
     * @return the value of tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Set the value of tipo
     *
     * @param tipo new value of tipo
     */
    public void setTipo(String tipo) {
        if (tipo.equals("Entero") || tipo.equals("Real")
                || tipo.equals("Texto") || tipo.equals("SN")) 
            this.tipo = tipo;
    }


    /**
     * Get the value of ancho
     *
     * @return the value of ancho
     */
    public String getAncho() {
        return ancho;
    }

    /**
     * Set the value of ancho
     *
     * @param ancho new value of ancho
     */
    public void setAncho(String ancho) {
        
        int hide = Integer.parseInt(ancho);
        if(hide <= 0){
            ancho = "1";
            this.ancho = ancho;
            super.setColumns(Integer.parseInt(ancho));
        }else{
            this.ancho = ancho;
            super.setColumns(Integer.parseInt(ancho));
        }
    }
    
    @Override
    public void setText(String text){
        switch (tipo) {
            case "Entero":
                try{
                    Integer.parseInt(text);
                    super.setText(text);
                }catch (NumberFormatException e){
                    super.setText("valor no válido");
                }
                break;
            case "Real":
                try{
                    Double.parseDouble(text);
                    super.setText(text);
                }catch (NumberFormatException e){
                    super.setText("valor no válido");
                }
                break;
            case "SN":
                try{
                    if(text.equalsIgnoreCase("S"))
                        super.setText(text);
                    else if (text.equalsIgnoreCase("N"))
                        super.setText(text);
                }catch (Exception e){
                    super.setText("valor no válido");
                }
                break;
            default:
                super.setText(text);
                break;
        }        
    }
    
    public final void gestionaEntrada() {
        this.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();       
                switch (tipo) {
                    case "Entero":
                        if (!Character.isDigit(caracter)) {
                            e.consume();
                        }
                        break;
                    case "Real":
                        if (!Character.isDigit(caracter) && (caracter != KeyEvent.VK_COMMA)) {
                            e.consume();
                        }
                        break;
                    case "SN":
                        if(Character.toUpperCase(caracter) != KeyEvent.VK_S && Character.toUpperCase(caracter) != KeyEvent.VK_N)
                            e.consume();
                }
            }
        });
    }

}
