package co.windly.firebaseremoteconfigsample.presentation.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity extends AppCompatActivity {

  //region Threading

  protected CompositeDisposable disposables = new CompositeDisposable();

  //endregion

  //region Ui

  @LayoutRes
  protected abstract int getLayout();

  //endregion

  //region Lifecycle

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayout());
    initializeViews();
    initializeManagers();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    disposables.clear();
  }

  //endregion

  //region View Injection

  protected void initializeViews() {
    ButterKnife.bind(this);
  }

  //endregion

  //region Managers

  protected void initializeManagers() {
    // No-op.
  }

  //endregion
}
