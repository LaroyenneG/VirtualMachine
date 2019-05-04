/*
Created by Guillaume Laroyenne on 03/05/19.
*/

#ifndef VIRTUALPROCESSOR_VIRTUAL_PROCESSOR_H
#define VIRTUALPROCESSOR_VIRTUAL_PROCESSOR_H

#include <pthread.h>
#include <stdbool.h>

#define INPUT_OUTPUT_NUMBER 10
#define MEMORY_BLOCK_SIZE 10
#define MEMORY_SIZE_MAX_SIZE 100000

typedef long double vp_data_type_t;
typedef long long vp_operand_t;

typedef enum {
    ADD,
    MULT,
    DIV,
    COPY,
    SUB,
    MOD,
    LET,
    JMP,
    EXIT,
    GREATER,
    LOWER,
    EQUAL,
    INPUT,
    OUTPUT
} vp_instruction_t;

typedef struct {
    vp_instruction_t instruction;
    vp_operand_t right;
    vp_operand_t left;
} vp_line_t;

typedef struct {
    vp_data_type_t input[INPUT_OUTPUT_NUMBER];
    vp_data_type_t output[INPUT_OUTPUT_NUMBER];
    vp_data_type_t *memory;
    size_t memory_size;
    size_t cursor;
    vp_line_t *lines;
    size_t lines_size;
    pthread_mutex_t inMutex[INPUT_OUTPUT_NUMBER];
    pthread_cond_t inCond[INPUT_OUTPUT_NUMBER];
    pthread_mutex_t outMutex[INPUT_OUTPUT_NUMBER];
    pthread_cond_t outCond[INPUT_OUTPUT_NUMBER];
} virtual_processor_t;


extern virtual_processor_t *createVirtualProcessor();

extern void freeVirtualProcessor(virtual_processor_t *virtualProcessor);

extern pthread_t executeVirtualProcessor(virtual_processor_t *virtualProcessor);

extern void writeVirtualProcessor(virtual_processor_t *virtualProcessor, size_t index, vp_data_type_t value);

extern vp_data_type_t readVirtualProcessor(virtual_processor_t *virtualProcessor, size_t index);

extern void
appendLineVirtualProcessor(virtual_processor_t *virtualProcessor, vp_instruction_t instruction, vp_operand_t left,
                           vp_operand_t right);

#endif //VIRTUALPROCESSOR_VIRTUAL_PROCESSOR_H
