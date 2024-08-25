import java.awt.*;
import javax.swing.*;
class ImagePanel extends JPanel {

	  private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage(), 400, 400);
	  }

	  public ImagePanel(Image img, int w, int h) {
	    this.img = img;
	    Dimension size = new Dimension(w, h);
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }

	}
