package user;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;


public class UserDetailsSerde implements Serde<UserDetails>
{
	
	private UserDetailsSerializer serializer = new UserDetailsSerializer();
	private UserDetailsDeserializer deserializer = new UserDetailsDeserializer();

	@Override
	public Deserializer<UserDetails> deserializer() {
		// TODO Auto-generated method stub
		return  deserializer;
	}

	@Override
	public Serializer<UserDetails> serializer() {
		// TODO Auto-generated method stub
		return serializer;
	}

}
