package co.windly.firebaseremoteconfigsample.data.network.manager;

import co.windly.firebaseremoteconfigsample.utility.log.SampleLogger;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.reactivex.Completable;
import io.reactivex.Single;
import javax.inject.Inject;
import javax.inject.Named;

import static co.windly.firebaseremoteconfigsample.data.network.definition.RemoteConfigurationParameter.WELCOME_TEXT;

@SuppressWarnings("WeakerAccess")
public class RemoteConfigurationNetworkManager {

  //region Service

  @Inject
  FirebaseRemoteConfig config;

  @Inject
  @Named(value = "cache-expiration")
  long cacheExpiration;

  //endregion

  //region Constructor

  @Inject
  public RemoteConfigurationNetworkManager() {
    // No-op.
  }

  //endregion

  //region Remote Configuration

  public Completable downloadRemoteConfiguration() {
    return Completable.fromAction(
      () -> config.fetch(cacheExpiration)
        .addOnCompleteListener(task -> {
          if (task.isSuccessful()) {
            SampleLogger.v("Successfully fetched remote configuration.");
            config.activateFetched();
          } else {
            SampleLogger.v("An error occurred while fetching remote configuration.");
          }
        }));
  }

  //endregion

  //region Welcome Text

  public Single<String> getWelcomeText() {
    return Single.fromPublisher(publsher -> {
      final String text = config.getString(WELCOME_TEXT);
      publsher.onNext(text);
      publsher.onComplete();
    });
  }

  //endregion
}
