g++ -c -o Number/buildNum/number.o Number/number.cpp
ar r Number/buildNum/libNumber.a Number/buildNum/number.o

g++ -c -o Vector/buildVec/vector.o Vector/vector.cpp -INumber -LNumber/buildNum -lNumber
g++ -shared -o Vector/buildVec/libVector.so Vector/buildVec/vector.o

g++ -o Main/main.out Main/main.cpp -LNumber/buildNum -LVector/buildVec -lNumber -lVector -INumber -IVector
cd Main
export LD_LIBRARY_PATH=../Vector/buildVec
./main.out
