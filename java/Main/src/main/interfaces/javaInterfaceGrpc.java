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
import main.messages.CombatOuterClass;
import main.messages.DiceOuterClass;
import main.messages.Application;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.3.0)",
    comments = "Source: application.proto")
public final class javaInterfaceGrpc {

  private javaInterfaceGrpc() {}

  public static final String SERVICE_NAME = "javaInterface";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<CombatOuterClass.Combat,
      CombatOuterClass.Combat> METHOD_CALCULATE_COMBAT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "javaInterface", "calculateCombat"),
          io.grpc.protobuf.ProtoUtils.marshaller(CombatOuterClass.Combat.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(CombatOuterClass.Combat.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<DiceOuterClass.DiceType,
      DiceOuterClass.Dice> METHOD_ROLL_DICE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "javaInterface", "rollDice"),
          io.grpc.protobuf.ProtoUtils.marshaller(DiceOuterClass.DiceType.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(DiceOuterClass.Dice.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static javaInterfaceStub newStub(io.grpc.Channel channel) {
    return new javaInterfaceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static javaInterfaceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new javaInterfaceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static javaInterfaceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new javaInterfaceFutureStub(channel);
  }

  /**
   */
  public static abstract class javaInterfaceImplBase implements io.grpc.BindableService {

    /**
     */
    public void calculateCombat(CombatOuterClass.Combat request,
        io.grpc.stub.StreamObserver<CombatOuterClass.Combat> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CALCULATE_COMBAT, responseObserver);
    }

    /**
     */
    public void rollDice(DiceOuterClass.DiceType request,
        io.grpc.stub.StreamObserver<DiceOuterClass.Dice> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLL_DICE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CALCULATE_COMBAT,
            asyncUnaryCall(
              new MethodHandlers<
                CombatOuterClass.Combat,
                CombatOuterClass.Combat>(
                  this, METHODID_CALCULATE_COMBAT)))
          .addMethod(
            METHOD_ROLL_DICE,
            asyncUnaryCall(
              new MethodHandlers<
                DiceOuterClass.DiceType,
                DiceOuterClass.Dice>(
                  this, METHODID_ROLL_DICE)))
          .build();
    }
  }

  /**
   */
  public static final class javaInterfaceStub extends io.grpc.stub.AbstractStub<javaInterfaceStub> {
    private javaInterfaceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private javaInterfaceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected javaInterfaceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new javaInterfaceStub(channel, callOptions);
    }

    /**
     */
    public void calculateCombat(CombatOuterClass.Combat request,
        io.grpc.stub.StreamObserver<CombatOuterClass.Combat> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CALCULATE_COMBAT, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rollDice(DiceOuterClass.DiceType request,
        io.grpc.stub.StreamObserver<DiceOuterClass.Dice> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLL_DICE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class javaInterfaceBlockingStub extends io.grpc.stub.AbstractStub<javaInterfaceBlockingStub> {
    private javaInterfaceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private javaInterfaceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected javaInterfaceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new javaInterfaceBlockingStub(channel, callOptions);
    }

    /**
     */
    public CombatOuterClass.Combat calculateCombat(CombatOuterClass.Combat request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CALCULATE_COMBAT, getCallOptions(), request);
    }

    /**
     */
    public DiceOuterClass.Dice rollDice(DiceOuterClass.DiceType request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLL_DICE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class javaInterfaceFutureStub extends io.grpc.stub.AbstractStub<javaInterfaceFutureStub> {
    private javaInterfaceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private javaInterfaceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected javaInterfaceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new javaInterfaceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CombatOuterClass.Combat> calculateCombat(
        CombatOuterClass.Combat request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CALCULATE_COMBAT, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<DiceOuterClass.Dice> rollDice(
        DiceOuterClass.DiceType request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLL_DICE, getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE_COMBAT = 0;
  private static final int METHODID_ROLL_DICE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final javaInterfaceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(javaInterfaceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE_COMBAT:
          serviceImpl.calculateCombat((CombatOuterClass.Combat) request,
              (io.grpc.stub.StreamObserver<CombatOuterClass.Combat>) responseObserver);
          break;
        case METHODID_ROLL_DICE:
          serviceImpl.rollDice((DiceOuterClass.DiceType) request,
              (io.grpc.stub.StreamObserver<DiceOuterClass.Dice>) responseObserver);
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

  private static final class javaInterfaceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Application.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (javaInterfaceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new javaInterfaceDescriptorSupplier())
              .addMethod(METHOD_CALCULATE_COMBAT)
              .addMethod(METHOD_ROLL_DICE)
              .build();
        }
      }
    }
    return result;
  }
}
