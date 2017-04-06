package edu.kedari;

import edu.kedari.dao.JdbcDaoImpl;
import edu.kedari.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {

		Circle circle  = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}

}
