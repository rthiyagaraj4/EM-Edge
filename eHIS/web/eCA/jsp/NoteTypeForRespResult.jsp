<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------

17/05/2018	  IN066108		Kamalakannan	25/01/2018		Ramesh		        GHL-CRF-0497
12/06/2018	  IN067886		Kamalakannan	25/01/2018		Ramesh		        CA-GHL-CRF-0497/01
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
webbeans.eCommon.RecordSet NTRecordSet = (webbeans.eCommon.RecordSet)getObjectFromBean("NTRecordSet","webbeans.eCommon.RecordSet",session);
%>
<jsp:useBean id="getLincKey" scope="page" class="eCA._ca_license_rights"/>
<%!int row_count=0;%>
<html>
<head>
<title><fmt:message key="eCA.NoteTypeForResponosibilityResults.label" bundle="${ca_labels}"/></title>
 <%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- Added by Arvind @ 08-12-08 -->

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<script language='javascript' src='../js/NoteTypeForResp.js'></script>

<script>
	function checkNoteTypeForRes(thisObj, code, privilege_type){
		//if(thisObj.value=="")return;

	var group_by = document.forms(0).group_by.value;
	var grp_by_code = document.forms(0).grp_by_code.value;

	var defaultIndex = privilege_type;
	
	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></HEAD><BODY onKeyDown='lockKey()' CLASS='MESSAGE'><form name='form1' method='post' action='NoteTypeForRespValidate.jsp?code="+code+"&grp_by_code="+grp_by_code+"&obj_name="+thisObj.name+"&default_index="+defaultIndex+"&group_by="+group_by+"'></form></BODY></HTML>";
	parent.parent.messageFrame.document.write(HTMLVal);
	parent.parent.messageFrame.document.forms[0].submit();
	
	}

</script>
</head>
<%
Connection con			= null;
PreparedStatement pstmt = null;
ResultSet rs			= null;
HashMap hMapRecords		= null;


int row_disp=14;
int start = 0 ;
int end = 0 ;
int fm_disp=0, to_disp=0;
int count = 0;
int hdrSelCount = 0;
int chkCount = 0;//IN066108
int enableCount = 0;//IN066108
//String count1= "";

String title_desc="", group_by="", grp_by_code="", sql_query="", code="", desc="", classValue="",title_desc1="";
String from= "", to ="", dispMode="", update_val ="", valid="", associate="",dflt_transcription_yn="",dflt_trans_yn="",in_error_yn="";//IN066108
String privilege_type = "", selectOption1 = "selected", selectOption2 = "", selectOption3 = "";
String selectOption4 = "", selectOption5 = "", insUpd="", privilege_type_value ="",selAllValue="",default_allow_yn="",check_yn="";
String chk_transcription="";
String inErrorParam = "N";//IN066108
String enableInErr = "N";//IN067886
int pagecount = 0;

dispMode		=	request.getParameter("dispMode") ;
from			=	request.getParameter( "from" ) ;
to				=	request.getParameter( "to" ) ;
selAllValue	=	request.getParameter( "selAllValue" ) ;


//count1			=	request.getParameter( "count1" ) ;

if ( from == null || from=="null" || from.equals("null") )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;

if ( to == null || to =="null" || to.equals("null") )
	end = row_disp;//7 ;
else
	end = Integer.parseInt( to ) ;

if(dispMode == null || dispMode.equals("null")) dispMode="";
if(selAllValue == null || selAllValue.equals("null")) selAllValue="0";

hdrSelCount = Integer.parseInt( selAllValue ) ;



/*if ( count1 == null || count1=="null" || count1.equals("null") )
	count = 0 ;
else
	count = Integer.parseInt( count1 ) ;*/

group_by = request.getParameter("group_by");
if(group_by == null || group_by.equals(""))group_by="";
grp_by_code = request.getParameter("grp_by_code");
if(grp_by_code == null || grp_by_code.equals(""))grp_by_code="";

