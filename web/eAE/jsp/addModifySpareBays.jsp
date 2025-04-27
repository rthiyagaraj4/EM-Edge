<!DOCTYPE html>
<%@ page   import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, org.json.simple.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
	  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	  <script language='javascript' src='../js/SpareBays.js'></script>
	  <script language='javascript' src='../../eCommon/js/common.js'></script>
	  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	</head>
<%	 
	Connection con 					= null;
	PreparedStatement pstmt			= null;
	ResultSet rset				    = null;
	ArrayList Arr_Of_HashMap=new ArrayList();
	request.setCharacterEncoding("UTF-8");

	
	String	facilityId				= (String) session.getValue( "facility_id" ) ;
	String mode						= "";
	
	
	String clinic_code				= request.getParameter("clinic_code");
	clinic_code 					= (clinic_code == null)?"":clinic_code;

	String bay_no					= request.getParameter("bay_no");
	bay_no							= (bay_no == null)?"":bay_no;
	
	//Added by Ashwini on 30-Mar-2018 for PMG2018-COMN-CRF-0001
	String isBedOccupied	="";

	try
	{
		con									= ConnectionManager.getConnection(request);
		String clinic_code1					= "";
		String bay_no1						= "";
		String bay_type_code                 ="";
		String bay_type_desc="";
		String eff_status					= "";	
		String checkBoxAttribute			= "";
		String checkBoxAttribute1			="";
		String readonly                     = "";
		String modifymode						= "";
		String spareBay						="";
		String sparebayval="";
		mode = "INSERT";
		
		String sql = "select clinic_code,bay_no,bay_type_code,bay_type_desc,eff_status,spare_bay_yn from AE_SPARE_BAYS_VW where clinic_code=? and  bay_no=? and facility_id=? ";
		
		if(!(clinic_code.equals("")  && bay_no.equals("")))
		{
			pstmt   = con.prepareStatement(sql);
			pstmt.setString(1,clinic_code);
			pstmt.setString(2,bay_no);
			pstmt.setString(3,facilityId);
			rset = pstmt.executeQuery();
			
			while(rset!=null && rset.next())
			{
				clinic_code1					= rset.getString("clinic_code");    
				clinic_code1	 				= (clinic_code1 == null)?"":clinic_code1;
				bay_no1							= rset.getString("bay_no");
				bay_no1				 			= (bay_no1 == null)?"":bay_no1;

				bay_type_code				   = rset.getString("bay_type_code");
			    bay_type_code 			       = (bay_type_code == null)?"":bay_type_code;
				bay_type_desc                  =(rset.getString("bay_type_desc") == null)?"":rset.getString("bay_type_desc");
				eff_status						= rset.getString("eff_status");
			
                spareBay=rset.getString("spare_bay_yn");
				if(spareBay!=null && spareBay.equalsIgnoreCase("Y"))
				{
				       checkBoxAttribute1="CHECKED";
					   sparebayval="Y";
				}
				else {
					   checkBoxAttribute1="";
					   sparebayval="N";
				}
				if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
				{
						checkBoxAttribute   = "CHECKED";
				}
				else
					readonly="disabled";
				mode = "MODIFY";
			}
			if(rset!=null)  rset.close();
			if(pstmt!=null)  pstmt.close();
		}	// end of if clinic_code	  
		if(mode.equalsIgnoreCase("INSERT"))
		{
			checkBoxAttribute = "CHECKED";
			checkBoxAttribute1="";
		}else if(mode.equalsIgnoreCase("MODIFY")) modifymode="disabled";

		/*Added by Ashwini on 30-Mar-2018 for PMG2018-COMN-CRF-0001*/
		if(mode.equalsIgnoreCase("MODIFY"))
		{
		JSONObject jsonValue = eAE.AECommonBean.getAEBedOccupiedStatus(con, bay_no1, clinic_code1, facilityId);
		isBedOccupied		 = (String) jsonValue.get("isBedOccupied");
		}
		/*End PMG2018-COMN-CRF-0001*/

		%>
		<body OnMouseDown='CodeArrest()' onLoad='setFocus();' onKeyDown = 'lockKey()'>
			 <form name="bed_treatment_area_form" id="bed_treatment_area_form" action="../../servlet/eAE.SpareBaysServlet" method="post" target="messageFrame">
	
				<table border="0" cellpadding="3" cellspacing="0" align='center' width='70%'>
				 <br><br><br><br>
					<tr><td colspan='2' height='5'></td></tr>
				    <tr>
					    <td class='label'  width='50%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
						<td class='field'  width='50%'>
							<select name='clinic_code' id='clinic_code'  value='' <%=readonly%>   <%=modifymode%>>
								<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%								
								String clinic	= " select  distinct clinic_code, CLINIC_LONG_DESC clinic_desc from ae_tmt_area_for_clinic_vw where eff_status = 'E' and facility_id=? order by 2 ";	

								 pstmt   = con.prepareStatement(clinic);
								 pstmt.setString(1,facilityId) ;
								 rset   = pstmt.executeQuery();
								 while(rset!=null && rset.next())
								 {
									 if(clinic_code1.equals(rset.getString(1)))
										out.println("<option value='"+rset.getString(1)+"' selected>");	
									else
				                        out.println("<option value='"+rset.getString(1)+"'>");	     
										out.println(rset.getString(2));
										out.println("</option>"); 
								 }
								 if(pstmt!=null) pstmt.close();
								 if(rset!=null) rset.close();
%>
							</select>
				   		    <img src='../../eCommon/images/mandatory.gif' ></img>
						</td> 	
				    </tr>	
					<tr><td colspan='2' ></td></tr>
<tr>
		  <td class='label'  width='50%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></td>
		  <td class='field'  width='50%'><input type='text' name='bay_no' id='bay_no' value='<%=bay_no1%>' maxLength='8' size='8'
		  onBlur='ChangeUpperCase(this);' onKeyPress="return CheckForSpecChars(event);"<%=readonly%> <%=modifymode%>>
		  <img src='../../eCommon/images/mandatory.gif' ></img>
		  </td>
</tr>

                   
<tr><td colspan='2'></td></tr>

<tr>
              <td class='label'  width='50%'><fmt:message key="eAE.BedBayType.label" bundle="${ae_labels}"/></td>
              <td  class='field' width='50%'>
			<%
			if(eff_status.equals("D"))
			{
			%>
				<input type='text' name='bay_type_desc' id='bay_type_desc' value='<%=bay_type_desc%>' maxLength='15' size='15'readonly><img src='../../eCommon/images/mandatory.gif' ></img> 
				<input type='hidden' name='bay_type' id='bay_type' value='<%=bay_type_code%>' >
			<%
			}
			else
			{
			%>			
			
			<select name='bay_type' id='bay_type' >
               <option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
<%

	String sqlBayType="select bay_type_code,short_desc from ae_bay_type where eff_status='E' ORDER BY 2";
	pstmt		=	con.prepareStatement(sqlBayType);
    rset			=	pstmt.executeQuery();
		while(rset!=null && rset.next())
		 {
			 if(bay_type_code.equals(rset.getString(1)))
				out.println("<option value='"+rset.getString(1)+"' selected>");	
			else
				out.println("<option value='"+rset.getString(1)+"'>");	     
				out.println(rset.getString(2));
				out.println("</option>"); 
		 }
		 if(pstmt!=null) pstmt.close();
		 if(rset!=null) rset.close();
%>
	</select>
    <img src='../../eCommon/images/mandatory.gif' ></img>
<%
	}
%>
</td>
</tr>
<tr><td colspan='2'></td></tr>
                
                   <tr>
						<td class='label'  width='50%'><fmt:message key="eAE.PseudoBedBay.label" bundle="${ae_labels}"/></td>
			    	    <td class='field'  width='50%'>
					<%
					   String disable="";
					  if(eff_status.equals("D")&&mode.equals("MODIFY"))
			              disable ="disabled";
                        else 
						   disable="";
				   %>
				   <input type='checkbox' name='spare_bay1' id='spare_bay1' value='<%=sparebayval%>' <%=checkBoxAttribute1%> <%=disable%> onClick='chkValue(this);'>
                   <input type='hidden' name='spare_bay' id='spare_bay' value='<%=sparebayval%>'>
				   
			   </td>
			        </tr>
					<tr><td colspan='2'></td>
					</tr>

			        <tr>
						<td class='label'  width='50%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			    	    <td class='field'  width='50%'><input type='checkbox' name='eff_status' id='eff_status' value="E" <%=checkBoxAttribute%>  onClick='chkValue(this);'>
						</td>
			        </tr>
					<tr><td colspan='2' height='5'></td></tr>
			 </table> 
			     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >
				 <input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>">

				 <!--Added by Ashwini on 30-Mar-2018 for PMG2018-COMN-CRF-0001-->
				 <input type='hidden' name='bed_occupied_status' id='bed_occupied_status' value="<%=isBedOccupied%>">
		 </form>
	  </body>
<%
		if(rset!=null) rset.close(); 
		if(pstmt!=null) pstmt.close();
	    Arr_Of_HashMap.clear();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
    {
    	if(con != null)
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

