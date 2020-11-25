package com.myclass.dto;

import java.math.BigDecimal;

public class CourseDto {
	private int id;
	private String title;
	private String image;
	private int letures_count;
	private int hour_count;
	private int view_count;
	private BigDecimal price;
	private int discount;
	private BigDecimal promotion_price;
	private String description;
	private String content;
	private int category_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLetures_count() {
		return letures_count;
	}

	public void setLetures_count(int letures_count) {
		this.letures_count = letures_count;
	}

	public int getHour_count() {
		return hour_count;
	}

	public void setHour_count(int hour_count) {
		this.hour_count = hour_count;
	}

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public BigDecimal getPromotion_price() {
		return promotion_price;
	}

	public void setPromotion_price(BigDecimal promotion_price) {
		this.promotion_price = promotion_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public CourseDto(int id, String title, String image, int letures_count, int hour_count, int view_count,
			BigDecimal price, int discount, BigDecimal promotion_price, String desciption, String content) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.letures_count = letures_count;
		this.hour_count = hour_count;
		this.view_count = view_count;
		this.price = price;
		this.discount = discount;
		this.promotion_price = promotion_price;
		this.description = description;
		this.content = content;
	}
	public CourseDto() {}
}
