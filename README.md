# FallbackDFA

## Description

The Fallback DFA is a modified version of a DFA that allows for lexing (tokenizing) input strings. It reads a formatted string representation of the DFA and simulates its behavior on input strings to tokenize them. The tokenization process involves recognizing patterns in the input string based on the DFA's states and transitions.

### Installation

Clone the repository to your local machine:

```bash
git clone https://github.com/username/FallbackDFA.git
```

### Running the Code

To use the FallbackDFA class in your Java project, simply include the `FallbackDfa.java` file in your project directory. You can then create an instance of the `FallbackDfa` class and use its `run()` method to tokenize input strings.

Example usage:

```java
String fdfaRepresentation = "state1;state2;state3#symbol1;symbol2;symbol3#state1,symbol1,state2;state2,symbol2,state3#state1#state3";
FallbackDfa dfa = new FallbackDfa(fdfaRepresentation);
String input = "input_string_to_tokenize";
String tokens = dfa.run(input);
System.out.println("Tokens: " + tokens);
```

### Input Format

The input to the FallbackDfa constructor and the `run()` method follows a specific format:

```
state1;state2;state3#symbol1;symbol2;symbol3#state1,symbol1,state2;state2,symbol2,state3#start_state#accept_states
```

### Output Format

The `run()` method returns a formatted string representation of the list of tokens. The string representation follows the one described in the input format.

