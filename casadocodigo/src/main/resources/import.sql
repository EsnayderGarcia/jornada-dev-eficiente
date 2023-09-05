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

INSERT INTO tb_livro (titulo, resumo, sumario, preco, paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('Game of Thrones', 'Livro muito bom.', 'O foco central de GoT acomapanha o jogo político em Westeros, o continente de um mundo fantástico onde há regiões governadas por Casas nobres. Há sete reinos que estão sob a liderança do rei ocupante do Trono de Ferro, uma posição alta e desejada entre boa parte das famílias.', 58.40, 110, 'PA312123', '2024-10-11', 4, 4);
INSERT INTO tb_livro (titulo, resumo, sumario, preco, paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('Pai Rico, Pai Pobre', 'Livro muito bom.', 'Pai Rico, Pai Pobre é o primeiro best-seller de Robert Kiyosaki e Sharon Lechter. Ele advoga a busca pela independência financeira através de investimento, imóveis, ter seu próprio negócio e o uso de táticas financeiras de proteção do patrimônio.', 61.50, 85, 'PA311123', '2024-10-11', 2, 3);
INSERT INTO tb_livro (titulo, resumo, sumario, preco, paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('IT - A Coisa', 'Livro muito bom.', 'It é um romance de terror de 1986 do autor estadunidense Stephen King. Foi seu 22º livro e seu 17º romance escrito em seu próprio nome. A história segue as experiências de sete crianças, que são aterrorizadas por uma entidade maligna que explora os medos de suas vítimas para se disfarçar enquanto caçam suas presas.', 67.50, 110, 'PA312103', '2024-10-11', 3, 2);
INSERT INTO tb_livro (titulo, resumo, sumario, preco, paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES ('O Auto da Compadecida', 'Livro muito bom.', 'Auto da Compadecida é uma peça teatral em forma de auto, em três atos, escrita pelo autor brasileiro Ariano Suassuna em 1955. Sua primeira encenação aconteceu em 1956, no Recife, em Pernambuco. A peça também foi encenada em 1974, com direção de João Cândido.', 24.00, 190, 'PA812123', '2024-10-11', 1, 1);