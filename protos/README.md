========================================================================================
==							Gerando arquivos de comunicação							  ==
========================================================================================

Python:
Rode os comandos para gerar as mensagens e as interfaces gRPC:

$ python3 -m grpc_tools.protoc -I./ --python_out=./../python --grpc_python_out=./../python application.proto

$ python3 -m grpc_tools.protoc -I./ --python_out=./../python/ --grpc_python_out=./../python/ messages/Hero.proto messages/Dice.proto messages/Monster.proto messages/Combat.proto

Copie os arquivos para a pasta do projeto.

Java:
$ 

Ruby:
$