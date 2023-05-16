package cashmere.authorization;

import java.util.List;

import org.apache.commons.rdf.api.IRI;

import cartago.OperationInfo;

public class AuthorizationEngine {
    

    public AuthorizationEngine() {
    }

    public boolean resolveRequest(IRI agentIRI, OperationInfo operation) {
        
        // Get the effective WACResource
        WACResource effectiveWACResource = getEffectiveWACResource();

        // Retrieve the list of authorizations from the effective WACResource
        List<ACLAuthorization> authorizations = getAuthorizationList(effectiveWACResource);

        // Iterate through each authorization and check if the agent is authorized
        for (ACLAuthorization authorization : authorizations) {
            if (matchAuthorization(agentIRI, authorization)) {
                // Agent is authorized, resolve the operation successfully
                return true;
            }
        }

        // Agent is not authorized, resolve the operation as a failure
        return false;
    }

    private WACResource getEffectiveWACResource() {
        // TODO: Implement the logic to retrieve the effective WACResource
        // You can wrap the RDF serialization of the WACResource in a class and return an instance of that class.
        return null;
    }

    private List<ACLAuthorization> getAuthorizationList(WACResource wacResource) {
        // TODO: Implement the logic to retrieve the list of Authorizations from the WACResource
        // Return the list of ACLAuthorization objects
        return null;
    }

    private boolean matchAuthorization(IRI agentURI, ACLAuthorization aclAuthorization) {
        if (aclAuthorization instanceof AgentACLAuthorization) {
            return matchAgentAuthorization(agentURI, (AgentACLAuthorization) aclAuthorization);
        } else if (aclAuthorization instanceof AgentClassACLAuthorization) {
            return matchAgentClassAuthorization(agentURI, (AgentClassACLAuthorization) aclAuthorization);
        } else if (aclAuthorization instanceof AgentGroupACLAuthorization) {
            return matchAgentGroupAuthorization(agentURI, (AgentGroupACLAuthorization) aclAuthorization);
        }
        return false;
    }

    private boolean matchAgentAuthorization(IRI agentURI, AgentACLAuthorization agentAuthorization) {
        // TODO: Implement the logic to match agent authorization
        // Compare the agentURI with the authorization's agent URI and return true if they match
        return false;
    }

    private boolean matchAgentClassAuthorization(IRI agentURI, AgentClassACLAuthorization agentClassAuthorization) {
        // TODO: Implement the logic to match agent class authorization
        // Apply the appropriate SPARQL query and reasoning inference to verify agentURI is an instance of the class used for authorization
        return false;
    }

    private boolean matchAgentGroupAuthorization(IRI agentURI, AgentGroupACLAuthorization agentGroupAuthorization) {
        // TODO: Implement the logic to match agent group authorization
        // Run a federated SPARQL query for agentURI group membership against the relevant ContextDomainArtifacts
        return false;
    }
}

