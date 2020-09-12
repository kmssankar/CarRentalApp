package com.cts.fse.car.rental.dto;

public class ReturnCarReviewDTO {
	
	int bookingId;
	String comments;
	int rating;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "ReturnCarReviewDTO [bookingId=" + bookingId + ", comments=" + comments + ", rating=" + rating + "]";
	}
	
	
}
