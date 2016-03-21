package pro.solution.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import pro.solution.shared.Person;


/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface RpcService extends RemoteService {
	String test() throws IllegalArgumentException;

	Person authorizeUser(String username, String password) throws IllegalArgumentException;
}
