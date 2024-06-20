package edu.poly.shop.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts",uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Account {
	@Id
	@Column(length = 20)
	private String username;
	@Column(length = 30)
	private String password;
	@Column(columnDefinition = "nvarchar(50) not null")
	private String fullname;
	@Column(columnDefinition = "varchar(100) not null")
	private String email;
	@Column(columnDefinition = "nvarchar(15) not null")
	private String phone;
	@Column(columnDefinition = "varchar(255) not null")
    private String photo ; // Set a default photo URL

    @Column(columnDefinition = "varchar(20) not null")
    @Enumerated(EnumType.ORDINAL)
    private AccountRole role ; // Set default role to User
    @Column(columnDefinition = "varchar(20) not null")
    @Enumerated(EnumType.ORDINAL)
    private AccountStatus accountStatus;
	@Temporal(TemporalType.DATE)
	private Date registedDate;
	@Temporal(TemporalType.DATE)
	private Date updateDate;
	@PrePersist
	public void preCreate() {
		registedDate = new Date();
	}
	@PreUpdate
	public void preUpdate() {
		updateDate = new Date();
	}
}
