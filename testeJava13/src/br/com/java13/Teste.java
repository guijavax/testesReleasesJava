package br.com.java13;

public class Teste {

    public enum Semana {

        SEGUNDA_FEIRA("Segunda"),
        TERCA_FEIRA("Terça"),
        QUARTA_FEIRA("Quarta"),
        QUINTA_FEIRA("Quinta"),
        SEXTA_FEIRA("Sexta"),
        SABADO("Sábado"),
        DOMINGO("Domingo");
        
        private String dia;

        Semana(String dia) {
            this.dia = dia;
        }
        public String getValue() {
            return dia;
        }
    }

    public static void main(String[] args) {
        System.out.println("Teste 1" + testeSwitchNormal(Semana.DOMINGO.getValue()));
        System.out.println("Teste 2" + testeSwitchNovo(Semana.QUINTA_FEIRA.getValue()));

        String testeString = "UPDATE calculo_leituras_ucb\n" +
                "SET calculo_leituras_ucb.idnaoleitura = 0\n" +
                "where exists (\n" +
                "    select calculo_dados.iduc \n" +
                "    from calculo_dados\n" +
                "    where calculo_dados.idrota in (35,45,48,53,60,68,70,79)\n" +
                "    and calculo_leituras_ucb.iduc = calculo_dados.iduc\n" +
                ")\n" +
                "and calculo_leituras_ucb.ano_mes = ('01/07/2014')\n" +
                "and calculo_leituras_ucb.idnaoleitura = 24 ;";

        System.out.println(testeString);

        String testeString2 = """
                                 UPDATE calculo_leituras_ucb
                                 SET calculo_leituras_ucb.idnaoleitura = 0
                                 where exists (
                                     select calculo_dados.ida
                                     from calculo_dados
                                     where calculo_dados.idrota in (35,45,48,53,60,68,70,79)
                                     and calculo_leituras_ucb.iduc = calculo_dados.iduc
                                 )
                                 and calculo_leituras_ucb.ano_mes = ('01/07/2014')
                                 and calculo_leituras_ucb.idnaoleitura = 24 """;
        System.out.println(testeString2);
    }

    private static String testeSwitchNormal(String dia)  {
        switch (dia) {
            case "Segunda":
            case "Terça":
            case "Quarta":
            case "Quinta":
            case "Sexta":
            return  "Meio de semana";
            case "Sábado":
            case "Domingo":
                return "Fim de semana";
            default: return "Dia inválido";
        }
    }

    public static String testeSwitchNovo(String dia) {
        return switch (dia) {
            case "Segunda","Terça","Quarta","Quinta","Sexta" ->  "Meio de semana";
            case "Sábadp", "Domingo" -> "Fim de Semana";
            default -> "Dia Inválido";
        };


    }
}
