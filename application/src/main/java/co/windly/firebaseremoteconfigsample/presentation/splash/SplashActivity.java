package co.windly.firebaseremoteconfigsample.presentation.splash;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import butterknife.BindView;
import co.windly.firebaseremoteconfigsample.R;
import co.windly.firebaseremoteconfigsample.presentation.base.BaseActivity;

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
    animateLogo();
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
}
