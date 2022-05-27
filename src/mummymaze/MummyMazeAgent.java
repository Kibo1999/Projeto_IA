package mummymaze;

import agent.Agent;

import java.io.File;
import java.io.FileNotFoundException;

public class MummyMazeAgent extends Agent<MummyMazeState> {

    protected static MummyMazeState initialEnvironment;


    public MummyMazeAgent(MummyMazeState environment) {
        super(environment);
        initialEnvironment = (MummyMazeState) environment.clone();
        heuristics.add(new HeuristicTilesToGoal());
        //heuristics.add(new HeuristicTilesOutOfPlace());
        //heuristic = heuristics.get(0);
    }

    public MummyMazeState resetEnvironment(){
        environment = (MummyMazeState) initialEnvironment.clone();
        return environment;
    }


    public static MummyMazeState readInitialStateFromFile(File file) throws FileNotFoundException {
        java.util.Scanner scanner = new java.util.Scanner(file);

        char[][] matrix = new char [13][13];

        for (int i = 0; i < 13; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        initialEnvironment = new MummyMazeState(matrix);

        //need to uncomment later to save initial state
        //resetEnvironment();
        //return environment;

        return initialEnvironment;
    }

}
