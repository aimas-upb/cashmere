package cashmere.authorization;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.UnsupportedRDFormatException;

public class ContextDomainObserver {
    private IRI contextDomainGroupIRI;
    private IRI contextOntologyIRI;
    private IRI contextDimensionIRI;
    private IRI contextDomainIRI;
    private String contextDomainDescription;

    public ContextDomainObserver(IRI contextDomainGroupIRI, IRI contextOntologyIRI, IRI contextDimensionIRI,
                                 IRI contextDomainIRI, String contextDomainDescription) {
        this.contextDomainGroupIRI = contextDomainGroupIRI;
        this.contextOntologyIRI = contextOntologyIRI;
        this.contextDimensionIRI = contextDimensionIRI;
        this.contextDomainIRI = contextDomainIRI;
        this.contextDomainDescription = contextDomainDescription;
    }

    public IRI getContextDomainGroupIRI() {
        return contextDomainGroupIRI;
    }

    public void setContextDomainGroupIRI(IRI contextDomainGroupIRI) {
        this.contextDomainGroupIRI = contextDomainGroupIRI;
    }

    public IRI getContextOntologyIRI() {
        return contextOntologyIRI;
    }

    public void setContextOntologyIRI(IRI contextOntologyIRI) {
        this.contextOntologyIRI = contextOntologyIRI;
    }

    public IRI getContextDimensionIRI() {
        return contextDimensionIRI;
    }

    public void setContextDimensionIRI(IRI contextDimensionIRI) {
        this.contextDimensionIRI = contextDimensionIRI;
    }

    public IRI getContextDomainIRI() {
        return contextDomainIRI;
    }

    public void setContextDomainIRI(IRI contextDomainIRI) {
        this.contextDomainIRI = contextDomainIRI;
    }

    public String getContextDomainDescription() {
        return contextDomainDescription;
    }

    public void setContextDomainDescription(String contextDomainDescription) {
        this.contextDomainDescription = contextDomainDescription;
    }

    private Model retrieveOntologyGraph() throws RDFParseException, UnsupportedRDFormatException, IOException {
        // open an InputStream to the ontology IRI
        // parse the ontology IRI into an RDF4J Model
        // create an URL object from the ontology IRI
        URL ontologyURL = new URL(contextOntologyIRI.stringValue());
        InputStream ontologyInputStream = ontologyURL.openStream();

        // read the ontologyInputStream into an RDF4J Model using the Turtle format
        Model ontologyModel = Rio.parse(ontologyInputStream, contextOntologyIRI.stringValue(), RDFFormat.TURTLE);

        // dereference the ontology IRI to retrieve the ontology graph and return it
        return ontologyModel;
    }
}

