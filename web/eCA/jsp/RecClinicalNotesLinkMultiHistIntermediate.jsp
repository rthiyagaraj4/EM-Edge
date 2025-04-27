<!DOCTYPE html>

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");


	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);

	ArrayList list = manageEmailBean.returnSortList();

	Connection con = null;
/*	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql	 = "";
	StringBuffer displaydata = new StringBuffer();
	StringBuffer section_content = null ;
	String		 hist_data_type="";
	String		 strKey			=	"";
	String		 contentXML = "";*/
	String		 secKey = "";
	String		 hashKey = "";
	


	
	String sec_hdg_code = request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
//	String child_sec_hdg_code = request.getParameter("child_sec_hdg_code")==null?"":request.getParameter("child_sec_hdg_code");
	String Histrectype = request.getParameter("Histrectype")==null?"":request.getParameter("Histrectype");
	String Contrsysid = request.getParameter("Contrsysid")==null?"":request.getParameter("Contrsysid");
	String Accessionnum = request.getParameter("Accessionnum")==null?"":request.getParameter("Accessionnum");
	String Contrsyseventcode = request.getParameter("Contrsyseventcode")==null?"":request.getParameter("Contrsyseventcode");
	String result_disp = request.getParameter("result_disp")==null?"&nbsp;":request.getParameter("result_disp");
	result_disp=result_disp.trim();
	if(result_disp.equals("")||result_disp.equals("SPACE")||result_disp==null||result_disp.equals("null")||result_disp.equals("&nbsp;")||result_disp.equals("&amp;nbsp;"))
	{
		result_disp ="&amp;nbsp;";
	
	}
	String hist_rec_type_desc = request.getParameter("hist_rec_type_desc")==null?"&nbsp;":request.getParameter("hist_rec_type_desc");
	if(hist_rec_type_desc.equals("")||hist_rec_type_desc==null||hist_rec_type_desc.equals("null"))
		hist_rec_type_desc ="&nbsp;";
	String sort_by = request.getParameter("sort_by")==null?"C":request.getParameter("sort_by");
	String event_date_time = request.getParameter("event_date_time")==null?"":request.getParameter("event_date_time");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");

	
	try
	{
			hashKey = Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode+"~"+sec_hdg_code;
			
			if(sort_by.equals("D"))
				{
					secKey = sort_by+"~"+event_date_time+"~"+Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode+"~"+result_disp+"~"+hist_rec_type_desc+"~"+sec_hdg_code;
					//secKeyVal=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode
				}
				else if(sort_by.equals("C"))
				{
					secKey=sort_by+"~"+Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode+"~"+result_disp+"~"+hist_rec_type_desc+"~"+event_date_time+"~"+sec_hdg_code;
					//secKeyVal=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode
				}

				//secKey=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode;
				
				//secKey = secKey.trim();
				//PatResHash.put(secKey,section_content.toString());


				//sectionBean.setPatSecDetails(PatResHash,patient_id);

				//sectionBean.setSectionContent(sec_hdg_code,child_sec_hdg_code,section_content.toString());
				
				if(mode.equals("add"))
				{
					if(!list.contains(secKey)) 
						manageEmailBean.addRecordsToSortList(hashKey);
						manageEmailBean.addToHashMap(hashKey,secKey);
						manageEmailBean.addRecordstoLine2(hashKey);
						manageEmailBean.remRecordsFromLine1(hashKey);
						//manageEmailBean.addRecordstoLine1(secKeyVal);
				}
				if(mode.equals("remove"))
				{

					manageEmailBean.remRecordsFromSortList(hashKey);
					manageEmailBean.removeFromHashMap(hashKey);
					if(!manageEmailBean.returnList1().contains(hashKey))
						{
							manageEmailBean.addRecordstoLine1(hashKey);
							//manageEmailBean.addToHashMap(hashKey,secKey);
						}
					
					//if((list.contains(secKey)))
					//manageEmailBean.addRecordstoLine2(secKey);
					
				}
				
				if(mode.equals("removeAll"))
				{
					manageEmailBean.clearBean();
												
				}
			
				putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session);

				//putObjectInBean("sectionBean",sectionBean,session);


		/*if(rs !=null) rs.close();
		if(stmt != null ) stmt.close(); */

	}catch(Exception e)
	{		
		
		e.printStackTrace();
	
	}

	finally
	{
		
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}


	%>
