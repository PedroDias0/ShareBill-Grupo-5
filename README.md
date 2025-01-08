 # ShareBill

## Grupo:
 Gonçalo Fernandes – 20231215
 Pedro Dias – 20230038
 Tiago Rato - 20230931

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

## Passo a Passo de Funcionamento da Sharebill
O utilizador começa por criar um grupo para uma ocasião específica, como uma viagem, uma festa ou despesas mensais de uma casa partilhada.
Ao criar o grupo, o utilizador pode adicionar os membros que vão participar, seja escolhendo entre os seus contactos ou inserindo os emails dos participantes. Cada grupo tem um nome personalizado e uma data de criação.
Adicionar Despesas:

Qualquer membro do grupo pode adicionar despesas, especificando o valor total, uma breve descrição (ex: “compras de supermercado” ou “jantar”) e a data da despesa.
Ao registar a despesa, o utilizador indica quem pagou e como a despesa será dividida entre os membros (divisão igual ou personalizada). A aplicação permite também dividir valores desiguais, se alguns membros pagaram mais ou menos do que outros.
Cada nova despesa atualiza automaticamente o saldo de cada membro do grupo, indicando quem deve ou quem tem a receber.
Acompanhamento e Liquidação de Saldos:

A Sharebill mantém um saldo atualizado para cada membro, mostrando claramente quanto cada pessoa deve ou tem a receber dos outros participantes.
Os utilizadores podem consultar o saldo do grupo a qualquer momento e verificar um resumo das despesas, pagamentos pendentes e totais devidos por cada membro.
Além disso, a aplicação permite que os utilizadores marquem dívidas como “pagas” quando recebem o valor devido, atualizando automaticamente os saldos de todos no grupo.
Notificações automáticas podem ser enviadas para lembrar os participantes de pagamentos pendentes, garantindo que todos estejam cientes das suas obrigações.
Relatórios e Transparência:

A aplicação gera relatórios de despesas para que os utilizadores possam acompanhar as transações do grupo de forma clara e organizada.
Cada despesa e pagamento são registados, promovendo transparência e ajudando a evitar mal-entendidos sobre quem pagou ou deve pagar.

## Gráfico de Gantt
![image](https://github.com/user-attachments/assets/5d2d9876-8dcd-4080-b2f4-56b332d38437)

## Modelo de Dominio 
![image](https://github.com/user-attachments/assets/660ce7bd-690c-40cb-aea6-a2eeb8f04f4b)



## Design Aplicação 
![image](https://github.com/user-attachments/assets/0a9acaf4-9e5f-425e-8703-6b30769412a1)
![image](https://github.com/user-attachments/assets/8fcf3845-8fe0-481f-a068-4d441c71489c)
![image](https://github.com/user-attachments/assets/0ae5def4-1e91-4e93-8480-913f872f46b9)
![image](https://github.com/user-attachments/assets/6f950a1a-d171-47ce-b534-5f74f6b69007)
![image](https://github.com/user-attachments/assets/0a69ae10-0b5e-48c1-a0bc-a57ca14e06d5)
![image](https://github.com/user-attachments/assets/7c093f3c-5177-47b6-a4a3-68f2fe8c7361)
![image](https://github.com/user-attachments/assets/e544ea69-cf43-462c-bf50-a167d50d6bc6)
## Video 
https://we.tl/t-9UjenT2Kf0
## Conclusão:
O projeto Share bill visa criar uma aplicação que resolva de forma eficaz os problemas associados à partilha de despesas entre grupos. Os principais objetivos incluem a simplificação do processo de divisão de contas, a automatização de lembretes de pagamentos e a geração de relatórios detalhados. A aplicação será testada e otimizada para garantir uma experiência de utilizador clara e eficiente.

## Bibliografia:
1.	"Splitwise: Dividing Expenses for Friends and Groups." https://www.splitwise.com
2.	"Tricount: Expense Sharing Made Easy." https://www.tricount.com
3.	"Settle Up: Share Expenses with Friends." https://settleup.io





