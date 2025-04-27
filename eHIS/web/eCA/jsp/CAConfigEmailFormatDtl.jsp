<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%  
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCA/js/CAConfigEmailFormat.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
		function loadmsg(obj)
		{		
			
			if(obj.checked ==true) 
		    obj.value='Y';
	       else 
		    obj.value = 'N';         
			
		}		
		function checkChildEvents(obj){
		
			var objName = obj.name;		
			objName = objName.substring(objName.indexOf("~")+1);				
			var cInp = document.getElementsByTagName('input');
			for (var i=0;i<cInp.length ;i++ )
			{
				if (cInp[i].type == "checkbox")
				{
					var chdEvent =  cInp[i].name;
					chdEvent = chdEvent.substring(chdEvent.indexOf("~")+1);					
					if (objName == chdEvent )
					{
						if (obj.checked)
						{							
							cInp[i].checked = true;
							cInp[i].value = "Y";
						}else{
							cInp[i].checked = false;
							cInp[i].value = "N";							
						}
						
					}
					
				}
				
			}
			
		}
</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
	String classValue = "gridData";
	String eventName = "";
	String eventDesc = "";
	String eventStatus = "";
	String eventHdr = "";
	String strChecked = "";
	//String chkstr="disabled";
	String chkstr="";
	int rowCount=0;
	String reportTypeId = request.getParameter("reportTypeId") == null ? "" : request.getParameter("reportTypeId");
	
	
	Connection conn				= null;
	PreparedStatement pstmt	    = null;
	ResultSet rs				= null;


	try
 {
		String sqlSel = "select EVENT_NAME,EVENT_DESC,EVENT_STATUS,EVENT_HDR from CA_CONFIG_EMAIL_FORMAT where EFF_STATUS ='E' AND REPORT_ID=? order by SRL_NO";
	    
	    conn	= ConnectionManager.getConnection();
		pstmt	= conn.prepareStatement(sqlSel);
		pstmt.setString(1,reportTypeId);
		rs		= pstmt.executeQuery();	
%>

</html>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name="configEmailFrmtDtlForm" id="configEmailFrmtDtlForm" action="../../servlet/eCA.CAConfigEmailFrmtServlet" method="post" target="messageFrame">
	<table  class='grid' align='center' cellpadding=3 cellspacing=0 border=1 width='80%'>
		<tr>
		<td class='COLUMNHEADERCENTER' ><fmt:message key="eCA.DisplayEvents.label" bundle="${ca_labels}"/></td>
        <td class='COLUMNHEADERCENTER' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>	
		</tr>
		<%
		String eventHdrTemp = "";
	    while(rs.next())
	    {		
		strChecked="";
		rowCount++;

		eventName = rs.getString("EVENT_NAME") == null ? "" : rs.getString("EVENT_NAME");
		eventDesc = rs.getString("EVENT_DESC") == null ? "" : rs.getString("EVENT_DESC");
		eventStatus = rs.getString("EVENT_STATUS") == null ? "N" : rs.getString("EVENT_STATUS");		
		eventHdr = rs.getString("EVENT_HDR") == null ? "" : rs.getString("EVENT_HDR");
		if (eventStatus.equals("Y"))
			strChecked="checked";

		if (reportTypeId.equals("EMPATINS"))
		{
		  if((eventName.equals("ORD_CAT_DTL")) || (eventName.equals("PAT_INSTRUCTIONS")) )
			{	  
			  chkstr="disabled";
			  strChecked="checked";	
		   }
		   
		}
		
			if(!eventHdrTemp.equals(eventHdr))
			{
				 out.println("<tr>");
				 out.println("<td class='"+classValue+"'   name='eventDesc"+rowCount+"'><B>"+eventDesc);	
				 out.println("</B></td><td align='center' class='"+classValue+"' ><input type='checkbox' name='eventStatus"+rowCount+"~"+eventHdr+"' id='eventStatus"+rowCount+"~"+eventHdr+"' value='"+eventStatus+"' onclick='checkChildEvents(this)' "+strChecked+" "+chkstr+">");	
				 out.println("<input type=hidden name='eventName"+rowCount+"' id='eventName"+rowCount+"' value='"+eventName+"'>");
				 out.println("<input type=hidden name='eventHdr"+rowCount+"' id='eventHdr"+rowCount+"' value='"+eventHdr+"'>");
				 out.println("</tr>"); 		
				
			}else{
				 out.println("<tr>"); 				 
				 out.println("<td class='"+classValue+"'  name='eventDesc"+rowCount+"'>"+eventDesc);
				 out.println("</td><td align='center' class='"+classValue+"' ><input type='checkbox' name='eventStatus"+rowCount+"~"+eventHdr+"' id='eventStatus"+rowCount+"~"+eventHdr+"' value='"+eventStatus+"'  onclick='loadmsg(this)' "+strChecked+" "+chkstr+">");
				out.println("<input type=hidden name='eventName"+rowCount+"' id='eventName"+rowCount+"' value='"+eventName+"'>");
				out.println("<input type=hidden name='eventHdr"+rowCount+"' id='eventHdr"+rowCount+"' value='"+eventHdr+"'>");
				 out.println("</tr>"); 			
			} 

				eventHdrTemp = eventHdr;
		}	
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{		
	e.printStackTrace();
   }
   finally{
	if(conn != null) ConnectionManager.returnConnection(conn,request);
   }
	%>
</table>
<input type='hidden' name='configureEmailReport' id='configureEmailReport' value='<%=reportTypeId%>'>
<input type='hidden' name='total_count' id='total_count' value='<%=rowCount%>'>
</form> 
</body>
</html>

