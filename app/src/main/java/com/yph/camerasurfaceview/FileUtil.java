package com.yph.camerasurfaceview;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    private static final String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();

    //保存照片
    public static void saveBitmap(Bitmap b) {
        String jpegName = rootPath + "/" + getTime() + ".jpg";
        try {
            FileOutputStream fout = new FileOutputStream(jpegName);
            BufferedOutputStream bos = new BufferedOutputStream(fout);
            b.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取视频存储路径
    public static String getMediaOutputPath() {
        return rootPath + "/" + getTime() + ".mp4";
    }

    private static String getTime() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(System.currentTimeMillis()));
    }

    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
}
