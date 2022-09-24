/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uhh.lab3;

import java.io.*;

/**
 *
 * @author devoncz
 */
public class CosPlayTrekkie extends Trekkie {
    
    public String costume;
    
    public CosPlayTrekkie(String type, String name, int nerdFactor, boolean kirkBetterThanPicard, boolean speaksKlingon, String costume)
    {
        super(type,name,nerdFactor,kirkBetterThanPicard,speaksKlingon);
        this.costume = costume;
    }
    
    public String toString()
    {
        String trekkie = new String(name + " is a level " +
                nerdFactor + " Star Trek nerd ");
        String klingon;
        String costumeChoice;
        if(speaksKlingon)
            klingon = new String("who speaks Klingon ");
        else klingon = new String("who does not speak Klingon ");
        String captain;
        if(kirkBetterThanPicard)
            captain = new String("and thinks Captain Kirk is better than Captain Picard.");
        else captain = new String("and thinks Captain Picard is better than Captain Kirk.");
        
        //Is there a better way to override this function without copy pasting all the code? 
        //The change is so minor it feels like a waste.
       
        costumeChoice = new String(" Their costume choice is a " +costume + ".");
        
        return new String(trekkie + klingon + captain + costumeChoice);
    }
    
    public void harass()
    {
        if(speaksKlingon)
        {
            System.out.println("You ask trekkie " + name +
                    " if there is a word in Klingon for loneliness and make fun of them for wearing a " + costume + " costume" +
                    "(and then give him/her a " + getHarassment() + ")!");
            return;
        }
        if(kirkBetterThanPicard)
        {
            System.out.println("You tell trekkie " + name + 
                    " that Captian Kirk is better than Captain Picard and make fun of them for wearing a " + costume + " costume" +
                    "(and then give him/her a " + getHarassment() + ")!");
            return;
        }
        System.out.println("You tell trekkie " + name + 
                    " that Captian Picard is better than Captain Kirk and make fun of them for wearing a " + costume + " costume" +
                    "(and then give him/her a " + getHarassment() + ")!");
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
//        outputFile.println("Cosplay\nName: " + name + "\nNerd Level: " + nerdFactor + "\nKirk Better: " + kirkBetterThanPicard + "\nSpeaks Klingon: " + speaksKlingon + "\nCostume: " + costume + "\n---------------------------------------");
//        outputFile.close();
//        }
//        catch (Exception e)
//        {
//            System.out.println("Failed to append to file");
//        }
    }
    
}
