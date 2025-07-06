
package com.ubl.tugas_mp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class SectionMainMenu {

    public static void setup(Activity activity) {
        activity.findViewById(R.id.cardSquare).setOnClickListener(v -> goToSquare(v));
        activity.findViewById(R.id.cardRectangle).setOnClickListener(v -> goToRectangle(v));
        activity.findViewById(R.id.cardTriangle).setOnClickListener(v -> goToTriangle(v));
    }

    public static void goToSquare(View view) {
        Activity activity = (Activity) view.getContext();
        activity.startActivity(new Intent(activity, SquareActivity.class));
    }

    public static void goToRectangle(View view) {
        Activity activity = (Activity) view.getContext();
        activity.startActivity(new Intent(activity, RectangleActivity.class));
    }

    public static void goToTriangle(View view) {
        Activity activity = (Activity) view.getContext();
        activity.startActivity(new Intent(activity, EquilateralTriangleActivity.class));
    }
}

