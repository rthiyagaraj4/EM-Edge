<!DOCTYPE html>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String queryString = request.getQueryString();
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String cycle_no = request.getParameter("cycle_no") == null ? "" : request.getParameter("cycle_no");
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="JavaScript" src ="../../eCA/js/RecMaternityCons.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" onscroll='makeRowsStatic()'>
		<form name="specialityeventaddmodifyForm" id="specialityeventaddmodifyForm"  method ='post' target='messageFrame' >
		   	<table border='1' cellspacing='0' cellpadding='3' width='98%' align='left'>
				 <tr id='trIDStat'>
					<td  class='label' colspan='4'><b><fmt:message key="eCA.SelectCycle.label" bundle="${ca_labels}"/></b>
	<%
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql1 = "";
	try
	{    
			con = ConnectionManager.getConnection(request);
			String cycle1 = "";
			sql1 = "select CYCLE_NO from CA_PAT_SPLTY_EPISODE_HDR where patient_id = ? and module_id = ? order by CYCLE_NO DESC ";
			 ps = con.prepareStatement(sql1);
			 ps.setString(1,patient_id);
			 ps.setString(2,module_id);
			 rs = ps.executeQuery();
			  while(rs.next())
		     {
				  cycle1=rs.getString("CYCLE_NO")== null ? "" :  rs.getString("CYCLE_NO");
				  out.print("<a href=\"../../eCA/jsp/SpltyEpisode.jsp?"+queryString+"#"+cycle1+"\"	  target=\"cycleDetail\"  id='cycleNo"+cycle1+"'>"+cycle1+"&nbsp;&nbsp;&nbsp;</a>");
			}			
			%>
				 </td>
				 </tr>
				   <tr id='headerStatic'>
				  <td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
				  <td class='COLUMNHEADER'  width='20%'><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
				  <td class='COLUMNHEADER'  width='20%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				  <td class='COLUMNHEADER' width='35%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
				 </tr>
				</table>
				</form>
				</body>

				<script>
					var linkObj = document.getElementById('cycleNo'+<%=cycle_no%>);
					if(linkObj != null)
						linkObj.click();
				</script>
				</html>
			<%
				if(rs != null) rs.close();
		       if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in SpecialtyEventAddModifyIntermediate Module "+ee.toString());//common-icn-0181
	ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				if(con != null) 
			  {	
				ConnectionManager.returnConnection(con);
				con.close();
				if(rs != null) rs.close();
		       if(ps != null) ps.close();
			  }
			}
		catch(Exception e){
			//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}
	
	%>
				

