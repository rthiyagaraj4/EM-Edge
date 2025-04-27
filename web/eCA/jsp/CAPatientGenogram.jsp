<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
20/09/2013  IN043482		Ramesh G		The added Medical History is not displayed in Genogram
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*,javax.naming.NamingEnumeration,javax.naming.InitialContext,javax.sql.DataSource,oracle.jdbc.pool.OracleDataSource,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page language="java" %>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%> 
<head> 
<meta http-equiv='cache-control' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta http-equiv='pragma' content='no-cache'>
<title>Genogram</title>
<script>
function patHistory(val,val1){
	var dialogHeight ='45' ;
	var dialogWidth = '88' ;
	var dialogTop	= '10';
	var dialogLeft = '10' ;
	var screen_width=screen.width;

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
	var arguments	= "";
	if(val!=''){
		window.showModalDialog("../../eCA/jsp/CAMainChart.jsp?lookupFileName=../../eCA/jsp/FlowSheet.jsp?option_id=FLOW_SHEET&locale=en&patient_id="+val+"&Patient_ID="+val+"&PGeno_Name="+val1+"&Genotitle=Y&function_display_name=Clinical Event History",arguments,features);		
	}
	
}
</script> 
<style type="text/css" media="print">

@media print {
  body {
    width: 1280
    height: 800
  }
  /* etc */
}
</style>


