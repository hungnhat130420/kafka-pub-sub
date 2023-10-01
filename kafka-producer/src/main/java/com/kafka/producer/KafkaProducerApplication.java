package com.kafka.producer;

import com.kafka.producer.entity.Employee;
import com.kafka.producer.producer.EmployeeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@SpringBootApplication
@EnableScheduling
public class KafkaProducerApplication implements CommandLineRunner {

    private EmployeeProducer employeeProducer;

    @Autowired
    public KafkaProducerApplication(EmployeeProducer employeeProducer) {
        this.employeeProducer = employeeProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
           var emp = new Employee("emp"+i, "Employee "+i, LocalDate.now().toString());
           employeeProducer.sendMessage(emp);
        }
    }
}
