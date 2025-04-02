import java.io.*;
import java.util.*;
public class Runners{
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the data file:");
        String fname = scanner.nextLine();
        //oprn file
        Map<Integer,Set<String>> runnerWaypoints = new HashMap<>();
        Set<String> allwaypoints = new HashSet<>();
        try {
            Scanner streamming = new Scanner(new FileInputStream(fname));
            while (streamming.hasNextLine()){
                String[] line = streamming.nextLine().split(" ");
                String waypoint = line[1];
                int runnerNumber = Integer.parseInt(line[2]);
                //add waypoints
                allwaypoints.add(waypoint);
                runnerWaypoints.putIfAbsent(runnerNumber,new HashSet<>());
                runnerWaypoints.get(runnerNumber).add(waypoint);
            }
            if (runnerWaypoints.isEmpty()){
                System.out.println("Such empty!");
            }
            else{
                for (int runner: runnerWaypoints.keySet()){
                    Set<String> waypoints = runnerWaypoints.get(runner);
                    if (waypoints.containsAll(allwaypoints)){
                        System.out.println(runner +" OK.");
                    }
                    else{
                        System.out.println(runner +" Red flag.");
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}