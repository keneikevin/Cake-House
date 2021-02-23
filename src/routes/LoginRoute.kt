package com.kevin.routes

import com.kevin.data.requests.AccountRequest
import io.ktor.request.*
import io.ktor.routing.*

fun Route.loginRoute(){
    route("/login"){
        val request = try {
            call.receive<AccountRequest>()
        } catch (e:ContentTransformationException){}
    }
}