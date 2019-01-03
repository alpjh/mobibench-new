#include <jni.h>

JNIEXPORT void JNICALL
Java_com_example_esos_andctest_MobiBench_MobiBenchExe_mobibench_1run(JNIEnv *env, jobject instance,
                                                                     jstring str_) {
    const char *str = (*env)->GetStringUTFChars(env, str_, 0);

    // TODO

    (*env)->ReleaseStringUTFChars(env, str_, str);
}