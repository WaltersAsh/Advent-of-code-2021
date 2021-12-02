def read_inputs():
    inputs = []
    with open("inputs/day-one-input.txt", "r") as file:
        for line in file:
            single_line = line.strip()
            inputs.append(single_line)
    return inputs


def process(inputs):
    sums = []
    for i in range(2, len(inputs)):
        tot = int(inputs[i - 2]) + int(inputs[i - 1]) + int(inputs[i])
        sums.append(tot)

    inc = 0
    dec = 0
    na = 0

    print(sums[0], "(N/A - no previous measurement)")
    for i in range(1, len(sums)):
        if sums[i] > sums[i - 1]:
            inc += 1
            print(sums[i], " (increased)")
        elif sums[i] < sums[i - 1]:
            dec += 1
            print(sums[i], " (decreased)")
        else:
            na += 1
            print(sums[i], " (no change)")

    print("\nNumber of increased measurements: ", inc)
    print("Number of decreased measurements: ", dec)
    print("Number of stationary measurements: ", na)


def main():
    process(read_inputs())


if __name__ == "__main__":
    main()
