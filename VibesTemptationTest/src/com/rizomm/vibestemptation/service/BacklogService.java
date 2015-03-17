package com.rizomm.vibestemptation.service;

import java.util.List;

import com.rizomm.vibestemptation.bo.Backlog;
import com.rizomm.vibestemptation.bo.Product;
import com.rizomm.vibestemptation.bo.Client;


public interface BacklogService {

	public Client createClient(Client user);

	public void updateClient(Client user);

	public void deleteClient(Client user);

	public List<Client> listClients();
	
	public Client getClient(int id);

	public Product createProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Product product);

	public List<Product> listProducts();
	
	public Product getProduct(int id);

	public Backlog getBacklog();
}
