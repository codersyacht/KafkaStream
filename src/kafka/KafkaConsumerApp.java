package kafka;

import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.streams.StreamsConfig;
import user.UserDetails;


public class KafkaConsumerApp
{
	
	public static void main (String args[]) throws IOException, InterruptedException
	{
		Properties props = new Properties();
		String bootstrapServers = "kafka:9092";
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-live-test");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "console-consumer-myapp");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("value.deserializer", "user.UserDetailsDeserializer");


		String inputTopic = "sampletopic";
		try (KafkaConsumer<String, UserDetails> consumer = new KafkaConsumer<>(props)) {
			   consumer.subscribe(Collections.singletonList(inputTopic));
			   while (true) {
			       ConsumerRecords<String, UserDetails> messages = consumer.poll(100);
			       for (ConsumerRecord<String, UserDetails> message : messages) {

			         System.out.println("Message received " + message.value().toString());
			         DisplayValues(message.value());
			       }
			   }
			} catch (Exception e) {
			   e.printStackTrace();
			}

	  
	}

static void DisplayValues(UserDetails user)
{
   user.printValues();
   
}
	
}
