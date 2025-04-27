<!DOCTYPE html>
<%--
	FileName		: PatInstructionsResult.jsp
	Version	    : 3	
	Created On	: 05-08-2009
	Created By	: S.Sathish 
--%>
 
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, eCommon.XSSRequestWrapper, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eOP/js/PatInstructions.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try
{ 
  con	= ConnectionManager.getConnection();
  String serial_no="";
  String instruction_id="";
  String instruction_desc="";  
  String mode="";
  String serialno="";
  String desc="";
  String id=""; 
  String classValue = "";
  String default_yn="N"; 
  String check_default="";
  String facility_id="";
  String clinic_code="";
  String sqlmodify = "";
  String s_no = "";
  String ins_desc = "";
  String ins_id = "";
  String def_yn = "";
  String locale =((String)session.getAttribute("LOCALE"));
  request.setCharacterEncoding("UTF-8");
  mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
  serial_no=(request.getParameter("serial_no")==null)?"":request.getParameter("serial_no");
  instruction_id=(request.getParameter("instruction_id")==null)?"":request.getParameter("instruction_id");
  instruction_desc=(request.getParameter("instruction_desc")==null)?"":request.getParameter("instruction_desc");
  facility_id=(request.getParameter("facility_id")==null)?"":request.getParameter("facility_id");
  clinic_code=(request.getParameter("clinic_code")==null)?"":request.getParameter("clinic_code");  
  
	
		if(mode.equals("add"))
		{
			if(!(serial_no.equals("") && instruction_id.equals("") && instruction_desc.equals("")) )		
			{	
         //modified by N Munisekhar on 08-May-2012 against [IN:039810]			
			boolean ser=true;
			boolean inst=true;
			for(int k=0;k<associateDiagBean.getSize();k++)
			{
			if((k==0)||(k%4==0))
				{
				
				if(associateDiagBean.getObject(k).equals(serial_no))
					{
					ser=false;
					}
				if(associateDiagBean.getObject(k+2).equals(instruction_id))
					{
					inst=false;
					}	
				}
			
			}
			
		//	if(associateDiagBean.containsObject(serial_no)==false)
			if(ser)
			{
				//if(associateDiagBean.containsObject(instruction_id)==false)
				if(inst) 	
				{							
					associateDiagBean.putObject(serial_no);
					associateDiagBean.putObject(instruction_desc);
					associateDiagBean.putObject(instruction_id);
					associateDiagBean.putObject(default_yn);
				}//End  of [IN:039810]
				else
				{
					%>
					<script>
						alert(getMessage("RECORD_EXISTS","SM"));		
					</script>
					<%
				}
			}
			else
			{
				%>
					<script>
						alert("Duplicate serial No. not allowed");					       
					</script>
				<%
			}
		 }
		}	
		else if(mode.equals("delete"))
		{
		  if(!(serial_no.equals("") && serial_no.equals("null")))
		  {//modified by N Munisekhar on 15-May-2012 against [IN:40080]		
			boolean ser=false;
			for(int k=0;k<associateDiagBean.getSize();k++)
			{
			  if((k==0)||(k%4==0))
			  {
				if(associateDiagBean.getObject(k).equals(serial_no))
				{
				  ser=true;
				  if(ser)
				//if(associateDiagBean.containsObject(serial_no)!=false)
				  { 
				 // int pos=associateDiagBean.indexOfObject(serial_no);	
					for(int s=0;s<4;s++)
					  {	associateDiagBean.removeObject(k);}		
				  }
				}
			  }
		    }
		   }			
		 }//End of  [IN:40080]
		else if(mode.equals("modify"))
		{ 			
			associateDiagBean.clearAll();
			sqlmodify = "select INSTRUCTION_ID, AM_GET_DESC.AM_PAT_INSTRUCTIONS(INSTRUCTION_ID, '"+locale+"','1') description, DISPLAY_ORDER, DEFAULT_LINKED_YN from op_clinic_pat_instructions where FACILITY_ID=? and CLINIC_CODE=? order by DISPLAY_ORDER";
			
            pstmt=con.prepareStatement(sqlmodify);
			pstmt.setString( 1, facility_id);
			pstmt.setString( 2, clinic_code);
            rs=pstmt.executeQuery();

			while( rs!=null && rs.next())
			{
				s_no=(rs.getString("DISPLAY_ORDER")==null)?"":rs.getString("DISPLAY_ORDER");
				ins_desc=(rs.getString("description")==null)?"":rs.getString("description");
				ins_id=(rs.getString("INSTRUCTION_ID")==null)?"":rs.getString("INSTRUCTION_ID");
				def_yn=(rs.getString("DEFAULT_LINKED_YN")==null)?"":rs.getString("DEFAULT_LINKED_YN");

                associateDiagBean.putObject(s_no);
				associateDiagBean.putObject(ins_desc);
				associateDiagBean.putObject(ins_id);
				associateDiagBean.putObject(def_yn);
			}
				
			if(rs!=null) rs.close();
		    if(pstmt!=null) pstmt.close();
		}
		
		int rec_cnt=associateDiagBean.getSize();
		
		if(rec_cnt>0)
		{           
			
			%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name='PatInstructionsResult_form' id='PatInstructionsResult_form'>
	<table border='1' cellpadding='0' cellspacing='0' width='101%' align='center'>
		<tr>
			<th width='10%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>
			<th width='70%'><fmt:message key="eAM.InstructionDescript.label" bundle="${am_labels}"/></th>
			<th width='13%'><fmt:message key="eAM.InstructionID.label" bundle="${am_labels}"/></th>
			<th width='7%'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
		</tr>
		<%
			 ArrayList a= new ArrayList();
			 a= associateDiagBean.getRecordSetHandle();
			for(int i=0,j=0;i<rec_cnt;i++,j++)
			{  
					if ( i % 2 == 0 )
					 classValue = "QRYEVEN" ;
				else
					 classValue = "QRYODD" ;

					serialno=a.get(i).toString();
					desc=a.get(++i).toString();					
					id=a.get(++i).toString();
					default_yn=a.get(++i).toString();
					
					if(default_yn.equals("Y"))
						check_default="checked";
					else
						check_default="";
					/*Added "" desc hidden field value by Senthil on 21-Oct-2011*/
					%>
					 <input type = 'hidden' name = 'serialno<%=j%>' value = '<%=serialno%>'>
					<input type = 'hidden' name = 'desc<%=j%>' value = "<%=desc%>">
					<input type = 'hidden' name = 'id<%=j%>' value = '<%=id%>'>
					<%
									
					out.println("<tr><td class='" + classValue + "' align='center' width ='10%' nowrap>&nbsp;&nbsp;<a href=javascript:putvalues('"+j+"')>"+serialno+"</a></td>");
					out.println("<td class='" + classValue + "' align='center' width ='70%' style='WORD-BREAK:BREAK-ALL;'>"+desc+"</td>");
					out.println("<td class='" + classValue + "' align='center' width ='13%' nowrap>"+id+"</td>");
					out.println("<td class='" + classValue + "' align='center' width ='7%' nowrap><input type=checkbox name=default_yn "+check_default+"  onClick=deafult_check(this,'"+j+"')></td></tr>");
				
				}
				
          %>

	</table>
</form>
</body>
<%
		a.clear();
	}
	

}
catch(Exception e)
{
	 e.printStackTrace();
}
finally
	{					
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

