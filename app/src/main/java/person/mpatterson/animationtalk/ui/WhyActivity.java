package person.mpatterson.animationtalk.ui;

import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

/**
 * Created by michael on 9/11/16.
 */
public class WhyActivity extends BaseActivity {
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_why;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        return null;
    }

    @Override
    protected Class getNextActivityClass() {
        return PrinciplesActivity.class;
    }
}
