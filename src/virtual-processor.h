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

typedef long double data_type_t;
typedef long long operand_t;

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
} instruction_t;

typedef struct {
    instruction_t instruction;
    operand_t right;
    operand_t left;
} line_t;

typedef struct {
    data_type_t input[INPUT_OUTPUT_NUMBER];
    data_type_t output[INPUT_OUTPUT_NUMBER];
    data_type_t *memory;
    size_t memory_size;
    size_t cursor;
    line_t *lines;
    size_t lines_size;
    pthread_mutex_t inMutex[INPUT_OUTPUT_NUMBER];
    pthread_mutex_t outMutex[INPUT_OUTPUT_NUMBER];
} virtual_processor_t;


extern virtual_processor_t *createVirtualProcessor();

extern void freeVirtualProcessor(virtual_processor_t *virtualProcessor);

extern pthread_t executeVirtualProcessor(virtual_processor_t *virtualProcessor);

extern void writeVirtualProcessor(virtual_processor_t *virtualProcessor, size_t index, data_type_t value);

extern data_type_t readVirtualProcessor(virtual_processor_t *virtualProcessor, size_t index);

static void executeLineVirtualProcessor(virtual_processor_t *virtualProcessor, line_t *line, bool *alive);

static void instructionError(instruction_t instruction);

static void writeMemoryVirtualProcessor(virtual_processor_t *virtualProcessor, size_t address, data_type_t value);

static data_type_t readMemoryVirtualProcessor(virtual_processor_t *virtualProcessor, size_t address);

static void *threadExecuteVirtualProcessor(void *args);

#endif //VIRTUALPROCESSOR_VIRTUAL_PROCESSOR_H
