package kr.nyj.jh.deadbydaylight.ui.perks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.rxjava3.observers.DisposableObserver
import kr.nyj.jh.deadbydaylight.MainActivity
import kr.nyj.jh.deadbydaylight.adapter.RecyclerPerksAdapter
import kr.nyj.jh.deadbydaylight.databinding.FragmentPerksBinding
import kr.nyj.jh.deadbydaylight.model.Perks
import kr.nyj.jh.deadbydaylight.repository.DbdRepo

class PerksFragment : Fragment() {

    private var _binding: FragmentPerksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val repo: DbdRepo = DbdRepo()

    private val list = ArrayList<Perks>()
    private val recyclerAdapter = RecyclerPerksAdapter(list)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val perksViewModel =
            ViewModelProvider(this)[PerksViewModel::class.java]

        _binding = FragmentPerksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerPerks.layoutManager = LinearLayoutManager(context)
        binding.recyclerPerks.adapter = recyclerAdapter

        getPerks()

        return root
    }

    private fun getPerks() {
        (activity as MainActivity).doProgress(true)

        repo.getPerks()
            .subscribeWith(object: DisposableObserver<ArrayList<Perks>>() {
                override fun onNext(t: ArrayList<Perks>) {
                    list.addAll(t)
                    recyclerAdapter.notifyDataSetChanged()
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()

                    if(_binding != null)
                        (activity as MainActivity).doProgress(false)
                }

                override fun onComplete() {
                    Log.w("DEBUG", "getPerks onComplete()")

                    if(_binding != null)
                        (activity as MainActivity).doProgress(false)
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}