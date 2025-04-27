<!DOCTYPE html>

<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>                                 
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eOT.*,eOT.Common.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager," %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>


<html>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eOT/js/Booking.js' language='javascript'></script>
<script src='../../eOA/js/oamessages.js' language='javascript'></script>
<script src='../../eOT/js/InteractiveOperRegQuery.js' language='javascript'></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
           
<script src='../../eXH/js/showModalDialog.js' language='JavaScript'></script>

  <head>
  		<style>
		 TD.OTMENULAYER
		  {
	 	  FONT-FAMILY: VERDANA ;
	 	  FONT-SIZE: 10PT ;
	 	  BACKGROUND-COLOR: #D8BFD8;
	 	  COLOR: WHITE;
		}
		TD.OTMENU
		  {
			BACKGROUND-COLOR: #C0C0C0 ;
			FONT-SIZE: 9PT ;
			BORDER-STYLE: DASHED;
			BORDER-LEFT-COLOR: #FFA500;
			BORDER-RIGHT-COLOR: #FFA500;
			BORDER-TOP-COLOR: #FFFACD;
			BORDER-BOTTOM-COLOR: #FFFACD;
		  }
		TD.OTCLASS{
			FONT-SIZE: 9pt ;
			BORDER-STYLE: SOLID;
			border-left-color: #B2B6D7;
			border-right-color: #B2B6D7;
			border-top-color: #E2E3F0;
			border-bottom-color: #E2E3F0;
			height:18;	
			   }
.menu {text-align:left;position:absolute;width:'1300px'}
</style>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript'>
function scrollTitle()
{
var tab1=document.getElementById("headerTable");
var y = document.body.scrollTop;
tab1.style.top=y;
}


function assign()
{
var tab1=document.getElementById("headerTable");
tab1.style.top=0;
tab1.style.left=0;
}
</script>  
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!--Added against MMS-QH-CRF-0199 -->
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name='pendingOrderDtlForm' id='pendingOrderDtlForm' action='' method = 'post'>


<%	
String maxPixel="1810px";
%>

<table  border='1' width='<%=maxPixel%>' cellpadding=3 cellspacing=0>
<tr style="position: sticky; top: 0; background-color: white; z-index: 1;">
<th class='columnHeader' nowrap><fmt:message key="Common.patient.label" bundle="${common_labels}"/></th>
<th class='columnHeader' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
<th class='columnHeader' nowrap><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></th>
<th class='columnHeader' nowrap><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></th>
<th class='columnHeader' nowrap><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/></th> 
<th class='columnHeader' nowrap><fmt:message key="Common.operation.label" bundle="${common_labels}"/></th>
<th class='columnHeader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
<th class='columnHeader' nowrap><fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/></th>
<th class='columnHeader' nowrap><fmt:message key="eOT.OperationNo.Label" bundle="${ot_labels}"/></th>
<th class='columnHeader' nowrap><fmt:message key="eOT.OperationDate.Label" bundle="${ot_labels}"/></th>
<th class='columnHeader' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
</tr>
<%
/*	out.println("<BR>");		
	out.println("<BR>");		
	out.println("<BR>");		*/
	String facility_id=CommonBean.checkForNull(request.getParameter("facility_id"));
	String theatre=CommonBean.checkForNull(request.getParameter("theatre"));
	String speciality_code=CommonBean.checkForNull(request.getParameter("speciality_code"));
	String surgeon_code=CommonBean.checkForNull(request.getParameter("surgeon_code"));
	String
	anaesthetist_code=CommonBean.checkForNull(request.getParameter("anaesthetist_code"));
	String nurse_code=CommonBean.checkForNull(request.getParameter("nurse_code"));
	String oper_code=CommonBean.checkForNull(request.getParameter("oper_code"));
	String anaesthesia_code=CommonBean.checkForNull(request.getParameter("anaesthesia_code"));
	String implant_code=CommonBean.checkForNull(request.getParameter("implant_code"));
	String from_date=CommonBean.checkForNull(request.getParameter("from_date"));
	String to_date=CommonBean.checkForNull(request.getParameter("to_date"));
	String status=CommonBean.checkForNull(request.getParameter("status"));
	String orderby=CommonBean.checkForNull(request.getParameter("orderby"));
	String patient_id=CommonBean.checkForNull(request.getParameter("patient_id"));
	String source_code=CommonBean.checkForNull(request.getParameter("source_code"));
	String patient_id1="";
	String patient_anme1="";
	String sex1="";
	String dob1="";
	String theatre_desc1="";
	String speciality_desc1="";
	String surgeon_name1="";
	String anaesthetist_name1="";
	String oper_no1="";
	String oper_date1="";
	String status_desc1="";
	//String oper_code1="";
	String oper_desc1="";

	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rs1=null;

	
	String sql="";
	String sql1="";
	String whereClause="";

	String strMenu="";
	String strMenuItem="";
	String strQuery="";
	String strParameter="";
	String strTempOperation="";
	String flag="OPER_REG";

	int fetchCount=0;

