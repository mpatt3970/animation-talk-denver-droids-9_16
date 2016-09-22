package person.mpatterson.animationtalk.ui;

import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

/**
 * Created by michael on 9/17/16.
 */
public class PurposefulNaturalActivity extends BaseActivity {
    @Override
    protected int getLayoutResourceId() {
        // TODO: include why you shouldn't animate everything
        return R.layout.activity_purposeful_natural;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        return null;
    }

    @Override
    protected Class getNextActivityClass() {
        return ShortActivity.class;
    }
}
