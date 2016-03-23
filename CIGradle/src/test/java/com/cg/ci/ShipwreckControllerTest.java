package com.cg.ci;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.cg.ci.controller.ShipwreckController;
import com.cg.ci.model.Shipwreck;
import com.cg.ci.repository.ShipwreckRepository;

public class ShipwreckControllerTest {

	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testShipwreckGet(){
		
		
		Shipwreck  sw =new Shipwreck();
		sw.setId(1L);
		when(shipwreckRepository.findOne(1L)).thenReturn(sw);
		Shipwreck wreck = sc.get(1l);
		assertEquals(1l, wreck.getId().longValue());
	}
	
	@Test
	public void testShipwreckCreate(){
		
		Shipwreck  sw =new Shipwreck();
		sw.setId(1L);
		when(shipwreckRepository.saveAndFlush(sw)).thenReturn(sw);
		Shipwreck wreck = sc.create(sw);
		assertEquals(1l, wreck.getId().longValue());
	}
	
	@Test
	
	public void testShipwreckUpdate(){
		Shipwreck  sw =new Shipwreck();
		sw.setId(1L);
		sw.setName("Titanic");
		when(shipwreckRepository.findOne(1l)).thenReturn(sw);
		
		Shipwreck newWreck =new Shipwreck();
		newWreck.setId(1l);
		newWreck.setName("Platonic");
		when(shipwreckRepository.saveAndFlush(sw)).thenReturn(newWreck);
		
		Shipwreck wreck = sc.update(1l, newWreck);
		
		assertEquals("Platonic", wreck.getName());
		
		
	}

	/*@Test
	public void testShipwreckDelete(){
		Shipwreck  sw =new Shipwreck();
		sw.setId(1L);
		sw.setName("Titanic");
		when(shipwreckRepository.findOne(1l)).thenReturn(sw);
		when(shipwreckRepository.delete(sw));
		
		Shipwreck wreck = sc.delete(1l);
		
		assertEquals(1l, wreck.getId().longValue());
	}
	*/
	@Test
	public void testShipwreckList(){
		
		List<Shipwreck> ls = new ArrayList<Shipwreck>();
		Shipwreck sw1 = new Shipwreck();
		Shipwreck sw2 = new Shipwreck();
		Shipwreck sw3 = new Shipwreck();
		Shipwreck sw4 = new Shipwreck();
		sw1.setId(1l);
		sw2.setId(2l);
		sw3.setId(3l);
		sw4.setId(4l);
		ls.add(sw1);
		ls.add(sw2);
		ls.add(sw3);
		ls.add(sw4);
		
		when(shipwreckRepository.findAll()).thenReturn(ls);
		
		List<Shipwreck> shipwrecks = sc.list();
		assertEquals(4,shipwrecks.size());
	}
	
	
}
