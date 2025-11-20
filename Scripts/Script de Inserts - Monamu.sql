-- Os blocos de inserts das tabelas devem ser executados em ordem:

-- 1) Tabela pessoa:
INSERT INTO Pessoa (nompes, emapes, sexpes, telpes, ruapes, baipes, cidpes, estpes) 
VALUES
('Matheus Andrade', 'matheus@gmail.com', 'M', '51999990001', 'Rua Central 100', 'Centro', 'Porto Alegre', 'RS'),
('Julia Martins', 'julia.martins@email.com', 'F', '51999990002', 'Rua Flores 200', 'Jardim', 'Canoas', 'RS'),
('Carlos Ferreira', 'carlosf@gmail.com', 'M', '51999990003', 'Av Brasil 300', 'Centro', 'Gravataí', 'RS'),
('Amanda Rocha', 'amanda.rocha@hotmail.com', 'F', '51999990004', 'Rua Sol 50', 'São José', 'Novo Hamburgo', 'RS'),
('Pedro Lima', 'pedro.lima@gmail.com', 'M', '51999990005', 'Rua Verde 89', 'Ideal', 'Canoas', 'RS');

-- 2) Tabela loja:
INSERT INTO Loja (nomloj, rualoj, bailoj, cidloj, telloj, cnploj) 
VALUES
('Loja Matriz', 'Av Principal 1000', 'Centro', 'Porto Alegre', '5133330001', '11222333000188'),
('Loja Norte', 'Rua Norte 400', 'São José', 'Canoas', '5133330002', '22333444000199'),
('Loja Sul', 'Av Sul 900', 'Centro', 'Novo Hamburgo', '5133330003', '33444555000100'),
('Loja Leste', 'Rua Leste 150', 'Jardim', 'São Leopoldo', '5133330004', '44555666000111'),
('Loja Oeste', 'Rua Oeste 600', 'Bela Vista', 'Gravataí', '5133330005', '55666777000122');

-- 3) Tabela cliente:
INSERT INTO Cliente (codcli, cpfcli, datcadcli) 
VALUES
(1, '12345678901', NOW()),
(2, '23456789012', NOW()),
(3, '34567890123', NOW()),
(4, '45678901234', NOW()),
(5, '56789012345', NOW());

-- 4) Tabela fornecedor:
INSERT INTO Fornecedor (codfor, cnpfor, nomfanfor) 
VALUES
(1, '12345678000111', 'Alpha Têxtil'),
(2, '23456789000122', 'Moda Sul'),
(3, '34567890000133', 'Estilo Livre'),
(4, '45678901000144', 'Fashion RS'),
(5, '56789012000155', 'Tecido & Cia');

-- 5) Tabela funcionario:
INSERT INTO Funcionario (codfun, cpffun, carfun, datadmfun, senfun, codloj) 
VALUES
(1, '99887766001', 'Vendedor', NOW(), 'senha123', 1),
(2, '99887766002', 'Gerente', NOW(), 'senhager', 2),
(3, '99887766003', 'Caixa', NOW(), 'senha321', 3),
(4, '99887766004', 'Vendedor', NOW(), 'senha456', 4),
(5, '99887766005', 'Supervisor', NOW(), 'senha789', 5);

-- 6) Tabela produto:
INSERT INTO Produto (nompro, tampro, corpro, tipro, custpro, vendpro, qtdestpro, datcadpro, despro, codloj, codfor)
VALUES
('Camiseta Polo Azul', 'M', 'Azul', 'Camiseta', 30.00, 59.90, 50, NOW(), 'Camiseta polo algodão', 1, 1),
('Calça Jeans Slim', '42', 'Azul', 'Calça', 80.00, 149.90, 30, NOW(), 'Jeans masculino slim', 2, 2),
('Jaqueta Couro Eco', 'G', 'Preto', 'Jaqueta', 120.00, 249.90, 20, NOW(), 'Jaqueta ecológica', 3, 3),
('Vestido Floral', 'M', 'Rosa', 'Vestido', 70.00, 139.90, 25, NOW(), 'Vestido leve floral', 4, 4),
('Tênis Esportivo', '41', 'Cinza', 'Calçado', 90.00, 179.90, 40, NOW(), 'Tênis para corrida', 5, 5);

-- 8) Tabela desconto:
INSERT INTO Desconto (nomdsc, valdsc, caddsc, vlddsc) 
VALUES
('Cupom Verão', 10.00, NOW(), '2025-12-31'),
('Promoção Inverno', 5.00, NOW(), '2025-07-30'),
('Black Friday', 20.00, NOW(), '2025-11-30'),
('Cupom Cliente Novo', 15.00, NOW(), '2026-01-01'),
('Cupom Aniversário', 12.00, NOW(), '2025-05-30');

-- 7) Tabela venda:
INSERT INTO Venda (datven, totven, fompagven, cupdscven, codcli, codfun, coddsc) 
VALUES
(NOW(), 199.90, 'Pix', 10.00, 1, 1, 1),
(NOW(), 349.90, 'Credito', 5.00, 2, 2, 2),
(NOW(), 129.90, 'Debito', 20.00, 3, 3, 3),
(NOW(), 249.90, 'Dinheiro', 15.00, 4, 4, 4),
(NOW(), 159.90, 'Pix', 12.00, 5, 5, 5);

-- 9) Tabela condicional:
INSERT INTO Condicional (nomitncon, datretitncon, datdevitncon, obsitncon, codcli) 
VALUES
('2 Camisetas Polo', NOW(), NOW() + INTERVAL '7 days', 'Cliente levou para experimentar', 1),
('1 Jaqueta Couro', NOW(), NOW() + INTERVAL '5 days', 'Cliente irá decidir', 2),
('3 Tênis Esportes', NOW(), NOW() + INTERVAL '10 days', 'Pode devolver sem caixa', 3),
('1 Vestido Floral', NOW(), NOW() + INTERVAL '4 days', 'Cliente pediu reserva', 4),
('2 Calças Jeans', NOW(), NOW() + INTERVAL '6 days', NULL, 5);

-- 10) Tabela item_condicional:
INSERT INTO item_condicional (qtditecon, codcnd, codpro) 
VALUES
(2, 1, 1),
(1, 2, 3),
(3, 3, 5),
(1, 4, 4),
(2, 5, 2);

select * from venda;

-- 11) Tabela item_venda:
INSERT INTO item_venda (qtditeven, vlruniteven, vlrtotiteven, codven, codpro) 
VALUES
(2, 59.90, 119.80, 1, 1),
(1, 149.90, 149.90, 2, 2),
(1, 129.90, 129.90, 3, 3),
(1, 139.90, 139.90, 4, 4),
(1, 179.90, 179.90, 5, 5);
