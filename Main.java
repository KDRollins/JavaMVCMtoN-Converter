// Java M-to-N Converter using MVC design pattern
// Programmed by Kristopher Rollins

package NumConvert;


public class Main {


    public static void main(String[] args) {
   
               // Create MVC objects
               NCModel ncm = new NCModel();
               NCView ncv = new NCView();
               NCController ncc = new NCController();
               
               // initialize controller with references to model and view
               ncc.initialize(ncm, ncv);
               
               // initialize view with reference to controller
               ncv.initialize(ncc);
               
               // update the view with accurate model information
               ncv.updateView(ncm);
               
    }
}
