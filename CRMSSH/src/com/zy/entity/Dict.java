package com.zy.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dict implements Serializable{
	private int did;
	private String dname;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
}
