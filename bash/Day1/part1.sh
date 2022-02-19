#!/bin/bash

main() {
    file="../../inputs/day-one-input.txt";
    readarray -t inputs < $file
    ans=0;
    prev=${inputs[0]}
    len=${#inputs[@]}

    for ((i=1; i<len; i++)); do
        if [[ $prev -lt ${inputs[i]} ]]; then
            ((ans++))
        fi
        prev=${inputs[i]}
    done

    echo "Answer is: $ans"
}

main