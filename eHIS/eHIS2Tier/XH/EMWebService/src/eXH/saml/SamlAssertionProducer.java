package eXH.saml;

import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import org.opensaml.common.SAMLVersion;
import org.opensaml.common.impl.SAMLObjectContentReference;


import org.opensaml.saml2.core.Assertion;
import org.opensaml.saml2.core.Attribute;
import org.opensaml.saml2.core.AttributeStatement;
import org.opensaml.saml2.core.AttributeValue;
import org.opensaml.saml2.core.Audience;
import org.opensaml.saml2.core.AudienceRestriction;
import org.opensaml.saml2.core.AuthnContext;
import org.opensaml.saml2.core.AuthnContextClassRef;
import org.opensaml.saml2.core.AuthnStatement;
import org.opensaml.saml2.core.Conditions;
import org.opensaml.saml2.core.Issuer;
import org.opensaml.saml2.core.NameID;
import org.opensaml.saml2.core.NameIDType;
import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.Status;
import org.opensaml.saml2.core.StatusCode;
import org.opensaml.saml2.core.Subject;
import org.opensaml.saml2.core.SubjectConfirmation;
import org.opensaml.saml2.core.SubjectConfirmationData;
import org.opensaml.saml2.core.impl.AssertionBuilder;
import org.opensaml.saml2.core.impl.AttributeBuilder;
import org.opensaml.saml2.core.impl.AttributeStatementBuilder;
import org.opensaml.saml2.core.impl.AudienceBuilder;
import org.opensaml.saml2.core.impl.AudienceRestrictionBuilder;
import org.opensaml.saml2.core.impl.AuthnContextBuilder;
import org.opensaml.saml2.core.impl.AuthnContextClassRefBuilder;
import org.opensaml.saml2.core.impl.AuthnStatementBuilder;
import org.opensaml.saml2.core.impl.ConditionsBuilder;
import org.opensaml.saml2.core.impl.IssuerBuilder;
import org.opensaml.saml2.core.impl.NameIDBuilder;
import org.opensaml.saml2.core.impl.ResponseBuilder;
import org.opensaml.saml2.core.impl.StatusBuilder;
import org.opensaml.saml2.core.impl.StatusCodeBuilder;
import org.opensaml.saml2.core.impl.SubjectBuilder;
import org.opensaml.saml2.core.impl.SubjectConfirmationBuilder;
import org.opensaml.saml2.core.impl.SubjectConfirmationDataBuilder;
import org.opensaml.xml.XMLObjectBuilderFactory;
import org.opensaml.xml.encryption.EncryptionConstants;
import org.opensaml.xml.io.Marshaller;
import org.opensaml.xml.io.MarshallerFactory;
import org.opensaml.xml.io.MarshallingException;
import org.opensaml.xml.schema.XSString;
import org.opensaml.xml.schema.impl.XSStringBuilder;
import org.opensaml.xml.signature.Signature;
import org.opensaml.xml.signature.SignatureConstants;
import org.opensaml.xml.signature.SignatureException;
import org.opensaml.xml.signature.Signer;
import org.opensaml.xml.signature.impl.SignatureBuilder;
import org.opensaml.xml.security.SecurityHelper;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.util.XMLHelper;
import org.w3c.dom.Element;
import java.io.FileInputStream;
import java.util.UUID;

import org.opensaml.xml.Configuration;


public class SamlAssertionProducer {

	private String privateKeyLocation;
	private String publicKeyLocation;
	private String keystoreLocation;
	public static final String l_segment_id = "SAML";
	public static final String l_standard_code = "MLFIHL725";

	public static final String l_field_separator= "$!^";

	public static String l_debug_YN = "N";

	public String l_errcd = "S";
    public String l_errmsg = "";
    public String l_ack_text = "";	
    public static String l_saml_response="";
    
    public static final String CONFIRMATION_METHOD_BEARER = "urn:oasis:names:tc:SAML:2.0:cm:bearer";
	public static final String SUCCESS_STATUS_CODE = "urn:oasis:names:tc:SAML:2.0:status:Success";      
    
     

	public String getPrivateKeyLocation() {
		return privateKeyLocation;
	}

	public void setPrivateKeyLocation(String privateKeyLocation) {
		this.privateKeyLocation = privateKeyLocation;
	}

	public String getPublicKeyLocation() {
		return publicKeyLocation;
	}

	public void setPublicKeyLocation(String publicKeyLocation) {
		this.publicKeyLocation = publicKeyLocation;
	}
	
