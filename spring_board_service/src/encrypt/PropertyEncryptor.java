package encrypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class PropertyEncryptor {
	public static void main(String[] args) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setAlgorithm("PBEWITHMD5ANDDES");
		encryptor.setPassword("spring");
		
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3307/multicampus";
		String username = "multicampus";
		String password = "multicampus";
		
		StringBuilder sb = new StringBuilder();
		sb.append("DB.DRIVER=ENC(" + encryptor.encrypt(driver) + ")\n");
		sb.append("DB.URL=ENC(" + encryptor.encrypt(url) + ")\n");
		sb.append("DB.USERNAME=ENC(" + encryptor.encrypt(username) + ")\n");
		sb.append("DB.PASSWORD=ENC(" + encryptor.encrypt(password) + ")\n");
		
		System.out.println(sb.toString());
	}
}
