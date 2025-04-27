
       
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
 
<% 

	Connection con = null;
	ResultSet rs=null;
	Statement stmt = null;
	String SQL="";
	request.setCharacterEncoding("UTF-8");

try
	{
	con = ConnectionManager.getConnection(request);
	 stmt = con.createStatement();
			Map hash = (Map)obj.parseXMLString( request ) ;
			hash = (Map)hash.get("SEARCH") ;
			String facilityId	=(String) session.getValue("facility_id");
			String loginuser 	= (String) session.getValue( "login_user");
			String locale = (String)session.getAttribute("LOCALE");
			
			String f_mode		= request.getParameter("function_mode");
			String resource1		=(String) hash.get("resource1");
			String steps		=(String) hash.get("steps");
			String clinic_type		=(String) hash.get("clinic_type");
			String speciality		=(String) hash.get("speciality");
			String clinic_code1		=(String) hash.get("clinic_code1");
			if(steps==null) steps="";
			if(f_mode==null) f_mode="";
			if(resource1==null) resource1="";
			if(speciality==null) speciality="";
			if(clinic_code1==null) clinic_code1="";
			if(clinic_type==null) clinic_type="";
	
			ResultSet rssql1=null;
			ResultSet rssql2=null;
			
			String oper_stn_id="";

			Statement stsql2 = con.createStatement();	
			Statement stsql1 = con.createStatement();
		 if(steps.equals("1")){
	 if(resource1.equals("R")){
	SQL="select locn_type res_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind='R' and language_id='"+locale+"' ";
	
	 }
	 if(resource1.equals("P"))
	 {
		 SQL="select pract_type res_type,Desc_Userdef short_desc from am_pract_type_lang_vw where language_id='"+locale+"' order by 2";
	 }
	  if(resource1.equals("E") || resource1.equals("O"))
	 {
		 SQL="select resource_type res_type,short_desc from  am_resource_type_lang_vw  where resource_Class='"+resource1+"' and language_id='"+locale+"' ";
	 }
	 

rssql1 = stsql1.executeQuery(SQL);
String short_desc="";
String room_type="";
	


		while(rssql1!=null && rssql1.next() ){
		room_type=rssql1.getString("res_type");
	short_desc=rssql1.getString("short_desc");
		%>
			
	 var element = document.createElement('OPTION');
	element.text = "<%=short_desc%>";
	element.value= "<%=room_type%>";
	document.forms[0].fm_pract_type.add(element);
	 var element1 = document.createElement('OPTION');
	element1.text = "<%=short_desc%>";
	element1.value= "<%=room_type%>";
	document.forms[0].to_pract_type.add(element1);
	 <%    }
if (rssql1!=null) rssql1.close();
}else if(steps.equals("11")){

		String sql2="SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
		rssql2=stsql2.executeQuery(sql2);
			
		if (rssql2!=null && rssql2.next()){
		oper_stn_id=rssql2.getString("oper_stn_id");
		}else{%>
			
		<%}
		if (rssql2!=null) rssql2.close();

	 StringBuffer sql_main=new StringBuffer();
   sql_main.append("select a.open_to_all_pract_yn,a.long_desc,a.clinic_code from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id='"+oper_stn_id+"' and a.language_id='"+locale+"' and b.appl_user_id='"+loginuser+"' and (b.book_appt_yn='Y' or b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.clinic_type=b.locn_type and ");
	
	if(!speciality.equals("")){
		sql_main.append(" a.SPECIALITY_CODE='"+speciality+"' and ");
	}
	
	
	
	if(clinic_type.equals("D")){
	  sql_main.append("  a.clinic_type='Y' ");

	  }else{
		sql_main.append("  a.clinic_type='"+clinic_type+"' ");

	  }
	
	sql_main.append(" and a.CARE_LOCN_TYPE_IND='"+clinic_type+"' order by a.long_desc");
    
	if (rs!=null) rs.close();
	rs = stmt.executeQuery(sql_main.toString());
	sql_main.setLength(0);
	%>

     var i=2;
     var len=parent.frames[1].document.forms[0].location_name.options.length;
     var lBox=parent.frames[1].document.forms[0].location_name; 
     lBox.remove(lBox.options[0]);
     var opt=parent.frames[1].document.createElement('OPTION');
     opt.value='';
     opt.text='  --Select-- ';
	 lBox.add(opt);
     while(i<= len){
		 lBox.remove(lBox.options[i]);
		 i+=1;
	}
	
	<%	
		String short_desc="";
	String clinic_code="";
	String open_to_all_pract_yn="";

   while(rs!=null && rs.next() )
	   {
		short_desc=rs.getString("long_desc");
		clinic_code=rs.getString("clinic_code");
		open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
	
		%>    
	
		
		var opt=parent.frames[1].document.createElement('OPTION');
		opt.value='<%=open_to_all_pract_yn%>$<%=clinic_code%>';
		opt.text='<%=short_desc%>';
		parent.frames[1].document.forms[0].location_name.add(opt);
       	

<%
	}	
}
else if(steps.equals("X")){
	 String sql  = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+facilityId+"'";

	 String code="";
	 String desc="";

    if (rs!=null) rs.close();
	rs = stmt.executeQuery(sql);

	 while(rs!=null && rs.next()){
		 code=rs.getString("primary_resource_class");
			if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		    desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
		
	 }
	 %>

		parent.frames[1].document.getElementById("resource_class").value="<%=code%>";
		parent.frames[1].document.getElementById("P_RESOURCE_CLASS").value="<%=code%>";
		
	 <%

}
//Mahesh added for the IN:034921 as on 04/09/2012
else if(steps.equals("reprint_appt_slip"))
	{
	String appt_id		= (String) hash.get("appt_id");
	String appt_date="";
	String patient_id="";
	try
		{
		rs=stmt.executeQuery("Select to_char(appt_date,'dd/MM/yyyy') appt_date,patient_id from oa_appt where APPT_REF_NO='"+appt_id+"'");
		if(rs.next())
			{
			appt_date=checkForNull(rs.getString(1));
			patient_id=checkForNull(rs.getString(2));
			}
		}
	catch(Exception e)	
		{
		//System.out.println("Exception occurred while getting Pat ID and Appt Date "+e);
		e.printStackTrace();
		}
	%>		
	parent.frames[1].document.forms[0].appt_date.value=convertDate('<%=appt_date%>',"DMY","en",localeName);
	parent.frames[1].document.forms[0].patient_id.value='<%=patient_id%>';
	<%
	}
//End	
if(rs !=null) rs.close();
if(rssql1 !=null)rssql1.close();
if(stmt !=null) stmt.close();
if (stsql1!=null) stsql1.close();
if (stsql2!=null) stsql2.close();
hash.clear();
}catch( Exception e ){
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}
%>	
//Mahesh added for the IN:034921  as on 04/09/2012
<%!
public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
%>
//End
