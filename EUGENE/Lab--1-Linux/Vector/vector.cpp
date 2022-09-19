#include "vector.h"


Vector Vector::operator+(const Vector &sVect) {
    return Vector(_fNum + sVect._fNum, _sNum + sVect._sNum);
}

Number Vector::getRad() {
    return Number(sqrt(((_fNum * _fNum) + (_sNum * _sNum)).getNum()));
}

Number Vector::getAngle() {
    return Number(atan((_sNum / _fNum).getNum()));
}

Number Vector::getFNUM() {
    return _fNum;
}

Number Vector::getSNUM() {
    return _sNum;
}
