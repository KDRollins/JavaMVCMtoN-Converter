// NCView class
// Maintains and presents GUI

package NumConvert;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class NCView extends JFrame {
    // Jpanels for organizing the view
    private JPanel contPane = new JPanel(new BorderLayout()); 
    private JPanel topPane = new JPanel(new GridBagLayout());
    private JPanel midPane = new JPanel(new GridBagLayout());
    private JPanel botPane = new JPanel(new GridBagLayout());
    
    // buttons for UI
    private JButton convertBtn = new JButton("Convert");
    private JButton clearBtn = new JButton("Clear");
    private JButton nwlBtn = new JButton("New with last");
    
    // JText for I/O
    private JTextArea iText = new JTextArea(5,20);
    private JTextField iRad = new JTextField(2);
    
    private JTextArea oText = new JTextArea(5,20);
    private JTextField oRad = new JTextField(2);
    
    private JLabel iVL = new JLabel("In");
    private JLabel oVL = new JLabel("Out");
    private JLabel iRL = new JLabel("Radix In");
    private JLabel oRL = new JLabel("Radix Out");
    
    // initialize function sets up display
    public void initialize(NCController ncc) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,250);
        
        // subscribe controller to each button 
        convertBtn.addActionListener(ncc);
        clearBtn.addActionListener(ncc);
        nwlBtn.addActionListener(ncc);
        
        oText.setEditable(false);
        
        // build and organize GUI
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;
	topPane.add(iVL, c); 
        
        c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 1;
        topPane.add(iRL, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 1;
        c.insets = new Insets(0,0,0,10);
        topPane.add(iRad, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        topPane.add(oVL, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(0,10,0,0);
        topPane.add(oRL, c);  
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        topPane.add(oRad, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0,0,0,10);
        midPane.add(iText, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(0,10,0,0);
        midPane.add(oText, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0; 
        c.anchor = GridBagConstraints.PAGE_END;
	c.insets = new Insets(10,0,0,10); 
        botPane.add(nwlBtn, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0; 
        c.anchor = GridBagConstraints.PAGE_END; 
	c.insets = new Insets(10,5,0,5);
        botPane.add(clearBtn, c);
        
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0; 
        c.anchor = GridBagConstraints.PAGE_END;
	c.insets = new Insets(10,10,0,0);
        botPane.add(convertBtn, c);
        
        contPane.add(topPane, BorderLayout.PAGE_START);
        contPane.add(midPane, BorderLayout.CENTER);
        contPane.add(botPane, BorderLayout.PAGE_END);
        
        // hang on fridge
        setContentPane(contPane);
        setVisible(true);
    }
    
    // retrieve current data from model 
    public void updateView(NCModel ncm)
    {
        iText.setText(ncm.getIVal());
        iRad.setText("" + ncm.getIRad());
        oText.setText(ncm.getOVal());
        oRad.setText("" + ncm.getORad());
    }
    
    // gets
    public String getIVal()
    {
        return iText.getText();
    }
    
    public int getIRad()
    {
        return Integer.parseInt(iRad.getText());
    }
    
    public int getORad()
    {
        return Integer.parseInt(oRad.getText());
    }
}