Gerando arquivos de comunicação.
Rode os comandos para gerar as mensagens e as interfaces gRPC


--Python:
$ python3 -m grpc_tools.protoc -I./ --python_out=./../python --grpc_python_out=./../python application.proto

$ python3 -m grpc_tools.protoc -I./ --python_out=./../python/ --grpc_python_out=./../python/ messages/Hero.proto messages/Dice.proto messages/Monster.proto messages/Combat.proto

--Java:
$ 

--Ruby:
$ grpc_tools_ruby_protoc -I./ --ruby_out=./../ruby --grpc_out=./../ruby application.proto

$ protoc -I./ --ruby_out=./../ruby messages/Hero.proto messages/Dice.proto messages/Monster.proto messages/Combat.proto