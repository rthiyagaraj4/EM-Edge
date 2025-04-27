<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,webbeans.eCommon.*,java.util.StringTokenizer"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");
%>

<%
		String pr_id = request.getParameter("process_id");
		String strFrameRef = request.getParameter("bodyFrameRef");
		String op_call = request.getParameter("op_call");
		
		
		
		if(op_call == null) op_call="";
		int process = Integer.parseInt(pr_id);		
			Connection con = null;
			Statement stmt = null;
			Statement stmt1 = null;
			ResultSet rs = null;
			ResultSet rset = null;
try{
		con = ConnectionManager.getConnection(request);
	//Getting Date of Birth Function
	if ( process == 1 )
	{
		     if(op_call.equals("reg_pat")||op_call.equals("ae_reg_pat"))
					 strFrameRef = "parent.frames[1].frames[0]";
				stmt = con.createStatement();
		
			    int DAYS,MONTHS,AGE;

				int  maxAge		= Integer.parseInt(checkForNull(request.getParameter("maxAge")));				

				String DOB		= checkForNull(request.getParameter("date_of_birth"));
				String DateStr	= DOB;
				if (!localeName.equals("en"))
				{
					DateStr = DateUtils.convertDate(DOB,"DMY",localeName,"en"); 
				}

				String sql = "select calculate_age('"+DateStr+"',1) AGE, calculate_age('"+DateStr+"',2) MONTHS, calculate_age('"+DateStr+"',3) DAYS from dual";
				
				rs = stmt.executeQuery(sql);
				rs.next();
				AGE = rs.getInt("AGE");
				MONTHS = rs.getInt("MONTHS");
				DAYS = rs.getInt("DAYS");
				
				String htmlVal ="";
				
				if(AGE > maxAge) {
					 htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>var m_age = eval("+strFrameRef+").document.getElementById('max_patient_age').value;msg = getMessage('MAX_PATIENT_AGE','MP');msg = msg.replace('#', '$');msg= msg+' '+m_age+' '+ getLabel('Common.Years.label','common');alert(msg);eval("+strFrameRef+").document.getElementById('b_age').value = '';eval("+strFrameRef+").document.getElementById('date_of_birth').focus();eval("+strFrameRef+").document.getElementById('b_age').value='';eval("+strFrameRef+").document.getElementById('b_months').value='';eval("+strFrameRef+").document.getElementById('b_days').value='';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>";
					 out.println(htmlVal);
				} else if ((AGE == maxAge) && ((MONTHS > 0) ||  (DAYS > 0)) ) {			

					htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>var m_age = eval("+strFrameRef+").document.getElementById('max_patient_age').value;msg = getMessage('MAX_PATIENT_AGE','MP');msg = msg.replace('#', '$');msg= msg+' '+m_age+' '+ getLabel('Common.Years.label','common');alert(msg);eval("+strFrameRef+").document.getElementById('b_age').value = '';eval("+strFrameRef+").document.getElementById('date_of_birth').focus();eval("+strFrameRef+").document.getElementById('b_age').value='';eval("+strFrameRef+").document.getElementById('b_months').value='';eval("+strFrameRef+").document.getElementById('b_days').value='';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>"; 				
					out.println(htmlVal);					
				} else {
					htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>eval("+strFrameRef+").document.getElementById('b_age').value='"+AGE+"';eval("+strFrameRef+").document.getElementById('b_months').value='"+ MONTHS +"';eval("+strFrameRef+").document.getElementById('b_days').value='"+DAYS+"';"+"</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>";	out.println(htmlVal);
				}
	}
	if ( process == 2 )
		{
			stmt1 = con.createStatement();

			String DAYS,MONTHS,AGE;
		
			DAYS = checkForNull(request.getParameter("b_days"));
			MONTHS = checkForNull(request.getParameter("b_months"));
			AGE = checkForNull(request.getParameter("b_age"));
	
			if ( DAYS.equals("") )
				DAYS = "null";
			if ( MONTHS.equals("") )
				MONTHS = "null";
			if ( AGE.equals("") )
				AGE = "null";

			String DOB = "";
			String sql1 = "select calculate_date_of_birth ("+AGE+","+MONTHS+","+DAYS+") from dual";
			rset = stmt1.executeQuery(sql1);
			if (rset != null)
			{
				rset.next();
		        DOB = rset.getString(1);
			}

			if ( DOB !=null && !DOB.equals("") )
			{
				if (!localeName.equals("en"))
				{
					DOB = DateUtils.convertDate(DOB,"DMY","en",localeName); 
				}
			}

			if(op_call.equals("reg_pat")||op_call.equals("ae_reg_pat"))
					 strFrameRef = "parent.frames[1].frames[0]";

			String  htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown='lockKey()'><script language='javascript'>if(eval("+strFrameRef+").document.getElementById('date_of_birth')!=null){			eval("+strFrameRef+").document.getElementById('date_of_birth').value='"+DOB+"';}</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><input type='hidden' name='result' id='result' value='"+DOB+"'</body></html>";
			
			out.println(htmlVal);
			if(stmt1!=null) stmt1.close();
			if(rset!=null) rset.close();
	}
	if ( process == 3 )
    {	
		stmt1 = con.createStatement();
%>
		 <script>
		varFrameRef = '<%=strFrameRef%>'
		var op_call = '<%=op_call%>'
		if(op_call == "reg_pat" || op_call =="ae_reg_pat")
			varFrameRef = "parent.frames[1].frames[0]";
		var obj =eval(varFrameRef).document.getElementById('ethnic_group');
		var length  = obj.length;
		for(i=0;i<length;i++) {obj.remove(0);}
		var element1 = eval(varFrameRef).document.createElement('OPTION');
		element1.text = " ------- "+getLabel("Common.defaultSelect.label","Common")+" ------- ";
		element1.value= "";
		eval(varFrameRef).document.getElementById('ethnic_group').add(element1);	
		</script> 

<%		
		String race_code = request.getParameter("race_code");
		if(race_code == null) race_code="";
		if(!race_code.equals(""))
		{
			String sql = "Select ethnic_group_code, long_desc from mp_ethnic_group_lang_vw where language_id = '"+locale+"' and race_code='"+race_code+"' and eff_status='E'   order by 2";
		
			rset = stmt1.executeQuery(sql);
					
			if(rset!=null)
			{
				while (rset.next())
				{
%>			
					 <script>
					var element = eval(varFrameRef).document.createElement('OPTION');
					element.text = "<%=rset.getString("long_desc")%>";
					element.value= "<%=rset.getString("ethnic_group_code")%>";
					eval(varFrameRef).document.getElementById('ethnic_group').add(element);	
					</script> 
<% 
				}
			}
		 }	
			String htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown='lockKey()'></body></html>";
			out.println(htmlVal);
	}
}catch(Exception e) {/*  out.println(e.toString()); */ e.printStackTrace();}
finally
{
	if (rs != null) rs.close();
	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
	if (stmt1 != null) stmt1.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
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

