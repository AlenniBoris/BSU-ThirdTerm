#include <iostream>
#include <vector>
#include <sys/wait.h>

int main(int argc, char*argv[]) {
    putenv("PROC_TO_KILL=Telegram,chrome");
    pid_t pid = fork();
    switch (pid)
    {
        case -1:
            fprintf(stderr, "FORK FAILED\n");
            return -1;
        case 0:
            execv("./../../killer/cmake-build-debug/killer", argv);
            _exit(0);
        default:
            wait(NULL);
            _exit(0);
    }
    return 0;
}