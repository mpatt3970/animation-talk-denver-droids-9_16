package person.mpatterson.animationtalk.ui;

import java.util.Queue;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;
import person.mpatterson.animationtalk.helper.Phase;

/**
 * Created by michael on 9/20/16.
 */
public class AndMoreActivity extends BaseActivity {
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_and_more;
    }

    @Override
    protected Queue<Phase> buildPhases() {
        return null;
    }

    @Override
    protected Class getNextActivityClass() {
        return QuestionsActivity.class;
    }
}
