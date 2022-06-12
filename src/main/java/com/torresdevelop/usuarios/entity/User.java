package com.torresdevelop.usuarios.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class User {
	
	private String Id;
	private String nickName;
	private String userName;
	private String password;
	

}
