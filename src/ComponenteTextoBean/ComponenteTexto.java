package ComponenteTextoBean;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author Luis
 * @version 1.0
 */
public class ComponenteTexto extends JTextField implements Serializable {
        
    private String tipo;
    private int ancho;
    private Font fuente;
    private Color colorFuente;

    public static final Color ERROR = new Color(249,206,206);
    
    /**
     * Constructor sin argumentos
     */
    public ComponenteTexto() {
        this.ancho=9;
        this.setColumns(ancho);
        this.tipo="Texto";
        this.gestionaEntrada();
    }//close constructor
    
    /**
     *
     * @return
     */
    public Font getFuente() {
        return fuente;
    }

    /**
     *
     * @param fuente
     */
    public void setFuente(Font fuente) {
        this.fuente = fuente;
        this.setFont(fuente);
    }

    /**
     *
     * @return
     */
    public Color getColorFuente() {
        return colorFuente;
    }

    /**
     *
     * @param colorFuente
     */
    public void setColorFuente(Color colorFuente) {
        this.colorFuente = colorFuente;
        this.setForeground(colorFuente);
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
        if (tipo.equals("Entero") || tipo.equals("Real") || tipo.equals("Texto")
                || tipo.equals("SN") || tipo.equals("Alfanumérico")) 
            this.tipo = tipo;
    }//close set.

    /**
     * Get the value of ancho
     *
     * @return the value of ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Set the value of ancho
     *
     * @param ancho new value of ancho
     */
    public void setAncho(int ancho) {        
        //int hide = Integer.parseInt(ancho);
        //si es menor de 1 se establece en 1.
        if(ancho <= 0)
            ancho = 1;
        
        this.ancho = ancho;
        super.setColumns(ancho);
    }//close set.
    
    @Override
    public void setText(String text){
        super.setText(text);  
    }//close set.
    
    /**
     * gestiona la entrada por teclado para el componente.
     */
    public final void gestionaEntrada() {
        this.addKeyListener(new KeyAdapter() {   
            @Override
            public void keyReleased(KeyEvent evt) {
                char caracter = evt.getKeyChar();
                
                switch (tipo) {
                    case "Entero":
                        if (!Character.isDigit(caracter) && !(caracter == KeyEvent.VK_BACK_SPACE)) {
                            evt.consume();
                            setBackground(ERROR);
                        }else
                            setBackground(Color.WHITE);
                        
                        if (getText().length()>=ancho)
                            evt.consume();
                        break;
                    case "Real":
                        if ((!Character.isDigit(caracter)) && 
                            ((caracter < '.') || (caracter > '.')) && 
                            (caracter != KeyEvent.VK_BACK_SPACE)) {
                            evt.consume();
                            setBackground(ERROR);
                        }else if (getText().contains(".")){
                                if ((!Character.isDigit(caracter))&& (caracter != KeyEvent.VK_BACK_SPACE)){
                                    evt.consume();  // ignorar el evento de teclado
                                    setBackground(ERROR);
                                }
                        }else
                            setBackground(Color.WHITE);
                        if (getText().length()>=ancho)
                            evt.consume();
                        break;
                    case "SN":
                        if(Character.toUpperCase(caracter) != KeyEvent.VK_S && Character.toUpperCase(caracter) != KeyEvent.VK_N)
                            evt.consume();
                        if (getText().length()>=ancho)
                            evt.consume();
                    case "Alfanumérico":
                        if(!getText().isEmpty())
                            setBackground(Color.WHITE);
                        break;
                    case "Texto":
                        if (!Character.isLetter(caracter) && !(caracter == KeyEvent.VK_SPACE) 
                        && !(caracter == KeyEvent.VK_BACK_SPACE)) {
                            evt.consume();
                            setBackground(ERROR);
                        }else
                            setBackground(Color.WHITE);
                        break;
                    default:
                        if (getText().length()>=ancho)
                            evt.consume();
                }//close switch.
            }
        });
        
        this.addFocusListener(new FocusAdapter(){
        
            @Override
            public void focusLost(FocusEvent e){
                if(getText().isEmpty())
                    setBackground(ERROR);   
            }
        });
    }//close función.

    @Override
    public String toString() {
        return getTipo()+" -- "+ getAncho();
    }

}//close class.
