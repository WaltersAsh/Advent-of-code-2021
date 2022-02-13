#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 2000

int * readInputs() {
    FILE *fp;
    static int *inputs;

    fp = fopen("../../inputs/day-one-input.txt", "r");
    if (fp == NULL) {
        printf("Cannot open file\n");
        return 0;
    }

    inputs = (int *) malloc(SIZE * sizeof(int));
    while (!feof(fp)) {
        for (int i = 0; i < SIZE; i++) {
            fscanf(fp, "%d", &inputs[i]);
        }
    }
    fclose(fp);

    return inputs;
}

int process(int *inputs) {
    int c = 0;
    for (int i = 1; i < SIZE; i++) {
        if (inputs[i - 1] < inputs[i]) {
            c++;
        }
    }
    
    return c;
}

//gcc part1.c -o part1
int main(void) {
    printf("Answer is: %d\n", process(readInputs()));

    return 0;
}

