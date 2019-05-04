/*
Created by Guillaume Laroyenne on 03/05/19.
*/

#include <stdio.h>
#include <stdlib.h>

#include "virtual-processor.h"

virtual_processor_t *createVirtualProcessor() {

    virtual_processor_t *virtualProcessor = malloc(sizeof(virtual_processor_t));
    if (virtualProcessor == NULL) {
        perror("malloc()");
        exit(EXIT_FAILURE);
    }

    virtualProcessor->memory = malloc(sizeof(type_t) * MEMORY_BLOCK_SIZE);
    if (virtualProcessor->memory) {
        perror("malloc()");
        exit(EXIT_FAILURE);
    }

    virtualProcessor->memory_size = MEMORY_BLOCK_SIZE;

    virtualProcessor->cursor = 0;

    virtualProcessor->lines = NULL;

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

