# CameraSurfaceView
## 控件介绍
这是一个拍照，录像，闪光灯，摄像头切换，前后台切换于一体的SurfaceView，主要的功能有如下：

1. 点击拍照，录像，定时长录制 ,前后摄像头的切换，并且在后台完成以上所有操作


## 示例截图

![image](https://github.com/qq542391099/CameraSurfaceView-master/blob/master/screenshot/CameraSurfaceView.png)


## 使用方法

```
## 布局文件中添加
```
<com.yph.camerasurfaceview.CameraSurfaceView
    android:id="@+id/mediaSurfaceView"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```




### AndroidManifest.xml中添加权限
```

<uses-permission android:name="android.permission.WAKE_LOCK"/>

<uses-permission android:name="android.permission.RECORD_AUDIO" />
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_SETTINGS" />
<uses-feature android:name="android.hardware.camera" />
<uses-feature android:name="android.hardware.camera.autofocus" />
```
## Activity设置为全屏
```
View decorView = getWindow().getDecorView();
decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
ActionBar actionBar = getSupportActionBar();
actionBar.hide();
```
## 初始化CameraSurfaceView控件
cameraSurfaceView = (CameraSurfaceView) findViewById(R.id.mediaSurfaceView);
cameraSurfaceView.openCamera();
```
//(0.1.4+)动态权限获取
CheckPermissionsUtil checkPermissionsUtil = new CheckPermissionsUtil(this);
checkPermissionsUtil.requestAllPermission(this);

mJCameraView = (JCameraView) findViewById(R.id.cameraview);
//(0.0.7+)设置视频保存路径（如果不设置默认为Environment.getExternalStorageDirectory().getPath()）
mJCameraView.setSaveVideoPath(Environment.getExternalStorageDirectory().getPath());
//(0.0.8+)设置手动/自动对焦，默认为自动对焦
mJCameraView.setAutoFoucs(false);
mJCameraView.setCameraViewListener(new JCameraView.CameraViewListener() {
    @Override
    public void quit() {
        //返回按钮的点击时间监听
        MainActivity.this.finish();
    }
    @Override
    public void captureSuccess(Bitmap bitmap) {
        //获取到拍照成功后返回的Bitmap
    }
    @Override
    public void recordSuccess(String url) {
        //获取成功录像后的视频路径
    }
});
```