
/*-----SQL Assignment-----*/
USE [AdventureWorks2008R2];
/*1.1*/
SELECT * FROM Sales.SalesPerson;

/*1.2*/
Select FirstName, LastName from Person.Person where FirstName like 'B%';

/*1.3*/
select p.FirstName, p.LastName, h.JobTitle from Person.Person as p
join HumanResources.Employee as h on p.BusinessEntityID=h.BusinessEntityID
where h.JobTitle in('Design Engineer','Tool Designer','Marketing Assistant');


/*1.4*/
select Name,Color as max_weight from Production.Product Group by Name,Color;


/*1.5*/
Select Description, coalesce(MaxQty,0.00) as MaxQty from Sales.SpecialOffer;


/*1.6 Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’ for the year 2005 
i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’. Note: The field [CurrencyRate].[AverageRate] is defined as 
'Average exchange rate for the day.'*/

select * from Sales.CurrencyRate;
select avg(AverageRate) from Sales.CurrencyRate where FromCurrencyCode = 'USD' 
and ToCurrencyCode = 'GBP' and ModifiedDate between '2005-01-01' and '2005-12-31'; 

/*1.7 Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’. 
Display an additional column with sequential numbers for each row returned beginning at integer 1.
(Schema(s) involved: Person)*/

select row_number() over(order by FirstName asc) as RowNumber, FirstName,
LastName from Person.Person where FirstName like '%ss%';

/*1.8*/
Select BusinessEntityID as SalesPersonID,CommissionPct, 'Commission Band' = Case
when CommissionPct = 0 then 'band 0'
when CommissionPct > 0 and CommissionPct<=0.01 then 'band 1'
when CommissionPct >0.01 and CommissionPct<=1.5 then 'band 2'
when CommissionPct > 1.5 then 'band 3'End
from Sales.SalesPerson
order by CommissionPct;

/*1.9 Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) up to CEO Ken Sanchez.
Hint: use MS –203: SQL2[uspGetEmployeeManagers] (Schema(s) involved: [Person], [HumanResources]) */

select P.FirstName,P.MiddleName,P.LastName,
HumanResources.EmployeePayHistory.Rate, H.OrganizationLevel,H.JobTitle
from HumanResources.Employee as H inner join HumanResources.EmployeePayHistory on H.BusinessEntityID = HumanResources.EmployeePayHistory.BusinessEntityID
inner join
Person.Person as P on H.BusinessEntityID = P.BusinessEntityID
where P.BusinessEntityID<49
order by P.BusinessEntityID asc
;


/*1.10*/
select * from Production.ProductInventory
select ProductID, Quantity from Production.ProductInventory
order by Quantity desc;
