package nagarro_01_core_java;
import java.util.*;

public class SetValue {
	public void getInfo(Car c) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Car Model: ");
		String CarModel = sc.next();
		c.setCarModel(CarModel);
		
		System.out.println("Enter Car Type : ");
		String CarType = sc.next();
		c.setCarType(CarType);
		
		System.out.println("Enter Car Cost Price: ");
		double CarCostPrice = sc.nextDouble();
		c.setCarCostPrice(CarCostPrice);
		
		System.out.println("Enter Car Insurance Type : ");
		String CarInsuranceType = sc.next();
		c.setInsuranceType(CarInsuranceType);
			
	}
}
