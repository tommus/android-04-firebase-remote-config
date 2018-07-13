package co.windly.firebaseremoteconfigsample.application;

import android.app.Application;
import co.windly.firebaseremoteconfigsample.BuildConfig;
import co.windly.firebaseremoteconfigsample.utility.debug.DebugBridge;
import co.windly.firebaseremoteconfigsample.utility.log.SampleLogger;

public class SampleApplication extends Application {

  //region Lifecycle

  @Override
  public void onCreate() {
    super.onCreate();

    initializeDebugBridge();
    initializeLogger();
  }

  //endregion

  //region Debug bridge

  private void initializeDebugBridge() {
    DebugBridge.init(BuildConfig.ENABLE_DEBUG_BRIDGE, this);
  }

  //endregion

  //region Logger

  private void initializeLogger() {
    SampleLogger.init(BuildConfig.DEBUG);
  }

  //endregion
}
