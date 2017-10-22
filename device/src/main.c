//
//  main.c
//  Habiteeth
//  
//  Created by Choi dong ho on 2017. 10. 15..
//  Copyright © 2017년 MIRO. All rights reserved.
//

#include <Habiteeth.h>
#include <UVController.h>

#ifndef UNIT_TEST 

void setup() {
    // TODO: initial setting
}
    
void loop() {
    // TODO: Device work
    int a = 0;
    for(int i = 0; i < 10; i++) {
        a += i;
    }
    printf(a);

    hello_miro(); // call test
}

#endif