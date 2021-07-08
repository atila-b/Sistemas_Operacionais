# Importacao da biblioteca de socket
from socket import *

nomeServidor = '192.0.2.10'

portaServidor = 12000

socketCliente = socket (AF_INET, SOCK_STREAM)

socketCliente.connect ((nomeServidor, portaServidor))

arq = open('./mensagem.txt', 'r')

for i in arq.readlines():
    socketCliente.send(i)

arq.close()
socketCliente.close()