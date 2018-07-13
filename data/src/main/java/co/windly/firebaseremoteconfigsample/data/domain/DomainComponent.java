package co.windly.firebaseremoteconfigsample.data.domain;

import co.windly.firebaseremoteconfigsample.data.domain.manager.RemoteConfigurationDomainManager;
import co.windly.firebaseremoteconfigsample.data.network.module.RemoteConfigurationModule;
import co.windly.firebaseremoteconfigsample.data.persistence.PersistenceModule;
import dagger.Component;

@Component(modules = {
  PersistenceModule.class,
  RemoteConfigurationModule.class
})
public interface DomainComponent {

  //region Injections

  void inject(RemoteConfigurationDomainManager manager);

  //endregion
}
