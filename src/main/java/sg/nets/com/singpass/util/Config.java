package sg.nets.com.singpass.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	private Properties properties;
	private String sslDir;
	
	public Config() {
        properties = new Properties();

        try {
            String jbossServerConfigDir = System.getProperty("jboss.server.config.dir");            
            if (jbossServerConfigDir != null) {
                File file = new File(jbossServerConfigDir, "consumer-configuration.properties");
                if (file.isFile()) {
                    properties.load(new FileInputStream(file));
                    this.sslDir = jbossServerConfigDir+"\\"+properties.getProperty("SSL_DIR")+"\\"+properties.getProperty("MYINFO_SIGNATURE_CERT_PUBLIC_CERT");
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
}
