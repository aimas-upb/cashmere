package emas;

import cartago.AgentId;
import cartago.Artifact;
import cartago.CartagoEnvironment;
import cartago.GUARD;
import cartago.OPERATION;
import cartago.Workspace;
import cartago.WorkspaceArtifact;
import cartago.WorkspaceDescriptor;
import cartago.WorkspaceId;
import cartago.WorkspaceNotFoundException;
import cartago.infrastructure.web.CartagoEnvironmentService;


public class HueArtifact extends Artifact {
    
    private final int UNDEFINED = -1;
    
    String lightbulbUri;
    
    
	void init(String uri) {
	    this.lightbulbUri = uri;
	}
	
	// private int setState(String state) {
	//     HttpPut request = new HttpPut(lightbulbUri);
        
  //       try {
            
  //           request.setEntity(new StringEntity(state));
            
  //           HttpClient client = HttpClientBuilder.create().build();
  //           HttpResponse response = client.execute(request);
            
  //           return response.getStatusLine().getStatusCode();
            
  //       } catch (Exception e) {
  //           e.printStackTrace();
  //       }
        
  //       return UNDEFINED;
	// }
	
	//@OPERATION(guard = "sharesContext")
	void turnLightOn() {
	    AgentId invokerAgentId = getCurrentOpAgentId();
			
			try {
				String wspName = this.getId().getWorkspaceId().getFullName();	
				WorkspaceDescriptor wsp = CartagoEnvironment.getInstance().resolveWSP(wspName);
				log("Agent " + invokerAgentId + " is turning light on in worksspace + " + wspName + "!");
			} catch (WorkspaceNotFoundException e) {
				// TODO Auto-generated catch block
				log(e.getMessage());
			}
//	    setState("{ \"on\" : true }");
	}
	
	@OPERATION
    void turnLightOn(double x, double y) {
	      log("Turning light on with colors: " + x + " " + y);
        // setState("{ \"on\" : true, \"xy\" : [" + x + ", " + y + "] }");
    }
	
	@OPERATION
	void turnLightOff() {
	    log("Turning light off!");
//	    setState("{ \"on\" : false }");
	}

	@GUARD
	boolean sharesContext() {
	  // AgentId invokerAgentId = getCurrentOpAgentId();
		//log("Agent " + invokerAgentId + " is trying to turn the light on!");
		log("Agent is trying to turn the light on!");
		return true;
	}
}

