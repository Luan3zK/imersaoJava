import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;

public class StickersGen {
    public void gerar(InputStream inputStream, String nomeArquivo) throws Exception {
        // ler img
        // InputStream inputStream = new FileInputStream(new File("D:/Sousinha Backup/Code/Alura/imersaoJava/aluraStickers/img/filme.jpg"));
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@.jpg").openStream();
        BufferedImage imgOriginal = ImageIO.read(inputStream);

        // criar nova imagem em memo com alpha e redimensiona-la
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImg = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memo)
        Graphics2D graphics = (Graphics2D) novaImg.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        // escrever frase na img e estilizar
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 80);
        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);
        graphics.drawString("NAISSE", 40, novaAltura - 60);

        // criar uma nova imagem
        ImageIO.write(novaImg, "png", new File(nomeArquivo.replaceAll("(:)", " -")));
    }
}
