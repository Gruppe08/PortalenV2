package pro.solution.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

import pro.solution.shared.Person;

public interface RpcServiceAsync {
	void test(AsyncCallback<String> asyncCallback);
	void authorizeUser(String username, String password, AsyncCallback<Person> asyncCallback) throws IllegalArgumentException;
}
