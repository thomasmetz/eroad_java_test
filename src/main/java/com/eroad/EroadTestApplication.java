package com.eroad;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eroad.service.EroadService;

/**
 * 
 * @author thomasmetz
 *
 */
@SpringBootApplication
public class EroadTestApplication implements CommandLineRunner{

	@Resource
	private EroadService eroadService;
	
	public static void main(String[] args) {
		SpringApplication.run(EroadTestApplication.class, args);
	}
	
    @Override
    public void run(String... args) throws Exception {
    	eroadService.execute();
    }	
}