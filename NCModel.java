// NCModel class
// Maintains and performs operations on data
package NumConvert;

public class NCModel {
    // charList is all of the possible characters in order of value
    private final String theString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
    private final char[] charArr = theString.toCharArray();
    private String iVal = "0";
    private String oVal = "0";
    private int iRad = 10;
    private int oRad = 16;
    
    public void convert(NCView ncv)
    {
       iRad = ncv.getIRad();
       oRad = ncv.getORad();
       iVal = ncv.getIVal();        
       oVal = outToString(inToDec(iVal));
       
    }
    
    public void newWithLast()
    {
        iVal = oVal;
        iRad = oRad;
        oVal = "0";
        oRad = 10;
    }
    
    public void clear()
    {
      iVal = "0";
      oVal = "0";
      iRad = 10;
      oRad = 10;
    }
    
    // gets and sets
    public String getIVal()
    { return iVal; }
    public String getOVal()
    { return oVal; }
    public int getIRad()
    { return iRad; }
    public int getORad()
    { return oRad; }
    public void setIVal(String newIVal)
    { iVal = newIVal; }
    public void setOVal(String newOVal)
    { oVal = newOVal; }
    public void setIRad(int newIRad)
    { iRad = newIRad; }
    public void setORad(int newORad)
    { oRad = newORad; }
    
    // get decimal value of input string
    private int inToDec(String s)
    {
        int total = 0;
        int h1 = 0;
        int h2 = 0;
        char[] inArr = s.toCharArray();
        for(int i = s.length() - 1; i >= 0; i--)
        {
            h1 = theString.indexOf(inArr[i]);
            h2 = (int)Math.pow(iRad, s.length() - i - 1);
            total += h2 * h1;
        }
        return total;
    }
    
    // return string of converted decimal value
    private String outToString(int t)
    {
        int n = 0;
        int digit = 0;
        int h1 = 0;
        String output = "";
        
        // find max power of output radix
        for(int i = 0; (int)Math.pow(oRad, i) <= t; i++)
            n = i;
        
        // work down from maximum power of radix to 0
        for(int i = n; i >= 0; i--)
        {
            if (t != 0)
            {
                digit = t / (int) Math.pow(oRad, i);
                output+= charArr[digit];
                h1 = (digit * (int)Math.pow(oRad, i));
                if (h1 != 0)
                    t = t % h1;
            }
            else if (t == 0)
                output+= "0";
        }
        
        return output;
    }
}
