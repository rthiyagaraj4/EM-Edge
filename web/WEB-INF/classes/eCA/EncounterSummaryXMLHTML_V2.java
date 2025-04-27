/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * @author Sethuraman D
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package eCA;
import java.awt.Color;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;


 
public class EncounterSummaryXMLHTML_V2{
	
	public static StringBuffer htmlData = new StringBuffer();
	
	public static String pageSource = "";

	public static String tableNotesStr = "<table class=\"breakTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">"; 	
	public static String tableStr = "<table class=\"breakTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">"; 
	
	public static String tableTempStr = "<table class=\"tableTemp\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">";	
	
	public static String tableMainStr = "<table class=\"breakMainTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">";
	public static String tableMainTempStr = "<table class=\"breakMainTempTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">";
	
	public static String tableDataStr = "<table class=\"breakTable\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 750px\">";
	public static String tableLinearStr = "<table class=\"breakTableLC\" align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=450px >";
	public static String tableLineChartStr = "<table  class=\"breakTable\" valign=\"top\" align=\"left\" border=\"0\" width=400px>";
	public static String tbodyStr = "<tbody>";
	public static String trStr = "<tr class=\"breakTr\">";
	public static String trStrLC = "<tr class=\"breakTrLC\">";
	public static String trNotesStr = "<tr class=\"breakTrNotes\">";
	public static String tdHeadStr = "<td style=\"border-bottom:2px solid red\" valign=\"bottom\">";
	public static String tdGroupHeadStr = "<td style=\"border-bottom:1px solid green\" valign=\"bottom\">";
	public static String tdSubGroupHeadStr = "<td style=\"border-bottom:1px solid green;  text-align: left\" valign=\"bottom\">";
	
	public static String tdTableHeaderStr = "<td style=\"border-bottom: green 1px solid; text-align: center\" valign=\"center\" width=250px height=35px>";
	public static String tdTableDataStr = "<td style=\"text-align: left\" valign=\"center\" width=250px height=35px>";
	public static String tdTextStr = "<td style=\"text-align: left\" valign=\"center\" height=35px>";
	public static String tdStr = "<td valign=\"center\" height=35px>";
	public static String tdHeadWidthStr = "<td style=\"border-bottom:2px solid red\" valign=\"bottom\" width=35px>";

	public static String tdLinearLeftStr = "<td style=\"text-align: left\">";
	public static String tdLinearRightStr = "<td style=\"text-align: right\">";
	public static String tdLinearCenterStr = "<td style=\"text-align: center\">";
	public static String tdLineLeftStr = "<td style=\"text-align: left\" valign=\"top\">";
	public static String spanMainHeadStr = "<span style=\"font-family: verdana, geneva, sans-serif; color: red; font-size: 15pt; font-weight: bold;\">";
	//public static String spanMainHeadStr = "<span style=\"font-family: Gotham Book; color: red; font-size: 15pt; font-weight: bold;\">";
	public static String spanGroupHeadStr = "<span style=\"font-family: verdana, geneva, sans-serif; color: black; font-size: 14pt; font-weight: bold;\">";
	public static String spanSubGroupHeadStr = "<span style=\"font-size: 13pt; font-weight: bold;\">";
	public static String spanTextStr = "<span style=\"font-size: 12pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
	public static String spanSmallTextStr = "<span style=\"font-size: 10pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
	public static String spanTableHeadStr = "<span style=\"color: #808080\"><span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
	public static String spanFontSize11Str = "<span style=\"font-size: 11pt\">";

	public static String spanBlackColorStr = "<span style=\"color: #000000\">";
	public static String spanColorStr = "<span style=\"color: #808080\">";
	public static String spanFontFamStr = "<span style=\"font-family: verdana, geneva, sans-serif\">";
	public static String cspanStr = "</span>";
	public static String tdNormalStr = "<td>";
	public static String tdValignStr = "<td valign=\"top\">";
	public static String ctdStr = "</td>";
	public static String ctrStr = "</tr>";
	public static String ctbodyStr = "</tbody>";
	public static String ctableStr = "</table>";
	public static String spaceStr = "&nbsp;";
	public static String brStr = "<br>";
	public static String strongStr = "<strong>";
	public static String cStrongStr = "</strong>";
	public static String jspIncludeStr = "<jsp:include page=\""+pageSource+"\" />";
	
	public static String theadStr = "<thead>";
	public static String ctheadStr = "</thead>";
	
	public static String trTableStr = "<tr class=\"breakTr\">";

	public static String thStr = "<th>";
	public static String cthStr = "</th>";	
	
	public static String tfootStr = "<tfoot>";
	public static String ctfootStr = "</tfoot>";	
	
	public static String prevMainGroup = "";
	public static String currentMainGroup = "";
	
	public static int groupTotal = 0;
	public static int groupCount = 0;
	
	public static int subGroupTotal = 0;
	public static int subGroupCount = 0;
	
	public static int divCount = 0; 
	
	public static boolean kSubGroupFlag = false;
	//public static String[][] subGroupData = null;
	
	public static int tbl_cell_color_fill_flag = 0; 
	public static int tbl_cell_bborder_fill_flag = 0; 
	
	
	
