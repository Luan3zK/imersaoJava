import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // GET HTTP
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_8wzpskj5";
        // String url = "https://alura-filmes.herokuapp.com/conteudos";
        // extrator ext = new imdbExtrator();
        // String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        // extrator ext = new nasaExtrator();
        String url = "https://ap-sousa.herokuapp.com/linguagens";
        extrator ext = new linguagemExtrator();

        var http = new clienteHttp();
        String json = http.buscaDados(url);

        // Manipular os dados de title, image e rating.
        List<conteudo> conteudos = ext.extraiConteudos(json);

        var gerador = new StickersGen();
        for (int i = 0; i < 5; i++) {
            var content = conteudos.get(i);

            InputStream inputStream = new URL(content.getUrlImg()).openStream();
            String nomeArquivo = "aluraStickers/img-saida/" + content.getTitle() + ".png";
            
            gerador.gerar(inputStream, nomeArquivo);

            System.out.println("Título: " + content.getTitle());
        }
    }
}
