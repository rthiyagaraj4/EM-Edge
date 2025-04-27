<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/LocationForPractitioner.js"></script>
		<script language="JavaScript" src ="../../eOR/js/OrderEntrySearch.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
			
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%
	String facility_id = (String)session.getValue("facility_id");
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String target = "";
	String stdval = "";
	String sql = "";
	String selFunVal = "";
	String facilityid = "";
	String pract = "";
	String locale = "";
	String Specialty = "";
	String practitioner = "";
	String pract_id = "";
	String loc_type = "";
	String title = "";
	int count =0;
	try
	{
		
			con = ConnectionManager.getConnection(request);
			
		    target = request.getParameter("target")==null ? "" : request.getParameter("target");
			stdval = request.getParameter("stdval")==null ? "" : request.getParameter("stdval");
			pract = request.getParameter("pract")==null ? "" : request.getParameter("pract");
			facilityid = request.getParameter("facilityid")==null ? "" : request.getParameter("facilityid");
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			locale = request.getParameter("locale")==null ? "" : request.getParameter("locale");
			Specialty = request.getParameter("Specialty")==null ? "" : request.getParameter("Specialty");
			practitioner = request.getParameter("practitionerValue")==null ? "" : request.getParameter("practitionerValue");
			pract_id = request.getParameter("pract_id")==null ? "" : request.getParameter("pract_id");
			loc_type = request.getParameter("loc_type")==null ? "" : request.getParameter("loc_type");
			title = request.getParameter("title")==null ? "" : request.getParameter("title");

		   if (selFunVal.equals("ByLocationSpeciality"))
			{
			  
					if(!Specialty.equals(""))
					{
						sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"'";
						if(!pract.equals(""))
                        sql=sql+" and SPECIALITY_CODE  in (select nvl(PRIMARY_SPECIALITY_CODE,'***') PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id='"+pract+"' union all select SPECIALITY_CODE from AM_PRACT_SPECIALITIES where FACILITY_ID='"+facilityid+"' and PRACTITIONER_ID='"+pract+"' )";
						sql=sql+" and upper(a.SHORT_DESC) like upper(?) order by 2";
                      //  sql="SELECT order_type_code code,  short_desc description FROM or_order_type_lang_vw WHERE language_id=? and eff_status='E' AND order_category like ?  and upper(short_desc) like upper(?)";
						Specialty = Specialty + "%";
					}
			}
			else if(selFunVal.equals("AttendingPractitioner"))
		   {
				//out.println("<script>alert('hi"+practitioner+"')</script>");
			   if(!practitioner.equals(""))
			   {
					//IN059520 Start
					//sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id   and b.language_id = '"+locale+"' and a.eff_status = 'E' and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";
					sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id   and a.eff_status = b.eff_status and b.language_id = '"+locale+"' and a.eff_status = 'E' and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";
					//IN059520 Start
				  practitioner = practitioner + "%";
				 // out.println("<script>alert('hi"+practitioner+"')</script>");
			   }
		   }
		   else if(selFunVal.equals("ClinicCode"))
		   {
			   if(!stdval.equals(""))
			   {
			   sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+facilityid+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+facilityid+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+facilityid+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+facilityid+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+pract_id+"' and locn_type in ('C','W') and facility_id = '"+facilityid+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";
			   stdval = stdval + "%";
			   }
		   }
			ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			if (selFunVal.equals("ByLocationSpeciality"))
			{
                 
					if(!Specialty.equals(""))
					{	
						ps.setString(1,Specialty);
						//ps.setString(2,order_category);
						//ps.setString(3,orderTypevalue);		
					}
			}
			else if(selFunVal.equals("AttendingPractitioner"))
		    {
                    if(!practitioner.equals(""))
			        {
                       ps.setString(1,practitioner);
					}
		    }
			else if(selFunVal.equals("ClinicCode"))
		    {
				 if(!stdval.equals(""))
			        {
                       ps.setString(1,stdval);
					}

			}
		    rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}
			//out.println("<script>alert('count"+count+"')</script>");
			if(count == 1)
		 {		 
				rs.beforeFirst() ;				
				out.println("<script>");
             
           // out.println("alert('89')");
				if(!Specialty.equals(""))
			   {				
					 while(rs.next())
					{
					  
						out.println("parent.PatCriteriaFr.document.PatCriteriaFrm.specialty.value='"+rs.getString(2)+"'");
						out.println(" parent.PatCriteriaFr.document.PatCriteriaFrm.specialty_code.value='"+rs.getString(1)+"' ");
					}
			   }
			    else if(!practitioner.equals(""))
			   {
					while(rs.next())
					{
					   out.println("parent.PatCriteriaFr.document.PatCriteriaFrm.pract.value='"+rs.getString(2)+"'");
					   out.println(" parent.PatCriteriaFr.document.PatCriteriaFrm.AttendPract.value='"+rs.getString(1)+"' ");
					}
				}
				else if(!stdval.equals(""))
			    {
					//out.println("alert('hi')");
					while(rs.next())
					{
					   out.println("parent.PatCriteriaFr.document.PatCriteriaFrm.locationDesc.value='"+rs.getString(2)+"'");
					   out.println(" parent.PatCriteriaFr.document.PatCriteriaFrm.locationCode.value='"+rs.getString(1)+"' ");
					}

			    }
			out.println("</script>");
		   }
		  
		    if(ps != null) ps.close();
		    if(rs != null) rs.close();

			if(count == 0 || count > 1)
			{	
				if(!Specialty.equals(""))
			{
					sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"'";

					if(!pract.equals(""))
                    sql=sql+" and SPECIALITY_CODE  in (select nvl(PRIMARY_SPECIALITY_CODE,'***') PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id='"+pract+"' union all select SPECIALITY_CODE from AM_PRACT_SPECIALITIES where FACILITY_ID='"+facilityid+"' and PRACTITIONER_ID='"+pract+"' )";
					sql=sql + " and upper(a.SPECIALITY_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?) order by 2";
				//sql ="SELECT order_type_code code,  short_desc description FROM or_order_type_lang_vw WHERE language_id='"+localeName1+"' and eff_status='E' AND order_category like '"+order_category+"' and upper(order_type_code) like upper(?) and upper(short_desc) like upper(?)";
			}
			else if(!practitioner.equals(""))
			{
				//IN059520 Start
                //sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";
				sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id and a.eff_status = b.eff_status  and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name";
				//IN059520 End.
			}
			else if(!stdval.equals(""))
			{
				sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+facilityid+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+facilityid+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+facilityid+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+facilityid+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+pract_id+"' and locn_type in ('C','W') and facility_id = '"+facilityid+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";

			}
%>
	<script>
		
			var chkVal = "<%=selFunVal%>";
	        if (chkVal == "ByLocationSpeciality")
		    {	
			  	//alert();
				retVal=
				callFunction3("<%=sql%>","Speciality",parent.PatCriteriaFr.document.PatCriteriaFrm.specialty,parent.PatCriteriaFr.document.PatCriteriaFrm.specialty_code);  
				/* if(retVal != null && retVal !="")	
				{
					 parent.PatCriteriaFr.document.PatCriteriaFrm.specialty.value=retVal[1];
					 parent.PatCriteriaFr.document.PatCriteriaFrm.specialty_code.value=retVal[0];			
				}
				else
				{
					parent.PatCriteriaFr.document.PatCriteriaFrm.specialty.value='';
					parent.PatCriteriaFr.document.PatCriteriaFrm.specialty_code.value='';	
				} */
			}
		   	else if (chkVal == "AttendingPractitioner")
		   	{
	        	retVal=
				callFunction3("<%=sql%>","Practitioner",parent.PatCriteriaFr.document.PatCriteriaFrm.pract,parent.PatCriteriaFr.document.PatCriteriaFrm.AttendPract);
				/* if(retVal != null && retVal !="")	
				{
					 parent.PatCriteriaFr.document.PatCriteriaFrm.pract.value=retVal[1];
					 parent.PatCriteriaFr.document.PatCriteriaFrm.AttendPract.value=retVal[0];			
				}
				else
				{
					parent.PatCriteriaFr.document.PatCriteriaFrm.pract.value='';
					parent.PatCriteriaFr.document.PatCriteriaFrm.AttendPract.value='';	
				} */
		   }
		   else if (chkVal == "ClinicCode")
		   {
				retVal=
			   	callFunction3("<%=sql%>","<%=title%>",parent.PatCriteriaFr.document.PatCriteriaFrm.locationDesc, parent.PatCriteriaFr.document.PatCriteriaFrm.locationCode);
			  	/*if(retVal != null && retVal !="")	
				{
					 parent.PatCriteriaFr.document.PatCriteriaFrm.locationDesc.value=retVal[1];
					 parent.PatCriteriaFr.document.PatCriteriaFrm.locationCode.value=retVal[0];			
				}
				else
				{
					parent.PatCriteriaFr.document.PatCriteriaFrm.locationDesc.value='';
					parent.PatCriteriaFr.document.PatCriteriaFrm.locationCode.value='';	
				} */
			}
	</script>
<%	
	}
	
}
	catch(Exception ee)
	{
		ee.printStackTrace();
		//out.println("Exception in By Location Intermediate Module "+ee.toString());//common-icn-0181
	}
	finally
	{
		try{
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}
%>
 </body>
</html>

