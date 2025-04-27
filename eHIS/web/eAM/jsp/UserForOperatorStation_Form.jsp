<!DOCTYPE html>
<%--
	FileName	: UserForOperatorStation_Form.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>


<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>


<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eAM/js/UserForOperatorStation.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	Statement stmtsys=null;
	ResultSet rsetsys=null ;
	Statement stmt1=null;
	ResultSet rset1 = null;
	ResultSet rset=null;
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	
	String login_user=p.getProperty( "login_user" ) ;
	String facilityid=(String)session.getValue("facility_id") ;

	String locale=(String)session.getAttribute("LOCALE");

	String facilityId = request.getParameter("facilityId");
		if(facilityId == null || facilityId.equals(""))   facilityId=facilityid; 
	
	String uid="";
	String uname="";

	String fid="";
	String fname="";

	String oprstn="";
	String oprstnname="";

	String fnval="insert";

	String datefr="";
	String dateto="";
	//String sysdate="";
	String fromchk="check";

	SimpleDateFormat formatter=null;
	String s="";

	String datefr1="";
	
		String dateto_disp="";
		String datefr_disp="";
		String sqlDate_disp="";
	
	String sysdtsql="select to_char(sysdate,'dd/mm/yyyy') from dual ";
	
	
	uid=request.getParameter("uid");
	datefr=request.getParameter("date");

	try
	{
		con = ConnectionManager.getConnection(request);
		stmtsys=con.createStatement();
		rsetsys=stmtsys.executeQuery(sysdtsql);
		rsetsys.next();
		String sqlDate=rsetsys.getString(1);
		if(rsetsys!=null) rsetsys.close();
        if(stmtsys!=null) stmtsys.close();
		stmt=con.createStatement();
		/*rset=stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy') from dual");
		rset.next();
		sysdate=rset.getString(1);
		if(rset!=null) rset.close();
		if(stmt!=null)stmt.close();*/
	if(uid!=null )
	{
		uid=uid.trim();
		fnval="modify";
		
		String sql="select a.*, to_char(a.eff_date_from,'dd/mm/rrrr'),decode(sign(trunc(a.eff_date_from) - trunc(sysdate)) ,'-1','Lower','Higher') ind from am_user_for_oper_stn_vw a where   to_char(eff_date_from,'dd/mm/yyyy')=? and appl_user_id=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,datefr);
		pstmt.setString(2,uid);

		rset=pstmt.executeQuery();
		if(rset.next())
		{
		uid=rset.getString("appl_user_id");
		uname=rset.getString("appl_user_name");

		oprstn=rset.getString("oper_stn_id");
		oprstnname=rset.getString("SHORT_DESC");

		fid=rset.getString("Facility_id");
		fname=rset.getString("facility_name");

		String ind=rset.getString("ind");
		if(ind.equals("Lower"))
		{
			s="readonly";
			fromchk="nocheck";
		}
		else
			fromchk="check";

		if ( rset.getDate("eff_date_from") != null )
		   {
		        java.util.Date date = rset.getDate("eff_date_from");
		   		formatter = new SimpleDateFormat ("dd/MM/yyyy");
		    	datefr = formatter.format(date);
				datefr_disp=DateUtils.convertDate(datefr,"DMY","en",locale);
		    	date = null;
		    	formatter = null;

		    	date = rset.getDate("eff_date_from");
		    	formatter = new SimpleDateFormat ("dd/MM/yyyy");
		    	datefr1 = formatter.format(date);
		    }
	    	else
	    		datefr="";

	       if ( rset.getDate("eff_date_to") != null )
		{
		         java.util.Date date = rset.getDate("eff_date_to");
		      	 formatter = new SimpleDateFormat ("dd/MM/yyyy");
		    	 dateto = formatter.format(date);
				  dateto_disp=DateUtils.convertDate(dateto,"DMY","en",locale);
		    	 date = null;
		    	 formatter = null;
		 }
	  	else
			   dateto="";

		 if(dateto==null)
			dateto="";
	}
	else
		out.print("no resultset");
}

	 if(datefr==null)
			datefr="";
%>
		<script>
				var sStyle='<%=sStyle%>';
          function fetchVals(form,current,sel)
				{ 
					fucn="<%=fnval%>";
					var name=current.name;
					var value=current.value;

					if(name=="facility")
					{
						//removeitems(form.userid);
						document.forms[0].userid.value='';
						document.forms[0].user_desc.value='';
						removeitems(form.oprstn);

					var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'>";
					HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eAM/jsp/FetchValForUserForOperStn.jsp'>";
					HTMLVal = HTMLVal +"<input name='name' id='name' type='hidden' value= '"+name + " '><input name='value' id='value' type='hidden' value='"+value + "'>";
					HTMLVal = HTMLVal +"</form></BODY></HTML>";
					parent.messageFrame.document.write(HTMLVal);
					parent.messageFrame.document.form1.submit();
					}
				}

				function removeitems(obj)
				{
					var len=obj.length;
					var i=1;
					while(i<len)
					{
						len=obj.length
						obj.remove(i)
					}
				}

				function call(sel)
				{
					fetchVals(facility_form,facility_form.clinic,sel)
				}
				
				async function displayUser(obj,target,target_id)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit=getLabel('Common.user.label','Common');

              //Below code was modified by N Munisekhar on 24-Jan-2013 against SKR-SCF-0761 [IN:037419] 
				sql = "select a.appl_user_id code, b.appl_user_name description from SM_FACILITY_FOR_USER a, sm_appl_user_lang_vw  b where a.appl_user_id = b.appl_user_id and language_id = '"+localeName+"' and a.facility_id = '"+document.forms[0].facility.value+"' and upper(a.APPL_USER_ID) like upper(?) and upper(b.APPL_USER_NAME) like upper(?) and b.eff_status = 'E' ";
               // end of SKR-SCF-0761 [IN:037419] 

				//select postal_code code, short_desc description from mp_postal_code where eff_status = 'E' and upper(postal_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
					
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				//argumentArray[6] = DESC_CODE ;
				//argumentArray[7] = DESC_LINK ;
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
					target_id.value=arr[0];
				}else
				{
				target.value="";
				target_id.value="";
				}





				
			}

			async function displayUser1(obj,target,target_id)
				{

				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				//var tit=encodeURIComponent(getLabel('Common.user.label','Common'));
				//Commented the above code for SRR20056-SCF-6902 [IN:026514] by Suresh M on 11.02.2011
				var tit=getLabel('Common.user.label','Common');
				if(obj.value !="")
					{

				sql = "select appl_user_id  code,appl_user_name description  from sm_facility_for_user_vw where facility_id = '"+document.forms[0].facility.value+"' and appl_user_id like upper(?) and upper(appl_user_name) like upper(?) order by 2";


				//select postal_code code, short_desc description from mp_postal_code where eff_status = 'E' and upper(postal_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
					
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
					target_id.value=arr[0];
				}else
				{
				target.value="";
				target_id.value="";
				}
					}
					else
					{
						document.forms[0].userid.value='';
						document.forms[0].user_desc.value='';
					}
		}
			</script>
	</head>

	<body  onLoad="FocusFirstElement();" OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()' >
		<form name='UserForOperationStation_Form' id='UserForOperationStation_Form' action='../../servlet/eAM.UserForOperatorStationServlet' method='post' target='messageFrame'>
			<div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br><br>
			<input type="hidden" name="sStyle" id="sStyle" value='<%=sStyle%>' >
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='auto'>
			<tr>
				<td width='10%'>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td width='10%'>&nbsp;</td>
                        </tr>
				
				<tr>
				     <td width='10%'>&nbsp;</td>
    				     <td  class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
    				     <td  class='fields' colspan='2'><!--width='60%'-->&nbsp;&nbsp;

				  <%if(fnval.equals("modify"))
    				     {  System.out.println("1");
    				     	out.println("<input type='text' name='t' id='t' value=\""+fname +"\" readonly size='70' maxlength='35'>&nbsp<img src='../../eMP/images/mandatory.gif'>");
    				    	out.println("<input type='hidden' name='facility' id='facility' value=\""+fid+"\">");
    				    }
    				     else{%>
    				     <select name='facility' id='facility' onchange='fetchVals(this.form,this)'>
    				     <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
    				     <%
				stmt1=con.createStatement();
				String sqlFac="Select Facility_id,Facility_name Operating_facility_name from SM_FACILITY_FOR_USER_VW where appl_user_id = '"+login_user+"' and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ";
				out.println(sqlFac);
				String dataid="",facName="",sel="";
				rset1=stmt1.executeQuery(sqlFac);
				if(rset1!=null)
				{
				   while(rset1.next())
				   {
					 dataid=rset1.getString(1);
					 facName=rset1.getString(2);
					 if(facilityId.equals(dataid)) sel="selected"; else sel="";
					out.println("<option "+sel+" value=\""+dataid+ "\" >"+facName+"</option>");
    				    }
    				    
    				 }
    				    %>
    				    
    				      </select>&nbsp<img src='../../eMP/images/mandatory.gif'></img>
    				    <% } %>
    				   </td>
    				   <td width='10%'>&nbsp;</td>
    				</tr>
    				<tr>
    					<td width='10%'>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td width='10%'>&nbsp;</td>
                                </tr>
				
				
				
				<tr>
				      <td width='10%'>&nbsp;</td>
    				      <td   class='label'><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
    				     <td  class='fields' colspan='2'>&nbsp;&nbsp;
    				     <%if(fnval.equals("modify"))
    				     {
    				     	out.println("<input type='text' name='t' id='t' value=\""+ uname +"\" readonly size='30'maxlength='30'>&nbsp<img src='../../eMP/images/mandatory.gif'>");
    				    	out.println("<input type='hidden' name='userid' id='userid' value=\""+uid+"\">");
    				    }
    				     else{%>
    				    <input type='text'   name='user_desc' id='user_desc' size='30' onblur='displayUser1(this,user_desc,userid)' maxlength='60'><input type='hidden' name='userid' id='userid' value=""><input type='button' class='button' name='userIdbutton' id='userIdbutton' value='?' onClick='displayUser(this,user_desc,userid)'>
    				    		&nbsp<img src='../../eMP/images/mandatory.gif'><%}%>

    				   </td>
    				   <td width='10%'>&nbsp;</td>
    				</tr>
    				<tr>
    					<td width='10%'>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td width='10%'>&nbsp;</td>
                                </tr>


			 	<tr>
			 	     <td width='10%'>&nbsp;</td>
				     <td  class='label'><fmt:message key="Common.operatorstation.label" bundle="${common_labels}"/></td>
    				     <td  class='fields' colspan='4'>&nbsp;&nbsp;
    				      <%if(fnval.equals("modify"))
				        {
		 		       	out.println("<input type='text' name='p' id='p' value=\""+oprstnname+"\" readonly size='30'maxlength='30'>&nbsp<img src='../../eMP/images/mandatory.gif'>");
				       	out.println("<input type='hidden' name='oprstn' id='oprstn' value=\""+oprstn+"\">");
				        }

				       else{%>
    				   	<select name='oprstn' id='oprstn'>
    				   	<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
    				   	</select>
    				    	 <img src='../../eMP/images/mandatory.gif'></tr>
    				    	 <%}%>
    				     </td>
    				    </tr>

                <tr>  <td  class='label' colspan='4'>&nbsp;&nbsp;<td>&nbsp;</td> </tr>				

				<tr>
				<td width='10%'>&nbsp;</td>
				<td   class='label'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;
				<% if(datefr.equals("")) {
					sqlDate_disp=DateUtils.convertDate(sqlDate,"DMY","en",locale);

					datefr_disp=sqlDate_disp; }%>
				<input type='text' name='eff_date_from1' id='eff_date_from1' size='10'  value='<%=datefr_disp%>' onblur="DateCompare_from('from',this,sysdate);" maxlength='10' <%=s%> ><input type='hidden' name='eff_date_from1_disp' id='eff_date_from1_disp' value='<%=datefr%>'><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('eff_date_from1');">&nbsp<img src='../../eMP/images/mandatory.gif'><input type='hidden' name='eff_date_from1_greg' id='eff_date_from1_greg' value=''></td>


				<td  class='label'><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp
				<input type='text'  name='eff_date_to1' id='eff_date_to1' size='10' value='<%=dateto_disp%>' maxlength='10' onblur="DateCompare_from('To',this,sysdate);DateCompare3(eff_date_from1,this);"><input type='hidden' name='eff_date_to1_disp' id='eff_date_to1_disp' value='<%=dateto%>'><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('eff_date_to1');"><input type='hidden' name='eff_date_to1_greg' id='eff_date_to1_greg' value=''></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td width='10%'>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td width='10%'>&nbsp;</td>
                </tr>
			</table>
		</div>
		<input type='hidden' name='function' id='function' value='<%=fnval%>'>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
		<input type='hidden' name='eff_date_from' id='eff_date_from'  >
		<input type='hidden' name='eff_date_fromold' id='eff_date_fromold'  value='<%=datefr1%>'>
		<input type='hidden' name='eff_date_to' id='eff_date_to' >
		<input type='hidden' name='function1' id='function1' value='<%=fnval%>'>
		<INPUT TYPE='hidden' name='current' id='current'>
		<input type='hidden' name='fromcheck' id='fromcheck' value='<%=fromchk%>'>
		<input type='hidden' name='sysdate' id='sysdate' value='<%=sqlDate%>'>
		<%
			if(fnval.equals("insert"))
			 out.println("<script>fetchVals(document.UserForOperationStation_Form,document.UserForOperationStation_Form.facility)</script>");
		%>
	</form>
</body>
<%}  catch(Exception e){out.print(e);}
	  finally
	  {
		  try{
		 if(stmt!=null)	   stmt.close();
		 if(stmt1!=null)   stmt1.close();
		 if(pstmt!=null)   pstmt.close();
		 if(rset!=null)	   rset.close();
		 if(rset1!=null)   rset1.close();
		 if(rsetsys!=null) rsetsys.close();
		  }
		  catch(Exception e)
		  {
			ConnectionManager.returnConnection(con,request);
		  }
		  ConnectionManager.returnConnection(con,request);

	  }%>
</html>

