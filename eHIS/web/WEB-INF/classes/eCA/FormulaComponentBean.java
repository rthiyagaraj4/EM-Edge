/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
11/04/2017  IN061905       	DineshT     25/4/2016		Ramesh G   			The Scoring functionality In Notes should work in the similar manner as in Charts i.e on selection of individual variable, the score gets automatically calculated.
08/05/2017	IN063962		Dinesh T									ML-MMOH-CRF-0557_UT1
19/01/2018	IN066159		Dinesh T	19/01/2018		Ramesh G			970734 LIVE - Formula component error in Clinical Note
19/06/2019	SCRIPT_ERROR_FORMULA	DineshT	19/06/2019	Ramesh G		Script error when using formula component along with history component
--------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.sql.*;
import java.util.*;

public class FormulaComponentBean implements java.io.Serializable 
{
	public FormulaComponentBean(){}
	public synchronized String getJavaScriptForDateFormula(String definition,String formulaCompId,int formulaCompSrlNo, String formulaResultUnit, String formula_result_type)
    {
		String srlNo = "";
		String compId = "";
		int plusIndex = definition.indexOf("+");
		//int minusIndex = definition.indexOf("-");
		String formula_operator = (plusIndex != -1) ?"PLUS":"MINUS";

        //StringBuffer scriptFuntionCode=new StringBuffer("<SCRIPT>");//IN061905
        StringBuilder scriptFuntionCode=new StringBuilder("<SCRIPT>");//IN061905
        scriptFuntionCode.append("function getFormulaResult"+formulaCompId+formulaCompSrlNo+"(){");
        try
        {
			int i = definition.indexOf("$$$");
			int j = definition.indexOf("###");
			String firstComponent = definition.substring(i+3, j);

			//StringBuffer temp = new StringBuffer(definition);			
			scriptFuntionCode.append("var firstComponent;");
			scriptFuntionCode.append("var secondComponent;");
			scriptFuntionCode.append("var sysDateTimeInEnYN = 'N';");//IN063962
			if(!firstComponent.equals(""))
			{
				if(firstComponent.indexOf("!") != -1)
				{
					StringTokenizer strToken = new StringTokenizer(firstComponent, "!");
					String tempCompId = strToken.nextToken();
					compId = "C_" + tempCompId;
					srlNo = strToken.nextToken();				

					if((compId + srlNo).equals("C_systemDateTime99999A") || (compId + srlNo).equals("C_systemDate99999A"))
					{
						compId = tempCompId;
						scriptFuntionCode.append("sysDateTimeInEnYN = 'Y';");//IN063962
					}

					scriptFuntionCode.append("if (document.RecClinicalNotesTemplateForm." + compId + srlNo + " != null)");
					scriptFuntionCode.append("{");
					scriptFuntionCode.append("firstComponent = document.RecClinicalNotesTemplateForm." + compId + srlNo  + ".value;");
					scriptFuntionCode.append("}");

				}
			}
			i = definition.indexOf("$$$", j);
			j = definition.indexOf("###",j+3);
			String secondComponent ="";
			
			secondComponent = definition.substring(i+3,j);

			if(!secondComponent.equals(""))
			{
				if(secondComponent.indexOf("!") != -1)
				{
					StringTokenizer strToken = new StringTokenizer(secondComponent, "!");
					String tempCompId = strToken.nextToken();
					compId = "C_" + tempCompId;				
					srlNo = strToken.nextToken();

					if((compId + srlNo).equals("C_systemDateTime99999A") || (compId + srlNo).equals("C_systemDate99999A"))
					{
						compId = tempCompId;
						scriptFuntionCode.append("sysDateTimeInEnYN = 'Y';");//IN063962
					}

					scriptFuntionCode.append("if (document.RecClinicalNotesTemplateForm." + compId + srlNo + " != null)");
					scriptFuntionCode.append("{");
					scriptFuntionCode.append("secondComponent = document.RecClinicalNotesTemplateForm." + compId + srlNo  + ".value;");
					scriptFuntionCode.append("}");
				}
				else
				{
					scriptFuntionCode.append("secondComponent = " +  secondComponent + ";");			
				}
			}
			scriptFuntionCode.append("if (firstComponent != null &amp;&amp; secondComponent != null)");
			scriptFuntionCode.append("{");
			scriptFuntionCode.append("	var messageFrameReference = getMessageFrame();");
			scriptFuntionCode.append("	if(messageFrameReference != null)");
			scriptFuntionCode.append("	{");
			scriptFuntionCode.append("		var HTML = '&lt;form name=\"DateFormulaComputationForm\" action=\"..\\\\..\\\\eCA\\\\jsp\\\\RecClinicalNotesComputeDateFormula.jsp\" &gt;'; ");//IN033149
			scriptFuntionCode.append("		HTML += '&lt;input type=\"hidden\" name = \"firstComponent\" value = \"' + firstComponent + '\"&gt;';");
			scriptFuntionCode.append("		HTML += '&lt;input type=\"hidden\" name = \"secondComponent\" value = \"' + secondComponent + '\"&gt;';");
			scriptFuntionCode.append("		HTML += '&lt;input type=\"hidden\" name = \"formulaResultUnit\" value = \"" +  formulaResultUnit +"\"&gt;';");
			scriptFuntionCode.append("		HTML += '&lt;input type=\"hidden\" name = \"formulaCompID\" value = \"" +  (formulaCompId+formulaCompSrlNo) +"\"&gt;';");
			scriptFuntionCode.append("		HTML += '&lt;input type=\"hidden\" name = \"formula_result_type\" value = \"" +  formula_result_type +"\"&gt;';");			
			scriptFuntionCode.append("		HTML += '&lt;input type=\"hidden\" name = \"formula_operator\" value = \"" +  formula_operator +"\"&gt;';");
			scriptFuntionCode.append("		HTML += '&lt;input type=\"hidden\" name = \"sysDateTimeInEnYN\" value = \"' +  sysDateTimeInEnYN +'\"&gt;';");//IN063962
			scriptFuntionCode.append("		HTML += '&lt;/form&gt;';");
			scriptFuntionCode.append("		messageFrameReference.document.body.insertAdjacentHTML('AfterBegin', HTML);");
			scriptFuntionCode.append("		messageFrameReference.document.DateFormulaComputationForm.submit();");
			scriptFuntionCode.append("	}");
			scriptFuntionCode.append("}");
			//scriptFuntionCode.append("}</SCRIPT>");//IN061905
			scriptFuntionCode.append("}");//IN061905
			scriptFuntionCode.append(getJavaScriptForDateFormulaOnLoadUnload(definition,formulaCompId,formulaCompSrlNo, formulaResultUnit, formula_result_type));//IN061905
			scriptFuntionCode.append("</SCRIPT>");//IN061905
		}
        catch(Exception e)
        {
			e.printStackTrace();            
        }
        return scriptFuntionCode.toString();
    }
	
