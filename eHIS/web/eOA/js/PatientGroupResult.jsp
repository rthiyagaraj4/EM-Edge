<!DOCTYPE html>
 
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*" %>
<%%>

<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eOA/js/jquery.js' language='javascript'></script>
<script language='javascript' src='../../eOA/js/PatientGroup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
$("input[name='checkall']").live('click',function() {
	var checked = $(this).attr('checked');
	if(checked == 'checked') {
		$("input[name='pat_id_chk']").attr("checked", true);
	} else {
		$("input[name='pat_id_chk']").attr("checked", false);
	}
});

function FnDelete(){
	var VarPatIds=FnGetCheckdValues();
	var IsError			= 0;
	if(VarPatIds==""){
		alert(getMessage("ATLEAST_ONE_SELECTED", "common"));
		parent.commontoolbarFrame.document.location.reload();
		IsError	=1;
	}
	if(IsError==0){
		$("#HidSelectedPatIds").val(VarPatIds);
		$("#PatGrpRes").submit();
	}
}

function FnGetCheckedCount(){
	var count	= 0;
	$("input[name='pat_id_chk']").filter(':checked').each(function() {
		count	= count + 1;
	});
	return parseInt(count);
}


function FnGetCheckdValues(){
	var VarPatIds	= "";
	$("input[name='pat_id_chk']").filter(':checked').each(function() {
		VarPatIds+=$(this).val()+"|";
	});
	if(VarPatIds!=''){
		VarPatIds	= VarPatIds.slice(0,-1);
	}
	return VarPatIds;
}




function FnInsert(){
	var VarPatIds		= FnGetCheckdValues();
	var VarPatCount		= FnGetCheckedCount();
	var VarMaxPatient	= $("#max_patient").val();
	var VarCheckCount	= parseInt($("#Existing_Group_Members").val())+VarPatCount;
	var IsError			= 0;
	if(VarPatIds==""){
		alert(getMessage("ATLEAST_ONE_SELECTED", "common"));
		parent.commontoolbarFrame.document.location.reload();
		IsError	= 1;
	}else if(VarCheckCount > VarMaxPatient){
		alert(getMessage("MAX_PAT_LIMIT_REACHED", "OA"));
		parent.commontoolbarFrame.document.location.reload();
		IsError	= 1;
	}
	if(IsError==0){
		$("#HidSelectedPatIds").val(VarPatIds);
		$("#PatGrpRes").submit();
	}
}




</script>
<%
request.setCharacterEncoding("UTF-8");	
String locale=(String)session.getAttribute("LOCALE");
String mode	= (request.getParameter("mode")==null)?"":request.getParameter("mode");
String GroupId = (request.getParameter("GroupId")==null)?"":request.getParameter("GroupId");
String Existing_Group_Members = (request.getParameter("Existing_Group_Members")==null)?"":request.getParameter("Existing_Group_Members");
String max_patient = (request.getParameter("max_patient")==null)?"":request.getParameter("max_patient");
String VarWhere	= "";
if(mode.equals("insert")){
	String First_Name = (request.getParameter("First_Name")==null)?"":request.getParameter("First_Name");
	String Second_Name =(request.getParameter("Second_Name")==null)?"": request.getParameter("Second_Name");
	String Third_Name = (request.getParameter("Third_Name")==null)?"":request.getParameter("Third_Name");
	String Family_Name = (request.getParameter("Family_Name")==null)?"":request.getParameter("Family_Name");
	String Dob =(request.getParameter("Dob")==null)?"": request.getParameter("Dob");
	String Sex = (request.getParameter("Sex")==null)?"":request.getParameter("Sex");
	String MobileNo = (request.getParameter("MobileNo")==null)?"":request.getParameter("MobileNo");
	String group_location_id	= (request.getParameter("group_location_id")==null)?"":request.getParameter("group_location_id");
	
	if(!First_Name.equals("")) VarWhere+=" AND A.FIRST_NAME like '%"+First_Name+"%'";
	if(!Second_Name.equals("")) VarWhere+=" AND A.SECOND_NAME like '%"+Second_Name+"%'";
	if(!Third_Name.equals("")) VarWhere+=" AND A.THIRD_NAME like '%"+Third_Name+"%'";
	if(!Family_Name.equals("")) VarWhere+=" AND A.FAMILY_NAME like '%"+Family_Name+"%'";
	if(!Dob.equals("")) VarWhere+=" AND trunc(A.DATE_OF_BIRTH) = to_date('"+Dob+"','dd/mm/yyyy')";
	if(!Sex.equals("") && !Sex.equals("A")) VarWhere+=" AND A.SEX = '"+Sex+"'";
	if(!MobileNo.equals("")) VarWhere+=" AND A.CONTACT1_NO = '"+MobileNo+"'";
	VarWhere+= " AND A.PATIENT_ID not in ( select DISTINCT  C.PATIENT_ID from  OA_GROUP_DTLS C, oa_group_hdr D where C.GROUP_ID=D.GROUP_ID and D.LOCN_CODE='"+group_location_id+"')";
	
}else if(mode.equals("delete")){
	if(!GroupId.equals("")) VarWhere+=" AND B.GROUP_ID = '"+GroupId+"'";
}

