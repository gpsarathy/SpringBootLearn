package org.EurekaApplicationServer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netflix.appinfo.InstanceInfo;

@EnableDiscoveryClient
@SpringBootApplication
public class App 
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
}
