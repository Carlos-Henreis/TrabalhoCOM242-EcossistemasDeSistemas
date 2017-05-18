package main.messages;

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: application.proto

public final class Application {
  private Application() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021application.proto\032\023messages/Hero.proto" +
      "\032\025messages/Combat.proto\032\023messages/Dice.p" +
      "roto\032\026messages/Monster.proto2h\n\rrubyInte" +
      "rface\022\035\n\007getHero\022\007.HeroID\032\007.Heroes\"\000\022\033\n\007" +
      "setHero\022\005.Hero\032\007.Heroes\"\000\022\033\n\007addHero\022\005.H" +
      "ero\032\007.Heroes\"\0002=\n\017pythonInterface\022*\n\017gen" +
      "erateMonster\022\n.MonsterQt\032\t.Monsters\"\0002V\n" +
      "\rjavaInterface\022%\n\017calculateCombat\022\007.Comb" +
      "at\032\007.Combat\"\000\022\036\n\010rollDice\022\t.DiceType\032\005.D" +
      "ice\"\000b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          HeroOuterClass.getDescriptor(),
          CombatOuterClass.getDescriptor(),
          DiceOuterClass.getDescriptor(),
          MonsterOuterClass.getDescriptor(),
        }, assigner);
    HeroOuterClass.getDescriptor();
    CombatOuterClass.getDescriptor();
    DiceOuterClass.getDescriptor();
    MonsterOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
