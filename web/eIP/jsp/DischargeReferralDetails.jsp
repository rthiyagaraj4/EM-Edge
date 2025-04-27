<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../js/DischargePatient.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>
        function enable_referred(obj)
                {
                       document.getElementById('td2').innerText= '';

                    if(document.forms[0].referred.checked == true)
                    {
                        document.forms[0].referral_type.disabled=false;
                        document.forms[0].referred_to.disabled=false;
                        document.forms[0].preferred_date.disabled=false;
                        document.forms[0].location0.disabled=false;
                        document.forms[0].location1.disabled=false;
                        document.forms[0].location2.disabled=false;
                        document.forms[0].practitioner.disabled=false;
                        document.forms[0].practitioner1.disabled=false;
                        
                        document.getElementById('id1').src="../../eCommon/images/mandatory.gif";                             
                        document.getElementById('id1').style.visibility='visible';           
                        document.getElementById('td1').innerText= '';

                        document.getElementById('id2').src="../../eCommon/images/mandatory.gif";                             
                        document.getElementById('id2').style.visibility='visible';  
                        document.getElementById('td2').innerText= '';

                        document.getElementById('id3').src="../../eCommon/images/mandatory.gif";                             
                        document.getElementById('id3').style.visibility='visible';  
                        document.getElementById('td3').innerText= '';
                        document.forms[0].ReferralNotes.disabled=false; 
	                }
                    else
                    {
                        document.forms[0].ReferralNotes.disabled=true; 

                        document.forms[0].referral_type.disabled=true;
                        document.forms[0].referred_to.disabled=true;
                        document.forms[0].preferred_date.disabled=true;
                        document.forms[0].location0.disabled=true;
                        document.forms[0].location1.disabled=true;
                        document.forms[0].location2.disabled=true;
                        document.forms[0].practitioner.disabled=true;
                        document.forms[0].practitioner1.disabled=true;

                        document.forms[0].referral_type.options(0).selected=true;
                        document.forms[0].referred_to.options(0).selected=true;
                        document.forms[0].preferred_date.value="";
                        document.forms[0].location0.options(0).selected=true;
                        document.forms[0].location1.options(0).selected=true;
                        document.forms[0].location2.value="";
                        document.forms[0].practitioner.options(0).selected=true;
                        document.forms[0].practitioner1.value="";
                        

						document.getElementById('id1').style.visibility='hidden';            
						document.getElementById('id2').style.visibility='hidden';            
						document.getElementById('id3').style.visibility='hidden';            
						document.getElementById('id4').style.visibility='hidden';            
						document.getElementById('id5').style.visibility='hidden';    
                    
						delete_values1(document.getElementById('referred_to'))
						delete_values(document.getElementById('location0'))
						delete_values(document.getElementById('location1'))
						delete_values(document.getElementById('practitioner'))
						document.getElementById('location2').value = ""
						document.getElementById('practitioner1').value = ""
						document.forms[0].ReferralNotes.value = ''
                    }
                }

                function getval1(obj)
                {
	                    document.getElementById('td2').innerText= '';

						var ref_type=obj.value;
						location0_array = new Array () ;
                    
                        delete_values1(document.getElementById('referred_to'))
                        delete_values(document.getElementById('location0'))

                        delete_values(document.getElementById('location1'))
                        delete_values(document.getElementById('practitioner'))
                        document.getElementById('location2').value = ""
                        document.getElementById('practitioner1').value = ""

                    if(ref_type == 'X' || ref_type == 'E')
                    {
                    if(ref_type=="X")
                    {
                        document.getElementById('id4').style.visibility='hidden';
                        document.getElementById('td5').style.visibility='hidden';

			            document.forms[0].id4.style.visibility='hidden';
                        document.forms[0].id5.style.visibility='hidden';

                        document.forms[0].location0.disabled=true;
                        document.forms[0].location1.disabled=true;

                        document.forms[0].location2.disabled=false;
                        document.forms[0].practitioner1.disabled=false;
                    }
                    else if(ref_type=="E")
                    {
                        document.forms[0].location2.disabled=true;
                        document.forms[0].practitioner1.disabled=true;

                        document.forms[0].location0.disabled=false;
                        document.forms[0].location1.disabled=false;

	                    document.forms[0].id4.style.visibility='visible';
	                    document.forms[0].id5.style.visibility='visible';

                    }

                    var loc0=document.forms[0].location0.value;
                    document.forms[0].referred_to.value="";
                    document.forms[0].preferred_date.value="";
                    document.forms[0].location0.value="";
                    document.forms[0].location1.value="";
                    document.forms[0].location2.value="";
                    document.forms[0].practitioner.value="";
                    document.forms[0].practitioner1.value="";
                    
                    var ref= document.forms[0].referred_to
                    while (ref.options.length >1)
                    {
                        ref.options.remove(1);
                    }
                    var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='GetReferralVals.jsp?src1=1&ref_type="+ref_type+"&loc0="+loc0+"'></form></BODY></HTML>";

                    Dummy_frame.document.write(HTMLVal);
                    Dummy_frame.document.forms[0].submit();

                    }
                }

                function populate_hcare(obj)
                {
                    if(!obj.value=="")
                    {
                        document.getElementById('id4').src="../../eCommon/images/mandatory.gif";     document.getElementById('id4').style.visibility='visible';           
                        
                        document.getElementById('id5').src="../../eCommon/images/mandatory.gif";     document.getElementById('td5').style.visibility='visible';           
                    }
                    else
                    {
                        document.getElementById('id4').style.visibility='hidden';
                        document.getElementById('td5').style.visibility='hidden';
                    }
                
                    document.getElementById('td2').innerText=       
                    document.forms[0].hcare_setting_type_desc.value

                    delete_values(document.forms[0].location0)
                    if(obj.value != "")
                    {
                        for(var i=0;i<location0_array.length;i++)
                            document.forms[0].location0.add(location0_array[i]);
                    }
                }
                function  validate_from_date(obj)
                    {
                        if(obj.value.length>0)
                        CheckDate(obj);
                        DateValidation(obj);
                    }
                    function DateValidation(obj){ 
                curdate = document.forms[0].sdate;

                var msg = getMessage("FROM_DATE_LESS_SYSDATE","SM");
                if(doDateCheckAlert(curdate,obj) == false    ) {
                    obj.focus();
                    obj.select();
                    alert(msg);
                }
                    }
                function clear_location(obj)
                {
                    var len1=document.forms[0].practitioner.length;
                    var j=1;
                    while(j<len1)
                    {
                        len1=document.forms[0].practitioner.length;
                        document.forms[0].practitioner.remove(j);
                    }

                    document.forms[0].practitioner_name.value="";
                    
                    var len=document.forms[0].location1.length;
                    var i=1;
                    while(i<len)
                    {
                        len=document.forms[0].location1.length
                        document.forms[0].location1.remove(i)
                    }
                        var ref_to=document.forms[0].referred_to.value;
                        var loc_type=obj.value;
                        var location1=document.forms[0].location1.value;
                        if(loc_type=='C' || loc_type=='N')
                        {
                            var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='GetCheckoutVals.jsp?src1=2&loc_type="+loc_type+"&ref_to="+ref_to+"&location1="+location1+"'></form></BODY></HTML>";
                            parent.Dummy_frame.document.write(HTMLVal);
                            parent.Dummy_frame.document.forms[0].submit();


                        }
                }
				 function delete_values(field)
                {
                        var selected = field;
                        while ( selected.options.length > 0 )
                                    selected.remove(selected.options[0]);
                        var opt=document.createElement("Option");
                        opt.text="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
                        opt.value="";
                        field.add(opt);
                }
                function delete_values1(field)
                {
                        var selected = field;
                        while ( selected.options.length > 0 )
                                    selected.remove(selected.options[0]);
                        var opt=document.createElement("Option");
                        opt.text="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
                        opt.value="";
                        field.add(opt);
                }
                function disableAllFields()
                {
					document.forms[0].referral_type.disabled=true;
                    document.forms[0].referred_to.disabled=true;
                    document.forms[0].preferred_date.disabled=true;
                    document.forms[0].location0.disabled=true;
                    document.forms[0].location1.disabled=true;
                    document.forms[0].location2.disabled=true;
                    document.forms[0].practitioner.disabled=true;
                    document.forms[0].practitioner1.disabled=true;

                    document.getElementById('id1').style.visibility='hidden';            
                    document.getElementById('id2').style.visibility='hidden';            
                    document.getElementById('id3').style.visibility='hidden';            
                    document.getElementById('id4').style.visibility='hidden';            
                    document.getElementById('id5').style.visibility='hidden';            
                }
		</script>
