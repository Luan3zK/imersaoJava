import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // GET HTTP Dos TOP 250 filmes.
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_8wzpskj5";
        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Extrair os dados.(PARSE)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        // Manipular os dados de title, image e rating.
        var gerador = new StickersGen();
        for (Map<String,String> filme : listaDeFilmes) {
            String urlImg = filme.get("image");
            String title = filme.get("title");
            InputStream inputStream = new URL(urlImg).openStream();

            String novoArquivo = title + ".png";
            gerador.gerar(inputStream, novoArquivo);

            System.out.println("Título: " + title);
        }
    }
}
