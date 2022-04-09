package com.example.data.repository.remote.datasource

import com.example.data.remote.model.DataLoveResponse
import com.example.domain.utils.RemoteErrorEmitter

interface MainDataSource {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host : String,
        key : String,
        // fName : 남자이름
        mName : String,
        // sName : 여자이름
        fName : String
    ) : DataLoveResponse?
}