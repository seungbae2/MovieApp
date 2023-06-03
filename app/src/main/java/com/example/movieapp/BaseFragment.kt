package com.example.movieapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.movieapp.features.common.viewmodel.ThemeViewModel

open class BaseFragment : Fragment() {
    protected val themeViewModel: ThemeViewModel by activityViewModels()
}