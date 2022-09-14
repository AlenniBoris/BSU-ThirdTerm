#include <iostream>
#include "vectorH.h"

using namespace CalcsNum;
int main()
{
    Vector fVec(Number(15), Number(40));
    Vector sVec(Number(15), Number(-10));
    std::cout << "Sum vecs = " << fVec + sVec << std::endl;
    std::cout << ONE_V << std::endl;
    std::cout << ZERO_V << std::endl;
}

