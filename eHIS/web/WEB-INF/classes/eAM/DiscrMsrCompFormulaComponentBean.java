/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.sql.*;
import java.util.*;

public class DiscrMsrCompFormulaComponentBean implements java.io.Serializable 
{
	public DiscrMsrCompFormulaComponentBean(){}
	public synchronized String getJavaScriptForFormulaXML(String definition,String formulaCompId,int formulaCompSrlNo)
	{
		definition = definition.replace('~',' ');		
		StringBuffer scriptFuntionCode=new StringBuffer("<SCRIPT>");
		scriptFuntionCode.append("function getFormulaResult"+formulaCompId+formulaCompSrlNo+"(){");
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
						compId=st.nextToken();
						srlNo=st.nextToken();
					}catch(Exception e)
					{
					  e.printStackTrace();
					}
					scriptFuntionCode.append("var comp"+srlNo+count+"; if(document.forms[0]."+(compId+srlNo)+"!=null)comp"+srlNo+count+"=document.forms[0]."+(compId+srlNo)+".value;");
                                        //scriptFuntionCode.append("if(
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
			/*if(!checkExpression(remainingString))
			{
				return compTempered;
				//out.println("<script>alert('Invalid Expression')</script>");	
				//detail="";
			}*/
			scriptFuntionCode.append("var result="+formulaString+";if(!isNaN(result)) document.forms[0]."+formulaCompId+formulaCompSrlNo+".value=result;");
			scriptFuntionCode.append("}</SCRIPT>");
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
	private boolean checkExpression(String str)
	{
		char[] charArr=str.toCharArray();
		for(int i=0;i<charArr.length;i++)
		{
			if(charArr[i]=='(' || charArr[i]==')' || charArr[i]=='+' || charArr[i]=='-' || charArr[i]=='*' || charArr[i]=='/' || charArr[i]==' ')
			{
			}
			else
			{
				return false;
			}
		}
		return true;
	}

}
