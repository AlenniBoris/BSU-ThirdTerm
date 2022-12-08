#include <iostream>
#include <cstring>
#include <fcntl.h>
#include <sys/stat.h>
#include <unistd.h>

int main(int argc, char* argv[]) {

    int fileDescriptor;

    std::string outNumbers = std::to_string((std::atoi(argv[1]) * 7)) + " ";

    for (int i = 2; i < argc; ++i) {
        outNumbers += std::to_string((std::atoi(argv[i]) * 7)) + " ";
    }

    outNumbers += "\n";
//    std::cout << outNumbers;

    mkfifo("/tmp/ProcessM", 0666);
    fileDescriptor = open("/tmp/ProcessM", O_WRONLY);

    write(fileDescriptor, outNumbers.c_str(), strlen(outNumbers.c_str()) + 1);
    close(fileDescriptor);

    return 0;
}
