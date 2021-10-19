# Projeto Desafio Seleção Java

## Endponts:

Para fazer o donwload do arquivo JSON:
```
http://localhost:8080/download/json
```

Para fazer o donwload do arquivo CSV:
```
http://localhost:8080/download/csv
```

Para filtrar um municipio pelo nome:
```
http://localhost:8080/municipios?nomeCidade=
```

## Observações:

Segue alguns itens que não foram implementados por falta de tempo:
- Endereço do IBGE nas application.properties;
- Testes unitários chamando a api do IBGE sem mock;
- Testes unitários das classes de gateways;
- Melhorias de código fonte na classe JsonResource;

### Qualquer dúvida ou sugestão estou a disposição.
