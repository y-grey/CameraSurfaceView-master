# CameraSurfaceView
## 控件介绍
主要的功能有：拍照，录像，定时长录制 ,前后摄像头的切换，并且在后台完成以上所有操作


## 示例截图

![image](https://github.com/qq542391099/CameraSurfaceView-master/blob/master/screenshot/CameraSurfaceView.png)


## 使用方法

```
1.赋予程序必要的权限；

2.布局文件中添加

<com.yph.camerasurfaceview.CameraSurfaceView
    android:id="@+id/mediaSurfaceView"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />

或者 new CameraSurfaceView()，然后调用openCamera()即可。

```
