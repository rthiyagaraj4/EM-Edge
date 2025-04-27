<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
10/04/2024  50627    Twinkle Shah    10/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	webbeans.eCommon.RecordSet accRightForResRecSet = (webbeans.eCommon.RecordSet)getObjectFromBean("accRightForResRecSet","webbeans.eCommon.RecordSet",session);
%>
<%!int row_count=0;%>
<html>
<head>
<title> <fmt:message key="eCA.TaskForResponsibilityRelationship.label" bundle="${ca_labels}"/></title>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../../eCA/js/CAAllowedPositConsultTag.js'></script>
</head>
<%
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String facilityId = (String)session.getValue( "facility_id" ) ;

Connection con			= null;
PreparedStatement pstmt = null,pstmt1=null;
ResultSet rs			= null,rs1=null;
HashMap hMapRecords		= null; 

String practitionerId ="", practitionerName = "", position_code = "", position_desc = "", positionIU="", position_restr_yn="", pract_type1="", classValue="";

int row_disp=14;
int start = 0 ;
int end = 0 ;
int chk_count=0;
String checkallDateEnable="";
int fm_disp=0, to_disp=0;
String dispMode		=	request.getParameter("dispMode")==null?"": request.getParameter("dispMode");
String search_by = request.getParameter("search_by")==null?"":request.getParameter("search_by");
String pract_type = request.getParameter("practitioner_type")==null?"":request.getParameter("practitioner_type");
String search_txt = request.getParameter("search_txt")==null?"":request.getParameter("search_txt");
String from		=request.getParameter( "from" )==null?"1": request.getParameter( "from" );
String to		=request.getParameter( "to" )==null?String.valueOf(row_disp): request.getParameter( "to" );
start = Integer.parseInt( from ) ;
end = Integer.parseInt( to ) ;
String or_bean_id 						= "@CAAllowedPositConsultTagBean";
String or_bean_name 					= "eCA.CAAllowedPositConsultTagBean";
CAAllowedPositConsultTagBean bean		= (CAAllowedPositConsultTagBean)getBeanObject( or_bean_id, or_bean_name, request ) ;

try{
	con = ConnectionManager.getConnection(request);
	if(dispMode.equals("")){
		accRightForResRecSet.clearAll();
		ArrayList  resArray = bean.getMppedPositionDtlToPactitioner(facilityId,pract_type,locale);
		row_count =resArray.size();
    	if (row_count >0 ){
    	for(int i = 0; i < row_count; i++){
    	ArrayList array = (ArrayList)resArray.get(i);
		HashMap hMapRecs = new HashMap();
		hMapRecs.put("position_code"		, array.get(0));
		hMapRecs.put("position_desc"		, array.get(1));
		hMapRecs.put("positionIU"		, array.get(2));
		hMapRecs.put("position_restr_yn"		, array.get(3));
		hMapRecs.put("pract_type1"		, array.get(4));
		accRightForResRecSet.putObject(hMapRecs);
    	}
		row_count	=	accRightForResRecSet.getSize();
		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);
		from = ""+(start - 1);
		to   = ""+(end - 1);
		}%>
		<script>
			if('<%=row_count%>' <= 0){
			var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common");	
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
		</script>
		<%
	}else{
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));		
		if(dispMode.equals("Next")){
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
			
		}else if(dispMode.equals("Previous")){
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
		}
		if(to_val > (row_count-1))
			to_val=(row_count-1);

		for(int j=from_val; j<=to_val; j++){	
			position_code 		=	request.getParameter("position_code"+j)==null?"":request.getParameter("position_code"+j);
			position_desc	=	request.getParameter("position_desc"+j)==null?"":request.getParameter("position_desc"+j);
			positionIU	=	request.getParameter("positionIU"+j)==null?"I":request.getParameter("positionIU"+j);
			position_restr_yn	=	request.getParameter("position_restr_yn"+j)==null?"N":request.getParameter("position_restr_yn"+j);
			pract_type1	=	request.getParameter("pract_type1"+j)==null?"":request.getParameter("pract_type1"+j);
			HashMap hMapAlter = (java.util.HashMap)accRightForResRecSet.getObject(j);
			hMapAlter.put("position_code"	, position_code);
			hMapAlter.put("position_desc"	, position_desc); 
			hMapAlter.put("positionIU"	, positionIU); 
			hMapAlter.put("position_restr_yn"	, position_restr_yn); 
			hMapAlter.put("pract_type1"	, pract_type1); 
			accRightForResRecSet.setObject(j, hMapAlter);
		}
		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
	putObjectInBean("accRightForResRecSet",accRightForResRecSet,session);
