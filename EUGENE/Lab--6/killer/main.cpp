#include <iostream>

#include "killer.h"
int main(int argc, char *argv[]) {
//    killById(1827768);
//    killByName("Telegram.exe");
//    killByProc("Telegram.exe,Discord.exe,msedge.exe");
    killByProc();
    for (int i = 0; i < argc; ++i) {
        if (strcmp(argv[i], "--name") == 0){
            killByName(argv[i+1]);
        }
        if (strcmp(argv[i], "--id") == 0){
            killById(std::stoi(argv[i+1]));
        }
    }

    return 0;
}