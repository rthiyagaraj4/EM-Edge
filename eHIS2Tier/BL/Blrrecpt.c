
/* Result Sets Interface */
#ifndef SQL_CRSR
#  define SQL_CRSR
  struct sql_cursor
  {
    unsigned int curocn;
    void *ptr1;
    void *ptr2;
    unsigned long magic;
  };
  typedef struct sql_cursor sql_cursor;
  typedef struct sql_cursor SQL_CURSOR;
#endif /* SQL_CRSR */

/* Thread Safety */
typedef void * sql_context;
typedef void * SQL_CONTEXT;

/* Object support */
struct sqltvn
{
  unsigned char *tvnvsn; 
  unsigned short tvnvsnl; 
  unsigned char *tvnnm;
  unsigned short tvnnml; 
  unsigned char *tvnsnm;
  unsigned short tvnsnml;
};
typedef struct sqltvn sqltvn;

struct sqladts
{
  unsigned int adtvsn; 
  unsigned short adtmode; 
  unsigned short adtnum;  
  sqltvn adttvn[1];       
};
typedef struct sqladts sqladts;

static struct sqladts sqladt = {
  1,1,0,
};

/* Binding to PL/SQL Records */
struct sqltdss
{
  unsigned int tdsvsn; 
  unsigned short tdsnum; 
  unsigned char *tdsval[1]; 
};
typedef struct sqltdss sqltdss;
static struct sqltdss sqltds =
{
  1,
  0,
};

/* File name & Package Name */
struct sqlcxp
{
  unsigned short fillen;
           char  filnam[32];
};
static const struct sqlcxp sqlfpn =
{
    31,
    "T:\\BL\\handover\\PROC\\Blrrecpt.pc"
};


static unsigned long sqlctx = 2038190629;


static struct sqlexd {
   unsigned int   sqlvsn;
   unsigned int   arrsiz;
   unsigned int   iters;
   unsigned int   offset;
   unsigned short selerr;
   unsigned short sqlety;
   unsigned int   occurs;
      const short *cud;
   unsigned char  *sqlest;
      const char  *stmt;
   sqladts *sqladtp;
   sqltdss *sqltdsp;
            void  **sqphsv;
   unsigned int   *sqphsl;
            int   *sqphss;
            void  **sqpind;
            int   *sqpins;
   unsigned int   *sqparm;
   unsigned int   **sqparc;
   unsigned short  *sqpadto;
   unsigned short  *sqptdso;
            void  *sqhstv[37];
   unsigned int   sqhstl[37];
            int   sqhsts[37];
            void  *sqindv[37];
            int   sqinds[37];
   unsigned int   sqharm[37];
   unsigned int   *sqharc[37];
   unsigned short  sqadto[37];
   unsigned short  sqtdso[37];
} sqlstm = {10,37};

/* SQLLIB Prototypes */
extern void sqlcxt (void **, unsigned long *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlcx2t(void **, unsigned long *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlbuft(void **, char *);
extern void sqlgs2t(void **, char *);
extern void sqlorat(void **, unsigned long *, void *);

/* Forms Interface */
static const int IAPSUCC = 0;
static const int IAPFAIL = 1403;
static const int IAPFTL  = 535;
extern void sqliem(char *, int *);

 static const char *sq0013 = 
"select ORG_DOC_TYPE_CODE ,ORG_DOC_NUM  from BL_PATIENT_LEDGER where (((((EPI\
SODE_TYPE=:b0 and PATIENT_ID=:b1) and EPISODE_ID=:b2) and NVL(VISIT_ID,1)=NVL(\
:b3,NVL(VISIT_ID,1))) and (AD_PR_ADJ_BILL_DOC_TYPE,AD_PR_ADJ_BILL_DOC_NUM) in \
(select BILL_DOC_TYPE_CODE ,BILL_DOC_NUM  from BL_BILLS_FOR_CONS_RECEIPT where\
 (DOC_TYPE_CODE=:b4 and DOC_NUMBER=:b5))) and RECPT_NATURE_CODE in ('AD','PR')\
) order by 1            ";

 static const char *sq0014 = 
"select ORG_DOC_TYPE_CODE ,ORG_DOC_NUM  from BL_PATIENT_LEDGER where ((((((EP\
ISODE_TYPE=:b0 and PATIENT_ID=:b1) and EPISODE_ID=:b2) and NVL(VISIT_ID,1)=NVL\
(:b3,NVL(VISIT_ID,1))) and AD_PR_ADJ_BILL_DOC_TYPE=:b4) and AD_PR_ADJ_BILL_DOC\
_NUM=:b5) and RECPT_NATURE_CODE in ('AD','PR')) order by 1            ";

 static const char *sq0015 = 
"select a.BLNG_SERV_CODE ,a.DEPOSIT_AMT ,b.long_desc  from BL_RCPT_RFND_SERVI\
CE_DTL a ,BL_BLNG_SERV B where ((a.DOC_TYPE_CODE=:b0 and a.DOC_NUMBER=To_NUMBE\
R(:b1)) and a.blng_serv_code=b.blng_serv_code) order by 1            ";

 static const char *sq0101 = 
"select distinct ext_acct_facility_id ,ext_acct_code ,ext_acct_dept_code  fro\
m bl_bills_for_cons_Receipt where (doc_type_code=:b0 and doc_number=:b1)      \
     ";

 static const char *sq0102 = 
"select bill_doc_type_code ,bill_doc_num  from bl_bills_for_cons_Receipt wher\
e (doc_type_code=:b0 and doc_number=:b1)           ";

 static const char *sq0103 = 
"etween NVL(TO_DATE(:b6,'DD/MM/YYYYHH24:MI:SS'),TO_DATE('01/01/100000:00:00',\
'DD/MM/YYYYHH24:MI:SS')) and NVL(TO_DATE(:b7,'DD/MM/YYYYHH24:MI:SS'),TO_DATE('\
01/01/400023:59:59','DD/MM/YYYYHH24:MI:SS'))) for update of print_flag nowait ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,180,0,4,407,0,0,5,2,0,1,0,1,3,0,0,2,9,0,0,2,3,0,0,2,9,0,0,1,9,0,0,
40,0,0,2,109,0,6,428,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,2,1,0,0,2,9,0,0,
71,0,0,3,108,0,4,447,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
98,0,0,4,137,0,4,472,0,0,5,1,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
133,0,0,5,164,0,4,497,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
160,0,0,6,101,0,4,519,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
187,0,0,7,236,0,4,529,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
210,0,0,8,305,0,6,571,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,2,
9,0,0,
249,0,0,9,0,0,30,625,0,0,0,0,0,1,0,
264,0,0,10,0,0,27,631,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
295,0,0,11,96,0,4,695,0,0,3,1,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,
322,0,0,12,267,0,4,795,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,
365,0,0,13,412,0,9,1181,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
404,0,0,14,302,0,9,1183,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
443,0,0,13,0,0,13,1202,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
466,0,0,14,0,0,13,1206,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
489,0,0,13,0,0,15,1229,0,0,0,0,0,1,0,
504,0,0,14,0,0,15,1231,0,0,0,0,0,1,0,
519,0,0,15,223,0,9,1252,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
542,0,0,15,0,0,15,1271,0,0,0,0,0,1,0,
557,0,0,15,0,0,13,1281,0,0,3,0,0,1,0,2,9,0,0,2,4,0,0,2,9,0,0,
584,0,0,16,93,0,5,1323,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
607,0,0,17,268,0,4,1434,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
630,0,0,18,91,0,4,1446,0,0,1,0,0,1,0,2,9,0,0,
649,0,0,19,268,0,4,1456,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
672,0,0,20,91,0,4,1468,0,0,1,0,0,1,0,2,9,0,0,
691,0,0,21,268,0,4,1479,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
714,0,0,22,91,0,4,1491,0,0,1,0,0,1,0,2,9,0,0,
733,0,0,23,268,0,4,1501,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
756,0,0,24,91,0,4,1513,0,0,1,0,0,1,0,2,9,0,0,
775,0,0,25,268,0,4,1523,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
798,0,0,26,91,0,4,1535,0,0,1,0,0,1,0,2,9,0,0,
817,0,0,27,268,0,4,1545,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
840,0,0,28,91,0,4,1557,0,0,1,0,0,1,0,2,9,0,0,
859,0,0,29,268,0,4,1567,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
882,0,0,30,91,0,4,1579,0,0,1,0,0,1,0,2,9,0,0,
901,0,0,31,268,0,4,1589,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
924,0,0,32,91,0,4,1601,0,0,1,0,0,1,0,2,9,0,0,
943,0,0,33,268,0,4,1611,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
966,0,0,34,91,0,4,1623,0,0,1,0,0,1,0,2,9,0,0,
985,0,0,35,268,0,4,1633,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1008,0,0,36,91,0,4,1645,0,0,1,0,0,1,0,2,9,0,0,
1027,0,0,37,268,0,4,1655,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1050,0,0,38,91,0,4,1667,0,0,1,0,0,1,0,2,9,0,0,
1069,0,0,39,268,0,4,1677,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1092,0,0,40,91,0,4,1689,0,0,1,0,0,1,0,2,9,0,0,
1111,0,0,41,268,0,4,1700,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1134,0,0,42,91,0,4,1712,0,0,1,0,0,1,0,2,9,0,0,
1153,0,0,43,268,0,4,1723,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1176,0,0,44,91,0,4,1735,0,0,1,0,0,1,0,2,9,0,0,
1195,0,0,45,268,0,4,1745,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1218,0,0,46,91,0,4,1757,0,0,1,0,0,1,0,2,9,0,0,
1237,0,0,47,268,0,4,1767,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1260,0,0,48,91,0,4,1779,0,0,1,0,0,1,0,2,9,0,0,
1279,0,0,49,268,0,4,1789,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1302,0,0,50,91,0,4,1801,0,0,1,0,0,1,0,2,9,0,0,
1321,0,0,51,268,0,4,1812,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1344,0,0,52,91,0,4,1824,0,0,1,0,0,1,0,2,9,0,0,
1363,0,0,53,268,0,4,1835,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1386,0,0,54,91,0,4,1847,0,0,1,0,0,1,0,2,9,0,0,
1405,0,0,55,350,0,4,1858,0,0,3,2,0,1,0,1,3,0,0,2,9,0,0,1,9,0,0,
1432,0,0,56,198,0,4,1872,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
1455,0,0,57,268,0,4,1884,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1478,0,0,58,91,0,4,1896,0,0,1,0,0,1,0,2,9,0,0,
1497,0,0,59,350,0,4,1906,0,0,3,2,0,1,0,1,3,0,0,2,9,0,0,1,9,0,0,
1524,0,0,60,198,0,4,1919,0,0,2,1,0,1,0,1,3,0,0,2,9,0,0,
1547,0,0,61,268,0,4,1931,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1570,0,0,62,91,0,4,1943,0,0,1,0,0,1,0,2,9,0,0,
1589,0,0,63,268,0,4,1954,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1612,0,0,64,91,0,4,1966,0,0,1,0,0,1,0,2,9,0,0,
1631,0,0,65,268,0,4,1976,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1654,0,0,66,91,0,4,1988,0,0,1,0,0,1,0,2,9,0,0,
1673,0,0,67,248,0,4,1999,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1696,0,0,68,91,0,4,2011,0,0,1,0,0,1,0,2,9,0,0,
1715,0,0,69,248,0,4,2023,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1738,0,0,70,91,0,4,2035,0,0,1,0,0,1,0,2,9,0,0,
1757,0,0,71,248,0,4,2046,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1780,0,0,72,91,0,4,2058,0,0,1,0,0,1,0,2,9,0,0,
1799,0,0,73,248,0,4,2068,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1822,0,0,74,91,0,4,2080,0,0,1,0,0,1,0,2,9,0,0,
1841,0,0,75,248,0,4,2090,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1864,0,0,76,91,0,4,2102,0,0,1,0,0,1,0,2,9,0,0,
1883,0,0,77,248,0,4,2112,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1906,0,0,78,91,0,4,2124,0,0,1,0,0,1,0,2,9,0,0,
1925,0,0,79,248,0,4,2134,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1948,0,0,80,91,0,4,2146,0,0,1,0,0,1,0,2,9,0,0,
1967,0,0,81,248,0,4,2157,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
1990,0,0,82,91,0,4,2169,0,0,1,0,0,1,0,2,9,0,0,
2009,0,0,83,248,0,4,2180,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2032,0,0,84,91,0,4,2192,0,0,1,0,0,1,0,2,9,0,0,
2051,0,0,85,248,0,4,2204,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2074,0,0,86,91,0,4,2216,0,0,1,0,0,1,0,2,9,0,0,
2093,0,0,87,248,0,4,2227,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2116,0,0,88,91,0,4,2239,0,0,1,0,0,1,0,2,9,0,0,
2135,0,0,89,248,0,4,2250,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2158,0,0,90,91,0,4,2262,0,0,1,0,0,1,0,2,9,0,0,
2177,0,0,91,248,0,4,2273,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2200,0,0,92,91,0,4,2285,0,0,1,0,0,1,0,2,9,0,0,
2219,0,0,93,248,0,4,2295,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2242,0,0,94,91,0,4,2307,0,0,1,0,0,1,0,2,9,0,0,
2261,0,0,95,248,0,4,2317,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2284,0,0,96,91,0,4,2329,0,0,1,0,0,1,0,2,9,0,0,
2303,0,0,97,248,0,4,2339,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2326,0,0,98,91,0,4,2351,0,0,1,0,0,1,0,2,9,0,0,
2345,0,0,99,248,0,4,2362,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
2368,0,0,100,91,0,4,2374,0,0,1,0,0,1,0,2,9,0,0,
2387,0,0,101,159,0,9,2449,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2410,0,0,101,0,0,13,2461,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
2437,0,0,101,0,0,15,2510,0,0,0,0,0,1,0,
2452,0,0,102,127,0,9,2529,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2475,0,0,102,0,0,13,2540,0,0,2,0,0,1,0,2,9,0,0,2,3,0,0,
2498,0,0,102,0,0,15,2581,0,0,0,0,0,1,0,
2513,0,0,104,0,0,32,2818,0,0,0,0,0,1,0,
2528,0,0,103,1256,0,9,2865,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
2575,0,0,103,0,0,13,2944,0,0,37,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
1,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,
2738,0,0,105,0,0,32,2990,0,0,0,0,0,1,0,
2753,0,0,103,0,0,15,3048,0,0,0,0,0,1,0,
2768,0,0,106,365,0,6,3080,0,0,5,5,0,1,0,1,9,0,0,3,9,0,0,2,9,0,0,3,9,0,0,2,9,0,
0,
2803,0,0,107,292,0,6,3119,0,0,5,5,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,
0,
2838,0,0,108,184,0,6,3157,0,0,3,3,0,1,0,1,9,0,0,3,9,0,0,3,9,0,0,
2865,0,0,109,1354,0,6,3186,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,3,3,0,0,3,3,0,0,1,9,
0,0,2,9,0,0,2,9,0,0,3,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2924,0,0,110,190,0,4,3277,0,0,9,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
2975,0,0,111,91,0,2,3320,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
};


/************************************************************************/
/* OCS MEDICOM VER 1.0                                               */
/************************************************************************/
/* PROGRAM NAME          : BLRRECPT.PC                                  */
/* AUTHOR                : NITIN KUMAR                                  */
/* DATE WRITTEN          : 18-APR-1993                                  */
/* MODIFIED BY           : Aldrin Alberto for AMH                       */                                                                     
/*                                                                      */
/* CALLED FROM           :                                              */ 
/*                                                                      */
/*  FUNCTION             :                                              */
/*                                                                      */
/*  TABLE DETAILS                                                       */ 
/*                                                                      */
/*        S. No.     TABLENAMES             INPUT/OUTPUT                */
/*                                                                      */
/*         1.        BL_RECEIPT_REFUND_DTL     Query/Update             */
/*         2.        SY_PROG_CONTROL           Update/Lookup            */
/*         3.        SY_PROG_MESG                Insert                 */
/*                                                                      */
/*  PARAMETERS           :             -                                 */
/*                                                                      */
/*  SUBROUTINES          :                                              */
/*                                                                      */
/*         1.        ERR_MESG            err_mesg                       */
/*                                                                      */
/*                                                                      */
/*                                                                      */
/************************************************************************/
/* UPGRADED TO 4.1   */
                                             
/* All control-chars have been commented as they do not make sense on a DMP
   All reference to HK$ change to Dhs
   -  For American Hospital Implementation. -- G. Viswanath/31/7/1996
*/   

#include <stdio.h>
#include <string.h>
#include <math.h>
//#include <sqlca.h>
//#include <sqlda.h>
#include <bl.h>


/*
#define OERROR (sqlca.sqlcode < 0)
*/

#define LAST_ROW (sqlca.sqlcode == 1403)

#define NOT_FOUND (sqlca.sqlerrd[2] == 0)

#define MAX_LINES 80

#define ESC     0x1B

#define INIT_MESG       "Printing Receipt in progress"
#define ONLINE_PRINTING 1
/*
#define DEBUG 1
*/

#define SKIP_1 3
#define SKIP_2 64
#define SKIP_3 3
#define SKIP_4 10
#define SKIP_4_1 2
#define SKIP_5 22
#define SKIP_6 15
#define SKIP_6_1 15
#define SKIP_7 3
#define SKIP_8 13
#define SKIP_9 10


/* EXEC SQL BEGIN DECLARE SECTION; */ 



   /* VARCHAR uid_pwd      [132],
           hosp_name    [120],
           date_time    [20],
           user_id      [20],
           nd_pgm_date  [35],
	   nd_facility_name[31],
	   nd_service_desc[41],
	   nd_recpt_nature_code[3],
	   nd_blng_grp   [3],
	   nd_hcard_status[12],	
	   nd_service_code[11],
	   nd_hcard_num[21],
	   
	   nd_hcard_expiry_date[15],
	   nd_cash_counter_desc [16]; */ 
struct { unsigned short len; unsigned char arr[132]; } uid_pwd;

struct { unsigned short len; unsigned char arr[120]; } hosp_name;

struct { unsigned short len; unsigned char arr[20]; } date_time;

struct { unsigned short len; unsigned char arr[20]; } user_id;

struct { unsigned short len; unsigned char arr[35]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[31]; } nd_facility_name;

struct { unsigned short len; unsigned char arr[41]; } nd_service_desc;

struct { unsigned short len; unsigned char arr[3]; } nd_recpt_nature_code;

struct { unsigned short len; unsigned char arr[3]; } nd_blng_grp;

struct { unsigned short len; unsigned char arr[12]; } nd_hcard_status;

struct { unsigned short len; unsigned char arr[11]; } nd_service_code;

struct { unsigned short len; unsigned char arr[21]; } nd_hcard_num;

struct { unsigned short len; unsigned char arr[15]; } nd_hcard_expiry_date;

struct { unsigned short len; unsigned char arr[16]; } nd_cash_counter_desc;


   /* VARCHAR nd_session_id    [16],
	   nd_facility_id   [3] ,
           nd_fm_doc_type   [7],
	   nd_clinic	    [16],
           nd_to_doc_type   [7],
	   nd_nationality   [5],
           nd_fm_doc_num    [10],
           nd_to_doc_num    [10],
           nd_fm_doc_date   [12],
	   // Added by MRAMESH. date : 31-dec-1997
	   cur_str          [8],
	   sub_cur_str      [8],	   
           nd_to_doc_date   [12],
	   l_printer_ids[1000],
	   l_printer_names[1000],
	   l_printer_types[1000],
	   l_queue_names[1000],
	   l_no_of_copies[1000],
	   l_errortext[1000],
	   l_logo_yniflaser[1000],
	   LOGO_DIR[1000],
	   l_logo_name[1000],
	   l_errorlevel[10],
	   l_sysmessageid[10]; */ 
struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[3]; } nd_facility_id;

