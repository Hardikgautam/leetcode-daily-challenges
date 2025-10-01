WITH cte AS
(
    SELECT
        customer_id,
        SUM(CASE WHEN transaction_type = 'purchase' THEN 1 ELSE 0 END) AS num_p,
        SUM(CASE WHEN transaction_type = 'refund' THEN 1 ELSE 0 END) / COUNT(DISTINCT transaction_id) AS refund_rate,
        (MAX(transaction_date) - MIN(transaction_date)) AS active_days
    FROM
        customer_transactions 
    GROUP BY
        customer_id
)
SELECT
    customer_id
FROM
    cte
WHERE
    num_p >= 3
    AND active_days >= 30
    AND refund_rate < 0.2
ORDER BY
    customer_id;
