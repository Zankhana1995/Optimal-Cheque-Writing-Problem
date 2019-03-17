# Optimal Cheque Writing Problem
The input is a number of periods (N), a constant amount (A) that has to be paid each period to a creditor and an
initial balance in your bank account (B). For each time period, you need to write a cheque for an
amount . given the following rules:
• You cannot owe money to your creditor:
• Your balance cannot be negative (but you can assume that your account gets credited by an amount
equal to A every time period).
• At the end of the N periods you paid the creditor exactly the amount owed.
• The cheque amount has to be positive. An amount of 0 as payment is allowed, but the cost is 0 as it does
not require writing a cheque.
For example:
1. If N=3, A=100, B=0. The only way to pay is to write a cheque for 100 every time period
