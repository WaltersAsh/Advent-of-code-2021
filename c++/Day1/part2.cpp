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
    for (int i = 0; i < inputs.size() - 2; i++) {
        if (inputs[i + 3] > inputs[i]) {
            c++;
        }
    }

    return c;
}

//g++ part2.cpp -o part2
int main() {
    int ans = process(readInputs());
    std::cout << "Answer is: " << ans << std::endl;

    return 0;
}