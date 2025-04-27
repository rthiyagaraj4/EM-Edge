<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
Connection con = ConnectionManager.getConnection(request);
	try
	{
		
		//PreparedStatement pstmt = null ;
		//ResultSet rs = null; ResultSet rs23 = null; 
		//Statement stmt=null;
		CallableStatement call=null;

		request.setCharacterEncoding("UTF-8");
		String locale	= (String)session.getAttribute("LOCALE");

		//String fin_tab_banner="";

		String login_user =  p.getProperty("login_user");
		if(login_user==null) login_user="";

		String facility_id = (String)httpSession.getValue("facility_id");
		if(facility_id==null) facility_id="";	

		String title= (String)httpSession.getValue("title");
		if(title==null) title="";

		String episode_type=request.getParameter("episodetype");
		if(episode_type==null) episode_type="";

		String episode_id=request.getParameter("episodeid");
		if(episode_id==null) episode_id="";

		String visit_id=request.getParameter("visitid");
		if(visit_id==null) visit_id="";

		String patient_id=request.getParameter("patientid");
		if(patient_id==null) patient_id="";

/*
		System.out.println("facility_id:"+facility_id);
		System.out.println("patient_id:"+patient_id);
		System.out.println("episode_type:"+episode_type);
		System.out.println("episode_id:"+episode_id);
		System.out.println("visit_id:"+visit_id);
		System.out.println("locale:"+locale);
*/
	
		String banner_qry="";
		
		try
		{
			call = con.prepareCall("{ ? = call   BL_PROC_ITEM_VALIDATIONS_MP.GET_PATIENT_BANNER(?,?,?,?,?)}");	
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.setString(2,facility_id);
			call.setString(3,patient_id);
			call.setString(4,episode_id);
			call.setString(5,visit_id);
			call.setString(6,locale);
			call.execute();
		
			banner_qry = call.getString(1);		
//			System.out.println("banner_qry:"+banner_qry);
			if ( banner_qry == null ) banner_qry = "";

			call.close();	
		}
		catch(Exception e)
		{
			System.out.println("Exception in banner qry:"+e);
		}

//		System.out.println("banner_qry:"+banner_qry);

%>
<script>
function call_bl_fin_dtls()
{
	var retVal = 	new String();
	var title=getLabel("eBL.PAT_ENCOUNTER_FIN_DTLS.label","BL");
	var episodetype = document.forms[0].episode_type.value;
	var episodeid = document.forms[0].episode_id.value;
	var visitid = document.forms[0].visit_id.value;
	var patientid= document.forms[0].patient_id.value;
	var episode1 ="";

	if(episodetype=="D")
	{
		episode1=getLabel("Common.daycare.label","common");
	}
	else if(episodetype=="I")
	{
		episode1=getLabel("Common.inpatient.label","common");
	}
	else if(episodetype=="E")
	{
		episode1=getLabel("Common.emergency.label","common");
	}
	else if(episodetype=="O")
	{
		episode1=getLabel("Common.Outpatient.label","common");
	}
	else if(episodetype=="R")
	{
		episode1=getLabel("Common.external.label","common");
	}

	var dialogTop			= "200";
	var dialogHeight		= "42" ;
	var dialogWidth			= "70" ;
	var features			= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			="";	

	var column_sizes = escape("");               
	var column_descriptions ="";	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episodetype="+episodetype+"&"+"episodeid="+episodeid+"&"+"visitid="+visitid+"&"+"patientid="+patientid+"&episode1="+episode1;
	retVal=window.showModalDialog("../../eBL/jsp/BLFinDtlQryMain.jsp?"+param,arguments,features);
}

</script>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>

<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>

<tr>
	<td width='60%'></td>
	<td class='PATIENTLINECOLOR' width='40%' style='position:relative;' nowrap style="cursor:pointer;" onClick="call_bl_fin_dtls();"><font  size='<%=(banner_qry.length()>50?"-5":"2")%>'><div align='right' title="Financial Details"><%=banner_qry%></div></td>
</tr>
</table>

<INPUT TYPE="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<INPUT TYPE="hidden" name="title" id="title" value="<%=title%>">
<INPUT TYPE="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<INPUT TYPE="hidden" name="episode_type" id="episode_type" value="<%=episode_type%>">
<INPUT TYPE="hidden" name="episode_id" id="episode_id" value="<%=episode_id%>">
<INPUT TYPE="hidden" name="visit_id" id="visit_id" value="<%=visit_id%>">
<INPUT TYPE="hidden" name="locale" id="locale" value="<%=locale%>">

</form>
</body>
<%
	}
	catch(Exception e)
	{
		System.out.println("Exception in the Main Try:"+e);
	}
	finally
	{	
		ConnectionManager.returnConnection(con, request);				
    }
%>

</html>

