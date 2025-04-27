<!DOCTYPE html>
<%@ page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/RecPatChiefComplaint.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
	//		var returnArray;
			
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String description = "";
	String description1 = "";
	String encounter_id = "";
	String locale = "";	
	String facility_id		=	(String) session.getValue("facility_id");
	StringBuffer sql = new StringBuffer();
	String complaint_id = "";
	String complaint_desc ="";					
	String complaint_details ="";
	String spltCode ="";

	int count =0;
	try
	{
			con = ConnectionManager.getConnection(request);
			description = request.getParameter("complaint_id") == null ? "" : request.getParameter("complaint_id");
			encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
			locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
			spltCode = request.getParameter("spltCode") == null ? "" : request.getParameter("spltCode");
		

			sql.append("select COMPLAINT_ID,COMPLAINT_DESC,COMPLAINT_TEXT from CA_CHIEF_COMPLAINT_lang_vw where (SPECIALITY_CODE is null  or SPECIALITY_CODE=(select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?)) and eff_status='E' and language_id = ? ");

			description1 = description;
			if (!description.equals(""))
			{
				description = description + "%";
				sql.append(" and upper(COMPLAINT_DESC) like upper(?)");

			}	

			ps = con.prepareStatement(sql.toString());
			ps.setString(1,facility_id);
			ps.setString(2,encounter_id);
			ps.setString(3,locale);
			if (!description.equals(""))
			{
				ps.setString(4,description);
			}
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				if(rs.next())
				{						
					complaint_id = rs.getString(1);
					complaint_desc = rs.getString(2);					
					complaint_details =rs.getString(3);	
					//out.println("alert('here"+count+"')");
					
				  	out.println("parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_desc.value='"+complaint_desc+"' ");
					out.println("parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.flag.value='true' ");	
					out.println("parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_id.value='"+complaint_id+"' ");
					out.println("parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_details.value='"+ complaint_details+"' ");
				}
			}
			if(rs != null) rs.close();			
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				//out.println("<script>alert('count"+count+"')</script>");
		/*		sql = "select COMPLAINT_ID,COMPLAINT_DESC,COMPLAINT_TEXT from CA_CHIEF_COMPLAINT_lang_vw where (SPECIALITY_CODE is null  or SPECIALITY_CODE=(select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?)) and eff_status='E' and language_id = ?";  */
%>
	<script>
		 retArray = callFunction("<%=encounter_id%>","<%=description1%>","<%=spltCode%>");
			if(retArray != null && retArray !="")	
			{
					//var splitval = retArray.split("#");
					var splitval = retArray.split("`");
					parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_id.value=splitval[0];
					parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_desc.value=splitval[1];
					parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_details.value=splitval[2];				
					parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.flag.value = 'true'  
					var open_in_modal =parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.open_in_modal.value;
                  if(open_in_modal =="Y"){
					parent.AEMessageFrame.location.href='../../eCommon/jsp/error.jsp';
				  }else {
					  	top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
				  
				  }

			}
			else
			{
					parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_id.value="";
					parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_desc.value="";
					parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.complaint_details.value="";
					parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.flag.value = 'true'
					var open_in_modal =parent.RecPatChiefComplaintAddModifyFrame.document.RecPatChiefComplaintAddModifyForm.open_in_modal.value;
                  if(open_in_modal =="Y"){
					parent.AEMessageFrame.location.href='../../eCommon/jsp/error.jsp';
				  }else {
					  	top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
				  
				  }
			}			
	</script>
<%
		 }	
	if(rs != null) rs.close();
	if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
		//out.println("Exception in RecPatChiefComplaintIntermediate Module "+ee.toString());//COMMON-ICN-0181
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){
			e.printStackTrace();
		
		}
	}
%>
<%!
	
	private String replaceSpecialChars(String input)
	{
		if(input.indexOf("\n")!=-1)
			input = input.replaceAll("\n","");	

		return input;
	}

%>
 </body>
</html>
	 
	 

