<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
Connection con = null;
ResultSet rs=null;



try
{
	Properties p;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	con = ConnectionManager.getConnection(request);
	Statement stmt = con.createStatement();

    String locale = (String)session.getAttribute("LOCALE");
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;

    
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;

   

    String p_ref_type		=(String) hash.get("p_ref_type");
	if(p_ref_type ==null) p_ref_type="";

	

	String steps		=(String) hash.get("steps");
	if(steps ==null) steps="";
   

	if(steps.equals("1"))
	{
		
		
	String list_sql="";
	String list_code="";
	String list_desc="";
	
	if(p_ref_type.equals("L")){
   
		//list_sql="Select facility_name, facility_id from sm_facility_param_lang_vw Where language_id='en' and STATUS = 'E' and facility_id='HS' order by 1";
		list_sql="Select facility_name, facility_id from sm_facility_param_lang_vw Where language_id='"+locale+"' and STATUS = 'E' and facility_id='"+p_facility_id+"' order by 1";


	
	}else if(p_ref_type.equals("E")){
		list_sql="Select facility_name, facility_id from sm_facility_param_lang_vw Where language_id='"+locale+"' and STATUS = 'E' order by 1";
	}else if(p_ref_type.equals("X")){
		list_sql="Select short_desc, referral_Code from am_referral_lang_vw where language_id='"+locale+"' and eff_status = 'E' order by 1";
	}
	
 if (rs!=null) rs.close();
 
	 	

	rs = stmt.executeQuery(list_sql);
	 while(rs!=null && rs.next()){
		 list_desc=rs.getString(1);
		 list_code=rs.getString(2);
		 

		 %>
		 
		/*var opt1=parent.frames[1].document.createElement('OPTION');
		var opt2=parent.frames[1].document.createElement('OPTION');
		
		opt1.value="<%=list_code%>";
		opt2.value="<%=list_code%>";
		opt1.text="<%=list_desc%>";
		opt2.text="<%=list_desc%>";
		
		parent.frames[1].document.forms[0].P_FM_REF_CODE.add(opt1);
		parent.frames[1].document.forms[0].P_TO_REF_CODE.add(opt2);*/

     

	 <%}
 

 
}

if (rs !=null) rs.close();
if (stmt !=null) stmt.close();

hash.clear();


	}
	
	
catch(Exception e)
{
	out.println(e.toString());
	e.printStackTrace();
}
finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
