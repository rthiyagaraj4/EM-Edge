<!DOCTYPE html>


<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*,eCommon.XSSRequestWrapper,eCommon.Common.*"  %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"  %>
<%
String locale = (String)session.getAttribute("LOCALE"); 
request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="javascript" src="../../eOT/js/Hashtable.js"></script>
<script language="javascript" src="../../eOT/js/SurgeonDiaryMaintainSchedule.js"></script>
<script language="javascript" src="../../eOT/js/OTCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		
	 String facility_id =(String) session.getAttribute("facility_id"); 
	 String from = checkForNull(request.getParameter( "from" ) );
     String to =checkForNull(request.getParameter( "to" ) );
	 String surgeon_code =(String) checkForNull(request.getParameter("surgeon_code")); 
	 String from_date =(String) checkForNull(request.getParameter("from_date_hidden")); 
	 String to_date =(String) checkForNull(request.getParameter("to_date_hidden"));
	 String totalSelected= checkForNull(request.getParameter("totalSelected"));
	 StringBuilder sbr = new StringBuilder();		
	 String classValue = "" ;
	 //String args="";
    
  	 int maxRecord = 0;
     int start = 0 ;
     int end = 0 ;
     int i=1;
	 
	String sql1="SELECT A.OPER_ROOM_CODE, A.SPECIALITY_CODE, C.SHORT_DESC SPECIALITY_DESC, TO_CHAR(A.BOOKING_DATE,'DD/MM/YYYY'), TO_CHAR(BOOKING_DATE ,'DAY') BOOKING_DAY, A.TEAM_DOCTOR_CODE, B.SHORT_NAME SURGEON_NAME FROM OT_DIARY_SCHEDULE A, ( SELECT '*ALL'  PRACTITIONER_ID, 'All Surgeon' SHORT_NAME FROM DUAL UNION SELECT  PRACTITIONER_ID CODE ,SHORT_NAME DESCRIIPTION FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID =? ) B,  (SELECT '*ALL' SPECIALITY_CODE, 'All Specialities' SHORT_DESC FROM DUAL UNION SELECT SPECIALITY_CODE,SHORT_DESC FROM AM_SPECIALITY_LANG_VW WHERE LANGUAGE_ID =?) C WHERE A.OPERATING_FACILITY_ID = ? AND A.BOOKING_DATE >= TRUNC(SYSDATE) AND A.TEAM_DOCTOR_CODE = ? AND  TRUNC(A.BOOKING_DATE) >= NVL(TO_DATE(?,'DD/MM/YYYY'), TRUNC(A.BOOKING_DATE)) AND TRUNC(A.BOOKING_DATE) <= NVL(TO_DATE(?,'DD/MM/YYYY'), TRUNC(A.BOOKING_DATE)) AND  A.TEAM_DOCTOR_CODE=B.PRACTITIONER_ID AND A.SPECIALITY_CODE=C.SPECIALITY_CODE ORDER BY A.BOOKING_DATE, A.OPER_ROOM_CODE, A.TEAM_DOCTOR_CODE";
	
	Connection con=ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	
	start = ("".equals(from))?1:Integer.parseInt( from );
	end = ("".equals(from))?14:Integer.parseInt( to );
	try{
		
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,surgeon_code);
		pstmt.setString(5,from_date);
		pstmt.setString(6,to_date);
		rst = pstmt.executeQuery();
       int total=0;
		while(rst.next())
		{
			total++;
		}
		maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
		}

	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Err Msg From SurgeonDiaryMaintainAddModifySchedule.jsp : "+e);
	}finally{
		try{if(pstmt!=null) pstmt.close();
			if(rst!=null)rst.close();
			sbr.setLength(0);
		}catch(Exception e){e.printStackTrace();}
	}
%>

</head>
<body  class='CONTENT' onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SurgeonDiaryMaintainAddModifySchedule" id="SurgeonDiaryMaintainAddModifySchedule">
<P>
<table class='grid' align='right'>
<tr>
<td>
<%

