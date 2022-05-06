INSERT INTO
  autores (
    id,
    nome,
    email,
    data_nascimento,
    biografia,
    criado_em
  )
VALUES
  (
    DEFAULT,
    'Autor Teste',
    'autor@teste.com.br',
    CURRENT_TIMESTAMP,
    'Autor de teste.',
    CURRENT_TIMESTAMP
  )
