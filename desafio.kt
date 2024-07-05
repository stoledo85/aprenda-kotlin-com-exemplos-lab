// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(var nome:String,var idade:Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60,var desc:String)

data class Formacao(val nome: String, val nivel:Nivel ,var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        print("Aluno ${usuario.nome} está matriculado na formação $nome.")
    }
    fun criarConteudo(conteudoedu :ConteudoEducacional){
        conteudos.add(conteudoedu)
        print("Conteúdo criado.")
    }
    fun removerConteudo(conteudoedu :ConteudoEducacional){
        conteudos.remove(conteudoedu)
         println("Conteúdo '${conteudoedu.nome}' removido ")
    }
    fun exibir() {
        println("Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos:")
        for (conteudo in conteudos) {
            println(" - ${conteudo.nome} (${conteudo.duracao} minutos) - ${conteudo.desc})")
        }
        println("Inscritos:")
        for (inscrito in inscritos) {
            println(" - ${inscrito.nome})")
        }
    }
}

fun main() {
    val usuario1 = Usuario(nome="Carlos", idade=25)
    val usuario2 = Usuario(nome="Lucas", idade=18)
    val usuario3 = Usuario(nome="José", idade=36)

    val cont1 = ConteudoEducacional(nome="Programação OO em Kotlin", desc="Conteudo de Introdutorio a POO com Kotlin",duracao=60)
    val cont2 = ConteudoEducacional(nome="Programação OO em Kotlin", desc="Logica de programação com Kotlin",duracao=36)
    
    val formacaoKotlin = Formacao(nome="Formação Kotlin", nivel=Nivel.BASICO)
    formacaoKotlin.criarConteudo(cont1)
    formacaoKotlin.criarConteudo(cont2)
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)

    formacaoKotlin.exibir()
}
