package ar.com.bna.ejercicio01.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class StringPublisher {

	private static final String INPUT_TOPIC_NAME = "cliente";
	private final KafkaTemplate<String, String> kafkaTemplate;
	private final String KEY = "cliente";

	public void produce(String texto) {
		log.info("Produced: " + texto);
		kafkaTemplate.send(INPUT_TOPIC_NAME, KEY, texto);
	}
}
