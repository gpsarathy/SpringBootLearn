package com.springboot.learn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceInstanceInfo {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@RequestMapping("/service-instances/{service}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
	        @PathVariable String service) {
	     /*List<ServiceInstance> instanceInfo= this.discoveryClient.get(service);
	    String appNameString=null;
	    System.out.println("service looking for " + service +instanceInfo.get(0).toString());
	     for (ServiceInstance serviceInstance : instanceInfo) {
	    	 appNameString=serviceInstance.getHost()+serviceInstance.getPort();
	    	 System.out.println("Application name" + appNameString);
		}
		
	     return appNameString;
	     */
		System.out.println("service name" + service);
		return this.discoveryClient.getInstances(service);
	     
	}
	
	@RequestMapping("/isUp")
	public String up() {
	
	     return "Alive";
	     
	}
}

