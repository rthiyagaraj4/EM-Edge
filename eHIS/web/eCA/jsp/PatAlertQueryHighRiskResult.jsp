<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body  class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	StringBuffer strBuff_sql = new StringBuffer();
	Connection conn 	= 	null; //(Connection) session.getValue( "connection" ) ;
	PreparedStatement stmt		=	null, pstmt = null;
	ResultSet rs		=	null, rs_new = null;
	String login_user 	= (String) session.getValue( "login_user" ) ;
	String patient_id 	= request.getParameter("patient_id");
	String context_value  = (String) request.getParameter("PQ");//request.getParameter("Context");
	
	if (context_value ==null) context_value ="Y";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String userid = p.getProperty( "login_user" ) ;
	String facilityId 		= (String) session.getValue( "facility_id" ) ;
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");

	String sql ="";
	String set_flag="";

	String P_access_type="V";
	String P_access_data="HR";

	String patient_type=request.getParameter("patient_type");
	if(patient_type==null)
		patient_type="C";
try{

	conn = ConnectionManager.getConnection(request);
	strBuff_sql.append("select 'x' from mr_user_access_rights_vw where  FACILITY_ID   =? ");
	strBuff_sql.append(" and APPL_USER_ID=? and ACCESS_TYPE    ='V'  and ");

			   if(context_value.equals("Y")){
				   strBuff_sql.append("PATIENT_TYPE='C' ");
					
			   }else{
				   strBuff_sql.append("PATIENT_TYPE='O' ");
					
			   }
			strBuff_sql.append(" and ACCESS_SCOPE='HR' and ");
			strBuff_sql.append(" exists(select '1' from pr_high_risk_condition where patient_id=? and ");
			strBuff_sql.append("  rownum<2) ");

		pstmt = conn.prepareStatement(strBuff_sql.toString());
		pstmt.setString(1,facilityId);
		pstmt.setString(2,userid);
		pstmt.setString(3,patient_id);
		rs_new=pstmt.executeQuery();

	if (context_value.equals("Y"))
	{
		sql= "Select '1' from mr_user_access_rights_vw where appl_user_id=? and access_type='V' and patient_type='C' and access_scope='HR'";
	}
	else
	{
		sql="Select '1' from mr_user_access_rights_vw where appl_user_id=? and access_type='V' and patient_type='O' and access_scope='HR'";
	}

	stmt = conn.prepareStatement(sql);
	stmt.setString(1,login_user);
	rs = stmt.executeQuery();
	if (!(rs.next()))
		set_flag="Y";
	else
		set_flag="N";
%>
<script>

function CallDescFrame(Obj)
{
	var selected_val =Obj.value;
	top.content.workAreaFrame.PatAlertHighRiskMainFrame.PatAlertQueryHighRiskDesc.location.href='PatAlertQueryHighRiskDesc.jsp?radio_par='+selected_val+'&patient_id=<%=patient_id%>'
}

function authorised(Obj)
{
	var P_access_type=document.forms[0].P_access_type.value;
	var P_access_data=document.forms[0].P_access_data.value;
	var context_value=document.forms[0].context_value.value;
	var btn_flag	 =document.forms[0].btn_flag.value;


	Chk_val=Obj.value;

	if(btn_flag = "A")
	{
		document.forms[0].btn_flag.value ="N";
		var bool = '<%=set_flag%>'
		if (bool == 'Y' )

			alert(getMessage('NO_USER_FOUND','CA'));
		else
			parent.PatAlertHighRiskMainFrame.location.href="Authorize.jsp?called_from_ip=<%=called_from_ip%>&Access_Type="+P_access_type+"&Context="+context_value+"&Access_Data="+P_access_data+"&Patient_Id=<%=patient_id%>&jsp_name=PatAlertHighRiskMainFrame.jsp&radio_par=A";
	}
    else if(btn_flag = "N")
	{
			document.forms[0].btn_flag.value ="A";
			if("<%=called_from_ip%>" == "Y")
				parent.PatAlertHighRiskMainFrame.location.href='blank.jsp';
			else
				top.content.workAreaFrame.PatAlertHighRiskMainFrame.location.href='blank.jsp';

			document.forms[0].high_risk_button.value=getLabel("Common.Authorized.label","Common");

	}

}
</script>
<form name="radio_high_risk" id="radio_high_risk">
<table border=0   height=100% cellpadding='3' cellspacing='0' align=center width='100%'>
<th class='columnHeader'  align=center ><font size=1><fmt:message key="Common.HighRiskConditions.label" bundle="${common_labels}"/>
</th>
<td class='columnHeader' >
<font size=1></font>
<%
	if(rs_new.next())
	{%>
		<input type='button' name='high_risk_button' id='high_risk_button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels")%>' onclick='authorised(this)' class='button'>
	<%}
	else
	{
		out.print("&nbsp");
	}
%>
</td>
</table>
<input type="hidden" name="P_access_type" id="P_access_type" value=<%=P_access_type %> >
<input type="hidden" name="P_access_data" id="P_access_data" value=<%=P_access_data %> >
<input type="hidden" name="context_value" id="context_value" value=<%=context_value %> >
<input type="hidden" name="btn_flag" id="btn_flag"      value="A">


</form>
</body>
<%
}
catch (Exception e) 
{
	//out.println("Exception @ try"+e.toString()); //COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181	
}
finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(rs_new!=null) rs_new.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null)ConnectionManager.returnConnection(conn,request);	
	}catch(Exception e){
			//out.println("Exception @ finally try"+e.toString()); //COMMON-ICN-0181
		     e.printStackTrace();//COMMON-ICN-0181

	} 
}

%>
</html>

