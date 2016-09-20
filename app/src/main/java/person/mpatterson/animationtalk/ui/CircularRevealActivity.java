package person.mpatterson.animationtalk.ui;

import android.animation.Animator;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewAnimationUtils;

import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

public class CircularRevealActivity extends BaseActivity {

    private boolean exit;
    private boolean firstAnimComplete;
    Display display;
    Point size;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_circular_reveal;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        return null;
    }

    @Override
    protected Class getNextActivityClass() {
        if (exit) {
            return QuestionsActivity.class;
        } else {
            if (!firstAnimComplete) {
                View correctReveal = findViewById(R.id.correct_reveal);

                int correctX = size.x / 2;
                int correctY = size.y / 2;
                int viewX = correctReveal.getWidth() / 2;
                int viewY = correctReveal.getHeight() / 2;
                float correctRadius = (float) Math.hypot(correctX, correctY);

                Animator correctAnimator = ViewAnimationUtils.createCircularReveal(correctReveal, viewX, viewY, 0, correctRadius);
                correctReveal.setVisibility(View.VISIBLE);
                correctAnimator.start();
                firstAnimComplete = true;
            } else {
                exit = true;

                View incorrectReveal = findViewById(R.id.incorrect_reveal);

                int viewX = incorrectReveal.getWidth() / 2;
                int viewY = incorrectReveal.getHeight() / 2;
                float incorrectRadius = size.x / 2;

                Animator incorrectAnimator = ViewAnimationUtils.createCircularReveal(incorrectReveal, viewX, viewY, 0, incorrectRadius);
                incorrectReveal.setVisibility(View.VISIBLE);
                incorrectAnimator.start();
            }
        }
        return null;
    }
}
