-- Criando procedure para calcular o total da venda com desconto:
create or replace function venda_desconto(total numeric, desconto numeric)
returns numeric
as
$Body$
declare
	resultado numeric(10, 2);

begin
	resultado := ((total) - (total * (desconto / 100))); 

	return resultado;
end
$Body$
language plpgsql;

-- Teste da procedure:
select
    v.codven,
    venda_desconto(v.totven, d.valdsc) "Total Com Desconto"
from Venda v
join Desconto d on d.coddsc = v.coddsc;

-- Valor total de cada produto em estoque:
create or replace function total_cada_produto(qtd_produto int4, vlr_produto numeric(6,2))
returns numeric
as
$Body$
declare
	resultado numeric (10, 2);

begin
	resultado := (qtd_produto * vlr_produto);

	return resultado;
end
$Body$
language plpgsql;

-- Teste da procedure:
select
	p.nompro "Nome do Produo", p.qtdestpro "Quantidade em Estoque", p.vendpro "Preço de Venda",
	total_cada_produto(p.qtdestpro, p.vendpro) "Valor Total"
from produto p;
