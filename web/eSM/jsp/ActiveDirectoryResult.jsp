<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")? (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
    <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <script src="../../eCommon/js/common.js" language="javascript"></script>
    <script src="../../eSM/js/ActiveDirectoryLoookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%

Connection conn = null;
String classvalue = "gridData" ;
int recCount = 1;
int notlinkedcnt = 0;

String retvaljson = request.getParameter("retvaljson");
String retDataCnt = request.getParameter("retDataCnt");

int retCnt = Integer.parseInt(retDataCnt);

String[] arrOfStr = retvaljson.split("}",retCnt);

int indexval;
int indexval1;
String value = "";
String active_dir_id = "";
String id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ActiveDirectoryID.label","sm_labels");

try{

conn = ConnectionManager.getConnection(request);

%>

<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id="ResultTab">

<th><%=id_desc%></th>

<%
for(int g=0;g<arrOfStr.length;g++)
{
	indexval = arrOfStr[g].indexOf("sAMAccountName",1)+17; 
	indexval1 = arrOfStr[g].indexOf("displayName",1); 
	value = arrOfStr[g].substring(indexval,indexval1).trim();
	value = value.substring(0,value.length()-3).trim();

	String loginID			= value;
	PreparedStatement pstmt	= null;
	ResultSet  rs			= null;

	try{
		
		String sql = " SELECT active_dir_id, appl_user_id, app_password.decrypt (appl_user_password) AS appl_user_password, app_password.decrypt (pin_no) AS appl_user_pin FROM sm_appl_user WHERE upper(active_dir_id) = upper('"+loginID+"') ";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if(rs != null && rs.next()){

			active_dir_id = rs.getString("active_dir_id")==null?"":rs.getString("active_dir_id");
			
		}else{
			active_dir_id = "";
		}
							
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(pstmt !=null) pstmt.close();
			if(rs !=null) rs.close();
		}
		catch(Exception fe){
		}
	}

	if(active_dir_id.equals("")){
%>

		<tr onClick="Modify('<%=recCount%>');">

		<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=value%></font></td>

		<input type="hidden" name ="hd_<%=recCount%>" value="<%=value%>">

		</tr>
<%
		notlinkedcnt++;
	}

	recCount++;

}

if(notlinkedcnt == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[1].location.href ='../../eCommon/html/blank.html';</script>");
}

}catch(Exception e){
	e.printStackTrace();
}finally { 
	ConnectionManager.returnConnection(conn,request);
}
%>

</table>



</body>
</html>

<%!
public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

