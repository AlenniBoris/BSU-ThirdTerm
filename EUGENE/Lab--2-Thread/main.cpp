#include <iostream>
#include <thread>
#include <vector>
#include <exception>

std::vector<std::vector<int>> setMatrix(std::vector<std::vector<int>> Matrix, int rows){
    for (auto & i : Matrix) {
        for (int j = 0; j < rows; ++j) {
            i.push_back(rand() % 10 + 1);
        }
    }
    return Matrix;
}

std::vector<std::vector<int>> setC(std::vector<std::vector<int>> A, int sizeM, std::vector<std::vector<int>> B, std::vector<std::vector<int>> C){
    for (int i = 0; i < sizeM; ++i) {
        std::vector<int> vec;
        for (int j = 0; j < sizeM; ++j) {
            int num = 0;
            for (int k = 0; k < sizeM; ++k) {
                num+= A[i][k] * B[k][j];
            }
            vec.push_back(num);
        }
        C.push_back(vec);
    }
    return C;
}

void setSizes(int &sizeM){
    std::cout << "Please, enter size of your matrixs : " ;
    std::cin >> sizeM;
//
//    if (sizeM < 5){
//        throw std::invalid_argument("Incorrect input");
//    }
}

void showMatrixs(std::vector<std::vector<int>> matrixA, std::vector<std::vector<int>> matrixB, std::vector<std::vector<int>> matrixC){
    std::cout << std::endl;
    for (auto & i : matrixA) {
        for (int j : i) {
            std::cout << j << ' ';
        }
        std::cout << std::endl;
    }
    std::cout << std::endl;
    for (auto & i : matrixB) {
        for (int j : i) {
            std::cout << j << ' ';
        }
        std::cout << std::endl;
    }
    std::cout << "----------------------" << std::endl;
    for (auto & i : matrixC) {
        for (int j : i) {
            std::cout << j << ' ';
        }
        std::cout << std::endl;
    }
}

int main() {

    int sizeM;

    setSizes(sizeM);

    std::vector<std::vector<int>> matrixA(sizeM);
    std::vector<std::vector<int>> matrixB(sizeM);
    std::vector<std::vector<int>> matrixC(sizeM);

    matrixA = setMatrix(matrixA, sizeM);
    matrixB = setMatrix(matrixB, sizeM);
    matrixC = setC(matrixA, sizeM,matrixB,matrixC);

    showMatrixs(matrixA, matrixB, matrixC);

    return 0;
}
