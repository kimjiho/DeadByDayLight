package kr.nyj.jh.deadbydaylight.ui.killers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import io.reactivex.rxjava3.observers.DisposableObserver
import kr.nyj.jh.deadbydaylight.adapter.RecyclerKillersAdapter
import kr.nyj.jh.deadbydaylight.databinding.FragmentKillersBinding
import kr.nyj.jh.deadbydaylight.model.Killers
import kr.nyj.jh.deadbydaylight.repository.DbdRepo

class KillersFragment : Fragment() {

    private var _binding: FragmentKillersBinding? = null
    private val binding get() = _binding!!

    private val repo: DbdRepo = DbdRepo()

    private val list = ArrayList<Killers>()
    private val recyclerAdapter = RecyclerKillersAdapter(list)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(KillersViewModel::class.java)

        _binding = FragmentKillersBinding.inflate(inflater, container, false)


        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.recyclerKillers.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerKillers.adapter = recyclerAdapter

        getKillers()

        return root
    }

    private fun getKillers() {
        repo.getKillers()
            .subscribeWith(object: DisposableObserver<ArrayList<Killers>>() {
                override fun onNext(t: ArrayList<Killers>) {
                    var text = ""
                    var index = 0
                    for(i in t) {
                        Log.w("DEBUG", "name: ${i.name}")

                        text += i.name

                        list.add(i)

                        recyclerAdapter.notifyItemChanged(index)
                        index++
                    }

                    //binding.textHome.text = text
                }

                override fun onError(e: Throwable) {
                    binding.progressBar.visibility = View.GONE
                    e.printStackTrace()
                }

                override fun onComplete() {
                    binding.progressBar.visibility = View.GONE
                    Log.w("DEBUG", "getKillers onComplete()")
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}