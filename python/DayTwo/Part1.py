def read_inputs():
    inputs = []
    with open("inputs/day-two-input.txt", "r") as file:
        for line in file:
            single_line = line.strip()
            inputs.append(single_line)
    return inputs


def process(inputs):
    horiz = 0
    depth = 0

    for i in range(len(inputs)):
        split = inputs[i].split()
        match split[0]:
            case "forward":
                horiz += int(split[1])
            case "up":
                depth -= int(split[1])
            case "down":
                depth += int(split[1])
            case _:
                print("Error; forward, up, or down not parsed")
    print("Final horizontal position: ", horiz)
    print("Final depth: ", depth)
    print("Final result (Multiplied): ", horiz * depth)


def main():
    process(read_inputs())


if __name__ == "__main__":
    main()
