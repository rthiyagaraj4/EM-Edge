<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*, eCommon.Common.*" contentType="text/html;charset=UTF-8"  %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
	
<style>
	.inner_table_site { 
		width:1100px;  
		height:325px;
		overflow-y: auto;	
	} 
	
	tbody>*
	{
		white-space: nowrap;
	}	
	
</style>
	
</head>
<script>
function callonload(){
	if(parent.frames[0].document.getElementById('Search'))
		parent.frames[0].document.getElementById('Search').disabled=false;
	if(parent.frames[0].document.getElementById('clear'))
		parent.frames[0].document.getElementById('clear').disabled=false;
	if(parent.frames[0].document.getElementById("resultPageLoaded"))
		parent.frames[0].document.getElementById("resultPageLoaded").value="Y";
}
</script>
<body onload='callonload();' onKeyDown = 'lockKey()'>
<form name='pract_form' id='pract_form'>
<%
    String user_sql="";
   // String whereClause="";
	request.setCharacterEncoding("UTF-8");	
    String tel_no="";
	String mobile_no="";
	String pager_no="";
	String endOfRes = "1" ;
	String job_title_practDetails="";
	String pract_type_dtls="";
	String pract_type_desc="";
	String pract_name_temp="";
	
	//Below line added for this CRF ML-MMOH-CRF-0862	
	boolean isCernerpractitioner=false;
	String pract_word_wrap="";
	String pract_long_namewidth="";
	String other_desc_width="";	
	String pract_word_wrap_postion="";	
	String other_fields_width="";
    String plusSymbol_width="";	
	String pract_id_width="";
	String pract_full_namewidth="";
	String pract_full_word_wrap="";
	String tab_width="100%";
	String plussymbol_word_wrap="";
	//End this CRF ML-MMOH-CRF-0862 
	
	
	String srch_click			=request.getParameter("srch_click")==null?"N":request.getParameter("srch_click"); 
	String locale				=((String)session.getAttribute("LOCALE"));
	String facility_id			=(String)session.getAttribute("facility_id");
    String pract_type			=request.getParameter("pract_type")==null?"":request.getParameter("pract_type"); 
	String primary_specialty	=request.getParameter("primary_specialty")==null?"":request.getParameter("primary_specialty");
	String pract_id				=request.getParameter("pract_id")==null?"":request.getParameter("pract_id");              	
	String pract_name			=request.getParameter("pract_name")==null?"":request.getParameter("pract_name");         	
	String start_ends_contains	=request.getParameter("start_ends_contains")==null?"S":request.getParameter("start_ends_contains");         
	String job_title			=request.getParameter("job_title")==null?"":request.getParameter("job_title");         
	String gender				=request.getParameter("gender")==null?"":request.getParameter("gender");         
	String bool_user_sql		=request.getParameter("bool_user_sql")==null?"":request.getParameter("bool_user_sql");    
	String toggle_sql2			=request.getParameter("toggle_sql2")==null?"":request.getParameter("toggle_sql2");       
	String radiovalue			=request.getParameter("radiovalue")==null?"":request.getParameter("radiovalue");
	String from					=request.getParameter( "from" ) ;
	String to					=request.getParameter( "to" ) ;
	pract_id=pract_id.trim();
	pract_name=pract_name.trim();
	int start = 0 ;
	int end = 0 ;
	//int k=0;
	if ( from == null ){
		start = 1 ;
	}else{
		start = Integer.parseInt( from ) ;
		/*if(!pract_name.equals("")){
			pract_name = URLDecoder.decode(pract_name,"UTF-8");
		}*/
	}
	if ( to == null ){
		end = 14 ;
	}else{
		end = Integer.parseInt( to ) ;
		/*if(!pract_name.equals("")){
			pract_name = URLDecoder.decode(pract_name,"UTF-8");
		}*/
	}
	if(toggle_sql2.equals("")){
		user_sql       = (String) session.getValue("sql")==null?"":(String) session.getValue("sql");

	}
	if(toggle_sql2.equals("Yes")){
		user_sql       = (String) session.getValue("sqlSec")==null?"":(String) session.getValue("sqlSec");
	}
	if(bool_user_sql.equals("")){
		if(user_sql.equals("") ){
			bool_user_sql="0";
		}else{
			bool_user_sql="1";
		}
	}
	if(!pract_id.equals("") &&  bool_user_sql.equals("0") ){
		if(start_ends_contains.equals("S")){
			pract_id=pract_id+"%";
		}else if(start_ends_contains.equals("E")){
			pract_id="%"+pract_id;
		}else if(start_ends_contains.equals("C")){
			pract_id="%"+pract_id+"%";
		}
	}
	String code="";
	String desc="";
