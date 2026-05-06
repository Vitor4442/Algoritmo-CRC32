import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        testarCrc32c("", 0x00000000L);
        testarCrc32c("123456789", 0xE3069283L);
        testarCrc32c("Ola mundo", 0xF741C7D0L);
    }

    private static void testarCrc32c(String texto, long valorEsperado) {
        Crc32c crc32c = new Crc32c();
        byte[] dados = texto.getBytes(StandardCharsets.UTF_8);

        crc32c.update(dados, 0, dados.length);

        long valorCalculado = crc32c.getValue();

        System.out.println("Texto: \"" + texto + "\"");
        System.out.println("CRC32C calculado: " + formatarHexadecimal(valorCalculado));
        System.out.println("CRC32C esperado:  " + formatarHexadecimal(valorEsperado));

        if (valorCalculado == valorEsperado) {
            System.out.println("Resultado: valido");
        } else {
            System.out.println("Resultado: invalido");
        }

        System.out.println();
    }

    private static String formatarHexadecimal(long valor) {
        return String.format("0x%08X", valor);
    }
}
