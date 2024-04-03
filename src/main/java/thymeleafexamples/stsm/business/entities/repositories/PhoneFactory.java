package thymeleafexamples.stsm.business.entities.repositories;

import java.util.ArrayList;
import java.util.List;

import thymeleafexamples.stsm.business.entities.Phone;

public class PhoneFactory {
	public List<Phone> getPhones(String serviceName) {
		System.out.println("FACTORY: " + serviceName);
		switch (serviceName) {
		case "serviceA": {
			return getiPhones();
		}
		case "serviceB": {
			return getSamsungPhones();
		}
		case "serviceC": {
			return getOppoPhones();
		}
		default: {
			return null;
		}
		}
	}

	private List<Phone> getiPhones() {
		List<Phone> phones = new ArrayList<>();

		Phone p1 = new Phone();
		p1.setFeatures("Face ID");
		p1.setModel("iPhone 13");
		p1.setPrice(59900);

		Phone p2 = new Phone();
		p2.setFeatures("Crash Detection2, Photonic Engine");
		p2.setModel("iPhone 14");
		p2.setPrice(69900);

		Phone p3 = new Phone();
		p3.setFeatures("Crash Detection2, Photonic Engine, Smart HDR 5 for photos");
		p3.setModel("iPhone 15");
		p3.setPrice(79900);

		phones.add(p1);
		phones.add(p2);
		phones.add(p3);

		return phones;
	}

	private List<Phone> getSamsungPhones() {
		List<Phone> phones = new ArrayList<>();

		Phone p1 = new Phone();
		p1.setFeatures("Wifi, Volte");
		p1.setModel("Samsung Galaxy M12");
		p1.setPrice(10999);

		Phone p2 = new Phone();
		p2.setFeatures("Wifi, Volte, 5G");
		p2.setModel("Samsung Galaxy S21");
		p2.setPrice(69999);

		phones.add(p1);
		phones.add(p2);

		return phones;
	}

	private List<Phone> getOppoPhones() {
		List<Phone> phones = new ArrayList<>();

		Phone p1 = new Phone();
		p1.setFeatures("Accelerometer, Proximity, Compass");
		p1.setModel("Oppo A78");
		p1.setPrice(14399);

		Phone p2 = new Phone();
		p2.setFeatures("Geomagnetic Sensor, Proximity Sensor, Optical Sensor, Gravity Sensor, Gyroscope, Pedometer");
		p2.setModel("OPPO F21 Pro 5G");
		p2.setPrice(22770);

		phones.add(p1);
		phones.add(p2);
		return phones;
	}
}