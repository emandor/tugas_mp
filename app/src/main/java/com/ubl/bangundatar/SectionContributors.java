
package com.ubl.bangundatar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Icon;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

public class SectionContributors {

    @SuppressLint("SetTextI18n")
    public static void setup(Activity activity) {
        LinearLayout container = activity.findViewById(R.id.contributorsContainer);

        List<Contributor> contributors = Arrays.asList(
                new Contributor("Aris Kurniawan", "2311510438"),
                new Contributor("Ahmad Dzaki", "2311510651"),
                new Contributor("Jenar Mahani","2311510032"),
                new Contributor("Nur Ani Mudiyanti","2311510479")
        );

        for (Contributor contributor : contributors) {
            LinearLayout row = new LinearLayout(activity);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setPadding(0, 8, 0, 8);

            ImageView icon = new ImageView(activity);
            icon.setImageResource(R.drawable.ic_person);
            icon.setColorFilter(activity.getResources().getColor(R.color.primary));
            LinearLayout.LayoutParams iconParams = new LinearLayout.LayoutParams(48, 48);
            iconParams.setMargins(0, 0, 16, 0);
            icon.setLayoutParams(iconParams);

            TextView text = new TextView(activity);
            text.setText(contributor.name + " – " + contributor.id);
            text.setTextSize(16);
            text.setTextColor(activity.getResources().getColor(R.color.textPrimary));

            row.addView(icon);
            row.addView(text);
            container.addView(row);
        }
    }
}
