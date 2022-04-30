package com.example.databasedemo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
class DataModel (
      @Id @GeneratedValue
      val id: Long,
      val content: String? = null,
      var likeCount: Int?=0,
      var tweetCount: Int?=0
)