/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;
public class Comparisons1 {
public StringBuffer combineThem(String mystr1,String mystr2)
{
	StringBuffer str11=new StringBuffer();
	StringBuffer str22=new StringBuffer();
	str11.append(" "+mystr1);
	str22.append(" "+mystr2);
	
	/*for(int i=0;i<str11.length();i++)
	{
		if(str11.charAt(i)=='<'){
			//str11.delete(i,1);
			//str11.insert(i,"&lt;");
			str11.replace(i,i+1,"&lt;");
		}
		if(str11.charAt(i)=='>'){
			//str11.delete(i,1);
			//str11.insert(i,"&gt;");
			str11.replace(i,i+1,"&gt;");
		}
		if(str11.charAt(i)=='"'){
			//str11.delete(i,1);
			//str11.insert(i,"&lt;");
			str11.replace(i,i+1,"&quot;");
		}
				
	}

	for(int i=0;i<str22.length();i++)
	{
		if(str22.charAt(i)=='<'){
			//str11.delete(i,1);
			//str11.insert(i,"&lt;");
			str22.replace(i,i+1,"&lt;");
		}
		if(str22.charAt(i)=='>'){
			//str11.delete(i,1);
			//str11.insert(i,"&gt;");
			str22.replace(i,i+1,"&gt;");
		}
		if(str22.charAt(i)=='"'){
			//str11.delete(i,1);
			//str11.insert(i,"&lt;");
			str22.replace(i,i+1,"&quot;");
		}
		

	}*/
	String str1=new String(str11);
	String str2=new String(str22);
	//String str1=mystr1;
	//String str2=mystr2;
	
	String[] s1=str1.split(" ");
	String[] s2=str2.split(" ");
	int k=0,j=0;
	int l=0;
	int s1_index[]=new int[s1.length];
	int s2_index[]=new int[s2.length];
	int c1_index[]=new int[s1.length];
	int c2_index[]=new int[s2.length];
	for(int d=0;d<s1.length;d++)
		s1_index[d]=-1;
			
	for(int d=0;d<s2.length;d++)
		s2_index[d]=-1;

	
	if(s1.length<=s2.length)
	{
		for(int i=0;i<s1.length;)
		{	
			while(j<s2.length)
			{
				if(!(s1[i].equals(s2[j])))
				{
					k=j+1;
					while(k<s2.length)
					{ 
						if(!(s1[i].equals(s2[k])))
						{
							k++;
						}
						else
						{	
							s1_index[l]=i;s2_index[l]=k;l++;
							break;
						}
					}		
				}
				else
				{
					s1_index[l]=i;s2_index[l]=j;l++;
				}
				break;
			}
			i++;j++;			
		}
	}
	else if(s1.length>s2.length)
	{
		for(int i=0;i<s2.length;)
		{	
			while(j<s1.length)
			{
				if(!(s2[i].equals(s1[j])))
				{
					k=i+1;
					while(k<s1.length)
					{
						if(!(s2[i].equals(s1[k])))
						{
							k++;
						}
						else
						{	
							s2_index[l]=j;s1_index[l]=k;l++;
							break;
						}
					}
				}
				else
				{
					s1_index[l]=i;s2_index[l]=j;l++;
				}
				break;
			}
			i++;j++;
		}
	}

	
	int c=0;

	for(int i=0,d=0;i<s1.length;i++)
	{
		if(s1_index[d]==i)
		{
			d++;
		}
		else
		{	
			if(d>0){
			c1_index[c]=i;
			c2_index[c]=s2_index[d-1]+1;
			c++;}
		}
	}

	StringBuffer disp=new StringBuffer();

	//int jj=0;
	for(int ll=0,lk=0;lk<s2.length;lk++)
	{
		if(s2_index[ll]==lk)
		{
			ll++;
			
			disp.append("<font size='4'>"+" "+s2[lk]+"</font>");

	/*%>
			<font size="4"><%=s2[lk] %></font>	
	<%*/	}
		else
		{
			for(int ii=0;ii<c2_index.length;ii++)
			{
				if(lk==c2_index[ii])
				{
					disp.append("<font color=red size='4'><strike>"+" "+s1[c1_index[ii]]+"</strike></font>");
				/*%>
				<font color=red size="4"><strike><%=s1[c1_index[ii]]%></strike></font>	
			<%	*/}
			}
		disp.append("<font color=green size='4'><u>"+" "+s2[lk]+"</u></font>");
		/*%>
		<font color=green size="4"><%=s2[lk] %></font>	
	<%	*/}
	}



return disp;
}	
}



