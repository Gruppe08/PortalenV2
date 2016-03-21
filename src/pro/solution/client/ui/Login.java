package pro.solution.client.ui;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Login extends Composite {
	
	Button loginBtn;
	TextBox usernameBox;
	PasswordTextBox passwordBox;
	
	public Login(){
		VerticalPanel outerPanel = new VerticalPanel();
		outerPanel.setSize("100%", "100%");
		outerPanel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
		outerPanel.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
		
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setSpacing(10);
		
		Label titleLbl = new Label("DØKBook");
		titleLbl.setStyleName("title");
		Label usernameLbl = new Label("Username: ");
		Label passwordLbl = new Label("Password: ");
		usernameBox = new TextBox();
		passwordBox = new PasswordTextBox();
		loginBtn = new Button("Login");

		vPanel.add(titleLbl);
		vPanel.add(usernameLbl);
		vPanel.add(usernameBox);
		vPanel.add(passwordLbl);
		vPanel.add(passwordBox);
		vPanel.add(loginBtn);
		
		outerPanel.add(vPanel);
		
		initWidget(outerPanel);
	}
	
	public void addClickHandlers(ClickHandler clickHandler){
		loginBtn.addClickHandler(clickHandler);
	}
	
	public TextBox getUsernameBox() {
		return usernameBox;
	}
	
	public PasswordTextBox getPasswordBox() {
		return passwordBox;
	}
}	
