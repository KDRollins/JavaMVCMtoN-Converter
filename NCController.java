// NCController class
// Handles user input and interaction between the model and view
package NumConvert;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public class NCController implements ActionListener{
    
    private NCModel ncm = null;
    private NCView ncv = null;
    
    // Link controller to model and view
    public void initialize(NCModel m, NCView v)
    {
        ncm = m;
        ncv = v;
    }
    
    // implement the ActionListener for each button press
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       String btnText = ((JButton) evt.getSource()).getText();
       if ("Convert".equals(btnText))
       {
           ncm.convert(ncv);
       }
       else if ("Clear".equals(btnText))
       {
           ncm.clear();
       }
       if ("New with last".equals(btnText))
       {
           ncm.newWithLast();
       }
       
       // update the view with new changes to model
           ncv.updateView(ncm);
    }
    
}
