package co.windly.firebaseremoteconfigsample.utility.view;

import android.view.View;

public class ViewUtil {

  //region Visibility

  public static void changeVisibility(View view, boolean flag) {
    changeVisibility(view, flag, View.GONE);
  }

  public static void changeVisibility(View view, boolean flag, int falseRes) {
    final int visibility = (flag) ? View.VISIBLE : falseRes;
    view.setVisibility(visibility);
  }

  //endregion
}