struct { unsigned short len; unsigned char arr[7]; } nd_fm_doc_type;

struct { unsigned short len; unsigned char arr[16]; } nd_clinic;

struct { unsigned short len; unsigned char arr[7]; } nd_to_doc_type;

struct { unsigned short len; unsigned char arr[5]; } nd_nationality;

struct { unsigned short len; unsigned char arr[10]; } nd_fm_doc_num;

struct { unsigned short len; unsigned char arr[10]; } nd_to_doc_num;

struct { unsigned short len; unsigned char arr[12]; } nd_fm_doc_date;

struct { unsigned short len; unsigned char arr[8]; } cur_str;

struct { unsigned short len; unsigned char arr[8]; } sub_cur_str;

struct { unsigned short len; unsigned char arr[12]; } nd_to_doc_date;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_ids;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_names;

struct { unsigned short len; unsigned char arr[1000]; } l_printer_types;

struct { unsigned short len; unsigned char arr[1000]; } l_queue_names;

struct { unsigned short len; unsigned char arr[1000]; } l_no_of_copies;

struct { unsigned short len; unsigned char arr[1000]; } l_errortext;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_yniflaser;

struct { unsigned short len; unsigned char arr[1000]; } LOGO_DIR;

struct { unsigned short len; unsigned char arr[1000]; } l_logo_name;

struct { unsigned short len; unsigned char arr[10]; } l_errorlevel;

struct { unsigned short len; unsigned char arr[10]; } l_sysmessageid;


   /* VARCHAR d_doc_type_code                             [7],
           d_doc_number                                [9],
		   d_doc_srno								   [3],
	   d_mdoc_type_code                             [7],
           d_mdoc_number                                [9],
           d_doc_date                                  [13],
           d_trx_date_time                             [17],
           d_episode_type                              [2],
           d_patient_id                                [21],
           d_patient_name                              [61],
           d_patient_name_loc_lang                     [61],
           d_episode_id                                [9],
           d_visit_id                                  [5],
           d_bill_doc_type_code                        [7],
           d_bill_doc_number                           [9],
           d_customer_code                             [9],
           d_cust_name                                 [41],
           d_doc_amt                                   [23],
           d_slmt_type_code                            [3],
           d_slmt_type_desc                            [16],
           d_slmt_doc_ref_desc                         [21],
           d_slmt_doc_ref_date                         [13],
           d_slmt_doc_remarks                          [31],
	   d_branch_name			       [61],
           d_narration                                 [51],
		   nd_cashier								   [31],
           d_payer_name                                [41],
		   nd_hcare_appl_num						   [21],
           d_cur_bed_num                               [9],
	   d_cur_ward_code			       [5],
           d_cash_counter_code                         [3],	   
           d_shift_id                                  [2],
	   d_rowid                                     [20],
	   d_doc_type_num                              [25],
	   d_doc_time									[10],
	   d_acc_int_code								[7],
	   d_ac_code									[51],
	   d_operator									[31],
	   d_nric_no									[21],
	   d_deposit_no									[51],
	   d_doc_no										[31],
	   d_payment_desc								[16],
	   d_receipt_type								[4],
	   d_receipt_desc								[16],
	   d_dep_doc_type_code							[7],
	   d_dep_doc_num								[9],
	   temp_doc_type_code							[7],
	   nd_reportid									[20],
	   nd_logo_pgm_id[1000],
	   nd_ws_no[30],
	   l_consolidated_receipt_yn					[4],
	   l_ext_acct_facility_id						[15],  
	   l_ext_acct_code								[15],          
	   l_ext_acct_dept_code							[8],
	   l_bill_doc_type_code							[10],
	   l_to_doc_type_code							[10],
	   l_to_doc_type_num							[10],
	   l_online_print_yn							[5],
	   l_file_name									[50],
	   l_fr_date									[30],
	   l_to_date									[30]; */ 
struct { unsigned short len; unsigned char arr[7]; } d_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_doc_number;

struct { unsigned short len; unsigned char arr[3]; } d_doc_srno;

struct { unsigned short len; unsigned char arr[7]; } d_mdoc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_mdoc_number;

struct { unsigned short len; unsigned char arr[13]; } d_doc_date;

struct { unsigned short len; unsigned char arr[17]; } d_trx_date_time;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[21]; } d_patient_id;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name;

struct { unsigned short len; unsigned char arr[61]; } d_patient_name_loc_lang;

struct { unsigned short len; unsigned char arr[9]; } d_episode_id;

struct { unsigned short len; unsigned char arr[5]; } d_visit_id;

struct { unsigned short len; unsigned char arr[7]; } d_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_bill_doc_number;

struct { unsigned short len; unsigned char arr[9]; } d_customer_code;

struct { unsigned short len; unsigned char arr[41]; } d_cust_name;

struct { unsigned short len; unsigned char arr[23]; } d_doc_amt;

struct { unsigned short len; unsigned char arr[3]; } d_slmt_type_code;

struct { unsigned short len; unsigned char arr[16]; } d_slmt_type_desc;

struct { unsigned short len; unsigned char arr[21]; } d_slmt_doc_ref_desc;

struct { unsigned short len; unsigned char arr[13]; } d_slmt_doc_ref_date;

struct { unsigned short len; unsigned char arr[31]; } d_slmt_doc_remarks;

struct { unsigned short len; unsigned char arr[61]; } d_branch_name;

struct { unsigned short len; unsigned char arr[51]; } d_narration;

struct { unsigned short len; unsigned char arr[31]; } nd_cashier;

struct { unsigned short len; unsigned char arr[41]; } d_payer_name;

struct { unsigned short len; unsigned char arr[21]; } nd_hcare_appl_num;

struct { unsigned short len; unsigned char arr[9]; } d_cur_bed_num;

struct { unsigned short len; unsigned char arr[5]; } d_cur_ward_code;

struct { unsigned short len; unsigned char arr[3]; } d_cash_counter_code;

struct { unsigned short len; unsigned char arr[2]; } d_shift_id;

struct { unsigned short len; unsigned char arr[20]; } d_rowid;

struct { unsigned short len; unsigned char arr[25]; } d_doc_type_num;

struct { unsigned short len; unsigned char arr[10]; } d_doc_time;

struct { unsigned short len; unsigned char arr[7]; } d_acc_int_code;

struct { unsigned short len; unsigned char arr[51]; } d_ac_code;

struct { unsigned short len; unsigned char arr[31]; } d_operator;

struct { unsigned short len; unsigned char arr[21]; } d_nric_no;

struct { unsigned short len; unsigned char arr[51]; } d_deposit_no;

struct { unsigned short len; unsigned char arr[31]; } d_doc_no;

struct { unsigned short len; unsigned char arr[16]; } d_payment_desc;

struct { unsigned short len; unsigned char arr[4]; } d_receipt_type;

struct { unsigned short len; unsigned char arr[16]; } d_receipt_desc;

struct { unsigned short len; unsigned char arr[7]; } d_dep_doc_type_code;

struct { unsigned short len; unsigned char arr[9]; } d_dep_doc_num;

struct { unsigned short len; unsigned char arr[7]; } temp_doc_type_code;

struct { unsigned short len; unsigned char arr[20]; } nd_reportid;

struct { unsigned short len; unsigned char arr[1000]; } nd_logo_pgm_id;

struct { unsigned short len; unsigned char arr[30]; } nd_ws_no;

struct { unsigned short len; unsigned char arr[4]; } l_consolidated_receipt_yn;

struct { unsigned short len; unsigned char arr[15]; } l_ext_acct_facility_id;

struct { unsigned short len; unsigned char arr[15]; } l_ext_acct_code;

struct { unsigned short len; unsigned char arr[8]; } l_ext_acct_dept_code;

struct { unsigned short len; unsigned char arr[10]; } l_bill_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } l_to_doc_type_code;

struct { unsigned short len; unsigned char arr[10]; } l_to_doc_type_num;

struct { unsigned short len; unsigned char arr[5]; } l_online_print_yn;

struct { unsigned short len; unsigned char arr[50]; } l_file_name;

struct { unsigned short len; unsigned char arr[30]; } l_fr_date;

struct { unsigned short len; unsigned char arr[30]; } l_to_date;


   char		nd_print_flag,
			nd_rec_ref_flag,
			online_batch_flag,
			nd_lang_ind,
			d_err_code[30];

	char	l_sql_stmt[3000];
	char    l_temp_line1[300];
	char    l_temp_line2[300];
	char	l_mesg[300];

   double	d_doc_amt_num, 
			nd_dep_amt;

   long     l_bill_doc_number,len1 = 0;

   int	nd_no_of_decimal, dep_cnt = 0, rec_cnt = 0,
		nd_dep_status = 0, l_tier_arch,l_dmp = 0, l_lsr = 0,
		l_margin_len= 30;

	/* VARCHAR		nd_lang_id	[4],
			nd_hosp_name    [1000],
			loc_legend1	[201],
			loc_legend2	[201],
			loc_legend3	[201],
			loc_legend4	[201],
			loc_legend5	[201],
			loc_legend6	[201],
			loc_legend7	[201],
			loc_legend8	[201],
			loc_legend9	[201],
			loc_legend10	[201],
			loc_legend11	[201],
			loc_legend12	[201],
			loc_legend13	[201],
			loc_legend14	[201],
			loc_legend15	[201],
			loc_legend16	[201],
			loc_legend17	[201],
			loc_legend20	[201],
			loc_legend21	[201],
			loc_legend22	[201],
			loc_legend23	[201],
			loc_legend24	[201],
			loc_legend25	[201],
			loc_legend26	[201],
			loc_legend27	[201],
			loc_legend28	[201],
	// --------------------------------------19092005------
			loc_legend29	[201],
			loc_legend30	[201],
			loc_legend31	[201],
			loc_legend32	[201],
			loc_legend33	[201],
			loc_legend34	[201],
			loc_legend35	[201],
			loc_legend36	[201],
			loc_legend37	[201],
			loc_legend38	[201],
			loc_legend39	[201],
			loc_legend40	[201],
			loc_legend41	[201],
			loc_legend42	[201],
			loc_legend43	[201],
			loc_legend50	[201]; */ 
struct { unsigned short len; unsigned char arr[4]; } nd_lang_id;

struct { unsigned short len; unsigned char arr[1000]; } nd_hosp_name;

struct { unsigned short len; unsigned char arr[201]; } loc_legend1;

struct { unsigned short len; unsigned char arr[201]; } loc_legend2;

struct { unsigned short len; unsigned char arr[201]; } loc_legend3;

struct { unsigned short len; unsigned char arr[201]; } loc_legend4;

struct { unsigned short len; unsigned char arr[201]; } loc_legend5;

struct { unsigned short len; unsigned char arr[201]; } loc_legend6;

struct { unsigned short len; unsigned char arr[201]; } loc_legend7;

struct { unsigned short len; unsigned char arr[201]; } loc_legend8;

struct { unsigned short len; unsigned char arr[201]; } loc_legend9;

struct { unsigned short len; unsigned char arr[201]; } loc_legend10;

struct { unsigned short len; unsigned char arr[201]; } loc_legend11;

struct { unsigned short len; unsigned char arr[201]; } loc_legend12;

struct { unsigned short len; unsigned char arr[201]; } loc_legend13;

struct { unsigned short len; unsigned char arr[201]; } loc_legend14;

struct { unsigned short len; unsigned char arr[201]; } loc_legend15;

struct { unsigned short len; unsigned char arr[201]; } loc_legend16;

struct { unsigned short len; unsigned char arr[201]; } loc_legend17;

struct { unsigned short len; unsigned char arr[201]; } loc_legend20;

struct { unsigned short len; unsigned char arr[201]; } loc_legend21;

struct { unsigned short len; unsigned char arr[201]; } loc_legend22;

struct { unsigned short len; unsigned char arr[201]; } loc_legend23;

struct { unsigned short len; unsigned char arr[201]; } loc_legend24;

struct { unsigned short len; unsigned char arr[201]; } loc_legend25;

struct { unsigned short len; unsigned char arr[201]; } loc_legend26;

struct { unsigned short len; unsigned char arr[201]; } loc_legend27;

struct { unsigned short len; unsigned char arr[201]; } loc_legend28;

struct { unsigned short len; unsigned char arr[201]; } loc_legend29;

struct { unsigned short len; unsigned char arr[201]; } loc_legend30;

struct { unsigned short len; unsigned char arr[201]; } loc_legend31;

struct { unsigned short len; unsigned char arr[201]; } loc_legend32;

struct { unsigned short len; unsigned char arr[201]; } loc_legend33;

struct { unsigned short len; unsigned char arr[201]; } loc_legend34;

struct { unsigned short len; unsigned char arr[201]; } loc_legend35;

struct { unsigned short len; unsigned char arr[201]; } loc_legend36;

struct { unsigned short len; unsigned char arr[201]; } loc_legend37;

struct { unsigned short len; unsigned char arr[201]; } loc_legend38;

struct { unsigned short len; unsigned char arr[201]; } loc_legend39;

struct { unsigned short len; unsigned char arr[201]; } loc_legend40;

struct { unsigned short len; unsigned char arr[201]; } loc_legend41;

struct { unsigned short len; unsigned char arr[201]; } loc_legend42;

struct { unsigned short len; unsigned char arr[201]; } loc_legend43;

struct { unsigned short len; unsigned char arr[201]; } loc_legend50;

	// --------------------------------------19092005----Up to here------

	/* VARCHAR		nd_file_name	[100]; */ 
struct { unsigned short len; unsigned char arr[100]; } nd_file_name;


/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/Blrrecpt.c-arc   1.0   Apr 19 2007 17:06:58   vcm_th  $ sqlca.h 
 */

/* Copyright (c) 1985,1986, 1998 by Oracle Corporation. */
 
/*
NAME
  SQLCA : SQL Communications Area.
FUNCTION
  Contains no code. Oracle fills in the SQLCA with status info
  during the execution of a SQL stmt.
NOTES
  **************************************************************
  ***                                                        ***
  *** This file is SOSD.  Porters must change the data types ***
  *** appropriately on their platform.  See notes/pcport.doc ***
  *** for more information.                                  ***
  ***                                                        ***
  **************************************************************

  If the symbol SQLCA_STORAGE_CLASS is defined, then the SQLCA
  will be defined to have this storage class. For example:
 
    #define SQLCA_STORAGE_CLASS extern
 
  will define the SQLCA as an extern.
 
  If the symbol SQLCA_INIT is defined, then the SQLCA will be
  statically initialized. Although this is not necessary in order
  to use the SQLCA, it is a good pgming practice not to have
  unitialized variables. However, some C compilers/OS's don't
  allow automatic variables to be init'd in this manner. Therefore,
  if you are INCLUDE'ing the SQLCA in a place where it would be
  an automatic AND your C compiler/OS doesn't allow this style
  of initialization, then SQLCA_INIT should be left undefined --
  all others can define SQLCA_INIT if they wish.

  If the symbol SQLCA_NONE is defined, then the SQLCA variable will
  not be defined at all.  The symbol SQLCA_NONE should not be defined
  in source modules that have embedded SQL.  However, source modules
  that have no embedded SQL, but need to manipulate a sqlca struct
  passed in as a parameter, can set the SQLCA_NONE symbol to avoid
  creation of an extraneous sqlca variable.
 
MODIFIED
    lvbcheng   07/31/98 -  long to int
    jbasu      12/12/94 -  Bug 217878: note this is an SOSD file
    losborne   08/11/92 -  No sqlca var if SQLCA_NONE macro set 
  Clare      12/06/84 - Ch SQLCA to not be an extern.
  Clare      10/21/85 - Add initialization.
  Bradbury   01/05/86 - Only initialize when SQLCA_INIT set
  Clare      06/12/86 - Add SQLCA_STORAGE_CLASS option.
*/
 
#ifndef SQLCA
#define SQLCA 1
 
struct   sqlca
         {
         /* ub1 */ char    sqlcaid[8];
         /* b4  */ int     sqlabc;
         /* b4  */ int     sqlcode;
         struct
           {
           /* ub2 */ unsigned short sqlerrml;
           /* ub1 */ char           sqlerrmc[70];
           } sqlerrm;
         /* ub1 */ char    sqlerrp[8];
         /* b4  */ int     sqlerrd[6];
         /* ub1 */ char    sqlwarn[8];
         /* ub1 */ char    sqlext[8];
         };

#ifndef SQLCA_NONE 
#ifdef   SQLCA_STORAGE_CLASS
SQLCA_STORAGE_CLASS struct sqlca sqlca
#else
         struct sqlca sqlca
#endif
 
#ifdef  SQLCA_INIT
         = {
         {'S', 'Q', 'L', 'C', 'A', ' ', ' ', ' '},
         sizeof(struct sqlca),
         0,
         { 0, {0}},
         {'N', 'O', 'T', ' ', 'S', 'E', 'T', ' '},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0}
         }
#endif
         ;
#endif
 
#endif
 
/* end SQLCA */
/* EXEC SQL INCLUDE SQLDA.H;
 */ 
/*
 * $Header:   T:/eHIS-102/archives/eHIS2Tier/BL/Blrrecpt.c-arc   1.0   Apr 19 2007 17:06:58   vcm_th  $ sqlda.h 
 */

/***************************************************************
*      The SQLDA descriptor definition                         *
*--------------------------------------------------------------*
*      VAX/3B Version                                          *
*                                                              *
*  Copyright (c) 1987, 1997, 1998, 1999 by Oracle Corporation                    *
***************************************************************/


/* NOTES
  **************************************************************
  ***                                                        ***
  *** This file is SOSD.  Porters must change the data types ***
  *** appropriately on their platform.  See notes/pcport.doc ***
  *** for more information.                                  ***
  ***                                                        ***
  **************************************************************
*/

/*  MODIFIED
    apopat     07/31/99 -  [707588] TAB to blanks for OCCS
    lvbcheng   10/27/98 -  change long to int for sqlda
    lvbcheng   08/15/97 -  Move sqlda protos to sqlcpr.h
    lvbcheng   06/25/97 -  Move sqlda protos to this file
    jbasu      01/29/95 -  correct typo
    jbasu      01/27/95 -  correct comment - ub2->sb2
    jbasu      12/12/94 - Bug 217878: note this is an SOSD file
    Morse      12/01/87 - undef L and S for v6 include files
    Richey     07/13/87 - change int defs to long 
    Clare      09/13/84 - Port: Ch types to match SQLLIB structs
    Clare      10/02/86 - Add ifndef SQLDA
*/

