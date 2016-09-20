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

    private boolean pause;
    private boolean exit;
    private boolean firstAnimComplete;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_circular_reveal;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        return null;
    }

    @Override
    protected Class getNextActivityClass() {
        if (exit) {
            return QuestionsActivity.class;
        } else if (pause) {
            exit = true;
        } else {
            if (!firstAnimComplete) {
                View correctReveal = findViewById(R.id.correct_reveal);

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);

                int correctX = size.x / 2;
                int correctY = size.y / 2;
                float correctRadius = (float) Math.hypot(correctX, correctY);

                Animator correctAnimator = ViewAnimationUtils.createCircularReveal(correctReveal, correctX, correctY, 0, correctRadius);
                correctReveal.setVisibility(View.VISIBLE);
                correctAnimator.start();
                firstAnimComplete = true;
            } else {
                pause = true;

                View incorrectReveal = findViewById(R.id.incorrect_reveal);

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);

                int incorrectX = size.x / 2;
                int incorrectY = size.y / 2;

                float incorrectRadius = size.x / 2;
                Animator incorrectAnimator = ViewAnimationUtils.createCircularReveal(incorrectReveal, incorrectX, incorrectY, 0, incorrectRadius);
                incorrectReveal.setVisibility(View.VISIBLE);
                incorrectAnimator.start();
            }
        }
        return null;
    }
}
