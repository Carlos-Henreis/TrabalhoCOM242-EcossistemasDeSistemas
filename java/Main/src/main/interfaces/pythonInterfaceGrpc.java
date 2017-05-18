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
import main.messages.MonsterOuterClass;
import main.messages.Application;


/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.3.0)",
    comments = "Source: application.proto")
public final class pythonInterfaceGrpc {

  private pythonInterfaceGrpc() {}

  public static final String SERVICE_NAME = "pythonInterface";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<MonsterOuterClass.MonsterQt,
      MonsterOuterClass.Monsters> METHOD_GENERATE_MONSTER =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "pythonInterface", "generateMonster"),
          io.grpc.protobuf.ProtoUtils.marshaller(MonsterOuterClass.MonsterQt.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(MonsterOuterClass.Monsters.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static pythonInterfaceStub newStub(io.grpc.Channel channel) {
    return new pythonInterfaceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static pythonInterfaceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new pythonInterfaceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static pythonInterfaceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new pythonInterfaceFutureStub(channel);
  }

  /**
   */
  public static abstract class pythonInterfaceImplBase implements io.grpc.BindableService {

    /**
     */
    public void generateMonster(MonsterOuterClass.MonsterQt request,
        io.grpc.stub.StreamObserver<MonsterOuterClass.Monsters> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GENERATE_MONSTER, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GENERATE_MONSTER,
            asyncUnaryCall(
              new MethodHandlers<
                MonsterOuterClass.MonsterQt,
                MonsterOuterClass.Monsters>(
                  this, METHODID_GENERATE_MONSTER)))
          .build();
    }
  }

  /**
   */
  public static final class pythonInterfaceStub extends io.grpc.stub.AbstractStub<pythonInterfaceStub> {
    private pythonInterfaceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pythonInterfaceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pythonInterfaceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pythonInterfaceStub(channel, callOptions);
    }

    /**
     */
    public void generateMonster(MonsterOuterClass.MonsterQt request,
        io.grpc.stub.StreamObserver<MonsterOuterClass.Monsters> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GENERATE_MONSTER, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class pythonInterfaceBlockingStub extends io.grpc.stub.AbstractStub<pythonInterfaceBlockingStub> {
    private pythonInterfaceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pythonInterfaceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pythonInterfaceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pythonInterfaceBlockingStub(channel, callOptions);
    }

    /**
     */
    public MonsterOuterClass.Monsters generateMonster(MonsterOuterClass.MonsterQt request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GENERATE_MONSTER, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class pythonInterfaceFutureStub extends io.grpc.stub.AbstractStub<pythonInterfaceFutureStub> {
    private pythonInterfaceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pythonInterfaceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pythonInterfaceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pythonInterfaceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MonsterOuterClass.Monsters> generateMonster(
        MonsterOuterClass.MonsterQt request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GENERATE_MONSTER, getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_MONSTER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final pythonInterfaceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(pythonInterfaceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_MONSTER:
          serviceImpl.generateMonster((MonsterOuterClass.MonsterQt) request,
              (io.grpc.stub.StreamObserver<MonsterOuterClass.Monsters>) responseObserver);
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

  private static final class pythonInterfaceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Application.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (pythonInterfaceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new pythonInterfaceDescriptorSupplier())
              .addMethod(METHOD_GENERATE_MONSTER)
              .build();
        }
      }
    }
    return result;
  }
}
