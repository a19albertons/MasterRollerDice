package com.example.masterrollerdice

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InflarFragmentos {

    @Test
    fun inicioInflar() {
        val scenario = launchFragmentInContainer<Inicio>()
        scenario.onFragment { fragment ->
            assert(fragment.view != null)
        }
    }

    @Test
    fun inflarHistorial() {
        val scenario = launchFragmentInContainer<Historial>()
        scenario.onFragment { fragment ->
            assert(fragment.view != null)
        }
    }
}