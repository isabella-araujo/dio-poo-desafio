import br.edu.dio.desafio.domain.BootCamp;
import br.edu.dio.desafio.domain.Curso;
import br.edu.dio.desafio.domain.Dev;
import br.edu.dio.desafio.domain.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso01 = new Curso("Curso 01", "Descrição do Curso 01", 10);
        Curso curso02 = new Curso("Curso 02", "Descrição do Curso 02", 25);
        System.out.println(curso01);

        Mentoria men01 = new Mentoria("Mentoria 01", "Descrição da Mentoria 01", LocalDate.now());
        Mentoria men02 = new Mentoria("Mentoria 02", "Descrição da Mentoria 02", LocalDate.of(2024, 8,4));
        System.out.println(men02);

        BootCamp bootcamp = new BootCamp("Bootcamp", "Descrição do Bootcamp");
        bootcamp.adicionarConteudo(curso01);
        bootcamp.adicionarConteudo(curso02);
        bootcamp.adicionarConteudo(men01);

        Dev dev01 = new Dev("Dev 01");
        dev01.inscreverBootCamp(bootcamp);
        dev01.exibirConteudosInscritos();
        dev01.progredir();
        dev01.exibirConteudosConcluidos();
    }
}