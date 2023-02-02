/*Exercise 2*/
/*Write separate queries using a join, a subquery, a CTE, and then 
an EXISTS to list all AdventureWorks customers who have not placed 
an order.*/

Use AdventureWorks2008R2;
/* using join*/
Select C.CustomerID from Sales.SalesOrderHeader SOH
Right join Sales.Customer C on C.CustomerID=SOH.CustomerID
where SalesOrderID is NULL;

/*using subquery*/
Select C.CustomerID from Sales.Customer C where C.CustomerID Not in
(Select CustomerID from Sales.SalesOrderHeader);

/*exist*/
Select C.CustomerID from Sales.Customer C where NOT EXISTS
(Select s.CustomerID from Sales.SalesOrderHeader as s where s.CustomerID=C.CustomerID);

/*CTE*/
With CustomerWithoutOrder(CustomerID)
as
(Select C.CustomerID from Sales.SalesOrderHeader SOH
Right join Sales.Customer C on C.CustomerID=SOH.CustomerID
where SalesOrderID is NULL)
Select * from CustomerWithoutOrder;
/*Exercise 3*/
/*Show the most recent five orders that were purchased from account
numbers that have spent more than $70,000 with 
AdventureWorks*/

Select Top 5 SalesOrderID, AccountNumber, OrderDate
from Sales.SalesOrderHeader
where AccountNumber in 
(Select AccountNumber from Sales.SalesOrderHeader
group by AccountNumber having sum(SubTotal)>70000)
order by OrderDate;

/*Exercise 4
Create a function that takes as inputs a SalesOrderID, a Currency Code, and a date, and returns a table of all the SalesOrderDetail rows 
for that Sales Order including Quantity, ProductID, UnitPrice, and the unit price converted to the target currency based on the end of 
day rate for the date provided. Exchange rates can be found in the Sales.CurrencyRate table. */
Go 
Create function Sales.getProducts(@SalesOrderID int, @CurrencyCode nchar(3),@CurrencyRateDate datetime)
Returns TABLE
As
return
with Products
AS(
    select * from Sales.SalesOrderDetail AS sod where sod.SalesOrderID = @SalesOrderID
	)
    select p.ProductID, p.OrderQty, p.UnitPrice,p.UnitPrice*scr.EndOfDayRate as 'Converted Price' from Products p,
	Sales.CurrencyRate as scr
    where scr.ToCurrencyCode = @CurrencyCode
    and scr.CurrencyRateDate = @CurrencyRateDate
Go

select * from Sales.getProducts(1, 'USD', '2005-01-01');
/*Exercise 5
Write a Procedure supplying name information from the Person.Person table and accepting a filter for the first name. Alter the above 
Store Procedure to supply Default Values if user does not enter any value.*/
Go
Create procedure Person.up_getNamesByType @Type nchar(2)='xyz'
as 
select FirstName from Person.Person where PersonType=@Type
Go

/*Exercise 6
Write a trigger for the Product table to ensure the list price can never be raised more than 15 Percent in a single change. Modify the 
above trigger to execute its check code only if the ListPrice column is updated */

Go
Create Trigger CheckPriceRise
on Production.Product
After update
as
begin
set nocount on;
if update(ListPrice)
begin
update Production.Product
set ListPrice = IIF((i.ListPrice-d.ListPrice)> d.ListPrice*0.15, d.ListPrice, i.ListPrice)
from deleted as d, Production.Product as p
inner join inserted as i on i.ProductID = p.ProductID
end
end
Go