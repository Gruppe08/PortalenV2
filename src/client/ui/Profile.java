package pro.solution.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import pro.solution.shared.Person;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;

public class Profile extends Composite {

	private static ProfileUiBinder uiBinder = GWT.create(ProfileUiBinder.class);
	@UiField Image profilePicture;
	@UiField Label usernameLabel;
	@UiField RadioButton sexMaleRBtn;
	@UiField RadioButton sexFemaleRBtn;
	@UiField TextArea descriptionArea;

	interface ProfileUiBinder extends UiBinder<Widget, Profile> {
	}
	
	public Profile() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setProfileInfo(Person person) {
		profilePicture.setUrl(person.getUrlImage());
		usernameLabel.setText(person.getUsername());
		descriptionArea.setText(person.getDescription());
		
		if(person.getSex() == 'm'){
			sexMaleRBtn.setValue(true);
			sexMaleRBtn.setEnabled(true);
			sexFemaleRBtn.setEnabled(false);
		}
		else if(person.getSex() == 'f'){
			sexFemaleRBtn.setValue(true);
			sexFemaleRBtn.setEnabled(true);
			sexMaleRBtn.setEnabled(false);
		}
	}

}
