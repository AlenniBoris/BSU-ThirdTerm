# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.23

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/borisall/Загрузки/clion-2022.2.1/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /home/borisall/Загрузки/clion-2022.2.1/bin/cmake/linux/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN/cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/MAIN.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/MAIN.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/MAIN.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/MAIN.dir/flags.make

CMakeFiles/MAIN.dir/main.cpp.o: CMakeFiles/MAIN.dir/flags.make
CMakeFiles/MAIN.dir/main.cpp.o: ../main.cpp
CMakeFiles/MAIN.dir/main.cpp.o: CMakeFiles/MAIN.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/MAIN.dir/main.cpp.o"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/MAIN.dir/main.cpp.o -MF CMakeFiles/MAIN.dir/main.cpp.o.d -o CMakeFiles/MAIN.dir/main.cpp.o -c "/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN/main.cpp"

CMakeFiles/MAIN.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/MAIN.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN/main.cpp" > CMakeFiles/MAIN.dir/main.cpp.i

CMakeFiles/MAIN.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/MAIN.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN/main.cpp" -o CMakeFiles/MAIN.dir/main.cpp.s

# Object files for target MAIN
MAIN_OBJECTS = \
"CMakeFiles/MAIN.dir/main.cpp.o"

# External object files for target MAIN
MAIN_EXTERNAL_OBJECTS =

MAIN: CMakeFiles/MAIN.dir/main.cpp.o
MAIN: CMakeFiles/MAIN.dir/build.make
MAIN: ../../Number/cmake-build-debug/libNumber.a
MAIN: ../../Vector/cmake-build-debug/libVector.so
MAIN: CMakeFiles/MAIN.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable MAIN"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/MAIN.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/MAIN.dir/build: MAIN
.PHONY : CMakeFiles/MAIN.dir/build

CMakeFiles/MAIN.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/MAIN.dir/cmake_clean.cmake
.PHONY : CMakeFiles/MAIN.dir/clean

CMakeFiles/MAIN.dir/depend:
	cd "/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN" "/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN" "/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN/cmake-build-debug" "/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN/cmake-build-debug" "/home/borisall/Рабочий стол/HWK_CPP/HW22_09/MAIN/cmake-build-debug/CMakeFiles/MAIN.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/MAIN.dir/depend

