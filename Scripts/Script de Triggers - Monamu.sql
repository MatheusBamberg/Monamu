-- Criando os Triggers:
-- Trigger que Mostra quem fez e o que fez na tabela Descontos:
create or replace function desconto_trigger()
returns trigger
as
$Body$
begin
	insert into desconto_log (opelog, usudeslog, datdeslog, antdeslog, depdeslog)
	values (TG_OP, current_user, current_timestamp, old::text, new::text);

	if TG_OP = ('DELETE') then
		return OLD;
	else
		return NEW;
	end if;
end
$Body$
language plpgsql;

--Inserindo trigger na tabela Desconto depois da operação:
create trigger desconto_bf_tg 
before insert or update or delete
on desconto
for each row
execute procedure desconto_trigger();

------------------------------------------------------------------------
-- Teste do log
select * from desconto_log;
select * from desconto;

update desconto 
set valdsc = 25 
where coddsc = 1;

insert into desconto (nomdsc, valdsc, caddsc, vlddsc, codven)
values ( 'Black Friday', 25, current_timestamp, '2025-12-20', 5);

delete from desconto 
where coddsc = 7;

-----------------------------------------------------------------------

-- Trigger para controle de Integridade do Sistema. Confirmação de Deleção de Clientes:
create or replace function Venda_trigger()
returns trigger
as
$Body$
begin
	insert into venda_log (opevenlog, usuvenlog, datvenlog, antvenlog, depvenlog)
	values (TG_OP, current_user, current_timestamp, old::text, new::text);

	if TG_OP = ('DELETE') then
		return OLD;
	else
		return NEW;
	end if;
end
$Body$
language plpgsql;

-- Inserindo o trigger:
create trigger venda_bf_tg 
before insert or update or delete
on venda
for each row
execute procedure venda_trigger();

-- Testando log:
select * from venda_log;
select * from venda;

insert into venda (datven, totven, fompagven, cupdscven, codcli, codfun)
values (current_timestamp, 2, 'Dinheiro', 1, 1, 3);

update venda
set totven = 40
where codven = 6;

delete from venda 
where codven = 6;