	public String getKeystoreLocation() {
		return keystoreLocation;
	}

	public void setKeystoreLocation(String keystoreLocation) {
		this.keystoreLocation = keystoreLocation;
	}
		

	public String getSamlResponse(final String issuerName, final String recipient, final String userId, final String userRole,
			final SAMLInputContainer input, final String audienceUri, final String roleSamlAttributeName,
			final String keyStoreLocation, final char[] keyStorePassword, final String keyAlias, final char[] keyPassword) {
		final XMLObjectBuilderFactory builderFactory = Configuration.getBuilderFactory();

		// Create the Assertion
		final String sessionId = UUID.randomUUID().toString();
		final Assertion assertion = createSamlAssertion(builderFactory, issuerName, userId, userRole, input, recipient, sessionId,
				audienceUri, roleSamlAttributeName, keyStoreLocation, keyStorePassword, keyAlias, keyPassword);

		// Create the Response
		final ResponseBuilder responseBuilder = (ResponseBuilder) builderFactory.getBuilder(Response.DEFAULT_ELEMENT_NAME);
		final Response response = responseBuilder.buildObject();
		response.setID(sessionId);
		response.setIssueInstant(new DateTime());

		final Issuer issuer = createIssuer(builderFactory, issuerName);
		response.setIssuer(issuer);

		final Status status = createSuccessStatus(builderFactory);
		response.setStatus(status);

		response.getAssertions().add(assertion);

		final MarshallerFactory marshallerFactory = Configuration.getMarshallerFactory();
		Element element = null;
		try {
			marshallerFactory.getMarshaller(response).marshall(response);
			Signer.signObject(assertion.getSignature());
			final Marshaller marshaller = marshallerFactory.getMarshaller(response);
			element = marshaller.marshall(response);
		} catch (final MarshallingException e) {
			throw new RuntimeException("Error occurred while marshalling the response", e);
		} catch (final SignatureException e) {
			throw new RuntimeException("Error occurred while signing the response", e);
		}

		return XMLHelper.nodeToString(element);
	}

