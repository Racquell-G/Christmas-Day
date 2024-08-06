
public class ChristmasList {

	//The owner of this ChristmasList
	String listOwner;
	
	//The presents stored in this ChristmasList
	Gift[] presents;
	
	//the number of presents on this list
	int length;
	
	//The maximum length of a ChristmasList
	static final int MAX_LENGTH = 8;
	
	//The ratio of nice to naughty gift receivers
	static final double niceToNaughty = .9;
	
	public ChristmasList(String name) { //Constructor
		this.listOwner = name;
		this.presents = new Gift [MAX_LENGTH];
		this.length = 0;
	}

	public static void main(String[] args) {
		ChristmasList greyList = new ChristmasList ("Racquell Grey");
		Gift grey1 = new Gift("Peace and Prosperity for all");
		Gift grey2 = new Gift("Ten Grand Cash", "Cha-ching", "Gold Band");
		Gift grey3 = new Gift("All 5s on the test", "Sounds focused", "Rigorous Preparation");
		
		greyList.addGift(grey1);
		greyList.addGift(grey2);
		greyList.addGift(grey3);
		
		System.out.println(greyList.writeLetter());
		
		ChristmasList greyGifts = greyList.receivePresents();
		
		while(greyGifts.hasPresents()) {
			System.out.println(greyGifts.openPresent());
		}
	}
	
	public  String writeLetter() {
	String out = "Dear Santa,";
	out += "\n";
	out += "\nThis year for Christmas I would like:";
	for (int i = 0; i < length; i++) {
		out += "\n" + presents[i].getName();
	}
	out += "\n";
	out += "\nSincerely, ";
	out += "\n" + listOwner;
	
	return out;
	}
	
	public boolean hasPresents() {
		
		if (length > 0) {
			for (int i= 0; i < length; i++) {
			if (!presents [i].getOpened()) {
				return true;
				}
			}
		}
		return false;
	
	}
	
	public boolean addGift (Gift g) {
		
		if (length != MAX_LENGTH) { 
			presents [length] = g;
			length++;
			return true;
		} 
				return false;	
		
	}
	
	public String openPresent() {
		String noneLeft = "You have no more presents left to open!";
		int k = 0;
		if (hasPresents() == true) {
			Gift aGift;
			aGift = presents [k];
			aGift.open();
			for (int i = length; i >= 0; i--) { //moves items in array to the left by one
				presents [i] = presents [i - 1];
			}
			length --;
		}
		
			return noneLeft;
	}
	
	public ChristmasList receivePresents() {
	ChristmasList delivery = new ChristmasList ((this.listOwner));
	for (int i = 0; i < presents.length; i++) {
		double naughtyOrNiceNum = Math.random();
		if (naughtyOrNiceNum<= niceToNaughty) {
			presents [i] = new Gift ("coal");
			return delivery;
		}
		}
	return delivery;
	}


}
