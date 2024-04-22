//package com.example.demo.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.example.demo.service.NguoiDungService;
//
//
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//	@Autowired
//	private NguoiDungService nguoiDungService;
//	
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests( authz -> {        		
//        				authz.requestMatchers(HttpMethod.GET, "/trangchund").hasRole("ND");
//        				authz.requestMatchers(HttpMethod.GET,"/trangchu", "/thongke", "/xemchitiet").hasRole("QTV");
//        				authz.anyRequest().authenticated();
//        				}).
//        formLogin((formLogin) -> formLogin
//        		.loginPage("/")
//                .loginProcessingUrl("/dangnhap")
//                .usernameParameter("tenDangNhap") 
//                .passwordParameter("matKhau")         
//                .failureUrl("/?error")
//                .defaultSuccessUrl("/chontrang")
//                .permitAll()
//        );
//	  return http.build();
//	}
//	
//	@Bean 
//	public UserDetailsService user() {
//		 return new CustomUserDetailsService(nguoiDungService);
//	}
//	
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//    }
//   @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//   @Bean
//   public DaoAuthenticationProvider authenticationProvider() {
//       DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//       authProvider.setUserDetailsService(user());
//       authProvider.setPasswordEncoder(passwordEncoder()); 
//       return authProvider;
//   }
//
//
//}
//<dependency>
//            <groupId>org.springframework.boot</groupId>
//            <artifactId>spring-boot-starter-security</artifactId>
//        </dependency>
