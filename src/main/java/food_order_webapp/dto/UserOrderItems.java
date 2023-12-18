package food_order_webapp.dto;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class UserOrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	private String umail;
	private int fid;
	@Lob
	private byte[] fimage;
	private String fname;
	private float fprice;
	private int fquantity;
	private float subtotal;
	private String order_ref;
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public byte[] getFimage() {
		return fimage;
	}
	public void setFimage(byte[] fimage) {
		this.fimage = fimage;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public float getFprice() {
		return fprice;
	}
	public void setFprice(float fprice) {
		this.fprice = fprice;
	}
	public int getFquantity() {
		return fquantity;
	}
	public void setFquantity(int fquantity) {
		this.fquantity = fquantity;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public String getOrder_ref() {
		return order_ref;
	}
	public void setOrder_ref(String order_ref) {
		this.order_ref = order_ref;
	}
	@Override
	public String toString() {
		return "UserOrderItems [item_id=" + item_id + ", umail=" + umail + ", fid=" + fid + ", fimage="
				+ Arrays.toString(fimage) + ", fname=" + fname + ", fprice=" + fprice + ", fquantity=" + fquantity
				+ ", subtotal=" + subtotal + ", order_ref=" + order_ref + "]";
	}
}
