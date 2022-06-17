package com.infy.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Customer_tbl")
public class Customer {
	// Ok This is Java
	@Id
	@Column(name="custId")
	int custId;
	
	@Column(name="custName",length=20)
	@NotNull(message="Sorry CustName cannot be null")
	//@Pattern(regexp="[a-zA-Z] {5,10}",message="sorry name is not in pattern")
	String custName;
	
	@Column(name="custAge")
	@Max(value=100,message="Cust max value fail")
	@Min(value=5,message="Cust min value fail")
	int custAge;
	
	@Column(name="custAddr",length=20)
	String custAddr;
	
	public Customer() {
		super();
	}

	public Customer(int custId, String custName, int custAge, String custAddr) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAge = custAge;
		this.custAddr = custAddr;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAge=" + custAge + ", custAddr="
				+ custAddr + "]";
	}
	
	

}
