CREATE DATABASE LojaMateriaisConstrucao;

USE LojaMateriaisConstrucao;

CREATE TABLE Clientes (
    ID_Cliente INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100),
    Endereco VARCHAR(255),
    Telefone VARCHAR(20),
    Email VARCHAR(100)
);

CREATE TABLE Funcionarios (
    ID_Funcionario INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100),
    Cargo VARCHAR(50),
    Salário DECIMAL(10, 2),
    Data_Admissão DATE
);

CREATE TABLE Fornecedores (
    ID_Fornecedor INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100),
    Endereço VARCHAR(255),
    Telefone VARCHAR(20),
    Email VARCHAR(100)
);

CREATE TABLE Categorias (
    ID_Categoria INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(50)
);

CREATE TABLE Produtos (
    ID_Produto INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100),
    ID_Categoria INT,
    Preço DECIMAL(10, 2),
    Quantidade_Estoque INT,
    FOREIGN KEY (ID_Categoria) REFERENCES Categorias(ID_Categoria)
);

CREATE TABLE Vendas (
    ID_Venda INT PRIMARY KEY AUTO_INCREMENT,
    ID_Cliente INT,
    ID_Funcionario INT,
    Data_Venda DATE,
    Valor_Total DECIMAL(10, 2),
    FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente),
    FOREIGN KEY (ID_Funcionario) REFERENCES Funcionarios(ID_Funcionario)
);

CREATE TABLE Itens_Venda (
    ID_Item_Venda INT PRIMARY KEY AUTO_INCREMENT,
    ID_Venda INT,
    ID_Produto INT,
    Quantidade INT,
    Preço_Unitário DECIMAL(10, 2),
    FOREIGN KEY (ID_Venda) REFERENCES Vendas(ID_Venda),
    FOREIGN KEY (ID_Produto) REFERENCES Produtos(ID_Produto)
);

CREATE TABLE Compras (
    ID_Compra INT PRIMARY KEY AUTO_INCREMENT,
    ID_Fornecedor INT,
    Data_Compra DATE,
    Valor_Total DECIMAL(10, 2),
    FOREIGN KEY (ID_Fornecedor) REFERENCES Fornecedores(ID_Fornecedor)
);

CREATE TABLE Itens_Compra (
    ID_Item_Compra INT PRIMARY KEY AUTO_INCREMENT,
    ID_Compra INT,
    ID_Produto INT,
    Quantidade INT,
    Preço_Unitário DECIMAL(10, 2),
    FOREIGN KEY (ID_Compra) REFERENCES Compras(ID_Compra),
    FOREIGN KEY (ID_Produto) REFERENCES Produtos(ID_Produto)
);

CREATE TABLE Estoque (
    ID_Estoque INT PRIMARY KEY AUTO_INCREMENT,
    ID_Produto INT,
    Quantidade_Disponível INT,
    FOREIGN KEY (ID_Produto) REFERENCES Produtos(ID_Produto)
);

CREATE TABLE Pagamentos (
    ID_Pagamento INT PRIMARY KEY AUTO_INCREMENT,
    ID_Venda INT,
    Data_Pagamento DATE,
    Valor_Pago DECIMAL(10, 2),
    FOREIGN KEY (ID_Venda) REFERENCES Vendas(ID_Venda)
);

CREATE TABLE Devoluções (
    ID_Devolução INT PRIMARY KEY AUTO_INCREMENT,
    ID_Venda INT,
    Data_Devolução DATE,
    Motivo VARCHAR(255),
    FOREIGN KEY (ID_Venda) REFERENCES Vendas(ID_Venda)
);

-- Inserindo dados na tabela Clientes
INSERT INTO Clientes (Nome, Endereco, Telefone, Email) VALUES
('João Silva', 'Rua A, 123', '1234-5678', 'joao@example.com'),
('Maria Oliveira', 'Rua B, 456', '2345-6789', 'maria@example.com');

-- Inserindo dados na tabela Funcionários
INSERT INTO Funcionarios (Nome, Cargo, Salário, Data_Admissão) VALUES
('Carlos Souza', 'Gerente', 5000.00, '2020-01-15'),
('Ana Lima', 'Vendedora', 2500.00, '2021-06-01');

-- Inserindo dados na tabela Fornecedores
INSERT INTO Fornecedores (Nome, Endereço, Telefone, Email) VALUES
('Fornecedor A', 'Av. Central, 789', '3456-7890', 'fornecedorA@example.com'),
('Fornecedor B', 'Av. Secundária, 101', '4567-8901', 'fornecedorB@example.com');

-- Inserindo dados na tabela Categorias
INSERT INTO Categorias (Nome) VALUES
('Ferramentas'),
('Materiais de Construção');

-- Inserindo dados na tabela Produtos
INSERT INTO Produtos (Nome, ID_Categoria, Preço, Quantidade_Estoque) VALUES
('Martelo', 1, 25.00, 100),
('Cimento', 2, 30.00, 200);

-- Inserindo dados na tabela Vendas
INSERT INTO Vendas (ID_Cliente,ID_Funcionario, Data_Venda, Valor_Total) VALUES
(1, 1, '2023-07-01', 55.00),
(2, 2, '2023-07-02', 60.00);

-- Inserindo dados na tabela Itens_Venda
INSERT INTO Itens_Venda (ID_Venda, ID_Produto, Quantidade, Preço_Unitário) VALUES
(1, 1, 2, 25.00),
(1, 2, 1, 30.00),
(2, 2, 2, 30.00);

-- Inserindo dados na tabela Compras
INSERT INTO Compras (ID_Fornecedor, Data_Compra, Valor_Total) VALUES
(1, '2023-06-25', 500.00),
(2, '2023-06-26', 600.00);

-- Inserindo dados na tabela Itens_Compra
INSERT INTO Itens_Compra (ID_Compra, ID_Produto, Quantidade, Preço_Unitário) VALUES
(1, 1, 20, 20.00),
(1, 2, 10, 25.00),
(2, 2, 20, 25.00);

-- Inserindo dados na tabela Estoque
INSERT INTO Estoque (ID_Produto, Quantidade_Disponível) VALUES
(1, 100),
(2, 200);

-- Inserindo dados na tabela Pagamentos
INSERT INTO Pagamentos (ID_Venda, Data_Pagamento, Valor_Pago) VALUES
(1, '2023-07-01', 55.00),
(2, '2023-07-02', 60.00);

-- Inserindo dados na tabela Devoluções
INSERT INTO Devoluções (ID_Venda, Data_Devolução, Motivo) VALUES
(1, '2023-07-03', 'Produto danificado');