package csen1002.main.task3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Write your info here
 * 
 * @name Mohamed Moustafa Rabie
 * @id 49-3603
 * @labNumber 21
 */

public class FallbackDfa {

	ArrayList<String> states = new ArrayList<>();
	ArrayList<String> alphabet = new ArrayList<>();
	ArrayList<String> transitions = new ArrayList<>();
	String startState;
	ArrayList<String> acceptStates = new ArrayList<>();

	/**
	 * Constructs a Fallback DFA
	 * 
	 * @param fdfa A formatted string representation of the Fallback DFA. The string
	 *             representation follows the one in the task description
	 */
	public FallbackDfa(String fdfa) {
		String[] fdfaArray = fdfa.split("#");

		states.addAll(List.of(fdfaArray[0].split(";")));

		alphabet.addAll(List.of(fdfaArray[1].split(";")));

		transitions.addAll(List.of(fdfaArray[2].split(";")));

		startState = fdfaArray[3];

		acceptStates.addAll(List.of(fdfaArray[4].split(";")));

		//System.out.println(states + "  " + alphabet + "  " + transitions + "  " + startState + "  " + acceptStates);
	}

	/**
	 * @param input The string to simulate by the FDFA.
	 * 
	 * @return Returns a formatted string representation of the list of tokens. The
	 *         string representation follows the one in the task description
	 */
	public String run(String input) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main (String[] args){
		FallbackDfa temp = new FallbackDfa("0;1;2;3#a;b#0,a,0;0,b,1;1,a,2;1,b,1;2,a,0;2,b,3;3,a,3;3,b,3#0#1;2");
	}
}