try
{
	conn = ConnectionManager.getConnection(request);
	int index=1;
// modified Nursing unit to ref_source_code on 12/10

//	sql="SELECT PATIENT_ID, (SELECT DECODE( ? ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID ) PATIENT_NAME1, SEX, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH , THEATRE_DESC,OPER_CODE,OPER_DESC,SPECIALITY_DESC, SURGEON_NAME, ANAESTHETIST_NAME,OPER_NUM, TO_CHAR(OPER_DATE,'DD/MM/YYYY') OPER_DATE , STATUS_DESC FROM OT_POST_OPER_DETAILS_VW A WHERE OPERATING_FACILITY_ID	=? AND A.PATIENT_ID = NVL(?,A.PATIENT_ID) AND NVL(NURSING_UNIT_CODE,'~') = NVL(?,NVL(NURSING_UNIT_CODE,'~')) AND OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),SYSDATE) AND ((? = '*ALL')	OR (THEATRE_CODE = ? )) AND ((? = '*ALL') OR (OPER_STATUS = ? )) ";
//Modified by rajesh on behalf of SCF-1744

//	sql="SELECT PATIENT_ID, (SELECT DECODE( ? ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID ) PATIENT_NAME1, SEX, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH , THEATRE_DESC,OPER_CODE,OPER_DESC,SPECIALITY_DESC, SURGEON_NAME, ANAESTHETIST_NAME,OPER_NUM, TO_CHAR(OPER_DATE,'DD/MM/YYYY') OPER_DATE , STATUS_DESC FROM OT_POST_OPER_DETAILS_VW A WHERE OPERATING_FACILITY_ID	=? AND A.PATIENT_ID = NVL(?,A.PATIENT_ID) AND REF_SOURCE_CODE = NVL (?, REF_SOURCE_CODE) AND OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),SYSDATE) AND ((? = '*ALL')	OR (THEATRE_CODE = ? )) AND ((? = '*ALL') OR (OPER_STATUS = ? )) ";
	//Commented against MMS-QH-CRF-0199
	/*sql="SELECT PATIENT_ID, (SELECT DECODE( ? ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID ) PATIENT_NAME1, SEX, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH , THEATRE_DESC,OPER_CODE,OPER_DESC,SPECIALITY_DESC, SURGEON_NAME, ANAESTHETIST_NAME,OPER_NUM, TO_CHAR(OPER_DATE,'DD/MM/YYYY') OPER_DATE , STATUS_DESC FROM OT_POST_OPER_DETAILS_VW A WHERE OPERATING_FACILITY_ID	=? AND A.LANGUAGE_ID='"+locale+"' AND A.PATIENT_ID = NVL(?,A.PATIENT_ID) AND REF_SOURCE_CODE = NVL (?, REF_SOURCE_CODE) AND OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),SYSDATE) AND ((? = '*ALL')	OR (THEATRE_CODE = ? )) AND ((? = '*ALL') OR (OPER_STATUS = ? )) ";*/
	//Modified against MMS-QH-CRF-0199
	sql="SELECT PATIENT_ID, (SELECT DECODE( ? ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID ) PATIENT_NAME1, SEX, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH , THEATRE_DESC,A.OPER_CODE,C.LONG_DESC OPER_DESC,SPECIALITY_DESC, SURGEON_NAME, ANAESTHETIST_NAME,OPER_NUM, TO_CHAR(OPER_DATE,'DD/MM/YYYY') OPER_DATE , STATUS_DESC FROM OT_POST_OPER_DETAILS_VW A,OT_OPER_MAST_LANG_VW C WHERE OPERATING_FACILITY_ID	=? AND A.LANGUAGE_ID='"+locale+"' AND A.PATIENT_ID = NVL(?,A.PATIENT_ID) AND REF_SOURCE_CODE = NVL (?, REF_SOURCE_CODE) AND OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),SYSDATE) AND ((? = '*ALL')	OR (THEATRE_CODE = ? )) AND ((? = '*ALL') OR (OPER_STATUS = ? )) AND A.language_id = C.language_id AND A.OPER_CODE= C.OPER_CODE ";

	if(!speciality_code.equals(""))
		whereClause=whereClause+" AND INSTR(ALL_SPECIALITY_CODES,'#'||?||'#') > 0 ";
	if(!surgeon_code.equals(""))
		whereClause=whereClause+" AND (SURGEON_CODE= ? OR (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND A.OPER_NUM = B.OPER_NUM	AND B.ROLE_TYPE	IN ('OS','AS')	AND B.PRACTITIONER_ID = ? )) ";
	if(!anaesthetist_code.equals(""))
		whereClause=whereClause+" AND (ANESTHETIST_CODE= ? OR (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND	 A.OPER_NUM	= B.OPER_NUM AND B.ROLE_TYPE IN ('MA','AA')	AND B.PRACTITIONER_ID =? )) ";
	if(!nurse_code.equals(""))
		whereClause=whereClause+" AND (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID 	= B.OPERATING_FACILITY_ID	AND A.OPER_NUM = B.OPER_NUM	AND B.ROLE_TYPE	IN ('NS')AND B.PRACTITIONER_ID = ? ) ";
	if(!oper_code.equals(""))
		whereClause=whereClause+" AND ? IN (SELECT OPER_CODE FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID 	= A.OPERATING_FACILITY_ID AND  OPER_NUM	= A.OPER_NUM) ";

	if(!anaesthesia_code.equals(""))
		whereClause=whereClause+" AND ANESTHESIA_CODE	= ? ";

	if(!implant_code.equals(""))
		whereClause=whereClause+" AND (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_SURGICAL_ACCESSORIES B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND	 A.OPER_NUM	= B.OPER_NUM AND B.ACCESSORY_TYPE = 'S'	AND B.ACCESSORY_CODE = ? ) ";
	
/*
old code, modified by bshankar to keep the bind variables
	if(!speciality_code.equals(""))
		whereClause=whereClause+" AND INSTR(ALL_SPECIALITY_CODES,'#'||'"+speciality_code+"'||'#') > 0 ";
	if(!surgeon_code.equals(""))
		whereClause=whereClause+" AND (SURGEON_CODE= '"+surgeon_code+"' OR (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND A.OPER_NUM = B.OPER_NUM	AND B.ROLE_TYPE	IN ('OS','AS')	AND B.PRACTITIONER_ID = '"+surgeon_code+"' )) ";
	if(!anaesthetist_code.equals(""))
		whereClause=whereClause+" AND (ANESTHETIST_CODE= '"+anaesthetist_code+"' OR (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND	 A.OPER_NUM	= B.OPER_NUM AND B.ROLE_TYPE IN ('MA','AA')	AND B.PRACTITIONER_ID ='"+anaesthetist_code+"' )) ";
	if(!nurse_code.equals(""))
		whereClause=whereClause+" AND (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID 	= B.OPERATING_FACILITY_ID	AND A.OPER_NUM = B.OPER_NUM	AND B.ROLE_TYPE	IN ('NS')AND B.PRACTITIONER_ID = '"+nurse_code+"' ) ";
	if(!oper_code.equals(""))
		whereClause=whereClause+" AND '"+oper_code+"' IN (SELECT OPER_CODE FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID 	= A.OPERATING_FACILITY_ID AND  OPER_NUM	= A.OPER_NUM) ";

	if(!anaesthesia_code.equals(""))
		whereClause=whereClause+" AND ANESTHESIA_CODE	= '"+anaesthesia_code+"' ";
	if(!implant_code.equals(""))
		whereClause=whereClause+" AND (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_SURGICAL_ACCESSORIES B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND	 A.OPER_NUM	= B.OPER_NUM AND B.ACCESSORY_TYPE = 'S'	AND B.ACCESSORY_CODE = '"+implant_code+"' ) ";
*/
	switch(orderby.charAt(0))
	{
		case '1':whereClause=whereClause+" order by PATIENT_NAME";break;
		case '2':whereClause=whereClause+" order by PATIENT_ID";break;
		case '3':whereClause=whereClause+" order by THEATRE_DESC";break;
		case '4':whereClause=whereClause+" order by SURGEON_NAME";break;
		case '5':whereClause=whereClause+" order by ANAESTHETIST_NAME";break;
		case '6':whereClause=whereClause+" order by SPECIALITY_DESC";break;
		case '7':whereClause=whereClause+" order by OPER_NUM";break;
		case '8':whereClause=whereClause+" order by OPER_DATE";break;
		case '9':whereClause=whereClause+" order by STATUS_DESC";break;
		
	}
	sql=sql+whereClause;
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(index++,locale);
	pstmt.setString(index++,facility_id);
	pstmt.setString(index++,patient_id);
	pstmt.setString(index++,source_code);
	pstmt.setString(index++,from_date);
	pstmt.setString(index++,to_date);
	pstmt.setString(index++,theatre);
	pstmt.setString(index++,theatre);
	pstmt.setString(index++,status);
	pstmt.setString(index++,status);
	if(!speciality_code.equals("")){
		pstmt.setString(index++,speciality_code);
	}
	if(!surgeon_code.equals("")){
		pstmt.setString(index++,surgeon_code);
		pstmt.setString(index++,surgeon_code);
	}
	if(!anaesthetist_code.equals("")){
		pstmt.setString(index++,anaesthetist_code);
		pstmt.setString(index++,anaesthetist_code);
	}
	if(!nurse_code.equals("")){
		pstmt.setString(index++,nurse_code);
	}

	if(!oper_code.equals("")){
		pstmt.setString(index++,oper_code);
	}
	if(!anaesthesia_code.equals(""))
		pstmt.setString(index++,anaesthesia_code);

	if(!implant_code.equals("")){
		pstmt.setString(index++,implant_code);
	}
	rs=pstmt.executeQuery();
	System.err.println(" SQl : "+sql);
	while(rs.next())
	{
		fetchCount++;
	
		patient_id1=CommonBean.checkForNull(rs.getString("PATIENT_ID"));
		patient_anme1=CommonBean.checkForNull(rs.getString("PATIENT_NAME1"));
		sex1=CommonBean.checkForNull(rs.getString("SEX"));   	
		//dob1=CommonBean.checkForNull(rs.getString("DATE_OF_BIRTH"));	
		dob1=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH"),"DMY","en",locale));
		//preferedDate=com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMY","en",locale);
		theatre_desc1=CommonBean.checkForNull(rs.getString("THEATRE_DESC"));
		speciality_desc1=CommonBean.checkForNull(rs.getString("SPECIALITY_DESC"));
		//oper_desc1=CommonBean.checkForNull(rs.getString("OPER_DESC"));
		surgeon_name1=CommonBean.checkForNull(rs.getString("SURGEON_NAME"));
		anaesthetist_name1=CommonBean.checkForNull(rs.getString("ANAESTHETIST_NAME"));
		oper_no1=CommonBean.checkForNull(rs.getString("OPER_NUM"));
		//oper_date1=CommonBean.checkForNull(rs.getString("OPER_DATE"));
		oper_date1=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("OPER_DATE"),"DMY","en",locale));
		status_desc1=CommonBean.checkForNull(rs.getString("STATUS_DESC"));
		//oper_code1=CommonBean.checkForNull(rs.getString("OPER_CODE"));
		oper_desc1=CommonBean.checkForNull(rs.getString("OPER_DESC"));
		//Commented against MMS-QH-CRF-0199
		/*sql1="SELECT B.SHORT_DESC OPER_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"' AND A.OPER_NUM = '"+oper_no1+"' AND A.OPER_CODE = B.OPER_CODE ORDER BY 1 ";*/	
		//Added against MMS-QH-CRF-0199
		sql1="SELECT B.LONG_DESC OPER_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"' AND A.OPER_NUM = '"+oper_no1+"' AND A.OPER_CODE = B.OPER_CODE ORDER BY 1 ";
		pstmt1=conn.prepareStatement(sql1);
		rs1=pstmt1.executeQuery();

		//strTempOperation="Operations/Procedures,";
		strTempOperation=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")+",";

		while(rs1.next())
		{
			strTempOperation=strTempOperation+rs1.getString(1)+",";
		}		
		if(rs1!=null)		rs1.close();
		if(pstmt1!=null)		pstmt1.close();

		//strMenu="Patient History"+","+"Surgery History"+","+"Patient Demographics";
		strMenu=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientHistory.label","common_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SurgeryHistory.Label","ot_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PatientDemographics.Label","ot_labels");
		
		strMenuItem="PH"+","+"SH"+","+"PDD";
		strParameter=oper_no1+"::"+facility_id+"::"+patient_id1+"::"+patient_anme1+"::"+sex1+"::"+dob1+"::"+flag;
		if(fetchCount%2==0)	strQuery="class='gridData'";
		else		strQuery="class='gridData'";
		out.println("<tr>");
		//out.println("<td width='220' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"DisplayTooltipForOperRegQry('"+strMenuItem+"','"+strMenu+"','"+strParameter+"',this,'imgArrow"+fetchCount+"');\" width='200'  onMouseOver='hideToolTip();'>"+patient_anme1+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");
		out.println("<td width='220' nowrap id='orderctl" + fetchCount + "' style='cursor:pointer' class='gridDataBlue' onClick=\"DisplayTooltipForOperRegQry('" + strMenuItem + "','" + strMenu + "','" + strParameter + "',this,'imgArrow" + fetchCount + "');\"  width='200'  onMouseOver='hideToolTip();'>"
	+"<a href='javascript:void(0);' style='color: blue; text-decoration: underline;'>"
    + patient_anme1+"</a>"
    + "<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow" + fetchCount + "'></a></td>");

		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+sex1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+dob1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+theatre_desc1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+speciality_desc1+"</td>");

		out.println("<input type='hidden' name='reason"+fetchCount+"' id='reason"+fetchCount+"' value=\""+strTempOperation+"\" >"); 
       //Modified against MMS-QH-CRF-0199
		out.println("<td "+strQuery+" class='"+strQuery+"' ><img src='../../eOT/images/drugInfo.gif' OnMouseOver=\"Tip(reasonToolTip('reason',"+fetchCount+"),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\"  onMouseOut='UnTip();'>"+oper_desc1+"</font></td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+surgeon_name1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+anaesthetist_name1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+oper_no1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left' nowrap>"+oper_date1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left' nowrap >&nbsp;"+status_desc1+"</td>");
		out.println("</tr>");
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(fetchCount==0)
	 out.println("<script>callNoRecord();</script>");
}catch(Exception ee)
{
	ee.printStackTrace();
	System.err.println("Exception264="+ee);
}
finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(conn,request);
}
%>
 </table>
 <input type='hidden' name='locale' id='locale' value="<%=locale%>">
 <input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
 <input type='hidden' name='oper_num' id='oper_num' value="<%=oper_no1%>">
 </form>
 	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'>	
	</div>
</html>

