package co.windly.firebaseremoteconfigsample.utility.log;

import timber.log.Timber;

@SuppressWarnings("ALL")
public class SampleLogger {

  //region Constructor

  private SampleLogger() {
    /* No-op. */
  }

  //endregion

  //region Initialization

  public static void init(boolean enable) {
    if (enable) {
      Timber.plant(new Timber.DebugTree());
    }
  }

  //endregion

  //region Verbose

  public static <T> void v(String message, T... objects) {
    Timber.v(message, objects);
  }

  public static <T> void v(Throwable throwable, String message, T... objects) {
    Timber.v(throwable, message, objects);
  }

  //endregion

  //region Debug

  public static <T> void d(String message, T... objects) {
    Timber.d(message, objects);
  }

  public static <T> void d(Throwable throwable, String message, T... objects) {
    Timber.d(throwable, message, objects);
  }

  //endregion

  //region Info

  public static <T> void i(String message, T... objects) {
    Timber.i(message, objects);
  }

  public static <T> void i(Throwable throwable, String message, T... objects) {
    Timber.i(throwable, message, objects);
  }

  //endregion

  //region Warning

  public static <T> void w(String message, T... objects) {
    Timber.w(message, objects);
  }

  public static <T> void w(Throwable throwable, String message, T... objects) {
    Timber.w(throwable, message, objects);
  }

  //endregion

  //region Error

  public static <T> void e(String message, T... objects) {
    Timber.e(message, objects);
  }

  public static <T> void e(Throwable throwable, String message, T... objects) {
    Timber.e(throwable, message, objects);
  }

  //endregion

  //region What a Terrible Failure

  public static <T> void wtf(String message, T... objects) {
    Timber.wtf(message, objects);
  }

  public static <T> void wtf(Throwable throwable, String message, T... objects) {
    Timber.wtf(throwable, message, objects);
  }

  //endregion
}