	public synchronized String getJavaScriptForFormulaXML(String definition,String formulaCompId,int formulaCompSrlNo, int nDecimalDigit)	
	{
		String unManipulatedDefn = definition;//SCRIPT_ERROR_FORMULA
		definition = definition.replace('~',' ');		
		StringBuffer scriptFuntionCode=new StringBuffer("<SCRIPT>");
		scriptFuntionCode.append("function getFormulaResult"+formulaCompId+formulaCompSrlNo+"(){");
		//scriptFuntionCode.append("isDataAvail='N';");//IN061905//Commented For IN066159
		String formulaString=definition;
		String remainingString=definition;
		StringBuffer temp  = null;
		StringBuffer temp1 = null;
		StringBuffer temp2 = null;
		StringTokenizer st = null;
		String compIdSrlNo = "";
		String compId="";
		String srlNo="";
		int count = 0;
		String compTempered = "<SCRIPT>function getFormulaResult"+formulaCompId+formulaCompSrlNo+"(){alert('Component Tempered');}</SCRIPT>";
		try
		{
			while(definition.indexOf("$$$")!=-1)
			{
				int i=definition.indexOf("$$$");
				int j=definition.indexOf("###");

				int ii=formulaString.indexOf("$$$");
				int jj=formulaString.indexOf("###");

				int iii=remainingString.indexOf("$$$");
				int jjj=remainingString.indexOf("###");

				//out.println(i+"   "+j);
				if((j<i))
				{
					return compTempered;
				}
				else if((definition.substring(i+3,j).indexOf("$$$")!=-1) )
				{
					return compTempered;
				}
				compIdSrlNo=definition.substring(i+3,j);
				compId="";
				srlNo="";
				if(!compIdSrlNo.equals(""))
				{
					try
					{
						st=new StringTokenizer(compIdSrlNo,"!");
						compId="C_" + st.nextToken();
						srlNo=st.nextToken();
					}catch(Exception e)
					{
						e.printStackTrace();
						
					}
						scriptFuntionCode.append("var comp"+srlNo+count+";if(document.forms[0]."+(compId+srlNo)+"!=null)");//IN061905//Uncommented For IN066159
						//scriptFuntionCode.append("var comp"+srlNo+count+"=0;if(document.forms[0]."+(compId+srlNo)+"!=null)");//IN061905//Commented For IN066159
						scriptFuntionCode.append("{");
						//scriptFuntionCode.append("if (document.forms[0]."+(compId+srlNo)+".value!=''){if('Y'!= isDataAvail){isDataAvail='Y';}}if (document.forms[0]."+(compId+srlNo)+".value!=''){");//IN061905//Commented For IN066159
						scriptFuntionCode.append("if(document.forms[0]."+(compId+srlNo)+".type=='select-one')");
						scriptFuntionCode.append("{");
					//scriptFuntionCode.append("	if(document.forms[0]."+(compId+srlNo)+"(document.forms[0]." + (compId+srlNo)+".selectedIndex).score == 'undefined') ");
					//scriptFuntionCode.append("	{");
						scriptFuntionCode.append("  if(document.forms[0]." + (compId+srlNo)+".selectedIndex>-1){"); //IN061298
						scriptFuntionCode.append("		var temp_var = document.forms[0]."+(compId+srlNo)+"(document.forms[0]." + (compId+srlNo)+".selectedIndex).value;");
						scriptFuntionCode.append("	    var score_text =  document.forms[0]."+(compId+srlNo)+"_score"+".value;");
						scriptFuntionCode.append("	     var split_appendText = score_text.split('###');");
						scriptFuntionCode.append("	     for(i = 0; i &lt; split_appendText.length;i++)");
						scriptFuntionCode.append("	     {");
						scriptFuntionCode.append("	         var  split_score= split_appendText[i].split('~');");
						scriptFuntionCode.append("	         if(temp_var == split_score[0])                       ");
						scriptFuntionCode.append("			{   ");          
						scriptFuntionCode.append("					comp"+srlNo+count+" = split_score[1];  ");           
						scriptFuntionCode.append("					i = split_appendText.length;                      ");          
						scriptFuntionCode.append("			}   ");          
					    scriptFuntionCode.append("		 }");
					    //scriptFuntionCode.append("	}else{comp"+srlNo+count+"=0;}"); //IN061298//Commented For IN066159
						scriptFuntionCode.append("		 }");//Added For IN066159
						
					//	scriptFuntionCode.append("	}");
					//	scriptFuntionCode.append(" else");
					//	scriptFuntionCode.append("	{");
					//	scriptFuntionCode.append("		comp"+srlNo+count+" = document.forms[0]."+(compId+srlNo)+"(document.forms[0]." + (compId+srlNo)+".selectedIndex).score;");
				//		scriptFuntionCode.append("	}");
						scriptFuntionCode.append("}");
						scriptFuntionCode.append("else ");
						scriptFuntionCode.append("{if(!isNaN(document.forms[0]."+(compId+srlNo)+".value))");
						scriptFuntionCode.append("		comp"+srlNo+count+"=document.forms[0]."+(compId+srlNo)+".value;");
						scriptFuntionCode.append("}");
						//scriptFuntionCode.append("isDataAvail='Y';");//IN061905//Commented For IN066159
						//scriptFuntionCode.append("}");//IN061905//Commented For IN066159
						scriptFuntionCode.append("}");

/*
				scriptFuntionCode.append("var comp"+srlNo+count+"; if(document.forms[0]."+(compId+srlNo)+"!=null)");
					scriptFuntionCode.append("{");
					scriptFuntionCode.append("	if(document.forms[0]."+(compId+srlNo)+".type=='select-one')");
					scriptFuntionCode.append("	{");
					scriptFuntionCode.append("		comp"+srlNo+count+" = document.forms[0]."+(compId+srlNo)+"(document.forms[0]." + (compId+srlNo)+".selectedIndex).score;");
					scriptFuntionCode.append("	}");
					scriptFuntionCode.append("	else ");
					scriptFuntionCode.append("	{");
					scriptFuntionCode.append("		comp"+srlNo+count+"=document.forms[0]."+(compId+srlNo)+".value;");
					scriptFuntionCode.append("	}");
					scriptFuntionCode.append("}");
*/
				}
				temp=new StringBuffer(definition);
				temp1=new StringBuffer(formulaString);
				temp2=new StringBuffer(remainingString);
				temp1.replace(ii,jj+3,"eval(comp"+srlNo+count+")");
				//--------------
				temp2.replace(iii,jjj+3,"");
				remainingString=temp2.toString();
				//-------------------
				formulaString=temp1.toString();
				temp.replace(i,j+3,"");
				definition=temp.toString();
				count++;			

			}//end while			
			scriptFuntionCode.append("var result="+formulaString+";");
			//scriptFuntionCode.append("var roundedRes = roundNumber(result, "+nDecimalDigit+");");//IN061905
			//scriptFuntionCode.append("if(isDataAvail=='Y' || result !=''){var roundedRes = roundNumber(result, "+nDecimalDigit+");");//IN061905//Commented For IN066159
			scriptFuntionCode.append("if(result !='' || result==0){var roundedRes = roundNumber(result, "+nDecimalDigit+");");//IN061905//Commented For IN066159 //result==0 added for GHL-SCF-1644
			scriptFuntionCode.append("if(!isNaN(roundedRes))document.forms[0]."+formulaCompId+formulaCompSrlNo+".value=roundedRes;");
			scriptFuntionCode.append("else if(isNaN(roundedRes)) document.forms[0]."+formulaCompId+formulaCompSrlNo+".value='';");
			scriptFuntionCode.append("}");//IN061905
			scriptFuntionCode.append("}");//SCRIPT_ERROR_FORMULA
			//scriptFuntionCode.append("else document.forms[0]."+formulaCompId+formulaCompSrlNo+".value='';");//IN061905//Commented For IN066159
			scriptFuntionCode.append(getJavaScriptForFormulaXMLOnLoadUnload(unManipulatedDefn,formulaCompId,formulaCompSrlNo,nDecimalDigit,definition));
			//scriptFuntionCode.append("}</SCRIPT>");//SCRIPT_ERROR_FORMULA
			scriptFuntionCode.append("</SCRIPT>");//SCRIPT_ERROR_FORMULA
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			temp  = null;
			temp1 = null;
			temp2 = null;
			st = null;
			
		}

		return scriptFuntionCode.toString();

	}
	
