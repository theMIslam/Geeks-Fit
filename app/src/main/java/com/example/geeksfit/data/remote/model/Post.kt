package com.example.geeksfit.data.remote.model

data class Post(
    val description: String,
    val operationId: String,
    val parameters: List<ParameterXXX>,
    val tags: List<String>
)