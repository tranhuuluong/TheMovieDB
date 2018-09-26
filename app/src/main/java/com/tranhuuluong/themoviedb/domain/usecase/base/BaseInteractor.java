package com.tranhuuluong.themoviedb.domain.usecase.base;

import com.tranhuuluong.themoviedb.domain.usecase.executors.Executors;
import com.tranhuuluong.themoviedb.domain.usecase.listener.ResponseListener;

import java.util.concurrent.Executor;

/**
 * Created by luongtran on 9/25/18.
 */
public abstract class BaseInteractor {
    private Executor workerExecutor;
    private Executor callbackExecutor;

    public BaseInteractor() {
        this(Executors.worker(), Executors.mainThread());
    }

    public BaseInteractor(Executor workerExecutor, Executor callbackExecutor) {
        this.workerExecutor = workerExecutor;
        this.callbackExecutor = callbackExecutor;
        if (workerExecutor == null) {
            throw new IllegalArgumentException("Worker executor cannot be null");
        }

        if (callbackExecutor == null) {
            throw new IllegalArgumentException("Callback executor cannot be null");
        }
    }

    protected void submitTask(Runnable taskRunnable) {
        workerExecutor.execute(taskRunnable);
    }

    protected void notifyCallback(Runnable callbackRunnable) {
        callbackExecutor.execute(callbackRunnable);
    }

    protected <T> void notifyCallback(final ResponseListener<T> listener, final T result, final Exception e) {
        if (listener != null) {
            notifyCallback(new Runnable() {
                @Override
                public void run() {
                    listener.onResponse(result, e);
                }
            });
        }
    }
}
