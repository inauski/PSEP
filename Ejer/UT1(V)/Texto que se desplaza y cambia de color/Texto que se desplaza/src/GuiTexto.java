
/**
 *  
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;
//import javax.swing.border.*;
 
@SuppressWarnings("serial")
public class GuiTexto  extends JFrame
{
     private PanelTexto pnlTexto;
     private JButton btnParar;
     private JButton btnIniciar;

    /**
     * Constructor de la clase GuiTexto
     */
    public GuiTexto()
    {
         btnIniciar = new JButton("Iniciar");
         btnIniciar.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ev)
                                        {
                                            pnlTexto.iniciarAnimacion();
                                        }
                                    }
                                    );
         btnParar = new JButton("Terminar");
         btnParar.addActionListener(new ActionListener()
                                    {
                                        public void actionPerformed(ActionEvent ev)
                                        {
                                            pnlTexto.pararAnimacion();
                                        }
                                    }
                                    );
                                    
         JPanel pnlSur = new JPanel();
         pnlSur.add(btnIniciar);
         pnlSur.add(btnParar);
         this.add(pnlSur, BorderLayout.SOUTH);
         pnlTexto = new PanelTexto(700, 300);
         this.add(pnlTexto);
        
         this.setTitle("Texto que se va moviendo horizontalmente y cambia de color con hilos");
          
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         this.pack();
         this.setLocationRelativeTo(null);
         this.setResizable(true);
         this.setVisible(true);
       
    }

     
}
