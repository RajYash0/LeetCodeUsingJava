SELECT Request_at AS Day,
       ROUND(SUM(Status != 'completed') * 1.0 / COUNT(*), 2) AS "Cancellation Rate"
FROM Trips
JOIN Users AS Client ON Trips.Client_Id = Client.Users_Id
JOIN Users AS Driver ON Trips.Driver_Id = Driver.Users_Id
WHERE Client.Banned = 'No' AND Driver.Banned = 'No'
  AND Request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY Request_at;
