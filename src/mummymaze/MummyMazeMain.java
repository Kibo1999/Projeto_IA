package mummymaze;

import showSolution.SolutionPanel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MummyMazeMain {
    //private static String FILE_PATH = "./Niveis/nivel_so_com_heroi.txt";
    private static String FILE_PATH = "./Niveis/nivel_so_com_heroi_e_paredes.txt";

    public static void main(String[] args) throws IOException {
        // read the initial state from a file
        MummyMazeState state = MummyMazeAgent.readInitialStateFromFile(new File(FILE_PATH));
        //DEBUG: Shows matrix
        //state.showState();
        System.out.println(state);

        // instantiate a new Agent
        MummyMazeAgent agent = new MummyMazeAgent(state);
        System.out.println("new agent created");
        // instanciar um novo Problem
        MummyMazeProblem problem = new MummyMazeProblem(state);
        System.out.println("new problem created");
        // execute the search algorithm to find a solution
        System.out.println("trying to solve problem");
        agent.solveProblem(problem);
        System.out.println("problem solved");
        // execute the solution (which will generate a list of strings -- the turns)
        agent.executeSolution();
        // get the list of turns and the cost
        System.out.println("solution executed");
        List<String> turns = agent.getTurnos();
        double cost = agent.getSolutionCost();
        System.out.println("Showing the final matrix : " + state);
        // show the list of turns in the GUI
        System.out.println("showing the solution visually");
        SolutionPanel.showSolution(turns, cost);
        System.out.println("solution shown");
    }
}
