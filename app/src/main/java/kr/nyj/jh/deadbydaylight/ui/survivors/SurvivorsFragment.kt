package kr.nyj.jh.deadbydaylight.ui.survivors

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.observers.DisposableObserver
import kr.nyj.jh.deadbydaylight.adapter.RecyclerCommonAdapter
import kr.nyj.jh.deadbydaylight.databinding.FragmentSurvivorsBinding
import kr.nyj.jh.deadbydaylight.model.Survivors
import kr.nyj.jh.deadbydaylight.repository.DbdRepo

class SurvivorsFragment : Fragment() {

    private var _binding: FragmentSurvivorsBinding? = null
    private val binding get() = _binding!!

    // todo > placed ViewModel
    private val repo: DbdRepo = DbdRepo()

    private val list = ArrayList<Survivors>()
    private val recyclerAdapter = RecyclerCommonAdapter(list)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val survivorsViewModel =
            ViewModelProvider(this)[SurvivorsViewModel::class.java]

        _binding = FragmentSurvivorsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        survivorsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.recyclerSurvivor.layoutManager = LinearLayoutManager(context)
        binding.recyclerSurvivor.adapter = recyclerAdapter

        //call Retrofit
        //get Survivors Information of Dead by Daylight
        getSurvivors()

        return root
    }

    private fun getSurvivors() {
        repo.getSurvivors()
            .subscribeWith(object: DisposableObserver<ArrayList<Survivors>>() {
                override fun onNext(t: ArrayList<Survivors>) {
                    //var text = ""
                    var index = 0
                    for(i in t) {
                        Log.w("DEBUG", "name: ${i.name}")
                        //text += i.name

                        list.add(i)

                        recyclerAdapter.notifyItemChanged(index)
                        index++
                    }

                    //binding.textDashboard.text = text
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                    binding.progressBar.visibility = View.GONE
                }

                override fun onComplete() {
                    Log.w("DEBUG", "getSurvivors onComplete()")
                    binding.progressBar.visibility = View.GONE
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}