package andrei.profir.pomodoro.activities;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import andrei.profir.pomodoro.R;

/**
 * Created by Admin on 23.05.2016.
 */
public class SettingsActivity extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}
