package person.mpatterson.animationtalk.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

/**
 * Created by michael on 9/20/16.
 */
public class CustomPropertyActivity extends BaseActivity {
    private static final String HEADER_TEXT = "Animating Custom Properties";

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_custom_property;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        TextView view = (TextView) findViewById(R.id.header);

        Animator animator = ObjectAnimator.ofInt(view, STRING_LENGTH, 0, HEADER_TEXT.length());
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());

        Animator bounceAnimator = ObjectAnimator.ofInt(view, STRING_LENGTH, 0, HEADER_TEXT.length());
        bounceAnimator.setDuration(3000);
        bounceAnimator.setInterpolator(new BounceInterpolator());

        Queue<Phase> phases = new ArrayDeque<>();
        phases.add(new Phase(animator, false, this));
        phases.add(new Phase(bounceAnimator, false, this));
        return phases;
    }

    @Override
    protected Class getNextActivityClass() {
        return QuestionsActivity.class;
    }

    public static final Property<TextView, Integer> STRING_LENGTH =
            new Property<TextView, Integer>(Integer.class, "stringLength") {

                @Override
                public Integer get(TextView textView) {
                    return textView.getText().length();
                }

                @Override
                public void set(TextView object, Integer value) {
                    object.setText(HEADER_TEXT.substring(0, value));
                }
            };
}
