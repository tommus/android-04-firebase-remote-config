package co.windly.firebaseremoteconfigsample.data.persistence;

import android.content.Context;
import android.support.annotation.NonNull;
import co.windly.firebaseremoteconfigsample.data.persistence.settings.RemoteConfigurationPrefs;
import dagger.Module;
import dagger.Provides;

@Module
public class PersistenceModule {

  //region Fields

  private Context context;

  //endregion

  //region Constructor

  public PersistenceModule(@NonNull Context context) {
    this.context = context;
  }

  //endregion

  //region Preferences

  @Provides
  @NonNull
  RemoteConfigurationPrefs provideRemoteConfigurationPreferences() {
    return RemoteConfigurationPrefs.get(context);
  }

  //endregion
}
