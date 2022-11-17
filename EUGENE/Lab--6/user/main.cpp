#include <iostream>
#include <windows.h>
#include <vector>

std::wstring StringToWString(const std::string &str)
{
    int sizeNeeded = MultiByteToWideChar(CP_UTF8, 0, &str[0], (int)str.size(), NULL, 0);
    std::wstring wstrTo(sizeNeeded, 0);
    MultiByteToWideChar(CP_UTF8, 0, &str[0], (int)str.size(), &wstrTo[0], sizeNeeded);
    return wstrTo;
}

int main(int argc, char*argv[]) {
    STARTUPINFO si;
    PROCESS_INFORMATION piProcessKiller;
    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&piProcessKiller, sizeof(piProcessKiller));

    std::vector<std::wstring> args;
    for (int i = 0; i < argc; ++i) {
        args.push_back(StringToWString(argv[i]));
    }

    if (!SetEnvironmentVariableW(L"PROC_TO_KILL", L"Telegram.exe Discord.exe"))
    {
        std::cerr << "Set environment variable failed with error code" << GetLastError() << '\n';
    }

    std::string command_line = "../../killer/cmake-build-debug/killer.exe";
    for (auto arg : args) {
        command_line += " " + std::string(arg.begin(), arg.end());
    }

    if (!CreateProcess(
            NULL,
            &command_line.front(),
            NULL,
            NULL,
            TRUE,
            0,
            NULL,
            NULL,
            &si,
            &piProcessKiller
            )){
        std::cerr << "Create process failed with error code" << GetLastError() << '\n';
    }
    WaitForSingleObject(piProcessKiller.hProcess, INFINITE);
    if (!CloseHandle(piProcessKiller.hProcess) && !CloseHandle(piProcessKiller.hThread)){
        std::cerr << "Close handle failed with error code" << GetLastError() << '\n';
    }

    if (!SetEnvironmentVariableW(L"PROC_TO_KILL", NULL))
    {
        std::cerr << "Set environment variable failed with error code" << GetLastError() << '\n';
    }

    return 0;
}
