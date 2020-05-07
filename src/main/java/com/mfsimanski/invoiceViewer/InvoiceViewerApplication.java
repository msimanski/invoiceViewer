package com.mfsimanski.invoiceViewer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvoiceViewerApplication implements CommandLineRunner
{
	public static void main(String[] args)
	{
		SpringApplication.run(InvoiceViewerApplication.class, args);
	}
	
	@Override
	public void run(String... arg) throws Exception
	{
		System.out.print("Test");
	}
}
