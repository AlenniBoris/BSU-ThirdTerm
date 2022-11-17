//
// Created by User on 16.11.2022.
//

#ifndef KILLER_KILLER_H
#define KILLER_KILLER_H

#include <iostream>
#include <windows.h>
#include <tlhelp32.h>
#include <string>
#include <sstream>

void killByProc(std::string PROC_TO_KILL);

void killByProc();

void killByName(std::string name);

void killById(int id);

#endif //KILLER_KILLER_H
