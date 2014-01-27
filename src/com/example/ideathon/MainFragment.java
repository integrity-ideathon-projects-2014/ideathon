package com.example.ideathon;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.preferences.ProjectPreferences;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphPlace;
import com.facebook.model.GraphUser;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.LoginButton;

public class MainFragment extends Fragment {

	private static UiLifecycleHelper uiHelper;
	private static final String PERMISSION = "publish_actions";
	private static GraphUser user;
	private static boolean canPresentShareDialog;
	private ProjectPreferences pref;
	private static PendingAction pendingAction = PendingAction.NONE;
	private static List<GraphUser> tags = null;
	private static GraphPlace place;
	private static Activity activity;
	

	private enum PendingAction {
		NONE, POST_STATUS_UPDATE
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		activity = getActivity();
		uiHelper = new UiLifecycleHelper(getActivity(), callback);
		uiHelper.onCreate(savedInstanceState);
		pref = new ProjectPreferences(getActivity());
		onClickPostStatusUpdate();
	}

	private static boolean hasPublishPermission() {
		Session session = Session.getActiveSession();
		return session != null
				&& session.getPermissions().contains("publish_actions");
	}

	private void onClickPostStatusUpdate() {
		performPublish(PendingAction.POST_STATUS_UPDATE, canPresentShareDialog);
	}

	@SuppressWarnings("incomplete-switch")
	private void handlePendingAction() {
		PendingAction previouslyPendingAction = pendingAction;
		// These actions may re-set pendingAction if they are still pending, but
		// we assume they
		// will succeed.
		pendingAction = PendingAction.NONE;

		switch (previouslyPendingAction) {
		case POST_STATUS_UPDATE:
			postStatusUpdate();
			break;
		}
	}

	private static FacebookDialog.ShareDialogBuilder createShareDialogBuilder() {
		return new FacebookDialog.ShareDialogBuilder(activity)
				.setName("Hello Facebook")
				.setDescription(
						"The 'Hello Facebook' sample application showcases simple Facebook integration")
				.setLink("http://developers.facebook.com/android");
	}

	private static void showPublishResult(String message, GraphObject result,
			FacebookRequestError error) {
		String title = null;
		String alertMessage = null;
		if (error == null) {
			title = "The title";
			String id = "My id";
			alertMessage = "Alert message";
		} else {
			title = "Error in title";
			alertMessage = error.getErrorMessage();
		}
	}

	private static void postStatusUpdate() {
		if (canPresentShareDialog) {
			FacebookDialog shareDialog = createShareDialogBuilder().build();
			uiHelper.trackPendingDialogCall(shareDialog.present());
			System.out.println("yeha");
		} else if (user != null && hasPublishPermission()) {
			final String message = "Playing integrity test for Ideathon.";
			System.out.println("yeha1");// getString("R.string.status_update",
			// user.getFirstName(), (new Date().toString()));
			Request request = Request.newStatusUpdateRequest(
					Session.getActiveSession(), message, place, tags,
					new Request.Callback() {
						@Override
						public void onCompleted(Response response) {
							showPublishResult(message,
									response.getGraphObject(),
									response.getError());
							System.out.println("yeha2");
						}
					});
			request.executeAsync();
		} else {
			pendingAction = PendingAction.POST_STATUS_UPDATE;
			System.out.println("yeha3");
		}
	}

	private void performPublish(PendingAction action, boolean allowNoSession) {
		Session session = Session.getActiveSession();
		if (session != null) {
			pendingAction = action;
			if (hasPublishPermission()) {
				// We can do the action right away.
				handlePendingAction();
				return;
			} else if (session.isOpened()) {
				// We need to get new permissions, then complete the action when
				// we get called back.
				session.requestNewPublishPermissions(new Session.NewPermissionsRequest(
						this, PERMISSION));
				return;
			}
		}

		if (allowNoSession) {
			pendingAction = action;
			handlePendingAction();
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		uiHelper.onDestroy();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		uiHelper.onPause();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Session session = Session.getActiveSession();
		if (session != null && (session.isOpened() || session.isClosed())) {
			onSessionStateChange(session, session.getState(), null);
		}
		uiHelper.onResume();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state,
				Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_main, container, false);
		LoginButton authButton = (LoginButton) view
				.findViewById(R.id.authButton);
		// final TextView tvName = (TextView) view.findViewById(R.id.tvName);
		/*
		 * final TextView tvLink = (TextView) view.findViewById(R.id.tvLink);
		 * final TextView tvId = (TextView) view.findViewById(R.id.tvId);
		 */
		authButton.setFragment(this);
		authButton
				.setUserInfoChangedCallback(new LoginButton.UserInfoChangedCallback() {

					@Override
					public void onUserInfoFetched(GraphUser user) {
						// TODO Auto-generated method stub
						MainFragment.this.user = user;
						if (user != null) {
							System.out.println("Hey: "+user.getFirstName());
							pref.setName(user.getName());
							pref.setDOB(user.getBirthday());
							pref.setCountry(user.getLocation() + "");
							String location = user.getLocation().toString();
							String country = getCountry(location.toString());
							System.out.println("Location: "+user.getLocation());
							System.out.println("Country: "+country+"");
							System.out.println("Birthday:"+user.getBirthday());
//							postStatusUpdate();
							Intent intent = new Intent(getActivity(), PlayTheme.class);
							getActivity().startActivity(intent);
							
						} else {
							System.out.println("User is null---Nabin");
						}

					}

					private String getCountry(String location) {
						// TODO Auto-generated method stub
						
						int len = location.length()-2;
						int start = location.indexOf("name")+6;
						return location.substring(start, len);
					}
				});
		return view;
	}

	private void onSessionStateChange(Session session, SessionState state,
			Exception exception) {
		if (state.isOpened()) {
			System.out.println("Logged in...");

		} else if (state.isClosed()) {
			System.out.println("Logged out...");
		}
	}
	
	public static void postupdate() {
		postStatusUpdate();
	}

}