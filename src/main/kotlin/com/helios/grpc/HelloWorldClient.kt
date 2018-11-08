package com.helios.grpc

import com.helios.GreeterGrpc
import com.helios.HelloRequest
import io.grpc.ManagedChannelBuilder

fun main(vararg args:String){
    val channel = ManagedChannelBuilder.forAddress("127.0.0.1",8888)
            .usePlaintext(true)
            .build()
    val resp = GreeterGrpc.newBlockingStub(channel).sayHello(HelloRequest.newBuilder().setName("hecy").build())
    println(resp.message)
}