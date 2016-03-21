package pro.solution.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import pro.solution.shared.Person;

public class Settings extends Composite {

	private static SettingsUiBinder uiBinder = GWT.create(SettingsUiBinder.class);
	@UiField TextBox passwordBox;
	@UiField RadioButton sexMaleRBtn;
	@UiField RadioButton sexFemaleRBtn;
	@UiField TextArea descriptionArea;
	@UiField Button changeProfileBtn;

	interface SettingsUiBinder extends UiBinder<Widget, Settings> {
	}
	
	public Settings() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void addClickHandlers(ClickHandler clickHandler){
		changeProfileBtn.addClickHandler(clickHandler);
	}

	public void setProfileSettings(Person person) {
		passwordBox.setText(person.getPassword());
		descriptionArea.setText(person.getDescription());
		
		if(person.getSex() == 'm'){
			sexMaleRBtn.setValue(true);
			sexMaleRBtn.setEnabled(true);
		}
		else if(person.getSex() == 'f'){
			sexFemaleRBtn.setValue(true);
			sexFemaleRBtn.setEnabled(true);
		}
	}
	
	public TextBox getPasswordBox() {
		return passwordBox;
	}
	
	public TextArea getDescriptionArea() {
		return descriptionArea;
	}
	
	public RadioButton getSexMaleRBtn() {
		return sexMaleRBtn;
	}
	
	public RadioButton getSexFemaleRBtn() {
		return sexFemaleRBtn;
	}
}