</head> 
<body > 
<TABLE align=center border="0" width = '100%'>
	<TR>
		<TD align="center">
			 <!--<DIV style="height: 100%;width: 100%;overflow: auto;"  > -->
			 <DIV style="height: 100%;width: 100%;">			
			<%
			// Current Generation
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale					=	(String) p.getProperty("LOCALE");
			
			int screenHeight=500;
			int screenWidth=1000;
			
			
			//4th Generation Details
				String patFFGrandFatherId	=	"";
				String patFFGrandMotherId	=	"";
				String patFMGrandFatherId	=	"";
				String patFMGrandMotherId	=	"";
				String patMFGrandFatherId	=	"";
				String patMFGrandMotherId	=	"";
				String patMMGrandFatherId	=	"";
				String patMMGrandMotherId	=	"";
				
			//4th Generations  Relation
				
				String patFFGrandFatherId_Wife_Relation	=	"";				
				String patFMGrandFatherId_Wife_Relation	=	"";				
				String patMFGrandFatherId_Wife_Relation	=	"";				
				String patMMGrandFatherId_Wife_Relation	=	""; 
				
			//3rd Generation				
				String patFGrandFatherId	= 	"";
				String patFGrandMotherId	=	"";
				String patMGrandFatherId	=	"";
				String patMGrandMotherId	=	"";	
			//3rd Generation  Details
				String patFGrandFatherFather_Childs	= 	"";
				String patFGrandMotherFather_Childs	=	"";
				String patMGrandFatherFather_Childs	=	"";
				String patMGrandMotherFather_Childs	=	"";
			//3rd Generations  Relation
				String patFFather_Mother_Relation	=	"";
				String patMFather_Mother_Relation	=	"";
				
			//2nd Generation	
				String patFatherId			=	"";
				String patMotherId 			=	"";
			//2nd Generation Details
				String patFGrandFather_Childs	= 	"";
				String patMGrandFather_Childs	=	"";
			//2nd Generation Relation
				String patFather_Mother_Relation	=	"";
			
			// Current Generation Details
				String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
				String patient_id_ = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");				
				//patient_id = "A07";
				String patFather_Childs			=	"";
				String patientFamily_Details	=	"";
				String patientFamily_Relations	=	"";
				
				String patientChilds		=	"";
				String patientTotalChilds	=	"";
				
			StringBuffer patientsDetails = new StringBuffer();			
			String patients_Details ="";
			StringBuffer esiRelationDetails = new StringBuffer();
			String esi_Details ="";
			StringBuffer mhRelationDetails = new StringBuffer();  //IN043482
			String mh_Details ="";								//IN043482
			ArrayList<String> draw_relations= new ArrayList<String>();
			StringBuffer draw_relationsDetails = new StringBuffer();  
			String drawRelationsDetails ="";								
			Connection conn=null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			  
			PreparedStatement pst1 = null;
			ResultSet rs1 = null;
			  
			PreparedStatement pst2 = null;
			ResultSet rs2 = null;
			
			try{
				conn = ConnectionManager.getConnection(request);				
				pst = conn.prepareStatement("SELECT NON_PATIENT_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE PATIENT_ID=?");//NEW
				pst.setString(1,patient_id);
				rs = pst.executeQuery();
				if(rs.next()){
				  patient_id	=	rs.getString("NON_PATIENT_ID")==null?"":(String)rs.getString("NON_PATIENT_ID");
				}else{
					patient_id="";
				}
				if(rs!=null)rs.close();
				if(pst!=null)pst.close();
				
				if(!"".equals(patient_id)){
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1,patient_id);
					rs = pst.executeQuery();
					if(rs.next()){
					  patFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();
					
					
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patFatherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patFGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patFGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();
					
					
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patMotherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patMGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patMGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();
					
					
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patFGrandFatherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patFFGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patFFGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();

					
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patFGrandMotherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patFMGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patFMGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();

					
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patMGrandFatherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patMFGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patMFGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();

				
					pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
					pst.setString(1, patMGrandMotherId);
					rs = pst.executeQuery();			  
					if(rs.next()){
					  patMMGrandFatherId	=	rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
					  patMMGrandMotherId	=	rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();
			//4th Genaration Reltion Details
					if((!"".equals(patFFGrandFatherId)) && (!"".equals(patFFGrandMotherId))){						
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patFFGrandFatherId);
						pst.setString(2, patFFGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patFFGrandFatherId_Wife_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");						
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					if((!"".equals(patFMGrandFatherId))&&(!"".equals(patFMGrandMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patFMGrandFatherId);
						pst.setString(2, patFMGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patFMGrandFatherId_Wife_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					if((!"".equals(patMFGrandFatherId))&&(!"".equals(patMFGrandMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patMFGrandFatherId);
						pst.setString(2, patMFGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patMFGrandFatherId_Wife_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");						
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					if((!"".equals(patMMGrandFatherId))&&(!"".equals(patMMGrandMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patMMGrandFatherId);
						pst.setString(2, patMMGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patMMGrandFatherId_Wife_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");						
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
			//3rd Generation Details
					if(!"".equals(patFGrandFatherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patFGrandFatherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patFGrandFatherFather_Childs)){
												patFGrandFatherFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patFGrandFatherFather_Childs =patFGrandFatherFather_Childs +"|"+ rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									patFGrandFatherFather_Childs =patFGrandFatherId;
								}							
							}
							if(rs!=null)rs.close();
							if(pst!=null)pst.close();
						}
					}
					
					if(!"".equals(patFGrandMotherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patFGrandMotherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID  CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patFGrandMotherFather_Childs)){
												patFGrandMotherFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patFGrandMotherFather_Childs = patFGrandMotherFather_Childs + "|" + (rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID"));
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									
									patFGrandMotherFather_Childs =patFGrandMotherId;
								}
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					
					if(!"".equals(patMGrandFatherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patMGrandFatherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID  CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patMGrandFatherFather_Childs)){
												patMGrandFatherFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patMGrandFatherFather_Childs =patMGrandFatherFather_Childs +"|"+ rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									patMGrandFatherFather_Childs =patMGrandFatherId;
								}
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					
					if(!"".equals(patMGrandMotherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patMGrandMotherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patMGrandMotherFather_Childs)){
												patMGrandMotherFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patMGrandMotherFather_Childs =patMGrandMotherFather_Childs +"|"+ rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									patMGrandMotherFather_Childs =patMGrandMotherId;
								}
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					
			//3rd Generation Relation Ship
					
					if((!"".equals(patFGrandFatherId))&&(!"".equals(patFGrandMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patFGrandFatherId);
						pst.setString(2, patFGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patFFather_Mother_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					
					if((!"".equals(patMGrandFatherId))&&(!"".equals(patMGrandMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patMGrandFatherId);
						pst.setString(2, patMGrandMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patMFather_Mother_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
			
			//2nd Generation Details
					if(!"".equals(patFatherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patFatherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patFGrandFather_Childs)){
												patFGrandFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patFGrandFather_Childs =patFGrandFather_Childs +"|"+ (rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID"));
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									patFGrandFather_Childs =patFatherId;
								}
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					if(!"".equals(patMotherId)){
						pst = conn.prepareStatement("SELECT FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID=?");
						pst.setString(1, patMotherId);						
						rs = pst.executeQuery();
						if(rs!=null){
							if(rs.next()){
								String father_id= rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID");
								String mother_id= rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID");
								if(father_id!=null && !"".equals(father_id) && !"".equals(mother_id) && mother_id!=null){
									pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
									pst1.setString(1, father_id);
									pst1.setString(2, mother_id);
									rs1 = pst1.executeQuery();
									if(rs1 !=null){
										while(rs1.next()){
											if("".equals(patMGrandFather_Childs)){
												patMGrandFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
											}else{
												patMGrandFather_Childs =patMGrandFather_Childs +"|"+ (rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID"));
											}
										}
									}
									if(rs1!=null)rs1.close();
									if(pst1!=null)pst1.close();
								}else{
									patMGrandFather_Childs =patMotherId;
								}
							}
							if(rs!=null)rs.close();
							if(pst!=null)pst.close();
						}
					}
			//2nd Generation Relation
					if((!"".equals(patFatherId))&&(!"".equals(patMotherId))){
						pst = conn.prepareStatement("SELECT RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? AND TO_GENOID=?");
						pst.setString(1, patFatherId);
						pst.setString(2, patMotherId);
						rs = pst.executeQuery();			  
						if(rs.next()){
								patFather_Mother_Relation	=	rs.getString("RELATION_ID")==null?"":(String)rs.getString("RELATION_ID");
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
			//Current Generation
					if(patFatherId!=null && !"".equals(patFatherId) && !"".equals(patMotherId) && patMotherId!=null){
						pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?)");
						pst1.setString(1, patFatherId);
						pst1.setString(2, patMotherId);
						rs1 = pst1.executeQuery();
						if(rs1 !=null){
							while(rs1.next()){
								if("".equals(patFather_Childs)){
									patFather_Childs = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
								}else{
									patFather_Childs =patFather_Childs +"|"+ (rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID"));
								}
							}
						}
						if(rs1!=null)rs1.close();
						if(pst1!=null)pst1.close();
					}else{
						patFather_Childs =patMotherId;
					}
					
					
					pst = conn.prepareStatement("SELECT TO_GENOID,DECODE(RELATION_ID,'MA','0','1') SRLNO, RELATION_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='COUPLE' AND FROM_GENOID=? ORDER BY SRLNO"); 
					pst.setString(1, patient_id);
					rs = pst.executeQuery();
					int pfamilCount=0;
					if(rs !=null){
						while(rs.next()){
							if("".equals(patientFamily_Details)){
								patientFamily_Details = rs.getString("TO_GENOID")==null?"":(String)rs.getString("TO_GENOID"); 
							}else{
								patientFamily_Details =patientFamily_Details +"|"+ (rs.getString("TO_GENOID")==null?"":(String)rs.getString("TO_GENOID")); 
							}						
							
														
							if("".equals(patientFamily_Relations)){
								patientFamily_Relations = (String)rs.getString("RELATION_ID"); 
								draw_relations.add((String)rs.getString("RELATION_ID"));
							}else{
								patientFamily_Relations =patientFamily_Relations +"|"+ (String)rs.getString("RELATION_ID"); 
								draw_relations.add((String)rs.getString("RELATION_ID"));
							}	
							pfamilCount++;
							
							
							pst1 = conn.prepareStatement("SELECT TO_GENOID CHILD_ID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=? AND TO_GENOID IN(SELECT TO_GENOID FROM CA_GENOGRAM_RELATION WHERE RELATION_TYPE_ID='CHILD' AND FROM_GENOID=?) ORDER BY SIBLNG_POS"); 
							pst1.setString(1, patient_id);
							pst1.setString(2, (String)rs.getString("TO_GENOID")); 
							rs1 = pst1.executeQuery();
							String vicChild_="";
							if(rs1 !=null){
								while(rs1.next()){
									if("".equals(vicChild_)){
										vicChild_ = rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID");
									}else{
										vicChild_ =vicChild_ +"|"+ (rs1.getString("CHILD_ID")==null?"":(String)rs1.getString("CHILD_ID"));
									}
								}
								if("".equals(patientTotalChilds)){
									patientTotalChilds = vicChild_;
								}else{
									patientTotalChilds	= patientTotalChilds+"|"+vicChild_;
								}
								if(!"".equals(vicChild_)){
									if("".equals(patientChilds)){
										patientChilds = patient_id+"-"+(String)rs.getString("TO_GENOID")+"~"+vicChild_;
									}else{
										patientChilds =patientChilds +"^"+ patient_id+"-"+(String)rs.getString("TO_GENOID")+"~"+vicChild_;
									}
								}
							}
							if(rs1!=null)rs1.close();
							if(pst1!=null)pst1.close();
							
							
						}
					}
					if(rs!=null)rs.close();
					if(pst!=null)pst.close();
					
					screenHeight = screenHeight+(150*(pfamilCount-1));
					ArrayList totalList = new ArrayList();
					if(!"".equals(patient_id))
						totalList.add(patient_id);
					if(!"".equals(patFFGrandFatherId))
						totalList.add(patFFGrandFatherId);
					if(!"".equals(patFFGrandMotherId))
						totalList.add(patFFGrandMotherId);
					if(!"".equals(patFMGrandFatherId))
						totalList.add(patFMGrandFatherId);
					if(!"".equals(patFMGrandMotherId))
						totalList.add(patFMGrandMotherId);
					if(!"".equals(patMFGrandFatherId))
						totalList.add(patMFGrandFatherId);
					if(!"".equals(patMFGrandMotherId))
						totalList.add(patMFGrandMotherId);
					if(!"".equals(patMMGrandFatherId))
						totalList.add(patMMGrandFatherId);
					if(!"".equals(patMMGrandMotherId))
						totalList.add(patMMGrandMotherId);
					ArrayList childArraylist = new ArrayList();
						if(!"".equals(patFGrandFatherFather_Childs))
							childArraylist.add(patFGrandFatherFather_Childs);
						if(!"".equals(patFGrandMotherFather_Childs))
							childArraylist.add(patFGrandMotherFather_Childs);
						if(!"".equals(patMGrandFatherFather_Childs))
							childArraylist.add(patMGrandFatherFather_Childs);
						if(!"".equals(patMGrandMotherFather_Childs))
							childArraylist.add(patMGrandMotherFather_Childs);
						if(!"".equals(patFGrandFather_Childs))
							childArraylist.add(patFGrandFather_Childs);
						if(!"".equals(patMGrandFather_Childs))
							childArraylist.add(patMGrandFather_Childs);
						if(!"".equals(patFather_Childs))
							childArraylist.add(patFather_Childs);
						if(!"".equals(patientFamily_Details))
							childArraylist.add(patientFamily_Details);
						if(!"".equals(patientTotalChilds))
							childArraylist.add(patientTotalChilds);
						//childArraylist.add();
						//childArraylist.add();
					if(!"".equals(patFFGrandFatherId_Wife_Relation))
							draw_relations.add(patFFGrandFatherId_Wife_Relation);
					if(!"".equals(patFMGrandFatherId_Wife_Relation))
							draw_relations.add(patFMGrandFatherId_Wife_Relation);
					if(!"".equals(patMFGrandFatherId_Wife_Relation))
							draw_relations.add(patMFGrandFatherId_Wife_Relation);
					if(!"".equals(patMMGrandFatherId_Wife_Relation))
							draw_relations.add(patMMGrandFatherId_Wife_Relation);
					if(!"".equals(patFFather_Mother_Relation))
							draw_relations.add(patFFather_Mother_Relation);
					if(!"".equals(patMFather_Mother_Relation))
							draw_relations.add(patMFather_Mother_Relation);
					if(!"".equals(patFather_Mother_Relation))
							draw_relations.add(patFather_Mother_Relation);
			
					for(int i=0;i<childArraylist.size();i++){					
						String[] tempChildIds = ((String)childArraylist.get(i)).split("\\|");
						for(int j=0;j<tempChildIds.length;j++){						
							totalList.add(tempChildIds[j]);
						}
					}
					StringBuffer totalListbf= new StringBuffer();
					for(int k=0;k<totalList.size();k++){
						totalListbf.append("'"+((String)totalList.get(k))+"'");
						if(k!=(totalList.size())-1)
							totalListbf.append(",");
					}
					
					if(!"".equals(totalListbf.toString())){
						//pst = conn.prepareStatement("SELECT PATIENT_ID,PATIENT_NAME,SEX,SM_CONVERT_DATE_2T(DATE_OF_BIRTH,?) DATE_OF_BIRTH,DECESED_YN,MARRIED_YN,FATHER_ID,MOTHER_ID FROM CA_GNO_PATIENT_DTL WHERE PATIENT_ID IN ("+totalListbf.toString()+")");//OLD					
						pst = conn.prepareStatement("SELECT PATIENT_ID,NON_PATIENT_ID,PATIENT_NAME,SEX,SM_CONVERT_DATE_2T(DATE_OF_BIRTH,?) DATE_OF_BIRTH,DECEASED_YN,COUPLE_RELN_YN,FATHER_ID,MOTHER_ID FROM CA_GENOGRAM_ATTRIBUTE_VW WHERE NON_PATIENT_ID IN ("+totalListbf.toString()+")");//NEW					
						pst.setString(1, locale);
						
						rs = pst.executeQuery();	
						
						if(rs!=null){						
							while(rs.next()){
								if(!"".equals(patientsDetails.toString()))
									patientsDetails.append("|");
								patientsDetails.append(rs.getString("NON_PATIENT_ID")==null?"":(String)rs.getString("NON_PATIENT_ID"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("PATIENT_NAME")==null?"":(String)rs.getString("PATIENT_NAME"));	
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("DATE_OF_BIRTH")==null?"":(String)rs.getString("DATE_OF_BIRTH"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("DECEASED_YN")==null?"":(String)rs.getString("DECEASED_YN"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("COUPLE_RELN_YN")==null?"":(String)rs.getString("COUPLE_RELN_YN"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("FATHER_ID")==null?"":(String)rs.getString("FATHER_ID"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("MOTHER_ID")==null?"":(String)rs.getString("MOTHER_ID"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("PATIENT_ID")==null?"":(String)rs.getString("PATIENT_ID"));
								patientsDetails.append("~");
								patientsDetails.append(rs.getString("SEX")==null?"":(String)rs.getString("SEX"));
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					patients_Details	= patientsDetails.toString();
					//Emotional/Social/Interpersonal Relations.
					if(!"".equals(totalListbf.toString())){
						pst = conn.prepareStatement("SELECT A.TO_GENOID||'~'||(SELECT SEX FROM CA_GENOGRAM_ATTRIBUTE WHERE NON_PATIENT_ID=A.TO_GENOID)||'~'||A.FROM_GENOID||'~'||(SELECT SEX FROM CA_GENOGRAM_ATTRIBUTE WHERE NON_PATIENT_ID=A.FROM_GENOID)||'~'||A.RELATION_ID ESIRELATION,A.RELATION_ID RELATION_ID FROM CA_GENOGRAM_RELATION A WHERE A.RELATION_TYPE_ID IN ('EMOTION','SOCIAL','INTER') AND A.TO_GENOID IN ("+totalListbf.toString()+")");				
						rs = pst.executeQuery();						
						if(rs!=null){						
							while(rs.next()){
								if(!"".equals(esiRelationDetails.toString()))
									esiRelationDetails.append("|");
								esiRelationDetails.append(rs.getString("ESIRELATION")==null?"":(String)rs.getString("ESIRELATION"));								
								draw_relations.add((String)rs.getString("RELATION_ID"));
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					esi_Details	= esiRelationDetails.toString();
					//IN043482 Start.
					//Medical History.
					if(!"".equals(totalListbf.toString())){
						pst = conn.prepareStatement("SELECT A.FROM_GENOID||'~'||(SELECT SEX FROM CA_GENOGRAM_ATTRIBUTE WHERE NON_PATIENT_ID=A.FROM_GENOID)||'~'||A.RELATION_ID MHRELATION, A.RELATION_ID RELATION_ID FROM CA_GENOGRAM_RELATION A WHERE A.RELATION_TYPE_ID='MH' AND A.FROM_GENOID IN("+totalListbf.toString()+")");				
						rs = pst.executeQuery();						
						if(rs!=null){						
							while(rs.next()){
								if(!"".equals(mhRelationDetails.toString()))
									mhRelationDetails.append("|");
								mhRelationDetails.append(rs.getString("MHRELATION")==null?"":(String)rs.getString("MHRELATION"));								
								draw_relations.add((String)rs.getString("RELATION_ID"));
							}
						}
						if(rs!=null)rs.close();
						if(pst!=null)pst.close();
					}
					mh_Details	= mhRelationDetails.toString();
					//IN043482 End.
					//Draw Relations
					for(int i=0;i<draw_relations.size();i++){
							if(!"".equals(draw_relationsDetails.toString()))
									draw_relationsDetails.append("|");
							draw_relationsDetails.append((String)draw_relations.get(i));						
					}
					
					drawRelationsDetails=draw_relationsDetails.toString();
			
			%>
			
			<applet code="CAGenogramApplet" codebase="../Genogram/" archive="CAGenogramApplet.jar" width="<%=screenWidth%>" height="<%=screenHeight%>" >
				<param name="classloader_cache" value="false">
				
				<!-- 4th Generation-->
				<param name="patFFGrandFatherId" value="<%=patFFGrandFatherId%>">
				<param name="patFFGrandMotherId" value="<%=patFFGrandMotherId%>">
				<param name="patFMGrandFatherId" value="<%=patFMGrandFatherId%>">
				<param name="patFMGrandMotherId" value="<%=patFMGrandMotherId%>">
				<param name="patMFGrandFatherId" value="<%=patMFGrandFatherId%>">
				<param name="patMFGrandMotherId" value="<%=patMFGrandMotherId%>">
				<param name="patMMGrandFatherId" value="<%=patMMGrandFatherId%>">
				<param name="patMMGrandMotherId" value="<%=patMMGrandMotherId%>">

				<param name="patFFGrandFatherAndHisWife_Relation" value="<%=patFFGrandFatherId_Wife_Relation%>">				
				<param name="patFMGrandFatherAndHisWife_Relation" value="<%=patFMGrandFatherId_Wife_Relation%>">				
				<param name="patMFGrandFatherAndHisWife_Relation" value="<%=patMFGrandFatherId_Wife_Relation%>">				
				<param name="patMMGrandFatherAndHisWife_Relation" value="<%=patMMGrandFatherId_Wife_Relation%>">

				<!-- 3rd Generation-->				
				<param name="patFGrandFatherId" value="<%=patFGrandFatherId%>">
				<param name="patFGrandMotherId" value="<%=patFGrandMotherId%>">
				<param name="patMGrandFatherId" value="<%=patMGrandFatherId%>">
				<param name="patMGrandMotherId" value="<%=patMGrandMotherId%>">				
				
				<param name="patFGrandFatherFather_Childs" value="<%=patFGrandFatherFather_Childs%>">
				<param name="patFGrandMotherFather_Childs" value="<%=patFGrandMotherFather_Childs%>">
				<param name="patMGrandFatherFather_Childs" value="<%=patMGrandFatherFather_Childs%>">
				<param name="patMGrandMotherFather_Childs" value="<%=patMGrandMotherFather_Childs%>">
				
				<param name="patFFather_Mother_Relation" value="<%=patFFather_Mother_Relation%>">
				<param name="patMFather_Mother_Relation" value="<%=patMFather_Mother_Relation%>">
				
				<!-- 2nd Generation-->				
				<param name="patFatherId" value="<%=patFatherId%>">
				<param name="patMotherId" value="<%=patMotherId%>">				
				<param name="patFGrandFather_Childs" value="<%=patFGrandFather_Childs%>">
				<param name="patMGrandFather_Childs" value="<%=patMGrandFather_Childs%>">				
				<param name="patFather_Mother_Relation" value="<%=patFather_Mother_Relation%>">
				
				<!-- Current Generation.-->
				<param name="patient_id" value="<%=patient_id%>">
				<param name="patFather_Childs" value="<%=patFather_Childs%>">
				<param name="patientFamily_Details" value="<%=patientFamily_Details%>">
				<param name="patientFamily_Relations" value="<%=patientFamily_Relations%>">
				
				<param name="patientChilds" value="<%=patientChilds%>">
				
				<param name="patientsDetails" value="<%=patients_Details%>">
				<param name="esiDetails" value="<%=esi_Details%>">
				<param name="mhDetails" value="<%=mh_Details%>">  <!--  IN043482 -->
			</applet>
			<%
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{				
				if(conn != null) ConnectionManager.returnConnection(conn,request);
			}
			%>
			
			</DIV>
		</TD>
	</TR>
<TABLE>
<script>
		function assignTransBtnPage(){
			parent.patientGenogramTranBtn.location.href='../../eCA/jsp/CAPatientGenogramTranBtn.jsp?patient_id=<%=patient_id_%>&drawRelationString=<%=drawRelationsDetails%>';
		}
		//call after page loaded
		window.onload=assignTransBtnPage ; 
		</script>
</body> 
</html> 