#ifndef SQLDA_
#define SQLDA_ 1
 
#ifdef T
# undef T
#endif
#ifdef F
# undef F
#endif

#ifdef S
# undef S
#endif
#ifdef L
# undef L
#endif
 
struct SQLDA {
  /* ub4    */ int        N; /* Descriptor size in number of entries        */
  /* text** */ char     **V; /* Ptr to Arr of addresses of main variables   */
  /* ub4*   */ int       *L; /* Ptr to Arr of lengths of buffers            */
  /* sb2*   */ short     *T; /* Ptr to Arr of types of buffers              */
  /* sb2**  */ short    **I; /* Ptr to Arr of addresses of indicator vars   */
  /* sb4    */ int        F; /* Number of variables found by DESCRIBE       */
  /* text** */ char     **S; /* Ptr to Arr of variable name pointers        */
  /* ub2*   */ short     *M; /* Ptr to Arr of max lengths of var. names     */
  /* ub2*   */ short     *C; /* Ptr to Arr of current lengths of var. names */
  /* text** */ char     **X; /* Ptr to Arr of ind. var. name pointers       */
  /* ub2*   */ short     *Y; /* Ptr to Arr of max lengths of ind. var. names */
  /* ub2*   */ short     *Z; /* Ptr to Arr of cur lengths of ind. var. names */
  };
 
typedef struct SQLDA SQLDA;
 
#endif

/* ----------------- */
/* defines for sqlda */
/* ----------------- */

#define SQLSQLDAAlloc(arg1, arg2, arg3, arg4) sqlaldt(arg1, arg2, arg3, arg4) 

#define SQLSQLDAFree(arg1, arg2) sqlclut(arg1, arg2) 




#include <winproc.h>

FILE *fp;
int lctr = 0,pctr =0;

char filename[150];
char l_epi_barcode[50],
     l_rec_barcode[50];

void proc_main(argc,argv)
char *argv[];
int argc;
{
   char lv_msg[1024];

   if (argc < 6) 
   {
        //disp_message(ERR_MESG,"BLRRECPT : Usage BLRRECPT userid/password session_id pgm_date doc_type num print_flag facility report_id\n");
		disp_message(ERR_MESG,"BLRRECPT : Usage Error - Check Command Line Parameter\n");
        proc_exit();
   } 
   
   if (argc >= 10)
   {
        strcpy(nd_reportid.arr,argv[9]);
        nd_reportid.len = strlen(nd_reportid.arr);

		//sprintf(l_mesg,"1  %s    2   %s   3   %s   4   %s   5   %s    6   %s    7   %s   8   %s   9   %s   10    %s     11    %s      12     %s",argv[1],argv[2],argv[3],argv[4],argv[5],argv[6],argv[7],argv[8],argv[9],argv[10],argv[11],argv[12]);	
		//disp_message(ERR_MESG,l_mesg);
   }

   if (argc >= 11)
   {
        strcpy(nd_ws_no.arr,argv[10]);
        nd_ws_no.len = strlen(nd_ws_no.arr);
   }
	
   

   
	//sprintf(l_mesg,"1  %s    2   %s   3   %s   4   %s   5   %s    6   %s    7   %s   8   %s   9   %s   10    %s",argv[1],argv[2],argv[3],argv[4],argv[5],argv[6]);	
	//sprintf(l_mesg,"Arg C   %d",argc);
	
	//sprintf(l_mesg,"Total    %d    -    1  %s    2   %s   3   %s   4   %s   5   %s    6   %s    7   %s",argc, argv[1],argv[2],argv[3],argv[4],argv[5],argv[6],argv[7]);	
	//disp_message(ERR_MESG,l_mesg);

   if (argc < 8)
   {
        strcpy(nd_reportid.arr,"BLRRECPT");
        nd_reportid.len = strlen(nd_reportid.arr);
   }
   
   strcpy(uid_pwd.arr,argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr);

   strcpy(g_session_id,argv[2]);
   strcpy(nd_session_id.arr,argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr);

   strcpy(g_pgm_id,"BLRRECPT"); 

   if(sql_connect() == -1)
   {
      disp_message(ERR_MESG,"Error in connecting to Oracle\n");
      if (uid_pwd.len == 0)
         disp_message(ERR_MESG,"Null oracle uid/pwd\n\n\n");
      proc_exit();
   }

   set_meduser_role();

   strcpy(g_pgm_date,argv[3]);
   strcpy(nd_pgm_date.arr,argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr);


   get_param_for_three_tier();

   if(l_tier_arch==2)
   {   
	   strcpy(d_doc_type_code.arr, argv[5]);
	   strcpy(d_doc_number.arr, argv[6]);

	   d_doc_type_code.len = strlen(d_doc_type_code.arr);
	   d_doc_number.len    = strlen(d_doc_number.arr);

	   if (argc >= 11)
	   {
		strcpy(nd_ws_no.arr,argv[10]);
	        nd_ws_no.len = strlen(nd_ws_no.arr);
	   }

		if(argc>=12)
		{
			strcpy(l_to_doc_type_code.arr,argv[10]);
			l_to_doc_type_code.len = strlen(l_to_doc_type_code.arr);

			strcpy(l_to_doc_type_num.arr,argv[11]);
			l_to_doc_type_num.len = strlen(l_to_doc_type_num.arr);
		}

		if (argc >= 13)
		{
			strcpy(l_fr_date.arr,argv[12]);
			l_fr_date.len = strlen(l_fr_date.arr);

			strcpy(l_to_date.arr,argv[13]);
			l_to_date.len = strlen(l_to_date.arr);
		}


		strcpy(nd_facility_id.arr,argv[8]);

		nd_facility_id.len  = strlen(nd_facility_id.arr);
		strcpy(g_facility_id,nd_facility_id.arr);
   
		nd_print_flag = argv[7][0];  

		nd_facility_name.arr[0] = '\0';
		nd_facility_name.len = 0;
	}
	else if(l_tier_arch==3)
	{
		strcpy(nd_facility_id.arr,argv[4]);

		nd_facility_id.len  = strlen(nd_facility_id.arr);
		strcpy(g_facility_id,nd_facility_id.arr);

		strcpy(nd_reportid.arr,argv[5]);
                nd_reportid.len = strlen(nd_reportid.arr);

		l_file_name.arr[0]='\0';
		strcpy(l_file_name.arr,argv[6]);
		//l_file_name.arr[l_file_name.len]='\0';
		l_file_name.len = strlen(l_file_name.arr);

		//sprintf(l_mesg,"File Name  -     %s ",l_file_name.arr);
		//disp_message(ERR_MESG,l_mesg);
	}

get_printer_type();

l_logo_yniflaser.arr[0] = 'N';

//get_logo_dtl();

get_left_margin();	


   nd_hosp_name.arr[0] = '\0';
   nd_hosp_name.len = 0;            
   
   /* exec sql select acc_entity_name, no_of_decimal ,
	    lpad(' ',round((:l_margin_len-length(ACC_ENTITY_NAME))/2),' ')||UPPER(ACC_ENTITY_NAME)
	    into :nd_facility_name, :nd_no_of_decimal,:nd_hosp_name
 	    from sy_acc_entity where acc_entity_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select acc_entity_name ,no_of_decimal ,(lpad(' ',round(((:\
b0-length(ACC_ENTITY_NAME))/2)),' ')||UPPER(ACC_ENTITY_NAME)) into :b1,:b2,:b3\
  from sy_acc_entity where acc_entity_id=:b4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_facility_name;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_no_of_decimal;
   sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_hosp_name;
   sqlstm.sqhstl[3] = (unsigned int  )1002;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[4] = (unsigned int  )5;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
    {
         err_mesg("SELECT failed on cursor SY_ACC_ENTITY",0,"");
    }
    nd_facility_name.arr[nd_facility_name.len] = '\0';
    nd_hosp_name.arr[nd_hosp_name.len] = '\0';


    open_files(); 


	declare_receipt_cursor();

	nd_lang_id.arr[0] = '\0';
	nd_lang_id.len = 0;

		/* EXEC SQL EXECUTE
			BEGIN
			blcommon.get_language_ind_id
				(
					:nd_facility_id,
					:d_patient_id,
					:nd_lang_ind,
					:nd_lang_id				
				);
			END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin blcommon . get_language_ind_id ( :nd_facility_id , :d\
_patient_id , :nd_lang_ind , :nd_lang_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )40;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_lang_ind;
  sqlstm.sqhstl[2] = (unsigned int  )1;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_lang_id;
  sqlstm.sqhstl[3] = (unsigned int  )6;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


 
		nd_lang_id.arr[strlen(nd_lang_id.arr)] = '\0';
	
    while(fetch_receipt_cursor())
	{
		nd_cash_counter_desc.arr[0] = '\0';
		nd_cash_counter_desc.len = 0;    
   
		/* exec sql select short_desc 
				   into :nd_cash_counter_desc 
				   from bl_cash_counter
				  where operating_facility_id = :nd_facility_id
					and cash_counter_code     = :d_cash_counter_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select short_desc into :b0  from bl_cash_counter where (ope\
rating_facility_id=:b1 and cash_counter_code=:b2)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )71;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_cash_counter_desc;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_cash_counter_code;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR)
		{
			 err_mesg("FETCH failed on BL_CASH_COUNTER",0,"");
		}
    
		nd_cash_counter_desc.arr[nd_cash_counter_desc.len] = '\0';

		if(strlen(d_patient_id.arr) != 0) 
		{ 
			d_patient_name.arr[0]  = '\0';
			d_patient_name_loc_lang.arr[0]  = '\0';
			nd_nationality.arr[0]  = '\0';
			d_nric_no.arr[0]		= '\0';
				
			d_patient_name.len  = 0;
			d_patient_name_loc_lang.len  = 0;
			nd_nationality.len = 0;
			d_nric_no.len		= 0;

			/* EXEC SQL SELECT SHORT_NAME,
	       					SHORT_NAME_LOC_LANG,
							NATIONALITY_CODE,
							NATIONAL_ID_NUM
					   INTO :d_patient_name,
							:d_patient_name_loc_lang,
							:nd_nationality,
							:d_nric_no
					   FROM MP_PATIENT_MAST
					  WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SHORT_NAME ,SHORT_NAME_LOC_LANG ,NATIONALITY_CODE ,\
NATIONAL_ID_NUM into :b0,:b1,:b2,:b3  from MP_PATIENT_MAST where PATIENT_ID=:b\
4";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )98;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_patient_name;
   sqlstm.sqhstl[0] = (unsigned int  )63;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_patient_name_loc_lang;
   sqlstm.sqhstl[1] = (unsigned int  )63;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_nationality;
   sqlstm.sqhstl[2] = (unsigned int  )7;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_nric_no;
   sqlstm.sqhstl[3] = (unsigned int  )23;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[4] = (unsigned int  )23;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			 if(OERROR)
			 {   
				err_mesg("SELECT failed on table MP_PATIENT_MAST",0,"");
			 }
    
			 d_patient_name.arr[d_patient_name.len]  = '\0';
			 d_patient_name_loc_lang.arr[d_patient_name_loc_lang.len]  = '\0';
			 nd_nationality.arr[nd_nationality.len] = '\0';
			 d_nric_no.arr[d_nric_no.len] = '\0';
		}

		d_slmt_type_desc.arr[0]  = '\0';
		d_slmt_type_desc.len  = 0;

		/* EXEC SQL SELECT SHORT_DESC
				   INTO :d_slmt_type_desc
				   FROM BL_SLMT_TYPE
				  WHERE SLMT_TYPE_CODE = :d_slmt_type_code
					AND acc_entity_code in (select acc_entity_code 
											  from sy_acc_entity
											 where acc_entity_id = :nd_facility_id); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select SHORT_DESC into :b0  from BL_SLMT_TYPE where (SLMT_T\
YPE_CODE=:b1 and acc_entity_code in (select acc_entity_code  from sy_acc_entit\
y where acc_entity_id=:b2))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )133;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_slmt_type_desc;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_slmt_type_code;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if(OERROR)
		{   
			err_mesg("FETCH failed on cursor SLMT_TYPE_CUR",0,"");
		}

		d_slmt_type_desc.arr[d_slmt_type_desc.len]  = '\0';

		d_receipt_desc.arr[0]	= '\0';
		d_acc_int_code.arr[0]	= '\0';
		d_ac_code.arr[0]		= '\0';

		d_receipt_desc.len  = 0;
		d_acc_int_code.len  = 0;
		d_ac_code.len		= 0;

		/* EXEC SQL select long_desc, 
						receipt_acc_int_code 
				   into :d_receipt_desc, 
						:d_acc_int_code
				   FROM BL_RECEIPT_TYPE
				  WHERE RECEIPT_TYPE_CODE = :d_receipt_type; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select long_desc ,receipt_acc_int_code into :b0,:b1  from B\
L_RECEIPT_TYPE where RECEIPT_TYPE_CODE=:b2";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )160;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_receipt_desc;
  sqlstm.sqhstl[0] = (unsigned int  )18;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_acc_int_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_receipt_type;
  sqlstm.sqhstl[2] = (unsigned int  )6;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		d_receipt_desc.arr[d_receipt_desc.len]	= '\0';
		d_acc_int_code.arr[d_acc_int_code.len]	= '\0';

		/* EXEC SQL SELECT MAIN_ACC1_CODE||' '||MAIN_ACC2_CODE||' '||
						DEPT_CODE||' '||SUBLEDGER_GROUP_CODE||' '||
						SUBLEDGER_LINE_CODE||' '||PRODUCT_GROUP_CODE||' '||
						PRODUCT_LINE_CODE      
				   INTO :d_ac_code
				   FROM BL_GL_ACCOUNT
				  WHERE ACC_INT_CODE =:d_acc_int_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select ((((((((((((MAIN_ACC1_CODE||' ')||MAIN_ACC2_CODE)||'\
 ')||DEPT_CODE)||' ')||SUBLEDGER_GROUP_CODE)||' ')||SUBLEDGER_LINE_CODE)||' ')\
||PRODUCT_GROUP_CODE)||' ')||PRODUCT_LINE_CODE) into :b0  from BL_GL_ACCOUNT w\
here ACC_INT_CODE=:b1";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )187;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_ac_code;
  sqlstm.sqhstl[0] = (unsigned int  )53;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_acc_int_code;
  sqlstm.sqhstl[1] = (unsigned int  )9;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		d_ac_code.arr[d_ac_code.len]	= '\0';

		fetch_legend_value();
				
		print_recpt();
		
		update_rec();   

		//fprintf(fp,"%c");		
	
		if (l_lsr != 0 && l_dmp == 0)
		{
			if ( l_logo_yniflaser.arr[0] != 'Y')
				fprintf(fp,"%cE",ESC);  /* To Reset Printer */
		}
		else
		{
			fprintf(fp,"%c@",ESC);  /* To ReSet compressed mode */
		}
	}

	close_receipt_cursor();

	//fprintf(fp,"%c@",ESC); 	/* To ReSet compressed mode */

    fclose(fp);

    if 	(l_online_print_yn.arr[0] == 'N')
	{
	    if (l_lsr != 0 && l_dmp == 0 && l_logo_yniflaser.arr[0] == 'Y')
	    {
                l_errortext.arr[0] = '\0';
		l_errortext.len = 0;	

		/* EXEC SQL EXECUTE
		DECLARE
			l_print_status BOOLEAN;
		BEGIN				
			APPPRINT.SUBMIT_ORACLE_REPORT
				 (:nd_ws_no,
				  :nd_facility_id,
				  'BL',
				  :nd_logo_pgm_id,
				  'P', --p_report_option
				  '',  --p_outputfile_format
				  '',  --p_outputfile_name
				  'O',
				  ' ', --p_location_code
				  NULL, --:l_printer_names,
				  NULL,
				  NULL, --p_page_from
				  NULL, --p_page_to
				  NULL, --p_print_mode
				  'P_FILE_NAME='||:nd_file_name||'+'||'P_LOGO_NAME='||:l_logo_name, --p_param_list
				  l_print_status, --OUT BOOLEAN,
				  :l_errortext);				


		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare l_print_status BOOLEAN ; BEGIN APPPRINT . SUBMIT_OR\
ACLE_REPORT ( :nd_ws_no , :nd_facility_id , 'BL' , :nd_logo_pgm_id , 'P' , '' \
, '' , 'O' , ' ' , NULL , NULL , NULL , NULL , NULL , 'P_FILE_NAME=' || :nd_fi\
le_name || '+' || 'P_LOGO_NAME=' || :l_logo_name , l_print_status , :l_errorte\
xt ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )210;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[1] = (unsigned int  )5;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_logo_pgm_id;
  sqlstm.sqhstl[2] = (unsigned int  )1002;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_file_name;
  sqlstm.sqhstl[3] = (unsigned int  )102;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_logo_name;
  sqlstm.sqhstl[4] = (unsigned int  )1002;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&l_errortext;
  sqlstm.sqhstl[5] = (unsigned int  )1002;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}




		if (l_errortext.arr[0] != '\0')
			disp_message(ERR_MESG,l_errortext.arr);
	    }
	}
	else if (l_online_print_yn.arr[0] == 'Y')
	{
		
		if (l_logo_yniflaser.arr[0] != 'Y')
		{
		
			PrintDocument(	uid_pwd.arr,		//char	*PUidPwd;
					nd_session_id.arr,	//char	*PSessionID;
					nd_facility_id.arr,	//char	*PFacilityID;
					"BL",				//char	*PModuleID;
					nd_reportid.arr,			//char	*PDocumentID;
					filename,			//char	*POnlinePrintFileNames;
					"O",				//char	*PLocationTypes;
					" ",				//char	*PLocationCodes;
					1,					//int		PNumOfCopies;
					1,					//int		PPageFrom;
					999					//int		PPageTo;
				);
		}
        }	


	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 6;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )249;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	return;
}

sql_connect()
{
  /* EXEC SQL CONNECT :uid_pwd; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 6;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )10;
  sqlstm.offset = (unsigned int  )264;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
  sqlstm.sqhstl[0] = (unsigned int  )134;
  sqlstm.sqhsts[0] = (         int  )134;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


  if (sqlca.sqlcode < 0)
      return(-1);
  return(0);
}


open_files()
{
if (LOGO_DIR.arr[0] != '\0') 
    strcpy(filename,LOGO_DIR.arr);
else 
   strcpy(filename,WORKING_DIR);

   
   if(l_tier_arch==2)
   {
	   if(nd_print_flag EQ 'R')
	   {
		   strcpy(nd_file_name.arr,"blroffrc.lis");
		   nd_file_name.len  = strlen(nd_file_name.arr);
	    }
	   else
	   {
		   strcpy(nd_file_name.arr,"blrrefnd.lis");
		   nd_file_name.len  = strlen(nd_file_name.arr);
	   }
	}
	else if(l_tier_arch==3)
	{
		strcpy(nd_file_name.arr,l_file_name.arr);
		nd_file_name.len  = strlen(nd_file_name.arr);
	}
	
   strcat(filename,nd_file_name.arr);
   
   
   strcpy(OUTPUT_FILE_NAME,filename );

   //sprintf(l_mesg,"Tier     %d       Filename   %s",l_tier_arch,filename);
   //disp_message(ERR_MESG,l_mesg);

   if ((fp = fopen(filename,"w")) == NULL)
   {
        err_mesg("Error while opening output file",0,"");
        proc_exit();
   }
}

print_recpt()
{
   char out_str[10][133];
   char s_amt[20];
   int  length_str[10];
   int  l_no_of_deposit=0;
   int  i = 0,no_of_lines = 0;
   char epi_visit[14];

   //Added by MRAMESH. Date : 31-dec-1997
   cur_str.arr[0]   = '\0';
   cur_str.len      =  0;   
   sub_cur_str.arr[0]   = '\0';
   sub_cur_str.len      = 0;

   /* exec sql select base_currency,
                   base_currency_dec 
            into :cur_str,
		   :sub_cur_str
  	    from sy_acc_entity
	    where acc_entity_id = :nd_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 6;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select base_currency ,base_currency_dec into :b0,:b1  from\
 sy_acc_entity where acc_entity_id=:b2";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )295;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&cur_str;
   sqlstm.sqhstl[0] = (unsigned int  )10;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&sub_cur_str;
   sqlstm.sqhstl[1] = (unsigned int  )10;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if(sqlca.sqlcode == 1403)
   { 
	err_mesg("No base currency in table SY_ACC_ENTITY",0,"");
   }
   
   if (sqlca.sqlcode < 0)
   {   
	err_mesg("SELECT failed on table  SY_ACC_ENTITY",0,"");
   }
   
   cur_str.arr[cur_str.len]  = '\0';
   sub_cur_str.arr[sub_cur_str.len] = '\0';

   if (l_lsr != 0 && l_dmp == 0)
      {	
		if ( l_logo_yniflaser.arr[0] != 'Y')
		{
			fprintf(fp,"%c(s8H",ESC);	
			fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 	  */	      
		}
			prt_space_hdr();
			fprintf(fp,"%-50.50s\n",loc_legend24.arr);
			prt_space_hdr();
			fprintf(fp,"%-50.50s\n",loc_legend22.arr);
			prt_space_hdr();
			fprintf(fp,"%-50.50s\n\n",nd_hosp_name.arr);		

			fprintf(fp,"\n\n");		

		if ( l_logo_yniflaser.arr[0] != 'Y')
			fprintf(fp,"%c(s12H",ESC);	
	}


   print_report_header();

   	
   if (l_lsr != 0 && l_dmp == 0)
   {	
	/*
	if ( l_logo_yniflaser.arr[0] != 'Y')
		fprintf(fp,"%c(s8H",ESC);	

	fprintf(fp,"%-50.50s\n",loc_legend22.arr);
	fprintf(fp,"%-50.50s\n\n",nd_hosp_name.arr);
	*/
	
	if ( l_logo_yniflaser.arr[0] != 'Y')
		fprintf(fp,"%c(s12H",ESC);	
   }

   prt_space();
   //fprintf(fp,"%-16.16s : %6s/%-8s/%-s\n",loc_legend2.arr,d_doc_type_code.arr,d_doc_number.arr,d_doc_srno.arr);
   fprintf(fp,"\n");

   prt_space();	
   fprintf(fp,"%-16.16s : %-10s\n",loc_legend3.arr,d_doc_date.arr);
   prt_space();
   fprintf(fp,"%-16.16s : %-10s\n",loc_legend4.arr,d_doc_time.arr);

   //fprintf(fp,"%-16.16s : %-50s\n",loc_legend5.arr,d_ac_code.arr);
   //Included by Harish against Customization document.
   if(strcmp(l_consolidated_receipt_yn.arr,"Y")==0)
   {
		decl_consolidated_rec_cursor();
		print_consolidated_Receipt();
   }
   else
   {		
		prt_space();

		if (strcmp(nd_recpt_nature_code.arr,"MI") == 0)
		  fprintf(fp,"%-16.16s : %-s/%-s/%-s\n",loc_legend5.arr,l_ext_acct_facility_id.arr,l_ext_acct_dept_code.arr,l_ext_acct_code.arr);
		else
		  fprintf(fp,"%-16.16s : %-s/%-s\n",loc_legend5.arr,l_ext_acct_facility_id.arr,l_ext_acct_code.arr);

   }

   if (l_lsr != 0 && l_dmp == 0)
   {  
      // shifted down
   }
   else
   {
	prt_space();
	fprintf(fp,"%-16.16s : %-30s\n",loc_legend6.arr,nd_cashier.arr);
   }

   prt_space();
   fprintf(fp,"%-16.16s : ",loc_legend7.arr);

   if (strcmp(nd_recpt_nature_code.arr,"BI") == 0)
   {
		/* EXEC SQL SELECT COUNT(*) 
		           into :dep_cnt 
				   FROM	BL_PATIENT_LEDGER		
				  WHERE EPISODE_TYPE = :d_episode_type
				    AND PATIENT_ID = :d_patient_id
				    AND EPISODE_ID = :d_episode_id
				    AND NVL(VISIT_ID,1) = NVL(:d_visit_id,NVL(VISIT_ID,1))
				    AND AD_PR_ADJ_BILL_DOC_TYPE = :d_bill_doc_type_code
				    AND AD_PR_ADJ_BILL_DOC_NUM = :d_bill_doc_number
				    AND RECPT_NATURE_CODE IN ('AD','PR'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select count(*)  into :b0  from BL_PATIENT_LEDGER where (((\
(((EPISODE_TYPE=:b1 and PATIENT_ID=:b2) and EPISODE_ID=:b3) and NVL(VISIT_ID,1\
)=NVL(:b4,NVL(VISIT_ID,1))) and AD_PR_ADJ_BILL_DOC_TYPE=:b5) and AD_PR_ADJ_BIL\
L_DOC_NUM=:b6) and RECPT_NATURE_CODE in ('AD','PR'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )322;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&dep_cnt;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[1] = (unsigned int  )4;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_episode_id;
  sqlstm.sqhstl[3] = (unsigned int  )11;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_visit_id;
  sqlstm.sqhstl[4] = (unsigned int  )7;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_bill_doc_type_code;
  sqlstm.sqhstl[5] = (unsigned int  )9;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_bill_doc_number;
  sqlstm.sqhstl[6] = (unsigned int  )11;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		temp_doc_type_code.arr[0]	= '\0';
		temp_doc_type_code.len		= 0;

		decl_dep_adj_cur();
		while(fetch_dep_adj_cur())
		{
			if(l_no_of_deposit==2)
			{				
				fprintf(fp,"\n");
				prt_space();
				fprintf(fp,"%-16.16s   "," ");				
				l_no_of_deposit=0;
			}
			l_no_of_deposit++;

			if (l_no_of_deposit>1)
			{
					fprintf(fp,", ");
			}
			fprintf(fp,"%-s/%-s",d_dep_doc_type_code.arr,d_dep_doc_num.arr);
		}
		close_cursor();
	}

	fprintf(fp,"\n\n");
	
	prt_space();
	fprintf(fp,"%-16.16s : %-20s\n",loc_legend8.arr,d_patient_id.arr);

	prt_space();
	fprintf(fp,"%-16.16s : %-40s\n\n",loc_legend9.arr,d_patient_name.arr);

	prt_space();
	fprintf(fp,"%-16.16s : %-20s\n",loc_legend10.arr,d_nric_no.arr);
	
	if (strcmp(l_consolidated_receipt_yn.arr,"Y")==0)
	{
		decl_cons_rec_bill_cursor();
		print_consolidated_Receipt_bill();
	}
	else
	{
		if (strcmp(nd_recpt_nature_code.arr,"BI") == 0)
		{
			prt_space();
			fprintf(fp,"%-16.16s : %6s/%-8s\n",loc_legend11.arr,d_bill_doc_type_code.arr,d_bill_doc_number.arr);
		}
		else
		{
			prt_space();
			fprintf(fp,"%-16.16s : \n",loc_legend11.arr);
		}
	}

	prt_space();
	fprintf(fp,"%-16.16s : %-20s\n",loc_legend12.arr,d_slmt_type_desc.arr);

	prt_space();
	fprintf(fp,"%-16.16s : %-20s\n",loc_legend13.arr,d_slmt_doc_ref_desc.arr);

	if (l_lsr != 0 && l_dmp == 0)
	{
		prt_space();
		fprintf(fp,"%-16.16s : %-s\n",loc_legend25.arr,d_slmt_doc_remarks.arr);
		prt_space();
		fprintf(fp,"%-16.16s : %-45.45s\n",loc_legend26.arr,d_branch_name.arr);
	}

	fprintf(fp,"\n");

	prt_space();
	fprintf(fp,"%-16.16s : %s",loc_legend14.arr,cur_str.arr);
	print_formated(d_doc_amt_num);
	fprintf(fp,"\n");

	//fprintf(fp,"%-16.16s : %-50s\n",loc_legend15.arr,d_receipt_desc.arr);

	prt_space();
	fprintf(fp,"%-16.16s : %-50s\n",loc_legend15.arr,d_narration.arr);

	if (l_lsr != 0 && l_dmp == 0)
	{	
		prt_space();
		fprintf(fp,"%-16.16s : %-s",loc_legend16.arr,d_payer_name.arr);
		fprintf(fp,"\n");
		
		prt_space();
		fprintf(fp,"%-16.16s : %-s",loc_legend50.arr,d_doc_no.arr);
		fprintf(fp,"\n");


		/*
		if(d_doc_no.len > 0 )
		{
			if (d_payer_name.len > 25)
			{
				fprintf(fp,"\n");
				prt_space();
				fprintf(fp,"%-16.16s : "," ");
			}	
			fprintf(fp,"(%-s)",d_doc_no.arr);
			fprintf(fp,"\n");
		}
		*/

		fprintf(fp,"\n");  

		prt_space();
		fprintf(fp,"%-16.16s : %-30s\n",loc_legend6.arr,nd_cashier.arr);

		prt_space();
		fprintf(fp,"%-16.16s : %-16.16s\n",loc_legend23.arr,nd_cash_counter_desc.arr);		
		fprintf(fp,"\n");
		if (d_mdoc_type_code.arr[0] != '\0')
		{
			prt_space();
			fprintf(fp,"%-16.16s : (%-s %-s)\n",loc_legend27.arr,d_mdoc_type_code.arr,d_mdoc_number.arr);
		}
		else
		{
			fprintf(fp,"\n");  
		}

	}
	else
	{	
		prt_space();	
		fprintf(fp,"%-16.16s : %-s",loc_legend16.arr,d_payer_name.arr);

		if(d_doc_no.len > 0)
		{
			fprintf(fp,"(%-s)",d_doc_no.arr);
		}
	}	

	if (l_lsr != 0 && l_dmp == 0)
	{	 
               /*--------------------19/09/2005----------------------*/

	       if (loc_legend29.arr[0] != '\0' || loc_legend30.arr[0] != '\0'||
		   loc_legend31.arr[0] != '\0' || loc_legend32.arr[0] != '\0'||
		   loc_legend33.arr[0] != '\0' || loc_legend34.arr[0] != '\0'||
		   loc_legend35.arr[0] != '\0' || loc_legend36.arr[0] != '\0'||
		   loc_legend37.arr[0] != '\0' || loc_legend38.arr[0] != '\0'||
		   loc_legend39.arr[0] != '\0' || loc_legend40.arr[0] != '\0'||
		   loc_legend41.arr[0] != '\0' || loc_legend42.arr[0] != '\0'||
		   loc_legend43.arr[0] != '\0' ) 
	       {
			       if ( l_logo_yniflaser.arr[0] != 'Y')
			       {
				      fprintf(fp,"%c9",ESC);          /* To Release the margin */				  
				      fprintf(fp,"%c(s8H",ESC); 	/* To set the font size	  */
				      fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 	  */
				}			
				
				      fprintf(fp,"\n\n\n\n");			

				      fprintf(fp,"\n");	

				      if (loc_legend29.arr[0] != '\0')				 
					fprintf(fp,"%-s\n\n",loc_legend29.arr);
				

				if ( l_logo_yniflaser.arr[0] != 'Y')
				{
				      fprintf(fp,"%c(s12.5H",ESC); 	/* To set the font size	  */				  
				}

				      if (loc_legend30.arr[0] != '\0')	
				      fprintf(fp,"%-s\n",loc_legend30.arr);

				      if (loc_legend31.arr[0] != '\0') 
				      fprintf(fp,"%-s\n",loc_legend31.arr);

				      if (loc_legend32.arr[0] != '\0') 
				      fprintf(fp,"%-s\n",loc_legend32.arr);

				      if (loc_legend33.arr[0] != '\0') 
				      fprintf(fp,"%-s\n",loc_legend33.arr);

				      if (loc_legend34.arr[0] != '\0') 
				      fprintf(fp,"%-s\n",loc_legend34.arr);

				      if (loc_legend35.arr[0] != '\0') 
				      fprintf(fp,"%-s\n",loc_legend35.arr);

				      if (loc_legend36.arr[0] != '\0') 
				      fprintf(fp,"%-s\n",loc_legend36.arr);

				
				     //fprintf(fp,"\n");

				     if (loc_legend37.arr[0] != '\0') 
				     fprintf(fp,"%-s\n",loc_legend37.arr);

				     if (loc_legend38.arr[0] != '\0') 
				     fprintf(fp,"%-s\n",loc_legend38.arr);

				     if (loc_legend39.arr[0] != '\0') 
				     fprintf(fp,"%-s\n",loc_legend39.arr);

				     if (loc_legend40.arr[0] != '\0') 
				     fprintf(fp,"%-s\n",loc_legend40.arr);

				     if (loc_legend41.arr[0] != '\0') 
				     fprintf(fp,"%-s\n",loc_legend41.arr);

				     if (loc_legend42.arr[0] != '\0') 
				     fprintf(fp,"%-s\n",loc_legend42.arr);

				     if (loc_legend43.arr[0] != '\0') 
				     fprintf(fp,"%-s\n",loc_legend43.arr);

				     if (l_logo_yniflaser.arr[0] != 'Y')
				     {				
					fprintf(fp,"%c(s12H",ESC); 	/* To set the font size	  */
				     }
		}
		else
		{
			fprintf(fp,"\n\n\n\n");
		}


		fprintf(fp,"\n");
		fprintf(fp,"%-s\n",loc_legend28.arr);                		
		fprintf(fp,"\n");

		 /*--------------------19/09/2005---up to here-------------------*/

	}
	else
	{
		fprintf(fp,"\n\n\n");
	}

	/*if (nd_rec_ref_flag == 'R')
		fprintf(fp,"%-16.16s : %-40s\n\n\n",loc_legend16.arr,d_narration.arr);
	else
		fprintf(fp,"%-16.16s : %-40s\n\n\n",loc_legend17.arr,d_payer_name.arr);*
	/*        
		length_str[0] = 45;
		for (i =1;i<10;i++)
			length_str[i] = 80;
		for (i =1;i<10;i++)
			strcpy(out_str[i],"");


		no_of_lines =    print_in_words(d_doc_amt_num<0?-d_doc_amt_num:d_doc_amt_num,MAX_LINES,sub_cur_str.arr,out_str,nd_no_of_decimal);

		put_val(s_amt,d_doc_amt_num < 0? -d_doc_amt_num:d_doc_amt_num);
   
		format_amt(s_amt);
		if(nd_print_flag EQ 'R')
		{
			for(i=0;i<SKIP_5;i++) fprintf(fp," ");
		}
		else
		{
			for(i=0;i<SKIP_6;i++) fprintf(fp," ");
		}

		if(strlen(out_str[1]))
			strcat(out_str[1],")");
		else
			strcat(out_str[0],")");

		fprintf(fp,"\n");
		for(i=0;i<SKIP_3;i++) fprintf(fp," ");
		fprintf(fp,"THE SUM OF %s : %s\n",cur_str.arr,s_amt);
   
		if(d_doc_amt_num != 0)
			fprintf(fp,"\n\n 	   (%-6s",cur_str.arr);
         
		if(d_doc_amt_num == 0) 
		{
			fprintf(fp,"\n\n\t\t(%s",out_str[0]);
		}
		else
			fprintf(fp,"%s",out_str[0]);

		fprintf(fp," %s\n\n",out_str[1]);*/

		if ( l_logo_yniflaser.arr[0] != 'Y')
			fprintf(fp,"");
}

