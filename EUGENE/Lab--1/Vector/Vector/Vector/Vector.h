#pragma once
#ifdef MATHLIBRARY_EXPORTS
#define MATHLIBRARY_API __declspec(dllexport)
#else
#define MATHLIBRARY_API __declspec(dllimport)
#endif


#include <ostream>
#include "Number/Number/Number.h"


using namespace CalcsNum;
class Vector {
private:
	Number _fNum, _sNum;
public:
	Vector(CalcsNum::Number fNum, Number sNum) : _fNum(fNum), _sNum(sNum) {};

	Vector operator+(const Vector& sVect) {
		return Vector(_fNum + sVect._fNum, _sNum + sVect._sNum);
	}

	Number getRad() {
		return Number(sqrt(((_fNum * _fNum) + (_sNum * _sNum)).getNum()));
	}

	Number getAngle() {
		return Number(atan((_sNum / _fNum).getNum()));
	}

	Number getFNUM() {
		return _fNum;
	}

	Number getSNUM() {
		return _sNum;
	}
};

const static Vector ZERO_V = Vector(ZERO, ZERO);
const static Vector ONE_V = Vector(ONE, ONE);

std::ostream& operator<<(std::ostream& out, Vector v) {
	out << v.getFNUM() << ";" << v.getSNUM();
	return out;
}

