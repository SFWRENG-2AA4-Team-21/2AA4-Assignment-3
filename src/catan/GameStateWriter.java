package catan;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;

public class GameStateWriter implements Observer {
    private static final String DEFAULT_OUTPUT = "visualize/state.json";
    private static final Logger LOGGER = Logger.getLogger(GameStateWriter.class.getName());
    @Override
    public void update(Board board) {
        write(board);
    }

    public static void write(Board board) {
        write(board, DEFAULT_OUTPUT);
    }

    public static void write(Board board, String outputPath) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        // roads
        sb.append(" \"roads\": [\n");
        appendingRoads(sb, board);
        sb.append("\n  ],\n");

        // buildings
        sb.append("  \"buildings\": [\n");
        appendingBuildings(sb, board);
        sb.append("\n  ]\n");

        sb.append("}\n");

        try (FileWriter fileWrite = new FileWriter(outputPath)) {
            fileWrite.write(sb.toString());
            LOGGER.info(String.format("[GameStateWriter] state.json written to %s", outputPath));
        } catch (IOException e) {
            LOGGER.severe(String.format("[GameStateWriter] failed to write state.json: %s", e.getMessage()));
        }
    
    }
    public static void appendingRoads(StringBuilder sb, Board board){
        Collection<Edge> edges = board.getAllEdges();
        boolean firstRoad = true;
        for (Edge edge : edges) {
            Road road = edge.getRoad();

            if (!edge.hasRoad() || road.getOwner() == null)
                continue;
            

            if (!firstRoad) {
                sb.append(",\n");
            }

            firstRoad = false;

            sb.append("    { ");
            sb.append("\"a\": ").append(edge.getNodeA()).append(", ");
            sb.append("\"b\": ").append(edge.getNodeB()).append(", ");
            sb.append("\"owner\": \"").append(road.getOwner().getColorString()).append("\"");
            sb.append(" }");
    }
    }
    public static void appendingBuildings(StringBuilder sb, Board board){
        Collection<Node> nodes = board.getAllNodes();
        boolean firstBuilding = true;
        for (Node node : nodes) {
            Building building = node.getBuilding();

            if (!node.hasBuilding() || building.getOwner() == null) {
                continue;
            }

            if (!firstBuilding) {
                sb.append(",\n");
            }

            firstBuilding = false;
            String type = (building instanceof City) ? "CITY" : "SETTLEMENT";

            sb.append("    { ");
            sb.append("\"node\": ").append(node.getId()).append(", ");
            sb.append("\"owner\": \"").append(building.getOwner().getColorString()).append("\", ");
            sb.append("\"type\": \"").append(type).append("\"");
            sb.append(" }");
    }
    }

}
