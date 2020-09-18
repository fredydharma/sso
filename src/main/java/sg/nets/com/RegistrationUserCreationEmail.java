package sg.nets.com;

import org.jboss.logging.Logger;
import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.FormAction;
import org.keycloak.authentication.FormContext;
import org.keycloak.authentication.ValidationContext;
import org.keycloak.authentication.forms.RegistrationPage;
import org.keycloak.authentication.forms.RegistrationUserCreation;
import org.keycloak.forms.login.LoginFormsProvider;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;

public class RegistrationUserCreationEmail extends RegistrationUserCreation{
	
	public static final String PROVIDER_ID = "registration-user-creation-email";	
    private static final Logger logger = Logger.getLogger(RegistrationUserCreationEmail.class);
	
	public static final AuthenticationExecutionModel.Requirement[] REQUIREMENT_CHOICES = {
            AuthenticationExecutionModel.Requirement.REQUIRED
    };
	
	@Override
    public void buildPage(FormContext context, LoginFormsProvider form) {
		logger.info("Custom SPI ["+RegistrationUserCreationEmail.class.getName()+"] inside buildPage method.");
		form.setAttribute("mobile", "081912217889");
		form.setAttribute(RegistrationPage.FIELD_USERNAME, "budi");		
    }
	
	@Override
	public void validate(ValidationContext context) {			
		logger.info("Custom SPI ["+RegistrationUserCreationEmail.class.getName()+"] inside validate method.");
		super.validate(context);
	}
	
	@Override
	public String getDisplayType() {
		return "Registration User Creation Email Domain";
	}	

    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        return REQUIREMENT_CHOICES;
    }
    
    public String getId() {
        return PROVIDER_ID;
    }
    
    public FormAction create(KeycloakSession session) {
        return this;
    }
}
