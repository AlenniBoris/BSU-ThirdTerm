#include <iostream>
#include <cstring>
#include <cmath>
#include <fcntl.h>
#include <sys/stat.h>
#include <unistd.h>

int main() {
    int fileDescriptor;

    mkfifo("/tmp/ProcessP", 0666);

    char enterNumbers[1024];
    std::string outNumbers = "";
    int sum = 0;

    fileDescriptor = open("/tmp/ProcessP", O_RDONLY);
    read(fileDescriptor, enterNumbers, 1024);

    char* ptr = strtok(enterNumbers, " ");

    while(ptr != NULL){
        sum += std::atoi(ptr);
        ptr = strtok(NULL, " ");
    }

    outNumbers += std::to_string(sum) + "\n";
//    std::cout << outNumbers;

    fileDescriptor = open("/tmp/ProcessS", O_WRONLY);
    write(fileDescriptor, outNumbers.c_str(), strlen(outNumbers.c_str()) + 1);
}