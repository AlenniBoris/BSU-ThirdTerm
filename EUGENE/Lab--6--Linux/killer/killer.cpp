#include <locale>
#include <codecvt>
#include <csignal>
#include <cstring>
#include "killer.h"

void killByProc(){
    char *env_var = getenv("PROC_TO_KILL");
    if (env_var == NULL){ return; }
    char *ptr = strtok(env_var, ",");
    while(ptr != NULL){
        killByName(ptr);
        ptr = strtok(NULL, ",");
    }
}

void killByName(const char* name){
    char buff[512];
    std::string str(name);
    FILE *cmd_stream = popen(("pidof " + str).c_str(), "r");
    fgets(buff, 512, cmd_stream);
    pid_t pid = strtoul(buff, NULL, 10);
    std::string pids(buff);
    pclose(cmd_stream);
    if (pids.empty()){
        return;
    }
    char *ptr = strtok(&pids.front(), " ");
    while(ptr != NULL){
        kill(std::atoi(ptr), SIGTERM);
        ptr = strtok(NULL, " ");
    }
}

void killById(int id){
    auto result = kill(id, SIGKILL) == 0;
    if (result){
        std::cout << "Process " + std::to_string(id) + " was killed" << std::endl;
    }else{
        std::cout << "Process " + std::to_string(id) + " wasn't killed" << std::endl;
    }
}