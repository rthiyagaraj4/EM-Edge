<!DOCTYPE html>

<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="PatientCareBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/SpltyHomePageLinkRep.js'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onScroll="scrollTitle1()">
<script language=javascript>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>	

<%
	String  patient_id				= "";
	String  module_id				= "";
	String  check				= "";
	String  cycle_no				= "";
	String  keyRef				= "";
    String  hist_rec_type			= "";
	String  event_date_str			= "";
    String  event_date_str_prev		= "";
    String  event_group_desc		= "";
    String  event_group_desc_prev	= "";
    String  event_time_str			= "";
    String  event_desc				= "";
    String  result_num				= "";
    String  result_num_uom			= "";
    String  normalcy_str			= "";
	String  normalcy				= "";
    String  normal_low_value_str	= "";
    String  normal_high_value_str	= "";
    String  result_str				= "";
    String  hist_data_type			= "";
    String  hist_data_exists		= "";
	String  ret_str					= "";
	String  temp					= "";
	String  flag					= "";
    String return_format			= "";
	String strsql1					= "";
	String contr_sys_id					= "";
	String event_datetime_str					= "";
	String contr_sys_event_code					= "";
	String accession_num					= "";
	int count=0;
	
	Clob  hist_data	 = null;

	StringBuffer textFormat		=	new StringBuffer("");
	StringBuffer displaydata	=	new StringBuffer();
	
	int k=0;

	return_format		=	(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
    flag				=	(request.getParameter("flag")==null)?"":request.getParameter("flag");
	patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
	hist_rec_type		=	(request.getParameter("hist_rec_type")==null)	?	""	:	request.getParameter("hist_rec_type");	
	module_id		=	(request.getParameter("module_id")==null)	?	""	:	request.getParameter("module_id");	
	cycle_no		=	(request.getParameter("cycle_no")==null)	?	""	:	request.getParameter("cycle_no");	
	keyRef		=	(request.getParameter("keyRef")==null)	?	""	:	request.getParameter("keyRef");	
	check		=	(request.getParameter("check")==null)	?	""	:	request.getParameter("check");	




	
	if(!flag.equals("f"));
	    ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"); 
    
	ret_str=ret_str.substring(1,ret_str.length());

	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	%>
		<form name="RecClinicalNotesLinkMedSelectedTextForm" id="RecClinicalNotesLinkMedSelectedTextForm">
		<div id='divDataTitle' style='postion:relative'>
	<%
		if(!ret_str.equals(""))
		{
			%>
			<table border="1" id="finalDiv1"  cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td class='columnheader'  width="20%" style="font-size:10"><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width="25%" style="font-size:10"><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
				<td class='columnheader'  width="55%" style="font-size:10"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
			</tr>
			</table>
			<%
		}
	%>
	</div>
	<div id='inhtml'>

	<table border="1" id="finalDiv"  cellpadding="3" cellspacing="0" width="100%">
	<%
		try
		{
			if(!flag.equals("f"))
			{
			if(ret_str!=null || (!ret_str.equals(" ")))
			{
				StringTokenizer strtCodes = new StringTokenizer(ret_str,",");
				
				con =  ConnectionManager.getConnection(request);
				
				//strsql1="SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.LONG_DESC EVENT_GROUP_DESC,C.EVENT_GROUP,B.LONG_DESC EVENT_DESC, B.EVENT_CODE, A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT DECODE(A.NORMALCY_IND,HIGH_STR,'ABNORMAL',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,A.FACILITY_ID,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B ,CR_CLIN_EVENT_GROUP C WHERE B.HIST_REC_TYPE=A.HIST_REC_TYPE AND B.EVENT_CODE=A.EVENT_CODE and  B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  AND C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND C.EVENT_GROUP(+)=A.EVENT_GROUP AND A.PATIENT_ID=? AND A.HIST_REC_TYPE =? AND A.ROWID=? ORDER BY a.REQUEST_NUM_SEQ,5,7,6,9,8,3 ";				
				strsql1="SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,CONTR_SYS_ID,CONTR_SYS_EVENT_CODE,C.LONG_DESC EVENT_GROUP_DESC,C.EVENT_GROUP,B.LONG_DESC EVENT_DESC, B.EVENT_CODE, A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT A.NORMALCY_IND FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,A.FACILITY_ID,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM 	CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B ,CR_CLIN_EVENT_GROUP C WHERE 	B.HIST_REC_TYPE=A.HIST_REC_TYPE AND 	B.EVENT_CODE=A.EVENT_CODE and B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  AND 	C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE 	AND 	C.EVENT_GROUP(+)=A.EVENT_GROUP 	AND 	A.PATIENT_ID=? 	AND 	A.HIST_REC_TYPE =? 	AND 	A.ROWID=? 	ORDER BY a.REQUEST_NUM_SEQ,5,7,6,9,8,3";
				stmt = con.prepareStatement(strsql1);

				String formet	=	"";

				count=0;
				while(strtCodes.hasMoreTokens())
				{
					
					if(strtCodes.hasMoreElements())
						temp= (String) strtCodes.nextToken();
					count++;
			
					stmt.setString(1,patient_id);
					stmt.setString(2,hist_rec_type);
					stmt.setString(3,temp);
					rs = stmt.executeQuery();
					
					while(rs!=null && rs.next())
					{
						 event_date_str			=		rs.getString("EVENT_DATE_STR")==null?"":rs.getString("EVENT_DATE_STR");
						 event_datetime_str			=		rs.getString("EVENT_DATETIME_STR")==null?"":rs.getString("EVENT_DATETIME_STR");
						 event_group_desc		=		rs.getString("EVENT_GROUP_DESC")==null?"":rs.getString("EVENT_GROUP_DESC");
						 event_time_str			=		rs.getString("EVENT_TIME_STR")==null?"":rs.getString("EVENT_TIME_STR");
						 event_desc				=		rs.getString("EVENT_DESC")==null?"":rs.getString("EVENT_DESC");
						 result_num				=		rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM");
						 result_num_uom			=		rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
					     //normalcy_str			=		rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
						 normalcy				=		rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
						 hist_data_type			=		rs.getString("HIST_DATA_TYPE")==null?"":rs.getString("HIST_DATA_TYPE");
						 normal_low_value_str	=		rs.getString("normal_low_value_str")==null?"0":rs.getString("normal_low_value_str");
						 normal_high_value_str	=		rs.getString("normal_high_value_str")==null?"0":rs.getString("normal_high_value_str");		
						 result_str				=		rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
						 hist_data				=		rs.getClob("HIST_DATA");
						 hist_data_exists		=		rs.getString("HIST_DATA_EXISTS")==null?"":rs.getString("HIST_DATA_EXISTS");

						contr_sys_id=rs.getString("CONTR_SYS_ID")==null?"":rs.getString("CONTR_SYS_ID");
						contr_sys_event_code=rs.getString("CONTR_SYS_EVENT_CODE")==null?"":rs.getString("CONTR_SYS_EVENT_CODE");
						accession_num=rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
						%>

						<input type="hidden" name="event_datetime_str<%=count%>" id="event_datetime_str<%=count%>" value="<%=event_datetime_str%>"> 
						<input type="hidden" name="contr_sys_id<%=count%>" id="contr_sys_id<%=count%>" value="<%=contr_sys_id%>"> 
						<input type="hidden" name="contr_sys_event_code<%=count%>" id="contr_sys_event_code<%=count%>" value="<%=contr_sys_event_code%>"> 
						<input type="hidden" name="accession_num<%=count%>" id="accession_num<%=count%>" value="<%=accession_num%>"> 
						
						<%




						 //
							if  (normalcy.equals("HIGH_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");										
							else if(normalcy.equals("LOW_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");
							else if(normalcy.equals("ABN_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");
							else if(normalcy.equals("CRIT_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
							else if(normalcy.equals("CRIT_HIGH_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
							else if(normalcy.equals("CRIT_LOW_STR"))
								normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
						 //
						 int normal_low_value=(int)Float.parseFloat(normal_low_value_str);
						 normal_low_value_str=String.valueOf(normal_low_value);
						 int normal_high_value=(int)Float.parseFloat(normal_high_value_str);
						 normal_high_value_str=String.valueOf(normal_high_value);
		 
						 displaydata.setLength(0);
						
						 if(hist_data!=null)
						 {
							java.io.BufferedReader r = new java.io.BufferedReader(hist_data.getCharacterStream());
							String line = null;
					
							while((line=r.readLine()) != null) 
							{
								displaydata.append(line+"\n");
							}
						 }
			
						 formet = "";
		
						if(return_format.equals("TEXT"))
							formet="\n";
						else
							formet="<br>";
		
						textFormat.append(formet);

						if(!event_date_str_prev.equals(event_date_str))
						{
							textFormat.append(event_date_str);
							textFormat.append(formet);
							%>
								<tr>
			                    <td  class='CAHIGHERLEVELCOLOR' width="20%">
									<font size=2><%=event_date_str%></font>
								</td>
								<td  class=CAHIGHERLEVELCOLOR width="25%">&nbsp;</td>	
								<td class=CAHIGHERLEVELCOLOR width="55%" >&nbsp;</td>	
								</tr>           
							<%
							
							event_group_desc_prev="";
						}

						if(!event_group_desc_prev.equals(event_group_desc))
						{
							if(return_format.equals("TEXT"))
						    {	
								textFormat.append("             "+event_group_desc);
								textFormat.append(formet);
							}
							else
							{	
								textFormat.append("                 "+event_group_desc);
								textFormat.append(formet);	
							}
							%>	
				
							<tr>
							<td   class=CAGROUP>&nbsp;</td>	
							<td   class=CAGROUP  >
								<font size=2><%=event_group_desc%></font>
							</td>
							<td   class=CAGROUP>&nbsp;</td> 
							</tr>
							<%
						}
						%>
						<tr>	
						<%
							if(return_format.equals("TEXT"))
								textFormat.append("              "+event_time_str+"                 "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");				                   			   		
							else
								textFormat.append("   "+event_time_str+"                           "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");
						%>
						<td  class='<%=(hist_data_type.equals("HTM")?"OAYELLOW":"CAFOURTHLEVELCOLOR")%>' >
						<font size=2><%=event_time_str%></font></td><td  class=CAFOURTHLEVELCOLOR ><font size=2><%=event_desc%></font></td>
						<td   class=CAFOURTHLEVELCOLOR><font size=2>
				    <%

					if (hist_data_type.equals("NUM"))
					{
						%>
							<%=result_num%>&nbsp;<%=result_num_uom%>&nbsp;&nbsp;&nbsp;<%=normalcy_str%>
						<%
						 
					    if(!normal_low_value_str.equals("0") && !normal_high_value_str.equals("0"))
						{
							textFormat.append("("+normal_low_value_str+"-"+normal_high_value_str+") ");
						 %>
							(<%=normal_low_value_str%>-<%=normal_high_value_str%>)
						<%
						}
						if (!result_str.equals(""))
						{
							%>&nbsp;<%=result_str%>&nbsp; 
							<% 
								textFormat.append("   "+result_str+"  ");
						}
						
						if(hist_data_exists.equals("Y"))
						{
							   %> <br><fmt:message key="eCA.Comment.label" bundle="${ca_labels}"/>:<br><%=displaydata.toString()%>
							   <%
						}
					 }
					 else if (hist_data_type.equals("STR") || hist_data_type.equals("HTM") )
					 {
						 %>
							&nbsp;<%=result_str%>&nbsp;
						<% 
							textFormat.append("   "+result_str+"  ");
							
							if(hist_data_exists.equals("Y"))
							{
								%> <br><fmt:message key="eCA.Comment.label" bundle="${ca_labels}"/>:<br><%=displaydata.toString()%>
								<%
							}
					 }

					 if(hist_data_exists.equals("Y"))
					 {
						if (hist_data_type.equals("TXT"))
								textFormat.append(displaydata.toString()+formet); 	
						else if(hist_data_type.equals("STR"))
						    textFormat.append(formet+"Comment:"+displaydata.toString()+formet); 
					 }
					
					 %>
				   </font></td>
				   </tr>
			
					 <%
					 k++;
					 event_date_str_prev=event_date_str;
					 event_group_desc_prev=event_group_desc;
				}

				if(rs!=null) rs.close();	
		}
			
	}
}

if(stmt!=null)stmt.close();		 	

}
	
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception cauight in RecClinicalNotesLinkHistRepSelectedText.jsp" + e);//COMMON-ICN-0181
}
finally 
{
	
	if(con!=null)ConnectionManager.returnConnection(con,request);
}

%>		

</table>
</div>
<input type="hidden" name="temp" id="temp" value="">
<input type="hidden" name="count" id="count" value="">
<%
String cat="";
if(!return_format.equals("TEXT"))
{
	cat = "<font size=2>"+textFormat.toString()+"</font>";

}
else
{
cat = textFormat.toString();
}
%>
<input type="hidden" name="temptext" id="temptext" value="<%=cat%>"> 
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>"> 
<input type="hidden" name="hist_rec_type" id="hist_rec_type" value="<%=hist_rec_type%>"> 
<input type="hidden" name="module_id" id="module_id" value="<%=module_id%>"> 
<input type="hidden" name="cycle_no" id="cycle_no" value="<%=cycle_no%>"> 
<input type="hidden" name="keyRef" id="keyRef" value="<%=keyRef%>"> 
<input type="hidden" name="Rcount" id="Rcount" value="<%=count%>"> 
</form>
</body>
<%if(check.equals("xyz")){%>
<script>returnDataApprove_df();</script>
<%}%>

