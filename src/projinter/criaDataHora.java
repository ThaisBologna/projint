package projinter;

public class CriaDataHora {

    public CriaDataHora() {
    }

    public String[] dia() {
        String[] dia = new String[31];
        for (int i = 1; i < 32; i++) {
            dia[i - 1] = "" + i;
        }
        return dia;
    }

    public String[] mes() {
        String[] mes = new String[12];
        for (int i = 1; i < 13; i++) {
            mes[i - 1] = "" + i;
        }
        return mes;
    }

    public String[] ano() {
        String[] ano = new String[70];
        int soma = 0;
        for (int i = 1; i < 71; i++) {
            soma = i + 1946;
            ano[i - 1] = "" + soma;
        }
        return ano;
    }

    public String[] anoEvento() {
        String[] ano = new String[5];
        int soma = 0;
        for (int i = 1; i < 6; i++) {
            soma = i + 2015;
            ano[i - 1] = "" + soma;
        }
        return ano;
    }

    public String[] horas() {
        String[] horas = new String[24];
        for (int i = 0; i < 24; i++) {
            horas[i] = "" + i;
        }
        return horas;
    }

    public String[] minutos() {
        String[] minutos = new String[4];
        for (int i = 0; i < 4; i++) {
            minutos[i] = "" + i * 15;
        }
        return minutos;
    }
}
