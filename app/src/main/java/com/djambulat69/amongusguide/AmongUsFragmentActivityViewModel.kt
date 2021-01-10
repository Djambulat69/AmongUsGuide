package com.djambulat69.amongusguide

import androidx.lifecycle.ViewModel

class AmongUsFragmentActivityViewModel: ViewModel() {

    private val repository = MyRepository
    val crewmateTipsList = repository.crewmateTips
    val impostorTipsList = repository.impostorTips

}