--Loja
create or replace view vw_loja
as
select 
nomloj,
cnploj,
telloj,
rualoj,
bailoj,
cidloj
from loja l;

select * from vw_loja;

--Fornecedor
create or replace view vw_fornecedor
as
select
p.nompes,
f.cnpfor,
p.telpes,
p.emapes,
f.nomfanfor,
p.sexpes,
p.ruapes,
p.baipes,
p.cidpes,
p.estpes
from fornecedor f
inner join pessoa p on f.codfor = p.codpes;

select * from vw_fornecedor;

--Funcionários
create or replace view vw_funcionario
as 
select
p.nompes,
f.cpffun,
f.carfun,
p.emapes,
f.datadmfun,
p.sexpes,
p.ruapes,
p.baipes,
p.cidpes,
p.estpes
from funcionario f
inner join pessoa p on f.codpes = p.codpes;

select * from vw_funcionario;

--Descontos
create or replace view vw_desconto
as
select
d.nomdsc,
d.valdsc,
d.caddsc,
d.vlddsc
from desconto d;

select * from vw_desconto;

select * from cliente;
select * from condicional;
select * from item_condicional ic;
--Condicional
create or replace view vw_condicional
as
select
p.nompes,
co.nomitncon,
co.datretitncon,
co.datdevitncon,
co.obsitncon,
co.devitncon
from condicional co
inner join cliente c on co.codcli = c.codcli
inner join pessoa p on c.codcli = p.codpes;

select * from vw_condicional;

--Clientes
create or replace view vw_cliente
as
select
p.nompes,
c.cpfcli,
p.telpes,
p.emapes,
p.sexpes,
c.datcadcli,
p.ruapes,
p.baipes,
p.cidpes,
p.estpes
from cliente c
inner join pessoa p on p.codpes = c.codcli;

select * from vw_cliente;

--Vendas
create or replace view vw_venda
as
select
p.nompes "Nome do Cliente",
p2.nompes "Nome do Funcionario",
v.datven,
v.fompagven,
d.nomdsc,
v.totven,
pr.nompro,
iv.qtditeven,
iv.vlrtotiteven from venda v
inner join cliente c on v.codcli = c.codcli
inner join pessoa p on p.codpes = c.codcli
inner join funcionario f on v.codfun = f.codpes
inner join pessoa p2 on f.codpes = p2.codpes
inner join desconto d on v.coddsc = d.coddsc
inner join item_venda iv on v.codven = iv.codven
inner join produto pr on iv.codpro = iv.codpro;

select * from vw_venda;

select * from loja;
select * from produto;
--Produto
create or replace view vw_produto
as
select
p.nompro,
p.tampro,
p.corpro,
p.tipro,
p.custpro,
p.vendpro,
p.datcadpro,
p.qtdestpro,
p.despro,
pe.nompes,
l.nomloj
from produto p
inner join fornecedor f on p.codfor = f.codfor
inner join pessoa pe on f.codfor = pe.codpes
inner join loja l on p.codloj = l.codloj;

select * from vw_produto;
