package com.example.growigh
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedActivity : AppCompatActivity() {
    private lateinit var feedRecyclerView: RecyclerView
    private lateinit var feedAdapter: FeedAdapter
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        apiService = APIclient.getApiService()

        feedRecyclerView = findViewById(R.id.feedRecyclerView)
        feedRecyclerView.layoutManager = LinearLayoutManager(this)
        feedAdapter = FeedAdapter(emptyList())
        feedRecyclerView.adapter = feedAdapter

        fetchImages()
    }

    private fun fetchImages() {
        val call = apiService.getImages()

        call.enqueue(object : Callback<List<FeedItem>> {
            override fun onResponse(call: Call<List<FeedItem>>, response: Response<List<FeedItem>>) {
                if (response.isSuccessful) {
                    val feedItems = response.body()
                    if (feedItems != null) {
                        runOnUiThread {
                            feedAdapter.setData(feedItems)
                        }
                    }
                } else {
                    Toast.makeText(baseContext, " No images found", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<FeedItem>>, t: Throwable) {
                Log.e("FeedActivity", "API call failed: ${t.message}")
            }
        })
    }
}
