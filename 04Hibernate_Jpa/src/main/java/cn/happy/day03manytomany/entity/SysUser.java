package cn.happy.day03manytomany.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户的实体类
 * @author zhy
 *
 */
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {
	@Id
	@Column(name = "user_id")
	@GenericGenerator(name = "uuid",strategy = "uuid")  //声明一个主键生成器  name 生成器的名字 strategy是hibernate的主键生成策略
	@GeneratedValue(generator = "uuid")
	private String userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_password")
	private String userPassword;
	@Column(name = "user_state")
	private Integer userState;
	
	//多对多关系映射：一个用户可以具备多个角色
	@ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
	private Set<SysRole> roles = new HashSet<SysRole>(0);

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Integer getUserState() {
		return userState;
	}
	public void setUserState(Integer userState) {
		this.userState = userState;
	}
	public Set<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userState=" + userState + "]";
	}
	
	
}
