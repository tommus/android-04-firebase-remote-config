package co.windly.firebaseremoteconfigsample.data.network.definition;

import android.support.annotation.StringDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static co.windly.firebaseremoteconfigsample.data.network.definition.RemoteConfigurationParameter.WELCOME_TEXT;

@StringDef({
  WELCOME_TEXT
})
@Retention(RetentionPolicy.SOURCE)
public @interface RemoteConfigurationParameter {

  String WELCOME_TEXT = "welcome_text";
}
