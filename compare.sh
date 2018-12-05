#!/usr/bin/env bash
./gradlew build --stacktrace
if [ $? = 0 ]; then
    java -ea -cp build/libs/coursera_algs4_part_1.jar:libs/algs4.jar edu.coursera.algs41.SortCompare $1 $2 $3 $4
fi