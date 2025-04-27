<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
27/07/2017		IN061891	Raja S		27/07/2017		Ramesh G		ML-MMOH-CRF-0543 
11/24/2023   32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCA.*,java.util.*,eCA.CAOpenChartServlet,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>


<html>
   <%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String queryStringForChart		=	request.getQueryString() == null ? "" : request.getQueryString();
%>
   <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../js/CAMenu.js' language='javascript'></script>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
    <script language='javascript' src='../../eCA/js/PersonalisePatListDetails.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script>

	//function ShowPats(pat_name,pat_id,age,gender,queryStringForChart,prac_id) //32902
	async function ShowPats(pat_name,pat_id,age,gender,queryStringForChart,prac_id,ind)  //32902
		{	
			//Start.32902
			var restPatientYN=document.getElementById("restPatientYN"+ind).value; 
			var accessRightsViewPatient=document.getElementById("accessRightsViewPatient").value; 
			if(pat_id !=="" && restPatientYN =="Y" && accessRightsViewPatient==0)
			{
			  	restrictOpenVIPPat(pat_id,restPatientYN,accessRightsViewPatient);
			  	return;
			}
			//end. 32902
				var dialogHeight= "200px" ;
				var dialogWidth = "700px" ;
				var dialogTop = "117" ;
				var dialogLeft = "50" ;
				var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+";status=no;scroll=yes;";
				retVal = await window.showModalDialog("ShowPersonalisePatients.jsp?queryStringForChart="+queryStringForChart+"&patientName="+pat_name+"&patientID="+pat_id+"&Age="+age+"&Gender="+gender+"&pracID="+prac_id,"",features);
		}
	</script>
    <head>
    </head>
    <body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<style>
.gridDataSelectNew
{
	background-color: #CDE5FF;
	font-family: Verdana;
	font-size: 8pt;
	color: #000000;
	font-weight:normal;
	text-align:center;
	padding-left:10px;
	padding-right:10px;
	vertical-align:middle;	
} 
.gridData
{
	background-color: #FFFFFF;
	height:18px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 8pt;
	color: #000000;
	font-weight:normal;
	text-align:center;
	padding-left:10px;
	padding-right:10px;
	vertical-align:middle;
	border-bottom:1px;
	border-top:0px;
	border-left:0px;
	border-right:0px;
	border-style:solid;
	border-color:#EEEEEE;
}
</style>
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
function patClick_(id){
	for(var i=0;i<patIdArr.length;i++){
		if(i==id){
			document.getElementById('rtz'+i).className='gridDataSelectNew';
			document.getElementById('rty'+i).className='gridDataSelectNew';
			document.getElementById('rta'+i).className='gridDataSelectNew';
			document.getElementById('rtb'+i).className='gridDataSelectNew';
			document.getElementById('rtc'+i).className='gridDataSelectNew';
			document.getElementById('rtd'+i).className='gridDataSelectNew';
			document.getElementById('rte'+i).className='gridDataSelectNew';
			document.getElementById('rtf'+i).className='gridDataSelectNew';
			document.getElementById('rtg'+i).className='gridDataSelectNew';
			
		}else{
			document.getElementById('rtz'+i).className='gridData';
			document.getElementById('rty'+i).className='gridData';
			document.getElementById('rta'+i).className='gridData';
			document.getElementById('rtb'+i).className='gridData';
			document.getElementById('rtc'+i).className='gridData';
			document.getElementById('rtd'+i).className='gridData';
			document.getElementById('rte'+i).className='gridData';
			document.getElementById('rtf'+i).className='gridData';
			document.getElementById('rtg'+i).className='gridData';
		}
	}
}
</script>
<%
Connection con =null;
PreparedStatement pstmt = null;
int recCount = 0;

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String client_ip_address = p.getProperty("client_ip_address");
con = ConnectionManager.getConnection(request);

HttpSession thisSession = request.getSession(false);
String facility_id  =  (String) thisSession.getValue("facility_id") ;
String userId=(String) session.getValue("login_user");
String clinicianId=(String) session.getValue("ca_practitioner_id");
StringBuffer QueryString=new StringBuffer();

String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
String sex_desc = "";
String DateofBirth = "";
String anchorID= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
String from_date_time1 = request.getParameter("from_date_time")==null?"":request.getParameter("from_date_time");
String to_date_time1 = request.getParameter("to_date_time")==null?"":request.getParameter("to_date_time");
String active_flg = request.getParameter("active_flg")==null?"":request.getParameter("active_flg");
//32902 start
String restPatientYN	=	"";
String ca_bean_id 						= "@CACommonGetPatientDtlBean";
String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
CACommonGetPatientDtlBean bean1			= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
int accessRightsViewPatient=0;
accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
//32902 end

