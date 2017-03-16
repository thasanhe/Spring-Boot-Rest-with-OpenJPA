package com.rpicloud;

import com.github.javafaker.Faker;
import com.rpicloud.models.Pie;
import com.rpicloud.repositories.PieRepository;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.OpenJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootRestExampleApplication extends JpaBaseConfiguration{
	private final Faker faker = new Faker();

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestExampleApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner initializeDb(PieRepository repository) {
		return (args) -> {
			repository.deleteAll();

			for (int i =0; i<20; ++i) {
				repository.save(new Pie(faker.lorem().word(), faker.lorem().sentence(), i ));
			}
		};
	}*/

	protected SpringBootRestExampleApplication(DataSource dataSource, JpaProperties properties, ObjectProvider<JtaTransactionManager> jtaTransactionManager, ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
		super(dataSource, properties, jtaTransactionManager, transactionManagerCustomizers);
	}

	@Override
	protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
		OpenJpaVendorAdapter jpaVendorAdapter = new OpenJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		return jpaVendorAdapter;
	}

	@Override
	protected Map<String, Object> getVendorProperties() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("openjpa.Log", "DefaultLevel=TRACE, Tool=INFO, SQL=TRACE, Runtime=TRACE");
		map.put("openjpa.jdbc.MappingDefaults", "IndexLogicalForeignKeys=false,IndexDiscriminator=false");
		map.put("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
		map.put("openjpa.RuntimeUnenhancedClasses", "supported");
		map.put("openjpa.DynamicEnhancementAgent", "false");
		map.put("openjpa.weaving", "false");
		return map;
	}
}
