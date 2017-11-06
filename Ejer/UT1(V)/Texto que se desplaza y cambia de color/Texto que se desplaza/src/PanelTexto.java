
/**
 *  Demo Timer
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
@SuppressWarnings({ "unused", "serial" })
public class PanelTexto extends JPanel implements Runnable, KeyListener 
{
    private volatile boolean running; // a true animacion ejecutandose
    private Thread th;
    private int x;
    private int y;
    private boolean green;;

    /**
     * Constructor de la clase PanelTexto
     */
    public PanelTexto(int ancho, int alto)
    {
        Dimension dimension = new Dimension(ancho, alto);
        this.setPreferredSize(dimension);
        x = (int) dimension.getWidth() / 2;
       
        green = true;
        this.addKeyListener(this);
        running = false;
       // iniciarAnimacion();

    }

    /**
     *  
     * Cada vez que se dibuja el panel se modifica
     * el color de la letra y las coordenadas x e y en las que se
     * escribe el texto
     *      
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.blue);
        //this.requestFocus();

        g.setFont(new Font("ARIAL", Font.BOLD, 16));

        g.drawString("INICIAR continuar / TERMINAR parar" , 20, 50);
     
        if (green)
            g.setColor(Color.green);
        else
            g.setColor(Color.yellow);
        green = !green; 
        g.setFont(new Font("ARIAL", Font.BOLD, 24));

        g.drawString("TEXTO QUE SE DESPLAZA", x, 100);
       //System.out.println(Thread.currentThread().getName());
    }

    /**
     * parar el hilo de animación
     */
    public void pararAnimacion()
    {
        System.out.println("Parando " + Thread.currentThread().getName());
        running = false;
    }

    /**
     * iniciar el hilo de animación
     */
    public void iniciarAnimacion()
    {
        if (!running)
        {
            th = new Thread(this);
            th.setName("Hilo de animacion");
            th.start();
            running = true;
        }
    }

    /**
     *  Codigo que se ejecuta concurrentemente
     */
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
        while (running) // ejecutar indefinidamente hasta parar el hilo
        {
            actualizar();
            repaint();
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException ex) {}

        }

    }

    /**
     * actualizar coordenadas del texto
     */
    private  void actualizar()
    {
        if (this.x > this.getWidth())
            x = -x;
        else
            x += 5;

    }

    public void keyPressed(KeyEvent e) 
    {
        System.out.println("Pulsada tecla " + Thread.currentThread().getName());
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) 
        { 
            pararAnimacion();
            
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER)
        { 
            iniciarAnimacion();

        } 

    } 

    public void keyReleased(KeyEvent e) {} 

    public void keyTyped(KeyEvent e) {} 

}
