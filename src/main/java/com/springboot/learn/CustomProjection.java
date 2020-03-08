package com.springboot.learn;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.stereotype.Repository;

@Repository
@Projection(name = "basic",types = { Card.class })

public interface CustomProjection {
	String getName();
	int getContactNo();
}
