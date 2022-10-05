#include <iostream>
#include <thread>
#include <vector>
#include <exception>

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

std::vector<std::vector<int>> setC(std::vector<std::vector<int>> A, int colsA, int rowsA, std::vector<std::vector<int>> B, int colsB, int rowsB, std::vector<std::vector<int>> C){
    for (int i = 0; i < colsA; ++i) {
        std::vector<int> vec;
        for (int j = 0; j < rowsA; ++j) {
            int num = 0;
            for (int k = 0; k < rowsB; ++k) {
                num+= A[i][k] * B[k][j];
            }
            vec.push_back(num);
        }
        C.push_back(vec);
    }
    return C;
}

int main() {

    int colA, rowA;
    int colB, rowB;

    std::cout << "Please, enter your sizes" << std::endl;
    std::cout << "Number of columns A = ";
    std::cin >> colA;
    std::cout << "Number of rows A = ";
    std::cin >> rowA;
    std::cout << "Number of columns B = ";
    std::cin >> colB;
    std::cout << "Number of rows B = ";
    std::cin >> rowB;

//    if (colA < 5 || rowA < 5 || colB < 5 || rowB < 5 || rowA != colB){
//        throw std::invalid_argument("Incorrect input");
//    }

    std::vector<std::vector<int>> matrixA(colA);
    std::vector<std::vector<int>> matrixB(colB);
    std::vector<std::vector<int>> matrixC(colA);

    matrixA = setA(matrixA, rowA);
    matrixB = setB(matrixB, rowB);
    matrixC = setC(matrixA, colA, rowA, matrixB, colB, rowB, matrixC);

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
