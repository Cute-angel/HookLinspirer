package com.floxcat.hooklinspirer;
import android.content.Context;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import com.floxcat.hooklinspirer.utils.UtilsForHook;

public class HookMain  implements IXposedHookLoadPackage {

    //for AppStore
    public String LTKTacticsTotalApps = "";
    public UtilsForHook.Applist applist;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
//        if (!lpparam.packageName.equals("com.innofidei.guardsecure")) {
//            return;
//        }
        hookSN(lpparam, "HA12YBEV");
        hookRomVerison(lpparam);
        hookModel(lpparam);
//      it seems that swdid refer to mac_address
        hookSwdId(lpparam);

        hookLTKTacticsTotalApps(lpparam);
    }

    void hookRomVerison(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("com.linspirer.utils.d", lpparam.classLoader, "q", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult("TB-X605M_S000001_221128_DaWanJiaoYu");
//                Toast.makeText(Activity,"Version",Toast.LENGTH_SHORT).show();
//                XposedBridge.log("Version");
            }
        });
    }

    void hookSN(XC_LoadPackage.LoadPackageParam lpparam, String sn) {
        XposedHelpers.findAndHookMethod("com.linspirer.utils.d", lpparam.classLoader, "g", Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(sn);
            }
        });
    }

    void hookModel(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("com.linspirer.utils.d", lpparam.classLoader, "e", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult("Lenovo TB-X605M");
            }
        });
    }

    void hookSwdId(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("com.linspirer.utils.d", lpparam.classLoader, "a", android.content.Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                param.setResult(UtilsForHook.getMacaddres());
            }
        });
    }
    //[for App store]
    void hookLTKTacticsTotalApps(XC_LoadPackage.LoadPackageParam lpparam) {
//        Class<?> ItemApp = XposedHelpers.findClass("com.android.launcher3.model.ItemApp",lpparam.classLoader);
        XposedHelpers.findAndHookMethod("com.android.launcher3.model.LTKTactics", lpparam.classLoader, "setTotalApps", java.util.List.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                setApplist(new UtilsForHook.Applist((String) param.args[0]));
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
            }
        });
    }

    public UtilsForHook.Applist getApplist() {
        return applist;
    }

    public void setApplist(UtilsForHook.Applist applist) {
        this.applist = applist;
    }
}
