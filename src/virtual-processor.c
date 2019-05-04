/*
Created by Guillaume Laroyenne on 03/05/19.
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <pthread.h>
#include "virtual-processor.h"

#define PROCESSOR_ARITHMETIC_OPERATION(left, operator, right) writeMemoryVirtualProcessor(virtualProcessor, right, \
        readMemoryVirtualProcessor(virtualProcessor, right) \
        operator readMemoryVirtualProcessor(virtualProcessor, left))

virtual_processor_t *createVirtualProcessor() {

    virtual_processor_t *virtualProcessor = malloc(sizeof(virtual_processor_t));
    if (virtualProcessor == NULL) {
        perror("malloc()");
        exit(EXIT_FAILURE);
    }

    virtualProcessor->memory = malloc(sizeof(data_type_t) * MEMORY_BLOCK_SIZE);
    if (virtualProcessor->memory) {
        perror("malloc()");
        exit(EXIT_FAILURE);
    }

    memset(virtualProcessor->input, 0, sizeof(data_type_t) * INPUT_OUTPUT_NUMBER);
    memset(virtualProcessor->output, 0, sizeof(data_type_t) * INPUT_OUTPUT_NUMBER);

    for (unsigned int i = 0; i < INPUT_OUTPUT_NUMBER; i++) {
        pthread_mutex_init(&virtualProcessor->inMutex[i], NULL);
        pthread_mutex_init(&virtualProcessor->outMutex[i], NULL);
    }

    virtualProcessor->memory_size = MEMORY_BLOCK_SIZE;

    for (unsigned int i = 0; i < virtualProcessor->memory_size; i++) {
        virtualProcessor->memory[i] = INFINITY;
    }

    virtualProcessor->cursor = 0;

    virtualProcessor->lines = NULL;

    virtualProcessor->lines_size = 0;

    return virtualProcessor;
}


void freeVirtualProcessor(virtual_processor_t *virtualProcessor) {

    if (virtualProcessor != NULL) {

        free(virtualProcessor->lines);
        virtualProcessor->lines = NULL;

        free(virtualProcessor->memory);
        virtualProcessor->memory = NULL;

        free(virtualProcessor);
    }
}


pthread_t executeVirtualProcessor(virtual_processor_t *virtualProcessor) {

    pthread_t pthread;

    pthread_create(&pthread, NULL, threadExecuteVirtualProcessor, virtualProcessor);

    return pthread;
}

void executeLineVirtualProcessor(virtual_processor_t *virtualProcessor, line_t *line, bool *alive) {

    size_t cursor = virtualProcessor->lines_size;

    instruction_t instruction = line->instruction;
    operand_t left = line->left;
    operand_t right = line->right;

    switch (instruction) {

        case EXIT:
            if (left != 0 || right != 0) {
                instructionError(instruction);
            }
            *alive = false;
            break;

        case JMP:
            if (right + cursor < 0 || right + cursor >= virtualProcessor->lines_size) {
                instructionError(instruction);
            }
            if (readMemoryVirtualProcessor(virtualProcessor, left)) {
                virtualProcessor->cursor = cursor + right - 1;
            }
            break;

        case MULT:
            PROCESSOR_ARITHMETIC_OPERATION(left, *, right);
            break;

        case ADD:
            PROCESSOR_ARITHMETIC_OPERATION(left, +, right);
            break;

        case DIV:
            if (left == 0) {
                instructionError(instruction);
            }
            PROCESSOR_ARITHMETIC_OPERATION(left, /, right);
            break;

        case SUB:
            PROCESSOR_ARITHMETIC_OPERATION(left, -, right);
            break;

        case MOD:
            writeMemoryVirtualProcessor(virtualProcessor, right,
                                        (unsigned long long) readMemoryVirtualProcessor(virtualProcessor, right) %
                                        (unsigned long long) readMemoryVirtualProcessor(virtualProcessor, left));
            break;

        case COPY:
            writeMemoryVirtualProcessor(virtualProcessor, right, readMemoryVirtualProcessor(virtualProcessor, left));
            break;

        case LOWER:
            PROCESSOR_ARITHMETIC_OPERATION(left, <, right);
            break;


        case GREATER:
            PROCESSOR_ARITHMETIC_OPERATION(left, >, right);
            break;

        case EQUAL:
            PROCESSOR_ARITHMETIC_OPERATION(left, ==, right);
            break;

        case LET:
            if (right >= MEMORY_SIZE_MAX_SIZE) {
                instructionError(instruction);
            }
            writeMemoryVirtualProcessor(virtualProcessor, right, left);
            break;

        case INPUT:
            break;

        case OUTPUT:
            break;

        default:
            instructionError(instruction);
    }
}

void instructionError(instruction_t instruction) {

    switch (instruction) {

        case LET:
            fprintf(stderr, "let instruction memory over size\n");
            break;

        case JMP:
            fprintf(stderr, "jmp instruction error\n");
            break;

        default:
            fprintf(stderr, "invalid instruction : %d\n", instruction);
    }

    exit(EXIT_FAILURE);
}


void writeMemoryVirtualProcessor(virtual_processor_t *virtualProcessor, size_t address, data_type_t value) {

    while (address <= virtualProcessor->memory_size) {

        size_t size = virtualProcessor->memory_size + MEMORY_BLOCK_SIZE;

        virtualProcessor->memory = realloc(virtualProcessor->memory, sizeof(data_type_t) * size);
        if (virtualProcessor->memory == NULL) {
            perror("realloc()");
            exit(EXIT_FAILURE);
        }

        for (size_t i = virtualProcessor->memory_size; i < size; i++) {
            virtualProcessor->memory[i] = INFINITY;
        }

        virtualProcessor->memory_size = size;
    }

    virtualProcessor->memory[address] = value;
}


data_type_t readMemoryVirtualProcessor(virtual_processor_t *virtualProcessor, size_t address) {

    if (address >= virtualProcessor->memory_size) {
        fprintf(stderr, "segmentation fault\n");
        exit(EXIT_FAILURE);
    }

    data_type_t value = 0;

    value = virtualProcessor->memory[address];

    if (value == INFINITY) {
        fprintf(stderr, "memory no init\n");
        exit(EXIT_FAILURE);
    }

    return value;
}


void writeVirtualProcessor(virtual_processor_t *virtualProcessor, size_t index, data_type_t value) {

    if (index >= INPUT_OUTPUT_NUMBER) {
        fprintf(stderr, "invalid in out index\n");
        exit(EXIT_FAILURE);
    }


}

data_type_t readVirtualProcessor(virtual_processor_t *virtualProcessor, size_t index) {

    if (index >= INPUT_OUTPUT_NUMBER) {
        fprintf(stderr, "invalid in out index\n");
        exit(EXIT_FAILURE);
    }


}


void *threadExecuteVirtualProcessor(void *args) {

    virtual_processor_t *virtualProcessor = args;

    virtualProcessor->cursor = 0;

    bool alive = virtualProcessor->lines > 0;

    while (alive) {

        line_t *line = &virtualProcessor->lines[virtualProcessor->cursor];

        executeLineVirtualProcessor(virtualProcessor, line, &alive);

        virtualProcessor->cursor = (virtualProcessor->cursor + 1) % virtualProcessor->lines_size;
    }

    pthread_exit(NULL);
}