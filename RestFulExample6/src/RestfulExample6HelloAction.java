
import java.io.IOException;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/")
public class RestfulExample6HelloAction {
		
			
		@GET
		@Produces({MediaType.APPLICATION_JSON})
		@Path("/createsample")
		public Response EchoMessagePlain(String message){
			
			System.out.println(message);
			System.out.println("Get, createsample, json Method Called.");
			
			//TODO Add the new random message to list
			
			ServerResponsejson MyresponseObj = new ServerResponsejson();
			
			MyresponseObj.code = "success";
			MyresponseObj.message ="Echo plan message - Get message return " + message;
			
			String jsonstr = "";
			try {
				jsonstr = new ObjectMapper().writeValueAsString (MyresponseObj);
			} catch (Exception e) {
				return Response.status(500).build();
			}
			return Response.ok(jsonstr,"application/json").build();
		}
		
		@POST
		@Consumes({MediaType.APPLICATION_JSON})
		@Produces({MediaType.APPLICATION_JSON})
		@Path("/create")
		public Response EchoMessagejson (String message){
			
			SimpleNameClass nameObj;   
			
			System.out.println("Post, create, json Method Called.");
			System.out.println(message);  // Dump the raw message so we can see it on the console 

			//ServerResponse response = new ServerResponse();
			ServerResponsejson MyresponseObj = new ServerResponsejson();
			
			try {
				nameObj = new ObjectMapper().readValue(message, SimpleNameClass.class);
				System.out.println(nameObj.FirstName + " " + nameObj.LastName);

				MyresponseObj.code = "success";
				MyresponseObj.message = nameObj.FirstName + " " + nameObj.LastName;

			} catch (JsonParseException e1) {
				e1.printStackTrace();
				MyresponseObj.code = "error";
				MyresponseObj.errmessage = "json Parse exception";
			} catch (JsonMappingException e1) {
				e1.printStackTrace();
				MyresponseObj.code = "error";
				MyresponseObj.errmessage = "json mapping object exception";
			} catch (IOException e1) {
				e1.printStackTrace();
				MyresponseObj.code = "error";
				MyresponseObj.errmessage = "json io exception";
			}
		
		
	        //  build the return object as json	
			String jsonstr = "";
			try {
				jsonstr = new ObjectMapper().writeValueAsString(MyresponseObj);
			} catch (Exception e) {
				return Response.status(500).build();
			}
			return Response.ok(jsonstr,"application/json").build();
		}
		

}
