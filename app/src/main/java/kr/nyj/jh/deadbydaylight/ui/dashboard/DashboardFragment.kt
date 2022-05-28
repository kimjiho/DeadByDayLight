package kr.nyj.jh.deadbydaylight.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.reactivex.rxjava3.observers.DisposableObserver
import kr.nyj.jh.deadbydaylight.databinding.FragmentDashboardBinding
import kr.nyj.jh.deadbydaylight.model.Survivors
import kr.nyj.jh.deadbydaylight.repository.DbdRepo

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        //start
        getSurvivors()

        return root
    }

    private val repo: DbdRepo = DbdRepo()
    private fun getSurvivors() {
        repo.getSurvivors()
            .subscribeWith(object: DisposableObserver<ArrayList<Survivors>>() {
                override fun onNext(t: ArrayList<Survivors>) {
                    for(i in t) {
                        Log.w("DEBUG", "name: ${i.name}")
                    }
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

                override fun onComplete() {
                    Log.w("DEBUG", "getSurvivors onComplete()")
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}