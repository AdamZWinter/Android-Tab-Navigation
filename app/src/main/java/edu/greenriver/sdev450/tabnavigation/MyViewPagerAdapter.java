package edu.greenriver.sdev450.tabnavigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabLayout;

public class MyViewPagerAdapter extends FragmentStateAdapter {

    public static final int TAB_COUNT = 3;
    FragmentActivity mainActivity;

    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        mainActivity = fragmentActivity;  //this might cause a memory leak
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new HomeFragment();
            case 1:
                return new SettingsFragment();
            case 2:
                return new NotificationsFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        //return the number of tabs

        TabLayout tabLayout = mainActivity.findViewById(R.id.tab_layout);
        return tabLayout.getTabCount();

        //return TAB_COUNT;
    }
}
