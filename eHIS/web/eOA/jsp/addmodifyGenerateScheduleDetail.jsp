<!DOCTYPE html>
 
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
<%%>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eOA/js/GenerateSchedule.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
/*Below line modified for this CRF[CRF AMRI-CRF-0236]*/
function checkAll(){
var len=document.GenerateScheduleDetail_form.nochkbox.value;
	 if(document.GenerateScheduleDetail_form.selected_chk.checked){	 	
	 for(var k=0; k<len; k++){  
	 eval('document.GenerateScheduleDetail_form.selected_'+k).checked=true;	
	 eval('document.GenerateScheduleDetail_form.selected_'+k).value="Y";	 
	}
 }else{  
	for(var k=0; k<len; k++){ 
	  eval('document.GenerateScheduleDetail_form.selected_'+k).checked=false;
      eval('document.GenerateScheduleDetail_form.selected_'+k).value="N";         
	} 
  }
  document.GenerateScheduleDetail_form.nochkbox.value=len;
}

function checkSinglechk(){
 var singchklen=document.GenerateScheduleDetail_form.selected_chk.value;
for(var m=0; m<singchklen; m++){
	if(eval('document.GenerateScheduleDetail_form.selected_'+m).checked){ 
       eval('document.GenerateScheduleDetail_form.selected_'+m).checked=true;	
	   eval('document.GenerateScheduleDetail_form.selected_'+m).value="Y";
    }else{ 
	   eval('document.GenerateScheduleDetail_form.selected_'+m).checked=false;
       eval('document.GenerateScheduleDetail_form.selected_'+m).value="N";
	   if(document.GenerateScheduleDetail_form.selected_chk.checked){	  
	   document.GenerateScheduleDetail_form.selected_chk.checked=false;
	   }	   
    }	 
  }	
}
/*End for this CRF[CRF AMRI-CRF-0236]*/
</script>


<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rset=null ;
//Statement stmt1=null;
//ResultSet rset1=null ;

String wd1 = checkForNull(request.getParameter("wd1"));
String wd2 = checkForNull(request.getParameter("wd2"));
String wd3 = checkForNull(request.getParameter("wd3"));
String wd4 = checkForNull(request.getParameter("wd4"));
String wd5 = checkForNull(request.getParameter("wd5"));
String wd6 = checkForNull(request.getParameter("wd6"));
String wd7 = checkForNull(request.getParameter("wd7"));

String from_date = checkForNull(request.getParameter("from_date"));
String to_date = checkForNull(request.getParameter("to_date"));

//String locationType=request.getParameter("locationType");

String facilityId = (String) session.getValue( "facility_id" ) ;


String da[]  = new String[7];

String cliniccode = checkForNull(request.getParameter("clinic_code"));
String days = checkForNull(request.getParameter("days"));
int i= 0;
StringTokenizer str 	= new StringTokenizer(days,"|");

while(str.hasMoreTokens()){
	da[i] = str.nextToken();
	i++;
}

String ID="";
String dayofweek="";
//int last;
String pre_pract="";
String pre_resource="";
String cur_pract="";
//int first=1;
String day = "";
String d="";
int s=0;
int no=0;
String preID = "";
boolean X_flag = false;

String checkBoxAttribute1="";
String checkBoxAttribute2="";
String checkBoxAttribute3="";
String checkBoxAttribute4="";
String checkBoxAttribute5="";
String checkBoxAttribute6="";
String checkBoxAttribute7="";

String dis1 = "DISABLED";
String dis2 = "DISABLED";
String dis3 = "DISABLED";
String dis4 = "DISABLED";
String dis5 = "DISABLED";
String dis6 = "DISABLED";
String dis7 = "DISABLED";

String res_type="";
String res_class="";
String locale			= (String)session.getAttribute("LOCALE");


