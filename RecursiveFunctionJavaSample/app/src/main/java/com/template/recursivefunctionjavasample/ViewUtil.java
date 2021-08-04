package com.template.recursivefunctionjavasample;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class ViewUtil {
    private ViewUtil() {
        throw new AssertionError();
    }

    private static List<View> getViewTree(@Nullable final View view) {
        List<View> views = new ArrayList<>();
        if ((view instanceof ViewGroup)) {
            int childNum = ((ViewGroup) view).getChildCount();
            for (int count = childNum; 0 <= count; count--) {
                View child = ((ViewGroup) view).getChildAt(count - 1);
                views.addAll(getViewTree(child));
            }
        }
        if (view != null) {
            views.add(view);
        }
        return views;
    }

    public static void setOnClickListenerForToggleButton(@NonNull final View vg, @Nullable final View.OnClickListener l) {
        final List<View> viewTree = getViewTree(vg);
        viewTree.stream().filter(view -> view instanceof ToggleButton).forEach(view -> view.setOnClickListener(l));
    }
}
