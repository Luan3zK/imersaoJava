package br.com.sousinha.codesapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ppLinguagem")
public class Linguagem {

    @Id
    private String id;
    private String title;
    private String image;
    private int rank;

    public Linguagem() {

    }
    
    public Linguagem(String title, String image, int rank) {
        this.title = title;
        this.image = image;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public int getRank() {
        return rank;
    }
    
}
