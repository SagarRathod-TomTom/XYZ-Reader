package com.example.xyzreader.ui;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Sagar Rathod on 15-Nov-2016.
 */

public class FABScrollingBehaviour extends FloatingActionButton.Behavior{

    private boolean mIsAnimatingOut = false;

    public FABScrollingBehaviour(Context context, AttributeSet attrs) {
                super();
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
                                       FloatingActionButton child,
                                       View directTargetChild, View target, int nestedScrollAxes) {

        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL
                         || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);

    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout,
                               FloatingActionButton child,
                               View target, int dxConsumed,
                               int dyConsumed, int dxUnconsumed,
                               int dyUnconsumed) {

        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        if (dyConsumed > 0 && !this.mIsAnimatingOut && child.getVisibility() == View.VISIBLE) {
                       // User scrolled down and the FAB is currently visible -> hide the FAB
                    child.hide();

        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
                        // User scrolled up and the FAB is currently not visible -> show the FAB
                   child.show();
        }

    }

}
