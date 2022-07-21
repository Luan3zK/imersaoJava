import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class nasaExtrator implements extrator {
    
    public List<conteudo> extraiConteudos(String json){
        // Extrair os dados.(PARSE)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listAtributos = parser.parse(json);

        List<conteudo> content = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listAtributos) {
            String title = atributos.get("title");
            String urlImg = atributos.get("url");
            var conteudo = new conteudo(title, urlImg);
            content.add(conteudo);
        }

        return content;
    }
}
