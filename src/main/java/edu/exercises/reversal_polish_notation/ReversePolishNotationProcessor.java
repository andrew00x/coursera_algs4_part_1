package edu.exercises.reversal_polish_notation;

import com.google.common.collect.ImmutableMap;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static com.google.common.base.Strings.isNullOrEmpty;

public class ReversePolishNotationProcessor {
    private final Map<String, Operation> operations;

    public ReversePolishNotationProcessor(Map<String, Operation> operations) {
        this.operations = operations;
    }

    public ReversePolishNotationProcessor() {
        this(ImmutableMap.of(
                "+", Operations.PLUS,
                "-", Operations.MINUS,
                "/", Operations.DIV,
                "*", Operations.MULT,
                "^", Operations.POW)
            );
    }

    String[] parse(String reversePolishNotation) {
        checkArgument(!isNullOrEmpty(reversePolishNotation));
        return reversePolishNotation.split("\\s+");
    }

    public double calculate(String reversePolishNotation) {
        final String[] tokens = parse(reversePolishNotation);
        final Deque<Double> stack = new LinkedList<>();
        for (String token : tokens) {
            final Operation operation = operations.get(token);
            if (operation != null) {
                double result = operation.evaluate(stack);
                stack.push(result);
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        checkState(stack.size() == 1);
        return stack.pop();
    }
}
