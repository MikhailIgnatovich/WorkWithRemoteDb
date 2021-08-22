package com.bulich.misha.workwithremotedb.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bulich.misha.workwithremotedb.R
import com.bulich.misha.workwithremotedb.data.models.FilmsModel
import com.bulich.misha.workwithremotedb.databinding.FilmItemBinding
import com.squareup.picasso.Picasso

class FilmAdapter : RecyclerView.Adapter<FilmAdapter.FilmHolder>() {

    private val filmsList = ArrayList<FilmsModel>()

    class FilmHolder(val binding: FilmItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind (filmsModel: FilmsModel) {
            val getImage = filmsModel.image
            Picasso.get().load(getImage).into(binding.imageCardFilm)
            binding.idCardFilms.text = filmsModel.id.toString()
            binding.nameCardFilms.text = filmsModel.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: FilmItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.film_item, parent, false)
        return FilmHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        holder.bind(filmsList[position])
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    fun setList(films: List<FilmsModel>) {
        filmsList.clear()
        filmsList.addAll(films)
    }
}