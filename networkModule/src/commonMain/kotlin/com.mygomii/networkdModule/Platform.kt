package com.mygomii.networkdModule

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


