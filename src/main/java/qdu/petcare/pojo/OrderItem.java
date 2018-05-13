package qdu.petcare.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderItem implements Serializable {

	private Integer id;

	private Integer userId;

	private BigDecimal orderNo;

	private Integer productId;

	private String productName;

	private String productImage;

	private Double currentUnitPrice;

	private Integer quantity;

	private Integer totalPrice;

	private Date createTime;

	private Date updateTime;

	private List<OrderItem> list;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(BigDecimal orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Double getCurrentUnitPrice() {
		return currentUnitPrice;
	}

	public void setCurrentUnitPrice(Double currentUnitPrice) {
		this.currentUnitPrice = currentUnitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<OrderItem> getList() {
		return list;
	}

	public void setList(List<OrderItem> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", userId=" + userId + ", orderNo=" + orderNo + ", productId=" + productId
				+ ", productName=" + productName + ", productImage=" + productImage + ", currentUnitPrice="
				+ currentUnitPrice + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", list=" + list + "]";
	}

	
	
	

}