%>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name='GenerateScheduleDetail_form' id='GenerateScheduleDetail_form'  method='post' target='messageFrame'>
	<table border='0' cellpadding='0' cellspacing='0' align='center' width='80%'>
	<td colspan='4'  class='COLUMNHEADER' ><fmt:message key="eOA.ResourceDetail.label" bundle="${oa_labels}"/></th>
		<tr>
		<td  width='13%' class='CAGROUPHEADING' ><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
		<td  width='29%' class='CAGROUPHEADING' ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		<td  width='47%' class='CAGROUPHEADING' align='center' ><fmt:message key="eOA.TimeTableAvailableDays.label" bundle="${oa_labels}"/></td>
		<%/*Below line modified for this CRF[AMRI-CRF-0236]*/%>
		<td width='10%' align='center' class='CAGROUPHEADING'> 
		<fmt:message key="Common.selectall.label" bundle="${common_labels}"/>
		
	
		
		<input type='checkbox' name='selected_chk' id='selected_chk'  onclick ='checkAll()' value='' >
		<input type='hidden' name='selected_chk1' id='selected_chk1' id='selected_chk1'>
		<input type='hidden' name='selected_chk2' id='selected_chk2' id='selected_chk2'>
		<input type='hidden' name='selected_chk3' id='selected_chk3' id='selected_chk3'>
		<input type='hidden' name='selected_chk4' id='selected_chk4' id='selected_chk4'>
		<input type='hidden' name='selected_chk5' id='selected_chk5' id='selected_chk5'>
		<input type='hidden' name='selected_chk6' id='selected_chk6' id='selected_chk6'>
		<input type='hidden' name='selected_chk7' id='selected_chk7' id='selected_chk7'>
		<input type='hidden' name='selected_chk8' id='selected_chk8' id='selected_chk8'>
			
		</td>
		</tr>
	
	</table>
	
		<!--<div  style="position:relative;height:400px;overflow:auto"> -->
		<div  style="position:relative;height:380px;vertical-align:top;overflow:auto"> 
		<table border='0' cellpadding='0' cellspacing='0' align='center' width='80%'>
		
		
		
		<%/*Below Line Added for this CRF  [AMRI-CRF-0236]*/%>
		<tr>		
		<td colspan='3' width='43%'>&nbsp;</td>		
		<td width='47%' align='center'>
						<table border='0' cellpadding='0' cellspacing='0' align='center'width='90%'>
							<tr>
							<td width='14%' class='labelcenter'><%=wd1%></td>							
							<td width='14%' class='labelcenter'><%=wd2%></td>
							<td width='14%' class='labelcenter'><%=wd3%></td>
							<td width='14%' class='labelcenter'><%=wd4%></td>
							<td width='14%' class='labelcenter'><%=wd5%></td>
							<td width='14%' class='labelcenter'><%=wd6%></td>
							<td width='14%' class='labelcenter'><%=wd7%></td>
							<td>&nbsp;</td>
							</tr>
						</table>
						</td>	
		<td width='10%' align='center' class='CAGROUPHEADING'>&nbsp;</td>
		</tr>
     <%/*Below line modified for this CRF[CRF AMRI-CRF-0236]*/%>

		<tr align='left' >
		<%
		try{
		//stmt1 = con.createStatement();
		String anchor="";
		/*String strsql="select count(*) as total from  oa_clinic_time_table a, sm_day_of_week b  where a.facility_id = '"+facilityId+"' and clinic_code = '"+cliniccode+"' and a.day_no = b.day_no and a.care_locn_type_ind='"+locationType+"' ";


		rset1 = stmt1.executeQuery(strsql);
		rset1.next();
		last = rset1.getInt("total");*/

		//stmt=con.createStatement();
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//String sqlchk =" select  a.practitioner_id,  decode(A.resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, substr(b.day_of_week,1,3), a.day_no, a.resource_class from oa_clinic_time_table a,  sm_day_of_week b  where a.facility_id = '"+facilityId+"' and a.care_locn_type_ind='"+locationType+"' and  clinic_code = '"+cliniccode+"'   and a.day_no = b.day_no  order by nvl(practitioner_name,'!'),a.day_no  ";
		
        
		String sqlchk ="select a.clinic_code, A.PRACTITIONER_ID,Nvl(decode(A.resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1'), 'R',AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2'),  AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2')),'!') pract_name, decode(A.resource_class, 'P',AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2'),  AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, substr(b.day_of_week,1,3), a.day_no day_no, a.resource_class,a.PHYS_ROSTER_REQD_YN from oa_clinic_time_table a, sm_day_of_week b where a.facility_id = '"+facilityId+"' and a.clinic_code = '"+cliniccode+"' and a.day_no = b.day_no AND 0 < (SELECT (case when a.PHYS_ROSTER_REQD_YN = 'Y' then (select distinct count(1) from OA_ROSTER_FOR_PRACT where facility_id = '"+facilityId+"' and clinic_code = a.clinic_code and practitioner_id = a.practitioner_id AND FACILITY_ID = A.FACILITY_ID and ON_DUTY_DATE between to_date('"+from_date+"','dd/mm/yyyy') and to_date('"+to_date+"', 'dd/mm/yyyy')) else 1 end) FROM DUAL) UNION select a.clinic_code, A.PRACTITIONER_ID, Nvl(decode(A.resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1'), 'R',AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2'),  AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2')),'!') pract_name,decode(A.resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2'),  AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID, A.PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, substr(b.day_of_week,1,3), a.day_no day_no,a.resource_class,a.PHYS_ROSTER_REQD_YN from oa_clinic_time_table a, sm_day_of_week b where a.facility_id = '"+facilityId+"' and a.clinic_code = '"+cliniccode+"' AND a.PHYS_ROSTER_REQD_YN = 'N' and a.day_no = b.day_no order by pract_name,day_no ";
		
		
		

		rset=stmt.executeQuery(sqlchk);

		//rset.last();
		//last = rset.getRow();
		//rset.beforeFirst();

		if(rset != null){
			while(rset.next()){
				ID=checkForNull(rset.getString(2));
				cur_pract=checkForNull(rset.getString(4));
				day  = checkForNull(rset.getString(5));
				res_type=checkForNull(rset.getString("resource_class"));

				if(res_type.equals("P"))
				{
				res_class="Practitioner";
				}else if(res_type.equals("R"))
				{
				res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(res_type.equals("E"))
				{
				res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(res_type.equals("O"))
				{
				res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
				}
				

				if(res_type==null) res_type="";
				if(res_class==null) res_class="";

				if(cur_pract == null || cur_pract.equals("")){
					cur_pract = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.Notidentified.label","oa_labels");
				}
				//if((!(cur_pract.equals(pre_pract) || first ==1)) || last == first){
				if((!(cur_pract.equals(pre_pract) || rset.isFirst())) || rset.isLast()){
					//if( last == first){
					if(rset.isLast()){

						if(cur_pract.equals(pre_pract))
						{
							d=d+day+"|";
						
						}
						else
						{
							X_flag = true;
						}
					}
								
					if(preID == null || preID.equals("") ||(preID.substring(0,preID.indexOf("*"))).equals("null") || !pre_resource.equals("Practitioner")) 
						anchor="&nbsp;";
					else	         
						anchor="<a href='javaScript:showPractWindow(\""+preID+"\")'>+&nbsp;</a>";
			
					if(!d.equals("")){						
						if(pre_resource.equals("Practitioner"))
							pre_resource=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
					%>					
						<td width='3%' class='labelleft' ><%=anchor%></td>
						<td width='10%' class='labelleft'  nowrap ><%=pre_resource%> </td>
						<td width='29%' class='labelleft' nowrap ><%=pre_pract%></font>
						<input type='hidden' name='practitioner_id_<%=s%>' id='practitioner_id_<%=s%>' value='<%=preID%>'></td>
						<%
					}
								
					StringTokenizer st 	= new StringTokenizer(d.toString(),"|");

					while(st.hasMoreTokens()){
						no++;
						dayofweek=st.nextToken();
						if(dayofweek.equals(wd1)){
							checkBoxAttribute1 = "CHECKED" ;
							dis1 = "" ;}
						if(dayofweek.equals(wd2)){
							checkBoxAttribute2 = "CHECKED" ;
							dis2 = "" ;}
						if(dayofweek.equals(wd3)){
							checkBoxAttribute3 = "CHECKED" ;
							dis3 = "" ;}
						if(dayofweek.equals(wd4)){
							checkBoxAttribute4 = "CHECKED" ;
							dis4 = "" ;}
						if(dayofweek.equals(wd5)){
							checkBoxAttribute5 = "CHECKED" ;
							dis5 = "" ;}
						if(dayofweek.equals(wd6)){
							checkBoxAttribute6 = "CHECKED" ;
							dis6= "" ;}
						if(dayofweek.equals(wd7)){
							checkBoxAttribute7 = "CHECKED" ;
							dis7 = "" ;
						}
					}

					if(!d.equals("")){
	%>
						<td width='47%'align='center'>
						<table border='0' cellpadding='0' cellspacing='0' align='center'width='90%'>
							<tr>
							<td width='14%' align='center'>
							<input type='checkbox' name='day_1' id='day_1' value='<%=wd1%>' <%=checkBoxAttribute1%> <%=dis1%>></td>
							
							<td width='14%' align='center'>
							<input type='checkbox' name='day_2' id='day_2' value='<%=wd2%>' <%=checkBoxAttribute2%> <%=dis2%>></td>

							<td width='14%' align='center'>
							<input type='checkbox' name='day_3' id='day_3' value='<%=wd3%>' <%=checkBoxAttribute3%> <%=dis3%>></td>

							<td width='14%' align='center'>
							<input type='checkbox' name='day_4' id='day_4' value='<%=wd4%>' <%=checkBoxAttribute4%> <%=dis4%>></td>

							<td width='14%' align='center'>
							<input type='checkbox' name='day_5' id='day_5' value='<%=wd5%>' <%=checkBoxAttribute5%> <%=dis5%>></td>

							<td width='14%' align='center'>
							<input type='checkbox' name='day_6' id='day_6' value='<%=wd6%>' <%=checkBoxAttribute6%> <%=dis6%>></td>

							<td width='14%' align='center'>
							<input type='checkbox' name='day_7' id='day_7' value='<%=wd7%>' <%=checkBoxAttribute7%> <%=dis7%>></td>

							<td>&nbsp;</td>
							</tr>
						</table>
						</td>

						<td width='7%' align='center'>
						<%/*Below line modified for this CRF[CRF AMRI-CRF-0236]*/%>
						<input type='checkbox' name='selected_<%=s%>' id='selected_<%=s%>'  value='Y' onclick="checkSinglechk()" checked> 
						<%s++;%>
						</td>
						</tr>
						<%
						d="";
					}
				}

				d=d+day+"|";
				//first++;
				pre_pract = cur_pract;
				pre_resource=res_class;
				preID = ID+"*"+res_type;

				checkBoxAttribute1="";
				checkBoxAttribute2="";
				checkBoxAttribute3="";
				checkBoxAttribute4="";
				checkBoxAttribute5="";
				checkBoxAttribute6="";
				checkBoxAttribute7="";

				dis1 = "DISABLED";
				dis2 = "DISABLED";
				dis3 = "DISABLED";
				dis4 = "DISABLED";
				dis5 = "DISABLED";
				dis6 = "DISABLED";
				dis7 = "DISABLED";
				if(X_flag){
				 	dayofweek = day;

					if (preID==null) 
						preID="";
				 	
						if(preID == null || preID.equals("") ||(preID.substring(0,preID.indexOf("*"))).equals("null") || !pre_resource.equals("Practitioner")) 
							anchor="&nbsp;";
						else
							anchor="<a href='javaScript:showPractWindow(\""+preID+"\")'>+&nbsp;</a>";

					if(res_class.equals("Practitioner"))	
						   res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");	
					%><!-- Below lin changed @ UAT-3 by Sudhakar-->
				 <td width='3%'  class='labelleft'><%=anchor%></td><td width='10%'  class='labelleft' nowrap><%=res_class%></td><td width='29%'  class='labelleft' nowrap><%=cur_pract%></font>
				<input type='hidden' name='practitioner_id_<%=s%>' id='practitioner_id_<%=s%>' value='<%=preID%>'></td>

				<%
				
				if(dayofweek.equals(wd1)){
					checkBoxAttribute1 = "CHECKED" ;
					dis1 = "" ;}
				if(dayofweek.equals(wd2)){
					checkBoxAttribute2 = "CHECKED" ;
					dis2 = "" ;}
				if(dayofweek.equals(wd3)){
					checkBoxAttribute3 = "CHECKED" ;
					dis3 = "" ;}
				if(dayofweek.equals(wd4)){
					checkBoxAttribute4 = "CHECKED" ;
					dis4 = "" ;}
				if(dayofweek.equals(wd5)){
					checkBoxAttribute5 = "CHECKED" ;
					dis5 = "" ;}
				if(dayofweek.equals(wd6)){
					checkBoxAttribute6 = "CHECKED" ;
					dis6= "" ;}
				if(dayofweek.equals(wd7)){
					checkBoxAttribute7 = "CHECKED" ;
					dis7 = "" ;
				}
				%>

				<td width='47%'align='center'>
				<table border='0' cellpadding='0' cellspacing='0' align='center' width='90%'>
				<tr>
				<td width='14%' align='center'>
				<input type='checkbox' name='day_1' id='day_1' value='<%=wd1%>' <%=checkBoxAttribute1%> <%=dis1%>></td>
				
				<td width='14%' align='center'>
				<input type='checkbox' name='day_2' id='day_2' value='<%=wd2%>' <%=checkBoxAttribute2%> <%=dis2%>></td>

				<td width='14%' align='center'>
				<input type='checkbox' name='day_3' id='day_3' value='<%=wd3%>' <%=checkBoxAttribute3%> <%=dis3%>></td>

				<td width='14%' align='center'>
				<input type='checkbox' name='day_4' id='day_4' value='<%=wd4%>' <%=checkBoxAttribute4%> <%=dis4%>></td>

				<td width='14%' align='center'>
				<input type='checkbox' name='day_5' id='day_5' value='<%=wd5%>' <%=checkBoxAttribute5%> <%=dis5%>></td>

				<td width='14%' align='center'>
				<input type='checkbox' name='day_6' id='day_6' value='<%=wd6%>' <%=checkBoxAttribute6%> <%=dis6%>></td>

				<td width='14%' align='center'>
				<input type='checkbox' name='day_7' id='day_7' value='<%=wd7%>' <%=checkBoxAttribute7%> <%=dis7%>></td>

				<td>&nbsp;</td>
				</tr>
				</table>
				</td>

				<td width='7%' align='center'>
				<%/*Below line modified for this CRF[CRF AMRI-CRF-0236]*/%>
				<input type='checkbox' name='selected_<%=s%>' id='selected_<%=s%>'  value='Y' onclick="checkSinglechk()" checked>
				<%s++;%>
				</td>
				</tr>
				<%
			}
		}// while loop of recordset
	} // if recordset null
	%>
	<input type='hidden' name='nochkbox' id='nochkbox' value='<%=s%>' >
	<%
	if(rset != null) rset.close();
	//if(rset1 != null) rset1.close();
	if(stmt != null) stmt.close();
	//if(stmt1 != null) stmt1.close();
}catch(Exception e) {
	//out.println(e.toString()); 
	e.printStackTrace();
	
}finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</table>
</form>
</body>
<script>
/*Below line modified for this CRF[CRF AMRI-CRF-0236]*/
  document.GenerateScheduleDetail_form.selected_chk.value='<%=s%>';
  document.GenerateScheduleDetail_form.selected_chk.checked=true;	
 //End CRF[CRF AMRI-CRF-0236]
</script>
</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

