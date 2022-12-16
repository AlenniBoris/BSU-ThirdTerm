#include <windows.h>
#include <iostream>

void callProcess(std::string str)
{
    STARTUPINFO si;
    PROCESS_INFORMATION pi;
    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&pi, sizeof(pi));
    if (!CreateProcess(NULL, &str.front(), NULL, NULL, TRUE, 0, NULL, NULL, &si, &pi))
    {
        std::cerr << "Error " << GetLastError() << '\n';
    }
    WaitForSingleObject(pi.hProcess, INFINITE);
    if (!CloseHandle(pi.hProcess) && !CloseHandle(pi.hThread))
    {
        std::cerr << "Error  " << GetLastError() << '\n';
    }
}

int main()
{
    callProcess("C:\\Proga for BSU\\BSU-Third\\EUGENE\\Lab--7\\ProcessM\\cmake-build-debug\\ProcessM.exe");
    callProcess("C:\\Proga for BSU\\BSU-Third\\EUGENE\\Lab--7\\ProcessA\\cmake-build-debug\\ProcessA.exe");
    callProcess("C:\\Proga for BSU\\BSU-Third\\EUGENE\\Lab--7\\ProcessP\\cmake-build-debug\\ProcessP.exe");
    callProcess("C:\\Proga for BSU\\BSU-Third\\EUGENE\\Lab--7\\ProcessS\\cmake-build-debug\\ProcessS.exe");



    HANDLE handlePIPE;
    char enterNumbers[1024];
    DWORD numberBytesReaden;

    handlePIPE = CreateNamedPipe(TEXT("\\\\.\\pipe\\PipeS"),
                                 PIPE_ACCESS_DUPLEX,
                            PIPE_TYPE_BYTE | PIPE_READMODE_BYTE | PIPE_WAIT,   // FILE_FLAG_FIRST_PIPE_INSTANCE is not needed but forces CreateNamedPipe(..) to fail if the pipe already exists...
                            1,
                            1024 * 16,
                            1024 * 16,
                                 NMPWAIT_USE_DEFAULT_WAIT,
                                 NULL);


    while (handlePIPE != INVALID_HANDLE_VALUE)
    {
        if (ConnectNamedPipe(handlePIPE, NULL) != FALSE)   // wait for someone to connect to the pipe
        {
            while (ReadFile(handlePIPE, enterNumbers, sizeof(enterNumbers) - 1, &numberBytesReaden, NULL) != FALSE)
            {
                enterNumbers[numberBytesReaden] = '\0';

                printf("%s", enterNumbers);
                DisconnectNamedPipe(handlePIPE);


            }
        }

    }

    return 0;
}