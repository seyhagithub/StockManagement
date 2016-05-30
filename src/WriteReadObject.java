import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import org.apache.commons.collections.FastArrayList;

import it.unimi.dsi.fastutil.io.FastBufferedInputStream;
import it.unimi.dsi.fastutil.io.FastBufferedOutputStream;
public class WriteReadObject extends Thread{
		
		 public ArrayList<Stock> writeObject(Integer record) throws IOException, ClassNotFoundException{
			//Stock stock = new Stock (record, "MacBook", 12.86, 12, "25/05/2015");
			ArrayList<Stock> insertData = new ArrayList<Stock>();
			 //ArrayList insertData = new ArrayList();
			for(int i=1;i<=record;i++){
				insertData.add(new Stock (i, "MacBook", 12.86, 12, "25/05/2015"));
			}
//			ObjectOutputStream oos = new ObjectOutputStream( new BufferedOutputStream(
//					new FileOutputStream("file/stock.txt")));
//		    oos.writeObject(insertData);
//		    oos.close();
			return insertData;
		}
		public void writeToFile(ArrayList<?> c) throws IOException{
			ObjectOutputStream oos = new ObjectOutputStream( new BufferedOutputStream(
					new FileOutputStream("file/stock.txt")));
			oos.writeObject(c);
			 oos.close();
		}
		public ArrayList<Stock>readObject(String fileName) throws IOException, ClassNotFoundException{
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(fileName)));
			ArrayList<Stock> readData = (ArrayList<Stock>) ois.readObject(); // cast is needed.
		    //ArrayList<Stock> storeData = new ArrayList<Stock>(readData);
		    ois.close();
		    return readData;
		}
		
		
	
}
