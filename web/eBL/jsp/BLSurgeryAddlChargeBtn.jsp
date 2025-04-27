<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con = null; 
	PreparedStatement pstmt = null;
	ResultSet rscurr=null;
	try
	{
		//HttpSession httpSession = request.getSession(false);
		//Properties p = (Properties)httpSession.getValue("jdbc");	
		//String locale	= (String)session.getAttribute("LOCALE");
		con	=	ConnectionManager.getConnection(request);	

		String function_id = request.getParameter("function_id");
			if(function_id == null) function_id="EDIT";

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eBL/js/BLSurgeryAddlchargeDtl.js"></script>
		</head>
 <%
		int noofdecimal=2;
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}
			rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("rscurr="+e.toString());
		}
%>
<html>
<script>
	 function putdeci(object)
	{
	var decimal=document.forms[0].noofdecimal.value;
	if(object.value!='')
	{
		putDecimal(object,17,decimal);
	}
	
	}
	function total_amt()
	{	    
		var tot_disc_amt=0.0;
		var cat_tot_disc_amt=0.0;
		var tot_net_amt=0.0;
		var tot_gross_amt=0.0;
		var cat_tot_net_amt=0.0;
		var tot_patient_payable=0.00;
		var cat_tot_patient_payable=0.00;
		var cat_gross_amt=0.00;
		var a_disc_amt=new Array();var a_net_amt=new Array();var a_pat_pay=new Array();var a_gross_amt=new Array();
		var tot_records=parent.frames[1].document.forms[0].totalRecords.value;		
		
		if(tot_records!=0)
		{		
					

			var ord_catlog_count=parent.frames[1].document.forms[0].ord_tot_rec.value;
			for(var i=0;i<ord_catlog_count;i++)
			{
				var order_serv_cnt = eval("parent.frames[1].document.forms[0].order_serv_cnt_"+i);
				var order_serv_cnt_tt = eval(order_serv_cnt.value)+1;
				for(var j=0;j<order_serv_cnt_tt;j++)
				{		
					if(j==0)
					{
						var disc_amt = eval("parent.frames[1].document.forms[0].disc_amt_"+i+"_"+j);						
						a_disc_amt[j]=disc_amt.value;

						var net_amt = eval("parent.frames[1].document.forms[0].net_amt_"+i+"_"+j);						
						a_net_amt[j]=net_amt.value;

						var pat_pay_amt = eval("parent.frames[1].document.forms[0].pat_pay_amt_"+i+"_"+j);						
						a_pat_pay[j]=pat_pay_amt.value;

						var gross_amt = eval("parent.frames[1].document.forms[0].gross_amt_"+i+"_"+j);						
						a_gross_amt[j]=gross_amt.value;

						cat_tot_disc_amt=parseFloat(cat_tot_disc_amt)+parseFloat(a_disc_amt[j]);
						cat_tot_net_amt=parseFloat(cat_tot_net_amt)+parseFloat(a_net_amt[j]);
						cat_tot_patient_payable=parseFloat(cat_tot_patient_payable)+parseFloat(a_net_amt[j]);
						cat_gross_amt=parseFloat(cat_gross_amt)+parseFloat(a_gross_amt[j]);
						
					}

					if(j!=0)
					{	
						var selected_row = eval("parent.frames[1].document.forms[0].selected_row_"+i+"_"+j);						
						if (selected_row.value=="Y")
						{				
							var disc_amt = eval("parent.frames[1].document.forms[0].disc_amt_"+i+"_"+j);
							a_disc_amt[j]=disc_amt.value;								
							tot_disc_amt = parseFloat(tot_disc_amt) + parseFloat(a_disc_amt[j]);

							var net_amt = eval("parent.frames[1].document.forms[0].net_amt_"+i+"_"+j);						
							a_net_amt[j]=net_amt.value;
							tot_net_amt =  parseFloat(tot_net_amt) + parseFloat(a_net_amt[j]);
		
							var pat_pay_amt = eval("parent.frames[1].document.forms[0].pat_pay_amt_"+i+"_"+j);						
							a_pat_pay[j]=pat_pay_amt.value;									
							tot_patient_payable =  parseFloat(tot_patient_payable) + parseFloat(a_pat_pay[j]);

							var gross_amt = eval("parent.frames[1].document.forms[0].gross_amt_"+i+"_"+j);						
						    a_gross_amt[j]=gross_amt.value;
							tot_gross_amt = parseFloat(tot_gross_amt) + parseFloat(a_gross_amt[j]);
							
										
						}
					}
				}
			}
			tot_disc_amt = parseFloat(tot_disc_amt) + parseFloat(cat_tot_disc_amt);
			tot_net_amt = parseFloat(tot_net_amt) + parseFloat(cat_tot_net_amt);
			tot_patient_payable = parseFloat(tot_patient_payable) + parseFloat(cat_tot_patient_payable);

			tot_gross_amt = parseFloat(tot_gross_amt) + parseFloat(cat_gross_amt);

					
			parent.frames[1].document.forms[0].disc_amt.value=tot_disc_amt;
			var temp_disc=eval("parent.frames[1].document.forms[0].disc_amt")
			putdeci(temp_disc);

			parent.frames[1].document.forms[0].net_amt.value=tot_net_amt;
			var temp_net=eval("parent.frames[1].document.forms[0].net_amt")
			putdeci(temp_net);

			parent.frames[1].document.forms[0].patient_payable.value=tot_patient_payable;
			var temp_pat_pay=eval("parent.frames[1].document.forms[0].patient_payable")
			putdeci(temp_pat_pay);

			parent.frames[1].document.forms[0].gross_amt.value=tot_gross_amt;
			var temp_gross_amt=eval("parent.frames[1].document.forms[0].gross_amt")
			putdeci(temp_gross_amt);
		}
	}