//out.println("grp_by_code"+grp_by_code);
//IN066108 starts
String inError_query = "select IN_ERROR_YN from CA_NOTE_PARAM";
con = ConnectionManager.getConnection();
pstmt = con.prepareStatement(inError_query);
rs = pstmt.executeQuery();
while(rs.next()){
	inErrorParam = rs.getString("IN_ERROR_YN");
}
//IN066108 ends
if(group_by.equals("RS"))
{
	title_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");
	title_desc1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels");
	chk_transcription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DfltTranscriptionNotes.label","ca_labels");
	//sql_query = "select a.note_type_desc description, a.note_type code,(select privilege_type from ca_note_type_for_resp b where b.note_type = a.note_type and b.resp_id ='"+grp_by_code+"')privilege_type, (select (case when privilege_type is not null then 'Y' else 'N' end)from ca_note_type_for_resp b where b.note_type = a.note_type and b.resp_id ='"+grp_by_code+"') valid,(SELECT dflt_transcription_yn FROM ca_note_type_for_resp b WHERE b.note_type = a.note_type AND b.resp_id ='"+grp_by_code+"') dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn,(SELECT IN_ERR_ACCESS_YN FROM ca_note_type_for_resp b WHERE b.note_type = a.note_type AND b.resp_id = '"+grp_by_code+"') in_error_yn from ca_note_type a where eff_status='E' order by upper(a.note_type_desc)";//IN066108 changed//common-icn-0180
	sql_query = "select a.note_type_desc description, a.note_type code,(select privilege_type from ca_note_type_for_resp b where b.note_type = a.note_type and b.resp_id =?)privilege_type, (select (case when privilege_type is not null then 'Y' else 'N' end)from ca_note_type_for_resp b where b.note_type = a.note_type and b.resp_id =?) valid,(SELECT dflt_transcription_yn FROM ca_note_type_for_resp b WHERE b.note_type = a.note_type AND b.resp_id =?) dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn,(SELECT IN_ERR_ACCESS_YN FROM ca_note_type_for_resp b WHERE b.note_type = a.note_type AND b.resp_id = ?) in_error_yn from ca_note_type a where eff_status='E' order by upper(a.note_type_desc)";//IN066108 changed//common-icn-0180

}
else if(group_by.equals("PR"))
{
	title_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");
	title_desc1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	chk_transcription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DfltTranscriptionNotes.label","ca_labels");
	//sql_query = "select a.note_type_desc description, a.note_type code,(select resource_type from CA_NOTE_TYPE_FOR_RESOURCE b where b.note_type_id = a.note_type and b.resource_code ='"+grp_by_code+"') privilege_type, (select (case when resource_type is not null then 'Y' else 'N' end)from CA_NOTE_TYPE_FOR_RESOURCE b where b.note_type_id = a.note_type and b.resource_code ='"+grp_by_code+"') valid, (SELECT dflt_transcription_yn FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code ='"+grp_by_code+"') dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn,(SELECT IN_ERR_ACCESS_YN FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code = '"+grp_by_code+"') in_error_yn from ca_note_type a where eff_status='E' and exists (select 1 from CA_NOTE_TYPE_FOR_RESP where RESP_ID in (select NVL(resp_id,'XX') from sm_resp_for_user ia, sm_appl_user ib where ib.func_role_id='"+grp_by_code+"' and ia.appl_user_id=ib.appl_user_id) and note_type=A.NOTE_TYPE ) order by upper(a.note_type_desc)";//IN066108 changed//common-icn-0180
	sql_query = "select a.note_type_desc description, a.note_type code,(select resource_type from CA_NOTE_TYPE_FOR_RESOURCE b where b.note_type_id = a.note_type and b.resource_code =?) privilege_type, (select (case when resource_type is not null then 'Y' else 'N' end)from CA_NOTE_TYPE_FOR_RESOURCE b where b.note_type_id = a.note_type and b.resource_code =?) valid, (SELECT dflt_transcription_yn FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code =?) dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn,(SELECT IN_ERR_ACCESS_YN FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code = ?) in_error_yn from ca_note_type a where eff_status='E' and exists (select 1 from CA_NOTE_TYPE_FOR_RESP where RESP_ID in (select NVL(resp_id,'XX') from sm_resp_for_user ia, sm_appl_user ib where ib.func_role_id=? and ia.appl_user_id=ib.appl_user_id) and note_type=A.NOTE_TYPE ) order by upper(a.note_type_desc)";//IN066108 changed//common-icn-0180

}else if(group_by.equals("SP"))
{
	title_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");
	title_desc1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	chk_transcription =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DfltTranscriptionNotes.label","ca_labels");
	//sql_query = "SELECT a.note_type_desc description, a.note_type code,(SELECT resource_type FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code ='"+grp_by_code+"')privilege_type, (SELECT (CASE WHEN resource_type IS NOT NULL THEN 'Y' ELSE 'N' END)FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code ='"+grp_by_code+"') valid,(SELECT dflt_transcription_yn FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code ='"+grp_by_code+"') dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn FROM ca_note_type a WHERE eff_status='E' ORDER BY UPPER(a.note_type_desc)";//common-icn-0180
	sql_query = "SELECT a.note_type_desc description, a.note_type code,(SELECT resource_type FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code =?)privilege_type, (SELECT (CASE WHEN resource_type IS NOT NULL THEN 'Y' ELSE 'N' END)FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code =?) valid,(SELECT dflt_transcription_yn FROM CA_NOTE_TYPE_FOR_RESOURCE b WHERE b.note_type_id = a.note_type AND b.resource_code =?) dflt_transcription_yn,(select TRANSCRIPTION_YN from ca_note_group where NOTE_GROUP = a.NOTE_GROUP_ID)default_allow_yn FROM ca_note_type a WHERE eff_status='E' ORDER BY UPPER(a.note_type_desc)";//common-icn-0180

}
else if(group_by.equals("NT"))
{
	title_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels"); 
	title_desc1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels");
	//sql_query = "select a.resp_name description, a.resp_id code,(select privilege_type from ca_note_type_for_resp b where b.resp_id = a.resp_id and b.note_type='"+grp_by_code+"') privilege_type, (select (case when privilege_type is not null then 'Y' else 'N' end)from ca_note_type_for_resp b where b.resp_id = a.resp_id and b.note_type='"+grp_by_code+"')valid from sm_resp a where eff_status='E' order by upper(a.resp_name)";//IN066108 changed//common-icn-0180
	sql_query = "select a.resp_name description, a.resp_id code,(select privilege_type from ca_note_type_for_resp b where b.resp_id = a.resp_id and b.note_type=?) privilege_type, (select (case when privilege_type is not null then 'Y' else 'N' end)from ca_note_type_for_resp b where b.resp_id = a.resp_id and b.note_type=?)valid from sm_resp a where eff_status='E' order by upper(a.resp_name)";//IN066108 changed//common-icn-0180

}
else
{
	title_desc = "";
	title_desc1= "";
	if(!(group_by.equals("NT")))
	{
	  chk_transcription= "";
	}

}

