package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Avenger;
import com.revature.repositories.AvengerDAO;

@Controller //This will turn our controller into a bean, which will give us MVC functionality
@ResponseBody//This will be added automatically to every method in the class and will convert the responses to JSON for us
@RequestMapping(value="/avenger")// This will grab all requests that end in "/spring/avenger"
@CrossOrigin
public class AvengerController {

	//I am skipping the service layer for this demo, because it would just be a pass through layer anyway
	private AvengerDAO ad;
	
	//This is our constructor that will allow us to use constructor injection and our DAO methods
	@Autowired //This annotation we are now using constructor injection to inject AvengerDAO as a dependency 
	public AvengerController(AvengerDAO dao) {
		this.ad = dao;
	}
	
	//Lets declare some methods to handle HTTP requests (This is the big replacement for Javalin)
	
	//Lets get all Avenger members
	@RequestMapping(method=RequestMethod.GET) //This will ensure that any Get request to /avenger goes here
	public List<Avenger> assemble(){
		return Arrays.asList(ad.getAll()); //.getAll() returns an array, so we need to convert it to a list and we can do that using Arrays.asList()
	}
	
	//Lets do get by id
	@GetMapping("/{id}") //GetMapping will specify that GET requests that are sent to /avenger are sent here as well
	//But we also added in a path parameter. So any GET request with /avenger/(some number) will actually be sent to this method
	//@PathVariable annotation will allow you to grab that path variable sent in the URL, for us it is id, but it can be whatever you set it to
	//Spring has an object called ResponseEnitiy that lets us set things like status code, and the response body
	public ResponseEntity<Avenger> getById(@PathVariable("id") int id){ 
		Avenger a = ad.getById(id); //This will get an Avenger with the id that comes from the Path Parameter that got sent with the request
		if(a == null) {
			//We could type in the code 204 which means "no content"
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(a);
		}
		else {//if the Avenger is NOT null then this will actually go off
			//You can also just do return ResponseEntity.status(200).body(a);
			return ResponseEntity.ok(a);// This is shorthand for return ResponseEntity.status(HttpStatus.OK).body(a);
		}
	}
	
	//Lets do update Avenger
	@PutMapping //Any HTTP PUT request sent to /avenger will go here
	//@ReqeustBody will convert our JSON from the body of the request into an object we specify
	// It is like @ResponseBody, but for requests
	public ResponseEntity<Avenger> update(@RequestBody Avenger a){
		if(a.getId() > ad.team.length || a.getId() < 1 ) {
			return ResponseEntity.status(204).body(a);
		}
		else {
			a = ad.update(a);
			return ResponseEntity.status(202).body(a);
		}
	}
	
	
}