	public static StringBuffer getXMLHtml(String xmlData, int tbl_cell_color_fill, int tbl_cell_bborder_fill) {
		
		htmlData = new StringBuffer();

		String hyphen = "-";
		int subGroupTotal = 0;
		
		List<Element> reportHeaderList = null;
		List<Element> mainGroupList = null;
		
		Element rootNode = null;
		Element reportNode = null;
		Element mainGroupNode = null;
		
		String[][] mainGroupData = null;		
		
		SAXBuilder builder = new SAXBuilder();
		
		//String xmlRecords = "<GraphicalDisplay><ReportHeader referrence= \"HealthCheck\" name= \"Executive Health Check\">  <MainGroup referrence= \"CHIEFCOMPL\" name= \"Chief Complaint\" ImageUrl=\"\" Remarks=\"\"><Template referrence=\"1\" name=\"Textual\"> <ResultDesc1 ResultText=\"Chest Pain\" ResultVal=\"- None\" /> </Template></MainGroup><MainGroup referrence= \"VITALINF\" name= \"Vital Information\" ImageUrl=\"\" Remarks=\"\"><Template referrence=\"1\" name=\"Textual\"><ResultDesc1 ResultText=\"Temperature\" ResultVal=\"\"></ResultDesc1><ResultDesc2 ResultText=\"Pulse\" ResultVal=\"72/min\"></ResultDesc2><ResultDesc3 ResultText=\"Respiratory Rate\" ResultVal=\"\"></ResultDesc3><ResultDesc4 ResultText=\"Height\" ResultVal=\"173 cms\"></ResultDesc4><ResultDesc5 ResultText=\"Weight\" ResultVal=\"63 Kg\"></ResultDesc5></Template><Group referrence= \"BLP\" name = \"Blood Pressure\" UOM=\"mmHG\" remarks=\"\"><SubGroup referrence= \"SP\" name = \"Systolic BP\" remarks=\"\">  <Template referrence=\"3\" name=\"Linear Gauge\"><TemplateRange  RangeFrom=\"90\" RangeTo=\"150\" TemplateSplit=\"3\"></TemplateRange><TemplateSplit1 RangeFrom=\"90\" RangeTo=\"120\" bgcolor=\"Green\"></TemplateSplit1><TemplateSplit2 RangeFrom=\"120\" RangeTo=\"140\" bgcolor=\"Yellow\"></TemplateSplit2>                    <TemplateSplit3 RangeFrom=\"140\" RangeTo=\"150\" bgcolor=\"Red\"></TemplateSplit3>                  <ResultVal        Result=\"140\" bgcolor=\"Red\" ResultStr=\"Your Value is Pre-Hypertension\" > </ResultVal>        <ResultNormal    ResultNormal=\"Optimum :90-120\"> </ResultNormal></Template></SubGroup><SubGroup referrence= \"DP\" name = \"Diastolic BP\" remarks=\"\"> <Template referrence=\"3\" name=\"Linear Gauge\"><TemplateRange  RangeFrom=\"60\" RangeTo=\"90\" TemplateSplit=\"2\"></TemplateRange><TemplateSplit1 RangeFrom=\"60\" RangeTo=\"80\" bgcolor=\"Green\"></TemplateSplit1><TemplateSplit2 RangeFrom=\"80\" RangeTo=\"90\" bgcolor=\"Yellow\"></TemplateSplit2><ResultVal        Result=\"80\" bgcolor=\"Green\" ResultStr=\"Your Value is Optimal\" > </ResultVal><ResultNormal    ResultNormal=\"Optimum :60-80\"> </ResultNormal></Template></SubGroup><SubGroup referrence= \"BP\" name = \"General BP\" remarks=\"\"><Template referrence=\"3\" name=\"Linear Gauge\">                    <TemplateRange  RangeFrom=\"80\" RangeTo=\"220\" TemplateSplit=\"3\"></TemplateRange><TemplateSplit1 RangeFrom=\"80\" RangeTo=\"120\" bgcolor=\"Green\"></TemplateSplit1>                <TemplateSplit2 RangeFrom=\"120\" RangeTo=\"140\" bgcolor=\"Yellow\"></TemplateSplit2><TemplateSplit3 RangeFrom=\"140\" RangeTo=\"220\" bgcolor=\"Red\"></TemplateSplit3><ResultVal        Result=\"120\" bgcolor=\"Green\" ResultStr=\"Your Value is Optimal\" > </ResultVal><ResultNormal    ResultNormal=\"Optimum :80-120\"> </ResultNormal></Template></SubGroup></Group></MainGroup><MainGroup referrence= \"LIVFUNC\" name= \"Liver Function Test\" ImageUrl=\"LiverFunction.gif\" Remarks=\"This test help assess the health of the Liver. Infections, alcoholism, cancer and drug damage are usual causes for liver Diseases. This test help assess the health of the Liver. Infections, alcoholism, cancer and drug damage are usual causes for liver Diseases. Abnormal Levels of Serum protiens help diagnosed damaged liver cells, usually caused by liver disease or acute infections\"><SubGroup referrence= \"BILBURN\" name = \"Bilirubin\" remarks=\"Bilirubin Description to be displayed here\"> <Template referrence=\"2\" name=\"Table\" Coloumns = \"5\"><Column> <ColumnName1>Parameter </ColumnName1><ColumnName2> Units</ColumnName2><ColumnName3> Result</ColumnName3><ColumnName4> Your Value is </ColumnName4><ColumnName5> Reference</ColumnName5></Column><RowNo> <RowNo1  ColumnName1=\"Total Billrubin\" ColumnName2=\"mg/dl\" bgcolor = \"Green\" ColumnName3 = \"0.7\" ColumnName4 = \"Optimal\" ColumnName5 =\"0.2-1.3\" ></RowNo1><RowNo2  ColumnName1=\" --Direct Billrubin\" ColumnName2=\"mg/dl\" bgcolor = \"Green\" ColumnName3 = \"0.2\" ColumnName4 = \"Optimal\" ColumnName5 =\"0.0-0.3\" ></RowNo2><RowNo3  ColumnName1=\" --Conjuncted Billrubin\" ColumnName2=\"mg/dl\" bgcolor = \"\" ColumnName3 = \"0.0\" ColumnName4 = \"-\" ColumnName5 =\"-\" ></RowNo3><RowNo4  ColumnName1=\" --Delta Billrubin\" ColumnName2=\"mg/dl\" bgcolor = \"\" ColumnName3 = \"0.20\" ColumnName4 = \"\" ColumnName5 =\"\" ></RowNo4></RowNo></Template></SubGroup><SubGroup referrence= \"SERUM\" name = \"Serum Protiens\" remarks=\"Abnormal Levels of Serum protiens help diagnosed damaged liver cells, usually caused by liver disease or acute infections\"> <Template referrence=\"2\" name=\"Table\" Coloumns = \"5\"><Column> <ColumnName1>Parameter </ColumnName1><ColumnName2> Units</ColumnName2><ColumnName3> Result</ColumnName3><ColumnName4> Your Value is </ColumnName4><ColumnName5> Reference</ColumnName5></Column><RowNo> <RowNo1  ColumnName1=\"Total Proteins\" ColumnName2=\"gm/dl\" bgcolor = \"Green\" ColumnName3 = \"7.6\" ColumnName4 = \"Optimal\" ColumnName5 =\"6.3-8.2\" ></RowNo1><RowNo2  ColumnName1=\" --Albumin\" ColumnName2=\"gm/dl\" bgcolor = \"Green\" ColumnName3 = \"4.2\" ColumnName4 = \"Optimal\" ColumnName5 =\"3.5-5.0\" ></RowNo2><RowNo3  ColumnName1=\" --Globulin\" ColumnName2=\"gm/dl\" bgcolor = \"Yellow\" ColumnName3 = \"2.0\" ColumnName4 = \"Low\" ColumnName5 =\"2.4-3.5\" ></RowNo3><RowNo4  ColumnName1=\" --Albumin/Globulin\" ColumnName2=\"Ratio\" bgcolor = \"Green\" ColumnName3 = \"1.2\" ColumnName4 = \"Optimal\" ColumnName5 =\"0.9-2.0\" ></RowNo4></RowNo></Template></SubGroup></MainGroup><MainGroup referrence= \"LIPIDPF\" name= \"Lipid Profile Test\" ImageUrl=\"LipidProfile.gif\" Remarks=\"Lipid Profile function test\"> <Group referrence= \"LDL\" name = \"LDL or Bad Cholestrol\" UOM=\"mg/dl\" numericresult=\"116\" bgcolor=\"yellow\" remarks=\"LDL Description to displayed here\"> <Template referrence=\"3\" name=\"Linear Gauge\"><TemplateRange  RangeFrom=\"40\" RangeTo=\"160\" TemplateSplit=\"3\"></TemplateRange><TemplateSplit1 RangeFrom=\"40\" RangeTo=\"100\" bgcolor=\"Green\">  </TemplateSplit1><TemplateSplit2 RangeFrom=\"100\" RangeTo=\"130\" bgcolor=\"Yellow\">  </TemplateSplit2><TemplateSplit3 RangeFrom=\"130\" RangeTo=\"160\" bgcolor=\"Red\">  </TemplateSplit3><ResultVal Result=\"116\" bgcolor=\"Yellow\" ResultStr=\"Your Value is Near Optimum\" > </ResultVal><ResultNormal ResultNormal=\"Optimum :40-160\"> </ResultNormal> </Template></Group><Group referrence= \"LDL\" name = \"LDL or Good Cholestrol\" UOM=\"mg/dl\" numericresult=\"69\" bgcolor=\"green\" remarks=\"LDL Description to displayed here\"> <Template referrence=\"3\" name=\"Linear Gauge\"><TemplateRange  RangeFrom=\"20\" RangeTo=\"80\" TemplateSplit=\"3\"></TemplateRange><TemplateSplit1 RangeFrom=\"20\" RangeTo=\"27\" bgcolor=\"red\">  </TemplateSplit1><TemplateSplit2 RangeFrom=\"27\" RangeTo=\"75\" bgcolor=\"yellow\">  </TemplateSplit2><TemplateSplit3 RangeFrom=\"75\" RangeTo=\"80\" bgcolor=\"green\">  </TemplateSplit3><ResultVal Result=\"69\" bgcolor=\"green\" ResultStr=\"Your Value is Near Optimum\" > </ResultVal><ResultNormal ResultNormal=\"Optimum :35-75\"> </ResultNormal></Template> </Group></MainGroup></ReportHeader></GraphicalDisplay>";
		  //File xmlFile = new File("c:\\file.xml");	
		InputSource is = new InputSource();
	    is.setCharacterStream(new StringReader(xmlData));    
	 
		try {
			
			tbl_cell_color_fill_flag = tbl_cell_color_fill;
			tbl_cell_bborder_fill_flag = tbl_cell_bborder_fill;
	 
			Document document = (Document) builder.build(is);			
			rootNode = document.getRootElement();
			
			// Report Header List
			 divCount = 0;
			reportHeaderList = rootNode.getChildren("ReportHeader");			
			for (int i = 0; i < reportHeaderList.size(); i++) {
			   reportNode = (Element) reportHeaderList.get(i);
			   // Main Group List
			   mainGroupList = reportNode.getChildren("MainGroup");			   
			   for (int j =0; j <mainGroupList.size();j++){
			   		hyphen = "-";
			   		groupTotal = 0;
			   		groupCount = 0;
			   		subGroupTotal = 0;
			   		subGroupCount = 0;
			   		mainGroupNode = (Element) mainGroupList.get(j);	
			   		mainGroupData = returnMainGroup(mainGroupNode);				   		
			   		
			   		//if (mainGroupNode.getAttributeValue("referrence").equalsIgnoreCase("vitalinf")){
			   			//drawMainHead(mainGroupData);
			   			drawMainHead(mainGroupData, j);
			   			dataList(mainGroupNode);						
						htmlData.append(brStr);
			   		//}			   		
			   }
			}

			if (htmlData.length()>0){
				htmlData.append("<input type=\"hidden\" name=\"divCount\" id=\"divCount\" value="+divCount+" >");
			}
			
	 
		} catch (IOException io) {
			System.out.println(" IOException in getXMLHtml 184 ::: "+io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(" JDOMException in getXMLHtml 184 ::: "+jdomex.getMessage());
		}catch (Exception exp) {
			System.out.println(" Exception in getXMLHtml 184 ::: "+exp.getMessage());
		}
		return htmlData;
	}
	public static void dataList(Element Node){	
		boolean kSubGroup = false;
		
		String hyphen = "-";
		int templateInt = 0;
		List<Element> childList = null;
		List<Element> groupChildList = null;
		List<Element> subGroupChildList = null;		
		Element childNode = null;
		Element groupChildNode = null;
		Element subGroupChildNode = null;
		
		int subGroupChildCount = 0;
		
		String[][] groupData = null;
		String[][] subGroupData = null;
		
		//try {
			childList = Node.getChildren();		
						
			
			if (Node.getName().equalsIgnoreCase("maingroup")){
				groupTotal = Node.getChildren("Group").size();
			}
			if (Node.getName().equalsIgnoreCase("group")){
				//htmlData.append(brStr);
				subGroupCount = 0;
				//subGroupTotal = Node.getChildren("SubGroup").size(); //Comment by Sethu for Std XML structure on 09/10/2014
				//Added by Sethu for Std XML structure on 09/10/2014
				subGroupTotal = 0; 				
				subGroupChildList = Node.getChildren("SubGroup");
				
				for (int i=0;i<subGroupChildList.size();i++){
					
					subGroupChildNode = (Element) subGroupChildList.get(i);
					if (subGroupChildNode.getName().equalsIgnoreCase("subgroup") && !(subGroupChildNode.getAttributeValue("name").equalsIgnoreCase("empty"))){						
						subGroupTotal++;
					}
					
				}
			}				
			
			templateInt = 0;
			
	   		for (int k=0;k<childList.size();k++){
	   			hyphen = "--";
	   			childNode = (Element) childList.get(k);
				
				//templateInt = 0; //Commented by Sethu on 21/04/2014
	   			
	   			if (childNode.getName().equalsIgnoreCase("group") && !(childNode.getAttributeValue("name").equalsIgnoreCase("empty"))){	 
	   				kSubGroupFlag = false;
	   				subGroupData = null;
	   				groupData = returnGroupHead(childNode);		
	   				groupCount++;
	   				
	   				subGroupChildCount = childNode.getChildren("SubGroup").size();	   				
	   				groupChildList = childNode.getChildren();
	   				for (int g=0;g<groupChildList.size();g++){
	   					groupChildNode = (Element) groupChildList.get(g);
	   					if (groupChildNode.getName().equalsIgnoreCase("template")){
	   						templateInt = 0;
	   						templateInt = childGroupTemplate(childNode,groupCount);
	   					}
	   				}	   	
	   				/***/
	   				/*
					if (groupTotal>0){
	   					if ((groupCount>1) && (subGroupChildCount>0)){
	   						kSubGroup = true;	 
							htmlData.append(ctrStr);
							htmlData.append(ctbodyStr);
		   					htmlData.append(ctableStr);	  
	   					}
	   				}
	   				*/
	   				if (templateInt !=2){
	   					//drawGroupHead(groupData,templateInt,kSubGroup);
	   				}
	   			}	   			
	   			if (childNode.getName().equalsIgnoreCase("subgroup") && !(childNode.getAttributeValue("name").equalsIgnoreCase("empty"))){
	   				kSubGroupFlag = true;
	   				subGroupData = null;
	   				subGroupData = returnSubGroup(childNode);	
	   				
	   				subGroupCount++;	
	   				templateInt = 0;
	   				templateInt = childSubGroupTemplate(childNode,subGroupCount);
	   				
	   				if (templateInt != 2)
	   					drawSubHead(subGroupData,templateInt);
	   				
	   			}
	   			   			   				   			
	   			if (childNode.getName().equalsIgnoreCase("template")){			   				
	   				if (childNode.getParentElement().getName().equalsIgnoreCase("group")){
	   					//drawTemplate(childNode,groupTotal,groupCount);
	   					drawTemplate(childNode,groupTotal,groupCount, templateInt);
	   				}
	   				else if (childNode.getParentElement().getName().equalsIgnoreCase("subgroup"))
	   				{	   					
	   					//drawTemplate(childNode,subGroupTotal,subGroupCount);
	   					drawTemplate(childNode,subGroupTotal,subGroupCount, templateInt);
	   				}
	   				else
	   				{
	   					//drawTemplate(childNode,subGroupTotal,subGroupCount);
	   					drawTemplate(childNode,subGroupTotal,subGroupCount, templateInt);
	   				}
	   			}	
	   			else
	   			{
	   				dataList(childNode);
	   			}
	   		}
			
	   		/*
		}catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		*/
		
	}
	public static int childSubGroupTemplate(Element Node, int subGroupCount){
		
		int templateInt = 0;
		boolean groupFlag = false;
		
		try {	
			if (Node.getName().equalsIgnoreCase("group")){
				groupFlag = true;
			}
			if ((Node.getName().equalsIgnoreCase("group")) || (Node.getName().equalsIgnoreCase("subgroup"))){
				templateInt = Node.getChild("Template").getAttribute("referrence").getIntValue();
			}
		}catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}		

		if (templateInt==3 || templateInt==4){	
			if (subGroupCount==1){
				if (!groupFlag){
					//Sethu
				}
				htmlData.append(brStr);	
				htmlData.append(tableStr);				
				htmlData.append(tbodyStr);	
				htmlData.append(trStrLC);	
				htmlData.append(tdValignStr); //Commented by Sethu -- tdNormalStr
			}
			//**********//
			if (((subGroupCount-1)>1) && (((subGroupCount-1)%2)==0)){
				htmlData.append(trStrLC);	
				htmlData.append(tdValignStr); //Commented by Sethu -- tdNormalStr
			}			
			else
			{
				//htmlData.append(tdNormalStr);
			}
			
		}
		return templateInt;
	}
	public static int childGroupTemplate(Element Node, int groupCount){
		
		int templateInt = 0;
		boolean groupFlag = false;
		
		try {	
			if (Node.getName().equalsIgnoreCase("group")){
				groupFlag = true;
			}	
			
			if ((Node.getName().equalsIgnoreCase("group")) || (Node.getName().equalsIgnoreCase("subgroup"))){
				templateInt = Node.getChild("Template").getAttribute("referrence").getIntValue();
			}
			
		}catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}		

