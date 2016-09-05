package person.mpatterson.animationtalk.ui;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.widget.BaseLayout;

/**
 * Created by michael on 9/5/16.
 */
public class QuestionsActivity extends BaseActivity {

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_questions;
    }

    @Override
    protected Class getNextActivityClass() {
        return null;
    }

    private void startAnimation() {
        ((BaseLayout) findViewById(R.id.base_layout)).startAnimation();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        startAnimation();
        return super.onKeyDown(keyCode, event);
    }
}
