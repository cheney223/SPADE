package spade.query.postgresql;

import spade.core.Graph;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static spade.core.AbstractStorage.CHILD_VERTEX_KEY;
import static spade.core.AbstractStorage.PARENT_VERTEX_KEY;
import static spade.core.AbstractStorage.PRIMARY_KEY;

/**
 * @author raza
 */
public class GetChildren extends PostgreSQL<Graph>
{
    public GetChildren()
    {
        register();
    }

    @Override
    public Graph execute(String argument_string)
    {
        Pattern argument_pattern = Pattern.compile(",");
        String[] arguments = argument_pattern.split(argument_string);
        String constraints = arguments[0].trim();
        Map<String, List<String>> parameters = parseConstraints(constraints);
        Integer limit = null;
        if(arguments.length > 1)
            limit = Integer.parseInt(arguments[1].trim());
        return execute(parameters, limit);
    }

    @Override
    public Graph execute(Map<String, List<String>> parameters, Integer limit)
    {
        // implicit assumption that parameters contain annotation PARENT_VERTEX_KEY
        StringBuilder query = new StringBuilder(100);

        query.append("SELECT * FROM ");
        query.append(VERTEX_TABLE);
        query.append(" WHERE ");
        query.append("\"");
        query.append(PRIMARY_KEY);
        query.append("\"");
        query.append(" IN(");
        query.append("SELECT ");
        query.append("\"");
        query.append(CHILD_VERTEX_KEY);
        query.append("\"");
        query.append(" FROM ");
        query.append(EDGE_TABLE);
        query.append(" WHERE ");
        query.append("\"");
        query.append(PARENT_VERTEX_KEY);
        query.append("\"");
        query.append(" = ");
        query.append("'");
        List<String> entry = parameters.get(PARENT_VERTEX_KEY);
        if(entry != null)
            query.append(entry.get(COL_VALUE));
        else
            return null;
        query.append("'");
        query.append(")");
        if(limit != null)
            query.append(" LIMIT ").append(limit);
        query.append(";");

        Logger.getLogger(GetChildren.class.getName()).log(Level.INFO, "Following query: " + query.toString());
        Graph children = new Graph();
        children.vertexSet().addAll(prepareVertexSetFromSQLResult(query.toString()));


        return children;
    }

}
