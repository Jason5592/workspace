// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HelloWorld.proto

package com.archforce.ath.rds.grpc.proto;

/**
 * Protobuf type {@code com.archforce.ath.rds.grpc.proto.A3}
 */
public  final class A3 extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.archforce.ath.rds.grpc.proto.A3)
    A3OrBuilder {
private static final long serialVersionUID = 0L;
  // Use A3.newBuilder() to construct.
  private A3(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private A3() {
    i_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private A3(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              i_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            i_.add(input.readInt32());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
              i_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              i_.add(input.readInt32());
            }
            input.popLimit(limit);
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
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        i_ = java.util.Collections.unmodifiableList(i_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.archforce.ath.rds.grpc.proto.HelloWorld.internal_static_com_archforce_ath_rds_grpc_proto_A3_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.archforce.ath.rds.grpc.proto.HelloWorld.internal_static_com_archforce_ath_rds_grpc_proto_A3_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.archforce.ath.rds.grpc.proto.A3.class, com.archforce.ath.rds.grpc.proto.A3.Builder.class);
  }

  public static final int I_FIELD_NUMBER = 1;
  private java.util.List<java.lang.Integer> i_;
  /**
   * <code>repeated int32 i = 1;</code>
   */
  public java.util.List<java.lang.Integer>
      getIList() {
    return i_;
  }
  /**
   * <code>repeated int32 i = 1;</code>
   */
  public int getICount() {
    return i_.size();
  }
  /**
   * <code>repeated int32 i = 1;</code>
   */
  public int getI(int index) {
    return i_.get(index);
  }
  private int iMemoizedSerializedSize = -1;

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
    getSerializedSize();
    if (getIList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(iMemoizedSerializedSize);
    }
    for (int i = 0; i < i_.size(); i++) {
      output.writeInt32NoTag(i_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < i_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(i_.get(i));
      }
      size += dataSize;
      if (!getIList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      iMemoizedSerializedSize = dataSize;
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.archforce.ath.rds.grpc.proto.A3)) {
      return super.equals(obj);
    }
    com.archforce.ath.rds.grpc.proto.A3 other = (com.archforce.ath.rds.grpc.proto.A3) obj;

    boolean result = true;
    result = result && getIList()
        .equals(other.getIList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getICount() > 0) {
      hash = (37 * hash) + I_FIELD_NUMBER;
      hash = (53 * hash) + getIList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.archforce.ath.rds.grpc.proto.A3 parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.archforce.ath.rds.grpc.proto.A3 parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.archforce.ath.rds.grpc.proto.A3 parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.archforce.ath.rds.grpc.proto.A3 parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.archforce.ath.rds.grpc.proto.A3 parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.archforce.ath.rds.grpc.proto.A3 parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.archforce.ath.rds.grpc.proto.A3 parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.archforce.ath.rds.grpc.proto.A3 parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.archforce.ath.rds.grpc.proto.A3 parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.archforce.ath.rds.grpc.proto.A3 parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.archforce.ath.rds.grpc.proto.A3 parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.archforce.ath.rds.grpc.proto.A3 parseFrom(
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
  public static Builder newBuilder(com.archforce.ath.rds.grpc.proto.A3 prototype) {
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
   * Protobuf type {@code com.archforce.ath.rds.grpc.proto.A3}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.archforce.ath.rds.grpc.proto.A3)
      com.archforce.ath.rds.grpc.proto.A3OrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.archforce.ath.rds.grpc.proto.HelloWorld.internal_static_com_archforce_ath_rds_grpc_proto_A3_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.archforce.ath.rds.grpc.proto.HelloWorld.internal_static_com_archforce_ath_rds_grpc_proto_A3_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.archforce.ath.rds.grpc.proto.A3.class, com.archforce.ath.rds.grpc.proto.A3.Builder.class);
    }

    // Construct using com.archforce.ath.rds.grpc.proto.A3.newBuilder()
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
      i_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.archforce.ath.rds.grpc.proto.HelloWorld.internal_static_com_archforce_ath_rds_grpc_proto_A3_descriptor;
    }

    public com.archforce.ath.rds.grpc.proto.A3 getDefaultInstanceForType() {
      return com.archforce.ath.rds.grpc.proto.A3.getDefaultInstance();
    }

    public com.archforce.ath.rds.grpc.proto.A3 build() {
      com.archforce.ath.rds.grpc.proto.A3 result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.archforce.ath.rds.grpc.proto.A3 buildPartial() {
      com.archforce.ath.rds.grpc.proto.A3 result = new com.archforce.ath.rds.grpc.proto.A3(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        i_ = java.util.Collections.unmodifiableList(i_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.i_ = i_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
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
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.archforce.ath.rds.grpc.proto.A3) {
        return mergeFrom((com.archforce.ath.rds.grpc.proto.A3)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.archforce.ath.rds.grpc.proto.A3 other) {
      if (other == com.archforce.ath.rds.grpc.proto.A3.getDefaultInstance()) return this;
      if (!other.i_.isEmpty()) {
        if (i_.isEmpty()) {
          i_ = other.i_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureIIsMutable();
          i_.addAll(other.i_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
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
      com.archforce.ath.rds.grpc.proto.A3 parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.archforce.ath.rds.grpc.proto.A3) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<java.lang.Integer> i_ = java.util.Collections.emptyList();
    private void ensureIIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        i_ = new java.util.ArrayList<java.lang.Integer>(i_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int32 i = 1;</code>
     */
    public java.util.List<java.lang.Integer>
        getIList() {
      return java.util.Collections.unmodifiableList(i_);
    }
    /**
     * <code>repeated int32 i = 1;</code>
     */
    public int getICount() {
      return i_.size();
    }
    /**
     * <code>repeated int32 i = 1;</code>
     */
    public int getI(int index) {
      return i_.get(index);
    }
    /**
     * <code>repeated int32 i = 1;</code>
     */
    public Builder setI(
        int index, int value) {
      ensureIIsMutable();
      i_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 i = 1;</code>
     */
    public Builder addI(int value) {
      ensureIIsMutable();
      i_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 i = 1;</code>
     */
    public Builder addAllI(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureIIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, i_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 i = 1;</code>
     */
    public Builder clearI() {
      i_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.archforce.ath.rds.grpc.proto.A3)
  }

  // @@protoc_insertion_point(class_scope:com.archforce.ath.rds.grpc.proto.A3)
  private static final com.archforce.ath.rds.grpc.proto.A3 DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.archforce.ath.rds.grpc.proto.A3();
  }

  public static com.archforce.ath.rds.grpc.proto.A3 getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<A3>
      PARSER = new com.google.protobuf.AbstractParser<A3>() {
    public A3 parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new A3(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<A3> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<A3> getParserForType() {
    return PARSER;
  }

  public com.archforce.ath.rds.grpc.proto.A3 getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

