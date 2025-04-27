<!DOCTYPE html>
  <!--This file is saved on 07/11/2005-->

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<html>
	<%
		request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
 
	    String lStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
	%>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=lStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/DisDataCharting.js"></script>
	<Script src="../../eCommon/js/locale.js" language="JavaScript"></Script>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<!-- <body CLASS="MESSAGE"> -->
<body onMouseDown="" onKeyDown="lockKey()" CLASS="MESSAGE"> 
<%

	String bean_id					= "DisDataChartingBean"+(String)request.getParameter("episode_id");
	String bean_name				= "ePH.DisDataChartingBean";

	DisDataChartingBean beanObj = ( DisDataChartingBean )getBeanObject(bean_id,bean_name,request) ;
	beanObj.setLanguageId(locale);

	java.util.Properties p = (java.util.Properties) session.getValue("jdbc") ;
//	String locale		= (String) p.getProperty("LOCALE");
	String sStyle =	 "";	
	String operatingfacilityid = "";         
	String accessionnum = "";                  
	String episodetype = "";                   
	String episodeid = "";                     
	String visitid = "";                       
	String clinicianid = "";        
	String locncode = "";
	String patientid = "";
	String discrmsrid = ""; 
	String discrmsrresultnum = "";           
	String discrmsrresultnumuom = "";       
	String discrmsrresultstr = "";           
	String discrmsrresultdata = "";          
	String normallow = "";                     
	String normalhigh = "";                    
	String criticallow = "";                   
	String criticalhigh = "";   
	String discrmsrresulttype = "";
	String admdttime = "";
	String defdata = "";
	String normabnormind = "";
	String batteryid = "";
	String Sdate = "";
	String inError="";
	String inReplace="";
	String errorRemarks="";
	String client_ip_address="";
	String location_type ="";
	String module_id="";
	int rowcount=1;
	int noofrec = 0;
	int outrec = 0;
	int noofvals = 15;
	String temp_outrec=outrec+"";
	String temp_noofvals=noofvals+"";
			
	String finalvalues[][] = null ;

	sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	try
	{
		Sdate=request.getParameter("sys_date_time");
		patientid = request.getParameter("patient_id");	
		clinicianid = request.getParameter("clinician_id");
		locncode = request.getParameter("locn_code")==null?"":request.getParameter("locn_code");
		episodetype = request.getParameter("patient_class");

		episodeid = request.getParameter("episode_id");    
		visitid = request.getParameter("visit_id")==null?"1":request.getParameter("visit_id");       
		operatingfacilityid = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		admdttime = request.getParameter("adm_dt_time")==null?"":request.getParameter("adm_dt_time");
		inError = request.getParameter("in_error")==null?"":request.getParameter("in_error");
		inReplace =request.getParameter("in_replace")==null?"":request.getParameter("in_replace");
		client_ip_address = p.getProperty("client_ip_address");
		location_type = (request.getParameter("location_type")==null)?"":request.getParameter("location_type");
		module_id =request.getParameter("module_id")==null?"":request.getParameter("module_id"); 	

		batteryid =request.getParameter("battery_id")==null?"":request.getParameter("battery_id"); 
		noofrec = Integer.parseInt(request.getParameter("no_of_rec")==null?"":request.getParameter("no_of_rec"));
		outrec = noofrec+1;
		temp_outrec=outrec+"";
		finalvalues =  new String[outrec][noofvals];
		String flag="";	

		for(rowcount=1; rowcount<=noofrec;rowcount++)
		{
			int colcount = 0;
			errorRemarks=request.getParameter("remarks"+String.valueOf(rowcount-1))==null?"":request.getParameter("remarks"+String.valueOf(rowcount-1));  
			discrmsrid = request.getParameter("item_id_"+String.valueOf(rowcount));
			discrmsrresulttype = request.getParameter("result_type_"+String.valueOf(rowcount))==null?"":request.getParameter("result_type_"+String.valueOf(rowcount));

			if(discrmsrresulttype.equals("N") || discrmsrresulttype.equals("I"))
			{
					discrmsrresultnum = request.getParameter("str_id_"+String.valueOf(rowcount))==null?"":request.getParameter("str_id_"+String.valueOf(rowcount));
					discrmsrresultnumuom = request.getParameter("uom_id_"+String.valueOf(rowcount))==null?"":request.getParameter("uom_id_"+String.valueOf(rowcount)); 
					normallow = request.getParameter("normal_low_"+String.valueOf(rowcount))==null?"":request.getParameter("normal_low_"+String.valueOf(rowcount));                        
					normalhigh = request.getParameter("normal_high_"+String.valueOf(rowcount))==null?"":request.getParameter("normal_high_"+String.valueOf(rowcount));                      
					criticallow = request.getParameter("num_crit_low_"+String.valueOf(rowcount))==null?"":request.getParameter("num_crit_low_"+String.valueOf(rowcount));                        
					criticalhigh = request.getParameter("num_crit_high_"+String.valueOf(rowcount))==null?"":request.getParameter("num_crit_high_"+String.valueOf(rowcount));                       
					if(normallow.equals("")) normallow = "0";
					if(normalhigh.equals("")) normalhigh = "0";
					if(criticallow.equals("")) criticallow = "0";
					if(criticalhigh.equals("")) criticalhigh = "0";
					discrmsrresultdata = "";
			}
			else if(discrmsrresulttype.equals("L") || discrmsrresulttype.equals("C"))
			{
					discrmsrresultstr = request.getParameter("str_id_"+String.valueOf(rowcount))==null?"":request.getParameter("str_id_"+String.valueOf(rowcount));           
					discrmsrresultnum = "";
					discrmsrresultnumuom = "";
					discrmsrresultdata = "";
			}
			else if(discrmsrresulttype.equals("F"))
			{
					discrmsrresultdata = request.getParameter("str_id_"+String.valueOf(rowcount))==null?"":request.getParameter("str_id_"+String.valueOf(rowcount));        
					discrmsrresultnum = "";
					discrmsrresultnumuom = "";
			}
			else
			{
					discrmsrresultstr = request.getParameter("str_id_"+String.valueOf(rowcount))==null?"":request.getParameter("str_id_"+String.valueOf(rowcount));           
					discrmsrresultnum = "";
					discrmsrresultnumuom = "";
					discrmsrresultdata = "";
			}
					
			accessionnum= request.getParameter("accession_num_"+String.valueOf(rowcount))==null?"":request.getParameter("accession_num_"+String.valueOf(rowcount));                        
			defdata = request.getParameter("def_data_"+String.valueOf(rowcount))==null?"":request.getParameter("def_data_"+String.valueOf(rowcount));
			normabnormind = "";

			if(discrmsrresulttype.equals("N") || discrmsrresulttype.equals("I")){
				discrmsrresultstr = "";
				if(!discrmsrresultnum.equals(""))	{
					double n = Double.parseDouble(discrmsrresultnum);
					if(!(normallow.equals("") && criticallow.equals(""))){
						double l = Double.parseDouble(normallow);
						double c = Double.parseDouble(criticallow);

						if(l!=0.0 && n<l) 	normabnormind = "L";
						if(c!=0.0 && n< c) normabnormind = "K";
					}
					if(!(normalhigh.equals("") && criticalhigh.equals(""))){
						double h = Double.parseDouble(normalhigh);
						double c = Double.parseDouble(criticalhigh);

						if(h!=0.0 && n > h) normabnormind = "H";
						//if(c!=0.0 && n>c) normabnormind = "I";
						if(c!=0.0 && n>c) normabnormind = "M";
					}
				}
			}
			discrmsrresultdata+=defdata;
			if(discrmsrresulttype.equals("L") && !discrmsrresultstr.equals(""))
					normabnormind = request.getParameter("norm_abnorm_ind_"+String.valueOf(rowcount))==null?"":request.getParameter("norm_abnorm_ind_"+String.valueOf(rowcount)); 
			if(discrmsrresulttype.equals("C"))
				if(discrmsrresultstr.equals("")) discrmsrresultstr = "N";

			String operation = request.getParameter("op_type_"+String.valueOf(rowcount));

			finalvalues[rowcount][colcount++] = accessionnum;                 
			finalvalues[rowcount][colcount++] = discrmsrid;   
			finalvalues[rowcount][colcount++] = discrmsrresulttype;
			finalvalues[rowcount][colcount++] = discrmsrresultnum;         
			finalvalues[rowcount][colcount++] = discrmsrresultnumuom; 
			finalvalues[rowcount][colcount++] = discrmsrresultstr;           
			finalvalues[rowcount][colcount++] = discrmsrresultdata;        
			finalvalues[rowcount][colcount++] = normallow;                        
			finalvalues[rowcount][colcount++] = normalhigh;                      
			finalvalues[rowcount][colcount++] = criticallow;                        
			finalvalues[rowcount][colcount++] = criticalhigh;                       
			finalvalues[rowcount][colcount++] = normabnormind;
			finalvalues[rowcount][colcount++] = operation;
			finalvalues[rowcount][colcount++] = errorRemarks;
		} 

		HashMap results = new HashMap();
		//(java.util.HashMap)(busObj.getClass().getMethod("operateDisDataCharting",paramArray)).invoke(busObj,argArray);
		//(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		//boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

		results = beanObj.operateDisDataCharting( p,operatingfacilityid,episodetype,episodeid,visitid,clinicianid,locncode,patientid,batteryid,Sdate,finalvalues,admdttime,temp_outrec,temp_noofvals,client_ip_address,location_type,module_id,inError,inReplace );

		boolean inserted = (Boolean)results.get("status");
		String error = (String)results.get("error") ;
		//out.println(error);
		//out.println(results);
		//results.clear();
		out.println("<script>alert('"+error+"');</script>");

		if(inserted)	
			out.println("<script>window.close();</script></BODY></html>");
	}
	catch ( Exception e ) {
		e.printStackTrace();
   }
%>
</body>
</html>

