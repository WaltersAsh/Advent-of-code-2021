#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int * readInputs() {
    FILE *fp;
    static int inputs[255];
    
    fp = fopen("../../inputs/day-one-input.txt", "r");
    if (fp == NULL) {
        printf("Cannot open file\n");
        return 0;
    }
    
    int sc = fscanf(fp, "%d", &inputs);

    return inputs;
}

/*gcc t4test.c dbms.c -o t4test*/
int main(void) {

    int *inputs;

    inputs = readInputs();
    for (int i = 0; i < sizeof(inputs); i++) {
        printf(inputs[i]);
    }

    return 0;
}

