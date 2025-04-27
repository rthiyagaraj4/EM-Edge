<!DOCTYPE html>
<%--
	FileName	: md_addModifyLocnForOperatorStnResult.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*"%>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function changeEnable(Obj,Obj1)
	{
		var arr = new Array();
		arr = Obj1.value.split("$");
		if(Obj.checked)
		{
			arr[1]="Y";
		}
		else
			arr[1]="N";
		Obj1.value=arr[0]+"$"+arr[1]+"$"+arr[2];
	}
	async function showPractWindow(practID)
	{
	    var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	    var dialogHeight    = "70vh" ;
	    var dialogWidth = "80vw" ;
	    var dialogLeft="";
	    var arguments   = "" ;
	    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	    var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;
	}
	function submitPrevNext(from, to){
		//alert("temp====>"+parent.frames[0].temp);
		
	   document.forms[0].finalSelect.value=parent.frames[0].temp;	
	   
	   document.forms[0].from.value = from;
	   document.forms[0].to.value = to; 
		if(confirm(getMessage('WANT_TO_SAVE','common'))){ 
			document.forms[0].action="../../servlet/eAM.md_LocnForOperatorStn";		
			document.forms[0].submit();
		}else{				
			   parent.frames[0].temp='';
			 var operator_station=parent.frames[0].document.forms[0].oprstn.value;
			var location_type=parent.frames[0].document.forms[0].loctype.value;
			var speciality = parent.frames[0].document.forms[0].speciality.value;
			var facility = parent.frames[0].document.forms[0].facility.value;
           
			var search_by=parent.frames[0].document.forms[0].search_by.value;
			
			var search_txt=parent.frames[0].document.forms[0].search_txt.value;
			var from=document.forms[0].from.value;
			var to=document.forms[0].to.value;			
			parent.frames[1].location.href='../../eAM/jsp/md_addModifyLocnForOperatorStnResult.jsp?operator_station='+operator_station+'&location_type='+location_type+'&facilityID='+facility+'&speciality='+speciality+'&search_by='+search_by+'&search_txt='+search_txt+'&from='+from+'&to='+to;
			
	    }
	}
	function reloadresultPage(frame){

		if(frame == 'R'){
		    parent.frames[0].temp='';

			var operator_station=parent.frames[0].document.forms[0].oprstn.value;
			var location_type=parent.frames[0].document.forms[0].loctype.value;
			var speciality = parent.frames[0].document.forms[0].speciality.value;
			var facility = parent.frames[0].document.forms[0].facility.value;
           
			var search_by=parent.frames[0].document.forms[0].search_by.value;
			
			var search_txt=parent.frames[0].document.forms[0].search_txt.value;
			var from=document.forms[0].from.value;
			var to=document.forms[0].to.value;		
			parent.frames[1].location.href='../eAM/jsp/md_addModifyLocnForOperatorStnResult.jsp?operator_station='+operator_station+'&location_type='+location_type+'&facilityID='+facility+'&speciality='+speciality+'&search_by='+search_by+'&search_txt='+search_txt+'&from='+from+'&to='+to;			
			 parent.parent.frames[2].location.href='../eCommon/jsp/MstCodeError.jsp?err_num?err_val=';
			  alert(parent.frames[1].getMessage('RECORD_INSERTED','SM'));
		}
	}
	function chkSelect(){

		if(document.forms[0].record_empty.value=="N"){
				if(document.forms[0].all_flg.value=="Y"){
					document.forms[0].mainChk.checked=true;
				}else if(document.forms[0].all_flg.value=="N"){
					document.forms[0].mainChk.checked=false;
				}

				if(document.forms[0].global_available.value=="Y"){
					if(document.forms[0].all_global_flg.value=="Y"){
						document.forms[0].global_Chk.checked=true;
					}else if(document.forms[0].all_global_flg.value=="N"){
						document.forms[0].global_Chk.checked=false;
					}
				}

			
				
				if(document.forms[0].mainChk.checked){
				}else{
					
					if(document.forms[0].global_available.value=="Y"){
						document.forms[0].global_Chk.checked=false;
						document.forms[0].global_Chk.disabled=true;
					}
				}
		}	

	}	
	
