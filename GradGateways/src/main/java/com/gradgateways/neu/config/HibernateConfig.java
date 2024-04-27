package com.gradgateways.neu.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gradgateways.neu.model.Employer;
import com.gradgateways.neu.model.Feedback;
import com.gradgateways.neu.model.JobPosting;
import com.gradgateways.neu.model.Student;
import java.util.HashMap;
import java.util.Map;

/**
*
* @author mrunalipawar
* class : HibernateConfig
*/
@Configuration
public class HibernateConfig {

	/*
    @Bean
    SessionFactory sessionFactory() {
    	try {
            Map<String, Object> settings = new HashMap<>();
            settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            settings.put("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/gradgateways?createDatabaseIfNotExist=true");
            settings.put("hibernate.connection.username", "root");
            settings.put("hibernate.connection.password", "root@secret");
            settings.put("hibernate.hbm2ddl.auto", "create");
            settings.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
            settings.put("hibernate.show_sql", "true");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(Student.class);
            metadataSources.addAnnotatedClass(JobPosting.class);
            metadataSources.addAnnotatedClass(Employer.class);
            metadataSources.addAnnotatedClass(Feedback.class);

            Metadata metadata = metadataSources.buildMetadata();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            System.err.println("SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }*/

}

