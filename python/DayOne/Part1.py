def read_inputs():
    inputs = []
    with open("inputs/day-one-input.txt", "r") as file:
        for line in file:
            single_line = line.strip()
            inputs.append(single_line)
    return inputs


def process(inputs):
    inc = 0
    dec = 0
    na = 0

    print(inputs[0], "(N/A - no previous measurement)")
    for i in range(1, len(inputs)):
        if inputs[i] > inputs[i - 1]:
            inc += 1
            print(inputs[i], " (increased)")
        elif inputs[i] < inputs[i - 1]:
            dec += 1
            print(inputs[i], " (decreased)")
        else:
            na += 1
            print(inputs[i], " (no change)")

    print("\nNumber of increased measurements: ", inc)
    print("Number of decreased measurements: ", dec)
    print("Number of stationary measurements: ", na)


def main():
    process(read_inputs())


if __name__ == "__main__":
    main()
