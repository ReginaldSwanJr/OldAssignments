import java.io.*;
import java.util.*;

public class FileWordCounter{
	
	public static void main(String[] args)  throws FileNotFoundException, IOException {
		
		FileReader fRead = new FileReader("txt/properkjv_1.txt");
		PrintStream fOut = new PrintStream(new FileOutputStream("txt/output.txt"));
			

		
		 // hash map
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		
		// BufferReader
		@SuppressWarnings("resource")
		BufferedReader bRead = new BufferedReader(fRead);
		String curLine = bRead.readLine();
		
		int wordCount = 0;
		while(curLine != null){
			String[] line = curLine.split(" ");// breaks the string into an array
			for(int i = 0; i < line.length; i++){
					
				if(myMap.get(line[i]) == null){ // if the word is not in the map put it in there with a count of one
					myMap.put(line[i], 1);
					
					wordCount++;}
				
				else{ // if word already there update the value ex (key(word), value(number))
					int newValue = Integer.valueOf(String.valueOf(myMap.get(line[i])));
	                newValue++;
					myMap.put(line[i], newValue);
					wordCount++;}	
			}
			
			//sBuild.append(System.lineSeparator());
			curLine = bRead.readLine(); // read the next line
			//System.out.println("current line " + curLine);		
		}
		
		System.out.println("*****");
		

		ArrayList<Word> myList = new ArrayList<Word>();
		Map<String, Integer> lister = new Hashtable<String, Integer>(myMap);
		
		for(String key : lister.keySet()){
			Word element = new Word(key, lister.get(key));
			myList.add(element);
		}
		
		
		System.out.println("The paragraph has " + wordCount +" words. The frequency of the letters is as follows");
		fOut.println("The paragraph has " + wordCount +" words. The frequency of the letters is as follows");
		System.out.println();
		fOut.println("");
		
		
		
		
		Collections.sort(myList, new WordComparator()); // sorts the list
		// print the list
		for(Word werd : myList){
			if(werd.getWord().contains("  ")){
				wordCount = wordCount - werd.getCount();
			}
			System.out.println(werd.toString());
			fOut.println(werd.toString());
		}
		fOut.close();
		
		
		
	}
}
