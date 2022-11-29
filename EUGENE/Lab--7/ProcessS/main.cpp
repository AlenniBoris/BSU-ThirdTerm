#include <iostream>
#include <windows.h>

int main() {
    char enterNumbers[1024] = "1 2 3 4\n";
    std::string outNumbers = "";
    int sum = 0;

    char *nextNumber = nullptr;
    char *ptr = strtok_s(enterNumbers, " ", &nextNumber);

    while(ptr != NULL){
        sum += atoi(ptr);
        ptr = strtok_s(NULL, " ", &nextNumber);
    }

    outNumbers += std::to_string(sum) + "\n";

    std::cout << outNumbers;

    return 0;
}
