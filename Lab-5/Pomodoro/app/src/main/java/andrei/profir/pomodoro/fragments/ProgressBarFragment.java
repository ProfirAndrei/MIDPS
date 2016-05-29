package andrei.profir.pomodoro.fragments;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import andrei.profir.pomodoro.R;

public class ProgressBarFragment extends Fragment implements ImageButton.OnClickListener {
    private View mView;
    private ProgressBar mProgressBar;
    private ImageButton mImageButton;
    private TextView mTextViewProgress;
    private TextView mTextViewState;

    private ObjectAnimator mObjectAnimator;
    private boolean mIsAnimationCanceled = false;

    private ProgressTimer mTimer;

    private int mColorId = R.color.backgroundColor;
    public static String BUTTON_IS_SELECTED_KEY = "button_is_selected_key";

    private enum State {
        STOPPED, WORK, BREAK, LONG_BREAK
    }
    private State mState = State.STOPPED;

    private long mWorkMillis;
    private long mBreakMillis;
    private long mLongBreakMillis;
    private int mWorkSessions;
    private boolean mIsContinuousMode;
    private AlertDialog.Builder mAlertDialog;
    private boolean mIsShowAlert = false;

    private static final int NOTIFY_ID = 123654;
    private NotificationManager mNotificationManager;