decl_dep_adj_cur()
{
/*
	if(strcmp(l_consolidated_receipt_yn.arr,"Y")==0)
	{
		      strcpy(l_sql_stmt," SELECT ORG_DOC_TYPE_CODE, \
										 ORG_DOC_NUM \
									FROM BL_PATIENT_LEDGER		\
								   WHERE EPISODE_TYPE = :d_episode_type\
									 AND PATIENT_ID = :d_patient_id\
									 AND EPISODE_ID = :d_episode_id\
									 AND NVL(VISIT_ID,1) = NVL(:d_visit_id,NVL(VISIT_ID,1))\
									 AND (AD_PR_ADJ_BILL_DOC_TYPE,AD_PR_ADJ_BILL_DOC_NUM) \
									      IN (SELECT BILL_DOC_TYPE_CODE, BILL_DOC_NUM FROM BL_BILLS_FOR_CONS_RECEIPT \
										       WHERE DOC_TYPE_CODE = :d_doc_type_code AND DOC_NUMBER = :d_doc_number)\
									 AND RECPT_NATURE_CODE IN ('AD','PR')\
								   ORDER BY 1");
	}
	else
	{
		      strcpy(l_sql_stmt," SELECT ORG_DOC_TYPE_CODE, \
										 ORG_DOC_NUM \
									FROM BL_PATIENT_LEDGER\
								   WHERE EPISODE_TYPE = :d_episode_type\
									 AND PATIENT_ID = :d_patient_id\
									 AND EPISODE_ID = :d_episode_id\
									 AND NVL(VISIT_ID,1) = NVL(:d_visit_id,NVL(VISIT_ID,1))\
									 AND AD_PR_ADJ_BILL_DOC_TYPE = :d_bill_doc_type_code\
									 AND AD_PR_ADJ_BILL_DOC_NUM = :d_bill_doc_number\
									 AND RECPT_NATURE_CODE IN ('AD','PR')\
								   ORDER BY 1");
	}


	EXEC SQL PREPARE SELECT_DEPOSIT FROM :l_sql_stmt;

	if(OERROR)	   
		err_mesg("DECLARE failed while PREPARING cursor dep_adj_cur",0,"");


	EXEC SQL DECLARE dep_adj_cur CURSOR FOR SELECT_DEPOSIT;

	if(OERROR)	   
		err_mesg("DECLARE failed on cursor dep_adj_cur",0,"");


	EXEC SQL OPEN dep_adj_cur USING :d_episode_type,:d_patient_id,:d_episode_id,:d_visit_id,:d_doc_type_code ,:d_doc_number;

	if(OERROR)	   
		err_mesg("OPEN failed on cursor dep_adj_cur",0,"");
*/
//KGA 
/* EXEC SQL DECLARE dep_adj_cur1 CURSOR FOR 
        SELECT  ORG_DOC_TYPE_CODE, 
	        ORG_DOC_NUM 	
        FROM    BL_PATIENT_LEDGER		
        WHERE   EPISODE_TYPE = :d_episode_type									 AND PATIENT_ID = :d_patient_id 
        AND     EPISODE_ID = :d_episode_id
	AND     NVL(VISIT_ID,1) = NVL(:d_visit_id,NVL(VISIT_ID,1))
	AND (AD_PR_ADJ_BILL_DOC_TYPE,AD_PR_ADJ_BILL_DOC_NUM) 
	IN (SELECT BILL_DOC_TYPE_CODE, BILL_DOC_NUM FROM BL_BILLS_FOR_CONS_RECEIPT 
	WHERE DOC_TYPE_CODE = :d_doc_type_code AND DOC_NUMBER = :d_doc_number)
	AND RECPT_NATURE_CODE IN ('AD','PR')
	ORDER BY 1; */ 


if(OERROR)	   
		err_mesg("DECLARE failed on cursor dep_adj_cur1 ",0,"");

/* EXEC SQL DECLARE dep_adj_cur2 CURSOR FOR 
SELECT ORG_DOC_TYPE_CODE, 
	 ORG_DOC_NUM 
	FROM BL_PATIENT_LEDGER
   WHERE EPISODE_TYPE = :d_episode_type
	 AND PATIENT_ID = :d_patient_id
	 AND EPISODE_ID = :d_episode_id
	 AND NVL(VISIT_ID,1) = NVL(:d_visit_id,NVL(VISIT_ID,1))
	 AND AD_PR_ADJ_BILL_DOC_TYPE = :d_bill_doc_type_code
	 AND AD_PR_ADJ_BILL_DOC_NUM = :d_bill_doc_number
	 AND RECPT_NATURE_CODE IN ('AD','PR')
  ORDER BY 1; */ 


  if(OERROR)	   
		err_mesg("DECLARE failed on cursor dep_adj_cur2 ",0,"");




if(strcmp(l_consolidated_receipt_yn.arr,"Y")==0)
 /* EXEC SQL   Open dep_adj_cur1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0013;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )365;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_doc_number;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


else
 /* EXEC SQL  Open dep_adj_cur2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0014;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )404;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_episode_type;
 sqlstm.sqhstl[0] = (unsigned int  )4;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_episode_id;
 sqlstm.sqhstl[2] = (unsigned int  )11;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_visit_id;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_bill_doc_type_code;
 sqlstm.sqhstl[4] = (unsigned int  )9;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_bill_doc_number;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if(OERROR)	   
   err_mesg("OPEN failed on cursor dep_adj_cur",0,"");



}

fetch_dep_adj_cur()    
{
	d_dep_doc_type_code.arr[0]	= '\0';
	d_dep_doc_num.arr[0]		= '\0';

	d_dep_doc_type_code.len = 0;
	d_dep_doc_num.len		= 0;


if(strcmp(l_consolidated_receipt_yn.arr,"Y")==0)	
	/* EXEC SQL FETCH dep_adj_cur1 
	          into :d_dep_doc_type_code,
				   :d_dep_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )443;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_dep_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_dep_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


else
	/* EXEC SQL FETCH dep_adj_cur2 
	          into :d_dep_doc_type_code,
				   :d_dep_doc_num; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )466;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_dep_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_dep_doc_num;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	
	if(OERROR)	   
		err_mesg("FETCH failed on cursor dep_adj_cur",0,"");

    if (sqlca.sqlcode == 1403 )	
		return 0;

	d_dep_doc_type_code.arr[d_dep_doc_type_code.len]	= '\0';
	d_dep_doc_num.arr[d_dep_doc_num.len]				= '\0';

	return 1;
}



close_cursor()
{

if(strcmp(l_consolidated_receipt_yn.arr,"Y")==0)  
 /* EXEC SQL close dep_adj_cur1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )489;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


else
 /* EXEC SQL close dep_adj_cur2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )504;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}

declare_dep_cursor()
{   
	/* EXEC SQL DECLARE deposit_cursor CURSOR FOR 
	SELECT a.BLNG_SERV_CODE,a.DEPOSIT_AMT,
		   b.long_desc	
	  FROM BL_RCPT_RFND_SERVICE_DTL a,
		   BL_BLNG_SERV B
	 WHERE a.DOC_TYPE_CODE  = :d_doc_type_code 
	   AND a.DOC_NUMBER = To_NUMBER(:d_doc_number) 
	   AND a.blng_serv_code = b.blng_serv_code
	 ORDER 
	    BY 1; */ 


	if(OERROR)	   
		err_mesg("DECLARE failed on cursor deposit_cursor",0,"");
	
	nd_dep_status = 0;
    /* EXEC SQL OPEN deposit_cursor; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0015;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )519;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_doc_number;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if(OERROR)	   
		err_mesg("OPEN failed on cursor deposit_cursor",0,"");
	
    while (fetch_dep_cursor())
    {  
		if ( nd_dep_status == 1 )
		{
			fprintf(fp,"\n\n");
			fprintf(fp,"    SERVICE CODE  DESCRIPTION                    APPROX.SERVICE CHARGE\n ");
			fprintf(fp,"   ------------  -----------                    ---------------------\n");
		}
       
	    fprintf(fp,"    %-12.12s  %-30.30s ",nd_service_code.arr,nd_service_desc.arr);  
		print_formated(nd_dep_amt) ;   
		fprintf(fp,"\n");
    }
	
	/* exec sql close deposit_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )542;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_dep_cursor()
{
    nd_service_code.arr[0] = '\0';
    nd_service_code.len	   = 0;
	nd_service_desc.arr[0]	   = '\0';
    nd_service_desc.len	   = 0;
    nd_dep_amt = 0;
    /* EXEC SQL FETCH deposit_cursor INTO	
		:nd_service_code,:nd_dep_amt,:nd_service_desc; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )557;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_service_code;
    sqlstm.sqhstl[0] = (unsigned int  )13;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_dep_amt;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(double);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_service_desc;
    sqlstm.sqhstl[2] = (unsigned int  )43;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    if(OERROR)	   
	err_mesg("FETCH failed on cursor deposit_cursor",0,"");

    if (sqlca.sqlcode == 1403 )	
	return 0;
     nd_service_code.arr[nd_service_code.len] = '\0';
	 nd_service_desc.arr[nd_service_desc.len] = '\0';
        nd_dep_status = nd_dep_status + 1;
        return 1;   
}

print_formated(loc_amount)
double loc_amount;
{
	char s_amt[30], str_amt[30];	

    if(loc_amount < 0)
	{
        put_val(s_amt,-loc_amount);        
        format_amt(s_amt);
	    strcat(s_amt,"-");
        sprintf(str_amt,"%-14s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%-14s",str_amt);
    }
    else 
	{
        put_val(s_amt,loc_amount);         
        format_amt(s_amt);
        sprintf(str_amt,"%-14s",s_amt);
		l_ltrim(s_amt);
        fprintf(fp,"%-14s ",str_amt);
    }

}

update_rec()
{
	
	
    /* EXEC SQL UPDATE BL_RECEIPT_REFUND_HDR
             SET PRINT_FLAG = 'Y'
			 WHERE DOC_TYPE_CODE = :d_doc_type_code
			 AND DOC_NUMBER	= :d_doc_number; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 7;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update BL_RECEIPT_REFUND_HDR  set PRINT_FLAG='Y' where (D\
OC_TYPE_CODE=:b0 and DOC_NUMBER=:b1)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )584;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_doc_number;
    sqlstm.sqhstl[1] = (unsigned int  )11;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



            /*WHERE ROWID = :d_rowid;*/

     if (OERROR)
	{   
         err_mesg("UPDATE failed on table BL_RECEIPT_REFUND_HDR",0,"");
	}
}

