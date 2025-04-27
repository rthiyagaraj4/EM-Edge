/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ecis.utils;

import java.util.* ;

public class OnlineReport implements java.io.Serializable {
    String facilityId       ;
    String moduleId     ;
    String reportId         ;
    String locationType ;
    String locationCode ;
    String languageID ;
    Hashtable parameters    = new Hashtable() ;

    public OnlineReport() {
        setFacilityId( "" ) ;
        setModuleId( "" ) ;
        setReportId( "" ) ;
        setLocationType( "" ) ;
        setLocationCode( "" ) ;
		setLanguageID("");
    }

    public OnlineReport( String facilityId, String moduleId, String reportId ) {
        setFacilityId( facilityId ) ;
        setModuleId( moduleId ) ;
        setReportId( reportId ) ;
        setLocationType( "" ) ;
        setLocationCode( "" ) ;
		setLanguageID("");
    }

    public OnlineReport( String facilityId, String moduleId, String reportId, String locationType, String locationCode ) {
        setFacilityId( facilityId ) ;
        setModuleId( moduleId ) ;
        setReportId( reportId ) ;
        setLocationType( locationType ) ;
        setLocationCode( locationCode ) ;
		setLanguageID("");
    }

	public OnlineReport( String facilityId, String moduleId, String reportId, String locationType, String locationCode,String languageID ) {
        setFacilityId( facilityId ) ;
        setModuleId( moduleId ) ;
        setReportId( reportId ) ;
        setLocationType( locationType ) ;
        setLocationCode( locationCode ) ;
        setLanguageID( languageID ) ;
    }

    public void setFacilityId( String facilityId ) {
        this.facilityId = facilityId ;
    }
	public void setLanguageID( String languageID ) {
        this.languageID = languageID ;
    }
	public String getLanguageID() {
        return this.languageID ;
    }

    public String getFacilityId() {
        return this.facilityId ;
    }

    public void setModuleId( String moduleId ) {
        this.moduleId = moduleId ;
    }

    public String getModuleId() {
        return this.moduleId ;
    }

    public void setReportId( String reportId ) {
        this.reportId = reportId ;
    }

    public String getReportId() {
        return this.reportId ;
    }

    public void setLocationType( String locationType ) {
        this.locationType = locationType ;
    }

    public String getLocationType() {
        return this.locationType ;
    }

    public void setLocationCode( String locationCode ) {
        this.locationCode = locationCode ;
    }

    public String getLocationCode() {
        return this.locationCode ;
    }

    public void addParameter( String key, String value ) {
        parameters.put( key, value ) ;
    }

    public String getParameters() {
        String result = "" ;

        for( Enumeration e = parameters.keys(); e.hasMoreElements(); ) {
            String key      = (String) e.nextElement() ;
            String value    = (String) parameters.get( key ) ;

            if ( result.equals( "" ) )
                result = result + key + "=" + value ;
            else
                result = result + "+" + key + "=" + value ;
        }

        return result ;
    }
}
