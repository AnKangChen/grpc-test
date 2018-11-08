package com.helios.grpc

import com.helios.GreeterGrpc
import com.helios.HelloReply
import com.helios.HelloRequest
import io.grpc.ServerBuilder
import io.grpc.stub.StreamObserver

class GreeterGrpcImpl : GreeterGrpc.GreeterImplBase() {
    override fun sayHello(request: HelloRequest, responseObserver: StreamObserver<HelloReply>) {
        val message = "hello,${request.name}"
        val resp = HelloReply.newBuilder().setMessage(message).build()
        responseObserver.onNext(resp)
        responseObserver.onCompleted()
    }
}

fun main(vararg args:String){
    println("server starts")
    val server = ServerBuilder.forPort(8888)
            .addService(GreeterGrpcImpl())
            .build()
            .start()
    server.awaitTermination()
    println("server stops")
}