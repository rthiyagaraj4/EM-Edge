<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>


<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<%
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='testform' id='testform'>");
    //String	facilityId 	= (String) session.getValue( "facility_id" ) ;
	String criteria		= request.getParameter("criteria");
   // String refres		= "";
	if(	criteria ==  null ) 
		criteria="";
	//int chkotr		=	0;
	String selclaim	= 	"";
	selclaim = request.getParameter("selclaim");
	if(selclaim ==  null) selclaim="";
	String patient_id	= request.getParameter("patient_id");
	String cmgfrmbdypart	= request.getParameter("cmgfrmbdypart");
	String locale=(String)session.getAttribute("LOCALE"); 
	
	if(patient_id ==  null) patient_id="";
	Connection con 				= null;
	PreparedStatement pstmt4	= null;
	Statement st				= null;
	
	ResultSet rs4				= null; 
	String ID4					= "";
	String dat4					= "";
	
	try{

  con = ConnectionManager.getConnection(request);
	if(criteria.equals("populateClaim"))
		{
	//if (!(selclaim == null || selclaim.equals("")))
	//{
		String claimcode=request.getParameter("cliamcode");		
		if(claimcode==null)claimcode="";
		%>
 <script>
	var frameref;
	if('<%=cmgfrmbdypart%>'=="cmgfrmbdypart")
	{
      frameref=parent.frames[3]
		 
	}else if('<%=cmgfrmbdypart%>'=="cmgfrmreleasedeas")
	{
	frameref=parent.frames[0]
	}else
	{
	frameref=parent.frames[3]
	}

	var n = frameref.document.forms[0].CLAIMANT_TYPE_CODE.length
	
 	
	for(var i=0;i<n;i++)
   frameref.document.forms[0].CLAIMANT_TYPE_CODE.remove("");	
	var temp = "";
	var temp1='----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
	var opt=frameref.document.createElement('OPTION');
	opt.text=temp1;
	opt.value=temp;
	
	frameref.document.forms[0].CLAIMANT_TYPE_CODE.add(opt);	
	frameref.document.forms[0].CLAIMANT_TYPE_CODE.options[0].selected = true;

</script> 
		<%
StringBuffer sql=new StringBuffer();		
sql.append("select claimant_type_code,short_desc from mo_claimant_type_lang_vw where LANGUAGE_ID='"+locale+"' and      claimant_type=? and eff_status='E' order by 2");

//out.println("<script>alert(\""+sql.toString()+"\");</script>");
//out.println("<script>alert(\""+selclaim+"\");</script>");

pstmt4=con.prepareStatement(sql.toString());
pstmt4.setString(1,selclaim);
rs4=pstmt4.executeQuery();
		if(rs4!=null)
		{int i=0;
			while(rs4.next())
			{
			
				dat4 = rs4.getString("short_desc");
				ID4 = rs4.getString("claimant_type_code");	 
			
				
%>				 <script>
		
					var element = frameref.document.createElement('OPTION');
					element.text = "<%=dat4%>";
					element.value= "<%=ID4%>";
					

                   frameref.document.forms[0].CLAIMANT_TYPE_CODE.add(element);
	              frameref.document.forms[0].CLAIMANT_TYPE_CODE.value='<%=claimcode%>'
				 </script>
				
				<%
				i++;
				}
		}if(rs4!=null) rs4.close();	if(pstmt4!=null)pstmt4.close();
	//}
		}
	 
	 
	    if(pstmt4 != null)	pstmt4.close();
		if(st != null)	    st.close();
		if(rs4!= null)		rs4.close();
		}
	catch(Exception e){

		out.print("Exception in File GetClaim"+e.toString());
	}
	finally{
		
		
		ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
</html>

