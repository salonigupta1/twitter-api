package com.example.databasedemo.repository

import com.example.databasedemo.model.DataModel
import org.springframework.data.repository.CrudRepository


interface DataRepository: CrudRepository<DataModel, Long> {
    
}