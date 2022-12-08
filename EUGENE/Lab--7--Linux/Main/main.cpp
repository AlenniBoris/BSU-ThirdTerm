#include <iostream>
#include <fcntl.h>
#include <sys/stat.h>
#include <unistd.h>

int main() {

    int fileDescriptor;

    mkfifo("/tmp/ProcessS", 0666);

    char outNumbers[1024];

    fileDescriptor = open("/tmp/ProcessS", O_RDONLY);

    read(fileDescriptor, outNumbers, 1024);

    printf("%s\n", outNumbers);
    close(fileDescriptor);

    return 0;
}
