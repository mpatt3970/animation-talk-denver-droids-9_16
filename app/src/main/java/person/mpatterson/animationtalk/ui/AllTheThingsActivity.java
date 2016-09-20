package person.mpatterson.animationtalk.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

/**
 * Created by michael on 9/17/16.
 */
public class AllTheThingsActivity extends BaseActivity {
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_all_the_things;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        Queue<Phase> phases = new ArrayDeque<>();

        View animateWord = findViewById(R.id.animate_word);
        View allWord = findViewById(R.id.all_word);
        View theWord = findViewById(R.id.the_word);
        View thingsWord = findViewById(R.id.things_word);
        View leftStatement = findViewById(R.id.left_statement);
        View rightStatement = findViewById(R.id.right_statement);
        View animateImage = findViewById(R.id.animate_all_image);

        // This is just a funny example of how bad animations can look
        List<Animator> animators = new ArrayList<>();
        animators.add(ObjectAnimator.ofFloat(animateWord, View.TRANSLATION_X, animateWord.getTranslationX(), -1200));
        animators.add(ObjectAnimator.ofFloat(animateWord, View.TRANSLATION_Y, animateWord.getTranslationY(), -100));
        animators.add(ObjectAnimator.ofFloat(thingsWord, View.SCALE_X, thingsWord.getScaleX(), 0));
        animators.add(ObjectAnimator.ofFloat(allWord, View.TRANSLATION_Y, allWord.getTranslationY(), -100));
        animators.add(ObjectAnimator.ofFloat(theWord, View.ALPHA, theWord.getAlpha(), 0));
        animators.add(ObjectAnimator.ofFloat(animateImage, View.ALPHA, animateImage.getAlpha(), 0));
        animators.add(ObjectAnimator.ofFloat(leftStatement, View.TRANSLATION_X, leftStatement.getTranslationX(), 1200));
        animators.add(ObjectAnimator.ofFloat(rightStatement, View.TRANSLATION_X, rightStatement.getTranslationX(), -1200));

        AnimatorSet set = new AnimatorSet();
        set.playTogether(animators);
        set.setDuration(1000);
        phases.add(new Phase(set, false, this));

        return phases;
    }

    @Override
    protected Class getNextActivityClass() {
        return ShortActivity.class;
    }
}
