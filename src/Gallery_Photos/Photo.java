/*
 * Photos.java
 * Auteur: Alexandre Schweizer
 * Date de création: 6 juin 2018
 */

package Gallery_Photos;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Photo extends JButton {

	private boolean isIcon = true;
	private String path = "Images/";
	String pictureName ;
	String[] cardList; 
	CardLayout display; 
	GalleryPanel galleryPanel;

	JLabel icon = new JLabel();
	JPanel optionsPanel = new JPanel();
	public Photo(String pictureName, String[] cardList, CardLayout display, GalleryPanel galleryPanel, int id) {
		this.pictureName=pictureName ;
		this.galleryPanel=galleryPanel;
		setBorderPainted(false);
		setOpaque(false);
		FullScreenImage displayPhotoPanel = new FullScreenImage(pictureName) ;
		setPreferredSize(new Dimension(75, 75));
		setContentAreaFilled(false);
		try {

			Image img = ImageIO.read(new File(pictureName));
			img = getImageIcon(img,75,75);
			setIcon(new ImageIcon(img));
		} catch (Exception e) {
			// TODO: handle exception
		}
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				displayPhotoPanel.add(icon);
				galleryPanel.add(displayPhotoPanel,cardList[1]);
				display.show(galleryPanel, cardList[1]);
				displayPhotoPanel.add(optionsPanel) ;
			}
		});


	} 
	//	public void paintComponent(Graphics g)
	//	{
	//			
	//		    try 
	//		    {
	//		      Image img = ImageIO.read(new File(pictureName));
	//		      //g.drawImage(img, 0, 0, this);
	//		      //Pour une image de fond
	//		     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	//		    } catch (IOException e) {
	//		     System.out.println("ERROR : cannot load the background picture of the center pan ");
	//		    }                
	//		  }



	private Image getImageIcon (Image img,int x,int y) {
		BufferedImage resizedImg = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0,x, y, null);
		g2.dispose();
		return resizedImg;
	}

	class FullScreenImage extends JPanel {

		public FullScreenImage(String pictureName) {
			
			
			Image img ;
			try {
				img = ImageIO.read(new File(pictureName));
				img = getImageIcon(img, 270, 380);
				icon.setIcon(new ImageIcon(img));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

	}
	//	private Image getFullImage () {
	//		return null;
	//	}
	//
	//	public void setAsImage() {
	//		isIcon = false;
	//	}


}