package person.mpatterson.animationtalk.ui;

import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

/**
 * Created by michael on 9/17/16.
 */
public class MissingFrameActivity extends BaseActivity {
    // TODO make a custom janky animation
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_missing_frame;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        return null;
    }

    @Override
    protected Class getNextActivityClass() {
        return PurposefulNaturalActivity.class;
    }
}
