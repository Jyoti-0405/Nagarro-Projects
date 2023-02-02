package nagarro_01_core_java;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char chr = 0;
		do {
			try {
				SetValue  s = new SetValue();
				InsuranceCalculator calculator = new InsuranceCalculator();
				Car c = new Car();
				s.getInfo(c);
				calculator.getResult(c);
				System.out.println("Do you want to enter details fo any other car(y/n):");
				chr = sc.next().charAt(0);
			}
			catch(Exception e) {
				System.out.println("Invalid Input...Please enter a valid Input");
			}
		}
		while(chr == 'y');
	}

}
