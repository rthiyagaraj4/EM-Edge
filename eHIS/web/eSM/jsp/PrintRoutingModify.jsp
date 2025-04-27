<!DOCTYPE html>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>
<%@ page  import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
    request.setCharacterEncoding("UTF-8");
	String module_id=request.getParameter("module_id");
	String report_id=request.getParameter("report_id");
	String srl_no=request.getParameter("srl_no");
	

	

	String codedesc = "";
	String size="6";
	String sdate ="";
	String report_class="";

	Connection con=null;
	try{
	con = ConnectionManager.getConnection(request);
	Statement stmt=null ;
	ResultSet rs=null ;
	ResultSet rset=null;
	Statement stmt2=null;
	
	stmt = con.createStatement();

	//String ddesc[] = {"Location","Clinic","Nursing Unit","Pharmacy","Store"};
	//String dcode[] = {"L","C","N","P","S"};

	String sysdate="Select to_char(sysdate,'dd/mm/rrrr') from dual ";
	ResultSet rsdate=stmt.executeQuery(sysdate);
	while (rsdate.next())
		{
	      sdate=rsdate.getString(1);
		}
	if( rsdate != null) rsdate.close();
	String sql="select a.*, b.printer_name printer_name1, c.printer_name printer_name2,d.printer_name printer_name3,to_char(from_time1,'hh24:mi')from_1time,to_char(from_time2,'hh24:mi')from_2time,to_char(from_time3,'hh24:mi')from_3time,to_char(from_time1,'dd/mm/yyyy hh24:mi')from_timeinsert1,to_char(from_time2,'dd/mm/yyyy hh24:mi')from_timeinsert2,to_char(from_time3,'dd/mm/yyyy hh24:mi')from_timeinsert3 from sm_print_routing_vw a,sm_printer b,sm_printer c,sm_printer d where  a.printer_id1= b.printer_id (+)  and  a.printer_id2= c.printer_id (+)  "+" and a.printer_id3=d.printer_id (+) and  module_id='"+module_id+"'"+"and report_id='"+report_id+"'" + "and srl_no='"+srl_no+"'";
	

	rset = stmt.executeQuery(sql);
	rset.next();

	//String printer_id1 = rset.getString("printer_id1")==null?"":rset.getString("printer_id1");
	String printer_id1desc = rset.getString("printer_name1")==null?"":rset.getString("printer_name1");
	String printer_id2 = rset.getString("printer_id2")==null?"":rset.getString("printer_id2");
	String printer_id2desc = rset.getString("printer_name2")==null?"":rset.getString("printer_name2");
	String printer_id3 = rset.getString("printer_id3")==null?"":rset.getString("printer_id3"); 
	String printer_id3desc = rset.getString("printer_name3")==null?"":rset.getString("printer_name3");
			
	String printerId=rset.getString("printer_id1");
	String facilityname=rset.getString("facility_name");
	if(facilityname == null  || facilityname.equals(""))
		facilityname="";
	
	String code=rset.getString("dest_locn_code") ;
	
	String from_1time = rset.getString("from_1time")==null?"": rset.getString("from_1time");
	String from_2time = rset.getString("from_2time")==null?"": rset.getString("from_2time");
	String from_3time = rset.getString("from_3time")==null?"": rset.getString("from_3time");
	String from_timeinsert1 = rset.getString("from_timeinsert1");
	String from_timeinsert2 = rset.getString("from_timeinsert2")==null?"": rset.getString("from_timeinsert2");
	String from_timeinsert3 = rset.getString("from_timeinsert3")==null?"": rset.getString("from_timeinsert3");
	String desttypedesc = rset.getString("dest_locn_type_desc")==null?"": rset.getString("dest_locn_type_desc");
	if(code == null || code.equals(""))
		code="";
	

			try{
		%>

			<html>
			<head>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
            <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
			<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
			<script src="../../eCommon/js/common.js" language="javascript"></script>
			<script src="../../eSM/js/PrintRouting.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
			</head>

			<body OnMouseDown="CodeArrest()"   onLoad='initialLoad();FocusFirstElement()' onKeyDown = 'lockKey()'>
			<form name="printrouting_form" id="printrouting_form" action="../../servlet/eSM.PrintRoutingServlet" method="post" target="messageFrame">
			<table border="0" cellpadding="0" cellspacing="0" width="95%" align='center'>
				<tr>
					<td width='20%'>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
				
					<td colspan='2' class='fields'><input type='text' name='module_name' id='module_name' size='30' maxlength='30' value='<%=rset.getString("module_name")%>' readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
					<input type='hidden' name='module_id' id='module_id'  value='<%=rset.getString("module_id")%>' >
				
				</tr> 
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
				
					<td nowrap colspan='2' class='fields'><input type='text' name='report_name' id='report_name' size='60' maxlength='60' value='<%=rset.getString("REPORT_DESC")%>' readonly><input type='hidden' name='report_id' id='report_id' size='60' maxlength='60' value='<%=rset.getString("REPORT_ID")%>' ><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			
				</tr> 
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
						<td nowrap class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					
				<td nowrap colspan='2' class='fields'><!--width='77%'-->
				<%	
					out.println("<input type='text' name='facility_id1' id='facility_id1' size='70' maxlength='35' value='");
					if(rset.getString("facility_id")==null || rset.getString("facility_id").equals("null") ||rset.getString("facility_id").equals("") )
						out.println(" ' readonly>");
					else
						
						out.print(facilityname+"' readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img> " );
						
					String fid = rset.getString("facility_id");
					%>
					<input type='hidden' name='facility_id' id='facility_id'  value='<%=fid%>'>
					</td>
					
					</tr> 
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					
					
				<tr>
					  <td class="label"><!--width="23%"--><fmt:message key="Common.Destination.label" bundle="${common_labels}"/></td>
				
				 		   
				 <td nowrap class='fields' colspan='2'><input type='text'  name='dest_locn_type1' id='dest_locn_type1'  value ='<%=desttypedesc%>' readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>	    	 
				<input type='hidden' name='dest_locn_type' id='dest_locn_type'  value='<%=rset.getString("dest_locn_type")%>'>
			 <%
					 if(code== null || code.equals("null"))
						 codedesc ="";
					 else  if(rset.getString("dest_locn_type").equals("L")){
						 codedesc=rset.getString("dest_locn_code")==null?"":rset.getString("dest_locn_code");
					 }
					 else{
						codedesc=rset.getString("dest_locn_desc")==null?"":rset.getString("dest_locn_desc");
						size="15";
					 }%>
			
				 <!--<td nowrap class='fields'> width='67%'-->&nbsp;<input type='text'  name='dest_locn_code1' id='dest_locn_code1' size='<%=size%>' maxlength='<%=size%>' value ='<%=codedesc%>' readonly><input type='hidden'  name='dest_locn_code' id='dest_locn_code' size='<%=size%>' maxlength='<%=size%>' value ='<%=code%>' readonly>
				</td></tr> 
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td nowrap class="label"><fmt:message key="Common.workstation.label" bundle="${common_labels}"/></td>
				<%
					out.println("<td nowrap colspan='2' class='fields'><!--width='77%'--><input type='text' name='ws_no' id='ws_no' size='32' maxlength='30'  value='");		
					if(rset.getString("ws_no")==null || rset.getString("ws_no").equals("null") ||rset.getString("ws_no").equals("") )
							out.println(" ' readonly>");
						else
						out.println(rset.getString("ws_no")+"' readonly>" );%>
				</td>
				
				</tr> 	
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr> 
				
				
				<tr>
					<td nowrap class="label"><!--width="23%"--><fmt:message key="eSM.DefaultReportMode.label" bundle="${sm_labels}"/>
</td>
						<td colspan="2" class='fields'><!--width="77%"--><select disabled name="dflt_report_mode" id="dflt_report_mode"  >
			 <%
							String dfltrptmode = rset.getString( "dflt_report_mode" ) ;	
							if ( dfltrptmode.equals("B") )
							{%>
								<option value='B' selected><fmt:message key="eSM.Bitmap.label" bundle="${sm_labels}"/>
								<option value='C' ><fmt:message key="eSM.Character.label" bundle="${sm_labels}"/>
							<%}	
							else
							{%>
								<option value='C' selected><fmt:message key="eSM.Character.label" bundle="${sm_labels}"/>
								<option value='B' ><fmt:message key="eSM.Bitmap.label" bundle="${sm_labels}"/>
							<%}
			 %>
					</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
					  </td>
				 </tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td nowrap class="label"><!--width="23%"--><fmt:message key="eSM.NumberofCopies.label" bundle="${sm_labels}"/></td>
			
					<td nowrap colspan='2' class='fields'><!--width='77%'--><input type='text' name='no_of_copies' id='no_of_copies' size='2' maxlength='2' value='<%=rset.getInt("no_of_copies")%>'onBlur='CheckPositiveNumber1(this)'  onKeyPress='return ChkNumberInput1(this,event)'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				
				</tr> 
			 <tr>
				<td colspan=3>&nbsp;</td>
			  </tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="95%" align='center'>
			<tr class="black" width="100">
					<td class='columnheader' colspan='4'><fmt:message key="eSM.PrinterDetails.label" bundle="${sm_labels}"/></td>		
			</tr>
			<tr>
				<td colspan=4>&nbsp;</td>
			  </tr>
				<%
				if(rset!=null)rset.close();
	           if(stmt!=null)stmt.close();	
				  stmt = con.createStatement();
					 sql= "select report_class from sm_report where module_id='" + module_id + "'and report_id='"+ report_id +"'";
					 rs = stmt.executeQuery(sql);
					if(rs.next())
				{	
				report_class=rs.getString("report_class")==null?"":rs.getString("report_class");
				
				}
				if(stmt!=null)stmt.close();
				if(rs!=null)rs.close();
				
				%>
						
				
				<tr>
					<td nowrap class="label" width='20%'><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>1</td>
						<td nowrap class='fields'><INPUT TYPE="text" name="printer_id1desc" id="printer_id1desc"  value="<%=printer_id1desc%>" onblur='selectPrinter1(printer_id1desc,printer_id);disableTime1(this);'   value='' size=60><input type='button' class='button' value='?'  name='printer1' id='printer1' onClick='selectPrinter(printer_id1desc,printer_id);' >
         	 <!-- <select name="printer_id" id="printer_id" onChange='disableTime1(this)'>
 	       	<option value="">-------------------------- Select ---------------------------
 	 	 </select> -->
 	    	<INPUT TYPE="hidden" value="<%=report_class%>"  name='reportclass' id='reportclass'>
			
			<INPUT TYPE="hidden" value="<%=printerId%>"  name='printer_id' id='printer_id'><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
				<td class='label'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="from_time" id="from_time" size="5" value='<%=from_1time%>' onBlur='CheckTime(this)'    maxlength="5" ></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>2</td>
					<td nowrap class='fields'><INPUT TYPE="text" name="printer_id2desc" id="printer_id2desc"  value="<%=printer_id2desc%>" onblur='selectPrinter1(printer_id2desc,printer_id2);disableTime2(this);'   value='' size=60><input type='button' class='button' value='?'  name='printer2' id='printer2' onClick='selectPrinter(printer_id2desc,printer_id2);' >
					</td>
					<td class='label'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="text" name="from_2time" id="from_2time" size="5" value='<%=from_2time%>'   onBlur='CheckTime(this);'  maxlength="5" ></td>
					<INPUT TYPE="hidden" value="<%=printer_id2%>"  name='printer_id2' id='printer_id2'>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>3</td>
					<td nowrap class='fields'><INPUT TYPE="text" name="printer_id3desc" id="printer_id3desc"  value="<%=printer_id3desc%>" onblur='selectPrinter1(printer_id3desc,printer_id3);disableTime3(this)'   value='' size=60><input type='button' class='button' value='?'  name='printer3' id='printer3' onClick='selectPrinter(printer_id3desc,printer_id3);' >
					<INPUT TYPE="hidden" value="<%=printer_id3%>"  name='printer_id3' id='printer_id3'></td>
					<td class='label'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="text" name="from_3time" id="from_3time" size="5"  onBlur='CheckTime(this)'  value='<%=from_3time%>' maxlength="5" ></td>
				
				</tr>

			  </table>

			<input type='hidden' name='srl_no' id='srl_no'  value='<%=srl_no%>'>
			<input type="hidden" name="function" id="function" value="modify">
			<input type="hidden" name="eff_date_from" id="eff_date_from" >
			<input type="hidden" name="eff_date_to" id="eff_date_to" >
			<input type="hidden" name="sys" id="sys" value="<%=sdate%>">
			<input type='hidden' name='function_name' id='function_name' value='modify'>
			<input type="hidden" name="function1" id="function1" value="modify">
			<input type="hidden" name="from_timeinsert1" id="from_timeinsert1" value='<%=from_timeinsert1%>' >
			<input type="hidden" name="from_timeinsert2" id="from_timeinsert2" value='<%=from_timeinsert2%>' >
			<input type="hidden" name="from_timeinsert3" id="from_timeinsert3" value='<%=from_timeinsert3%>'>
			<input type="hidden" name="from_time1" id="from_time1" >
			<input type="hidden" name="from_time2" id="from_time2" >
			<input type="hidden" name="from_time3" id="from_time3" >

			</form>

			<%
				if(rset!=null)rset.close();
				if(rs!=null)rs.close();
				if(stmt2!=null)stmt2.close();
				
				if(stmt!=null)stmt.close();

				}
	catch(Exception  ce){out.print(ce+"here");}
	
	}catch(Exception e){out.println(e);}
