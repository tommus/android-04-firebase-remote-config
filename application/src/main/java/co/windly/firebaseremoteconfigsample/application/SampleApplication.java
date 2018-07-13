package co.windly.firebaseremoteconfigsample.application;

import android.app.Application;
import co.windly.firebaseremoteconfigsample.BuildConfig;
import co.windly.firebaseremoteconfigsample.R;
import co.windly.firebaseremoteconfigsample.utility.debug.DebugBridge;
import co.windly.firebaseremoteconfigsample.utility.log.SampleLogger;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class SampleApplication extends Application {

  //region Lifecycle

  @Override
  public void onCreate() {
    super.onCreate();

    initializeDebugBridge();
    initializeFonts();
    initializeLogger();
  }

  //endregion

  //region Debug bridge

  private void initializeDebugBridge() {
    DebugBridge.init(BuildConfig.ENABLE_DEBUG_BRIDGE, this);
  }

  //endregion

  //region Fonts

  private static final String DEFAULT_FONT_PATH = "fonts/ProximaNova-Regular.otf";

  private void initializeFonts() {
    CalligraphyConfig.initDefault(
      new CalligraphyConfig.Builder()
        .setDefaultFontPath(DEFAULT_FONT_PATH)
        .setFontAttrId(R.attr.fontPath)
        .build());
  }

  //endregion

  //region Logger

  private void initializeLogger() {
    SampleLogger.init(BuildConfig.DEBUG);
  }

  //endregion
}
