package cn.youja.uplus.crowd.model;

import java.util.Collection;

public class Crowd {

	private Collection<String> data;

	public Crowd() {
	}

	public Crowd(Collection<String> data) {
		super();
		this.data = data;
	}

	public Collection<String> getData() {
		return data;
	}

	public void setData(Collection<String> data) {
		this.data = data;
	}

}