VarWhere+=" AND A.DECEASED_YN = 'N'  AND A.SUSPEND_YN = 'N'  AND A.ACTIVE_YN = 'Y' ";


Connection con 		= ConnectionManager.getConnection(request);
Statement newstmt	= null;

ResultSet rset		= null ;
PreparedStatement pstmt	= null;
ResultSet rs		= null ;
String sql			= "";
String classValue	= "";
int noOfRecords		= 0;
int rowcnt=0;

String Family_No_Link_Yn 			= "";
String Family_No_Prompt				= ""; 
String First_Name_Accept_Yn 		= "";
String First_Name_Prompt 			= "";
String Second_Name_Accept_Yn 		= "";
String Second_Name_Prompt 			= "";
String Third_Name_Accept_Yn			= "";
String Third_Name_Prompt 			= "";
String Family_Name_Accept_Yn 		= ""; 
String Family_Name_Prompt			= "";
String gender						= "";
 
 try{
	String Qry_For_Slct_Flds="SELECT param.family_no_link_yn,param.family_no_prompt, param.first_name_accept_yn,param.first_name_order, param.first_name_prompt,param.second_name_accept_yn, param.second_name_order,param.second_name_prompt, param.third_name_accept_yn,param.third_name_order, param.third_name_prompt,param.family_name_accept_yn, param.family_name_order,param.family_name_prompt, first_name_loc_lang_prompt,second_name_loc_lang_prompt, third_name_loc_lang_prompt,family_name_loc_lang_prompt FROM   mp_param_lang_vw param WHERE  param.module_id = 'MP' AND param.language_id = ?";
	 pstmt = con.prepareStatement(Qry_For_Slct_Flds);
	 pstmt.setString(1,locale);
	 rs = pstmt.executeQuery();
     if (rs !=null){
           if (rs.next()){
              
             Family_No_Link_Yn =rs.getString("Family_No_Link_Yn")== null ?  "N" : rs.getString("Family_No_Link_Yn");
             Family_No_Prompt =rs.getString("Family_No_Prompt")== null ? "Head of the Family" : rs.getString("Family_No_Prompt");
          	
             First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null ? "N" : rs.getString("First_Name_Accept_Yn");
             First_Name_Prompt = rs.getString("First_Name_Prompt")==null ? "First Name" : rs.getString("First_Name_Prompt");
            
             Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null ? "N" : rs.getString("Second_Name_Accept_Yn");
             Second_Name_Prompt = rs.getString("Second_Name_Prompt")==null ? "Second Name" : rs.getString("Second_Name_Prompt");
            
             Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null ? "N" : rs.getString("Third_Name_Accept_Yn");
             Third_Name_Prompt = rs.getString("Third_Name_Prompt")==null ? "Third Name" : rs.getString("Third_Name_Prompt");

        	 Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null ? "N" : rs.getString("Family_Name_Accept_Yn");
      		 Family_Name_Prompt = rs.getString("Family_Name_Prompt")==null ? "Family Name" : rs.getString("Family_Name_Prompt");
           }
       }
   }catch(Exception e) { out.println(e.toString());}
   finally
   {
       if (pstmt != null) pstmt.close();
       if (rs != null) rs.close();
   }

 if(mode.equals("insert")){
	 
 	sql="select A.PATIENT_ID,A.FIRST_NAME,A.SECOND_NAME,A.THIRD_NAME,A.FAMILY_NAME,to_char(A.DATE_OF_BIRTH,'dd/mm/yyyy')DATE_OF_BIRTH,A.SEX, A.CONTACT1_NO from mp_patient A  where A.PATIENT_ID is not null " +VarWhere ;
 
 }else{
	 sql=" SELECT A.patient_id,B.PATIENT_ID, A.first_name, A.second_name, A.third_name, A.family_name,TO_CHAR (A.date_of_birth, 'dd/mm/yyyy') date_of_birth, A.sex, A.CONTACT1_NO,B.GROUP_ID FROM mp_patient A , oa_group_dtls B where A.patient_id = B.patient_id " +VarWhere;
 }
newstmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
rset = newstmt.executeQuery(sql) ;

%>

<style>
.wrapword{
	word-wrap: break-word;      
	word-break: break-all;
	white-space: normal;
}
</style>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="PatGrpRes" id="PatGrpRes" id="PatGrpRes" method="post" action="../../servlet/eOA.GenerateGroupPatientsServlet">
<input type="hidden" name="HidSelectedPatIds" id="HidSelectedPatIds" id="HidSelectedPatIds" value="" >
<input type="hidden" name="max_patient" id="max_patient" id="max_patient" value="<%=max_patient%>" >
<input type="hidden" name="GroupId" id="GroupId" id="GroupId" value="<%=GroupId%>" >
<input type="hidden" name="Existing_Group_Members" id="Existing_Group_Members" id="Existing_Group_Members" value="<%=Existing_Group_Members%>" >
<input type="hidden" name="mode" id="mode" id="mode" value="<%=mode%>" >