</head>
<%
		request.setCharacterEncoding("UTF-8"); 
		Connection con		= null;
		Statement stmt 		= null;
		ResultSet rs		= null;
		String system_date = "";
		try
		{
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
            rs = stmt.executeQuery("Select to_char(sysdate,'dd/mm/rrrr')  from dual");
			while(rs!=null && rs.next())
			{
				system_date = rs.getString( 1 );
			}   
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}catch(Exception e){
			out.print("Exception "+e);
		}	
		finally   
		{
			ConnectionManager.returnConnection(con,request);
		}
%>
<body onLoad='document.forms[0].referred.focus();disableAllFields();' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='Referral_Details_form' id='Referral_Details_form'  method="post" >
		<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<th align='left' colspan='4'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></th>
                      <tr>
                              <td align='right' width='20%' class='label' nowrap><fmt:message key="Common.Referred.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                              <td width='70%'  align='left' colspan='2'> <input type='checkbox' name='referred' id='referred' value="Y" onClick='enable_referred(this)' > </td>
							  <td >&nbsp;</td>
                       </tr>
                       <tr>
                              <td align=right class=label nowrap><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                              <td align=left><select name=referral_type id=referral_type onchange='getval1(this)' >
                                      <option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
                                      <option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
                                      <option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
                                        </select>&nbsp;<img id=id1 src='../../eCommon/images/mandatory.gif'></td>
								<td align=left id=td1></td>
                                <td>&nbsp;</td>
                      </tr>
                      <tr>
                               <td align=right class=label nowrap><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                               <td align=left ><select name=referred_to id=referred_to onchange='populate_hcare(this)' >
                               <option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
                               </select>&nbsp;<img id=id2 src='../../eCommon/images/mandatory.gif'>&nbsp;</td>
                               <td align=left class=label id='td2' colspan=1></td>
							   <td>&nbsp;</td>
                       </tr>
                       <tr>
                               <td align=right class=label nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                               <td align=left><input type=text name=preferred_date id=preferred_date value='<%=system_date%>'  size=10 maxlength=10  onBlur="validate_from_date(this)">&nbsp;<img id=id3 src='../../eCommon/images/mandatory.gif'></td>
                               <td align=left id=td3>&nbsp;</td>
						       <td>&nbsp;</td>
                      </tr>
                      <tr>
							<td align=right class=label nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td align=left nowrap><select name=location0 id=location0 onchange='clear_location(this)'>
								<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>    
							</select>&nbsp;<img id=id4 src='../../eCommon/images/mandatory.gif'> <select name=location1 id=location1 onchange='callme(this);'>
								<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
								</select>&nbsp;<img id=id5 src='../../eCommon/images/mandatory.gif'></td>
								<td id=td5>&nbsp;</td>
								<td>&nbsp;</td>
                      </tr>
                     <tr>
                             <td>&nbsp;</td>
                             <td colspan=2 align=left><input type=text name=location2 id=location2 value=''></td>
							 <td>&nbsp;</td>

                     </tr>
                     <tr>
							<td align=right class=label nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                            <td align=left><select name=practitioner id=practitioner value=''>
                                     <option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>    
                             </select>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                             <td>&nbsp;</td>
							 <td>&nbsp;</td>
                     </tr>
                     <tr>
                              <td>&nbsp;</td>
                              <td colspan=2 align=left><input type=text name=practitioner1 id=practitioner1 value='' size=30 maxlength=30></td>
							  <td>&nbsp;</td>
                     </tr>
					 <Tr>
                           	<td align=right class=label nowrap><fmt:message key="eMP.ReferralNotes.label" bundle="${mp_labels}"/>&nbsp;&nbsp;</td>
							<TD COLSPAN='2'><textarea rows='8' cols='40' name='ReferralNotes'></textarea></TD>
							<td>&nbsp;</td>
					 </tr>
					</table>
					<table align=right cellpadding=0 cellspacing=0 width="100%">
					<tr>
						<td align='right'><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="window.close()"></td>
					</tr>
					</table>

</form>
</BODY>
</HTML>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

