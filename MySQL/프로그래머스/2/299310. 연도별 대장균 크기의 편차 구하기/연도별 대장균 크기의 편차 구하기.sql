SELECT
  YEAR(differentiation_date) AS YEAR,
  MAX(size_of_colony) OVER (PARTITION BY YEAR(differentiation_date)) - size_of_colony AS YEAR_DEV,
  id
FROM ecoli_data
ORDER BY YEAR, YEAR_DEV;