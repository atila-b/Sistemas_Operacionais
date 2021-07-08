from socket import *
import os

portaServidor = 12000

socketServidor = socket (AF_INET, SOCK_STREAM)

socketServidor.bind (('192.0.2.10', portaServidor))

socketServidor.listen (1)

# Python 2
print "O servidor esta pronto para receber"

path = os.path.join("./", "backup")
os.mkdir(path)

while 1 :
    socketConexao, endereco = socketServidor.accept ()
    arq = open('./backup/' + str(endereco) + '.txt', 'w')
    dados = socketConexao.recv(1024)
    if not dados:
	break
    arq.write(dados)
    arq.close()
    print "Dados recebidos de " + str(endereco[0])

socketConexao.close