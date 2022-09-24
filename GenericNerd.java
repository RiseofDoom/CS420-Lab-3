/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhh.lab3;
import java.io.*;

public class GenericNerd implements Serializable{
    
    public String name;
    public String type;
    public int nerdFactor;
    
    public GenericNerd(String type, String name, int nerdFactor) {
        if(name == null)
        {
            System.out.println("Error: GenericNerd constructor - name is null!");
            System.exit(1);
        }
        
        // the setNerdFactor method handles parameter range checking
        setNerdFactor(nerdFactor);
        
        this.name = name;
        this.type = type;
    }
    
    /**
       Returns a string containing this nerd's name.
       @return The nerd's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
       Returns this nerd's nerd factor.
       @return This nerd's nerd factor.
     */
    public int getNerdFactor()
    {
        return nerdFactor;
    }
    
    /**
       Sets this nerd's factor to the provided value.
       Precondition: provided nerdFactor must be between 1 and 10.
       Postcondition: This nerd's nerdFactor is set to the provided value.
       @param nerdFactor On a scale of 1 to 10, how nerdy this nerd is.
     */
    public void setNerdFactor(int nerdFactor)
    {
        if((nerdFactor < 1) || (nerdFactor > 10))
        {
            System.out.println("Warning: Nerd factor must be between 1 & 10 (using default 1)!");
            this.nerdFactor = 1;
        }
        else this.nerdFactor = nerdFactor;
    }
    
    /**
       Creates and returns a string indicating this nerd's name and nerd factor
       @return String containing nerd's name and nerdFactor.
     */
    public String toString()
    {
        return new String(name + " is a level " + nerdFactor + " nerd.");
    }
    
    /**
       Harass this nerd.  Harassment is based upon the nerd's nerd factor.
       Postcondition: A message indicating how to harass this nerd is printed.
     */
    public void harass()
    {
        System.out.println("You give nerd " + name + " a " + getHarassment() +
                "!");
    }
    
    /**
       Determine how to harass the nerd based on the nerd's nerd factor.  Higher
       nerd factors result in worse harassment.  NOTE: THIS IS NOT A PUBLIC
       METHOD.  IT IS A HELPER METHOD FOR THE HARASS METHOD.
     */
    public String getHarassment()
    {
        String harassment = null;
        switch (nerdFactor)
        {
            case 1:
            case 2:
            case 3:
                harassment = new String("wet willy");
                break;
            case 4:
            case 5:
            case 6:
                harassment = new String("purple nurple");
                break;
            case 7:
            case 8:
            case 9:
                harassment = new String("wedgie");
                break;
            case 10:  // case 10, code should never get here otherwise
                harassment = new String("SUPER ATOMIC WEDGIE");
                break;
            default: // this should never happen!
                System.out.println("Error: unrecognized error code!!!");
                System.exit(2);
        }
        return harassment;
    }
   
    public void writeNerd()
    {
        try
        {
           FileOutputStream fs = new FileOutputStream("nerdRoster.dat",true);
           ObjectOutputStream output = new ObjectOutputStream(fs);
           
           output.writeObject(this);
           output.close();
        }
        catch (Exception e) {System.out.println("Failed to append to file");}
        
        
        
        
        
        
//        try {
//        FileWriter fwriter = new FileWriter("nerdRoster.txt",true);
//        PrintWriter outputFile = new PrintWriter (fwriter);
//        outputFile.println("Generic\nName: " + name + "\nNerd Level: " + nerdFactor + "\n---------------------------------------");
//        outputFile.close();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Failed to append to file");
//        }
    }
   
    
}
