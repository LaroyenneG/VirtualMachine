#include <stdio.h>
#include <stdlib.h>
#include <zconf.h>
#include <wait.h>

#include "virtual-processor.h"

int main(int argc, char **argv) {

    if (argc != 1) {
        fprintf(stderr, "Usage : vp\n");
        exit(EXIT_FAILURE);
    }

    virtual_processor_t *virtualProcessor = createVirtualProcessor(1, 1);

    appendLineVirtualProcessor(virtualProcessor, INPUT, 0, 10);

    appendLineVirtualProcessor(virtualProcessor, OUTPUT, 0, 10);

    appendLineVirtualProcessor(virtualProcessor, EXIT, 0, 0);

    pid_t pid = executeVirtualProcessor(virtualProcessor);

    vp_data_type_t value = 5;

    writeVirtualProcessor(virtualProcessor, 0, value);

    vp_data_type_t result = readVirtualProcessor(virtualProcessor, 0);

    printf("%LF! = %Lf\n", value, result);

    freeVirtualProcessor(virtualProcessor);

    int s;

    waitpid(pid, &s, 0);

    return EXIT_SUCCESS;
}