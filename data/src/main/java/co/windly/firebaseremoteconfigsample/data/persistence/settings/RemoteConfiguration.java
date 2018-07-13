package co.windly.firebaseremoteconfigsample.data.persistence.settings;

import org.jraf.android.prefs.DefaultString;
import org.jraf.android.prefs.Prefs;

import static android.content.Context.MODE_PRIVATE;

@Prefs(value = "RemoteConfigurationPreferences", fileMode = MODE_PRIVATE)
public class RemoteConfiguration {

  //region Welcome Text

  @DefaultString("")
  String welcomeText;

  //endregion
}
