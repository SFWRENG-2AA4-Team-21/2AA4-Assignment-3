package catan;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;


public class GameStateWriter{
   private static final String default_output = "visualize/state.json";

   public static void write(Board board){
       write(board, default_output);
   }

   public static void write(Board board, String outputPath){
       StringBuilder sb = new StringBuilder();
       sb.append("{\n");


   // roads
   sb.append(" \"roads\": [\n");
   Collection<Edge> edges = board.getAllEdges();
   boolean firstRoad = true;
   for(Edge edge : edges){
       if(!edge.hasRoad()) continue;
       Road road = edge.getRoad();
        //     REMOVE WHEN ROAD.GETOWNER IMPLEMENTED
       if(road.getOwner() == null){
           continue;
       }

       if(!firstRoad){
           sb.append(",\n");
       }

       firstRoad = false;

       sb.append("    { ");
       sb.append("\"a\": ").append(edge.getNodeA()).append(", ");
       sb.append("\"b\": ").append(edge.getNodeB()).append(", ");
       sb.append("\"owner\": \"").append(road.getOwner().getColorString()).append("\"");
       sb.append(" }");
   }
   sb.append("\n  ],\n");

   // buildings
   sb.append("  \"buildings\": [\n");

   Collection<Node> nodes = board.getAllNodes();
   boolean firstBuilding = true;
   for(Node node : nodes){
       if(!node.hasBuilding()){
           continue;
       }

       Building building = node.getBuilding();

       //remove one building.getOwner implemented
       if(building.getOwner() == null){
           continue;
       }

       if(!firstBuilding){
           sb.append(",\n"); }

           firstBuilding = false;
           String type = (building instanceof City) ? "CITY" : "SETTLEMENT";

           sb.append("    { ");
           sb.append("\"node\": ").append(node.getId()).append(", ");
           sb.append("\"owner\": \"").append(building.getOwner().getColorString()).append("\", ");
           sb.append("\"type\": \"").append(type).append("\"");
           sb.append(" }");
       }

       sb.append("\n  ]\n");
       sb.append("}\n");

       try(FileWriter fileWrite = new FileWriter(outputPath)){
           fileWrite.write(sb.toString());
           System.out.println("[GamrStateWriter] state.json written to " + outputPath);
       }
       catch (IOException e){
           System.err.println("[GameStateWriter] failed to write state.json: " + e.getMessage());
       }
   }

}

