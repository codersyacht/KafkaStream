package user;

import org.apache.kafka.common.serialization.Serializer;


import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDetailsSerializer implements Serializer<UserDetails>
{

	@Override public byte[] serialize(String arg0, UserDetails arg1) {
		   byte[] retVal = null;
		   ObjectMapper objectMapper = new ObjectMapper();
		   try {
		     retVal = objectMapper.writeValueAsString(arg1).getBytes();
		   } catch (Exception e) {
		     e.printStackTrace();
		   }
		   return retVal;
		 }


}
