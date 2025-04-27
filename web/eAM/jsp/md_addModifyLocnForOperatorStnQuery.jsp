<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>


<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*" %>
<%
	Connection con = null;	
	Statement stmt=null;
	Statement stmt1=null;
	PreparedStatement pstmt = null;
	Statement stmt5=null;
	ResultSet rset=null ;
	ResultSet rset5=null ;
	
	Statement stmt2=null;
	ResultSet rset2=null ;

	String oprstn="";
	String loc="";
	String locid="";
	String fnval="insert";

	oprstn=request.getParameter("oper_stn_id");
	locid=request.getParameter("locn_code");
	loc=request.getParameter("loc");

	

	String uid="";
	Properties p=(Properties)session.getValue("jdbc");
	uid=(String)p.getProperty("login_user");

try
{
	con = ConnectionManager.getConnection(request);
	stmt1=con.createStatement();
	if(oprstn!=null )
	{
		oprstn=oprstn.trim();
		locid=locid.trim();
		fnval="modify";
		//String sql="select * from AM_LOCN_FOR_OPER_STN_VW where oper_stn_id='"+oprstn+"' and locn_code='"+locid+"' and care_locn_type='"+loc+"'";
		//rset=stmt1.executeQuery(sql);
		
		String sql="select * from AM_LOCN_FOR_OPER_STN_VW where oper_stn_id=? and locn_code=? and care_locn_type=?";
		pstmt   = con.prepareStatement(sql);
		pstmt.setString	(	1,	oprstn		);
		pstmt.setString	(	2,	locid		);
		pstmt.setString	(	3,	loc		);
		rset		 = pstmt.executeQuery();
	
		if(rset.next())
		{
			oprstn=rset.getString("oper_stn_id");

			locid=rset.getString("locn_code");
			
			loc =rset.getString("care_locn_type");

		
		}
	}
	
	if(rset!=null)rset.close();
	String sqlspl="SELECT SHORT_DESC, SPECIALITY_CODE FROM AM_SPECIALITY WHERE EFF_STATUS = 'E' order by SHORT_DESC";
	stmt2=con.createStatement();
	rset2=stmt2.executeQuery(sqlspl);

   String facilityid=(String)session.getValue("facility_id");
   String dispFacilityId= request.getParameter("facilityID");
//   out.println("dispFacilityId--->"+dispFacilityId);
 	if(dispFacilityId == null || dispFacilityId.equals("")) dispFacilityId=facilityid;
 	else
 	dispFacilityId = dispFacilityId.trim();
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/md_LocnForOperatorStation.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<script>
var sStyle='<%=sStyle%>';
function populateResult(){
	if(chkPractitionerList()){
		parent.frames[0].temp='';
		var operator_station=document.forms[0].oprstn.value;
		var location_type=document.forms[0].loctype.value;
		var speciality = document.forms[0].speciality.value;
		var facility = document.forms[0].facility.value;
		var search_by=document.forms[0].search_by.value;
		var search_txt=document.forms[0].search_txt.value;	 	parent.frames[1].location.href='../../eAM/jsp/md_addModifyLocnForOperatorStnResult.jsp?operator_station='+operator_station+'&location_type='+location_type+'&speciality='+speciality+'&facilityID='+facility+'&search_by='+search_by+'&search_txt='+search_txt;
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num?err_val=';						
	}	
}
function test_fun(){
}	
function fetchVals(form,current,sel){
	var name=current.name;
	var value=current.value; 
	if(name=="oprstn"){
		removeitems(form.loctype);
	}
	var oid=form.oprstn.value
	var lt=form.loctype.value
	var fid=form.facility.value;	
	parent.frames[1].location.href='../../eCommon/html/blank.html'
	var HTMLVal = "<HTML><HEAD>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'>";
	HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eAM/jsp/md_FetchValForLocnForOperator.jsp'>";
	HTMLVal = HTMLVal +"<input name='name' id='name' type='hidden' value= '"+name + "'><input name='value' id='value' type='hidden' value='"+value +"'>";
	HTMLVal = HTMLVal +"<input name='fid' id='fid' type='hidden' value='"+fid+"'>";
	HTMLVal = HTMLVal +"<input name='oprstn' id='oprstn'  type='hidden' value='"+oid+"'>";
	HTMLVal = HTMLVal +"<input name='loctype' id='loctype'  type='hidden' value='"+lt+"'>";
	HTMLVal = HTMLVal +"</form></BODY></HTML>";
	parent.parent.frames[2].document.write(HTMLVal);
	parent.parent.frames[2].document.form1.submit();
}
function removeitems(obj){
	var len=obj.length;
	var i=1;
	while(i<len){
		len=obj.length;
		obj.remove(i);
	}
}
function clearResult(){
parent.frames[1].location.href='../../eCommon/html/blank.html';
parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num?err_val=';
}				
function populateOperStn(Obj){
	if(Obj.value !=''){
	var HTMLVal = new String();
	HTMLVal = "<HTML><HEAD>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eAM/jsp/md_FetchValForLocnForOperator.jsp'> "+
				" <input name='name' id='name' type='hidden' value='fromFac'><input name='operating_facilityID' id='operating_facilityID' type='hidden' value='"+Obj.value+"'></form></BODY></HTML>";
		parent.parent.frames[2].document.write(HTMLVal);
		parent.parent.frames[2].document.dum_form.submit();
	}
	var n=document.forms[0].oprstn.options.length;
		for(var i=0;i<n;i++)
			document.forms[0].oprstn.remove("oprstn");
		var tp ="----------"+getLabel("Common.defaultSelect.label","Common")+"----------";
		var opt=document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		document.forms[0].oprstn.add(opt);
	
	var n2=document.forms[0].loctype.options.length;
		for(var i2=0;i2<n2;i2++)
			document.forms[0].loctype.remove("loctype");
		var tp2 ="----------"+getLabel("Common.defaultSelect.label","Common")+"----------";
		var opt2=document.createElement("OPTION");
		opt2.text=tp2;
		opt2.value="";
		document.forms[0].loctype.add(opt2);		
		parent.frames[1].location.href='../../eCommon/html/blank.html';	
}
function enable_txt(obj){
	if(obj.value!='00'){			
	  document.forms[0].search_txt.disabled=false;
	}else{
	  document.forms[0].search_txt.disabled=true;
	  document.forms[0].search_txt.value="";
	}
}
function CheckForSpecChars_local(event){
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*'";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}
</script>
</head>

<body  OnMouseDown="CodeArrest()" onLoad="Focusing('facility')" onKeyDown = 'lockKey()' >
<form name='location_form' id='location_form' action='../../servlet/eAM.LocnForOperStnServlet' method='post' target='messageFrame'>
		<table border='0' cellpadding='0' cellspacing='0' width='85%' align='center'>
					<tr>
					<td class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td nowrap class='fields'>&nbsp;<select name='facility' id='facility' onChange='populateOperStn(this)' >
					<option >--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
				       <%
	 				   
	                    
	                    String ID1="",dat1="",en1="";
						stmt=con.createStatement();
						rset=stmt.executeQuery("Select Facility_id,Facility_name Operating_facility_id from SM_FACILITY_FOR_USER_VW where appl_user_id = '"+uid+"' and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ");
						if(rset!=null)
						{
						   while(rset.next())
						   {
							dat1=rset.getString("Operating_facility_id");
							ID1=rset.getString("facility_id");
							if(ID1.equals(dispFacilityId))
								  en1="selected";
								else
								    en1="";

						out.println("<option value=\""+ID1+ "\" "+en1+">"+dat1+"</option>");
							
						   }
						  	 }
							
						   %>	</select>						
					&nbsp;<img src='../../eMP/images/mandatory.gif' align='center'></img>
					</td>
					<td nowrap>&nbsp;&nbsp;</td>
					<td nowrap>&nbsp;&nbsp;</td>
					</tr>
			<tr>
			    <td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
    				<tr>
    				     <td  nowrap class='label'><fmt:message key="Common.operatorstation.label" bundle="${common_labels}"/></td>
    				     <td class='fields'>&nbsp;<select name='oprstn' id='oprstn' onchange='fetchVals(this.form,this)'>
    				     <option value=''>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
						 <%							             
	                    String op_ID1="",op_dat1="";
						stmt5=con.createStatement();	
						//rset5=stmt.executeQuery("SELECT  oper_stn_id,short_desc  FROM  am_oper_stn WHERE  facility_id='"+dispFacilityId+"' "+" and EFF_STATUS='E'  ORDER BY short_desc ");
						
						if(pstmt!=null)	   		pstmt.close();
						
						String strStmt="SELECT  oper_stn_id,short_desc  FROM  am_oper_stn WHERE  facility_id=? and EFF_STATUS='E'  ORDER BY short_desc ";
						
						pstmt   = con.prepareStatement(strStmt);
						pstmt.setString	(	1,	dispFacilityId		);
						rset5		 = pstmt.executeQuery();
						
						if(rset5!=null)
						{
						   while(rset5.next())
						   {
							op_dat1=rset5.getString("oper_stn_id");
							op_ID1=rset5.getString("short_desc");
							
							out.println("<option value='"+op_dat1+ "' >"+op_ID1);
						   }
						  	 }
						   %>    				          
    				    		</select>&nbsp;<img src='../../eMP/images/mandatory.gif' align='center'></img>

	   				   </td>
    				  
    				     <td  nowrap class='label'>&nbsp;&nbsp;<fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
    				     <td class='fields' nowrap>&nbsp;<select name='loctype' id='loctype' onchange='clearResult()'>
    				     <option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
    				     </select>&nbsp;<img src='../../eMP/images/mandatory.gif' align='center'></img>
    				   </td>
    				</tr>
    				<tr>
    				        <td>&nbsp;</td>
    				        <td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
			       </tr>

			     <tr>
				     	<td  class='label'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				     	<td class='fields'>&nbsp;<select name='speciality' id='speciality' onchange='clearResult()'>
				     	<option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
					<%if(rset2!=null)
					{
					   while(rset2.next())
					   {
						String dat2=rset2.getString(1);
						String id1=rset2.getString(2);
							out.println("<option value='"+id1+ "' >"+dat2);
					   }
					}%>

				     	
				     	</select>&nbsp;
				     	</td>
				     	<td>&nbsp;</td>
				     	<td>&nbsp;</td>
				    </tr>

				<tr>
				<td colspan='4'>&nbsp;</td>
				</tr>

				<tr>
				
				<td class='label'  id = lab1 ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
				<td  colspan=2 class='fields' >
				
				&nbsp;<SELECT name="search_by" id="search_by" onChange="enable_txt(this)" >
				<option value="00">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<option value="01"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></option>
				<option value="02"><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></option>
				</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="search_txt" id="search_txt" onKeyPress='return CheckForSpecChars_local(event);'  disabled size=30 maxlength=30></td>

				<td colspan='1'>&nbsp;</td>
				</tr>
				    
				<tr>
					<td colspan='4' align='right'><input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='populateResult()'></td>
			    </tr>
<%
 }
catch(Exception e){
	e.printStackTrace();
	}
   finally{
	   try
	   {
	     	if(stmt!=null)	     	stmt.close();
			if(stmt1!=null)	   		stmt1.close();
			if(pstmt!=null)	   		pstmt.close();
			if(stmt5!=null)	   		stmt5.close();
			if(stmt2!=null)	   		stmt2.close();
	     	if(rset!=null)	     	rset.close();
			if(rset2!=null)         rset2.close();
			if(rset5!=null)         rset5.close();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	     	ConnectionManager.returnConnection(con,request);
	     }
%>
    				</table>
    			
		 <% if(fnval.equals("insert"))
		//	out.println("<script>populateOperStn(document.forms[0].facility)</script>");
		%>
		
		<input type='hidden' name='function' id='function' value='<%=fnval%>'>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
	</form>
</body>
</html>