from_date_time1		= com.ehis.util.DateUtils.convertDate(from_date_time1,"DMYHM",locale,"en");
to_date_time1		= com.ehis.util.DateUtils.convertDate(to_date_time1,"DMYHM",locale,"en");

if("A".equals(active_flg))
//QueryString.append("select  distinct a.patient_id,REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','')      patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob,c.date_of_birth,CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex,  TO_CHAR (a.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE from ca_pat_personalise_list a, pr_encounter b, mp_patient c WHERE   a.facility_id =? and a.PRACTITIONER_ID = ? AND c.patient_id=a.patient_id and b.patient_id(+)=a.patient_id and b.facility_id (+)=a.facility_id AND c.SUSPEND_YN  != 'Y' AND b.ATTEND_PRACTITIONER_ID =? AND ( (b.patient_class IN ('IP', 'DC') and b.adt_status between '01'and '07') OR ( b.patient_class IN  ('OP', 'EM') and B.visit_status in ('01','02','03','04','05','06','09'))) AND C.DECEASED_YN!='Y' "); //IN064743 //32902
QueryString.append("select  distinct a.patient_id,REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','')      patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob,c.date_of_birth,CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex,  TO_CHAR (a.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE,c.restrict_reinstate_yn from ca_pat_personalise_list a, pr_encounter b, mp_patient c WHERE   a.facility_id =? and a.PRACTITIONER_ID = ? AND c.patient_id=a.patient_id and b.patient_id(+)=a.patient_id and b.facility_id (+)=a.facility_id AND c.SUSPEND_YN  != 'Y' AND b.ATTEND_PRACTITIONER_ID =? AND ( (b.patient_class IN ('IP', 'DC') and b.adt_status between '01'and '07') OR ( b.patient_class IN  ('OP', 'EM') and B.visit_status in ('01','02','03','04','05','06','09'))) AND C.DECEASED_YN!='Y' "); //32902
else
//QueryString.append("select distinct  a.patient_id,REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','')      patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob,c.date_of_birth,CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex,  TO_CHAR (a.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE from ca_pat_personalise_list a, pr_encounter b, mp_patient c WHERE   a.facility_id =? and a.PRACTITIONER_ID = ? AND c.patient_id=a.patient_id and b.patient_id(+)=a.patient_id and b.facility_id (+)=a.facility_id AND c.SUSPEND_YN  != 'Y' AND b.ATTEND_PRACTITIONER_ID =? AND  ( (b.patient_class IN ('IP', 'DC') and b.adt_status not between '01'and '07') OR ( b.patient_class IN  ('OP', 'EM') and B.visit_status not in ('01','02','03','04','05','06','09')))  AND C.DECEASED_YN!='Y' AND NOT EXISTS ( select pr.patient_id from ca_pat_personalise_list cp, pr_encounter pr WHERE   pr.facility_id =a.facility_id and pr.patient_id=a.patient_id AND pr.patient_id(+)=cp.patient_id and pr.facility_id (+)=cp.facility_id and pr.ATTEND_PRACTITIONER_ID = a.practitioner_id AND ((pr.patient_class IN ('IP', 'DC') and pr.adt_status between '01'and '07') OR (pr.patient_class IN ('OP','EM') and pr.visit_status  in ('01','02','03','04','05','06','09')))) "); //IN064743 //32902
QueryString.append("select distinct  a.patient_id,REPLACE (REPLACE (DECODE (?,'en', c.patient_name, NVL ( c.patient_name_loc_lang,  c.patient_name)), '''',''), '''','')      patient_name, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob,c.date_of_birth,CA_GET_AGE_IN_HRS (c.date_of_birth,c.DECEASED_DATE) age , sex,  TO_CHAR (a.ADDED_DATE, 'dd/mm/yyyy hh24:mi') ADDED_DATE,c.restrict_reinstate_yn from ca_pat_personalise_list a, pr_encounter b, mp_patient c WHERE   a.facility_id =? and a.PRACTITIONER_ID = ? AND c.patient_id=a.patient_id and b.patient_id(+)=a.patient_id and b.facility_id (+)=a.facility_id AND c.SUSPEND_YN  != 'Y' AND b.ATTEND_PRACTITIONER_ID =? AND  ( (b.patient_class IN ('IP', 'DC') and b.adt_status not between '01'and '07') OR ( b.patient_class IN  ('OP', 'EM') and B.visit_status not in ('01','02','03','04','05','06','09')))  AND C.DECEASED_YN!='Y' AND NOT EXISTS ( select pr.patient_id from ca_pat_personalise_list cp, pr_encounter pr WHERE   pr.facility_id =a.facility_id and pr.patient_id=a.patient_id AND pr.patient_id(+)=cp.patient_id and pr.facility_id (+)=cp.facility_id and pr.ATTEND_PRACTITIONER_ID = a.practitioner_id AND ((pr.patient_class IN ('IP', 'DC') and pr.adt_status between '01'and '07') OR (pr.patient_class IN ('OP','EM') and pr.visit_status  in ('01','02','03','04','05','06','09')))) "); //32902

		if(!(from_date_time1.equals("")))
			QueryString.append(" 	and a.ADDED_DATE >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");
		if(!(to_date_time1.equals("")))
			QueryString.append(" 	and a.ADDED_DATE <= to_date( ?,'dd/mm/yyyy hh24:mi' )+0.00068287 ");
		QueryString.append("AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,a.patient_id,a.facility_id)");  //32902
