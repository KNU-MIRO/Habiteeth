//
//  native_test.c
//  Habiteeth
//  
//  Created by Hyeon soo Ha on 2017. 10. 15..
//  Copyright © 2017년 MIRO. All rights reserved.
//
//  NOTE: native code test script, API 테스트코드 작성(Arduino API 사용X)

#include <Habiteeth.h>
#include <unity.h>

#ifdef UNIT_TEST 

int main(int argc, char **argv) {
    TEST_ASSERT_EQUAL(200, unit_test_adder(100, 100)); // unit test test
    return 0;
}

#endif

