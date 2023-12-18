package food_order_webapp.dto;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class UserCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	private int uid;
	private String umail;
	private int fid;
	@Lob
	private byte[] fimage;
	private String fname;
	private float fprice;
	private int fquantity;
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	@Override
	public String toString() {
		return "UserCart [cart_id=" + cart_id + ", uid=" + uid + ", umail=" + umail + ", fid=" + fid + ", fimage="
				+ Arrays.toString(fimage) + ", fname=" + fname + ", fprice=" + fprice + ", fquantity=" + fquantity
				+ "]";
	}
}
