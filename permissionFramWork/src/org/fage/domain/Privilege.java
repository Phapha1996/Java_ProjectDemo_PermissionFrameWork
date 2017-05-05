package org.fage.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_privilege")
public class Privilege implements Serializable{
	private int id;
	private String name;
	private String discription;
	private Date createTime;
	/*private List<Role> roles = new ArrayList<Role>();
	
	@ManyToMany(mappedBy="privileges",fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}*/

	@Temporal(TemporalType.DATE)
	public Date getCreateTime() {
		return createTime;
	}
	
	public String getDiscription() {
		return discription;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Privilege other = (Privilege) obj;
		if (this.name == null) {
			if (other.getName() != null)
				return false;
		} else if (!this.name.equals(other.getName()))
			return false;
		return true;
	}

	
}
