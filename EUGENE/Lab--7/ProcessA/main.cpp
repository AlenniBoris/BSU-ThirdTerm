#include <iostream>
#include <windows.h>

int main() {
    char enterNumbers[1024] = "1 2 3 4\n";
    std::string outNumbers = "";

    char *nextNumber = nullptr;
    char *ptr = strtok_s(enterNumbers, " ", &nextNumber);

    while(ptr != NULL){
        outNumbers += std::to_string(std::atoi(ptr)+2) + " ";
        ptr = strtok_s(NULL, " ", &nextNumber);
    }

    outNumbers += "\n";

    std::cout << outNumbers;

    return 0;
}
