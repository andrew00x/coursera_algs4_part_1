#!/usr/bin/env bash
./gradlew build --stacktrace
if [ $? = 0 ]; then
    java -ea -cp build/libs/coursera_algs4_part_1.jar:libs/algs4.jar edu.coursera.algs41.IntArrayGen $1 > src/main/resources/$2
fi