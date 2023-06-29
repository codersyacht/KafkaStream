package kafka;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import user.UserDetails;

public class KafkaUserProducer {
   
   public static void main(String[] args) throws IOException 
   {
      
	   UserDetails user = new UserDetails();
     
      Properties props = new Properties();
      props.put("bootstrap.servers", "kafka:9092");
      //props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      //props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
      props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      props.put("value.serializer", "user.UserDetailsSerializer");
      
      try (Producer<String, UserDetails> producer = new KafkaProducer<>(props)) {
    	  producer.send(new ProducerRecord<String, UserDetails>("sampletopic", "ket1",user));
    	  System.out.println("Message " + user.toString() + " sent !!");
    	} catch (Exception e) {
    	  e.printStackTrace();
    	}

     //Producer<String, byte[]> producer = new KafkaProducer <String, byte[]>(props);
     //File file = new File("/Users/hussamoa/Downloads/Slide1.JPG");      
     //final ProducerRecord<String, byte[]> producerOrderRequest = new ProducerRecord<>("sampletopic", "filedata", filtobyte(file)) ;
     //producer.send(producerOrderRequest);      
     //producer.flush();
     //producer.close();
      
          
   }
}
  
