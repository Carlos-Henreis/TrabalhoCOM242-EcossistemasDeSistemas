# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: messages/Monster.proto

require 'google/protobuf'

Google::Protobuf::DescriptorPool.generated_pool.build do
  add_message "Monster" do
    optional :id, :int32, 1
    optional :name, :string, 2
    optional :strength, :int32, 3
    optional :resistance, :int32, 4
    optional :health, :int32, 5
  end
  add_message "MonsterQt" do
    optional :qt, :int32, 1
  end
  add_message "Monsters" do
    repeated :monster, :message, 1, "Monster"
  end
end

Monster = Google::Protobuf::DescriptorPool.generated_pool.lookup("Monster").msgclass
MonsterQt = Google::Protobuf::DescriptorPool.generated_pool.lookup("MonsterQt").msgclass
Monsters = Google::Protobuf::DescriptorPool.generated_pool.lookup("Monsters").msgclass
