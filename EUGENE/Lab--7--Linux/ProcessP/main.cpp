#include <iostream>
#include <cstring>
#include <cmath>
#include <fcntl.h>
#include <sys/stat.h>
#include <unistd.h>

int main() {
    int fileDescriptor;

    mkfifo("/tmp/ProcessA", 0666);

    char enterNumbers[1024];
    std::string outNumbers = "";

    fileDescriptor = open("/tmp/ProcessA", O_RDONLY);
    read(fileDescriptor, enterNumbers, 1024);

    char* ptr = strtok(enterNumbers, " ");

    while(ptr != NULL){
        outNumbers += std::to_string(std::pow(std::atoi(ptr), 3)) + " ";
        ptr = strtok(NULL, " ");
    }

    outNumbers += "\n";
//    std::cout << outNumbers;

    fileDescriptor = open("/tmp/ProcessP", O_WRONLY);
    write(fileDescriptor, outNumbers.c_str(), strlen(outNumbers.c_str()) + 1);

    return 0;
}


