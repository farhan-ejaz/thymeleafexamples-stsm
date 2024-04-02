package thymeleafexamples.stsm.business.entities.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import thymeleafexamples.stsm.business.entities.Phone;

@Repository
public class PhoneRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Phone> findAll() {
		return this.mongoTemplate.findAll(Phone.class);
	}

	public void insert() {
		System.out.println("CREATE INSTANCE");
		
		Phone p1 = new Phone();
		p1.setFeatures("NFC, Bluetooth, Gorilla Glass");
		p1.setModel("iPhone 13 SE");
		p1.setPrice(220);

		Phone p2 = new Phone();
		p2.setFeatures("Ultrawide lens with OIS, Bluetooth, Gorilla Glass");
		p2.setModel("iPhone 14");
		p2.setPrice(650);

		// Insert is used to initially store the object into the database.
		mongoTemplate.insert(p1);
		mongoTemplate.insert(p2);
	}

}
