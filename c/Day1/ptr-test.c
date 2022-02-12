#include <stdio.h>

void testUno() {
    int x = 7;
    printf("x is %d\n", x);

    x = 14;
    printf("x is %d\n", x);


    int * aptr = &x;
    printf("Pointer is %p\n", aptr); //prints address 
    printf("Pointer value is %d\n", *aptr); //prints actual value that pointer is pointing at (deferencing)
    
    //change x value via pointer
    *aptr = 21;
    printf("New pointer value is %d\n", *aptr);
    printf("Original x var has updated %d\n", x);
    return;
}

void testDos() {
    int arr[5];
    int *ptr = arr; //&nums[0]
    int inc = 0;

    for (;ptr < &arr[5]; ptr++) {
        printf("%p\n", ptr); //ptr is being incremented by 4 bytes each which is the address
        *ptr = inc + 1;
        inc += 1;    
    }

    for (int i = 0; i < 5; i++) {
        printf("%d\n", arr[i]);
    }

    return;
}

void testTres() {
    int arr[5];
    int size = sizeof(arr) / sizeof(arr[0]);
    for (int i = 0; i < size; i++) {
        arr[i] = i + 1;
        printf("%d\n", arr[i]);
    }
}


int main() {
    printf("Tests pointer changes in variable x\n");
    testUno();
    printf("\n");
    
    printf("Tests pointer incrementation in array\n");
    testDos();
    printf("\n");

    return 0;
}

