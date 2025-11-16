-- Os blocos de inserts das tabelas devem ser executados em ordem:

-- 1) Tabela pessoa:
INSERT INTO pessoa (nompes, emapes, sexpes, telpes, ruapes, baipes, cidpes, estpes)
VALUES
('João Silva', 'joao.silva@gmail.com', 'M', '51990000001', 'Rua A', 'Centro', 'Porto Alegre', 'RS'),
('Maria Souza', 'maria.souza@gmail.com', 'F', '51990000002', 'Rua B', 'Centro', 'Porto Alegre', 'RS'),
('Carlos Lima', 'carlos.lima@gmail.com', 'M', '51990000003', 'Rua C', 'Centro', 'Porto Alegre', 'RS'),
('Ana Pereira', 'ana.pereira@gmail.com', 'F', '51990000004', 'Rua D', 'Centro', 'Porto Alegre', 'RS'),
('Fernanda Costa', 'fernanda.costa@gmail.com', 'F', '51990000005', 'Rua E', 'Centro', 'Porto Alegre', 'RS');

-- 2) Tabela loja:
INSERT INTO loja (nomloj, rualoj, bailoj, cidloj, telloj, cnploj)
VALUES
('Loja Central', 'Rua Principal, 100', 'Centro', 'Porto Alegre', '5133334444', '11111111000101'),
('Loja Norte', 'Av Brasil, 200', 'Norte', 'Porto Alegre', '5133334445', '22222222000102'),
('Loja Sul', 'Rua Sul, 300', 'Sul', 'Porto Alegre', '5133334446', '33333333000103'),
('Loja Oeste', 'Rua Oeste, 400', 'Oeste', 'Porto Alegre', '5133334447', '44444444000104'),
('Loja Leste', 'Av Leste, 500', 'Leste', 'Porto Alegre', '5133334448', '55555555000105');

-- 3) Tabela cliente:
INSERT INTO cliente (codcli, cpfcli, datcadcli)
VALUES
(1, '00000000101', NOW()),
(2, '00000000202', NOW()),
(3, '00000000303', NOW()),
(4, '00000000404', NOW()),
(5, '00000000505', NOW());

-- 4) Tabela fornecedor:
INSERT INTO fornecedor (codfor, cnpfor, nomfanfor)
VALUES
(3, '10000000000001', 'Fornecedor A'),
(4, '20000000000002', 'Fornecedor B'),
(5, '30000000000003', 'Fornecedor C'),
(1, '40000000000004', 'Fornecedor D'),
(2, '50000000000005', 'Fornecedor E');

-- 5) Tabela funcionario:
INSERT INTO funcionario (codfun, cpffun, carfun, datadmfun, senfun, codloj)
VALUES
(1, '11111111111', 'Gerente', NOW(), '1234', 1),
(2, '22222222222', 'Vendedor', NOW(), 'abcd', 2),
(3, '33333333333', 'Caixa', NOW(), 'senha1', 3),
(4, '44444444444', 'Estoquista', NOW(), 'senha2', 4),
(5, '55555555555', 'Vendedor', NOW(), 'senha3', 5);

-- 6) Tabela produto:
INSERT INTO produto 
(nompro, tampro, corpro, tipro, custpro, vendpro, qtdestpro, datcadpro, despro, codloj, codfor)
VALUES
('Camisa Polo', 'M', 'Azul', 'Vestuário', 30.00, 59.90, 20, NOW(), 'Camisa básica polo', 1, 3),
('Calça Jeans', '42', 'Azul', 'Vestuário', 50.00, 99.90, 15, NOW(), 'Jeans tradicional', 2, 4),
('Tênis Running', '40', 'Preto', 'Calçados', 70.00, 149.90, 10, NOW(), 'Tênis esportivo', 3, 5),
('Boné Aba Reta', 'Único', 'Preto', 'Acessórios', 15.00, 29.90, 25, NOW(), 'Boné estiloso', 4, 1),
('Moletom Canguru', 'G', 'Cinza', 'Vestuário', 60.00, 129.90, 8, NOW(), 'Moletom confortável', 5, 2);

-- 7) Tabela venda:
INSERT INTO venda (datven, totven, fompagven, cupdscven, codcli, codfun)
VALUES
(NOW(), 199.90, 'Pix', 10.00, 1, 1),
(NOW(), 89.90, 'Credito', NULL, 2, 2),
(NOW(), 59.90, 'Debito', 5.00, 3, 3),
(NOW(), 129.90, 'Dinheiro', NULL, 4, 4),
(NOW(), 49.90, 'Pix', NULL, 5, 5);

-- 8) Tabela desconto:
INSERT INTO desconto (nomdsc, valdsc, caddsc, vlddsc, codven)
VALUES
('Desconto Verão', 10.00, NOW(), '2025-12-31', 1),
('Cupom Cliente', 5.00, NOW(), '2025-12-31', 2),
('Desconto Relâmpago', 7.00, NOW(), '2025-12-31', 3),
('Promoção Especial', 15.00, NOW(), '2025-12-31', 4),
('Cupom Novo Cliente', 8.00, NOW(), '2025-12-31', 5);

-- 9) Tabela condicional:
INSERT INTO condicional (nomitncon, datretitncon, datdevitncon, obsitncon, codcli)
VALUES
('Camisa Polo', NOW(), NOW() + INTERVAL '5 days', 'Sem observações', 1),
('Calça Jeans', NOW(), NOW() + INTERVAL '7 days', 'Cliente pediu reserva', 2),
('Tênis Running', NOW(), NOW() + INTERVAL '3 days', NULL, 3),
('Boné Aba Reta', NOW(), NOW() + INTERVAL '4 days', NULL, 4),
('Moletom Canguru', NOW(), NOW() + INTERVAL '6 days', 'Cliente interessado', 5);

-- 10) Tabela item_condicional:
INSERT INTO item_condicional (qtditecon, codcnd, codpro)
VALUES
(1, 1, 1),
(2, 2, 2),
(1, 3, 3),
(1, 4, 4),
(2, 5, 5);

-- 11) Tabela item_venda:
INSERT INTO item_venda (qtditeven, vlruniteven, vlrtotiteven, codven, codpro)
VALUES
(1, 59.90, 59.90, 1, 1),
(1, 89.90, 89.90, 2, 2),
(1, 59.90, 59.90, 3, 3),
(1, 129.90, 129.90, 4, 4),
(1, 49.90, 49.90, 5, 5);
