package model;

import java.util.ArrayList;
import java.util.List;

public class Entry {

	private int sn;
	private Branch branch;
	private String coupon_no;
	private String invoice_no;
	private String customer_name;
	private String address;
	private String zip_code;
	private String telephone;
	private String mobile;
	private String created_at;
	
	private List<Prize> prizes;
	
	

	public Entry(String[] line) {
		super();
		this.sn = Integer.parseInt(line[0]);
		
		this.branch = new Branch(line[1], line[2]);
				
		this.coupon_no = line[3];
		this.invoice_no = line[4];
		this.customer_name = line[5];
		this.address = line[6];
		this.zip_code = line[7];
		this.telephone = line[8];
		this.mobile = line[9];
		this.created_at = line[10];
		
		prizes = new ArrayList<Prize>();
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}	

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getCoupon_no() {
		return coupon_no;
	}

	public void setCoupon_no(String coupon_no) {
		this.coupon_no = coupon_no;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public List<Prize> getPrizes() {
		return prizes;
	}

	public void setPrizes(List<Prize> prizes) {
		this.prizes = prizes;
	}
	
	
}
