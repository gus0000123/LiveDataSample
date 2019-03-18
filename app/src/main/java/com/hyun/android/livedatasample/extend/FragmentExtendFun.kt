package com.android.ysmg.adm.util.extend

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

fun replaceFragment(activity: FragmentActivity, @IdRes R_id: Int, fragment: Fragment) {
    activity.supportFragmentManager
            .beginTransaction()
            .replace(R_id, fragment)
            ?.commitAllowingStateLoss()
}

fun getTopFragments(fm: FragmentManager) = fm.fragments.last()
