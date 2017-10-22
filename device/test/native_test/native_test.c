//
//  native_test.c
//  Habiteeth
//  
//  Created by Hyeon soo Ha on 2017. 10. 15..
//  Copyright © 2017년 MIRO. All rights reserved.
//
//  NOTE: native code test script, API 테스트코드 작성(Arduino API 사용X)

#include <Habiteeth.h>
#include <UVController.h>

#include <unity.h>

#ifdef UNIT_TEST 
int algorythm_test_dongyoung(int target, int source);
int algorythm_test_ho(int target, int source);

int main(int argc, char **argv) {
    TEST_ASSERT_EQUAL(200, unit_test_adder(100, 100)); // unit test test
    TEST_ASSERT_EQUAL(UV_LED_OFF, ultra_violet_led_control(UV_LED_OFF));
    TEST_ASSERT_EQUAL(UV_LED_ON, ultra_violet_led_control(UV_LED_ON));
    TEST_ASSERT_EQUAL(60,algorythm_test_ho(3,5));

    // TODO 테스트코드 작성하시오 2개 정도
 
    return 0;
}


// TODO: 동영이는 target에서 source까지의 숫자를 전부 더하시오
// ex: 2, 4 -> 2 + 3 + 4 -> 9
int algorythm_test_dongyoung(int target, int source) {
    
    return 0;
}
    
    // TODO: 동호는  target에서 source까지의 숫자를 전부 곱하시오.
int algorythm_test_ho(int target, int source) {
    int mul = 1;
    for(int i = target; i <= source; i++) {
        mul = mul * i;
    }
    return mul;
}
    

#endif

