//
// Created by borisall on 22.11.22.
//

#ifndef KILLER_KILLER_H
#define KILLER_KILLER_H

#include <iostream>
#include <pthread.h>
#include <csignal>
#include <string>
#include <sstream>

void killByProc(std::string PROC_TO_KILL);

void killByProc();

void killByName(const char *name);

void killById(int id);

#endif //KILLER_KILLER_H
