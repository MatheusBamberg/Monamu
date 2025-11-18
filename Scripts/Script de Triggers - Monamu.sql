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
select * from venda;

update desconto 
set valdsc = 25 
where coddsc = 1;

insert into desconto (nomdsc, valdsc, caddsc, vlddsc, codven)
values ( 'Black Friday', 25, current_timestamp, '2025-12-20', 5);

delete from desconto 
where coddsc = 7;
-----------------------------------------------------------------------