try{

	if(dispMode.equals(""))
	{

		NTRecordSet.clearAll();
		int pstmtcount =1;//common-icn-0180
		//con = ConnectionManager.getConnection(); commented for IN066108
		pstmt = con.prepareStatement(sql_query);
		//common-icn-0180 starts
		if(group_by.equals("RS")){
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
		}
		else if(group_by.equals("PR")){
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
		}
		else if(group_by.equals("SP")){
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
				
		}
		else if(group_by.equals("NT")){
			pstmt.setString(pstmtcount++, grp_by_code);
			pstmt.setString(pstmtcount++, grp_by_code);
			
		}
		//common-icn-0180 ends
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			code			= rs.getString("code");
			desc			= rs.getString("description");
			privilege_type	= rs.getString("privilege_type");
			valid			= rs.getString("valid");
			if(!(group_by.equals("NT")))
	        {
	           dflt_transcription_yn		= rs.getString("dflt_transcription_yn");
			   default_allow_yn			= rs.getString("default_allow_yn");
			   //IN066108 start
			   if(!group_by.equals("SP")){
				   in_error_yn				= rs.getString("in_error_yn");
				   if(in_error_yn == null || in_error_yn.equals("") || in_error_yn.equals("null"))in_error_yn="N";
			   }
			   //IN066108 end
			   if(dflt_transcription_yn == null || dflt_transcription_yn.equals("") || dflt_transcription_yn.equals("null"))dflt_transcription_yn="N";
			   if(default_allow_yn == null || default_allow_yn.equals("") || default_allow_yn.equals("null"))default_allow_yn="";
			   //out.println("dflt_transcription_yn"+dflt_transcription_yn);
	        }
						
			if(code == null || code.equals("null"))code="";
			if(desc == null || desc.equals("null"))desc="";
			if(privilege_type == null|| privilege_type.equals("null"))privilege_type="";
			if(valid == null || valid.equals("") || valid.equals("null"))valid="N";
			
			
			
			HashMap hMapRecs = new HashMap();
			hMapRecs.put("code"				, code);
			hMapRecs.put("desc"				, desc);
			hMapRecs.put("privilege_type"	, privilege_type);
			hMapRecs.put("associate"		, "N");
			hMapRecs.put("valid"			, valid);
			if(!(group_by.equals("NT")))
	        {
			  hMapRecs.put("dflt_transcription_yn"			, dflt_transcription_yn);
			  hMapRecs.put("default_allow_yn"			, default_allow_yn);
			 //IN066108 start
			  if(!group_by.equals("SP")){
			  hMapRecs.put("in_error_yn"			, in_error_yn);
			  }
			  //IN066108 end
			}
			hMapRecs.put("insUpd"			, "");
			NTRecordSet.putObject(hMapRecs);				
		}
	row_count	=	NTRecordSet.getSize();
		
	fm_disp	=	0;
	to_disp	=	(row_disp-1);
	if(to_disp > (row_count-1))
	to_disp=(row_count-1);

	from = ""+(start - 1);
	to   = ""+(end - 1);
	%>
		<script>
		if('<%=row_count%>' <= 0)
		{
			var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'common');	
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
	</script>
	<%
	}
	else
	{
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));
		if(dispMode.equals("Next"))
		{
			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);
			title_desc	= title_desc;
			title_desc1	= title_desc1;			
			hdrSelCount = hdrSelCount+1;
			if(!(group_by.equals("NT")))
	        {
			  chk_transcription = chk_transcription;
			}
		}
		else if(dispMode.equals("Previous"))
		{
			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);
			title_desc	= title_desc;
			title_desc1	= title_desc1;		
			hdrSelCount=hdrSelCount-1;
			if(!(group_by.equals("NT")))
	        {
			  chk_transcription = chk_transcription;
			}		
		}
	
	if(to_val > (row_count-1))
		to_val=(row_count-1);
	String valid_rec = "";
	//String dflt_rec="";
	if (group_by.equals("RS")||(group_by.equals("NT"))) 
	{
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);	
			if(update_val == null || update_val.equals("null") || update_val.equals("")) update_val = "";	
			if (group_by.equals("RS"))
			{
				dflt_trans_yn = request.getParameter("dflt_trans_yn"+j);	
				//IN066108 start 
				in_error_yn = request.getParameter("in_error_yn"+j);
				//IN066108 end
				if(dflt_trans_yn == null || dflt_trans_yn.equals("null") || dflt_trans_yn.equals("")) dflt_trans_yn = "";
				//IN066108 start
				if(in_error_yn == null || in_error_yn.equals("null") || in_error_yn.equals("")) in_error_yn = "";
				//IN066108 end
			}
			
						
			HashMap hMapAlter = (java.util.HashMap)NTRecordSet.getObject(j);
			//out.println("hMapAlter"+(java.util.HashMap)NTRecordSet.getObject(j));
			
			valid_rec = (String)hMapAlter.get("valid");
			//out.println("valid_rec"+valid_rec);

			if(valid_rec.equals("Y"))
			{
				insUpd = "U" ;
			}
			else if(valid_rec.equals("N")) 
			{
				if(update_val.equals("1")||update_val.equals("2")||update_val.equals("3")||update_val.equals("4")||update_val.equals("5")||update_val.equals("P")||update_val.equals("S"))
				{
					insUpd = "I";
				}
				else
				{
					insUpd = "";
				}
			}
			if(valid_rec.equals("Y")){
				hMapAlter.put("privilege_type", update_val);
				hMapAlter.put("associate"	  , "Y");
				hMapAlter.put("insUpd"		  , insUpd);
				//IN066108 start
				if(in_error_yn.equals("1") ||in_error_yn.equals("Y") ){
					in_error_yn="Y";
				}
				else if(in_error_yn.equals("0") ||in_error_yn.equals("N")||in_error_yn.equals("") ){
					in_error_yn="N";
				}
				hMapAlter.put("in_error_yn"	  , in_error_yn);
				//IN066108 end
				/*if (group_by.equals("RS"))
				{
					hMapAlter.put("dflt_transcription_yn" , dflt_trans_yn);
				}*/
				NTRecordSet.setObject(j, hMapAlter);
			}else if(valid_rec.equals("N")){				
					hMapAlter.put("privilege_type", update_val);
					hMapAlter.put("associate"	  , "Y");
					hMapAlter.put("insUpd"		  , insUpd);
					//IN066108 start
					if(in_error_yn.equals("1") ||in_error_yn.equals("Y")){
						in_error_yn="Y";
					}
					else if(in_error_yn.equals("0") ||in_error_yn.equals("N")||in_error_yn.equals("") ){
						in_error_yn="N";
					}
					hMapAlter.put("in_error_yn"	  , in_error_yn);
					//IN066108 end				
					/*if (group_by.equals("RS"))
					{
						hMapAlter.put("dflt_transcription_yn" , dflt_trans_yn);
					}*/
					NTRecordSet.setObject(j, hMapAlter);
			}		
		}
	}
