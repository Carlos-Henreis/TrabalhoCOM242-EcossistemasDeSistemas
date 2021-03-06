package main.messages;

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: messages/Combat.proto

public final class CombatOuterClass {
  private CombatOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface CombatOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Combat)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.Hero aHero = 1;</code>
     */
    boolean hasAHero();
    /**
     * <code>.Hero aHero = 1;</code>
     */
    HeroOuterClass.Hero getAHero();
    /**
     * <code>.Hero aHero = 1;</code>
     */
    HeroOuterClass.HeroOrBuilder getAHeroOrBuilder();

    /**
     * <code>.Monster aMonster = 2;</code>
     */
    boolean hasAMonster();
    /**
     * <code>.Monster aMonster = 2;</code>
     */
    MonsterOuterClass.Monster getAMonster();
    /**
     * <code>.Monster aMonster = 2;</code>
     */
    MonsterOuterClass.MonsterOrBuilder getAMonsterOrBuilder();

    /**
     * <code>.Combat.attacker who_attacks = 3;</code>
     */
    int getWhoAttacksValue();
    /**
     * <code>.Combat.attacker who_attacks = 3;</code>
     */
    CombatOuterClass.Combat.attacker getWhoAttacks();

    /**
     * <code>bool deadDefender = 4;</code>
     */
    boolean getDeadDefender();
  }
  /**
   * Protobuf type {@code Combat}
   */
  public  static final class Combat extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Combat)
      CombatOrBuilder {
    // Use Combat.newBuilder() to construct.
    private Combat(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Combat() {
      whoAttacks_ = 0;
      deadDefender_ = false;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Combat(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              HeroOuterClass.Hero.Builder subBuilder = null;
              if (aHero_ != null) {
                subBuilder = aHero_.toBuilder();
              }
              aHero_ = input.readMessage(HeroOuterClass.Hero.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(aHero_);
                aHero_ = subBuilder.buildPartial();
              }

              break;
            }
            case 18: {
              MonsterOuterClass.Monster.Builder subBuilder = null;
              if (aMonster_ != null) {
                subBuilder = aMonster_.toBuilder();
              }
              aMonster_ = input.readMessage(MonsterOuterClass.Monster.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(aMonster_);
                aMonster_ = subBuilder.buildPartial();
              }

              break;
            }
            case 24: {
              int rawValue = input.readEnum();

              whoAttacks_ = rawValue;
              break;
            }
            case 32: {

              deadDefender_ = input.readBool();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CombatOuterClass.internal_static_Combat_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CombatOuterClass.internal_static_Combat_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              CombatOuterClass.Combat.class, CombatOuterClass.Combat.Builder.class);
    }

    /**
     * Protobuf enum {@code Combat.attacker}
     */
    public enum attacker
        implements com.google.protobuf.ProtocolMessageEnum {
      /**
       * <code>hero = 0;</code>
       */
      hero(0),
      /**
       * <code>monster = 1;</code>
       */
      monster(1),
      UNRECOGNIZED(-1),
      ;

      /**
       * <code>hero = 0;</code>
       */
      public static final int hero_VALUE = 0;
      /**
       * <code>monster = 1;</code>
       */
      public static final int monster_VALUE = 1;


      public final int getNumber() {
        if (this == UNRECOGNIZED) {
          throw new java.lang.IllegalArgumentException(
              "Can't get the number of an unknown enum value.");
        }
        return value;
      }

      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static attacker valueOf(int value) {
        return forNumber(value);
      }

      public static attacker forNumber(int value) {
        switch (value) {
          case 0: return hero;
          case 1: return monster;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<attacker>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
          attacker> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<attacker>() {
              public attacker findValueByNumber(int number) {
                return attacker.forNumber(number);
              }
            };

      public final com.google.protobuf.Descriptors.EnumValueDescriptor
          getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptor() {
        return CombatOuterClass.Combat.getDescriptor().getEnumTypes().get(0);
      }

      private static final attacker[] VALUES = values();

      public static attacker valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        if (desc.getIndex() == -1) {
          return UNRECOGNIZED;
        }
        return VALUES[desc.getIndex()];
      }

      private final int value;

      private attacker(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:Combat.attacker)
    }

    public static final int AHERO_FIELD_NUMBER = 1;
    private HeroOuterClass.Hero aHero_;
    /**
     * <code>.Hero aHero = 1;</code>
     */
    public boolean hasAHero() {
      return aHero_ != null;
    }
    /**
     * <code>.Hero aHero = 1;</code>
     */
    public HeroOuterClass.Hero getAHero() {
      return aHero_ == null ? HeroOuterClass.Hero.getDefaultInstance() : aHero_;
    }
    /**
     * <code>.Hero aHero = 1;</code>
     */
    public HeroOuterClass.HeroOrBuilder getAHeroOrBuilder() {
      return getAHero();
    }

    public static final int AMONSTER_FIELD_NUMBER = 2;
    private MonsterOuterClass.Monster aMonster_;
    /**
     * <code>.Monster aMonster = 2;</code>
     */
    public boolean hasAMonster() {
      return aMonster_ != null;
    }
    /**
     * <code>.Monster aMonster = 2;</code>
     */
    public MonsterOuterClass.Monster getAMonster() {
      return aMonster_ == null ? MonsterOuterClass.Monster.getDefaultInstance() : aMonster_;
    }
    /**
     * <code>.Monster aMonster = 2;</code>
     */
    public MonsterOuterClass.MonsterOrBuilder getAMonsterOrBuilder() {
      return getAMonster();
    }

    public static final int WHO_ATTACKS_FIELD_NUMBER = 3;
    private int whoAttacks_;
    /**
     * <code>.Combat.attacker who_attacks = 3;</code>
     */
    public int getWhoAttacksValue() {
      return whoAttacks_;
    }
    /**
     * <code>.Combat.attacker who_attacks = 3;</code>
     */
    public CombatOuterClass.Combat.attacker getWhoAttacks() {
      CombatOuterClass.Combat.attacker result = CombatOuterClass.Combat.attacker.valueOf(whoAttacks_);
      return result == null ? CombatOuterClass.Combat.attacker.UNRECOGNIZED : result;
    }

    public static final int DEADDEFENDER_FIELD_NUMBER = 4;
    private boolean deadDefender_;
    /**
     * <code>bool deadDefender = 4;</code>
     */
    public boolean getDeadDefender() {
      return deadDefender_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (aHero_ != null) {
        output.writeMessage(1, getAHero());
      }
      if (aMonster_ != null) {
        output.writeMessage(2, getAMonster());
      }
      if (whoAttacks_ != CombatOuterClass.Combat.attacker.hero.getNumber()) {
        output.writeEnum(3, whoAttacks_);
      }
      if (deadDefender_ != false) {
        output.writeBool(4, deadDefender_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (aHero_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getAHero());
      }
      if (aMonster_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getAMonster());
      }
      if (whoAttacks_ != CombatOuterClass.Combat.attacker.hero.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(3, whoAttacks_);
      }
      if (deadDefender_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(4, deadDefender_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof CombatOuterClass.Combat)) {
        return super.equals(obj);
      }
      CombatOuterClass.Combat other = (CombatOuterClass.Combat) obj;

      boolean result = true;
      result = result && (hasAHero() == other.hasAHero());
      if (hasAHero()) {
        result = result && getAHero()
            .equals(other.getAHero());
      }
      result = result && (hasAMonster() == other.hasAMonster());
      if (hasAMonster()) {
        result = result && getAMonster()
            .equals(other.getAMonster());
      }
      result = result && whoAttacks_ == other.whoAttacks_;
      result = result && (getDeadDefender()
          == other.getDeadDefender());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasAHero()) {
        hash = (37 * hash) + AHERO_FIELD_NUMBER;
        hash = (53 * hash) + getAHero().hashCode();
      }
      if (hasAMonster()) {
        hash = (37 * hash) + AMONSTER_FIELD_NUMBER;
        hash = (53 * hash) + getAMonster().hashCode();
      }
      hash = (37 * hash) + WHO_ATTACKS_FIELD_NUMBER;
      hash = (53 * hash) + whoAttacks_;
      hash = (37 * hash) + DEADDEFENDER_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getDeadDefender());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static CombatOuterClass.Combat parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CombatOuterClass.Combat parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CombatOuterClass.Combat parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static CombatOuterClass.Combat parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static CombatOuterClass.Combat parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static CombatOuterClass.Combat parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static CombatOuterClass.Combat parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static CombatOuterClass.Combat parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static CombatOuterClass.Combat parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static CombatOuterClass.Combat parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(CombatOuterClass.Combat prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Combat}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Combat)
        CombatOuterClass.CombatOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return CombatOuterClass.internal_static_Combat_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return CombatOuterClass.internal_static_Combat_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                CombatOuterClass.Combat.class, CombatOuterClass.Combat.Builder.class);
      }

      // Construct using CombatOuterClass.Combat.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        if (aHeroBuilder_ == null) {
          aHero_ = null;
        } else {
          aHero_ = null;
          aHeroBuilder_ = null;
        }
        if (aMonsterBuilder_ == null) {
          aMonster_ = null;
        } else {
          aMonster_ = null;
          aMonsterBuilder_ = null;
        }
        whoAttacks_ = 0;

        deadDefender_ = false;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return CombatOuterClass.internal_static_Combat_descriptor;
      }

      public CombatOuterClass.Combat getDefaultInstanceForType() {
        return CombatOuterClass.Combat.getDefaultInstance();
      }

      public CombatOuterClass.Combat build() {
        CombatOuterClass.Combat result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public CombatOuterClass.Combat buildPartial() {
        CombatOuterClass.Combat result = new CombatOuterClass.Combat(this);
        if (aHeroBuilder_ == null) {
          result.aHero_ = aHero_;
        } else {
          result.aHero_ = aHeroBuilder_.build();
        }
        if (aMonsterBuilder_ == null) {
          result.aMonster_ = aMonster_;
        } else {
          result.aMonster_ = aMonsterBuilder_.build();
        }
        result.whoAttacks_ = whoAttacks_;
        result.deadDefender_ = deadDefender_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof CombatOuterClass.Combat) {
          return mergeFrom((CombatOuterClass.Combat)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(CombatOuterClass.Combat other) {
        if (other == CombatOuterClass.Combat.getDefaultInstance()) return this;
        if (other.hasAHero()) {
          mergeAHero(other.getAHero());
        }
        if (other.hasAMonster()) {
          mergeAMonster(other.getAMonster());
        }
        if (other.whoAttacks_ != 0) {
          setWhoAttacksValue(other.getWhoAttacksValue());
        }
        if (other.getDeadDefender() != false) {
          setDeadDefender(other.getDeadDefender());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        CombatOuterClass.Combat parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (CombatOuterClass.Combat) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private HeroOuterClass.Hero aHero_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          HeroOuterClass.Hero, HeroOuterClass.Hero.Builder, HeroOuterClass.HeroOrBuilder> aHeroBuilder_;
      /**
       * <code>.Hero aHero = 1;</code>
       */
      public boolean hasAHero() {
        return aHeroBuilder_ != null || aHero_ != null;
      }
      /**
       * <code>.Hero aHero = 1;</code>
       */
      public HeroOuterClass.Hero getAHero() {
        if (aHeroBuilder_ == null) {
          return aHero_ == null ? HeroOuterClass.Hero.getDefaultInstance() : aHero_;
        } else {
          return aHeroBuilder_.getMessage();
        }
      }
      /**
       * <code>.Hero aHero = 1;</code>
       */
      public Builder setAHero(HeroOuterClass.Hero value) {
        if (aHeroBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          aHero_ = value;
          onChanged();
        } else {
          aHeroBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.Hero aHero = 1;</code>
       */
      public Builder setAHero(
          HeroOuterClass.Hero.Builder builderForValue) {
        if (aHeroBuilder_ == null) {
          aHero_ = builderForValue.build();
          onChanged();
        } else {
          aHeroBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.Hero aHero = 1;</code>
       */
      public Builder mergeAHero(HeroOuterClass.Hero value) {
        if (aHeroBuilder_ == null) {
          if (aHero_ != null) {
            aHero_ =
              HeroOuterClass.Hero.newBuilder(aHero_).mergeFrom(value).buildPartial();
          } else {
            aHero_ = value;
          }
          onChanged();
        } else {
          aHeroBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.Hero aHero = 1;</code>
       */
      public Builder clearAHero() {
        if (aHeroBuilder_ == null) {
          aHero_ = null;
          onChanged();
        } else {
          aHero_ = null;
          aHeroBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.Hero aHero = 1;</code>
       */
      public HeroOuterClass.Hero.Builder getAHeroBuilder() {
        
        onChanged();
        return getAHeroFieldBuilder().getBuilder();
      }
      /**
       * <code>.Hero aHero = 1;</code>
       */
      public HeroOuterClass.HeroOrBuilder getAHeroOrBuilder() {
        if (aHeroBuilder_ != null) {
          return aHeroBuilder_.getMessageOrBuilder();
        } else {
          return aHero_ == null ?
              HeroOuterClass.Hero.getDefaultInstance() : aHero_;
        }
      }
      /**
       * <code>.Hero aHero = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          HeroOuterClass.Hero, HeroOuterClass.Hero.Builder, HeroOuterClass.HeroOrBuilder> 
          getAHeroFieldBuilder() {
        if (aHeroBuilder_ == null) {
          aHeroBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              HeroOuterClass.Hero, HeroOuterClass.Hero.Builder, HeroOuterClass.HeroOrBuilder>(
                  getAHero(),
                  getParentForChildren(),
                  isClean());
          aHero_ = null;
        }
        return aHeroBuilder_;
      }

      private MonsterOuterClass.Monster aMonster_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          MonsterOuterClass.Monster, MonsterOuterClass.Monster.Builder, MonsterOuterClass.MonsterOrBuilder> aMonsterBuilder_;
      /**
       * <code>.Monster aMonster = 2;</code>
       */
      public boolean hasAMonster() {
        return aMonsterBuilder_ != null || aMonster_ != null;
      }
      /**
       * <code>.Monster aMonster = 2;</code>
       */
      public MonsterOuterClass.Monster getAMonster() {
        if (aMonsterBuilder_ == null) {
          return aMonster_ == null ? MonsterOuterClass.Monster.getDefaultInstance() : aMonster_;
        } else {
          return aMonsterBuilder_.getMessage();
        }
      }
      /**
       * <code>.Monster aMonster = 2;</code>
       */
      public Builder setAMonster(MonsterOuterClass.Monster value) {
        if (aMonsterBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          aMonster_ = value;
          onChanged();
        } else {
          aMonsterBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.Monster aMonster = 2;</code>
       */
      public Builder setAMonster(
          MonsterOuterClass.Monster.Builder builderForValue) {
        if (aMonsterBuilder_ == null) {
          aMonster_ = builderForValue.build();
          onChanged();
        } else {
          aMonsterBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.Monster aMonster = 2;</code>
       */
      public Builder mergeAMonster(MonsterOuterClass.Monster value) {
        if (aMonsterBuilder_ == null) {
          if (aMonster_ != null) {
            aMonster_ =
              MonsterOuterClass.Monster.newBuilder(aMonster_).mergeFrom(value).buildPartial();
          } else {
            aMonster_ = value;
          }
          onChanged();
        } else {
          aMonsterBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.Monster aMonster = 2;</code>
       */
      public Builder clearAMonster() {
        if (aMonsterBuilder_ == null) {
          aMonster_ = null;
          onChanged();
        } else {
          aMonster_ = null;
          aMonsterBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.Monster aMonster = 2;</code>
       */
      public MonsterOuterClass.Monster.Builder getAMonsterBuilder() {
        
        onChanged();
        return getAMonsterFieldBuilder().getBuilder();
      }
      /**
       * <code>.Monster aMonster = 2;</code>
       */
      public MonsterOuterClass.MonsterOrBuilder getAMonsterOrBuilder() {
        if (aMonsterBuilder_ != null) {
          return aMonsterBuilder_.getMessageOrBuilder();
        } else {
          return aMonster_ == null ?
              MonsterOuterClass.Monster.getDefaultInstance() : aMonster_;
        }
      }
      /**
       * <code>.Monster aMonster = 2;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          MonsterOuterClass.Monster, MonsterOuterClass.Monster.Builder, MonsterOuterClass.MonsterOrBuilder> 
          getAMonsterFieldBuilder() {
        if (aMonsterBuilder_ == null) {
          aMonsterBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              MonsterOuterClass.Monster, MonsterOuterClass.Monster.Builder, MonsterOuterClass.MonsterOrBuilder>(
                  getAMonster(),
                  getParentForChildren(),
                  isClean());
          aMonster_ = null;
        }
        return aMonsterBuilder_;
      }

      private int whoAttacks_ = 0;
      /**
       * <code>.Combat.attacker who_attacks = 3;</code>
       */
      public int getWhoAttacksValue() {
        return whoAttacks_;
      }
      /**
       * <code>.Combat.attacker who_attacks = 3;</code>
       */
      public Builder setWhoAttacksValue(int value) {
        whoAttacks_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>.Combat.attacker who_attacks = 3;</code>
       */
      public CombatOuterClass.Combat.attacker getWhoAttacks() {
        CombatOuterClass.Combat.attacker result = CombatOuterClass.Combat.attacker.valueOf(whoAttacks_);
        return result == null ? CombatOuterClass.Combat.attacker.UNRECOGNIZED : result;
      }
      /**
       * <code>.Combat.attacker who_attacks = 3;</code>
       */
      public Builder setWhoAttacks(CombatOuterClass.Combat.attacker value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        whoAttacks_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>.Combat.attacker who_attacks = 3;</code>
       */
      public Builder clearWhoAttacks() {
        
        whoAttacks_ = 0;
        onChanged();
        return this;
      }

      private boolean deadDefender_ ;
      /**
       * <code>bool deadDefender = 4;</code>
       */
      public boolean getDeadDefender() {
        return deadDefender_;
      }
      /**
       * <code>bool deadDefender = 4;</code>
       */
      public Builder setDeadDefender(boolean value) {
        
        deadDefender_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool deadDefender = 4;</code>
       */
      public Builder clearDeadDefender() {
        
        deadDefender_ = false;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Combat)
    }

    // @@protoc_insertion_point(class_scope:Combat)
    private static final CombatOuterClass.Combat DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new CombatOuterClass.Combat();
    }

    public static CombatOuterClass.Combat getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Combat>
        PARSER = new com.google.protobuf.AbstractParser<Combat>() {
      public Combat parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Combat(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Combat> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Combat> getParserForType() {
      return PARSER;
    }

    public CombatOuterClass.Combat getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Combat_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Combat_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025messages/Combat.proto\032\023messages/Hero.p" +
      "roto\032\026messages/Monster.proto\"\232\001\n\006Combat\022" +
      "\024\n\005aHero\030\001 \001(\0132\005.Hero\022\032\n\010aMonster\030\002 \001(\0132" +
      "\010.Monster\022%\n\013who_attacks\030\003 \001(\0162\020.Combat." +
      "attacker\022\024\n\014deadDefender\030\004 \001(\010\"!\n\010attack" +
      "er\022\010\n\004hero\020\000\022\013\n\007monster\020\001b\006proto3"
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
          MonsterOuterClass.getDescriptor(),
        }, assigner);
    internal_static_Combat_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Combat_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Combat_descriptor,
        new java.lang.String[] { "AHero", "AMonster", "WhoAttacks", "DeadDefender", });
    HeroOuterClass.getDescriptor();
    MonsterOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
