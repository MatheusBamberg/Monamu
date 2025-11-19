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

-- Trigger para controle de Integridade do Sistema. Confirmação de Deleção de Clientes:
create or replace function confirmacao_delete()
returns trigger
as
$Body$
begin
	if TG_OP = 'DELETE' then
		if current_setting('app.confirma_delete', true) is distinct from ('true') then
			raise exception 'Delete bloqueado: necessário confirmar antes de executar.';
		end if;
	end if;
	
	return OLD;
end
$Body$
language plpgsql;

drop trigger if exists delete_cliente_bf_tg on cliente;

-- Inserindo Trigger:
create trigger delete_cliente_bf_tg
before delete
on cliente
for each row
execute procedure confirmacao_delete();

-- Testes
--Inserts para testar
select * from cliente;
select * from pessoa;

insert into pessoa (nompes, emapes, sexpes, telpes, ruapes, baipes, cidpes, estpes)
values ('carlos', 'carlos@gmail.com', 'M', '9', 'rur', 'la', 'aqui', 'sc');

insert into cliente (codcli, cpfcli, datcadcli)
values (6, '21512577', current_timestamp);


delete from cliente
where codcli = 6;

begin;

set local app.confirma_delete = true;
delete from cliente
where codcli = 6;

rollback;