</script>
<%
	Connection con			= null;
	PreparedStatement pstmt	= null;
	Statement stmt			= null;
	ResultSet rs			= null ;
			
	String all_flg="Y";
	String record_empty="N";
	String all_global_flg="Y";
	String disabled_attribute="";
	String locn_type_ind = "";
	String finalSelect   = "",effStatus = "";
	String from = request.getParameter("from");
    String to   = request.getParameter("to");
	String global_available="N";
	String search_by=request.getParameter("search_by");
	String search_txt=request.getParameter("search_txt");
		if(search_by == null) search_by="";
		if(search_txt == null) search_txt="";

		String search_by1="";
		String search_by2="";
		String search_by3="";

		if(search_by.equals("01"))
		{
		   search_by1="LOCN_CODE";
		   search_by2="CLINIC_CODE";
		   search_by3="NURSING_UNIT_CODE";
		}
		else if(search_by.equals("02"))
		{
			search_by1="LOCN_LONG_DESC";
			search_by2="LONG_DESC";
			search_by3="LONG_DESC";
		}
		
	int maxRecord = 0;
	int start     = 0;
	int end       = 0;

    if(from == null){ start = 0; } else {  start = Integer.parseInt( from ) ; }
    if(to == null){ end = 6; } else { end = Integer.parseInt( to ) ; }
	
	finalSelect=request.getParameter("finalSelect");
	if(finalSelect == null) finalSelect="";
    
	effStatus=request.getParameter("effStatus");
	
	if(effStatus == null) effStatus="";
	String facilityID     = request.getParameter("facilityID");
	if(facilityID == null) facilityID="";
	String specialty_code = request.getParameter("speciality");
	if(specialty_code == null) specialty_code="";
	String operator_station=request.getParameter("operator_station");
	if(operator_station == null) operator_station="";
	String location_type= request.getParameter("location_type");
	if(location_type == null) location_type="";
	String global_chkattribute="";
	String Chkglobal="";
	String Global_Flag= "";
  
	
	if((location_type.equals("C"))||(location_type.equals("Y"))||(location_type.equals("E"))){
		 Global_Flag="Y";
	 }


		
	try
	{
		con = ConnectionManager.getConnection(request);
		
		String GlobalSql="SELECT GLOBAL_BOOK_APPT_YN FROM am_oper_stn where Facility_Id = '"+facilityID+"' and Oper_Stn_ID ='"+operator_station+"'";
		pstmt = con.prepareStatement(GlobalSql.toString());		
		rs = pstmt.executeQuery();
		if(rs != null && rs.next())
		{
			global_chkattribute = rs.getString(1);
		}		
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();


		StringBuffer practSql =new StringBuffer("");
		practSql.setLength(0);
		practSql.append("select care_locn_type_ind from am_care_locn_type where locn_type=?");
		pstmt = con.prepareStatement(practSql.toString());
		pstmt.setString(1, location_type);
		rs = pstmt.executeQuery();
		if(rs != null && rs.next())
		{
			locn_type_ind = rs.getString(1);
		}
	
		practSql.setLength(0);
		practSql.append("");
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		
		if(locn_type_ind.equals("N"))
		{		
			practSql.setLength(0);

			if(!specialty_code.equals(""))				
			{
			practSql.append("Select a.locn_code, a.locn_long_desc,a.global_locn_yn global_locn_yn, 'Y' del_flag,service_desc,upper(a.locn_long_desc) from am_locn_for_oper_stn_vw a where a.Facility_Id ='"+facilityID+"' and a.Oper_Stn_ID = '"+operator_station+"' and a.CARE_LOCN_TYPE = '"+location_type+"'");

			
			if(!search_by.equals("") && !search_txt.equals(""))
			  practSql.append(" and upper("+search_by1+")  like upper('"+search_txt+"%')"); 
			
			practSql.append(" Union Select a.nursing_unit_code locn_code, a.long_desc,'N' global_locn_yn,'N' del_flag, b.short_desc,upper(a.long_desc) from ip_nursing_unit a ,am_service b, IP_NURS_UNIT_FOR_SPECIALTY C where a.service_code= b.service_code and a.facility_id = '"+facilityID+"' and a.eff_status = 'E' and C.SPECIALTY_CODE = '"+specialty_code+"' and ");

			if(!search_by.equals("") && !search_txt.equals(""))
			  practSql.append(" upper(a."+search_by3+")  like upper('"+search_txt+"%') and"); 

			practSql.append("  A.FACILITY_ID = C.FACILITY_ID AND A.NURSING_UNIT_CODE = C.NURSING_UNIT_CODE AND a.LOCN_TYPE= '"+location_type+"' and a.nursing_unit_code not in (Select a.locn_code from am_locn_for_oper_stn a where a.Facility_Id ='"+facilityID+"' and a.Oper_Stn_ID = '"+operator_station+"' ");

			
			}else{
				practSql.append("Select a.locn_code, a.locn_long_desc,a.global_locn_yn global_locn_yn, 'Y' del_flag,service_desc,upper(a.locn_long_desc) from am_locn_for_oper_stn_vw a where a.Facility_Id ='"+facilityID+"' and a.Oper_Stn_ID = '"+operator_station+"' and a.CARE_LOCN_TYPE = '"+location_type+"'   ");

				if(!search_by.equals("") && !search_txt.equals(""))
				 practSql.append(" and upper("+search_by1+")  like upper('"+search_txt+"%')"); 
				
			//out.println("The values pract values"+practSql.toString());


//				practSql.append(" and (nvl(a.SPECIALITY_CODE,'!') = nvl('"+specialty_code+"','!') or a.SPECIALITY_CODE = nvl('"+specialty_code+"',a.SPECIALITY_CODE))  ");

				practSql.append(" Union Select a.nursing_unit_code locn_code, a.long_desc,'N' global_locn_yn,'N' del_flag, b.short_desc,upper(a.long_desc) from ip_nursing_unit a ,am_service b where a.service_code= b.service_code and a.facility_id = '"+facilityID+"' and a.eff_status = 'E'  ");

				if(!search_by.equals("") && !search_txt.equals(""))
			  practSql.append(" and upper(a."+search_by3+")  like upper('"+search_txt+"%')"); 


//				practSql.append(" and (nvl(c.SPECIALTY_CODE,'!') = nvl('"+specialty_code+"','!') or c.SPECIALTY_CODE = nvl('"+specialty_code+"',c.SPECIALTY_CODE)) and ");

				practSql.append(" and a.LOCN_TYPE= '"+location_type+"' and a.nursing_unit_code not in (Select a.locn_code from am_locn_for_oper_stn_vw a where a.Facility_Id ='"+facilityID+"' and a.Oper_Stn_ID = '"+operator_station+"' and a.care_locn_type = '"+location_type+"'");
				
			}

	
			
			practSql.append(" and a.LOCN_TYPE = '"+location_type+"') order by 5 ");

			
		}
		
		else
		{			
			practSql.setLength(0);
			practSql.append(" Select A.SPECIALITY_CODE,a.locn_code,a.locn_long_desc,a.service_desc,a.eff_status,a.global_locn_yn global_locn_yn, 'Y' del_flag,  upper(a.locn_long_desc) from am_locn_for_oper_stn_vw a where a.Facility_Id = '"+facilityID+"' and a.Oper_Stn_ID ='"+operator_station+"' ");

			if(!search_by.equals("") && !search_txt.equals(""))
				  practSql.append(" and upper("+search_by1+")  like upper('"+search_txt+"%')"); 

			if(!specialty_code.equals(""))				
			{
				practSql.append(" and a.Speciality_Code = '"+specialty_code+"' ");
			}
			else
			{
				practSql.append(" and (nvl(a.Speciality_Code,'!') = nvl('"+specialty_code+"','!') or a.Speciality_Code = nvl('"+specialty_code+"',a.Speciality_Code)) ");
			}
			practSql.append(" and a.CARE_LOCN_TYPE = '"+location_type+"' Union Select A.SPECIALITY_CODE, a.clinic_code locn_code, a.long_desc, b.short_desc service_desc,a.eff_status,'N' global_locn_yn,'N' del_flag,upper(a.long_desc) from op_clinic a, am_service b where a.facility_id = '"+facilityID+"'  and a.clinic_type='"+location_type+"' ");

			if(!search_by.equals("") && !search_txt.equals(""))
			  practSql.append(" and upper(a."+search_by2+")  like upper('"+search_txt+"%')"); 

			if(!specialty_code.equals(""))				
			{
				practSql.append(" and a.Speciality_Code = '"+specialty_code+"' ");
			}
			else
			{
				practSql.append(" and (nvl(a.Speciality_Code,'!') = nvl('"+specialty_code+"','!') or a.Speciality_Code = nvl('"+specialty_code+"',a.Speciality_Code)) ");
			}
			practSql.append(" and a.service_Code(+) = b.service_code and a.eff_status = 'E' and a.Clinic_Code not in (Select a.locn_code from am_locn_for_oper_stn_vw a where a.Facility_Id = '"+facilityID+"' and a.Oper_Stn_ID = '"+operator_station+"' ");

			if(!search_by.equals("") && !search_txt.equals(""))
				  practSql.append(" and upper("+search_by1+")  like upper('"+search_txt+"%')"); 

			if(!specialty_code.equals(""))
			{
				practSql.append(" and a.Speciality_Code = '"+specialty_code+"' ");
			}
			else
			{
				practSql.append(" and (nvl(a.Speciality_Code,'!') = nvl('"+specialty_code+"','!') or a.Speciality_Code = nvl('"+specialty_code+"',a.Speciality_Code)) ");
			}
			practSql.append(" and a.CARE_LOCN_TYPE = '"+location_type+"') order by 4 ");
		}

		//out.println("The values pract values"+practSql.toString());
	
		StringBuffer totValues=new StringBuffer();
		StringBuffer totValuesfordis=new StringBuffer();	
		StringBuffer globalValues=new StringBuffer();	
		StringBuffer globalValuesdis=new StringBuffer();	
		
        String global_locn_yn="";   	
	
		int m=0;
		try
		{
		
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=stmt.executeQuery(practSql.toString());
		
		while(rs.next())
		{
			
			totValues.append(rs.getString("locn_code")+"$"+rs.getString("del_flag").substring(0,1)+"$chk"+m+"$E$"+rs.getString("global_locn_yn")+"$chkGlobe"+m+"~");
	  
			 globalValuesdis.append(rs.getString("locn_code")+"$"+rs.getString("del_flag").substring(0,1)+"$chk"+m+"$E$N$chkGlobe"+m+"~");
			
			globalValues.append(rs.getString("locn_code")+"$"+rs.getString("del_flag").substring(0,1)+"$chk"+m+"$E$Y$chkGlobe"+m+"~");
		 
			totValuesfordis.append(rs.getString("locn_code")+"$"+rs.getString("del_flag").substring(0,1)+"$chk"+m+"$D$N$chkGlobe"+m+"~");
			m++;
		
		}
		
		rs.beforeFirst();
		
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();


	  }
	  catch(Exception e4)
	  {
		  out.println("Exception e4 :"+ e4.toString());
	  }
%>	
<body  OnMouseDown="CodeArrest();" onKeyDown = "lockKey()" onload="chkSelect()"  class='CONTENT'>
<form name='facility_form_result' id='facility_form_result'  method='post' target="messageFrame">
<table  width='85%' border=0 align='center'>
<tr>
	<td class="white">
		<table border='0' align='right'>
			<tr>
				<td>
<input type='hidden' name='operator_station' id='operator_station' value='<%=operator_station%>'>
<input type='hidden' name='location_type' id='location_type' value='<%=location_type%>'>
<input type='hidden' name='speciality' id='speciality' value='<%=specialty_code%>'>
<input type='hidden' name='finalSelect' id='finalSelect' value='<%=finalSelect%>'>
<input type='hidden' name='totValues' id='totValues' value='<%=totValues%>'>
<input type='hidden' name='globalValues' id='globalValues' value='<%=globalValues%>'>
<input type='hidden' name='globalValuesdis' id='globalValuesdis' value='<%=globalValuesdis%>'>
<!--input type='hidden' name='totValuesfordis' value='<%=totValuesfordis%>'-->
<input type=hidden name='function_name' id='function_name' value='insert'>
<input type='hidden' name='maxRecord' id='maxRecord' value='<%=maxRecord%>' >
<input type=hidden name='from' id='from' value='<%=start%>'>
<input type=hidden name='to' id='to' value='<%=end%>'>
<input type=hidden name='start' id='start' value='<%=start%>'>
<input type=hidden name='end' id='end' value='<%=end%>'>
<%
    if ( !(start <= 1)) {
%>
 <a href='javascript:submitPrevNext(<%=(start-7)%>,<%=(end-7)%>)' text-decoration='none'> <fmt:message key="Common.previous.label" bundle="${common_labels}"/> </a>
 <input type=hidden name='whichPage' id='whichPage' value='prev'>
<%
    }
    if (!((start+7) >= maxRecord ))
	{
%>
		<a href='javascript:submitPrevNext(<%=(start+7)%>,<%=(end+7)%>)' text-decoration='none'> <fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
	    <input type=hidden name='whichPage' id='whichPage' value='prev'>
<%
    }
%>
</td>
</tr>
</table>
	</td>
	</tr>
	</table>

	<%  if(maxRecord!=0)
			{      
		%>
		<table border='1' cellpadding='0' cellspacing='0' width='85%' align='center'>
			<th width='50%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			<th width='25%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><input type='checkbox'  name='mainChk' id='mainChk'   onClick='parent.frames[0].chkAll(this)'></th>
		
			<%if((global_chkattribute.equals("Y"))&&(Global_Flag.equals("Y")))	{%>  
			<th width='25%'><fmt:message key="Common.Global.label" bundle="${common_labels}"/><input type='checkbox'  name='global_Chk' id='global_Chk' <%=Chkglobal%> onClick='parent.frames[0].chkAll_Global(this)'></th>
			<%}%>
		<% }else
				{
				record_empty="Y";%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
		<% }
		int i=0;
		
		String classValue="",chkAttribute="",chkAttribute1="" ;
		String service_desc="",old_service_desc="",clinic_desc="",locn_code="",del_flag=""/*,eff_status=""*/;
	
		if (start != 0)
		{
			for(int j=1; j<=start; i++,j++)
			{
				rs.next();				
			}
		}		     
		while(rs.next() && i<=end)
		{ 
			service_desc= rs.getString("service_desc");
			clinic_desc=rs.getString("locn_long_desc");
			locn_code=rs.getString("locn_code");
			del_flag= rs.getString("del_flag");
		
			if(Global_Flag.equals("Y")){
	    	    global_locn_yn= rs.getString("global_locn_yn");			     
			    if((del_flag.substring(0,1).equals("Y"))&&(global_locn_yn.equals("Y")))
				chkAttribute1="CHECKED";
			    else
				chkAttribute1="";
			}

			if(del_flag.substring(0,1).equals("Y")){
				chkAttribute="CHECKED";
				disabled_attribute="enabled";
			}else{
				chkAttribute="";				
				disabled_attribute="disabled";	
				all_flg="N";
			}

			if( i%2 == 0)  
				classValue="QRYEVEN";
			else
				classValue="QRYODD";
			if(!service_desc.equals(old_service_desc))	{
				out.println("<tr>");
				out.println("<td class='CAHIGHERLEVELCOLOR' colspan='3'>"+service_desc+"</td></tr>");
				out.println("<tr><td class='"+classValue+"'>"+clinic_desc+"</td>");
				out.println("<td class='"+classValue+"' align='center'><input type='checkbox' "+chkAttribute+"  name='chk"+i+"' id='chk"+i+"' value='"+locn_code+"$"+del_flag.substring(0,1)+"'  onClick='parent.frames[0].chkServices(this,"+i+")'></td>");
         
				if((global_chkattribute.equals("Y"))&&(Global_Flag.equals("Y")))	{	 	
					out.println("<td class='"+classValue+"' align='center'><input type='checkbox' "+Chkglobal+" "+chkAttribute1+" name='chkGlobe"+i+"' id='chkGlobe"+i+"'  onClick='parent.frames[0].chkServices_global(this,"+i+")' "+disabled_attribute+"></td>");
					global_available="Y";

					if(disabled_attribute.equals("disabled") || chkAttribute1.equals("")){
						all_global_flg="N";
					}
				}
			}else{
				out.println("<tr>");
				out.println("<td class='"+classValue+"'>"+clinic_desc+"</td>");
				out.println("<td class='"+classValue+"' align='center'><input type='checkbox' "+ chkAttribute+" name='chk"+i+"' id='chk"+i+"' value='"+locn_code+"$"+del_flag.substring(0,1)+"' onClick='parent.frames[0].chkServices(this,"+i+")'></td>");

				if((global_chkattribute.equals("Y"))&&(Global_Flag.equals("Y")))	{	
					out.println("<td class='"+classValue+"' align='center'><input type='checkbox' "+Chkglobal+" "+chkAttribute1+" name='chkGlobe"+i+"' id='chkGlobe"+i+"'  onClick='parent.frames[0].chkServices_global(this,"+i+")'"+disabled_attribute+"></td>");
					global_available="Y";

					if(disabled_attribute.equals("disabled") || chkAttribute1.equals("")){
						all_global_flg="N";
					}
				}
			}
			out.println("</tr>");
			old_service_desc=service_desc;
			i++;
		}
		
		StringTokenizer st=new StringTokenizer(finalSelect,"~");
		int temp=st.countTokens();	
		for(int u2=0;u2<temp;u2++)
		{			
			String st2=st.nextToken();
			StringTokenizer st1=new StringTokenizer(st2,"$");
			st1.nextToken();
			st1.nextToken();
			String objName=st1.nextToken();
			String enable_dis=st1.nextToken();
			String global_dis=st1.nextToken();			
			
			if(enable_dis.equals("E"))
				out.println("<script>if(eval(\"document.forms[0]."+objName+"\")) document.forms[0]."+objName+".checked=true;</script>");
			else
				out.println("<script>if(eval(\"document.forms[0]."+objName+"\")) document.forms[0]."+objName+".checked=false;</script>");

       	if((global_chkattribute.equals("Y"))&&(Global_Flag.equals("Y")))	{
			   String objName1=st1.nextToken();
			   
			if(global_dis.equals("Y"))
				out.println("<script>if(eval(\"document.forms[0]."+objName1+"\")) document.forms[0]."+objName1+".checked=true;</script>");
			else
				out.println("<script>if(eval(\"document.forms[0]."+objName1+"\")) document.forms[0]."+objName1+".checked=false;</script>");
		   }
		}

	}
	catch(Exception e2){out.print(e2);}
	finally
	{
		try
		{
	  if(rs!=null)		rs.close();
  	  if(stmt!=null)	stmt.close();
	  if(pstmt!=null)	pstmt.close();
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
	  ConnectionManager.returnConnection(con,request);

	}%>
	</table>
	<input type='hidden' name='facilityID' id='facilityID' value="<%=facilityID%>" >
	<input type='hidden' name='search_by' id='search_by' value='<%=search_by%>'>
	<input type='hidden' name='search_txt' id='search_txt' value='<%=search_txt%>'>
	<input type='hidden' name='Chkglobal' id='Chkglobal' value='<%=Chkglobal%>'>
	<input type='hidden' name='all_flg' id='all_flg' value='<%=all_flg%>'>
	<input type='hidden' name='global_available' id='global_available' value='<%=global_available%>'>
	<input type='hidden' name='record_empty' id='record_empty' value='<%=record_empty%>'>
	<input type='hidden' name='all_global_flg' id='all_global_flg' value='<%=all_global_flg%>'>

	
</body>
</html>

