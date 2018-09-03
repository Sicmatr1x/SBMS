package com.joe.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="item")
public class Item {
	@Id
	@Column(name="i_id")
	@GenericGenerator(name="ug", strategy="uuid")
	@GeneratedValue(generator="ug")
	private String iid;
	@Column(name="item_name")
	private String itemName;
	@Column(name="num")
	private Integer num;
	
	
	@ManyToOne(targetEntity=Base.class)
	@JoinColumn(name="b_id")
	@JsonIgnore
	private Base base;
	
	
	public Item() {

	}
	public Item(String iid, String itemName, Integer num) {
		super();
		this.iid = iid;
		this.itemName = itemName;
		this.num = num;
	}
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Base getBase() {
		return base;
	}
	public void setBase(Base base) {
		this.base = base;
	}
	
}
