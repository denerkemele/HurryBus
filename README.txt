#HurryBus
HurryBus � um projeto que se originou em sala de aula como um projeto para a cadeira de Est�gio do curso de Ci�ncia da Computa��o.

No projeto existem duas classes que s�o usadas como modelo de objetos de Evento e de Usu�rio, essas classes se encontram no pacote �modelo�. Existe um pacote chamado de �dao� o qual cont�m o pacote �banco� respons�vel por manter a classe que faz a conex�o com o banco de dados. Ainda dentro do pacote �dao� existem as classes �EventoDao� e �UsuarioDao�, nessas classes cont�m todos os m�todos para manipula��o do bando de dados.

Foram criadas duas tabelas no banco de dados, uma para guardar as informa��es do usu�rio e outra para guardar os dados de cada evento criado pelo usu�rio.

Foi implementado nas classes �EventoDao� e �UsuarioDao� m�todos para tratarem objetos do tipo JSON e Strings do tipo JSON, podendo com elas executar opera��es no banco de dados

Foi criado uma tela JSP de teste, a tela de teste pode direcionar para outras seis telas em JSP cada uma delas recebem dados por formul�rios e criando uma String JSON para fazer a comunica��o com as classes que manipulam o banco de dados
Criado as classes UsuarioHendler e EventoHendler, porem ainda com problemas no metodo que recebe uma String JSON pelo metodo POST para fazer a persist�ncia.
