package ru.bsuedu.lec05.basicfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class LifecycleFragment : Fragment() {
    private var value = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.w(TAG, "Fragment - onCreate")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w(TAG, "Fragment - onDestroy")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.w(TAG, "Fragment - onCreateView")
        return inflater.inflate(R.layout.fragment_lifecycle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.w(TAG, "Fragment - onViewCreated")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.w(TAG, "Fragment - onDestroyView")
    }

    override fun onStart() {
        super.onStart()
        Log.w(TAG, "Fragment - onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.w(TAG, "Fragment - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG, "Fragment - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.w(TAG, "Fragment - onPause")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.w(TAG, "Fragment - onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        Log.w(TAG, "Fragment - onDetach")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("AA", value)
        super.onSaveInstanceState(outState)
        Log.w(TAG, "Fragment - onSaveInstanceState $outState")
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        value = savedInstanceState?.getInt("AA", value) ?: 0
        Log.w(TAG, "Fragment - onViewStateRestored $savedInstanceState")
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LifecycleFragment()
    }
}