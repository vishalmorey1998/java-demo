package com.user.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private int userId;
  private String fullName;
  private String userName;
  private String password;
  private long contactNumber;
  @Lob
  @Column(length = 999999999)
  private byte[] pancardImage;
  @Lob
  @Column(length = 999999999)
  private byte[] aadharCardImage;
  @Lob
  @Column(length = 999999999)
  private byte[] profileImage;

}
