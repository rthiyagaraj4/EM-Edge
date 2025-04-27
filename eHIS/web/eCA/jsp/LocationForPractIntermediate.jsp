<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
	String practitioner = "";
	String speciality = "";
	String locationcode = "";
	String locationcode1 = "";
	String specialitycode = "";
	String primespeciality = "";
	String locn_type = "";
	String sql = "";
	String selFunVal = "";
	int count =0;
	try
	{
		
			con = ConnectionManager.getConnection(request);
			practitioner = request.getParameter("practitioner") == null ? "" : request.getParameter("practitioner");
		    speciality = request.getParameter("speciality")==null ? "" : request.getParameter("speciality");
			locationcode = request.getParameter("locationcode")==null ? "" : request.getParameter("locationcode");
			locationcode1 = request.getParameter("locationcode1")==null ? "" : request.getParameter("locationcode1");
			specialitycode = request.getParameter("specialitycode")==null ? "" : request.getParameter("specialitycode");
			primespeciality = request.getParameter("primespeciality")==null ? "" : request.getParameter("primespeciality");
			locn_type = request.getParameter("locn_type")==null ? "" : request.getParameter("locn_type");
			selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
			

			if (selFunVal.equals("Pract")){
				practitioner = practitioner + "%";

				if(!speciality.equals(""))
				{
					sql ="select distinct b.practitioner_id, b.practitioner_name from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id =? and b.primary_speciality_code=? and upper(b.practitioner_name) like upper(?)";					
				}
				else
				{
					sql ="select distinct b.practitioner_id, b.practitioner_name from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id =? and upper(b.practitioner_name) like upper(?) ";	
					

				}
			
			}else if (selFunVal.equals("Location"))
			{
				locationcode = locationcode + "%";
				 if(!locationcode.equals(""))
				{
					sql ="SELECT short_desc description ,locn_code code FROM ca_locn_vw where locn_type = ? and facility_id = ?  and upper(short_desc) like upper(?) ";
				}
			}else if (selFunVal.equals("Location1"))
			{
				 if(!locationcode1.equals(""))
				{
					sql ="SELECT short_desc description ,locn_code code FROM ca_locn_vw where locn_type = ? and facility_id = ?  and upper(short_desc) like upper(?) ";
					
					locationcode1 = locationcode1 + "%";					
				}
			}else if (selFunVal.equals("Speciality"))
			{
					if(!specialitycode.equals(""))
					{
						sql ="Select speciality_code code, short_desc description from am_speciality where upper(short_desc) like upper(?) ";

						specialitycode = specialitycode + "%";
					}
			
			}else if (selFunVal.equals("PrimeSpeciality")){
				if(!primespeciality.equals(""))
				{
					sql ="Select speciality_code code, short_desc description from am_speciality where upper(short_desc) like upper(?) ";
					primespeciality = primespeciality + "%";				
				}
			}
		
			
			ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			if (selFunVal.equals("Pract")){
				if(!speciality.equals(""))
				{
					ps.setString(1,facility_id);
					ps.setString(2,speciality);
					ps.setString(3,practitioner);
				}
				else
				{
					ps.setString(1,facility_id);
					ps.setString(2,practitioner);

				}
			
			}else if (selFunVal.equals("Location"))
			{
				 if(!locationcode.equals(""))
				{					
					ps.setString(1,locn_type);
					ps.setString(2,facility_id);
					ps.setString(3,locationcode);
				}
			}else if (selFunVal.equals("Location1"))
			{
				 if(!locationcode1.equals(""))
				{
					ps.setString(1,locn_type);
					ps.setString(2,facility_id);
					ps.setString(3,locationcode1);
				}
			}else if (selFunVal.equals("Speciality"))
			{
					if(!specialitycode.equals(""))
					{					
						ps.setString(1,specialitycode);	
					}
			
			}else if (selFunVal.equals("PrimeSpeciality")){
				if(!primespeciality.equals(""))
				{
					ps.setString(1,primespeciality);	
				}
			}
					
			rs = ps.executeQuery();
		
			while(rs.next())
			{
				count++;
			}
			
			
			if(count == 1)
			 {
		
				rs.beforeFirst() ;				
				out.println("<script>");
               if(!speciality.equals(""))
			  {
				   while(rs.next())
				{						
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.pctr.value='"+rs.getString(2)+"' ");
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.Header.document.LPract.practitioner_id.value='"+rs.getString(1)+"' ");
					out.println("PopulateName('"+rs.getString(1)+"');");
				}
				
			  }
			  else if(speciality.equals("") && selFunVal.equals("Pract"))
			  {
				while(rs.next())
				{						
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.pctr.value='"+rs.getString(2)+"' ");
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.Header.document.LPract.practitioner_id.value='"+rs.getString(1)+"' ");
					out.println("PopulateName('"+rs.getString(1)+"');");
				}
			  }

			 
			  
			  if(!locationcode.equals(""))
			  {
					  while(rs.next())
				{
					out.println("parent.parent.f_query_add_mod.AddModify.document.Section_form.loca.value='"+rs.getString(1)+"' ");
					out.println("parent.parent.f_query_add_mod.AddModify.document.Section_form.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.AddModify.document.Section_form.locn_code.value='"+rs.getString(2)+"' ");
				}
			}
			if(!locationcode1.equals(""))
			  {
					  while(rs.next())
				{
					out.println("parent.parent.f_query_add_mod.Query.document.qry_location.locn_code.value='"+rs.getString(1)+"' ");
					out.println("parent.parent.f_query_add_mod.Query.document.qry_location.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.Query.document.qry_location.locaSerch.value='"+rs.getString(2)+"' ");
				}
			}

			if(!specialitycode.equals(""))
			  {
				 while(rs.next())
				{
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.spl.value='"+rs.getString(2)+"' ");
					out.println("parent.parent.f_query_add_mod.Header.document.LPract.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.Header.document.LPract.spl_code.value='"+rs.getString(1)+"' ");
				}
			}

			if(!primespeciality.equals(""))
			  {
					  while(rs.next())
				{
					out.println("parent.parent.f_query_add_mod.Query.document.qry_location.speciality.value='"+rs.getString(2)+"' ");
					out.println("parent.parent.f_query_add_mod.Query.document.qry_location.flag.value='true' ");	out.println("parent.parent.f_query_add_mod.Query.document.qry_location.prime_spl_code.value='"+rs.getString(1)+"' ");
				}
			}
			out.println("</script>");
		   }
		  
		    if(ps != null) ps.close();
		    if(rs != null) rs.close();

			if(count == 0 || count > 1)
			{			
				if(!speciality.equals(""))
			{
				sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+facility_id+"' and b.primary_speciality_code='"+speciality+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by 2";
			}
			else
			{
				sql ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where b.practitioner_id = a.func_role_id and b.operating_facility_id ='"+facility_id+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by 2";
                


			}
			if(!locationcode.equals(""))
			{
				sql ="SELECT short_desc description ,locn_code code FROM ca_locn_vw where locn_type = '"+locn_type+"' and facility_id = '"+facility_id+"'  and  upper(locn_code) like upper(?) and upper(short_desc) like upper(?) order by 1";
			}
			if(!locationcode1.equals(""))
			{
				sql ="SELECT short_desc description ,locn_code code FROM ca_locn_vw where locn_type = '"+locn_type+"' and facility_id = '"+facility_id+"'  and  upper(locn_code) like upper(?) and upper(short_desc) like upper(?) order by 1";
			}

			if(!specialitycode.equals(""))
			{
				sql ="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
			}
			if(!primespeciality.equals(""))
			{
				sql ="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
			}

%>
	<script>
async function openShowmodal(){
		var chkVal = "<%=selFunVal%>";

		if (chkVal == "Pract")
		{			
			 retArray = await callFunction("<%=sql%>","LocationPract",parent.parent.f_query_add_mod.Header.document.LPract.pctr)

			if(retArray != null && retArray !="")	
			{
				var ret1=unescape(retArray);
				 var arr=ret1.split(",");
					if(arr[1]==undefined) 
					{
						arr[0]="";	
						arr[1]="";	
					}
				    
					parent.parent.f_query_add_mod.Header.document.LPract.pctr.value = arr[1];
					parent.parent.f_query_add_mod.Header.document.LPract.practitioner_id.value = arr[0];
					parent.parent.f_query_add_mod.Header.document.LPract.flag.value = 'true'
					
					parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
			}
			else
			{
				parent.parent.f_query_add_mod.Header.document.LPract.pctr.value = ''
				parent.parent.f_query_add_mod.Header.document.LPract.practitioner_id.value = ''
				parent.parent.f_query_add_mod.Header.document.LPract.flag.value = 'true'
				parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			}
		}else if (chkVal == "Location")
		{		
				retVal =await callFunction1("<%=sql%>","Location",parent.parent.f_query_add_mod.AddModify.document.Section_form.loca)

				if(retVal != null && retVal !="")	
				{
					var ret1=unescape(retVal);
					 var arr=ret1.split(",");
						if(arr[1]==undefined) 
						{
							arr[0]="";	
							arr[1]="";	
						}
						parent.parent.f_query_add_mod.AddModify.document.Section_form.loca.value = arr[1];
						parent.parent.f_query_add_mod.AddModify.document.Section_form.locn_code.value = arr[0];
						parent.parent.f_query_add_mod.AddModify.document.Section_form.flag.value = 'true'
						
						parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.parent.f_query_add_mod.AddModify.document.Section_form.loca.value = ''
					parent.parent.f_query_add_mod.AddModify.document.Section_form.locn_code.value = ''
					parent.parent.f_query_add_mod.AddModify.document.Section_form.flag.value = 'true'
					parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
			}else if (chkVal == "Location1")
		     {				
				retVal = await callFunction2("<%=sql%>","Location",parent.parent.f_query_add_mod.Query.document.qry_location.locn_code)

				if(retVal != null && retVal !="")	
				{      
					var ret1=unescape(retVal);
					 var arr=ret1.split(",");
						if(arr[1]==undefined) 
						{
							arr[0]="";	
							arr[1]="";	
						}
						parent.parent.f_query_add_mod.Query.document.qry_location.locn_code.value = arr[1];
						parent.parent.f_query_add_mod.Query.document.qry_location.locaSerch.value = arr[0];
						parent.parent.f_query_add_mod.Query.document.qry_location.flag.value = 'true'
						
						parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.parent.f_query_add_mod.Query.document.qry_location.locn_code.value = ''
					parent.parent.f_query_add_mod.Query.document.qry_location.locaSerch.value = ''
					parent.parent.f_query_add_mod.Query.document.qry_location.flag.value = 'true'
					parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}

			 }else if (chkVal == "Speciality")
		        {				
				retVal = await callFunction3("<%=sql%>","Speciality",parent.parent.f_query_add_mod.Header.document.LPract.spl)

				if(retVal != null && retVal !="")	
				{      
					var ret1=unescape(retVal);
					 var arr=ret1.split(",");
						if(arr[1]==undefined) 
						{
							arr[0]="";	
							arr[1]="";	
						}
						parent.parent.f_query_add_mod.Header.document.LPract.spl.value = arr[1];
						parent.parent.f_query_add_mod.Header.document.LPract.spl_code.value = arr[0];
						parent.parent.f_query_add_mod.Header.document.LPract.flag.value = 'true'
						
						parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.parent.f_query_add_mod.Header.document.LPract.spl.value = ''
					parent.parent.f_query_add_mod.Header.document.LPract.spl_code.value = ''
					parent.parent.f_query_add_mod.Header.document.LPract.flag.value = 'true'
					parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}
			  }else if (chkVal == "PrimeSpeciality")
		       {				  
				retVal = await callFunction4("<%=sql%>","Speciality",parent.parent.f_query_add_mod.Query.document.qry_location.speciality)

				if(retVal != null && retVal !="")	
				{		
					var ret1=unescape(retVal);
					 var arr=ret1.split(",");
						if(arr[1]==undefined) 
						{
							arr[0]="";	
							arr[1]="";	
						}
						parent.parent.f_query_add_mod.Query.document.qry_location.speciality.value = arr[1];
						parent.parent.f_query_add_mod.Query.document.qry_location.prime_spl_code.value = arr[0];
						parent.parent.f_query_add_mod.Query.document.qry_location.flag.value = 'true'
						
						parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
				}
				else
				{
					parent.parent.f_query_add_mod.Query.document.qry_location.speciality.value = ''
					parent.parent.f_query_add_mod.Query.document.qry_location.prime_spl_code.value = ''
					parent.parent.f_query_add_mod.Query.document.qry_location.flag.value = 'true'
					parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				}

			 }
		
		}
openShowmodal();
	</script>
<%	
	}
	
}
	catch(Exception ee)
	{
		ee.printStackTrace();
		//out.println("Exception in Location For Pract Intermediate Module "+ee.toString());//COMMON-ICN-0181	
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

