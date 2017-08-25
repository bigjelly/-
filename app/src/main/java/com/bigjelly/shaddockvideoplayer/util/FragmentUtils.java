package com.bigjelly.shaddockvideoplayer.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.bigjelly.shaddockvideoplayer.R;
import com.bigjelly.shaddockvideoplayer.view.base.BaseFragment;

import java.util.List;

/**
 *fragment管理类
 **/
public class FragmentUtils {

    public static void replace(FragmentManager manager, int containerId, Fragment fragment, boolean addBackStack, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        if (addBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.replace(containerId, fragment, tag).commitAllowingStateLoss();
    }

    public static void add(FragmentManager manager, int containerId, Fragment fragment, boolean addBackStack, String tag) {
        FragmentTransaction transaction = manager.beginTransaction();
        if (addBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.add(containerId, fragment, tag).commitAllowingStateLoss();
    }

    public static void addMultiple(FragmentManager manager, int containerId, int showPosition, BaseFragment... fragments) {
        FragmentTransaction transaction = manager.beginTransaction();
        for (int i = 0; i < fragments.length; i++) {
            String tag = fragments[i].getClass().getName();
            transaction.add(containerId, fragments[i], tag);
            if (showPosition != i) {
                transaction.hide(fragments[i]);
            }
            fragments[i].setUserVisibleHint(!fragments[i].isHidden());
        }
        transaction.commit();
    }

    public static void showHideFragment(FragmentManager manager, Fragment show, Fragment hide, boolean animation, boolean backStack) {
        FragmentTransaction transaction = manager.beginTransaction();
        if (animation) {
            transaction.setCustomAnimations(
                    R.anim .fragment_translate_in, R.anim.fragment_translate_out
            ,R.anim.fragment_pop_in,R.anim.fragment_pop_out);
        }
        transaction.show(show);
        if (hide == null) {
            List<Fragment> fragments = manager.getFragments();
            if (fragments != null) {
                for (Fragment fragment : fragments) {
                    if (fragment != show) {
                        transaction.hide(fragment);
                    }
                }
            }
        } else {
            transaction.hide(hide);
        }
        if (backStack) {
            transaction.addToBackStack("showHideFragment");
        }
        transaction.commit();
    }

    public static <T extends BaseFragment> T findFragment(FragmentManager manager, Class<T> tClass) {

        if (manager.getFragments() == null) {
            return null;
        }
        return (T) manager.findFragmentByTag(tClass.getName());
    }
}
