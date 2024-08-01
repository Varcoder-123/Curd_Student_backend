package curd.student.records;

import curd.student.records.entity.Student;
import curd.student.records.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
@SpringBootApplication
public class RecordsApplication  {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {

		SpringApplication.run(RecordsApplication.class, args);
	}


}
