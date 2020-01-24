package edu.exercises.reversal_polish_notation;

import static com.google.common.base.Preconditions.checkArgument;

public class Operations {
    public static Operation PLUS = arguments -> {
        checkArgument(arguments.size() >= 2);
        return arguments.pop() + arguments.pop();
    };

    public static Operation MINUS = arguments -> {
        checkArgument(arguments.size() >= 1);
        final Double firstArgument = arguments.pop();
        if (arguments.isEmpty()) {
            return - firstArgument;
        }
        return arguments.pop() - firstArgument;
    };

    public static Operation DIV = arguments -> {
        checkArgument(arguments.size() >= 2);
        return 1 / (arguments.pop() / arguments.pop());
    };

    public static Operation MULT = arguments -> {
        checkArgument(arguments.size() >= 2);
        return arguments.pop() * arguments.pop();
    };

    public static Operation POW = arguments -> {
        checkArgument(arguments.size() >= 2);
        Double argument = arguments.pop();
        Double power = arguments.pop();
        return Math.pow(power, argument);
    };
}
