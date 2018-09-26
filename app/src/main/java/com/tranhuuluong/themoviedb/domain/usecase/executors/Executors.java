package com.tranhuuluong.themoviedb.domain.usecase.executors;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/**
 * Created by luongtran on 9/25/18.
 */
public final class Executors {

    private static final Executor WORKER_THREAD_EXECUTOR = java.util.concurrent.Executors.newCachedThreadPool(new ThreadFactory() {
        @Override
        public Thread newThread(final Runnable r) {
            return new Thread(new Runnable() {
                @Override
                public void run() {
                    android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                    r.run();
                }
            }, "Worker-Thread");
        }
    });

    private static final Executor MAIN_THREAD_EXECUTOR = new Executor() {
        private Handler handler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            handler.post(command);
        }
    };

    public static Executor worker() {
        return WORKER_THREAD_EXECUTOR;
    }

    public static Executor mainThread() {
        return MAIN_THREAD_EXECUTOR;
    }
}
