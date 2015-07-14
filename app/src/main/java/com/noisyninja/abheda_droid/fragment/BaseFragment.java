package com.noisyninja.abheda_droid.fragment;

import android.support.v4.app.Fragment;

import com.noisyninja.abheda_droid.util.ReviewUtil;

/**
 * Created by ir2pi on 7/10/2015.
 */
public class BaseFragment extends Fragment {

    public BaseFragment(){
        ReviewUtil.init();
    }
}
