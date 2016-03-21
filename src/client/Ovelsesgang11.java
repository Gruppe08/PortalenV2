package pro.solution.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import pro.solution.client.logik.Controller;
import pro.solution.client.rpc.RpcService;
import pro.solution.client.rpc.RpcServiceAsync;
import pro.solution.client.ui.ContentPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Ovelsesgang11 implements EntryPoint {

	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ContentPanel content = new ContentPanel();
		RootLayoutPanel.get().add(content);
		RpcServiceAsync rpcService = GWT.create(RpcService.class);
		new Controller(content, rpcService);
	}
}