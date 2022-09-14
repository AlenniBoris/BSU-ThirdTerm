#pragma once
#include <iostream>

namespace CalcsNum {
	class Number {
	private:
		double _num;
	public:
		Number(double num) : _num(num) {};
		double getNum() { return _num; }

		Number operator+(const Number& sec) const {
			return Number(_num + sec._num);
		}
		Number operator-(const Number& sec) const {
			return Number(_num - sec._num);
		}
		Number operator*(const Number& sec) const {
			return Number(_num * sec._num);
		}
		Number operator/(const Number& sec) const {
			return Number(_num / sec._num);
		}
	};
}

const static CalcsNum::Number ONE = CalcsNum::Number(1);
const static CalcsNum::Number ZERO = CalcsNum::Number(0);

std::ostream& operator<<(std::ostream& out, CalcsNum::Number n) {
	out << n.getNum();
	return out;
}