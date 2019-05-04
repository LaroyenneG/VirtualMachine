cmake_minimum_required(VERSION 3.14)
project(VirtualProcessor C)

set(CMAKE_C_STANDARD 99)
set(CMAKE_CXX_COMPILER gcc)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Wall -Werror -Wextra -pedantic -g")

include_directories(src)

add_executable(vp
        src/virtual-processor.c
        src/virtual-processor.h
        main.c)

target_link_libraries(vp pthread)
