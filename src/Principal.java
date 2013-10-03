import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal  extends JFrame {
    
    ActionListener eventHandler = new EventHandler();
    JMenuItem itregmanual;
    JDesktopPane desk;
    public Principal(String titulo) {
        super(titulo);
        desk=new JDesktopPane();
        setContentPane(desk);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setSize(dimension);
        JMenuBar menugral = new JMenuBar();
        setJMenuBar(menugral);
        JMenu opregistracion= new JMenu("Menu");
        menugral.add(opregistracion);        
        itregmanual= new JMenuItem("SubMenu");
        itregmanual.addActionListener(eventHandler);
        opregistracion.add(itregmanual);
        opregistracion.addSeparator();
        setVisible(true);                
        
    }
    class EventHandler implements ActionListener  {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == itregmanual)  ventana();
        };
    };
    private void ventana( ) {
        Ventana consulta= new Ventana();
        desk.add(consulta,new Integer(1));
        Dimension dim_pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dim_cuadro = consulta.getSize();
        consulta.setLocation((dim_pantalla.width-dim_cuadro.width)/2,(dim_pantalla.height-dim_cuadro.height)/2);
        consulta.show();
    }    
}
