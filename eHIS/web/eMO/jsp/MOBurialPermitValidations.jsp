<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/common.js' ></script>

<%
	Connection con               = null;
	java.sql.Statement stat      = null;
	ResultSet rs                 = null;

	int count1                   = 0;
	int count                    = 0;
	int countReg                 = 0;
	int countFlag                = 0;
	int countFlag1               = 0;
	int countFlag11              = 0;
	int countReg1                = 0;
	char alert_yn				 = 'Y';
    String beginHtml			 = "<html><script>";
	String endHtml			     = "</script></html>";
try
{

   	request.setCharacterEncoding("UTF-8");
	String patient_id     = request.getParameter("patient_id");
	String burial_permit_no     = request.getParameter("burial_permit_no");
	if(burial_permit_no==null || burial_permit_no.equals("null"))burial_permit_no = "";
	String mode     = request.getParameter("mode");
	if(mode==null || mode.equals("null"))mode = "";
	String BurialFlag     = request.getParameter("BurialFlag");
	if(BurialFlag==null || BurialFlag.equals("null"))BurialFlag = "";
	String	facility_id   = (String) session.getValue( "facility_id" ) ;
    con                   = ConnectionManager.getConnection(request);
    if(patient_id==null || patient_id.equals("null"))patient_id = "";
    if(mode.equals("query") ){
      %>
      <script> 
	     parent.frames[1].document.forms[0].patient_id.value='<%=patient_id%>' ;
         parent.patientLine.location.href='../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>';
         parent.result.location.href = '../../eMO/jsp/MOBurialPermitSearch.jsp?param=<%=patient_id%>&mode=<%=mode%>';
	     parent.frames[4].location.href='../../eCommon/jsp/error.jsp?err_value=0';
     </script>
     <%
	}else{

	if(BurialFlag.equals("Y") ){
		  if(!burial_permit_no.equals("")){
		  
        stat=con.createStatement();
		
		rs=stat.executeQuery("select count(*) from  mo_mortuary_regn where facility_id='"+facility_id+"' and burial_permit_no='"+burial_permit_no+"'");
		if(rs!=null)
		{
			while(rs.next())
			{
			 countFlag=rs.getInt(1);
			}
		 }
		 if(rs!=null) rs.close();
		 if(stat!=null) stat.close();
		 stat=con.createStatement();
		 rs=stat.executeQuery("select count(*) from  mo_burial_permit where burial_permit_no='"+burial_permit_no+"'  and facility_id='"+facility_id+"'");
		 if(rs!=null)
		 {
			while(rs.next())
			{
			 countFlag11=rs.getInt(1);
			}
		 }
		 if(rs!=null) rs.close();
		 if(stat!=null) stat.close();
		 }
		
		if(!patient_id.equals("")){
		
		stat=con.createStatement();
		rs=stat.executeQuery("select count(*) from  mo_burial_permit where patient_id='"+patient_id+"'  and facility_id='"+facility_id+"'");
		if(rs!=null)
		{
			while(rs.next())
			{
			 countFlag1=rs.getInt(1);
			}
		 }
		 if(rs!=null) rs.close();
		 if(stat!=null) stat.close();
		 
		}
        if(countFlag > 0 || countFlag1 > 0 || countFlag11 > 0)
			{
			  out.println(beginHtml+"parent.result.document.forms[0].burial_permit_no.value='';alert(getMessage('BURIAL_PERMIT_NO_EXISTS','MO'))"+endHtml);
			  out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);

			 %>
			 
			  <script>
                 parent.result.document.forms[0].burial_permit_no.value='';
			     parent.result.document.forms[0].burial_permit_no.focus();
			 </script>
			  <%
			}%>
	 <script>
	  parent.frames[4].location.href='../../eCommon/jsp/error.jsp?err_value=0';
	  </script><%
	}
	else{
	webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
	patdata.setFacility_id(facility_id);
	String patientIdStatus = patdata.CheckStatus(con,patient_id);
	
    if (patientIdStatus.equals("INVALID_PATIENT")) 
	{
		out.println(beginHtml+"alert(getMessage('INVALID_PATIENT','MP'))"+endHtml);
		out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
		alert_yn = 'N';
	}
     else
     {
		stat=con.createStatement();
		rs=stat.executeQuery("select count(*) from mp_patient where patient_id='"+patient_id+"' and deceased_yn='Y'");
		if(rs!=null)
		{
			while(rs.next())
			{
			 count1=rs.getInt(1);
			}
		 }
		 if(rs!=null) rs.close();
          if(stat!=null) stat.close(); 
		if(count1==0)
			{
			 out.println(beginHtml+"alert(getMessage('PATIENT_IS_NOT_DECEASED','MO'))"+endHtml);
			out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
			 alert_yn = 'N';
			}
		if(count1>0){
	
		   stat=con.createStatement();
		   rs=stat.executeQuery("select count(*) from  mo_burial_permit where patient_id='"+patient_id+"'");

			while(rs.next())
			{
			count=rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
			if(count>0)
			{
				 out.println(beginHtml+"alert(getMessage('BURIAL_PERMIT_NO_EXISTS','MO'))"+endHtml);
                out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
				 alert_yn = 'N';
	        
			}
          if(count==0)
          {
	       stat=con.createStatement();
		   rs=stat.executeQuery("select count(*) from MO_MORTUARY_REGN where patient_id='"+patient_id+"' and facility_id='"+facility_id+"'");

			while(rs.next())
			{
			countReg=rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
            if(countReg>0)
			{
			out.println(beginHtml+"alert(getMessage('PATIENT_ALREADY_REGISTERED','MO'))"+endHtml);
			out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
			alert_yn = 'N';
		    }
          }
    }//end of count1>0
    if(!patient_id.equals("") && (count==0)){
	      stat=con.createStatement();
		  rs=stat.executeQuery("select count(*) from mo_encounter_dtls_vw where  patient_id='"+patient_id+"'  and facility_id='"+facility_id+"'");

		    while(rs.next())
			{
			countReg1=rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
            if(countReg1==0)
			{
			out.println(beginHtml+"alert(getMessage('REGN_NOT_ALLOWED','MO'))"+endHtml);
			out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
			alert_yn = 'N';
		  
			}
	}
	if(!patient_id.equals("") && (count==0)){
	      stat=con.createStatement();
		  rs=stat.executeQuery("select count(*) from mo_encounter_dtls_vw where  patient_id='"+patient_id+"'  and facility_id='"+facility_id+"' and  MLC_YN='N' and regn_allowed_in_mo_yn='Y' and patient_id not in (select NVL(patient_id,'*') from mo_mortuary_regn) and patient_id not in (select patient_id  from mo_burial_permit) ");

		    while(rs.next())
			{
			countReg1=rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stat!=null) stat.close();
            if(countReg1==0)
			{
			out.println(beginHtml+"alert(getMessage('BURIAL_PERMIT_NOT_ALLOWED','MO'))"+endHtml);
			out.println(beginHtml+"parent.frames[1].document.forms[0].patient_id.disabled=false;"+endHtml);
			alert_yn = 'N';
		    }
   }
}//end of else
if(!(alert_yn=='N'))
{%>
<script>
	parent.frames[1].document.forms[0].patient_id.value='<%=patient_id%>' ;
    parent.patientLine.location.href='../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>';
    parent.result.location.href = '../../eMO/jsp/MOBurialPermitSearch.jsp?param=<%=patient_id%>';
	parent.frames[4].location.href='../../eCommon/jsp/error.jsp?err_value=0';
</script>
<%}else{%>
<script>
	parent.frames[1].document.forms[0].patient_id.value='';
    parent.patientLine.location.href='../../eCommon/html/blank.html';
    parent.result.location.href='../../eCommon/html/blank.html';
    parent.frames[4].location.href='../../eCommon/jsp/error.jsp?err_value=0';
</script>
<%}
    if(stat!=null) stat.close();
	if(rs!=null) rs.close();
	}
  }
}
catch(Exception e)
{
  out.println("Exception in File MOBurialPermitValidations"+e.toString());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>



