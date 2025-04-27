
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Connection con = null;
	try
	{
		con=ConnectionManager.getConnection(request);
		Statement stmt	= null;
		ResultSet rs	= null;
		String Patient_Id = request.getParameter("Patient_Id");
		String facilityid=(String)session.getValue("facility_id");
		
		String episodeID="";
		String visitNum="";
		String Pat_Details="";
		String PatDetails="";
		String bl_details="";
		
		String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
		String resp_id = (String) session.getValue("responsibility_id");
		String selectSql = "";
		String view_pat_photo_yn = "N";
		 String locale=(String)session.getAttribute("LOCALE");
int counter1=0;
		
		
	

%>
<html>
<head>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<SCRIPT LANGUAGE="JavaScript">
	function ViewPatDtl(Pat_id)
	{
		Pat_id=unescape(Pat_id)

		var url         = "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(Pat_id);
		var dialogTop = "70" ;
		var dialogHeight= "40" ;
		var dialogWidth	= "65" ;
		var arguments   = "" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
		var returnval = window.showModalDialog( url, arguments, features ) ;
	}

	function blank() {}

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>
<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%

stmt = con.createStatement();
if(bl_install_yn.equals("Y"))
				{     
	 
		rs = stmt.executeQuery("select BL_PROC_ITEM_VALIDATIONS_MP.GET_PATIENT_BANNER('"+facilityid+"','"+Patient_Id+"','','','"+locale+"')bl_dtls from dual");
		if(rs != null && rs.next()) 
		{
			bl_details = rs.getString("bl_dtls")==null?"":rs.getString("bl_dtls");
		}
				}
		//stmt = con.createStatement();
		
		rs = stmt.executeQuery("select get_patient_line('"+Patient_Id+"','"+locale+"') from dual");
		
		if(rs != null && rs.next()) 
		{
			Pat_Details = rs.getString(1);
		}
		PatDetails = Pat_Details.substring(0,(Pat_Details.indexOf("#")));
		
		 StringTokenizer token=new StringTokenizer(PatDetails,",");
		 counter1=token.countTokens();
		

		 if(rs != null) rs.close();

		selectSql = "select view_pat_photo_yn from mp_access_rights where resp_id = '"+resp_id+"' ";
	//	stmt = con.createStatement();

		rs = stmt.executeQuery(selectSql);
		if (rs != null && rs.next())
		{
			view_pat_photo_yn = rs.getString(1);
			if(view_pat_photo_yn == null || view_pat_photo_yn.equals("null")) view_pat_photo_yn = "N";
		}
		if(rs != null) rs.close();

		//String pat_details1=PatDetails;
		int counter=counter1;
		String name_val = "";
		String name_val1 = "";
		String gen_val  = "";
		String date_of_val = "";
		String pat_id = "";
		String gen_val1 = "";
		String pref_val = "";
		String[] arg_vals = new String[10];
		String final_value = "";
		String suf_val = "";

		int i=0;
		while (token.hasMoreTokens()) {
			arg_vals[i]=token.nextToken();
			arg_vals[i]=arg_vals[i].trim();
			i++;
		}
		if(counter==4)
		{
		name_val=arg_vals[0];
		//name1_val=pat_details1[1];
		gen_val=arg_vals[1];
		date_of_val=arg_vals[2];
		pat_id=arg_vals[3];

		if(gen_val.equals("M"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}else if(gen_val.equals("F"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else if(gen_val.equals("U"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		 final_value=name_val+","+date_of_val+","+gen_val1+","+pat_id;
		}
		else if(counter ==5)
		{
		name_val=arg_vals[0];
		pref_val=arg_vals[1];
		gen_val=arg_vals[2];
		date_of_val=arg_vals[3];
		pat_id=arg_vals[4];
		if(gen_val.equals("M"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}else if(gen_val.equals("F"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else if(gen_val.equals("U"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		 final_value=name_val+","+pref_val+","+date_of_val+","+gen_val1+","+pat_id;
		}
		else if(counter ==6)
		{
		suf_val=arg_vals[0];
		name_val=arg_vals[1];
		pref_val=arg_vals[2];
		gen_val=arg_vals[3];
		date_of_val=arg_vals[4];
		pat_id=arg_vals[5];
		if(gen_val.equals("M"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}else if(gen_val.equals("F"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else if(gen_val.equals("U"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		 final_value=suf_val+","+name_val+","+pref_val+","+date_of_val+","+gen_val1+","+pat_id;
		}else if(counter==7)
		{


		suf_val=arg_vals[0];
		name_val=arg_vals[1];
		name_val1=arg_vals[2];
		pref_val=arg_vals[3];
		gen_val=arg_vals[4];
		date_of_val=arg_vals[5];
		pat_id=arg_vals[6];
		if(gen_val.equals("M"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}else if(gen_val.equals("F"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else if(gen_val.equals("U"))
		{
		gen_val1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		 final_value=suf_val+","+name_val+","+name_val1+","+pref_val+","+date_of_val+","+gen_val1+","+pat_id;
		}

%>
<script>
 /*var pat_details1="<%=PatDetails%>";
var counter="<%=counter1%>";
var name_val;
var gen_val;
var date_of_val;
var pat_id;
var gen_val1;
var pref_val;
var final_value;
if(counter=="4")
{
pat_details1=pat_details1.split(",");
name_val=pat_details1[0];
//name1_val=pat_details1[1];
gen_val=pat_details1[1];
date_of_val=pat_details1[2];
pat_id=pat_details1[3];
/*alert('name_val:'+name_val);
alert('gen_val:'+gen_val);
alert('date_of_val:'+date_of_val);
alert('pat_id:'+pat_id);

if(gen_val == " M")
{
gen_val1=getLabel("Common.male.label","common");
}else if(gen_val ==" F")
{
gen_val1=getLabel("Common.female.label","common");
}else if(gen_val ==" U")
{
gen_val1=getLabel("Common.unknown.label","common");
}
 final_value=name_val+","+date_of_val+","+gen_val1+","+pat_id;
}else if(counter =="5")
{
pat_details1=pat_details1.split(",");
name_val=pat_details1[0];
pref_val=pat_details1[1];
gen_val=pat_details1[2];
date_of_val=pat_details1[3];
pat_id=pat_details1[4];
if(gen_val == " M")
{
gen_val1=getLabel("Common.male.label","common");
}else if(gen_val ==" F")
{
gen_val1=getLabel("Common.female.label","common");
}else if(gen_val ==" U")
{
gen_val1=getLabel("Common.unknown.label","common");
}
 final_value=name_val+","+pref_val+","+date_of_val+","+gen_val1+","+pat_id;
}else if(counter =="6")
{
pat_details1=pat_details1.split(",");
suf_val=pat_details1[0];
name_val=pat_details1[1];
pref_val=pat_details1[2];
gen_val=pat_details1[3];
date_of_val=pat_details1[4];
pat_id=pat_details1[5];
if(gen_val == " M")
{
gen_val1=getLabel("Common.male.label","common");
}else if(gen_val ==" F")
{
gen_val1=getLabel("Common.female.label","common");
}else if(gen_val ==" U")
{
gen_val1=getLabel("Common.unknown.label","common");
}
 final_value=suf_val+","+name_val+","+pref_val+","+date_of_val+","+gen_val1+","+pat_id;
}*/
</script>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
<tr>
	<%if(view_pat_photo_yn.equals("Y")) { %>
	<td width="5%" class='PATIENTLINECOLOR' ><img onClick='showPatientImage("<%=Patient_Id%>");' align='left' src='../../eMP/images/PatientPhoto.gif' onMouseOver='style.cursor="hand";title="Click to View Patient Photo"'></img></td>
<%}
	//else { 
		%> <!-- <td width="5%" class='PATIENTLINECOLOR'>&nbsp;</td> --> <%
		//}
	
	%>

	<td  class='PATIENTLINECOLOR'  style='position:relative;' nowrap style="cursor:pointer;" onClick="ViewPatDtl('<%=Patient_Id%>')"><font  size='<%=(PatDetails.length()>50?"-5":"2")%>'><%=final_value%></td>
	<%
		if(!bl_details.trim().equals("")){%>
	<td  class='PATIENTLINECOLOR' id='outstdAmt' >&nbsp;</td><td  class='PATIENTLINECOLOR'  style='position:relative;' nowrap style="cursor:pointer;" onClick="ViewBLDtl('<%=episodeID%>','<%=visitNum%>','<%=Patient_Id%>')"><font  size='2'><%=bl_details%></td>
<%}else%>
<td></td>
</tr>
</body>
</html>
<%	if(stmt != null) stmt.close();
	if(rs != null) rs.close();
	}catch(Exception e){
		out.println(e);
		e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>

