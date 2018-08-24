
public class Word {
	private String word;
	private int count;
	
	public Word(){
		setWord(null);
		setCount(null);
	}
	
	public Word(String w, int c){
		setWord(w);
		setCount(c);
	}
	
	public Word(String w, String c) {
		setWord(w);
		setCount(c);
		
	}
	
	public void setWord(String w){
		this.word = w;
	}
	
	public void setCount(String c){
		this.count = Integer.parseInt(c);
	}
	
	public void setCount(int c){
		//this.count = Integer.toString(c);
		this.count = c;
	}
	
	public String getWord(){
		return word;
	}
	
	public int getCount(){
		return count;
	}
	
	public String toString(){
		String out = word + " : " + count;
		return out;
	}

}
