package com.SpringFrame.SpringJDBCDemo;

import com.SpringFrame.SpringJDBCDemo.model.Nil;
import com.SpringFrame.SpringJDBCDemo.repo.Nilrepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);
		Nil n = context.getBean(Nil.class);
		n.setId(111);
		n.setName("Nilu");
		n.setTech("Java");

		Nil n2 = context.getBean(Nil.class);
		n2.setId(103);

		Nilrepo repo = context.getBean(Nilrepo.class);
		repo.save(n);
		System.out.println(repo.findAll());
		System.out.println("Data saved successfully!");
		repo.delete(n2);
		System.out.println(repo.findAll());
		System.out.println("Data deleted...");
	}

}