fetch_legend_value()
{
	loc_legend1.arr[0]		= '\0';
	loc_legend2.arr[0]		= '\0';
	loc_legend3.arr[0]		= '\0';
	loc_legend4.arr[0]		= '\0';
	loc_legend5.arr[0]		= '\0';
	loc_legend6.arr[0]		= '\0';
	loc_legend7.arr[0]		= '\0';
	loc_legend8.arr[0]		= '\0';
	loc_legend9.arr[0]		= '\0';
	loc_legend10.arr[0]		= '\0';
	loc_legend11.arr[0]		= '\0';
	loc_legend12.arr[0]		= '\0';
	loc_legend13.arr[0]		= '\0';
	loc_legend14.arr[0]		= '\0';
	loc_legend15.arr[0]		= '\0';
	loc_legend16.arr[0]		= '\0';
	loc_legend17.arr[0]		= '\0';

	loc_legend20.arr[0]		= '\0';
	loc_legend21.arr[0]		= '\0';
	loc_legend22.arr[0]		= '\0';
	loc_legend23.arr[0]		= '\0';
	loc_legend24.arr[0]		= '\0';
	loc_legend25.arr[0]		= '\0';
	loc_legend26.arr[0]		= '\0';
	loc_legend27.arr[0]		= '\0';
	loc_legend28.arr[0]		= '\0';	
  // ----------------------------------------------19092005--
	loc_legend29.arr[0]		= '\0';	
	loc_legend30.arr[0]		= '\0';	
	loc_legend31.arr[0]		= '\0';	
	loc_legend32.arr[0]		= '\0';			
	loc_legend33.arr[0]		= '\0';	
	loc_legend34.arr[0]		= '\0';	
	loc_legend35.arr[0]		= '\0';	
	loc_legend36.arr[0]		= '\0';	
	loc_legend37.arr[0]		= '\0';	
	loc_legend38.arr[0]		= '\0';	
	loc_legend39.arr[0]		= '\0';	
	loc_legend40.arr[0]		= '\0';	
	loc_legend41.arr[0]		= '\0';	
	loc_legend42.arr[0]		= '\0';	
	loc_legend43.arr[0]		= '\0';
	
	loc_legend50.arr[0]		= '\0';	
// ------------------------------------------------19092005--Up to Here--


	loc_legend1.len			= 0;
	loc_legend2.len			= 0;
	loc_legend3.len			= 0;
	loc_legend4.len			= 0;
	loc_legend5.len			= 0;
	loc_legend6.len			= 0;
	loc_legend7.len			= 0;
	loc_legend8.len			= 0;
	loc_legend9.len			= 0;
	loc_legend10.len		= 0;
	loc_legend11.len		= 0;
	loc_legend12.len		= 0;
	loc_legend13.len		= 0;
	loc_legend14.len		= 0;
	loc_legend15.len		= 0;
	loc_legend16.len		= 0;
	loc_legend17.len		= 0;

	loc_legend20.len		= 0;
	loc_legend21.len		= 0;
	loc_legend22.len		= 0;
	loc_legend23.len		= 0;
	loc_legend24.len		= 0;
	loc_legend25.len		= 0;
	loc_legend26.len		= 0;
	loc_legend27.len		= 0;
	loc_legend28.len		= 0;
  // ----------------------------------------------19092005--
	loc_legend29.len		= 0;
	loc_legend30.len		= 0;
	loc_legend31.len		= 0;
	loc_legend32.len		= 0;
	loc_legend33.len		= 0;
	loc_legend34.len		= 0;
	loc_legend35.len		= 0;
	loc_legend36.len		= 0;
	loc_legend37.len		= 0;
	loc_legend38.len		= 0;
	loc_legend39.len		= 0;
	loc_legend40.len		= 0;
	loc_legend41.len		= 0;
	loc_legend42.len		= 0;
	loc_legend43.len		= 0;

	loc_legend50.len		= 0;

  // ----------------------------------------------19092005--Upto Here---

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend1
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_010' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_010') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )607;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend1;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend1
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_010'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_010'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )630;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend1;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 1",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend2
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_020' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_020') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )649;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend2;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend2
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_020'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_020'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )672;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend2;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 2",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend3
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_030' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_030') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )691;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend3;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend3
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_030'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_030'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )714;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend3;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 3",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend4
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_040' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_040') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )733;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend4;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend4
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_040'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_040'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )756;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend4;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 4",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend5
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_050' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_050') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )775;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend5;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend5
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_050'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_050'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )798;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend5;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 5",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend6
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_060' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_060') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )817;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend6;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend6
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_060'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_060'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )840;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend6;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 6",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend7
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_070' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_070') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )859;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend7;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend7
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_070'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_070'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )882;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend7;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 7",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend8
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_080' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_080') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )901;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend8;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend8
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_080'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_080'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )924;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend8;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 8",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend9
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_090' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_090') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )943;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend9;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend9
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_090'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_090'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )966;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend9;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 9",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend10
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_100' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_100') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )985;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend10;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend10
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_100'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_100'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1008;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend10;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 10",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend11
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_110' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_110') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1027;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend11;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend11
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_110'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_110'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1050;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend11;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 11",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend12
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_120' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_120') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1069;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend12;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend12
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_120'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_120'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1092;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend12;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 12",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend13
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_130' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_130') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1111;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend13;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend13
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_130'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_130'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1134;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend13;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 13",0,"");
	}


	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend14
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_140' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_140') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1153;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend14;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend14
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_140'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_140'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1176;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend14;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 14",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend15
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_150' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_150') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1195;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend15;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend15
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_150'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_150'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1218;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend15;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 15",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend16
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_160' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_160') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1237;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend16;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend16
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_160'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_160'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1260;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend16;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 16",0,"");
	}

	/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend17
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_170' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_RE\
CORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM\
_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and \
LEGEND_ID='RECEIPT.LEGEND_170') and LANGUAGE_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1279;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend17;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
 sqlstm.sqhstl[1] = (unsigned int  )6;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend17
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_170'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_170'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1302;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend17;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 17",0,"");
	}


		/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend20
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_200' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 7;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_R\
ECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='S\
M_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and\
 LEGEND_ID='RECEIPT.LEGEND_200') and LANGUAGE_ID=:b1)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1321;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&loc_legend20;
  sqlstm.sqhstl[0] = (unsigned int  )203;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
  sqlstm.sqhstl[1] = (unsigned int  )6;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend20
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_200'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_200'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1344;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend20;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 20",0,"");
	}


/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
				into :loc_legend21
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_210' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_REC\
ORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_\
LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and L\
EGEND_ID='RECEIPT.LEGEND_210') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1363;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend21;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend21
				from sm_lang_legend
				where LEGEND_ID = 'RECEIPT.LEGEND_210'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_210'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1386;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend21;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 21",0,"");
	}


			/* EXEC SQL select 
			lpad(' ',round((:l_margin_len-length(rtrim(substr(COLUMN_VALUE,1,50))))/2),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))	
			/ortrim(substr(COLUMN_VALUE,1,50))o/
				into :loc_legend22
				from SM_RECORD_TRANS_DATA a,sm_lang_legend b
				where MODULE_ID = 'SM' 
				and	TABLE_ID = 'SM_LANG_LEGEND'
				and COLUMN_ID = 'DFLT_LEGEND_VALUE'
				and PK_VALUE = LEGEND_ID
				and LEGEND_ID = 'RECEIPT.LEGEND_220' 
				and LANGUAGE_ID = :nd_lang_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(COLUMN_VA\
LUE,1,50))))/2)),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))) into :b1  from\
 SM_RECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_\
ID='SM_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID\
) and LEGEND_ID='RECEIPT.LEGEND_220') and LANGUAGE_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1405;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&loc_legend22;
   sqlstm.sqhstl[1] = (unsigned int  )203;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
   sqlstm.sqhstl[2] = (unsigned int  )6;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select /o dflt_legend_value o/
			lpad(' ',round((:l_margin_len-length(rtrim(substr(dflt_legend_value,1,50))))/2),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))				
			into :loc_legend22
			from sm_lang_legend
			where LEGEND_ID = 'RECEIPT.LEGEND_220'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(dflt_legend\
_value,1,50))))/2)),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))) into :\
b1  from sm_lang_legend where LEGEND_ID='RECEIPT.LEGEND_220'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1432;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend22;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

	if (sqlca.sqlcode < 0)
	{   
		err_mesg("SELECT failed on LEGEND 22",0,"");
	}

/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
		into :loc_legend23
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_230' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_REC\
ORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_\
LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and L\
EGEND_ID='RECEIPT.LEGEND_230') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1455;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend23;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend23
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_230'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_230'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1478;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend23;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 23",0,"");
}

/* EXEC SQL select /ortrim(substr(COLUMN_VALUE,1,50))o/
		lpad(' ',round((:l_margin_len-length(rtrim(substr(COLUMN_VALUE,1,50))))/2),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))	
		into :loc_legend24
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_240' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(COLUMN_VALUE\
,1,50))))/2)),' ')||UPPER(rtrim(substr(COLUMN_VALUE,1,50)))) into :b1  from SM\
_RECORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID=\
'SM_LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) a\
nd LEGEND_ID='RECEIPT.LEGEND_240') and LANGUAGE_ID=:b2)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1497;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&loc_legend24;
sqlstm.sqhstl[1] = (unsigned int  )203;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqhstv[2] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[2] = (unsigned int  )6;
sqlstm.sqhsts[2] = (         int  )0;
sqlstm.sqindv[2] = (         void  *)0;
sqlstm.sqinds[2] = (         int  )0;
sqlstm.sqharm[2] = (unsigned int  )0;
sqlstm.sqadto[2] = (unsigned short )0;
sqlstm.sqtdso[2] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select /o dflt_legend_value o/
		lpad(' ',round((:l_margin_len-length(rtrim(substr(dflt_legend_value,1,50))))/2),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))			
		into :loc_legend24
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_240'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select (lpad(' ',round(((:b0-length(rtrim(substr(dflt_legend\
_value,1,50))))/2)),' ')||UPPER(rtrim(substr(dflt_legend_value,1,50)))) into :\
b1  from sm_lang_legend where LEGEND_ID='RECEIPT.LEGEND_240'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1524;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_margin_len;
 sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&loc_legend24;
 sqlstm.sqhstl[1] = (unsigned int  )203;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 24",0,"");
}

/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
		into :loc_legend25
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_250' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_REC\
ORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_\
LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and L\
EGEND_ID='RECEIPT.LEGEND_250') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1547;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend25;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend25
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_250'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_250'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1570;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend25;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 25",0,"");
}


/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
		into :loc_legend26
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_260' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_REC\
ORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_\
LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and L\
EGEND_ID='RECEIPT.LEGEND_260') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1589;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend26;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend26
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_260'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_260'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1612;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend26;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 26",0,"");
}

/* EXEC SQL select rtrim(substr(COLUMN_VALUE,1,50))
		into :loc_legend27
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_270' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select rtrim(substr(COLUMN_VALUE,1,50)) into :b0  from SM_REC\
ORD_TRANS_DATA a ,sm_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_\
LANG_LEGEND') and COLUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and L\
EGEND_ID='RECEIPT.LEGEND_270') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1631;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend27;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend27
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_270'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_270'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1654;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend27;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 27",0,"");
}


/* EXEC SQL select /ortrim(substr(COLUMN_VALUE,1,50))o/ COLUMN_VALUE
		into :loc_legend28
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_280' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_280') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1673;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend28;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend28
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_280'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_280'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1696;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend28;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 28",0,"");

}
           /*---------------------19092005-------------------------------------*/

