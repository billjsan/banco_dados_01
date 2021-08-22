package banco;

/**
 * Classe que configura o banco de dados
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
     * Método cria a tabela de método de Suporte Funcao
     *
     * @return retorna o comando parar criar a tabela
     * de Suporte Funcaão
     */
    private static String criarTabelaSuporteFuncao (){

        return  "CREATE TABLE suporte_funcao ("+
                "id_funcao int UNSIGNED not null auto_increment,"+
                "descricao varchar(180) not null,"+
                "salario double not null,"+
                "PRIMARY KEY (id_funcao)"+
                ") ENGINE = InnoDB, DEFAULT CHARSET = utf8, AUTO_INCREMENT = 0;";
    }

    /**
     * Método cria a tabela de Funcionario
     *
     * @return retorna o comando SQL parar criar a tabela
     * de Funcionario
     */
    private static String criarTabelaFuncionario (){

        return  "CREATE TABLE funcionario ("+
                "id_funcionario int UNSIGNED not null auto_increment primary key,"+
                "nome varchar(30) not null,"+
                "id_funcao int UNSIGNED,"+
                "constraint fk_id_funcao foreign key (id_funcao)"+
                "references suporte_funcao(id_funcao)"+
                "ON DELETE CASCADE"+
                "ON UPDATE CASCADE"+
                ") ENGINE = InnoDB, DEFAULT CHARSET = utf8, AUTO_INCREMENT = 0;";
    }

    /**
     * Método cria a tabela de método de Estacao
     *
     * @return retorna o comando SQL parar criar a tabela
     * de Estacao
     */
    private static String criarTabelaEstacao (){

        return  "CREATE TABLE estacao ("+
                "cod_est int UNSIGNED not null auto_increment primary key,"+
                "endereco text not null,"+
                "nome varchar(30)"+
                ") ENGINE = InnoDB, DEFAULT CHARSET = utf8, AUTO_INCREMENT = 0;";
    }

    /**
     * Método cria a tabela de Tipo de Modal
     *
     * @return retorna o comando SQL parar criar a tabela
     * de Tipo de Modal
     */
    private static String criarTabelaTipoModal (){

        return  "CREATE TABLE tipo_modal ("+
                "tipo_modal int UNSIGNED not null auto_increment primary key,"+
                "nome_modal varchar(30) not null,"+
                "valor_hora double"+
                ") ENGINE = InnoDB, DEFAULT CHARSET = utf8, AUTO_INCREMENT = 0;";
    }

    /**
     * Método cria a tabela de Modal
     *
     * @return retorna o comando SQL parar criar a tabela
     * de Modal
     */
    private static String criarTabelaModal (){

        return  "CREATE TABLE modal ("+
               "id_modal int UNSIGNED not null auto_increment primary key,"+
                "tipo_modal int UNSIGNED,"+
                "modelo VARCHAR(30) not null,"+
                "marca varchar(20) not null,"+
                "constraint fk_tipo_modal foreign key (tipo_modal)"+
                 "references tipo_modal(tipo_modal)"+
                "ON DELETE CASCADE"+
                "ON UPDATE CASCADE"+
                ") ENGINE = InnoDB, DEFAULT CHARSET = utf8, AUTO_INCREMENT = 0;";
    }q





    /**
     * Esse método monta o banco de dados chamando
     * os metodo internos dessa classe
     */
    public static void executar(){
        createDataBase();
        criarTabelaCliente ();


    }

}