		if (templateInt==3 || templateInt==4){	
			if (groupCount==1){
				if (!groupFlag){
					//Sethu
				}
				htmlData.append(tableStr);				
				htmlData.append(tbodyStr);	
				htmlData.append(trStrLC);	
				htmlData.append(tdValignStr); //Commented by Sethu -- tdNormalStr
			}
			//**********//
			if (((groupCount-1)>1) && (((groupCount-1)%2)==0)){
				htmlData.append(trStrLC);	
				htmlData.append(tdValignStr);//Commented by Sethu -- tdNormalStr
			}			
			else
			{
				//htmlData.append(tdNormalStr);
			}
			
		}
		return templateInt;
	}
	public static void drawTemplate(Element Node, int subGroup, int subGroupCount){
		
		
		int templateInt = 0;
		int columnCount = 0;
		String[][] textData = null;
		String[][] tableData = null;
		String[][] linearRangeData = null;
		String[][] linearSplitData = null;
		String[][] linearValuesData = null;
		String[][] lineRangeData = null;
		String[][] lineSplitData = null;
		String[][] lineGraphData = null;
		String[][] subGroupData = null;

		String[][] notesData = null;
		try {
			templateInt = Node.getAttribute("referrence").getIntValue();	
			
			//System.out.println(" *** templateInt 411 *** "+templateInt);
			
			if (templateInt == 1){					
				textData = returnText(Node);	
				drawText(textData);				
			}
			if (templateInt == 2){	
			
				columnCount = Node.getAttribute("Columns").getIntValue();
				tableData = returnTable(Node,columnCount);

				//System.out.println(" *** tableData.length 420 *** "+tableData.length+" *** tableData[0].length *** "+tableData[0].length);
				//tableData = returnTable(Node);
				drawTable(tableData);								
			}	
			if (templateInt == 3){		
				Element rangeElement = Node.getChild("TemplateRange");			
				
				if (rangeElement != null) {
					// Range Values
					linearRangeData = returnLGaugeRangeValues(Node);
					//Split Values
					linearSplitData = returnLGaugeSplitValues(Node);
					//Point Values
					linearValuesData = returnLGaugeValues(Node);				
					
					String divID = Node.getParentElement().getAttributeValue("referrence");
					divCount++;
					divID = divID + Integer.toString(divCount);
					drawLinearGauge(divID, linearRangeData, linearSplitData, linearValuesData,subGroupCount);
					
					if (subGroup>0 && subGroupCount>0){
						if (subGroupCount==subGroup){						
							htmlData.append(ctrStr);
							htmlData.append(ctbodyStr);
							htmlData.append(ctableStr);			
						}
						else if ( (subGroupCount > 1) && (subGroupCount%2) == 0)
						{
							//htmlData.append(ctdStr);
							htmlData.append(ctrStr);
						}
						else if (subGroup==1)
						{
							htmlData.append(tdValignStr);//Commented by Sethu -- tdNormalStr
							htmlData.append(ctdStr);
							htmlData.append(ctrStr);
						}
						else 
						{
							htmlData.append(tdValignStr);//Commented by Sethu -- tdNormalStr
						}
					}
				}
				
			}	
			if (templateInt == 4){				
				// Range Values
				lineRangeData = returnLGraphRangeValues(Node);
				
				Element rangeElement = Node.getChild("TemplateRange");						
				if (rangeElement != null) {
					//Split Values
					lineSplitData = returnLGaugeSplitValues(Node);	
				}
				// Graph Data Values
				lineGraphData = returnLGraphValues(Node);						
				
				String divID = Node.getParentElement().getAttributeValue("referrence");
				divCount++;
				divID = divID + Integer.toString(divCount);
				drawLineGraph(divID, lineRangeData, lineSplitData, lineGraphData, subGroupCount);
				if (subGroup>0 && subGroupCount>0){
					if (subGroupCount==subGroup){						
						htmlData.append(ctrStr);
						htmlData.append(ctbodyStr);
						htmlData.append(ctableStr);			
					}
					else if ( (subGroupCount > 1) && (subGroupCount%2) == 0)
					{						
						htmlData.append(ctrStr);
					}
					else if (subGroup==1)
					{
						htmlData.append(tdValignStr);//Commented by Sethu -- tdNormalStr
						htmlData.append(ctdStr);
						htmlData.append(ctrStr);
					}
					else 
					{
						htmlData.append(tdValignStr);//Commented by Sethu -- tdNormalStr
					}
				}
			}
			if (templateInt == 5){
				String divID = Node.getParentElement().getAttributeValue("referrence");
				//divCount++;
				//divID = divID + Integer.toString(divCount);
				notesData = returnNotesData(Node);
				drawNotesData(divID,notesData);
			}
			
		}catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}
	
	public static void drawTemplate(Element Node, int subGroup, int subGroupCount, int template){
		
		
		int templateInt = 0;
		int columnCount = 0;
		String[][] textData = null;
		String[][] tableData = null;
		String[][] linearRangeData = null;
		String[][] linearSplitData = null;
		String[][] linearValuesData = null;
		String[][] lineRangeData = null;
		String[][] lineSplitData = null;
		String[][] lineGraphData = null;
		String[][] subGroupData = null;

		String[][] notesData = null;
		try {
			templateInt = Node.getAttribute("referrence").getIntValue();	
			
			//System.out.println(" *** templateInt *** "+templateInt);
			
			if (templateInt == 1){					
				textData = returnText(Node);	
				drawText(textData);				
			}
			if (templateInt == 2){	
				columnCount = Node.getAttribute("Columns").getIntValue();

				tableData = returnTable(Node,columnCount);

				//System.out.println(" *** tableData.length *** "+tableData.length+" *** tableData[0].length *** "+tableData[0].length);
				//tableData = returnTable(Node);
				//drawTable(tableData);								
				drawTable(Node, tableData, template );
			}	
			if (templateInt == 3){		
				Element rangeElement = Node.getChild("TemplateRange");			
				
				if (rangeElement != null) {
					// Range Values
					linearRangeData = returnLGaugeRangeValues(Node);
					//Split Values
					linearSplitData = returnLGaugeSplitValues(Node);
					//Point Values
					linearValuesData = returnLGaugeValues(Node);				
					
					String divID = Node.getParentElement().getAttributeValue("referrence");
					divCount++;
					divID = divID + Integer.toString(divCount);
					drawLinearGauge(divID, linearRangeData, linearSplitData, linearValuesData,subGroupCount);
					
					if (subGroup>0 && subGroupCount>0){
						if (subGroupCount==subGroup){						
							htmlData.append(ctrStr);
							htmlData.append(ctbodyStr);
							htmlData.append(ctableStr);			
						}
						else if ( (subGroupCount > 1) && (subGroupCount%2) == 0)
						{
							//htmlData.append(ctdStr);
							htmlData.append(ctrStr);
						}
						else if (subGroup==1)
						{
							htmlData.append(tdValignStr);//Commented by Sethu -- tdNormalStr
							htmlData.append(ctdStr);
							htmlData.append(ctrStr);
						}
						else 
						{
							htmlData.append(tdValignStr);//Commented by Sethu -- tdNormalStr
						}
					}
				}
				
			}	
			if (templateInt == 4){				
				// Range Values
				lineRangeData = returnLGraphRangeValues(Node);
				
				Element rangeElement = Node.getChild("TemplateRange");						
				if (rangeElement != null) {
					//Split Values
					lineSplitData = returnLGaugeSplitValues(Node);	
				}
				// Graph Data Values
				lineGraphData = returnLGraphValues(Node);						
				
				String divID = Node.getParentElement().getAttributeValue("referrence");
				divCount++;
				divID = divID + Integer.toString(divCount);
				drawLineGraph(divID, lineRangeData, lineSplitData, lineGraphData, subGroupCount);
				if (subGroup>0 && subGroupCount>0){
					if (subGroupCount==subGroup){						
						htmlData.append(ctrStr);
						htmlData.append(ctbodyStr);
						htmlData.append(ctableStr);			
					}
					else if ( (subGroupCount > 1) && (subGroupCount%2) == 0)
					{						
						htmlData.append(ctrStr);
					}
					else if (subGroup==1)
					{
						htmlData.append(tdValignStr);//Commented by Sethu -- tdNormalStr
						htmlData.append(ctdStr);
						htmlData.append(ctrStr);
					}
					else 
					{
						htmlData.append(tdValignStr);//Commented by Sethu -- tdNormalStr
					}
				}
			}
			if (templateInt == 5){
				String divID = Node.getParentElement().getAttributeValue("referrence");
				//divCount++;
				//divID = divID + Integer.toString(divCount);
				notesData = returnNotesData(Node);
				drawNotesData(divID,notesData);
			}
			
		}catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}catch (Exception ex) {
			System.out.println(" Exception in drawTemplate 635 ::: "+ex.getMessage());
		}
	}
	public static String[][] returnText(Element Node){
		String[][] textArray = null;
		List<Element> textList = null;
		Element textNode = null;
		
		textList = Node.getChildren();
		
		textArray = new String[textList.size()][2];
		
		for (int t=0;t<textList.size();t++){
			textNode = (Element) textList.get(t);			
			textArray[t][0] = textNode.getAttribute("ResultText").getValue();
			textArray[t][1] = textNode.getAttribute("ResultVal").getValue();
		}
		return textArray;
	}
	public static String[][] returnTable(Element Node, int colCount){
		String[][] tableArray = null;
		
		List<Element> tableList = null;
		List<Element> columnList = null;
		List<Element> rowList = null;
	
		Element tableNode = null;
		Element groupNode = null;
		Element subGroupNode = null;
		Element columnNode = null;		
		Element rowNode = null;
		
		List<Element> columnTypeList = null;
		Element columnTypeNode = null;	
		
		String columnName = "";

		try
		{		
			tableList = Node.getChildren();	
			
			subGroupNode = Node.getParentElement();
			groupNode = subGroupNode.getParentElement();
			
			for (int t=0;t<tableList.size();t++){
				tableNode = (Element) tableList.get(t);

				if (tableNode.getName().equalsIgnoreCase("columntype")){
					columnTypeList = tableNode.getChildren();
				}
				if (tableNode.getName().equalsIgnoreCase("column")){
					columnList = tableNode.getChildren();
				}
				if (tableNode.getName().equalsIgnoreCase("rowno")){
					rowList = tableNode.getChildren();
				}

			}

			//System.out.println(" *** rowList *** "+rowList.size()+" *** colCount *** "+colCount+" *** columnTypeList.size() *** "+columnTypeList.size());

			if (columnTypeList.size() > 0)		
				tableArray = new String[2+rowList.size()][colCount+2];// colCount+1
			else
				tableArray = new String[1+rowList.size()][colCount+2]; //colCount+1
				
			for (int c=0;c<columnTypeList.size();c++){
				columnTypeNode = (Element) columnTypeList.get(c);
				tableArray[0][c] = columnTypeNode.getValue();
			}
			
			for (int c=0;c<columnList.size();c++){
				columnNode = (Element) columnList.get(c);
				if (columnTypeList.size() > 0)
				{
					tableArray[1][c] = columnNode.getValue();
				}
				else
				{
					tableArray[0][c] = columnNode.getValue();
				}		
			}

			StringBuffer strTableRow = new StringBuffer();		
			
			if (columnTypeList.size() > 0)
				tableArray[1][colCount] = "Color";
			else
				tableArray[0][colCount] = "Color";
			
			for (int r=0;r<rowList.size();r++){
				rowNode = (Element) rowList.get(r);

				strTableRow = new StringBuffer();

				for (int s=0;s<colCount;s++ ){
					columnName = "ColumnName"+(s+1);
					if (columnTypeList.size() > 0)
					{
						tableArray[r+2][s] = rowNode.getAttribute(columnName).getValue();

						strTableRow.append(tableArray[r+2][s].toString());
					}
					else
					{
						tableArray[r+1][s] = rowNode.getAttribute(columnName).getValue();
						strTableRow.append(tableArray[r+1][s].toString());
					}

					strTableRow.append("$$$");
				}

				//System.out.println(" *** strTableRow *** "+strTableRow);

				if (columnTypeList.size() > 0)
					tableArray[r+2][colCount] = rowNode.getAttribute("bgcolor").getValue();
				else
					tableArray[r+1][colCount] = rowNode.getAttribute("bgcolor").getValue();

				if (columnTypeList.size() > 0)
					tableArray[r+2][colCount+1] = rowNode.getAttribute("MethodName").getValue();
				else
					tableArray[r+1][colCount+1] = rowNode.getAttribute("MethodName").getValue();


				//System.out.println(" *** MethodName *** "+rowNode.getAttribute("MethodName").getValue());

				/*

				if (columnTypeList.size() > 0)
					System.out.println(" *** r *** "+r+ " *** tableArray["+r+2"]["+colCount+"] *** "+tableArray[r+2][colCount]);
				else
					System.out.println(" *** r *** "+r+ " *** tableArray["+r+1"]["+colCount+"] *** "+tableArray[r+1][colCount]);

				*/

				
				/*
				tableArray[r+1][0] = rowNode.getAttribute("ColumnName1").getValue();
				tableArray[r+1][1] = rowNode.getAttribute("ColumnName2").getValue();			
				tableArray[r+1][2] = rowNode.getAttribute("ColumnName3").getValue();
				tableArray[r+1][3] = rowNode.getAttribute("ColumnName4").getValue();
				tableArray[r+1][4] = rowNode.getAttribute("ColumnName5").getValue();
				tableArray[r+1][5] = rowNode.getAttribute("bgcolor").getValue();
				*/
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return tableArray;		
	}
	public static String[][] returnMainGroup(Element Node){
		String[][] mainGroupArray = new String[1][4];		
		
		if (Node.getName().equalsIgnoreCase("maingroup")){
			mainGroupArray[0][0] =  Node.getAttribute("name").getValue();
			mainGroupArray[0][1] =  Node.getAttribute("Remarks").getValue();
			mainGroupArray[0][2] =  Node.getAttribute("ImageUrl").getValue();
			mainGroupArray[0][3] =  Node.getAttribute("referrence").getValue();
		}
		return mainGroupArray;		
	}
	public static String[][] returnGroupHead(Element Node){
		String[][] groupArray = new String[1][3];		

		if (Node.getName().equalsIgnoreCase("group")){
			groupArray[0][0] =  Node.getAttribute("name").getValue();
			groupArray[0][1] =  Node.getAttribute("UOM").getValue();
			groupArray[0][2] =  Node.getAttribute("remarks").getValue();
			
			if (groupArray[0][0].equalsIgnoreCase("empty"))
				groupArray[0][0] = "";
			
			if (groupArray[0][1].equalsIgnoreCase("empty"))
				groupArray[0][1] = "";
			
			if (groupArray[0][2].equalsIgnoreCase("empty"))
				groupArray[0][2] = "";
			
		}
		return groupArray;		
	}	
	public static String[][] returnSubGroup(Element Node){
		String[][] tableSubGroupArray = new String[1][2];		
		if (Node.getName().equalsIgnoreCase("subgroup")){
			tableSubGroupArray[0][0] =  Node.getAttribute("name").getValue();
			tableSubGroupArray[0][1] =  Node.getAttribute("remarks").getValue();				
		}
		return tableSubGroupArray;		
	}	
	public static String[][] returnLGaugeSplitValues(Element Node){
		String[][] linearSplitArray = null;
		int splitRange = 0;
		List<Element> rangeList = null;
		List<Element> splitList = null;
		Element rangeNode = null;
		Element splitNode = null;	
		
		splitList = Node.getChildren();		
		
		for (int t=0;t<splitList.size();t++){
			splitNode = (Element) splitList.get(t);			
			if (splitNode.getName().equalsIgnoreCase("templaterange")){
				splitRange = Integer.parseInt(splitNode.getAttribute("TemplateSplit").getValue());				
			}
		}		
		linearSplitArray = new String[splitRange][3];		

		rangeList = Node.getChild("TemplateRange").getChildren();
		
		for (int i=0;i<rangeList.size();i++){
			rangeNode = (Element) rangeList.get(i);	
			linearSplitArray[i][0] = rangeNode.getAttributeValue("RangeFrom");
			linearSplitArray[i][1] = rangeNode.getAttributeValue("RangeTo");
			linearSplitArray[i][2] = rangeNode.getAttributeValue("bgcolor");
		}
		return linearSplitArray;
		
	}
	public static String[][] returnLGaugeRangeValues(Element Node){
		String[][] linearRangeArray = new String[1][3];		
		List<Element> rangeList = null;		
		Element rangeNode = null;			
		
		rangeList = Node.getChildren("TemplateRange");		
		
		for (int t=0;t<rangeList.size();t++){
			rangeNode = (Element) rangeList.get(t);	
			linearRangeArray[t][0] = rangeNode.getAttributeValue("RangeFrom");
			linearRangeArray[t][1] = rangeNode.getAttributeValue("RangeTo");
			linearRangeArray[t][2] = rangeNode.getAttributeValue("TemplateSplit");			
		}
		
		return linearRangeArray;
		
	}
	public static String[][] returnLGaugeValues(Element Node){
		String[][] linearArray = new String[1][4];
		
		List<Element> splitList = null;
		Element resultValNode = null;
		Element resultNormalNode = null;		
		
		splitList = Node.getChildren("ResultVal");		
		
		for (int t=0;t<splitList.size();t++){
			resultValNode = (Element) splitList.get(t);
			linearArray[t][0] = resultValNode.getAttribute("Result").getValue();
			linearArray[t][1] = resultValNode.getAttribute("bgcolor").getValue();
			linearArray[t][2] = resultValNode.getAttribute("ResultStr").getValue();			
		}
		
		splitList = Node.getChildren("ResultNormal");		
		
		for (int t=0;t<splitList.size();t++){
			resultNormalNode = (Element) splitList.get(t);
			linearArray[t][3] = resultNormalNode.getAttribute("ResultNormal").getValue();						
		}	
		return linearArray;
		
	}
	
	public static void drawMainHead(String[][] main){
		
		if (main.length>0){
			htmlData.append(tableMainStr);
			htmlData.append(tbodyStr);
			htmlData.append(trStr);				
			if (main[0][2].length()>0){	
				htmlData.append(tdHeadWidthStr);
				htmlData.append("<input type=\"image\" id=\""+main[0][3]+"\"  src=\"../../eCA/images/"+main[0][2]+"\"  width=\"35px\" height=\"20px\">");								
				htmlData.append(ctdStr);			
			}			
			htmlData.append(tdHeadStr);
			htmlData.append(spanMainHeadStr);
			htmlData.append(main[0][0]);
			htmlData.append(cspanStr);			
			htmlData.append(ctdStr);
			htmlData.append(ctrStr);
			htmlData.append(ctbodyStr);
			htmlData.append(ctableStr);			
			
			if (main[0][1].length()>0){
				htmlData.append(tableStr);
				htmlData.append(tbodyStr);
				htmlData.append(trStr);			
				htmlData.append(tdTextStr);
				htmlData.append(spanTextStr);
				htmlData.append(main[0][1]);				
				htmlData.append(cspanStr);
				htmlData.append(cspanStr);
				htmlData.append(ctdStr);
				htmlData.append(ctrStr);
				htmlData.append(ctbodyStr);
				htmlData.append(ctableStr);		
			}	
			htmlData.append(brStr);
		}				
	}
	
public static void drawMainHead(String[][] main, int mGroupCount){
		
		if (main.length>0){
			if (mGroupCount>0) {
				htmlData.append(tableMainStr);
			}
			else
			{
				htmlData.append(tableMainTempStr);
				
			}
			htmlData.append(tbodyStr);
			htmlData.append(trStr);				
			if (main[0][2].length()>0){	
				htmlData.append(tdHeadWidthStr);
				htmlData.append("<input type=\"image\" id=\""+main[0][3]+"\"  src=\"../../eCA/images/"+main[0][2]+"\"  width=\"35px\" height=\"20px\">");								
				htmlData.append(ctdStr);			
			}			
			htmlData.append(tdHeadStr);
			htmlData.append(spanMainHeadStr);
			htmlData.append(main[0][0]);
			htmlData.append(cspanStr);			
			htmlData.append(ctdStr);
			htmlData.append(ctrStr);
			htmlData.append(ctbodyStr);
			htmlData.append(ctableStr);			
			
			if (main[0][1].length()>0){
				htmlData.append(tableStr);
				htmlData.append(tbodyStr);
				htmlData.append(trStr);			
				htmlData.append(tdTextStr);
				htmlData.append(spanTextStr);
				htmlData.append(main[0][1]);				
				htmlData.append(cspanStr);
				htmlData.append(cspanStr);
				htmlData.append(ctdStr);
				htmlData.append(ctrStr);
				htmlData.append(ctbodyStr);
				htmlData.append(ctableStr);		
			}	
			htmlData.append(brStr);
		}				
	}

	public static void drawGroupHead(String[][] group, int template, boolean kSubGroup){
		
		if (group.length>0){
			if ((template !=3) && (template !=4)){
				htmlData.append(tableStr);
			}
			else if(kSubGroup)
			{
				htmlData.append(tableStr);
			}
			else
			{
				htmlData.append(tableLinearStr);
			}			
			htmlData.append(tbodyStr);
			if ((template !=3) && (template !=4)){
				htmlData.append(trStr);		
			}
			else 
			{
				htmlData.append(trStrLC);		
			}
				
			htmlData.append(tdGroupHeadStr);
			htmlData.append(spanGroupHeadStr);						
			htmlData.append(group[0][0]);
			
			if (group[0][1].length()>0){
				htmlData.append(",");				
				htmlData.append(group[0][1]);				
			}		
			htmlData.append(cspanStr);
			htmlData.append(ctdStr);
			htmlData.append(ctrStr);
			if ((template !=3) && (template !=4)){
				htmlData.append(ctbodyStr);
				htmlData.append(ctableStr);	
				htmlData.append(brStr);	
			}							
		}	
		
	}
	public static void drawSubHead(String[][] sub, int template){
		
		if ( !(sub == null) && (sub.length>0)){
			if ((template !=3) && (template !=4)){
				htmlData.append(tableStr);
			}
			else
			{
				htmlData.append(tableLinearStr);
			}
			
			htmlData.append(tbodyStr);
			if ((template !=3) && (template !=4)){
				htmlData.append(trStr);		
			}
			else 
			{
				htmlData.append(trStrLC);		
			}						
			htmlData.append(tdSubGroupHeadStr);
			htmlData.append(spanColorStr);
			htmlData.append(spanSubGroupHeadStr);
			htmlData.append(spanFontFamStr);					
			htmlData.append(sub[0][0]);
			htmlData.append(cspanStr);
			htmlData.append(cspanStr);
			htmlData.append(cspanStr);
			htmlData.append(ctdStr);
			htmlData.append(ctrStr);			
			if (sub[0][1].length()>0){
				htmlData.append(trStr);			
				htmlData.append(tdTextStr);
				htmlData.append(spanTextStr);
				htmlData.append(sub[0][1]);				
				htmlData.append(cspanStr);
				htmlData.append(cspanStr);
				htmlData.append(ctdStr);
				htmlData.append(ctrStr);
			}	
			if ((template !=3) && (template !=4)){
				htmlData.append(ctbodyStr);
				htmlData.append(ctableStr);	
				htmlData.append(brStr);	
			}
							
		}	
		
	}
	
	public static void drawText(String[][] text){

		boolean trFlag = false; // Added by Sethu

		if (text.length>0){
			htmlData.append(tableStr);
			htmlData.append(tbodyStr);
			//htmlData.append(trStr);			
			for (int i=0;i<text.length;i++){
				if (i%4==0){					
					htmlData.append(trStr);		
				}
				htmlData.append(tdStr);
				htmlData.append(spanTextStr);						
				htmlData.append(text[i][0]);
				htmlData.append(cspanStr);
				htmlData.append(cspanStr);
				if (!(text[i][1].equalsIgnoreCase("- none"))){
					htmlData.append(spaceStr);
					htmlData.append(": -");
					htmlData.append(spaceStr);
					htmlData.append(text[i][1]);
					htmlData.append(spaceStr);
				}
				htmlData.append(ctdStr);
				if ((i>0) && (i%3==0)){		//Changed by Sethu
					htmlData.append(ctrStr);
					trFlag = true;
				}
			}
			if (!trFlag){					//Changed by Sethu
				htmlData.append(ctrStr);
			}
			htmlData.append(ctbodyStr);
			htmlData.append(ctableStr);
			htmlData.append(brStr);	
			
		}		
		
	}
	public static void drawTable(String[][] text){

		//System.out.println(" *** text.length 1123 *** "+text.length);
		
		if (text.length>0){
			htmlData.append(tableDataStr);
			htmlData.append(theadStr);	
			
			htmlData.append(trTableStr);			
	
			for (int i=0;i<1;i++){	

				//System.out.println(" *** text.length *** "+text.length+" *** text[i].length *** "+text[i].length);
				
				for (int j=0;j<text[i].length-1;j++){	
					
					if (j==0){
						htmlData.append("<td class=\"thickBorder\" style=\"border-bottom: green 1px solid; text-align: center\" valign=\"center\" width=250px height=30px>");
					}
					if (j==1){
						htmlData.append("<td class=\"thickBorder\" style=\"border-bottom: green 1px solid; text-align: center\" valign=\"center\" width=100px height=30px>");
					}
					if (j==2){
						htmlData.append("<td class=\"thickBorder\" style=\"border-bottom: green 1px solid; text-align: center\" valign=\"center\" width=125px height=30px>");
					}
					if (j==3){
						htmlData.append("<td class=\"thickBorder\"style=\"border-bottom: green 1px solid; text-align: center\" valign=\"center\" width=150px height=30px>");
					}
					if (j==4){
						htmlData.append("<td class=\"thickBorder\" style=\"border-bottom: green 1px solid; text-align: center\" valign=\"center\" width=125px height=30px>");
					}
					
					
					htmlData.append(strongStr);	
					htmlData.append(spanTableHeadStr);
					//htmlData.append(thStr);	
					//System.out.println(" *** text["+i+"]["+j+"] *** "+text[i][j]);
					htmlData.append(text[i][j]);
					//htmlData.append(cthStr);	
					htmlData.append(cspanStr);
					htmlData.append(cspanStr);
					htmlData.append(cspanStr);
					htmlData.append(cStrongStr);
					htmlData.append(ctdStr);	
					
				}
				
				
			}	
			
			htmlData.append(ctrStr);	
			htmlData.append(ctheadStr);
			htmlData.append(tbodyStr);	

			//System.out.println(" *** After For Loop in drawTable*** ");	

			
			StringBuffer strTableLine = new StringBuffer();

			for (int i=1;i<text.length;i++){
				//System.out.println( " ************ text.length *********** "+text.length+" *********** "+text[i].length);
				strTableLine = new StringBuffer();		
				for (int j=0;j<text[i].length-1;j++){
					strTableLine.append(text[i][j]);
					strTableLine.append("$$$");
				}

				//System.out.println(strTableLine);
			}

			for (int i=1;i<text.length;i++){
				htmlData.append(trTableStr);		
				for (int j=0;j<text[i].length-1;j++){
					if (j==0){
						htmlData.append("<td class=\"thickBorder\" style=\"text-align: left\" valign=\"center\" width=250px height=30px>");
					}
					if (j==1){
						htmlData.append("<td class=\"thickBorder\" style=\"text-align: center\" valign=\"center\" width=100px height=30px>");
					}
					if (j==2){
						htmlData.append("<td class=\"thickBorder\" style=\"border-bottom: "+text[i][text[i].length-1]+" 3px solid; text-align: center\"  valign=\"center\" width=125px height=30px>");
					}
					if (j==3){
						htmlData.append("<td class=\"thickBorder\" style=\"text-align: center\" valign=\"center\" width=150px height=30px>");
					}
					if (j==4){
						htmlData.append("<td class=\"thickBorder\" style=\"text-align: center\" valign=\"center\" width=125px height=30px>");
					}
					if (j==0){
						htmlData.append(strongStr);
					}
					htmlData.append(spanTextStr);	
					if (text[i][j].length()>0){
						htmlData.append(text[i][j]);
					}
					else
					{
						htmlData.append("&nbsp;");
					}
					
					htmlData.append(cspanStr);
					htmlData.append(cspanStr);					
					if (j==0){
						htmlData.append(cStrongStr);
					}
					htmlData.append(ctdStr);					
				}
				htmlData.append(ctrStr);
			}				
			
			htmlData.append(tfootStr);
			htmlData.append(ctfootStr);
			htmlData.append(ctbodyStr);
			htmlData.append(ctableStr);	
			htmlData.append(brStr);	
		}
		
		
	}
	
	public static void drawTable(Element Node, String[][] text, int template){
		
		int colSpan = 0;		
		String headerStr = "";	
		String remarksStr = "";
		String uomStr = "";
		String tdTableSubGroupHeadStr = "";
		
		String tdCellBBColorStr = "";
		String tdBgColorStr = "";
		
		String hexColor = "";
		
		boolean kSubGroupHeadFlag = false;
		
		if (text.length>0){		
			
			colSpan = text[0].length;
	
			tdTableSubGroupHeadStr = "<td style=\"border-bottom:1px solid green;  text-align: left\" valign=\"bottom\" colspan="+colSpan+">";
			
			if (Node.getParentElement().getName().equalsIgnoreCase("group")){				
				headerStr =  Node.getParentElement().getAttributeValue("name");	
				uomStr =  Node.getParentElement().getAttributeValue("UOM");	
				remarksStr = Node.getParentElement().getAttributeValue("remarks");
			}
			else if (Node.getParentElement().getName().equalsIgnoreCase("subgroup"))
			{
				if (!(Node.getParentElement().getAttributeValue("name").equalsIgnoreCase("empty")))
				{
					kSubGroupHeadFlag = true;
					headerStr =  Node.getParentElement().getAttributeValue("name");
					uomStr =  Node.getParentElement().getAttributeValue("UOM");	
					remarksStr = Node.getParentElement().getAttributeValue("remarks");
				}
				else
				{
					if (Node.getParentElement().getParentElement().getName().equalsIgnoreCase("group")){
						if (!(Node.getParentElement().getParentElement().getAttributeValue("name").equalsIgnoreCase("empty")))
						{
							kSubGroupHeadFlag = true;			
							headerStr =  Node.getParentElement().getParentElement().getAttributeValue("name");
							uomStr =  Node.getParentElement().getParentElement().getAttributeValue("UOM");	
							remarksStr = Node.getParentElement().getParentElement().getAttributeValue("remarks");
						}
						
					}
				}
				
			}
			
			htmlData.append(tableTempStr);
			htmlData.append(theadStr);
				htmlData.append(trTableStr);
				htmlData.append(thStr);
					if (kSubGroupHeadFlag){
						htmlData.append(tableTempStr);
						htmlData.append(tbodyStr);
						htmlData.append(trTableStr);
						
							if (headerStr.length()> 0){
								htmlData.append(tdSubGroupHeadStr);
							}
							else
							{
									htmlData.append(tdNormalStr); 
								}
								
								htmlData.append(spanColorStr);
								htmlData.append(spanSubGroupHeadStr);
								htmlData.append(spanFontFamStr);					
								htmlData.append(headerStr);
								if (uomStr.length()>0){
									htmlData.append(", "+uomStr);
								}
								htmlData.append(cspanStr);
								htmlData.append(cspanStr);
								htmlData.append(cspanStr);
								htmlData.append(ctdStr);
							
							htmlData.append(ctrStr);
							
							if (remarksStr.length()>0){
								htmlData.append(trTableStr);			
								htmlData.append(tdTextStr);
								htmlData.append(spanTextStr);
								htmlData.append(remarksStr);				
								htmlData.append(cspanStr);
								htmlData.append(cspanStr);
								htmlData.append(ctdStr);
								htmlData.append(ctrStr);
							}				
							
						htmlData.append(ctbodyStr);
						htmlData.append(ctableStr);	
						htmlData.append(brStr);	
					}
				htmlData.append(cthStr);
				htmlData.append(ctrStr);
				
				htmlData.append(trTableStr);
				htmlData.append(thStr);
			
					htmlData.append(tableTempStr);
					htmlData.append(trTableStr);
					htmlData.append(thStr);
					
			//--------------------------------------------
			
						htmlData.append(tableDataStr);
						htmlData.append(tbodyStr);
						htmlData.append(trTableStr);
				
						for (int i=0;i<1;i++){		
							
							for (int j=0;j<text[i].length-2;j++){		
								
								if (text[i][j].equalsIgnoreCase("p")){
									htmlData.append("<td class=\"thickBorder\" style=\"text-align: center\" valign=\"center\" width=250px height=30px>");
								}
								if (text[i][j].equalsIgnoreCase("u")){
									htmlData.append("<td class=\"thickBorder\" style=\"text-align: center\" valign=\"center\" width=100px height=30px>");
								}
								if (text[i][j].equalsIgnoreCase("v")){
									htmlData.append("<td class=\"thickBorder\" style=\"text-align: center\" valign=\"center\" width=125px height=30px>");
								}
								if (text[i][j].equalsIgnoreCase("y")){
									htmlData.append("<td class=\"thickBorder\" style=\"text-align: center\" valign=\"center\" width=150px height=30px>");
								}
								if (text[i][j].equalsIgnoreCase("r")){
									htmlData.append("<td class=\"thickBorder\" style=\"text-align: center\" valign=\"center\" width=125px height=30px>");
								}	
								
								htmlData.append(strongStr);	
								htmlData.append(spanTableHeadStr);
								//System.out.println( " *** text["+i+1+"]["+j+"] 1396 *** "+text[i+1][j]);
								htmlData.append(text[i+1][j]);
								htmlData.append(cspanStr);
								htmlData.append(cspanStr);
								htmlData.append(cspanStr);
								htmlData.append(cStrongStr);
								htmlData.append(ctdStr);	
								
							}				
						}		
						
						htmlData.append(ctrStr);
				
						htmlData.append(ctbodyStr);
						htmlData.append(ctableStr);	
					
			//------------------------------------------------------
					
					htmlData.append(cthStr);
					htmlData.append(ctrStr);
					htmlData.append(ctableStr);	
				
				htmlData.append(cthStr);
				htmlData.append(ctrStr);
			
			htmlData.append(ctheadStr);			
			
			htmlData.append(tbodyStr);
			//-------------------------------------------------------
			htmlData.append(trTableStr);
			htmlData.append(thStr);
				htmlData.append(tableTempStr);
				htmlData.append(tbodyStr);
				htmlData.append("<tr height=0px >");
				htmlData.append(ctrStr);				
				htmlData.append(ctbodyStr);
				htmlData.append(ctableStr);	
			htmlData.append(cthStr);
			htmlData.append(ctrStr);		
			
			//-------------------------------------------------------
			
			htmlData.append(trNotesStr);
			htmlData.append(thStr);
			//htmlData.append(tdNormalStr);
				htmlData.append(tableDataStr);					
				
			for (int i=0;i<text.length-2;i++){
				htmlData.append(trStr);				
				
				for (int j=0;j<text[i+2].length-2;j++){		
					
					if (text[0][j].equalsIgnoreCase("p")){
						htmlData.append("<td class=\"thickBorder\" style=\"text-align: left\" valign=\"center\" width=250px height=30px>");
					}
					if (text[0][j].equalsIgnoreCase("u")){
						htmlData.append("<td class=\"thickBorder\" style=\"text-align: center\" valign=\"center\" width=100px height=30px>");
					}
					if (text[0][j].equalsIgnoreCase("v")){
						
						if (tbl_cell_bborder_fill_flag == 1){ 
							
							if (text[i+2][text[i+2].length-2].length()>0){
								tdCellBBColorStr = "border-bottom: "+text[i+2][text[i+2].length-1]+" 3px solid;";
							}
							else
								tdCellBBColorStr = "";
						}
						else
						{
							tdCellBBColorStr = "";
						}						
						
						//System.out.println( " *** 1474 ***");

						if (tbl_cell_color_fill_flag == 1){ 
							if (text[i+2][text[i+2].length-2].length()>0){
								hexColor = text[i+2][text[i+2].length-2];
								Color color = Color.decode(hexColor);							
								Color highlight = brighten(color, 0.64, 0.25, 0.52);	
								String hexShade = String.format("#%02x%02x%02x", highlight.getRed(), highlight.getGreen(), highlight.getBlue());
								
								tdCellBBColorStr = tdCellBBColorStr + " background-color: "+hexShade+";";
							
							}
							else
								tdCellBBColorStr = tdCellBBColorStr + "";
						}
						
						htmlData.append("<td class=\"thickBorder\" style=\""+tdCellBBColorStr+"  text-align: center\"  valign=\"center\" width=125px height=30px>");
						
						//System.out.println( " *** 1492 ***");
						
					}
					if (text[0][j].equalsIgnoreCase("y")){
						htmlData.append("<td class=\"thickBorder\" style=\"text-align: center\" valign=\"center\" width=150px height=30px>");
					}
					if (text[0][j].equalsIgnoreCase("r")){
						htmlData.append("<td class=\"thickBorder\" style=\"text-align: center\" valign=\"center\" width=125px height=30px>");
					}
					
					//System.out.println( " *** 1520 ***");
					
					if (j==0){
						htmlData.append(strongStr);
					}
					htmlData.append(spanTextStr);					
					if (text[i+2][j].length()>0){
						htmlData.append(text[i+2][j]);
					}
					htmlData.append(cspanStr);					
					
					if (j==0){
						htmlData.append(cStrongStr);
					}

					if (j==0){
						htmlData.append("</br>");
						htmlData.append(spanSmallTextStr);
						
						//System.out.println( " *** text["+i+2+"][text["+i+2+"].length-1] ***"+text[i+2][text[i+2].length-1]);
						
						if (text[i+2][text[i+2].length-1].length()>0){
							htmlData.append(text[i+2][text[i+2].length-1]);
						}
						htmlData.append(cspanStr);
					}
					
					htmlData.append(ctdStr);					
				}
				
				htmlData.append(ctrStr);
			}	
			
			htmlData.append(ctableStr);
			
			htmlData.append(cthStr);
			htmlData.append(ctrStr);			
			
			htmlData.append(tfootStr);
			htmlData.append(ctfootStr);
			htmlData.append(ctbodyStr);			
			htmlData.append(ctableStr);	
			htmlData.append(brStr);	
		}	
		
	}
	
	public static void drawLinearGauge(String divID, String[][] range, String[][] split, String[][] values, int subGroupCount){
		
		String iFrameTag = "";
		String pageSource = "";
		String divTag = "", scriptTag="";

		String splitRange = "";	
		
		//int xAxisMin=0, xAxisMax=0, pValue=0;
		double xAxisMin=0.0, xAxisMax=0.0, pValue=0.0;
		
		Double dPValue = 0.0;
	
		if (range.length>0){			
			//xAxisMin = Integer.parseInt(range[0][0]);
			//xAxisMax = Integer.parseInt(range[0][1]);
			xAxisMin = Double.parseDouble(range[0][0]);
			xAxisMax = Double.parseDouble(range[0][1]);					

		}		
		 
		if (values.length>0){
			//pValue = Integer.parseInt(values[0][0]);
			//dPValue = new Double(values[0][0]);
		}		

		if (split.length>0){
			for (int i=0;i<split.length;i++){
				for (int j=0;j<split[i].length;j++){
					if (j<split[i].length-1){
						splitRange = splitRange+split[i][j]+"~";
					}
					else
					{
						splitRange = splitRange+split[i][j];
					}					
				}	
				if (i<split.length-1){
					splitRange = splitRange + "@";
				}				
			}
		}		
		
		if (splitRange.length() > 0)
		{
			splitRange = splitRange.replace('#', '>');
		}

		//divID = "DIVID";
		pageSource = "../../eCA/jsp/ES_Kendo_Linear.jsp?divID="+divID+"&xAxisMin="+xAxisMin+"&xAxisMax="+xAxisMax+"&splitRange="+splitRange+"&pValue="+values[0][0];
		
		//pageSource = "encodeURI('../../eCA/jsp/ES_Kendo_Linear_Head.jsp?divID="+divID+"&xAxisMin="+xAxisMin+"&xAxisMax="+xAxisMax+"&splitRange="+splitRange+"&pValue="+pValue+"')";

		iFrameTag = "<iframe name=\""+divID+"\" frameborder=\"0\" id=\""+divID+"\" src=\""+pageSource+"\" width=\"100%\"   height = \"70px\" scrolling =\"no\"></iframe>";	
		
		//divTag = "<div id=\""+divID+"\"> </div>";
		//scriptTag = "<script> $('#"+divID+"').load("+pageSource+", function() {});</script>";		
		
		if (values.length>0){			
			htmlData.append(trStrLC);			
			htmlData.append(tdValignStr); //changes made here  
			
				htmlData.append("<table class=\"breakTableLC\" align=\"left\" border=\"0\" cellpadding=\"2\" cellspacing=\"2\" width=450px >");
				htmlData.append(tbodyStr);
				htmlData.append(trStrLC);
				
					htmlData.append("<td width=\"100px\"></td>");
					htmlData.append("<td width=\"25px\" height=\"25px\" align=\"right\" style=\"border:3px solid "+values[0][1]+";\" text-align:center\">");
					htmlData.append(strongStr);
					htmlData.append(spanBlackColorStr);
					htmlData.append(spanFontSize11Str);
					htmlData.append(spanFontFamStr);	
					htmlData.append(values[0][0]);
					htmlData.append(cspanStr);
					htmlData.append(cspanStr);
					htmlData.append(cspanStr);
					htmlData.append(cStrongStr);
					htmlData.append(ctdStr);
				
					htmlData.append(tdLinearLeftStr);	
					htmlData.append(spanColorStr);
					htmlData.append(spanFontSize11Str);
					htmlData.append(spanFontFamStr);
					htmlData.append(spaceStr);
					htmlData.append(spaceStr);
					htmlData.append(values[0][2]);
					htmlData.append(cspanStr);
					htmlData.append(cspanStr);
					htmlData.append(cspanStr);
					htmlData.append(ctdStr);
				
				htmlData.append(ctrStr);
				htmlData.append(ctbodyStr);
				htmlData.append(ctableStr);	
			
			htmlData.append(ctdStr);
			htmlData.append(ctrStr);
			
			htmlData.append(trStrLC);			
			htmlData.append(tdLinearCenterStr);				
			htmlData.append(iFrameTag); // Commented by Sethu to check printing
			//htmlData.append(divTag);
			//htmlData.append(scriptTag);
			htmlData.append(ctdStr);
			htmlData.append(ctrStr);
			
			htmlData.append(trStrLC);			
			htmlData.append(tdLinearRightStr);	
			htmlData.append(spanColorStr);
			htmlData.append(spanFontSize11Str);
			htmlData.append(spanFontFamStr);	
			htmlData.append(values[0][3]);
			htmlData.append(cspanStr);
			htmlData.append(cspanStr);
			htmlData.append(cspanStr);
			htmlData.append(ctdStr);
			htmlData.append(ctrStr);
			htmlData.append(ctbodyStr);
			htmlData.append(ctableStr);	
			
			htmlData.append(ctdStr);
			
					
		}	
		
	}

	public static String[][] returnLGraphRangeValues(Element Node){
		String[][] lineRangeArray = new String[1][6];		
		List<Element> rangeList = null;		
		Element rangeNode = null;			
		
		rangeList = Node.getChildren("TemplateRange");		
		
		for (int t=0;t<rangeList.size();t++){
			rangeNode = (Element) rangeList.get(t);	
			lineRangeArray[t][0] = rangeNode.getAttributeValue("RangeFrom");
			lineRangeArray[t][1] = rangeNode.getAttributeValue("RangeTo");
			lineRangeArray[t][2] = rangeNode.getAttributeValue("TemplateSplit");				
		}
		rangeList = Node.getChildren("ValueRange");		
		
		for (int t=0;t<rangeList.size();t++){
			rangeNode = (Element) rangeList.get(t);			
			lineRangeArray[t][3] = rangeNode.getAttributeValue("dataPlot");	
			lineRangeArray[t][4] = rangeNode.getAttributeValue("xDataType");
			lineRangeArray[t][5] = rangeNode.getAttributeValue("yDataType");				
		}
		
		return lineRangeArray;
		
	}

	public static String[][] returnLGraphValues(Element Node){
		String[][] lineSplitArray = null;		

		List<Element> rangeList = null;		
		Element rangeNode = null;					
		
		rangeList = Node.getChild("ValueRange").getChildren();
		
		lineSplitArray = new String[rangeList.size()][2];	
		
		for (int i=0;i < rangeList.size();i++){			
			rangeNode = (Element) rangeList.get(i);	
			lineSplitArray[i][0] = rangeNode.getAttributeValue("xAxis");
			lineSplitArray[i][1] = rangeNode.getAttributeValue("yAxis");			
		}
		return lineSplitArray;
		
	}

	public static void drawLineGraph(String divID, String[][] range, String[][] split, String[][] values, int subGroupCount){
		
		String iFrameTag = "";
		String divTag = "", scriptTag="";
		//int dataCount = 0;	
		String pageSource = "";
	
		
		String splitRange = "";
		String valuesRange = "";	

		//int tdRangeDiff = 0;
		double tdRangeDiff = 0.0;
		
		//int tdRangeTot = 0;
		double tdRangeTot = 0.0;

		//int totHeight = 0;
		double totHeight = 0.0;

		//dataCount = subGroupCount - 1;
		
		//int yAxisMin=0, yAxisMax=0;
		double yAxisMin=0.0, yAxisMax=0.0;
		
		String xAxisDataType = "", yAxisDataType = "";
		
		if (range.length>0){
			if (range[0][0] != null){
				//yAxisMin = Integer.parseInt(range[0][0]);
				yAxisMin = Double.parseDouble(range[0][0]);
			}
			if (range[0][1] != null){
				//yAxisMax = Integer.parseInt(range[0][1]);
				yAxisMax = Double.parseDouble(range[0][1]);
			}
			xAxisDataType = range[0][4];
			yAxisDataType = range[0][5];
			totHeight = yAxisMax - yAxisMin;
		}	
		if (split != null) {
			if (split.length>0){
				for (int i=0;i<split.length;i++){
					
					for (int j=0;j<split[i].length;j++){
						if (j<split[i].length-1){
							splitRange = splitRange+split[i][j]+"~";
						}
						else
						{
							splitRange = splitRange+split[i][j];
						}					
					}	
					if (i<split.length-1){
						splitRange = splitRange + "@";
					}
					if (split[i][1] != null)
						split[i][1]= "0";
					
					if (split[i][0] != null)
						split[i][0]= "0";
					
					tdRangeDiff = Double.parseDouble(split[i][1]) - Double.parseDouble(split[i][0]);
					tdRangeTot = tdRangeTot + tdRangeDiff;
				}
			}
		}
		
		if (splitRange.length() > 0)
		{
			splitRange = splitRange.replace('#', '>');
		}
		
		tdRangeDiff = 0;

		if (values.length>0){
			for (int i=0;i<values.length;i++){
				for (int j=0;j<values[i].length;j++){
					if (j<values[i].length-1){
						valuesRange = valuesRange+values[i][j]+"~";
					}
					else
					{
						valuesRange = valuesRange+values[i][j];
					}					
				}	
				if (i<values.length-1){
					valuesRange = valuesRange + "@";
				}
			}
		}	
		
		String[][] lineRange = null;		
		String[] ranges = null;
		
		String[] rangeArray = splitRange.split("@");		
		
		for (int x=0; x<rangeArray.length; x++)
		{			
			ranges = rangeArray[x].split("~");			
		}
		lineRange = new String[rangeArray.length][ranges.length];		
		
		for (int x=0; x<rangeArray.length; x++)
		{						
			ranges = rangeArray[x].split("~");			
			for (int y=0;y<ranges.length;y++){
				lineRange[x][y] =  ranges[y];				
			}			
		}
		
		//pageSource for iFrame
		//pageSource = "../../eCA/jsp/ES_Kendo_LineChart.jsp?divID="+divID+"&yAxisMin="+yAxisMin+"&yAxisMax="+yAxisMax+"&xAxisDataType="+xAxisDataType+"&yAxisDataType="+yAxisDataType+"&splitRange="+splitRange+"&valuesRange="+valuesRange;
		
		//pageSource for div tag
		pageSource = "encodeURI('../../eCA/jsp/ES_Kendo_LineChart_Head.jsp?divID="+divID+"&yAxisMin="+yAxisMin+"&yAxisMax="+yAxisMax+"&xAxisDataType="+xAxisDataType+"&yAxisDataType="+yAxisDataType+"&splitRange="+splitRange+"&valuesRange="+valuesRange+"')";

		//iFrameTag = "<iframe frameborder=\"0\" id=\""+divID+"\" src=\""+pageSource+"\" width=\"100%\"   height = \"250px\" scrolling =\"no\"></iframe>";
		
		divTag = "<div id=\""+divID+"\"> </div>";
		scriptTag = "<script> $('#"+divID+"').load("+pageSource+", function() {});</script>";

		//if (split.length>0){				
			
			htmlData.append(trStr);			
			htmlData.append(tdLinearCenterStr);
			//htmlData.append(iFrameTag); // Commented by Sethu to check printing
			htmlData.append(divTag);
			htmlData.append(scriptTag);
			htmlData.append(ctdStr);
			htmlData.append(ctrStr);			
			htmlData.append(ctbodyStr);
			htmlData.append(ctableStr);	
			
			htmlData.append(ctdStr);			
			
		//}			
	}
	public static String[][] returnNotesData(Element Node){
		String[][] notesDataArray = new String[1][5];		
		List<Element> notesList = null;		
		Element notesNode = null;			
		
		notesList = Node.getChildren("NotesText");		
		notesDataArray = new String[notesList.size()][5];
		
		for (int t=0;t<notesList.size();t++){
			notesNode = (Element) notesList.get(t);	
			notesDataArray[t][0] = notesNode.getAttributeValue("notesType");
			notesDataArray[t][1] = notesNode.getAttributeValue("queryColumn");
			notesDataArray[t][2] = notesNode.getAttributeValue("columnName");
			notesDataArray[t][3] = notesNode.getAttributeValue("columnData");
			notesDataArray[t][4] = notesNode.getAttributeValue("dataTable");	
		}
		
		return notesDataArray;
		
	}
	public static void drawNotesData(String divID, String[][] notesData){
		
		String pageSource = "";		
		String queryColumn = "";
		String columnName = "";
		String columnData = "";
		String dataTable = "";
		String divTag = "";
		String scriptTag = "";

		String divStr = "";
		
		for (int i=0;i<notesData.length;i++){
			
			queryColumn = notesData[i][1];
			columnName = notesData[i][2];
			columnData = notesData[i][3];
			dataTable = notesData[i][4];	
			
			columnData = columnData.replace('#', '>');
			
			divCount++;
			divStr = divID + Integer.toString(divCount);
			
			//divID = divID + i;
			
			pageSource = "../../eCA/jsp/ES_Notes.jsp?divID="+divStr+"&queryColumn="+queryColumn+"&columnName="+columnName+"&columnData="+columnData+"&dataTable="+dataTable;
			
			divTag = "<div id=\""+divStr+"\"> </div>";
			scriptTag = "<script> $('#"+divStr+"').load('"+pageSource+"', function() {});</script>";
			
			htmlData.append(tableNotesStr);
			htmlData.append(tbodyStr);
			htmlData.append(trNotesStr);			
			htmlData.append(tdNormalStr);
			
			htmlData.append(divTag);
			htmlData.append(scriptTag);
			
			htmlData.append(ctdStr);
			htmlData.append(ctrStr);			
			htmlData.append(ctbodyStr);
			htmlData.append(ctableStr);
			
						
		}
		
	}
	
	public static Color brighten(Color color, double fraction1, double fraction2, double fraction3) {

        int red = (int) Math.round(Math.min(255, color.getRed() + 255 * fraction1));
        int green = (int) Math.round(Math.min(255, color.getGreen() + 255 * fraction2));
        int blue = (int) Math.round(Math.min(255, color.getBlue() + 255 * fraction3));

        int alpha = color.getAlpha();

        return new Color(red, green, blue, alpha);

    }
}
