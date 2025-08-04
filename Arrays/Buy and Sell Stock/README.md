
# 121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the i-th day. You want to maximize your profit by choosing a single day to buy one stock and a different day in the future to sell it.
Return the maximum profit you can achieve. If no profit is possible, return 0.

## Intuition:
Buy at the lowest price seen so far, sell at the current price if it gives better profit. The trick is to always look backward for buy, not forward.

## Approach:

Start with the first price as the minimum (buy).

Loop through the array from index 1.

If current price is higher than minSoFar, calculate profit.

Keep updating the maximum profit seen.

If current price is lower than minSoFar, update it.

Finally, return the best profit.

## Main Logic:

Maintain minPrice seen so far while iterating.

For every day, calculate profit = price - minPrice.

Update maxProfit whenever profit is better.

If a new minimum is found, update minPrice.


## Time Complexity: O(n)
## Space Complexity: O(1)

## Similar Problems:

122. Best Time to Buy and Sell Stock II (Multiple transactions)

Best Time to Buy and Sell Stock III (Two transactions)

Best Time to Buy and Sell Stock IV (K transactions)

Best Time to Buy and Sell Stock with Cooldown

Best Time to Buy and Sell Stock with Transaction Fee

## Real-life Use Case:
Helps to determine maximum ROI from a single stock buy-sell pair over a time series. Can be used in finance, investment planning, or stock strategy simulation.

## Flashcard / Mind Map Recall Tip:
“Track min price so far. At each price, check profit = price - min.”