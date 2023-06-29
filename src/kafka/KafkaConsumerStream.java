package kafka;


import java.io.IOException;
import java.util.Properties;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;

import user.UserDetails;

	
public class KafkaConsumerStream 
{
	
	public static void main (String args[]) throws IOException, InterruptedException
	{
		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-live-test");
		String bootstrapServers = "kafka:9092";
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, user.UserDetailsSerde.class.getName());
		//props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    //props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");

		String inputTopic = "sampletopic";
		StreamsBuilder builder=new StreamsBuilder();// when using the DSL
		KStream<String, UserDetails> kstream = builder.stream(inputTopic);
		
		KStream<String, UserDetails> kstream1 = kstream.filter((key, value)-> value.toString().contains("Bangalore"));
		
		kstream1.foreach((k,v)-> DisplayValues(v));
		
			Topology topology = builder.build();
	
		
		@SuppressWarnings("resource")
		KafkaStreams streams = new KafkaStreams(topology, props);

		streams.start();

		  /*
		KStream<String, byte[]> kstream = builder.stream(inputTopic);
		kstream.foreach((k,v)-> writeByte(v));
		
		Topology topology = builder.build();
		
		@SuppressWarnings("resource")
		KafkaStreams streams = new KafkaStreams(topology, props);

		streams.start();

	*/
	
	}

	/*
	    static void writeByte(byte[] bytes)
{

         
    try {
        OutputStream os = new FileOutputStream("/Users/hussamoa/Downloads/X.jpg");
        System.out.println("Successfully" + " byte inserted");
        os.close();
    }

    catch (Exception e) 
    {

        System.out.println("Exception: " + e);
    }
}
	 */

	static void DisplayValues(UserDetails user)
	{
	   user.printValues();
	   
	}

}
	