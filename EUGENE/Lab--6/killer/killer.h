#ifndef LAB__6_KILLER_H
#define LAB__6_KILLER_H

#include <iostream>
#include <windows.h>
#include <tlhelp32.h>
#include <string>
#include <sstream>

void killByProc(std::string PROC_TO_KILL);

void killByName(std::string name);

void killById(int id);

#endif //LAB__6_KILLER_H
