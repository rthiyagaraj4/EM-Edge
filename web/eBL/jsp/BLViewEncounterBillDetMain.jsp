<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
//HttpSession httpSession = request.getSession(false);
//Properties p = (Properties)httpSession.getValue("jdbc");
String locale	= (String)session.getAttribute("LOCALE");	
if(locale==null || locale.equals("")) locale="en";

Connection con = null;
con	=	ConnectionManager.getConnection(request);
java.util.Locale loc = new java.util.Locale(locale);
java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);
//java.util.ResourceBundle bl_labels1 = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);

	String patln="";String strPatientId="";String strEncounterId="";
	String strVisitId="";
	String strEpisodeType="";
	String strEpisodeId="";String epitype="";String strTitle="";
	String encounter="";
try
				{
					strPatientId = request.getParameter("patient_id");
					if(strPatientId==null) strPatientId="";	
//					System.out.println("strPatientId @:"+strPatientId);
					strEncounterId=request.getParameter("encounter_id");
					if(strEncounterId==null || strEncounterId.equals("")) strEncounterId="";
					strVisitId = request.getParameter("visit_id");
					if(strVisitId==null || strVisitId.equals("")) strVisitId="";
					strEpisodeType = request.getParameter("episode_type");
					if(strEpisodeType==null) strEpisodeType="";
					strEpisodeId = request.getParameter("episode_id");
					if(strEpisodeId==null || strEpisodeId.equals("")) strEpisodeId="";
					if(strEpisodeType.equals("O"))
					{
						epitype=(String) bl_labels.getString("Common.Outpatient.label");
						encounter =epitype+ " / " + strEpisodeId +  " / " + strVisitId ;
					}
						else if(strEpisodeType.equals("E"))
						{
							epitype=(String) bl_labels.getString("Common.emergency.label");
							encounter = epitype+ " / " + strEpisodeId +  " / " + strVisitId ;
						}
							else if(strEpisodeType.equals("I"))
							{
								epitype=(String) bl_labels.getString("Common.inpatient.label");
								encounter = epitype+ " / " + strEpisodeId  ;
							}
								else if(strEpisodeType.equals("D"))
								{	
									epitype=(String) bl_labels.getString("Common.daycare.label");
									encounter = epitype+ " / " + strEpisodeId  ;
								}
					strTitle=(String) bl_labels.getString("Common.BillDetails.label");
	
					CallableStatement call = con.prepareCall("{ ? = call  get_patient_line(?,?)}");	
					call.registerOutParameter(1,java.sql.Types.VARCHAR);
					call.setString(2,strPatientId);
					call.setString(3,locale);
					call.execute();							
					patln = call.getString(1);				
					call.close();
					if ( patln == null ) patln = "";
					int ind=patln.indexOf("#");
					patln=patln.substring(0,ind);
//					System.out.println("title @:"+patln);
				}
			catch(Exception e)
			{
				System.out.println("title"+ e);
		
			}
			finally 
			{				
				if(con!=null) {
				ConnectionManager.returnConnection(con, request);
							 }
			}
			
%>
<HTML>
<head>
   <title>
      <%=strTitle%> -- <%=patln%> / <%=encounter%>
   </title>
</head>


<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<%
		String params = request.getQueryString();
//		System.out.println("params:"+params);
	%>

	  <iframe name='' id=''	src='../../eBL/jsp/BLViewEncounterBillDet.jsp?<%=params%>'  frameborder=0 noresize scrolling='auto'  style='height:92vh;width:100vw'></iframe><iframe SRC="../../eBL/jsp/BLViewEncounterBillDetBtn.jsp"	  name="" id="" frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>	
</HTML>

