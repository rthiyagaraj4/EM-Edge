	/*
	-----------------------------------------------------------------------------------------------
	Date       		Edit History   Name        		Description
	-----------------------------------------------------------------------------------------------
	21/08/2015        	100        Prithvirajan       created

	-----------------------------------------------------------------------------------------------
	*/
	package eMP;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;

	public class DocumentTypeBean implements java.io.Serializable
	{
		private static final long serialVersionUID = 1L;
		
		private String sFacilityId;
		private String sFileCategory;
		private String sDocumentName;
		private String sDocumentType;
		private String sDocumentSharedPath;
		private int    sDocFolderOption;
		private String sDocWebserviceURL;
		private int sPhotoDocOption; 
		private String sPhotoSharedpath;
		private int sInvFolderOption; //Added by Kamatchi S for MO-CRF-20171.1
		private String sInventorySharedpath;//Added by Kamatchi S for MO-CRF-20171.1
	
		
		
		public HttpServletRequest request;
		public HttpSession session;

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
		 * @return the sDocumentName
		 */
		public String getsDocumentName() {
			return sDocumentName;
		}
		/**
		 * @param sDocumentName the sDocumentName to set
		 */
		public void setsDocumentName(String sDocumentName) {
			this.sDocumentName = sDocumentName;
		}
		/**
		 * @return the sDocumentType
		 */
		public String getsDocumentType() {
			return sDocumentType;
		}
		/**
		 * @param sDocumentType the sDocumentType to set
		 */
		public void setsDocumentType(String sDocumentType) {
			this.sDocumentType = sDocumentType;
		}
		/**
		 * @return the sDocumentSharedPath
		 */
		public String getsDocumentSharedPath() {
			return sDocumentSharedPath;
		}
		/**
		 * @param sDocumentSharedPath the sDocumentSharedPath to set
		 */
		public void setsDocumentSharedPath(String sDocumentSharedPath) {
			this.sDocumentSharedPath = sDocumentSharedPath;
		}
		/**
		 * @return the sDocFolderOption
		 */
		public int getsDocFolderOption() {
			return sDocFolderOption;
		}
		/**
		 * @param sDocFolderOption the sDocFolderOption to set
		 */
		public void setsDocFolderOption(int sDocFolderOption) {
			this.sDocFolderOption = sDocFolderOption;
		}
		/**
		 * @return the sDocWebserviceURL
		 */
		public String getsDocWebserviceURL() {
			return sDocWebserviceURL;
		}
		/**
		 * @param sDocWebserviceURL the sDocWebserviceURL to set
		 */
		public void setsDocWebserviceURL(String sDocWebserviceURL) {
			this.sDocWebserviceURL = sDocWebserviceURL;
		}
		
		//Added by bhuvana for MO-CRF-20153
		/**
		 * @return the File Category 
		 */
		public String getsFileCategory() {
			return sFileCategory;
		}
		/**
		 * @param sFacilityId the sFacilityId to set
		 */
		public void setsFileCategory(String sFileCategory) {
			this.sFileCategory = sFileCategory;
		}
		

		//Added by bhuvana
		/**
		 * @return the File Category 
		 */
		public int getsPhotoDocOption() {
			return sPhotoDocOption;
		}
		/**
		 * @param sFacilityId the sPhotoDocOption to set
		 */
		public void setsPhotoDocOption(int sPhotoDocOption) {
			this.sPhotoDocOption = sPhotoDocOption;
		}

		
		/**
		 * @return the File Category 
		 */
		public String getsPhotoSharedpath() {
			return sPhotoSharedpath;
		}
		/**
		 * @param sFacilityId the sPhotoSharedpath to set
		 */
		public void setsPhotoSharedpath(String PhotoSharedpath) {
			this.sPhotoSharedpath = sPhotoSharedpath;
		}
		//Ended by bhuvana for MO-CRF-20153
		
		//Added by Kamatchi S for MO-CRF-20171.1
		/**
		 * @return the sInventorySharedpath
		 */
		public String getsInventorySharedPath() {
			return sInventorySharedpath;
		}
		/**
		 * @param sInventorySharedpath the sInventorySharedpath to set
		 */
		public void setsInventorySharedPath(String sInventorySharedpath) {
			this.sInventorySharedpath = sInventorySharedpath;
		}
		/**
		 * @return the sInvFolderOption   
		 */
		public int getsInvFolderOption() {
			return sInvFolderOption;
		}
		/**
		 * @param sInvFolderOption the sInvFolderOption to set
		 */
		public void setsInvFolderOption(int sInvFolderOption) {
			this.sInvFolderOption = sInvFolderOption;
		}
	}

