#include <iostream>
#include <fstream>
#include <vector>

std::vector<int> readInputs() {
    std::vector<int> inputs;
    std::ifstream inputFile("../../inputs/day-one-input.txt");
    std::string str;

    while (std::getline(inputFile, str)) {
        if (str.size() > 0) {
            inputs.push_back(std::stoi(str));
        }
    }
    inputFile.close();

    return inputs;
}

int process(std::vector<int> inputs) {
    int c = 0;
    for (int i = 1; i < inputs.size(); i++) {
        if (inputs[i - 1] < inputs[i]) {
            c++;
        }
    }

    return c;
}

//g++ part1.cpp -o part1
int main() {
    int ans = process(readInputs());
    std::cout << "Answer is: " << ans << std::endl;

    return 0;
}