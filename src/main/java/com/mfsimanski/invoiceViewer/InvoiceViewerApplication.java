package com.mfsimanski.invoiceViewer;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mfsimanski.invoiceViewer.model.Invoice;
import com.mfsimanski.invoiceViewer.model.InvoiceRepository;

@SpringBootApplication
public class InvoiceViewerApplication implements CommandLineRunner
{
	@Autowired
	InvoiceRepository invoiceRepository;
	
	public static void main(String[] args)
	{
		SpringApplication.run(InvoiceViewerApplication.class, args);
	}
	
	@Override
	public void run(String... arg) throws Exception
	{
		Optional<Iterable<Invoice>> op = Optional.of(invoiceRepository.findAll());
		Iterable<Invoice> invoices = op.get();
		
		System.out.println("------------------------------");
		System.out.println("        Invoice Viewer        ");
		System.out.println("------------------------------");
		
		Scanner scr = new Scanner(System.in);
		int invoiceNumber = 0;
		int customerId = 0;
		
		boolean flag = true;
		
		String control = "y";
		
		int invoiceOrCustomer = 0;
		
		do
		{
			invoiceNumber = 0;
			customerId = 0;
			invoiceOrCustomer = 0;
			flag = true;
			System.out.println("Search by Invoice Number (1) or Customer ID (2), or quit (3)?");
			if (scr.hasNextInt()) 
			{
				invoiceOrCustomer = scr.nextInt();
			}
			else 
			{
				System.out.println("Invalid: NaN.");
				scr.next();
				continue;
			}
			
			if (invoiceOrCustomer == 1)
			{
				System.out.println("Input an invoice number: ");
				if (scr.hasNextInt()) 
				{
					invoiceNumber = scr.nextInt();
				}
				else 
				{
					System.out.println("Invalid: NaN.");
					scr.next();
					continue;
				}
				
				for (Invoice inv : invoices) 
				{
					if (inv.getInvoiceNumber() == invoiceNumber)
					{
						System.out.println("Invoice found by that number: ");
						System.out.println(inv.toString());
						flag = false;
					}
				}
				
				if (flag)
				{
					System.out.println("No invoice found by that number.");
				}
			} else if (invoiceOrCustomer == 2)
			{
				System.out.println("Input a customer ID: ");
				if (scr.hasNextInt()) 
				{
					customerId = scr.nextInt();
				}
				else 
				{
					System.out.println("Invalid: NaN.");
					scr.next();
					continue;
				}
				
				
				for (Invoice inv : invoices) 
				{
					if (inv.getCustomerId() == customerId)
					{
						System.out.println("Invoice found by that number: ");
						System.out.println(inv.toString());
						flag = false;
					}
				}
				
				if (flag)
				{
					System.out.println("No invoice found by that number.");
				}
			}
			else if (invoiceOrCustomer == 3)
			{
				System.out.println("Bye!");
				System.exit(1);
			}
			else
			{
				System.out.println("Invalid choice.");
				continue;
			}
			
			System.out.println("Search again? (y/n)");
			control = scr.next();
			if (control.equals("y"))
			{
				continue;
			}
			
			System.out.println("Bye!");
		} while (control.equals("y") || control.equals("Y"));
	}
}