	/**
	 * Helper method which includes some basic SAML fields which are part of almost every SAML Assertion.
	 */
	public Assertion createSamlAssertion(final XMLObjectBuilderFactory builderFactory, final String issuerName, final String userId,
			final String userRole, final SAMLInputContainer input, final String recipient, final String sessionId,
			final String audienceUri, final String roleSamlAttributeName, final String keyStoreLocation, final char[] keyStorePassword,
			final String keyAlias, final char[] keyPassword) {
		
		// Create the NameIdentifier
		final NameID nameId;
		Assertion assertion = null;
		try {
		if (StringUtils.isEmpty(userId)) {
			nameId = null;
		} else {
			final NameIDBuilder nameIdBuilder = (NameIDBuilder) builderFactory.getBuilder(NameID.DEFAULT_ELEMENT_NAME);
			nameId = nameIdBuilder.buildObject();
			nameId.setValue(userId);
			nameId.setFormat(NameIDType.UNSPECIFIED);
		}

		// Create the Issuer
		final Issuer issuer = createIssuer(builderFactory, issuerName);

		// Create the AttributeStatement
		final AttributeStatementBuilder attributeStatementBuilder = (AttributeStatementBuilder) builderFactory
				.getBuilder(AttributeStatement.DEFAULT_ELEMENT_NAME);
		final AttributeStatement attributeStatement = attributeStatementBuilder.buildObject();

		// User roles (optional)
		if (StringUtils.isNotEmpty(roleSamlAttributeName)) {
			attributeStatement.getAttributes()
					.add(createAttribute(builderFactory, roleSamlAttributeName, userRole.trim().split("\\s*;\\s*")));
		}

		// User attributes (optional)
		/*
		if (CollectionUtils.isNotEmpty(attributes)) {
			for (final SamlAttribute attribute : attributes) {
				attributeStatement.getAttributes().add(createAttribute(builderFactory, attribute.getName(), attribute.getValue()));
			}
		}
		*/
		
		// Create the attribute statement
        Map attributes = input.getAttributes();
        if(attributes != null){
            Iterator keySet = attributes.keySet().iterator();
            while (keySet.hasNext()){
                String key = keySet.next().toString();
                String val = attributes.get(key).toString();
                //Attribute attrFirstName = buildStringAttribute(key, val, getSAMLBuilder());
                Attribute attrFirstName = createAttribute(builderFactory, key, val);
                attributeStatement.getAttributes().add(attrFirstName);
            }
        }

		// Create the SubjectConfirmation
		final SubjectConfirmationDataBuilder subjectConfirmationDataBuilder = (SubjectConfirmationDataBuilder) builderFactory
				.getBuilder(SubjectConfirmationData.DEFAULT_ELEMENT_NAME);
		final SubjectConfirmationData subjectConfirmationData = subjectConfirmationDataBuilder.buildObject();
		final DateTime now = new DateTime();
		subjectConfirmationData.setNotOnOrAfter(now.plusMinutes(2));
		subjectConfirmationData.setRecipient(recipient);

		final SubjectConfirmationBuilder subjectConfirmationBuilder = (SubjectConfirmationBuilder) builderFactory
				.getBuilder(SubjectConfirmation.DEFAULT_ELEMENT_NAME);
		final SubjectConfirmation subjectConfirmation = subjectConfirmationBuilder.buildObject();
		subjectConfirmation.setSubjectConfirmationData(subjectConfirmationData);
		subjectConfirmation.setMethod(CONFIRMATION_METHOD_BEARER);

		// Create the Subject
		final SubjectBuilder subjectBuilder = (SubjectBuilder) builderFactory.getBuilder(Subject.DEFAULT_ELEMENT_NAME);
		final Subject subject = subjectBuilder.buildObject();
		if (nameId != null) {	
			subject.setNameID(nameId);
		}
		subject.getSubjectConfirmations().add(subjectConfirmation);

		// Create Authentication Statement
		final AuthnStatementBuilder authStatementBuilder = (AuthnStatementBuilder) builderFactory
				.getBuilder(AuthnStatement.DEFAULT_ELEMENT_NAME);
		final AuthnStatement authnStatement = authStatementBuilder.buildObject();
		final DateTime now2 = new DateTime();
		authnStatement.setAuthnInstant(now2);
		authnStatement.setSessionIndex(sessionId);

		final AuthnContextBuilder authContextBuilder = (AuthnContextBuilder) builderFactory.getBuilder(AuthnContext.DEFAULT_ELEMENT_NAME);
		final AuthnContext authnContext = authContextBuilder.buildObject();

		final AuthnContextClassRefBuilder authContextClassRefBuilder = (AuthnContextClassRefBuilder) builderFactory
				.getBuilder(AuthnContextClassRef.DEFAULT_ELEMENT_NAME);
		final AuthnContextClassRef authnContextClassRef = authContextClassRefBuilder.buildObject();
		authnContextClassRef.setAuthnContextClassRef("urn:oasis:names:tc:SAML:2.0:ac:classes:unspecified");

		authnContext.setAuthnContextClassRef(authnContextClassRef);
		authnStatement.setAuthnContext(authnContext);

		// Create the audience restrictions
		final AudienceBuilder audienceBuilder = (AudienceBuilder) builderFactory.getBuilder(Audience.DEFAULT_ELEMENT_NAME);
		final Audience audience = audienceBuilder.buildObject();
		audience.setAudienceURI(audienceUri);

		final AudienceRestrictionBuilder audienceRestrictionBuilder = (AudienceRestrictionBuilder) builderFactory
				.getBuilder(AudienceRestriction.DEFAULT_ELEMENT_NAME);
		final AudienceRestriction audienceRestriction = audienceRestrictionBuilder.buildObject();
		audienceRestriction.getAudiences().add(audience);

		// Create the conditions
		final ConditionsBuilder conditionsBuilder = (ConditionsBuilder) builderFactory.getBuilder(Conditions.DEFAULT_ELEMENT_NAME);
		final Conditions conditions = conditionsBuilder.buildObject();
		conditions.setNotBefore(new DateTime().minusMinutes(1));
		conditions.setNotOnOrAfter(new DateTime().plusMinutes(9));
		conditions.getAudienceRestrictions().add(audienceRestriction);

		// Create the assertion
		final AssertionBuilder assertionBuilder = (AssertionBuilder) builderFactory.getBuilder(Assertion.DEFAULT_ELEMENT_NAME);
		assertion = assertionBuilder.buildObject();
		assertion.setID(sessionId);
		assertion.setIssuer(issuer);
		assertion.setIssueInstant(now);
		assertion.setVersion(SAMLVersion.VERSION_20);
		if (subject != null) {
			assertion.setSubject(subject);
		}
		assertion.getAuthnStatements().add(authnStatement);
		assertion.getAttributeStatements().add(attributeStatement);		
		assertion.setConditions(conditions);

		// Set the signature on the assertion
		final Credential signingCredential = getSigningCredential(keyStoreLocation, keyStorePassword, keyAlias, keyPassword);
		final SignatureBuilder sb = (SignatureBuilder) builderFactory.getBuilder(Signature.DEFAULT_ELEMENT_NAME);
		final Signature signature = sb.buildObject();
		signature.setSigningCredential(signingCredential);
		//signature.setSignatureAlgorithm(SignatureConstants.ALGO_ID_SIGNATURE_RSA);
		signature.setSignatureAlgorithm(SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA256);
		signature.setCanonicalizationAlgorithm(SignatureConstants.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);
		assertion.setSignature(signature);
		
		
		((SAMLObjectContentReference)signature.getContentReferences().get(0))
        .setDigestAlgorithm(EncryptionConstants.ALGO_ID_DIGEST_SHA256);
        
        
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}

		return assertion;
	}

