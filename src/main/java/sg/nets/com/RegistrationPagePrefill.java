package sg.nets.com;

import org.jboss.logging.Logger;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.FormAuthenticator;
import org.keycloak.authentication.FormContext;
import org.keycloak.authentication.forms.RegistrationPage;
import org.keycloak.forms.login.LoginFormsProvider;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;

import javax.ws.rs.core.Response;

public class RegistrationPagePrefill extends RegistrationPage{

	public static final String PROVIDER_ID = "registration-page-prefill-form";	
    private static final Logger logger = Logger.getLogger(RegistrationPagePrefill.class);
    
    public static final AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {
            AuthenticationExecutionModel.Requirement.REQUIRED
    };
    
    @Override
    public Response render(FormContext context, LoginFormsProvider form) {
    	
    	form.setAttribute(FIELD_FIRST_NAME,"Budi");
    	form.setAttribute(FIELD_LAST_NAME, "Aja");
    	
    	logger.info("Custom SPI ["+RegistrationPagePrefill.class.getName()+"] inside Render method.");
    	
        return form.createRegistration();
    }
    
    @Override
    public String getDisplayType() {
        return "Registration Page Prefill";
    }	

    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        return REQUIREMENT_CHOICES;
    }
    
    public String getId() {
        return PROVIDER_ID;
    }
    
    @Override
    public FormAuthenticator create(KeycloakSession session) {
        return this;
    }
}
