package food_order_webapp.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UserOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	private LocalDateTime datetime;
	private String uname;
	private String uaddress;
	private long uphone;
	private String umail;
	private float totalbill;
	private String payment_mode;
	private String payment_status;
	private String order_status;
	@ManyToMany
	private List<UserOrderItems> userOrderItems;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uddress) {
		this.uaddress = uddress;
	}
	public long getUphone() {
		return uphone;
	}
	public void setUphone(long uphone) {
		this.uphone = uphone;
	}
	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public float getTotalbill() {
		return totalbill;
	}
	public void setTotalbill(float totalbill) {
		this.totalbill = totalbill;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public List<UserOrderItems> getUserOrderItems() {
		return userOrderItems;
	}
	public void setUserOrderItems(List<UserOrderItems> userOrderItems) {
		this.userOrderItems = userOrderItems;
	}
	@Override
	public String toString() {
		return "UserOrder [order_id=" + order_id + ", datetime=" + datetime + ", uname=" + uname + ", uddress="
				+ uaddress + ", uphone=" + uphone + ", umail=" + umail + ", totalbill=" + totalbill + ", payment_mode="
				+ payment_mode + ", payment_status=" + payment_status + ", order_status=" + order_status
				+ ", userOrderItems=" + userOrderItems + "]";
	}
}
