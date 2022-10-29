#include <iostream>
#include <thread>
#include <vector>
#include <exception>
#include <chrono>
#include <mutex>
#include <valarray>
#include "buffered_channel.h"

std::vector<double> threadResults;
std::vector<double> defaultResults;
std::mutex g_lock;


std::vector<std::vector<int>> setMatrix(std::vector<std::vector<int>> Matrix, int rows){
    for (auto & i : Matrix) {
        for (int j = 0; j < rows; ++j) {
            i.push_back(rand() % 10 + 1);
        }
    }
    return Matrix;
}

void setSizes(int &sizeM){
    std::cout << "Please, enter size of your matrixs : " ;
    std::cin >> sizeM;

    if (sizeM < 5){
        throw std::invalid_argument("Incorrect input");
    }
}

void mulBlock(std::vector<std::vector<int>>& matrixA, std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int blockI, int blockJ, int sizeM, int sizeB){
    for (int i = blockI; i < std::min(blockI+sizeB, sizeM); ++i) {
        for (int j = 0; j < std::min(blockJ + sizeB, sizeM); ++j) {
            for (int k = 0; k < sizeM; ++k) {
                matrixC[i][j] += matrixA[i][k] + matrixB[k][j];
            }
        }
    }
}

void mulBlockCh(const std::vector<std::vector<int>>& matrixA, const std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC,  std::pair<int,int>& pair, int sizeM, int sizeB){
    for (int i = pair.first; i < std::min(pair.first+sizeB, sizeM); ++i) {
        for (int j = pair.second; j < std::min(pair.second + sizeB, sizeM); ++j) {
            for (int k = 0; k < sizeM; ++k) {
                g_lock.lock();
                matrixC[i][j] += matrixA[i][k] + matrixB[k][j];
                g_lock.unlock();
            }
        }
    }
}

void getCh(const std::vector<std::vector<int>>& matrixA,const std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int sizeM, int sizeB, BufferedChannel<std::pair<int, int>>& bufferedChannel){
    std::pair<std::pair<int, int>, bool> pair = bufferedChannel.Recv();
    while(pair.second){
        mulBlockCh(matrixA,matrixB,matrixC,pair.first,sizeM,sizeB);
        pair = bufferedChannel.Recv();

    }
}


void thrMul(const std::vector<std::vector<int>>& matrixA,const std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int sizeM, int sizeB){
    std::vector<std::thread> threads;
    int bufSize = std::pow(sizeM % sizeB == 0 ? sizeM / sizeB : sizeM / sizeB + 1, 2);
    BufferedChannel<std::pair<int, int>> bufferedChannel(bufSize);
    for (int blockI = 0; blockI < sizeM; blockI += sizeB) {
        for (int blockJ = 0; blockJ < sizeM; blockJ += sizeB) {
           std::pair<int, int> blocks = std::make_pair(blockI, blockJ);
           bufferedChannel.Send(std::move(blocks));
        }
    }
    bufferedChannel.Close();
    for (int i = 0; i < 10; ++i) {
        threads.emplace_back(getCh, std::ref(matrixA), std::ref(matrixB),std::ref(matrixC), sizeM, sizeB, std::ref(bufferedChannel));
    }
    for (int i = 0; i < threads.size(); ++i) {
        threads[i].join();
    }
}

void defMul(std::vector<std::vector<int>>& matrixA, std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int sizeM, int sizeB){
    for (int blockI = 0; blockI < sizeM; blockI += sizeB) {
        for (int blockJ = 0; blockJ < sizeM; blockJ += sizeB) {
            mulBlock(matrixA, matrixB, matrixC, blockI, blockJ, sizeM, sizeB);
        }
    }
}

void showMatrixs(std::vector<std::vector<int>>& matrixA, std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int sizeM){

    auto startTime = std::chrono::high_resolution_clock::now();
    for (int i = 1; i < sizeM; ++i) {
        thrMul(matrixA, matrixB,matrixC, sizeM, i);
        auto tempTime = std::chrono::high_resolution_clock::now();
        std::chrono::duration<double> tempDuration = tempTime - startTime;
        threadResults.push_back(tempDuration.count());
    }
    auto endTimeThread = std::chrono::high_resolution_clock::now();
    std::chrono::duration<double> durationThread = endTimeThread - startTime;
    std::cout << durationThread.count() << '\n';

    for (int i = 0; i < threadResults.size() - 1; ++i)
    {
        std::cout << "| Block size " << i+1 << " ,difference " << threadResults[i] - threadResults[i+1] << '\n';
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
