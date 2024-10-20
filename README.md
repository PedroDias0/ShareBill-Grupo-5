 # ShareBill

## Gonçalo Fernandes – 20231215
## Pedro Dias – 20230038
## Tiago Rato - 20230931

## Palavras-chave:
 Divisão de despesas, Gestão financeira, Share bill, Despesas compartilhadas, Grupos de amigos.
## Breve descrição da App e do problema que pretende resolver:
 O Share bill é uma aplicação que facilita a partilha de despesas entre grupos de pessoas, sejam amigos, familiares ou colegas de trabalho. Muitas vezes, a divisão de despesas em eventos sociais, viagens ou mesmo na gestão de uma casa partilhada, torna-se confusa e gera mal-entendidos. O Share bill automatiza este processo, calculando de forma justa quanto cada pessoa deve pagar ou receber, ajudando a evitar conflitos e simplificando a organização financeira entre grupos.

## Descrição dos objetivos e da motivação do trabalho a realizar: 
 O objetivo principal do projeto Share bill é desenvolver uma aplicação que simplifique a gestão de despesas compartilhadas, permitindo que os utilizadores adicionem e acompanhem despesas de forma eficiente. A motivação do trabalho surge da necessidade crescente de ferramentas digitais que automatizem a gestão financeira e melhorem a comunicação em situações de partilha de custos, como viagens ou eventos sociais. Esta aplicação será uma solução útil para reduzir o tempo e os conflitos associados à partilha de despesas.

## Identificação do Público-Alvo:
 O público-alvo do Share bill são grupos de amigos, estudantes, famílias, colegas de trabalho ou qualquer pessoa que precise de dividir despesas de forma justa e organizada. A aplicação destina-se a utilizadores que valorizam uma solução digital prática e intuitiva para gerir finanças pessoais e coletivas.

## Pesquisa de mercado sobre aplicações semelhantes ou com as quais pode comparar:
 1.	Splitwise – A principal inspiração para o Share bill, permitindo dividir despesas entre grupos. É amplamente usada e reconhecida, mas o Share bill pretende oferecer uma interface mais simples e mais funções.
 2.	Tricount – Focado em simplificar a divisão de despesas para grupos, particularmente durante viagens. Similar ao Share bill, mas com menos funcionalidades avançadas.
 3.	Settle Up – Outra aplicação de divisão de contas, com foco em simplicidade e partilha de despesas de maneira rápida.

## Guia de Teste 1: Criar um Grupo para Dividir Despesas:
•	Objetivo: Verificar se o utilizador consegue criar um grupo para dividir despesas corretamente.
•	Passos:
1.	O utilizador faz login na aplicação.
2.	O utilizador seleciona "Criar novo grupo".
3.	O utilizador insere o nome do grupo ("Viagem para Lisboa") e convida membros (escolhendo contatos).
4.	O utilizador confirma a criação do grupo.
5.	O sistema exibe o grupo recém-criado na lista de grupos.

## Guia de Teste 2: Adicionar uma Despesa ao Grupo:
•	Objetivo: Verificar se o utilizador consegue adicionar uma despesa ao grupo de forma correta.
•	Passos:
1.	O utilizador seleciona um grupo existente ("Viagem para Lisboa").
2.	O utilizador escolhe "Adicionar despesa" no grupo.
3.	O utilizador insere o valor da despesa (€200) e a descrição (Alojamento). 
4.	O utilizador seleciona quem pagou e como deseja dividir a despesa (divisão igual).
5.	O utilizador confirma a operação.
6.	O sistema atualiza o saldo de cada membro do grupo.

## Guia de Teste 3: Marcar uma Dívida como Paga:
•	Objetivo: Verificar se o utilizador consegue marcar uma dívida como paga.
•	Passos:
1.	O utilizador visualiza uma dívida pendente no grupo ("Pedro deve €50 a João").
2.	O utilizador clica na dívida e escolhe "Marcar como paga".
3.	O sistema pergunta ao utilizador se deseja confirmar a operação.
4.	O utilizador confirma.
5.	O sistema atualiza o estado da dívida para "Paga".

## Descrição genérica da solução a implementar:
O Share bill será uma aplicação mobile e web que permitirá a criação de grupos de despesas, a adição de pagamentos e a divisão automática dos custos entre os participantes. A solução inclui funcionalidades como lembretes automáticos, registo detalhado de transações e relatórios claros.

## Enquadramento nas diversas Unidades Curriculares:
Programação de Dispositivos Móveis – Ensina a criar interfaces amigáveis para os utilizadores;
Programação Orientada a Objetos – fornece técnicas para modelar o comportamento e as interações dos objetos tornando o código mais organizado;
Bases de Dados - Responsável pela gestão eficiente dos dados da aplicação, como informações sobre utilizadores, grupos e despesas;
Competências Comunicacionais;
Matemática Discreta – contribui no desenvolvimento de algoritmos que organizam dados e ajuda a tornar o código seja mais eficiente; 

## Requisitos Técnicos para desenvolvimento do projeto:
https://developer.android.com/studio?hl=pt-br
https://www.mysql.com
https://www.mamp.info/en/windows/

## Arquitetura da Solução:
Android Studio - Desenvolvimento da interface;
Mysql – Armazenamento consulta e manipulação de dados;
Mamp - Servidor local, testes de integração;
Figma - Design

## Tecnologias a utilizar:
Kotlin;
Java;
Mysql;

## Gráfico de Gantt
![image](https://github.com/user-attachments/assets/6b1920c4-f5d4-4bb4-a991-71b58b6bd5bc)

## Conclusão:
O projeto Share bill visa criar uma aplicação que resolva de forma eficaz os problemas associados à partilha de despesas entre grupos. Os principais objetivos incluem a simplificação do processo de divisão de contas, a automatização de lembretes de pagamentos e a geração de relatórios detalhados. A aplicação será testada e otimizada para garantir uma experiência de utilizador clara e eficiente.

## Bibliografia:
1.	"Splitwise: Dividing Expenses for Friends and Groups." https://www.splitwise.com
2.	"Tricount: Expense Sharing Made Easy." https://www.tricount.com
3.	"Settle Up: Share Expenses with Friends." https://settleup.io





