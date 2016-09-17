package person.mpatterson.animationtalk.helper;

import android.view.animation.Interpolator;

/**
 * Created by michael on 9/17/16.
 */
public class ReverseInterpolator implements Interpolator {
    @Override
    public float getInterpolation(float v) {
        return -v;
    }
}
