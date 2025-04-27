<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesFieldItem"%>

<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>

<%@page
	import="java.util.*, org.w3c.dom.*,java.sql.*,  webbeans.eCommon.*"
	contentType="text/html;charset=UTF-8"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"
	
	%>
	<%@ page import="eIPAD.chartsummary.clinicalnotes.request.*"
	
	%><%@ page import="eIPAD.chartsummary.clinicalnotes.response.*"
	
	%>
	
	<%@ page import="eIPAD.chartsummary.clinicalnotes.healthobject.*"
	
	%>
	
	<%@ page import="eIPAD.chartsummary.common.response.Errors"
	
	%>
	<%@ page import="eIPAD.chartsummary.common.response.TransactionResponse"
	
	%>
	<%@ page import="eIPAD.chartsummary.encounterlist.bc.EncounterListBC"
	
	%>
	<%@ page import="eIPAD.chartsummary.encounterlist.healthobject.EncounterHO"
	
	%>
	<%@ page import="eIPAD.chartsummary.encounterlist.request.EncounterListRequest"
	
	%>
		<%@ page import="eIPAD.chartsummary.encounterlist.response.EncounterListResponse"
	
	%>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String std_component_information = request.getParameter("std_component_information")==null?"":request.getParameter("std_component_information");



PatContext patContext= (PatContext)session.getAttribute("PatientContext");




String patient_id = patContext.getPatientId();

String encounter_id = patContext.getEncounterId();




EncounterListRequest encReq = new EncounterListRequest();
EncounterHO selEncHO;
String encounterId=null;

if(patContext!=null){
	encounterId = patContext.getEncounterId();
	encReq.setPatientContext(patContext);
	encReq.setFilterEncounterId(encounterId);
	locale = patContext.getLocale();
}
EncounterListBC encBC = new EncounterListBC();
EncounterListResponse selEncResp;
selEncResp = encBC.getEncounterList(encReq);



selEncHO = selEncResp.getEncounterList().get(0);


String code_spl=selEncHO.getSpecialtyCode();



String speciality_code =code_spl;

String facility_id = patContext.getFacilityId();

String flag = request.getParameter("flag")==null?"":request.getParameter("flag");
String rowIndex = request.getParameter("rowId")==null?"0":request.getParameter("rowId");
int rowId = Integer.parseInt(rowIndex);
rowId = rowId - 1;
String std_comp_id				=	"", look_up_type	=	"";
String std_comp_result_type	=	"",	compId			=	"";
std_component_information = java.net.URLDecoder.decode(std_component_information);
if (std_component_information==null) std_component_information="";


eCA.StandardCompRepository stdCompRep = new eCA.StandardCompRepository();
StringTokenizer st_comp_details = new StringTokenizer(std_component_information, "~");
String sqlQuery = "";
String chkSplChars = "";
Connection con = null;
PreparedStatement pstmt = null;

Gson gson = new Gson();
ResultSet rs = null;

