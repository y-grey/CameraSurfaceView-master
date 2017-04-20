# CameraSurfaceView
## 控件介绍
主要的功能有：拍照，录像，闪光灯，定时长录像 ,前后摄像头的切换，自适应横竖屏的切换，并且支持在后台完成以上所有操作


## 示例截图

![image](https://github.com/qq542391099/CameraSurfaceView-master/blob/master/screenshot/CameraSurfaceView.png)


## 使用方法

```
1.赋予程序必要的权限；

2.布局文件中添加

<com.yph.camerasurfaceview.CameraSurfaceView
    android:id="@+id/cameraSurfaceView"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />

或者 new CameraSurfaceView(context),即可。

3.拍照：cameraSurfaceView.capture();

  录像：cameraSurfaceView.startRecord();//开始录制
        cameraSurfaceView.stopRecord(); //结束录制
        //设置录制时长为10秒视频
        cameraSurfaceView.startRecord(10000, new MediaRecorder.OnInfoListener() {
            @Override
            public void onInfo(MediaRecorder mr, int what, int extra) {
                cameraSurfaceView.stopRecord();
            }
        });

  闪光灯：cameraSurfaceView.switchLight(boolean open);

  前后摄像头的切换：cameraSurfaceView.setDefaultCamera(boolean backCamera);

  前后台切换：cameraSurfaceView.setRunBack(boolean b)

4.释放Camera:
  @Override
  protected void onDestroy() {
      super.onDestroy();
      cameraSurfaceView.closeCamera();
  }

```
