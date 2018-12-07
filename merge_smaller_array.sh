#!/usr/bin/env bash
./gradlew build --stacktrace
if [ $? = 0 ]; then
    arr=$@
    if [ -z "$arr" ]; then
        arr="1 3 5 7 9 0 2 4 6 8"
    fi
    java -ea -cp build/libs/coursera_algs4_part_1.jar:libs/algs4.jar edu.coursera.algs41.MergeWithSmallerAuxiliaryArray $arr
fi