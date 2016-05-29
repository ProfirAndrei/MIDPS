package andrei.profir.pomodoro;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.util.AttributeSet;

public class NotificationRingtonePreference extends RingtonePreference {

    public NotificationRingtonePreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);

        String ringtone = sp.getString(getKey(), "");
        Uri uri;
        if (ringtone.equals("")) {
            uri = RingtoneManager.getActualDefaultRingtoneUri(context, 7);
        }
        else {
            uri = Uri.parse(ringtone);
        }

        Ringtone ring = RingtoneManager.getRingtone(context, uri);
        if (ring.getTitle(context).equals("Unknown ringtone"))
            setSummary("Silent");
        else
            setSummary(ring.getTitle(context));
    }

    @Override
    protected void onSaveRingtone(Uri ringtoneUri) {
        super.onSaveRingtone(ringtoneUri);

        Ringtone ring = RingtoneManager.getRingtone(getContext(), ringtoneUri);
        if (ring.getTitle(getContext()).equals("Unknown ringtone"))
            setSummary("Silent");
        else
            setSummary(ring.getTitle(getContext()));
    }
}