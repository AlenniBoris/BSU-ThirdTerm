#include <iostream>
#include <windows.h>

int main() {
    char enterNumbers[1024];
    DWORD numberBytesReaden;

    DWORD numberBytesWritten;
    std::string outNumbers;

    HANDLE handlePIPE = CreateNamedPipe(TEXT("\\\\.\\Pipes\\PipeP"),
                                        PIPE_ACCESS_DUPLEX,
                                        PIPE_TYPE_BYTE | PIPE_READMODE_BYTE | PIPE_WAIT,
                                        1,
                                        1024 * 16,
                                        1024 * 16,
                                        NMPWAIT_USE_DEFAULT_WAIT,
                                        NULL);

    while(handlePIPE != INVALID_HANDLE_VALUE){
        if (ConnectNamedPipe(handlePIPE, NULL) != FALSE){
            while(ReadFile(handlePIPE, enterNumbers, sizeof(enterNumbers) - 1, &numberBytesReaden, NULL) != FALSE){
                enterNumbers[numberBytesReaden] = '\0';
                outNumbers = "";
                int sum = 0;

                char *nextNumber = nullptr;
                char *currentNumber = strtok_s(enterNumbers, " ", &nextNumber);

                while(currentNumber != NULL){
                    sum += std::atoi(currentNumber);
                    currentNumber = strtok_s(NULL, " ", &nextNumber);
                }

                outNumbers += std::to_string(sum) + "\n";

                handlePIPE = CreateFile(TEXT("\\\\.\\Pipes\\PipeA"),
                                        GENERIC_READ | GENERIC_WRITE,
                                        0,
                                        NULL,
                                        OPEN_EXISTING,
                                        0,
                                        NULL);

                if(handlePIPE != INVALID_HANDLE_VALUE){
                    WriteFile(handlePIPE,
                              outNumbers.c_str(),
                              outNumbers.length() + 1,
                              &numberBytesWritten,
                              NULL);
                    CloseHandle(handlePIPE);
                }

                printf("%s", outNumbers.c_str());
            }
        }
        if(handlePIPE != INVALID_HANDLE_VALUE){
            WriteFile(handlePIPE,
                      outNumbers.c_str(),
                      12,
                      &numberBytesWritten,
                      NULL);
            CloseHandle(handlePIPE);
        }

        DisconnectNamedPipe(handlePIPE);
    }

    return 0;
}
