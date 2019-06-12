package Stacioni;
import java.util.prefs.Preferences;

public class LanguagePreference {

	private Preferences prefs;
	private final String LANG="Languages.lang";
	
	
	public void setLang(String lang) {
		prefs.put(LANG, lang);	
	}
	
	public String getLang() {
		
		return prefs.get(LANG, "en");
	}
	
	public LanguagePreference Preference() {
		prefs=Preferences.userRoot().node(this.getClass().getName());
		return this;
		
	}
	
	
	
}