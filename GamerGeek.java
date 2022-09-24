/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhh.lab3;

import java.io.*;

public class GamerGeek extends GenericNerd {
    
    //public int console;
    public String consoleName;
    
    public GamerGeek(String type, String name, String consoleName, int nerdFactor)
    {
        super(type,name,nerdFactor);
        
        if(consoleName == "PC" && nerdFactor < 5 || nerdFactor < 1 || nerdFactor > 10)
        {
            System.out.println("Warning: Nerd factor for PC gamer must be above 5 (using default 5)");
            this.nerdFactor = 5;
        }
        else if(consoleName == "Xbox Series X"  && nerdFactor > 6 || nerdFactor < 1 || nerdFactor > 10)
                {
                    System.out.println("Warning: Nerd factor for Xbox gamer must be between 1 and 6 (using default 6)");
                    this.nerdFactor = 6;
                }
       /* 
       switch(console)
       {
           case 1:
               this.consoleName = "PC";
               break;
           case 2:
               this.consoleName = "PS5";
               break;
           case 3:
               this.consoleName = "Xbox Series X";
               break;
       }
        */
        
        //this.name = name;
        //this.console = console;
        this.consoleName = consoleName;
    }
    
      public String toString()
    {
        return new String(name + " is a level " + nerdFactor + " nerd who plays " + consoleName + ".");
    }
    
    /**
       Harass this nerd.  Harassment is based upon the nerd's nerd factor.
       Postcondition: A message indicating how to harass this nerd is printed.
     */
    public void harass()
    {
        System.out.println("You tell nerd " + name + " " + getHarassment());
    }
    
    public String getHarassment()
    {
        String harassment = null;
        switch (consoleName)
        {
            case "PC":
                harassment = new String("Too many bugs on the PC!");
                break;
            case "Xbox Series X":
                harassment = new String("No Xbox game pass on your PlayStation!");
                break;
            case "PS5":
                harassment = new String("You sure must enjoy seeing ads on your console!");
                break;
            default: // this should never happen!
                System.out.println("Error: unrecognized console code!!!");
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
//        outputFile.println("Gamer\nName: " + name + "\nNerd Level: " + nerdFactor + "\nConsole: " + consoleName + "\n---------------------------------------");
//        outputFile.close();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Failed to append to file");
//        }
    }
    
}
