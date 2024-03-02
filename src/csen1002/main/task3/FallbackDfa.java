package csen1002.main.task3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

	ArrayList<String> lexq = new ArrayList<>();

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
		int L = 0;
		int R = 0;
		String lex = "";
		Stack<String> stack = new Stack<>();

		while (R < input.length()) {
			System.out.println("Begin: The l is equal to: " + L + "The R is equal to " + R);

			String currentState = startState;
			stack.push(currentState);
			for (int i = L; i < input.length(); i++) {
				String nextState = FindNextState(input.charAt(i) + "", currentState);
				currentState = nextState;
				L = i;
				stack.push(currentState);
			}
			System.out.println(stack);
			String latestState = stack.pop();
			boolean isAcceptState = false;
			boolean isRejectState = false;
			if (acceptStates.contains(latestState)) {
				isAcceptState = true;
			}

			String tempState = "";
			while (!isAcceptState) {
				if(!stack.isEmpty()) {
					tempState = stack.pop();
					L--;
				} else {
					tempState = latestState;
					isRejectState = true;
					break;
				}
				if (acceptStates.contains(tempState)) {
					isAcceptState = true;
				}
			}
			int endIndex = isRejectState ? input.length() : L + 1;
			lex += input.substring(R, endIndex) + "," + (tempState.equals("") ? latestState + ";" : tempState + ";");
			L+=1;
			System.out.println("End: The l is equal to: " + L + "The R is equal to: " + R);
			R = L;
			stack.removeAllElements();
			if(isRejectState){
				break;
			}
		}

		return lex.substring(0, lex.length() - 1);
	}

	String FindNextState(String inputLiteral, String fromState){
		for(int i = 0; i < transitions.size(); i++){
			String[] currTransition = transitions.get(i).split(",");
			if(currTransition[0].equals(fromState) && currTransition[1].equals(inputLiteral)){
				return currTransition[2];
			}
		}
		return null;
	}


	public static void main (String[] args){
		String example1 = "0;1;2;3#a;b#0,a,0;0,b,1;1,a,2;1,b,1;2,a,0;2,b,3;3,a,3;3,b,3#0#1;2";
		FallbackDfa temp = new FallbackDfa(example1);
		String ex1Input1 = "baababb";
		String ex1Input2 = "aaa";
		String ex1Input3 = "abaa";
		System.out.println(temp.run(ex1Input1));
	}
}
