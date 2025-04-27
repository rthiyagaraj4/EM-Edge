package eXH.saml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.security.KeyFactory;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;

import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.security.x509.BasicX509Credential;

import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import org.opensaml.xml.security.SecurityHelper;
import java.security.cert.Certificate;

import javax.xml.bind.DatatypeConverter;



public class CertManager {
	
	/**
	 * gets credential used to sign saml assertionts that are produced. This method
	 * assumes the cert and pkcs formatted primary key are on file system. this data
	 * could be stored elsewhere e.g keystore
	 * 
	 * a credential is used to sign saml response, and includes the private key
	 * as well as a cert for the public key
	 * 
	 * @return
	 * @throws Throwable
	 */
	public Credential getSigningCredential(String publicKeyLocation, String privateKeyLocation) throws Throwable {
		// create public key (cert) portion of credential
		
		System.out.println(" Public Key Location : "+publicKeyLocation+" Private Key Location : "+privateKeyLocation);
		InputStream inStream = new FileInputStream(publicKeyLocation);
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		X509Certificate publicKey = (X509Certificate)cf.generateCertificate(inStream);
		inStream.close();
		
		char[] pfxPassword = "malaffisso".toCharArray();
		String alias = "samlSigningkey";
		boolean success;
		
		
		
		// create private key
		RandomAccessFile raf = new RandomAccessFile(privateKeyLocation, "r");
		byte[] buf = new byte[(int)raf.length()];
		raf.readFully(buf);
		raf.close();
		
		//PKCS8EncodedKeySpec kspec = new PKCS8EncodedKeySpec(buf);
		PKCS8EncodedKeySpec kspec = new PKCS8EncodedKeySpec(DatatypeConverter.parseBase64Binary(buf.toString()));
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = kf.generatePrivate(kspec);
		
		/*
		
		KeyStore keyStore = KeyStore.getInstance("JKS");
		keyStore.load(new FileInputStream(privateKeyLocation), pfxPassword);
		PrivateKeyEntry keyEntry = (PrivateKeyEntry) keyStore.getEntry(alias, new KeyStore.PasswordProtection(pfxPassword));
		PrivateKey privateKey = keyEntry.getPrivateKey();    
		*/
		
		// create credential and initialize
		BasicX509Credential credential = new BasicX509Credential();
		credential.setEntityCertificate(publicKey);
		credential.setPrivateKey(privateKey);
		return credential;
	}
	
	public Credential getSigningCredential(final String keyStoreLocation, final char[] keyStorePassword, final String keyAlias,
			final char[] keyPassword) {
		try {
			final KeyStore keyStore = KeyStore.getInstance("JKS");
			keyStore.load(new FileInputStream(keyStoreLocation), keyStorePassword);
			final Certificate certificate = keyStore.getCertificate(keyAlias);

			final ProtectionParameter protectionParameter;
			if (keyPassword == null) {
				protectionParameter = null;
			} else {
				protectionParameter = new KeyStore.PasswordProtection(keyPassword);
			}
			final KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(keyAlias, protectionParameter);
			final PrivateKey privateKey = pkEntry.getPrivateKey();

			final Credential credential = SecurityHelper.getSimpleCredential(certificate.getPublicKey(), privateKey);
			return credential;
		} catch (final Exception e) {
			throw new RuntimeException("Error loading key '" + keyAlias + "' from " + keyStoreLocation, e);
		}
	}
}
