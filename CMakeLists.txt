cmake_minimum_required(VERSION 3.14)
project(VirtualProcessor C)

set(CMAKE_C_STANDARD 11)

include_directories(src)

add_executable(VirtualProcessor
        src/virtual-processor.c
        src/virtual-processor.h
        main.c)
