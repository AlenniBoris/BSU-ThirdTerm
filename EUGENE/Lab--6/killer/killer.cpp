#include <locale>
#include <codecvt>
#include "killer.h"

//void killByProc(std::string PROC_TO_KILL){
//    std::string temp_str;
//    if (!PROC_TO_KILL.empty()){
//        std::stringstream stream(PROC_TO_KILL);
//        while(std::getline(stream, temp_str, ',')){
//            killByName(temp_str);
//        }
//    }else{
//        std::cout << "Nothing to close";
//    }
//}

void killByProc(){
    DWORD buffer_size = 65535;
    std::wstring buffer;
    buffer.resize(buffer_size);
    buffer_size = GetEnvironmentVariableW(
            L"PROC_TO_KILL",
            &buffer[0],
            buffer_size
            );
    if (!buffer_size){
        std::cout << "error in getting environment variable\n";
    }
    buffer.resize(buffer_size);
    std::wstring_convert<std::codecvt_utf8<wchar_t>, wchar_t> converter;
    std::string args = converter.to_bytes(buffer);
    char *nextPtr = NULL;
    char *ptr = strtok_s(&args.front(), ",", &nextPtr);
    while (ptr != NULL)
    {
        killByName(ptr);
        ptr = strtok_s(NULL, ",", &nextPtr);
    }
}

void killByName(const char *name){
    HANDLE processes = CreateToolhelp32Snapshot(TH32CS_SNAPALL, NULL);
    PROCESSENTRY32 pentry32;
    pentry32.dwSize = sizeof(PROCESSENTRY32);
    if (processes == INVALID_HANDLE_VALUE){
        std::cout << "Can't get all processes";
    }
    bool res = Process32First(processes, &pentry32);
    while(res){
        if (strcmp(pentry32.szExeFile, name) == 0){
            HANDLE process = OpenProcess(PROCESS_TERMINATE, 0, (DWORD)pentry32.th32ProcessID);
            auto result = TerminateProcess(process, NULL);
            if (result){
                std::cout << "Process was killed" << std::endl;
            }else{
                std::cout << "Process wasn't killed" << std::endl;
            }
            CloseHandle(process);
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