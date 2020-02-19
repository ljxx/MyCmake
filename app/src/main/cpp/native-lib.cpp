#include <jni.h>
extern "C" {
#include <libavutil/avutil.h>
}
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_ylx_mycmake_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(av_version_info());
}
