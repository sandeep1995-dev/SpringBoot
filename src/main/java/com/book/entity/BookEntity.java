package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOK")
public class BookEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer bookId;
	@Column(name = "NAME")
	private String bookName;
	@Column(name = "PRICE")
	private Integer bookPrice;
	@Column(name = "AUTHOR")
	private String bookAuthor;
}
