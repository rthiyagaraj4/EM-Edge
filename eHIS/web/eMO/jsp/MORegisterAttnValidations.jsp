<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>

<%
	Connection con          = null;
	java.sql.Statement stat = null;
	ResultSet rs            = null;

	int dflag               = 0;
	int count               = 0;

    boolean status=false;
    
try
{
request.setCharacterEncoding("UTF-8");
String	facility_id   = (String) session.getValue( "facility_id" ) ;
 con                   = ConnectionManager.getConnection(request);
	String patient_id     =request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String objName     = request.getParameter("objName")==null?"":request.getParameter("objName");
	String function_id=request.getParameter("function_id")==null ?"":request.getParameter("function_id");	
	String external=request.getParameter("external")==null?"N":request.getParameter("external");
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	String calledFrom  = "";
	JSONObject json		= new JSONObject();
	json				= eMO.MOCommonBean.chkForExtBidBodyPartPatient(con, patient_id, facility_id);
	count				= (Integer)json.get("bidCount");
	if(count == 1)
		calledFrom	= "MO_BID_REGN";
	/*End*/
	
	if(objName.equals("bodyprt"))
	{
       String obtainedfrom = request.getParameter("obtainedfrom")==null?"":request.getParameter("obtainedfrom"); 
	   
      if(obtainedfrom.equals("A"))
	  {
	   int cntdec=0;
	   stat=con.createStatement();  
	   rs=stat.executeQuery("  select count(*) cnt from mp_patient a, mp_param b where patient_id='"+patient_id+"' and deceased_yn='N' and suspend_yn='N' and active_yn='Y' ");
	   if(rs.next())
       {
	      cntdec =rs.getInt("cnt");
	    
	   }
	   if(rs!=null)rs.close();
	   if(stat!=null)stat.close();
		
	   if(cntdec==0&&(!patient_id.equals("")))
	   {%>
	<script>alert(getMessage('INVALID_PATIENT','MP'));parent.frames[1].document.forms[0].patientid.value="";parent.frames[1].document.forms[0].patbtn.disabled=false;
parent.frames[1].document.forms[0].patientid.disabled=false;</script>
	  
	  <%}else{%>
 <script> parent.frames[3].document.location.href = '../../eMO/jsp/MORegisterBodyPartResult.jsp?function_id=<%=function_id%>&patientid=<%=patient_id%>&obt_from=<%=obtainedfrom%>'
 parent.frames[2].location.href = "../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>" ;  	
 </script>
	
		  
		  <%}

	  }else if(obtainedfrom.equals("D"))
	  { int cntdec=0;
		  stat=con.createStatement();  
	   rs=stat.executeQuery("  select count(*) cnt from mp_patient a, mp_param b where patient_id='"+patient_id+"' and sex='F' and deceased_yn='N' and suspend_yn='N' and active_yn='Y' and (sysdate-a.date_of_birth)/365 >=b.NB_MOTHER_MIN_AGE");
	   if(rs.next())
       {
	      cntdec =rs.getInt("cnt");
	    
	   }
	   if(rs!=null)rs.close();
	   if(stat!=null)stat.close();
	   if(cntdec==0&&(!patient_id.equals("")))
	   {%>
	<script>alert(getMessage('INVALID_PATIENT','MP'));parent.frames[1].document.forms[0].patientid.value="";parent.frames[1].document.forms[0].patbtn.disabled=false;
parent.frames[1].document.forms[0].patientid.disabled=false;</script>
	  <%}else {%>
 <script> parent.frames[3].document.location.href = '../../eMO/jsp/MORegisterBodyPartResult.jsp?function_id=<%=function_id%>&patientid=<%=patient_id%>&obt_from=<%=obtainedfrom%>'
 parent.frames[2].location.href = "../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>" ;  	
 </script>
	
		  
		  <%}

	  
	  
	  
	  }else if(obtainedfrom.equals("U"))
	  {
	  
	   int cntdec=0;
	   stat=con.createStatement();  
//	   rs=stat.executeQuery("select count(*) cnt from mp_patient a,mp_param b where patient_id='"+patient_id+"' and deceased_yn='Y' and a.PAT_DTLS_UNKNOWN_YN='Y' and patient_id not in (select patient_id from mo_mortuary_regn where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D'))");
	   rs=stat.executeQuery("select count(*) cnt from mp_patient a,mp_param b where patient_id='"+patient_id+"' and a.PAT_DTLS_UNKNOWN_YN='Y' and patient_id not in (select patient_id from mo_mortuary_regn where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D'))");
	   if(rs.next())
       {
	      cntdec =rs.getInt("cnt");
	    
	   }
	   if(rs!=null)rs.close();
	   if(stat!=null)stat.close();
	   if(cntdec==0&&(!patient_id.equals("")))
	   {%>
	<script>alert(getMessage('INVALID_PATIENT','MP'));parent.frames[1].document.forms[0].patientid.value="";parent.frames[1].document.forms[0].patbtn.disabled=false;
parent.frames[1].document.forms[0].patientid.disabled=false;
</script>
	  <%}else
		  {%>
 <script> parent.frames[3].document.location.href = '../../eMO/jsp/MORegisterBodyPartResult.jsp?function_id=<%=function_id%>&patientid=<%=patient_id%>&obt_from=<%=obtainedfrom%>'
 parent.frames[2].location.href = "../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>" ;  
 </script>
	
		  
		  <%}
	  
	  
	  
	  
	  }
		
     
		
	}else
	{
	
   

    if(patient_id==null || patient_id.equals("null")) patient_id = "";
	if(objName.equals("BURIAL_PERMIT_NO"))
{
   stat=con.createStatement();
   rs=stat.executeQuery("select BURIAL_PERMIT_NO,PATIENT_ID  from MO_BURIAL_PERMIT_VW where  facility_id='"+facility_id+"' and PATIENT_ID not in (select NVL(PATIENT_ID,'*') from mo_mortuary_regn  where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D')) and patient_id in (select patient_id from mo_encounter_dtls_vw where REGN_ALLOWED_IN_MO_YN='Y') and BURIAL_PERMIT_NO='"+patient_id+"' order by 2");
  
   if(rs.next())
   {
	patient_id=rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
	   %>
	<script>parent.frames[0].document.forms[0].patient_id.value='<%=rs.getString("PATIENT_ID")%>'
   parent.frames[0].document.forms[0].BURIAL_PERMIT_NO.disabled=true;
	parent.frames[0].document.forms[0].burialno_search.disabled=true;
	</script>
    <%}else
	{%>
   <script>alert(getMessage('BURIAL_PERMIT_NOT_EXIST','MO'));
  parent.frames[0].document.location.href = '../../eMO/jsp/MORegisterAttnSearch.jsp'
  
  </script>

	
	<%status=true;}


}else
{ 
	if(!calledFrom.equals("MO_BID_REGN")){//Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689

	  stat=con.createStatement();
	  rs=stat.executeQuery("select BURIAL_PERMIT_NO,PATIENT_ID from MO_BURIAL_PERMIT_VW where  facility_id='"+facility_id+"' and PATIENT_ID not in (select PATIENT_ID from mo_mortuary_regn where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D')) and patient_id in (select patient_id from mo_encounter_dtls_vw where REGN_ALLOWED_IN_MO_YN='Y') and patient_id='"+patient_id+"'");

	  if(rs.next())
	   {%>
		<script>

	   parent.frames[0].document.forms[0].BURIAL_PERMIT_NO.value='<%=rs.getString("BURIAL_PERMIT_NO")%>'
	   parent.frames[0].document.forms[0].BURIAL_PERMIT_NO.disabled=true;
	   parent.frames[0].document.forms[0].burialno_search.disabled=true;
	   
		</script>
		<%}
	}
}
	
	if(rs!=null) rs.close();
	if(stat!=null)stat.close();
	webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
	patdata.setFacility_id(facility_id);
	String patientIdStatus = patdata.CheckStatus(con,patient_id);
	
if(status!=true)
	{

if ( patientIdStatus.equals("INVALID_PATIENT"))
	{
	%>
	 <script>
		 parent.frames[0].document.forms[0].patient_id.value='';
		 alert(getMessage('INVALID_PATIENT','MP'));
		 parent.frames[0].document.forms[0].patient_id.focus();</script>
	<%
	if(external.equals("Y")){					
			//out.println("<script>top.content.location.href='../../eMO/jsp/MODeceasedDtlsFrameset.jsp?menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NNNNN&desktopFlag=N' ;</script>");
	}	
	}
else
{
    stat=con.createStatement();
    rs=stat.executeQuery("select count(*) from mp_patient where patient_id='"+patient_id+"' and deceased_yn='Y'");
if(rs!=null)
{
	while(rs.next())
		{
		dflag=rs.getInt(1);
		}
}
 if(rs!=null) rs.close();
 if(stat!=null)stat.close();
 /*Added by Thamizh selvi on 25th July 2017 for ML-MMOH-CRF-0689 Start*/
 if(calledFrom.equals("MO_BID_REGN"))
	 dflag = 2;
 /*End*/
if(dflag==0)
	{
	
	%>
	<script>parent.frames[0].document.forms[0].patient_id.value='';alert(getMessage('PATIENT_IS_NOT_DECEASED','MO'));parent.frames[0].document.forms[0].patient_id.focus();</script>
	<%
		
		if(external.equals("Y")){					
			//out.println("<script>top.content.location.href='../../eMO/jsp/MODeceasedDtlsFrameset.jsp?menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NNNNN&desktopFlag=N' ;</script>");
		}
	}
if(dflag==1){
	
   stat=con.createStatement();
   rs=stat.executeQuery("select count(*) from mo_encounter_dtls_vw where patient_id not in (select NVL(patient_id,'*') from mo_mortuary_regn_vw where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D')) and patient_id='"+patient_id+"'");
   

while(rs.next())
	{
	count=rs.getInt(1);
	}
	if(rs!=null) rs.close();
	if(stat!=null)stat.close();


	if(external.equals("Y")){
		

		 stat=con.createStatement();
		 rs=stat.executeQuery("select count(*)  from mp_patient where patient_id='"+patient_id+"' and DECEASED_DATE is not null and DECEASED_FACILITY_ID='"+facility_id+"' and DECEASED_ENCOUNTER_ID is not null");
   
		int counter=0;
		while(rs.next()){
			counter=rs.getInt(1);
		}
		if(rs!=null) rs.close();
		if(stat!=null)stat.close();
		
		if(count==1 && counter==1){
			%>
			<script>
			
			parent.frames[0].document.forms[0].patient_id.value='';
			alert(getMessage('NOT_EXT_PAT','MO'));			
			top.content.location.href='../../eMO/jsp/MODeceasedDtlsFrameset.jsp?menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NNNNN&desktopFlag=N' ;
			</script>
		<%
		}
			
		//if( counter==0)	{
			
			stat=con.createStatement();
			rs=stat.executeQuery("select count(*)  from MO_MORTUARY_REGN where PATIENT_ID='"+patient_id+"' and facility_id = '"+facility_id+"'");
	   
			int counter_1=0;
			while(rs.next()){
				counter_1=rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stat!=null)stat.close();

			if(counter_1>0){%>
				<script>
				
				parent.frames[0].document.forms[0].patient_id.value='';
				alert(getMessage('PATIENT_ALREADY_REGISTERED','MO'));
				parent.frames[0].document.forms[0].patient_id.focus();
				
				</script>

			<%}else{%>
				<script>
					var patient_id = '<%=patient_id%>'
					//var function_id = '<%=function_id%>'
					var function_id=parent.parent.commontoolbarFrame.document.forms[0].function_id.value;
					parent.frames[0].document.forms[0].patient_id.disabled=true;
					parent.frames[0].document.forms[0].patient_search.disabled=true;
					var external = '<%=external%>'	;
					parent.parent.frames[0].document.forms[0].apply.disabled=false;
					//self.location.href='../../eMO/jsp/MORegisterAttnResult.jsp?patient_id='+patient_id+'&function_id='+function_id
					
					self.location.href='../../eMO/jsp/MORegisterAttnResult.jsp?patient_id='+patient_id+'&function_id='+function_id+'&external='+external;</script>
		<%}
		
		//}

	
	}else{
	if(count==1)
	{
		
		
	%>
		<script>
		
		var patient_id = '<%=patient_id%>'
		//var function_id = '<%=function_id%>'
		var function_id=parent.parent.document.forms[0].function_id.value;
		parent.frames[0].document.forms[0].patient_id.disabled=true;
		parent.frames[0].document.forms[0].patient_search.disabled=true;
		var external = '<%=external%>'	;
		//self.location.href='../../eMO/jsp/MORegisterAttnResult.jsp?patient_id='+patient_id+'&function_id='+function_id
		parent.parent.frames[0].document.forms[0].apply.disabled=false;
		self.location.href='../../eMO/jsp/MORegisterAttnResult.jsp?patient_id='+patient_id+'&function_id='+function_id+'&external='+external;
		</script>

	<%}
	if(count==0){
		
		
		
			%>
			<script>
				parent.frames[0].document.forms[0].patient_id.value='';
				alert(getMessage('PATIENT_ALREADY_REGISTERED','MO'));
				parent.frames[0].document.forms[0].patient_id.focus();
			
			</script>
			<%
		
	}
}
}
/*Added by Thamizh selvi on 1st Aug 2017 for ML-MMOH-CRF-689 Start*/
if(dflag == 2){ 
	
	stat=con.createStatement();
	rs=stat.executeQuery("select count(*)  from MO_MORTUARY_REGN where PATIENT_ID='"+patient_id+"' and facility_id = '"+facility_id+"'");
	   
	int counter_1=0;
	while(rs.next()){
		counter_1=rs.getInt(1);
	}
	if(rs!=null) rs.close();
	if(stat!=null)stat.close();

	if(counter_1>0){%>
		<script>		
			parent.frames[0].document.forms[0].patient_id.value='';
			alert(getMessage('PATIENT_ALREADY_REGISTERED','MO'));
			parent.frames[0].document.forms[0].patient_id.focus();			
		</script>
	<%}else{%>
		<script>
			var patient_id	= '<%=patient_id%>'
			var calledFrom	= '<%=calledFrom%>';
			var function_id	= parent.parent.document.forms[0].function_id.value;
			parent.frames[0].document.forms[0].patient_id.disabled		= true;
			parent.frames[0].document.forms[0].patient_search.disabled	= true;
			var external = '<%=external%>'	;
			parent.parent.frames[0].document.forms[0].apply.disabled	= false;

			self.location.href='../../eMO/jsp/MORegisterAttnResult.jsp?patient_id='+patient_id+'&function_id='+function_id+'&calledFrom='+calledFrom+'&externalBidYn=Y&external='+external;
		</script>
	<%}
}/*End*/
}
     if(stat!=null) stat.close();
	if(rs!=null) rs.close();
	}	}
 
}
catch(Exception e){
  out.println("Exception in File MORegisterAttnValidations"+e.toString());
  e.printStackTrace();
  }
finally
{
	ConnectionManager.returnConnection(con,request);

}
%>

