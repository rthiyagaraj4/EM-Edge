#define RESOURCE_BUSY (sqlca.sqlcode == -54)
#define EQ ==
#define TRUE  1
#define FALSE 0
/*
int  end_pgm_control = 0;
*/
char g_pgm_id[10];
char g_session_id[16];
char g_pgm_date[14];

extern long atol();
extern double atof();
