/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChibeePatag
 *
 */
public class Branch {
	
	private String account;
	
	private String branch_name;
	
	private List<Prize> prizes;

	public String getAccount() {
		return account;
	}
		
	public Branch(String account, String branch_name) {
		super();
		this.account = account;
		this.branch_name = branch_name;
		this.prizes = new ArrayList<Prize>();
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
		

	public List<Prize> getPrizes() {
		return prizes;
	}

	public void setPrizes(List<Prize> prizes) {
		this.prizes = prizes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result
				+ ((branch_name == null) ? 0 : branch_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (branch_name == null) {
			if (other.branch_name != null)
				return false;
		} else if (!branch_name.equals(other.branch_name))
			return false;
		return true;
	}	
		
}
