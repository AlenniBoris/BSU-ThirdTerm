#include <iostream>
#include <cstring>

#include "killer.h"
int main(int argc, char const *argv[]) {
//    killById(4903);
//    killByName("Telegram");
    killByProc();
    for (int i = 0; i < argc; ++i) {
        if (strcmp(argv[i], "--name") == 0){
            killByName(argv[i+1]);
        }
        if (strcmp(argv[i], "--id") == 0){
            kill(std::atoi(argv[i+1]), SIGTERM);
        }
    }

    return 0;
}
