package com.joe.po;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="base")
public class Base {
	@Id
	@Column(name="b_id")
	@GenericGenerator(name="ug", strategy="uuid")
	@GeneratedValue(generator="ug")
	private String bid;
	@Column(name="base_name")
	private String baseName;
	
	@OneToMany(mappedBy="base", fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)//级联删除cascade
	private List<Item> itemList;
	
	public Base() {
		
	}
	public Base(String bid, String baseName) {
		super();
		this.bid = bid;
		this.baseName = baseName;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		return "Base [bid=" + bid + ", baseName=" + baseName + ", itemList=" + itemList + "]";
	}
	
	
	
}
