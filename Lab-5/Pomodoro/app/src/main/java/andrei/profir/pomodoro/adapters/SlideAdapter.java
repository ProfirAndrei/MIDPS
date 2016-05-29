package andrei.profir.pomodoro.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class SlideAdapter extends FragmentPagerAdapter {
    List<Fragment> mListFragments;

    public SlideAdapter(FragmentManager fm, List<Fragment> listFragments) {
        super(fm);

        mListFragments = listFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mListFragments.get(position);
    }

    @Override
    public int getCount() {
        return mListFragments.size();
    }
}
