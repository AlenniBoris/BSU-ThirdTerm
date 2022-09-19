cmake_minimum_required(VERSION 3.23)
project(Vector)

set(CMAKE_CXX_STANDARD 17)

add_library(Vector SHARED vector.cpp)

add_library(Number STATIC IMPORTED)
set_target_properties(Number PROPERTIES INTERFACE_INCLUDE_DIRECTORIES ${CMAKE_CURRENT_SOURCE_DIR}/../Number)
set_target_properties(Number PROPERTIES IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/../Number/cmake-build-debug/libNumber.a)
target_link_libraries(Vector Number)



