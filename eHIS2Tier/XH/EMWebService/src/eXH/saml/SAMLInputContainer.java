package eXH.saml;

import java.util.Map;

public class SAMLInputContainer{
    private String strIssuer;
    private String strNameID;
    private String strNameQualifier;
    private String sessionId;
    private String strRecipient;
    private String audienceRestriction;
    private int maxSessionTimeoutInMinutes = 15; // default is 15 minutes
    

	private Map<String,String> attributes;

    public String getStrIssuer(){
        return strIssuer;
    }
    
    public String getStrRecipient(){
        return strRecipient;
    }

    public String getAudienceRestriction() {
		return audienceRestriction;
	}

	public void setAudienceRestriction(String audienceRestriction) {
		this.audienceRestriction = audienceRestriction;
	}

	public void setStrIssuer(String strIssuer){
        this.strIssuer = strIssuer;
    }
	
	public void setStrRecipeint(String strRecipient){
        this.strRecipient = strRecipient;
    }

    public String getStrNameID(){
        return strNameID;
    }

    public void setStrNameID(String strNameID){
        this.strNameID = strNameID;
    }

    public String getStrNameQualifier() {
        return strNameQualifier;
    }

    public void setStrNameQualifier(String strNameQualifier){
        this.strNameQualifier = strNameQualifier;
    }

    public void setAttributes(Map<String,String> attributes){
        this.attributes = attributes;
    }

    public Map<String,String> getAttributes(){
        return attributes;
    }
    public void setSessionId(String sessionId){
        this.sessionId = sessionId;
    }

    public String getSessionId(){
        return sessionId;
    }

    public void setMaxSessionTimeoutInMinutes(int maxSessionTimeoutInMinutes){
        this.maxSessionTimeoutInMinutes = maxSessionTimeoutInMinutes;
    }

    public int getMaxSessionTimeoutInMinutes(){
        return maxSessionTimeoutInMinutes;
    }
}	