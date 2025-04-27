<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
13/03/2014		IN044157		Chowminya		 [AAKH CRF 0010.1]Five level Triage system  AE requirement 	
---------------------------------------------------------------------------------------------------------------
*/ %>
<!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
<%@ page import="java.sql.*, java.util.*,java.lang.Math.*, java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,com.ehis.util.*" %>
<!--CRF  SKR-CRF-0021 [IN028173] end-->

<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
  request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
 
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<script>
function navigate(start,end)
{

	if(document.forms[0].prev != null)
	document.forms[0].prev.disabled='true';

	if(document.forms[0].nex != null)
	document.forms[0].nex.disabled='true';

	top.content.workAreaFrame.PatResultFr.LocnResult.document.getElementById("from").value=start ;
	top.content.workAreaFrame.PatResultFr.LocnResult.document.getElementById("to").value=end ;

	var flag1=false;


	for(i=0;i<top.content.workAreaFrame.PatResultFr.LocnResult.document.anchors.length;i++)
	{
			if(top.content.workAreaFrame.PatResultFr.LocnResult.document.anchors(i).style.color=='pink' || top.content.workAreaFrame.PatResultFr.LocnResult.document.anchors(i).style.color=='yellow')
			{
				flag1=true;
				break;
			}
	}
		if(!flag1)
		{
			//alert('into');
			top.content.workAreaFrame.PatCriteriaFr.document.getElementById("order_by").value="";
			top.content.workAreaFrame.PatCriteriaFr.document.getElementById("re_order").value="";
			top.content.workAreaFrame.PatCriteriaFr.document.getElementById("anchor_id").value="";
		}
		var orderBy=top.content.workAreaFrame.PatCriteriaFr.document.getElementById("order_by").value;
		var reOrder=top.content.workAreaFrame.PatCriteriaFr.document.getElementById("re_order").value;
		var anchorID=top.content.workAreaFrame.PatCriteriaFr.document.getElementById("anchor_id").value;
		//----------ends here--
//		alert(top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].form.value);
	if(top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].form.value == "Location")
	{

		top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].action = '../jsp/PatListByLocationResult.jsp?orderBy='+orderBy+'&reOrder='+reOrder+'&anchorID='+anchorID;
	}
	//----------------
	if(top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].form.value == "MedService")
	{

		top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].action = '../jsp/PatListByMedServiceResult.jsp?orderBy='+orderBy+'&reOrder='+reOrder+'&anchorID='+anchorID;
	}


	if(top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].form.value == "Relation")
	{
		top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].action = '../jsp/PatListByRelnProvResult.jsp?orderBy='+orderBy+'&reOrder='+reOrder+'&anchorID='+anchorID;
	}

	top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].method = 'post'
    top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].target = ''
    top.content.workAreaFrame.PatResultFr.LocnResult.document.forms[0].submit() ; 

}

</script>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%      /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
       
	   Connection con				      = null;  
        PreparedStatement pstmt		      = null;
		ResultSet rset				      = null;
		String relnreqyn = request.getParameter("reln_req_yn")==null?"Y":request.getParameter("reln_req_yn");
		String newborn_page_yn = request.getParameter("newborn_page_yn")==null?"N":request.getParameter("newborn_page_yn");
		String color      ="";
		String noncritical="";
		String critical="";
		String semicritical="";
		String unassigned="";
		String sql="";
		ArrayList emg_zone = new ArrayList();//IN044157
		PreparedStatement stmtAE = null;
		ResultSet rsAE = null;
		String[] record =null; //IN044157
		String AEZone5 = "N"; //IN044157
		
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id		= (String)session.getAttribute("facility_id");//IN044157
		try
		 {
		       con = ConnectionManager.getConnection(request);
			   	//IN044157 - Start
				stmtAE = con.prepareStatement("Select FIVE_LEVEL_TRIAGE_APPL_YN from AE_PARAM where OPERATING_FACILITY_ID=?");
				stmtAE.setString(1,facility_id);
				rsAE = stmtAE.executeQuery();
				while(rsAE!=null && rsAE.next()){
					AEZone5 = rsAE.getString("FIVE_LEVEL_TRIAGE_APPL_YN");
				}
				
				if(AEZone5.equals("N"))
					sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E'";
				else	
					sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC,PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER asc"; 
				//IN044157 - End
	            //sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E'";
				//sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC,PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER asc"; //IN044157 
				
				pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
					if(AEZone5.equals("Y")){
					//IN044157 - Start
					record = new String[3];	
					record[0] = rset.getString("PRIORITY_ZONE");
					record[1] = rset.getString("PRIORITY_ZONE_TAB_DESC");
					record[2] = rset.getString("PRIORITY_ZONE_COLOR");
					emg_zone.add(record);
					}else{
					//IN044157 - End
					 color      =rset.getString("PRIORITY_ZONE");
					 if (color.equals("G")) {noncritical=rset.getString("PRIORITY_ZONE_TAB_DESC");}
					 if (color.equals("R")) {critical=rset.getString("PRIORITY_ZONE_TAB_DESC");}
					 if (color.equals("Y")) {semicritical=rset.getString("PRIORITY_ZONE_TAB_DESC");}
					 if (color.equals("U")) {unassigned=rset.getString("PRIORITY_ZONE_TAB_DESC");}
					}
				}
		}
		catch (Exception e)
		{
		e.printStackTrace() ;
		}
		finally
		{
		if(stmtAE!=null)stmtAE.close();
		if(rsAE!=null)rsAE.close();
        if(rset!=null) rset.close(); 
		if(pstmt!=null) pstmt.close();	
		if( con !=null ) ConnectionManager.returnConnection(con,request);
		}
		/* CRF  SKR-CRF-0021 [IN028173] end  */
