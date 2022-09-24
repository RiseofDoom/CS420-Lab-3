/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhh.lab3;

import java.io.*;

public class Trekkie extends GenericNerd {
    
    //Removed name and nerdFactor
    public boolean speaksKlingon;
    public boolean kirkBetterThanPicard;
    

    
    public Trekkie(String type, String name, int nerdFactor, boolean klingonSpeaker, boolean kirkBetter) 
    {
        super(type,name,nerdFactor);
        if(name == null)
        {
            System.out.println("Error: GenericNerd constructor - name is null!");
            System.exit(1);
        }
        
        
        this.name = name;
        if(klingonSpeaker)
        {
            speaksKlingon = true;
            // make sure Klingon speakers have a high enough nerd factor!
            if(nerdFactor < 9)
            {
                System.out.println("Warning: " + name + 
                        " speaks Klingon! (setting nerdFactor to 9).");
                setNerdFactor(9);
            }
        }
        kirkBetterThanPicard = kirkBetter;
    }
    //Removed getNerdFactor and setNerdFactor
    
    /**
       Indicates whether this Trekkie speaks Klingon.
       @return True if this Trekkie speaks Klingon, false otherwise.
     */
    public boolean klingonSpeaker()
    {
        return speaksKlingon;
    }
    
    /**
       Set this Trekkie's status as a Klingon speaker.
       Postcondition: This Trekkie's Klingon speaking status is updated to the
       provided value.
       @param klingonSpeaker The new status of this Trekkie's Klingon fluency.
     */
    public void setKlingonSpeaker(boolean klingonSpeaker)
    {
        speaksKlingon = klingonSpeaker;
    }
    
    /**
       Set this Trekkie's preference of Captain Kirk or Captain Picard
       Postcondition: this Trekkie's captain preference is updated
       @param kirkBetter True if this Trekkie prefers Kirk to Picard, false
       otherwise.
     */
    public void setCaptainPreference(boolean kirkBetter)
    {
        kirkBetterThanPicard = kirkBetter;
    }
    
    /**
       Indicates if this Trekkie prefers Captain Kirk over Captian Picard
       @return true if this Trekkie prefers Kirk to Picard, false otherwise.
     */
    public boolean ThinksKirkIsBetter()
    {
        return kirkBetterThanPicard;
    }
    
    /**
       Constructs and returns a String describing the various nerd qualities of
       this trekkie.
       @return a String indicating the nerd statistics of this Trekkie.
     */
    public String toString()
    {
        String trekkie = new String(name + " is a level " +
                nerdFactor + " Star Trek nerd ");
        String klingon;
        if(speaksKlingon)
            klingon = new String("who speaks Klingon ");
        else klingon = new String("who does not speak Klingon ");
        String captain;
        if(kirkBetterThanPicard)
            captain = new String("and thinks Captain Kirk is better than Captain Picard.");
        else captain = new String("and thinks Captain Picard is better than Captain Kirk.");
        
        return new String(trekkie + klingon + captain);
    }
    
    
    /**
       /**
       Harass this Trekkie.  Harassment is based upon the Trekkie's nerd factor,
       Star Trek captain preference, and Klingon fluency.
       Postcondition: A message indicating how to harass this nerd is printed.
     */
    public void harass()
    {
        if(speaksKlingon)
        {
            System.out.println("You ask trekkie " + name +
                    " if there is a word in Klingon for loneliness " +
                    "(and then give him/her a " + getHarassment() + ")!");
            return;
        }
        if(kirkBetterThanPicard)
        {
            System.out.println("You tell trekkie " + name + 
                    " that Captian Kirk is better than Captain Picard " +
                    "(and then give him/her a " + getHarassment() + ")!");
            return;
        }
        System.out.println("You tell trekkie " + name + 
                    " that Captian Picard is better than Captain Kirk " +
                    "(and then give him/her a " + getHarassment() + ")!");
    }
    
    //removed getHarrassment
    
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
//        outputFile.println("Trekkie\nName: " + name + "\nNerd Level: " + nerdFactor + "\nKirk Better: " + kirkBetterThanPicard + "\nSpeaks Klingon: " + speaksKlingon + "\n---------------------------------------");
//        outputFile.close();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Failed to append to file");
//        }
    }
   
    
}

