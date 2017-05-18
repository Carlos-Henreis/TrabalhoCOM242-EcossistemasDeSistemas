package main.interfaces;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import main.messages.HeroOuterClass;
import main.messages.Application;


/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.3.0)",
    comments = "Source: application.proto")
public final class rubyInterfaceGrpc {

  private rubyInterfaceGrpc() {}

  public static final String SERVICE_NAME = "rubyInterface";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<HeroOuterClass.HeroID,
      HeroOuterClass.Heroes> METHOD_GET_HERO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rubyInterface", "getHero"),
          io.grpc.protobuf.ProtoUtils.marshaller(HeroOuterClass.HeroID.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(HeroOuterClass.Heroes.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<HeroOuterClass.Hero,
      HeroOuterClass.Heroes> METHOD_SET_HERO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rubyInterface", "setHero"),
          io.grpc.protobuf.ProtoUtils.marshaller(HeroOuterClass.Hero.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(HeroOuterClass.Heroes.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<HeroOuterClass.Hero,
      HeroOuterClass.Heroes> METHOD_ADD_HERO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "rubyInterface", "addHero"),
          io.grpc.protobuf.ProtoUtils.marshaller(HeroOuterClass.Hero.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(HeroOuterClass.Heroes.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static rubyInterfaceStub newStub(io.grpc.Channel channel) {
    return new rubyInterfaceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static rubyInterfaceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new rubyInterfaceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static rubyInterfaceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new rubyInterfaceFutureStub(channel);
  }

  /**
   */
  public static abstract class rubyInterfaceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getHero(HeroOuterClass.HeroID request,
        io.grpc.stub.StreamObserver<HeroOuterClass.Heroes> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_HERO, responseObserver);
    }

    /**
     */
    public void setHero(HeroOuterClass.Hero request,
        io.grpc.stub.StreamObserver<HeroOuterClass.Heroes> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_HERO, responseObserver);
    }

    /**
     */
    public void addHero(HeroOuterClass.Hero request,
        io.grpc.stub.StreamObserver<HeroOuterClass.Heroes> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_HERO, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_HERO,
            asyncUnaryCall(
              new MethodHandlers<
                HeroOuterClass.HeroID,
                HeroOuterClass.Heroes>(
                  this, METHODID_GET_HERO)))
          .addMethod(
            METHOD_SET_HERO,
            asyncUnaryCall(
              new MethodHandlers<
                HeroOuterClass.Hero,
                HeroOuterClass.Heroes>(
                  this, METHODID_SET_HERO)))
          .addMethod(
            METHOD_ADD_HERO,
            asyncUnaryCall(
              new MethodHandlers<
                HeroOuterClass.Hero,
                HeroOuterClass.Heroes>(
                  this, METHODID_ADD_HERO)))
          .build();
    }
  }

  /**
   */
  public static final class rubyInterfaceStub extends io.grpc.stub.AbstractStub<rubyInterfaceStub> {
    private rubyInterfaceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private rubyInterfaceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected rubyInterfaceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new rubyInterfaceStub(channel, callOptions);
    }

    /**
     */
    public void getHero(HeroOuterClass.HeroID request,
        io.grpc.stub.StreamObserver<HeroOuterClass.Heroes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_HERO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setHero(HeroOuterClass.Hero request,
        io.grpc.stub.StreamObserver<HeroOuterClass.Heroes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_HERO, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addHero(HeroOuterClass.Hero request,
        io.grpc.stub.StreamObserver<HeroOuterClass.Heroes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_HERO, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class rubyInterfaceBlockingStub extends io.grpc.stub.AbstractStub<rubyInterfaceBlockingStub> {
    private rubyInterfaceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private rubyInterfaceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected rubyInterfaceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new rubyInterfaceBlockingStub(channel, callOptions);
    }

    /**
     */
    public HeroOuterClass.Heroes getHero(HeroOuterClass.HeroID request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_HERO, getCallOptions(), request);
    }

    /**
     */
    public HeroOuterClass.Heroes setHero(HeroOuterClass.Hero request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_HERO, getCallOptions(), request);
    }

    /**
     */
    public HeroOuterClass.Heroes addHero(HeroOuterClass.Hero request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_HERO, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class rubyInterfaceFutureStub extends io.grpc.stub.AbstractStub<rubyInterfaceFutureStub> {
    private rubyInterfaceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private rubyInterfaceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected rubyInterfaceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new rubyInterfaceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<HeroOuterClass.Heroes> getHero(
        HeroOuterClass.HeroID request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_HERO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<HeroOuterClass.Heroes> setHero(
        HeroOuterClass.Hero request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_HERO, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<HeroOuterClass.Heroes> addHero(
        HeroOuterClass.Hero request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_HERO, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_HERO = 0;
  private static final int METHODID_SET_HERO = 1;
  private static final int METHODID_ADD_HERO = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final rubyInterfaceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(rubyInterfaceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_HERO:
          serviceImpl.getHero((HeroOuterClass.HeroID) request,
              (io.grpc.stub.StreamObserver<HeroOuterClass.Heroes>) responseObserver);
          break;
        case METHODID_SET_HERO:
          serviceImpl.setHero((HeroOuterClass.Hero) request,
              (io.grpc.stub.StreamObserver<HeroOuterClass.Heroes>) responseObserver);
          break;
        case METHODID_ADD_HERO:
          serviceImpl.addHero((HeroOuterClass.Hero) request,
              (io.grpc.stub.StreamObserver<HeroOuterClass.Heroes>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class rubyInterfaceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Application.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (rubyInterfaceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new rubyInterfaceDescriptorSupplier())
              .addMethod(METHOD_GET_HERO)
              .addMethod(METHOD_SET_HERO)
              .addMethod(METHOD_ADD_HERO)
              .build();
        }
      }
    }
    return result;
  }
}
