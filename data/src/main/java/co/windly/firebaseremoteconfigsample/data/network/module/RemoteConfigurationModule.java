package co.windly.firebaseremoteconfigsample.data.network.module;

import android.support.annotation.NonNull;
import co.windly.firebaseremoteconfigsample.data.BuildConfig;
import co.windly.firebaseremoteconfigsample.data.R;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
public class RemoteConfigurationModule {

  //region Constructor

  public RemoteConfigurationModule() {
    // No-op.
  }

  //endregion

  //region Configuration

  @Provides
  @NonNull
  FirebaseRemoteConfig provideRemoteConfig(FirebaseRemoteConfigSettings settings) {
    final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
    config.setDefaults(R.xml.remote_config_defaults);
    config.setConfigSettings(settings);
    return config;
  }

  //endregion

  //region Settings

  @Provides
  @NonNull
  FirebaseRemoteConfigSettings provideRemoteConfigSettings() {
    return new FirebaseRemoteConfigSettings.Builder()
      .setDeveloperModeEnabled(BuildConfig.DEBUG)
      .build();
  }

  /**
   * Cache expires immediately in debug mode.
   */
  private static final long CACHE_DEBUG = 0L;

  /**
   * Cache expires in one hour by default.
   */
  private static final long CACHE_DEFAULT = 3_600L;

  @Provides
  @Named(value = "cache-expiration")
  long provideCacheExpiration() {
    return (BuildConfig.DEBUG) ? CACHE_DEBUG : CACHE_DEFAULT;
  }

  //endregion
}
