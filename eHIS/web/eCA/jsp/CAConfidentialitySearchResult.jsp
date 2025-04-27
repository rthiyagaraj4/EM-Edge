<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
12/12/2013	  IN042552		 Karthi L	 To maintain Patient's event confidentiality at Practitioner, Speciality and Responsibility level (Bru-HIMS-CRF-391)
--------------------------------------------------------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, eCommon.Common.*,java.net.URLEncoder, eCA.* ,eOR.Common.*, eOR.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String callFrom        = CommonBean.checkForNull(request.getParameter( "callFrom" ) ) ;
%>
<html>
    <head>
        <title></title>
		<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
        <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
        <script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
        <script language="Javascript" src="../../eCommon/js/CommonLookup.js"></script>
        <script language='javascript' src='../../eCA/js/ConfidentialitySetUpHeader.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()' >
<form name='confidentiality_search_result' id='confidentiality_search_result'  method='post' >
<%
    try{
		//Search Criteria's from Query Criteria page
		String sqlData         	= CommonBean.checkForNull(request.getParameter( "sqlData" ) );
		String searchCriteria  	= CommonBean.checkForNull(request.getParameter( "sc" ) ) ;
		String linkFields      	= CommonBean.checkForNull(request.getParameter( "linkFields" ) ) ;
		String displayOrder    	= CommonBean.checkForNull(request.getParameter( "displayOrder" ) ) ;
		String searchCode	   	= request.getParameter("search_code")==null?"":request.getParameter("search_code");
		String confidnt_type	= request.getParameter("confidnt_type")==null?"":request.getParameter("confidnt_type");
		String radioval			= request.getParameter("radioval")==null?"":request.getParameter("radioval");
		String l_hist_rec_type 	= request.getParameter("p_hist_rec_type")==null?"":request.getParameter("p_hist_rec_type");
		String l_search_by 		= request.getParameter("p_search_by")==null?"":request.getParameter("p_search_by");
		String l_search_value	= request.getParameter("p_search_txt")==null?"":request.getParameter("p_search_txt");
		String l_filter_		= request.getParameter("p_filter_")==null?"":request.getParameter("p_filter_");	
		if(searchCode == null || searchCode.equals("")){
			searchCode = confidnt_type;
		}
		
		String callingFromSearchResult	   	= request.getParameter("callingFromSearchResult")==null?"":request.getParameter("callingFromSearchResult");
		
		String l_bean_id		= "Ca_confidentialitySetUpBean";
		String l_bean_name		= "eCA.CAConfidentialitySetUpBean";
		String based_on_title =  null;
		String code_desc	= null;
		String view_list_title	= null;
		String view_by_title		= null;
		String desc_desc	= null;
		String from= "", to ="";
		int row_disp=14;
		String confdntKey = "";
		CAConfidentialitySetUpBean beanObj = (CAConfidentialitySetUpBean)getBeanObject(l_bean_id, l_bean_name, request);
		
		HashMap confdntHashMap = beanObj.getConfidentialityMapData();
		
		int selectedDataCount = 0;
		String selectedRecordCount = "";
		
		if(confdntHashMap != null){
			selectedDataCount = confdntHashMap.size();
			selectedRecordCount = String.valueOf(selectedDataCount);
		}
		
		
		if(searchCode.equals("P")){
			//code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
			desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
			view_list_title	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewList.label","ca_labels");
		}
		else if(searchCode.equals("S")){
			//code_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Specialty.label","common_labels");
			code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
			desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
			based_on_title	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.basedon.label","ca_labels");
			view_by_title	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewBy.label","ca_labels");
		}
		else if(searchCode.equals("R")){
			//code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels");
			code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
			desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
			view_list_title	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewList.label","ca_labels");
		}
		else {
			code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
			desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		}
		
		String select_code	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Select.label","common_labels");
		Enumeration paramnames = request.getParameterNames() ;

		int count = 0;
		String str = "";
		while( paramnames.hasMoreElements() ) {
			str = (String)paramnames.nextElement() ;
			if( str.equals( "from" ) || str.equals( "to" ) || str.equals( "searched" ) || str.equals( "sc" ) || str.equals( "linkFields" ) || str.equals( "displayOrder" ) || str.equals( "callFrom" ) )
				continue;
			count ++;
		}
		boolean searched    = request.getParameter( "searched" ) == null ? false : true  ;
		
		int start = 0 ;
		int end = 0 ;
		int fm_disp=0, to_disp=0;
		int start_int;
		int to_int;

		from			=	request.getParameter( "from" ) ;
		to				=	request.getParameter( "to" ) ;

		if ( from == null || from=="null" || from.equals("null") )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null || to =="null" || to.equals("null") )
			end = row_disp;//7 ;
		else
			end = Integer.parseInt( to ) ;
		
		String classvalue           = "" ;
	    HashMap sqlMap = new HashMap();
	    //include all the common parameters.
	    sqlMap.put( "sqlData", sqlData );
	    //Function Parameters
	    HashMap funcMap = new HashMap();
	    //The fields are going to be display
	    ArrayList displayFields = new ArrayList();

	    if( displayOrder.equals("CODE_DESC") ) {
	        displayFields.add( "code" );
	        displayFields.add( "description" );
	    } else {
	        displayFields.add( "description" );
	        displayFields.add( "code" );
	    }
	    ArrayList chkFields = new ArrayList();
	  
		String val_param1 = "";
		String val_param = "";
		
		if(radioval.equals("C"))
		{	
			val_param1 = "%";
			if(l_search_by.equals("S"))
			{
				val_param = l_search_value + "%";
			}
			else if(l_search_by.equals("C")){
				val_param = "%"+l_search_value+"%";
			}
			else if(l_search_by.equals("E")){
				val_param = "%"+l_search_value;
			}
		}	
		else if(radioval.equals("D"))
		{	
			val_param = "%";
			if(l_search_by.equals("S"))
			{
				val_param1 = l_search_value + "%";
			}
			else if(l_search_by.equals("C")){
				val_param1 = "%"+l_search_value+"%";
			}
			else if(l_search_by.equals("E")){
				val_param1 = "%"+l_search_value;
			}
		}
		
		chkFields.add(val_param);
		chkFields.add(val_param1);

		/*
		if(l_hist_rec_type.equals("LBIN") && !l_filter_.equals("E"))
		{
			chkFields.add(val_param);
			chkFields.add(val_param1);
		}
		*/
		// Adding function related array list into the HashMap
	    funcMap.put( "displayFields", displayFields );
	    funcMap.put( "chkFields", chkFields );
	    funcMap.put( "searchCriteria", searchCriteria );
		
		//Calling the Result from Common Adaptor as a arraylist.

		ArrayList result = (ArrayList) beanObj.getQueryResultPage(pageContext,sqlMap, funcMap, request, true,Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") ) );
	    
		if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
%>
	        <table cellpadding=0 cellspacing=0 width="100%" align="center">
	            <tr>
		            <td width="20%" class="white">&nbsp;</td>  
		            <td width="30%" class="white">&nbsp;</td>    
		            <td width="30%" class="white">&nbsp;</td>    
		            <td width="20%" class="white">&nbsp;</td> 
<%
					// For display the previous/next link
					out.println(result.get(1));
%>
	         	</tr>
	        </table>
	
	        <table border="0" cellpadding="3" cellspacing="0" width="100%" align="center" id="ResultTab">
				
			<th width = '22%'> <%=code_desc%></th> <% if(searchCode.equals("P") || searchCode.equals("R")) {%> <th width = '38%'><%=desc_desc%></th> <th width = '25%'><%=view_list_title%></th> <%}else if(searchCode.equals("S")) {%> <th width = '30%'><%=desc_desc%></th><th width = '19%'><%=based_on_title%></th> <th width = '16%'><%=view_by_title%></th><%} else { %> <th width = '50%'><%= desc_desc %></th> <% } %><th width = '15%'><%=select_code %></th>
	        		
	        		<input type="hidden" name ="confidnt_type" value="<%=searchCode%>">
					<input type="hidden" name = "selectedDataCount" value="">
	        		<input type="hidden" name ="callingFromSearchResult" value="search_result">
	        		<input type="hidden" name ="conf_hashmap_data" value="<%=confdntHashMap%>">
	        		
	        <%
	           	 	//Retriving the records from result arraylist
	            	ArrayList records=new ArrayList();
					String link_columns = null;
					ArrayList privilegeList = null;
					Object objectList  = null;
					String retval="";
					String priviliege_type1 = "";
					String priviliege_type2 = "";
					String priviliege_type3 = "";
					String priviliege_type4 = "";
					String priviliege_type5 = "";
					String priviliege_type6 = "";
					String priviliege_type7 = "";
					String priviliege_type8 = "";
					String checkBoxStatus	= "";

	            	for(int recCount=2; recCount<result.size(); recCount++) {
		                if ( recCount % 2 == 0 )
		                    classvalue = "gridData" ;
		                else
		                    classvalue = "gridData" ;
	        %>
	            <tr>  
	        <%
					link_columns = linkFields ;
					records=(ArrayList) result.get( recCount );
					retval="";
					priviliege_type1 = "";
					priviliege_type2 = "";
					priviliege_type3 = "";
					priviliege_type4 = "";
					priviliege_type5 = "";
					priviliege_type6 = "";
					priviliege_type7 = "";
					priviliege_type8 = "";
					checkBoxStatus	= "";
	    			
	                for(int colCount=0; colCount<records.size(); colCount++){
	                    if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
	                    	confdntKey = (String)records.get( colCount -1);
	                    	privilegeList = new ArrayList();
	                    	if(confdntHashMap != null){ 
	                    		if(confdntHashMap.containsKey(confdntKey)) {
	                    			objectList = (Object)confdntHashMap.get(confdntKey);
	                    			privilegeList = (ArrayList)objectList;
	                    			for(int p=0; p<privilegeList.size();p++ ){
	                    				if(privilegeList.get(p).equals("M")){
	                    					priviliege_type1 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("Z")){
	                    					priviliege_type2 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("E")){
	                    					priviliege_type3 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("A")){
	                    					priviliege_type4 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("B") || privilegeList.get(p).equals("LB")){
	                    					priviliege_type5 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("P")){
	                    					priviliege_type6 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("S")){
	                    					priviliege_type7 = "SELECTED";	
	                    				} else if(privilegeList.get(p).equals("B") || privilegeList.get(p).equals("BB")){
	                    					priviliege_type8 = "SELECTED";	
	                    				}
	                    			}
	                    			checkBoxStatus = "checked";
	                    		}
	                    	}
	        %>				<input type="hidden" name = "result_data_code_<%=start%>"  value="<%=(String)records.get( colCount -1)%>">
	        				
								<td name = 'reslut_data_desc_<%=start%>'  class="<%=classvalue%>" ><%=(String)records.get( colCount )%> </td>
							<% if(searchCode.equals("P") || searchCode.equals("R")) {%> 
		                        <td style = 'color:black;font-size:9pt;font-weight:normal;text-align:center;border-bottom:1px;border-style:solid;border-color:#EEEEEE;border-top:0px;border-left:0px;border-right:0px;' >
		                         	<select name='view_list_data_<%=start%>' id='view_list_data_<%=start%>'  onchange = 'changeSelectedData(this,<%=start %>)'>
										<option value = "M" <%=priviliege_type1%> ><fmt:message key="eCA.SelfRelated.label" bundle="${ca_labels}"/></option>
										<option value = "Z" <%=priviliege_type2%> ><fmt:message key="eCA.AllPatients.label" bundle="${ca_labels}"/></option>
									</select>
								</td>	
							<%} else if(searchCode.equals("S")) {%>
								<td style = 'color:black;font-size:9pt;font-weight:normal;text-align:center;border-bottom:1px;border-style:solid;border-color:#EEEEEE;border-top:0px;border-left:0px;border-right:0px;'  >
		                         	<select name='based_on_data_<%=start%>' id='based_on_data_<%=start%>'  onchange = 'changeSelectedData(this,<%=start %>)'>
										<option value = "E" <%=priviliege_type3%> ><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></option>
										<option value = "A" <%=priviliege_type4%> ><fmt:message key="eCA.authorizedorordered.label" bundle="${ca_labels}"/></option>
										<option value = "B" <%=priviliege_type5%> ><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
									</select>
								</td>
								<td   name='view_by_data_<%=recCount%>' style = 'color:black;font-size:9pt;font-weight:normal;text-align:center;border-bottom:1px;border-style:solid;border-color:#EEEEEE;border-top:0px;border-left:0px;border-right:0px;' >
		                         	<select name='view_by_data_<%=start%>' id='view_by_data_<%=start%>' onchange = 'changeSelectedData(this,<%=start %>)' >
										<option value = "P" <%=priviliege_type6%> ><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/></option>
										<option value = "S" <%=priviliege_type7%> ><fmt:message key="eCA.secondaryspeciality.label" bundle="${ca_labels}"/></option>
										<option value = "B" <%=priviliege_type8%> ><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
									</select>
								</td> 
							<% } else {%>
							
							<% } %>
	                        <td style = 'color:black;font-size:9pt;font-weight:normal;text-align:center;border-bottom:1px;border-style:solid;border-color:#EEEEEE;border-top:0px;border-left:0px;border-right:0px;'  >
	                        	<input type='checkbox' name='ctrlChkBox<%=start%>' id='ctrlChkBox<%=start%>' id = ='ctrlChkBox<%=start%>'  onClick="ctrlChkBox(this,<%=start %>)" <%= checkBoxStatus  %>></td>
	                   
	        <%  		
	        			}else{  %> 
	        				
	        				<% //if(searchCode.equals("E")) {%>
	                       		<td class="<%=classvalue%>" name = 'result_data_<%=start%>' ><%=(String)records.get( colCount )%></td> 
	        <%				//} 
	                    } 
	                    %> 
	                    <%
	    				retval=retval+"~"+(String)records.get( colCount );
	                    
	                } start++;
	        %>		<input type="hidden" name ="hd_<%=recCount%>" value="<%=retval%>">
			        </tr>
	        <%		
	            }
	        %>
	            </table>
	       <%
	            out.flush();
	        } else {	
	        %>
	            <script>
	            	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	            </script>
	           
	    <%
	    }           
	    out.println(beanObj.setForm ( request ,"CAConfidentialitySearchResult.jsp", searched) );	
	    sqlMap.clear();
		funcMap.clear();
		displayFields.clear();
		chkFields.clear();
		result.clear();
  
} catch(Exception e) {
  //  out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
	System.out.println("CAConfidentialitySearchResult.jsp,341,message=>"+e.getMessage());
	e.printStackTrace();
}

%>

 </form>
</body>
</html>
    
    

