#!/bin/bash

main() {
    file="../../inputs/day-one-input.txt";
    readarray -t inputs < $file
    ans=0;
    prev=${inputs[0]}
    len=${#inputs[@]}

    for ((i=0; i<len-2; i++)); do
        if [[ ${inputs[i+3]} -gt $prev ]]; then
            ((ans++))
        fi
        prev=${inputs[i+1]}
    done

    echo "Answer is: $ans"
}

main