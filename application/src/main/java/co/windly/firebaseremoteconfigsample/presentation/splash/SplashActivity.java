package co.windly.firebaseremoteconfigsample.presentation.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import co.windly.firebaseremoteconfigsample.R;

public class SplashActivity extends AppCompatActivity {

  //region Lifecycle

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
  }

  //endregion
}
