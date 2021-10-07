package com.example.seriousnewsapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotesmvvmcoroutines.utils.NetworkUtils
import com.example.seriousnewsapp.api.NewsService
import com.example.seriousnewsapp.model.News

class NewsRepository(private val newsService: NewsService,private val applicationContext: Context)
{
    //for the get every thing by topic
    private val newsLiveData=MutableLiveData<News>()
    public val news:LiveData<News>
        get()=newsLiveData

    //for the get headlines by country
    private val headlinesLiveData=MutableLiveData<News>()
    public val headlines:LiveData<News>
        get()=headlinesLiveData



    suspend fun getEveryThingByTopic(page:Int,q:String)
    {
        if(NetworkUtils.isInternetAvailable(applicationContext))
        {
            val result=newsService.getEveryTopic(q,page)
            if(result?.body()!=null)
            {
                //TODO: add the data in the database
                newsLiveData.postValue(result.body())
            }
        }
        else
        {
            //TODO: get the data from the database and display it
        }
    }

    suspend fun getHeadlinesCountry(country:String)
    {
        if(NetworkUtils.isInternetAvailable(applicationContext))
        {
            val result=newsService.getHeadlinesCountry(country)
            if(result?.body()!=null)
            {
                //TODO: add the data in the database
                headlinesLiveData.postValue(result.body())
            }
        }
        else
        {
            //TODO: get the data from the database and display it
        }
    }


}