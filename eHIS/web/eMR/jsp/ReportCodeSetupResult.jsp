<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page language="java" import="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eMR/js/ReportCodeSetup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

/////////////////////
async function getLevelGroupId(obj)
    {
		
		var name=(obj.name);
		//sub_group
		var str=name.substring(9,name.length);
	
		var Report_id=parent.frames[0].document.forms[0].Report_id.value;
		var type=parent.frames[0].document.forms[0].type.value
		var target= eval("document.forms[0].group_name"+str);
		var retVal	=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10vh" ;
		var dialogWidth			= "40vw" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var search_code=""; 
		var title=getLabel("Common.Group.label","Common")+' '+getLabel("Common.description.label","Common");
		var sql ="select group_desc,group_code from mr_report_grouping where report_id=`"+Report_id+"` and  mast_table_name_reference =`"+type+"`";
		search_code="group_code";
		search_desc="group_desc";
	    retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title)+"&dispDescFirst=dispDescFirst",arguments,features);
	   
	    var arr=new Array();
		
	    if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split("::");
			
		    var ass1= eval("document.forms[0].Group_id"+str);
			
			ass1.value=arr[0];
			
			var ass2= eval("document.forms[0].group_name"+str);
			
			ass2.value=arr[1];
			

			ass2.focus();
			
		}
	}
//////////////////////
function allowPositiveNumber() 
	{
		var key = window.event.keyCode;// allows only numbers to be entered
		if((key<48 )||(key>58)) 
			{
				return false;
			}
	}

	function chkDup(obj)
	{
		
		var count=document.forms[0].maxrecord.value;
		var obj_temp='';
		var val= obj.value;
       
		var flag=false;
		var i=0;
		for(var ind  = 1; ind <count;ind++)
		{
			if(obj.name =="serial_no"+ind+"")
			{
				
				 obj_temp = document.report_form_result["Group_id" + ind];
				
				//var group_val=obj_temp.value;
			}
		}

		//var dup=val;
		for(var ind  = 1; ind <count;ind++)
		{
		if(obj.name !="serial_no"+ind+"" && eval("document.report_form_result.serial_no"+ind+".value")!='')
		{
			
			/*if(obj.name =="serial_no"+ind+"")
			{
				//ert(ind);
				var obj_temp=eval("document.report_form_result.Group_id"+ind+"");
				//ert(obj_temp.value);
				//if(obj_temp != eval("document.report_form_result.Group_id"+ind+"
			}*/
			document.forms[0].status_value.value='Y';
			var num=eval("document.report_form_result.serial_no"+ind+".value")
			
			//obj.name= document.report_form_result.serial_no"+ind+" 
			if(val==num )
			{	
				var obj_temp1=eval("document.report_form_result.Group_id"+ind+"");
				if(obj_temp.value == obj_temp1.value)
				flag=true;
				else
				flag=false;
			}
			else
			{
				flag=false;
			}		
			
			if(flag==true)
			{
                var errors = getMessage('DUPLI_SRL_NO','MR');
				alert(errors);
				// alert("Duplicate Order Serial Nos are not allowed..");
				
				obj.focus();
				obj.select();
				i++;
				return false;
			}
		}		
	
		}
	}
