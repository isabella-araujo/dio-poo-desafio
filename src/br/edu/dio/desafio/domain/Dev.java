package br.edu.dio.desafio.domain;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new HashSet<>();
    private Set<Conteudo> conteudosConcluidos = new HashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    public void exibirConteudosInscritos() {
        System.out.println("+-----------------+Conteúdos Inscritos+-----------------+");
        for(Conteudo c : conteudosInscritos) {
            System.out.println(c);
        }
        System.out.println("+-------------------------------------------------------+");
    }

    public void exibirConteudosConcluidos() {
        System.out.println("+-----------------+Conteúdos Concluidos+-----------------+");
        for(Conteudo c : conteudosConcluidos) {
            System.out.println(c);
        }
        System.out.println("+--------------------------------------------------------+");
    }

    public void inscreverBootCamp(BootCamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.out.println("Erro: você não está matriculado em nenhum conteúdo.");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(conteudo -> conteudo.calcularXP())
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }
}
