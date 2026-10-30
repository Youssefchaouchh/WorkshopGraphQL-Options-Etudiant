package graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.EtudiantBusiness;
import repository.OptionBusiness;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndPoint extends SimpleGraphQLServlet {
    public GraphQLEndPoint() { super(buildSchema()); }

    private static GraphQLSchema buildSchema() {
        OptionBusiness ob = new OptionBusiness();
        EtudiantBusiness eb = new EtudiantBusiness(ob);
        return SchemaParser.newParser()
                .file("schema.graphql")
                .resolvers(new Query(ob, eb), new Mutations(ob, eb))
                .build()
                .makeExecutableSchema();
    }
}