%>
<script>



	function closew(Dcode,position,tel,mobile,pager,job_title,pract_type,pract_type_desc,count,Name)
	{
		if(count!=1)
		{
			var Name= eval('document.forms[0].desc'+position).value;
			//this loop is to remove the %20 addition in description feilds
			while(Name.indexOf("+")!=-1)
		  	{
				Name=Name.replace('+'," ");
	 	  	}
		  	while(pract_type_desc.indexOf("+")!=-1)
		  	{
				pract_type_desc=pract_type_desc.replace('+'," ");
	 	  	}
		}
		window.returnValue=Dcode+"~"+Name+"~"+tel+"~"+mobile+"~"+pager+"~"+job_title+"~"+pract_type+"~"+pract_type_desc;
		window.close();
	  }
/******function to show practitioner details*********************/
	async function showPractWindow(practID)
	{
	    var url     ="../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	    //var dialogHeight    = "30" ;
	    //var dialogWidth = "40" ;
		var dialogHeight    = "80vh" ;
	    var dialogWidth = "80vw" ;
		
		//Added for this CRF ML-MMOH-CRF-0862
		if(document.forms[0].isCernerpractitioner && document.forms[0].isCernerpractitioner.value=="true"){
			// dialogHeight    = "30" ;
	         //dialogWidth = "60" ;	
				dialogWidth	= "80vw";		 
		}		
		//End this CRF ML-MMOH-CRF-0862
	    var dialogLeft="";
	    var arguments   = "" ;
	    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	    var reportURL   = await top.window.showModalDialog( url, arguments, features ) ;
	    
	}

 </script>


<%
Connection conn=null;
PreparedStatement stmt=null;
ResultSet rs=null;
ResultSet rs1=null;

ResultSet rs_practDetail=null;
PreparedStatement pstmt_practDetail=null;

String searchtext="";
int i=1;
String dispDescFirst =request.getParameter("dispDescFirst");
if(dispDescFirst == null) dispDescFirst="";

