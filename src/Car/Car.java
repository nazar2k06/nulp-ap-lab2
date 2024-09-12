package Car;

public class Car {
	public Car() {
		id = 0;
		model = "";
		year = 0;
		price = 0;
		reg_number = "";
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setRegNumber(String reg_number) {
		this.reg_number = reg_number;
	}


	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return price;
	}


	public String toString() {
		String car_info = "";

		car_info += "ID: " + id + '\n';
		car_info += "Model: " + model + '\n';
		car_info += "Year: " + year + '\n';
		car_info += "Price: " + price + '\n';
		car_info += "Reg. number: " + reg_number;

		return car_info;
	}

	private int id;
	private String model;
	private int year;
	private int price;
	private String reg_number;
}