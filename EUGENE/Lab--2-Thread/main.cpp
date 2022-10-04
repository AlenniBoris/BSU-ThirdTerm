#include <iostream>
#include <thread>
#include <vector>

std::vector<std::vector<int>> setA(std::vector<std::vector<int>> A, int rows){
    std::cout << "Enter A: ";
    for (auto & i : A) {
        int num;
        for (int j = 0; j < rows; ++j) {
            std::cin >> num;
            i.push_back(num);
        }
    }
    return A;
}

std::vector<std::vector<int>> setB(std::vector<std::vector<int>> B, int rows){
    std::cout << "Enter B: ";
    for (auto & i : B) {
        int num;
        for (int j = 0; j < rows; ++j) {
            std::cin >> num;
            i.push_back(num);
        }
    }
    return B;
}

std::vector<std::vector<int>> setC(std::vector<std::vector<int>> A, std::vector<std::vector<int>> B, std::vector<std::vector<int>> C){
    for (int i = 0; i < A.size();) {
        int num = 0;
        for (int j = 0; j < A.size();) {
            num += A[i][j] * B[j][i];
            ++j;
        }
        C[i].push_back(num);
        ++i;
    }
}

int main() {

    int columnNum, rowNum;

    std::cout << "Please, enter your sizes" << std::endl;
    std::cout << "Number of columns A and B = ";
    std::cin >> columnNum;
    std::cout << "Number of rows A and B = ";
    std::cin >> rowNum;

    std::vector<std::vector<int>> matrixA(columnNum);
    std::vector<std::vector<int>> matrixB(columnNum);
    std::vector<std::vector<int>> matrixC(columnNum);

    matrixA = setA(matrixA, rowNum);
    matrixB = setB(matrixB, rowNum);
    matrixC = setC(matrixA, matrixB, matrixC);

    std::cout << "----------------------" << std::endl;

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

    return 0;
}