function submit_val()
	{
		var tot_records=parent.frames[1].document.forms[0].totalRecords.value;
		if(tot_records!=0)
		{
			var ord_catlog_count=parent.frames[1].document.forms[0].ord_tot_rec.value;
			var a_serv_code = new Array();
			var order_serv_cnt_t = new Array();
			var a_order_cat_code = new Array();
			var a_selected_row = new Array();
			var a_pract_id = new Array();
			var a_cat_pract_id = new Array();
			for(var i=0;i<ord_catlog_count;i++)
			{
			   var order_serv_cnt = eval("parent.frames[1].document.forms[0].order_serv_cnt_"+i);
				var order_serv_cnt_tt = eval(order_serv_cnt.value)+1;
				//var order_serv_cnt_tt = eval(order_serv_cnt.value);
					
				for(var j=0;j<order_serv_cnt_tt;j++)
				{		
					/*if(j==0)
					{
						var cat_pract_id = eval("parent.frames[1].document.forms[0].pract_name_"+i+"_"+j);
						a_cat_pract_id = cat_pract_id.value;
						
						if(cat_pract_id.value=="")
						{								
							alert(getMessage('BL9889','BL'));			
							return;
						}
					}  */
				//	if(j!=0)
				//	{
						var blng_serv_code = eval("parent.frames[1].document.forms[0].blng_serv_code_"+i+"_"+j);
						a_serv_code = blng_serv_code.value;
						var selected_row = eval("parent.frames[1].document.forms[0].selected_row_"+i+"_"+j);
						if (selected_row.value=="Y")
						{
							var pract_id = eval("parent.frames[1].document.forms[0].pract_name_"+i+"_"+j);
							a_pract_id = pract_id.value;	
							if(pract_id.value=="")
							{
								alert(getMessage('BL9889','BL'));	
								return false;
							}
						}
				//	}
				}
			}
			parent.frames[1].document.forms[0].action="../../eBL/jsp/BLAddlSurgerySubmit.jsp";
			parent.frames[1].document.forms[0].submit();					
		}
	}
		function close_view_window()
		{
			parent.window.close();
		}
</script>
<body onLoad='total_amt()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>
	<!--<table cellpadding=3 cellspacing=0  width="100%">
			<tr>
			<td width='6%'  class='label'>&nbsp;</td>
			<td width='16%'  class='label'>&nbsp;</td>
			<td width='8%'  class='label'>&nbsp;</td>
			<td width='16%'  class='label'><div align='right'><b><fmt:message key="Common.total.label" bundle="${common_labels}"/></b></div></td>
			<td width='8%' class='fields'><input type='text' name='gross_amt' id='gross_amt' size='10' maxlength='30' 
			value='' readonly style='text-align:right' ></td>
			 <td width='8%'  class='label'>&nbsp;</td>
			<td width='8%' class="fields"><input type='text' name='disc_amt' id='disc_amt' size='10' maxlength='30' 
			value='' readonly style='text-align:right' ></td>
				
			<td width='8%' class="fields">	<input type='text' name='net_amt' id='net_amt' size='10'  maxlength='30' value='' readonly 			style='text-align:right'></td>

			<td width='8%' class="fields"><input type='text' name='patient_payable' id='patient_payable' size='10'  maxlength='30' value='' readonly style='text-align:right'></td>

			 <td width='14%'  class='label'>&nbsp;</td>
	
			</tr>	
  </table>-->
<table cellpadding=3 cellspacing=0  width="100%">
<tr>	
<%    if(function_id.equals("EDIT"))
		{
%>
	 <td width="25%"  class='labels'>&nbsp;</td>
	 <td width="25%"  class='labels'>&nbsp;</td>
	 <td width="25%"  class='labels'>&nbsp;</td>
	<td width="25%"  class='labels'><INPUT TYPE="button"  class="BUTTON" VALUE="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick='submit_val()' >
	<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='close_window()'></td>		
	</td>
<%
	}
	else{
%>
     <td width="25%"  class='labels'>&nbsp;</td>
	 <td width="25%"  class='labels'>&nbsp;</td>
	 <td width="25%"  class='labels'>&nbsp;</td>
	<td width="25%"  class='labels'><INPUT TYPE="button"  class="BUTTON" VALUE="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='close_view_window()' >
<%
	}
%>
</tr>
</table>
		<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
<%
	}
	catch(Exception e) 
	{
		System.out.println("btn="+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con, request);
	}		
%>
</form>
</body>
</html>

