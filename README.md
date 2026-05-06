# Algoritmo CRC32C

Implementacao simples do algoritmo CRC32C em Java.

O objetivo do projeto e mostrar, de forma didatica, como calcular e validar um checksum usando uma classe propria chamada `Crc32c`.

## Arquivos do projeto

- [`src/Crc32c.java`](src/Crc32c.java): classe que implementa o calculo do CRC32C.
- [`src/Main.java`](src/Main.java): classe principal com exemplos simples de uso e validacao.

## Como executar

Compile os arquivos Java:

```bash
javac src/*.java
```

Execute o programa:

```bash
java -cp src Main
```

## Exemplo de saida

```text
Texto: ""
CRC32C calculado: 0x00000000
CRC32C esperado:  0x00000000
Resultado: valido

Texto: "123456789"
CRC32C calculado: 0xE3069283
CRC32C esperado:  0xE3069283
Resultado: valido

Texto: "Ola mundo"
CRC32C calculado: 0xF741C7D0
CRC32C esperado:  0xF741C7D0
Resultado: valido
```

## Como usar a classe `Crc32c`

Exemplo basico:

```java
import java.nio.charset.StandardCharsets;

public class Exemplo {
    public static void main(String[] args) {
        Crc32c crc32c = new Crc32c();

        byte[] dados = "123456789".getBytes(StandardCharsets.UTF_8);
        crc32c.update(dados, 0, dados.length);

        long resultado = crc32c.getValue();

        System.out.printf("CRC32C: 0x%08X%n", resultado);
    }
}
```

Resultado esperado:

```text
CRC32C: 0xE3069283
```

## O que o `Main` valida

O metodo `main` chama o metodo `testarCrc32c`, que:

1. recebe um texto;
2. transforma esse texto em bytes usando UTF-8;
3. calcula o CRC32C com a classe `Crc32c`;
4. compara o valor calculado com o valor esperado;
5. mostra se o resultado e valido ou invalido.

Casos usados:

- texto vazio: `0x00000000`
- `"123456789"`: `0xE3069283`
- `"Ola mundo"`: `0xF741C7D0`

## Observacao

CRC32C e usado para verificar integridade de dados, ou seja, ajudar a perceber alteracoes acidentais em uma mensagem ou arquivo.

Ele nao deve ser usado como algoritmo de seguranca ou criptografia.
