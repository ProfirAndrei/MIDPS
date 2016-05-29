package andrei.profir.pomodoro.dialogs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import andrei.profir.pomodoro.R;

public class TimerPickerDialog extends DialogPreference {
    private View mView;
    private int mHours = 0;
    private int mMinutes = 0;
    private int mSeconds = 0;
    private SharedPreferences sharedPreferences;

    public TimerPickerDialog(Context context) {
        this(context, null, 0);
    }

    public TimerPickerDialog(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimerPickerDialog(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setDialogLayoutResource(R.layout.dialog_timer_picker);
        setPositiveButtonText(R.string.ok);
        setNegativeButtonText(R.string.cancel);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        int defHours = 0;
        int defMinutes = 0;
        int defSeconds = 0;

        switch (getKey()) {
            case "work":
                defHours = 0;
                defMinutes = 25;
                defSeconds = 0;
                break;
            case "break":
                defHours = 0;
                defMinutes = 5;
                defSeconds = 0;
                break;
            case "long_break":
                defHours = 0;
                defMinutes = 15;
                defSeconds = 0;
                break;
        }

        mHours = sharedPreferences.getInt(getKey().concat("_h"), defHours);
        mMinutes = sharedPreferences.getInt(getKey().concat("_m"), defMinutes);
        mSeconds = sharedPreferences.getInt(getKey().concat("_s"), defSeconds);

        String title = "" + getTitle();
        setDialogTitle("Set " + title.toLowerCase());
        setSummary(getTextSummary());

        mView = View.inflate(getContext(), R.layout.dialog_timer_picker, null);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        ((TextView) view.findViewById(android.R.id.title)).setTextSize(15);
    }

    @Override
    protected View onCreateDialogView() {
        mView = View.inflate(getContext(), R.layout.dialog_timer_picker, null);

        NumberPicker numberPicker = (NumberPicker) mView.findViewById(R.id.hours);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(23);
        numberPicker.setValue(mHours);

        numberPicker = (NumberPicker) mView.findViewById(R.id.minutes);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(59);
        numberPicker.setValue(mMinutes);

        numberPicker = (NumberPicker) mView.findViewById(R.id.seconds);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(59);
        numberPicker.setValue(mSeconds);

        return mView;
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        if (positiveResult) {
            SharedPreferences.Editor editor = sharedPreferences.edit();

            NumberPicker np = (NumberPicker) mView.findViewById(R.id.hours);
            mHours = np.getValue();
            np = (NumberPicker) mView.findViewById(R.id.minutes);
            mMinutes = np.getValue();
            np = (NumberPicker) mView.findViewById(R.id.seconds);
            mSeconds = np.getValue();

            if (mHours == 0 && mMinutes == 0 && mSeconds == 0)
                mSeconds = 1;

            editor.putInt(getKey().concat("_h"), mHours);
            editor.putInt(getKey().concat("_m"), mMinutes);
            editor.putInt(getKey().concat("_s"), mSeconds);


            editor.apply();

            setSummary(getTextSummary());
        }
    }

    public String getTextSummary() {
        String text;
        if (mHours < 10)
            text = "0" + mHours;
        else
            text = "" + mHours;
        if (mMinutes < 10)
            text += ":0" + mMinutes;
        else
            text += ":" + mMinutes;
        if (mSeconds < 10)
            text += ":0" + mSeconds;
        else
            text += ":" + mSeconds;
        return text;
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        final Parcelable superState = super.onSaveInstanceState();

        final SavedState myState = new SavedState(superState);

        int[] val = new int[3];
        val[0] = ((NumberPicker) mView.findViewById(R.id.hours)).getValue();
        val[1] = ((NumberPicker) mView.findViewById(R.id.minutes)).getValue();
        val[2] = ((NumberPicker) mView.findViewById(R.id.seconds)).getValue();
        myState.values = val;

        return myState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());

        ((NumberPicker) mView.findViewById(R.id.hours)).setValue(myState.values[0]);
        ((NumberPicker) mView.findViewById(R.id.minutes)).setValue(myState.values[1]);
        ((NumberPicker) mView.findViewById(R.id.seconds)).setValue(myState.values[2]);
    }

    private static class SavedState extends BaseSavedState {
        // Member that holds the setting's value
        // Change this data type to match the type saved by your Preference
        int[] values;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public SavedState(Parcel source) {
            super(source);
            // Get the current preference's value
            source.readIntArray(values);  // Change this to read the appropriate data type
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            // Write the preference's value
            dest.writeIntArray(values);  // Change this to write the appropriate data type
        }

        // Standard creator object using an instance of this class
        public static final Parcelable.Creator<SavedState> CREATOR =
                new Parcelable.Creator<SavedState>() {

                    public SavedState createFromParcel(Parcel in) {
                        return new SavedState(in);
                    }

                    public SavedState[] newArray(int size) {
                        return new SavedState[size];
                    }
                };
    }
}
