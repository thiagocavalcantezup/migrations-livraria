UPDATE
  livros
SET
  status = 'PRE_VENDA'
WHERE
  status = '0';

UPDATE
  livros
SET
  status = 'VENDA'
WHERE
  status = '1';

UPDATE
  livros
SET
  status = 'COLECAO'
WHERE
  status = '2';

UPDATE
  livros
SET
  status = 'LOCACAO'
WHERE
  status = '3';
