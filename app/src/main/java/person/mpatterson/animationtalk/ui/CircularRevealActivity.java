package person.mpatterson.animationtalk.ui;

import android.animation.Animator;
import android.view.View;
import android.view.ViewAnimationUtils;

import java.util.ArrayDeque;
import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

public class CircularRevealActivity extends BaseActivity {
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_circular_reveal;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        View correctReveal = findViewById(R.id.correct_reveal);
        int correctX = correctReveal.getWidth() / 2;
        int correctY = correctReveal.getHeight() / 2;
        float correctRadius = (float) Math.hypot(correctX, correctY);
        Animator correctAnimator = ViewAnimationUtils.createCircularReveal(correctReveal, correctX, correctY, 0, correctRadius);
        //correctReveal.setVisibility(View.VISIBLE);

        View incorrectReveal = findViewById(R.id.incorrect_reveal);
        int incorrectX = incorrectReveal.getWidth() / 2;
        int incorrectY = incorrectReveal.getHeight() / 2;
        float incorrectRadius = (float) Math.hypot(incorrectX, incorrectY);
        Animator incorrectAnimator = ViewAnimationUtils.createCircularReveal(incorrectReveal, incorrectX, incorrectY, 0, incorrectRadius);
        //correctReveal.setVisibility(View.VISIBLE);

        Queue<Phase> phaseQueue = new ArrayDeque<>();
        phaseQueue.add(new Phase(correctAnimator, false, this));
        phaseQueue.add(new Phase(incorrectAnimator, true, this));

        return phaseQueue;
    }

    @Override
    protected Class getNextActivityClass() {
        return QuestionsActivity.class;
    }
}
