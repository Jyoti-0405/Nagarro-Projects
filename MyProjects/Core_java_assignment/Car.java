package nagarro_01_core_java;

public class Car {
	private String CarModel;
	private String CarType;
	private String InsuranceType;
	private double CarCostPrice;
	
	public String getCarModel() {
		return CarModel;
	}
	public void setCarModel(String carModel) {
		CarModel = carModel;
	}
	public double getCarCostPrice() {
		return CarCostPrice;
	}
	public void setCarCostPrice(double carCostPrice) {
		CarCostPrice = carCostPrice;
	}
	public String getCarType() {
		return CarType;
	}
	public void setCarType(String carType) {
		CarType = carType;
	}
	public String getInsuranceType() {
		return InsuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		InsuranceType = insuranceType;
	}
	
}
