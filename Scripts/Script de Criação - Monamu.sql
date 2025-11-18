-- Criação do Banco de Dados:

create database monamu;

----------------------------------------
-- Criação das Tabelas

CREATE TABLE cliente (
  codcli    int4 NOT NULL, 
  cpfcli    varchar(11) NOT NULL UNIQUE, 
  datcadcli timestamp NOT NULL, 
  CONSTRAINT pkey_cliente 
    PRIMARY KEY (codcli));
COMMENT ON TABLE cliente IS 'Cadastros de Clientes';
COMMENT ON COLUMN cliente.codcli IS 'Código do Cliente';
COMMENT ON COLUMN cliente.cpfcli IS 'CPF do Cliente';
COMMENT ON COLUMN cliente.datcadcli IS 'Data do cadastro do Cliente';

CREATE TABLE condicional (
  codcnd       SERIAL NOT NULL, 
  nomitncon    varchar(40) NOT NULL, 
  datretitncon timestamp NOT NULL, 
  datdevitncon timestamp NOT NULL, 
  obsitncon    varchar(150), 
  codcli       int4 NOT NULL, 
  CONSTRAINT pkey_condicional 
    PRIMARY KEY (codcnd));
COMMENT ON TABLE condicional IS 'Cadastros de itens levados no Condicional';
COMMENT ON COLUMN condicional.codcnd IS 'Código do Condicional';
COMMENT ON COLUMN condicional.nomitncon IS 'Nome dos itens levados no Condicional';
COMMENT ON COLUMN condicional.datretitncon IS 'Data da retirada do item no condicional';
COMMENT ON COLUMN condicional.datdevitncon IS 'Data da devolução do item no condicional';
COMMENT ON COLUMN condicional.obsitncon IS 'Observações do condicional';

CREATE TABLE desconto (
  coddsc SERIAL NOT NULL, 
  nomdsc varchar(40) NOT NULL, 
  valdsc numeric(4, 2) NOT NULL, 
  caddsc timestamp NOT NULL, 
  vlddsc date NOT NULL, 
  codven int4 NOT NULL, 
  CONSTRAINT pkey_desconto 
    PRIMARY KEY (coddsc));
COMMENT ON TABLE desconto IS 'Cadastros de Descontos';
COMMENT ON COLUMN desconto.coddsc IS 'Código do Desconto';
COMMENT ON COLUMN desconto.nomdsc IS 'Nome do Desconto (Ex. Cupom de Páscoa)';
COMMENT ON COLUMN desconto.valdsc IS 'Valor do Desconto em porcentagem';
COMMENT ON COLUMN desconto.caddsc IS 'Data de inicio da validade do Desconto';
COMMENT ON COLUMN desconto.vlddsc IS 'Validade do Desconto';

CREATE TABLE fornecedor (
  codfor    int4 NOT NULL, 
  cnpfor    varchar(14) NOT NULL UNIQUE, 
  nomfanfor varchar(80), 
  CONSTRAINT pkey_fornecedor 
    PRIMARY KEY (codfor));
COMMENT ON TABLE fornecedor IS 'Cadastro de Fornecedores';
COMMENT ON COLUMN fornecedor.codfor IS 'Código do Fornecedor';
COMMENT ON COLUMN fornecedor.cnpfor IS 'CNPJ do Fornecedor';
COMMENT ON COLUMN fornecedor.nomfanfor IS 'Nome Fantasia do Fornecedor';

CREATE TABLE funcionario (
  codfun    int4 NOT NULL, 
  cpffun    varchar(11) NOT NULL UNIQUE, 
  carfun    varchar(40) NOT NULL, 
  datadmfun timestamp NOT NULL, 
  senfun    varchar(20) NOT NULL, 
  codloj    int4 NOT NULL, 
  CONSTRAINT pkey_funcionario 
    PRIMARY KEY (codfun));
COMMENT ON TABLE funcionario IS 'Cadastros de Funcionarios';
COMMENT ON COLUMN funcionario.codfun IS 'Código do Funcionário';
COMMENT ON COLUMN funcionario.cpffun IS 'CPF do Funcionario';
COMMENT ON COLUMN funcionario.carfun IS 'Cargo do Funcionario';
COMMENT ON COLUMN funcionario.datadmfun IS 'Data de admissão do Funcionairo, ela será feita juntamente com o cadastro do mesmo';
COMMENT ON COLUMN funcionario.senfun IS 'Senha do funcionário';

CREATE TABLE item_condicional (
  coditecon SERIAL NOT NULL, 
  qtditecon int4 NOT NULL, 
  codcnd    int4 NOT NULL, 
  codpro    int4 NOT NULL, 
  CONSTRAINT pkey_item_condicional 
    PRIMARY KEY (coditecon));
COMMENT ON COLUMN item_condicional.coditecon IS 'Código do item no condicional';
COMMENT ON COLUMN item_condicional.qtditecon IS 'Quantidade de item no condicional';

