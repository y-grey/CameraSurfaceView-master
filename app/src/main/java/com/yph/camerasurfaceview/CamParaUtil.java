package com.yph.camerasurfaceview;

import android.hardware.Camera.Size;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CamParaUtil {

    public static Size getSize(List<Size> list, int th,Size defaultSize) {
        if(null == list || list.isEmpty()) return defaultSize;
        Collections.sort(list, new Comparator<Size>(){
            public int compare(Size lhs, Size rhs) {//作升序排序
                if (lhs.width == rhs.width) {
                    return 0;
                } else if (lhs.width > rhs.width) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        int i = 0;
        for (Size s : list) {
            if ((s.width > th) ) {//&& equalRate(s, rate)
                break;
            }
            i++;
        }
        if (i == list.size()) {
            return list.get(i-1);
        } else {
            return list.get(i);
        }
    }


//    public static Size getBestSize(List<Camera.Size> list, float rate) {
//        float previewDisparity = 100;
//        int index = 0;
//        for (int i = 0; i < list.size(); i++) {
//            Size cur = list.get(i);
//            float prop = (float) cur.width / (float) cur.height;
//            if (Math.abs(rate - prop) < previewDisparity) {
//                previewDisparity = Math.abs(rate - prop);
//                index = i;
//            }
//        }
//        return list.get(index);
//    }
//
//
//    private static boolean equalRate(Size s, float rate) {
//        float r = (float) (s.width) / (float) (s.height);
//        if (Math.abs(r - rate) <= 0.2) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public static boolean isSupportedFocusMode(List<String> focusList, String focusMode) {
        for (int i = 0; i < focusList.size(); i++) {
            if (focusMode.equals(focusList.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupportedFormats(List<Integer> supportedFormats, int jpeg) {
        for (int i = 0; i < supportedFormats.size(); i++) {
            if (jpeg == supportedFormats.get(i)) {
                return true;
            }
        }
        return false;
    }
}
