package com.bulich.misha.workwithremotedb.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bulich.misha.workwithremotedb.R
import com.bulich.misha.workwithremotedb.databinding.FilmsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class Films : Fragment() {

    private var binding: FilmsBinding? = null
    private var filmAdapter: FilmAdapter? = null
    private val filmsViewModel: FilmsViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.films, container, false)

        initRecyclerFilms()

        loadFilms()

        return binding?.root
    }

    private fun loadFilms() {
        filmsViewModel.loadFilms.observe(viewLifecycleOwner, Observer {
            filmAdapter?.setList(it)
            filmAdapter?.notifyDataSetChanged()
        })
    }


    private fun initRecyclerFilms() {
        binding?.recyclerFilms?.layoutManager = LinearLayoutManager(context)
        filmAdapter = FilmAdapter()
        binding?.recyclerFilms?.adapter = filmAdapter
    }
}