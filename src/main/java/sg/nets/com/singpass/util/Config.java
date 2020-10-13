package sg.nets.com.singpass.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	private Properties properties;
	private String sslDir;
	private String publicCert;
	private String privateKey;
	private String publicKey;
	
	public Config() {
        properties = new Properties();

        try {
            String jbossServerConfigDir = System.getProperty("jboss.server.config.dir");            
            if (jbossServerConfigDir != null) {
                File file = new File(jbossServerConfigDir, "consumer-configuration.properties");
                if (file.isFile()) {
                    properties.load(new FileInputStream(file));
                    this.sslDir = jbossServerConfigDir+"\\"+properties.getProperty("SSL_DIR");
                    this.publicCert = sslDir +"\\"+properties.getProperty("MYINFO_SIGNATURE_CERT_PUBLIC_CERT");
                    this.privateKey = sslDir +"\\"+properties.getProperty("DEMO_APP_SIGNATURE_CERT_PRIVATE_KEY");
                    this.publicKey = sslDir +"\\"+properties.getProperty("DEMO_APP_SIGNATURE_CERT_PUBLIC_KEY");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	public Properties getProperties() {
		return properties;
	}

	public String getSslDir() {
		return sslDir;
	}

	public void setSslDir(String sslDir) {
		this.sslDir = sslDir;
	}

	public String getPublicCert() {
		return publicCert;
	}

	public void setPublicCert(String publicCert) {
		this.publicCert = publicCert;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}		
}
