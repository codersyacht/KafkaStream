package user;


import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDetailsDeserializer implements Deserializer<UserDetails>
{

	@Override
	public UserDetails deserialize(String arg0, byte[] arg1) 
	{
		
		UserDetails userdetails = null;
		try
		{
		   ObjectMapper objectmapper = new ObjectMapper();
	       userdetails = objectmapper.readValue(arg1, UserDetails.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return userdetails;
	}

}
