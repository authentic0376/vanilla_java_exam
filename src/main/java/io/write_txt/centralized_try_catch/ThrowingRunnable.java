package io.write_txt.centralized_try_catch;

@FunctionalInterface
public interface ThrowingRunnable {
    void run() throws Exception;
}
