package com.bnr.model;

import java.util.List;

public class Address {

	private String permnentAddress;
	private String temporaryAddress;
	private String status;

	List<Phone> phone;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	public String getPermnentAddress() {
		return permnentAddress;
	}

	public void setPermnentAddress(String permnentAddress) {
		this.permnentAddress = permnentAddress;
	}

	public String getTemporaryAddress() {
		return temporaryAddress;
	}

	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}

	@Override
	public String toString() {
		return "Address [permnentAddress=" + permnentAddress + ", temporaryAddress=" + temporaryAddress + ", status="
				+ status + ", phone=" + phone + "]";
	}

}
