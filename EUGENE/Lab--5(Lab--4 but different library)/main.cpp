#include <iostream>
#include <windows.h>
#include <vector>
#include <exception>
#include <chrono>
#include <mutex>
#include <valarray>

std::vector<double> threadResults;
std::mutex g_lock;


std::vector<std::vector<int>> setMatrix(std::vector<std::vector<int>> Matrix, int rows) {
    for (auto& i : Matrix) {
        for (int j = 0; j < rows; ++j) {
            i.push_back(rand() % 10 + 1);
        }
    }
    return Matrix;
}

void setSizes(int& sizeM) {
    std::cout << "Please, enter size of your matrixs : ";
    std::cin >> sizeM;

    if (sizeM < 5) {
        throw std::invalid_argument("Incorrect input");
    }
}

void mulBlock(const std::vector<std::vector<int>>& matrixA, const std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int blockI, int blockJ, int sizeM, int sizeB) {
    for (int i = blockI; i < std::min(blockI + sizeB, sizeM); ++i) {
        for (int j = blockJ; j < std::min(blockJ + sizeB, sizeM); ++j) {
            for (int k = 0; k < sizeM; ++k) {
                g_lock.lock();
                matrixC[i][j] += matrixA[i][k] + matrixB[k][j];
                g_lock.unlock();
            }
        }
    }
}

struct Arguments{
    Arguments(const std::vector<std::vector<int>>& matrixA, const std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int sizeM, int sizeB, int blockI, int blockJ):
    matrixA(matrixA), matrixB(matrixB), matrixC(matrixC), sizeM(sizeM), sizeB(sizeB), blockI(blockI), blockJ(blockJ){};
    const std::vector<std::vector<int>>& matrixA;
    const std::vector<std::vector<int>>& matrixB;
    std::vector<std::vector<int>>& matrixC;
    int sizeM;
    int sizeB;
    int blockI;
    int blockJ;
};

DWORD WINAPI MultFunc(LPVOID arguments){
    Arguments *args = (Arguments*)arguments;
    mulBlock(args->matrixA, args->matrixB, args->matrixC, args->blockI, args->blockJ, args->sizeM, args->sizeB);
    ExitThread(0);
}

void thrMul(const std::vector<std::vector<int>>& matrixA, const std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int sizeM, int sizeB) {
    std::vector<HANDLE> threads;
    for (int blockI = 0; blockI < sizeM; blockI += sizeB) {
        for (int blockJ = 0; blockJ < sizeM; blockJ += sizeB) {
            threads.emplace_back(CreateThread(NULL, 0, &MultFunc, new Arguments(matrixA, matrixB, matrixC, sizeM, sizeB, blockI, blockJ), 0, NULL));
        }
    }
    for (int i = 0; i < threads.size(); ++i) {
        WaitForSingleObject(threads[i], INFINITE);
    }
}

void showMatrixs(const std::vector<std::vector<int>>& matrixA,const std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int sizeM) {
    auto startTime = std::chrono::high_resolution_clock::now();
    for (int i = 1; i < sizeM; ++i) {
        thrMul(matrixA, matrixB, matrixC, sizeM, i);
        auto tempTime = std::chrono::high_resolution_clock::now();
        std::chrono::duration<double> tempDuration = tempTime - startTime;
        threadResults.push_back(tempDuration.count());
        matrixC = std::vector<std::vector<int>>(sizeM, std::vector<int>(sizeM));
    }
    auto endTimeThread = std::chrono::high_resolution_clock::now();
    std::chrono::duration<double> durationThread = endTimeThread - startTime;
    std::cout << durationThread.count() << '\n';

    for (int i = 0; i < threadResults.size() - 1; ++i)
    {
        std::cout << "| Block size " << i + 1 << " ,difference " << threadResults[i] - threadResults[i + 1] << '\n';
        std::cout << "------------------------------------\n";
    }
}

int main() {
    int sizeM;
    setSizes(sizeM);
    std::vector<std::vector<int>> matrixA(sizeM);
    std::vector<std::vector<int>> matrixB(sizeM);
    std::vector<std::vector<int>> matrixC(sizeM, std::vector<int>(sizeM));
    matrixA = setMatrix(matrixA, sizeM);
    matrixB = setMatrix(matrixB, sizeM);
    showMatrixs(matrixA, matrixB, matrixC, sizeM);
    return 0;
}