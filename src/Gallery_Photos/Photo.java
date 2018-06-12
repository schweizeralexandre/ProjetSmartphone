/*
 * Photos.java
 * Auteur: Alexandre Schweizer
 * Date de création: 6 juin 2018
 */

package Gallery_Photos ;

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

/**
 * Cette classe permet d'afficher l'image en grand ou sous le format d'une icône.
 * @author Alex
 *
 */

class Photo extends JButton {



	String path = "Images/" ;
	String pictureName ;
	String[] cardList ; 
	CardLayout display ; 
	GalleryPanel galleryPanel ;

	JLabel icon = new JLabel() ; 
	JPanel optionsPanel = new JPanel() ;
	int id ;

	/**
	 * 
	 * Constructeur de photo permettant de redimensionner dans la galerie à la taille souhaitée (135x135) 
	 * et également de l'afficher en grand via un ActionListener
	 * 
	 * @param pictureName
	 * @param cardList
	 * @param display 
	 * @param galleryPanel
	 * @param id
	 */

	public Photo(String pictureName, String[] cardList, CardLayout display, GalleryPanel galleryPanel, int id) {
		this.pictureName=pictureName ;
		this.id=id ;
		this.galleryPanel=galleryPanel ;
		setBorderPainted(false) ;
		setOpaque(false) ;
		FullScreenImage displayPhotoPanel = new FullScreenImage(pictureName, galleryPanel,this) ;
		setPreferredSize(new Dimension(135, 135)) ;
		setContentAreaFilled(false) ;
		displayPhotoPanel.setLayout(new BorderLayout()) ;


		try {

			Image img = ImageIO.read(new File(pictureName)) ;
			img = getImageIcon(img,135,135) ;
			setIcon(new ImageIcon(img)) ;
		} catch (Exception e) {
			// TODO: handle exception
		}


		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub


				galleryPanel.add(displayPhotoPanel,cardList[1]) ;
				display.show(galleryPanel, cardList[1]) ;

				try {

					Image img = ImageIO.read(new File(pictureName)) ;
					img = getImageIcon(img, 270, 500) ;
					icon.setIcon(new ImageIcon(img)) ;
				} catch (Exception e) {
					// TODO: handle exception
				}

				displayPhotoPanel.add(optionsPanel,BorderLayout.NORTH) ;
				displayPhotoPanel.add(icon,BorderLayout.CENTER) ;


			}
		});


	} 

	/**
	 * Méthode permettant de redimensionner les images en icône grâce à Graphics2D
	 * Vu sur: https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/IconDemoProject/src/components/IconDemoApp.java
	 * @param img - Image à redimensionner
	 * @param x - largeur désirée
	 * @param y - hauteur désirée
	 * @return - Image redimensionnée
	 */

	private Image getImageIcon (Image img, int x, int y) {


		BufferedImage resizedImg = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB) ;
		Graphics2D g2 = resizedImg.createGraphics() ;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR) ;
		g2.drawImage(img, 0, 0,x, y, null) ;
		g2.dispose() ;
		return resizedImg ;
	}

	/**
	 * 
	 * Classe qui créer le panel qui va accueillir l'image en grand
	 *
	 */
	class FullScreenImage extends JPanel {


		private JPanel deletePanel = new JPanel() ;
		private JButton returnButton ;
		private JButton deleteButton ;

		private JLabel nomPhoto  ;
		Photo photo ;

		/**
		 * Méthode permettant l'affichage des options au dessus de la grande image
		 * @param pictureName
		 * @param gp
		 * @param photo
		 */


		public FullScreenImage(String pictureName, GalleryPanel gp, Photo photo) {
			this.photo=photo ;
			returnButton = new OptionsButton("Images/back_button.png",gp) ;
			nomPhoto = new JLabel(pictureName.replaceAll("Images/", "")) ;
			deleteButton = new OptionsButton("Images/delete_button.png",gp) ;


			deletePanel.setLayout (new GridLayout(1, 3)) ;
			deletePanel.setBackground(Color.white) ;

			optionsPanel.add(deletePanel) ;
			optionsPanel.add(returnButton) ;
			optionsPanel.add(nomPhoto) ;
			optionsPanel.add(deleteButton) ;

			/**
			 * ActionListener permettant de retourner sur la grille d'image de la galerie
			 */

			returnButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					gp.changePanel("GalleryPanel") ;
				}
			}) ;

			/**
			 * ActionListener permettant de pouvoir supprimer une image et de serialiser à nouveau la liste d'images
			 */

			deleteButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					int action = JOptionPane.showConfirmDialog(FullScreenImage.this, "Voulez-vous vraiment supprimer la photo ?", "Suppression", JOptionPane.OK_CANCEL_OPTION) ;

					if(action == JOptionPane.OK_OPTION) {
						gp.ImageGallery.remove(photo.id) ;

						try {
							gp.serialize(gp.ImageGallery) ;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace() ;
						}
						gp.displayImage() ;
						gp.changePanel("GalleryPanel") ;
					}
				}

			}) ;





		}

		/**
		 * 
		 * Classe qui permet d'éviter de réécrire du code pour les boutons
		 *
		 */

		public class OptionsButton extends JButton {

			private String path ;
			GalleryPanel gp ;
			public OptionsButton(String str,GalleryPanel gp) {
				path = str ;
				this.gp=gp ;

				setCursor(new Cursor(Cursor.HAND_CURSOR)) ;
				setOpaque(false) ;
				setContentAreaFilled(false) ;
				setBorderPainted(false) ;




				try {
					Image button = ImageIO.read(new File(path));
					setIcon(new ImageIcon(button));
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
	}
}