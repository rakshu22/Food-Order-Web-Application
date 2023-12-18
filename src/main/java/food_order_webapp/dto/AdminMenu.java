package food_order_webapp.dto;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class AdminMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	@Lob
	private byte[] image;
	private String name;
	private float price;
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [item_id=" + item_id + ", image=" + Arrays.toString(image) + ", name=" + name + ", price=" + price
				+ "]";
	}
}
