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
CMAKE_SOURCE_DIR = "/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP/cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/ProcessP.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/ProcessP.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/ProcessP.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/ProcessP.dir/flags.make

CMakeFiles/ProcessP.dir/main.cpp.o: CMakeFiles/ProcessP.dir/flags.make
CMakeFiles/ProcessP.dir/main.cpp.o: ../main.cpp
CMakeFiles/ProcessP.dir/main.cpp.o: CMakeFiles/ProcessP.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/ProcessP.dir/main.cpp.o"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/ProcessP.dir/main.cpp.o -MF CMakeFiles/ProcessP.dir/main.cpp.o.d -o CMakeFiles/ProcessP.dir/main.cpp.o -c "/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP/main.cpp"

CMakeFiles/ProcessP.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/ProcessP.dir/main.cpp.i"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP/main.cpp" > CMakeFiles/ProcessP.dir/main.cpp.i

CMakeFiles/ProcessP.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/ProcessP.dir/main.cpp.s"
	/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP/main.cpp" -o CMakeFiles/ProcessP.dir/main.cpp.s

# Object files for target ProcessP
ProcessP_OBJECTS = \
"CMakeFiles/ProcessP.dir/main.cpp.o"

# External object files for target ProcessP
ProcessP_EXTERNAL_OBJECTS =

ProcessP: CMakeFiles/ProcessP.dir/main.cpp.o
ProcessP: CMakeFiles/ProcessP.dir/build.make
ProcessP: CMakeFiles/ProcessP.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable ProcessP"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/ProcessP.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/ProcessP.dir/build: ProcessP
.PHONY : CMakeFiles/ProcessP.dir/build

CMakeFiles/ProcessP.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/ProcessP.dir/cmake_clean.cmake
.PHONY : CMakeFiles/ProcessP.dir/clean

CMakeFiles/ProcessP.dir/depend:
	cd "/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP" "/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP" "/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP/cmake-build-debug" "/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP/cmake-build-debug" "/home/borisall/Рабочий стол/HWK_CPP/HW10_12/ProcessP/cmake-build-debug/CMakeFiles/ProcessP.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/ProcessP.dir/depend
