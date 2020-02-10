package com.springboot.learn.SBLearn;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "card",collectionResourceRel = "card")
interface CustomBasicCardRepository extends JpaRepository<Card, Long>{

	@Override
	List<Card> findAll();

	@Override
	Optional<Card> findById(Long id);
	
	
}