	//IN061905, starts
	public synchronized String getJavaScriptForDateFormulaOnLoadUnload(String definition,String formulaCompId,int formulaCompSrlNo, String formulaResultUnit, String formula_result_type)
	{
		String srlNo = "";
		String compId = "";
		int plusIndex = definition.indexOf("+");
		String formula_operator = (plusIndex != -1) ?"PLUS":"MINUS";
        StringBuilder scriptFuntionCode=new StringBuilder("");              

        try
        {
			int i = definition.indexOf("$$$");
			int j = definition.indexOf("###");
			String firstComponent = definition.substring(i+3, j);

			scriptFuntionCode.append("function getFormulaResultLoadUnload"+formulaCompId+formulaCompSrlNo+"(){");  
			scriptFuntionCode.append("var firstComponent;");
			scriptFuntionCode.append("var secondComponent;");
			scriptFuntionCode.append("var sysDateTimeInEnYN = 'N';");//IN063962

			if(!firstComponent.equals(""))
			{
				if(firstComponent.indexOf("!") != -1)
				{
					StringTokenizer strToken = new StringTokenizer(firstComponent, "!");
					String tempCompId = strToken.nextToken();
					compId = "C_" + tempCompId;
					srlNo = strToken.nextToken();				

					if((compId + srlNo).equals("C_systemDateTime99999A") || (compId + srlNo).equals("C_systemDate99999A"))
					{
						compId = tempCompId;
						scriptFuntionCode.append("sysDateTimeInEnYN = 'Y';");//IN063962
					}

					scriptFuntionCode.append("if (document.RecClinicalNotesTemplateForm." + compId + srlNo + " != null)");
					scriptFuntionCode.append("{");
					scriptFuntionCode.append("firstComponent = document.RecClinicalNotesTemplateForm." + compId + srlNo  + ".value;");
					scriptFuntionCode.append("}");
				}
			}

			i = definition.indexOf("$$$", j);
			j = definition.indexOf("###",j+3);
			String secondComponent ="";
			
			secondComponent = definition.substring(i+3,j);

			if(!secondComponent.equals(""))
			{
				if(secondComponent.indexOf("!") != -1)
				{
					StringTokenizer strToken = new StringTokenizer(secondComponent, "!");
					String tempCompId = strToken.nextToken();
					compId = "C_" + tempCompId;				
					srlNo = strToken.nextToken();

					if((compId + srlNo).equals("C_systemDateTime99999A") || (compId + srlNo).equals("C_systemDate99999A"))
					{
						compId = tempCompId;
						scriptFuntionCode.append("sysDateTimeInEnYN = 'Y';");//IN063962
					}

					scriptFuntionCode.append("if (document.RecClinicalNotesTemplateForm." + compId + srlNo + " != null)");
					scriptFuntionCode.append("{");
					scriptFuntionCode.append("secondComponent = document.RecClinicalNotesTemplateForm." + compId + srlNo  + ".value;");
					scriptFuntionCode.append("}");
				}
				else
				{
					scriptFuntionCode.append("secondComponent = " +  secondComponent + ";");					
				}
			}

			scriptFuntionCode.append("if (firstComponent != null &amp;&amp; secondComponent !='')");
			scriptFuntionCode.append("{");
			//scriptFuntionCode.append("populateValue(firstComponent,secondComponent,'"+formulaResultUnit+"','"+(formulaCompId+formulaCompSrlNo)+"','"+formula_result_type+"','"+formula_operator+"')");//IN063962
			scriptFuntionCode.append("populateValue(firstComponent,secondComponent,'"+formulaResultUnit+"','"+(formulaCompId+formulaCompSrlNo)+"','"+formula_result_type+"','"+formula_operator+"',sysDateTimeInEnYN)");//IN063962
			scriptFuntionCode.append("}");			
			scriptFuntionCode.append("}");
		}
        catch(Exception e)
        {
			e.printStackTrace();            
        }

		return scriptFuntionCode.toString();
	}
	//IN061905, ends
	