String desc="";
if(reOrder.equals("2"))
	desc=" desc";
if(orderBy.equals("PN"))
	QueryString.append(" Order By patient_name"+desc);
else if(orderBy.equals("DOB"))
	QueryString.append(" Order By date_of_birth"+desc); //IN064743
else if(orderBy.equals("AGE"))
{
	if(reOrder.equals("1"))
	{
		QueryString.append(" Order By date_of_birth desc"); //IN064743


	}
	else
		QueryString.append(" Order By date_of_birth"); //IN064743
}
else if(orderBy.equals("SEX"))
	QueryString.append(" Order By sex"+desc);
else if(orderBy.equals("PID"))
	QueryString.append("Order By patient_id"+desc);
else if(orderBy.equals("AAT"))
	QueryString.append(" Order By ADDED_DATE"+desc);
else
	QueryString.append( " Order By ADDED_DATE desc");

%>
<form name='PatCriteriaFrm' id='PatCriteriaFrm' action='OpenChartWrapper.jsp' method = 'post' target='messageFrame'>

<%
pstmt = con.prepareStatement(QueryString.toString());
int colIndex=1;
pstmt.setString(colIndex++,locale);

pstmt.setString(colIndex++,facility_id);
pstmt.setString(colIndex++,clinicianId);
pstmt.setString(colIndex++,clinicianId);
if(!(from_date_time1.equals("")))
	pstmt.setString	(colIndex++,	from_date_time1	);
			
if(!(to_date_time1.equals("")))
	pstmt.setString	(colIndex++,	to_date_time1	);

pstmt.setString	(colIndex++,clinicianId);  //32902

ResultSet rsPatList = null;

try
{
	int k=0;
	int i=0;

	rsPatList = pstmt.executeQuery(); %>
	<table class='grid' id='PatCriteriaTbl' width='100%' >
	<tr>
		<th class='columnHeadercenter' width='3%'>&nbsp;</th>		
		<th class='columnHeadercenter' width='3%'><input type="checkbox" id='a001'  name='select_all' id='select_all' onclick='selectallpat();'></th>		
		<th class='columnHeadercenter' nowrap  >
			<a  id='a1' style='color:white' href="javascript:callForOrderBy('AAT');" onclick='changeColor(this);' ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddedAt.label","ca_labels")%></a>
		</th>		
		<th class='columnHeadercenter'   nowrap>
			<a id='a2'  style='color:white'   href="javascript:callForOrderBy('PN');" onclick='changeColor(this);' ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")%></a>
		</th>		
		<th class='columnHeadercenter'  nowrap  >
			<a id='a3' style='color:white'     href="javascript:callForOrderBy('DOB');" onclick='changeColor(this);'  ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")%></a>
		</th>		
		<th class='columnHeadercenter'  nowrap  >
			<a id='a4' style='color:white'     href="javascript:callForOrderBy('AGE');" onclick='changeColor(this);'  ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")%></a>
		</th>		
		<th class='columnHeadercenter'  nowrap  >
			<a id='a5' style='color:white'    href="javascript:callForOrderBy('SEX');" onclick='changeColor(this);'  ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")%></a>
		</th>		
		<th class='columnHeadercenter'  nowrap  >
			<a id='a6'  style='color:white'   href="javascript:callForOrderBy('PID');" onclick='changeColor(this);'  ><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")%></a>
		</th>		
	</tr>
<%	while(rsPatList.next()) 
	{
		recCount++;
		sex_desc = rsPatList.getString("sex");
		restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
		if(sex_desc.equals("M"))
			{
				sex_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			}
		else if(sex_desc.equals("F"))
			{
			sex_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			}
		else if(sex_desc.equals("U"))
			{
			sex_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}

		if(locale.equals("en"))
		{
			DateofBirth=rsPatList.getString("DOB");
		}
		else
		{
			DateofBirth=com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale);
		}

		out.println("<tr>");
		out.println("<td class='gridData' width='3%' id='rtz"+i+"' style='text-align: center'>&nbsp;</td>");
		out.println("<td class='gridData' width='3%' id='rty"+i+"' style='text-align: center'><input type='checkbox' name='rta"+i+"' id='rta"+i+"' id='rta"+i+"'></td><td id='rtb"+i+"' class='gridData' nowrap style='text-align: center'>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADDED_DATE"),"DMYHM","en",locale)+"</td><td  id='rtc"+i+"' class='gridData' nowrap style='text-align: center'>");
		if("A".equals(active_flg))
		//out.println("<a class='gridLink' href=\"javascript:ShowPats('"+rsPatList.getString("PATIENT_NAME")+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("AGE")+"','"+sex_desc+"','"+queryStringForChart+"','"+clinicianId+"');patClick_('"+i+"');\" name='patName'>"+rsPatList.getString("PATIENT_NAME")+"</a>");  //32902
		out.println("<a class='gridLink' href=\"javascript:ShowPats('"+rsPatList.getString("PATIENT_NAME")+"','"+rsPatList.getString("PATIENT_ID")+"','"+rsPatList.getString("AGE")+"','"+sex_desc+"','"+queryStringForChart+"','"+clinicianId+"','"+i+"');patClick_('"+i+"');\" name='patName'>"+rsPatList.getString("PATIENT_NAME")+"</a>"); //32902
		else
		out.println(rsPatList.getString("PATIENT_NAME"));
		out.println("</td><td id='rtd"+i+"' class='gridData' nowrap style='text-align: center'>"+DateofBirth+"</td><td id='rte"+i+"' class='gridData' nowrap style='text-align: center'>"+rsPatList.getString("AGE")+"</td><td id='rtf"+i+"' class='gridData' nowrap style='text-align: center'>"+sex_desc+"</td><td id='rtg"+i+"' class='gridData' nowrap style='text-align: center'>"+rsPatList.getString("PATIENT_ID")+"</td></tr>");
		out.println("<input type='hidden' name='rtp"+i+"' id='rtp"+i+"' id='rtp"+i+"' value='"+rsPatList.getString("PATIENT_ID")+"'> ");
		out.println("<script language='javascript'>");
		out.println("patIdArr["+i+"]='"+rsPatList.getString("patient_id")+"';");
		out.println("</script>");
		%>
		<script language='javascript' src='../../eCA/js/CACommon.js'></script> <!-- 32902 -->