finally { 

	ConnectionManager.returnConnection(con,request);
}
%>

</body>
</html>

<script>

async function selectPrinter1(desc,code)
{
	if(desc.value == "")
	{desc.value="";
	 code.value="";
	  	if(desc.name=="printer_id1desc")
			 {
				disableTime1(desc)
			 
			 }else if(desc.name=="printer_id2desc")
			 {
			 disableTime2(desc)
			 }else if(desc.name=="printer_id3desc")
			 {
			 disableTime3(desc)
			 }
	  return ;
	}		
await selectPrinter(desc,code)
}
	async function selectPrinter(desc,code)
	{
			tar=desc.value
				
		
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel("eSM.Printers.label","SM");	
		var reportclass=document.forms[0].reportclass.value
			
			sql="Select printer_id code,printer_name description from sm_printer where eff_status='E' and upper(printer_id) like upper(?) and upper(printer_name) like upper(?) order by 2";
	

		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = tar;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		  {
			
		   // var ret1=unescape(retVal);
			//arr=ret1.split(",");
			//desc.value=arr[1];
			//code.value=arr[0];
			var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			desc.value=arr[1];
			code.value=arr[0]
			//desc.focus();
				if(desc.name=="printer_id1desc")
			 {
				disableTime1(desc)
			 
			 }else if(desc.name=="printer_id2desc")
			 {
			 disableTime2(desc)
			 }else if(desc.name=="printer_id3desc")
			 {
			 disableTime3(desc)
			 }
			
			}else
		{
		desc.value="";
		code.value="";
		}
	}			
			
			function CheckPositiveNumber1(obj)
					{	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {		
				}
				else {
					if ( obj.value.length > 0 ) {
						alert(getMessage('COPY_GR_ZERO','SM'));
						obj.select();
						obj.focus();
					}
				}
			}

			function ChkNumberInput1(fld, e)
			{
			   var strCheck = '0123456789';
				var whichCode = (window.Event) ? e.which : e.keyCode;
				if (whichCode == 13) return true;  // Enter
				key = String.fromCharCode(whichCode);  // Get key value from key code
				if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
			}



			 function CheckTime(obj) 
			 {
				  if (obj.value.length > 0 )
				 {
					if(ValidateTime(obj)==false) 
					{
						alert(getMessage('INVALID_TIME_FMT','SM'));
						obj.value=''
						obj.select();
						obj.readOnly=false;

						obj.focus();
					}
				 }
			}
			function ValidateTime(obj)
			{
				time = obj.value
				if (time.indexOf(":") > -1) {
				if  (time.length<5) return false;
				var a=  time.split(":")
				splithrs=a[0];
				splitmin=a[1]
				
				if (splithrs >23 || splithrs <0) 
					{
						alert(getMessage('HR_LESS_TWENTYFOUR','SM'));
						obj.select();
						obj.focus();
					}
				if (splitmin >59 || splitmin <0) 
					{
						alert(getMessage('MI_LESS_SIXTY','SM'));
						obj.select();
						obj.focus();
					}
				} else return false;
				return true
			}
		

			function disableTime1(obj){
				var fieldval = obj.value;
				if(fieldval != '')
				{   
					document.forms[0].printer_id2desc.disabled = false;
					document.forms[0].from_time.readOnly = false;
					document.forms[0].from_time.value = "";
					document.forms[0].printer_id2.disabled = false;
					document.forms[0].printer_id3.value = "";
					document.forms[0].printer_id3desc.disabled = true;
					document.forms[0].from_time3.readonly= true;
				    document.forms[0].printer2.disabled = false;
				}
				else
				{	document.forms[0].printer_id2desc.value="";
				    document.forms[0].printer_id3desc.value="";
					document.forms[0].from_time.value='';
					document.forms[0].from_time.readOnly=true;
					document.forms[0].from_2time.value='';
					document.forms[0].printer_id2.value='';
					document.forms[0].from_3time.value='';
					document.forms[0].from_3time.readonly=true;
					document.forms[0].printer_id3.value='';
					document.forms[0].printer_id3.disabled=true;
					document.forms[0].from_2time.readOnly = true;
					document.forms[0].printer_id2.disabled = true;
				    document.forms[0].printer_id2desc.disabled = true;
					document.forms[0].printer2.disabled = true;
					document.forms[0].printer3.disabled = true;
				}
			}


			function disableTime2(obj){
				var fieldval = obj.value;
				
				if(fieldval != '')
				{
					document.forms[0].from_2time.readOnly = false;
					document.forms[0].from_2time.value = "";
					document.forms[0].from_3time.readOnly = false;
					//document.forms[0].printer_id3.disabled = false;
					document.forms[0].printer_id3desc.disabled = false;
					document.getElementById("printer3").disabled=false;
				}
				else
				{	document.forms[0].printer_id3desc.value="";
					document.forms[0].from_2time.value='';
					document.forms[0].from_3time.value='';
					document.forms[0].printer_id3.value='';
					document.forms[0].from_2time.readOnly = true;
			
					document.forms[0].from_3time.readOnly = true;
					document.forms[0].printer_id3desc.disabled = true;
					document.getElementById("printer3").disabled=true;
				}
			}

			function disableTime3(obj){
				if(obj.value != '')
				{
					document.forms[0].from_3time.readOnly = false;
			
				}
				else
				{
					document.forms[0].from_3time.value='';
					document.forms[0].from_2time.readOnly = true;
					document.forms[0].from_3time.readOnly = true;
				}
			}

			function initialLoad()
			{
				if(document.forms[0].printer_id.value!="")
				{
					document.forms[0].printer_id2desc.disabled = false;
					document.forms[0].printer2.disabled = false;
				}
				else
				{
					document.forms[0].printer_id2desc.disabled = true;
					document.forms[0].printer3.disabled = true;
				}
				if(document.forms[0].printer_id2.value!="")
				{
					document.forms[0].printer_id3desc.disabled = false;
					document.forms[0].printer3.disabled = false;
					}
				else
				{
					document.forms[0].printer_id3desc.disabled = true;
					document.forms[0].printer3.disabled = true;
				}
			}
		
			</script>

