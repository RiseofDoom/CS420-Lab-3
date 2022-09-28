
package uhh.lab3;
import java.util.*;
import java.io.*;
import javax.swing.*;
        
/**
 *
 * @author Devon Czerwonka and Jaden Matsunaka
 */



public class Lab3 {
    
    /** Creates a new instance of Lab2 */
    public Lab3() {
    }
    
    
    /**
       Print a list of nerds.
       @param A list containing GenericNerd objects.
     */
    public static void showNerdList(ArrayList<GenericNerd> list)
    {
        
        if(list.size() == 0)
        {
            System.out.println("\tThere are no nerds.");
        }
        
        for(int i = 0; i < list.size(); i++)
        {
            GenericNerd nerd = list.get(i);
            // note implicit call to nerd.toString() below.
            System.out.println(nerd.type);
            System.out.println(nerd);
            nerd.harass();
            System.out.println("---------------------------------------");
            
        }
        
    }
        
    public static void writeNerdsFile(ArrayList<GenericNerd> list)
    {
        System.out.println();
        System.out.println("ADDING NERDS TO FILE");
        System.out.println();
        
        if(list.size() == 0)
        {
            System.out.println("\tThere are no nerds to add.");
        }
        
        for(int i = 0; i < list.size(); i++)
        {
            try
            {
                FileOutputStream fs = new FileOutputStream("nerdRoster.dat",true);
                ObjectOutputStream output = new ObjectOutputStream(fs);
           
                output.writeObject(list); //Now writes object to binary file
                output.close();
            }
            catch (Exception e) {System.out.println("Failed to append to file");}
        }
        
        System.out.println();
        System.out.println("FINISHED ADDING NERDS TO FILE");
        System.out.println();
    }
   
    public static void readNerdsFile(ArrayList<GenericNerd> list) //Reads nerd information from the text file, reads a line containing the type of nerd so it knows what information to grab
    {
        GenericNerd storedNerd;
        boolean objectExists = true;
        ArrayList<GenericNerd> tempList = new ArrayList(10);
        
        try
        {
           FileInputStream fs = new FileInputStream("nerdRoster.dat");
           ObjectInputStream input = new ObjectInputStream(fs);
           
            tempList = (ArrayList<GenericNerd>) input.readObject(); //reads objects from binary file and adds them to array list
               
            for(GenericNerd nerd: tempList)
            {
                System.out.println(nerd.toString()); 
            }
           
           input.close();
        }
        catch (Exception e) {System.out.println("Failed to read from file"); }
        
        list.addAll(tempList); //Copies temp list to actual list so it can be returned out of the method
    }
    
     public static void harassNerds(ArrayList<GenericNerd> list)
    {
        System.out.println();
        System.out.println("************************************************");
        System.out.println("*               Harassing Nerds                *");
        System.out.println("************************************************");
        System.out.println();
        
        if(list.size() == 0)
        {
            System.out.println("\tThere are no nerds to harass.");
        }
        
        for(int i = 0; i < list.size(); i++)
        {
            GenericNerd nerd = list.get(i);
            nerd.harass();
        }
        
        System.out.println();
        System.out.println("************************************************");
        System.out.println("*   Finished Harassing Nerds (that was fun!)   *");
        System.out.println("************************************************");
        System.out.println();
    }
     
