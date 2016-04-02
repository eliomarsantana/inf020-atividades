#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
#include "dll.h"

typedef int (WINAPI * cfuncSoma)(int v1, int v2);
cfuncSoma FuncaoSoma;
//cfuncSubtracao FuncaoSubtracao;
//cfuncMultiplicacao FuncaoMultiplicacao;
//cfuncDivisao FuncaoDivisao;


int main(int argc,char **argv)
{
    int a,b,c;
    srand(time(NULL));
    a = (rand() % 100) + 1;
    b = (rand() % 100) + 1;

    HINSTANCE hLib=LoadLibrary("minhadll.dll");
    if (!hLib) { printf("error"); return 0; }
    FuncaoSoma=(cfuncSoma)GetProcAddress((HMODULE)hLib, "soma");
    //FuncaoSubtracao=(cfuncSubtracao)GetProcAddress((HMODULE)hLib, "subtracao");
    //FuncaoMultiplicacao=(cfuncMultiplicacao)GetProcAddress((HMODULE)hLib, "multiplicacao");
    //FuncaoDivisao=(cfuncDivisao)GetProcAddress((HMODULE)hLib, "divisao");

    soma = FuncaoSoma(a, b);
    //divisao = FuncaoSubtracao(a, b);
    //multiplicacao = FuncaoMultiplicacao(a, b);
    //divisao = FuncaoDivisao(a, b);

    FreeLibrary((HMODULE)hLib);

    printf("\nA soma de %d + %d = %d\n",a,b,soma);
    //printf("\nA subtracao de %d + %d = %d\n",a,b,subtracao);
    //printf("\nA multiplicacao de %d + %d = %d\n",a,b,multiplicacao);
    //printf("\nA divisao de %d + %d = %d\n",a,b,divisao);
    system("pause");
}
