package com.example.roombase.data.repositories

/**
 * ApiRepository
 */
interface ApiRepository {

    /**
     * Method to invoke repository service
     *
     * @param request request code
     */
    fun invokeService(request: String)
}