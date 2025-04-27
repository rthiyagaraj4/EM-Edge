<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,eCommon.XSSRequestWrapper"     contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../../eAE/js/AESecondaryTriage.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script> 

<%
 

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' onKeyDown = 'lockKey()'>");
	  Connection con = null;

      PreparedStatement pstmt1=null;
      ResultSet rs=null;
      int i=0;
		String open_to_all_pract_yn = "";
		String open_to_all_prac_for_clinic_yn = "";
		String clinic_code = "";
		String clinic_type = ""; 
		String clinic_desc = "";
		String treatment_area_code = "";
		String treatment_area_desc = "";
		String queue_status = "";	
		String queue_date	=	"";
		String rec_date_time="";
		String modified_by_id = "";
		String treatment_area_desc1 ="";
		String fbc_yn ="";

       	request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
	    String locale			= (String)session.getAttribute("LOCALE");


		String patient_id	 = checkForNull(request.getParameter("patient_id"));
		String facility_id	 =(String)session.getValue("facility_id");
		String encounter_id	 = checkForNull(request.getParameter("encounter_id"));
		String priority_zone = checkForNull(request.getParameter("priority_zone"));
		String brought_dead	 = request.getParameter("brought_dead")==null?"N":request.getParameter("brought_dead");
		String bed_no= checkForNull(request.getParameter("bed_no"));
		String called_from_ca  =    request.getParameter("called_from_ca");
    	queue_date			   =	checkForNull(request.getParameter("queue_date"));	
	//	disaster_yn			   =    checkForNull(request.getParameter("disaster_yn"));
		open_to_all_pract_yn   =    checkForNull(request.getParameter("open_to_all_pract_yn"));
        open_to_all_prac_for_clinic_yn = checkForNull(request.getParameter("open_to_all_prac_for_clinic_yn"));
		clinic_code          = checkForNull(request.getParameter("clinic_code"));
        clinic_type          = checkForNull(request.getParameter("clinic_type"));
		clinic_desc          = checkForNull(request.getParameter("clinic_desc"));
		treatment_area_code  = checkForNull(request.getParameter("treatment_area_code"));
		treatment_area_desc  = checkForNull(request.getParameter("treatment_area_desc"));
        treatment_area_desc1 = checkForNull(request.getParameter("treatment_area_desc"));
		queue_status         = checkForNull(request.getParameter("queue_status"));
		bed_no				 = checkForNull(request.getParameter("bed_no"));
		/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
		String called_from	= checkForNull(request.getParameter("called_from"));
		String RepDb		= checkForNull(request.getParameter("RepDb"));
		String page_name = checkForNull(request.getParameter("page_name"));//Added by santhosh for ML-MMOH-SCF-2384
		if(called_from.equals("CDR"))
			facility_id	= checkForNull(request.getParameter("facility_id"));
		/*End*/

		try
		{
	       	 con = webbeans.eCommon.ConnectionManager.getConnection(request);
  %>
<form>
<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 150; top: 62">
</div>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<tr><th align='left'><fmt:message key="eAE.RecordedDetails.label" bundle="${ae_labels}"/></th></tr>
<% 
String classValue = "" ;
int countRec =0;
StringBuffer strsql = new StringBuffer();

strsql.append("SELECT   to_char(RECORDED_DATE,'dd/mm/yyyy hh24:mi:ss')  recorded_date,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC ##REPDB##( facility_id,CLINIC_CODE,TREATMENT_AREA_CODE,'"+locale+"','2') TREATMENT_AREA_DESC,FBC_YN, MODIFIED_BY_ID FROM AE_PAT_EMERGENCY_DETAIL ##REPDB## where  facility_id = ? AND  encounter_id=? order by RECORDED_DATE DESC");//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1

/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
String sqlFinal = strsql.toString();
sqlFinal = sqlFinal.replaceAll("##REPDB##",RepDb);
/*End*/

pstmt1 = con.prepareStatement(sqlFinal,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
pstmt1.setString	(1,	facility_id);
pstmt1.setLong		(2,	Long.parseLong(encounter_id));

rs = pstmt1.executeQuery();
if(rs != null)
	    {
	          rs.last();
	          countRec = rs.getRow();
              rs.beforeFirst();
	    }
while ( rs.next()  )
{
	if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
	else
		classValue = "QRYODD" ;
 
  	rec_date_time = checkForNull(rs.getString("RECORDED_DATE"));
	treatment_area_desc = checkForNull(rs.getString("TREATMENT_AREA_DESC"));
	String record_date=rs.getString("RECORDED_DATE")==null?"": rs.getString("RECORDED_DATE");
	record_date=DateUtils.convertDate(record_date,"DMYHMS","en",locale);

	if (treatment_area_desc.equals("")){
		treatment_area_desc= treatment_area_desc1;
	}
	modified_by_id = checkForNull(rs.getString("MODIFIED_BY_ID"));
	fbc_yn = checkForNull(rs.getString("FBC_YN"));
	%>
	<tr ><td class='<%=classValue%>' id=tddata<%=i%>>
	<%
	out.println("<a  onMouseover='javascript:onMMove(msg,event,\""+java.net.URLEncoder.encode(treatment_area_desc)+"\",\""+java.net.URLEncoder.encode(modified_by_id)+"\");'  onMouseout='javascript:onMOut(msg);' href='javascript:loadJsp(\""+java.net.URLEncoder.encode(encounter_id)+"\",\""+java.net.URLEncoder.encode(rec_date_time)+"\",\""+i+"\",\""+countRec+"\",\""+called_from+"\");'>");
	out.println(record_date);
	out.println("</a></td></tr>");
	i++;
}
if (rs != null)	rs.close();
if (pstmt1 != null)	pstmt1.close();
if((strsql != null) && (strsql.length() > 0))
{
	strsql.delete(0,strsql.length());
}
%>
 </tr>
</table>
	    <input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
	    <input type=hidden name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
		<input type=hidden name='treatment_area_code' id='treatment_area_code' value="<%=treatment_area_code%>">
		<input type=hidden name='treatment_area_desc' id='treatment_area_desc' value="<%=treatment_area_desc%>">
	    <input type=hidden name='clinic_type' id='clinic_type' value="<%=clinic_type%>">
		<input type=hidden name='clinic_code' id='clinic_code' value="<%=clinic_code%>">
		<input type=hidden name='clinic_desc' id='clinic_desc' value="<%=clinic_desc%>">
		<input type=hidden name='priority_zone' id='priority_zone' value="<%=priority_zone%>">
	    <input type=hidden name='bed_no' id='bed_no' value="<%=bed_no%>">
	    <input type=hidden name='called_from_ca' id='called_from_ca' value="<%=called_from_ca%>">
	    <input type=hidden name='queue_date' id='queue_date' value="<%=queue_date%>">
	    <input type=hidden name='brought_dead' id='brought_dead' value="<%=brought_dead%>">
		<input type=hidden name='queue_status' id='queue_status' value="<%=queue_status%>">
		<input type=hidden name='open_to_all_pract_yn' id='open_to_all_pract_yn' value="<%=open_to_all_pract_yn%>">
		<input type=hidden name='fbc_yn' id='fbc_yn' value="<%=fbc_yn%>">
		<input type=hidden name='open_to_all_prac_for_clinic_yn' id='open_to_all_prac_for_clinic_yn' value="<%=open_to_all_prac_for_clinic_yn%>">
		<input type='hidden' name='queryString' id='queryString' value="<%=request.getQueryString()%>">
		<input type='hidden' name='page_name' id='page_name' value="<%=page_name%>">
	
</form>
<% 
  }catch(Exception e) {e.printStackTrace();}
  finally
  {
     webbeans.eCommon.ConnectionManager.returnConnection(con,request);
  }
%>
</BODY>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>
</HTML>

