#include <iostream>
#include <windows.h>
#include <cmath>

int main() {
    char enterNumbers[1024] = "1 2 3 4\n";
    std::string outNumbers = "";

    char *nextNumber = nullptr;
    char *ptr = strtok_s(enterNumbers, " ", &nextNumber);

    while(ptr != NULL){
        outNumbers += std::to_string((int)std::pow(std::atoi(ptr), 3)) + " ";
        ptr = strtok_s(NULL, " ", &nextNumber);
    }

    outNumbers += "\n";

    std::cout << outNumbers;

    return 0;
}
