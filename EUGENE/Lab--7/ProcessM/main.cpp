#include <iostream>
#include <windows.h>

int main() {
    char enterNumbers[1024] = "1 2 3 4\n";
    std::string outNumbers = "";

    char *nextNumber = nullptr;
    char *currentNumber = strtok_s(enterNumbers, " ", &nextNumber);

    while(currentNumber != NULL){
        outNumbers += std::to_string(std::atoi(currentNumber) * 7) + " ";
        currentNumber = strtok_s(NULL, " ", &nextNumber);
    }

    outNumbers += "\n";

    DWORD numberBytesWritten;

    HANDLE handlePIPE = CreateFile(TEXT("\\\\.\\Pipes\\PipeM"),
                                   GENERIC_READ | GENERIC_WRITE,
                                   0,
                                   NULL,
                                   OPEN_EXISTING,
                                   0,
                                   NULL);

    WriteFile(handlePIPE,
              outNumbers.c_str(),
              outNumbers.length() + 1,
              &numberBytesWritten,
              NULL);
    CloseHandle(handlePIPE);

//    std::cout << outNumbers;

    return 0;
}
