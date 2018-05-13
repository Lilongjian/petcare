package qdu.petcare.pojo;

import java.util.Date;

public class Category {
	
	private Integer id;
	private Integer parent_id;
	private String name;
	private Integer status;
	private Date create_time;
	private Date update_time;
	
	public Category() {
		super();
	}
	
	public Category(Integer parent_id, String name, Integer status, Date create_time, Date update_time) {
		super();
		this.parent_id = parent_id;
		this.name = name;
		this.status = status;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	
	public Category(Integer id, Integer parent_id, String name, Integer status, Date create_time, Date update_time) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		this.status = status;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", parent_id=" + parent_id + ", name=" + name + ", status=" + status
				+ ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
	

}
