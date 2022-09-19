#ifndef VECTOR_VECTOR_H
#define VECTOR_VECTOR_H

#include <ostream>
#include "number.h"
#include <cmath>


using namespace CalcsNum;
class Vector {
private:
    Number _fNum, _sNum;
public:
    Vector(CalcsNum::Number fNum, Number sNum) : _fNum(fNum), _sNum(sNum) {};

    Vector operator+(const Vector& sVect);

    Number getRad();

    Number getAngle();

    Number getFNUM();

    Number getSNUM();
};

const static Vector ZERO_V = Vector(ZERO, ZERO);
const static Vector ONE_V = Vector(ONE, ONE);

std::ostream& operator<<(std::ostream& out, Vector v) {
    out << v.getFNUM() << ";" << v.getSNUM();
    return out;
}

#endif //VECTOR_VECTOR_H
