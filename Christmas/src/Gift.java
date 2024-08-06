
public class Gift {
	
	private String name;
	private String hint;
	private String color;
	private boolean opened = false;
	
	public static final String[] COLORS = {"red", "blue", "green", "yellow", "purple"};
	static final String baseHint = "Something shifted inside!";
	
	public Gift(String name, String hint, String color) {
		this.name = name;
		this.hint = hint;
		this.color = color;
	}

	public Gift (String name) {
		this.name = name;
		this.hint = baseHint;
		this.color = COLORS[(int)(Math.random() * COLORS.length)];
	}
	
		public void inspect() { //Gets color of wrapping paper
			if(!opened) {
			System.out.println("It's a present wrapped in " + this.getColor());
			}
		}
		
		public void shake() { //shakes present for hint and prints the hint
			if(!opened) {
			System.out.println(this.getHint());
			}
		}
		
		public String open() { //opens present and gift can't be inspected
			String out = "You rip through " + this.getColor() + " wrapping to find:";
			out += "/n" + this.getName();
			opened = true;
			
			return out;
		}
		
		public String toString() { //tells information on gift
			return "It's a present wrapped in " + this.getColor() + "\n You shake it: "+ this.getHint();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getHint() {
			return hint;
		}

		public void setHint(String hint) {
			this.hint = hint;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public static String[] getColors() {
			return COLORS;
		}
		
		public boolean getOpened() {
			return opened;
		}
		
		public void setOpened(boolean open) {
			this.opened = open;
		}
	//
//		public static String getBasehint() {
//			return baseHint;
//		}

}
