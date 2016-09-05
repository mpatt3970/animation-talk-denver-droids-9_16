package person.mpatterson.animationtalk.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import person.mpatterson.animationtalk.R;

/**
 * Created by michael on 9/5/16.
 */
public class BaseLayout extends FrameLayout {


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
        setBackgroundResource(R.drawable.base_background);
        // TODO: build the toolbar/actionbar if needed
    }
}
