package person.mpatterson.animationtalk.helper;

import android.animation.Animator;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

import java.util.List;

/**
 * Created by michael on 9/5/16.
 */
public class Phase {

    public interface PhaseListener {
        void onAnimationEnded();
    }

    private boolean autoplay;
    private Animator animator;
    private List<Animator> animatorList;
    private Animatable2 animatable;
    private PhaseListener listener;

    public Phase(Animator animation, boolean autoplay, PhaseListener listener) {
        this.animator = animation;
        this.autoplay = autoplay;
        this.listener = listener;
        this.animator.addListener(mAnimatorListener);
    }

    public Phase(List<Animator> animatorList, boolean autoplay, PhaseListener listener) {
        this.animatorList = animatorList;
        this.autoplay = autoplay;
        this.listener = listener;
        Animator longestAnim = null;
        for (Animator animator : animatorList) {
            if (longestAnim == null) {
                longestAnim = animator;
            } else if (longestAnim.getDuration() < animator.getDuration()) {
                longestAnim = animator;
            }
        }
        if (longestAnim != null) {
            longestAnim.addListener(mAnimatorListener);
        }
    }

    public Phase(Animatable2 animatable, boolean autoplay, PhaseListener listener) {
        this.animatable = animatable;
        this.autoplay = autoplay;
        this.listener = listener;
        this.animatable.registerAnimationCallback(mAnimatableListener);
    }

    public void start() {
        if (animator != null) {
            animator.start();
        }
        if (animatorList != null) {
            for (Animator animator : animatorList) {
                animator.start();
            }
        }
        if (animatable != null) {
            animatable.start();
        }
    }

    public boolean isAutoplay() {
        return autoplay;
    }

    private Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animator) { }

        @Override
        public void onAnimationEnd(Animator animator) {
            if (listener != null) {
                listener.onAnimationEnded();
            }
        }

        @Override
        public void onAnimationCancel(Animator animator) { }

        @Override
        public void onAnimationRepeat(Animator animator) { }
    };

    private Animatable2.AnimationCallback mAnimatableListener = new Animatable2.AnimationCallback() {
        @Override
        public void onAnimationStart(Drawable drawable) {
            super.onAnimationStart(drawable);
        }

        @Override
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            if (listener != null) {
                listener.onAnimationEnded();
            }
        }
    };
}
