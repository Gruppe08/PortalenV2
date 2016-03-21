package pro.solution.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Button;

public class MainView extends Composite {

	private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

	private Profile profile;
	private Settings settings;
	
	@UiField DeckLayoutPanel centerPanel;
	@UiField Button profileBtn;
	@UiField Button friendsBtn;
	@UiField Button settingsBtn;
	@UiField Button logoutBtn;

	interface MainViewUiBinder extends UiBinder<Widget, MainView> {
	}

	public MainView() {
		initWidget(uiBinder.createAndBindUi(this));
		
		profile = new Profile();
		centerPanel.add(profile);
		
		settings = new Settings();
		centerPanel.add(settings);
		
		centerPanel.showWidget(profile);
	}

	public void addClickHandlers(ClickHandler clickHandler){
		profileBtn.addClickHandler(clickHandler);
		friendsBtn.addClickHandler(clickHandler);
		settingsBtn.addClickHandler(clickHandler);
		logoutBtn.addClickHandler(clickHandler);
	}
	
	public void changeView(Widget panel) {
		centerPanel.showWidget(panel);
	}
	
	public Profile getProfile() {
		return profile;
	}
	
	public Settings getSettings() {
		return settings;
	}
	
	public Button getProfileBtn() {
		return profileBtn;
	}
	
	public Button getFriendsBtn() {
		return friendsBtn;
	}
	
	public Button getSettingsBtn() {
		return settingsBtn;
	}
	
	public Button getLogoutBtn() {
		return logoutBtn;
	}
}
