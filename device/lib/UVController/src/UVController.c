#include <UVController.h>

int ultra_violet_led_control(int state) {

    // TODO: led control
    switch(state) {
        case UV_LED_OFF:
            printf("LED OFF");
        break;
        case UV_LED_ON:
            printf("LED ON");
        break;
        default: break;
    }

    return state;
}