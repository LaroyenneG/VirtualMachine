/*
Created by Guillaume Laroyenne on 03/05/19.
*/

#ifndef VIRTUALPROCESSOR_VIRTUAL_PROCESSOR_H
#define VIRTUALPROCESSOR_VIRTUAL_PROCESSOR_H

#define MEMORY_BLOCK_SIZE 10
#define MEMORY_SIZE_MAX_SIZE 100000

typedef long double type_t;

typedef enum {
    ADD,
    MULT,
    DIV,
    COPY,
    MOD,
    SET,
    JMP
} instruction_t;

typedef struct {
    instruction_t instruction;
    long long right;
    long long left;
} line_t;

typedef struct {
    type_t *memory;
    unsigned long memory_size;
    unsigned long cursor;
    line_t *lines;
} virtual_processor_t;


extern virtual_processor_t *createVirtualProcessor();

extern void freeVirtualProcessor(virtual_processor_t *virtualProcessor);


#endif //VIRTUALPROCESSOR_VIRTUAL_PROCESSOR_H