<%
while(rset.next()){
noOfRecords = noOfRecords + 1;
	if(mode.equals("insert")){
		if(noOfRecords > 100)
			break;
	}
}
rset.beforeFirst(); 

if(noOfRecords == 0){	  
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
}else if(noOfRecords > 100 && mode.equals("insert")){
	out.println("<script>alert(getMessage('TOO_MANY_RECORDS_REFINE_SEARCH','OA'))</script>");
}else{
	%>
		
	<table border='1' width='100%'  cellspacing='0' cellpadding='0'>
	<tr>
	<th  width="7%" height="20px"><b><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels") %></b></th>
	<%
	if(First_Name_Accept_Yn.equals("Y")){
		if(!First_Name_Prompt.equals("")){
			out.println("<th  width='15%'height='20px' ><b>"+First_Name_Prompt+"</b></th>");
		}else{
			out.println("<th  width='15%' height='20px'><b>First Name</b></th>");
		}
	}
	if(Second_Name_Accept_Yn.equals("Y")){
		if(!Second_Name_Prompt.equals("")){
			out.println("<th nowrap width='15%' height='20px'><b>"+Second_Name_Prompt+"</b></th>");
		}else{
			out.println("<th  width='15%' height='20px'><b>Second Name</b></th>");
		}
	}
	if(Third_Name_Accept_Yn.equals("Y")){
		if(!Third_Name_Prompt.equals("")){
			out.println("<th  width='15%' height='20px'><b>"+Third_Name_Prompt+"</b></th>");
		}else{
			out.println("<th  width='15%' height='20px'><b>Third Name</b></th>");
		}
	}
	if(Family_Name_Accept_Yn.equals("Y")){
		if(!Family_Name_Prompt.equals("")){
			out.println("<th  width='15%' height='20px'><b>"+Family_Name_Prompt+"</b></th>");
		}else{
			out.println("<th  width='15%' height='20px'><b>Family Name</b></th>");
		}
	}
	%>
	<th  width="10%" height='20px'><b><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")%></b></th>
	<th  width="8%" height='20px'><b><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DateofBirth.label","common_labels")%></b></th>
	
	
	<th  width="5%" height='20px'>Select All&nbsp;<input type='checkbox' name="checkall" id="checkall" value='N' ></th>
		</tr>
	 
	</table>
	<div style="height:400px; width:100%; overflow:auto;">
	<table border='1'  cellspacing='0' width="100%" cellpadding='0' style="overflow: auto;">
	 <%while(rset.next()){
	 		if(rowcnt%2==0)
	 			classValue="AR_QRYEVEN wrapword";
			else
				classValue="AR_QRYODD wrapword";
	 		
	 		gender=rset.getString("SEX");
			if(gender.equals("M")){
				gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			}else if(gender.equals("F")){
				gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			}else if(gender.equals("U")){
				gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}
	 	%>
	 
	 	<tr >
	 		<td  class="<%=classValue%>"  width="7%"><%=(rset.getString("PATIENT_ID")==null)?"&nbsp;":rset.getString("PATIENT_ID")%></td>
	 		<%if(First_Name_Accept_Yn.equals("Y")){%>
	 			<td  class="<%=classValue%>"   width="15%"><%=(rset.getString("FIRST_NAME")==null)?"&nbsp;":rset.getString("FIRST_NAME")%></td>
	 		<%}%>
	 		<%if(Second_Name_Accept_Yn.equals("Y")){ %>
	 			<td  class="<%=classValue%>"   width="15%"><%=(rset.getString("SECOND_NAME")==null)?"&nbsp;":rset.getString("SECOND_NAME")%></td>
	 		<%}%>
	 		<%if(Third_Name_Accept_Yn.equals("Y")){ %>
	 			<td  class="<%=classValue%>"  width="15%"><%=(rset.getString("THIRD_NAME")==null)?"&nbsp;":rset.getString("THIRD_NAME")%></td>
	 		<%}%>
	 		<%if(Family_Name_Accept_Yn.equals("Y")){ %>
	 			<td  class="<%=classValue%>"  width="15%"><%=(rset.getString("FAMILY_NAME")==null)?"&nbsp;":rset.getString("FAMILY_NAME")%></td>
	 		<%}%>
	 		<td class="<%=classValue%>"  width="10%"><%=gender%></td>
	 		<td class="<%=classValue%>"  width="8%"><%=(rset.getString("DATE_OF_BIRTH")==null)?"&nbsp;":rset.getString("DATE_OF_BIRTH")%></td>
	 		
	 		<td class="<%=classValue%>"  width="5%"><input name="pat_id_chk" id="pat_id_chk" type="checkbox" value="<%=rset.getString("PATIENT_ID")%>" ></td>
	 	</tr>
 	
	 
	 	
		
	 <%
	 rowcnt++;
	 }%>
	
	</table>
	</div>

<%
if(rset != null) rset.close();
if(pstmt != null) pstmt.close();

}%>
	</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

