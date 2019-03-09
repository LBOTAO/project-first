package cn.happy.day03manytomany.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色的实体类
 * @author zhy
 *
 */
@Entity
@Table(name = "sys_role")
public class SysRole implements Serializable {
	@Id
	@Column(name = "role_id")
	@GenericGenerator(name = "uuid",strategy = "uuid")  //声明一个主键生成器  name 生成器的名字 strategy是hibernate的主键生成策略
	@GeneratedValue(generator = "uuid")
	private String roleId;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "role_memo")
	private String roleMemo;
	
	//多对多关系映射：一个角色可以赋予多个用户
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role_res",
			joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "role_id")} //当前实体在中间表的外键字段
	                 ,inverseJoinColumns ={@JoinColumn(name = "user_id",referencedColumnName = "user_id")} ) //对方实体在中间表的外键字段
	private Set<SysUser> users = new HashSet<SysUser>(0);

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleMemo() {
		return roleMemo;
	}
	public void setRoleMemo(String roleMemo) {
		this.roleMemo = roleMemo;
	}
	public Set<SysUser> getUsers() {
		return users;
	}
	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "SysRole [roleId=" + roleId + ", roleName=" + roleName + ", roleMemo=" + roleMemo + "]";
	}
	
	
}
