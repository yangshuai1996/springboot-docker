package com.estone.it.controller;

import com.estone.it.entity.Bar1;
import com.estone.it.entity.Foo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangshuai
 * @since 2.2.1
 *
 */
@RestController
public class KafkaController {

	@Autowired
	private KafkaTemplate<Object, Object> kafkaTemplate;

	@GetMapping("/kafka/test/{msg}")
	public void sendMessage(@PathVariable("msg") String msg) {
		kafkaTemplate.send("test", msg);
	}
}