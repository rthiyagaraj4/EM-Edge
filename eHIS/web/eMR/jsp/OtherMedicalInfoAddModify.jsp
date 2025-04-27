<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>

      
	  <head>
	    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
     	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script src='../../eMR/js/CreatePatientFile.js' language='javascript'></script>

      	<script>
		function cancelthis()
		{
			parent.parent.frames[1].document.location.href='../../eMR/jsp/mrblank.jsp?step_1=9';
			parent.parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp';
		}

		function splCharCheck(obj,event)
		{
			
			var refval=obj.value;	
			var strCheck = '0123456789abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
			for(var i=0;i<=refval.length;i++)
			{
				var key1= refval.charAt(i);
				if (strCheck.indexOf(key1) == -1) 
				{
					alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
					obj.value='';
					obj.select();
					//obj.focus();
					break ;
				}
			}
		} 

	</script>

      </head>

      <body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onKeyDown = 'lockKey()'>
		

<%
   Connection conn=null;
   Statement stmt=null;
   ResultSet rset=null;
   PreparedStatement pstmt=null;

  String mode="";

	try{
			  String locale = (String)session.getAttribute("LOCALE"); 
			  request.setCharacterEncoding("UTF-8");
			  request= new XSSRequestWrapper(request);
			  response.addHeader("X-XSS-Protection", "1; mode=block");
			  response.addHeader("X-Content-Type-Options", "nosniff");
			  String PatId=request.getParameter("Patient_Id");
			  conn=ConnectionManager.getConnection(request);
			  String  ref_no=request.getParameter("ref_no");
			  String  ref_date=request.getParameter("ref_date");
			  if(ref_date==null) ref_date="";

			  String ref_date_converted="";
			  String category="O";
			  String remarks="";

			  String dob="";
			  String dis_code="";
			  String dis_confirmed="";
			  String sel="";
			  String cur_date="";

			   	String sql_dob="Select to_char(sysdate,'dd/mm/yyyy') cur_date, to_char(date_of_birth,'dd/mm/yyyy') dob from mp_patient where patient_id='"+PatId+"' ";
				Statement stmt_dob=conn.createStatement();
				ResultSet rs_dob=stmt_dob.executeQuery(sql_dob);
				if(rs_dob!=null)
				{
					while(rs_dob.next())
					{
						cur_date=rs_dob.getString("cur_date");
						dob=rs_dob.getString("dob");
					}
				}
				if(stmt_dob!=null) stmt_dob.close();
				if(rs_dob!=null) rs_dob.close();

			  if(ref_no==null)
			  {
				  ref_no="";
				  mode="insert";
			  }
			  else
			  {
					mode="modify";
					String count="";
					int numOfRecord;
					
					String sql = "select to_char(ref_date,'dd/mm/yyyy') ref_date1, category, remarks from mr_pat_other_med_info  where patient_id='"+PatId+"' and  ref_no= '"+ref_no+"' ";
					
					if(rset!=null)    	rset.close();
					if(pstmt!=null)   	stmt.close();
					
					pstmt=conn.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					rset = pstmt.executeQuery();
					
				if(rset!=null)
				{
					rset.last();
					numOfRecord=rset.getRow();
					rset.beforeFirst();
					count=Integer.toString(numOfRecord);
				}

				if (count.equals("0"))
				{
					mode = "insert";
				}
				else
				{
					mode = "modify";

					if(rset!=null)
					{
						while(rset.next())
						{
							ref_date=rset.getString("ref_date1");
								if(ref_date==null) ref_date="";
							category=rset.getString("category");
								if(category==null) category="";
							remarks=rset.getString("remarks");
								if(remarks==null) remarks="";
						}
					}
				}


	 }
	 
	if(mode.equals("modify"))
		dis_code="disabled";


	if(!(ref_date==null || ref_date.equals("")))
		ref_date_converted = DateUtils.convertDate(ref_date,"DMY","en",locale);
%>

      	<form name='OtherInfoAddModify' id='OtherInfoAddModify' method='post' action='../../servlet/eMR.OtherMedicalInfoServlet' target='messageFrame'>
      	<div align='left'>
      	<table border=0 cellspacing=0 cellpadding='3' align=center width='100%'>
		<tr>
			<td colspan='4' class='label'>&nbsp;</td>
		</tr>
      	<tr>
      		<td width='25%' class=label>&nbsp;</td>
      		<td width='25%' class=label ><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></td>
	<td width='25%' class='fields'><input type="text" name="ref_no" id="ref_no"  value="<%=ref_no%>" <%=dis_code%> size=10 maxlength=10  onblur="splCharCheck(this,event);"><img src="../../eCommon/images/mandatory.gif"></td>
			<td width='25%' class=label>&nbsp;</td>
      	</tr>
      	<tr>
			<td class=label>&nbsp;</td>
      		<td class=label ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
      		<td class='fields'><input type="text" name="ref_date" id="ref_date"  value="<%=ref_date_converted%>" size=10 maxlength=10 onblur='CheckRefDate(this)' <%=dis_confirmed%>><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].ref_date.select();return showCalendar('ref_date',null)" <%=dis_confirmed%> /><img src="../../eCommon/images/mandatory.gif"></td>
			<td class=label>&nbsp;</td>
      	</tr>
      	<tr>
			<td class=label>&nbsp;</td>
      		<td class=label ><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
      		<td class='fields'> <select name="category" id="category" <%=dis_confirmed%>>
				<option value='O' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
				<option value='R' ><fmt:message key="Common.report.label" bundle="${common_labels}"/></option>
				<option value='C' ><fmt:message key="eMR.Correspondence.label" bundle="${mr_labels}"/></option>
				<option value='A' <%=sel%>><fmt:message key="Common.adhoc.label" bundle="${common_labels}"/></option>
				</select><img src="../../eCommon/images/mandatory.gif"></td>
				<script>document.forms[0].category.value='<%=category%>' ;</script>
			<td class=label>&nbsp;</td>
       	</tr>
      	<tr>
			<td class=label>&nbsp;</td>
      		<td class=label ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
      		<td class='fields'><textarea name="remarks" style="resize:none;" rows="3" cols="30" onkeyPress='checkMaxLimit(this,2000);' onBlur='chkMax(this);makeValidString(this)'  <%=dis_confirmed%>><%=remarks%></textarea><img src="../../eCommon/images/mandatory.gif"></td>
			<td class=label>&nbsp;</td>
      	</tr>
      	<tr>
				<td class=label colspan='2'>&nbsp;</td>
				<td class=button><input type="button" class=button name="Record" id="Record" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onclick="apply1()"><input type="button" class=button name="Clear" id="Clear" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onclick="clearme1()"><input type="button" class=button name=Cancel id=Cancel value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onclick="cancelthis()"></td>
				<td class=label>&nbsp;</td>

		</tr>
		<tr>
			<td class='label' colspan='4'>&nbsp;</td>
		</tr>
      	</table>
		<input type=hidden name=mode value='<%=mode%>'>
		<input type='hidden' name='cur_date' id='cur_date' value='<%=cur_date%>' >
		<input type='hidden' name='patient_id' id='patient_id' value='<%=PatId%>' >
		<input type='hidden' name='dob' id='dob' value='<%=dob%>' >
		<input type='hidden' name='ref_no1' id='ref_no1' value='<%=ref_no%>' >

		</div>
      	</form>
      	</body>
      	</html>
<%

		}catch(Exception e){
			e.toString();
	     }
	     finally{
			 try
			 {
	     	if(rset!=null)    	rset.close();
			if(stmt!=null)   	stmt.close();
			if(pstmt!=null)   	pstmt.close();
			 }

			 catch(Exception e){
	     }

			ConnectionManager.returnConnection(conn,request);
	     }

%>

