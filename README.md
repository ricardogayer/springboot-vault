# Spring Boot com Hashicorp Vault 

    Comando Docker para executar o Hashicorp Vault
  
    docker run --rm --cap-add=IPC_LOCK -e VAULT_ADDR=http://localhost:8200 -p 8200:8200 -d --name=dev-vault vault:1.2.2

    -- Comando Docker para verificar o log e recuperar o Token gerado
    docker logs dev-vault

    -- Entrar no Docker para configurar as senhas...
	docker exec -it dev-vault sh

    -- Setar as variaveis de ambiente
	export VAULT_ADDR=http://localhost:8200
	export VAULT_TOKEN=s.kjkyqV1fYIGuzBGx8iRTxpx1

    -- Setar o usuário e a senha do banco de dados usando no programa Spring Boot
	vault kv put secret/javainuseapp dbpassword=postgres dbusername=postgres
	vault kv get secret/javainuseapp

    -- No projeto Spring Boot 
    
    bootstrap.yml
    
    spring:
      application:
        name: javainuseapp
      cloud:
        vault:
          host: localhost
          port: 8200
          scheme: http
          token: s.kjkyqV1fYIGuzBGx8iRTxpx1
          
          
    application.properties
   
    spring.datasource.username=${dbusername}
    spring.datasource.password=${dbpassword}