package banco;

/**
 * Classe qe configura o banco de dados
 */
public abstract class  CriaBancoDeDados {

    /**
     * Definição das constantes
     */
    private static final String CHARSET =" default char set=utf8";
    private static final String NOME_DO_BANCO ="banco_de_dados_novo";
    private static final String CREATE_DATA_BASE = "create database if not exists " + NOME_DO_BANCO  + CHARSET + ";";
    private static final String USE_DATA_BASE = "use " + NOME_DO_BANCO + ";";





    /***
     * Método cria um banco de dados e em seguida
     * o seleciona
     *
     * @return retorna o comando para criar uma tabela
     * e selecionar a tabela que foi criada
     */
    private static  String  createDataBase(){

        return CREATE_DATA_BASE + USE_DATA_BASE;
    }


    /**
     * Método cria a tabela de clientes
     *
     * @return retorna o comando parar criar a tabela
     * de clientes
     */
    private static String criarTabelaCliente (){

        return "CREATE TABLE cliente (" +
                "id_cliente int UNSIGNED NOT NULL auto_increment primary key," +
                "nome varchar(30) not null," +
                "cpf varchar(11) not null UNIQUE," +
                "e_mail varchar(30) not null UNIQUE," +
                "senha varchar(20) not null," +
                "nascimento date not null" +
                ") ENGINE = InnoDB, DEFAULT CHARSET = utf8, AUTO_INCREMENT = 0;";
    }

    /**
     * Método cria a tabela de método de pagamentos
     *
     * @return retorna o comando parar criar a tabela
     * de pagamentos
     */
    private static String criarTabelaMetodoPagamento (){

        return "CREATE TABLE metodo_pagamento (" +
                "id_cartao int UNSIGNED not null auto_increment primary key," +
                "id_cliente int UNSIGNED," +
                "n_cartao varchar(16) not null," +
                "nome_titular varchar(30) not null," +
                "cpf_titular varchar(11) not null," +
                "validade varchar(5) not null," +
                "cvc varchar(3) not null," +
                "constraint fk_id_cliente foreign key (id_cliente)" +
                "references cliente(id_cliente)" +
                "ON DELETE CASCADE" +
                "ON UPDATE CASCADE" +
                ") ENGINE = InnoDB, DEFAULT CHARSET = utf8, AUTO_INCREMENT = 0;";
    }

    /**
     * Método cria a tabela de método de Dados de Contato
     *
     * @return retorna o comando parar criar a tabela
     * de Dados de Contato
     */
    private static String criarTabelaDadosContato (){

        return "CREATE TABLE dados_contato (" +
        "id_cliente_dados int UNSIGNED,"+
        "telefone varchar(15),"+
        "constraint fk_id_cliente_dados FOREIGN KEY (id_cliente_dados)"+
        "REFERENCES cliente(id_cliente)"+
        "ON DELETE CASCADE"+
        "ON UPDATE CASCADE"+
        ") DEFAULT CHARSET = utf8, ENGINE = InnoDB;";
    }


    /**
     * Esse método monta o banco de dados chamando
     * os metodo internos dessa classe
     */
    public static void executar(){
        createDataBase();
        criarTabelaCliente ();


    }

}