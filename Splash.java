import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Splash extends JFrame {
    Splash() {
        setTitle("Hotel Booking Splash");
        setSize(858, 680);
        setLocation(300, 80);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Load and scale image
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("icon/hotel-booking.jpg")); // Adjust path if needed
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add custom panel
        BackgroundPanel bgPanel = new BackgroundPanel(image);
        setContentPane(bgPanel);
        new Login();
        setVisible(true);

        // Wait for 5 seconds then close
        try {
            Thread.sleep(5000);
            dispose(); // Close the splash screen
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}

// Custom JPanel to draw scaled, centered image
class BackgroundPanel extends JPanel {
    private BufferedImage image;

    public BackgroundPanel(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int imgWidth = image.getWidth();
            int imgHeight = image.getHeight();

            // Calculate aspect ratio
            double imgAspect = (double) imgWidth / imgHeight;
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            double panelAspect = (double) panelWidth / panelHeight;

            int drawWidth, drawHeight;
            if (imgAspect > panelAspect) {
                drawWidth = panelWidth;
                drawHeight = (int) (panelWidth / imgAspect);
            } else {
                drawHeight = panelHeight;
                drawWidth = (int) (panelHeight * imgAspect);
            }

            // Center the image
            int x = (panelWidth - drawWidth) / 2;
            int y = (panelHeight - drawHeight) / 2;

            g.drawImage(image, x, y, drawWidth, drawHeight, this);
        }
    }
}
