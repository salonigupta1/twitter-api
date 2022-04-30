package com.example.databasedemo.controller

import com.example.databasedemo.model.DataModel
import com.example.databasedemo.repository.DataRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.xml.crypto.Data


@RestController
@RequestMapping("twitter")
class DataController(
        val data: DataRepository
) {

    @PostMapping("addTweet")
    fun addTweet(@RequestBody tweet: DataModel): ResponseEntity<DataModel>{
        return ResponseEntity.ok(data.save(tweet))
    }

    @GetMapping("all")
    fun seeAll(): ResponseEntity<MutableIterable<DataModel>> {
        return ResponseEntity.ok(data.findAll())
    }

    @PatchMapping("likeTweet")
    fun likeTweet(@RequestBody tweet: DataModel): ResponseEntity<DataModel> {
        //Fetch likes and add 1 to it


        var dataResp = data.findById(tweet.id)
        dataResp.get().likeCount = dataResp.get().likeCount?.plus(1)
        //Increment likes and update

        return ResponseEntity.ok(data.save(dataResp.get()))
    }

    @PatchMapping("retweet")
    fun retweet(@RequestBody tweet: DataModel): ResponseEntity<DataModel> {
        //Fetch retweets and add 1 to it
        var dataResp = data.findById(tweet.id)

        dataResp.get().tweetCount = dataResp.get().tweetCount?.plus(1)
        if(dataResp.get().tweetCount==null){
            dataResp.get().tweetCount=1
        }

        return ResponseEntity.ok(data.save(dataResp.get()))
    }

    @GetMapping("tweet/{tweet_id}")
    fun likesCount(@PathVariable tweet_id: Long): ResponseEntity<Optional<DataModel>> {
        //Return Likes Count of that tweet
        return ResponseEntity.ok(data.findById(tweet_id))
    }


}