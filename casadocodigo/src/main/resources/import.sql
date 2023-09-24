INSERT INTO tb_categoria (nome) VALUES ('Comédia');
INSERT INTO tb_categoria (nome) VALUES ('Investimentos');
INSERT INTO tb_categoria (nome) VALUES ('Terror');
INSERT INTO tb_categoria (nome) VALUES ('Ficção');

INSERT INTO tb_autor (nome, descricao, email, instante_criacao) VALUES ('Ariano Suassuna', 'Um autor muito top!', 'ari@gmail.com', '2023-07-13');
INSERT INTO tb_autor (nome, descricao, email, instante_criacao) VALUES ('Stephen King', 'Um autor muito top!', 'stephen@gmail.com', '2023-07-13');
INSERT INTO tb_autor (nome, descricao, email, instante_criacao) VALUES ('Robert Kyosaki', 'Um autor muito top!', 'robert@gmail.com', '2023-07-13');
INSERT INTO tb_autor (nome, descricao, email, instante_criacao) VALUES ('George R.R Martir', 'Um autor muito top!', 'george@gmail.com', '2023-07-13');

INSERT INTO tb_pais(nome) VALUES ('Brasil');
INSERT INTO tb_pais(nome) VALUES ('Argentina');
INSERT INTO tb_pais(nome) VALUES ('Equador');
INSERT INTO tb_pais(nome) VALUES ('Colômbia');

INSERT INTO tb_estado(nome, pais_id) VALUES ('Pará', 1);
INSERT INTO tb_estado(nome, pais_id) VALUES ('Maranhão', 1);
INSERT INTO tb_estado(nome, pais_id) VALUES ('Chimborazo', 3);

INSERT INTO tb_livro (titulo, resumo, sumario, preco, paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('Game of Thrones', 'Livro muito bom.', 'O foco central de GoT acomapanha o jogo político em Westeros, o continente de um mundo fantástico onde há regiões governadas por Casas nobres. Há sete reinos que estão sob a liderança do rei ocupante do Trono de Ferro, uma posição alta e desejada entre boa parte das famílias.', 60.00, 110, 'PA312123', '2024-10-11', 4, 4);
INSERT INTO tb_livro (titulo, resumo, sumario, preco, paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('Pai Rico, Pai Pobre', 'Livro muito bom.', 'Pai Rico, Pai Pobre � o primeiro best-seller de Robert Kiyosaki e Sharon Lechter. Ele advoga a busca pela independ�ncia financeira atrav�s de investimento, im�veis, ter seu pr�prio neg�cio e o uso de t�ticas financeiras de prote��o do patrim�nio.', 61.50, 85, 'PA311123', '2024-10-11', 2, 3);
INSERT INTO tb_livro (titulo, resumo, sumario, preco, paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('IT - A Coisa', 'Livro muito bom.', 'It � um romance de terror de 1986 do autor estadunidense Stephen King. Foi seu 22� livro e seu 17� romance escrito em seu pr�prio nome. A hist�ria segue as experi�ncias de sete crian�as, que s�o aterrorizadas por uma entidade maligna que explora os medos de suas v�timas para se disfarçar enquanto ca�am suas presas.', 67.50, 110, 'PA312103', '2024-10-11', 3, 2);
INSERT INTO tb_livro (titulo, resumo, sumario, preco, paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('O Auto da Compadecida', 'Livro muito bom.', 'Auto da Compadecida � uma pe�a teatral em forma de auto, em tr�s atos, escrita pelo autor brasileiro Ariano Suassuna em 1955. Sua primeira encena��o aconteceu em 1956, no Recife, em Pernambuco. A pe�a tamb�m foi encenada em 1974, com dire��o de Jo�o C�ndido.', 24.00, 190, 'PA812123', '2024-10-11', 1, 1);