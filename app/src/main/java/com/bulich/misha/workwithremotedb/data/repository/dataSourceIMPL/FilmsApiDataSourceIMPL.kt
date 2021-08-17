package com.bulich.misha.workwithremotedb.data.repository.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import com.bulich.misha.workwithremotedb.data.api.ApiClient
import com.bulich.misha.workwithremotedb.data.models.FilmsApiModel
import com.bulich.misha.workwithremotedb.data.models.FilmsModel
import com.bulich.misha.workwithremotedb.data.repository.dataSource.FilmsApiDataSource
import com.bulich.misha.workwithremotedb.data.repository.dataSource.FilmsDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsApiDataSourceIMPL(private val filmsDataSource: FilmsDataSource) :
    FilmsApiDataSource {

    override fun startMigration(context: Context) {
        val call = ApiClient.instance?.api?.getFilms()
        call?.enqueue(object : Callback<ArrayList<FilmsApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<FilmsApiModel>>,
                response: Response<ArrayList<FilmsApiModel>>
            ) {

                var loadFilms: ArrayList<FilmsApiModel>? = null
                loadFilms?.clear()
                loadFilms = response.body()!!

                for (audit in loadFilms) {
                    audit.id?.let {
                        FilmsModel(
                            it,
                            audit.name.toString(),
                            audit.image.toString()
                        )
                    }?.let {
                        filmsDataSource.insert(it)
                    }
                }

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<ArrayList<FilmsApiModel>>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_LONG).show()
            }

        })
    }
}