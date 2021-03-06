package com.si;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringIdolConfig {
	// Bean declaration methods go here

	@Bean
	public Performer duke123() {
		return new Juggler();
	}

	@Bean
	public Performer kenny123() {
		Instrumentalist kenny = new Instrumentalist();
		kenny.setInstrument(guitar123());
		kenny.setSong("Jingle Bells");
		return kenny;
	}
	
	@Bean
	public Magician merlin() {
		Magician merlin = new Magician();
		return merlin;
	}
	
	@Bean
	public Volunteer arthur() {
		Volunteer arthur = new Volunteer();
		return arthur;
	}
	
	@Bean
	public Guitar guitar123() {
		return new Guitar();
	}
}