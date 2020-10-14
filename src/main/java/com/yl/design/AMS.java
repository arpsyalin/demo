package com.yl.design;

import java.util.HashMap;

/**
 * * @Description ams代理模式梳理
 * * @Author 刘亚林
 * * @CreateDate 2020/10/14
 * * @Version 1.0
 * * @Remark TODO  没看源码纯手写 未验证是否正确
 **/
public class AMS {
    public abstract static class Singleton<T> {
        T instance;

        Singleton() {
            instance = create();
        }

        public abstract T create();

        public T get() {
            return instance;
        }
    }

    public static class ActivityManager {
        private static final Singleton<IActivityManager> IActivityManagerSingleton =
                new Singleton<IActivityManager>() {
                    @Override
                    public IActivityManager create() {
                        final IBinder b = ServiceManager.getService("Activity");
                        final IActivityManager am = IActivityManager.Stub.asInterface(b);
                        return am;
                    }
                };

        public ActivityManager() {
        }

        public String getService() {
            return ActivityManagerNative.getDefault().getService();
        }

        public String getRunningService() {
            return IActivityManagerSingleton.get().getService();
        }

    }


    public interface IBinder {
        IActivityManager asInterface();
    }

    public interface IActivityManager {
        String getService();

        class Stub {
            public static IActivityManager asInterface(IBinder iBinder) {
                if (iBinder instanceof IActivityManager) {
                    return (IActivityManager) iBinder;
                }
                return null;
            }
        }
    }


    public static abstract class ActivityManagerNative implements IActivityManager, IBinder {
        @Override
        public IActivityManager asInterface() {
            return this;
        }

        public static IActivityManager getDefault() {
            return new ActivityManagerProxy("Activity").mActivityManagerNative;
        }

        public static class ActivityManagerProxy {
            ActivityManagerNative mActivityManagerNative;

            public ActivityManagerProxy(String type) {
                mActivityManagerNative = (ActivityManagerNative) ServiceManager.getService(type).asInterface();
            }

            public String getService() {
                return mActivityManagerNative.getService();
            }
        }
    }

    public static class ActivityManagerService extends ActivityManagerNative {
        @Override
        public String getService() {
            return "ActivityManagerNative";
        }
    }


    public static class ServiceManager {
        static HashMap<String, IBinder> map = new HashMap<>();

        public static IBinder getService(String type) {
            if (!map.containsKey(type)) {
                map.put(type, new ActivityManagerService());
            }
            return map.get(type);
        }
    }
}
