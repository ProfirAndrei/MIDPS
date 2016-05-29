package andrei.profir.pomodoro.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

import andrei.profir.pomodoro.R;
import andrei.profir.pomodoro.adapters.SlideAdapter;
import andrei.profir.pomodoro.fragments.ListItemsFragment;
import andrei.profir.pomodoro.fragments.ProgressBarFragment;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener,
        TabHost.OnTabChangeListener {

    private ViewPager mViewPager;
    private TabHost mTabHost;
    public  static int CURRENT_ITEM = 0;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = View.inflate(getApplicationContext(), R.layout.activity_main, null);

        initViewPager();
        initTabHost();

        mTabHost.setCurrentTab(CURRENT_ITEM);
    }

    private void initTabHost() {
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        TabHost.TabSpec tabSpec;

        tabSpec = mTabHost.newTabSpec("tab1");
        tabSpec.setContent(new FakeContent(getApplicationContext()));
        tabSpec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_timer, null));
        mTabHost.addTab(tabSpec);

        tabSpec = mTabHost.newTabSpec("tab2");
        tabSpec.setContent(new FakeContent(getApplicationContext()));
        tabSpec.setIndicator("", getResources().getDrawable(R.drawable.ic_tab_settings, null));
        mTabHost.addTab(tabSpec);

        mTabHost.setOnTabChangedListener(this);
    }

    public class FakeContent implements TabHost.TabContentFactory {
        Context mContext;

        public FakeContent(Context context) {
            mContext = context;
        }

        @Override
        public View createTabContent(String s) {
            View fakeView = new View(mContext);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }

    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        List<Fragment> listFragments = new ArrayList<>();
        listFragments.add(new ProgressBarFragment());
        listFragments.add(new ListItemsFragment());

        SlideAdapter myAdapter = new SlideAdapter(getSupportFragmentManager(), listFragments);

        mViewPager.setAdapter(myAdapter);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mTabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabChanged(String s) {
        int selectedPage = mTabHost.getCurrentTab();
        mViewPager.setCurrentItem(selectedPage);

        HorizontalScrollView horizontalScrollView =
                (HorizontalScrollView) findViewById(R.id.h_scroll_view);
        View tabView = mTabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft() - (horizontalScrollView.getWidth() -
                tabView.getWidth()) / 2;
        horizontalScrollView.smoothScrollTo(scrollPos, 0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        /*outState.putInt(COLOR_BACKGROUND, mView.getSolidColor());
        Log.i("++++++++++++++", "" + mView.getSolidColor());*/
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        /*mView.setBackgroundColor(savedInstanceState.getInt(COLOR_BACKGROUND));
        Log.i("++++++++++++++000000", "" + mView.getSolidColor());*/
    }
}
