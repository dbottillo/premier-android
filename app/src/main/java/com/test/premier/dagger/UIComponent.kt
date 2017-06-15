package com.test.premier.dagger

import com.test.premier.ui.MainActivity
import dagger.Component

@UIScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(PresenterModule::class))
interface UIComponent {

    fun inject(activity: MainActivity)

}
