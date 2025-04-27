
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------------------------
16/09/2014	IN049625		Ramesh G	16/09/2014		Sunil K V		Clinical Notes Content Missing.User  has entered all the data in the clinical notes and have signed off the note.														
06/09/2019	IN071335	   	Ramesh G											Common-ICN-0012
-------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.util.*,java.text.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser" />
<%

	request.setCharacterEncoding("UTF-8");
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
	
	String locale = (String) p.getProperty("LOCALE");
	String facility_id = (String) session.getValue("facility_id");
	
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
	hash = (Hashtable) hash.get("SEARCH");
	String accession_num = hash.get("accession_num") == null ? "": (String) hash.get("accession_num");
	
	
	String patient_id = request.getParameter("patient_id")==null?"":(String)request.getParameter("patient_id");
	String encounter_id =  request.getParameter("encounter_id")==null?"":(String)request.getParameter("encounter_id");
	DateFormat df = new SimpleDateFormat("yyyyddMMHHmmss");
    java.util.Date dateobj = new java.util.Date();
		
	String bean_id = "@ReBuildClinicalNotesBean"+patient_id+encounter_id+df.format(dateobj);
	String bean_name = "eCA.ReBuildClinicalNotes";

	eCA.ReBuildClinicalNotes reBuildClinicalNotes = (eCA.ReBuildClinicalNotes)getObjectFromBean(bean_id,bean_name,session);

	reBuildClinicalNotes.setLocale(locale);
	reBuildClinicalNotes.setFacilityId(facility_id);
	
	String status = "true";
	try {
		
		reBuildClinicalNotes.setAccessionNum(accession_num);
		reBuildClinicalNotes.setJdbcProps(p);

		ArrayList notesDetails = new ArrayList();
		notesDetails = reBuildClinicalNotes.getNotesDetails();
		
		if (notesDetails.size() > 0) {
			if ((Double.parseDouble((String) notesDetails.get(0))) > (Double.parseDouble((String)reBuildClinicalNotes.getRebuildNotesCriteria()))) {
				reBuildClinicalNotes.setAccessionNum((String) notesDetails.get(1));
				reBuildClinicalNotes.setContrModAccessionNum((String) notesDetails.get(2));
				reBuildClinicalNotes.setPatientId((String) notesDetails.get(3));
				reBuildClinicalNotes.setEncounterId((String) notesDetails.get(4));
				reBuildClinicalNotes.setPractitionerName((String) notesDetails.get(5));
				reBuildClinicalNotes.setModifiedDate((String) notesDetails.get(8));
				String recordMode = "";
				
				if ("R".equals(notesDetails.get(6)))
					recordMode = "RecordAddendum";
				else if ("S".equals(notesDetails.get(6)))
					recordMode = "SignAddendum";
				
				reBuildClinicalNotes.setRecordMode(recordMode);				
				// IN071335 Changes Start.
				//String contextUrl = HttpUtils.getRequestURL(request).toString();
				//contextUrl = contextUrl.substring(0,contextUrl.indexOf("eCA/"));
				String contextUrl = application.getRealPath("/");
				System.out.println("RecClinicalNotesReBuildIntermediate.jsp---------contextUrl--------->"+contextUrl+"<---");
				// IN071335 Changes End.
				reBuildClinicalNotes.setXSLFileContextReference(contextUrl);
				
				if (!reBuildClinicalNotes.caReBuildNotes())
					status = "false";

			}
		}
		out.println(status);
	} catch (Exception e) {
		e.printStackTrace();
	}
	putObjectInBean(bean_id,reBuildClinicalNotes,session);

	
%>

