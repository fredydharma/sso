package sg.nets.com.singpass.api;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.services.resource.RealmResourceProviderFactory;

public class SingPassResourceProviderFactory  implements RealmResourceProviderFactory{

	@Override
	public RealmResourceProvider create(KeycloakSession session) {
		return new SingPassResourceProvider(session);
	}

	@Override
	public void init(Config.Scope config) {		
	}

	@Override
	public void postInit(KeycloakSessionFactory factory) {		
	}

	@Override
	public void close() {		
	}

	@Override
	public String getId() {		
		return "getPerson";
	}

	
}
