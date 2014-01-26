package com.example.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ProjectPreferences {

	Context context;
	SharedPreferences pref;
	Editor edit;

	public static final String PREF_NAME = "idea_pref";

	public static final String KEY_FIRST = "nouser";
	public static final String KEY_SHOWDIALOG = "dialog";
	public static final String KEY_NAME = "name";
	public static final String KEY_COUNTRY = "country";
	public static final String KEY_DOB = "dob";
	
	public static final String KEY_INTEGRITY_BADGE = "badge";
	public static final String KEY_INTEGRITY_LVL = "level";

	public ProjectPreferences(Context context) {
		this.context = context;
		pref = this.context.getSharedPreferences(PREF_NAME,
				Context.MODE_PRIVATE);
		edit = pref.edit();
	}

	public void isSignedUp(boolean state) {
		edit.putBoolean(KEY_FIRST, state);
		edit.commit();
	}

	public boolean getSignedUp() {
		return pref.getBoolean(KEY_FIRST, false);
	}

	public void setHelperDialog(boolean state) {
		edit.putBoolean(KEY_SHOWDIALOG, state);
		edit.commit();
	}

	public boolean getShowDialog() {
		return pref.getBoolean(KEY_FIRST, true);
	}

	public void setName(String name) {
		edit.putString(KEY_NAME, name);
		edit.commit();
	}

	public String getName() {
		return pref.getString(KEY_NAME, "");
	}

	public void setDOB(String dob) {
		edit.putString(KEY_DOB, dob);
		edit.commit();
	}

	public String getDOB() {
		return pref.getString(KEY_DOB, "");
	}

	public void setCountry(String country) {
		edit.putString(KEY_COUNTRY, country);
		edit.commit();
	}

	public String getCountry() {
		return pref.getString(KEY_COUNTRY, "");
	}
	
	public void setBadge(int badge) {
		edit.putInt(KEY_INTEGRITY_BADGE, badge);
		edit.commit();
	}

	public int getBadge() {
		return pref.getInt(KEY_INTEGRITY_BADGE, 0);
	}
	
	public void setLevel(int level) {
		edit.putInt(KEY_INTEGRITY_LVL, level);
		edit.commit();
	}

	public int getLevel() {
		return pref.getInt(KEY_INTEGRITY_LVL, 0);
	}

	public void clearall() {
		edit.clear();
		edit.commit();
	}

}
