package co.windly.firebaseremoteconfigsample.presentation.splash;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import co.windly.firebaseremoteconfigsample.R;
import co.windly.firebaseremoteconfigsample.data.domain.manager.RemoteConfigurationDomainManager;
import co.windly.firebaseremoteconfigsample.presentation.base.BaseActivity;
import co.windly.firebaseremoteconfigsample.utility.log.SampleLogger;
import co.windly.firebaseremoteconfigsample.utility.view.ViewUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

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

    // Observe welcome text.
    observeWelcomeText();

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

  //region Loading

  @BindView(R.id.loading)
  View loadingView;

  private void showLoading(boolean flag) {
    ViewUtil.changeVisibility(loadingView, flag);
  }

  //endregion

  //region Text

  @BindView(R.id.text)
  TextView textView;

  private void showText(boolean flag) {
    ViewUtil.changeVisibility(textView, flag);
  }

  private void setText(@NonNull CharSequence text) {
    textView.setText(text);
  }

  //endregion

  //region Remote Configuration

  private void downloadRemoteConfiguration() {
    disposables.add(
      remoteConfigurationManager
        .downloadRemoteConfiguration()
        .doOnSubscribe(disposable -> {
          showLoading(true);
          showText(false);
        })
        .doFinally(() -> {
          showLoading(false);
          showText(true);
        })
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

  //region Welcome Text

  private void observeWelcomeText() {
    disposables.add(
      remoteConfigurationManager
        .observeWelcomeText()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::handleObserveWelcomeTextSuccess,
          this::handleObserveWelcomeTextError
        ));
  }

  private void handleObserveWelcomeTextSuccess(@NonNull String text) {
    setText(text);
  }

  private void handleObserveWelcomeTextError(@NonNull Throwable throwable) {
    SampleLogger.v("An error occurred while fetching welcome text.");
    SampleLogger.v(throwable.getLocalizedMessage());
  }

  //endregion
}
