package com.rizomm.vibestemptation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rizomm.vibestemptation.bo.Backlog;
import com.rizomm.vibestemptation.bo.Product;
import com.rizomm.vibestemptation.bo.Client;

@org.springframework.stereotype.Component
public class BacklogServiceImpl implements BacklogService {
	
	private List<Client> clients = new ArrayList<Client>();
	private List<Product> products = new ArrayList<Product>();
	private Backlog backlog = new Backlog();
	
	private static int idClient = 0;
	private static int idProduct = 0;

	@Override
	public Product createProduct(Product product) {
		product.setId(idProduct++);
		products.add(product);
		return product;
	}

	@Override
	public Client createClient(Client client) {
		client.setId(idClient++);
		clients.add(client);
		return client;
	}

	@Override
	public void deleteProduct(Product product) {
		products.remove(product);
	}

	@Override
	public void deleteClient(Client client) {
		clients.remove(client);
	}

	@Override
	public Backlog getBacklog() {
		return backlog;
	}

	@Override
	public void updateProduct(Product product) {
		products.remove(product);
		products.add(product);
	}

	@Override
	public void updateClient(Client client) {
		clients.remove(client);
		clients.add(client);
	}

	@Override
	public List<Product> listProducts() {
		Collections.sort(products);
		return products;
	}

	@Override
	public List<Client> listClients() {
		Collections.sort(clients);
		return clients;
	}

	@Override
	public Client getClient(int id) {
		for(Client client : clients){
			if(client.getId() == id){
				return client;
			}
		}
		
		return null;
	}

	@Override
	public Product getProduct(int id) {
		for(Product product : products){
			if(product.getId() == id){
				return product;
			}
		}
		
		return null;
	}
}