
//COMENTADO PARA USAR O H2, PARA USAR O MYSQL DESCOMENTAR

//package br.com.tt.petshop.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource mysqlDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/petshop?serverTimezone=America/Sao_Paulo");
//        dataSource.setUsername("petshop");
//        dataSource.setPassword("banana123456");
//        return dataSource;
//    }
//}