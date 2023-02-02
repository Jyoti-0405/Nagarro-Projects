package nagarro_01_core_java;

public class InsuranceCalculator {
	public static void getResult(Car c) {
		String CarType = c.getCarType();
	Double CarCostPrice = c.getCarCostPrice();
	System.out.println(CarType);
	String InsuranceType = c.getInsuranceType();
	InsuranceValue value = new InsuranceValue();
	double ans = 0;
	if(CarType.equalsIgnoreCase("Hatchback")) {
		ans = CarCostPrice*value.Hatchback;
	}
	else if(CarType.equalsIgnoreCase("Sedan")) {
		ans = CarCostPrice*value.Sedan;
	}
	else if(CarType.equalsIgnoreCase("SUV")) {
		ans = CarCostPrice*value.SUV;
	}
	else {
		System.out.println("Invalid Input...");
	}
	if(InsuranceType.equalsIgnoreCase("Premium")) {
		ans+=(0.2*ans);
	}
	System.out.println("Car Type -  "+CarType);
	System.out.println("Car Model - "+c.getCarModel());
	System.out.println("Car Cost Price - "+c.getCarCostPrice());
	System.out.println("Car Insurance Premium Type - "+c.getInsuranceType());
	System.out.println("Total amount to be paid is Rs:- "+ans);
	}

}
