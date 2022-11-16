#include "killer.h"

void killByProc(std::string PROC_TO_KILL){
    std::string temp_str;
    if (!PROC_TO_KILL.empty()){
        std::stringstream stream(PROC_TO_KILL);
        while(std::getline(stream, temp_str, ',')){
            killByName(temp_str);
        }
    }else{
        std::cout << "Nothing to close";
    }
}

void killByName(std::string name){
    HANDLE processes = CreateToolhelp32Snapshot(TH32CS_SNAPALL, NULL);
    PROCESSENTRY32 pentry32;
    std::string text = name;
    pentry32.dwSize = sizeof(PROCESSENTRY32);
    if (processes == INVALID_HANDLE_VALUE){
        std::cout << "Can't get all processes";
    }
    bool res = Process32First(processes, &pentry32);
    while(res){
        if (strcmp(pentry32.szExeFile, strdup(name.c_str())) == 0){
            HANDLE process = OpenProcess(PROCESS_TERMINATE, 0, pentry32.th32ProcessID);
            auto result = TerminateProcess(process, NULL);
            CloseHandle(process);
            if (result){
                std::cout << "Process " + text + " was killed" << std::endl;
            }else{
                std::cout << "Process " + text + " wasn't killed" << std::endl;
            }
        }
        res = Process32Next(processes, &pentry32);
    }
    CloseHandle(processes);
}

void killById(int id){
    HANDLE process = OpenProcess(PROCESS_TERMINATE, false, id);
    auto result = TerminateProcess(process, NULL);
    CloseHandle(process);
    if (result){
        std::cout << "Process " + std::to_string(id) + " was killed" << std::endl;
    }else{
        std::cout << "Process " + std::to_string(id) + " wasn't killed" << std::endl;
    }
}