else 
	{ 			
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);	
			dflt_trans_yn = request.getParameter("dflt_trans_yn"+j);
			in_error_yn = request.getParameter("in_error_yn"+j);//IN066108 
			if(update_val == null || update_val.equals("null") || update_val.equals("")) update_val = "";
			if(dflt_trans_yn == null || dflt_trans_yn.equals("null") || dflt_trans_yn.equals("")) dflt_trans_yn = "";
			if(in_error_yn == null || in_error_yn.equals("null") || in_error_yn.equals("")) in_error_yn = "";//IN066108 start
			HashMap hMapAlter = (java.util.HashMap)NTRecordSet.getObject(j);
			
			//out.println("hMapAlter"+(java.util.HashMap)NTRecordSet.getObject(j));
		
			
			valid_rec = (String)hMapAlter.get("valid");
			/*if(valid_rec.equals("Y")) insUpd = "U" ;
				else if(valid_rec.equals("N")) insUpd = "";*/

				if(valid_rec.equals("Y"))
			{
				insUpd = "U" ;
			}
			else if(valid_rec.equals("N")) 
			{
				if(update_val.equals("1")||update_val.equals("2")||update_val.equals("3")||update_val.equals("4")||update_val.equals("5")||update_val.equals("P")||update_val.equals("S"))
				{
					insUpd = "I";
				}
				else
				{
					insUpd = "";
				}
			}
			if(valid_rec.equals("Y")){				
				hMapAlter.put("privilege_type",update_val.trim());
				hMapAlter.put("associate"	  , "Y");
				hMapAlter.put("insUpd"		  , insUpd);
				//IN066108 start
				if(in_error_yn.equals("1") ||in_error_yn.equals("Y") ){
					in_error_yn="Y";
				}
				else if(in_error_yn.equals("0") ||in_error_yn.equals("N")||in_error_yn.equals("") ){
					in_error_yn="N";
				}
				hMapAlter.put("in_error_yn"			, in_error_yn);
				//IN066108 end
				NTRecordSet.setObject(j, hMapAlter);
			}else if(valid_rec.equals("N")){			
				if(!update_val.equals("")) {				
					hMapAlter.put("privilege_type", update_val.trim());
					hMapAlter.put("associate"	  , "Y");
					hMapAlter.put("insUpd"		  , insUpd);
					//IN066108 start
					if(in_error_yn.equals("1") ||in_error_yn.equals("Y") ){
						in_error_yn="Y";
					}
					else if(in_error_yn.equals("0") ||in_error_yn.equals("N")||in_error_yn.equals("") ){
						in_error_yn="N";
					}
					hMapAlter.put("in_error_yn"			, in_error_yn);
					//IN066108 end
					NTRecordSet.setObject(j, hMapAlter);
				}else if(update_val.equals("")) {									
					hMapAlter.put("privilege_type", update_val.trim());
					hMapAlter.put("associate"	  , "Y");
					hMapAlter.put("insUpd"		  , "U");
					//IN066108 start
					if(in_error_yn.equals("1") ||in_error_yn.equals("Y") ){
						in_error_yn="Y";
					}
					else if(in_error_yn.equals("0") ||in_error_yn.equals("N")||in_error_yn.equals("") ){
						in_error_yn="N";
					}
					hMapAlter.put("in_error_yn"			, in_error_yn);
					//IN066108 end
					NTRecordSet.setObject(j, hMapAlter);
				}			
				
			} 	
		}
	
	}

	fm_disp = Integer.parseInt(from);
	to_disp	= Integer.parseInt(to);

	if(to_disp > (row_count-1))
	to_disp=(row_count-1);

	start	= Integer.parseInt(from);
	end     = Integer.parseInt(to);
}	
	