    private SharedPreferences mSp;
    private String mWorkRingtone;
    private String mBreakRingtone;
    private String mLongBreakRingtone;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_progress_bar, container, false);

        mTextViewProgress = (TextView) mView.findViewById(R.id.viewProgress);
        mTextViewState = (TextView) mView.findViewById(R.id.stateText);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/micra-bold.ttf");
        mTextViewState.setTypeface(typeface);
        mTextViewProgress.setTypeface(typeface);
        mTextViewState.setText(R.string.text_state_stopped);
        mProgressBar = (ProgressBar) mView.findViewById(R.id.progressBar);
        mImageButton = (ImageButton) mView.findViewById(R.id.imageButton);

        mImageButton.setOnClickListener(this);

        initTimeValues();

        mProgressBar.setRotation(-90f);
        mProgressBar.setMax((int) mWorkMillis);
        mProgressBar.setProgress(0);

        long hours = TimeUnit.MILLISECONDS.toHours(mWorkMillis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(mWorkMillis -
                TimeUnit.HOURS.toMillis(hours));
        long seconds = TimeUnit.MILLISECONDS.toSeconds(mWorkMillis -
                TimeUnit.HOURS.toMillis(hours) - TimeUnit.MINUTES.toMillis(minutes));

        mTextViewProgress.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));

        return mView;
    }

    private void initTimeValues() {
        mSp = PreferenceManager.getDefaultSharedPreferences(getContext());

        mWorkMillis = TimeUnit.HOURS.toMillis(mSp.getInt("work_h", 0)) +
                TimeUnit.MINUTES.toMillis(mSp.getInt("work_m", 25)) +
                TimeUnit.SECONDS.toMillis(mSp.getInt("work_s", 0));
        mBreakMillis = TimeUnit.HOURS.toMillis(mSp.getInt("break_h", 0)) +
                TimeUnit.MINUTES.toMillis(mSp.getInt("break_m", 5)) +
                TimeUnit.SECONDS.toMillis(mSp.getInt("break_s", 0));
        mLongBreakMillis = TimeUnit.HOURS.toMillis(mSp.getInt("long_break_h", 0)) +
                TimeUnit.MINUTES.toMillis(mSp.getInt("long_break_m", 15)) +
                TimeUnit.SECONDS.toMillis(mSp.getInt("long_break_s", 0));
        mWorkSessions = mSp.getInt("work_sessions", 4);
        mIsContinuousMode = mSp.getBoolean("continuous_mode", true);
        String defaultRingtone = RingtoneManager.
                getActualDefaultRingtoneUri(getContext(), 7).toString();
        mWorkRingtone = mSp.getString("work_notification", defaultRingtone);
        if (mWorkRingtone.equals(""))
            mWorkRingtone = RingtoneManager.
                    getActualDefaultRingtoneUri(getContext(), 7).toString();

        mBreakRingtone = mSp.getString("break_notification", defaultRingtone);
        if (mBreakRingtone.equals(""))
            mBreakRingtone = RingtoneManager.
                    getActualDefaultRingtoneUri(getContext(), 7).toString();

        mLongBreakRingtone = mSp.getString("long_break_notification", defaultRingtone);
        if (mLongBreakRingtone.equals(""))
            mLongBreakRingtone = RingtoneManager.
                    getActualDefaultRingtoneUri(getContext(), 7).toString();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mState == State.STOPPED) {
            initTimeValues();
            long hours = TimeUnit.MILLISECONDS.toHours(mWorkMillis);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(mWorkMillis -
                    TimeUnit.HOURS.toMillis(hours));
            long seconds = TimeUnit.MILLISECONDS.toSeconds(mWorkMillis -
                    TimeUnit.HOURS.toMillis(hours) - TimeUnit.MINUTES.toMillis(minutes));

            mTextViewProgress.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        }
    }

    public void playRingtone() {
        String ringtone = "";
        switch (mState) {
            case WORK:
                ringtone = mWorkRingtone;
                break;
            case BREAK:
                ringtone = mBreakRingtone;
                break;
            case LONG_BREAK:
                ringtone = mLongBreakRingtone;
                break;
        }
        final MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(getContext(), Uri.parse(ringtone));
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.stop();
                    mp.release();
                }
            });
        } catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    public void onClick(View view) {
        RelativeLayout relativeLayout = (RelativeLayout)
                mView.getRootView().findViewById(R.id.container);

        if (mImageButton.isSelected()) {
            mImageButton.setSelected(false);

            mColorId = R.color.backgroundColor;
            relativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), mColorId));


            mObjectAnimator.cancel();
            mObjectAnimator = ObjectAnimator.ofInt(mProgressBar, "progress",
                    (int) mObjectAnimator.getAnimatedValue(), 0);

            mObjectAnimator.setInterpolator(new LinearInterpolator());
            mObjectAnimator.setDuration(1000);
            mObjectAnimator.start();

            mTimer.cancel();

            mState = State.STOPPED;

            mTextViewState.setText(R.string.text_state_stopped);

            initTimeValues();

            if (mNotificationManager != null)
                mNotificationManager.cancel(NOTIFY_ID);

            long hours = TimeUnit.MILLISECONDS.toHours(mWorkMillis);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(mWorkMillis -
                    TimeUnit.HOURS.toMillis(hours));
            long seconds = TimeUnit.MILLISECONDS.toSeconds(mWorkMillis -
                    TimeUnit.HOURS.toMillis(hours) - TimeUnit.MINUTES.toMillis(minutes));

            mTextViewProgress.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        }
        else {
            mImageButton.setSelected(true);

            mColorId = R.color.backgroundColorWork;
            relativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), mColorId));

            mState = State.WORK;

            startTimer();
            startAnimation();
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState == null)
            return;
        //restore background color
        RelativeLayout relativeLayout = (RelativeLayout)
                mView.getRootView().findViewById(R.id.container);
        relativeLayout.setBackgroundColor(ContextCompat.
                getColor(getContext(), mColorId));

        //restore Image Button state
        mImageButton.setSelected(savedInstanceState.getBoolean(BUTTON_IS_SELECTED_KEY));

        //restore Animation state
        if (!(mState == State.STOPPED))
            startAnimation();

        switch (mState) {
            case WORK:
                mTextViewState.setText(R.string.text_state_work);
                break;
            case BREAK:
                mTextViewState.setText(R.string.text_state_break);
                break;
            case LONG_BREAK:
                mTextViewState.setText(R.string.text_state_long_break);
                break;
            default:
                mTextViewState.setText(R.string.text_state_stopped);
                break;
        }

        if (mIsShowAlert)
            mAlertDialog.show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(BUTTON_IS_SELECTED_KEY, mImageButton.isSelected());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        setRetainInstance(true);
    }

    private void startTimer() {
        long duration = mWorkMillis;
        mTextViewState.setText(R.string.text_state_work);

        if (mState == State.BREAK) {
            duration = mBreakMillis;
            mTextViewState.setText(R.string.text_state_break);
        }
        if (mState == State.LONG_BREAK) {
            duration = mLongBreakMillis;
            mTextViewState.setText(R.string.text_state_long_break);
        }

        mTimer = new ProgressTimer(duration, 1000);
        mTimer.setRoot(this);
        mTimer.start();
    }

    private void changeState() {
        if (mState == State.WORK) {
            if (mWorkSessions < 1) {
                //reset workSessions
                mWorkSessions = 2;
                mColorId = R.color.backgroundColorLongBreak;
                mState = State.LONG_BREAK;
            } else {
                mColorId = R.color.backgroundColorBreak;
                mState = State.BREAK;
            }
        }
        else {
            mColorId = R.color.backgroundColorWork;
            mState = State.WORK;
        }
        RelativeLayout relativeLayout = (RelativeLayout)
                mView.getRootView().findViewById(R.id.container);
        relativeLayout.setBackgroundColor(ContextCompat.getColor(getContext(), mColorId));
    }

    private void startAnimation() {
        if (mObjectAnimator != null)
            mObjectAnimator.cancel();
        if (mTimer == null)
            return;
        switch (mState) {
            case BREAK:
                mProgressBar.setMax((int) mBreakMillis);
                break;
            case LONG_BREAK:
                mProgressBar.setMax((int) mLongBreakMillis);
                break;
            default:
                mProgressBar.setMax((int) mWorkMillis);
                break;
        }
        mObjectAnimator = ObjectAnimator.ofInt(mProgressBar, "progress",
                0, (int) mTimer.getMillis());
        mObjectAnimator.setInterpolator(new LinearInterpolator());
        mObjectAnimator.setDuration(1000);

        mObjectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                mIsAnimationCanceled = false;
            }
            @Override
            public void onAnimationEnd(Animator animator) {
                if (mIsAnimationCanceled)
                    return;
                if (mObjectAnimator.isRunning())
                    mObjectAnimator.cancel();
                mObjectAnimator = ObjectAnimator.ofInt(mProgressBar, "progress",
                        (int) mTimer.getMillis(), 0);
                mObjectAnimator.setInterpolator(new LinearInterpolator());
                mObjectAnimator.setDuration(mTimer.getMillis());

                mObjectAnimator.start();
            }
            @Override
            public void onAnimationCancel(Animator animator) {
                mIsAnimationCanceled = true;
            }
            @Override
            public void onAnimationRepeat(Animator animator) {}
        });

        mObjectAnimator.start();
    }

    private void initAlertDialog() {
        mAlertDialog = new AlertDialog.Builder(getContext());
        String title;
        switch (mState) {
            case WORK:
                title = getString(R.string.title_work);
                break;
            case BREAK:
                title = getString(R.string.title_break);
                break;
            case LONG_BREAK:
                title = getString(R.string.title_long_break);
                break;
            default:
                title = getString(R.string.title_unknown_state);
                break;
        }
        mAlertDialog.setTitle(title);
        mAlertDialog.setMessage(R.string.alert_dialog_message);
        mAlertDialog.setIcon(R.drawable.ic_alert_dialog);
        mAlertDialog.setCancelable(false);

        mIsShowAlert = true;
    }

    private void showNotification(boolean isDone) {
        String contentTitle = "";
        String contentText = "";

        switch (mState) {
            case WORK:
                contentTitle = getString(R.string.title_work);
                contentText = getString(R.string.text_notification_work);
                break;

            case BREAK:
                contentTitle = getString(R.string.title_break);
                contentText = getString(R.string.text_notification_break);
                break;

            case LONG_BREAK:
                contentTitle = getString(R.string.title_long_break);
                contentText = getString(R.string.text_notification_long_break);
                break;
        }

        if (isDone)
            contentText = getString(R.string.text_notification_done);

        PendingIntent contentIntent = PendingIntent.getActivity(getContext(),
                0, getActivity().getIntent(),
                PendingIntent.FLAG_CANCEL_CURRENT);


        Resources res = getContext().getResources();
        Notification.Builder builder = new Notification.Builder(getContext());

        builder.setContentIntent(contentIntent)
                .setSmallIcon(R.drawable.ic_notification_small)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.icon_notification_large))
                .setTicker("Pomodoro notification")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle(contentTitle)
                .setContentText(contentText);

        Notification notification = builder.build();

        mNotificationManager = (NotificationManager) getContext().
                getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFY_ID, notification);
    }

    private static class ProgressTimer extends CountDownTimer {
        private long mHours;
        private long mMinutes;
        private long mSeconds;
        private long mMillis;
        private ProgressBarFragment mRoot;

        public ProgressTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

            mMillis = millisInFuture;
            parseTime();
        }

        public void setRoot(ProgressBarFragment root) {
            mRoot = root;
        }

        @Override
        public void onTick(long l) {
            mMillis = l;
            parseTime();
            String hms = String.format("%02d:%02d:%02d", mHours, mMinutes, mSeconds);
            mRoot.mTextViewProgress.setText(hms);
        }

        @Override
        public void onFinish() {
            mRoot.mTextViewProgress.setText("00:00:00");

            mRoot.showNotification(true);

            if (mRoot.mState == State.WORK)
                mRoot.mWorkSessions--;

            mRoot.changeState();

            mRoot.playRingtone();

            if (!mRoot.mIsContinuousMode) {
                mRoot.initAlertDialog();
                mRoot.mAlertDialog.setPositiveButton(R.string.alert_dialog_button_positive,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mRoot.startTimer();
                                mRoot.startAnimation();

                                mRoot.mIsShowAlert = false;

                                mRoot.showNotification(false);
                            }
                        });
                mRoot.mAlertDialog.setNegativeButton(R.string.alert_dialog_button_negative,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mRoot.mImageButton.callOnClick();

                                mRoot.mIsShowAlert = false;
                            }
                        });

                mRoot.mAlertDialog.show();
            }

            else {
                mRoot.showNotification(false);

                mRoot.startTimer();
                mRoot.startAnimation();
            }
        }

        private void parseTime() {
            mHours = TimeUnit.MILLISECONDS.toHours(mMillis);
            mMinutes = TimeUnit.MILLISECONDS.toMinutes(mMillis -
                    TimeUnit.HOURS.toMillis(mHours));
            mSeconds = TimeUnit.MILLISECONDS.toSeconds(mMillis -
                    TimeUnit.HOURS.toMillis(mHours) - TimeUnit.MINUTES.toMillis(mMinutes));
        }

        public long getMillis() {
            return mMillis;
        }
    }
}
