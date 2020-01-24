package edu.exercises.reversal_polish_notation;

import java.util.Deque;

public interface Operation {
    double evaluate(Deque<Double> arguments);
}
