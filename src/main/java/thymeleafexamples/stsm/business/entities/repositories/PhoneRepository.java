package thymeleafexamples.stsm.business.entities.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import thymeleafexamples.stsm.business.entities.Phone;

@Repository
public class PhoneRepository {
	@Autowired
	private MongoTemplate mongoTemplate;

    @Value("${key}")
    private String key;
    
	public List<Phone> findAll() {
		return this.mongoTemplate.findAll(Phone.class);
	}

	public void insert() {
		System.out.println("CREATE INSTANCE FOR: " +  this.key);
		
		List<Phone> phones = new PhoneFactory().getPhones(this.key);
		
		mongoTemplate.insertAll(phones);
	}

}
