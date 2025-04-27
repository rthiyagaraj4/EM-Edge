<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='Javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src="../../eMR/js/RecordPatientAdverseEvent.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="allergen_view_form1" id="allergen_view_form1">
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con			= null;
	Statement stmt			= null;
	ResultSet rs			= null;

	//String locale					= (String)session.getAttribute("LOCALE");
	String facilityId				=	(String)session.getValue("facility_id");
	String allergen			        = checkForNull(request.getParameter("allergen"));
	String x_coordinate				= checkForNull(request.getParameter("x_coordinate"));
	String y_coordinate				= checkForNull(request.getParameter("y_coordinate"));
	String patient_id				= checkForNull(request.getParameter("patient_id"));
	String onset_date               = "";
	String last_reaction_date       = "";
	String reaction_desc            = "";
	String severity                 = "";
	String allergen_desc			="";
//out.println("<script>alert(\""+allergen+"\");</script>");

	try
	{
		StringBuffer sql	=	new StringBuffer();
		StringBuffer tooltipStr	=  new StringBuffer();
		int maxCount		= 0;

		sql.append("SELECT CASE WHEN a.allergen_code IS NOT NULl THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id = 'en'),(SELECT long_desc FROM mr_allergen_lang_vw WHERE allergen_code = a.allergen_code AND language_id = 'en')))END allergen, TO_CHAR (a.onset_date, 'dd/mm/yyyy') onset_date, TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') last_reaction_date,am_get_desc.am_reaction (g.reaction_code, 'en', '1') reac_desc,a.severity severity FROM pr_allergy_sensitivity a, am_reaction g, pr_adverse_event_reaction f WHERE a.allergen_code = '"+allergen+"' AND a.allergen_code = f.allergen_code AND a.patient_id = '"+patient_id+"' and a.PATIENT_ID=f.PATIENT_ID and a.ADV_EVENT_TYPE_IND=f.ADV_EVENT_TYPE_IND and a.ADV_EVENT_TYPE=f.ADV_EVENT_TYPE and a.ALLERGEN_CODE=f.ALLERGEN_CODE and a.ADV_EVENT_SRL_NO=f.ADV_EVENT_SRL_NO and a.REACTION_CODE_VALUES=g.reaction_code ");
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();
		rs		=	stmt.executeQuery(sql.toString());
		while(rs.next())
		{
			if(maxCount==0)
			{
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Allergen.label","mr_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.onsetdate.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Last.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReactionDate.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.reactiondesc.label","mr_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severity.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append("<br>");
			}
				 allergen_desc            = checkForNull(rs.getString("allergen"));
				 onset_date               = checkForNull(rs.getString("onset_date"));
				 last_reaction_date       = checkForNull(rs.getString("last_reaction_date"));
				 reaction_desc            = checkForNull(rs.getString("reac_desc"));
				 severity                 = checkForNull(rs.getString("severity"));
//out.println("<script>alert(\""+reaction_desc+"\");</script>");
				 tooltipStr.append(allergen);
				 tooltipStr.append("^^");
				 tooltipStr.append(onset_date);
				 tooltipStr.append("^^");
				 tooltipStr.append(last_reaction_date);
				 tooltipStr.append("^^");
				 tooltipStr.append(reaction_desc);
				 tooltipStr.append("^^");
				 tooltipStr.append(severity);
				 tooltipStr.append("^^");
				 tooltipStr.append("<br>");
				 maxCount++;
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

		if(maxCount>0)
		{
			out.println("<script>displayToolTip(\""+tooltipStr.toString()+"\",\""+x_coordinate+"\",\""+y_coordinate+"\");</script>");
		
		}
	}
	catch(Exception e)
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
%>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

