package com.yl.handler;

import java.io.File;

/**
 * * @Description Activity线程
 * * @Author 刘亚林
 * * @CreateDate 2020/10/13
 * * @Version 1.0
 * * @Remark TODO
 **/
public class ActivityThread {
    H mH = new H();

    public void attach(boolean b) {
        Activity activity = new MainActivity();
        activity.onCreate();
        Message message = new Message();
        message.obj = activity;
        mH.handlerMessage(message);
    }

    static class H extends Handler {
        public void handlerMessage(Message message) {
            Activity activity = (Activity) message.obj;
            activity.onResume();
        }
    }
    public static void main(String[] args) {
        Looper.prepare();
        ActivityThread thread = new ActivityThread();
        thread.attach(false);
        Looper.loop();
    }
//    public static void main(String[] args) {
//        Trace.traceBegin(Trace.TRACE_TAG_ACTIVITY_MANAGER, "ActivityThreadMain");
//
//        // Install selective syscall interception
//        AndroidOs.install();
//
//        // CloseGuard defaults to true and can be quite spammy.  We
//        // disable it here, but selectively enable it later (via
//        // StrictMode) on debug builds, but using DropBox, not logs.
//        CloseGuard.setEnabled(false);
//
//        Environment.initForCurrentUser();
//
//        // Make sure TrustedCertificateStore looks in the right place for CA certificates
//        final File configDir = Environment.getUserConfigDirectory(UserHandle.myUserId());
//        TrustedCertificateStore.setDefaultUserDirectory(configDir);
//
//        Process.setArgV0("<pre-initialized>");
//
//        Looper.prepareMainLooper();
//
//        // Find the value for {@link #PROC_START_SEQ_IDENT} if provided on the command line.
//        // It will be in the format "seq=114"
//        long startSeq = 0;
//        if (args != null) {
//            for (int i = args.length - 1; i >= 0; --i) {
//                if (args[i] != null && args[i].startsWith(PROC_START_SEQ_IDENT)) {
//                    startSeq = Long.parseLong(
//                            args[i].substring(PROC_START_SEQ_IDENT.length()));
//                }
//            }
//        }
//        ActivityThread thread = new ActivityThread();
//        thread.attach(false, startSeq);
//
//        if (sMainThreadHandler == null) {
//            sMainThreadHandler = thread.getHandler();
//        }
//
//        if (false) {
//            Looper.myLooper().setMessageLogging(new
//                    LogPrinter(Log.DEBUG, "ActivityThread"));
//        }
//
//        // End of event ActivityThreadMain.
//        Trace.traceEnd(Trace.TRACE_TAG_ACTIVITY_MANAGER);
//        Looper.loop();
//
//        throw new RuntimeException("Main thread loop unexpectedly exited");
//    }
}
