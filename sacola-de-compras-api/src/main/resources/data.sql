INSERT INTO restaurante (id, cep, complemento, nome) VALUES
(10001L, '0000001', 'Rua Um', 'Hamburgueria'),
(10002L, '0000002', 'Rua Dois', 'Carrinho do Dogão'),
(10003L, '0000003', 'Rua Tres', 'Lanchonete'),
(10004L, '0000004', 'Rua Quatro', 'Pastelaria');

INSERT INTO cliente (id, cep, complemento, nome) VALUES
(90001L, '0000011', 'Rua Onze', 'João Batista'),
(90002L, '0000012', 'Rua Doze', 'Maria das Dores'),
(90003L, '0000013', 'Rua Treze', 'Nelson Rodrigues'),
(90004L, '0000014', 'Rua Quatorze', 'Sebastião Barbosa'),
(90005L, '0000015', 'Rua Quinze', 'Teresa Pereira');

INSERT INTO produto (id, disponivel, nome, valor_unitario, restaurante_id) VALUES
(20001L, true, 'X-Burgue', 7.5, 10001L),
(20002L, true, 'X-Salada', 9.5, 10001L),
(20003L, true, 'Refrigerante', 7.0, 10001L),
(20004L, true, 'Hot-Dog Simples', 7.3, 10002L),
(20005L, true, 'Hot-Dog Completo', 10.5, 10002L),
(20006L, true, 'Refrigerante', 6.9, 10002L),
(20007L, true, 'Coxinha', 6.0, 10003L),
(20008L, true, 'Coxinha c/ Catupiri', 6.5, 10003L),
(20009L, true, 'Refrigerante', 7.3, 10003L),
(20010L, true, 'Pastel Simples', 6.8, 10004L),
(20011L, true, 'Pastel Completo', 9.8, 10004L),
(20012L, true, 'Refrigerante 3', 6.9, 10004L);

INSERT INTO sacola (id, forma_pagamento, fechada, valor_total, cliente_id) VALUES
(30001L, 0, false, 0.0, 90001L),
(30002L, 0, false, 0.0, 90002L),
(30003L, 0, false, 0.0, 90003L),
(30004L, 0, false, 0.0, 90004L),
(30005L, 0, false, 0.0, 90005L);