/* EXEC SQL select COLUMN_VALUE
		into :loc_legend29
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_290' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_290') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1715;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend29;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend29
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_290'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_290'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1738;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend29;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 29",0,"");
}


/* EXEC SQL select COLUMN_VALUE
		into :loc_legend30
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_300' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_300') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1757;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend30;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend30
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_300'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_300'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1780;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend30;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 30",0,"");
}

/* EXEC SQL select COLUMN_VALUE
		into :loc_legend31
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_310' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_310') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1799;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend31;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend31
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_310'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_310'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1822;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend31;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 31",0,"");
}

/* EXEC SQL select COLUMN_VALUE
		into :loc_legend32
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_320' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_320') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1841;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend32;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend32
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_320'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_320'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1864;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend32;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 32",0,"");
}

/* EXEC SQL select COLUMN_VALUE
		into :loc_legend33
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_330' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_330') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1883;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend33;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend33
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_330'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_330'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1906;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend33;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 33",0,"");
}

/* EXEC SQL select COLUMN_VALUE
		into :loc_legend34
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_340' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_340') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1925;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend34;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend34
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_340'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_340'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1948;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend34;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 34",0,"");
}


/* EXEC SQL select COLUMN_VALUE
		into :loc_legend35
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_350' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_350') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )1967;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend35;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend35
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_350'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_350'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1990;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend35;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 35",0,"");
}


/* EXEC SQL select COLUMN_VALUE
		into :loc_legend36
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_360' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_360') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2009;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend36;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend36
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_360'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_360'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2032;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend36;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 36",0,"");
}



/* EXEC SQL select COLUMN_VALUE
		into :loc_legend37
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_370' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_370') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2051;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend37;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend37
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_370'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_370'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2074;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend37;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 37",0,"");
}


/* EXEC SQL select COLUMN_VALUE
		into :loc_legend38
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_380' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_380') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2093;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend38;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend38
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_380'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_380'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2116;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend38;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 38",0,"");
}


/* EXEC SQL select COLUMN_VALUE
		into :loc_legend39
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_390' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_390') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2135;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend39;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend39
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_390'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_390'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2158;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend39;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 39",0,"");
}


/* EXEC SQL select COLUMN_VALUE
		into :loc_legend40
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_400' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_400') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2177;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend40;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend40
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_400'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_400'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2200;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend40;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 40",0,"");
}

/* EXEC SQL select COLUMN_VALUE
		into :loc_legend41
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_410' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_410') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2219;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend41;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend41
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_410'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_410'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2242;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend41;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 41",0,"");
}

/* EXEC SQL select COLUMN_VALUE
		into :loc_legend42
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_420' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_420') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2261;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend42;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend42
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_420'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_420'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2284;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend42;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 42",0,"");
}

/* EXEC SQL select COLUMN_VALUE
		into :loc_legend43
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_430' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_430') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2303;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend43;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend43
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_430'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_430'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2326;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend43;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 43",0,"");
}


/* EXEC SQL select COLUMN_VALUE
		into :loc_legend50
		from SM_RECORD_TRANS_DATA a,sm_lang_legend b
		where MODULE_ID = 'SM' 
		and TABLE_ID = 'SM_LANG_LEGEND'
		and COLUMN_ID = 'DFLT_LEGEND_VALUE'
		and PK_VALUE = LEGEND_ID
		and LEGEND_ID = 'RECEIPT.LEGEND_500' 
		and LANGUAGE_ID = :nd_lang_id; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 7;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.stmt = "select COLUMN_VALUE into :b0  from SM_RECORD_TRANS_DATA a ,sm\
_lang_legend b where (((((MODULE_ID='SM' and TABLE_ID='SM_LANG_LEGEND') and CO\
LUMN_ID='DFLT_LEGEND_VALUE') and PK_VALUE=LEGEND_ID) and LEGEND_ID='RECEIPT.LE\
GEND_500') and LANGUAGE_ID=:b1)";
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2345;
sqlstm.selerr = (unsigned short)1;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlstm.sqhstv[0] = (         void  *)&loc_legend50;
sqlstm.sqhstl[0] = (unsigned int  )203;
sqlstm.sqhsts[0] = (         int  )0;
sqlstm.sqindv[0] = (         void  *)0;
sqlstm.sqinds[0] = (         int  )0;
sqlstm.sqharm[0] = (unsigned int  )0;
sqlstm.sqadto[0] = (unsigned short )0;
sqlstm.sqtdso[0] = (unsigned short )0;
sqlstm.sqhstv[1] = (         void  *)&nd_lang_id;
sqlstm.sqhstl[1] = (unsigned int  )6;
sqlstm.sqhsts[1] = (         int  )0;
sqlstm.sqindv[1] = (         void  *)0;
sqlstm.sqinds[1] = (         int  )0;
sqlstm.sqharm[1] = (unsigned int  )0;
sqlstm.sqadto[1] = (unsigned short )0;
sqlstm.sqtdso[1] = (unsigned short )0;
sqlstm.sqphsv = sqlstm.sqhstv;
sqlstm.sqphsl = sqlstm.sqhstl;
sqlstm.sqphss = sqlstm.sqhsts;
sqlstm.sqpind = sqlstm.sqindv;
sqlstm.sqpins = sqlstm.sqinds;
sqlstm.sqparm = sqlstm.sqharm;
sqlstm.sqparc = sqlstm.sqharc;
sqlstm.sqpadto = sqlstm.sqadto;
sqlstm.sqptdso = sqlstm.sqtdso;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



if (sqlca.sqlcode == 1403)
{
	/* EXEC SQL select dflt_legend_value into :loc_legend50
		from sm_lang_legend
		where LEGEND_ID = 'RECEIPT.LEGEND_500'; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select dflt_legend_value into :b0  from sm_lang_legend where\
 LEGEND_ID='RECEIPT.LEGEND_500'";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2368;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&loc_legend50;
 sqlstm.sqhstl[0] = (unsigned int  )203;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

if (sqlca.sqlcode < 0)
{   
	err_mesg("SELECT failed on LEGEND 50",0,"");
}



	loc_legend1.arr[loc_legend1.len]		= '\0';
	loc_legend2.arr[loc_legend2.len]		= '\0';
	loc_legend3.arr[loc_legend3.len]		= '\0';
	loc_legend4.arr[loc_legend4.len]		= '\0';
	loc_legend5.arr[loc_legend5.len]		= '\0';
	loc_legend6.arr[loc_legend6.len]		= '\0';
	loc_legend7.arr[loc_legend7.len]		= '\0';
	loc_legend8.arr[loc_legend8.len]		= '\0';
	loc_legend9.arr[loc_legend9.len]		= '\0';
	loc_legend10.arr[loc_legend10.len]		= '\0';
	loc_legend11.arr[loc_legend11.len]		= '\0';
	loc_legend12.arr[loc_legend12.len]		= '\0';
	loc_legend13.arr[loc_legend13.len]		= '\0';
	loc_legend14.arr[loc_legend14.len]		= '\0';
	loc_legend15.arr[loc_legend15.len]		= '\0';
	loc_legend16.arr[loc_legend16.len]		= '\0';
	loc_legend17.arr[loc_legend17.len]		= '\0';

	loc_legend20.arr[loc_legend20.len]		= '\0';
	loc_legend21.arr[loc_legend21.len]		= '\0';
	loc_legend22.arr[loc_legend22.len]		= '\0';
	loc_legend23.arr[loc_legend23.len]		= '\0';
	loc_legend24.arr[loc_legend24.len]		= '\0';
	loc_legend25.arr[loc_legend25.len]		= '\0';
	loc_legend26.arr[loc_legend26.len]		= '\0';
	loc_legend27.arr[loc_legend27.len]		= '\0';
	loc_legend28.arr[loc_legend28.len]		= '\0';
	loc_legend29.arr[loc_legend29.len]		= '\0';
	loc_legend30.arr[loc_legend30.len]		= '\0';
	loc_legend31.arr[loc_legend31.len]		= '\0';
	loc_legend32.arr[loc_legend32.len]		= '\0';
	loc_legend33.arr[loc_legend33.len]		= '\0';
	loc_legend34.arr[loc_legend34.len]		= '\0';
	loc_legend35.arr[loc_legend35.len]		= '\0';
	loc_legend36.arr[loc_legend36.len]		= '\0';
	loc_legend37.arr[loc_legend37.len]		= '\0';
	loc_legend38.arr[loc_legend38.len]		= '\0';
	loc_legend39.arr[loc_legend39.len]		= '\0';
	loc_legend40.arr[loc_legend40.len]		= '\0';
	loc_legend41.arr[loc_legend41.len]		= '\0';
	loc_legend42.arr[loc_legend42.len]		= '\0';
	loc_legend43.arr[loc_legend43.len]		= '\0';

	loc_legend50.arr[loc_legend50.len]		= '\0';
}

decl_consolidated_rec_cursor()
{
	/* EXEC SQL DECLARE consolidated_recpt_cur CURSOR FOR
	 SELECT 
   DISTINCT ext_acct_facility_id,
			ext_acct_code,       
			ext_acct_dept_code
	   FROM bl_bills_for_cons_Receipt
	  WHERE doc_type_code         = :d_doc_type_code
        AND doc_number			  = :d_doc_number; */ 


    if (OERROR)
		err_mesg("SELECT failed on cursor bl_bills_for_cons_Receipt",0,"");
}

open_consolidated_recpt_cur()
{
	/* EXEC SQL OPEN consolidated_recpt_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0101;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2387;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_number;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)	   
		err_mesg("OPEN failed on cursor consolidated_recpt_cur",0,"");
}

fetch_consolidated_recpt_cur()
{
	l_ext_acct_facility_id.arr[0]	= '\0';
	l_ext_acct_code.arr[0]			= '\0';  
	l_ext_acct_dept_code.arr[0]		= '\0';

	/* EXEC SQL FETCH consolidated_recpt_cur 
	          INTO :l_ext_acct_facility_id,  
				   :l_ext_acct_code,
			       :l_ext_acct_dept_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2410;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_ext_acct_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )17;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_ext_acct_code;
 sqlstm.sqhstl[1] = (unsigned int  )17;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_ext_acct_dept_code;
 sqlstm.sqhstl[2] = (unsigned int  )10;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)	   
		err_mesg("FETCH failed on cursor consolidated_recpt_cur ",0,"");

    if (sqlca.sqlcode == 1403 )	
		return 0;

	l_ext_acct_facility_id.arr[l_ext_acct_facility_id.len] = '\0';
	l_ext_acct_code.arr[l_ext_acct_code.len]		  	   = '\0';  
	l_ext_acct_dept_code.arr[l_ext_acct_dept_code.len]	   = '\0';

	return 1;
}

print_consolidated_Receipt()
{
	int l_no_of_recpts=0;
	
	open_consolidated_recpt_cur();

	prt_space();
	fprintf(fp,"%-16.16s : ",loc_legend5.arr);

	while(fetch_consolidated_recpt_cur())
	{
		if(l_no_of_recpts==2)
		{
			fprintf(fp,"\n");
			prt_space();
			fprintf(fp,"%-16.16s   "," ");			
			l_no_of_recpts=0;
		}
		l_no_of_recpts++;
		if (l_no_of_recpts>1)
		{
			fprintf(fp,", ");
		}
		if (strcmp(nd_recpt_nature_code.arr,"MI") == 0)
		   fprintf(fp,"%-s/%-s/%-s",l_ext_acct_facility_id.arr,l_ext_acct_dept_code.arr,l_ext_acct_code.arr);		
		else
		   fprintf(fp,"%-s/%-s",l_ext_acct_facility_id.arr,l_ext_acct_code.arr);

	}
	fprintf(fp,"\n");				
	
	/* EXEC SQL CLOSE consolidated_recpt_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2437;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)	   
		err_mesg("FETCH failed on cursor print_consolidated_Receipt",0,"");
}

decl_cons_rec_bill_cursor()
{

	/* EXEC SQL DECLARE cons_recpt_bill_cur CURSOR FOR
	 SELECT	bill_doc_type_code,
	        bill_doc_num
	   FROM bl_bills_for_cons_Receipt
	  WHERE doc_type_code         = :d_doc_type_code
        AND doc_number			  = :d_doc_number; */ 


    if (OERROR)
		err_mesg("SELECT failed on cursor bl_bills_for_cons_Receipt",0,"");

	/* EXEC SQL OPEN cons_recpt_bill_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0102;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2452;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_number;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)	   
		err_mesg("OPEN failed on cursor consolidated_recpt_cur",0,"");
}

fetch_cons_rec_bill_cursor()
{
	l_bill_doc_type_code.arr[0]	= '\0';
	l_bill_doc_number=0;

	/* EXEC SQL FETCH cons_recpt_bill_cur 
	          INTO :l_bill_doc_type_code,  
				   :l_bill_doc_number; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2475;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_bill_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )12;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_bill_doc_number;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(long);
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)	   
		err_mesg("FETCH failed on cursor cons_recpt_bill_cur ",0,"");

    if (sqlca.sqlcode == 1403 )	
		return 0;

	l_bill_doc_type_code.arr[l_bill_doc_type_code.len]	= '\0';

	return 1;
}

print_consolidated_Receipt_bill()
{
	int l_no_of_recpts=0;

	prt_space();
	fprintf(fp,"%-16.16s : ",loc_legend11.arr);
	
	while(fetch_cons_rec_bill_cursor())
	{
		if(l_no_of_recpts==2)
		{
			fprintf(fp,"\n");
			prt_space();
			fprintf(fp,"%-16.16s   "," ");
			l_no_of_recpts=0;
		}
		l_no_of_recpts++;

		if (l_no_of_recpts>1)
		{
				fprintf(fp,", ");
		}
		fprintf(fp,"%-s/%-ld",l_bill_doc_type_code.arr,l_bill_doc_number);
	}
	fprintf(fp,"\n");
	
	/* EXEC SQL CLOSE cons_recpt_bill_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2498;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if(OERROR)	   
		err_mesg("CLOSE failed on cursor cons_recpt_bill_cur",0,"");

}

prt_space()
{
	if (l_lsr != 0 && l_dmp == 0 && l_logo_yniflaser.arr[0] == 'Y')
	{
		fprintf(fp,"               ");
	}
}

prt_space_hdr()
{
	if (l_lsr != 0 && l_dmp == 0 && l_logo_yniflaser.arr[0] == 'Y')
	{
		fprintf(fp,"                      ");
	}
}
print_report_header()
{	int i;
	if (l_lsr != 0 && l_dmp == 0)
	{		
		if ( l_logo_yniflaser.arr[0] != 'Y')
		  {
		      fprintf(fp,"%c&a10L",ESC); 	/* To Set the Left margin */
		      fprintf(fp,"%c(s12H",ESC); 	/* To set the font size	  */
		      fprintf(fp,"%c(s3B",ESC); 	/* To set Bold style 	  */	      
		  }
	}
	else
	{
	      fprintf(fp,"%cg ",ESC); 	/* To Set compressed mode */
	}

	if (l_lsr != 0 && l_dmp == 0)
	{
		fprintf(fp,"\n");
	}
	else
	{
		fprintf(fp,"\n\n");
	}



	

	if (l_lsr != 0 && l_dmp == 0)
	{
	   if ( l_logo_yniflaser.arr[0] != 'Y')
	   {
	      fprintf(fp,"%c&d0D",ESC); /* set Underline mode */
	      fprintf(fp,"%c(s11H",ESC); 	/* To set the font size	  */
	   }
	      prt_space();
	      fprintf(fp,"%-s",loc_legend20.arr);		     
	    
	    if ( l_logo_yniflaser.arr[0] != 'Y')
	    {
	      fprintf(fp,"%c(s12H",ESC); 	/* To set the font size	  */
	      fprintf(fp,"%c&d@",ESC); 	/* release underline mode */
	     }

	      len1 = 19 - loc_legend20.len;

	      if (len1 > 0)
	      {
	         for (i=0;i<len1;i++)
		 {
		     fprintf(fp,"%-s"," ");		     
		 }
	      }
	      if ( l_logo_yniflaser.arr[0] == 'Y')
	      {
			//fprintf(fp," %-20.20s %-20.20s\n"," ",loc_legend21.arr);		     
			fprintf(fp," %-20.20s %-s/%-s/%-s\n"," ",d_doc_type_code.arr,d_doc_number.arr,d_doc_srno.arr);
	      }
	      else
	      {
			//fprintf(fp," %-35.35s %-20.20s\n"," ",loc_legend21.arr);		     
			fprintf(fp," %-35.35s %-s/%-s/%-s\n"," ",d_doc_type_code.arr,d_doc_number.arr,d_doc_srno.arr);		     
	      }

	}
	if (l_lsr != 0 && l_dmp == 0)
	{
	      if ( l_logo_yniflaser.arr[0] == 'Y')
	      {
			prt_space();	
		      //fprintf(fp,"%-19.19s  %-20.20s %-s/%-s/%-s",loc_legend1.arr," ",d_doc_type_code.arr,d_doc_number.arr,d_doc_srno.arr);
			fprintf(fp,"%-19.19s %-20.20s %-20.20s",loc_legend1.arr," ",loc_legend21.arr);
		}
	      else
	      {
			prt_space();
		      //fprintf(fp,"%-19.19s  %-35.35s %-s/%-s/%-s",loc_legend1.arr," ",d_doc_type_code.arr,d_doc_number.arr,d_doc_srno.arr);
			fprintf(fp,"%-19.19s  %-35.35s %-20.20s",loc_legend1.arr," ",loc_legend21.arr);
		}
	}
	else
	{
		prt_space();
		fprintf(fp,"%-19.19s  %-17.17s %-s/%-s/%-s",loc_legend1.arr," ",d_doc_type_code.arr,d_doc_number.arr,d_doc_srno.arr);
	}

	if (l_lsr != 0 && l_dmp == 0)
	{
		fprintf(fp,"\n\n\n");
	}
	else
	{		
		fprintf(fp,"\n\n\n\n\n\n\n");
	}
}

