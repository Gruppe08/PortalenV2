package pro.solution.client.logik;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import pro.solution.client.rpc.RpcServiceAsync;
import pro.solution.client.ui.ContentPanel;
import pro.solution.shared.Person;

public class Controller {

	private ContentPanel content;
	private RpcServiceAsync rpcService;
	private Person currentPerson = null;
	
	public Controller(ContentPanel content, RpcServiceAsync service){
		this.content = content;
		this.rpcService = service;
		content.getLogin().addClickHandlers(new LoginClickHandler());
		content.getMainView().addClickHandlers(new MenuClickHandler());
		content.getMainView().getSettings().addClickHandlers(new ChangeSettingsClickHandler());
	}
	
	/**
	 * Håndtere handlingen når det klikkes på login "button"
	 * @author KonnerupsMac
	 *
	 */
	private class LoginClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			String username = content.getLogin().getUsernameBox().getText();
			String password = content.getLogin().getPasswordBox().getText();

			
			rpcService.authorizeUser(username, password, new AsyncCallback<Person>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Der skete en fejl");
					
				}

				@Override
				public void onSuccess(Person result) {
					if(result == null){
						Window.alert("Wrong username or password");
					}
					currentPerson = result;
					content.getMainView().getProfile().setProfileInfo(currentPerson);
					content.changeView(content.getMainView());
					content.getMainView().changeView(content.getMainView().getProfile());	
					
				}
			});

		}
	}
	
	private class MenuClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			if(event.getSource() == content.getMainView().getProfileBtn()){
				content.getMainView().changeView(content.getMainView().getProfile());
			}
			else if(event.getSource() == content.getMainView().getFriendsBtn()){
				
			}
			else if(event.getSource() == content.getMainView().getSettingsBtn()){
				content.getMainView().getSettings().setProfileSettings(currentPerson);
				content.getMainView().changeView(content.getMainView().getSettings());
			}
			else if(event.getSource() == content.getMainView().getLogoutBtn()){
				content.changeView(content.getLogin());
				content.getLogin().getUsernameBox().setText("");
				content.getLogin().getPasswordBox().setText("");
				currentPerson = null;
			}
		}
	}
	
	private class ChangeSettingsClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			currentPerson.setPassword(content.getMainView().getSettings().getPasswordBox().getText());
			currentPerson.setDescription(content.getMainView().getSettings().getDescriptionArea().getText());
			if(content.getMainView().getSettings().getSexMaleRBtn().getValue() == true){
				currentPerson.setSex('m');
			}
			else if(content.getMainView().getSettings().getSexFemaleRBtn().getValue() == true){
				currentPerson.setSex('f');
			}
			content.getMainView().getProfile().setProfileInfo(currentPerson);
			Window.alert("Change was succesful");
		}
	}
}
