import javax.swing.*;

public class BannerPanel extends JPanel {
	private static final long serialVersionUID = 4751777519006353657L;
	
	public BannerPanel() {
		add(new JLabel("Asteroids"));
	}
	
	public BannerPanel(ImageIcon d) {
		add(new JLabel(d));
	}
}

