package co.windly.firebaseremoteconfigsample.data.domain.manager;

import android.content.Context;
import co.windly.firebaseremoteconfigsample.data.domain.DaggerDomainComponent;
import co.windly.firebaseremoteconfigsample.data.network.manager.RemoteConfigurationNetworkManager;
import co.windly.firebaseremoteconfigsample.data.network.module.RemoteConfigurationModule;
import co.windly.firebaseremoteconfigsample.data.persistence.PersistenceModule;
import co.windly.firebaseremoteconfigsample.data.persistence.manager.RemoteConfigurationPersistenceManager;
import io.reactivex.Completable;
import io.reactivex.annotations.NonNull;
import javax.inject.Inject;

@SuppressWarnings("WeakerAccess")
public class RemoteConfigurationDomainManager {

  //region Fields

  @Inject
  RemoteConfigurationNetworkManager network;

  @Inject
  RemoteConfigurationPersistenceManager persistence;

  //endregion

  //region Constructor

  public RemoteConfigurationDomainManager(@NonNull Context context) {
    DaggerDomainComponent
      .builder()
      .remoteConfigurationModule(new RemoteConfigurationModule())
      .persistenceModule(new PersistenceModule(context))
      .build()
      .inject(this);
  }

  //endregion

  //region Remote Configuration

  public Completable downloadRemoteConfiguration() {
    return network
      .downloadRemoteConfiguration()
      .andThen(downloadWelcomeText());
  }

  //endregion

  //region Welcome Text

  private Completable downloadWelcomeText() {
    return network
      .getWelcomeText()
      .flatMapCompletable(persistence::saveWelcomeText);
  }

  //endregion
}
