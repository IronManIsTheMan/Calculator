#include "demo_com_calculator_util_NativeCalculator.h"

JNIEXPORT jint JNICALL Java_demo_com_calculator_util_NativeCalculator_addAndModulo7
        (JNIEnv *env, jobject obj, jint x, jint y) {
        return (x + y) % 7;

}

JNIEXPORT jint JNICALL Java_demo_com_calculator_util_NativeCalculator_subtractAndModulo7
        (JNIEnv *env, jobject obj, jint x, jint y) {
        return (x - y) % 7;

}

JNIEXPORT jint JNICALL Java_demo_com_calculator_util_NativeCalculator_multiplyAndModulo7
        (JNIEnv *env, jobject obj, jint x, jint y) {
        return (x * y) % 7;
}
