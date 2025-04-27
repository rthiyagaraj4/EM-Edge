<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>


<html>
<head>
<%	request.setCharacterEncoding("UTF-8");	%>

	  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>


<% String locale = ((String)session.getAttribute("LOCALE"));%>
<script src='../../eBT/js/BTTransaction.js' language='javascript'></SCRIPT>
<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>


<script language='javascript'>
function closeWindow()
{
parent.window.close();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<!--Added by Ashwini on 20-Mar-2018 for MMS-DM-CRF-0137-->
<%
Connection conn=null;

try
{
	conn = ConnectionManager.getConnection(request);
%>

  <body onMouseDown="" onKeyDown="">

  <%
  		HttpSession httpSession = request.getSession(false);
		String strFacilityId=""+httpSession.getValue("facility_id");

		String patient_id=""+request.getParameter("patient_id");
		
		Boolean isUnitNoProdCodeScanAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "BT","UNIT_NO_PRODUCT_CODE");//Added by Ashwini on 20-Mar-2018 for MMS-DM-CRF-0137

		String sql="select EPISODE_ID EPISODE_ID1 from OP_VISIT where PATIENT_ID =? and  FACILITY_ID =? and EPISODE_ID=? and VISIT_ID=?";

		String episode_id= request.getParameter("episode_id");
		String visit_id=request.getParameter("visit_id");
		String encounter_id="";
		String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//Added for MMS-DM-CRF-170.2

		if(visit_id==null||visit_id.length()==0 || visit_id.equalsIgnoreCase("null")==true)
		{
			encounter_id=episode_id;
		}
		else
		{
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,patient_id); 
		pstmt.setString(2,strFacilityId);
		pstmt.setString(3,episode_id);
		pstmt.setString(4,visit_id);
		rs = pstmt.executeQuery();
		while(rs.next())
			{
			encounter_id=rs.getString(1);
			}
			rs.close();
			pstmt.close();
			//ConnectionManager.returnConnection(conn, request);
			}
			catch(Exception expSQL)
			{
				encounter_id="0";
			//ConnectionManager.returnConnection(conn, request);
			//eBT.LogFile.log("QADebugger","Exception "+expSQL,this);
			}
		}

	%>

<!-- change this form name as formTab for  view transfusionHistory -->

   <form name="formTab" id="formTab"  DETAIL_BLOCK_NAME='BTRRSelectionForm' method='post' action=""> 
   <table cellpadding=0 cellspacing=0 width="100%" align="center">
<tr>


 <td class='label'  colspan='6' ><b>
<!--	<input type="button" name="PatDtl" id="PatDtl" class="BUTTON" value ="Details"  	onClick="javascript:callDetails()">&nbsp;
	-->


  <input type="button" name="PatAnt" id="PatAnt" class="button" value = '<fmt:message key="eBT.Antibody.label" bundle="${bt_labels}" />' onClick="javascript:callAntiBody()">&nbsp;
  <!--Modified by Ashwini on 08-May-2018 for ML-MMOH-CRF-0589-->
   <input type="button" name="ReqPrint" id="ReqPrint" class="button" value = '<fmt:message key="eBT.TransfusionTransferHistory.label" bundle="${bt_labels}" />' onClick="javascript:callBloodHistory()">&nbsp;
	  <input type="button" name="PatReq" id="PatReq" class="button" value ='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requirement.label","common_labels")%>' onClick="javascript:callRequirments()">
  </td>


</tr>
	</table>

<!--<input type='hidden' name='PATIENT_ID' id='PATIENT_ID' value='<%=request.getParameter("patient_id")%>' RECORD_TYPE='S'>-->

<input type='hidden' name='PATIENT_ID' id='PATIENT_ID' value="<%=patient_id%>" RECORD_TYPE='S'>


<input type='hidden' name='FACILITY_ID' id='FACILITY_ID' value='<%=strFacilityId%>' RECORD_TYPE='S'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>' >
<!-- Encounter id should give for tranfusion History. -->

	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">

	<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" RECORD_TYPE='S'>
	<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>"><!-- added for MMS-DM-CRF-0170.2 -->

	<!--Added by Ashwini on 20-Mar-2018 for MMS-DM-CRF-0137-->
	<input type='hidden' name='isUnitNoProdCodeScanAppl' id='isUnitNoProdCodeScanAppl' value="<%=isUnitNoProdCodeScanAppl%>">
	

	</form>
<script> funBTTransfusionHistory(document.forms[0]); </script>
  </body>
  <%
	}
	catch(Exception exp)
	{
	}finally
	{
	ConnectionManager.returnConnection(conn, request);
	}
 %>
 </html>

