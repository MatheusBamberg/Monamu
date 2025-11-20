-- Criação dos Grupos de Funcionários:
create group gerente;
create group funcionario;

-- Atribuição das Permissões sobre as Tabelas:
grant select, insert, delete, update
on cliente, condicional, desconto, fornecedor, funcionario, item_condicional, item_venda, loja, pessoa, venda
to gerente;

grant select
on desconto_log, venda_log
to gerente;

grant select, insert, update
on cliente, condicional, desconto, item_condicional, item_venda, pessoa, produto, venda
to funcionario;