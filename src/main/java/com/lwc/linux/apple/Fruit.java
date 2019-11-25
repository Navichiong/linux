package com.lwc.linux.apple;

public enum Fruit {

	APPLE(1, "苹果"), ORANGE(2, "橘子");

	private Integer id;
	private String fruitName;

	private Fruit(Integer id, String fruitName) {
		this.id = id;
		this.fruitName = fruitName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

}
