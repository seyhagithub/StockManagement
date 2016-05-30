import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;

public class Display {
	static Scanner menu;
	static char[] input;
 	public  void showMenu(){

		Table t = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,  
				ShownBorders.SURROUND);
		CellStyle numberStyle = new CellStyle(HorizontalAlign.center);

		t.setColumnWidth(0, 80, 120);
	    
		t.addCell("*)Display | W)rite | R)ead | U)pdate | D)elete | F)irst | P)revious | "
				+ "L)ast",numberStyle);
		t.addCell(" ");
		t.addCell("S)earch | G)o to | Se)t row | Sa)ve | B)ack up | Re)store | H)elp |"
				+ " E)xit",numberStyle);
		
		System.out.println(t.render());
		System.out.println("options > ");
		menu = new Scanner(System.in);
		
	}
	
	public void displayData(ArrayList<Stock> readData, Integer offset, Integer record){
		Integer no = 0;
		
		Table t = new Table(5,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.ALL);
		CellStyle numberStyle = new CellStyle(HorizontalAlign.center);
		
		t.setColumnWidth(0, 15, 30);
	    t.setColumnWidth(1, 15, 30);
	    t.setColumnWidth(2, 15, 30);
	    t.setColumnWidth(3, 15, 30);
	    t.setColumnWidth(4, 15, 30);
	    
	    t.addCell("ID", numberStyle);
	    t.addCell("name", numberStyle);
	    t.addCell("Unit Price", numberStyle);
	    t.addCell("Quantity", numberStyle);
	    t.addCell("Imported Date",numberStyle);
	    
		int totalRow = readData.size();
	    for(int i=offset;i<record;i++){
	    	//no = readData.get(i).ID ;
	    	t.addCell(""+readData.get(i).getID(), numberStyle);
	    	t.addCell(readData.get(i).getName().toString(), numberStyle); 
	    	t.addCell(""+readData.get(i).getPrice(), numberStyle);
	    	t.addCell(""+readData.get(i).getQty(), numberStyle);
	    	t.addCell(readData.get(i).getDateImported().toString(),numberStyle);		 
	    }
	    t.addCell("Page: " + 1 + "/" + totalRow/record , numberStyle, 3);
	    t.addCell("Total Records: " + totalRow ,numberStyle, 2);
	    
	    System.out.println(t.render());	
	    
	}
	
	public void selectMenu(String input, ArrayList c){
		switch(input.toLowerCase()){
			case "*":
				System.out.println("Display");
				break;
			case "w":
				System.out.println("Write");
				break;
			case "r":
				System.out.println("Read");
				break;
			case "u":
				System.out.println("Update");
				break;
			case "d":
				System.out.println("Delete");
				break;
			case "f":
				System.out.println("First page");
				break;
			case "P":
				System.out.println("Privous page");
				break;
			case "l":
				System.out.println("Last page");
				break;
			case "s":
				System.out.println("search");
				Scanner scan = new Scanner(System.in);
				String name = scan.next();
				searchByName(name,c);
				break;
			case "g":
				System.out.println("go to");
				break;
			case "se":
				System.out.println("set row");
				break;
			case "b":
				System.out.println("Back");
				break;
			case "re":
				System.out.println("restore");
				break;
			case "h":
				System.out.println("help");
				break;
			case "e":
				System.out.println("Thank for your using my app....");
				System.exit(0);
				break;
			default:
				System.out.println("Incorrect Syntax!");
		}
	}
	
	public static void searchByName(String search, ArrayList<Stock> c){
		Stock stock = new Stock();
		stock.setName(search);
		Iterator <Stock> itr = c.iterator();
		while(itr.hasNext()){
				Stock element = itr.next();
				if(element.getName() == stock.getName()){
					System.out.println("Found");
					break;
				}
			
		}
		
	}
	
}
