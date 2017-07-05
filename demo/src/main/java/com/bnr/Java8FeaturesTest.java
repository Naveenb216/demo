package com.bnr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bnr.model.Address;
import com.bnr.model.Employee;
import com.bnr.model.Phone;


public class Java8FeaturesTest {

	public static void main(String args[]) {

		forEachEx();
	}

	public static void forEachEx() {
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k, v) -> {
			if (k.equals("C")) {
			//	System.out.println(">>matched.." + items.get("C").intValue());
				items.get("C").intValue();
				items.put("C", 85);
			}

			//System.out.println("K:" + k + " ,V:" + v);
		});

		System.out.println("******************");

		List<String> o = new ArrayList<>();
		o.add("A");
		o.add("B");
		o.add("C");
		o.add("D");
		o.add("E");

		//o.forEach(System.out::print);

		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^");
		//o.stream().filter(s -> s.contains("E")).forEach(System.out::println);

		Employee e = new Employee();
		e.setEmpId(1);
		e.setEmpname("Naveen");
		e.setEmpSal(65000);

		Address adr = new Address();
		adr.setPermnentAddress("MPT");
		adr.setTemporaryAddress("HYD");

		Address adr2 = new Address();
		adr2.setPermnentAddress("KMR");
		adr2.setTemporaryAddress("HYD");

		Phone ph = new Phone();
		ph.setPhoneNo(8652283229l);
		ph.setActive(true);
		List<Phone> phone = new ArrayList<>();
		Phone ph2 = new Phone();
		ph2.setPhoneNo(865228322l);
		ph2.setActive(false);
		List<Phone> phone2 = new ArrayList<>();
		
		
		phone.add(ph);
		phone2.add(ph2);
		adr.setPhone(phone);
		adr2.setPhone(phone2);

		List<Address> address = new ArrayList<>();
		address.add(adr);
		address.add(adr2);
		e.setAddress(address);

		//System.out.println(e);

		e.getAddress().stream().forEach((addre) -> {
			
			String t = "I";
			boolean st = false;
			addre.getPhone().stream().filter(phoo -> 
			      (phoo.getPhoneNo() == 8652283229l)&& 
			       phoo.isActive())
			      .forEach((pho) -> {
			    	  //t="A";
			    	  pho.setActive(st);
				System.out.println("Phone: " + pho);
				
				
			});
			addre.setStatus(t);
			System.out.println("address: " + addre);
		});

	}

}
