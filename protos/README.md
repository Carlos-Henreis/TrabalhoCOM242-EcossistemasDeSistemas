Gerando arquivos de comunicação.
Rode os comandos para gerar as mensagens e as interfaces gRPC


--Python:
$ python3 -m grpc_tools.protoc -I./ --python_out=./../python --grpc_python_out=./../python application.proto

$ protoc -I./ --python_out=./../python/ messages/Hero.proto messages/Dice.proto messages/Monster.proto messages/Combat.proto

--Java:
$ protoc --plugin=protoc-gen-grpc-java=protoc-gen-grpc-java.exe --grpc-java_out ./../java --java_out ./../java application.proto

$protoc -I./ --java_out ./../java/ messages/Hero.proto messages/Dice.proto messages/Monster.proto messages/Combat.proto

--Ruby:
$ grpc_tools_ruby_protoc -I./ --ruby_out=./../ruby --grpc_out=./../ruby application.proto

$ protoc -I./ --ruby_out=./../ruby messages/Hero.proto messages/Dice.proto messages/Monster.proto messages/Combat.proto
