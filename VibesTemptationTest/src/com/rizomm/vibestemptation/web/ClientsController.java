package com.rizomm.vibestemptation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.rizomm.vibestemptation.bo.Adress;
import com.rizomm.vibestemptation.bo.ClientCategory;
import com.rizomm.vibestemptation.bo.Client;
import com.rizomm.vibestemptation.service.BacklogService;

@Controller
public class ClientsController {

	@Autowired
	private BacklogService backlogService;

	@RequestMapping(value = "/clientsList.do", method = RequestMethod.GET)
	public ModelAndView clientsList() {
		ModelAndView mNv = new ModelAndView("clients/clientsList");
		
		mNv.addObject("clientsList", this.backlogService.listClients());

		return mNv;
	}

	@RequestMapping(value = "/addClient.do", method = RequestMethod.GET)
	public ModelAndView addClient() {
		ModelAndView mNv = new ModelAndView("clients/addClient");
		return mNv;
	}

	@RequestMapping(value = "/createClient.do", method = RequestMethod.POST)
	public ModelAndView createClient(
			@RequestParam("firstname") String _firstname,
			@RequestParam("lastname") String _lastname,
			@RequestParam("nickname") String _nickname,
			@RequestParam("streetNumber") String _streetNumber,	
			@RequestParam("streetName") String _streetName,		
			@RequestParam("postalcode") int _postalcode,			
			@RequestParam("town") String _town,				
			@RequestParam("country") String _country,			
			@RequestParam("age") int _age,	
			@RequestParam("category") ClientCategory _category) {

		// creation of the bean
		Adress adress = new Adress(_firstname, _lastname, _streetNumber, _streetName, _postalcode, _town, _country);
		Client client = new Client(_firstname, _lastname, _nickname, adress, _age, _category);

		// transmission to the backlog
		this.backlogService.createClient(client);
		return new ModelAndView(new RedirectView("/clientsList.do", true));
	}
	
	@RequestMapping(value = "/modifyClient/{_id}.do", method = RequestMethod.GET)
	public ModelAndView modifyClient(@PathVariable int _id) {
		return new ModelAndView("clients/modifyClient", "client", this.backlogService.getClient(_id));
	}
	
	@RequestMapping(value = "/modifyClient/{_id}.do", method = RequestMethod.POST)
	public ModelAndView updateClient(@RequestParam("firstname") String _firstname,
			@RequestParam("lastname") String _lastname,
			@RequestParam("nickname") String _nickname,
			@RequestParam("streetNumber") String _streetNumber,	
			@RequestParam("streetName") String _streetName,		
			@RequestParam("postalcode") int _postalcode,			
			@RequestParam("town") String _town,				
			@RequestParam("country") String _country,			
			@RequestParam("age") int _age,	
			@RequestParam("category") ClientCategory _category,
			@PathVariable int _id) {
		
		// creation of the bean
		Client client = new Client(_firstname, _lastname, _category, _id);
		
		// transmission to the backlog
		this.backlogService.updateClient(client);
		
		return new ModelAndView(new RedirectView("/clientsList.do", true));
	}
	
	@RequestMapping(value = "/deleteClient/{_id}.do", method = RequestMethod.GET)
	public ModelAndView deleteClient(@PathVariable int _id) {
		return new ModelAndView("clients/deleteClient", "client", this.backlogService.getClient(_id));
	}
	
	@RequestMapping(value = "/deleteClient/{_id}.do", method = RequestMethod.POST)
	public ModelAndView destroyClient(@PathVariable int _id) {
		
		// transmission to the backlog
		this.backlogService.deleteClient(this.backlogService.getClient(_id));
		
		return new ModelAndView(new RedirectView("/clientsList.do", true));
	}
}
