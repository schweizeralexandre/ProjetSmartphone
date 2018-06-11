/*
 * Photos.java
 * Auteur: Alexandre Schweizer
 * Date de création: 6 juin 2018
 */

package Gallery_Photos;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


class Photo extends JButton {

	private boolean isIcon = true;
	String path = "Images/";
	String pictureName ;
	String[] cardList; 
	CardLayout display; 
	GalleryPanel galleryPanel;

	JLabel icon = new JLabel();
	JPanel optionsPanel = new JPanel();
int id;


	public Photo(String pictureName, String[] cardList, CardLayout display, GalleryPanel galleryPanel, int id) {
		this.pictureName=pictureName ;
		this.id=id;
		this.galleryPanel=galleryPanel;
		setBorderPainted(false);
		setOpaque(false);
		FullScreenImage displayPhotoPanel = new FullScreenImage(pictureName, galleryPanel,this) ;
		setPreferredSize(new Dimension(135, 135));
		setContentAreaFilled(false);
		displayPhotoPanel.setLayout(new BorderLayout());

		try {

			Image img = ImageIO.read(new File(pictureName));
			img = getImageIcon(img,135,135);
			setIcon(new ImageIcon(img));
		} catch (Exception e) {
			// TODO: handle exception
		}


		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub


				galleryPanel.add(displayPhotoPanel,cardList[1]);
				display.show(galleryPanel, cardList[1]);

				try {

					Image img = ImageIO.read(new File(pictureName));
					img = getImageIcon(img, 270, 500);
					icon.setIcon(new ImageIcon(img));
				} catch (Exception e) {
					// TODO: handle exception
				}

				displayPhotoPanel.add(optionsPanel,BorderLayout.NORTH) ;
				displayPhotoPanel.add(icon,BorderLayout.CENTER);





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



	private Image getImageIcon (Image img, int x, int y) {
		BufferedImage resizedImg = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB) ;
		Graphics2D g2 = resizedImg.createGraphics() ;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0,x, y, null);
		g2.dispose();
		return resizedImg;
	}

	class FullScreenImage extends JPanel {


		private JPanel deletePanel = new JPanel() ;

		private JButton returnButton ;
		private JButton deleteButton ;

		private JLabel nomPhoto  ;
		Photo photo ;


		public FullScreenImage(String pictureName,GalleryPanel gp,Photo photo) {
			this.photo=photo;
			returnButton = new OptionsButton("Images/back_button.png",gp) ;
			nomPhoto = new JLabel(pictureName.replaceAll("Images/", "")) ;
			deleteButton = new OptionsButton("Images/delete_button.png",gp) ;
			//
			//			//			setCursor(new Cursor(Cursor.HAND_CURSOR));
			//			//			setCursor(new Cursor(Cursor.HAND_CURSOR));
			//			//			setOpaque(false);
			//			//			setContentAreaFilled(false);
			//			//			setBorderPainted(false);
			//
			//			Image img;
			//
			//			//			try {
			//			//				img = ImageIO.read(new File("Images/back_button.png"));
			//			//				returnButton.setIcon(new ImageIcon(img));
			//			//			} catch (IOException e) {
			//			//				// TODO Auto-generated catch block
			//			//				e.printStackTrace();
			//			//			}
			//			//			
			//			//			try {
			//			//				img = ImageIO.read(new File("Images/delete_button.png"));
			//			//				deleteButton.setIcon(new ImageIcon(img));
			//			//			} catch (IOException e) {
			//			//				// TODO Auto-generated catch block
			//			//				e.printStackTrace();
			//			//			}
			//			//			
			//
			//
			//
			//
			deletePanel.setLayout (new GridLayout(1, 3)) ;

			deletePanel.setBackground(Color.white) ;

			optionsPanel.add(deletePanel) ;

			optionsPanel.add(returnButton) ;
			optionsPanel.add(nomPhoto) ;
			optionsPanel.add(deleteButton) ;

			returnButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					gp.changePanel("GalleryPanel") ;
				}
			}) ;


			deleteButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					int action = JOptionPane.showConfirmDialog(FullScreenImage.this, "Voulez-vous vraiment supprimer la photo ?", "Suppression", JOptionPane.OK_CANCEL_OPTION) ;

					if(action == JOptionPane.OK_OPTION) {
					gp.ImageGallery.remove(photo.id);//.get(i).remove ;
					
					try {
						gp.serialize(gp.ImageGallery);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					gp.displayImage();
					gp.changePanel("GalleryPanel") ;
					}
				}

			}) ;





		}



		public class OptionsButton extends JButton {

			private String path;
			GalleryPanel gp;
			public OptionsButton(String str,GalleryPanel gp) {
				path = str;
				this.gp=gp;
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


			//			//	public class Retour implements ActionListener {
			//			//
			//			//		@Override
			//			//		public void actionPerformed(ActionEvent e) {
			//			//			// TODO Auto-generated method stub
			//			//			gp.changePanel("GalleryPanel") ;
			//			//		}
			//			//
			//			//
			//			//	}
			//
			////			public class Delete implements ActionListener {
			////
			////				@Override
			////				public void actionPerformed(ActionEvent e) {
			////					// TODO Auto-generated method stub
			////					gp.changePanel("GalleryPanel") ;
			////				}
			////
			////
			////			}
			//
			//		}
			//}
		}
	}
}