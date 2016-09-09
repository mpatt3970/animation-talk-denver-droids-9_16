/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package person.mpatterson.animationtalk.helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.List;
import java.util.Queue;

public abstract class BaseActivity extends Activity implements Phase.PhaseListener {

    private Queue<Phase> phases;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        phases = buildPhases();
    }

    protected abstract int getLayoutResourceId();

    protected abstract Queue<Phase> buildPhases();

    // maybe this should return an Intent??
    protected abstract Class getNextActivityClass();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_DPAD_CENTER) {
            if (phases != null && phases.size() > 0) {
                Phase phase = phases.poll();
                phase.start();
                return true;
            }
            Class clazz = getNextActivityClass();
            if (clazz != null) {
                Intent intent = new Intent(this, clazz);
                startActivity(intent);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onAnimationEnded() {
        if (phases != null && phases.size() > 0) {
            Phase phase = phases.peek();
            if (phase.isAutoplay()) {
                phases.remove();
                phase.start();
            }
        }
    }

    // TODO
//    protected abstract Transition getTransition();
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        return super.onKeyDown(keyCode, event);
//    }
}
