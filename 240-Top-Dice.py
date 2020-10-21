# Problem 240. Top Dice https://projecteuler.net/problem=240

# My approach to this problem:

# - Get the order-independent possibilities of throwing 20 dices of 12 sides .
# - From the above possibilities, retrieve the combinations which have top 10 sum equals to 70.
# - For each combination, count the number of permutations (order-dependent possibilities).
# - The result is the sum of permutations of all combinations found.

import itertools

numbers_of_dice = 20  # Number of dices
numbers_of_side = 12  # Number of sides on each dice
top_side_count = 10  # Top count of sides
top_sum = 70  # Sum of top sides

factorial = [1] * (numbers_of_dice + 1)

def main():
    init_factorial()
    number_of_ways = 0

    # Getting order independent possibilities of rolling 20 dices of 12-sides
    # Check if sum of top 10 values equals to 70
    # Add it to the result
    for i in itertools.combinations_with_replacement(range(1, numbers_of_side + 1), numbers_of_dice):
        if sum(i[numbers_of_dice - top_side_count::]) == top_sum:
            number_of_ways += get_permutations_of_combination(i)
    print(number_of_ways)

# Initialize the factorial 1! ... 20!
def init_factorial():
    for i in range(1, numbers_of_dice + 1):
        factorial[i] = factorial[i - 1] * i


# Function for obtaining the number of permutations
def get_permutations_of_combination(combination):
    freqs = [0] * numbers_of_side

    # Get the frequencies of each sides that appear
    for i in combination:
        freqs[i - 1] += 1

    n = factorial[numbers_of_dice]
    k = 1

    for i in freqs:
        k *= factorial[i]

    # Number of permutations is calculated as: 20!/(k1! ... k12!) whereas ki is the number of side that observed
    return int(n / k)


if __name__ == "__main__":
    main()