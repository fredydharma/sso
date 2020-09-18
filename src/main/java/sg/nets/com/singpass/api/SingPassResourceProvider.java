package sg.nets.com.singpass.api;

import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

public class SingPassResourceProvider implements RealmResourceProvider{
	
	private KeycloakSession session;
	
	public SingPassResourceProvider(KeycloakSession session) {
        this.session = session;
    }
	
	@Override
	public Object getResource() {
		return new SingPassResource(session);
	}
	
	@Override
	public void close() {		
	}
}