declare_receipt_cursor()
{
    d_doc_date.arr[0]                                                 = '\0';
    d_episode_type.arr[0]                                             = '\0';
    d_patient_id.arr[0]                                               = '\0';
    d_episode_id.arr[0]                                               = '\0';
    d_visit_id.arr[0]                                                 = '\0';
    d_bill_doc_type_code.arr[0]                                       = '\0';
    d_bill_doc_number.arr[0]                                          = '\0';
    d_customer_code.arr[0]                                            = '\0';
    d_doc_amt.arr[0]                                                  = '\0';
    d_slmt_type_code.arr[0]                                           = '\0';
    d_slmt_doc_ref_desc.arr[0]                                        = '\0';
    d_slmt_doc_ref_date.arr[0]                                        = '\0';
    d_slmt_doc_remarks.arr[0]                                         = '\0';
    d_narration.arr[0]                                                = '\0';
    d_payer_name.arr[0]                                               = '\0';
    d_rowid.arr[0]                                                    = '\0';
    d_trx_date_time.arr[0]                                            = '\0';
    d_cash_counter_code.arr[0]                                        = '\0';
    d_shift_id.arr[0]                                                 = '\0';
    d_doc_type_num.arr[0]                                             = '\0';
    nd_hcare_appl_num.arr[0]  										  = '\0';
	d_doc_time.arr[0]												  = '\0';
	d_doc_no.arr[0]													  = '\0';
    nd_recpt_nature_code.arr[0]										  = '\0';
	d_receipt_type.arr[0]											  = '\0';
    
    d_doc_date.len                                                    = 0;
    d_episode_type.len                                                = 0;
    d_patient_id.len                                                  = 0;
    d_episode_id.len                                                  = 0;
    d_visit_id.len                                                    = 0;
    d_bill_doc_type_code.len                                          = 0;
    d_bill_doc_number.len                                             = 0;
    d_customer_code.len                                               = 0;
    d_doc_amt.len                                                     = 0;
    d_slmt_type_code.len                                              = 0;
    d_slmt_doc_ref_desc.len                                           = 0;
    d_slmt_doc_ref_date.len                                           = 0;
    d_slmt_doc_remarks.len                                            = 0;
    d_narration.len                                                   = 0;
    d_payer_name.len                                                  = 0;
    d_rowid.len                                                       = 0;
    d_trx_date_time.len                                               = 0;
    d_cash_counter_code.len                                           = 0;
    d_shift_id.len                                                    = 0;
    d_doc_type_num.len                                                = 0;
	d_doc_time.len													  = 0;
	d_doc_no.len													  = 0;
    nd_hcare_appl_num.len											  = 0;
    nd_recpt_nature_code.len										  = 0;
	d_receipt_type.len												  = 0;
    d_doc_amt_num                                                     = 0;

    nd_cashier.arr[0]						      = '\0';
    nd_cashier.len								= 0;
   l_consolidated_receipt_yn.arr[0]				= '\0';
   l_ext_acct_facility_id.arr[0]				= '\0';
   l_ext_acct_code.arr[0]						= '\0';
   l_ext_acct_dept_code.arr[0]					= '\0';
    
   /* EXEC SQL DECLARE receipt_cursor CURSOR FOR
			SELECT a.DOC_TYPE_CODE,
                   a.DOC_NUMBER,
				   A.DOC_SRNO,
                   to_char(a.DOC_DATE,'dd/mm/yyyy'),
				   to_char(a.DOC_DATE,'HH24:MI:SS'),
                   a.EPISODE_TYPE,
                   a.PATIENT_ID,
                   LTRIM(TO_CHAR(a.EPISODE_ID,'00000009')), 
                   a.VISIT_ID,
                   a.BILL_DOC_TYPE_CODE,
                   LTRIM(TO_CHAR(a.BILL_DOC_NUMBER,'00000009')),
                   a.CUSTOMER_CODE,
                   TO_CHAR(a.DOC_AMT) DOC_AMT,
                   a.SLMT_TYPE_CODE,
                   a.SLMT_DOC_REF_DESC,
                   TRUNC(a.SLMT_DOC_REF_DATE),
                   a.SLMT_DOC_REMARKS,
                   substr(a.NARRATION,1,30),
                   substr(a.PAYER_NAME,1,40),
                   A.ROWID,
                   TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),
                   a.CASH_COUNTER_CODE,
                   a.SHIFT_ID,
				   a.DOC_TYPE_CODE||LTRIM(TO_CHAR(a.DOC_NUMBER,'00000009')),
				   a.RECPT_REFUND_IND,
				   a.RECPT_NATURE_CODE,
				   a.HCARE_APPL_NUM,
				   a.ADDED_BY_ID,
				   substr(a.RCPT_RFND_ID_NO,1,30),
				   a.RECPT_TYPE_CODE,
				   a.consolidated_receipt_yn,
				   a.ext_acct_facility_id,  
				   a.ext_acct_code,          
				   a.ext_acct_dept_code,
				   a.downtime_doc_type_code,         
				   a.downtime_doc_number,
				   a.bank_branch
			 FROM BL_RECEIPT_REFUND_HDRDTL_VW a
			WHERE a.DOC_TYPE_CODE 	
		  BETWEEN :d_doc_type_code
		      AND NVL(:l_to_doc_type_code,:d_doc_type_code)
			  AND a.DOC_NUMBER    	
	      BETWEEN :d_doc_number 
		      AND NVL(:l_to_doc_type_num, :d_doc_number)
			  AND doc_date
		  BETWEEN NVL(TO_DATE(:l_fr_date,'DD/MM/YYYYHH24:MI:SS'),TO_DATE('01/01/100000:00:00','DD/MM/YYYYHH24:MI:SS'))
		      AND NVL(TO_DATE(:l_to_date,'DD/MM/YYYYHH24:MI:SS'),TO_DATE('01/01/400023:59:59','DD/MM/YYYYHH24:MI:SS'))
              FOR 
		   UPDATE 
		       OF print_flag NOWAIT; */ 
   

    if(sqlca.sqlcode == -54) 
	{
		sprintf(d_err_code,"%5d",sqlca.sqlerrd[2]);
		disp_message(ERR_MESG,d_err_code);
        /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 7;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )2513;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		proc_exit();
	}    

    if (OERROR)
    {
         err_mesg("DECLARE failed on cursor receipt_cursor",0,"");
    }

    d_doc_type_code.arr[d_doc_type_code.len]                             = '\0';
    d_doc_number.arr[d_doc_number.len]                                   = '\0';
	d_doc_srno.arr[d_doc_srno.len]										 = '\0';
    d_doc_date.arr[d_doc_date.len]                                       = '\0';
	d_doc_time.arr[d_doc_time.len]										 = '\0';
    d_episode_type.arr[d_episode_type.len]                               = '\0';
    d_patient_id.arr[d_patient_id.len]                                   = '\0';
    d_episode_id.arr[d_episode_id.len]                                   = '\0';
    d_visit_id.arr[d_visit_id.len]                                       = '\0';
    d_bill_doc_type_code.arr[d_bill_doc_type_code.len]                   = '\0';
    d_bill_doc_number.arr[d_bill_doc_number.len]                         = '\0';
    d_customer_code.arr[d_customer_code.len]                             = '\0';
    d_doc_amt.arr[d_doc_amt.len]                                         = '\0';
    d_slmt_type_code.arr[d_slmt_type_code.len]                           = '\0';
    d_slmt_doc_ref_desc.arr[d_slmt_doc_ref_desc.len]                     = '\0';
    d_slmt_doc_ref_date.arr[d_slmt_doc_ref_date.len]                     = '\0';
    d_slmt_doc_remarks.arr[d_slmt_doc_remarks.len]                       = '\0';
    d_payer_name.arr[d_payer_name.len]                                   = '\0';
    d_narration.arr[d_narration.len]                                     = '\0';
    d_trx_date_time.arr[d_trx_date_time.len]                             = '\0';
    d_cash_counter_code.arr[d_cash_counter_code.len]                     = '\0';
    d_shift_id.arr[d_shift_id.len]                                       = '\0';
    d_doc_type_num.arr[d_doc_type_num.len]                               = '\0';
	d_doc_no.arr[d_doc_no.len]											 = '\0';
	d_receipt_type.arr[d_receipt_type.len]								 = '\0';
    nd_hcare_appl_num.arr[nd_hcare_appl_num.len]			 = '\0';
    nd_recpt_nature_code.arr[nd_recpt_nature_code.len]			 = '\0';    

    d_doc_amt_num = atof(d_doc_amt.arr);
    nd_cashier.arr[nd_cashier.len]					 = '\0';  

   l_consolidated_receipt_yn.arr[l_consolidated_receipt_yn.len]	= '\0';
   l_ext_acct_facility_id.arr[l_ext_acct_facility_id.len]			= '\0';
   l_ext_acct_code.arr[l_ext_acct_code.len]						= '\0';
   l_ext_acct_dept_code.arr[l_ext_acct_dept_code.len]			= '\0';

    nd_print_flag = nd_rec_ref_flag; 

	/* EXEC SQL OPEN receipt_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 8;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select a.DOC_TYPE_CODE ,a.DOC_NUMBER ,A.DOC_SRNO ,to_char(a.DOC_DATE,'dd\
/mm/yyyy') ,to_char(a.DOC_DATE,'HH24:MI:SS') ,a.EPISODE_TYPE ,a.PATIENT_ID ,\
LTRIM(TO_CHAR(a.EPISODE_ID,'00000009')) ,a.VISIT_ID ,a.BILL_DOC_TYPE_CODE ,L\
TRIM(TO_CHAR(a.BILL_DOC_NUMBER,'00000009')) ,a.CUSTOMER_CODE ,TO_CHAR(a.DOC_\
AMT) DOC_AMT ,a.SLMT_TYPE_CODE ,a.SLMT_DOC_REF_DESC ,TRUNC(a.SLMT_DOC_REF_DA\
TE) ,a.SLMT_DOC_REMARKS ,substr(a.NARRATION,1,30) ,substr(a.PAYER_NAME,1,40)\
 ,A.rowid  ,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') ,a.CASH_COUNTER_CODE ,a.SH\
IFT_ID ,(a.DOC_TYPE_CODE||LTRIM(TO_CHAR(a.DOC_NUMBER,'00000009'))) ,a.RECPT_\
REFUND_IND ,a.RECPT_NATURE_CODE ,a.HCARE_APPL_NUM ,a.ADDED_BY_ID ,substr(a.R\
CPT_RFND_ID_NO,1,30) ,a.RECPT_TYPE_CODE ,a.consolidated_receipt_yn ,a.ext_ac\
ct_facility_id ,a.ext_acct_code ,a.ext_acct_dept_code ,a.downtime_doc_type_c\
ode ,a.downtime_doc_number ,a.bank_branch  from BL_RECEIPT_REFUND_HDRDTL_VW \
a where ((a.DOC_TYPE_CODE between :b0 and NVL(:b1,:b0) and a.DOC_NUMBER betw\
een :b3 and NVL(:b4,:b3)) and doc_date b");
 sqlstm.stmt = sq0103;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2528;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&l_to_doc_type_code;
 sqlstm.sqhstl[1] = (unsigned int  )12;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )9;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_doc_number;
 sqlstm.sqhstl[3] = (unsigned int  )11;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_to_doc_type_num;
 sqlstm.sqhstl[4] = (unsigned int  )12;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&d_doc_number;
 sqlstm.sqhstl[5] = (unsigned int  )11;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_fr_date;
 sqlstm.sqhstl[6] = (unsigned int  )32;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_to_date;
 sqlstm.sqhstl[7] = (unsigned int  )32;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
    {
         err_mesg("OPEN failed on cursor receipt_cursor",0,"");
    }
}

fetch_receipt_cursor()
{
    d_doc_date.arr[0]                                                 = '\0';
    d_episode_type.arr[0]                                             = '\0';
    d_patient_id.arr[0]                                               = '\0';
    d_episode_id.arr[0]                                               = '\0';
    d_visit_id.arr[0]                                                 = '\0';
    d_bill_doc_type_code.arr[0]                                       = '\0';
    d_bill_doc_number.arr[0]                                          = '\0';
    d_customer_code.arr[0]                                            = '\0';
    d_doc_amt.arr[0]                                                  = '\0';
    d_slmt_type_code.arr[0]                                           = '\0';
    d_slmt_doc_ref_desc.arr[0]                                        = '\0';
    d_slmt_doc_ref_date.arr[0]                                        = '\0';
    d_slmt_doc_remarks.arr[0]                                         = '\0';
    d_narration.arr[0]                                                = '\0';
    d_payer_name.arr[0]                                               = '\0';
    d_rowid.arr[0]                                                    = '\0';
    d_trx_date_time.arr[0]                                            = '\0';
    d_cash_counter_code.arr[0]                                        = '\0';
    d_shift_id.arr[0]                                                 = '\0';
    d_doc_type_num.arr[0]                                             = '\0';
    nd_hcare_appl_num.arr[0]  										  = '\0';
	d_doc_time.arr[0]												  = '\0';
	d_doc_no.arr[0]													  = '\0';
    nd_recpt_nature_code.arr[0]										  = '\0';
	d_receipt_type.arr[0]											  = '\0';
    
    d_doc_date.len                                                    = 0;
    d_episode_type.len                                                = 0;
    d_patient_id.len                                                  = 0;
    d_episode_id.len                                                  = 0;
    d_visit_id.len                                                    = 0;
    d_bill_doc_type_code.len                                          = 0;
    d_bill_doc_number.len                                             = 0;
    d_customer_code.len                                               = 0;
    d_doc_amt.len                                                     = 0;
    d_slmt_type_code.len                                              = 0;
    d_slmt_doc_ref_desc.len                                           = 0;
    d_slmt_doc_ref_date.len                                           = 0;
    d_slmt_doc_remarks.len                                            = 0;
    d_narration.len                                                   = 0;
    d_payer_name.len                                                  = 0;
    d_rowid.len                                                       = 0;
    d_trx_date_time.len                                               = 0;
    d_cash_counter_code.len                                           = 0;
    d_shift_id.len                                                    = 0;
    d_doc_type_num.len                                                = 0;
	d_doc_time.len													  = 0;
	d_doc_no.len													  = 0;
    nd_hcare_appl_num.len											  = 0;
    nd_recpt_nature_code.len										  = 0;
	d_receipt_type.len												  = 0;
    d_doc_amt_num                                                     = 0;

    nd_cashier.arr[0]												  = '\0';
    nd_cashier.len													  = 0;
	l_consolidated_receipt_yn.arr[0]								  = '\0';
	l_ext_acct_facility_id.arr[0]									  = '\0';
	l_ext_acct_code.arr[0]											  = '\0';
	l_ext_acct_dept_code.arr[0]										  = '\0';

	d_mdoc_type_code.arr[0] = '\0';
	d_mdoc_type_code.len = 0;

	d_mdoc_number.arr[0] = '\0';
	d_mdoc_number.len = 0;

	d_branch_name.arr[0] = '\0';
	d_branch_name.len = 0;
    
   /* EXEC SQL FETCH receipt_cursor 
             INTO :d_doc_type_code,
                  :d_doc_number,
				  :d_doc_srno,
                  :d_doc_date,
				  :d_doc_time,
                  :d_episode_type,
                  :d_patient_id,
                  :d_episode_id,
                  :d_visit_id,
                  :d_bill_doc_type_code,
                  :d_bill_doc_number,
                  :d_customer_code,
                  :d_doc_amt,
                  :d_slmt_type_code,
                  :d_slmt_doc_ref_desc,
                  :d_slmt_doc_ref_date,
                  :d_slmt_doc_remarks,
                  :d_narration,
                  :d_payer_name,
                  :d_rowid,
                  :d_trx_date_time,
                  :d_cash_counter_code,
                  :d_shift_id,
		  :d_doc_type_num,
		  :nd_rec_ref_flag,
		  :nd_recpt_nature_code,
		  :nd_hcare_appl_num,
		  :nd_cashier,
		  :d_doc_no,
		  :d_receipt_type,
		  :l_consolidated_receipt_yn,
		  :l_ext_acct_facility_id,  
		  :l_ext_acct_code,          
		  :l_ext_acct_dept_code,
		  :d_mdoc_type_code,
		  :d_mdoc_number,
		  :d_branch_name; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 37;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2575;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
   sqlstm.sqhstl[0] = (unsigned int  )9;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_doc_number;
   sqlstm.sqhstl[1] = (unsigned int  )11;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_doc_srno;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_doc_date;
   sqlstm.sqhstl[3] = (unsigned int  )15;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_doc_time;
   sqlstm.sqhstl[4] = (unsigned int  )12;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_episode_type;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[6] = (unsigned int  )23;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_episode_id;
   sqlstm.sqhstl[7] = (unsigned int  )11;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&d_visit_id;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&d_bill_doc_type_code;
   sqlstm.sqhstl[9] = (unsigned int  )9;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&d_bill_doc_number;
   sqlstm.sqhstl[10] = (unsigned int  )11;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&d_customer_code;
   sqlstm.sqhstl[11] = (unsigned int  )11;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&d_doc_amt;
   sqlstm.sqhstl[12] = (unsigned int  )25;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&d_slmt_type_code;
   sqlstm.sqhstl[13] = (unsigned int  )5;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&d_slmt_doc_ref_desc;
   sqlstm.sqhstl[14] = (unsigned int  )23;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&d_slmt_doc_ref_date;
   sqlstm.sqhstl[15] = (unsigned int  )15;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&d_slmt_doc_remarks;
   sqlstm.sqhstl[16] = (unsigned int  )33;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&d_narration;
   sqlstm.sqhstl[17] = (unsigned int  )53;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&d_payer_name;
   sqlstm.sqhstl[18] = (unsigned int  )43;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&d_rowid;
   sqlstm.sqhstl[19] = (unsigned int  )22;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&d_trx_date_time;
   sqlstm.sqhstl[20] = (unsigned int  )19;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&d_cash_counter_code;
   sqlstm.sqhstl[21] = (unsigned int  )5;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&d_shift_id;
   sqlstm.sqhstl[22] = (unsigned int  )4;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&d_doc_type_num;
   sqlstm.sqhstl[23] = (unsigned int  )27;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&nd_rec_ref_flag;
   sqlstm.sqhstl[24] = (unsigned int  )1;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&nd_recpt_nature_code;
   sqlstm.sqhstl[25] = (unsigned int  )5;
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&nd_hcare_appl_num;
   sqlstm.sqhstl[26] = (unsigned int  )23;
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&nd_cashier;
   sqlstm.sqhstl[27] = (unsigned int  )33;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&d_doc_no;
   sqlstm.sqhstl[28] = (unsigned int  )33;
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&d_receipt_type;
   sqlstm.sqhstl[29] = (unsigned int  )6;
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&l_consolidated_receipt_yn;
   sqlstm.sqhstl[30] = (unsigned int  )6;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&l_ext_acct_facility_id;
   sqlstm.sqhstl[31] = (unsigned int  )17;
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&l_ext_acct_code;
   sqlstm.sqhstl[32] = (unsigned int  )17;
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&l_ext_acct_dept_code;
   sqlstm.sqhstl[33] = (unsigned int  )10;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&d_mdoc_type_code;
   sqlstm.sqhstl[34] = (unsigned int  )9;
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&d_mdoc_number;
   sqlstm.sqhstl[35] = (unsigned int  )11;
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&d_branch_name;
   sqlstm.sqhstl[36] = (unsigned int  )63;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
    if (sqlca.sqlcode == 1403 )	
		return 0;

	if(sqlca.sqlcode == -54) 
	{
		sprintf(d_err_code,"%5d",sqlca.sqlerrd[2]);
		disp_message(ERR_MESG,d_err_code);
        /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
        struct sqlexd sqlstm;
        sqlstm.sqlvsn = 10;
        sqlstm.arrsiz = 37;
        sqlstm.sqladtp = &sqladt;
        sqlstm.sqltdsp = &sqltds;
        sqlstm.iters = (unsigned int  )1;
        sqlstm.offset = (unsigned int  )2738;
        sqlstm.cud = sqlcud0;
        sqlstm.sqlest = (unsigned char  *)&sqlca;
        sqlstm.sqlety = (unsigned short)256;
        sqlstm.occurs = (unsigned int  )0;
        sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		proc_exit();
	}    

    if (OERROR)
    {
         err_mesg("FETCH failed on cursor receipt_cursor",0,"");
    }

    d_doc_type_code.arr[d_doc_type_code.len]                             = '\0';
    d_doc_number.arr[d_doc_number.len]                                   = '\0';
	d_doc_srno.arr[d_doc_srno.len]										 = '\0';
    d_doc_date.arr[d_doc_date.len]                                       = '\0';
	d_doc_time.arr[d_doc_time.len]										 = '\0';
    d_episode_type.arr[d_episode_type.len]                               = '\0';
    d_patient_id.arr[d_patient_id.len]                                   = '\0';
    d_episode_id.arr[d_episode_id.len]                                   = '\0';
    d_visit_id.arr[d_visit_id.len]                                       = '\0';
    d_bill_doc_type_code.arr[d_bill_doc_type_code.len]                   = '\0';
    d_bill_doc_number.arr[d_bill_doc_number.len]                         = '\0';
    d_customer_code.arr[d_customer_code.len]                             = '\0';
    d_doc_amt.arr[d_doc_amt.len]                                         = '\0';
    d_slmt_type_code.arr[d_slmt_type_code.len]                           = '\0';
    d_slmt_doc_ref_desc.arr[d_slmt_doc_ref_desc.len]                     = '\0';
    d_slmt_doc_ref_date.arr[d_slmt_doc_ref_date.len]                     = '\0';
    d_slmt_doc_remarks.arr[d_slmt_doc_remarks.len]                       = '\0';
    d_payer_name.arr[d_payer_name.len]                                   = '\0';
    d_narration.arr[d_narration.len]                                     = '\0';
    d_trx_date_time.arr[d_trx_date_time.len]                             = '\0';
    d_cash_counter_code.arr[d_cash_counter_code.len]                     = '\0';
    d_shift_id.arr[d_shift_id.len]                                       = '\0';
    d_doc_type_num.arr[d_doc_type_num.len]                               = '\0';
	d_doc_no.arr[d_doc_no.len]											 = '\0';
	d_receipt_type.arr[d_receipt_type.len]								 = '\0';
    nd_hcare_appl_num.arr[nd_hcare_appl_num.len]						 = '\0';
    nd_recpt_nature_code.arr[nd_recpt_nature_code.len]					 = '\0';    

    d_mdoc_type_code.arr[d_mdoc_type_code.len] = '\0';
    d_mdoc_number.arr[d_mdoc_number.len] = '\0';

    d_doc_amt_num = atof(d_doc_amt.arr);
    nd_cashier.arr[nd_cashier.len]	= '\0';  

    d_branch_name.arr[d_branch_name.len] = '\0';


	l_consolidated_receipt_yn.arr[l_consolidated_receipt_yn.len]	= '\0';
	l_ext_acct_facility_id.arr[l_ext_acct_facility_id.len]		= '\0';
	l_ext_acct_code.arr[l_ext_acct_code.len]						= '\0';
	l_ext_acct_dept_code.arr[l_ext_acct_dept_code.len]			= '\0';

    nd_print_flag = nd_rec_ref_flag; 

	return 1;
}

close_receipt_cursor()
{
	/* EXEC SQL CLOSE receipt_cursor; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 37;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2753;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

get_left_margin()
{

	if (l_lsr != 0 && l_dmp == 0)
	  {
		if (l_logo_yniflaser.arr[0] == 'Y')			    
			l_margin_len = 40;				
		else
			l_margin_len = 55;

	  }
}


get_logo_dtl()
{
	  l_logo_yniflaser.arr[0] = 'N';

	  l_errorlevel.arr[0] = '\0';
	  l_errorlevel.len = 0;

	  l_sysmessageid.arr[0] = '\0';
	  l_sysmessageid.len = 0;

	  l_errortext.arr[0] = '\0';
	  l_errortext.len = 0;	  

	  if (l_lsr != 0 && l_dmp == 0)
	  {	  
		/* EXEC SQL EXECUTE	
		BEGIN					
			BLOPIN.GET_PRINT_SETUP_COL_VALUE(
				:nd_facility_id,
				'BLRRECPT',
				'PRINT_LOGO_YN_IF_LASER',
				:l_logo_yniflaser,
				:l_errorlevel,
				:l_sysmessageid,
				:l_errortext) ;
				
			:l_logo_yniflaser := nvl(:l_logo_yniflaser,'N');

			if :l_sysmessageid is not null then
				:l_errorlevel := '10';
				:l_errortext := blcommon.get_error_text(:l_sysmessageid);
			end if;

		END;
		END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 37;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin BLOPIN . GET_PRINT_SETUP_COL_VALUE ( :nd_facility_id \
, 'BLRRECPT' , 'PRINT_LOGO_YN_IF_LASER' , :l_logo_yniflaser , :l_errorlevel , \
:l_sysmessageid , :l_errortext ) ; :l_logo_yniflaser := nvl ( :l_logo_yniflase\
r , 'N' ) ; if :l_sysmessageid is not null then :l_errorlevel := '10' ; :l_err\
ortext := blcommon . get_error_text ( :l_sysmessageid ) ; end if ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2768;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&l_logo_yniflaser;
  sqlstm.sqhstl[1] = (unsigned int  )1002;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&l_errorlevel;
  sqlstm.sqhstl[2] = (unsigned int  )12;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&l_sysmessageid;
  sqlstm.sqhstl[3] = (unsigned int  )12;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&l_errortext;
  sqlstm.sqhstl[4] = (unsigned int  )1002;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		

		if (strcmp(l_errorlevel.arr,"10") == 0 && l_errortext.arr[0] != '\0')
		{
			disp_message(ERR_MESG,l_errortext.arr);
			proc_exit(0);
		}

		l_errorlevel.arr[0] = '\0';
		l_errorlevel.len = 0;

		l_sysmessageid.arr[0] = '\0';
		l_sysmessageid.len = 0;

		l_errortext.arr[0] = '\0';
		l_errortext.len = 0;

		if (l_logo_yniflaser.arr[0] == 'Y')
		{
			/* EXEC SQL EXECUTE	
			BEGIN				
				BLOPIN.GET_PRINT_SETUP_COL_VALUE(
					:nd_facility_id,
					'BLRRECLO',
					'LOGO_NAME',
					:l_logo_name,
					:l_errorlevel,
					:l_sysmessageid,
					:l_errortext);			

				if :l_sysmessageid is not null then
					:l_errorlevel := '10';
					:l_errortext := blcommon.get_error_text(:l_sysmessageid);
				end if;
			END;
			END-EXEC; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 37;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "begin BLOPIN . GET_PRINT_SETUP_COL_VALUE ( :nd_facility_id\
 , 'BLRRECLO' , 'LOGO_NAME' , :l_logo_name , :l_errorlevel , :l_sysmessageid ,\
 :l_errortext ) ; if :l_sysmessageid is not null then :l_errorlevel := '10' ; \
:l_errortext := blcommon . get_error_text ( :l_sysmessageid ) ; end if ; END ;";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2803;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&l_logo_name;
   sqlstm.sqhstl[1] = (unsigned int  )1002;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&l_errorlevel;
   sqlstm.sqhstl[2] = (unsigned int  )12;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&l_sysmessageid;
   sqlstm.sqhstl[3] = (unsigned int  )12;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&l_errortext;
   sqlstm.sqhstl[4] = (unsigned int  )1002;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (strcmp(l_errorlevel.arr,"10") == 0 && l_errortext.arr[0] != '\0')
			{
				disp_message(ERR_MESG,l_errortext.arr);
				proc_exit(0);		
			}		

			LOGO_DIR.arr[0] = '\0';
			LOGO_DIR.len = 0;

			l_errorlevel.arr[0] = '\0';
 		        l_errorlevel.len = 0;

		        l_sysmessageid.arr[0] = '\0';
		        l_sysmessageid.len = 0;

		        l_errortext.arr[0] = '\0';
		        l_errortext.len = 0;	
			
			if (l_online_print_yn.arr[0] == 'N')
			{			
				/* EXEC SQL EXECUTE	
				BEGIN				
					WORKSTATION.GET_WS_PARAM(
						:nd_ws_no,				
						'BLLOGODIR',
						:LOGO_DIR,
						:l_errortext);			
					if :l_errortext is not null then 
						:l_errortext	:= 'BLLOGODIR:'||:l_errortext;
					end if;

				END;
				END-EXEC; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 37;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "begin WORKSTATION . GET_WS_PARAM ( :nd_ws_no , 'BLLOGODIR\
' , :LOGO_DIR , :l_errortext ) ; if :l_errortext is not null then :l_errortext\
 := 'BLLOGODIR:' || :l_errortext ; end if ; END ;";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2838;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_ws_no;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&LOGO_DIR;
    sqlstm.sqhstl[1] = (unsigned int  )1002;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&l_errortext;
    sqlstm.sqhstl[2] = (unsigned int  )1002;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			
				if (l_errortext.arr[0] != '\0')
				{
					disp_message(ERR_MESG,l_errortext.arr);
					proc_exit(0);
				}		
			}
		}

		
	    }
}

get_printer_type()
{
	/* EXEC SQL EXECUTE
	DECLARE
		l_sys_mesg_id VARCHAR2(10);
		l_err_level VARCHAR2(10);
		l_err_text VARCHAR2(1000);
		l_document_value blcommon.rectype_Tab;
		l_format_type VARCHAR2(200);
		l_report_tool_ind VARCHAR2(1);
	BEGIN
		blcommon.get_doc_print_format_Tab(
     			:nd_facility_id,
			:nd_reportid,
			l_document_value,
			l_sys_mesg_id,
			l_err_level,
			l_err_text);	
			
		FOR i IN l_document_value.FIRST..l_document_value.LAST LOOP
			if  l_document_value(i).id = 'FORMAT_TYPE' then
				l_format_type := l_document_value(i).value;
			end if;				
			
			if l_document_value(i).id = 'REPORT_TOOL_IND' then 
				l_report_tool_ind := l_document_value(i).value;
			end if;		 	
		END LOOP;		

		if l_format_type = 'DMP_PREPRINTED' then
			:l_dmp := 1;
			:l_lsr := 0;
		elsif l_format_type in('LASER_WITH_LOGO','LASER_WITHOUT_LOGO') then
			:l_dmp := 0;
			:l_lsr := 1;
		else
			:l_dmp := 0;
			:l_lsr := 0;
		end if;

		if :l_dmp = 0 and :l_lsr = 0 then

			APPPRINT.GET_ROUTING_PRINTERS(
			 :nd_ws_no,
			 :nd_facility_id,
			 'BL',
			 :nd_reportid,
			 'O',
			 ' ',
			 :l_printer_ids,
			 :l_printer_names,
			 :l_printer_types ,
			 :l_queue_names,
			 :l_no_of_copies,
			 :l_errortext);

			 :l_dmp := NVL(instr(:l_printer_types,'D'),0);
			 :l_lsr := NVL(instr(:l_printer_types,'S'),0);			 

			 if :l_dmp != 0 and :l_lsr != 0 then 
			    :l_dmp := 0;
			    --if there is a laser, then output format will be laser
			 end if;

			 if :l_dmp = 0 and :l_lsr = 0 then 
			    :l_lsr := 1;
			    --Default is Laser Format
			 end if;	
		end if;
   END;
   END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 37;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "declare l_sys_mesg_id VARCHAR2 ( 10 ) ; l_err_level VARCHAR2 ( 10 ) ; l_\
err_text VARCHAR2 ( 1000 ) ; l_document_value blcommon . rectype_Tab ; l_for\
mat_type VARCHAR2 ( 200 ) ; l_report_tool_ind VARCHAR2 ( 1 ) ; BEGIN blcommo\
n . get_doc_print_format_Tab ( :nd_facility_id , :nd_reportid , l_document_v\
alue , l_sys_mesg_id , l_err_level , l_err_text ) ; FOR i IN l_document_valu\
e . FIRST .. l_document_value . LAST LOOP if l_document_value ( i ) . id = '\
FORMAT_TYPE' then l_format_type := l_document_value ( i ) . value ; end if ;\
 if l_document_value ( i ) . id = 'REPORT_TOOL_IND' then l_report_tool_ind :\
= l_document_value ( i ) . value ; end if ; END LOOP ; if l_format_type = 'D\
MP_PREPRINTED' then :l_dmp := 1 ; :l_lsr := 0 ; elsif l_format_type in ( 'LA\
SER_WITH_LOGO' , 'LASER_WITHOUT_LOGO' ) then :l_dmp := 0 ; :l_lsr := 1 ; els\
e :l_dmp := 0 ; :l_lsr := 0 ; end if ; if :l_dmp = 0 and :l_lsr = 0 then APP\
PRINT . GET_ROUTING_PRINTERS ( :nd_ws_no , :nd_facility_id , 'BL' , :nd_repo\
rtid , 'O' , ' ' , :l_printer_ids , :l_p");
 sqlstm.stmt = "rinter_names , :l_printer_types , :l_queue_names , :l_no_of_\
copies , :l_errortext ) ; :l_dmp := NVL ( instr ( :l_printer_types , 'D' ) , 0\
 ) ; :l_lsr := NVL ( instr ( :l_printer_types , 'S' ) , 0 ) ; if :l_dmp != 0 a\
nd :l_lsr != 0 then :l_dmp := 0 ; end if ; if :l_dmp = 0 and :l_lsr = 0 then :\
l_lsr := 1 ; end if ; end if ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2865;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_reportid;
 sqlstm.sqhstl[1] = (unsigned int  )22;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_dmp;
 sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_lsr;
 sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[4] = (unsigned int  )32;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&l_printer_ids;
 sqlstm.sqhstl[5] = (unsigned int  )1002;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&l_printer_names;
 sqlstm.sqhstl[6] = (unsigned int  )1002;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&l_printer_types;
 sqlstm.sqhstl[7] = (unsigned int  )1002;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&l_queue_names;
 sqlstm.sqhstl[8] = (unsigned int  )1002;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&l_no_of_copies;
 sqlstm.sqhstl[9] = (unsigned int  )1002;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&l_errortext;
 sqlstm.sqhstl[10] = (unsigned int  )1002;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



   if ( l_errortext.arr[0] != '\0')
		{
			l_errortext.arr[0] = '\0';
			l_errortext.len = 0;
		}

}

get_param_for_three_tier()
{
	d_doc_type_code.arr[0]    = '\0';
	l_to_doc_type_code.arr[0] = '\0';
	d_doc_number.arr[0]       = '\0'; 
	l_to_doc_type_num.arr[0]  = '\0';
	l_online_print_yn.arr[0] = '\0';
	nd_ws_no.arr[0] = '\0';
	nd_logo_pgm_id.arr[0]	= '\0';
	nd_ws_no.len = 0;

	nd_logo_pgm_id.len	= 0;

	/* EXEC SQL SELECT param1, 
					param2, 
					param3, 
					param4, 
					NVL(param30,'N'),
					param29,
					param28
			   INTO	:d_doc_type_code,
					:d_doc_number ,
					:l_to_doc_type_code,
					:l_to_doc_type_num,
					:l_online_print_yn,
					:nd_ws_no,
					:nd_logo_pgm_id
			   FROM sy_prog_param
			  WHERE pgm_id     = 'BLRRECPT'
	            AND PGM_DATE   = :nd_pgm_date
	            AND SESSION_ID = :nd_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 37;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select param1 ,param2 ,param3 ,param4 ,NVL(param30,'N') ,par\
am29 ,param28 into :b0,:b1,:b2,:b3,:b4,:b5,:b6  from sy_prog_param where ((pgm\
_id='BLRRECPT' and PGM_DATE=:b7) and SESSION_ID=:b8)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2924;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_doc_type_code;
 sqlstm.sqhstl[0] = (unsigned int  )9;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_doc_number;
 sqlstm.sqhstl[1] = (unsigned int  )11;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&l_to_doc_type_code;
 sqlstm.sqhstl[2] = (unsigned int  )12;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&l_to_doc_type_num;
 sqlstm.sqhstl[3] = (unsigned int  )12;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&l_online_print_yn;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_ws_no;
 sqlstm.sqhstl[5] = (unsigned int  )32;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_logo_pgm_id;
 sqlstm.sqhstl[6] = (unsigned int  )1002;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[7] = (unsigned int  )37;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[8] = (unsigned int  )18;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (sqlca.sqlcode == 1403)
	{
		l_tier_arch=2;
		strcpy(l_online_print_yn.arr,"Y");
		l_online_print_yn.len = strlen(l_online_print_yn.arr);
	}

	if(OERROR)
		err_mesg("SELECT failed on SY_PROG_PARAM",0,"");

	d_doc_type_code.arr[d_doc_type_code.len]    = '\0';
	l_to_doc_type_code.arr[l_to_doc_type_code.len] = '\0';
	d_doc_number.arr[d_doc_number.len]       = '\0'; 
	l_to_doc_type_num.arr[l_to_doc_type_num.len]  = '\0';
	l_online_print_yn.arr[l_online_print_yn.len] = '\0';
	nd_ws_no.arr[nd_ws_no.len] = '\0';
	nd_logo_pgm_id.arr[nd_logo_pgm_id.len]		= '\0';

	if (l_tier_arch!=2)
		l_tier_arch=3; 

	//sprintf(l_mesg,"1 - %s     2 - %s     3 - %s     4 - %s      30 - %s",d_doc_type_code.arr,d_doc_number.arr,l_to_doc_type_code.arr,l_to_doc_type_num.arr,l_online_print_yn.arr);
	//disp_message(ERR_MESG,l_mesg);

	/* EXEC SQL DELETE 
	           FROM sy_prog_param
			  WHERE pgm_id     = 'BLRRECPT'
	            AND PGM_DATE   = :nd_pgm_date
	            AND SESSION_ID = :nd_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 37;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "delete  from sy_prog_param  where ((pgm_id='BLRRECPT' and PG\
M_DATE=:b0) and SESSION_ID=:b1)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2975;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_pgm_date;
 sqlstm.sqhstl[0] = (unsigned int  )37;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_session_id;
 sqlstm.sqhstl[1] = (unsigned int  )18;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}