<input type="hidden" id="restPatientYN<%=i%>"  name="restPatientYN<%=i%>" value='<%=rsPatList.getString("restrict_reinstate_yn")%>'><!-- 32902  --> 
<input type="hidden" id="accessRightsViewPatient"  name="accessRightsViewPatient" id="accessRightsViewPatient" value='<%=accessRightsViewPatient%>'><!-- 32902  --> 
<%
		i++;
		k++;
	}
	if(recCount==0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");



}
catch(Exception e)
{
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally 
{
	if(pstmt!=null) pstmt.close();
	if(rsPatList!=null) rsPatList.close();
	if(con!=null)con.close();										
}%>
        </table>
		<input type="hidden" name="patient_id" id="patient_id" value="">
		<input type="hidden" name="encounter_id" id="encounter_id" value="">
		<input type="hidden" name="insert_op" id="insert_op" value="N">
        <input type="hidden" name="patient_class" id="patient_class" value="">
		<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
		<input type='hidden' name='rec_count' id='rec_count' value='<%=recCount%>'>
		<input type='hidden' name='mode' id='mode' value=''>
	    <input type='hidden' name='delPatList' id='delPatList' value="">
		<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
		<input type='hidden' name='login_id' id='login_id' value="<%=userId%>">
		<input type='hidden' name='pract_id' id='pract_id' value="<%=clinicianId%>">
		<input type='hidden' name='system_id' id='system_id' value="<%=client_ip_address%>">
		
		
        </form>
		<form name='PatSearchFrm' id='PatSearchFrm' action='OpenChartWrapper.jsp' method = 'post' target=messageFrame>
		<input type='hidden' name='patient_id' id='patient_id'>
		<input type='hidden' name='episode_visit_id' id='episode_visit_id'>
		<input type='hidden' name='episode_id' id='episode_id'>
	    <input type='hidden' name='from_function' id='from_function' value='M'>
		<input type='hidden' name='from_date_time' id='from_date_time' value="<%=from_date_time1%>">
	    <input type='hidden' name='to_date_time' id='to_date_time' value="<%=to_date_time1%>">
		<input type='hidden' name='active_flg' id='active_flg' value="<%=active_flg%>">

	
	
</form>
<%if(!anchorID.equals("")){%>
		<script>
			if('<%=anchorID%>'!='')
			{
				if('<%=reOrder%>'=='1')
				{
					document.getElementById("PatCriteriaTbl").all.<%=anchorID%>.style.color='pink';
				}
				else if('<%=reOrder%>'=='2')
					document.getElementById("PatCriteriaTbl").all.<%=anchorID%>.style.color='yellow';
			}
		</script>
		<%}%>
    </body>
</html>

