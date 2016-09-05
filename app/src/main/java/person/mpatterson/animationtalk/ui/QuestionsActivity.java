package person.mpatterson.animationtalk.ui;

import person.mpatterson.animationtalk.R;
import person.mpatterson.animationtalk.helper.BaseActivity;

/**
 * Created by michael on 9/5/16.
 */
public class QuestionsActivity extends BaseActivity {
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_questions;
    }

    @Override
    protected Class getNextActivityClass() {
        return null;
    }
}
