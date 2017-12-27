package com.rojagadeesh.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rojagadeesh.model.Shipwreck;
import com.rojagadeesh.repository.ShipwreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {
	
	@Autowired
	private ShipwreckRepository swr;
	
	@RequestMapping(value="shipwrecks",method=RequestMethod.GET)
	public List<Shipwreck> list()
	{
		//return ShipwreckStub.list();
		return swr.findAll();
	}
	
	@RequestMapping(value="shipwrecks",method=RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck shipwreck)
	{
		//return ShipwreckStub.create(shipwreck);
		return swr.saveAndFlush(shipwreck);
	}
	
	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.GET)
	public Shipwreck get(@PathVariable Long id)
	{
		//return ShipwreckStub.get(id);
		return swr.findOne(id);
	}
	
	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.PUT)
	public Shipwreck get(@PathVariable Long id,@RequestBody Shipwreck shipwreck)
	{
		//return ShipwreckStub.update(id, shipwreck);
		Shipwreck existingSW = swr.findOne(id);
		BeanUtils.copyProperties(shipwreck, existingSW);
		return swr.saveAndFlush(existingSW);
	}
	
	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable Long id)
	{
		//return ShipwreckStub.delete(id);
		Shipwreck existingSW = swr.findOne(id);
		swr.delete(existingSW);
		return existingSW;
	}

}