</script>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null ;
	//ResultSet rset=null;
	int maxRecord=0;
	Statement stmt1=null;
	ResultSet rs1=null ;
			
	String Report_id=request.getParameter("Report_id");
	String type=request.getParameter("type");
	String sql="";
	
	int i=1;
	
    int slno=0;
	//int recordCount = 0;	
	try
	{
		con = ConnectionManager.getConnection(request);
		
		String sql1="Select max(ORDER_BY_SRL_NO) from MR_REPORT_MAPPING where REPORT_ID=? and MAST_TABLE_NAME_REFERENCE=? ";	
		pstmt=con.prepareStatement(sql1);
		pstmt.setString(1,Report_id);
		pstmt.setString(2,type);
		 rs=pstmt.executeQuery();
		if(rs.next())
		{
		slno=rs.getInt(1);
		slno=slno+1;
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		%>

		<%	
		 if(type.equals("SP"))
		{
			sql="select report_id,mast_table_name_reference, mast_code, short_desc, order_by_srl_no,Report_desc,GROUP_CODE  from mr_report_mapping,AM_SPECIALITY where report_id = '"+Report_id+"' and mast_table_name_reference = '"+type+"' and SPECIALITY_CODE = mast_code union select '"+Report_id+"' report_id , '"+type+"'  mast_table_name_reference, speciality_code mast_code,short_desc, 0,null Report_desc,null GROUP_CODE from AM_SPECIALITY where speciality_code not in (select mast_code from mr_report_mapping where report_id = '"+Report_id+"'  and mast_table_name_reference = '"+type+"') order by 3";
		}
		else if(type.equals("RC")){
         sql="select report_id, mast_table_name_reference, mast_code, short_desc,order_by_srl_no,Report_desc,GROUP_CODE  from mr_report_mapping,mp_race where report_id = '"+Report_id+"' and mast_table_name_reference = '"+type+"' AND MAST_CODE= RACE_CODE union select '"+Report_id+"' report_id , '"+type+"'  mast_table_name_reference, race_code mast_code,short_desc, 0,null Report_desc,null GROUP_CODE from mp_race where race_code not in (select mast_code from mr_report_mapping where report_id = '"+Report_id+"'  and mast_table_name_reference = '"+type+"')  order by 3";

		}else if(type.equals("DT")){
         sql=" select report_id, mast_table_name_reference, mast_code, short_desc, order_by_srl_no,Report_desc,GROUP_CODE  from mr_report_mapping,MP_NOD_TYPE where report_id = '"+Report_id+"' and mast_table_name_reference = '"+type+"' AND nod_type=MAST_CODE union select '"+Report_id+"' report_id , '"+type+"'  mast_table_name_reference, nod_type  mast_code,short_desc, 0,null Report_desc,null GROUP_CODE from MP_NOD_TYPE where nod_type not in (select mast_code from mr_report_mapping where report_id = '"+Report_id+"'  and mast_table_name_reference = '"+type+"')  order by 3";

		}else if(type.equals("HC")){
         sql="select report_id, mast_table_name_reference, mast_code, short_desc, order_by_srl_no,Report_desc,GROUP_CODE  from mr_report_mapping,AM_HCARE_SETTING_TYPE where report_id = '"+Report_id+"' and mast_table_name_reference='"+type+"' AND Hcare_setting_type_code= MAST_CODE union select '"+Report_id+"' report_id , '"+type+"'  mast_table_name_reference, Hcare_setting_type_code mast_code,short_desc, 0,null Report_desc,null GROUP_CODE from AM_HCARE_SETTING_TYPE where Hcare_setting_type_code not in (select mast_code from mr_report_mapping where report_id = '"+Report_id+"'  and mast_table_name_reference = '"+type+"') order by 3 ";

		}
		
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=stmt.executeQuery(sql);
		String classValue = "" ;
	
		if(rs != null)
		{
			rs.last();
			maxRecord = rs.getRow();
			rs.beforeFirst();

			if(maxRecord == 0)
		{%>	
			<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);
			</script>
		
		<%}}%>
	</head>
	<body  OnMouseDown="CodeArrest();"  class='CONTENT' onKeyDown = 'lockKey()'>
	<form name='report_form_result' id='report_form_result' action="../../servlet/eMR.ReportCodeSetup.java" method='post' target="messageFrame" >
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
	<tr>
		<td class="white">			
	<tr>
		<td>
			<table border='1' cellpadding='0' cellspacing='0' width="100%" align='center'>
				<tr>
					<th width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
					<th width='25%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			        <th width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
					<th width='25%'><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/></th>
					<th width='20%'><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
                     <th width='10%'><fmt:message key="Common.OrderSrlNo.label" bundle="${common_labels}"/></th>
				</tr>
				<%
				
				while (rs.next()) 
		{ 
		if ( i % 2 == 0 )
					 	classValue = "QRYEVEN" ;
					 else
					 	classValue = "QRYODD" ;%>
				<tr>
				<td align='left' width='10%' name='code<%=i%>' class='<%=classValue%>'>
				<%
				   String desc=rs.getString("short_desc")==null?"":rs.getString("short_desc");
					String code=rs.getString("mast_code")==null?"":rs.getString("mast_code");
					 String serial_no=rs.getString("order_by_srl_no")==null?"":rs.getString("order_by_srl_no");
			 String Report_desc=rs.getString("Report_desc")==null?"":rs.getString("Report_desc");
			  String group_code=rs.getString("GROUP_CODE")==null?"":rs.getString("GROUP_CODE");
			 			 String group_desc="";
				String group_code_val="";
					 if(serial_no.equals("0"))serial_no="";
					 %>					 
					 
					 <%=code%></td>	
						<td align='left' width='25%' name='desc<%=i%>'class='<%=classValue%>'>
						  <%=desc%></td>
						  <td align='center' width='10%' class='<%=classValue%>'>
						 <%if(!(serial_no.equals(""))){%>
						    <input type="checkbox" value="Y" onclick="chkDescription(this);" checked name="inc<%=i%>" id="inc<%=i%>">
						 </td>
						 <td align='left' width='25%' class='<%=classValue%>'>
						   <input type = text  size='25' maxLength='40' 
                        name ="report_desc<%=i%>"  value = "<%=Report_desc%>" ></td>
						<!--Adding group code----->
						<td width='25%' align='left' >
						<%
							sql ="Select group_desc,GROUP_CODE from mr_report_grouping Where report_id='"+Report_id+"' and   MAST_TABLE_NAME_REFERENCE ='"+type+"' order by group_desc";
			
							stmt1 = con.createStatement();
							rs1 = stmt1.executeQuery(sql);
							while(rs1.next())
							{
								group_desc = rs1.getString("group_desc");
								group_code_val	=rs1.getString("GROUP_CODE");
								if(group_code_val.equals(group_code)){%>
                                <input type="hidden" value="<%=group_code_val%>" name="Group_id<%=i%>">
						     <textarea rows=2  readonly cols=20  name="group_name<%=i%>"  ><%=group_desc%></textarea><input type="button" name="sub_group<%=i%>" id="sub_group<%=i%>" value="?" class="BUTTON" onClick="getLevelGroupId(this);"><%}}
							 if(rs1!=null) rs1.close();
							 if(stmt1!=null) stmt1.close();
						%>
							
							<!-- <input type="text" value="<%=group_desc%>" name="group_name<%=i%>"> -->
			            </td>
						<!--  endded here--------->
						 <td align='left' width='10%' class='<%=classValue%>'>
						     <input type = text size='2' maxLength='2' onkeypress="return allowPositiveNumber()"                name ="serial_no<%=i%>"  onBlur="checkVal(this);chkDup(this)" value = "<%=serial_no%>" >
						 </td>	
					<%}else{%>
							
							<input type="checkbox" value="N" onclick="chkDescription(this);" name="inc<%=i%>" id="inc<%=i%>">
						 </td>
						 <td align='left' width='25%' class='<%=classValue%>'>
						    <input type = text  disabled size='25' maxLength='40' 
                        name ="report_desc<%=i%>" >
						</td>
						<!--Adding group code----->
						<td width='25%' align='left' >
							<input type="hidden" value="" name="Group_id<%=i%>" id="Group_id<%=i%>" >
							 <textarea rows=2  readonly disabled cols=20  name="group_name<%=i%>"></textarea><input type="button" name="sub_group<%=i%>" id="sub_group<%=i%>" disabled value="?" class="BUTTON" onClick="getLevelGroupId(this);">
						</td>
						<!--  endded here--------->
						 <td align='left' width='10%' class='<%=classValue%>'>
						    <input type = text size='2' disabled maxLength='2' onkeypress="return allowPositiveNumber()"
                        name ="serial_no<%=i%>"  onBlur="checkVal(this);chkDup(this)" value = "<%=serial_no%>" >
						</td>	
				    <%}%>
							
						<input type='hidden' name='Rep_id' id='Rep_id' value='<%=Report_id%>'>
						<input type='hidden' name='code<%=i%>' id='code<%=i%>' value='<%=code%>'>
						<input type='hidden' name='type' id='type' value='<%=type%>'>
						<input type='hidden' name='status_value' id='status_value' value=''>
						<input type='hidden' name='grp_value' id='grp_value' value='<%=group_desc%>'>
  
						<% i++;
		}%>
			<input type='hidden'name="maxrecord" value="<%=i%>">
			</table>		
		</td>
		</tr>
		</table>
		
	</form>
</body>
</html>
		<%	 
		//if(stmt!=null)stmt.close();
		//if(rs!=null)rs.close();
	}
	  catch(Exception e){/* out.print(e); */ e.printStackTrace();}
	  finally
	  {
	  if(rs!=null)	rs.close();
	  if(stmt!=null)	stmt.close();
	   ConnectionManager.returnConnection(con,request);

	  }%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

