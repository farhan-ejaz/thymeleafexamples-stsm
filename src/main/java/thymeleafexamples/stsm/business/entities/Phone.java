package thymeleafexamples.stsm.business.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "phones")
public class Phone {
	@Id
	public String id;
	
	public int price;
	
	public String model;
	
	public String features;
	
	 @Override
	  public String toString() {
	    return "Phone [id=" + id + ", model=" + model + ", price=" + price + ", features=" + features + "]";
	  }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

}
