package impl;

import inf.Item;

import java.math.BigDecimal;


public class BasketItems implements Item {

	private int qty;
	private BigDecimal price;
	private String name;
	
	public BasketItems(int q, BigDecimal p, String nm){
		this.qty = q;
		this.price = p;
		this.name = nm;
	}

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public int getQuantity() {
		return this.qty;
	}

	public void setName(String name) {
		this.name = name;		
	}

	public void setPrice(BigDecimal price) {
		this.price = price;		
	}

	public void setQuantity(int quantity) {
		this.qty = quantity;		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		BasketItems other = (BasketItems) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (qty != other.qty)
			return false;

		return true;
	}

}
