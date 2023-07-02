package edu.sandbox.tasks.algorithms.seabattlecountships;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

public class MatrixArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                of(new int[][]{
                        {0, 0},
                        {0, 0}
                }, 0),
                of(new int[][]{
                        {1, 0},
                        {0, 0}
                }, 1),
                of(new int[][]{
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1}
                }, 1),
                of(new int[][]{
                        {0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0}
                }, 2),
                of(new int[][]{
                        {0, 1, 0, 1},
                        {0, 1, 0, 1},
                        {0, 1, 0, 0},
                        {0, 0, 0, 1},
                }, 3),
                of(new int[][]{
                        {1, 0, 1, 0, 1, 0},
                        {1, 0, 1, 0, 1, 0},
                        {1, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0}
                }, 5),
                of(new int[][]{
                        {1, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1, 0},
                        {1, 0, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0},
                        {1, 0, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0}
                }, 6),
                of(new int[][]{
                        {1, 1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1, 0},
                        {1, 0, 1, 0, 1, 0},
                        {1, 0, 0, 0, 0, 0}
                }, 6)
        );
    }
}
