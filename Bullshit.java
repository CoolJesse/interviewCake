import java.util.Random;

class Bullshit{

	public static int getRandom(int floor, int ceiling){
		Random rand = new Random();
		//return new Random().nextInt(ceiling) + floor;
		return rand.nextInt((ceiling - floor) + 0) + floor;		
	}

	public static void main(String[] arg){
		System.out.println("Testing!!!");

		Random rand = new Random();

		for(int i=0; i < 100; i++){
			//System.out.print( (rand.nextInt(12) + 0) + ", ");
			System.out.print( getRandom(2, 15) + ", ");
		}
/*
		char sample_1 = 'a';
		char sample_2 = 'A';
		char sample_3 = '0';
		char sample_4 = '?';
		char sample_5 = '.';
		char sample_6 = ' ';
		char sample_7 = '-';
		char sample_8 = '	';


		System.out.println("Character " + sample_1 + " is a letter: " + Character.isLetter(sample_1));
		System.out.println("Character " + sample_2 + " is a letter: " + Character.isLetter(sample_2));
		System.out.println("Character " + sample_3 + " is a letter: " + Character.isLetter(sample_3));
		System.out.println("Character " + sample_4 + " is a letter: " + Character.isLetter(sample_4));
		System.out.println("Character " + sample_5 + " is a letter: " + Character.isLetter(sample_5));
		System.out.println("Character " + sample_6 + " is a letter: " + Character.isLetter(sample_6));
		System.out.println("Character " + sample_7 + " is a letter: " + Character.isLetter(sample_7));
		System.out.println("Character " + sample_8 + " is a letter: " + Character.isLetter(sample_8));
	*/
	}
}