    public static void task2_write(double array[][])
    {
        JFileChooser choose = new JFileChooser();
        
        if(choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            File file = choose.getSelectedFile();
            
            try
            {
                FileOutputStream fs = new FileOutputStream(file);
                DataOutputStream output = new DataOutputStream(fs);
           
                for(int row = 0; row < array.length; row++)
                {
                    for(int col = 0; col < array[row].length; col++)
                    {
                        output.writeDouble(array[row][col]);
                    }
                }
                output.close();
            }
            catch (Exception e) {System.out.println("Failed to append to file");}
            
            try
            {
                FileInputStream fs = new FileInputStream(file);
                DataInputStream input = new DataInputStream(fs);
                ArrayList<Double> temp2 = new ArrayList<Double>();
                
                while(true) //reads ints from binary file and adds them to array list until reaching end of file
                {
                    try
                    {
                       temp2.add(input.readDouble());  
                    }
                    catch(EOFException e)
                    {
                        break;
                    }
                }
                input.close();
                
                System.out.println(temp2.toString()); //prints out entire array list
                
            }
            catch (Exception e) {System.out.println("Failed to append to file");}
            
        }
        else { System.out.println("Error: File not choosen"); }
        
        
        
    }
    
     
    public static void task3()
    {
        JFileChooser choose = new JFileChooser(); //Lets user select a file, uses default location since I have no idea what your file directories would be
        choose.showOpenDialog(null);
        File file = choose.getSelectedFile();
        
        int[] temp = {10,20,30,40,50,60,70,80,90,100}; //an array of values so I don't have a buncha lines just to write to the file
        ArrayList<Integer> temp2 = new ArrayList<Integer>(); //an arraylist of integers to use when reading from the binary file
        
        try
        {
            RandomAccessFile randomFile = new RandomAccessFile(file,"rw"); 
            
            for(int num : temp) //goes through int array to add all values to binary file
            {
                randomFile.writeInt(num);
            }
            
            randomFile.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: Failed to append to file");
        }
        
        try
        {
            RandomAccessFile randomFile = new RandomAccessFile(file,"rw");
            
            randomFile.seek(4*4); //seek takes you to the line you want (times 4 because of size of int in bytes)
            randomFile.writeInt(-50); //replaces line with negative value
            randomFile.seek(9*4);
            randomFile.writeInt(-100);
            
            randomFile.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: Failed to append to file");
        }
        
        try
        {
            RandomAccessFile randomFile = new RandomAccessFile(file,"rw");
                        
            while(true) //reads ints from binary file and adds them to array list until reaching end of file
            {
                try
                {
                   temp2.add(randomFile.readInt());  
                }
                catch(EOFException e)
                {
                    break;
                }
                
            }
            
            System.out.println(temp2.toString()); //prints out entire array list
            
            randomFile.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: Failed to append to file");
        }
        
        
    }
     
     
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        try {
//        PrintWriter outputFile = new PrintWriter("nerdroster.txt");
//        FileOutputStream fs = new FileOutputStream("nerdRoster.dat");}//Empties the file on run, for testing stuff
//        catch (Exception e) { System.out.println("Failed to create file"); }
        
        
        // TODO code application logic here
        
        //System.out.println("<<< CS 420 Lab 1 Test Code. >>>");
        
        // List to keep a few nerds in
        ArrayList<GenericNerd> nerdList = new ArrayList(10);
        
        
        
        // create a few nerds and add them to the list
        GenericNerd nerd = new GenericNerd("GenericNerd","Nerdy Nerd", 9);
        nerdList.add(nerd);
        // This will generate a warning message:
        nerd = new GenericNerd("GenericNerd","Lame-o Lamerson", 12);
        nerdList.add(nerd);
        
        
        // POLYMORPHISM IN ACTION!!!
        nerd = new Trekkie("Trekkie","Captain Spazz", 3,false,true);
        nerdList.add(nerd);
        nerd = new CosPlayTrekkie("CosPlayTrekkie","Glenn", 4, true, true, "Borg drone");
        nerdList.add(nerd);
        nerd = new Trekkie("Trekkie","Lt. Commander Loser", 10,true,true);
        nerdList.add(nerd);
        // generate another warning (Klingon speaker of a low level)
        nerd = new Trekkie("Trekkie","Deanna Troi fanboy", 6,true,false);
        nerdList.add(nerd);
        // round out the list with a few more various nerds
        nerd = new GenericNerd("GenericNerd","Baron Ron von Dorkenstein", 10);
        nerdList.add(nerd);
        nerd = new GenericNerd("GenericNerd","Donnie Doofus", 8);
        nerdList.add(nerd);
        
        nerd = new GamerGeek("GamerGeek","PC Gamer", "PC", 8);
        nerdList.add(nerd);
        nerd = new GamerGeek("GamerGeek","PS5 Gamer", "Xbox Series X", 10);
        nerdList.add(nerd);
        
        nerd = new CosPlayTrekkie("CosPlayTrekkie","Joe Mother", 7, false, true, "Vulcan");
        nerdList.add(nerd);
        nerd = new GamerGeek("GamerGeek","Xbox Gamer", "PS5", 3);
        nerdList.add(nerd);
        nerd = new CosPlayTrekkie("CosPlayTrekkie","Jimmy", 10, true, false, "Klingon");
        nerdList.add(nerd);
        
        
        //TASK 1 FOR LAB 3
        
        writeNerdsFile(nerdList);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nerd Roster created, press return to continue...");
        String s = keyboard.nextLine();
        
        ArrayList<GenericNerd> nerdList2 = new ArrayList(10);
        readNerdsFile(nerdList2);
        
        harassNerds(nerdList2);
        
        
        //TASK 2 FOR LAB 3
        
        double[][] x = {{10.34,23.567,61.2},{-12.0,200.32,30e2}};
        task2_write(x);



        //TASK 3 FOR LAB 3
        
        task3(); 
        
    }
    
}

