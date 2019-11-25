package com.lwc.linux.apple;

public class MainTest {
	
	public static void main(String[] args) {
		
		Plate plate = new Plate();
		Father father = new Father(plate);
		Mother mother = new Mother(plate);
		Son son = new Son(plate);
		Daughter daughter = new Daughter(plate);
		
		Thread tf = new Thread(father);
		tf.setName("爸爸");
		
		Thread tm = new Thread(mother);
		tm.setName("妈妈");
		
		Thread ts1 = new Thread(son) ;
		ts1.setName("大儿子");
		
		Thread ts2 = new Thread(son);
		ts2.setName("小儿子");
		
		Thread td1 = new Thread(daughter);
		td1.setName("大女儿");
		
		Thread td2 = new Thread(daughter);
		td2.setName("小女儿");

		tf.start();
		tm.start();
		ts1.start();
		ts2.start();
		td1.start();
		td2.start();
	}
}