%>
<body class='CONTENT' onLoad="" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='formNoteTypeRespResults' id='formNoteTypeRespResults'>
<table cellpadding='0' cellspacing='0' border='0' width='80%' align='center'>
<tr align='right' width='10%'>
<%
if ( (!(start <= 1)) && (start < row_count)){
%>
	<td class='white' width='95%'></td> 
			<td  align='right' width='5%'>
	<A class='gridLink' HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
	</td>
<%	
}
if ( !( (start+row_disp) >= row_count ) ){
%>
	<td class='white' width='95%'></td> 
			<td  align='right' width='5%'>
	<A class='gridLink' HREF='javascript:onClick=checkVal("Next");' text-decoration='none' >&nbsp;<fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
	</td>
<%
}
%>
</tr>
</table> 

<%
if(row_count > 0)
{
%>
<table class='grid' cellpadding='0' cellspacing='0' border='0' width='90%' align='center'>
<th class='columnHeadercenter' align="left"><%=title_desc%></th>
<th class='columnHeadercenter' align="left"><%=title_desc1%>
<%
 if((group_by.equals("SP"))||(group_by.equals("PR")))
{	
%>
	
 <input type='checkbox' name='ctrlChkBox<%=hdrSelCount%>' id='ctrlChkBox<%=hdrSelCount%>' onClick="javascript:perform(this,'<%=hdrSelCount%>','<%=group_by%>');" <%if(selAllValue.equals("Y")){%>checked<%}%>></th>
<%
}
 %>
 <%
if(!(group_by.equals("NT")))
{	
%>
	
<th class='columnHeadercenter' align="left"><%=chk_transcription%></th>
<%
 }
 //IN066108 start
if((group_by.equals("RS")||group_by.equals("PR"))&&(inErrorParam.equals("Y")) )
{	
%>
 	
<th class='columnHeadercenter' align="left"><fmt:message key="eCA.InError.label" bundle="${ca_labels}"/><input type='checkbox' name='ctrlChkBoxx1' id='ctrlChkBoxx1' onClick="javascript:performSelectAll(this,'<%=hdrSelCount%>');" <%if(selAllValue.equals("Y")){%>checked<%}%>></th><!--IN066108_1 alpha-->
<%
 }//IN066108 end
}
%>
<%
	
	for(int i=fm_disp; i<=to_disp; i++)
	{
		classValue		=	( (i%2)==0 )? "gridData" : "gridData";
		hMapRecords		=	(java.util.HashMap)NTRecordSet.getObject(i);
		code			=	(String)	hMapRecords.get("code");
		desc			=	(String)	hMapRecords.get("desc");
		privilege_type	=	(String)	hMapRecords.get("privilege_type");
		associate		=	(String)	hMapRecords.get("associate");
		enableInErr = "N";//IN067886
		if(!(group_by.equals("NT")))
		{
		  default_allow_yn		=	(String)	hMapRecords.get("default_allow_yn");
		  dflt_transcription_yn		=	(String)	hMapRecords.get("dflt_transcription_yn");
		  in_error_yn		=	(String)	hMapRecords.get("in_error_yn");//IN066108 start
		  if(default_allow_yn == null || default_allow_yn.equals(""))default_allow_yn="N";
		  if(dflt_transcription_yn.equals("")||dflt_transcription_yn.equals("null"))
			dflt_transcription_yn = "N"; else dflt_transcription_yn =dflt_transcription_yn;
		  //IN066108 start
		  if(in_error_yn == null || in_error_yn.equals("null") || in_error_yn.equals("")){
			  in_error_yn = "N"; 
		  }
		  else {
			  in_error_yn =in_error_yn;
		  }
		  valid 			=	(String)hMapRecords.get("valid");
		  if(valid.equals("")||valid.equals("null"))
			  valid = "N"; else valid =valid;
		//IN066108 end	  
		  //out.println("dflt_transcription_yn%%%%"+dflt_transcription_yn);
		//IN067886 start
		  if ("Y".equals(valid))			
				enableInErr = "Y";
		//IN067886 end
		}
		if(associate == null || associate.equals(""))associate="N";		
		if(privilege_type.equals("")||privilege_type.equals("null"))
			privilege_type_value = "0";	else privilege_type_value = privilege_type;
		


		if(privilege_type.equals("1")){
			selectOption1 = "selected";
			selectOption2 = "";
			selectOption3 = "";
			selectOption4 = "";
			selectOption5 = "";
		}else if(privilege_type.equals("2")){
			selectOption1 = "";
			selectOption2 = "selected";
			selectOption3 = "";
			selectOption4 = "";
			selectOption5 = "";
		}else if(privilege_type.equals("3")){
			selectOption1 = "";
			selectOption2 = "";
			selectOption3 = "selected";
			selectOption4 = "";
			selectOption5 = "";
		}else if(privilege_type.equals("4")){
			selectOption1 = "";
			selectOption2 = "";
			selectOption3 = "";
			selectOption4 = "selected";
			selectOption5 = "";
		}else if(privilege_type.equals("5")){
			selectOption1 = "";
			selectOption2 = "";
			selectOption3 = "";
			selectOption4 = "";
			selectOption5 = "selected";
		}else{
			selectOption1 = "";
			selectOption2 = "";
			selectOption3 = "";
			selectOption4 = "";
			selectOption5 = "";
		}
		%>
		<tr id=''>
			<!-- onChange='return checkNoteTypeForRes(this,"<%=code%>","<%=privilege_type_value%>"); -->
			<td class='<%=classValue%>'  width='30%'><%=((equals(""))?"&nbsp;":desc)%></td>
			<td class='<%=classValue%>'  width='30%'><%if((group_by.equals("RS"))||(group_by.equals("NT"))){%>
			<select name='select_yn<%=i%>' id='select_yn<%=i%>' onchange='TransDisplay(this,"<%= i%>")'><option value=''>------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------------------</option>
			<%if((getLincKey.getKey()).equals("CABASIC") || (getLincKey.getKey()).equals("CAMINI") || (getLincKey.getKey()).equals("BASIC")){%>
				<option value="3" <%=selectOption3%> ><fmt:message key="eCA.AuthorwithAuthorizationFacility.label" bundle="${ca_labels}"/></option>
				<option value="5" <%=selectOption5%> ><fmt:message key="eCA.ViewonlyPrivilege.label" bundle="${ca_labels}"/></option>
			<%}else if((getLincKey.getKey()).equals("CACLDC")){%>
				<option value="1" <%=selectOption1%> ><fmt:message key="eCA.Transcriber.label" bundle="${ca_labels}"/></option>
				<option value="2" <%=selectOption2%> ><fmt:message key="eCA.AuthorbutwithoutAuthorizationFacility.label" bundle="${ca_labels}"/></option>
				<option value="3" <%=selectOption3%> ><fmt:message key="eCA.AuthorwithAuthorizationFacility.label" bundle="${ca_labels}"/></option>
				<option value="4" <%=selectOption4%> ><fmt:message key="eCA.ReviewerPrivilegeforVerifyingandAuthorization.label" bundle="${ca_labels}"/></option>
				<option value="5" <%=selectOption5%> ><fmt:message key="eCA.ViewonlyPrivilege.label" bundle="${ca_labels}"/></option>
			</select>
	<%
	}
			}else
			{
				%>
				<input type=checkbox onclick = 'chkunchk(this,"<%= i%>","<%=group_by%>")'  name='select_yn<%= i%>' id='select_yn<%= i%>' value= '<%if(privilege_type.equals("P")||privilege_type.equals("S")||privilege_type.equals("1")){%>1<%}else{%>0<%}%>' <%
				if(privilege_type.equals("P")||privilege_type.equals("S")||privilege_type.equals("1"))
				{
				%>
					checked
				<%
				}
				%>>
				
		 <%
			}
			if(privilege_type.equals("P")||privilege_type.equals("S")||privilege_type.equals("1")){
				count = count+1;
				enableInErr = "Y";//IN067886
			}
			%>
			</td>
			<%
				if(!(group_by.equals("NT")))
		      {%>
			<td class='<%=classValue%>'  width='30%'>
			<input type='hidden' name='default_allow_yn<%= i%>' id='default_allow_yn<%= i%>' value='<%=default_allow_yn%>'>
		
		
		    <input type='checkbox' onclick = 'chkunchk1(this,"<%= i%>")'  name='dflt_trans_yn<%= i%>' value= '<%if(dflt_transcription_yn.equals("Y")||dflt_transcription_yn.equals("1")){%>1<%}else{%>0<%}%>' 
					<%
					if(dflt_transcription_yn.equals("Y")||dflt_transcription_yn.equals("1"))
					{%>
						checked
					<%}%>
				<%				if((privilege_type.equals("P")||privilege_type.equals("S")||privilege_type.equals("1")||privilege_type.equals("2")||privilege_type.equals("3")||privilege_type.equals("4")||privilege_type.equals("5"))&&default_allow_yn.equals("Y"))
				{
				}
				else
				{%>
				disabled
				<%}%>>
				</td>
				<%//IN066108 start%>
				<%
				
				if(group_by.equals("RS") &&inErrorParam.equals("Y")){ %>
					<td class='<%=classValue%>'  width='30%'>
		 			    <input type='checkbox' onclick = 'chkunchk2(this,"<%= i%>")'  name='in_error_yn<%=i%>' id='in_error_yn<%=i%>' value= '<%if(in_error_yn.equals("Y")||in_error_yn.equals("1")){%>1<%}else{%>0<%}%>' 
					<%
					if(in_error_yn.equals("Y")||in_error_yn.equals("1"))
					{
						++chkCount;//IN066108
					%>
						checked
					<%}
					//IN067886 start		
		 			    	if(!privilege_type.equals("3")&&!privilege_type.equals("4")){%>
		 			    		disabled
		 			    	<%}
		 			    	else{
		 			    		
		 			    		++enableCount;//IN066108
		 			    	}
					%>>
					
					<%if(privilege_type.equals("3")&&privilege_type.equals("4")){
						count = count+1;
						enableInErr = "Y";
					}//IN067886 end %>
					
					
					</td><%} 
					//IN066108 start
					else if(group_by.equals("RS") && inErrorParam.equals("N"))
					{
					%>
					<input type ='hidden' name='in_error_yn<%=i%>' id='in_error_yn<%=i%>' value ='0'/>
					<%
					}
					//IN066108 stop
					if(group_by.equals("PR") &&inErrorParam.equals("Y")){ %>
					<td class='<%=classValue%>'  width='30%'>
		 			    <input type='checkbox' onclick = 'chkunchk2(this,"<%= i%>")'  name='in_error_yn<%=i%>' value= '<%if(in_error_yn.equals("Y")||in_error_yn.equals("1")){%>1<%}else{%>0<%}%>' 
					<%
					if(in_error_yn.equals("Y")||in_error_yn.equals("1"))
					{
						++chkCount;
					%>
						checked
					<%}		
		 			    //if(valid.equals("Y"))//commented for IN067886
		 			    	if("Y".equals(enableInErr))//IN067886
					{
		 			    	++enableCount;
					}
					else
					{%>
							disabled
					<%}%>>
					</td><%} 
					//IN066108 start
					else if(group_by.equals("PR") && inErrorParam.equals("N"))
					{
					%>
					<input type ='hidden' name='in_error_yn<%=i%>' id='in_error_yn<%=i%>' value ='0'/>
					<%
					}
				
				//IN066108 stop%>
				<%}%>
			</tr>
			<%//IN066108 start%>
		<tr>
			<td>
				<input type="hidden" name='valid<%=i%>' id='valid<%=i%>' value=<%=valid%> > 
			</td>
		</tr><%//IN066108 start%>
<%
		pagecount++;
	}

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
	putObjectInBean("NTRecordSet",NTRecordSet,session);

	

}catch(Exception e){
	//out.println("Exception in try :"+e.toString());//common-icn-0181
	e.printStackTrace();
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}	
%>

	<td>
	</td>
	</table>
	<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> > 
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value="<%=to%>">
	<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">
	<input type="hidden" name="grp_by_code" id="grp_by_code" value="<%=grp_by_code%>">
	<input type="hidden" name="selAllValue" id="selAllValue" value="<%=hdrSelCount%>">
	<input type="hidden" name="default_allow_yn" id="default_allow_yn" value="<%=default_allow_yn%>">
	<input type="hidden" name="check_yn<%=hdrSelCount%>" id="check_yn<%=hdrSelCount%>" value="<%=check_yn%>">
	<input type="hidden" name="pagecount" id="pagecount" value="<%=pagecount%>">
	<input type="hidden" name="chkCount" id="chkCount" value="<%=chkCount%>">
	<input type="hidden" name="enableCount" id="enableCount" value="<%=enableCount%>">
	<input type="hidden" name="inErrorParam" id="inErrorParam" value="<%=inErrorParam%>">
	<script language='javascript' src='../../eCA/js/NoteTypeForResp.js'></script>
	<script>
		fnSelectAllChkBox("<%=hdrSelCount%>");
		onLoadInErrorSelectAll();//IN06788
	</script>
</form>
</body>
</html>