	private Status createSuccessStatus(final XMLObjectBuilderFactory builderFactory) {
		final StatusCodeBuilder statusCodeBuilder = (StatusCodeBuilder) builderFactory.getBuilder(StatusCode.DEFAULT_ELEMENT_NAME);
		final StatusCode statusCode = statusCodeBuilder.buildObject();
		statusCode.setValue(SUCCESS_STATUS_CODE);
		final StatusBuilder statusBuilder = (StatusBuilder) builderFactory.getBuilder(Status.DEFAULT_ELEMENT_NAME);
		final Status status = statusBuilder.buildObject();
		status.setStatusCode(statusCode);

		return status;
	}

	private Issuer createIssuer(final XMLObjectBuilderFactory builderFactory, final String issuerName) {
		// Create Issuer
		final IssuerBuilder issuerBuilder = (IssuerBuilder) builderFactory.getBuilder(Issuer.DEFAULT_ELEMENT_NAME);
		final Issuer issuer = issuerBuilder.buildObject();
		issuer.setValue(issuerName);

		return issuer;
	}

	private Attribute createAttribute(final XMLObjectBuilderFactory builderFactory, final String attributeName,
			final String... attributeValues) {
		final AttributeBuilder attributeBuilder = (AttributeBuilder) builderFactory.getBuilder(Attribute.DEFAULT_ELEMENT_NAME);
		final Attribute attribute = attributeBuilder.buildObject();
		attribute.setName(attributeName);

		final XSStringBuilder xsStringBuilder = (XSStringBuilder) builderFactory.getBuilder(XSString.TYPE_NAME);
		for (final String value : attributeValues) {
			final XSString xsString = xsStringBuilder.buildObject(AttributeValue.DEFAULT_ELEMENT_NAME, XSString.TYPE_NAME);
			xsString.setValue(value);
			attribute.getAttributeValues().add(xsString);
		}

		return attribute;
	}

	/**
	 * @param keyStoreLocation the location of the key store to load
	 * @param keyStorePassword the password for the key store
	 * @param keyPassword the password for the key within the key store or null if there is no key
	 * @param keyAlias the alias of the key to load
	 */
	public static Credential getSigningCredential(final String keyStoreLocation, final char[] keyStorePassword, final String keyAlias,
			final char[] keyPassword) {
		try {
			final KeyStore keyStore = KeyStore.getInstance("JKS");
			keyStore.load(new FileInputStream(keyStoreLocation), keyStorePassword);
			final Certificate certificate = keyStore.getCertificate(keyAlias);
			
			certificate.verify(certificate.getPublicKey());

			final ProtectionParameter protectionParameter;
			if (keyPassword == null) {
				protectionParameter = null;
			} else {
				protectionParameter = new KeyStore.PasswordProtection(keyPassword);
			}
			final KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(keyAlias, protectionParameter);
			final PrivateKey privateKey = pkEntry.getPrivateKey();
			
			System.out.println(" Public Key Algorithm: "+certificate.getPublicKey().getAlgorithm()+ " Private Algorithm : "+privateKey.getAlgorithm());

			final Credential credential = SecurityHelper.getSimpleCredential(certificate.getPublicKey(), privateKey);
			return credential;
		} catch (final Exception e) {
			throw new RuntimeException("Error loading key '" + keyAlias + "' from " + keyStoreLocation, e);
		}
	}

	
}
