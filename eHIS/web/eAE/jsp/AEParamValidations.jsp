<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%> 

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='Javascript'></script>
<script language='javascript' src='../../eAE/js/AEParameter.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 

<%
	Connection connection			=	null;
	PreparedStatement pst	        =	null;
	ResultSet		rs				=	null;
	StringBuffer sql  			    =	new StringBuffer();
	String spo2 = "empty";
	String fbc = "empty";
	String bloodSugar = "empty";
	String ecg = "empty";
	String dressing = "empty";
	String systolicBP = "empty";
	String respiratory = "empty";
	String cbd = "empty";//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
	int flag = 0;
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String dataName = request.getParameter("dataName");
	String dataValue = request.getParameter("dataValue");
	MessageManager mm = new MessageManager();

	dataName = (dataName == null || dataName == "")?"empty":dataName;
	dataValue = (dataValue == null || dataValue == "")?"empty":dataValue;

     

    if(dataName.equals("empty")){
		spo2 = request.getParameter("spo2");
		fbc = request.getParameter("fbc");	
		bloodSugar = request.getParameter("bloodSugar");
		ecg = request.getParameter("ecg");
		dressing = request.getParameter("dressing");
		systolicBP = request.getParameter("systolicBP");	
		respiratory = request.getParameter("respiratory");
		cbd = request.getParameter("cbd");//Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651
	}
	else{
		flag = 1;
		if(dataName.equals("order_catalog_code1"))
			spo2 = dataValue;
		if(dataName.equals("order_catalog_code2"))
			ecg = dataValue;
		if(dataName.equals("order_catalog_code3"))
			fbc = dataValue;
		if(dataName.equals("order_catalog_code4"))
			dressing = dataValue;
		if(dataName.equals("order_catalog_code5"))
			bloodSugar = dataValue;
		if(dataName.equals("systolicBP"))
			systolicBP = dataValue;
		if(dataName.equals("respiratory"))
			respiratory = dataValue;
	}
	int count = 0;
	try
	{
		 connection			= ConnectionManager.getConnection(request);
         
  		 // Checking for SPO2
		 if(!spo2.equals("empty")){ 
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code) AND upper(long_desc) like upper('"+spo2+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
		    count	=	rs.getInt("countValue");
	
			if(count == 0) {
				
					final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SpO2.label","ae_labels")); 
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;	       
		%>
			<script>
			parent.f_query_add_mod.document.parameter_form.order_catalog_code1.value="";
			parent.f_query_add_mod.document.parameter_form.order_cat_code1.value="";		
			parent.f_query_add_mod.document.parameter_form.order_catalog_code1.focus();
			</script>
        <% 
			}
			sql.delete(0,sql.length());
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
		 }
  		 
		 /*Added by Thamizh selvi on 12th Apr 2018 against ML-MMOH-CRF-0651 Start*/
		 // Checking for CBD
		 if(!cbd.equals("empty")){ 
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code) AND upper(long_desc) like upper('"+cbd+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
		    count	=	rs.getInt("countValue");

			if(count == 0) {
				
					final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.CBD.label","ae_labels")); 
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;	       
		%>
			<script>
			parent.f_query_add_mod.document.parameter_form.order_catalog_code6.value="";
			parent.f_query_add_mod.document.parameter_form.order_cat_code6.value="";		
			parent.f_query_add_mod.document.parameter_form.order_catalog_code6.focus();
			</script>
        <% 
			}
			sql.delete(0,sql.length());
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
		 }
		 /*End*/

		// Checking FOR FBC
		if(!fbc.equals("empty")){
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code) AND upper(long_desc) like upper('"+fbc+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
			    count	=	rs.getInt("countValue");
		
			if(count == 0) {
				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.FBC.label","ae_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
		%>
			<script>
			parent.f_query_add_mod.document.parameter_form.order_catalog_code3.value="";
			parent.f_query_add_mod.document.parameter_form.order_cat_code3.value="";
			parent.f_query_add_mod.document.parameter_form.order_catalog_code3.focus();
			</script>
        <% 
			}
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}
			
		
// Checking FOR BLOOD SUGAR
		if(!bloodSugar.equals("empty")) {
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code) AND upper(long_desc) like upper('"+bloodSugar+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
				count	=	rs.getInt("countValue");
	
			if(count == 0) {
				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.CapillaryBloodSugar.label","ae_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
		%>
			<script>
			parent.f_query_add_mod.document.parameter_form.order_catalog_code5.value="";
			parent.f_query_add_mod.document.parameter_form.order_cat_code5.value="";
			parent.f_query_add_mod.document.parameter_form.order_catalog_code5.focus();
			</script>
        <% 
			}
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}

		// Checking FOR ECG
		if(!ecg.equals("empty")) {
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code)   AND upper(long_desc) like upper('"+ecg+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
			    count	=	rs.getInt("countValue");
			if(count == 0) {
				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ecg.label","common_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
		%>
			<script>
			parent.f_query_add_mod.document.parameter_form.order_catalog_code2.value="";
			parent.f_query_add_mod.document.parameter_form.order_cat_code2.value="";
			parent.f_query_add_mod.document.parameter_form.order_catalog_code2.focus();
			</script>
        <% 
			}
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}

// Checking FOR DRESSING
		if(!dressing.equals("empty")) {
			sql.append("SELECT count(*) countValue FROM or_order_catalog WHERE  order_type_code=NVL('',order_type_code) AND upper(long_desc) like upper('"+dressing+"%') AND eff_status='E'  AND nvl(activity_type,'!') = nvl('',nvl(activity_type,'!'))");
			
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
				count	=	rs.getInt("countValue");
	
			if(count == 0) {
				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Dressing.label","common_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
		%>
			<script>
			parent.f_query_add_mod.document.parameter_form.order_catalog_code4.value="";
			parent.f_query_add_mod.document.parameter_form.order_cat_code4.value="";
			parent.f_query_add_mod.document.parameter_form.order_catalog_code4.focus();
			</script>
        <% 
			}
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}
		
		 //Checking FOR SYSTOLIC BP
		if(!systolicBP.equals("empty")) {
			 sql.append("SELECT count(*) countValue FROM am_discr_msr WHERE upper(short_desc) like upper('"+systolicBP+"%')");
			
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();
			if ((rs != null) && (rs.next()))
				count	=	rs.getInt("countValue");
			
			
			if(count == 0) {

				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SystolicBP.label","ae_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
			%>
			<script>
			parent.f_query_add_mod.document.parameter_form.systolicBP.value="";
			parent.f_query_add_mod.document.parameter_form.systolicBPhdd.value="";			
			parent.f_query_add_mod.document.parameter_form.systolicBP.focus();
			</script>
        <% 
			}
			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}
		
		// Checking FOR RESPORIATORY
		if(!respiratory.equals("empty")) {
			sql.append("SELECT count(*) countValue FROM am_discr_msr WHERE upper(short_desc) like upper('"+respiratory+"%')");
			
			pst = connection.prepareStatement(sql.toString());
			rs=pst.executeQuery();			
			if ((rs != null) && (rs.next()))
			{
				count	=	rs.getInt("countValue");

			}
			if(count == 0) {
				final java.util.Hashtable mesg = mm.getMessage(locale, "INVALID_VALUE", "Common") ;
					String msg = ((String) mesg.get("message"));
					StringBuffer msgBuffer=new StringBuffer(msg);
                int splcharat=msg.indexOf("#");
				msgBuffer.deleteCharAt(splcharat);
				mesg.clear();
				msgBuffer=msgBuffer.replace(splcharat,splcharat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.RespiratoryRate.label","ae_labels"));
				out.println("<script>alert('"+msgBuffer+"')</script>");
				flag = 1;
				%>
			<script>
			parent.f_query_add_mod.document.parameter_form.respiratory.value="";
			parent.f_query_add_mod.document.parameter_form.respiratoryhdd.value="";
			parent.f_query_add_mod.document.parameter_form.respiratory.focus();
			</script>
        <% 
			}

			if(rs!=null) rs.close();
			if(pst!=null) pst.close();
			sql.delete(0,sql.length());
		}


		if(pst!=null) pst.close();
		if(rs!=null) rs.close();

		if(flag == 0)
	%>
	<script>
			parent.f_query_add_mod.document.parameter_form.submit();
	</script> 
	<%}catch(Exception exception)
	{
		exception.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(connection, request);
	}
%>
<script>top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
</script>
</html>

