package com.example.domain;

import java.util.Date;

public class User {

	private Long userId;
	private String userName;
	private Date userRegistrationDate;
	private String userCategory;
	private Order order;

	public User(Long userId, String userName, Date userRegistrationDate, String userCategory, Order order) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRegistrationDate = userRegistrationDate;
		this.userCategory = userCategory;
		this.order = order;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getUserRegistrationDate() {
		return userRegistrationDate;
	}

	public void setUserRegistrationDate(Date userRegistrationDate) {
		this.userRegistrationDate = userRegistrationDate;
	}

	public String getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((userCategory == null) ? 0 : userCategory.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userRegistrationDate == null) ? 0 : userRegistrationDate.hashCode());
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
		User other = (User) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (userCategory == null) {
			if (other.userCategory != null)
				return false;
		} else if (!userCategory.equals(other.userCategory))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userRegistrationDate == null) {
			if (other.userRegistrationDate != null)
				return false;
		} else if (!userRegistrationDate.equals(other.userRegistrationDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userRegistrationDate=" + userRegistrationDate
				+ ", userCategory=" + userCategory + "]";
	}

}
