/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
10/06/2015        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------

Edited by prithvi on 26/08/2015-- removed 2 variables(1. sDocSharedPath, 2. sWebserviceURL) and added one arraylist.

*/
package eMP;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DocumentConfigBean implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String sFacilityId;
	private int iDocScanEnabled;	
	private int iDocSaveAs; 
	private int iDocFolderOption; 
	private int iDocCheckStatus; 
	private int iPhotoEnabled;
	private int iInvFolderOption;//Added by Kamatchi S for MO-CRF-20171.1    

	private String sDocSharedPath;
	private String sDocWebserviceUrl;
	private String sDocType;
	private String sPhotoSharedpath;
	private String sFileCategory;
	private String sInvSharedPath;//Added by Kamatchi S for MO-CRF-20171.1
	
	public HttpServletRequest request;
	public HttpSession session;

	public int iPhotoDocOption;

	private List<DocumentTypeBean> iDocTypeList = null;  // Added by prithvi on 26/08/2015
	private int iDocScanUIEnabled; // Added by prithvi on 26/08/2015

	/**
	 * @return the Facility ID 
	 */
	public String getsFacilityId() {
		return sFacilityId;
	}
	/**
	 * @param sFacilityId the sFacilityId to set
	 */
	public void setsFacilityId(String sFacilityId) {
		this.sFacilityId = sFacilityId;
	}


	/**
	 * @return the Document Scan Flag 
	 */
	public int getiDocScanEnabled() {
		return iDocScanEnabled;
	}
	
	/**
	 * @param iDocScanEnabled the iDocScanEnabled to set
	 */
	public void setiDocScanEnabled(int iDocScanEnabled) {
		this.iDocScanEnabled = iDocScanEnabled;
	}

	/**
	 * @param iDocScanUIEnabled the iDocScanEnabled to set
	 */
	public void setiDocScanUIEnabled(int iDocScanUIEnabled) {
		this.iDocScanUIEnabled = iDocScanUIEnabled;
	}

	/**
	 * @return the Document Scan UI Flag 
	 */
	public int getiDocScanUIEnabled() {
		return iDocScanUIEnabled;
	}

	/**
	 * @return the Document Save As Flag 
	 */
	public int getiDocSaveAs() {
		return iDocSaveAs;
	}
	/**
	 * @param iDocSaveAs the iDocSaveAs to set
	 */
	public void setiDocSaveAs(int iDocSaveAs) {
		this.iDocSaveAs = iDocSaveAs;
	}
	
	/**
	 * @return the Document Folder Option 
	 */
	public int getiDocFolderOption() {
		return iDocFolderOption;
	}
	/**
	 * @param iDocFolderOption the iDocFolderOption to set
	 */
	public void setiDocFolderOption(int iDocFolderOption) {
		this.iDocFolderOption = iDocFolderOption;
	}	
	/**
	 * @return the Document Upload check Status
	 */
	public int getiDocCheckStatus() {
		return iDocCheckStatus;
	}
	/**
	 * @param iDocCheckStatus the iDocCheckStatus to set
	 */
	public void setiDocCheckStatus(int iDocCheckStatus) {
		this.iDocCheckStatus = iDocCheckStatus;
	}		
	
	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}
	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}
	/**
	 * @return the iDocTypeList
	 */
	public List<DocumentTypeBean> getiDocTypeList() {
		return iDocTypeList;
	}
	/**
	 * @param iDocTypeList the iDocTypeList to set
	 */
	public void setiDocTypeList(List<DocumentTypeBean> iDocTypeList) {
		this.iDocTypeList = iDocTypeList;
	}

   /**
	 * @return the sDocSharedPath
	 */
	public String getsDocSharedPath() {
		return sDocSharedPath;
	}
	/**
	 * @param sDocSharedPath the sDocSharedPath to set
	 */
	public void setsDocSharedPath(String sDocSharedPath) {
		this.sDocSharedPath = sDocSharedPath;
	}
	/**
	 * @return the sDocWebserviceUrl
	 */
	public String getsDocWebserviceUrl() {
		return sDocWebserviceUrl;
	}
	/**
	 * @param sDocWebserviceUrl the sDocWebserviceUrl to set
	 */
	public void setsDocWebserviceUrl(String sDocWebserviceUrl) {
		this.sDocWebserviceUrl = sDocWebserviceUrl;
	}
	/**
	 * @return the sDocType
	 */
	public String getsDocType() {
		return sDocType;
	}
	/**
	 * @param sDocType the sDocType to set
	 */
	public void setsDocType(String sDocType) {
		this.sDocType = sDocType;
	}

	//Added by bhuvana for MO-CRF-20153
	/**
	 * @return the PhotoOption Flag 
	 */
	public int getsPhotoDocOption() {
		return iPhotoDocOption;
	}
	
	/**
	 * @param iDocScanEnabled the iDocScanEnabled to set
	 */
	public void setsPhotoDocOption(int iPhotoDocOption) {
		this.iPhotoDocOption = iPhotoDocOption;
	}

	
	/**
	 * @return the PhotoSharedpath
	 */
	public String getsPhotoSharedpath() {
		return sPhotoSharedpath;
	}
	/**
	 * @param sPhotoSharedpath the sPhotoSharedpath to set
	 */
	public void setsPhotoSharedpath(String sPhotoSharedpath) {
		this.sPhotoSharedpath = sPhotoSharedpath;
	}

	
	/**
	 * @return the File Category based on document or Photo  
	 */
	public String getsFileCategory() {
		return sFileCategory;
	}
	/**
	 * @param sFileCategory the sFacilityId to set
	 */
	public void setsFileCategory(String sFileCategory) {
		this.sFileCategory = sFileCategory;
	}
	//Ended by bhuvana for MO-CRF-20153

	//Added by Kamatchi S for MO-CRF-20171.1
	/**
	 * @return the Inventory Document Folder Option 
	 */
	public int getiInvFolderOption() {
		return iInvFolderOption;
	}
	/**
	 * @param iInvFolderOption the iInvFolderOption to set
	 */
	public void setiInvFolderOption(int iInvFolderOption) {
		this.iInvFolderOption = iInvFolderOption;
	}

	/**
	 * @return the InventorySharedpath
	 */
	public String getsInvSharedpath() {
		return sInvSharedPath;
	}
	/**
	 * @param sPhotoSharedpath the sPhotoSharedpath to set
	 */
	public void setsInvSharedpath(String sInvSharedPath) {
		this.sInvSharedPath = sInvSharedPath;
	}



}