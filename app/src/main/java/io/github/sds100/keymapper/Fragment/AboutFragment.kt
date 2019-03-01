package io.github.sds100.keymapper.fragment

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import io.github.sds100.keymapper.Constants
import io.github.sds100.keymapper.R

/**
 * Created by sds100 on 10/12/2018.
 */

class AboutFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.about)

        findPreference(getString(R.string.key_pref_version)).summary = Constants.VERSION
    }
}