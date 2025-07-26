package com.Spring.spring_data_jpa;

import com.Spring.spring_data_jpa.model.Student;
import com.Spring.spring_data_jpa.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		StudentRepo repo = context.getBean(StudentRepo.class);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setId(101);
		s1.setName("Nilmoni");
		s1.setTech("Java Developer");

		s2.setId(102);
		s2.setName("Naitik");
		s2.setTech("Web Developer");

		s3.setId(103);
		s3.setName("Anshuman");
		s3.setTech("AI");

		//Saving data
//		repo.save(s1);
//		repo.save(s2);
//		repo.save(s3);

		//Fetching data
		System.out.println(repo.findAll());
		//Fetching by id
		System.out.println(repo.findById(102));
		//Fetching by different variable like name
		System.out.println(repo.findByName("Nilmoni"));

		//Updating data
		Student s4 = context.getBean(Student.class);
		s4.setId(102);
		s4.setName("Rishi");
		s4.setTech("Python");
		repo.save(s4);
		System.out.println(repo.findAll());

		//Deleting data
		repo.delete(s3);
		System.out.println(repo.findAll());
	}

}
