package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;

import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by Arkadiusz Wilczek on 21.03.18.
 */

public class Emojifier {

    private static final String LOG_TAG = Emojifier.class.getSimpleName();

    public static void detectFaces(Context context, Bitmap bitmap) {
        int numberFaces;

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        SparseArray<Face> faces = detector.detect(frame);

        numberFaces = faces.size();
        Log.d(LOG_TAG ,"Number faces: " + numberFaces);
    }
}
