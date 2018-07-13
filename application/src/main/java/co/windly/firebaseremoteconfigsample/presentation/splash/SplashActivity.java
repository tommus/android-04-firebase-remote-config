package co.windly.firebaseremoteconfigsample.presentation.splash;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import butterknife.BindView;
import co.windly.firebaseremoteconfigsample.R;
import co.windly.firebaseremoteconfigsample.data.domain.manager.RemoteConfigurationDomainManager;
import co.windly.firebaseremoteconfigsample.presentation.base.BaseActivity;
import co.windly.firebaseremoteconfigsample.utility.log.SampleLogger;
import io.reactivex.annotations.NonNull;

public class SplashActivity extends BaseActivity {

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.activity_splash;
  }

  //endregion

  //region Lifecycle

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Animate logo.
    animateLogo();

    // Download (refresh) remote configuration.
    downloadRemoteConfiguration();
  }

  //endregion

  //region Managers

  private RemoteConfigurationDomainManager remoteConfigurationManager;

  @Override
  protected void initializeManagers() {
    super.initializeManagers();
    remoteConfigurationManager = new RemoteConfigurationDomainManager(this);
  }

  //endregion

  //region Logo

  @BindView(R.id.logo)
  ImageView logoView;

  private void animateLogo() {
    final Drawable drawable = logoView.getDrawable();
    if (drawable instanceof Animatable) {
      final Animatable animatable = (Animatable) drawable;
      animatable.start();
    }
  }

  //endregion

  //region Remote Configuration

  private void downloadRemoteConfiguration() {
    disposables.add(
      remoteConfigurationManager
        .downloadRemoteConfiguration()
        .subscribe(
          this::handleDownloadRemoteConfigurationSuccess,
          this::handleDownloadRemoteConfigurationError
        ));
  }

  private void handleDownloadRemoteConfigurationSuccess() {
    SampleLogger.v("Successfully refreshed remote configuration.");
  }

  private void handleDownloadRemoteConfigurationError(@NonNull Throwable throwable) {
    SampleLogger.v("An error occurred while refreshing remote configuration.");
    SampleLogger.v(throwable.getLocalizedMessage());
  }

  //endregion
}
