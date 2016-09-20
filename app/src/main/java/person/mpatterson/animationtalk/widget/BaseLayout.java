package person.mpatterson.animationtalk.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import person.mpatterson.animationtalk.R;

/**
 * Created by michael on 9/5/16.
 */
public class BaseLayout extends FrameLayout {

    private Drawable mBackground;

    public BaseLayout(Context context) {
        this(context, null, 0);
    }

    public BaseLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBackground = ContextCompat.getDrawable(getContext(), R.drawable.animated_background);
        setBackground(mBackground);
    }

    public Animatable2 getAnimatable() {
        if (mBackground instanceof Animatable2) {
            return (Animatable2) mBackground;
        }
        return null;
    }
}
