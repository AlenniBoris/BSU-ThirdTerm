add_executable(killer main.cpp killer.h killer.cpp ../user/user.cpp)
add_library(libkiller
        STATIC
        killer.h
        killer.cpp)