%>
<form name=color_form >


<table align='left' cellspacing='0' cellpadding='0' border='3' width='100%' >
<tr>
	<td  align='center' bordercolor='blue' width='' id='previous'></td>

<td>
<table border=1 align='left' cellspacing='0' cellpadding='3' border='0' width='100%'>
		<tr>
				 <td   class='QRYEVEN'><font size=1><b><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></b></td>
			<%
			//if code modified IN044157 
			if(AEZone5.equals("Y")){
			if(emg_zone.size() > 0)
			{
				for(int i=0;i<emg_zone.size();i++)
				{
					String[] emg = new String[3];
					emg = (String [])emg_zone.get(i);
					
			%>		
				<td bgcolor='<%=emg[2]%>'><font size=1 color=black><%=emg[1]%></font></td>
			<%	
				}
			}}else{
			%>	
				 <!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
				<td class=CRITICAL style='background-color:RED'><font size=1 color=black><%=critical%></font></td>
				<td class=SEMICRITICAL><font size=1 color=black><%=semicritical%></font></td>
				<td class=NONCRITICAL><font size=1 color=black><%=noncritical%></font></td>
				<!--CRF  SKR-CRF-0021 [IN028173] end-->
			<%
			}
			%>
		</tr>
</table>
</td>


<td>
	<table border=1 align='left' cellspacing='0' cellpadding='3' border='0' width='100%'>
		<tr>
				
				<%	if(newborn_page_yn.equals("Y"))
				{ %>
				<td   class='NEWBORN' style='background:#00FF00' width='6%'></td>
				<td   class='QRYEVEN' ><font size=1><fmt:message key="eCA.HealthNewBorn.label" bundle="${ca_labels}"/>&nbsp</td>
				<td   align='left' class='DISCHARGED' style='background:#0099FF' width='6%' >&nbsp;</td>
				<td   class='QRYEVEN'   ><font size=1>&nbsp;<fmt:message key="eCA.AdmittedNewborn.label" bundle="${ca_labels}"/>&nbsp;</td>
				<td   class='CADECEASED' width='6%'></td>
				<td   class='QRYEVEN' ><font size=1><fmt:message key="eCA.StillbornDeceased.label" bundle="${ca_labels}"/>&nbsp</td>
				<%} else {%>
				<td   class='CADECEASED' width='6%'>&nbsp;</td>
				<td   class='QRYODD'><font size=1>&nbsp;<fmt:message key="Common.deceased.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td   class='NEWBORN' width='6%'>&nbsp;</td>
				<td  class='QRYEVEN' ><font size=1>&nbsp;<fmt:message key="eCA.NewbornExists.label" bundle="${ca_labels}"/>&nbsp;&nbsp;</td>
				<td  align='left' class='DISCHARGED' width='6%' align=center>&nbsp;</td>
				<td   class='QRYEVEN' ><font size=1>&nbsp;<fmt:message key="Common.discharged.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				 <%} %>

		</tr>
	</table>
</td>

<%	if(relnreqyn.equals("Y"))
	{ %>
		<td >
			<table border='1' width='100%' id=tab > 
				<td  id=c1  width='6%'  >&nbsp;<b>*</b>&nbsp;</td>
				<td  id=c2  class='QRYEVEN' ><font size=1>&nbsp;<fmt:message key="eCA.NoPPRelationship.label" bundle="${ca_labels}"/>&nbsp;&nbsp;</td>
			</table>
	</td>
	
<%}%>
<td  align='center' bordercolor='blue' width='' id='next'></td>
</tr>
</table>
</form>
</body>
</html>

