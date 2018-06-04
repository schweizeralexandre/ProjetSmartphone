package Gallery_Photos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class GalleryPanel extends JPanel {

	private JPanel menuPanel = new JPanel() ;
	private JPanel galeryPanel = new JPanel() ;
	private JPanel photoPanel = new JPanel() ;

	private JButton returnButton = new GaleryButton("Images/back_button.png") ;
	private JLabel titleLabel = new JLabel("Ma Galerie") ;
	private JButton addButton = new GaleryButton("Images/add_button.png") ;


	public GalleryPanel() {
		galeryPanel.setLayout(new BorderLayout());
		//menuPanel.setPreferredSize(new Dimension(270, 50)) ;
		menuPanel.setBackground(Color.white) ;

		//galeryPanel.setPreferredSize(new Dimension(270, 490)) ;
		galeryPanel.setBackground(Color.lightGray) ;

		//photoPanel.setSize(270, 540) ;
		//photoPanel.setLayout(new FlowLayout()) ;

		//		photoPanel.add(menuPanel, BorderLayout.NORTH) ;
		//		photoPanel.add(galeryPanel, BorderLayout.SOUTH) ;

		galeryPanel.add(photoPanel, BorderLayout.CENTER) ;
		galeryPanel.add(menuPanel,BorderLayout.NORTH);

		menuPanel.setLayout(new GridLayout(1, 3)) ;

		//titleLabel.setPreferredSize(new Dimension(90, 50)) ;
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER) ;
		titleLabel.setFont(new Font("Helvetica Neue",  Font.BOLD, 12)) ;
		titleLabel.setForeground(new Color(51, 153, 255)) ;
		menuPanel.add(returnButton) ;
		menuPanel.add(titleLabel) ;
		menuPanel.add(addButton) ;


		setLayout(new BorderLayout()) ;
		add(galeryPanel,BorderLayout.CENTER) ;

		photoPanel.setLayout(new GridLayout(4,4)) ;


		Photo gl = new Photo ("photo1.jpg") ;
		photoPanel.add(gl) ;
		for (int i = 0; i < 8 ; i++) {
			photoPanel.add(new JLabel("test"));
		}




	}

	class GaleryButton extends JButton {

		private String path;

		public GaleryButton(String str) {
			path = str;

			//setPreferredSize(new Dimension(100, 50));
			setCursor(new Cursor(Cursor.HAND_CURSOR));
			setCursor(new Cursor(Cursor.HAND_CURSOR));
			setOpaque(false);
			setContentAreaFilled(false);
			setBorderPainted(false);



			try {
				Image button = ImageIO.read(new File(path));
				setIcon(new ImageIcon(button));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	class Photo extends JButton {

		private boolean isIcon = true;
		private String path = "Images/";

		public Photo(String pictureName) {
			if(isIcon) {

				try {
					Image img = ImageIO.read(new File(path+pictureName));
					img = getImageIcon(img);
					setIcon(new ImageIcon(img));
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {

			}
		}

		private Image getImageIcon (Image img) {
			BufferedImage resizedImg = new BufferedImage(75, 75, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = resizedImg.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.drawImage(img, 0, 0, 75, 75, null);
			g2.dispose();
			return resizedImg;
		}

		private Image getFullImage () {
			return null;
		}

		public void setAsImage() {
			isIcon = false;
		}
	}
}






