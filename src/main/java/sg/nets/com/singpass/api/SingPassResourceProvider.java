package sg.nets.com.singpass.api;

import org.keycloak.services.resource.RealmResourceProvider;

public class SingPassResourceProvider implements RealmResourceProvider{
	
	public SingPassResourceProvider() {		
	}
	
	@Override
	public Object getResource() {
		return new SingPassResource();
	}
	
	@Override
	public void close() {		
	}
}
