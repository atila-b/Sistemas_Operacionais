# Servidor de Backup para o Departamento de Turismo (DTUR)
## Autor:
Átila Bernardo Mota Sousa

## Descrição:
A aplicação consiste em um servidor do Departamento de Turismo (DTUR) responsável pelo backup de mensagens enviadas pelos clientes. No arquivo .imn do core estão presentes o host do servidor DTUR e 2 outros hosts de clientes. Na simulação primeiramente são executados automaticamente os códigos em Python dos clientes e servidores e assim iniciadas as conexões TCP e envio das mensagens. Todas essas mensagens são guardadas na pasta 'home/backup' do servidor e são identificadas através do IP do cliente que a enviou. Para visualização da aplicação, os códigos dos clientes que são executados automaticamente no início da simulação enviam mensagens no formato '.txt' informando a sua inicialização e esses arquivos são armazenados, podendo ser verificados na pasta 'backup' do servidor.

## Protocolo de transporte:
TCP

## Número de porta:
12000

## Formato das mensagens:
.txt



