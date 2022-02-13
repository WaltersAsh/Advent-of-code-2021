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
    int *windows;
    windows = (int *) malloc(SIZE * sizeof(int));

    for (int i = 2; i < SIZE; i++) {
        windows[i] = inputs[i - 2] + inputs[i - 1] + inputs[i];
    }

    for (int i = 1; i < SIZE - 1; i++) {
        if (windows[i - 1 ] < windows[i]) {
            c++;
        }
    }
    
    return c;
}

//gcc part2.c -o part2
int main(void) {
    printf("Answer is: %d\n", process(readInputs()));

    return 0;
}