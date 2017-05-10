# TrabalhoCOM242-EcossistemasDeSistemas
Comunicação e troca de operações de sistemas em linguagens diferentes utilizando google protocol buffers

Instalação do compiler e libs---------------------------------------

1.)Usando arquivo direto do github:

Baixe a versão 3.2 do arquivo zip 

Siga as instruções do README do arquivo, mas rode os possíveis comandos
através do "AUTO APT". Deem uma olhada no tutorial para instalar e 
configurá-lo.

https://www.vivaolinux.com.br/dica/Facilite-sua-vida-com-o-autoapt

OBS: *A instalação e configuração do AUTO APT demora um pouco
	 *O protobuf compiler deve estar na pasta raiz
	 *A lib deve estar na pasta com o nome da linguagem
	 *tanto o compiler qanto a lib podem ser instaladas com o AUTO APT 
--------------------------------------------------------------------
2.) Usando o debian apt-get:

$sudo apt-get install protobuf-compiler
$sudo apt-get install libprotobuf-java

Se for usar a lib de outra linguagem de uma olhada no repositório da
ubuntu, so consegui encontrar o de python e o de java, mas nada impede
que outros repositórios possuam essas libs.

OBS: *Verifique a versão de seu protoc
		$protoc --version
	  e garanta que seja pelo menos 3.*
--------------------------------------------------------------------