ArrayList<ClinicalNotesFieldItem>  ClinicalVals= new  ArrayList();
try
{
	con = ConnectionManager.getConnection(request);	
	while(st_comp_details.hasMoreTokens())
	{

		//StringTokenizer temp = new StringTokenizer(st_comp_details.nextToken(), "|");
		String strs[] = st_comp_details.nextToken().split("\\|");
		
		//while(temp.hasMoreTokens())
		
		if(strs.length>0)
		{
		
			String retVal[] = null;
			//std_comp_id				= temp.nextToken();
			std_comp_id				= strs[0];
			if (std_comp_id==null) std_comp_id="";
			//look_up_type			= temp.nextToken();
			look_up_type			= strs[1];
			if (look_up_type==null) look_up_type="";
			//look_up_type=look_up_type;
			//std_comp_result_type	= temp.nextToken();		
			std_comp_result_type	= strs[2];		
			if (std_comp_result_type==null) std_comp_result_type="";

			//compId						= temp.nextToken();		
			compId						= strs[3];	
			if (compId==null) compId="";
			
			

			
		
			//if(!std_comp_result_type.equals("L"))
			//{
				sqlQuery = stdCompRep.getCAKeyValue(std_comp_id);
				
			if(!sqlQuery.equals(""))
			{
				if(sqlQuery.indexOf("$$") != -1)
				{
					retVal = construct(sqlQuery);
					//for(int i=0;i<retVal.length;i++)
					int setStringCount = 1;
					pstmt = con.prepareStatement(retVal[0]);

					for(int i=1;i<retVal.length;i++)
					{
						
						String param = retVal[i];

						if(param.equals("PATIENT_ID"))
							pstmt.setString(setStringCount++, patient_id);
						else if(param.equals("ENCOUNTER_ID"))
							pstmt.setString(setStringCount++, encounter_id);
						else if(param.equals("FACILITY_ID"))
							pstmt.setString(setStringCount++, facility_id);	
						else if(param.equals("SPECIALITY_CODE"))
							pstmt.setString(setStringCount++, speciality_code);	
						else if(param.equals("MAST_TYPE_REF"))
							pstmt.setString(setStringCount++, "");	
						else if(param.equals("LANGUAGE_ID"))
							pstmt.setString(setStringCount++, locale);
					}
				}
				else
				{

					pstmt = con.prepareStatement(sqlQuery);
				}
               

				
				rs = pstmt.executeQuery();
				//IN038004 Starts
				//out.println("var templateFormObj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm");
// 				out.println("if(null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame)");
// 				out.println("{");
// 					out.println("var templateFormObj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm");
// 				out.println("}");
// 				out.println("else");
// 				out.println("{");
// 					out.println("var templateFormObj = parent.document.RecClinicalNotesTemplateForm");	
// 				out.println("}");
				//IN038004 Ends
				
				
			
				
				while(rs.next()&&!std_comp_result_type.equals("L"))
				{
					
					
					ClinicalNotesFieldItem clinic= new ClinicalNotesFieldItem();
					
					
					
					
					
					if (rs.getString(1)!=null)
					{
						chkSplChars = rs.getString(1);
						chkSplChars = chkSplChars.replaceAll("\"","\\\\\"");
						chkSplChars = chkSplChars.replaceAll("\\r","`");
						if (std_comp_result_type.equals("D"))
						{
							chkSplChars = com.ehis.util.DateUtils.convertDate(chkSplChars,"DMY","en",locale);		
						}else if (std_comp_result_type.equals("E")){
							chkSplChars = com.ehis.util.DateUtils.convertDate(chkSplChars,"DMYHM","en",locale);
						}						
						if(flag.equals("addrow"))
						{
// 							out.println("if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.all."+compId+"["+rowId+"]!=undefined){"); //IN052359
// 								out.println("if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.all."+compId+"["+rowId+"].value == '')");
// 								out.println("{");
// 									 out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.all."+compId+"["+rowId+"].value = \""+chkSplChars+"\";");
// 								out.println("}");
// 							 out.println("}");//IN052359
// 							 //IN052359 Start.
// 							out.println("for(var i=0;i<"+rowId+";i++){");
// 								out.println("if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.all."+compId+"[i]!=undefined){"); //IN052359
// 									out.println("if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.all."+compId+"[i].value == ''){");
// 										out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.all."+compId+"[i].value = \""+chkSplChars+"\";");
// 									out.println("}");
// 								out.println("}");	
// 							out.println("}");
							//IN052359 End.
						}
						else
						{
						//out.println("if(templateFormObj."+compId+".value == '')");//IN038004
// 						out.println("if(null!=templateFormObj && null!=templateFormObj."+compId+" && templateFormObj."+compId+".value == '')");//IN038004
// 						out.println("{");
// 						out.println("var testVar =  \""+chkSplChars+"\"");
						

//System.out.println("OUtput values........"+chkSplChars+"compId::"+compId);
//out.println(chkSplChars);

clinic.setCode(compId);
clinic.setDesc(chkSplChars);

ClinicalVals.add(clinic);






					
// 						out.println("templateFormObj."+compId+".value = testVar;");
// 						 out.println("}");
						}
					}
				}
			
								
				
				
			}
			/*else
			{
				if (!std_comp_id.equals(""))
					
			}*/
			if(rs!=null)rs.close();
			if(pstmt!=null) pstmt.close();
			
			//}
		}
	}
	
	response.setContentType("application/json");	
	
	String	jsonFieldResponse = gson.toJson(ClinicalVals);
	
	response.setContentType("application/json");
	response.getWriter().write(jsonFieldResponse);

	
	
	
}
catch(Exception e)
{
	e.printStackTrace();
	out.println("Exception caught at RecClinicalNotesStdCompLinking.jsp-->" + e);
}
finally
{
	if(con!=null)	ConnectionManager.returnConnection(con,request);
}
%>

<%!
private static String[] construct(String sqlQuery)
{
	StringBuffer temp = new StringBuffer(sqlQuery);
	String retVal[];
	int count = 0;
	if(temp.indexOf("$$") == temp.lastIndexOf("$$"))
		retVal = new String[2];
	else
	{
		int start_index = 0;
		while (true)
		{
			start_index = temp.indexOf("$$", start_index);
			if(start_index == -1)
				break;
			else
			{
				count++;
				start_index += 2;
			}
		}
		retVal = new String[count+1];
	}

	count = 1;
	while(temp.indexOf("$$") != -1)
	{
		int start_index = temp.indexOf("$$");
		int end_index = temp.indexOf("##");
		String paramValue = temp.substring(start_index+2, end_index);
		temp.replace(start_index, end_index+2, "?");

		retVal[count] = paramValue;
		count++;
	}
	retVal[0] = temp.toString();

	return retVal;
}

/*public static String encodeHexString(String sourceText) {

		byte[] rawData = sourceText.getBytes();
		StringBuffer hexText = new StringBuffer();
		String initialHex = null;
		int initHexLength = 0;

		for (int i = 0; i < rawData.length; i++) {
			int positiveValue = rawData[i] & 0x000000FF;
			initialHex = Integer.toHexString(positiveValue);
			initHexLength = initialHex.length();
			while (initHexLength++ < 2) {
				hexText.append("0");
			}
			hexText.append(initialHex);
		}
		return hexText.toString();
	}*/

%>
