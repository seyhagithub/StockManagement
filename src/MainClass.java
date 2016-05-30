import java.io.*;
import java.util.*;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;

public class MainClass  extends Thread{
	static ArrayList<?> insertData;
	static ArrayList<Stock> storeData;
	static ArrayList<Stock> readData;
	static Display display = new Display();
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		boolean b = true;
		Scanner input;
		String menu;
		WriteReadObject writeObjectRead = new WriteReadObject();
		
		long start = System.currentTimeMillis(); 
		storeData = writeObjectRead.writeObject(10000000);
		writeObjectRead.writeToFile(storeData);
		long end = System.currentTimeMillis();
		System.out.println("Insert Data:" + (end - start) + " ms");
		    
	   long st = System.currentTimeMillis();
	   readData = writeObjectRead.readObject("file/stock.txt");
	   //Read Data from collection 
	   long ed = System.currentTimeMillis();
	   System.out.println("Read Data:" + (ed - st)  + " ms");
	   
	   display.displayData(storeData, 0,5);
	   display.showMenu();
	   
	   while(b){
		   input = new Scanner(System.in);
		   menu = input.next();
//		   if(menu == "e"){
//			   b = false;
//		   }
		   display.selectMenu(menu, readData);
		   //readData transfer to display class
		   display.displayData(storeData, 0,5);
		   display.showMenu();
	   }
	   
		 
	}
	
}