	//SCRIPT_ERROR_FORMULA, starts
	public synchronized String getJavaScriptForFormulaXMLOnLoadUnload(String definition,String formulaCompId,int formulaCompSrlNo, int nDecimalDigit,String formula_operator)
	{
		definition = definition.replace('~',' ');		
		StringBuffer scriptFuntionCode=new StringBuffer("<SCRIPT>");
		scriptFuntionCode.append("function getFormulaResultLoadUnload"+formulaCompId+formulaCompSrlNo+"(){");
		String formulaString=definition;
		String remainingString=definition;
		StringBuffer temp  = null;
		StringBuffer temp1 = null;
		StringBuffer temp2 = null;
		StringTokenizer st = null;
		String compIdSrlNo = "";
		String compId="";
		String srlNo="";
		int count = 0;
		String compTempered = "<SCRIPT>function getFormulaResultLoadUnload"+formulaCompId+formulaCompSrlNo+"(){alert('Component Tempered');}</SCRIPT>";
		
		try
		{
			while(definition.indexOf("$$$")!=-1)
			{
				int i=definition.indexOf("$$$");
				int j=definition.indexOf("###");
				
				int ii=formulaString.indexOf("$$$");
				int jj=formulaString.indexOf("###");
				
				int iii=remainingString.indexOf("$$$");
				int jjj=remainingString.indexOf("###");
				
				if((j<i))
				{
					return compTempered;
				}
				else if((definition.substring(i+3,j).indexOf("$$$")!=-1) )
				{
					return compTempered;
				}
				compIdSrlNo=definition.substring(i+3,j);
				compId="";
				srlNo="";
				
				if(!compIdSrlNo.equals(""))
				{
					try
					{
						st=new StringTokenizer(compIdSrlNo,"!");
						compId="C_" + st.nextToken();
						srlNo=st.nextToken();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					scriptFuntionCode.append("var comp"+srlNo+count+";if(document.forms[0]."+(compId+srlNo)+"!=null)");//IN061905//Uncommented For IN066159
					scriptFuntionCode.append("{");
					scriptFuntionCode.append("if(document.forms[0]."+(compId+srlNo)+".type=='select-one')");
					scriptFuntionCode.append("{");					
					scriptFuntionCode.append("  if(document.forms[0]." + (compId+srlNo)+".selectedIndex>-1){"); //IN061298
					scriptFuntionCode.append("		var temp_var = document.forms[0]."+(compId+srlNo)+"(document.forms[0]." + (compId+srlNo)+".selectedIndex).value;");
					scriptFuntionCode.append("	    var score_text =  document.forms[0]."+(compId+srlNo)+"_score"+".value;");
					scriptFuntionCode.append("	     var split_appendText = score_text.split('###');");
					scriptFuntionCode.append("	     for(i = 0; i &lt; split_appendText.length;i++)");
					scriptFuntionCode.append("	     {");
					scriptFuntionCode.append("	         var  split_score= split_appendText[i].split('~');");
					scriptFuntionCode.append("	         if(temp_var == split_score[0])                       ");
					scriptFuntionCode.append("			{   ");          
					scriptFuntionCode.append("					comp"+srlNo+count+" = split_score[1];  ");           
					scriptFuntionCode.append("					i = split_appendText.length;                      ");          
					scriptFuntionCode.append("			}   ");          
					scriptFuntionCode.append("		 }");
					scriptFuntionCode.append("		 }");			
					scriptFuntionCode.append("}");
					scriptFuntionCode.append("else ");
					scriptFuntionCode.append("{if(!isNaN(document.forms[0]."+(compId+srlNo)+".value))");
					scriptFuntionCode.append("		comp"+srlNo+count+"=document.forms[0]."+(compId+srlNo)+".value;");
					scriptFuntionCode.append("}");
					scriptFuntionCode.append("}");
				}
				
				temp=new StringBuffer(definition);
				temp1=new StringBuffer(formulaString);
				temp2=new StringBuffer(remainingString);
				temp1.replace(ii,jj+3,"eval(comp"+srlNo+count+")");
				//--------------
				temp2.replace(iii,jjj+3,"");
				remainingString=temp2.toString();
				//-------------------
				formulaString=temp1.toString();
				temp.replace(i,j+3,"");
				definition=temp.toString();
				count++;
			}
			
			scriptFuntionCode.append("var result="+formulaString+";");
			scriptFuntionCode.append("if(result !='' || result==0){var roundedRes = roundNumber(result, "+nDecimalDigit+");");  //result==0 added for GHL-SCF-1644
			scriptFuntionCode.append("if(!isNaN(roundedRes))document.forms[0]."+formulaCompId+formulaCompSrlNo+".value=roundedRes;");
			scriptFuntionCode.append("else if(isNaN(roundedRes)) document.forms[0]."+formulaCompId+formulaCompSrlNo+".value='';");
			scriptFuntionCode.append("}");
			scriptFuntionCode.append("}");
			scriptFuntionCode.append("</SCRIPT>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			temp  = null;
			temp1 = null;
			temp2 = null;
			st = null;			
		}
		
		return scriptFuntionCode.toString();
	}//SCRIPT_ERROR_FORMULA, ends
}
