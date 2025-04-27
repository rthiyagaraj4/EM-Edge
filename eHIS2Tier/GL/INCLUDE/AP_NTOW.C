#include <stdio.h>

char one[10][8] = {"","ONE ","TWO ","THREE ","FOUR ","FIVE ","SIX ","SEVEN ","EIGHT ","NINE "};

char teens[10][12] = {"TEN ","ELEVEN ","TWELVE ","THIRTEEN ","FOURTEEN ","FIFTEEN ", "SIXTEEN ","SEVENTEEN ","EIGHTEEN ","NINETEEN "};

char tens[10][12] = { "TEN ","TWENTY ","THIRTY ","FORTY ","FIFTY ","SIXTY ","SEVENTY ","EIGHTY ","NINETY "};

extern double atof();

char n_out_str[10][132];

char s[1000];

print_in_words(l_number,l_length,l_sub_cur_str,l_out_str)

double l_number;
int l_length;
char l_out_str[][133];

/********* ADDED BY VENKAT ON (20/04/1998)************/
char l_sub_cur_str[10];
/****************************************************/

{
    int j,k;
    long i;
    double n,n1,x;

/*
    for (j =0;j<10;j++)
	s[i][0] = '\0';
*/

    n=l_number;

	/***** ADDED TO PRINT ZERO INCASE OF ZERO (27/04/1998) ******/
    if ( l_number == 0.00 )    
	{
		j = 0;
	    strcpy(l_out_str,"*** NIL ***");
		return 1;
	} 
	
	/************************************************************/


    if (n > ((double) 999999999999.99)) return (0);

	strcpy(s,"");
	n1=n;
    
	if(n >= 1000000000) {
	    x=n/1000000000;
	    i=x;
	    l_convert(i);
	    strcat(s,"BILLION ");
	    n=n-((double)i*1000000000);
	}
    
	if(n >= 1000000) {
	    i=n/1000000;
	    l_convert(i);
	    strcat(s,"MILLION ");
	    n=n-(i*1000000);
	}
    
	if(n >= 1000) {
	    i=n/1000;
	    l_convert(i);
	    strcat(s,"THOUSAND ");
	    n=n-(i*1000);
	}
    
	i=n;
	if(i > 0) {
	    l_convert(i);
	    n=n-i;
	}

    if(!s[0])
	strcat(s,"ZERO ");

    i = get_dec(n1);

    if(i>0) {
/*------------- ADDED BY VENKAT ON 06/05/1998-----------*/
 if (l_number < 1)
	{
		sprintf(s,"ZERO AND %s ",l_sub_cur_str);
	}
 else
 {
		sprintf(s,"%s AND %s ",s,l_sub_cur_str);
	}

	// strcat(s,"AND FILS  ");
	l_convert(i);
    }
/*-------------------------------------------------------*/
  
	
	strcat(s," ONLY ");
    for (k =0;k<10;k++)
    {
      strcpy(l_out_str[k],"");
    }
    j = l_split(l_length)+1;
    for (k =0;k<j;k++)
    {
      n_ltrim(n_out_str[k]);
      strcpy(l_out_str[k],n_out_str[k]);
  }
  return j;
}

l_convert(num)
int num;
{

int x,and;
and = 0;

    if(num >= 100) {
	x=num/100;
	strcat(s,one[x]);
	strcat(s,"HUNDRED ");
	num=num-(x*100);
	if(num) and = 1;
    }
    if(num >= 10 && num <20) {
	if(and) {
	    strcat(s,"AND ");
	    and = 0;
	}
	strcat(s,teens[num-10]);
	return 0;
    }


    if(num >= 20) {
	if(and) {
	    strcat(s,"AND ");
	    and = 0;
	}
	x=num/10;
	strcat(s,tens[x-1]);
	num=num-(x*10);
    }

    if (num < 10) {
	if(and) 
	    strcat(s,"AND ");
	strcat(s,one[num]);
    }
}

get_dec(n1)
double n1;
{

    char d1[20],d2[3];
    int j;

    sprintf(d1,"%15.2f",n1);
    j=strlen(d1)-1;
    d2[2] = '\0';
    d2[1] = d1[j--];
    d2[0] = d1[j];

    return atoi(d2);
}

l_split(n)
int n;
{
    int i = 0, j = 0,k = 0,l = 0,m = 0,p = 0,z = 0;

    for (k=0;;k++)
    {
       if (s[i] == '\0') break;
       for (m = 0,i= p;i<p + n;i++,m++)
       {
	   n_out_str[k][m] = s[i];
	   if (s[i] == '\0')
	   {
	       z = 1;
	       break;
	   }
       }
       if (s[i] == '\0') break;
       l = m;
       j = l;
       if (z == 0)
       {
	  for (j=l;j>=0;j--)
	  {
	     if (n_out_str[k][j] == ' ') break;
	  }
	  p += j;
	  n_out_str[k][j] = '\0';
       }
       else
       {
	  n_out_str[k][j] = '\0';
	  break;
       }
    }
    return (k);
}

n_ltrim(l_str)
char *l_str;
{
   char *ptr;
   ptr = l_str;
   while (*ptr== ' ') ptr++;
   for(;*ptr!='\0';ptr++,l_str++)
    *l_str = *ptr;
   *l_str = '\0';
}
