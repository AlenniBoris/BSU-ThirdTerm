#include <iostream>
#include <thread>
#include <vector>
#include <exception>
#include <chrono>

std::vector<double> threadResults;

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

//--------------------------------------------------------------------------------------

void mulBlock(std::vector<std::vector<int>>& matrixA, std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int blockI, int blockJ, int sizeM, int sizeB){
    for (int i = blockI; i < std::min(blockI+sizeB, sizeM); ++i) {
        for (int j = 0; j < std::min(blockJ + sizeB, sizeM); ++j) {
            for (int k = 0; k < sizeM; ++k) {
                matrixC[i][j] += matrixA[i][k] + matrixB[k][j];
            }
        }
    }
}

void thrMul(std::vector<std::vector<int>>& matrixA, std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int sizeM, int sizeB){
    std::vector<std::thread> threads;
    for (int blockI = 0; blockI < sizeM; blockI += sizeB) {
        for (int blockJ = 0; blockJ < sizeM; blockJ += sizeB) {
            threads.emplace_back(mulBlock, std::cref(matrixA), std::cref(matrixB), std::ref(matrixC), blockI, blockJ, sizeM, sizeB);
        }
    }
    for (int i = 0; i < threads.size(); ++i) {
        threads[i].join();
    }
}

void showMatrixs(std::vector<std::vector<int>>& matrixA, std::vector<std::vector<int>>& matrixB, std::vector<std::vector<int>>& matrixC, int sizeM){
//    std::cout << std::endl;
//    for (auto & i : matrixA) {
//        for (int j : i) {
//            std::cout << j << ' ';
//        }
//        std::cout << std::endl;
//    }
//    std::cout << std::endl;
//    for (auto & i : matrixB) {
//        for (int j : i) {
//            std::cout << j << ' ';
//        }
//        std::cout << std::endl;
//    }
//    std::cout << "----------------------" << std::endl;

    auto startTime = std::chrono::high_resolution_clock::now();
    for (int i = 0; i < sizeM; ++i) {
        thrMul(matrixA, matrixB,matrixC, sizeM, i);
        auto tempTime = std::chrono::high_resolution_clock::now();
        std::chrono::duration<double> tempDuration = tempTime - startTime;
        threadResults.push_back(tempDuration.count());
    }
    auto endTimeThread = std::chrono::high_resolution_clock::now();
    std::chrono::duration<double> durationThread = endTimeThread - startTime;
    std::cout << durationThread.count() << '\n';

    for (int i = 0; i < threadResults.size(); ++i) {
        std::cout << "time =  " << threadResults[i];
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
