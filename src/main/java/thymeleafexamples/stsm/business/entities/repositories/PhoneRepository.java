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
		//System.out.println("CREATE INSTANCE");
		
		Phone p = new Phone();
		p.setFeatures("NFC, Bluetooth, Gorilla Glass");
		p.setModel("iPhone 13 SE");
		p.setPrice(220);

		// Insert is used to initially store the object into the database.
		//mongoTemplate.insert(p);
	}

}
