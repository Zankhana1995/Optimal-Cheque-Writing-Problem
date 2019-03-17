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

We associate to writing each cheque a cost C[x] equal to the number of characters taken to write the amount x
on the cheque. You are asked to write a program that finds a payment schedule that satisfies the constraints
above and it is optimal:

1. If N=2, A=100, B=0; the optimal schedule cost is 20: writing twice “one hundred”
2. If N=2, A= 100, B=100; the optimal schedule cost is 10:(writing one cheque for “two hundred”). Note that
a payment schedule of (200,0) is valid.
3. If N=3, A=97, B=6; the optimal schedule is 28 for the schedule (99,96,96) corresponding to writing:
“ninety nine” and twice “ninety six”. Another valid schedule might be (97,97,97) but its cost is higher at
33.
