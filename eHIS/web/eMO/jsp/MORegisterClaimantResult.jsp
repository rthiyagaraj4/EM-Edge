<!DOCTYPE html>
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head> 

	 <%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	  <script language='javascript' src='../../eCommon/js/common.js'></script>
	  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	  <!--<script language='javascript' src='../../eMO/js/MORegisterClaimant.js'></script>-->
	  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
  
</head>
 <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="ae_reg_attn_result_form" id="ae_reg_attn_result_form"    method="post" target="messageFrame" >
		

 <%
   
	
    Connection conn					= null;
    java.sql.Statement stmt		    = null;
    java.sql.Statement stmt1		= null;
    java.sql.Statement stmt2		= null; 
    java.sql.Statement stmt3		= null;
    java.sql.Statement stmt6		= null;
    java.sql.Statement stmt42		= null;
    
    ResultSet rs					= null;
    ResultSet rs1					= null;
    ResultSet rs2					= null;
    ResultSet rs3					= null;
    ResultSet rs6					= null;
    ResultSet rs42					= null;
	int k=0;	
    try{

      String operation=request.getParameter("operation");
      if(operation==null || operation.equals("null")) operation="insert";
      conn = ConnectionManager.getConnection(request);	
	  String locale=(String)session.getAttribute("LOCALE"); 
	  Properties p		= (java.util.Properties) session.getValue("jdbc");





//String relationship=request.getParameter("RELATIONSHIP")==null?"":request.getParameter("RELATIONSHIP"); 
//String name=request.getParameter("NAME")==null?"":request.getParameter("NAME"); 
//String job_title=request.getParameter("JOB_TITLE")==null?"":request.getParameter("JOB_TITLE"); 
//String COUNTRY_CODE=request.getParameter("COUNTRY_CODE")==null?"":request.getParameter("COUNTRY_CODE"); 
//String TELEPHONE_OFF=request.getParameter("TELEPHONE_OFF")==null?"":request.getParameter("TELEPHONE_OFF"); 

//String TELEPHONE_RES=request.getParameter("TELEPHONE_RES")==null?"":request.getParameter("TELEPHONE_RES"); 

//String EMAIL_ID=request.getParameter("EMAIL_ID")==null?"":request.getParameter("EMAIL_ID"); 
//String MOB_TEL_NO=request.getParameter("MOB_TEL_NO")==null?"":request.getParameter("MOB_TEL_NO"); 
//String NAT_ID_NO=request.getParameter("NAT_ID_NO")==null?"":request.getParameter("NAT_ID_NO"); 
//String ORGANIZATION_NAME=request.getParameter("ORGANIZATION_NAME")==null?"":request.getParameter("ORGANIZATION_NAME"); 
//String PATIENT_EMPLOYEE_ID1=request.getParameter("PATIENT_EMPLOYEE_ID")==null?"":request.getParameter("PATIENT_EMPLOYEE_ID"); 





  //    String regno		              	 = ""; 
      String JOB1_TITLE              	 = "";	
      String ADDR2_LINE1             	 = "";
      String ADDR2_LINE2            	 =  ""; 
      String ADDR2_LINE3             	 = "" ;
      String ADDR2_LINE4			     =  "";
      String CONTACT1_NAME             	 = ""; 
      String CONTACT3_NAME             	 = ""; 
      String CONTACT1_RELATION           = ""; 
      String CONTACT3_RELATION           = ""; 
	  String CONTACT1_RES_AREA_CODE="";
	  String CONTACT1_REGION_CODE="";
	  String CONTACT1_RES_TOWN_CODE="";
	  String CONTACT1_REGION_CODE3="";
	  String CONTACT1_RES_AREA_CODE3="";
	  String CONTACT1_RES_TOWN_CODE3="";
	  String tel_no1="";
	  String otel_no1="";	
	  String restowncode="";
	  String ecou="";
	  String sq3="";
	  String ocpndesc="";
	  String ocpn_class_desc="";
	  String OCPN_CODE="";
	  String resareacode="";
	  String regioncode="";
      String CONTACT1_NAT_ID_NO          = ""; 
      String tel_no                 	 = ""; 
    //  String tel_no1                 	 = ""; 
      String otel_no                 	 = ""; 
      //String otel_no1                 	 = ""; 
      String email                  	 = ""; 
      String frommo						 = "";		
	  String frommo1					 = "";		
      String postal_code		         = "";  
	  String postal_code1		         = "";
	  String addrl1                      = "";
	  String addrl2                      = "";
	  String addrl3                      = "";
	  String addrl4                      = "";
	  String postalcode                  = "";
	  String orgn                        = "";	  
	  String countrycode                 = "";
 	  String country_code                = "";
	  String country_code1               = "";
	  //String disableVal                  = "";
	  //String disableReadOnly             = "";
	  String name1                       = "";
	  String name2                       = "";
	  //String ctype                       = "";
	  String pid                         = "";
	  //String dob                         = "";
	  //String dsbl                        = "";
	  //String db                          = "";
	  String mobile                      = "";
	 // String JOB3_TITLE                   ="";  
	  String PATIENT_EMPLOYEE_ID         = "";
	  String short_desc                  = "";
	  //String load3                       = "";
	  //String times                       = "";
      String[] contact_col_names	     = null ;
	  String[] contact_prompts			 = null ;
	  String[] contact_fields		     = null ;
       String bodypartframe="";
	   String postaldesc="";
	  //int tabIndex		                 = 1;

	 String kcou ="";

      name1			= checkForNull(request.getParameter("name1"));//claimant type
	  
      name2			= checkForNull(request.getParameter("ctype"));//claimant type
	  bodypartframe      =checkForNull(request.getParameter("bodypart"));//claimant type
      if(bodypartframe.equals("bodypart"))bodypartframe="parent.frames[3]";else 
	  if(bodypartframe.equals("cmgfrmreleasedeas"))bodypartframe="parent.frames[0]";else
	  bodypartframe="parent.frames[3]";
	  //name2			= checkForNull(request.getParameter("value1"));//claimant
      pid			= checkForNull(request.getParameter("pid"));//from moregisterclaimantsearch.jsp
      //regno			= checkForNull(request.getParameter("regno"));//from moregisterclaimantsearch.jsp
     
	  //load3			= checkForNull(request.getParameter("load3"));// ctype value from moregisterclaimantsearch.jsp
      //times			= checkForNull(request.getParameter("ti"));// count from moregisterclaimantsearch.jsp
	
		
		
 
/* End of Dummy Display*/

	 String[] address_col_names=	{"ADDR_LINE1_PROMPT","ADDR_LINE2_PROMPT","ADDR_LINE3_PROMPT","ADDR_LINE4_PROMPT","REGION_PROMPT","RES_AREA_PROMPT","RES_TOWN_PROMPT","POSTAL_CODE_PROMPT"};

	 String[] address1_fld_names=	{"addr_line_1","addr_line_2","addr_line_3","addr_line_4","","","","postal_code"};


	 ArrayList contact_addr= fetchContactAddresses(conn,out,"parent.parent.messageFrame",p) ;
	 
	// String Site					= (String)contact_addr.get(0) ;
	 contact_col_names		        = (String[])contact_addr.get(1) ;
	
	 contact_prompts			    = (String[])contact_addr.get(2) ;
     contact_fields			        = (String[])contact_addr.get(3) ;
	 contact_addr				    = null;
     

	// String sqlRelation	 = " select RELATIONSHIP_CODE,SHORT_DESC from MP_RELATIONSHIP "+
						//   " where EFF_STATUS='E' and nvl(eff_date_from,sysdate) >= sysdate "+
					//	   " and nvl(eff_date_to,sysdate) <= sysdate order by SHORT_DESC ";
String sql42="";

    sql42="SELECT  NATIONAL_ID_NO,to_char(DATE_OF_BIRTH,'mm/dd/yyyy') dob,ALT_ID1_NO from mp_patient where PATIENT_ID='"+pid+"'";
	
	stmt42 = conn.createStatement();
	rs42=stmt42.executeQuery(sql42);
	while((rs42!=null)&&(rs42.next()))
		{
		 //nid      = checkForNull(rs42.getString("NATIONAL_ID_NO"));
	     //dob      = checkForNull(rs42.getString("dob"));
		 //altid    = checkForNull(rs42.getString("ALT_ID1_NO"));
		}
	  if(rs42!=null) rs42.close();
	  if(stmt42!=null)stmt42.close();
	 	 
	
	if(name1.equals("K"))
	{
			
	 frommo = " select CONTACT1_RELATION, CONTACT1_NAME,JOB1_TITLE,ADDR1_LINE1,ADDR1_LINE2,ADDR1_LINE3,ADDR1_LINE4,POSTAL1_CODE,COUNTRY1_CODE,OFF1_TEL_NO,RES1_TEL_NO,CONTACT1_EMAIL_ID,CONTACT1_MOB_TEL_NO,CONTACT1_NAT_ID_NO,MODIFIED_FACILITY_ID, CONTACT1_REGION_CODE,CONTACT1_RES_AREA_CODE, CONTACT1_RES_TOWN_CODE from mp_pat_rel_contacts where patient_id='"+pid+"'";
	
	
	     

	stmt = conn.createStatement();
	rs= stmt.executeQuery(frommo);
   		   if(rs!=null && rs.next())
			{
                CONTACT1_REGION_CODE =	checkForNull(rs.getString("CONTACT1_REGION_CODE"));
				CONTACT1_RES_AREA_CODE =checkForNull(rs.getString("CONTACT1_RES_AREA_CODE"));
				CONTACT1_RES_TOWN_CODE =checkForNull(rs.getString("CONTACT1_RES_TOWN_CODE"));

	    		CONTACT1_NAME			= checkForNull(rs.getString("CONTACT1_NAME"));           
				CONTACT1_RELATION		= checkForNull(rs.getString("CONTACT1_RELATION"));
     			addrl1					= checkForNull(rs.getString("ADDR1_LINE1"));
				addrl2					= checkForNull(rs.getString("ADDR1_LINE2"));
     		    addrl3					= checkForNull(rs.getString("ADDR1_LINE3"));
			    addrl4					= checkForNull(rs.getString("ADDR1_LINE4"));
				tel_no                  = checkForNull(rs.getString("RES1_TEL_NO"));
				otel_no                 = checkForNull(rs.getString("OFF1_TEL_NO"));
				mobile					= checkForNull(rs.getString("CONTACT1_MOB_TEL_NO"));
				email					= checkForNull(rs.getString("CONTACT1_EMAIL_ID"));
				postal_code             = checkForNull(rs.getString("POSTAL1_CODE"));
				country_code            = checkForNull(rs.getString("COUNTRY1_CODE"));
				JOB1_TITLE              = checkForNull(rs.getString("JOB1_TITLE"));
		 		CONTACT1_NAT_ID_NO      = checkForNull(rs.getString("CONTACT1_NAT_ID_NO"));
		 		

			 }if(rs!=null) rs.close();
			  if(stmt!=null)stmt.close();

      	

      sq3 = "select short_desc from mp_res_town_lang_vw  where LANGUAGE_ID='"+locale+"' and res_town_code = '"+CONTACT1_RES_TOWN_CODE+"'";
      stmt2= conn.createStatement();
	  rs2 = stmt2.executeQuery(sq3);
	  while(rs2!=null && rs2.next())
	  {
		restowncode=checkForNull(rs2.getString("short_desc"));
	  } 
	  if(rs2!=null) rs2.close();
	  if(stmt2!=null)stmt2.close();
		
   sq3 = "select short_desc from mp_res_area_lang_vw  where LANGUAGE_ID='"+locale+"' and res_area_code = '"+CONTACT1_RES_AREA_CODE+"'";
   stmt2= conn.createStatement();
   rs2 = stmt2.executeQuery(sq3);
		
  while(rs2!=null && rs2.next())
  {
	resareacode=checkForNull(rs2.getString("short_desc"));
  } 
  if(rs2!=null) rs2.close();
  if(stmt2!=null)stmt2.close();
  sq3 = "select short_desc from mp_region_lang_vw where LANGUAGE_ID='"+locale+"' and REGION_CODE = '"+CONTACT1_REGION_CODE+"'";
  stmt2= conn.createStatement();
  rs2 = stmt2.executeQuery(sq3);
  while(rs2!=null && rs2.next())
	{
		regioncode=checkForNull(rs2.getString("short_desc"));
  } 
  if(rs2!=null) rs2.close();
  if(stmt2!=null)stmt2.close();
	
  sq3 = "select short_name from mp_country_lang_vw  where  LANGUAGE_ID='"+locale+"' and country_code = '"+country_code+"'";
  stmt2= conn.createStatement();
  rs2 = stmt2.executeQuery(sq3);
  while(rs2!=null && rs2.next())
	{
		kcou=checkForNull(rs2.getString("short_name"));
	}
	if(rs2!=null) rs2.close();
	if(stmt2!=null)stmt2.close();
				
 String[] address_fld_values=	{addrl1,addrl2,addrl3,addrl4,"","","",postal_code};
 String str4 ="select RELATIONSHIP_CODE,short_desc from MP_RELATIONSHIP_lang_vw where LANGUAGE_ID='"+locale+"' and  eff_status='E' order by 2";
 String reln = "";
			
stmt6=conn.createStatement();
rs6 =  stmt6.executeQuery(str4);
int relval=1;

while(rs6.next())
	{
		String Query_Rel_code = rs6.getString("RELATIONSHIP_CODE");
	
	%>
		<script>

			//if("<%=rs6.getString("RELATIONSHIP_CODE")%>"=="<%=CONTACT1_RELATION%>")
			if("<%=Query_Rel_code%>"=="<%=CONTACT1_RELATION%>")
				eval(<%=bodypartframe%>).document.forms[0].RELATIONSHIP.options[<%=relval%>].selected=true;		</script>			
			
			<%relval++;}if(rs6!=null) rs6.close();
			 if(stmt6!=null) stmt6.close();
 		
		
		%> 
	
<script>
		
//parent.frames[3].document.forms[0].RELATIONSHIP.value="<%=CONTACT1_RELATION%>"			
//parent.frames[3].document.forms[0].RELATIONSHIP1.value="<%=reln%>"			
eval(<%=bodypartframe%>).document.forms[0].NAME.value="<%=CONTACT1_NAME%>"		     
eval(<%=bodypartframe%>).document.forms[0].JOB_TITLE.value="<%=JOB1_TITLE%>"	             	 
eval(<%=bodypartframe%>).document.forms[0].COUNTRY_DESC.value="<%=kcou%>"	            	 
eval(<%=bodypartframe%>).document.forms[0].TELEPHONE_OFF.value="<%=otel_no%>"	
eval(<%=bodypartframe%>).document.forms[0].TELEPHONE_RES.value="<%=tel_no%>"						 
eval(<%=bodypartframe%>).document.forms[0].EMAIL_ID.value="<%=email%>"	       	 
eval(<%=bodypartframe%>).document.forms[0].MOB_TEL_NO.value="<%=mobile%>"	         	 
eval(<%=bodypartframe%>).document.forms[0].NAT_ID_NO.value="<%=CONTACT1_NAT_ID_NO%>"	 	 
eval(<%=bodypartframe%>).document.forms[0].ZIP_CODE.value="<%=postal_code%>" 
eval(<%=bodypartframe%>).document.forms[0].COUNTRY_CODE.value="<%=country_code%>"	
if(eval(<%=bodypartframe%>).document.forms[0].region!=null)
	eval(<%=bodypartframe%>).document.forms[0].region.value="<%=regioncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].area!=null)
	eval(<%=bodypartframe%>).document.forms[0].area.value="<%=resareacode%>"
if(eval(<%=bodypartframe%>).document.forms[0].town!=null)
	eval(<%=bodypartframe%>).document.forms[0].town.value="<%=restowncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].region1!=null)
	eval(<%=bodypartframe%>).document.forms[0].region1.value="<%=CONTACT1_REGION_CODE%>"
if(eval(<%=bodypartframe%>).document.forms[0].area1!=null)
	eval(<%=bodypartframe%>).document.forms[0].area1.value="<%=CONTACT1_RES_AREA_CODE%>"
if(eval(<%=bodypartframe%>).document.forms[0].town1!=null)
	eval(<%=bodypartframe%>).document.forms[0].town1.value="<%=CONTACT1_RES_TOWN_CODE%>"
if(eval(<%=bodypartframe%>).document.forms[0].COUNTRY_DESC!=null)
	eval(<%=bodypartframe%>).document.forms[0].COUNTRY_DESC.value="<%=kcou%>"

if(eval(<%=bodypartframe%>).document.forms[0].m_region_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_region_code.value="<%=regioncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].m_area_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_area_code.value="<%=resareacode%>"
if(eval(<%=bodypartframe%>).document.forms[0].m_town_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_town_code.value="<%=restowncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].postal_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].postal_code.value="<%=postal_code%>"



</script>	 
	 
	 <%
		
		for(int i=0;i<contact_col_names.length;i++) 
		{
			if( !( contact_col_names[i].equalsIgnoreCase("REGION_PROMPT") ||contact_col_names[i].equalsIgnoreCase("RES_AREA_PROMPT") || contact_col_names[i].equalsIgnoreCase("RES_TOWN_PROMPT")) )
			{
				out.println("<tr>");
				out.println("<td class='LABEL' align='RIGHT' nowrap>"+contact_prompts[i]+"</td>") ;		
				for(int j=0; j<address_col_names.length; j++)
				{
					
					if(address_col_names[j].equalsIgnoreCase(contact_col_names[i]))
					{
						
						if(address_col_names[j].equalsIgnoreCase("POSTAL_CODE_PROMPT"))
						{%>
							
								<script>
							eval(<%=bodypartframe%>).document.forms[0].<%=address1_fld_names[j]%>.value="<%=address_fld_values[j]%>"	
							</script>
				<%	}
						else
						{%>
							
						<script>
							eval(<%=bodypartframe%>).document.forms[0].<%=address1_fld_names[j]%>.value="<%=address_fld_values[j]%>"	
							</script>
					<%		}
						
					}
				}   
			}
		}
    %>
		

	<%
	
		}else	if(name1.equals("E"))
	{
		 frommo = " select CONTACT3_RELATION,CONTACT3_NAME,OCPN_CODE,JOB3_TITLE,ADDR3_LINE1,ADDR3_LINE2,ADDR3_LINE3,ADDR3_LINE4,POSTAL3_CODE,COUNTRY3_CODE,OFF3_TEL_NO,RES3_TEL_NO,ORGANIZATION_NAME,PATIENT_EMPLOYEE_ID,CONTACT3_REGION_CODE,CONTACT3_RES_AREA_CODE,CONTACT3_RES_TOWN_CODE from mp_pat_rel_contacts where patient_id='"+pid+"'";
		  
	
	    
		stmt = conn.createStatement();
		rs= stmt.executeQuery(frommo);
   		   if(rs!=null && rs.next())
			{
				CONTACT1_REGION_CODE3	    = checkForNull(rs.getString("CONTACT3_REGION_CODE")); 
		    	CONTACT1_RES_AREA_CODE3		= checkForNull(rs.getString("CONTACT3_RES_AREA_CODE"));
				CONTACT1_RES_TOWN_CODE3		= checkForNull(rs.getString("CONTACT3_RES_TOWN_CODE"));
				OCPN_CODE	                = checkForNull(rs.getString("OCPN_CODE"));
				CONTACT3_NAME			    = checkForNull(rs.getString("CONTACT3_NAME")); 
		    	CONTACT3_RELATION			= checkForNull(rs.getString("CONTACT3_RELATION"));
				ADDR2_LINE1					= checkForNull(rs.getString("ADDR3_LINE1"));
				ADDR2_LINE2					= checkForNull(rs.getString("ADDR3_LINE2"));
				ADDR2_LINE3					= checkForNull(rs.getString("ADDR3_LINE3"));
			    ADDR2_LINE4					= checkForNull(rs.getString("ADDR3_LINE4"));
				tel_no1						= checkForNull(rs.getString("RES3_TEL_NO"));
				otel_no1					= checkForNull(rs.getString("OFF3_TEL_NO"));
				postal_code1				= checkForNull(rs.getString("POSTAL3_CODE"));
				country_code1				= checkForNull(rs.getString("COUNTRY3_CODE"));
				//JOB3_TITLE					= checkForNull(rs.getString("JOB3_TITLE"));
				PATIENT_EMPLOYEE_ID			= checkForNull(rs.getString("PATIENT_EMPLOYEE_ID"));
				orgn						= checkForNull(rs.getString("ORGANIZATION_NAME"));
		 		
			 }if(rs!=null) rs.close();
			  if(stmt!=null) stmt.close();
		
%>		
	 
<%
		
		
		
		if(!OCPN_CODE.equals(""))
		 {sq3 ="select a.SHORT_DESC ocpn_desc,b.short_desc ocpn_class_desc from mp_occupation_lang_vw a,MP_OCCUPATION_CLASS_lang_vw b where a.LANGUAGE_ID='"+locale+"' AND  a.LANGUAGE_ID=b.LANGUAGE_ID and  a.OCPN_CODE='"+OCPN_CODE+"'and  a.OCPN_CLASS_CODE=b.OCPN_CLASS_CODE";
	   	stmt2= conn.createStatement();
		rs2 = stmt2.executeQuery(sq3);
	   	while(rs2!=null && rs2.next())
		{   
			ocpndesc=checkForNull(rs2.getString("ocpn_desc"));
			ocpn_class_desc=checkForNull(rs2.getString("ocpn_class_desc"));
		}%> 
		
		 <script>eval(<%=bodypartframe%>).document.getElementById('hed1').innerHTML="Occupation Class";
		eval(<%=bodypartframe%>).document.getElementById('ocpnlab').innerHTML="<b><%=ocpn_class_desc%></b>";
		 </script>
		
		 <%}
	
		sq3 = "select short_desc from mp_res_area_lang_vw  where LANGUAGE_ID='"+locale+"'  and res_area_code = '"+CONTACT1_RES_AREA_CODE3+"'";

		stmt2= conn.createStatement();
		rs2 = stmt2.executeQuery(sq3);
		
		
		while(rs2!=null && rs2.next())
		{
			resareacode=checkForNull(rs2.getString("short_desc"));
		}     if(rs2!=null) rs2.close();
			  if(stmt2!=null)stmt2.close();
	
     sq3 = "select short_desc from mp_res_town_lang_vw  where  LANGUAGE_ID='"+locale+"'  and res_town_code = '"+CONTACT1_RES_TOWN_CODE3+"'";

		stmt2= conn.createStatement();
		rs2 = stmt2.executeQuery(sq3);
		
		
		while(rs2!=null && rs2.next())
		{
			restowncode=checkForNull(rs2.getString("short_desc"));
		}     if(rs2!=null) rs2.close();
			  if(stmt2!=null)stmt2.close();
	
        
       sq3 = "select short_desc from mp_region_lang_vw where LANGUAGE_ID='"+locale+"' and REGION_CODE = '"+CONTACT1_REGION_CODE3+"'";
      
		stmt2= conn.createStatement();
		rs2 = stmt2.executeQuery(sq3);
		
		
		while(rs2!=null && rs2.next())
		{
			regioncode=checkForNull(rs2.getString("short_desc"));
			
			
		}     if(rs2!=null) rs2.close();
			  if(stmt2!=null)stmt2.close();
	
		 
		stmt3= conn.createStatement();
		String sq4 = "select short_name from mp_country_lang_vw where LANGUAGE_ID='"+locale+"' and country_code = '"+country_code1+"'";
		
		rs3 = stmt3.executeQuery(sq4);
		while(rs3!=null && rs3.next())
		{
		  ecou = checkForNull(rs3.getString("short_name"));
		}if(rs3!=null) rs3.close();
		 if(stmt3!=null) stmt3.close(); 
	
		
		String[] address_fld_values1=	{ADDR2_LINE1,ADDR2_LINE2,ADDR2_LINE3,ADDR2_LINE4,"","","",postal_code1};
%>
	 <!-- <body OnMouseDown='CodeArrest()' >
     <form name="ae_reg_attn_result_form" id="ae_reg_attn_result_form"  action="../../servlet/eMO.MORegClaimServlet"  method="post" target="messageFrame" >
	 -->


	       <%			
			String str4 ="select RELATIONSHIP_CODE,short_desc from MP_RELATIONSHIP_lang_vw where LANGUAGE_ID='"+locale+"' and eff_status='E' order by 2";
			String reln = "";
			
			stmt6=conn.createStatement();
			rs6 =  stmt6.executeQuery(str4);
			int relval=1;
			while(rs6.next())
			{
				String Query_rel_code = rs6.getString("RELATIONSHIP_CODE");

				%>
			<script>
			
			//if("<%=rs6.getString("RELATIONSHIP_CODE")%>"=="<%=CONTACT3_RELATION%>")
			if("<%=Query_rel_code%>"=="<%=CONTACT3_RELATION%>")
		     eval(<%=bodypartframe%>).document.forms[0].RELATIONSHIP.options[<%=relval%>].selected=true;		</script>			
			
			<%relval++;}if(rs6!=null) rs6.close();
			 if(stmt6!=null) stmt6.close();
			
			%> 
	
	 
	 
<script>
		
//<%=bodypartframe%>.document.forms[0].RELATIONSHIP.value="<%=CONTACT3_RELATION%>"
//<%=bodypartframe%>.document.forms[0].RELATIONSHIP1.value="<%=reln%>"

eval(<%=bodypartframe%>).document.forms[0].NAME.value="<%=CONTACT3_NAME%>"		     
eval(<%=bodypartframe%>).document.forms[0].JOB_TITLE.value="<%=ocpndesc%>"	             	 
eval(<%=bodypartframe%>).document.forms[0].COUNTRY_CODE.value="<%=country_code1%>"	            	 
eval(<%=bodypartframe%>).document.forms[0].COUNTRY_DESC.value="<%=ecou%>"	            	 
eval(<%=bodypartframe%>).document.forms[0].TELEPHONE_OFF.value="<%=otel_no1%>"	
eval(<%=bodypartframe%>).document.forms[0].TELEPHONE_RES.value="<%=tel_no1%>"						 
eval(<%=bodypartframe%>).document.forms[0].ORGANIZATION_NAME.value="<%=orgn%>"	       	 
eval(<%=bodypartframe%>).document.forms[0].PATIENT_EMPLOYEE_ID.value="<%=PATIENT_EMPLOYEE_ID%>"	 
if(eval(<%=bodypartframe%>).document.forms[0].region!=null)
	eval(<%=bodypartframe%>).document.forms[0].region.value="<%=regioncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].area!=null)
	eval(<%=bodypartframe%>).document.forms[0].area.value="<%=resareacode%>"
if(eval(<%=bodypartframe%>).document.forms[0].town!=null)
	eval(<%=bodypartframe%>).document.forms[0].town.value="<%=restowncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].region1!=null)
	eval(<%=bodypartframe%>).document.forms[0].region1.value="<%=CONTACT1_REGION_CODE3%>"
if(eval(<%=bodypartframe%>).document.forms[0].area1!=null)
	eval(<%=bodypartframe%>).document.forms[0].area1.value="<%=CONTACT1_RES_AREA_CODE3%>"
if(eval(<%=bodypartframe%>).document.forms[0].town1!=null)
	eval(<%=bodypartframe%>).document.forms[0].town1.value="<%=CONTACT1_RES_TOWN_CODE3%>"
if(eval(<%=bodypartframe%>).document.forms[0].ZIP_CODE!=null)
	eval(<%=bodypartframe%>).document.forms[0].ZIP_CODE.value="<%=postal_code%>" 

if(eval(<%=bodypartframe%>).document.forms[0].m_region_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_region_code.value="<%=regioncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].m_area_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_area_code.value="<%=resareacode%>"
if(eval(<%=bodypartframe%>).document.forms[0].m_town_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_town_code.value="<%=restowncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].postal_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].postal_code.value="<%=postal_code%>"


</script>	 

	 
	 
	 <%	
		for(int i=0;i<contact_col_names.length;i++) 
		{
			
			if( !( contact_col_names[i].equalsIgnoreCase("REGION_PROMPT") ||contact_col_names[i].equalsIgnoreCase("RES_AREA_PROMPT") || contact_col_names[i].equalsIgnoreCase("RES_TOWN_PROMPT")) )
			{
			
				for(int j=0; j<address_col_names.length; j++)
				{

					if(address_col_names[j].equalsIgnoreCase(contact_col_names[i]))
					{
						
						if(address_col_names[j].equalsIgnoreCase("POSTAL_CODE_PROMPT"))
						{%>
					<script>
						eval(<%=bodypartframe%>).document.forms[0].<%=address1_fld_names[j]%>.value="<%=address_fld_values1[j]%>"	
							</script>
								<%}
						else
						{%>
				
							<script>
							eval(<%=bodypartframe%>).document.forms[0].<%=address1_fld_names[j]%>.value="<%=address_fld_values1[j]%>"	
							</script>
						<%}
						
					}
				}   
			}
		}
		
   
		

      
   
	
	}else
	 
	
	{
		 
	 frommo1 = "select SHORT_DESC,ADD_LINE1,ADD_LINE2,ADD_LINE3,ADD_LINE4,POSTAL_CODE,MP_GET_DESC.MP_POSTAL_CODE(POSTAL_CODE,'"+locale+"','2') POSTAL_DESC,COUNTRY_CODE,TEL_NO,EMAIL_ID ,RES_TOWN_CODE,MP_GET_DESC.MP_RES_TOWN(RES_TOWN_CODE,'"+locale+"','2') RES_TOWN_DESC, RES_AREA_CODE,MP_GET_DESC.MP_RES_AREA(RES_AREA_CODE,'"+locale+"','2') RES_AREA_DESC, REGION_CODE,MP_GET_DESC.MP_REGION(REGION_CODE,'"+locale+"','2') REGION_DESC from mo_claimant_type_vw where claimant_type_code='"+name2+"'";
	
	
	     

	stmt1 = conn.createStatement();
	rs1 = stmt1.executeQuery(frommo1);
		
   	   while( rs1!=null && rs1.next())
			{
			short_desc		 = checkForNull(rs1.getString("short_desc"));
		 	addrl1           = checkForNull(rs1.getString("ADD_LINE1"));
			addrl2           = checkForNull(rs1.getString("ADD_LINE2"));
			addrl3           = checkForNull(rs1.getString("ADD_LINE3"));
			addrl4           = checkForNull(rs1.getString("ADD_LINE4"));
			postalcode		 = checkForNull(rs1.getString("POSTAL_CODE"));
			postaldesc		 = checkForNull(rs1.getString("POSTAL_DESC"));
			countrycode		 = checkForNull(rs1.getString("COUNTRY_CODE"));
		    tel_no			 = checkForNull(rs1.getString("TEL_NO"));
	




		email			 = checkForNull(rs1.getString("email_id"));
			
			CONTACT1_RES_TOWN_CODE3    =checkForNull(rs1.getString("RES_TOWN_CODE"));
			restowncode                =checkForNull(rs1.getString("RES_TOWN_DESC"));
			CONTACT1_RES_AREA_CODE3    =checkForNull(rs1.getString("RES_AREA_CODE"));
			resareacode                =checkForNull(rs1.getString("RES_AREA_DESC"));
			CONTACT1_REGION_CODE3      =checkForNull(rs1.getString("REGION_CODE"));
			regioncode                 =checkForNull(rs1.getString("REGION_DESC"));
			} if(rs1!=null) rs1.close();
			  if(stmt1!=null) stmt1.close();
				
			 String []address_fld_values=	{addrl1,addrl2,addrl3,addrl4,"","","",postalcode};
			
		%>
	 <input type="hidden" name='addrl1' id='addrl1'  value ='<%=addrl1%>'>
	 <input type="hidden" name='addrl2' id='addrl2'  value ='<%=addrl2%>'>
	 <input type="hidden" name='addrl3' id='addrl3'  value ='<%=addrl3%>'>
	 <input type="hidden" name='addrl4' id='addrl4'  value ='<%=addrl4%>'>
	 <input type="hidden" name='pin' id='pin'  value ='<%=postalcode%>'>
	 <input type="hidden" name='coucode' id='coucode'  value ='<%=countrycode%>'>
	
        <%
					
		
		for(int i=0;i<contact_col_names.length;i++) 
		{
		
			if( !( contact_col_names[i].equalsIgnoreCase("REGION_PROMPT") ||contact_col_names[i].equalsIgnoreCase("RES_AREA_PROMPT") || contact_col_names[i].equalsIgnoreCase("RES_TOWN_PROMPT")) )
			{
				
				
				for(int j=0; j<address_col_names.length; j++)
				{
					
					if(address_col_names[j].equalsIgnoreCase(contact_col_names[i]))
					{
						
						if(address_col_names[j].equalsIgnoreCase("POSTAL_CODE_PROMPT"))
						{%>
						
							<script>
							eval(<%=bodypartframe%>).document.forms[0].<%=address1_fld_names[j]%>.value="<%=address_fld_values[j]%>"	
							</script>
							  			
							
					<%	}
						else
						{%>
					        <script>
							eval(<%=bodypartframe%>).document.forms[0].<%=address1_fld_names[j]%>.value="<%=address_fld_values[j]%>"	
							</script>
								
						
						<%}
						
					}
				}   
			}
		}
			 sq3 = "select short_name from mp_country_lang_vw  where LANGUAGE_ID='"+locale+"' and  country_code = '"+countrycode+"'";

		stmt2= conn.createStatement();
		rs2 = stmt2.executeQuery(sq3);
		
		
		while(rs2!=null && rs2.next())
		{
			kcou=checkForNull(rs2.getString("short_name"));
		}
		      if(rs2!=null) rs2.close();
			  if(stmt2!=null)stmt2.close();
			
			
    
	
/*			short_desc		 = checkForNull(rs1.getString("short_desc"));
		 	addrl1           = checkForNull(rs1.getString("ADD_LINE1"));
			addrl2           = checkForNull(rs1.getString("ADD_LINE2"));
			addrl3           = checkForNull(rs1.getString("ADD_LINE3"));
			addrl4           = checkForNull(rs1.getString("ADD_LINE4"));
			postalcode		 = checkForNull(rs1.getString("POSTAL_CODE"));
			countrycode		 = checkForNull(rs1.getString("COUNTRY_CODE"));
		    tel_no			 = checkForNull(rs1.getString("TEL_NO"));
			email			 = checkForNull(rs1.getString("email_id"));*/
%>
	
	
	<script>
eval(<%=bodypartframe%>).document.forms[0].NAME.value ="<%=short_desc%>"		     
eval(<%=bodypartframe%>).document.forms[0].COUNTRY_CODE.value="<%=countrycode%>"	            	 
eval(<%=bodypartframe%>).document.forms[0].COUNTRY_DESC.value="<%=kcou%>"	            	 
eval(<%=bodypartframe%>).document.forms[0].TELEPHONE_OFF.value="<%=tel_no%>"	
//<%=bodypartframe%>.document.forms[0].TELEPHONE_RES.value="<%=tel_no%>"						 
eval(<%=bodypartframe%>).document.forms[0].EMAIL_ID.value="<%=email%>"	       	 
eval(<%=bodypartframe%>).document.forms[0].ZIP_CODE.value="<%=country_code%>"	            	 
if(eval(<%=bodypartframe%>).document.forms[0].region!=null)
	eval(<%=bodypartframe%>).document.forms[0].region.value="<%=regioncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].area!=null)
	eval(<%=bodypartframe%>).document.forms[0].area.value="<%=resareacode%>"
if(eval(<%=bodypartframe%>).document.forms[0].town!=null)
	eval(<%=bodypartframe%>).document.forms[0].town.value="<%=restowncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].region1!=null)
	eval(<%=bodypartframe%>).document.forms[0].region1.value="<%=CONTACT1_REGION_CODE3%>"
if(eval(<%=bodypartframe%>).document.forms[0].area1!=null)
	eval(<%=bodypartframe%>).document.forms[0].area1.value="<%=CONTACT1_RES_AREA_CODE3%>"
if(eval(<%=bodypartframe%>).document.forms[0].town1!=null)
	eval(<%=bodypartframe%>).document.forms[0].town1.value="<%=CONTACT1_RES_TOWN_CODE3%>"

if(eval(<%=bodypartframe%>).document.forms[0].m_region_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_region_code.value="<%=regioncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].m_area_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_area_code.value="<%=resareacode%>"
if(eval(<%=bodypartframe%>).document.forms[0].m_town_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_town_code.value="<%=restowncode%>"
if(eval(<%=bodypartframe%>).document.forms[0].postal_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].postal_code.value="<%=postal_code%>"


if(eval(<%=bodypartframe%>).document.forms[0].m_region!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_region.value="<%=CONTACT1_REGION_CODE3%>"
if(eval(<%=bodypartframe%>).document.forms[0].m_area!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_area.value="<%=CONTACT1_RES_AREA_CODE3%>"
if(eval(<%=bodypartframe%>).document.forms[0].m_town!=null)
	eval(<%=bodypartframe%>).document.forms[0].m_town.value="<%=CONTACT1_RES_TOWN_CODE3%>"
if(eval(<%=bodypartframe%>).document.forms[0].postal_code!=null)
	eval(<%=bodypartframe%>).document.forms[0].postal_code.value="<%=postalcode%>"
if(eval(<%=bodypartframe%>).document.forms[0].postal_code1!=null)
	eval(<%=bodypartframe%>).document.forms[0].postal_code1.value="<%=postaldesc%>"

</script>	 

	
	

		
      
	<%
		//}
	}%>
		
	<input type="hidden" name='j' id='j'  value ='<%=k%>'>
	</form>
		</body>
		<html>
<%
	  if(rs != null) rs.close();
      if(stmt != null) stmt.close();
	  if(rs2!=null) rs2.close();
	  if(stmt2!=null)stmt2.close();
	  if(rs1!=null) rs1.close();
	  if(stmt1!=null) stmt1.close();
	  if(rs6!=null) rs6.close();
	  if(stmt6!=null) stmt6.close();
	  if(rs3!=null) rs3.close();
	  if(stmt3!=null) stmt3.close();
	  if(rs42!=null) rs42.close();
	  if(stmt42!=null)stmt42.close();
	 }
catch(Exception e) 
{
	out.println("Exception in File MORegisterClaimantResult"+e.toString());
	e.printStackTrace();
}
finally
{
  
   ConnectionManager.returnConnection(conn,request);
}
%>

<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>

