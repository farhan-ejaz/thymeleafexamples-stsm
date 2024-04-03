/*
 * =============================================================================
 *
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package thymeleafexamples.stsm.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class SpringBusinessConfig {
	@Value("${spring.data.mongodb.uri}")
	String connectionString;
    public SpringBusinessConfig() {
        super();
    }

    // Nothing else to be configured here: component scanning will do everything needed
	public @Bean MongoDatabaseFactory mongoDatabaseFactory() {
		System.out.println("CONNSTR--->" + connectionString);
		return new SimpleMongoClientDatabaseFactory(connectionString);
	}

	public @Bean MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoDatabaseFactory());
	}
}
