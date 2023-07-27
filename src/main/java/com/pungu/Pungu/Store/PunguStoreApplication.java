package com.pungu.Pungu.Store;

import com.pungu.Pungu.Store.Entities.Author;
import com.pungu.Pungu.Store.Entities.Book;
import com.pungu.Pungu.Store.Repositories.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class PunguStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(PunguStoreApplication.class, args);
		System.out.println("Hello, This is Pungu.");
	}

//	@Bean
//	public ModelMapper modelMapper(){
//		return  new ModelMapper();
//	}
}
