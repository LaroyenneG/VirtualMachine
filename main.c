#include <stdio.h>
#include <stdlib.h>
#include <zconf.h>

#include "virtual-processor.h"

int main(int argc, char **argv) {

    if (argc != 1) {
        fprintf(stderr, "Usage : vp\n");
        exit(EXIT_FAILURE);
    }

    virtual_processor_t *virtualProcessor = createVirtualProcessor();

    appendLineVirtualProcessor(virtualProcessor, INPUT, 1, 10);

    appendLineVirtualProcessor(virtualProcessor, OUTPUT, 1, 10);

    appendLineVirtualProcessor(virtualProcessor, EXIT, 0, 0);

    pthread_t pthread = executeVirtualProcessor(virtualProcessor);


    vp_data_type_t value = 5;

    writeVirtualProcessor(virtualProcessor, 1, value);

    vp_data_type_t result = readVirtualProcessor(virtualProcessor, 1);

    printf("%LF! = %Lf\n", value, result);

    freeVirtualProcessor(virtualProcessor);

    pthread_join(pthread, NULL);

    return EXIT_SUCCESS;
}