<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<script language='javascript' src='../../eCommon/js/common.js'></script>

<%

Connection con             = null;
ResultSet rs	           = null;
java.sql.Statement stmt	   = null;
String sql         = "";
//String postmortem_reqd_yn = "";
//String position_desc         ="";
request.setCharacterEncoding("UTF-8");
String ref_code           = request.getParameter("ref_code")==null?"":request.getParameter("ref_code");
String ref_type           = request.getParameter("ref_type")==null?"":request.getParameter("ref_type");
String regpat           = request.getParameter("regpat")==null?"":request.getParameter("regpat");


String locale=(String)session.getAttribute("LOCALE"); 
String facilityid=(String)session.getValue("facility_id");
String hcare_type_code=request.getParameter("hcare_type_code") == null?"":request.getParameter("hcare_type_code");
//String area_desc           = null;
try
{  /* if(ref_code.equals("L"))
	{
	sql="select FACILITY_ID,FACILITY_NAME from sm_facility_param where facility_id='"+facilityid+"'";
	}
	 else if(ref_code.equals("E"))
	{
	
	sql="select FACILITY_ID,FACILITY_NAME from sm_facility_param where facility_id!='"+facilityid+"' order by 2";
	
	}else if(ref_code.equals("X"))
	{
     sql="select REFERRAL_CODE,SHORT_DESC from AM_referral where eff_status='E' order by 2";
	}*/

	if(ref_code.equals("L"))
	{
		sql="SELECT  a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc FROM sm_facility_param_lang_vw a, am_hcare_setting_type_lang_vw b  WHERE a.LANGUAGE_ID='"+locale+"' and a.LANGUAGE_ID=b.LANGUAGE_ID and a.hcare_setting_type_code = b.hcare_setting_type_code  AND a.facility_id = '"+facilityid+"' ORDER BY b.short_desc";
	}else if(ref_code.equals("E"))
	{
		sql="SELECT  a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc FROM sm_facility_param_lang_vw a, am_hcare_setting_type_lang_vw b  WHERE a.LANGUAGE_ID='"+locale+"' and a.LANGUAGE_ID=b.LANGUAGE_ID and a.hcare_setting_type_code = b.hcare_setting_type_code and  a.hcare_setting_type_code ='"+hcare_type_code+"' AND a.facility_id != '"+facilityid+"' ORDER BY b.short_desc";
		
		
	}else if(ref_code.equals("X"))
	{
		sql="Select  a.REFERRAL_CODE referred_to_id,a.SHORT_DESC referred_to_id_desc, a.healthcare_setting_type hcare_setting_type, b.short_desc hcare_setting_type_desc from am_referral_lang_vw a, am_hcare_setting_type_lang_vw b where    a.LANGUAGE_ID='"+locale+"'  and a.LANGUAGE_ID=b.LANGUAGE_ID  and a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' and  a.healthcare_setting_type='"+hcare_type_code+"' order by a.short_desc";

		
	}
	
%>
	
  <script>
 if("<%=regpat%>"=="regpat")
var obj =parent.frames[3].document.forms[0].referral_source
else
 var obj =parent.frames[3].document.forms[0].referral_source
	var length  = obj.length;
	for(i=0;i<length;i++) {obj.remove(0);}

    var opt= parent.frames[1].document.createElement('Option');
    opt.text='----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
    opt.value="";
    obj.add(opt) ;     
   
   </script>
	
<%	
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);
int i=1;
	while(rs.next())
	{
		hcare_type_code=rs.getString(3);
		%>
	
 <script>
if("<%=regpat%>"=="regpat")
var opt= parent.frames[3].document.createElement('Option');
else
var opt= parent.frames[1].document.createElement('Option');
opt.text="<%=rs.getString(2)%>"; 
opt.value="<%=rs.getString(1)%>";
obj.add(opt) ;

if("<%=rs.getString(1)%>"=="<%=ref_type%>")
		{
if("<%=regpat%>"=="regpat")
{
parent.frames[3].document.MO_regn_form.referral_source.options['<%=i%>'].selected=true;
}else
{

parent.frames[1].document.MO_regn_form.referral_source.options['<%=i%>'].selected=true;
}
		}
	 <%if(regpat.equals("regpat"))
		{
		if(ref_code.equals("L"))
		{%>
		parent.frames[3].document.MO_regn_form.referral_source.options[1].selected=true;
		parent.frames[3].document.MO_regn_form.referral_source.disabled=true;
		parent.frames[3].document.MO_regn_form.hcare_type.value="<%=hcare_type_code%>";
		parent.frames[3].document.MO_regn_form.hcare_type.disabled=true;
		<%}else{%>
		parent.frames[3].document.MO_regn_form.referral_source.disabled=false;
		parent.frames[3].document.MO_regn_form.hcare_type.disabled=false;
		
		<%}}else
		{if(ref_code.equals("L")){%>
		parent.frames[3].document.MO_regn_form.referral_source.options[1].selected=true;
		parent.frames[3].document.MO_regn_form.referral_source.disabled=true;
		parent.frames[3].document.MO_regn_form.hcare_type.value="<%=hcare_type_code%>";
		parent.frames[3].document.MO_regn_form.hcare_type.disabled=true;
		<%}else{%>
		parent.frames[3].document.MO_regn_form.referral_source.disabled=false;
		parent.frames[3].document.MO_regn_form.hcare_type.disabled=false;
		
		
		
		
		
		<%}}%>
	</script>
	<%
	i++;

}
 
 if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();

 }
 catch(Exception ee)
 {
	if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
	ee.printStackTrace();
 }
finally
{
   ConnectionManager.returnConnection(con,request);
}

%>


