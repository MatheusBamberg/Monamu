--Liste o nome do produto, categoria, tamanho, preço de venda 
-- e quantidade em estoque de todos os produtos disponíveis para venda. 
-- Ordene os resultados por nome do produto.

create or replace view lista_produtos
as
select 
nompro "Nome do Produto", 
tipro "Tipo", 
tampro "Tamanho", 
vendpro "Preço de Venda", 
qtdestpro "Quantidade em Estoque"
from 
produto p 
order by 
nompro;

select * from lista_produtos;


--Liste o nome do cliente, a data da compra, os produtos comprados e o valor total de cada compra. 
--Exiba apenas as compras do cliente selecionado. 
--Ordene pela data da compra, da mais recente para a mais antiga.
--**Objetivo técnico:** Usar JOIN, WHERE e ORDER BY.

create or replace view lista_clientes
as
select 
nompes "Nome do Cliente", 
datven "Data da Venda", 
nompro "Nome do Produto", 
vlrtotiteven "Valor total da Venda"
from 
cliente c
inner join pessoa pe on c.codcli = pe.codpes
inner join venda v on c.codcli  = v.codcli
inner join item_venda iv on v.codven  = iv.codven
inner join produto p on iv.codpro = p.codpro
where 
c.codcli = '1'
order by 
datven desc;

select * from lista_clientes;


--Liste o nome do funcionário, a data da venda, os produtos vendidos 
-- e o valor total de cada venda realizada em um período definido. 
--Ordene por nome do funcionário e, dentro do funcionário, por data da venda.
--**Objetivo técnico:** Usar JOIN, WHERE (filtro por período) e ORDER BY.

create or replace view venda_dos_funcionarios
as
select 
nompes "Nome do Funcionário", 
datven "Data da Venda", 
nompro "Nome do Produto", 
vlrtotiteven "Valor Total da Venda"
from 
funcionario f 
inner join pessoa pe on f.codpes = pe.codpes
inner join venda v on f.codpes = v.codfun
inner join item_venda iv on v.codven = iv.codven
inner join produto p on iv.codpro = p.codpro
where v.datven between '01/01/2025' and '02/12/2025'
order by 
pe.nompes, 
v.datven;

select * from venda_dos_funcionarios;


--Mostre, para cada categoria de produto, 
-- a quantidade total vendida
-- e o valor total faturado em um período definido. 
--Liste apenas as categorias com vendas registradas
-- e ordene pelo maior valor faturado.
--Usar JOIN, GROUP BY, SUM, HAVING e ORDER BY.

create or replace view venda_por_categoria
as
select 
p.tipro "Tipo",
sum(qtditeven) "Quantidade vendida",
sum (vlrtotiteven ) "Faturamento Total"
from produto p 
inner join item_venda iv  on p.codpro = iv.codpro
inner join venda v on iv.codven = v.codven
where v.datven between '01/01/2024' and '31/12/2025'
group by tipro
order by 3 desc;

select * from venda_por_categoria;
