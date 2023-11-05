package finalHollenback;

import java.util.ArrayList;

public interface FileService 
{
	public ArrayList<Saleable> readData (String name);
	
	public boolean writeData (String name, ArrayList<Saleable> inventory);
	
}
