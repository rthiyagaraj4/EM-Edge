<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

      <head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
	    
		<script src='../../eMR/js/HMISMaster.js' language='javascript'></script>
	  
	 </head>

      <%
	  Connection con = null;
	  PreparedStatement pstmt=null;
	  PreparedStatement pstmt1=null;
	  PreparedStatement pstmt2=null;
	  ResultSet rs=null ;
	  ResultSet rs1=null ;
	  ResultSet rs2=null ;
	  String mysql="";
	  String mysql1="";
	  String mysql2="";
	  String efstat="";
	  String check="";
	  String check1="";
	  String Facility="";
	  String Code="";
	  String Desc="";
	  String HospitalCode="";
	  String WardCode="";
	  String Moduledes="";
      String heading="";
	  String disp="";
	  String spec="";
	 String descrip="";
	 String facdesc="";
	 String warddesc="";
	 String specdesc="";
	 String indi="";
	 String indidisp="";
     String warddisp="";
	 String warddisp1="";
	String  hospdisp="";
	String  hospdisp1="";

	  try
	  {
		con = ConnectionManager.getConnection(request);
		Facility=request.getParameter("facility")==null ?"":request.getParameter("facility");
	    Code= (request.getParameter("code1")==null) ?"":request.getParameter("code1");
	    Desc= request.getParameter("code2")==null?"":request.getParameter("code2");
        HospitalCode=request.getParameter("code4");
	    if ((HospitalCode==null) || (HospitalCode.equals("null"))) {HospitalCode = "";}else{hospdisp="disabled";}
	    WardCode= (request.getParameter("code3")==null)?"":request.getParameter("code3");
	    if ((WardCode==null) || (WardCode.equals("null"))){ WardCode = "";warddisp="";}else {warddisp="readonly";warddisp1="disabled";}
        
	    Moduledes= (request.getParameter("code6")==null)?"":request.getParameter("code6");
	   heading= (request.getParameter("code7")==null)?"":request.getParameter("code7");
	   disp= (request.getParameter("disp")==null)?"":request.getParameter("disp");
	   if ((disp==null) || (disp.equals("null"))) {disp = "";}else{hospdisp1="disabled";}
	  
	  spec= (request.getParameter("spec")==null)?"":request.getParameter("spec");
	  if ((spec==null) || (spec.equals("null"))) spec = "";
	  
	  descrip= (request.getParameter("descrip")==null)?"":request.getParameter("descrip");
	  if ((descrip==null) || (descrip.equals("null"))) descrip = "";
	   
	  facdesc= (request.getParameter("facdesc")==null)?"":request.getParameter("facdesc");
	  if ((facdesc==null) || (facdesc.equals("null")))  facdesc = "";
	  
	  indi= (request.getParameter("indi")==null)?"":request.getParameter("indi");
	  
	  if ((indi==null)||(indi.equals("null"))){indi = "";}else{indidisp="disabled";}
	  
	  
	  efstat= (request.getParameter("efstat")==null)?"":request.getParameter("efstat");
	  if ((efstat==null)||(efstat.equals("null")))efstat = "";
	  
	
	  
		
	  warddesc= (request.getParameter("warddesc")==null)?"":request.getParameter("warddesc");
	  if ((warddesc==null) || (warddesc.equals("null"))) warddesc = "";
	    
	  specdesc= (request.getParameter("specdesc")==null)?"":request.getParameter("specdesc");
	  if ((specdesc==null) || (specdesc.equals("null"))) specdesc = "";
	   %>
	  
	 <body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	
	<form name='hmis_form' id='hmis_form' action='../../servlet/eMR.HMISMastersServlet' method='post' target='messageFrame'>
	
	
	  
	<table border='0' cellpadding='5' cellspacing='0' align='center' width='95%'>
     <tr>         
	<td colspan=4 class="COLUMNHEADER"><%=heading%></th> 
	</tr>
	<%
		
 if(Moduledes.equals("IP_NURS_UNIT_FOR_SPECIALTY"))
	{
	        mysql="select hmis_code1 from xt_hmis_link where table_id = 'SM_FACILITY_PARAM'";
            pstmt=con.prepareStatement(mysql);
            rs=pstmt.executeQuery();
	        mysql1="select hmis_code1, hmis_code1 from xt_hmis_link where table_id = 'IP_NURSING_UNIT'";
            pstmt1=con.prepareStatement(mysql1);
			rs1=pstmt1.executeQuery();
            mysql2="select hmis_code1, hmis_code1 from xt_hmis_link where table_id = 'AM_SPECIALITY' ";
			pstmt2=con.prepareStatement(mysql2);
			rs2=pstmt2.executeQuery();
           %>
		 
		 <tr>
			 
		   <td class='label' width='20%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class="fields" width='20%'><%=facdesc%></td>
			<td class='label' width='20%'><fmt:message key="eMR.HospitalCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" width='40%'>
		
		   <SELECT name="hospital_code" id="hospital_code"  <%=warddisp1%>>
			 <Option>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
		
		   <% while(rs.next())
		    {
		     	if (WardCode.equals(rs.getString(1)))
				{%>
		    <Option value='<%=rs.getString(1)%>' selected disabled ><%=rs.getString(1)%></option>
				<%}
				else{%>
                <Option value='<%=rs.getString(1)%>' ><%=rs.getString(1)%></option>
			<%}}%>
		   </SELECT><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		
		   </tr>
          
		<tr>
			<td class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td class="fields" ><%=warddesc%></td>
			<td class='label' ><fmt:message key="eMR.WardCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" >
			<SELECT name="hmis_code" id="hmis_code" <%=hospdisp%>><Option>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option> 
		<%
		while(rs1.next())
		    {
		     	   if (HospitalCode.equals(rs1.getString(1)))
				{%>
		    <Option value='<%=rs1.getString(1)%>' selected disabled ><%=rs1.getString(1)%></option>
				<%}
				else{%>
                <Option value='<%=rs1.getString(1)%>' ><%=rs1.getString(1)%></option>
			<%}}%>
		   </SELECT><img src='../../eCommon/images/mandatory.gif' align='center'></img>	
			</td>
		</tr>
	
		<tr>		
			<td class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class="fields" ><%=specdesc%></td>
			<td class='label' ><fmt:message key="eMR.DisciplineCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" >
			<SELECT name="disp" id="disp" <%=hospdisp1%>><Option>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option> 
			
		<% 
		while(rs2.next())
		    {
		     	   if (disp.equals(rs2.getString(1)))
				{%>
		    <Option value='<%=rs2.getString(1)%>' selected  ><%=rs2.getString(1)%></option>
				<%}
				else{%>
                <Option value='<%=rs2.getString(1)%>' ><%=rs2.getString(1)%></option>
			<%}}	%>
		
		</SELECT><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		</tr>
  		
	<%
	}
	else if (Moduledes.equals("IP_NURSING_UNIT"))
	{
		    mysql="select hmis_code1 from xt_hmis_link where table_id = 'SM_FACILITY_PARAM'";
            pstmt=con.prepareStatement(mysql);
            rs=pstmt.executeQuery();
	       if(efstat.equals("Y"))
		   {
		 check="checked";
		 check1="disabled";
		}
		else
		{
		
		}
		 
		
			 %>
				
		<tr>
			<td class='label' width='20%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class="fields" width='20%'><%=descrip%></td>
			<td class='label'  width='20%'><fmt:message key="eMR.HospitalCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" width='40%'>
			<SELECT name="hospital_code" id="hospital_code" <%=warddisp1%>>
				 <Option>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option> 
			 	<% while(rs.next())
		    {
		      
		       if (WardCode.equals(rs.getString(1)))
				{%>
		        <Option  value='<%=rs.getString(1)%>' selected><%=rs.getString(1)%></option>
				<%}
				else{%>
                <Option value='<%=rs.getString(1)%>' ><%=rs.getString(1)%></option>
			<%}}
				%>
			 </SELECT><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		</tr> 
			
 		<!-- <tr><td width='20%' colspan='4'>&nbsp;</td></tr>
		<tr>
			<td class='label' align='right' width='20%'>Facility&nbsp;&nbsp;</td>
			<td class="label" align='left' width='30%'><b>&nbsp;&nbsp;<%=descrip%></b></td>
			<td class='label' align='right' width='20%'>Hospital Code&nbsp;&nbsp;</td>
			<td class="label" align='left' width='30%'>
			<input type ='text' name = 'hospital_code' size ='10' maxlength='10' value ='<%=WardCode%>'  onBlur='makeValidString(this)'  onKeyPress="return CheckForSpecChars(event)"   >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		</tr> -->
			
		<tr>
			<td class='label' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class="fields" ><%=Code%></td>
			<td class='label' ><fmt:message key="eMR.WardCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" >
			<input type ='text' name = 'hmis_code' size ='10' maxlength='10' value ='<%=HospitalCode%>' onBlur='makeValidString(this)'  onKeyPress="return CheckForSpecChars(event)" <%=warddisp%>  ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		</tr>

		<tr>
			<td class='label' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class="fields" ><%=Desc%></td>
			<td class='label' ><fmt:message key="eMR.MaternityWard.label" bundle="${mr_labels}"/></td>
			<td class="fields" >
		
			<input type ='checkbox'  value='N' name = 'emer_maternity_yn'   <%=check%> <%=warddisp1%> onClick="checkEn()" >
			</td>
		</tr>
 		
	<%
	}
	else if (Moduledes.equals("OP_CLINIC"))
	{
		    mysql="select hmis_code1 from xt_hmis_link where table_id = 'SM_FACILITY_PARAM'";
            pstmt=con.prepareStatement(mysql);
            rs=pstmt.executeQuery();
	       if(efstat.equals("Y"))
		   {
		 check="checked";
		 check1="disabled";
		}
		
		 
		
			 %>
				
		<tr>
			<td class='label' width='20%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<td class="fields" width='20%'><%=descrip%></td>
			<td class='label'  width='20%'><fmt:message key="eMR.HospitalCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" width='40%'>
			<SELECT name="hospital_code" id="hospital_code" <%=warddisp1%>>
				 <Option>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option> 
			 	<% while(rs.next())
		    {
		      
		       if (WardCode.equals(rs.getString(1)))
				{%>
		        <Option  value='<%=rs.getString(1)%>' selected><%=rs.getString(1)%></option>
				<%}
				else{%>
                <Option value='<%=rs.getString(1)%>' ><%=rs.getString(1)%></option>
			<%}}
				%>
			 </SELECT><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		</tr> 
			
 			
		<tr>
			<td class='label' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class="fields" ><%=Code%></td>
			<td class='label' ><fmt:message key="eMR.ExternalMasterCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" >
			<input type ='text' name = 'hmis_code' size ='10' maxlength='10' value ='<%=HospitalCode%>' onBlur='makeValidString(this)'  onKeyPress="return CheckForSpecChars(event)" <%=warddisp%>  ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		</tr>

		<tr>
			<td class='label'  ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class="fields" ><%=Desc%></td>
			<td class='label' colspan='2'></td>
			
		</tr>
 		
	<%
	}
	else if(Moduledes.equals("IP_DISCHARGE_TYPE"))
	{
	%>
 		
		<tr>
			<td class='label' width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class="fields" width='20%'><%=Code%></td>
			<td class='label'  width='20%' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class="fields" width='40%'><%=Desc%></td>
		</tr>
 		
        <tr>
			<td class='label' ><fmt:message key="eMR.ExternalMasterCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" >
			<input type ='text' name = 'hmis_code' size ='10' maxlength='10' 
		         value ='<%=WardCode%>' onBlur='makeValidString(this)'   onKeyPress="return CheckForSpecChars(event)"   <%=warddisp%>><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td class='label' ><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/></td>
			<td class="fields" >
			<%	
					 if(indi.equals(""))
		{%>
			         <select name='indicator' id='indicator' >
					<option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
					 <option value='DHM'><fmt:message key="Common.home.label" bundle="${common_labels}"/></option>
				     <option value='DTH'><fmt:message key="eMR.Death.label" bundle="${mr_labels}"/></option>
					<option value='ABS'><fmt:message key="Common.Abscond.label" bundle="${common_labels}"/></option>
					<option value='AOR'><fmt:message key="Common.AtOwnRisk.label" bundle="${common_labels}"/></option>
					<option value='TOH'><fmt:message key="Common.TransfertoOtherHospital.label" bundle="${common_labels}"/></option></option>
					<%}else{%>
	        			<select name='indicator' id='indicator' disabled>
				  <%if(indi.equals("DHM"))
			{%>
		            <option value='DHM' selected><fmt:message key="Common.home.label" bundle="${common_labels}"/></option>
				     <option value='DTH'><fmt:message key="eMR.Death.label" bundle="${mr_labels}"/></option>
					<option value='ABS'><fmt:message key="Common.Abscond.label" bundle="${common_labels}"/></option>
					<option value='AOR'><fmt:message key="Common.AtOwnRisk.label" bundle="${common_labels}"/></option>
					<option value='TOH'><fmt:message key="Common.TransfertoOtherHospital.label" bundle="${common_labels}"/></option></option>
					
    		<%} if(indi.equals("DTH"))
			{%>
				   <option value='DHM'><fmt:message key="Common.home.label" bundle="${common_labels}"/></option>
				     <option value='DTH' selected ><fmt:message key="eMR.Death.label" bundle="${mr_labels}"/></option>
					<option value='ABS'><fmt:message key="Common.Abscond.label" bundle="${common_labels}"/></option>
					<option value='AOR'><fmt:message key="Common.AtOwnRisk.label" bundle="${common_labels}"/></option>
					<option value='TOH'><fmt:message key="Common.TransfertoOtherHospital.label" bundle="${common_labels}"/></option></option>
					
    		<%}
					
					if(indi.equals("ABS"))
			{%>
					<option value='DHM'><fmt:message key="Common.home.label" bundle="${common_labels}"/></option>
				     <option value='DTH'><fmt:message key="eMR.Death.label" bundle="${mr_labels}"/></option>
					<option value='ABS' selected ><fmt:message key="Common.Abscond.label" bundle="${common_labels}"/></option>
					<option value='AOR'><fmt:message key="Common.AtOwnRisk.label" bundle="${common_labels}"/></option>
					<option value='TOH'><fmt:message key="Common.TransfertoOtherHospital.label" bundle="${common_labels}"/></option></option>
					
    		<%}if(indi.equals("AOR")){%>
					<option value='DHM'><fmt:message key="Common.home.label" bundle="${common_labels}"/></option>
				     <option value='DTH'><fmt:message key="eMR.Death.label" bundle="${mr_labels}"/></option>
					<option value='ABS'><fmt:message key="Common.Abscond.label" bundle="${common_labels}"/></option>
					<option value='AOR' selected><fmt:message key="Common.AtOwnRisk.label" bundle="${common_labels}"/></option>
					<option value='TOH'><fmt:message key="Common.TransfertoOtherHospital.label" bundle="${common_labels}"/></option></option>
					
			   <%}
			 if(indi.equals("TOH")){%>
					<option value='DHM'><fmt:message key="Common.home.label" bundle="${common_labels}"/></option>
				     <option value='DTH'><fmt:message key="eMR.Death.label" bundle="${mr_labels}"/></option>
					<option value='ABS'><fmt:message key="Common.Abscond.label" bundle="${common_labels}"/></option>
					<option value='AOR'><fmt:message key="Common.AtOwnRisk.label" bundle="${common_labels}"/></option>
					<option value='TOH' selected ><fmt:message key="Common.TransfertoOtherHospital.label" bundle="${common_labels}"/></option></option>
					
			   <%}}%>
			
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		</tr>
  		
	<%
	}
	else if(Moduledes.equals("IP_BED_CLASS"))
	{
	%>
 		
		<tr>
			<td class='label' width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class="fields" width='20%'><%=Code%></td>
			<td class='label' width='20%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class="fields" width='40%'><%=Desc%></td>
		</tr>
 		
        <tr>
			<td class='label' ><fmt:message key="eMR.ExternalMasterCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" >
			<input type ='text' name = 'hmis_code' size ='10' maxlength='10' value ='<%=WardCode%>'
			onBlur='makeValidString(this)'    onKeyPress="return CheckForSpecChars(event)" <%=warddisp%>><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td class='label' ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
			
		<%	if(indi.equals(""))
		{%>
			<td class="fields" >
				<select name='indicator' id='indicator' >
					<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
				    <option value='1C'>1st Class</option>
    				<option value='2C'>2nd Class</option>
    				<option value='3C'>3rd Class</option>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		<%}else{%>
	        	<td class="fields" >
				<select name='indicator' id='indicator'  disabled>
					
				    <%if(indi.equals("1C"))
			{%>
						<option value='1C' selected>1st Class</option>
						<option value='2C'>2nd Class</option>
						<option value='3C'>3rd Class</option>
    		<%} if(indi.equals("2C"))
			{%>
						<option value='1C'>1st Class</option>
						<option value='2C' selected>2nd Class</option>
						<option value='3C'>3rd Class</option>
    		<%}if(indi.equals("3C")){%>
						<option value='1C'>1st Class</option>
						<option value='2C'>2nd Class</option>	
						<option value='3C' selected>3rd Class</option>
			   <%}%>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
		
		
		<%}%>

		</tr>
  		
	<%
	}
	else if(Moduledes.equals("MP_NOD_TYPE"))
	{
	%>
 		
		<tr>
			<td class='label' width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class="fields"  width='20%'><%=Code%></td>
			<td class='label' width='20%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class="fields" width='40%'><%=Desc%></td>
		</tr>
 		
        <tr>
			<td class='label' ><fmt:message key="eMR.ExternalMasterCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" >
			<input type ='text' name = 'hmis_code' size ='10'  maxlength='10' value ='<%=WardCode%>'
            onBlur='makeValidString(this)' onKeyPress="return CheckForSpecChars(event)"   <%=warddisp%> ><img src='../../eCommon/images/mandatory.gif' align='center'  onKeyPress="return CheckForSpecChars(event)" ></img>
			</td>
	                
			<td class='label' ><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></td>
			<td class="fields" >
		  

			<%	if(indi.equals(""))
		{%>	
		   		 <select name='indicator' id='indicator'  >		
			<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
					<option value='NRD'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
					<option value='CSD'><fmt:message key="eMR.Ceasarean.label" bundle="${mr_labels}"/></option>
					<option value='FRD'><fmt:message key="eMR.Forceps.label" bundle="${mr_labels}"/></option>
					<option value='VCD'><fmt:message key="eMR.Vacuum.label" bundle="${mr_labels}"/></option>
					<option value='OTH'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
		<%}else{%>
	        	
				 <select name='indicator' id='indicator' disabled>
					
				    <%if(indi.equals("NRD"))
			{%>
		            <option value='NRD' selected><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
					<option value='CSD'><fmt:message key="eMR.Ceasarean.label" bundle="${mr_labels}"/></option>
					<option value='FRD'><fmt:message key="eMR.Forceps.label" bundle="${mr_labels}"/></option>
					<option value='VCD'><fmt:message key="eMR.Vacuum.label" bundle="${mr_labels}"/></option>
					<option value='OTH'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
    		<%} if(indi.equals("CSD"))
			{%>    <option value='NRD' ><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
					<option value='CSD' selected><fmt:message key="eMR.Ceasarean.label" bundle="${mr_labels}"/></option>
					<option value='FRD'><fmt:message key="eMR.Forceps.label" bundle="${mr_labels}"/></option>
					<option value='VCD'><fmt:message key="eMR.Vacuum.label" bundle="${mr_labels}"/></option>
					<option value='OTH'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
    		<%}if(indi.equals("FRD")){%>
					<option value='NRD'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
					<option value='CSD'><fmt:message key="eMR.Ceasarean.label" bundle="${mr_labels}"/></option>
					<option value='FRD' selected><fmt:message key="eMR.Forceps.label" bundle="${mr_labels}"/></option>
					<option value='VCD'><fmt:message key="eMR.Vacuum.label" bundle="${mr_labels}"/></option>
					<option value='OTH'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
			   <%}
						if(indi.equals("VCD")){%>
					   <option value='NRD'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
					<option value='CSD'><fmt:message key="eMR.Ceasarean.label" bundle="${mr_labels}"/></option>
					<option value='FRD'><fmt:message key="eMR.Forceps.label" bundle="${mr_labels}"/></option>
					<option value='VCD' selected><fmt:message key="eMR.Vacuum.label" bundle="${mr_labels}"/></option>
					<option value='OTH'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
			   <%}if(indi.equals("OTH")){%>
					   <option value='NRD'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
					<option value='CSD'><fmt:message key="eMR.Ceasarean.label" bundle="${mr_labels}"/></option>
					<option value='FRD'><fmt:message key="eMR.Forceps.label" bundle="${mr_labels}"/></option>
					<option value='VCD'><fmt:message key="eMR.Vacuum.label" bundle="${mr_labels}"/></option>
					<option value='OTH' selected><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
			   <%}}%>

     </select><img src='../../eCommon/images/mandatory.gif' align='center'></img>


</td>
			</tr>
  		
	
		
<%
	}else if(Moduledes.equals("MP_REGION"))
		  {
	   if(indi.equals("Y"))
		   {
		 check="checked";
		 check1="disabled";
		}
		

	
	%>

  
		<tr>
			<td class='label'  width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class="fields" width='20%'><%=Code%></td>
			<td class='label'  width='20%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class="fields" width='40%'><%=Desc%></td>
		</tr>
 		
        <tr>
			<td class='label' ><fmt:message key="eMR.ExternalMasterCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" >
			<input type ='text' name = 'hmis_code' size ='10' maxlength='10' value ='<%=WardCode%>' onBlur='makeValidString(this)' onKeyPress="return CheckForSpecChars(event)"  <%=warddisp%> > <img src='../../eCommon/images/mandatory.gif' align='center'></img>
			
			</td>
	   	   <td class="label" >
		     <fmt:message key="eMR.HomeState.label" bundle="${mr_labels}"/></td>
			<td class="fields"><input type ='checkbox'  value='N' name = 'indicator'   <%=check%> <%=warddisp1%> onClick="checkEn1()" >
			</td>
			<!-- <td class='label' align='right' width='15%'>&nbsp;&nbsp;</td>
			<td class="label" align='left' width='40%'>&nbsp;&nbsp;</td> -->
		</tr>
  		
		  
		  <%}
      
	else
	{
	%>
 		
		<tr>
			<td class='label'  width='20%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td class="fields"  width='20%'><%=Code%></td>
			<td class='label'  width='20%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class="fields"  width='40%'><%=Desc%></td>
		</tr>
 		
        <tr>
			<td class='label' ><fmt:message key="eMR.ExternalMasterCode.label" bundle="${mr_labels}"/></td>
			<td class="fields" >
			<input type ='text' name = 'hmis_code' size ='10' maxlength='10' value ='<%=WardCode%>' onBlur='makeValidString(this)' onKeyPress="return CheckForSpecChars(event)"  <%=warddisp%> > <img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
			<td class='label' colspan='2' ></td>
			
		</tr>
  		
	<%
	}
			
			}catch(Exception e)
	{
	}
		finally
{
	try
	{

	if(pstmt != null)pstmt.close();
	if(pstmt1 != null)pstmt1.close();
    if(pstmt2 != null)pstmt2.close(); 
	}
	catch(Exception e1)
	{
	}
	ConnectionManager.returnConnection(con,request);

}


	%>
   	</table>
   	
	<INPUT TYPE="hidden" name="tableId" id="tableId" value=<%=Moduledes%>>
	<INPUT TYPE="hidden" name="facility" id="facility" value=<%=Facility%>>
	<INPUT TYPE="hidden" name="spec" id="spec" value=<%=spec%>>
	<INPUT TYPE="hidden" name="Code" id="Code" value=<%=Code%>>
	<INPUT TYPE="hidden" name="func" id="func" value="insert">
	<INPUT TYPE="hidden" name="ward" id="ward" value=<%=warddisp%>>
   	</form>

	</body>
   	</html> 
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

