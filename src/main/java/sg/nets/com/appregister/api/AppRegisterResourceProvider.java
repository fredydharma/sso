package sg.nets.com.appregister.api;

import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

public class AppRegisterResourceProvider implements RealmResourceProvider{
	
	private KeycloakSession session;
	
	public AppRegisterResourceProvider(KeycloakSession session) {
        this.session = session;
    }
	
	@Override
	public Object getResource() {
		return new AppRegisterResource(session);
	}
	
	@Override
	public void close() {		
	}
}