try{
	conn=ConnectionManager.getConnection(request);

 //Below line added for this CRF ML-MMOH-CRF-0862	    
  isCernerpractitioner=CommonBean.isSiteSpecific(conn, "AM","CERNER_PRACTITIONER_ID");
  if(isCernerpractitioner){
     pract_word_wrap="word-wrap: break-word;width:248px";	
     pract_long_namewidth="248px";  
	 other_fields_width="130px";
	 pract_id_width="130px";
     plusSymbol_width="20px";	
	 plussymbol_word_wrap="word-wrap: break-word;width:20px";
     pract_word_wrap_postion="word-wrap: break-word;width:130px";	
     //pract_full_namewidth="167.5px";	 
	 //pract_full_word_wrap="word-wrap: break-word;width:167.5px";	
	 pract_full_namewidth="168px";
	 pract_full_word_wrap="word-wrap: break-word;width:168px";
	 //tab_width="1100px";
	 tab_width="1110px";
	 if(dispDescFirst.equals("dispDescFirst"))  tab_width="100%";
  }
  //End this CRF ML-MMOH-CRF-0862



String sql="";

//String searchcriteria=request.getParameter("search_criteria");
searchtext = request.getParameter("searchtext");
if(searchtext == null) searchtext="";





if(bool_user_sql.equals("0")){
	//out.println("<script>alert(\"inside default:-----"+bool_user_sql+"\")</script>");
	sql = "SELECT a.practitioner_id  practitioner_id, a.practitioner_name practitioner_name,b.desc_sysdef practitioner_type ,c.short_desc  primary_specialty,d.POSITION_CODE job_title,am_get_desc.AM_POSITION(d.POSITION_CODE, '"+locale+"','1') job_title_desc ,a.gender FROM am_practitioner_lang_vw a, am_pract_type_lang_vw b,am_speciality_lang_vw c,am_position_lang_vw d, am_pract_for_facility e WHERE a.pract_type=NVL('"+pract_type+"',a.pract_type) And A.PRACTITIONER_ID=E.PRACTITIONER_ID AND E.FACILITY_ID='"+facility_id+"' AND a.primary_speciality_code=NVL('"+primary_specialty+"',a.primary_speciality_code) AND a.EFF_STATUS='E' AND A.EFF_STATUS=E.EFF_STATUS AND a.practitioner_id like upper(NVL('"+pract_id+"',a.practitioner_id)) AND  a.gender=NVL('"+gender+"',a.gender) AND UPPER(NVL(a.position_code,'123')) LIKE UPPER(NVL('"+job_title+"',NVL(a.position_code,'123'))) AND a.pract_type=b.pract_type AND a.primary_speciality_code=c.speciality_code AND  a.position_code=d.position_code(+) and a.language_id='"+locale+"' and b.language_id='"+locale+"' and c.language_id='"+locale+"' and d.language_id(+)='"+locale+"' and  upper(a.practitioner_name) LIKE ";
	if(start_ends_contains.equals("S")){
		pract_name_temp=pract_name+"%";
		sql=sql+"upper(?)";
	}else if(start_ends_contains.equals("E")){
		pract_name_temp="%"+pract_name;
		sql=sql+"upper(?)";
	}else if(start_ends_contains.equals("C")){
		pract_name_temp="%"+pract_name+"%";
		sql=sql+"upper(?)";
	}
}else{
	sql=user_sql;
	// break the incoming sql... if the position_code is fetched, include th get desc also for teh position code.
	int job_title_ind=sql.toUpperCase().indexOf("POSITION_CODE");
	int from_ind=sql.toUpperCase().indexOf("FROM");
	StringBuffer strbff=new StringBuffer();
	if(job_title_ind>0 && (job_title_ind<from_ind)){
		strbff.append(sql.substring(0,job_title_ind-2));
		if((sql.substring(job_title_ind-1,job_title_ind)).equals(".")){
			strbff.append("am_get_desc.AM_POSITION("+sql.substring(job_title_ind-2,job_title_ind)+"POSITION_CODE, '"+locale+"','1') job_title_desc,");
		}else{
			strbff.append(",am_get_desc.AM_POSITION(POSITION_CODE, '"+locale+"','1') job_title_desc");
		}
		strbff.append(sql.substring(job_title_ind-2,sql.length()));
		sql= strbff.toString();
	}else{
		strbff.append(sql.substring(0,from_ind));
		strbff.append(",am_get_desc.AM_POSITION(b.POSITION_CODE, '"+locale+"','1') job_title_desc ");
		strbff.append(sql.substring(from_ind,sql.length()));
		sql= strbff.toString();
	}
	strbff=null;
}

	
//sql=sql.toUpperCase();
int sqlind=sql.indexOf("order by");
if(sqlind == -1)
{
	sqlind=sql.indexOf("ORDER BY");
}

if(sqlind != -1)
{
	sql = sql.substring(0,sqlind-1);
}

try{

if(radiovalue.equals("C")){
sql=sql+" order by practitioner_id";
}
else{
sql=sql+" order by practitioner_name";
}
stmt = conn.prepareStatement(sql);




if(bool_user_sql.equals("0")){
	stmt.setString(1,pract_name_temp);

}else{



if(toggle_sql2.equals("")){
	
	if(start_ends_contains.equals("S"))
	{
		pract_name_temp=pract_name+"%";
		pract_id=pract_name+"%";
	}
	else if(start_ends_contains.equals("E"))
	{
			pract_name_temp="%"+pract_name;
			pract_id="%"+pract_name;

	}
	else if(start_ends_contains.equals("C"))
	{
			pract_name_temp="%"+pract_name+"%";
			pract_id="%"+pract_name+"%";

	}
}else{
	

	if(start_ends_contains.equals("S"))
	{
		pract_name_temp=pract_name+"%";
		pract_id=pract_id+"%";
	}
	else if(start_ends_contains.equals("E"))
	{
			pract_name_temp="%"+pract_name;
			pract_id="%"+pract_id;

	}
	else if(start_ends_contains.equals("C"))
	{
			pract_name_temp="%"+pract_name+"%";
			pract_id="%"+pract_id+"%";

	}

}


	if(pract_type.equals("")){
		stmt.setString(1,"%");
	}else{
		stmt.setString(1,pract_type);
	}

	if(primary_specialty.equals("")){
		stmt.setString(2,"%");
	}else{
		stmt.setString(2,primary_specialty);
	}


	if(pract_id.equals("")){
		stmt.setString(3,"%");
	}else{
		stmt.setString(3,pract_id);
	}

	if(pract_name.equals("")){
		stmt.setString(4,"%");
	}else{
		stmt.setString(4,pract_name_temp);
	}

	

	if(gender.equals("")){
		stmt.setString(5,"%");
	}else{
		stmt.setString(5,gender);
	}


	if(job_title.equals("")){
		stmt.setString(6,"%");
	}else{
		stmt.setString(6,job_title);
	}
    }

rs = stmt.executeQuery();
	String gender1="";
	String pract_id1="";
	String pract_name1="";
	String gender2	="";
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rs.next() ;
	int count=0;
	while(i<=end && rs.next()){

     
	if(count==0)
		{%>
			
			<table align='right' border='0' >
<tr>
<td>
<%


if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/GeneralPractitionerSearchResult.jsp?dispDescFirst="+dispDescFirst+"&bool_user_sql="+URLEncoder.encode(bool_user_sql)+"&from="+(start-14)+"&to="+(end-14)+"&fromLink="+URLEncoder.encode("Yes")+"&pract_type="+URLEncoder.encode(pract_type)+"&primary_specialty="+URLEncoder.encode(primary_specialty)+"&pract_id="+URLEncoder.encode(pract_id,"UTF-8")+"&gender="+URLEncoder.encode(gender)+"&job_title="+URLEncoder.encode(job_title)+"&toggle_sql2="+URLEncoder.encode(toggle_sql2)+"&start_ends_contains="+URLEncoder.encode(start_ends_contains)+"&pract_name="+URLEncoder.encode(pract_name,"UTF-8")+"&radiovalue="+radiovalue+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if (endOfRes.equals("1") ) 
	out.println("<A id='nextval' HREF='../../eAM/jsp/GeneralPractitionerSearchResult.jsp?dispDescFirst="+dispDescFirst+"&bool_user_sql="+URLEncoder.encode(bool_user_sql)+"&from="+(start+14)+"&to="+(end+14)+"&fromLink="+URLEncoder.encode("Yes")+"&pract_id="+URLEncoder.encode(pract_id,"UTF-8")+"&pract_type="+URLEncoder.encode(pract_type)+"&primary_specialty="+URLEncoder.encode(primary_specialty)+"&gender="+URLEncoder.encode(gender)+"&job_title="+URLEncoder.encode(job_title)+"&toggle_sql2="+URLEncoder.encode(toggle_sql2)+"&start_ends_contains="+URLEncoder.encode(start_ends_contains)+"&pract_name="+URLEncoder.encode(pract_name,"UTF-8")+"&radiovalue="+radiovalue+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");


%>
</td>
</tr>
</table>
<BR><BR>
</P>
   <%if(isCernerpractitioner){%>    
	 <table class="head" width="<%=tab_width%>"  border="1" cellpadding="0" cellspacing="0">
	<%}else {%>	
	 <table border="1" width="<%=tab_width%>" cellspacing='0' cellpadding='0' id='tb1'>	
<%	}
	
			if(dispDescFirst.equals("dispDescFirst")) {%>
			<th width='60%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<th width='40%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<%} else {%>
			<th width='<%=plusSymbol_width%>'>+</th>
			<th width='<%=pract_id_width%>' ><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>			
			<th width='<%=pract_full_namewidth%>' ><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
			<%if(isCernerpractitioner){%> 
			<th width='<%=pract_long_namewidth%>' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.longname.label" bundle="${common_labels}"/></th>
			<%}%>
			<th width='<%=other_fields_width%>' ><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></th>
			<th width='<%=other_fields_width%>' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
			<th width='<%=other_fields_width%>' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
			<th width='<%=other_fields_width%>' ><fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
			
	  <%  
		} 
		//Added for this CRF ML-MMOH-CRF-0862
		if(isCernerpractitioner){%>
		</table>
		  <div class="inner_table_site">
		  <table class="head" width="<%=tab_width%>"  border="1" cellpadding="0" cellspacing="0">		  
		<%}
		//End this CRF ML-MMOH-CRF-0862
	
	}

count++;

%>
<%
	String rowclass = "" ;
	String me="";
	
		if ( i % 2 == 0 )
			rowclass = "QRYEVEN" ;
		else
			rowclass = "QRYODD" ;

	pract_name1	=	rs.getString("practitioner_name");

	 gender2		=	rs.getString("gender");
	

if(gender2.equals("M") || gender2.equalsIgnoreCase("MALE"))
{
	gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
}else if(gender2.equals("F")|| gender2.equalsIgnoreCase("FEMALE"))
{
	gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
}else if(gender2.equals("U")|| gender2.equalsIgnoreCase("UNKNOWN"))
{
	gender1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
}



   pract_id1	        	=	rs.getString("practitioner_id");
	code							=	rs.getString("practitioner_type");
	desc							=	rs.getString("primary_specialty");
	try{
		job_title_practDetails			=rs.getString("job_title_desc");
	}catch(Exception nocolumn){
		
		nocolumn.printStackTrace();
	}
	
	



// block commented  to reduce un neseccary query for tel/pager/mobile/position. 
// handled internally in  RegPatReferral1.js

/*

	String sql_pract_detail="select off_tel_num,mobile_num,pager_num,am_get_desc.AM_POSITION(POSITION_CODE, '"+locale+"','1') job_title,pract_type,am_get_desc.am_pract_type(pract_type,'"+locale+"',2) pract_type_desc from am_practitioner  where practitioner_id=? ";

	pstmt_practDetail   = conn.prepareStatement(sql_pract_detail) ;
	pstmt_practDetail.setString( 1, pract_id1);
	 rs_practDetail = pstmt_practDetail.executeQuery() ;
	 
		if(rs_practDetail != null)
		{
			while(rs_practDetail.next())
			{
				tel_no = rs_practDetail.getString("off_tel_num");
				if(tel_no==null) tel_no="";

		
				
				mobile_no = rs_practDetail.getString("mobile_num");
				if(mobile_no==null) mobile_no="";

				pager_no = rs_practDetail.getString("pager_num");
				if(pager_no==null) pager_no="";
			
				job_title_practDetails = rs_practDetail.getString("job_title");
				if(job_title_practDetails==null) job_title_practDetails="";
			
				pract_type_dtls = rs_practDetail.getString("pract_type");
				if(pract_type_dtls==null) pract_type_dtls="";
			
				pract_type_desc = rs_practDetail.getString("pract_type_desc");
				if(pract_type_desc==null) pract_type_desc="";
		
			
			}
		}if (rs_practDetail != null) rs_practDetail.close();
			if (pstmt_practDetail != null) pstmt_practDetail.close();

*/	



    //Below line commented for this CRF ML-MMOH-CRF-0862
	//out.println("<tr style='background-color:;'><td class='"+rowclass+"'>");	


	%>
	<input type='hidden' name="desc<%=i%>" id="desc<%=i%>" value="<%=pract_name1%>" >
	<%
		if(dispDescFirst.equals("dispDescFirst")) {
		me=desc+"::"+code;
		//Below line added for this CRF ML-MMOH-CRF-0862
		out.println("<tr style='background-color:;'><td width='60%' class='"+rowclass+"'>");
	%>
		<a href=javascript:closew("<%=java.net.URLEncoder.encode(me)%>")>
	<%	out.println(desc+"</a></td><td width='40%' class='"+rowclass+"'>");
		out.println( code+"</td></tr>" );
		}
		//used as of now...
		else
		{
		me=code;		
		//Below line added for this CRF ML-MMOH-CRF-0862
		out.println("<tr style='background-color:;'><td class='"+rowclass+"' width ='"+plusSymbol_width+"' style='"+plussymbol_word_wrap+"' >");
		
		out.println("<a href=\"javascript:showPractWindow('"+pract_id1+"')\">+</a></td>");
		%>
		<td class=<%=rowclass%> width='<%=pract_id_width%>' style='<%=pract_word_wrap_postion%>'  >		  
		<a  href='javascript:closew("<%=pract_id1%>","<%=i%>","<%=tel_no%>","<%=mobile_no%>","<%=pager_no%>","<%=job_title_practDetails%>","<%=pract_type_dtls%>","<%=pract_type_desc%>")'> <%=pract_id1%></a></td>
		
		<%
		//Added for this CRF ML-MMOH-CRF-0862
		if(isCernerpractitioner){
		out.println("<td class='"+rowclass+"' width ='"+pract_full_namewidth+"' style='"+pract_full_word_wrap+"' >");
		if(!locale.equals("en")) {%>
		 <a href='javascript:closew("<%=pract_id1%>","<%=i%>","<%=tel_no%>","<%=mobile_no%>","<%=pager_no%>","<%=job_title_practDetails%>","<%=pract_type_dtls%>","<%=pract_type_desc%>")'>
		<%}else
		{ %>
		<a href='javascript:closew("<%=pract_id1%>","<%=i%>","<%=tel_no%>","<%=mobile_no%>","<%=pager_no%>","<%=job_title_practDetails%>","<%=pract_type_dtls%>","<%=pract_type_desc%>")'>
		<%}
		
		out.println( pract_name1	+"</a></td>" );
		}
		//End this CRF ML-MMOH-CRF-0862
		
		out.println( "<td class='"+rowclass+"' width ='"+pract_long_namewidth+"' style='"+pract_word_wrap+"' >");
				
		if(!locale.equals("en")) {%>
		 <a href='javascript:closew("<%=pract_id1%>","<%=i%>","<%=tel_no%>","<%=mobile_no%>","<%=pager_no%>","<%=job_title_practDetails%>","<%=pract_type_dtls%>","<%=pract_type_desc%>")'>
		<%}else
		{ %>
		<a href='javascript:closew("<%=pract_id1%>","<%=i%>","<%=tel_no%>","<%=mobile_no%>","<%=pager_no%>","<%=job_title_practDetails%>","<%=pract_type_dtls%>","<%=pract_type_desc%>")'>
		<%}
		//Added for this CRF ML-MMOH-CRF-0862
		if(isCernerpractitioner){
		  //Below line added for this CRF ML-MMOH-CRF-0862	    
		  String long_name=CommonBean.getPractitionerLongName(conn, pract_id1, locale);		
           if(long_name.equals("")) long_name="&nbsp;";
           out.println(long_name +"</a></td>" );		
		}else{	
		   out.println( pract_name1	+"</a></td>" );
		}
		//End this CRF ML-MMOH-CRF-0862		
				
		out.println("<td class='"+rowclass+"' width ='"+other_fields_width+"' style='"+pract_word_wrap_postion+"' >");
		out.println(code+"</td><td  class='"+rowclass+"' width ='"+other_fields_width+"' style='"+pract_word_wrap_postion+"' >");
		out.println( desc+"</td>" );
		out.println( "<td class='"+rowclass+"' width ='"+other_fields_width+"' style='"+pract_word_wrap_postion+"' >"+gender1+"</td>" );
		

		//job_title1=job_title_practDetails;
		if(job_title_practDetails==null || job_title_practDetails.equals("null"))
			{
			job_title_practDetails="&nbsp;";
			}
			if(job_title_practDetails!=null && job_title_practDetails.equals("")){
				job_title_practDetails="&nbsp;";
			}
		%><td class='<%=rowclass%>' width='<%=other_fields_width%>' style="<%=pract_word_wrap_postion%>" ><%=job_title_practDetails%></td></tr><%
		}
		i++;	  
	 }
	 
	 if(count==0)
	{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));if(parent.frames[0].document.getElementById('radiovalue').value == 'D'){ if(parent.frames[0].document.getElementById('pract_name')) parent.frames[0].document.getElementById('pract_name').readOnly=false; }else if (parent.frames[0].document.getElementById('radiovalue').value == 'C'){if(parent.frames[0].document.getElementById('pract_id')) parent.frames[0].document.getElementById('pract_id').readOnly=false; }else {if(parent.frames[0].document.getElementById('pract_name')) parent.frames[0].document.getElementById('pract_name').readOnly=false;} if(parent.frames[0].document.getElementById('Search')) parent.frames[0].document.getElementById('Search').disabled=false; if(parent.frames[0].document.getElementById('clear')) parent.frames[0].document.getElementById('clear').disabled=false; document.location.href='../../eCommon/html/blank.html'</script>");

	}
	 
	
	 if ( count < 14 || (!rs.next()) ) {

%>
	
	<script >
	
	if (document.getElementById('nextval'))
		document.getElementById('nextval').style.visibility='hidden';
	if(<%=count%>==1 && <%=start%>==1 && "<%=srch_click%>"=="N")
		 {	
closew("<%=pract_id1%>","<%=i%>","<%=tel_no%>","<%=mobile_no%>","<%=pager_no%>","<%=job_title_practDetails%>","<%=pract_type_dtls%>","<%=pract_type_desc%>","<%=count%>","<%=pract_name1%>")
		 }

	</script>
<% 
		} else {%>
	<script >
	
	if (document.getElementById('nextval'))
		document.getElementById('nextval').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
	 
  %>
<script>

if(parent.frames[0].document.getElementById('pract_id'))
parent.frames[0].document.getElementById('pract_id').readOnly=false;                     

if(parent.frames[0].document.getElementById('pract_name'))
parent.frames[0].document.getElementById('pract_name').readOnly=false;               


if(parent.frames[0].document.getElementById('Search'))
parent.frames[0].document.getElementById('Search').disabled=false;

if(parent.frames[0].document.getElementById('clear'))
parent.frames[0].document.getElementById('clear').disabled=false;

</script>
	  <%
   
   if (rs != null) rs.close();if (stmt != null) stmt.close();
}catch(Exception e) { 
	e.printStackTrace();
}
	finally
	{
	
		if (rs != null) rs.close();
		if (rs1 != null) rs1.close();
		if (pstmt_practDetail != null) pstmt_practDetail.close();
		if (rs_practDetail != null) rs_practDetail.close();
		if (stmt != null) stmt.close();
	
	
	
	} 

%>
</table>
<%if(isCernerpractitioner){%>
</div>
<%}%>
<input type='hidden' name='searchtext' id='searchtext' value="<%=searchtext%>" > 
<input type='hidden' name='resultPageLoaded' id='resultPageLoaded' value="Y" > 
<!--Below line added for this CRF ML-MMOH-CRF-0862--> 
<input type='hidden' name='isCernerpractitioner' id='isCernerpractitioner' value="<%=isCernerpractitioner%>" >  
</form>

</BODY>
</html>
<%
}catch(Exception e) { 
	
e.printStackTrace();
}
	finally
	{
		if (conn != null) 
			ConnectionManager.returnConnection(conn,request);
	}	

%>