%>
<body  OnMouseDown="CodeArrest();"  class='CONTENT' onKeyDown = 'lockKey()'>
<form name='CAAllowedPositConsultTagRusltFrm' id='CAAllowedPositConsultTagRusltFrm' >
<table cellpadding='3' cellspacing='0' border='0' width='50%' align='center'>
<tr  width='10%'>
<td class='white' width='49%'></td>
<%
	if ( (!(start <= 1)) && (start < row_count)){
	%>
		<td width='6%' class='label'>
		<A class='gridLink' HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
		</td>
	<%	
	}
	if ( !( (start+row_disp) >= row_count ) ){
	%>
		<td width='6%' class = 'label'><A class='gridLink' HREF='javascript:onClick=checkVal("Next");' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
		</td>
	<%
	}
%>
</tr>
</table> 
<table class='grid' border="1"  cellspacing='0' width="50%" align='center' >
<tr>
<%-- <td class='columnheadercenter' NOWRAP width='2%'><fmt:message key="eCA.Code.label" bundle="${ca_labels}"/>
 --%>
<td class='columnheadercenter' NOWRAP width='5%'><fmt:message key="eCA.Position.label" bundle="${ca_labels}"/>
<td class='columnheadercenter' NOWRAP width='2%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/>
<input type="checkbox" id="allChecked" name="allChecked" id="allChecked" onClick="selectAll(this);" /></td>
</tr> 	
<%
	for(int i=fm_disp; i<=to_disp; i++){
		
		classValue		=	( (i%2)==0 )? "gridData" : "gridData";
		java.sql.Date fromDate = null;
		java.sql.Date toDate = null;
		hMapRecords 	= (java.util.HashMap)accRightForResRecSet.getObject(i);
		position_code		=	(String)	hMapRecords.get("position_code");
		position_desc		=	(String)	hMapRecords.get("position_desc");
		positionIU		=	(String)	hMapRecords.get("positionIU");
		position_restr_yn		=	(String)	hMapRecords.get("position_restr_yn");
		pract_type1		=	(String)	hMapRecords.get("pract_type1");
		if(position_restr_yn.equals("Y"))
		{
			chk_count++;
		} 
	%>
<tr>
<td class='gridData'><%=position_desc%></td>
<input type="hidden" id="position_code<%=i%>" name="position_code<%=i%>" value="<%=position_code%>">
<input type="hidden" id="position_desc<%=i%>" name="position_desc<%=i%>" value="<%=position_desc%>">
<input type="hidden" id="positionIU<%=i%>" name="positionIU<%=i%>" value="<%=positionIU%>">
<input type="hidden" id="pract_type1<%=i%>" name="pract_type1<%=i%>" value="<%=pract_type1%>">

<td class='gridData'>
<input type="checkbox" id="position_restr_yn<%=i%>" name="position_restr_yn<%=i%>" onClick="selectChkBox(this,<%=i%>)" value="<%=position_restr_yn%>" <%if("Y".equals(position_restr_yn)){%> checked <%}%>/>
</td>
		<input type='hidden' id='checkallDateEnable' name='checkallDateEnable' id='checkallDateEnable' value="<%=i%>">	

</tr>
<%
	}
}
catch(Exception e)
{
		e.printStackTrace();
}
finally
{		
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>	
 </table>
 <input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> > 
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value="<%=to%>">
	<input type='hidden' name='row_count' id='row_count' id='row_count' value="<%=row_count%>">
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type="hidden" name="optionValStr" id="optionValStr" value=""/>
	<input type='hidden' name='fromStart' id='fromStart' value='<%=start%>'></input>
	<input type='hidden' name='chk_count' id='chk_count' id='chk_count' value="<%=chk_count%>"> 
    
</form>
<script>
var checkallDateEnable=document.getElementsByName("checkallDateEnable").length;
var chk_count=parseInt(document.getElementById("chk_count").value);
if((checkallDateEnable == chk_count) && (!checkallDateEnable==0 && !chk_count==0))
document.forms[0].allChecked.checked = true;  
</script>
</body>
</html>

