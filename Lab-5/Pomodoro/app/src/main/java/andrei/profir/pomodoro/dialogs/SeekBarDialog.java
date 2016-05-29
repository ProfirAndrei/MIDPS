package andrei.profir.pomodoro.dialogs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import andrei.profir.pomodoro.R;

public class SeekBarDialog extends DialogPreference {
    private int mSeekValue;
    private View mView;
    private TextView mTextView;

    public SeekBarDialog(Context context, AttributeSet attrs) {
        super(context, attrs);

        setDialogLayoutResource(R.layout.dialog_seek_bar);
        setPositiveButtonText(R.string.ok);
        setNegativeButtonText(R.string.cancel);

        mView = View.inflate(getContext(), R.layout.dialog_seek_bar, null);
        mTextView = (TextView) mView.findViewById(R.id.seekValue);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        mSeekValue = sp.getInt(getKey(), 4);

        setSummary("" + mSeekValue);
    }

    @Override
    protected View onCreateDialogView() {
        mView = View.inflate(getContext(), R.layout.dialog_seek_bar, null);
        mTextView = (TextView) mView.findViewById(R.id.seekValue);


        SeekBar seekBar = (SeekBar) mView.findViewById(R.id.seekBar);
        seekBar.setMax(50);
        seekBar.setProgress(mSeekValue);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextView.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        mTextView.setText("" + mSeekValue);

        return mView;
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        if (positiveResult) {
            mSeekValue = ((SeekBar) mView.findViewById(R.id.seekBar)).getProgress();
            if (mSeekValue == 0)
                mSeekValue = 1;
            persistInt(mSeekValue);

            setSummary("" + mSeekValue);
        }
    }
}
