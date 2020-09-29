package sg.nets.com.singpass.api;

import org.keycloak.services.resource.RealmResourceProvider;

public class SingPassEnvResourceProvider implements RealmResourceProvider{

	@Override
	public void close() {		
	}

	@Override
	public Object getResource() {
		return new SingPassEnvResource();
	}

}
