//
//  device_test.c
//  Habiteeth
//  
//  Created by Hyeon soo Ha on 2017. 10. 15..
//  Copyright © 2017년 MIRO. All rights reserved.
//
//  NOTE: device code test script, 디바이스 테스트 코드 작성

#include <Arduino.h>
#include <unity.h>
#include <Habiteeth.h>

#ifdef UNIT_TEST

void setup() {
    delay(2000);
    UNITY_BEGIN();    // IMPORTANT LINE!
}

void loop() {
    RUN_TEST(hello_miro());
    TEST_ASSERT_EQUAL(200, unit_test_adder(100, 100)); // unit test test
    UNITY_END(); // stop unit testing
}

#endif