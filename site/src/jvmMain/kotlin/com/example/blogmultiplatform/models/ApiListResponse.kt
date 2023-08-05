package com.example.blogmultiplatform.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

@Serializable(ApiListResponseSerializer::class)
actual sealed class ApiListResponse {
    @Serializable
    @SerialName("idle")
    actual object Idle : ApiListResponse()

    @Serializable
    @SerialName("success")
    actual data class Success(val data: List<PostWithoutDetails>) : ApiListResponse()

    @Serializable
    @SerialName("error")
    actual data class Error(val message: String) : ApiListResponse()
}

@Serializable(ApiResponseSerializer::class)
actual sealed class ApiResponse {
    @Serializable
    @SerialName("idle")
    actual object Idle : ApiResponse()

    @Serializable
    @SerialName("success")
    actual data class Success(val data: Post) : ApiResponse()

    @Serializable
    @SerialName("error")
    actual data class Error(val message: String) : ApiResponse()
}

object ApiListResponseSerializer :
    JsonContentPolymorphicSerializer<ApiListResponse>(ApiListResponse::class) {
    override fun selectDeserializer(element: JsonElement) = when {
        "data" in element.jsonObject -> ApiListResponse.Success.serializer()
        "message" in element.jsonObject -> ApiListResponse.Error.serializer()
        else -> ApiListResponse.Idle.serializer()
    }
}

object ApiResponseSerializer :
    JsonContentPolymorphicSerializer<ApiResponse>(ApiResponse::class) {
    override fun selectDeserializer(element: JsonElement) = when {
        "data" in element.jsonObject -> ApiResponse.Success.serializer()
        "message" in element.jsonObject -> ApiResponse.Error.serializer()
        else -> ApiResponse.Idle.serializer()
    }
}