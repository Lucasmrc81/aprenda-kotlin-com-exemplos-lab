// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    var conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (usuario !in inscritos) {
            inscritos.add(usuario)
            println("${usuario.nome} foi matriculado na formação $nome")
        } else {
            println("${usuario.nome} já está matriculado na formação $nome")
        }
    }
}

fun main() {
    // Criando conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 120)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 180)
    
    // Criando formações
    val formacaoKotlin = Formacao(
        nome = "Formação em Kotlin",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(conteudo1, conteudo2)
    )
    
    // Criando usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    
    // Matriculando usuários
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario1)  // Tentando matricular o mesmo usuário novamente
    
    // Exibindo informações sobre a formação
    println("Formação: ${formacaoKotlin.nome}")
    println("Nível: ${formacaoKotlin.nivel}")
    println("Conteúdos: ${formacaoKotlin.conteudos.joinToString { it.nome }}")
    println("Inscritos: ${formacaoKotlin.inscritos.joinToString { it.nome }}")
}