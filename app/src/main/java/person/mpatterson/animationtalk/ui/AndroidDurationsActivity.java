package person.mpatterson.animationtalk.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

/**
 * Created by michael on 9/17/16.
 */
public class AndroidDurationsActivity extends BaseActivity {
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_android_durations;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        View ballShort = findViewById(R.id.short_ball_anim);
        View ballMedium = findViewById(R.id.medium_ball_anim);
        View ballLong = findViewById(R.id.long_ball_anim);

        Resources res = getResources();
        float width = 600 * res.getDisplayMetrics().density - res.getDimensionPixelOffset(R.dimen.white_ball_size);
        Interpolator interpolator = new LinearInterpolator();
        Animator animatorShort = ObjectAnimator.ofFloat(ballShort, View.TRANSLATION_X, 0, width);
        animatorShort.setDuration(res.getInteger(android.R.integer.config_shortAnimTime));
        animatorShort.setInterpolator(interpolator);

        Animator animatorMedium = ObjectAnimator.ofFloat(ballMedium, View.TRANSLATION_X, 0, width);
        animatorMedium.setDuration(res.getInteger(android.R.integer.config_mediumAnimTime));
        animatorMedium.setInterpolator(interpolator);


        Animator animatorLong = ObjectAnimator.ofFloat(ballLong, View.TRANSLATION_X, 0, width);
        animatorLong.setDuration(res.getInteger(android.R.integer.config_longAnimTime));
        animatorLong.setInterpolator(interpolator);

        List<Animator> animators = Arrays.asList(animatorShort, animatorMedium, animatorLong);

        Phase p = new Phase(animators, false, this);
        Queue<Phase> phaseQueue = new ArrayDeque<>();
        phaseQueue.add(p);
        return phaseQueue;
    }

    @Override
    protected Class getNextActivityClass() {
        return DurationDependsActivity.class;
    }
}
