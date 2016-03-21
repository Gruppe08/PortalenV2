package pro.solution.client.ui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class ContentPanel extends Composite {

	private DeckLayoutPanel contentPanel;
	private Login login;
	private MainView mainView;

	public ContentPanel() {
		contentPanel = new DeckLayoutPanel();
		initWidget(contentPanel);
		
		login = new Login();
		contentPanel.add(login);
		
		mainView = new MainView();
		contentPanel.add(mainView);
		
		contentPanel.showWidget(login);
	}

	public void changeView(Widget panel) {
		contentPanel.showWidget(panel);
	}
	
	public Login getLogin() {
		return login;
	}
	
	public MainView getMainView() {
		return mainView;
	}
}
