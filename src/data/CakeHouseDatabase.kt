package com.kevin.data

import com.kevin.data.collections.Cake
import com.kevin.data.collections.User
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo

val client = KMongo.createClient().coroutine
val database = client.getDatabase("CakeHouseDatabase")
private val users = database.getCollection<User>()
private val cakes = database.getCollection<Cake>()

suspend fun registerUser(user:User):Boolean{
    return users.insertOne(user).wasAcknowledged()
}
suspend fun checkIfUserExists(email:String):Boolean{
    return users.findOne(User::email eq email) != null
}
suspend fun checkPasswordForEmail(email: String, passwordToCheck: String): Boolean {
    val actualPassword = users.findOne(User::email eq email)?.password ?: return false
    return actualPassword == passwordToCheck
}