CREATE TABLE item_venda (
  coditeven    SERIAL NOT NULL, 
  qtditeven    int4 NOT NULL, 
  vlruniteven  numeric(6, 2) NOT NULL, 
  vlrtotiteven numeric(6, 2) NOT NULL, 
  codven       int4 NOT NULL, 
  codpro       int4 NOT NULL, 
  CONSTRAINT pkey_item_venda 
    PRIMARY KEY (coditeven));
COMMENT ON TABLE item_venda IS 'Item com a venda';
COMMENT ON COLUMN item_venda.coditeven IS 'Código do item venda';
COMMENT ON COLUMN item_venda.qtditeven IS 'Quantidade de item por venda';
COMMENT ON COLUMN item_venda.vlruniteven IS 'Preço unitário na venda';
COMMENT ON COLUMN item_venda.vlrtotiteven IS 'Valor total dos itens por venda';

CREATE TABLE loja (
  codloj SERIAL NOT NULL, 
  nomloj varchar(80) NOT NULL, 
  rualoj varchar(100) NOT NULL, 
  bailoj varchar(40) NOT NULL, 
  cidloj varchar(40) NOT NULL, 
  telloj varchar(20) NOT NULL, 
  cnploj varchar(14) NOT NULL UNIQUE, 
  CONSTRAINT pkey_loja 
    PRIMARY KEY (codloj));
COMMENT ON TABLE loja IS 'Cadastro de lojas';
COMMENT ON COLUMN loja.codloj IS 'Código da loja';
COMMENT ON COLUMN loja.nomloj IS 'Nome da loja';
COMMENT ON COLUMN loja.rualoj IS 'Rua do endereço da loja';
COMMENT ON COLUMN loja.bailoj IS 'Bairro do endereço da loja';
COMMENT ON COLUMN loja.cidloj IS 'Cidade onde a loja está localizada';
COMMENT ON COLUMN loja.telloj IS 'Telefone da loja';
COMMENT ON COLUMN loja.cnploj IS 'CNPJ da loja';

CREATE TABLE pessoa (
  codpes SERIAL NOT NULL, 
  nompes varchar(80) NOT NULL, 
  emapes varchar(80) NOT NULL UNIQUE, 
  sexpes char(1) NOT NULL CHECK(sexpes in ('M', 'F')), 
  telpes varchar(20) NOT NULL, 
  ruapes varchar(100) NOT NULL, 
  baipes varchar(20) NOT NULL, 
  cidpes varchar(50) NOT NULL, 
  estpes varchar(20) NOT NULL, 
  CONSTRAINT pkey_pessoa 
    PRIMARY KEY (codpes));
COMMENT ON TABLE pessoa IS 'Tabelas de cadastro de Pessoas';
COMMENT ON COLUMN pessoa.nompes IS 'Nome da Pessoa';
COMMENT ON COLUMN pessoa.emapes IS 'Email da Pessoa';
COMMENT ON COLUMN pessoa.sexpes IS 'Sexo da Pessoa';
COMMENT ON COLUMN pessoa.telpes IS 'Telefone da Pessoa';
COMMENT ON COLUMN pessoa.ruapes IS 'Rua da Pessoa';
COMMENT ON COLUMN pessoa.baipes IS 'Bairro da Pessoa';
COMMENT ON COLUMN pessoa.cidpes IS 'Cidade da Pessoa';
COMMENT ON COLUMN pessoa.estpes IS 'Estado que a Pessoa mora';

CREATE TABLE produto (
  codpro    SERIAL NOT NULL, 
  nompro    varchar(100) NOT NULL UNIQUE, 
  tampro    varchar(10) NOT NULL, 
  corpro    varchar(40) NOT NULL, 
  tipro     varchar(40) NOT NULL, 
  custpro   numeric(6, 2) NOT NULL, 
  vendpro   numeric(6, 2) NOT NULL, 
  qtdestpro int4 NOT NULL, 
  datcadpro timestamp NOT NULL, 
  despro    text, 
  atipro    bool DEFAULT 'TRUE' NOT NULL CHECK(atipro in (TRUE, FALSE)), 
  codloj    int4 NOT NULL, 
  codfor    int4 NOT NULL, 
  CONSTRAINT pkey_produto 
    PRIMARY KEY (codpro));
COMMENT ON TABLE produto IS 'Cadastro dos produtos';
COMMENT ON COLUMN produto.nompro IS 'Nome do produto';
COMMENT ON COLUMN produto.tampro IS 'Tamanho do produto. P, M, G ou medidas';
COMMENT ON COLUMN produto.corpro IS 'Cor do produto';
COMMENT ON COLUMN produto.tipro IS 'Tipo do produto.';
COMMENT ON COLUMN produto.custpro IS 'Preço de custo do produto';
COMMENT ON COLUMN produto.vendpro IS 'Preço de venda do produto';
COMMENT ON COLUMN produto.qtdestpro IS 'Quantidade em estoque do produto';
COMMENT ON COLUMN produto.datcadpro IS 'Data do cadastro do produto';
COMMENT ON COLUMN produto.despro IS 'Descrição do produto';
COMMENT ON COLUMN produto.atipro IS 'TRUE: produto ativo e FALSE: produto inativo';

