package com.ylx.mycmake;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * createTime：2020-02-24  21:24
 * author：YLiXiang
 * description：
 */
public class YlxPlayer implements SurfaceHolder.Callback {

    static {
        System.loadLibrary("ylxplayer");
    }

    private SurfaceHolder mSurfaceHolder;

    //绘制NDK path surfaceView
    public void setSurfaceView(SurfaceView surfaceView) {

        if(null != this.mSurfaceHolder) {
            this.mSurfaceHolder.removeCallback(this);
        }
        this.mSurfaceHolder = surfaceView.getHolder();
        this.mSurfaceHolder.addCallback(this);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        surfaceHolder.getSurface();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    /**
     * 开始播放
     * @param path
     */
    public void start(String path) {
        native_start(path, mSurfaceHolder.getSurface());
    }

    public native void native_start(String path, Surface surface);
}