if ( !(start <= 1) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
	
	if ( !( (start+14) > maxRecord ) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");

%>
</td>
</tr>
</table>
<br><br>
</p>
<%@ include file="../../eOT/jsp/SurgeonDiaryMaintainScheduleTitles.jsp"%>
<%

	String sql="SELECT A.OPER_ROOM_CODE, A.SPECIALITY_CODE, C.SHORT_DESC SPECIALITY_DESC, TO_CHAR(A.BOOKING_DATE,'DD/MM/YYYY'), TO_CHAR(BOOKING_DATE ,'DAY') BOOKING_DAY, A.TEAM_DOCTOR_CODE, B.SHORT_NAME SURGEON_NAME FROM OT_DIARY_SCHEDULE A, ( SELECT '*ALL'  PRACTITIONER_ID, 'All Surgeon' SHORT_NAME FROM DUAL UNION SELECT  PRACTITIONER_ID CODE ,SHORT_NAME DESCRIIPTION FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID =? ) B,  (SELECT '*ALL' SPECIALITY_CODE, 'All Specialities' SHORT_DESC FROM DUAL UNION SELECT SPECIALITY_CODE,SHORT_DESC FROM AM_SPECIALITY_LANG_VW WHERE LANGUAGE_ID =?) C WHERE A.OPERATING_FACILITY_ID = ? AND A.BOOKING_DATE >= TRUNC(SYSDATE) AND A.TEAM_DOCTOR_CODE = ? AND  TRUNC(A.BOOKING_DATE) >= NVL(TO_DATE(?,'DD/MM/YYYY'), TRUNC(A.BOOKING_DATE)) AND TRUNC(A.BOOKING_DATE) <= NVL(TO_DATE(?,'DD/MM/YYYY'), TRUNC(A.BOOKING_DATE)) AND  A.TEAM_DOCTOR_CODE=B.PRACTITIONER_ID AND A.SPECIALITY_CODE=C.SPECIALITY_CODE ORDER BY A.BOOKING_DATE, A.OPER_ROOM_CODE, A.TEAM_DOCTOR_CODE";
	String booking_date = "";
	String speciality_code=" ";
	String theatre_code=" ";
	start = ("".equals(from))?1:Integer.parseInt( from );
	end = ("".equals(from))?14:Integer.parseInt( to );
	try{
//		con=ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,surgeon_code);
		pstmt.setString(5,from_date);
		pstmt.setString(6,to_date);
		rst=pstmt.executeQuery();
		int k=start;
		int record_no=start;
	    if ( start != 1 ){    }
		for( int j=1; j<start; i++,j++ )
		rst.next() ;
        //int m=0;
		while(rst.next() && k<=end  ){
		 	classValue = ( k % 2 == 0 )?"gridData":"gridData";
			sbr.append("<tr>");
			theatre_code=checkForNull(rst.getString(1));
			sbr.append("<td class='"+classValue+"' width='15%'>"+theatre_code+"</td>");//Theatre Code
//			sbr.append("<input type='hidden' name='Speciality_code_"+k+" value="+.checkForNull(rst.getString(2))+">");//Speciality Code
			speciality_code=rst.getString(2);
			sbr.append("<td class='"+classValue+"' width='20%'>"+checkForNull(rst.getString(3))+"</td>");//Speciality Desc
			booking_date = com.ehis.util.DateUtils.convertDate(rst.getString(4),"DMY","en",locale);
			sbr.append("<td class='"+classValue+"' width='15%'>"+checkForNull(booking_date)+"</td>");//Booking Date
			sbr.append("<td class='"+classValue+"' width='10%'>"+checkForNull(rst.getString(5))+"</td>");//Booking Day
			sbr.append("<td class='"+classValue+"' width='20%'>"+checkForNull(rst.getString(6))+"</td>");//Surgeon Code
			sbr.append("<td class='"+classValue+"' width='20%'>"+checkForNull(rst.getString(7))+"</td>");//Surgeon Desc
			sbr.append("<td class='"+classValue+"' width='10'><input type='checkbox' name= 'chk_release"+record_no+"' id= 'chk_release"+record_no+"'  booking_date='"+booking_date+"'speciality_code='"+speciality_code+"'theatre_code='"+theatre_code+"' sch_flag='N' onclick='validateCheckBox(this);'></td>");//Delete
			sbr.append("</tr>");
			//args = 	rst.getString(1)+"@@"+rst.getString(2)+"@@"+rst.getString(3)+"@@"+rst.getString(4)+"@@"+rst.getString(5)+"@@"+rst.getString(6)+"@@"+rst.getString(7);
			//out.println("<script>loadDBDtls('"+args+"')</script>");
			if(totalSelected.length()>0){
				String tokens[] = totalSelected.split(",");
				for(int p = 0;p<tokens.length;p++){
					if(Integer.parseInt(tokens[p])==record_no)
						sbr.append("<script>assingListItemValue("+tokens[p]+");</script>");
				}
			}
			k++;
			record_no++;
		}
		if(sbr.length()>0) out.println(sbr.toString());	
	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Err Msg From SurgeonDiaryMaintainAddModifySchedule.jsp : "+e);
	}finally{
		try{if(pstmt!=null) pstmt.close();
			if(rst!=null)rst.close();
			sbr.setLength(0);
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
	}


%> 
</table>
</center>

<input type='hidden' name='facility_id' id='facility_id'  value='<%=facility_id%>'> 
<input type='hidden' name='locale' id='locale' value="<%=locale%>"> 
<input type='hidden' name='surgeon_code' id='surgeon_code' value="<%=surgeon_code%>">
<input type="hidden" name="modified_flag" id="modified_flag" value="false" >
<input type="hidden" name="start" id="start" value="<%=start%>" >
<input type="hidden" name="end" id="end" value="<%=end%>" >
<input type="hidden" name="from_date" id="from_date" value="<%=from_date%>" >
<input type="hidden" name="to_date" id="to_date" value="<%=to_date%>" >
<input type="hidden" name="totalSelected" id="totalSelected" value="<%=totalSelected%>" >


</form> 
</body>
</html>

