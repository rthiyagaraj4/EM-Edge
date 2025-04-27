<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.net.URLEncoder"%>
<%
/*
-----------------------------------------------------------------------------------------
Date       		Edit History     	   Name        Rev.Date  		 Rev.By			Description
-----------------------------------------------------------------------------------------
07/08/2018	  	IN064543		Kamalakannan	07/08/2018		Ramesh G		ML-MMOH-CRF-0776
20/11/2018	  	ML-MMOH-SCF-1108	Kamalakannan	20/11/2018		Ramesh G		ML-MMOH-SCF-1108
------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>



<%
try{
	request.setCharacterEncoding("UTF-8");
	/* Mandatory checks start */
	//String mode			=	request.getParameter( "mode" ) ;
	//String function_id	=	request.getParameter( "function_id" ) ;
	String bean_id		=	"Or_OrderCatalog" ;
	//String bean_name	=	"eOR.OrderCatalogBean";

	boolean flag			=   false ;

	
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject( bean_id.trim(),"eOR.OrderCatalogBean",request) ;


	Hashtable hash		  = (Hashtable)xmlObj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );	
	//IN064543 start
	String action 			= bean.checkForNull((String)hash.get("action"), "");
	String lengthStr = null;	
	HashMap valuesFromBean = null;
	ArrayList rowValues = null;
	HashMap rowMap = null;
	int index = 0;
	
			if("INSERTINPUTS".equals(action)){
				flag = bean.instructionByAgeSync(hash);
				if(flag){
					//valuesFromBean = (HashMap)bean.getInstructionsRecStr().get(3);//commented for ML-MMOH-SCF-1108 
					valuesFromBean = (HashMap)bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
					String readOnly 			= bean.checkForNull((String)hash.get("readOnly"), "N");
					rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
					//rowValues = (ArrayList)valuesFromBean.get("records");//commented for ML-MMOH-SCF-1108 
					if(rowValues!=null){
						out.println("clearBeforeInsertion()");
						for(int start=0; start<rowValues.size();start++){
						HashMap rowValHash = (HashMap)rowValues.get(start);
						out.println("insertContentToRow('"+start+"','"+rowValHash.get("sex_spec_ind")+"','"+rowValHash.get("min_age_in_yrs")+"','"+rowValHash.get("min_age_in_mths")+"','"+rowValHash.get("min_age_in_days")+"','"+rowValHash.get("max_age_in_yrs")+"','"+rowValHash.get("max_age_in_mths")+"','"+rowValHash.get("max_age_in_days")+"')");
						}
					}
				}else{
					out.println("alert(getMessage('SEX_MAX_MIN_OVERLAP_CHK','OR'))");
				}
				putObjectInBean(bean_id,bean,request);
			}else if("ONLOADCONTENTS".equals(action)){
				//IN64543, starts
				String instructionType = bean.checkForNull((String)hash.get("instructionType"), "IS");
				String l_read_only = bean.checkForNull((String)hash.get("readOnly"), "N");
				
				if("IS".equals(instructionType))
				{
					//String pat_preps_or_instrns_free_fmt_is = (String)((HashMap)bean.getInstructionsRecStr().get(2)).get("pat_preps_or_instrns_free_fmt_is");//commented for ML-MMOH-SCF-1108 
					String pat_preps_or_instrns_free_fmt_is = (String)((HashMap)bean.getInstructionsRecStrClob()).get("pat_preps_or_instrns_free_fmt_is");//ML-MMOH-SCF-1108 
					if(pat_preps_or_instrns_free_fmt_is==null)
						pat_preps_or_instrns_free_fmt_is =  "";	
					//out.println("loadContentInEditor('"+pat_preps_or_instrns_free_fmt_is+"')");//IN64543
					out.println(pat_preps_or_instrns_free_fmt_is);////IN64543
				}//IN64543, starts
				else if("IM".equals(instructionType))
				{
					//valuesFromBean = (HashMap)bean.getInstructionsRecStr().get(3);//commented for ML-MMOH-SCF-1108 
					valuesFromBean = (HashMap)bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
					rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
					//rowValues = (ArrayList)valuesFromBean.get("records");//commented for ML-MMOH-SCF-1108 
				
					out.println("clearBeforeInsertion()");
					if(rowValues!=null)
					{
						for(int start=0; start<rowValues.size();start++)
						{
							HashMap rowValHash = (HashMap)rowValues.get(start);							
							out.println("insertContentToRow('"+start+"','"+rowValHash.get("sex_spec_ind")+"','"+rowValHash.get("min_age_in_yrs")+"','"+rowValHash.get("min_age_in_mths")+"','"+rowValHash.get("min_age_in_days")+"','"+rowValHash.get("max_age_in_yrs")+"','"+rowValHash.get("max_age_in_mths")+"','"+rowValHash.get("max_age_in_days")+"')");
						}//IN64543
					}
				}
				putObjectInBean(bean_id,bean,request);
			}else if("MODIFYINPUTS".equals(action)){
				int curr_index = Integer.parseInt(bean.checkForNull((String)hash.get("index"), ""));				
				hash.remove("instructionType");
				hash.remove("action");
				hash.remove("index");				
				valuesFromBean = (HashMap)bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				
				rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
				HashMap map = new HashMap();
				//Set keys = hash.keySet();//commented for ML-MMOH-SCF-1108 
				rowMap = (HashMap)rowValues.get(curr_index);//ML-MMOH-SCF-1108 
				Set keys = rowMap.keySet();//ML-MMOH-SCF-1108 
		        for(Object key: keys){
		        	map.put(key,rowMap.get(key));//ML-MMOH-SCF-1108 
		        }
		        
				rowValues.set(curr_index,map);
				if(rowValues!=null){
					out.println("clearBeforeInsertion();");
					for(int start=0; start<rowValues.size();start++){
					HashMap rowValHash = (HashMap)rowValues.get(start);					
					out.println("insertContentToRow('"+start+"','"+rowValHash.get("sex_spec_ind")+"','"+rowValHash.get("min_age_in_yrs")+"','"+rowValHash.get("min_age_in_mths")+"','"+rowValHash.get("min_age_in_days")+"','"+rowValHash.get("max_age_in_yrs")+"','"+rowValHash.get("max_age_in_mths")+"','"+rowValHash.get("max_age_in_days")+"')");
					}
				}
				putObjectInBean(bean_id,bean,request);
			}else if("GETROWVALUES".equals(action)){
				lengthStr =bean.checkForNull((String)hash.get("index"), "");
				int length = Integer.parseInt(lengthStr);
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				String l_read_only = bean.checkForNull((String)hash.get("readOnly"), "N");
				rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
				rowMap = (HashMap)rowValues.get(length);
				String sex_spec_ind = bean.checkForNull((String)rowMap.get("sex_spec_ind"), "");
				String min_age_in_yrs = bean.checkForNull((String)rowMap.get("min_age_in_yrs"), "");
				String min_age_in_mths = bean.checkForNull((String)rowMap.get("min_age_in_mths"), "");
				String min_age_in_days = bean.checkForNull((String)rowMap.get("min_age_in_days"), "");
				String max_age_in_yrs = bean.checkForNull((String)rowMap.get("max_age_in_yrs"), "");
				String max_age_in_mths = bean.checkForNull((String)rowMap.get("max_age_in_mths"), "");
				String max_age_in_days = bean.checkForNull((String)rowMap.get("max_age_in_days"), "");
				out.println("loadContentInRow('"+sex_spec_ind+"','"+min_age_in_yrs+"','"+min_age_in_mths+"','"+min_age_in_days+"','"+max_age_in_yrs+"','"+max_age_in_mths+"','"+max_age_in_days+"');");
				//out.println("closeEditorBoard()");//IN64543
				out.println("closeEditorBoard('"+l_read_only+"')");//IN64543
			}else if("GETCOMMENTS".equals(action)){
				lengthStr =bean.checkForNull((String)hash.get("index"), "-1");//ML-MMOH-SCF-1108 
				int length = Integer.parseInt(lengthStr);
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
				rowMap = (HashMap)rowValues.get(length);
				String pat_preps_or_instrns_free_fmt_im = bean.checkForNull((String)rowMap.get("pat_preps_or_instrns_free_fmt_im"), "");
				out.println(pat_preps_or_instrns_free_fmt_im);////IN64543
			}else if("CLEARVALUES".equals(action)){
				lengthStr =bean.checkForNull((String)hash.get("index"), "");
				int length = Integer.parseInt(lengthStr);
				//ML-MMOH-SCF-1108 start
				HashMap tempMap = (HashMap)bean.getInstructionsRecStr().get(3);
				ArrayList tempList = (ArrayList)tempMap.get("records");
				tempList.remove(length);
				if(tempList!=null){
					out.println("clearBeforeInsertion();");
					for(int start=0; start<tempList.size();start++){
					HashMap insideTempMap = (HashMap)tempList.get(start);
					out.println("insertContentToRow('"+start+"','"+insideTempMap.get("sex_spec_ind")+"','"+insideTempMap.get("min_age_in_yrs")+"','"+insideTempMap.get("min_age_in_mths")+"','"+insideTempMap.get("min_age_in_days")+"','"+insideTempMap.get("max_age_in_yrs")+"','"+insideTempMap.get("max_age_in_mths")+"','"+insideTempMap.get("max_age_in_days")+"')");
					}
				}
				//ML-MMOH-SCF-1108 end
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				((ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im")).remove(length);//ML-MMOH-SCF-1108 
				rowValues = ((ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im"));//ML-MMOH-SCF-1108 
				if(rowValues!=null){
					out.println("clearBeforeInsertion();");
					for(int start=0; start<rowValues.size();start++){
					HashMap rowValHash = (HashMap)rowValues.get(start);
					out.println("insertContentToRow('"+start+"','"+rowValHash.get("sex_spec_ind")+"','"+rowValHash.get("min_age_in_yrs")+"','"+rowValHash.get("min_age_in_mths")+"','"+rowValHash.get("min_age_in_days")+"','"+rowValHash.get("max_age_in_yrs")+"','"+rowValHash.get("max_age_in_mths")+"','"+rowValHash.get("max_age_in_days")+"')");
					}
				}
				out.println("clearValuesInAllEditors();closeEditorBoard();");
				putObjectInBean(bean_id,bean,request);
			}
			else if("AGE_SEX_CLEAR_ALL_VALUES".equals(action))//IN64543, starts
			{
				
				//ML-MMOH-SCF-1108 start
				HashMap tempMap = (HashMap)bean.getInstructionsRecStr().get(3);
				ArrayList tempList = (ArrayList)tempMap.get("records");
				if(tempList!=null)
					tempList.clear();
				//ML-MMOH-SCF-1108 end
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				String l_read_only = bean.checkForNull((String)hash.get("readOnly"), "N");
				rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
				//ML-MMOH-SCF-1108 start
				if(rowValues!=null)
					rowValues.clear();
				out.println("clearValuesInAllEditors();closeEditorBoard('"+l_read_only+"');");
				putObjectInBean(bean_id,bean,request);
			}else if("STD_INSTRN_CLEAR_ALL_VALUES".equals(action))//IN64543, starts STD_INSTRN_CLEAR_ALL_VALUES
			{
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				String l_read_only = bean.checkForNull((String)hash.get("readOnly"), "N");
				if(valuesFromBean.containsKey("pat_preps_or_instrns_free_fmt_is"))
				valuesFromBean.remove("pat_preps_or_instrns_free_fmt_is");
				out.println("clearValuesInAllEditors();closeEditorBoard('"+l_read_only+"');");
				putObjectInBean(bean_id,bean,request);
			}else if("CLEAR_ALL_EDITOR_VALUES".equals(action))//IN64543, starts STD_INSTRN_CLEAR_ALL_VALUES
			{
				valuesFromBean = bean.getInstructionsRecStrClob();//ML-MMOH-SCF-1108 
				String l_read_only = bean.checkForNull((String)hash.get("readOnly"), "N");
				if(valuesFromBean.containsKey("pat_preps_or_instrns_free_fmt_im")){
					rowValues = (ArrayList)valuesFromBean.get("pat_preps_or_instrns_free_fmt_im");//ML-MMOH-SCF-1108 
					if(rowValues!=null)
						rowValues.clear();
				}	
				if(valuesFromBean.containsKey("pat_preps_or_instrns_free_fmt_is")){
					valuesFromBean.remove("pat_preps_or_instrns_free_fmt_is");
				}
				//ML-MMOH-SCF-1108 end
				out.println("clearValuesInAllEditors();closeEditorBoard('"+l_read_only+"');");
				putObjectInBean(bean_id,bean,request);
			}//IN64543, ends
			else if("TEXT_AGE_SEX_CLEAR_ALL_VALUES".equals(action))//IN64543, starts
			{
				valuesFromBean = (HashMap)bean.getInstructionsRecStr().get(3);
				rowValues = (ArrayList)valuesFromBean.get("records");
				if(rowValues!=null)
					rowValues.clear();
				HashMap textValuesFromBean = (HashMap)bean.getInstructionsRecStr().get(2);
				if(textValuesFromBean!=null)
					textValuesFromBean.clear();	
				putObjectInBean(bean_id,bean,request);
			}//IN64543, ends
			else{//IN064543 end	
					try
					{
						
					  flag			      = bean.instructionByAgeSync(hash);
						//System.out.println("##########flag"+flag);
					}catch(Exception e){%>
					<script>alert("Exception thrown ...Chk in OrderCatalogInstructionSync.jsp"+"<%=e.getMessage()%>");</script>
				
					<%}
					//out.println("here================="+flag+ "");
					out.println("syncStatus(" + flag + ")");
					putObjectInBean(bean_id,bean,request);
			}//IN064543	
}catch(Exception e){
	System.out.println("Exp in OrderCatalogsync.jsp"+e.getMessage());
	e.printStackTrace();
}
%>
