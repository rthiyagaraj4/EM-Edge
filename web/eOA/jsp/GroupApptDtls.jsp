<!DOCTYPE html>

 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<html>
<head>

	
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head> 
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
 <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' >

<%
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet	rs=null;
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String group_id	= request.getParameter("group_id");
		String group_Name="",locn_type_desc="",location_desc="";
		String locale=(String)session.getAttribute("LOCALE");
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
		String app_date	= request.getParameter("app_date");
		int i=0;
		String classValue="";
		
        try{
         con = ConnectionManager.getConnection(request);
		 String sql = "select group_name,LOCN_TYPE,op_get_desc.op_clinic(?,LOCN_CODE,?,2) CLINIC_DESC  from oa_group_hdr where group_id=?";
	     //stmt=con.prepareStatement("select group_name,LOCN_TYPE,op_get_desc.op_clinic('"+fac_id+"',LOCN_CODE,'"+locale+"',2) CLINIC_DESC  from oa_group_hdr where group_id='"+group_id+"'");
		 stmt = con.prepareStatement(sql);
		 stmt.setString(1,fac_id);
		 stmt.setString(2,locale);
		 stmt.setString(2,group_id);
		 rs = stmt.executeQuery();
		 if(rs.next()){		 
		 
		 
			  group_Name=checkForNull(rs.getString("group_name"));
			  locn_type_desc=checkForNull(rs.getString("LOCN_TYPE"));	
              location_desc=checkForNull(rs.getString("CLINIC_DESC"));			 
		}			  
		if(locn_type_desc.equals("C")){					
				locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}else if(locn_type_desc.equals("E")) {
				locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		}else if(locn_type_desc.equals("Y")){			
				locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
		}
			 %>
			 <tr >
			 <td class='QUERYDATA'><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td>
			 <td  class='fields'><%=group_Name%></td>
			 <td  class='QUERYDATA'><%=locn_type_desc%></td>
			 <td  class='fields'><%=location_desc%></td>
			 </tr><tr><td clospan='4'>&nbsp;</td></tr>	 
			 <tr >
			  <td class='QUERYDATA'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>	
			  <td class='fields'> <%=app_date%>&nbsp;</td>	 <td clospan='2'>&nbsp;</td>			  
			 </tr>			 
			</table>
		
	<%
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
}
catch(Exception e)
	{
	//out.println("one L :" +e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}	
%>
</body>
</html> 

