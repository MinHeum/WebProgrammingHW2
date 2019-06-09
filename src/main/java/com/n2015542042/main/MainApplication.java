package com.n2015542042.main;

import com.n2015542042.main.domain.Basic;
import com.n2015542042.main.domain.Profile;
import com.n2015542042.main.repository.BasicRepository;
import com.n2015542042.main.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(BasicRepository basicRepository, ProfileRepository profileRepository) throws Exception {
		return args -> {
			Basic basic =
				basicRepository.save(Basic.builder()
					.name("홍길동")
					.label("CEO")
					.email("hong@gmail.com")
					.phone("010-1234-5678")
					.build());
				basicRepository.save(Basic.builder()
					.name("장길산")
					.label("CFO")
					.email("jang@gmail.com")
					.phone("010-1000-2000")
					.build());
				basicRepository.save(Basic.builder()
					.name("춘향이")
					.label("CTO")
					.email("chun@gmail.com")
					.phone("010-9999-8888")
					.build());
				basicRepository.save(Basic.builder()
					.name("권율")
					.label("CIO")
					.email("kwon@gmail.com")
					.phone("010-3333-4444")
					.build());
				basicRepository.save(Basic.builder()
					.name("이황")
					.label("CSO")
					.email("lee@gmail.com")
					.phone("010-3221-3221")
					.build());

			Profile profile =
				profileRepository.save(Profile.builder()
					.network("트위터")
					.username("@king")
					.url("https://www.twitter.com/@king/")
					.createdat(LocalDateTime.now())
					.build());
				profileRepository.save(Profile.builder()
					.network("페이스북")
					.username("hollys")
					.url("https://www.facebook.com/hollys/")
					.createdat(LocalDateTime.now())
					.build());

				profileRepository.save(Profile.builder()
					.network("인스타그램")
					.username("24HoursCafe")
					.url("https://www.instagram.com/24HoursCafe/")
					.createdat(LocalDateTime.now())
					.build());

				profileRepository.save(Profile.builder()
					.network("텀블러")
					.username("smallTumblr")
					.url("https://tumblr.smallTumblr.com/")
					.createdat(LocalDateTime.now())
					.build());

				profileRepository.save(Profile.builder()
					.network("미니홈피")
					.username("newCyworld")
					.url("https://cy.cyworld.com/home/new/12345678")
					.createdat(LocalDateTime.now())
					.build());


		};
	}


}
