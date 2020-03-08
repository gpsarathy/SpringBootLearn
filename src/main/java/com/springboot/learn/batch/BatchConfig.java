package com.springboot.learn.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;



@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean(name = "importUserJob")
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		System.out.println("Params inside jobs");
		return jobBuilderFactory.get("job")
			.incrementer(new RunIdIncrementer())
			.listener(listener)
			.flow(step1())
			.end()
			.build();
	}

	
	
	@Bean
	public Step step1() {

		System.out.println("Params inside jobs");
		return stepBuilderFactory.get("step1")
			.<Person, Person> chunk(2)
			.reader(reader())
			.processor(new PersonItemProcessor())
			.writer(writer( dataSource))
			.build();
	}
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	ItemWriter<Person> writer(DataSource dataSource) {
		
		return new JdbcBatchItemWriterBuilder<Person>()
			    .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
			    .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
			    .dataSource(dataSource)
			    .build();
			}


	
	 ItemReader<? extends Person> reader() {
		
		String file="sample-data.csv";
		return new FlatFileItemReaderBuilder<Person>()
			    .name("personItemReader")
			    .resource(new ClassPathResource(file))
			    .delimited()
			    .names(new String[]{"firstName", "lastName"})
			    .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
			      setTargetType(Person.class);
			    }})
			    .build();
			}
	}