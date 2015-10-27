/**
 * 
 */
package ui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author ChibeePatag
 *
 */
public class LuckyGrocersRaffleFrame extends JFrame {

	JPanel activePanel1;

	Container cPane;

	public static LuckyGrocersRaffleFrame lgcFrame;
	
	public LuckyGrocersRaffleFrame(String title) {
		super(title);
	}
	

	public void startSos(LuckyGrocersRaffleFrame mainFrame){
		SetupPanel loginPanel = new SetupPanel();
		cPane = mainFrame.getContentPane();
		cPane.setLayout(new GridLayout(1, 1));		
		
		mainFrame.setBounds(10, 10, 300, 200);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setActivePanel(loginPanel);
		cPane.add(activePanel1);
		addWindowListener(new OnExit());
	}
	
	public void setActivePanel(JPanel activePanel){
		if(activePanel1 != null){
			cPane.remove(activePanel1);
		}
		activePanel1 = activePanel;
		cPane.add(activePanel1);
		validate();

//		sosFrame.repaint();
	}
	
	public static LuckyGrocersRaffleFrame getSosFrame(){
		return lgcFrame;
	}
	
    private class OnExit extends WindowAdapter {
        public void windowClosing( WindowEvent e ) {
            int option = JOptionPane.showOptionDialog(
                    LuckyGrocersRaffleFrame.this,
                    "Are you sure you want to quit?",
                    "Exit Dialog", JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, null,
                    null );
            if( option == JOptionPane.YES_OPTION ) {
           //     Main.close();
            	System.exit( 0 );
            } else{
            	return;
            }
        }
    }
	
}
