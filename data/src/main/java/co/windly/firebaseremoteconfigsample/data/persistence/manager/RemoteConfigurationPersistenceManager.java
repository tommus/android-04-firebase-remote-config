package co.windly.firebaseremoteconfigsample.data.persistence.manager;

import co.windly.firebaseremoteconfigsample.data.persistence.settings.RemoteConfigurationPrefs;
import io.reactivex.Completable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

import static io.reactivex.annotations.SchedulerSupport.IO;

@SuppressWarnings("WeakerAccess")
public class RemoteConfigurationPersistenceManager {

  //region Fields

  @Inject
  RemoteConfigurationPrefs remoteConfiguration;

  //endregion

  //region Constructor

  @Inject
  public RemoteConfigurationPersistenceManager() {
    // No-op.
  }

  //endregion

  //region Welcome Text

  @SchedulerSupport(value = IO)
  public Completable saveWelcomeText(@NonNull String text) {
    return Completable.fromAction(
      () -> remoteConfiguration.edit().putWelcomeText(text).apply()
    ).subscribeOn(Schedulers.io());
  }

  //endregion
}
