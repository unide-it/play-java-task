package utils;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

public class CompletableFutureUtils {
    private CompletableFutureUtils() {
    }

    public static <E> CompletableFuture<Collection<E>> allOf(Collection<CompletableFuture<E>> completableFutures) {
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        return allFutures.thenApply(future -> completableFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList()));
    }
}