CREATE TABLE venda (
  codven    SERIAL NOT NULL, 
  datven    timestamp NOT NULL, 
  totven    numeric(6, 2) NOT NULL, 
  fompagven varchar(20) NOT NULL CHECK(fompagven in ('Dinheiro', 'Credito', 'Debito', 'Pix')), 
  cupdscven numeric(5, 2), 
  codcli    int4 NOT NULL, 
  codfun    int4 NOT NULL, 
  CONSTRAINT pkey_venda 
    PRIMARY KEY (codven));
COMMENT ON TABLE venda IS 'Cadastro de Vendas';
COMMENT ON COLUMN venda.codven IS 'Código da Venda';
COMMENT ON COLUMN venda.datven IS 'Data da Venda';
COMMENT ON COLUMN venda.totven IS 'Valor total da Venda';
COMMENT ON COLUMN venda.fompagven IS 'Forma de pagamento da Venda.
(Dinheiro, Crédito, Débito, Pix)';
COMMENT ON COLUMN Venda.cupdscven IS 'Cupom de desconto da Venda para clientes cadastrados';
ALTER TABLE cliente ADD CONSTRAINT cliente_codpes_fkey_001 FOREIGN KEY (codcli) REFERENCES pessoa (codpes);
ALTER TABLE condicional ADD CONSTRAINT condicional_ccodcli_fkey_001 FOREIGN KEY (codcli) REFERENCES cliente (codcli);
ALTER TABLE desconto ADD CONSTRAINT desconto_codven_fkey_001 FOREIGN KEY (codven) REFERENCES venda (codven);
ALTER TABLE fornecedor ADD CONSTRAINT fornecedor_codpes_fkey_001 FOREIGN KEY (codfor) REFERENCES pessoa (codpes);
ALTER TABLE funcionario ADD CONSTRAINT funcionario_codloj_fkey_001 FOREIGN KEY (codloj) REFERENCES loja (codloj);
ALTER TABLE funcionario ADD CONSTRAINT funcionario_codpes_fkey_001 FOREIGN KEY (codfun) REFERENCES pessoa (codpes);
ALTER TABLE item_condicional ADD CONSTRAINT "item_condicional_codcnd_fkey_002
" FOREIGN KEY (codcnd) REFERENCES condicional (codcnd);
ALTER TABLE item_condicional ADD CONSTRAINT "item_condicional_codpro_fkey_001
" FOREIGN KEY (codpro) REFERENCES produto (codpro);
ALTER TABLE item_venda ADD CONSTRAINT item_venda_codpro_fkey_001 FOREIGN KEY (codpro) REFERENCES produto (codpro);
ALTER TABLE item_venda ADD CONSTRAINT item_venda_codven_fkey_002 FOREIGN KEY (codven) REFERENCES venda (codven);
ALTER TABLE produto ADD CONSTRAINT produto_codfor_fkey_001 FOREIGN KEY (codfor) REFERENCES fornecedor (codfor);
ALTER TABLE produto ADD CONSTRAINT produto_coloj_fkey_002 FOREIGN KEY (codloj) REFERENCES loja (codloj);
ALTER TABLE venda ADD CONSTRAINT venda_codcli_fkey_002 FOREIGN KEY (codcli) REFERENCES cliente (codcli);
ALTER TABLE venda ADD CONSTRAINT venda_codfun_fkey_001 FOREIGN KEY (codfun) REFERENCES funcionario (codfun);

-- Tabela para Auditoria dos Descontos
CREATE TABLE Desconto_log (
  codlog    SERIAL NOT NULL, 
  opelog    varchar(10) NOT NULL, 
  usudeslog varchar(80) NOT NULL, 
  datdeslog timestamp NOT NULL, 
  antdeslog varchar(200), 
  depdeslog varchar(200), 
  CONSTRAINT pkey_desconto_log 
    PRIMARY KEY (codlog));
COMMENT ON TABLE Desconto_log IS 'Tabela criada para fins de auditoria sobre alterações feitas na tabela Desconto.';
COMMENT ON COLUMN Desconto_log.codlog IS 'Código do Log gerado';
COMMENT ON COLUMN Desconto_log.opelog IS 'Operação realizada';
COMMENT ON COLUMN Desconto_log.usudeslog IS 'Nome do usuário da pessoa que fez a alteração';
COMMENT ON COLUMN Desconto_log.datdeslog IS 'Data de quando a alteração foi feita';
COMMENT ON COLUMN Desconto_log.antdeslog IS 'Armazena o que estava salvo antes da alteração';
COMMENT ON COLUMN Desconto_log.depdeslog IS 'Armazena o que foi salvo depois da alteração';

-----------------------------------------------
-- Criação dos Índices:

create unique index idx_produto_codpro on produto (codpro);

create index idx_venda_datven on venda (datven);

create unique index idx_cliente_codcli on cliente (codcli);
create unique index idx_cliente_cpfcli on cliente (cpfcli);

create unique index idx_funcionario_codfun on funcionario (codfun);
create unique index idx_funcionario_cpffun on funcionario (cpffun);