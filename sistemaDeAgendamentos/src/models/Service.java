package models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Service implements Serializable {
	private int id;
	private String serviceName;
	private BigDecimal price;
	
	public Service(int id, String serviceName, BigDecimal price) {
		this.setId(id);
		this.setServiceName(serviceName);
		this.setPrice(price);
	}
	
	public String getServiceName() {
		return this.serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public BigDecimal getPrice() {
		return this.price;
	}
	public void setPrice(BigDecimal price) {
	    this.price = price;

	}
    @Override
    public String toString() {
        return serviceName;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
