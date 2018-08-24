import java.util.Comparator;

public class WordComparator implements Comparator<Word>{
	public int compare(Word w1, Word w2){
		//int value = w1.getCount().compareTo(w2.getCount());
		int value;
		if(w1.getCount() == w2.getCount())
			value = 0;
		else if(w1.getCount() > w2.getCount())
			value = 1;
		else
			value = -1;
		return value;
	}
}